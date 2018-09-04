package com.ninemax.nacao.to.system;

import java.io.Serializable;

public class clsUserLogin_logTO implements Serializable {
	
	private String operId ;
	private String operDate;
	private String user_id;
	private String user_name;
	private String user_kind;
	private String user_ip;
	
	private static final long serialVersionUID = 100006l;
	public String getOperDate() {
		return operDate;
	}
	public void setOperDate(String operDate) {
		this.operDate = operDate;
	}
	public String getOperId() {
		return operId;
	}
	public void setOperId(String operId) {
		this.operId = operId;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_kind() {
		return user_kind;
	}
	public void setUser_kind(String user_kind) {
		this.user_kind = user_kind;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_ip() {
		return user_ip;
	}
	public void setUser_ip(String user_ip) {
		this.user_ip = user_ip;
	}
	
	

}
