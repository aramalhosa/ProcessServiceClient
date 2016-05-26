package com.ajr.process.service.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajr.process.service.dao.ChainDAO;
import com.ajr.process.service.dto.ChainComponentDTO;
import com.ajr.process.service.dto.ChainDTO;
import com.ajr.process.service.entity.ChainProjComponent;
import com.ajr.process.service.entity.ChainProject;
import com.ajr.process.service.services.ProcessServiceChainManagerService;

@Service
public class ProcessServiceChainManagerServiceImpl implements
		ProcessServiceChainManagerService {

	@Autowired
	ChainDAO chainDAO;

	private ChainDAO getChainDAO() {
		return chainDAO;
	}
	
	@Override
	public void insertProject(String project, ChainDTO chainProject){
		
		getChainDAO().insertProject(project, chainProject.getProjectName(), chainProject.getProjectDescription());

	}

	@Override
	public void insertProjectComponents(int projectId, List<ChainComponentDTO> components){
		
		for (ChainComponentDTO c: components){
			getChainDAO().insertProjectComponent(projectId, c.getComponentAttribute(), c.getComponentDescription());
		}
		
	}
	
	@Override
	public void updateProjectComponents(int projectId, List<ChainComponentDTO> components){
		
		getChainDAO().removeProjectComponents(projectId);
		
		for (ChainComponentDTO c: components){
			getChainDAO().insertProjectComponent(projectId, c.getComponentAttribute(), c.getComponentDescription());
		}
	}
	
	@Override
	public List<ChainDTO> getChainProjectsList(String project) {

		List<ChainDTO> result = new ArrayList<ChainDTO>();
		List<ChainProject> listProjects = getChainDAO().retrieveProjects(project);
		List<Integer> projectComponentsId = new ArrayList<Integer>();
		List<String> projectComponentsAtributes = new ArrayList<String>();
		List<String> projectComponentsDescriptions = new ArrayList<String>();

		for (ChainProject l : listProjects) {

			ChainDTO newProcessServiceChain = new ChainDTO(l.getChainProject(),
					l.getDescription(), projectComponentsId,
					projectComponentsAtributes, projectComponentsDescriptions);

			result.add(newProcessServiceChain);

		}

		return result;

	}

	@Override
	public ChainDTO getChainProjectById(int projectId) {

		ChainProject project = getChainDAO().retrieveProject(projectId);
		List<ChainProjComponent> projComponents = getChainDAO()
				.retrieveProjectComponents(projectId);
		List<Integer> projectComponentsId = new ArrayList<Integer>();
		List<String> projectComponentsAtributes = new ArrayList<String>();
		List<String> projectComponentsDescriptions = new ArrayList<String>();

		for (ChainProjComponent c : projComponents) {

			projectComponentsId.add(c.getChainProject().getId());
			projectComponentsAtributes.add(c.getAttribute());
			projectComponentsDescriptions.add(c.getDescription());

		}

		ChainDTO result = new ChainDTO(project.getChainProject(),
				project.getDescription(), projectComponentsId,
				projectComponentsAtributes, projectComponentsDescriptions);
		
		return result;
	}

}
