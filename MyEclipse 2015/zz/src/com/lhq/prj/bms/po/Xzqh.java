package com.lhq.prj.bms.po;

import java.io.Serializable;

/**
 * Xzqh.java Create on 2008-9-18 下午08:02:11
 * 
 * 职务
 * 
 * Copyright (c) 2008 by MTA.
 * 
 * @author 廖瀚卿
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Xzqh implements Serializable {

	public Xzqh() {
	}

	public Xzqh(Integer xzqhId, String xzqhCode, String xzqhName,String xzqhNote) {
		this.xzqhId = xzqhId;
		this.xzqhCode = xzqhCode;
		this.xzqhName = xzqhName;
		this.xzqhNote = xzqhNote;
	}

	/** 职务id */
	private Integer xzqhId;

	/** 职务名称 */
	private String xzqhCode;

	/** 备注 */
	private String xzqhName;
	
	private String xzqhNote;

	public Integer getXzqhId() {
		return xzqhId;
	}

	public void setXzqhId(Integer xzqhId) {
		this.xzqhId = xzqhId;
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

	public void setXzqhNote(String xzqhNote) {
		this.xzqhNote = xzqhNote;
	}

	public String getXzqhNote() {
		return xzqhNote;
	}

}
