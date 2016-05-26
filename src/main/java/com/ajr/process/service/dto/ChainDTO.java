package com.ajr.process.service.dto;

import java.util.ArrayList;
import java.util.List;

public class ChainDTO {

	private String projectName;
	private String projectDescription;
	private List<Integer> projectComponentsId;
	private List<String> projectComponentsAtributes;
	private List<String> projectComponentsDescriptions;

	public ChainDTO(String projectName, String projectDescription,
			List<Integer> projectComponentsId,
			List<String> projectComponentsAtributes,
			List<String> projectComponentsDescriptions) {
		
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.projectComponentsId = projectComponentsId;
		this.projectComponentsAtributes = projectComponentsAtributes;
		this.projectComponentsDescriptions = projectComponentsDescriptions;
	}
	
	public ChainDTO(String projectName, String projectDescription){	
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.projectComponentsId = new ArrayList<Integer>();
		this.projectComponentsAtributes = new ArrayList<String>();
		this.projectComponentsDescriptions = new ArrayList<String>();
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public List<Integer> getProjectComponentsId() {
		return projectComponentsId;
	}

	public void setProjectComponentsId(List<Integer> projectComponentsId) {
		this.projectComponentsId = projectComponentsId;
	}

	public List<String> getProjectComponentsAtributes() {
		return projectComponentsAtributes;
	}

	public void setProjectComponentsAtributes(
			List<String> projectComponentsAtributes) {
		this.projectComponentsAtributes = projectComponentsAtributes;
	}

	public List<String> getProjectComponentsDescriptions() {
		return projectComponentsDescriptions;
	}

	public void setProjectComponentsDescriptions(
			List<String> projectComponentsDescriptions) {
		this.projectComponentsDescriptions = projectComponentsDescriptions;
	}

}
