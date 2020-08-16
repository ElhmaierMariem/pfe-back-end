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


import com.gestion.springjwt.models.TABColClass;
import com.gestion.springjwt.models.TypeD;


import com.gestion.springjwt.payload.models.TABColClassModel;
import com.gestion.springjwt.payload.response.MessageResponse;

import com.gestion.springjwt.repository.TABColRepo;
import com.gestion.springjwt.repository.TypeDRepo;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/tab-col")
public class TABColController {
    


  private final TABColRepo repository;
//  private final TypeDRepo repo;
  
  TABColController(TABColRepo repository, TypeDRepo repo) {
    this.repository = repository;
//    this.repo = repo;
  }

  @GetMapping("/all")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> all() {
    List<TABColClass> tabcols = repository.findAll();
    return ResponseEntity.ok(tabcols);
  }

//  @PostMapping("/save")
//  @PreAuthorize("hasRole('ADMIN')")
//  public ResponseEntity<?> create(@Valid @RequestBody TABColClassModel tabCol) {
//    TABColClass newTABCOL = new TABColClass();
//    newTABCOL.setTabColLibelle(tabCol.getTabColLibelle());
//    newTABCOL.setTabColLargeur(tabCol.getTabColLargeur());
//    
//    TypeD typeD = (TypeD) repo.findById(tabCol.getTypeDId())
//    		.orElseThrow(() -> new IllegalArgumentException("not found"));
//    newTABCOL.setTypeD(typeD);
//    repository.save(newTABCOL);
//    return ResponseEntity.ok(new MessageResponse("Tableau colonnes registered successfully!"));
//  }
//
//  // Single item
//
//  @GetMapping("/one")
//  @PreAuthorize("hasRole('ADMIN')")
//  public ResponseEntity<?> one(@Valid @RequestBody Long id) {
//
//    TABColClass tabCol = (TABColClass) repository.findById(id)                                      
//                                        .orElseThrow(() -> new IllegalArgumentException("not found"));
//    return ResponseEntity.ok(tabCol);
//												 
//  }
//
//  @PutMapping("/update")
//  @PreAuthorize("hasRole('ADMIN')")
//  public ResponseEntity<?> update(@RequestBody TABColClassModel newTABCOL) {
//
//    TABColClass typeD = (TABColClass) repository.findById( newTABCOL.getTypeDId())
//        .orElseThrow(() -> new IllegalArgumentException("not found"));
//         
//        repository.save(typeD);
//
//        return ResponseEntity.ok(new MessageResponse("Tableau colonnes updated successfully!"));
//
//  }
//
//  @DeleteMapping("/delete/{id}")
//  @PreAuthorize("hasRole('ADMIN')")
//  public ResponseEntity<?> delete(@Valid @PathVariable Long id) {
//    repository.deleteById(id);
//    return ResponseEntity.ok(new MessageResponse("Tableau colonnes deleted successfully!"));
//  }
}
