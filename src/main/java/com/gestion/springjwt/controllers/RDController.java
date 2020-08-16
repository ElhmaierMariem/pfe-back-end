package com.gestion.springjwt.controllers;

import java.util.List;

import javax.validation.Valid;

import com.gestion.springjwt.models.RDClass;
import com.gestion.springjwt.models.TypeRD;
import com.gestion.springjwt.payload.models.RDClassModel;
import com.gestion.springjwt.payload.response.MessageResponse;
import com.gestion.springjwt.repository.RDRepo;
import com.gestion.springjwt.repository.TypeRDRepo;

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

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/rds")
public class RDController {
    


  private final RDRepo repository;
  private final TypeRDRepo repo;
  
  RDController(RDRepo repository, TypeRDRepo repo) {
    this.repository = repository;
    this.repo = repo;
  }

  @GetMapping("/all")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> all() {
    List<RDClass> rds = repository.findAll();
   
    return ResponseEntity.ok(rds);
  }

  @PostMapping("/save")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> create(@Valid @RequestBody RDClassModel rd) {
    RDClass newRD = new RDClass();
    newRD.setLibelle(rd.getLibelle());
    newRD.setDataBase(rd.getDataBase());
    newRD.setIpAdr(rd.getIpAdr());
    newRD.setLogin(rd.getLogin());
    newRD.setPasswd(rd.getPasswd());
    TypeRD typeRD = (TypeRD) repo.findById(rd.getTypeRd().getIdRD())
    		.orElseThrow(() -> new IllegalArgumentException("not found"));
    newRD.setTypeRd(typeRD);
    repository.save(newRD);
    return ResponseEntity.ok(new MessageResponse("Ressource de données registered successfully!"));
  }

  // Single item

  @GetMapping("/one")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> one(@Valid @RequestBody Long id) {

    RDClass rd = (RDClass) repository.findById(id)                                      
                                        .orElseThrow(() -> new IllegalArgumentException("not found"));
    return ResponseEntity.ok(rd);
												 
  }

  @PutMapping("/update/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> update(@RequestBody RDClassModel newRD, @PathVariable Long id) {

    RDClass typeRD = (RDClass) repository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("not found"));
    TypeRD typRD = (TypeRD) repo.findById(newRD.getTypeRd().getIdRD())
    .orElseThrow(() -> new IllegalArgumentException("not found"));

        typeRD.setDataBase(newRD.getDataBase());
         typeRD.setIpAdr(newRD.getIpAdr());
         typeRD.setLibelle(newRD.getLibelle());
         typeRD.setLogin(newRD.getLogin());
         typeRD.setPasswd(newRD.getPasswd());
         typeRD.setTypeRd(typRD);
        repository.save(typeRD);

        return ResponseEntity.ok(new MessageResponse("RD updated successfully!"));

  }

  @DeleteMapping("/delete/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> delete(@Valid @PathVariable Long id) {
    repository.deleteById(id);
    return ResponseEntity.ok(new MessageResponse("RD deleted successfully!"));
  }
}