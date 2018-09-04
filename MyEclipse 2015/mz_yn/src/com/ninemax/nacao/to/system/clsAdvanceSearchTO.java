package com.ninemax.nacao.to.system;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * ∏ﬂº∂≤È—ØGOV
 * @author yxf
 *
 */
public class clsAdvanceSearchTO implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8113363117519639934L;
	private String category;
	private String field_name;
	private String field_value;
	private String ismenu;
	private ArrayList menuList;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getField_name() {
		return field_name;
	}
	public void setField_name(String field_name) {
		this.field_name = field_name;
	}
	public String getField_value() {
		return field_value;
	}
	public void setField_value(String field_value) {
		this.field_value = field_value;
	}
	public String getIsmenu() {
		return ismenu;
	}
	public void setIsmenu(String ismenu) {
		this.ismenu = ismenu;
	}
	public ArrayList getMenuList() {
		return menuList;
	}
	public void setMenuList(ArrayList menuList) {
		this.menuList = menuList;
	}
	
}
