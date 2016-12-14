package com.ajr.process.service.dto;


public class ChainProjectDTO {

	private String id;
	private String name;
	private String description;
	private String componentSelectedId;
	private String componentSelectedAtribute;
	
	public ChainProjectDTO(String id, String name, String desc, String idComp, String compDesc) {
		this.id = id;
		this.name = name;
		this.description = desc;
		this.componentSelectedId = idComp;
		this.componentSelectedAtribute = compDesc;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getComponentSelectedId() {
		return componentSelectedId;
	}

	public void setComponentId(String componentSelectedId) {
		this.componentSelectedId = componentSelectedId;
	}

	public String getcomponentSelectedAtribute() {
		return componentSelectedAtribute;
	}

	public void setcomponentSelectedAtribute(String componentSelectedAtribute) {
		this.componentSelectedAtribute = componentSelectedAtribute;
	}

}
