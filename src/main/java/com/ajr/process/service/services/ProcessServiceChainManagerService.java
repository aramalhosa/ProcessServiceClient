package com.ajr.process.service.services;

import java.util.List;

import com.ajr.process.service.dto.ChainComponentDTO;
import com.ajr.process.service.dto.ChainDTO;
import com.ajr.process.service.dto.ChainProjDTO;
import com.ajr.process.service.dto.ChainProjIdDescDTO;

public interface ProcessServiceChainManagerService {
	
	public void insertProject(String project, ChainProjDTO chainProject);
	public void insertProjectComponents(int projectId, List<ChainComponentDTO> components);
	public void updateProjectComponents(int projectId, List<ChainComponentDTO> components);
	public void updateSelectedProjectComponent(int projectId, int chainProj, int component);
	public List<ChainProjIdDescDTO> getChainProjectsList(String project);
	public ChainProjIdDescDTO getChainProjectSelected(String project);
	public ChainDTO getChainProjectById(int projectId);
	
}
