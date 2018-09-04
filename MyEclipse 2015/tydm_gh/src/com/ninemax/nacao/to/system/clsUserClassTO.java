package com.ninemax.nacao.to.system;

import java.io.Serializable;

public class clsUserClassTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2045457389374200284L;
	private String id;
	private String userClassName;
	private String orderBy;
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
	public String getUserClassName() {
		return userClassName;
	}
	public void setUserClassName(String userClassName) {
		this.userClassName = userClassName;
	}


}
