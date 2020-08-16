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

import com.gestion.springjwt.models.TypeChamps;

import com.gestion.springjwt.payload.models.ChampsModel;

import com.gestion.springjwt.payload.response.MessageResponse;
import com.gestion.springjwt.repository.TypeChampsRepo;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/type-champs")
public class TypeChampsController {
    


  private final TypeChampsRepo repository;

  TypeChampsController(TypeChampsRepo repository) {
    this.repository = repository;
  }

  @GetMapping("/all")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> all() {
    List<TypeChamps> typeChamps = repository.findAll();
    return ResponseEntity.ok(typeChamps);
  }

  @PostMapping("/save")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> create(@Valid @RequestBody ChampsModel rd) {
    TypeChamps typeChamps = new TypeChamps();
    typeChamps.setTypeChampsLibelle(rd.getChampsLibelle());
    repository.save(typeChamps);
    return ResponseEntity.ok(new MessageResponse("Type champs registered successfully!"));
  }

  // Single item

  @GetMapping("/one")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> one(@Valid @RequestBody Long id) {

    TypeChamps typeChamps = (TypeChamps) repository.findById(id)                                      
                                        .orElseThrow(() -> new IllegalArgumentException("not found"));
    return ResponseEntity.ok(typeChamps);
												 
  }

  @PutMapping("/update")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> update(@RequestBody TypeChamps newTypeChamps) {

    TypeChamps typeChamps = (TypeChamps) repository.findById(newTypeChamps.getTypeChampsId())
        .orElseThrow(() -> new IllegalArgumentException("not found"));
         
        repository.save(typeChamps);

        return ResponseEntity.ok(new MessageResponse("Type champs updated successfully!"));

  }

  @DeleteMapping("/delete")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> delete(@RequestBody Long id) {
    repository.deleteById(id);
    return ResponseEntity.ok(new MessageResponse("Type champs deleted successfully!"));
  }
}
