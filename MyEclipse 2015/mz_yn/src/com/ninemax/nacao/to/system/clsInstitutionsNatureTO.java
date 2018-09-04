package com.ninemax.nacao.to.system;

import java.io.Serializable;

public class clsInstitutionsNatureTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8732088205198562217L;
	private String id;
	private String nature_name;
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
	public String getNature_name() {
		return nature_name;
	}
	public void setNature_name(String nature_name) {
		this.nature_name = nature_name;
	}


}
