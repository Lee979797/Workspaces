/*
 * @(#)Ywset.java 2008-9-16 
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
public class Ywset implements Serializable {
	public Ywset() {
		super();
	}
	
	private Integer ywsetId;

	private String ywlx;
	
	private String ywlxdm;
	
	private String bzjgmc;
	
	private String bzjgdm;
	
	private String flag;

	private String note;

	
	public void setYwsetId(Integer ywsetId) {
		this.ywsetId = ywsetId;
	}

	public Integer getYwsetId() {
		return ywsetId;
	}

	public void setYwlx(String ywlx) {
		this.ywlx = ywlx;
	}

	public String getYwlx() {
		return ywlx;
	}
	
	public void setYwlxdm(String ywlxdm) {
		this.ywlxdm = ywlxdm;
	}

	public String getYwlxdm() {
		return ywlxdm;
	}
	
	public void setBzjgmc(String bzjgmc) {
		this.bzjgmc = bzjgmc;
	}

	public String getBzjgmc() {
		return bzjgmc;
	}

	public void setBzjgdm(String bzjgdm) {
		this.bzjgdm = bzjgdm;
	}

	public String getBzjgdm() {
		return bzjgdm;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getFlag() {
		return flag;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getNote() {
		return note;
	}

}
