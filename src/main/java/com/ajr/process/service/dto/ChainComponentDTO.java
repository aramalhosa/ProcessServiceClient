package com.ajr.process.service.dto;

import java.util.List;

public class ChainComponentDTO {

	private String idComponent;	
	private String componentAttribute;
	private String componentDescription;
	private List<ChainComponentDTO> componentRelations;

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


	public List<ChainComponentDTO> getComponentRelations() {
		return componentRelations;
	}


	public void setComponentRelations(List<ChainComponentDTO> componentRelations) {
		this.componentRelations = componentRelations;
	}


}
