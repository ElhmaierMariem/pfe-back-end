package com.gestion.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.springjwt.models.FormClass;

public interface FormRepo extends JpaRepository<FormClass, Long> {

}
