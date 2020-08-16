package com.gestion.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.springjwt.models.RAPPClass;

public interface RAPPRepo extends JpaRepository<RAPPClass, Long> {

}
