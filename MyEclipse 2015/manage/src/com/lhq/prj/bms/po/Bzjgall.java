package com.lhq.prj.bms.po;

import java.io.Serializable;

/**
 * Bzjgall.java Create on 2008-9-18 下午08:02:11
 * 
 * 职务
 * 
 * Copyright (c) 2008 by MTA.
 * 
 * @author 廖瀚卿
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Bzjgall implements Serializable {

	public Bzjgall() {
	}

	public Bzjgall(Integer bzjgid,String bzjgdm, String bzjgmc, String superdm, String note) {
		this.bzjgid = bzjgid;
		this.bzjgdm = bzjgdm;
		this.bzjgmc = bzjgmc;
		this.superdm = superdm;
		this.note=note;
	}

	private Integer bzjgid;

	private String bzjgdm;

	private String bzjgmc;

	private String superdm;
	
	private String note;

	
	public Integer getBzjgid() {
		return bzjgid;
	}
	
	public void setBzjgid(Integer bzjgid) {
		this.bzjgid = bzjgid;
	}
	

	public String getBzjgmc() {
		return bzjgmc;
	}

	public void setBzjgmc(String bzjgmc) {
		this.bzjgmc = bzjgmc;
	}

	public String getBzjgdm() {
		return bzjgdm;
	}

	public void setBzjgdm(String bzjgdm) {
		this.bzjgdm = bzjgdm;
	}

	public void setSuperdm(String superdm) {
		this.superdm = superdm;
	}

	public String getSuperdm() {
		return superdm;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getNote() {
		return note;
	}
}
