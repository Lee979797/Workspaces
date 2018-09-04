package com.ninemax.nacao.to.system;

import java.io.Serializable;

public class clsOwnershipTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1654583315733072433L;
	private String id;
	private String propertyName;
	private String orderBy;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}


}
