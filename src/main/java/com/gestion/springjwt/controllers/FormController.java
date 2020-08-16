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

import com.gestion.springjwt.models.FormChampsClass;
import com.gestion.springjwt.models.FormClass;
import com.gestion.springjwt.models.LVClass;
import com.gestion.springjwt.models.TypeChamps;
import com.gestion.springjwt.models.TypeD;
import com.gestion.springjwt.payload.models.FormChampsClassModel;
import com.gestion.springjwt.payload.models.FormClassModel;

import com.gestion.springjwt.payload.response.MessageResponse;
import com.gestion.springjwt.repository.FormChampsRepo;
import com.gestion.springjwt.repository.FormRepo;
import com.gestion.springjwt.repository.LVRepo;
import com.gestion.springjwt.repository.TypeChampsRepo;
import com.gestion.springjwt.repository.TypeDRepo;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/form")
public class FormController {
    


  private final FormRepo repository;
  private final LVRepo lvRepo;
  private final TypeDRepo typedRepo;
  private final TypeChampsRepo typeChampsRepo;
  private final FormChampsRepo formChampsRepo;

 
  
  FormController(FormRepo repository,  LVRepo lvRepo, TypeDRepo typedRepo, TypeChampsRepo typeChampsRepo, FormChampsRepo formChampsRepo) {
    this.repository = repository;
    this.lvRepo = lvRepo;
    this.typedRepo = typedRepo;
    this.typeChampsRepo = typeChampsRepo;
    this.formChampsRepo = formChampsRepo;
    
  }

  @GetMapping("/all")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> all() {
	  
    List<FormClass> forms = repository.findAll();
    return ResponseEntity.ok(forms);
	  
  }

  @PostMapping("/save")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> create(@Valid @RequestBody FormClassModel form) {
	  System.out.println(form);
	  
	  
    FormClass newForm = new FormClass();
    newForm.setFormLibelle(form.getFormLibelle());
    newForm.setFormNombreColonnes(form.getFormNombreColonnes()); 
    repository.save(newForm);
    
    
    for (FormChampsClassModel f : form.getTabFormChamps()) {
		FormChampsClass formChampsClass =  new FormChampsClass();
		
		formChampsClass.setFormChampsNom(f.getFormChampsNom());
		formChampsClass.setFormChampsLibelle(f.getFormChampsLibelle());
		formChampsClass.setFormChampsLargeur(f.getFormChampsLargeur());
		formChampsClass.setFormChampsColspan(f.getFormChampsColspan());
		
		
		TypeD typeD = typedRepo.findById(f.getTypeDId())
				.orElseThrow(() -> new IllegalArgumentException("not found"));
		formChampsClass.setTypeD(typeD);
		
		TypeChamps typeC = typeChampsRepo.findById(f.getTypeChampsId())
				.orElseThrow(() -> new IllegalArgumentException("not found"));
		formChampsClass.setTypeChamps(typeC);
		
		LVClass listeVal = lvRepo.findById(f.getLVId())
				.orElseThrow(() -> new IllegalArgumentException("not found"));
		
		formChampsClass.setLvClass(listeVal);
		
		formChampsClass.setFormClass(newForm);
		
		formChampsRepo.save(formChampsClass);
		
		
	}
    return ResponseEntity.ok(new MessageResponse("Formulaire registered successfully!"));
  }

  // Single item

  @GetMapping("/one")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> one(@Valid @RequestBody Long id) {

    FormClass form = (FormClass) repository.findById(id)                                      
                                        .orElseThrow(() -> new IllegalArgumentException("not found"));
    return ResponseEntity.ok(form);
												 
  }

  @PutMapping("/update/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> update(@RequestBody FormClassModel newForm , @PathVariable Long id) {

	  FormClass fC = (FormClass) repository.findById(id)
			  				.orElseThrow(() -> new IllegalArgumentException("not found"));
	  	fC.setFormLibelle(newForm.getFormLibelle());
	  	fC.setFormNombreColonnes(newForm.getFormNombreColonnes()); 
	    repository.save(fC);
	    
	    
	    for (FormChampsClassModel f : newForm.getTabFormChamps()) {
	    	FormChampsClass fchamp = (FormChampsClass) formChampsRepo.findById(id)
	  				.orElseThrow(() -> new IllegalArgumentException("not found"));
	    	fchamp.setFormChampsNom(f.getFormChampsNom());
			fchamp.setFormChampsLibelle(f.getFormChampsLibelle());
			fchamp.setFormChampsLargeur(f.getFormChampsLargeur());
			fchamp.setFormChampsColspan(f.getFormChampsColspan());
			
			
			TypeD typeD = typedRepo.findById(f.getTypeDId())
					.orElseThrow(() -> new IllegalArgumentException("not found"));
			fchamp.setTypeD(typeD);
			
			TypeChamps typeC = typeChampsRepo.findById(f.getTypeChampsId())
					.orElseThrow(() -> new IllegalArgumentException("not found"));
			fchamp.setTypeChamps(typeC);
			
			LVClass listeVal = lvRepo.findById(f.getLVId())
					.orElseThrow(() -> new IllegalArgumentException("not found"));
			
			fchamp.setLvClass(listeVal);
			
			fchamp.setFormClass(fC);
			
			formChampsRepo.save(fchamp);
			
			
		}

    return ResponseEntity.ok(new MessageResponse("Formulaire updated successfully!"));

  }

  @DeleteMapping("/delete/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> delete(@Valid @PathVariable Long id) {
    repository.deleteById(id);
    return ResponseEntity.ok(new MessageResponse("Formulaire deleted successfully!"));
  }


}
