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

import com.gestion.springjwt.payload.models.CATClassModel;

import com.gestion.springjwt.payload.response.MessageResponse;
import com.gestion.springjwt.repository.CATRepo;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/cat")
public class CATController {
    


  private final CATRepo repository;
  
  
  CATController(CATRepo repository) {
    this.repository = repository;
   
  }

  @GetMapping("/all")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> all() {
    List<CATClass> cat = repository.findAll();
    return ResponseEntity.ok(cat);
  }

  @PostMapping("/save")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> create(@Valid @RequestBody CATClassModel cat) {
    CATClass newCAT = new CATClass();
    newCAT.setCatLibelle(cat.getCatLibelle());
    
    
    repository.save(newCAT);
    return ResponseEntity.ok(new MessageResponse("Catégorie rapport registered successfully!"));
  }

  // Single item

  @GetMapping("/one")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> one(@Valid @RequestBody Long id) {

    CATClass cat = (CATClass) repository.findById(id)                                      
                                        .orElseThrow(() -> new IllegalArgumentException("not found"));
    return ResponseEntity.ok(cat);
												 
  }

  @PutMapping("/update/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> update(@RequestBody CATClassModel newCAT , @PathVariable Long id) {

    CATClass cat = (CATClass) repository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("not found"));
    cat.setCatLibelle(newCAT.getCatLibelle());
        repository.save(cat);

        return ResponseEntity.ok(new MessageResponse("Catégorie rapport updated successfully!"));

  }

  @DeleteMapping("/delete/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> delete(@Valid @PathVariable Long id) {
    repository.deleteById(id);
    return ResponseEntity.ok(new MessageResponse("Catégorie rapport deleted successfully!"));
  }
}
