package com.ajr.process.service.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajr.process.service.dao.ChainDAO;
import com.ajr.process.service.dto.ChainComponentDTO;
import com.ajr.process.service.dto.ChainDTO;
import com.ajr.process.service.dto.ChainProjDTO;
import com.ajr.process.service.dto.ChainProjIdDescDTO;
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

	public void insertProject(String project, ChainProjDTO chainProject) {

		getChainDAO().insertProject(project, chainProject.getProjectName(),
				chainProject.getProjectDescription());

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

	public List<ChainProjIdDescDTO> getChainProjectsList(String project) {

		List<ChainProjIdDescDTO> result = new ArrayList<ChainProjIdDescDTO>();

		List<ChainProject> listProjects = getChainDAO().retrieveProjects(
				project);

		String empty = "";

		for (ChainProject l : listProjects) {

			ChainProjIdDescDTO obj = new ChainProjIdDescDTO(Integer.toString(l
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

	public ChainProjIdDescDTO getChainProjectSelected(String project) {

		ChainProject sqlSelect = getChainDAO().retrieveProjectSelected(project);

		ChainProjComponent sqlSelect1 = getChainDAO()
				.retrieveProjectComponentSelected(sqlSelect.getId());

		ChainProjIdDescDTO result = new ChainProjIdDescDTO(
				Integer.toString(sqlSelect.getId()),
				sqlSelect.getDescription(),
				Integer.toString(sqlSelect1.getId()),
				sqlSelect1.getDescription());

		return result;
	}

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

		ChainDTO result = new ChainDTO(projectId, project.getChainProject(),
				project.getDescription(), projectComponentsId,
				projectComponentsAtributes, projectComponentsDescriptions);

		return result;
	}

}
