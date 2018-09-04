package com.ninemax.nacao.to.system;

import java.io.Serializable;

public class clsUserGroupTO implements Serializable {
	
	private String strUserGroup_id;
	private String strUserGroup_name;
	private String strUserGroup_memo;
	private String strUserGroup_status;
	private String strUserGroup_kind;
	
	public String getUserGroup_id() {
		return strUserGroup_id;
	}
	public void setUserGroup_id(String strUserGroup_id) {
		this.strUserGroup_id = strUserGroup_id;
	}
	public String getUserGroup_memo() {
		return strUserGroup_memo;
	}
	public void setUserGroup_memo(String strUserGroup_memo) {
		this.strUserGroup_memo = strUserGroup_memo;
	}
	public String getUserGroup_name() {
		return strUserGroup_name;
	}
	public void setUserGroup_name(String strUserGroup_name) {
		this.strUserGroup_name = strUserGroup_name;
	}
	public String getUserGroup_status() {
		return strUserGroup_status;
	}
	public void setUserGroup_status(String strUserGroup_status) {
		this.strUserGroup_status = strUserGroup_status;
	}
	public String getUserGroup_kind() {
		return strUserGroup_kind;
	}
	public void setUserGroup_kind(String strUserGroup_kind) {
		this.strUserGroup_kind = strUserGroup_kind;
	}
	
	

}
