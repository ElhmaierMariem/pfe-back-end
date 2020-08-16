package com.gestion.springjwt.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="CATEGORIE_RAPPORTS")
public class CATClass implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CATEGORIE_RAPPORT_ID")
	private Long catId;
	@Column(name="LIBELLE")
	private String catLibelle;
	
	/** **************** Getters and Setters ************************ **/
	public Long getCattId() {
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
	
	/** ******************Constructor **************************** **/
	public CATClass(String catLibelle) {
		super();
		this.catLibelle = catLibelle;
	}
	

	public CATClass() {
		
	}

	
}

