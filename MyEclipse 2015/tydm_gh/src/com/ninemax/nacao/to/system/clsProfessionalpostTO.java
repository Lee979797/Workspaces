package com.ninemax.nacao.to.system;

import java.io.Serializable;

public class clsProfessionalpostTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5786862776778787078L;
	private String id;
	private String postName;
	private String orderBy;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}


}
