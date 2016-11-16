package com.ajr.process.service.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajr.process.service.dao.ChainDAO;
import com.ajr.process.service.dto.ChainComponentDTO;
import com.ajr.process.service.dto.ChainDTO;
import com.ajr.process.service.dto.ChainProjectDTO;
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

	public void insertProject(String project, ChainProjectDTO chainProject) {

		getChainDAO().insertProject(project, chainProject.getName(),
				chainProject.getDescription());

	}

	public List<ChainProjectDTO> getChainProjectsList(String project) {

		List<ChainProjectDTO> result = new ArrayList<ChainProjectDTO>();

		List<ChainProject> listProjects = getChainDAO().retrieveProjects(
				project);

		String empty = "";

		for (ChainProject l : listProjects) {

			ChainProjectDTO obj = new ChainProjectDTO(Integer.toString(l
					.getId()), l.getDescription(), empty, empty);

			result.add(obj);

		}

		return result;
	}

	public List<ChainDTO> getChainProjectsDetail(String project) {

		List<ChainDTO> result = new ArrayList<ChainDTO>();
		List<ChainProject> listProjects = getChainDAO().retrieveProjects(
				project);
		List<Integer> projectComponentsId = new ArrayList<Integer>();
		List<String> projectComponentsAtributes = new ArrayList<String>();
		List<String> projectComponentsDescriptions = new ArrayList<String>();

		for (ChainProject l : listProjects) {

			ChainDTO newProcessServiceChain = new ChainDTO(l.getId(),
					l.getChainProject(), l.getDescription(),
					projectComponentsId, projectComponentsAtributes,
					projectComponentsDescriptions);

			result.add(newProcessServiceChain);

		}

		return result;

	}

	public ChainProjectDTO getChainProjectSelected() {
		
		String componentId = "";
		String componentDesc = "";

		ChainProject sqlSelect = getChainDAO().retrieveProjectSelected();

		Set<ChainProjComponent> components = sqlSelect.getChainProjComponents();
		
		for(ChainProjComponent c: components){
			if (c.getSelected()=='1'){
				componentId = Integer.toString(c.getId());
				componentDesc = c.getDescription();
			}
		}

		ChainProjectDTO result = new ChainProjectDTO(
				Integer.toString(sqlSelect.getId()),
				sqlSelect.getDescription(),
				componentId,
				componentDesc);

		return result;
	}
	
	public List<ChainComponentDTO> getComponentRelations(int projectId, int componentId){
		
		ChainProject proj = getChainDAO().retrieveProject(projectId);
		
		ChainProjComponent comp = getChainDAO().retrieveProjectComponent(projectId, componentId);
		
		//TODO Not full implemented! Need to be reviewed!
		
		return null;
	}

	public ChainDTO getChainProjectById(int projectId) {

		ChainProject project = getChainDAO().retrieveProject(projectId);
		Set<ChainProjComponent> projComponents = project.getChainProjComponents();
		List<Integer> projectComponentsId = new ArrayList<Integer>();
		List<String> projectComponentsAtributes = new ArrayList<String>();
		List<String> projectComponentsDescriptions = new ArrayList<String>();

		for (ChainProjComponent c : projComponents) {

			projectComponentsId.add(c.getChainProject().getId());
			projectComponentsAtributes.add(c.getAttribute());
			projectComponentsDescriptions.add(c.getDescription());

		}

		ChainDTO result = new ChainDTO(projectId, project.getChainProject(),
				project.getDescription(), projectComponentsId,
				projectComponentsAtributes, projectComponentsDescriptions);

		return result;
	}	
	
	public ChainComponentDTO getChainProjectComponent(int projectId, int componentId){
		
		ChainProjComponent component = getChainDAO().retrieveProjectComponent(projectId, componentId);
		
		ChainComponentDTO result = new ChainComponentDTO();
		
		result.setComponentAttribute(component.getAttribute());
		result.setComponentDescription(component.getDescription());
		result.setIdComponent(Integer.toString(component.getId()));		
		result.setComponentRelations(null);
		
		return result;
		
	}
	
	public ChainComponentDTO getChainSelectedProjectComponent(String project){

		ChainProjComponent component = getChainDAO().retrieveSelectedProjectComponent(project);
		
		ChainComponentDTO result = new ChainComponentDTO();
		
		result.setComponentAttribute(component.getAttribute());
		result.setComponentDescription(component.getDescription());
		result.setIdComponent(Integer.toString(component.getId()));		
		result.setComponentRelations(null);
		
		return result;
		
	}
	
	public void insertProjectComponents(int projectId,
			List<ChainComponentDTO> components) {

		for (ChainComponentDTO c : components) {
			getChainDAO().insertProjectComponent(projectId,
					c.getComponentAttribute(), c.getComponentDescription());
		}

	}

	public void updateProjectComponents(int projectId,
			List<ChainComponentDTO> components) {

		getChainDAO().removeProjectComponents(projectId);

		for (ChainComponentDTO c : components) {
			getChainDAO().insertProjectComponent(projectId,
					c.getComponentAttribute(), c.getComponentDescription());
		}
	}

	public void updateSelectedProjectComponent(int projectId, int projChain,
			int component) {

		getChainDAO().updateSelecedProjectComponent(projectId, projChain,
				component);

	}



}
