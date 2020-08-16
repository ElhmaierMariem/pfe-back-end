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

import com.gestion.springjwt.models.LVClass;
import com.gestion.springjwt.models.RDClass;

import com.gestion.springjwt.payload.models.LVClassModel;


import com.gestion.springjwt.payload.response.MessageResponse;
import com.gestion.springjwt.repository.LVRepo;
import com.gestion.springjwt.repository.RDRepo;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/lv")
public class LVController {
    


  private final LVRepo repository;
  private final RDRepo repo;
  
  LVController(LVRepo repository, RDRepo repo) {
    this.repository = repository;
    this.repo = repo;
  }

  @GetMapping("/all")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> all() {
		
		  List<LVClass> lvs = repository.findAll();
		  return ResponseEntity.ok(lvs);
	  
//	  return ResponseEntity.ok(new LVClassModel());
		 
		  
	  
		  
		 
	 
  }

  @PostMapping("/save")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> create(@Valid @RequestBody LVClassModel lv) {
	  LVClass newLV = new LVClass();
	  System.out.println(lv.toString());
    newLV.setLVLibelle(lv.getlVLibelle());
    newLV.setLVRequeteSql(lv.getlVRequeteSql());
    newLV.setLVColonneValeur(lv.getLVColonneValeur());
    newLV.setLVColonneId(lv.getLVColonneId());
    
    RDClass RD = (RDClass) repo.findById(lv.getRdId())
    		.orElseThrow(() -> new IllegalArgumentException("not found"));
    newLV.setRD(RD);
    repository.save(newLV);
    return ResponseEntity.ok(new MessageResponse("Liste de Valeurs registered successfully!"));
  }

  // Single item

  @GetMapping("/one")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> one(@Valid @RequestBody Long id) {

    LVClass lv = (LVClass) repository.findById(id)                                      
                                        .orElseThrow(() -> new IllegalArgumentException("not found"));
    return ResponseEntity.ok(lv);
												 
  }

  @PutMapping("/update/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> update(@RequestBody LVClassModel newLV , @PathVariable Long id) {
	  
    LVClass RD = (LVClass) repository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("not found"));
    System.out.println(newLV);
    System.out.println(new LVClassModel());
    RDClass rd = repo.findById(newLV.getRdId())
   		 .orElseThrow(() -> new IllegalArgumentException("not found"));
         
    RD.setLVLibelle(newLV.getlVLibelle());
    RD.setLVRequeteSql(newLV.getlVRequeteSql());
    RD.setLVColonneValeur(newLV.getLVColonneValeur());
    RD.setLVColonneId(newLV.getLVColonneId());
    RD.setRD(rd);
  
    
    
        repository.save(RD);

        return ResponseEntity.ok(new MessageResponse("Liste de Valeurs updated successfully!"));

  }

  @DeleteMapping("/delete/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> delete(@Valid @PathVariable Long id) {
    repository.deleteById(id);
    return ResponseEntity.ok(new MessageResponse("Liste de Valeurs deleted successfully!"));
  }


}
