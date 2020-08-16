package com.gestion.springjwt.payload.models;

public class FormChampsClassModel {
   
	    private Long formChampsNom ;
	    private String formChampsLibelle;
	    private Long formChampsLargeur;
	    private Long formChampsColspan;
	    private Long typeDId;
	    private Long typeChampsId;
	    private Long lVId;
	    
		
	
		@Override
		public String toString() {
			return "FormChampsClassModel [formChampsNom=" + formChampsNom + ", formChampsLibelle=" + formChampsLibelle
					+ ", formChampsLargeur=" + formChampsLargeur + ", formChampsColspan=" + formChampsColspan
					+ ", typeDId=" + typeDId + ", typeChampsId=" + typeChampsId + ", lVId=" + lVId + "]";
		}
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
		public Long getTypeDId() {
			return typeDId;
		}
		public void setTypeDId(Long typeDId) {
			this.typeDId = typeDId;
		}
		public Long getTypeChampsId() {
			return typeChampsId;
		}
		public void setTypeChampsId(Long typeChampsId) {
			this.typeChampsId = typeChampsId;
		}
		public Long getLVId() {
			return lVId;
		}
		public void setLVId(Long lVId) {
			this.lVId = lVId;
		}
		public FormChampsClassModel(LVClassModel lv, ChampsModel typeChamps, DModel typed , Long formChampsNom, String formChampsLibelle, Long formChampsLargeur,
				Long formChampsColspan, Long typeDId, Long typeChampsId, Long lVId) {
			super();
			this.formChampsNom = formChampsNom;
			this.formChampsLibelle = formChampsLibelle;
			this.formChampsLargeur = formChampsLargeur;
			this.formChampsColspan = formChampsColspan;
			this.typeDId = typeDId;
			this.typeChampsId = typeChampsId;
			this.lVId = lVId;
		}
		public FormChampsClassModel() {
			
		}
	    
	    
	    
	    
}
