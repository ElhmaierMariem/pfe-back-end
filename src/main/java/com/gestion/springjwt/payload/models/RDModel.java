package com.gestion.springjwt.payload.models;

public class RDModel {
	
	private Long idRD;
	private String libelle;
	public Long getIdRD() {
		return idRD;
	}
	public void setIdRD(Long idRD) {
		this.idRD = idRD;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public RDModel() {
		
	}
	public RDModel(Long idRD, String libelle) {
		super();
		this.idRD = idRD;
		this.libelle = libelle;
	}
}
