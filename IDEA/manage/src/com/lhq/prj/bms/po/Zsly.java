/*
 * @(#)Zsly.java 2012-12-19 
 *
 * Copyright 2012 YQ.
 */

package com.lhq.prj.bms.po;

import java.io.Serializable;
import java.util.Date;

/**
 * 证书利用
 * 
 * @author lhq
 * @version 1.0 ����03:25:39
 */
@SuppressWarnings("serial")
public class Zsly implements Serializable {
	public Zsly(Integer id) {
		super();
		this.id = id;
	}

	public Zsly() {
		super();
	}

	private Integer id;
	private String zsbh;
	private String zslx;
	private String jgdm;
	private String jgmc;
	private String ssds;
	private String ssbzjg;
	private String flag;
	private Date fpsj;
	private Date dysj;
	private String czy;
	private String djh;
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setZsbh(String zsbh) {
		this.zsbh = zsbh;
	}

	public String getZsbh() {
		return zsbh;
	}

	public void setZslx(String zslx) {
		this.zslx = zslx;
	}

	public String getZslx() {
		return zslx;
	}

	public void setSsds(String ssds) {
		this.ssds = ssds;
	}

	public String getSsds() {
		return ssds;
	}

	public void setSsbzjg(String ssbzjg) {
		this.ssbzjg = ssbzjg;
	}

	public String getSsbzjg() {
		return ssbzjg;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getFlag() {
		return flag;
	}

	public void setFpsj(Date fpsj) {
		this.fpsj = fpsj;
	}

	public Date getFpsj() {
		return fpsj;
	}

	public void setCzy(String czy) {
		this.czy = czy;
	}

	public String getCzy() {
		return czy;
	}

	public void setDysj(Date dysj) {
		this.dysj = dysj;
	}

	public Date getDysj() {
		return dysj;
	}

	public void setDjh(String djh) {
		this.djh = djh;
	}

	public String getDjh() {
		return djh;
	}

	public void setJgdm(String jgdm) {
		this.jgdm = jgdm;
	}

	public String getJgdm() {
		return jgdm;
	}

	public void setJgmc(String jgmc) {
		this.jgmc = jgmc;
	}

	public String getJgmc() {
		return jgmc;
	}

	


}
