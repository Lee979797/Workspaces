/*
 * @(#)KeyLog.java 2008-9-16 
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
public class KeyLog implements Serializable {
	public KeyLog() {
		super();
	}

	private Integer logId;
	private String xzqhCode;
	private String PrimaryTableName;
	private Integer PrimaryKeyNumber;
	
	public void setXzqhCode(String xzqhCode) {
		this.xzqhCode = xzqhCode;
	}

	public String getXzqhCode() {
		return xzqhCode;
	}

	public void setPrimaryTableName(String primaryTableName) {
		PrimaryTableName = primaryTableName;
	}

	public String getPrimaryTableName() {
		return PrimaryTableName;
	}


	public void setLogId(Integer logId) {
		this.logId = logId;
	}

	public Integer getLogId() {
		return logId;
	}

	public void setPrimaryKeyNumber(Integer primaryKeyNumber) {
		PrimaryKeyNumber = primaryKeyNumber;
	}

	public Integer getPrimaryKeyNumber() {
		return PrimaryKeyNumber;
	}



	
	
}
