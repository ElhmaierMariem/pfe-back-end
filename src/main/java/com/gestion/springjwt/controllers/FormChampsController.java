package com.gestion.springjwt.controllers;

import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.springjwt.models.FormChampsClass;

import com.gestion.springjwt.repository.FormChampsRepo;
import com.gestion.springjwt.repository.LVRepo;

import com.gestion.springjwt.repository.TypeChampsRepo;
import com.gestion.springjwt.repository.TypeDRepo;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/form-champs")
public class FormChampsController {
    


  private final FormChampsRepo repository;
//  private final TypeDRepo repo;
//  private final TypeChampsRepo typeChampsRepo;
//  private final LVRepo lvRepo ;
//  
//  
  FormChampsController(FormChampsRepo repository, TypeDRepo repo, LVRepo lvRepo,TypeChampsRepo typeChampsRepo ) {
    this.repository = repository;
//    this.repo = repo;
//    this.lvRepo= lvRepo;
//    this.typeChampsRepo = typeChampsRepo;
  }
//
  @GetMapping("/all")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> all() {
	  List<FormChampsClass> rds = repository.findAll();
   
    return ResponseEntity.ok(rds);
  }
//
//  @PostMapping("/save")
//  @PreAuthorize("hasRole('ADMIN')")
//  public ResponseEntity<?> create(@Valid @RequestBody FormClassModel ) {
////    FormChampsClass newFC = new FormChampsClass();
////    newFC.setFormChampsLibelle(rd.getFormChampsLibelle());
////    newFC.setFormChampsNom(rd.getFormChampsNom());
////    newFC.setFormChampsLargeur(rd.getFormChampsLargeur());
////    newFC.setFormChampsColspan(rd.getFormChampsColspan());
////    
////    TypeChamps typeC = (TypeChamps) typeChampsRepo.findById(rd.getTypeChamps().getChampsId())
////    		.orElseThrow(() -> new IllegalArgumentException("not found"));
////    newFC.setTypeChamps(typeC);
////    
////    TypeD typeD = (TypeD) repo.findById()
////    		.orElseThrow(() -> new IllegalArgumentException("not found"));
////    newFC.setTypeD(typeD);
////    
////    LVClass lv = (LVClass) lvRepo.findById(rd.getLv().getlVId())
////    		.orElseThrow(() -> new IllegalArgumentException("not found"));
////    newFC.setLvClass(lv);
////    
////    repository.save(newFC);
//    return ResponseEntity.ok(new MessageResponse("Formulaire champs registered successfully!"));
//  }
//
//  // Single item
//
//  @GetMapping("/one")
//  @PreAuthorize("hasRole('ADMIN')")
//  public ResponseEntity<?> one(@Valid @RequestBody Long id) {
//
//    FormChampsClass rd = (FormChampsClass) repository.findById(id)                                      
//                                        .orElseThrow(() -> new IllegalArgumentException("not found"));
//    return ResponseEntity.ok(rd);
//												 
//  }
//
//  @PutMapping("/update/{id}")
//  @PreAuthorize("hasRole('ADMIN')")
//  public ResponseEntity<?> update(@RequestBody FormChampsClassModel newFC, @PathVariable Long id) {
//
////    FormChampsClass fc = (FormChampsClass) repository.findById(id)
////        .orElseThrow(() -> new IllegalArgumentException("not found"));
////    TypeD typD = (TypeD) repo.findById(newFC.getTyped().getdId())
////    .orElseThrow(() -> new IllegalArgumentException("not found"));
////    
////    TypeChamps typC = (TypeChamps) typeChampsRepo.findById(newFC.getTypeChamps().getChampsId())
////    	    .orElseThrow(() -> new IllegalArgumentException("not found"));
////    
////    LVClass listV = (LVClass) lvRepo.findById(newFC.getLv().getlVId())
////    	    .orElseThrow(() -> new IllegalArgumentException("not found"));
////
////    fc.setFormChampsNom(newFC.getFormChampsNom());
////    fc.setFormChampsLibelle(newFC.getFormChampsLibelle());
////    fc.setFormChampsColspan(newFC.getFormChampsColspan());
////    fc.setFormChampsLargeur(newFC.getFormChampsLargeur());
////    fc.setTypeD(typD);
////    fc.setTypeChamps(typC);
////    fc.setLvClass(listV);
////        repository.save(fc);
//
//        return ResponseEntity.ok(new MessageResponse("Formulaire Champs updated successfully!"));
//
//  }
//
//  @DeleteMapping("/delete/{id}")
//  @PreAuthorize("hasRole('ADMIN')")
//  public ResponseEntity<?> delete(@Valid @PathVariable Long id) {
//    repository.deleteById(id);
//    return ResponseEntity.ok(new MessageResponse("Formulaire Champs deleted successfully!"));
//  }
}