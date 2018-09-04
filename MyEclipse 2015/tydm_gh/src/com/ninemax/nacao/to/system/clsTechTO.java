package com.ninemax.nacao.to.system;

import java.io.Serializable;

public class clsTechTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6012674144401596076L;
	private String id;
	private String techName;
	private String orderBy;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTechName() {
		return techName;
	}
	public void setTechName(String techName) {
		this.techName = techName;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
	
	
	
}
