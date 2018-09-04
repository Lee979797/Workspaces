package com.ninemax.jpa.code.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TFddbr entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_fddbr")
public class TFddbr implements java.io.Serializable {

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
	//gj
	private String zzmm;
	private Date rzsj;
	//dzdw
	private String lxdh;
	private String lxmobile;
	private String txdz;
	private String yb;
	private String mz;
	private String iszz;
	private String email;
	private Date csrq;
	private String xl;
	private Date rhsj;
	private String qtzw;
	private String status;
	private String memo;

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

	@Column(name = "lxdh", length = 500)
	public String getLxdh() {
		return this.lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}

	@Column(name = "lxmobile", length = 500)
	public String getLxmobile() {
		return this.lxmobile;
	}

	public void setLxmobile(String lxmobile) {
		this.lxmobile = lxmobile;
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

	@Column(name = "mz", length = 500)
	public String getMz() {
		return this.mz;
	}

	public void setMz(String mz) {
		this.mz = mz;
	}

	@Column(name = "iszz", length = 1)
	public String getIszz() {
		return this.iszz;
	}

	public void setIszz(String iszz) {
		this.iszz = iszz;
	}

	@Column(name = "email", length = 500)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "csrq", length = 23)
	public Date getCsrq() {
		return this.csrq;
	}

	public void setCsrq(Date csrq) {
		this.csrq = csrq;
	}

	@Column(name = "xl", length = 500)
	public String getXl() {
		return this.xl;
	}

	public void setXl(String xl) {
		this.xl = xl;
	}

	@Column(name = "rhsj", length = 23)
	public Date getRhsj() {
		return this.rhsj;
	}

	public void setRhsj(Date rhsj) {
		this.rhsj = rhsj;
	}

	@Column(name = "qtzw", length = 500)
	public String getQtzw() {
		return this.qtzw;
	}

	public void setQtzw(String qtzw) {
		this.qtzw = qtzw;
	}

	@Column(name = "status", length = 1)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "memo", length = 500)
	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		return "TFddbr [lsh=" + lsh + ", tyshxydm=" + tyshxydm + ", id=" + id
				+ ", jgmc=" + jgmc + ", xm=" + xm + ", zw=" + zw + ", xb=" + xb
				+ ", zjlx=" + zjlx + ", zjhm=" + zjhm + ", zzmm=" + zzmm
				+ ", rzsj=" + rzsj + ", lxdh=" + lxdh + ", lxmobile="
				+ lxmobile + ", txdz=" + txdz + ", yb=" + yb + ", mz=" + mz
				+ ", iszz=" + iszz + ", email=" + email + ", csrq=" + csrq
				+ ", xl=" + xl + ", rhsj=" + rhsj + ", qtzw=" + qtzw
				+ ", status=" + status + ", memo=" + memo + "]";
	}

}