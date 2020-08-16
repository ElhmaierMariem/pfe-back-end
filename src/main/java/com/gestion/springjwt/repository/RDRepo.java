package com.gestion.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.springjwt.models.RDClass;

public interface RDRepo extends JpaRepository<RDClass, Long>{

}
