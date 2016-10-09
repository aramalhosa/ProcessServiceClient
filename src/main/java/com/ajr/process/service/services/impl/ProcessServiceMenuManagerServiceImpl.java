package com.ajr.process.service.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajr.process.service.dao.MenuDataDAO;
import com.ajr.process.service.dto.MenuCellDTO;
import com.ajr.process.service.dto.MenuDataDTO;
import com.ajr.process.service.dto.SubMenu1CellDTO;
import com.ajr.process.service.dto.SubMenu2CellDTO;
import com.ajr.process.service.dto.SubMenuDataDTO;
import com.ajr.process.service.entity.MenuData;
import com.ajr.process.service.services.ProcessServiceMenuManagerService;

@Service
public class ProcessServiceMenuManagerServiceImpl implements
		ProcessServiceMenuManagerService {

	@Autowired
	MenuDataDAO menuDataDAO;

	private MenuDataDAO getMenuDataDAO() {
		return menuDataDAO;
	}

	
	public List<MenuCellDTO> getList() {

		List<MenuCellDTO> result = new ArrayList<MenuCellDTO>();
		List<MenuData> listMenuData = getMenuDataDAO().retrieveMenuItems();

		for (MenuData d : listMenuData) {
			MenuCellDTO newProcessServiceMenu = new MenuCellDTO(d.getLabel(),
					Integer.toString(d.getMenunum()));
			result.add(newProcessServiceMenu);

		}

		return result;

	}

	
	public List<MenuCellDTO> getMenuByProject(String project) {

		List<MenuCellDTO> result = new ArrayList<MenuCellDTO>();
		List<MenuData> listMenuData = getMenuDataDAO().retrieveMenuItems(
				project);

		for (MenuData d : listMenuData) {
			MenuCellDTO newProcessServiceMenu = new MenuCellDTO(d.getLabel(),
					Integer.toString(d.getMenunum()));
			result.add(newProcessServiceMenu);

		}

		return result;
	}

	
	public List<SubMenu1CellDTO> getSubMenu1ByProject(String project) {

		List<SubMenu1CellDTO> result = new ArrayList<SubMenu1CellDTO>();
		List<MenuData> listMenuData = getMenuDataDAO().retrieveSubMenu1Items(
				project);

		for (MenuData d : listMenuData) {
			SubMenu1CellDTO newProcessServiceMenu = new SubMenu1CellDTO(
					Integer.toString(d.getMenunum()), d.getLabel(),
					Integer.toString(d.getSubmenu1num()));
			result.add(newProcessServiceMenu);

		}

		return result;
	}

	
	public List<SubMenu2CellDTO> getSubMenu2ByProject(String project) {

		List<SubMenu2CellDTO> result = new ArrayList<SubMenu2CellDTO>();
		List<MenuData> listMenuData = getMenuDataDAO().retrieveSubMenu2Items(
				project);

		for (MenuData d : listMenuData) {
			SubMenu2CellDTO newProcessServiceMenu = new SubMenu2CellDTO(
					Integer.toString(d.getMenunum()), Integer.toString(d
							.getSubmenu1num()), d.getLabel(),
					Integer.toString(d.getSubmenu2num()));
			result.add(newProcessServiceMenu);

		}

		return result;
	}

	
	public MenuCellDTO getMenuById(String project, int menuId) {

		MenuData menuData = getMenuDataDAO().retrieveMenuItem(project, menuId);

		MenuCellDTO result = new MenuCellDTO(menuData.getLabel(),
				Integer.toString(menuData.getMenunum()));

		return result;

	}

	
	public List<SubMenu1CellDTO> getSubMenu1ById(String project, int menuId) {

		List<SubMenu1CellDTO> result = new ArrayList<SubMenu1CellDTO>();
		List<MenuData> listMenuData = getMenuDataDAO().retrieveSubMenu1Items(
				project, menuId);

		for (MenuData d : listMenuData) {
			SubMenu1CellDTO newProcessServiceMenu = new SubMenu1CellDTO(
					Integer.toString(d.getMenunum()), d.getLabel(),
					Integer.toString(d.getSubmenu1num()));
			result.add(newProcessServiceMenu);

		}

		return result;

	}

	
	public List<SubMenu2CellDTO> getSubMenu2ById(String project, int menuId,
			int submenuId) {

		List<SubMenu2CellDTO> result = new ArrayList<SubMenu2CellDTO>();
		List<MenuData> listMenuData = getMenuDataDAO().retrieveSubMenu2Items(
				project, menuId, submenuId);

		for (MenuData d : listMenuData) {
			SubMenu2CellDTO newProcessServiceMenu = new SubMenu2CellDTO(
					Integer.toString(d.getMenunum()), Integer.toString(d
							.getSubmenu1num()), d.getLabel(),
					Integer.toString(d.getSubmenu2num()));
			result.add(newProcessServiceMenu);

		}

		return result;

	}

	
	public void updateMenuItems(String project, MenuDataDTO menu) {

		getMenuDataDAO().updateMenuItems(project, menu.getMenu1Text(),
				menu.getMenu2Text(), menu.getMenu3Text(), menu.getMenu4Text());

	}

	
	public void updateSubMenu1Items(String project, int menuId,
			SubMenuDataDTO subMenu) {

		getMenuDataDAO().updateSubMenu1Items(project, menuId,
				subMenu.getMenu1Text(), subMenu.getMenu2Text(),
				subMenu.getMenu3Text(), subMenu.getMenu4Text(),
				subMenu.getMenu5Text(), subMenu.getMenu6Text());

	}

	
	public void updateSubMenu2Items(String project, int menuId, int subMenu1,
			SubMenuDataDTO subMenu2) {

		getMenuDataDAO().updateSubMenu2Items(project, menuId, subMenu1,
				subMenu2.getMenu1Text(), subMenu2.getMenu2Text(),
				subMenu2.getMenu3Text(), subMenu2.getMenu4Text(),
				subMenu2.getMenu5Text(), subMenu2.getMenu6Text());

	}

}
