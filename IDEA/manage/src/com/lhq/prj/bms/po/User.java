package com.lhq.prj.bms.po;

import java.io.Serializable;

/**
 * User.java Create on 2008-9-18 ����09:32:48
 * 
 * �û���
 * 
 * Copyright (c) 2008 by MTA.
 * 
 * @author �����
 * @version 1.0
 */
@SuppressWarnings("serial")
public class User implements Serializable {

	public User() {
	}

	/** �û�id */
	private Integer userId;

	/** Ա������ */
	private String emplName;

	/** Ա������ */
	private String emplNo;

	/** �ƶ��绰 */
	private String mobilePhone;
	
	private String email;

	/** �Ա� */
	private String sex;

	/** ���� */
	private Integer age;

	/** �û��� */
	private String userName;
	
	/** ���� */
	private String password;

	/** �����ֹ�˾��id */
	private Integer centerId;

	/** �����ֹ�˾ */
	private String centerName;
	
	/** �����ֹ�˾ */
	private String centerCode;


	/** �������ŵ�id */
	private Integer bzjgId;

	/** �������� */
	private String bzjgName;
	
	/** �������� */
	private String bzjgCode;

	/** ְ��id */
	private String dutyId;

	/** ְ����� */
	private String dutyName;

	/** �Ƿ����Ա */
	private boolean manager;

	/** ��ע */
	private String remark;
	
	private String zsbhPre;
	private String zsbhPre_fb;
	private String icPort;
	private Integer useUpPageSize;
	private Integer useDownPageSize;
	private Integer useFullPageSize;
	
	private String qxCode;
	private String ywqx;
	
	private String luckPwd;
	
	private String veiwHelpPage;
	

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getCenterId() {
		return centerId;
	}

	public void setCenterId(Integer centerId) {
		this.centerId = centerId;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public Integer getBzjgId() {
		return bzjgId;
	}

	public void setBzjgId(Integer bzjgId) {
		this.bzjgId = bzjgId;
	}

	public String getBzjgName() {
		return bzjgName;
	}

	public void setBzjgName(String bzjgName) {
		this.bzjgName = bzjgName;
	}

	public String getDutyId() {
		return dutyId;
	}

	public void setDutyId(String dutyId) {
		this.dutyId = dutyId;
	}

	public String getDutyName() {
		return dutyName;
	}

	public void setDutyName(String dutyName) {
		this.dutyName = dutyName;
	}

	public String getEmplName() {
		return emplName;
	}

	public void setEmplName(String emplName) {
		this.emplName = emplName;
	}

	public String getEmplNo() {
		return emplNo;
	}

	public void setEmplNo(String emplNo) {
		this.emplNo = emplNo;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}

	public boolean isManager() {
		return manager;
	}

	public void setManager(boolean manager) {
		this.manager = manager;
	}

	public void setCenterCode(String centerCode) {
		this.centerCode = centerCode;
	}

	public String getCenterCode() {
		return centerCode;
	}

	public void setBzjgCode(String bzjgCode) {
		this.bzjgCode = bzjgCode;
	}

	public String getBzjgCode() {
		return bzjgCode;
	}

	public void setZsbhPre(String zsbhPre) {
		this.zsbhPre = zsbhPre;
	}

	public String getZsbhPre() {
		return zsbhPre;
	}

	public void setZsbhPre_fb(String zsbhPre_fb) {
		this.zsbhPre_fb = zsbhPre_fb;
	}

	public String getZsbhPre_fb() {
		return zsbhPre_fb;
	}

	public void setIcPort(String icPort) {
		this.icPort = icPort;
	}

	public String getIcPort() {
		return icPort;
	}

	public void setUseUpPageSize(Integer useUpPageSize) {
		this.useUpPageSize = useUpPageSize;
	}

	public Integer getUseUpPageSize() {
		return useUpPageSize;
	}

	public void setUseDownPageSize(Integer useDownPageSize) {
		this.useDownPageSize = useDownPageSize;
	}

	public Integer getUseDownPageSize() {
		return useDownPageSize;
	}

	public void setUseFullPageSize(Integer useFullPageSize) {
		this.useFullPageSize = useFullPageSize;
	}

	public Integer getUseFullPageSize() {
		return useFullPageSize;
	}

	public void setLuckPwd(String luckPwd) {
		this.luckPwd = luckPwd;
	}

	public String getLuckPwd() {
		return luckPwd;
	}

	public void setVeiwHelpPage(String veiwHelpPage) {
		this.veiwHelpPage = veiwHelpPage;
	}

	public String getVeiwHelpPage() {
		return veiwHelpPage;
	}

	public String getQxCode() {
		return qxCode;
	}

	public void setQxCode(String qxCode) {
		this.qxCode = qxCode;
	}

	public String getYwqx() {
		return ywqx;
	}

	public void setYwqx(String ywqx) {
		this.ywqx = ywqx;
	}

}
