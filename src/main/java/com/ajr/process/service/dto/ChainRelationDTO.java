package com.ajr.process.service.dto;

public class ChainRelationDTO {

	private String idComponent;	
	private String componentAttribute;
	private String componentDescription;
	private boolean selected;
	
	public ChainRelationDTO(String idComponent, String componentAttribute, String componentDescription, boolean selected){
		
		this.idComponent = idComponent;
		this.componentAttribute = componentAttribute;
		this.componentDescription = componentDescription;
		this.selected = selected;
		
	}
	
	public ChainRelationDTO(){
		
		this.idComponent = "";
		this.componentAttribute = "";
		this.componentDescription = "";
		this.selected = false;
	}	

	public String getIdComponent() {
		return idComponent;
	}


	public void setIdComponent(String idComponent) {
		this.idComponent = idComponent;
	}


	public String getComponentAttribute() {
		return componentAttribute;
	}


	public void setComponentAttribute(String componentAttribute) {
		this.componentAttribute = componentAttribute;
	}


	public String getComponentDescription() {
		return componentDescription;
	}


	public void setComponentDescription(String componentDescription) {
		this.componentDescription = componentDescription;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

}
