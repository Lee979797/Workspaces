package com.lhq.prj.bms.po;

import java.io.Serializable;

/**
 * Func.java Create on 2008-9-18 ����08:02:11
 * 
 * ְ��
 * 
 * Copyright (c) 2012 by YQ.
 * 
 * @author �����
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Func implements Serializable {

	public Func() {
	}

	public Func(Integer funcId, String funcName,String remark) {
		this.funcId = funcId;
		this.funcName = funcName;
		this.remark = remark;
	}

	/** ְ��id */
	private Integer funcId;

	/** ְ����� */
	private String funcCode;
	
	/** ְ����� */
	private String funcName;
	
	/** ְ����� */
	private String parentOrderid;
	
	/** ְ����� */
	private String parentName;
	
	/** ְ����� */
	private String parentCode;
	
	/** ְ����� */
	private boolean parentFlag;

	/** ��ע */
	private String remark;

	public Integer getFuncId() {
		return funcId;
	}

	public void setFuncCode(String funcCode) {
		this.funcCode = funcCode;
	}

	public String getFuncCode() {
		return funcCode;
	}

	public void setFuncId(Integer funcId) {
		this.funcId = funcId;
	}

	public String getFuncName() {
		return funcName;
	}

	public void setFuncName(String funcName) {
		this.funcName = funcName;
	}

	public void setParentOrderid(String parentOrderid) {
		this.parentOrderid = parentOrderid;
	}

	public String getParentOrderid() {
		return parentOrderid;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentFlag(boolean parentFlag) {
		this.parentFlag = parentFlag;
	}

	public boolean getParentFlag() {
		return parentFlag;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
