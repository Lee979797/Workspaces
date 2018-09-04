package com.ninemax.nacao.to.system;

import java.io.Serializable;

public class clsUsermetaTO implements Serializable{
	
	String role_id;
	String egov_id;
	String meta_id;
	public String getRole_id() {
		return role_id;
	}
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	public String getEgov_id() {
		return egov_id;
	}
	public void setEgov_id(String egov_id) {
		this.egov_id = egov_id;
	}
	public String getMeta_id() {
		return meta_id;
	}
	public void setMeta_id(String meta_id) {
		this.meta_id = meta_id;
	}
	
	

}
