package com.gestion.springjwt.payload.models;

import java.util.ArrayList;
import java.util.List;

public class FormClassModel {

	
	private Long formId;
	private String formLibelle;
	private Long formNombreColonnes;
	
	private List<FormChampsClassModel> tabFormChamps = new ArrayList<FormChampsClassModel>();
	
	public List<FormChampsClassModel> getTabFormChamps() {
		return tabFormChamps;
	}
	public void setTabFormChamps(List<FormChampsClassModel> tabFormChamps) {
		this.tabFormChamps = tabFormChamps;
	}
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
	@Override
	public String toString() {
		return "FormClassModel [formId=" + formId + ", formLibelle=" + formLibelle + ", formNombreColonnes="
				+ formNombreColonnes + ", tabFormChamps=" + tabFormChamps + "]";
	}
	public Long getFormNombreColonnes() {
		return formNombreColonnes;
	}
	public void setFormNombreColonnes(Long formNombreColonnes) {
		this.formNombreColonnes = formNombreColonnes;
	}
	public FormClassModel(Long formId, String formLibelle, Long formNombreColonnes) {
		super();
		
		this.formId = formId;
		this.formLibelle = formLibelle;
		this.formNombreColonnes = formNombreColonnes;
	}
	public FormClassModel() {
		
	}
	
}
