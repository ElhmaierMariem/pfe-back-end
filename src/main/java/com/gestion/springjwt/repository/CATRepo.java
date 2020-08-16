package com.gestion.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.springjwt.models.CATClass;

public interface CATRepo extends JpaRepository<CATClass, Long>{

}
