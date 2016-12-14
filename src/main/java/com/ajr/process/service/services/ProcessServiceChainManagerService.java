package com.ajr.process.service.services;

import java.util.List;

import com.ajr.process.service.dto.ChainComponentDTO;
import com.ajr.process.service.dto.ChainDTO;
import com.ajr.process.service.dto.ChainProjectDTO;

public interface ProcessServiceChainManagerService {
	
	public void insertProject(String project, ChainProjectDTO chainProject);
	public void insertProjectComponents(int projectId, List<ChainComponentDTO> components);
	public void updateProjectComponents(int projectId, List<ChainComponentDTO> components);
	public void updateSelectedProjectComponent(int projectId, int chainProj, int component);
	public List<ChainProjectDTO> getChainProjectsList(String project);
	public List<ChainComponentDTO> getChainProjectComponentsList(int chainProj);
	public List<ChainComponentDTO> getSelectedChainProjectComponentsList(String project);
	public ChainProjectDTO getSelectedChainProject(String project);
	public ChainComponentDTO getSelectedComponentFromSelectedChainProject(String project);
	public ChainDTO getChainProjectById(int projectId);
	public ChainComponentDTO getChainProjectComponent(int projectId, int componentId);
	public List<ChainComponentDTO> getComponentRelations(int projectId, int componentId);
	
}
