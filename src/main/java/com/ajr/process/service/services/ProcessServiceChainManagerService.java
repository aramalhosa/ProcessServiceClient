package com.ajr.process.service.services;

import java.util.List;

import com.ajr.process.service.dto.ChainComponentDTO;
import com.ajr.process.service.dto.ChainDTO;
import com.ajr.process.service.dto.ChainProjectDTO;
import com.ajr.process.service.dto.ChainRelationDTO;
import com.ajr.process.service.exceptions.AttributeAlreadyExistsException;

public interface ProcessServiceChainManagerService {
	
	public void insertProject(String project, ChainProjectDTO chainProject);
	public void insertProjectComponent(String project, ChainComponentDTO component) throws AttributeAlreadyExistsException;
	public void insertComponentsRelation(int compId1, int compId2);
	public void updateProjectComponents(int projectId, List<ChainComponentDTO> components);
	public void updateSelectedProjectComponent(String project, int chainProj, int component);
	public void updateComponentRelations(int componentId, List<Integer> relations);	
	public List<ChainProjectDTO> getChainProjectsList(String project);
	public List<ChainComponentDTO> getChainProjectComponentsList(int chainProj);
	public List<ChainComponentDTO> getSelectedChainProjectComponentsList(String project);
	public ChainProjectDTO getSelectedChainProject(String project);
	public ChainComponentDTO getSelectedComponentFromSelectedChainProject(String project);
	public ChainDTO getChainProjectById(int projectId);
	public ChainComponentDTO getChainProjectComponent(int componentId);
	public List<ChainComponentDTO> getComponentRelations(int componentId);
	public List<ChainRelationDTO> getRelations(int componentId);
	public List<ChainRelationDTO> getNewRelations(int chainProject, int componentId);
	
}
