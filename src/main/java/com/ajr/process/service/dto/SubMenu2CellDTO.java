package com.ajr.process.service.dto;

public class SubMenu2CellDTO {
	
	public final String menuId;
	public final String subMenu1Id;
	public final String label;
	public final String subMenu2Id;
	
	public SubMenu2CellDTO(String menuId, String subMenu1Id, String label, String subMenu2Id) {
		this.menuId = menuId;
		this.subMenu1Id = subMenu1Id;
		this.label = label;
		this.subMenu2Id = subMenu2Id;
	}


}
