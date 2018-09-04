package com.ninemax.nacao.to.system;

import java.io.Serializable;

public class clsEmployeesTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1751257222176715989L;
	private String id;
	private String employees;
	private String orderBy;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmployees() {
		return employees;
	}
	public void setEmployees(String employees) {
		this.employees = employees;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
}
