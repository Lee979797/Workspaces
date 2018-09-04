package com.ninemax.nacao.to.system;

import java.io.Serializable;

public class clsNationalityTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1306232817934308977L;
	private String id;
	private String nationalityName;
	private String orderBy;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNationalityName() {
		return nationalityName;
	}
	public void setNationalityName(String nationalityName) {
		this.nationalityName = nationalityName;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
}
