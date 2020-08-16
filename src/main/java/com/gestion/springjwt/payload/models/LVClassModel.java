package com.gestion.springjwt.payload.models;

public class LVClassModel {

	private Long lvid;
	private String lVLibelle;
	private String lVRequeteSql;
	private String lVColonneId;
	private String lVColonneValeur;
	@Override
	public String toString() {
		return "LVClassModel [Id=" + lvid + ", lVLibelle=" + lVLibelle + ", lVRequeteSql=" + lVRequeteSql
				+ ", lVColonneId=" + lVColonneId + ", lVColonneValeur=" + lVColonneValeur + ", rdId=" + rdId + "]";
	}
	private Long rdId;
	public Long getRdId() {
		return rdId; 
	}
	public void setRdId(Long rdId) { 
		this.rdId = rdId;
	}
	public Long getlVId() {
		return lvid;
	}
	public void setlVId(Long lVId) {
		this.lvid = lVId;
	}
	public String getlVLibelle() {
		return lVLibelle;
	}
	public void setlVLibelle(String lVLibelle) {
		this.lVLibelle = lVLibelle;
	}
	public String getlVRequeteSql() {
		return lVRequeteSql;
	}
	public void setlVRequeteSql(String lVRequeteSql) {
		this.lVRequeteSql = lVRequeteSql;
	}
	public String getLVColonneId() {
		return lVColonneId;
	}
	public void setLVColonneId(String lVColonneId) {
		this.lVColonneId = lVColonneId;
	}
	public String getLVColonneValeur() {
		return lVColonneValeur;
	}
	public void setLVColonneValeur(String lVColonneValeur) {
		this.lVColonneValeur = lVColonneValeur;
	}
	public LVClassModel( Long RdId, Long lVId, String lVLibelle, String lVRequeteSql, String lVColonneId, String lVColonneValeur) {
		super();
		this.rdId = RdId;
		this.lvid = lVId;
		this.lVLibelle = lVLibelle;
		this.lVRequeteSql = lVRequeteSql;
		this.lVColonneId = lVColonneId;
		this.lVColonneValeur = lVColonneValeur;
	}
	public LVClassModel() {
		
	}
	
}
