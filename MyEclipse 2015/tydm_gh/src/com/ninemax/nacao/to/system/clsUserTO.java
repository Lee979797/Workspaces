package com.ninemax.nacao.to.system;

import java.io.Serializable;

public class clsUserTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2610425790671295958L;
	private String user_id;
	private String user_name;
	private String user_password;
	private String user_chineseName;
	private String userGroup_id;
	private String lastLogin;
	private String regDate;
	private String user_branch;
	private String user_ip;
	private String user_kind;
	private String User_Status;
	
	
	public String getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getUser_branch() {
		return user_branch;
	}
	public void setUser_branch(String user_branch) {
		this.user_branch = user_branch;
	}
	public String getUser_chineseName() {
		return user_chineseName;
	}
	public void setUser_chineseName(String user_chineseName) {
		this.user_chineseName = user_chineseName;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_ip() {
		return user_ip;
	}
	public void setUser_ip(String user_ip) {
		this.user_ip = user_ip;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUserGroup_id() {
		return userGroup_id;
	}
	public void setUserGroup_id(String userGroup_id) {
		this.userGroup_id = userGroup_id;
	}
	public String getUser_kind() {
		return user_kind;
	}
	public void setUser_kind(String user_kind) {
		this.user_kind = user_kind;
	}
	public String getUser_Status() {
		return User_Status;
	}
	public void setUser_Status(String user_Status) {
		User_Status = user_Status;
	}
	
	

}
