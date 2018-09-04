package com.ninemax.nacao.to.system;

import java.io.Serializable;


public class clsBaseGroupSortTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2239862389633458267L;
	private String group_id;
	private String group_name;
	private String group_desc;
	private int isgroup;
	private String group_parent;
	public String getGroup_id() {
		return group_id;
	}
	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	public String getGroup_desc() {
		return group_desc;
	}
	public void setGroup_desc(String group_desc) {
		this.group_desc = group_desc;
	}
	public int getIsgroup() {
		return isgroup;
	}
	public void setIsgroup(int isgroup) {
		this.isgroup = isgroup;
	}
	public String getGroup_parent() {
		return group_parent;
	}
	public void setGroup_parent(String group_parent) {
		this.group_parent = group_parent;
	}
	
	

}
