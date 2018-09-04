package com.ninemax.nacao.to.system;

import java.io.Serializable;

public class clsBusinesstypeTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4634344072441492379L;
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
