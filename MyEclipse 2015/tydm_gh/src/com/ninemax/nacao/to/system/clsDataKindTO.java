package com.ninemax.nacao.to.system;

import java.io.Serializable;

public class clsDataKindTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2858453194996001643L;
	private String id ;
	private String datakind_name;
	private String datakind_islast;
	private String datakind_depth;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
	     this.id=id;
	}
	public String getDataKindName(){
		return datakind_name;
	}
	public void setDataKindName(String datakindname){
		this.datakind_name=datakindname;
	}
	public String getDataKindIsLast(){
		return datakind_islast;
	}
	public void setDataKindIsLast(String datakindislast ){
		this.datakind_islast=datakindislast;
	}
	public String getDataKindDepth(){
		return datakind_depth;
	}
	public void setDataKindDepth(String datakinddepth) {
		this.datakind_depth=datakinddepth;
	}
}
