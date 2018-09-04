package com.ninemax.jpa.code.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TFzr entity. @author MyEclipse Persistence Tools
 */

//@Table(name = "t_fzr")
@Entity
@Table(name = "t_fzr")
public class TFzr implements java.io.Serializable {

	// Fields

	private Integer lsh;
	private String tyshxydm;
	private String id;
	private String jgmc;
	private String xm;
	private String zw;
	private String xb;
	private String zjlx;
	private String zjhm;
	private String gj;
	private String zzmm;
	private Date rzsj;
	private String dzdw;
	private String lxdh;
	private String txdz;
	private String yb;
	private String mz;
	private String memo1;
	private String lxmobile;
	private String iszz;
	private String email;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lsh", unique = true, nullable = false)
	public Integer getLsh() {
		return this.lsh;
	}



	public void setLsh(Integer lsh) {
		this.lsh = lsh;
	}

	@Column(name = "tyshxydm", length = 18)
	public String getTyshxydm() {
		return this.tyshxydm;
	}

	public void setTyshxydm(String tyshxydm) {
		this.tyshxydm = tyshxydm;
	}

	@Column(name = "id", length = 500)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "jgmc", length = 400)
	public String getJgmc() {
		return this.jgmc;
	}

	public void setJgmc(String jgmc) {
		this.jgmc = jgmc;
	}

	@Column(name = "xm", length = 500)
	public String getXm() {
		return this.xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	@Column(name = "zw", length = 500)
	public String getZw() {
		return this.zw;
	}

	public void setZw(String zw) {
		this.zw = zw;
	}

	@Column(name = "xb", length = 500)
	public String getXb() {
		return this.xb;
	}

	public void setXb(String xb) {
		this.xb = xb;
	}

	@Column(name = "zjlx", length = 500)
	public String getZjlx() {
		return this.zjlx;
	}

	public void setZjlx(String zjlx) {
		this.zjlx = zjlx;
	}

	@Column(name = "zjhm", length = 500)
	public String getZjhm() {
		return this.zjhm;
	}

	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}

	@Column(name = "gj", length = 500)
	public String getGj() {
		return this.gj;
	}

	public void setGj(String gj) {
		this.gj = gj;
	}

	@Column(name = "zzmm", length = 500)
	public String getZzmm() {
		return this.zzmm;
	}

	public void setZzmm(String zzmm) {
		this.zzmm = zzmm;
	}

	@Column(name = "rzsj", length = 23)
	public Date getRzsj() {
		return this.rzsj;
	}

	public void setRzsj(Date rzsj) {
		this.rzsj = rzsj;
	}

	@Column(name = "dzdw", length = 500)
	public String getDzdw() {
		return this.dzdw;
	}

	public void setDzdw(String dzdw) {
		this.dzdw = dzdw;
	}

	@Column(name = "lxdh", length = 500)
	public String getLxdh() {
		return this.lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}

	@Column(name = "txdz", length = 500)
	public String getTxdz() {
		return this.txdz;
	}

	public void setTxdz(String txdz) {
		this.txdz = txdz;
	}

	@Column(name = "yb", length = 6)
	public String getYb() {
		return this.yb;
	}

	public void setYb(String yb) {
		this.yb = yb;
	}
	@Column(name = "mz")
	public String getMz() {
		return mz;
	}

	public void setMz(String mz) {
		this.mz = mz;
	}

	@Column(name = "memo1")
	public String getMemo1() {
		return memo1;
	}

	public void setMemo1(String memo1) {
		this.memo1 = memo1;
	}
	
	@Column(name = "lxmobile", length = 500)
	public String getLxmobile() {
		return lxmobile;
	}
	public void setLxmobile(String lxmobile) {
		this.lxmobile = lxmobile;
	}
	@Column(name = "iszz", length = 1)
	public String getIszz() {
		return iszz;
	}

	public void setIszz(String iszz) {
		this.iszz = iszz;
	}
	@Column(name = "email", length = 500)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}