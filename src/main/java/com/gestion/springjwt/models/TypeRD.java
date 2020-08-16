package com.gestion.springjwt.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
@Entity
@Table(name="TYPE_RESSOURCE_DONNEES")
public class TypeRD implements Serializable {
     
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="TYPE_RD_ID")
	private Long typeRdId;
	@Column(name="LIBELLE")
    private String libelle;

	public TypeRD(String libelle) {
		this.libelle = libelle;
	}

	public TypeRD() {
	}

	public Long getTypeRdId() {
		return typeRdId;
	}

	public void setTypeRdId(Long typeRdId) {
		this.typeRdId = typeRdId;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	
     
}
