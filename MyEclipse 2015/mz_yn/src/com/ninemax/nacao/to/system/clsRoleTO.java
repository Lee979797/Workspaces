package com.ninemax.nacao.to.system;

import java.io.Serializable;

public class clsRoleTO implements Serializable{
	
	String strRole_id;
	String strRole_name;
	String strRole_kind;
	String strRole_memo;
    String strRole_status;
	
    private static final long serialVersionUID = 100009l;
	public String getRole_id() {
		return strRole_id;
	}
	public void setRole_id(String strRole_id) {
		this.strRole_id = strRole_id;
	}
	public String getRole_kind() {
		return strRole_kind;
	}
	public void setRole_kind(String strRole_kind) {
		this.strRole_kind = strRole_kind;
	}
	public String getRole_memo() {
		return strRole_memo;
	}
	public void setRole_memo(String strRole_memo) {
		this.strRole_memo = strRole_memo;
	}
	public String getRole_name() {
		return strRole_name;
	}
	public void setRole_name(String strRole_name) {
		this.strRole_name = strRole_name;
	}
	public String getRole_status() {
		return strRole_status;
	}
	public void setRole_status(String strRole_status) {
		this.strRole_status = strRole_status;
	}
	
	

}
