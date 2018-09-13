package com.lhq.prj.bms.po;

import java.io.Serializable;

/**
 * DictIndex.java Create on 2008-9-21 ����03:42:14
 * 
 * ��Ŀ��
 * 
 * Copyright (c) 2008 by MTA.
 * 
 * @author �����
 * @version 1.0
 */
@SuppressWarnings("serial")
public class DictIndex implements Serializable {

	/** ��Ŀid */
	private Integer subjectId;

	/** ��Ŀ��� */
	private String subjectName;

	/** ��ע */
	private String remark;

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

}
