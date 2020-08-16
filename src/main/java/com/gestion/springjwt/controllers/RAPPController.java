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

import com.gestion.springjwt.models.CATClass;
import com.gestion.springjwt.models.FormChampsClass;
import com.gestion.springjwt.models.FormClass;
import com.gestion.springjwt.models.RAPPClass;
import com.gestion.springjwt.models.RDClass;
import com.gestion.springjwt.models.TABClass;
import com.gestion.springjwt.payload.models.RAPPClassModel;
import com.gestion.springjwt.payload.response.MessageResponse;
import com.gestion.springjwt.repository.CATRepo;
import com.gestion.springjwt.repository.FormChampsRepo;
import com.gestion.springjwt.repository.FormRepo;
import com.gestion.springjwt.repository.RAPPRepo;
import com.gestion.springjwt.repository.RDRepo;
import com.gestion.springjwt.repository.TABRepo;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/rapp")
public class RAPPController {
    


  private final RAPPRepo repository;
  private final RDRepo repo;
  private final CATRepo catRepo ;
  private final FormRepo formRepo;
  private final FormChampsRepo formChampsRepo;
  private final TABRepo tabRepo;
  
  RAPPController(RAPPRepo repository, RDRepo repo , CATRepo catRepo, FormRepo formRepo,  FormChampsRepo formChampsRepo,  TABRepo tabRepo) {
    this.formChampsRepo = formChampsRepo;
	this.tabRepo = tabRepo;
	this.repository = repository;
    this.repo = repo;
    this.catRepo = catRepo;
    this.formRepo = formRepo;
  }

  @GetMapping("/all")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> all() {
		
		  List<RAPPClass> rapps = repository.findAll();
		  return ResponseEntity.ok(rapps);
		 
		  
	  
		  
		 
	 
  }

  @PostMapping("/save")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> create(@Valid @RequestBody RAPPClassModel rapp) {
	  RAPPClass newR = new RAPPClass();
	  System.out.println(rapp.toString());
	  newR.setRappLibelle(rapp.getRappLibelle());
	  newR.setRequeteSqlDetail(rapp.getRequeteSqlDetail());
	  newR.setRequeteSqlEntete(rapp.getRequeteSqlEntete());
	  newR.setTemplate(rapp.getTemplate());
	  newR.setAvecTemplate(rapp.isAvecTemplate());
    
    RDClass RD = (RDClass) repo.findById(rapp.getRd().getRdId())
    		.orElseThrow(() -> new IllegalArgumentException("not found"));
    newR.setRdClass(RD);
   
    
    CATClass CAT = (CATClass) catRepo.findById(rapp.getCat().getCatId())
    		.orElseThrow(() -> new IllegalArgumentException("not found"));
    newR.setCatClass(CAT);
   
    
    FormClass FORM = (FormClass) formRepo.findById(rapp.getForm().getFormId())
    		.orElseThrow(() -> new IllegalArgumentException("not found"));
    newR.setFormClass(FORM);
   
    
    FormChampsClass FCHAMPS = (FormChampsClass) formChampsRepo.findById(rapp.getFormChamps().getFormChampsNom())
    		.orElseThrow(() -> new IllegalArgumentException("not found"));
    newR.setFormChampsClass(FCHAMPS);
    
    TABClass TAB = (TABClass) tabRepo.findById(rapp.getTab().getTabId())
    		.orElseThrow(() -> new IllegalArgumentException("not found"));
    newR.setTabClass(TAB);
    
    repository.save(newR);
    return ResponseEntity.ok(new MessageResponse("Rapport registered successfully!"));
  }

  // Single item

  @GetMapping("/one")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> one(@Valid @RequestBody Long id) {

    RAPPClass rapp = (RAPPClass) repository.findById(id)                                      
                                        .orElseThrow(() -> new IllegalArgumentException("not found"));
    return ResponseEntity.ok(rapp);
												 
  }

  @PutMapping("/update/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> update(@RequestBody RAPPClassModel newR , @PathVariable Long id) {
	  
    RAPPClass Rapp = (RAPPClass) repository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("not found"));
    System.out.println(newR);
    System.out.println(new RAPPClassModel());
    
    RDClass rd = repo.findById(newR.getRdId())
   		 .orElseThrow(() -> new IllegalArgumentException("not found"));
    
    CATClass cat = catRepo.findById(newR.getCatId())
      		 .orElseThrow(() -> new IllegalArgumentException("not found"));
    
    FormClass form = formRepo.findById(newR.getFormId())
      		 .orElseThrow(() -> new IllegalArgumentException("not found"));
    
    FormChampsClass fChamps = formChampsRepo.findById(newR.getFormChampsId())
      		 .orElseThrow(() -> new IllegalArgumentException("not found"));
    
    TABClass tab = tabRepo.findById(newR.getTabId())
      		 .orElseThrow(() -> new IllegalArgumentException("not found"));
         
    Rapp.setRappLibelle(newR.getRappLibelle());
    Rapp.setRequeteSqlDetail(newR.getRequeteSqlDetail());
    Rapp.setRequeteSqlEntete(newR.getRequeteSqlEntete());
    Rapp.setTemplate(newR.getTemplate());
    Rapp.setAvecTemplate(newR.isAvecTemplate());
    Rapp.setRdClass(rd);
    Rapp.setCatClass(cat);
    Rapp.setFormChampsClass(fChamps);
    Rapp.setFormClass(form);
    Rapp.setTabClass(tab);
    
  
    
    
        repository.save(Rapp);

        return ResponseEntity.ok(new MessageResponse("Rapport updated successfully!"));

  }

  @DeleteMapping("/delete/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> delete(@Valid @PathVariable Long id) {
    repository.deleteById(id);
    return ResponseEntity.ok(new MessageResponse("Rapport deleted successfully!"));
  }


}

