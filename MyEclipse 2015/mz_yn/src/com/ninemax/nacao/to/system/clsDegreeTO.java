package com.ninemax.nacao.to.system;

import java.io.Serializable;

public class clsDegreeTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5945397070726839549L;
	private String id;
	private String degreeName;
	private String orderBy;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDegreeName() {
		return degreeName;
	}
	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
}
