package com.ninemax.jdbc.to.application;

import java.io.Serializable;

public class BzjgdmTO implements Serializable {

	/**
	 * VersionUID
	 */
	private static final long serialVersionUID = 3243807275796040344L;
	
	private String dm;
    private String mc;
    private String xzqhId;
    private String zrxzqhId;
    private String flag;
    private String superdm;
    private String jgmc;
    
	public String getDm() {
		return dm;
	}
	public void setDm(String dm) {
		this.dm = dm;
	}
	public String getMc() {
		return mc;
	}
	public void setMc(String mc) {
		this.mc = mc;
	}
	public String getXzqhId() {
		return xzqhId;
	}
	public void setXzqhId(String xzqhId) {
		this.xzqhId = xzqhId;
	}
	public String getZrxzqhId() {
		return zrxzqhId;
	}
	public void setZrxzqhId(String zrxzqhId) {
		this.zrxzqhId = zrxzqhId;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getSuperdm() {
		return superdm;
	}
	public void setSuperdm(String superdm) {
		this.superdm = superdm;
	}
	public String getJgmc() {
		return jgmc;
	}
	public void setJgmc(String jgmc) {
		this.jgmc = jgmc;
	}
}
