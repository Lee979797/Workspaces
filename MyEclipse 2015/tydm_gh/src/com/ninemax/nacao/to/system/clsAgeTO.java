package com.ninemax.nacao.to.system;

import java.io.Serializable;

public class clsAgeTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1348908288742886142L;
	private String id;
	private String age;
	private String orderBy;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}


}
