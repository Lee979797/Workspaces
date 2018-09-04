package com.ninemax.nacao.to.system;

import java.io.Serializable;

public class clsNationTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5463110317205016892L;
	private String id;
	private String nationName;
	private String orderBy;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNationName() {
		return nationName;
	}
	public void setNationName(String nationName) {
		this.nationName = nationName;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
}
