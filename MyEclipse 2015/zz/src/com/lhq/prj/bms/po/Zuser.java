package com.lhq.prj.bms.po;

import java.io.Serializable;

/**
 * Zuser.java Create on 2012-5-5
 * 
 * 用户类
 * 
 * Copyright (c) 2012 by YQ.
 * @author 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Zuser implements Serializable {

	
	public Zuser() {
	}

	/** 用户id */
	private Integer userid;
	/** 行政区划名称 */
	private String xzqhName;
	/** 行政区划代码 */
	private String xzqhCode;
	/** 注册号 */
	private String orgZch;
	/** 机构ID */
	private Integer orgid;
	/** 机构姓名 */
	private String orgName;
	/** 机构 编码 */
	private String orgCode;
	/** 机构 类型 */
	private String orgType;
	/** 批准机构 名称 */
	private String pzjgmc;
	/** 批准机构代码型 */
	private String pzjgdm;
	
	private String bzjgdm;
	/** 用户名称 */
	private String userName;
	/** 用户密码 */
	private String userPwd;
	/**姓名*/
	private String name;
	/** 手机 */
	private String mPhone;
	/** 电话 */
	private String tel;
	/** 电子邮件*/
	private String email;
	/** 联系地址*/
	private String address;
	/** 邮政编码*/
	private String postalcode;
	/** 性别 */
	private String sex;
	/** 证件类型*/
	private String zjlx;
	/** 身份证号码*/
	private String sfzHao;
	/** 通知信息方式 */
	private Integer msgType;
	/** 用户状态 */
	private String state;
	/** 备注 */
	private String note;
	
	

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Zuser(Integer userid) {
		this.userid = userid;
	}
	
	public Integer getZuserId() {
		return userid;
	}

	public void setZuserId(Integer userid) {
		this.userid = userid;
	}

	public Integer getOrgid() {
		return orgid;
	}

	public void setOrgid(Integer orgid) {
		this.orgid = orgid;
	}
	
	
	public String getXzqhCode() {
		return xzqhCode;
	}

	public void setXzqhCode(String xzqhCode) {
		this.xzqhCode = xzqhCode;
	}
	
	public String getXzqhName() {
		return xzqhName;
	}

	public void setXzqhName(String xzqhName) {
		this.xzqhName = xzqhName;
	}
	
	
	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	
	public String getOrgZch() {
		return orgZch;
	}

	public void setOrgZch(String orgZch) {
		this.orgZch = orgZch;
	}
	
	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	
	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
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
	
	public String getMPhone() {
		return mPhone;
	}
	public void setMPhone(String mPhone) {
		this.mPhone = mPhone;
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
    
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
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
	
	public Integer getMsgType() {
		return msgType;
	}
	public void setMsgType(Integer msgType) {
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

	public void setPzjgdm(String pzjgdm) {
		this.pzjgdm = pzjgdm;
	}

	public String getPzjgdm() {
		return pzjgdm;
	}

	public String getBzjgdm() {
		return bzjgdm;
	}

	public void setBzjgdm(String bzjgdm) {
		this.bzjgdm = bzjgdm;
	}

	@Override
	public String toString() {
		return "Zuser [userid=" + userid + ", xzqhName=" + xzqhName
				+ ", xzqhCode=" + xzqhCode + ", orgZch=" + orgZch + ", orgid="
				+ orgid + ", orgName=" + orgName + ", orgCode=" + orgCode
				+ ", orgType=" + orgType + ", pzjgmc=" + pzjgmc + ", pzjgdm="
				+ pzjgdm + ", bzjgdm=" + bzjgdm + ", userName=" + userName
				+ ", userPwd=" + userPwd + ", name=" + name + ", mPhone="
				+ mPhone + ", tel=" + tel + ", email=" + email + ", address="
				+ address + ", postalcode=" + postalcode + ", sex=" + sex
				+ ", zjlx=" + zjlx + ", sfzHao=" + sfzHao + ", msgType="
				+ msgType + ", state=" + state + ", note=" + note + "]";
	}

}
