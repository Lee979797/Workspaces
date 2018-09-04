package com.ninemax.nacao.to.system;

import java.io.Serializable;

public class clsUserLevelTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2193143224667982726L;
	private String id;
	private String userLevelName;
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
	public String getUserLevelName() {
		return userLevelName;
	}
	public void setUserLevelName(String userLevelName) {
		this.userLevelName = userLevelName;
	}


}
