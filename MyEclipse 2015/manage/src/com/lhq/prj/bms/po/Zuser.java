package com.lhq.prj.bms.po;

import java.io.Serializable;

/**
 * Zuser.java Create on 2012-5-5
 * 
 * 用户类
 * 
 * Copyright (c) 2008 by YQ.
 * @author 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Zuser implements Serializable {

	private Integer userid;
	private String xzqhCode;
	private String xzqhName;
	private String orgZch;
	private Integer orgid;
	private String orgName;
	private String orgCode;
	private String orgType;
	private String pzjgmc;
	private String pzjgdm;
	private String userName;
	private String userPwd;
	private String name;
	private String mPhone;
	private String tel;
	private String email;
	private String address;
	private String postalcode;
	private String sex;
	private String zjlx;
	private String sfzHao;
	private String msgType;
	private String state;
	private String note;

	
	
	public Zuser() {
	}
	
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	
	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
	
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSfzHao() {
		return sfzHao;
	}
	public void setSfzHao(String sfzHao) {
		this.sfzHao = sfzHao;
	}
	
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setXzqhName(String xzqhName) {
		this.xzqhName = xzqhName;
	}

	public String getXzqhName() {
		return xzqhName;
	}

	public void setXzqhCode(String xzqhCode) {
		this.xzqhCode = xzqhCode;
	}

	public String getXzqhCode() {
		return xzqhCode;
	}

	public void setOrgZch(String orgZch) {
		this.orgZch = orgZch;
	}

	public String getOrgZch() {
		return orgZch;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setOrgid(Integer orgid) {
		this.orgid = orgid;
	}

	public Integer getOrgid() {
		return orgid;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setZjlx(String zjlx) {
		this.zjlx = zjlx;
	}

	public String getZjlx() {
		return zjlx;
	}

	public void setPzjgmc(String pzjgmc) {
		this.pzjgmc = pzjgmc;
	}

	public String getPzjgmc() {
		return pzjgmc;
	}

	public void setmPhone(String mPhone) {
		this.mPhone = mPhone;
	}

	public String getmPhone() {
		return mPhone;
	}

	public void setPzjgdm(String pzjgdm) {
		this.pzjgdm = pzjgdm;
	}

	public String getPzjgdm() {
		return pzjgdm;
	}
}
