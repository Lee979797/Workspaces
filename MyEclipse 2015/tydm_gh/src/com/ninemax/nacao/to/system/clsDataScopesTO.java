package com.ninemax.nacao.to.system;

import java.io.Serializable;

public class clsDataScopesTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1403766365815290171L;
	private String id ;
	private String datascopes_name;
	private String datascopes_islast;
	private String datascopes_depth;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
	     this.id=id;
	}
	public String getDataScopesName(){
		return datascopes_name;
	}
	public void setDataScopesName(String datascopesname){
		this.datascopes_name=datascopesname;
	}
	public String getDataScopesIsLast(){
		return datascopes_islast;
	}
	public void setDataScopesIsLast(String datascopesislast ){
		this.datascopes_islast=datascopesislast;
	}
	public String getDataScopesDepth(){
		return datascopes_depth;
	}
	public void setDataScopesDepth(String datascopesdepth) {
		this.datascopes_depth=datascopesdepth;
	}
}
