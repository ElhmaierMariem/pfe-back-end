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
@Table(name="RAPPORTS")
public class RAPPClass implements Serializable {
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="CATEGORIE_RAPPORT_ID")
   	private CATClass catClass;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="RESSOURCE_DONNEES_ID")
   	private RDClass rdClass;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="FORMULAIRES_ID")
   	private FormClass formClass;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="FORMULAIRES_CHAMPS_ID")
   	private FormChampsClass formChampsClass;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="TABLEAUX_ID")
   	private TABClass tabClass;
	
	
    public CATClass getCatClass() {
		return catClass;
	}

	public void setCatClass(CATClass catClass) {
		this.catClass = catClass;
	}

	public RDClass getRdClass() {
		return rdClass;
	}

	public void setRdClass(RDClass rdClass) {
		this.rdClass = rdClass;
	}

	public FormClass getFormClass() {
		return formClass;
	}

	public void setFormClass(FormClass formClass) {
		this.formClass = formClass;
	}

	public FormChampsClass getFormChampsClass() {
		return formChampsClass;
	}

	public void setFormChampsClass(FormChampsClass formChampsClass) {
		this.formChampsClass = formChampsClass;
	}

	public TABClass getTabClass() {
		return tabClass;
	}

	public void setTabClass(TABClass tabClass) {
		this.tabClass = tabClass;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="RAPPORT_ID")
	private Long rappId;
	@Column(name = "LIBELLE")
       private String rappLibelle;
	@Column(name="REQUETE_SQL_ENTETE")
       private String requeteSqlEntete;
	@Column(name="REQUETE_SQL_DETAIL")
       private String requeteSqlDetail;
	@Column(name = "AVEC_TEMPLATE")
       private boolean avecTemplate;
	@Column(name="TEMPLATE")
       private String template;
	
	/** ******************* Getters and Setters*************** **/
	
	public Long getRappId() {
		return rappId;
	}

	public void setRappId(Long rappId) {
		this.rappId = rappId;
	}
	public String getRappLibelle() {
		return rappLibelle;
	}
	public void setRappLibelle(String rappLibelle) {
		this.rappLibelle = rappLibelle;
	}
	public String getRequeteSqlEntete() {
		return requeteSqlEntete;
	}
	public void setRequeteSqlEntete(String requeteSqlEntete) {
		this.requeteSqlEntete = requeteSqlEntete;
	}
	public String getRequeteSqlDetail() {
		return requeteSqlDetail;
	}
	public void setRequeteSqlDetail(String requeteSqlDetail) {
		this.requeteSqlDetail = requeteSqlDetail;
	}
	public boolean isAvecTemplate() {
		return avecTemplate;
	}
	public void setAvecTemplate(boolean avecTemplate) {
		this.avecTemplate = avecTemplate;
	}
	public String getTemplate() {
		return template;
	}
	public void setTemplate(String template) {
		this.template = template;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	/** ************** Constructor ******************** **/
	
	public RAPPClass( TABClass tabClass, FormChampsClass formChampsClass, FormClass formClass, RDClass rdClass, CATClass catClass, String rappLibelle, String requeteSqlEntete, String requeteSqlDetail, boolean avecTemplate,
			String template) {
		super();
		this.catClass = catClass;
		this.formChampsClass = formChampsClass ;
		this.formClass = formClass;
		this.rdClass = rdClass ;
		this.tabClass = tabClass;
		this.rappLibelle = rappLibelle;
		this.requeteSqlEntete = requeteSqlEntete;
		this.requeteSqlDetail = requeteSqlDetail;
		this.avecTemplate = avecTemplate;
		this.template = template;
	}

	public RAPPClass() {
		
	}
	
}


