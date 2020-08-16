package com.gestion.springjwt.payload.models;

public class RAPPClassModel {

	  private Long rappId;
	  private String rappLibelle;
	  private String requeteSqlEntete;
	  private String requeteSqlDetail;
	  private boolean avecTemplate;
	  private String template;
	  private Long catId;
	  private Long rdId;
	  private Long formId;
	  private Long tabId;
	  private Long formChampsId;
	  private CATClassModel cat;
	  private FormClassModel form;
	  private FormChampsClassModel formChamps;
	  private TABClassModel tab;
	  private RDClassModel rd;
	public CATClassModel getCat() {
		return cat;
	}
	public void setCat(CATClassModel cat) {
		this.cat = cat;
	}
	public FormClassModel getForm() {
		return form;
	}
	public void setForm(FormClassModel form) {
		this.form = form;
	}
	public FormChampsClassModel getFormChamps() {
		return formChamps;
	}
	public void setFormChamps(FormChampsClassModel formChamps) {
		this.formChamps = formChamps;
	}
	public TABClassModel getTab() {
		return tab;
	}
	public void setTab(TABClassModel tab) {
		this.tab = tab;
	}
	public RDClassModel getRd() {
		return rd;
	}
	public void setRd(RDClassModel rd) {
		this.rd = rd;
	}
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
	public Long getCatId() {
		return catId;
	}
	public void setCatId(Long catId) {
		this.catId = catId;
	}
	public Long getRdId() {
		return rdId;
	}
	public void setRdId(Long rdId) {
		this.rdId = rdId;
	}
	public Long getFormId() {
		return formId;
	}
	public void setFormId(Long formId) {
		this.formId = formId;
	}
	public Long getTabId() {
		return tabId;
	}
	public void setTabId(Long tabId) {
		this.tabId = tabId;
	}
	public Long getFormChampsId() {
		return formChampsId;
	}
	public void setFormChampsId(Long formChampsId) {
		this.formChampsId = formChampsId;
	}
	public RAPPClassModel(Long rappId, String rappLibelle, String requeteSqlEntete, String requeteSqlDetail, CATClassModel cat, FormClassModel form,
	   FormChampsClassModel formChamps,TABClassModel tab,RDClassModel rd,boolean avecTemplate,String template, Long catId, Long rdId,
	   Long formId, Long tabId, Long formChampsId) {
	   
	   
			 
		super();
		this.cat = cat;
		this.form = form;
		this.formChamps = formChamps;
		this.rd = rd;
		this.tab = tab;
		this.rappId = rappId;
		this.rappLibelle = rappLibelle;
		this.requeteSqlEntete = requeteSqlEntete;
		this.requeteSqlDetail = requeteSqlDetail;         
		this.avecTemplate = avecTemplate;
		this.template = template;
		this.catId = catId;
		this.rdId = rdId;
		this.formId = formId;
		this.tabId = tabId;
		this.formChampsId = formChampsId;
	}
	public RAPPClassModel() {
		
	}
	  
	  
}
