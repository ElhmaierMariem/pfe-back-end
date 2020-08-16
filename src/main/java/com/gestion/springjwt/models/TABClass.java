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
@Table(name="TABLEAUX")
public class TABClass implements Serializable {
	
	
	  
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="TABLEAU_COLONNES_ID")
   	private TABColClass tabColClass;
	 

	public TABColClass getTabColClass() {
		return tabColClass;
	}
	public void setTabColClass(TABColClass tabColClass) {
		this.tabColClass = tabColClass;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
     @Id
     @GeneratedValue(strategy =GenerationType.IDENTITY)
     @Column(name="TABLEAUX_ID")
     private Long tabId;
     @Column(name="LIBELLE")
     private String tabLibelle;
     
     /** *************Getters and Setters ****************** **/
	public Long getTabId() {
		return tabId;
	}
	public void setTabId(Long tabId) {
		this.tabId = tabId;
	}
	public String getTabLibelle() {
		return tabLibelle;
	}
	public void setTabLibelle(String tabLibelle) {
		this.tabLibelle = tabLibelle;
	}
	
	/** **************** Constructor *************** **/
	public TABClass(TABColClass tabColClass, String tabLibelle) {
		super();
		this.tabColClass = tabColClass;
		this.tabLibelle = tabLibelle;
	}
	public TABClass() {
		
	}
	
	
     
}
