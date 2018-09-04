package com.ninemax.nacao.to.system;

import java.io.Serializable;

public class clsWorkTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8775020557556240871L;
	private String id;
	private String workName;
	private String orderBy;
	
	
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getWorkName() {
		return workName;
	}
	public void setWorkName(String workName) {
		this.workName = workName;
	}
	
	
	
	

}
