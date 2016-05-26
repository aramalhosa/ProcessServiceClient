package com.ajr.process.service.services;

import java.util.List;

import com.ajr.process.service.dto.MenuCellDTO;
import com.ajr.process.service.dto.MenuDataDTO;
import com.ajr.process.service.dto.SubMenu1CellDTO;
import com.ajr.process.service.dto.SubMenu2CellDTO;
import com.ajr.process.service.dto.SubMenuDataDTO;

public interface ProcessServiceMenuManagerService {
	
	public List<MenuCellDTO> getList();
	public List<MenuCellDTO> getMenuByProject(String project);
	public List<SubMenu1CellDTO> getSubMenu1ByProject(String project);
	public List<SubMenu2CellDTO> getSubMenu2ByProject(String project);
	public MenuCellDTO getMenuById(String project, int menuId);
	public List<SubMenu1CellDTO> getSubMenu1ById(String project, int menuId);
	public List<SubMenu2CellDTO> getSubMenu2ById(String project, int menuId, int submenuId);
	public void updateMenuItems(String project, MenuDataDTO menu);
	public void updateSubMenu1Items(String project, int menuId, SubMenuDataDTO subMenu);
	public void updateSubMenu2Items(String project, int menuId, int submenu1, SubMenuDataDTO subMenu2);

}
