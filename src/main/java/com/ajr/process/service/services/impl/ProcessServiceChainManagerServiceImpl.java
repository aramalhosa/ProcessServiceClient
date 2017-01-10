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
import com.ajr.process.service.entity.ComponentRelation;
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
					.getId()), l.getChainProject(), l.getDescription(), empty,
					empty);

			result.add(obj);

		}

		return result;
	}

	public List<ChainComponentDTO> getChainProjectComponentsList(int chainProj) {

		List<ChainComponentDTO> result = new ArrayList<ChainComponentDTO>();

		List<ChainProjComponent> listComponents = getChainDAO()
				.retrieveChainProjectComponents(chainProj);

		for (ChainProjComponent l : listComponents) {

			ChainComponentDTO newProcessServiceChain = new ChainComponentDTO(
					Integer.toString(l.getId()), l.getAttribute(),
					l.getDescription());

			result.add(newProcessServiceChain);

		}

		return result;
	}

	public List<ChainComponentDTO> getSelectedChainProjectComponentsList(
			String project) {

		List<ChainComponentDTO> result = new ArrayList<ChainComponentDTO>();

		ChainProjComponent selComponent = getChainDAO()
				.retrieveSelectedComponentFromSelectedProject(project);

		List<ComponentRelation> listComponents = getChainDAO()
				.retrieveComponentRelations(selComponent.getId());

		for (ComponentRelation l : listComponents) {

			ChainComponentDTO newProcessServiceChain = new ChainComponentDTO(
					Integer.toString(l.getChainProjectComponent2().getId()), l
							.getChainProjectComponent2().getAttribute(), l
							.getChainProjectComponent2().getDescription());

			result.add(newProcessServiceChain);

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

	public ChainProjectDTO getSelectedChainProject(String project) {

		ChainProject chainProjectSel = getChainDAO().retrieveProjectSelected(
				project);

		ChainProjComponent componentSel = getChainDAO()
				.retrieveSelectedComponentFromSelectedProject(project);

		ChainProjectDTO result = new ChainProjectDTO(
				Integer.toString(chainProjectSel.getId()),
				chainProjectSel.getChainProject(),
				chainProjectSel.getDescription(), Integer.toString(componentSel
						.getId()), componentSel.getDescription());

		return result;
	}

	public List<ChainComponentDTO> getComponentRelations(int componentId) {

		List<ChainComponentDTO> result = new ArrayList<ChainComponentDTO>();

		List<ComponentRelation> listRel = getChainDAO()
				.retrieveComponentRelations(componentId);

		for (ComponentRelation l : listRel) {

			ChainComponentDTO newRelation = new ChainComponentDTO(
					Integer.toString(l.getChainProjectComponent2().getId()), l
							.getChainProjectComponent2().getAttribute(), l
							.getChainProjectComponent2().getDescription());

			result.add(newRelation);

		}

		return null;
	}

	public ChainDTO getChainProjectById(int projectId) {

		ChainProject project = getChainDAO().retrieveProject(projectId);
		Set<ChainProjComponent> projComponents = project
				.getChainProjComponents();
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

	public ChainComponentDTO getChainProjectComponent(int projectId,
			int componentId) {

		ChainProjComponent component = getChainDAO().retrieveProjectComponent(
				projectId, componentId);

		ChainComponentDTO result = new ChainComponentDTO();

		result.setComponentAttribute(component.getAttribute());
		result.setComponentDescription(component.getDescription());
		result.setIdComponent(Integer.toString(component.getId()));

		return result;

	}

	public ChainComponentDTO getSelectedComponentFromSelectedChainProject(
			String project) {

		ChainProjComponent component = getChainDAO()
				.retrieveSelectedComponentFromSelectedProject(project);

		ChainComponentDTO result = new ChainComponentDTO();

		result.setComponentAttribute(component.getAttribute());
		result.setComponentDescription(component.getDescription());
		result.setIdComponent(Integer.toString(component.getId()));

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
