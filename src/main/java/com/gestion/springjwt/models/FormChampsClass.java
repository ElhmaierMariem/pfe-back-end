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
@Table(name="FORMULAIRE_CHAMPS")
public class FormChampsClass implements Serializable{
    
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="TYPE_D_ID")
   	private TypeD typeD;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="TYPE_CHAMPS_ID")
   	private TypeChamps typeChamps;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="LISTE_VALEURS_ID")
   	private LVClass lvClass;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="FORMULAIRE_ID")
   	private FormClass formClass;
	
	
	public FormClass getFormClass() {
		return formClass;
	}
	public void setFormClass(FormClass formClass) {
		this.formClass = formClass;
	}
	public TypeD getTypeD() {
		return typeD;
	}
	public void setTypeD(TypeD typeD) {
		this.typeD = typeD;
	}
	public TypeChamps getTypeChamps() {
		return typeChamps;
	}
	public void setTypeChamps(TypeChamps typeChamps) {
		this.typeChamps = typeChamps;
	}
	public LVClass getLvClass() {
		return lvClass;
	}
	public void setLvClass(LVClass lvClass) {
		this.lvClass = lvClass;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="FORMULAIRE_CHAMP_NOM")
	private Long formChampsNom ;
    @Column(name="LIBELLE")
    private String formChampsLibelle;
    @Column(name="LARGEUR")
    private Long formChampsLargeur;
    @Column(name="COLSPAN")
    private Long formChampsColspan;
    
    /** *****************Getters and Setters ****************** **/
	public Long getFormChampsNom() {
		return formChampsNom;
	}
	public void setFormChampsNom(Long formChampsNom) {
		this.formChampsNom = formChampsNom;
	}
	public String getFormChampsLibelle() {
		return formChampsLibelle;
	}
	public void setFormChampsLibelle(String formChampsLibelle) {
		this.formChampsLibelle = formChampsLibelle;
	}
	public Long getFormChampsLargeur() {
		return formChampsLargeur;
	}
	public void setFormChampsLargeur(Long formChampsLargeur) {
		this.formChampsLargeur = formChampsLargeur;
	}
	public Long getFormChampsColspan() {
		return formChampsColspan;
	}
	public void setFormChampsColspan(Long formChampsColspan) {
		this.formChampsColspan = formChampsColspan;
	}
	
	/** ****************** Constructor  ************** **/
	public FormChampsClass( FormClass formClass ,LVClass lvClass ,TypeChamps typeChamps ,TypeD typeD, String formChampsLibelle, Long formChampsLargeur, Long formChampsColspan) {
		super();
		this.formClass = formClass;
		this.typeChamps = typeChamps;
		this.lvClass = lvClass ;
		this.typeD = typeD ;
		this.formChampsLibelle = formChampsLibelle;
		this.formChampsLargeur = formChampsLargeur;
		this.formChampsColspan = formChampsColspan;
	}
	public FormChampsClass() {
		
	}
	
	
	
	
	
    
}

