package com.lhq.prj.bms.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Zgbm implements Serializable{

	public Zgbm() {
		
	}
	
	public Zgbm(Integer zgid, String zgjgmc, String jgdm) {
		this.zgid = zgid;
		this.zgjgmc = zgjgmc;
		this.jgdm = jgdm;
	}
	private Integer zgid;
	
	private String zgjgmc;

	private String jgdm;

	public String getZgjgmc() {
		return zgjgmc;
	}

	public void setZgjgmc(String zgjgmc) {
		this.zgjgmc = zgjgmc;
	}

	public String getJgdm() {
		return jgdm;
	}

	public void setJgdm(String jgdm) {
		this.jgdm = jgdm;
	}

	public Integer getZgid() {
		return zgid;
	}

	public void setZgid(Integer zgid) {
		this.zgid = zgid;
	}

	@Override
	public String toString() {
		return "Zgbm [zgid=" + zgid + ", zgjgmc=" + zgjgmc + ", jgdm=" + jgdm
				+ "]";
	}
	
}
