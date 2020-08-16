package com.gestion.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.springjwt.models.TABClass;

public interface TABRepo extends JpaRepository<TABClass, Long> {

}
