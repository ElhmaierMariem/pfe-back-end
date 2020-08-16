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
@Table(name="RESSOURCE_DONNEES")
public class RDClass implements Serializable {
	
	private static final long serialVersionUID = 1L;
   
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="RESSOURCE_DONNEES_ID")
	private Long RdId;

	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="TYPE_RD_ID")
   	private TypeRD typeRD;
    
    @Column(name="LIBELLE")
	private String Libelle; 
	
	 @Column(name="ADRESSE_IP")
	 
    private String ipAdr;
	@Column(name="NOM_BASE_DONNEES")
	private String dataBase;
	
    @Column(name="LOGIN")
	private String login;
	
     @Column(name="MOT_PASSE")
    private String passwd;

	public RDClass(TypeRD typeRD, String libelle, String ipAdr, String dataBase, String login, String passwd) {
		this.typeRD = typeRD;
		Libelle = libelle;
		this.ipAdr = ipAdr;
		this.dataBase = dataBase;
		this.login = login;
		this.passwd = passwd;
	}

	public RDClass() {
	}

	public Long getRdId() {
		return RdId;
	}

	public void setRdId(Long rdId) {
		RdId = rdId;
	}

	public TypeRD getTypeRd() {
		return typeRD;
	}

	public void setTypeRd(TypeRD typeRD) {
		this.typeRD = typeRD;
	}

	public String getLibelle() {
		return Libelle;
	}

	public void setLibelle(String libelle) {
		Libelle = libelle;
	}

	public String getIpAdr() {
		return ipAdr;
	}

	public void setIpAdr(String ipAdr) {
		this.ipAdr = ipAdr;
	}

	public String getDataBase() {
		return dataBase;
	}

	public void setDataBase(String dataBase) {
		this.dataBase = dataBase;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
        
}
