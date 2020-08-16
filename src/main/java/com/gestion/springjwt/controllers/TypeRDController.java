package com.gestion.springjwt.controllers;

import java.util.List;
import javax.validation.Valid;

import com.gestion.springjwt.models.TypeRD;
import com.gestion.springjwt.payload.models.RDModel;
import com.gestion.springjwt.payload.response.MessageResponse;
import com.gestion.springjwt.repository.TypeRDRepo;

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

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/type-rd")
public class TypeRDController {
    


  private final TypeRDRepo repository;

  TypeRDController(TypeRDRepo repository) {
    this.repository = repository;
  }

  @GetMapping("/")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> all() {
    List<TypeRD> typeRds = repository.findAll();
    return ResponseEntity.ok(typeRds);
  }

  @PostMapping("/save")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> create(@Valid @RequestBody RDModel rd) {
    TypeRD typeRD = new TypeRD();
    typeRD.setLibelle(rd.getLibelle());
    repository.save(typeRD);
    return ResponseEntity.ok(new MessageResponse("Ressource de données registered successfully!"));
  }

  // Single item

  @GetMapping("/one")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> one(@Valid @RequestBody Long id) {

    TypeRD typeRD = (TypeRD) repository.findById(id)                                      
                                        .orElseThrow(() -> new IllegalArgumentException("not found"));
    return ResponseEntity.ok(typeRD);
												 
  }

  @PutMapping("/update")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> update(@RequestBody TypeRD newTypeRD) {

    TypeRD typeRD = (TypeRD) repository.findById(newTypeRD.getTypeRdId())
        .orElseThrow(() -> new IllegalArgumentException("not found"));
         
        repository.save(typeRD);

        return ResponseEntity.ok(new MessageResponse("RD updated successfully!"));

  }

  @DeleteMapping("/delete")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> delete(@RequestBody Long id) {
    repository.deleteById(id);
    return ResponseEntity.ok(new MessageResponse("RD deleted successfully!"));
  }
}
