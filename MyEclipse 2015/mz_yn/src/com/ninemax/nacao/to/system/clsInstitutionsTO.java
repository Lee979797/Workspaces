package com.ninemax.nacao.to.system;

import java.io.Serializable;

public class clsInstitutionsTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5600062505739109586L;
	private String id;
	private String sortName;
	private String orderBy;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getSortName() {
		return sortName;
	}
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}


}
