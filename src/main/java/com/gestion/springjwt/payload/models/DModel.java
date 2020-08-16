package com.gestion.springjwt.payload.models;

public class DModel {
      
	private Long dId;
	private String dLibelle;
	public Long getdId() {
		return dId;
	}
	public void setdId(Long dId) {
		this.dId = dId;
	}
	public String getdLibelle() {
		return dLibelle;
	}
	public void setdLibelle(String dLibelle) {
		this.dLibelle = dLibelle;
	}
	public DModel(Long dId, String dLibelle) {
		super();
		this.dId = dId;
		this.dLibelle = dLibelle;
	}
	public DModel() {
	
	}
	
}
