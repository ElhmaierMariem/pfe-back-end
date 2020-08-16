package com.gestion.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.springjwt.models.TypeRD;

@Repository
public interface TypeRDRepo extends JpaRepository<TypeRD, Long>{

}
