package com.gestion.springjwt.payload.models;

public class ChampsModel {
    
	private Long champsId;
	private String champsLibelle;
	public Long getChampsId() {
		return champsId;
	}
	public void setChampsId(Long champsId) {
		this.champsId = champsId;
	}
	public String getChampsLibelle() {
		return champsLibelle;
	}
	public void setChampsLibelle(String champsLibelle) {
		this.champsLibelle = champsLibelle;
	}
	public ChampsModel(Long champsId, String champsLibelle) {
		super();
		this.champsId = champsId;
		this.champsLibelle = champsLibelle;
	}
	public ChampsModel() {
		
	}
	
}
