package com.ninemax.nacao.to.system;

import java.io.Serializable;

public class clsAuthorizeTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6043521069106351437L;
	private String id;
	private String authorizeName;
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
	public String getAuthorizeName() {
		return authorizeName;
	}
	public void setAuthorizeName(String authorizeName) {
		this.authorizeName = authorizeName;
	}


}
