package com.ninemax.nacao.to.system;

import java.io.Serializable;

public class clsPoliticallandscapeTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8523065599727640096L;
	private String id;
	private String faceName;
	private String orderBy;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFaceName() {
		return faceName;
	}
	public void setFaceName(String faceName) {
		this.faceName = faceName;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	

}
