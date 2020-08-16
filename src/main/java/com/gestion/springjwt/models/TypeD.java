package com.gestion.springjwt.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;



@Entity
@Table(name="TYPE_DONNEES")
public class TypeD implements Serializable {
	
	 
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="TYPE_D_ID")
	private Long typeDId;
	@Column(name="LIBELLE")
	private String typeDLibelle;
	
	/** *************Getters and Setters***************** **/
	
	
	public Long getTypeDId() {
		return typeDId;
	}
	public void setTypeDId(Long typeDId) {
		this.typeDId = typeDId;
	}
	public String getTypeDLibelle() {
		return typeDLibelle;
	}
	public void setTypeDLibelle(String typeDLibelle) {
		this.typeDLibelle = typeDLibelle;
	}
	
	
	
	/** *****************Constructor**************** **/
	public TypeD(Long typeDId, String typeDLibelle) {
		super();
		this.typeDId = typeDId;
		this.typeDLibelle = typeDLibelle;
	}
	public TypeD() {
		
	}
	
	
	
	
}