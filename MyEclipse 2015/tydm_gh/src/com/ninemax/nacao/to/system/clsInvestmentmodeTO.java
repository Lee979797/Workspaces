package com.ninemax.nacao.to.system;

import java.io.Serializable;

public class clsInvestmentmodeTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4998205003922120245L;
	private String id;
	private String mannerName;
	private String orderBy;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMannerName() {
		return mannerName;
	}
	public void setMannerName(String mannerName) {
		this.mannerName = mannerName;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
}
