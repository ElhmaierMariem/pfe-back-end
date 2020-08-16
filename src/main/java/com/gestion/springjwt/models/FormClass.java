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
@Table(name="FORMULAIRES")
public class FormClass implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name="FORMULAIRES_ID")
	private Long formId;
     @Column(name="LIBELLE")
    private String formLibelle;
     @Column(name="NOMBRE_COLONNES")
    private Long formNombreColonnes;
	
	
     
     /** ****************Getters and Setters ********************* **/
     
     public Long getFormId() {
 		return formId;
 	}
 	public void setFormId(Long formId) {
 		this.formId = formId;
 	}
 	public String getFormLibelle() {
 		return formLibelle;
 	}
 	public void setFormLibelle(String formLibelle) {
 		this.formLibelle = formLibelle;
 	}
 	public Long getFormNombreColonnes() {
 		return formNombreColonnes;
 	}
 	public void setFormNombreColonnes(Long formNombreColonnes) {
 		this.formNombreColonnes = formNombreColonnes;
 	}
 	
 	/** ************** Constructor ********************* **/
	public FormClass(TypeChamps typeChamps,TypeD typeD, String formLibelle, Long formNombreColonnes) {
		super();
		this.formLibelle = formLibelle;
		this.formNombreColonnes = formNombreColonnes;
	}
	public FormClass() {
	
	}
	
 	
}
