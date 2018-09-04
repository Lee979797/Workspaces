package com.ninemax.nacao.to.system;

import java.io.Serializable;

public class clsRegistrationtypeTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2322089269275060561L;
	private String id;
	private String typeName;
	private String orderBy;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}


}
