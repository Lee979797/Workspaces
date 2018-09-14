package com.lhq.prj.bms.po;

import java.io.Serializable;

/**
 * DictDetail.java Create on 2008-9-21 ����04:21:51
 * 
 * ����
 * 
 * Copyright (c) 2008 by MTA.
 * 
 * @author �����
 * @version 1.0
 */
@SuppressWarnings("serial")
public class DictDetail implements Serializable {

	/** ����id */
	private Integer categoryId;

	/** ������� */
	private String categoryName;
	
	private String  categoryCode;

	/** ������Ŀid */
	private Integer subjectId;

	/** ������Ŀ��� */
	private String subjectName;
	
	/** ��ע */
	private String remark;

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getCategoryCode() {
		return categoryCode;
	}
}
