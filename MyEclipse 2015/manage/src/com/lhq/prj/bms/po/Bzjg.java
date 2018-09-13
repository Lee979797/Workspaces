/*
 * @(#)Bzjg.java 2008-9-16 
 *
 * Copyright 2008 MTA, Inc. All rights reserved.
 */

package com.lhq.prj.bms.po;

import java.io.Serializable;

/**
 * ������
 * 
 * @author lhq
 * @version 1.0 ����04:49:30
 */
@SuppressWarnings("serial")
public class Bzjg implements Serializable {
	public Bzjg() {
		super();
	}

	/** ����ID���Զ���ֵ�� */
	private Integer bzjgId;

	/** ������� not null 50 */
	private String bzjgName;
	
	/** ������� not null 50 */
	private String bzjgCode;
	
	/** ������� not null 50 */
	private String bzjgJcName;

	/** �����ֹ�˾id not null */
	private Integer centerId;

	/** �����ֹ�˾��ƣ������ֶΣ�not null 50 */
	private String centerName;
	
	/** �����ֹ�˾��ƣ������ֶΣ�not null 50 */
	private String centerCode;
	
	/** (����)��ַ 200 */
	private String address;

	/** (����)�绰 20 */
	private String tellPhone;

	/** (����)���������� 20 */
	private String leader;

	/** (����)�����˵绰 20 */
	private String mobilePhone;

	/** ��ע 200 */
	private String remark;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public void setBzjgJcName(String bzjgJcName) {
		this.bzjgJcName = bzjgJcName;
	}

	public String getBzjgJcName() {
		return bzjgJcName;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getTellPhone() {
		return tellPhone;
	}

	public void setTellPhone(String tellPhone) {
		this.tellPhone = tellPhone;
	}

	public void setBzjgCode(String bzjgCode) {
		this.bzjgCode = bzjgCode;
	}

	public String getBzjgCode() {
		return bzjgCode;
	}

	public void setCenterCode(String centerCode) {
		this.centerCode = centerCode;
	}

	public String getCenterCode() {
		return centerCode;
	}
}
