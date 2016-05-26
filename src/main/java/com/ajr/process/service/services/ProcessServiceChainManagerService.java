package com.ajr.process.service.services;

import java.util.List;

import com.ajr.process.service.dto.ChainComponentDTO;
import com.ajr.process.service.dto.ChainDTO;

public interface ProcessServiceChainManagerService {
	
	public void insertProject(String project, ChainDTO chainProject);
	public void insertProjectComponents(int projectId, List<ChainComponentDTO> components);
	public void updateProjectComponents(int projectId, List<ChainComponentDTO> components);
	public List<ChainDTO> getChainProjectsList(String project);
	public ChainDTO getChainProjectById(int projectId);
	
}
