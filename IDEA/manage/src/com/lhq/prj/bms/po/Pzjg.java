package com.lhq.prj.bms.po;

import java.io.Serializable;

/**
 * Pzjg.java Create on 2008-9-18 下午08:02:11
 * 
 * 职务
 * 
 * Copyright (c) 2008 by MTA.
 * 
 * @author 廖瀚卿
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Pzjg implements Serializable {

	public Pzjg() {
	}

	public Pzjg(Integer pzjgid,String pzjgdm, String pzjgmc, String bzjgdm, String note) {
		this.pzjgid = pzjgid;
		this.pzjgdm = pzjgdm;
		this.pzjgmc = pzjgmc;
		this.bzjgdm = bzjgdm;
		this.note=note;
	}

	private Integer pzjgid;

	private String pzjgdm;

	private String pzjgmc;

	private String bzjgdm;
	
	private String note;

	
	public Integer getPzjgid() {
		return pzjgid;
	}
	
	public void setPzjgid(Integer pzjgid) {
		this.pzjgid = pzjgid;
	}
	

	public String getPzjgmc() {
		return pzjgmc;
	}

	public void setPzjgmc(String pzjgmc) {
		this.pzjgmc = pzjgmc;
	}

	public String getPzjgdm() {
		return pzjgdm;
	}

	public void setPzjgdm(String pzjgdm) {
		this.pzjgdm = pzjgdm;
	}

	public void setBzjgdm(String bzjgdm) {
		this.bzjgdm = bzjgdm;
	}

	public String getBzjgdm() {
		return bzjgdm;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getNote() {
		return note;
	}
}
