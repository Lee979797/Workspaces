package com.ninemax.nacao.to.system;

import java.io.Serializable;

public class clsEnterpriseKindTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3566876942308497810L;
	private String id ;
	private String enterprisekind_name;
	private String enterprisekind_islast;
	private String enterprisekind_depth;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
	     this.id=id;
	}
	public String getEnterpriseKindName(){
		return enterprisekind_name;
	}
	public void setEnterpriseKindName(String enterprisekindname){
		this.enterprisekind_name=enterprisekindname;
	}
	public String geEnterpriseKindIsLast(){
		return enterprisekind_islast;
	}
	public void setEnterpriseKindIsLast(String enterprisekindislast ){
		this.enterprisekind_islast=enterprisekindislast;
	}
	public String getEnterpriseKindDepth(){
		return enterprisekind_depth;
	}
	public void setEnterpriseKindDepth(String enterprisekinddepth) {
		this.enterprisekind_depth=enterprisekinddepth;
	}
}
