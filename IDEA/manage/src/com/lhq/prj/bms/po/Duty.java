package com.lhq.prj.bms.po;

import java.io.Serializable;

/**
 * Duty.java Create on 2013-5-28 08:02:11
 * 
 * ְ��
 * 
 * Copyright (c) 2013 by YQ.
 * 
 * @author �����
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Duty implements Serializable {

	public Duty() {
	}

	public Duty(Integer dutyId, String dutyName,String funcCode,String funcName, String remark) {
		this.dutyId = dutyId;
		this.dutyName = dutyName;
		this.funcCode = funcCode;
		this.funcName=funcName;
		this.remark = remark;
	}

	/** ְ��id */
	private Integer dutyId;

	/** ְ����� */
	private String dutyName;
	
	/** ְ����� */
	private String funcCode;
	
	/** ְ����� */
	private String funcName;

	/** ��ע */
	private String remark;

	public Integer getDutyId() {
		return dutyId;
	}

	public void setDutyId(Integer dutyId) {
		this.dutyId = dutyId;
	}

	
	public String getDutyName() {
		return dutyName;
	}

	public void setDutyName(String dutyName) {
		this.dutyName = dutyName;
	}
	
	public String getFuncCode() {
		return funcCode;
	}

	public void setFuncCode(String funcCode) {
		this.funcCode = funcCode;
	}

	public void setFuncName(String funcName) {
		this.funcName = funcName;
	}

	public String getFuncName() {
		return funcName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
