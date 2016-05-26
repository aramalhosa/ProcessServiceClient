package com.ajr.process.service.dto;

import java.util.List;

public class ChainComponentDTO {

	private String componentAttribute;
	private String componentDescription;


	public ChainComponentDTO(String componentAttribute, String componentDescription){
		
		this.componentAttribute = componentAttribute;
		this.componentDescription = componentDescription;

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
