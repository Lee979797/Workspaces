package com.ninemax.nacao.to.system;

import java.io.Serializable;

public class clsSysUserTO implements Serializable{
	
	private String user_id;
	private String user_name;
	private String user_password;
	private String user_chineseName;
	private String role_id;
	private String userGroup_id;
	private String lastLogin;
	private String regDate;
	private String user_branch;
	private String user_ip;
	private String memo;
	private String item1;//website_id
	private String item2;//标识是注册用户进后台
	
	private String png;
	
	public String getItem1(){
		return item1;
	}
	public void setItem1(String item1) {
		this.item1 = item1;
	}
	public String getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getRole_id() {
		return role_id;
	}
	public void setRole_id(String role_id) {
		this.role_id = role_id;
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
	public String getPng() {
		return png;
	}
	public void setPng(String png) {
		this.png = png;
	}
	public String getItem2() {
		return item2;
	}
	public void setItem2(String item2) {
		this.item2 = item2;
	}
	
	

}
