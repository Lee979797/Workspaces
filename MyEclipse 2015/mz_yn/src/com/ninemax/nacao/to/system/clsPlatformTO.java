package com.ninemax.nacao.to.system;

import java.io.Serializable;

public class clsPlatformTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5502976559208468425L;
	private String id ;
	private String platform_name;
	private String platform_islast;
	private String platform_depth;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
	     this.id=id;
	}
	public String getPlatformName(){
		return platform_name;
	}
	public void setPlatformName(String platformname){
		this.platform_name=platformname;
	}
	public String getPlatformIsLast(){
		return platform_islast;
	}
	public void setPlatformIsLast(String platformislast ){
		this.platform_islast=platformislast;
	}
	public String getPlatformDepth(){
		return platform_depth;
	}
	public void setPlatformDepth(String platformdepth) {
		this.platform_depth=platformdepth;
	}
}
