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
@Table(name="TABLEAU_COLONNES")
public class TABColClass implements Serializable {
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="TYPE_D_ID")
   	private TypeD typeD;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="TABLEAUX_ID")
   	private TABClass tabClass;
	
    
	public TABClass getTabClass() {
		return tabClass;
	}
	public void setTabClass(TABClass tabClass) {
		this.tabClass = tabClass;
	}
	public TypeD getTypeD() {
		return typeD;
	}
	public void setTypeD(TypeD typeD) {
		this.typeD = typeD;
	}
	
	private static final long serialVersionUID = 1L;
	@Id
      @GeneratedValue(strategy =GenerationType.IDENTITY)
      @Column(name="TABLEAU_COLONNES_ID")
      private Long tabColId ;
      @Column(name="LIBELLE")
      private String tabColLibelle;
      @Column(name="LARGEUR")
      private Long tabColLargeur;
      
      /** ******** Getters and Setters************ **/
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
	
	/** ************* Constructor ********************* **/
	public TABColClass(TABClass tabClass, TypeD typeD, String tabColLibelle, Long tabColLargeur) {
		super();
		this.typeD = typeD;
		this.tabClass = tabClass;
		this.tabColLibelle = tabColLibelle;
		this.tabColLargeur = tabColLargeur;
	}
	public TABColClass() {
		
	}
	
	
	
      
      
}

