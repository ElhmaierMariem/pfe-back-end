package com.gestion.springjwt.payload.models;


public class RDClassModel {


	public RDClassModel() {
		
	}
	public RDClassModel(Long rdId, RDModel typeRd, String libelle, String ipAdr, String dataBase, String login,
			String passwd) {
		super();
		RdId = rdId;
		this.typeRd = typeRd;
		Libelle = libelle;
		this.ipAdr = ipAdr;
		this.dataBase = dataBase;
		this.login = login;
		this.passwd = passwd;
	}
	private Long RdId;
   	private RDModel typeRd;
	public Long getRdId() {
		return RdId;
	}
	public void setRdId(Long rdId) {
		RdId = rdId;
	}
	public RDModel getTypeRd() {
		return typeRd;
	}
	public void setTypeRd(RDModel typeRD) {
		this.typeRd = typeRD;
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
	private String Libelle;
    private String ipAdr;
	private String dataBase;
	private String login;
    private String passwd;
}
