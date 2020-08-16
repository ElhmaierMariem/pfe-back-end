package com.gestion.springjwt.payload.models;

public class CATClassModel {
   
	private Long catId;
	private String catLibelle;
	public Long getCatId() {
		return catId;
	}
	public void setCatId(Long catId) {
		this.catId = catId;
	}
	public String getCatLibelle() {
		return catLibelle;
	}
	public void setCatLibelle(String catLibelle) {
		this.catLibelle = catLibelle;
	}
	public CATClassModel(Long catId, String catLibelle) {
		super();
		this.catId = catId;
		this.catLibelle = catLibelle;
	}
	public CATClassModel() {
	
	}
	
}
