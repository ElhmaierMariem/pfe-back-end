package com.gestion.springjwt.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.springjwt.models.TypeD;

import com.gestion.springjwt.payload.models.DModel;

import com.gestion.springjwt.payload.response.MessageResponse;
import com.gestion.springjwt.repository.TypeDRepo;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/type-d")
public class TypeDController {
    


  private final TypeDRepo repository;

  TypeDController(TypeDRepo repository) {
    this.repository = repository;
  }

  @GetMapping("/all")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> all() {
    List<TypeD> typeDs = repository.findAll();
    return ResponseEntity.ok(typeDs);
  }

  @PostMapping("/save")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> create(@Valid @RequestBody DModel d) {
    TypeD typeD = new TypeD();
    typeD.setTypeDLibelle(d.getdLibelle());
    repository.save(typeD);
    return ResponseEntity.ok(new MessageResponse("Type de données registered successfully!"));
  }

  // Single item

  @GetMapping("/one")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> one(@Valid @RequestBody Long id) {

    TypeD typeD = (TypeD) repository.findById(id)                                      
                                        .orElseThrow(() -> new IllegalArgumentException("not found"));
    return ResponseEntity.ok(typeD);
												 
  }

  @PutMapping("/update")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> update(@RequestBody TypeD newTypeD) {

    TypeD typeD = (TypeD) repository.findById(newTypeD.getTypeDId())
        .orElseThrow(() -> new IllegalArgumentException("not found"));
         
        repository.save(typeD);

        return ResponseEntity.ok(new MessageResponse("Type de données updated successfully!"));

  }

  @DeleteMapping("/delete")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> delete(@RequestBody Long id) {
    repository.deleteById(id);
    return ResponseEntity.ok(new MessageResponse("Type de données deleted successfully!"));
  }
}

