package com.gestion.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.springjwt.models.LVClass;

public interface LVRepo extends JpaRepository<LVClass, Long> {

}
