package com.ajr.process.service.dto;


public class ChainProjIdDescDTO {

	private String id;
	private String description;
	private String componentId;
	private String compDescription;
	
	public ChainProjIdDescDTO(String id, String desc, String idComp, String compDesc) {
		this.id = id;
		this.description = desc;
		this.componentId = idComp;
		this.compDescription = compDesc;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getComponentId() {
		return componentId;
	}

	public void setComponentId(String componentId) {
		this.componentId = componentId;
	}

	public String getCompDescription() {
		return compDescription;
	}

	public void setCompDescription(String compDescription) {
		this.compDescription = compDescription;
	}

}
