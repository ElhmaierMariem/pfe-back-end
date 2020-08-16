package com.gestion.springjwt.payload.models;

import java.util.ArrayList;
import java.util.List;

public class TABClassModel {
 
	 private Long tabId;
	 private String tabLibelle;
	 private Long tabColId;
	 
	 private List<TABColClassModel> tabCol = new ArrayList<TABColClassModel>();
		
		
			
	public List<TABColClassModel> getTabCol() {
		return tabCol;
	}
	public void setTabCol(List<TABColClassModel> tabCol) {
		this.tabCol = tabCol;
	}
	public Long getTabColId() {
		return tabColId;
	}
	public void setTabColId(Long tabColId) {
		this.tabColId = tabColId;
	}
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
	public TABClassModel( Long tabColId, Long tabId, String tabLibelle) {
		super();
		this.tabColId = tabColId;
		this.tabId = tabId;
		this.tabLibelle = tabLibelle;
	}
	public TABClassModel() {
		
	}
	 
	 
}
