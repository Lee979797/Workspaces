package com.ninemax.nacao.to.govInfo;

public class clsGovType {

	private String gov_type_id = ""; //类型ID
	private String gov_type_pid = "";//类型父ID
	private String gov_type_name = "";//类型名称
	
	private String isgroup;
	private String gov_sort = "";//排序
	
	public String getGov_type_id() {
		return gov_type_id;
	}
	public void setGov_type_id(String gov_type_id) {
		this.gov_type_id = gov_type_id;
	}
	public String getGov_type_pid() {
		return gov_type_pid;
	}
	public void setGov_type_pid(String gov_type_pid) {
		this.gov_type_pid = gov_type_pid;
	}
	public String getGov_type_name() {
		return gov_type_name;
	}
	public void setGov_type_name(String gov_type_name) {
		this.gov_type_name = gov_type_name;
	}
	public String getIsgroup() {
		return isgroup;
	}
	public void setIsgroup(String isgroup) {
		this.isgroup = isgroup;
	}
	public String getGov_sort() {
		return gov_sort;
	}
	public void setGov_sort(String gov_sort) {
		this.gov_sort = gov_sort;
	}
	
	
}
