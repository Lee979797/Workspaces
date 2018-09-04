package com.ninemax.nacao.to.system;

import java.io.Serializable;

public class clsAreaTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4869602381753984847L;
	private String id;
	private String area_name;
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
	public String getArea_name() {
		return area_name;
	}
	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}


}
