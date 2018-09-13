package com.lhq.prj.bms.po;

import java.io.Serializable;

/**
 * Hylx.java Create on 2008-9-18 下午08:02:11
 * 
 * 职务
 * 
 * Copyright (c) 2008 by MTA.
 * 
 * @author 廖瀚卿
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Hylx implements Serializable {

	public Hylx() {
	}

	public Hylx(Integer hylxid,String hylxdm, String hylxmc,String hylxdmOld, String hylxmcOld, String hylxdm1, String hylxmc1,String hylxdm2, String hylxmc2,String hylxdm3, String hylxmc3, String note) {
		this.hylxid = hylxid;
		this.hylxdm = hylxdm;
		this.hylxmc = hylxmc;
		this.setHylxdmOld(hylxdmOld);
		this.setHylxmcOld(hylxmcOld);
		this.hylxdm1 = hylxdm1;
		this.hylxmc1 = hylxmc1;
		this.hylxdm2 = hylxdm2;
		this.hylxmc2 = hylxmc2;
		this.hylxdm3 = hylxdm3;
		this.hylxmc3 = hylxmc3;
		this.note=note;
	}

	private Integer hylxid;

	private String hylxdm;

	private String hylxmc;
	
	private String hylxdmOld;

	private String hylxmcOld;
	
	private String hylxdm1;

	private String hylxmc1;
	
	private String hylxdm2;

	private String hylxmc2;
	
	private String hylxdm3;

	private String hylxmc3;
	
	private String note;

	
	public Integer getHylxid() {
		return hylxid;
	}
	
	public void setHylxid(Integer hylxid) {
		this.hylxid = hylxid;
	}
	

	public String getHylxmc() {
		return hylxmc;
	}

	public void setHylxmc(String hylxmc) {
		this.hylxmc = hylxmc;
	}

	public String getHylxdm() {
		return hylxdm;
	}

	public void setHylxdm(String hylxdm) {
		this.hylxdm = hylxdm;
	}

	public void setHylxdm1(String hylxdm1) {
		this.hylxdm1 = hylxdm1;
	}

	public String getHylxdm1() {
		return hylxdm1;
	}

	public void setHylxmc1(String hylxmc1) {
		this.hylxmc1 = hylxmc1;
	}

	public String getHylxmc1() {
		return hylxmc1;
	}

	public void setHylxdm2(String hylxdm2) {
		this.hylxdm2 = hylxdm2;
	}

	public String getHylxdm2() {
		return hylxdm2;
	}

	public void setHylxmc2(String hylxmc2) {
		this.hylxmc2 = hylxmc2;
	}

	public String getHylxmc2() {
		return hylxmc2;
	}
	
	
	
	public void setHylxdm3(String hylxdm3) {
		this.hylxdm3 = hylxdm3;
	}

	public String getHylxdm3() {
		return hylxdm3;
	}

	public void setHylxmc3(String hylxmc3) {
		this.hylxmc3 = hylxmc3;
	}

	public String getHylxmc3() {
		return hylxmc3;
	}
	public void setNote(String note) {
		this.note = note;
	}

	public String getNote() {
		return note;
	}

	public void setHylxdmOld(String hylxdmOld) {
		this.hylxdmOld = hylxdmOld;
	}

	public String getHylxdmOld() {
		return hylxdmOld;
	}

	public void setHylxmcOld(String hylxmcOld) {
		this.hylxmcOld = hylxmcOld;
	}

	public String getHylxmcOld() {
		return hylxmcOld;
	}
}
