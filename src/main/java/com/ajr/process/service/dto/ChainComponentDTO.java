package com.ajr.process.service.dto;

public class ChainComponentDTO {

	private String idComponent;	
	private int idChainProject;
	private String componentAttribute;
	private String componentDescription;
	
	public ChainComponentDTO(String idComponent, int idChainProject, String componentAttribute, String componentDescription){
		
		this.idComponent = idComponent;
		this.idChainProject = idChainProject;
		this.componentAttribute = componentAttribute;
		this.componentDescription = componentDescription;
		
	}
	
	public ChainComponentDTO(){
		
		this.idComponent = "";
		this.componentAttribute = "";
		this.componentDescription = "";
		
	}	

	public String getIdComponent() {
		return idComponent;
	}


	public void setIdComponent(String idComponent) {
		this.idComponent = idComponent;
	}


	public int getIdChainProject() {
		return idChainProject;
	}

	public void setIdChainProject(int idChainProject) {
		this.idChainProject = idChainProject;
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

}
