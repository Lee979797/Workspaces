package com.ninemax.nacao.to.system;

import java.io.Serializable;

public class clsOrganizersTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2794812659610844392L;
	private String id;
	private String organizers;
	private String orderBy;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getOrganizers() {
		return organizers;
	}
	public void setOrganizers(String organizers) {
		this.organizers = organizers;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}


}
