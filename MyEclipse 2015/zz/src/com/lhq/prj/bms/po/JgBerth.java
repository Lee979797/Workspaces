package com.lhq.prj.bms.po;

public class JgBerth {

	private int jgid;
	private String jgmc;
	private String jgdm;
	private String jgdz;
	private String pzjgmc;
	private String pzjgdm;
	private String zch;
	private String email;
	private String dhhm;
	private String state;
	private int userid;
	
	public int getJgid() {
		return jgid;
	}
	public void setJgid(int jgid) {
		this.jgid = jgid;
	}
	public String getJgmc() {
		return jgmc;
	}
	public void setJgmc(String jgmc) {
		this.jgmc = jgmc;
	}
	public String getJgdm() {
		return jgdm;
	}
	public void setJgdm(String jgdm) {
		this.jgdm = jgdm;
	}
	public String getJgdz() {
		return jgdz;
	}
	public void setJgdz(String jgdz) {
		this.jgdz = jgdz;
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
	public String getZch() {
		return zch;
	}
	public void setZch(String zch) {
		this.zch = zch;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDhhm() {
		return dhhm;
	}
	public void setDhhm(String dhhm) {
		this.dhhm = dhhm;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "JgBerth [jgid=" + jgid + ", jgmc=" + jgmc + ", jgdm=" + jgdm
				+ ", jgdz=" + jgdz + ", pzjgmc=" + pzjgmc + ", pzjgdm="
				+ pzjgdm + ", zch=" + zch + ", email=" + email + ", dhhm="
				+ dhhm + ", state=" + state + ", userid=" + userid + "]";
	}
	
}
