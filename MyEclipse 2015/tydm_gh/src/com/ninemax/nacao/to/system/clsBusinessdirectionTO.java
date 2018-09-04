package com.ninemax.nacao.to.system;

import java.io.Serializable;

public class clsBusinessdirectionTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2488876129667722865L;
	private String id;
	private String directionName;
	private String orderBy;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDirectionName() {
		return directionName;
	}
	public void setDirectionName(String directionName) {
		this.directionName = directionName;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
}
