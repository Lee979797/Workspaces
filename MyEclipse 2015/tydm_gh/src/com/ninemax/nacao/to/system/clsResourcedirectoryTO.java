package com.ninemax.nacao.to.system;

import java.io.Serializable;

public class clsResourcedirectoryTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7006318871424661744L;
	private String id;
	private String directory;
	private String orderBy;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getDirectory() {
		return directory;
	}
	public void setDirectory(String directory) {
		this.directory = directory;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}


}
