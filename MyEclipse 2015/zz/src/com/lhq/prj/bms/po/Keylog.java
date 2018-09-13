package com.lhq.prj.bms.po;

import java.io.Serializable;


/**
 * Tjgdm.java Create on 2012-5-14
 * 
 * 新办申请
 * 
 * Copyright (c) 2012 by YQ.
 * @author 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Keylog implements Serializable {

	private Integer LogID;
	private String PrimaryTableName;
	private String ProduceDateTime;
	private String PrimaryKeyNumber;
	private String Wordtrack;

	
	/** 当前关联的借阅记录id */
	//private Integer logId;


	public Keylog() {
	}
	
	public Keylog(Integer LogID) {
		this.LogID = LogID;
	}
	
	public Integer getLogID() {
		return LogID;
	}
	public void setLogID(Integer LogID) {
		this.LogID = LogID;
	}
	
	
	public String getPrimaryTableName() {
		return PrimaryTableName;
	}
	public void setPrimaryTableName(String PrimaryTableName) {
		this.PrimaryTableName = PrimaryTableName;
	}
	
	public String getProduceDateTime() {
		return ProduceDateTime;
	}
	public void setProduceDateTime(String ProduceDateTime) {
		this.ProduceDateTime = ProduceDateTime;
	}

	public String getPrimaryKeyNumber() {
		return PrimaryKeyNumber;
	}
	public void setPrimaryKeyNumber(String PrimaryKeyNumber) {
		this.PrimaryKeyNumber = PrimaryKeyNumber;
	}

	public String getWordtrack() {
		return Wordtrack;
	}
	public void setWordtrack(String Wordtrack) {
		this.Wordtrack = Wordtrack;
	}
}
