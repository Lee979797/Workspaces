package com.ninemax.nacao.to.system;

import java.io.Serializable;

public class clsEducationTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2390581711708390934L;
	private String id;
	private String educationName;
	private String orderBy;
	
	public String getEducationName() {
		return educationName;
	}
	public void setEducationName(String educationName) {
		this.educationName = educationName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
	

}
