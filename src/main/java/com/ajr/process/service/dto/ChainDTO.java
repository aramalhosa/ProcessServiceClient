package com.ajr.process.service.dto;

import java.util.ArrayList;
import java.util.List;

public class ChainDTO {

	private int chainProjectId;
	private String chainProjectName;
	private String chainProjectDescription;
	private List<Integer> chainProjectComponentsId;
	private List<String> chainProjectComponentsAtributes;
	private List<String> chainProjectComponentsDescriptions;

	public ChainDTO(int chainProjectId, String chainProjectName,
			String chainProjectDescription,
			List<Integer> chainProjectComponentsId,
			List<String> chainProjectComponentsAtributes,
			List<String> chainProjectComponentsDescriptions) {

		this.chainProjectId = chainProjectId;
		this.chainProjectName = chainProjectName;
		this.chainProjectDescription = chainProjectDescription;
		this.chainProjectComponentsId = chainProjectComponentsId;
		this.chainProjectComponentsAtributes = chainProjectComponentsAtributes;
		this.chainProjectComponentsDescriptions = chainProjectComponentsDescriptions;
	}

	public ChainDTO(int chainProjectId, String chainProjectName,
			String chainProjectDescription) {

		this.chainProjectId = chainProjectId;
		this.chainProjectName = chainProjectName;
		this.chainProjectDescription = chainProjectDescription;
		this.chainProjectComponentsId = new ArrayList<Integer>();
		this.chainProjectComponentsAtributes = new ArrayList<String>();
		this.chainProjectComponentsDescriptions = new ArrayList<String>();
	}

	public int getChainProjectId() {
		return chainProjectId;
	}

	public void setChainProjectId(int chainProjectId) {
		this.chainProjectId = chainProjectId;
	}

	public String getChainProjectName() {
		return chainProjectName;
	}

	public void setChainProjectName(String chainProjectName) {
		this.chainProjectName = chainProjectName;
	}

	public String getChainProjectDescription() {
		return chainProjectDescription;
	}

	public void setChainProjectDescription(String chainProjectDescription) {
		this.chainProjectDescription = chainProjectDescription;
	}

	public List<Integer> getChainProjectComponentsId() {
		return chainProjectComponentsId;
	}

	public void setChainProjectComponentsId(
			List<Integer> chainProjectComponentsId) {
		this.chainProjectComponentsId = chainProjectComponentsId;
	}

	public List<String> getChainProjectComponentsAtributes() {
		return chainProjectComponentsAtributes;
	}

	public void setChainProjectComponentsAtributes(
			List<String> chainProjectComponentsAtributes) {
		this.chainProjectComponentsAtributes = chainProjectComponentsAtributes;
	}

	public List<String> getChainProjectComponentsDescriptions() {
		return chainProjectComponentsDescriptions;
	}

	public void setChainProjectComponentsDescriptions(
			List<String> chainProjectComponentsDescriptions) {
		this.chainProjectComponentsDescriptions = chainProjectComponentsDescriptions;
	}

}
