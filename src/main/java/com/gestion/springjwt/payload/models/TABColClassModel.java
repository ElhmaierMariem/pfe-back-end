package com.gestion.springjwt.payload.models;

public class TABColClassModel {
 
	  private Long typeDId;
	  private Long tabColId ;
	  private String tabColLibelle;
	  private Long tabColLargeur;
	  
	public Long getTypeDId() {
		return typeDId;
	}
	public void setTypeD(Long typeDId) {
		this.typeDId = typeDId;
	}
	public Long getTabColId() {
		return tabColId;
	}
	public void setTabColId(Long tabColId) {
		this.tabColId = tabColId;
	}
	public String getTabColLibelle() {
		return tabColLibelle;
	}
	public void setTabColLibelle(String tabColLibelle) {
		this.tabColLibelle = tabColLibelle;
	}
	public Long getTabColLargeur() {
		return tabColLargeur;
	}
	public void setTabColLargeur(Long tabColLargeur) {
		this.tabColLargeur = tabColLargeur;
	}
	public TABColClassModel(Long typeDId, Long tabColId, String tabColLibelle, Long tabColLargeur) {
		super();
		this.typeDId = typeDId;
		this.tabColId = tabColId;
		this.tabColLibelle = tabColLibelle;
		this.tabColLargeur = tabColLargeur;
	}
	public TABColClassModel() {
		
	}
	  
	  
}
