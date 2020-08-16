package com.gestion.springjwt.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.gestion.springjwt.models.TABClass;
import com.gestion.springjwt.models.TABColClass;

import com.gestion.springjwt.models.TypeD;

import com.gestion.springjwt.payload.models.TABClassModel;
import com.gestion.springjwt.payload.models.TABColClassModel;
import com.gestion.springjwt.payload.response.MessageResponse;

import com.gestion.springjwt.repository.TABColRepo;
import com.gestion.springjwt.repository.TABRepo;
import com.gestion.springjwt.repository.TypeDRepo;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/tab")
public class TABController {
    


  private final TABRepo repository;
  private final TABColRepo repo;
  private final TypeDRepo typeDRepo;
  
  TABController(TABRepo repository, TABColRepo repo , TypeDRepo typeDRepo) {
    this.repository = repository;
    this.typeDRepo = typeDRepo;
    this.repo = repo;
  }

  @GetMapping("/all")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> all() {
	  
    List<TABClass> tab = repository.findAll();
    return ResponseEntity.ok(tab);
  }

  @PostMapping("/save")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> create(@Valid @RequestBody TABClassModel tab) {
	  System.out.println(tab);
	  
	  
    TABClass newTab = new TABClass();
    newTab.setTabLibelle(tab.getTabLibelle());
   
    repository.save(newTab);
    
    
    for (TABColClassModel t : tab.getTabCol()) {
		TABColClass tabColClass =  new TABColClass();
		
		
		tabColClass.setTabColLibelle(t.getTabColLibelle());
		tabColClass.setTabColLargeur(t.getTabColLargeur());
		
		
		
		TypeD typeD = typeDRepo.findById(t.getTypeDId())
				.orElseThrow(() -> new IllegalArgumentException("not found"));
		tabColClass.setTypeD(typeD);
		
;
		
tabColClass.setTabClass(newTab);
		
repo.save(tabColClass);
		
		
	}
    return ResponseEntity.ok(new MessageResponse("Tableaux registered successfully!"));
  }

  // Single item

  @GetMapping("/one")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> one(@Valid @RequestBody Long id) {

    TABClass tab = (TABClass) repository.findById(id)                                      
                                        .orElseThrow(() -> new IllegalArgumentException("not found"));
    return ResponseEntity.ok(tab);
												 
  }

  @PutMapping("/update/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> update(@RequestBody TABClassModel newTab , @PathVariable Long id) {

	  TABClass TC = (TABClass) repository.findById(id)
			  				.orElseThrow(() -> new IllegalArgumentException("not found"));
	  	TC.setTabLibelle(newTab.getTabLibelle());
	  	
	    repository.save(TC);
	    
	    
	    for (TABColClassModel t : newTab.getTabCol()) {
	    	TABColClass tCol = (TABColClass) repo.findById(id)
	  				.orElseThrow(() -> new IllegalArgumentException("not found"));
	    	
	    	tCol.setTabColLibelle(t.getTabColLibelle());
	    	tCol.setTabColLargeur(t.getTabColLargeur());
			
			
			
			TypeD typeD = typeDRepo.findById(t.getTypeDId())
					.orElseThrow(() -> new IllegalArgumentException("not found"));
			tCol.setTypeD(typeD);
			
			
			
			tCol.setTabClass(TC);
			
			repo.save(tCol);
			
			
		}

    return ResponseEntity.ok(new MessageResponse("Tableau updated successfully!"));

  }

  @DeleteMapping("/delete/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> delete(@Valid @PathVariable Long id) {
    repository.deleteById(id);
    return ResponseEntity.ok(new MessageResponse("Tableau deleted successfully!"));
  }


}
