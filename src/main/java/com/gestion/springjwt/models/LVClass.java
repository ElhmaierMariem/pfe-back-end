package com.gestion.springjwt.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;



@Entity
@Table(name="LISTE_VALEURS")
public class LVClass implements Serializable {
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="RESSOURCE_DONNEES_ID")
   	private RDClass RD;
	public RDClass getRD() {
		return RD;
	}
	public void setRD(RDClass rD) {
		RD = rD;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name="LISTE_VALEURS_ID")
	private Long lVId;
      @Column(name="LIBELLE")
    private String lVLibelle;
      @Column(name="REQUETE_SQL")
    private String lVRequeteSql;
      @Column(name="COLONNE_ID")
    private String lVColonneId;
      @Column(name="COLONNE_VALEUR")
    private String lVColonneValeur;
      
      /** ************Getters and Setters*************** **/
	
      public Long getLVId() {
		return lVId;
	}
	public void setLVId(Long lVId) {
		this.lVId = lVId;
	}
	public String getLVLibelle() {
		return lVLibelle;
	}
	public void setLVLibelle(String lVLibelle) {
		this.lVLibelle = lVLibelle;
	}
	public String getLVRequeteSql() {
		return lVRequeteSql;
	}
	public void setLVRequeteSql(String lVRequeteSql) {
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
	
	/** ****************Constructor******************** **/ 
	public LVClass( RDClass RD, String lVLibelle, String lVRequeteSql, String lVColonneId,
			String lVColonneValeur) {
		super();
		this.RD =  RD;
		this.lVLibelle = lVLibelle;
		this.lVRequeteSql = lVRequeteSql;
		this.lVColonneId = lVColonneId;
		this.lVColonneValeur = lVColonneValeur;
	}
	public LVClass() {
		
	}
	
      
    
      
}
