package com.ninemax.nacao.to.system;

import java.io.Serializable;

public class clsExpertCategoryTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5447190084651779673L;
	private String id;
	private String category_name;
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
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}


}
