package com.ninemax.jpa.code.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * AppJgdmsb entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "APP_JGDMSB")
public class AppJgdmsb implements java.io.Serializable {

	// Fields

	private String blcode;
	private String jgdm;
	private String blfs;
	private String jgmc;
	private String jglx;
	private String njglx;
	private String fddbr;
	private String zjlx;
	private String zjhm;
	private String jyfw;
	private String jjhy;
	private String jjlx;
	private String njjhy;
	private String njjlx;
	private Timestamp zcrq;
	private Integer zgrs;
	private String zgmc;
	private Double zczj;
	private String hbzl;
	private String wftzgb;
	private String xzqh;
	private String yzbm;
	private String jgdz;
	private String dhhm;
	private String mobile;
	private String url;
	private String pzjgdm;
	private String pzjgmc;
	private String pzwh;
	private String gk;
	private String bzjgdm;
	private String tbr;
	private String tbrzjhm;
	private String tbrzjlx;
	private String tbrmobile;
	private Timestamp timeflag;
	private String tbrfax;
	private String tbrmail;
	private Integer sqfbsl;
	private String qtxxcp;
	private String tbrbz;
	private Timestamp bzrq;
	private Timestamp zfrq;
	private String lrr;
	
	private String blflag;
	private String spnotype;
	private String spnoxxnr;
	private Timestamp endflagtime;
	private String memo;
	private String zch;
	

	// Property accessors
	@Id
	@Column(name = "blcode", unique = true, nullable = false, length = 50)
	public String getBlcode() {
		return this.blcode;
	}

	public void setBlcode(String blcode) {
		this.blcode = blcode;
	}

	@Column(name = "jgdm", nullable = false, length = 9)
	public String getJgdm() {
		return this.jgdm;
	}

	public void setJgdm(String jgdm) {
		this.jgdm = jgdm;
	}

	@Column(name = "blfs", nullable = false, length = 10)
	public String getBlfs() {
		return this.blfs;
	}

	public void setBlfs(String blfs) {
		this.blfs = blfs;
	}

	@Column(name = "jgmc", length = 120)
	public String getJgmc() {
		return this.jgmc;
	}

	public void setJgmc(String jgmc) {
		this.jgmc = jgmc;
	}

	@Column(name = "jglx", length = 1)
	public String getJglx() {
		return this.jglx;
	}

	public void setJglx(String jglx) {
		this.jglx = jglx;
	}

	@Column(name = "njglx", length = 2)
	public String getNjglx() {
		return this.njglx;
	}

	public void setNjglx(String njglx) {
		this.njglx = njglx;
	}

	@Column(name = "fddbr", length = 30)
	public String getFddbr() {
		return this.fddbr;
	}

	public void setFddbr(String fddbr) {
		this.fddbr = fddbr;
	}

	@Column(name = "zjlx", length = 2)
	public String getZjlx() {
		return this.zjlx;
	}

	public void setZjlx(String zjlx) {
		this.zjlx = zjlx;
	}

	@Column(name = "zjhm", length = 25)
	public String getZjhm() {
		return this.zjhm;
	}

	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}

	@Column(name = "jyfw", length = 2000)
	public String getJyfw() {
		return this.jyfw;
	}

	public void setJyfw(String jyfw) {
		this.jyfw = jyfw;
	}

	@Column(name = "jjhy", length = 5)
	public String getJjhy() {
		return this.jjhy;
	}

	public void setJjhy(String jjhy) {
		this.jjhy = jjhy;
	}

	@Column(name = "jjlx", length = 3)
	public String getJjlx() {
		return this.jjlx;
	}

	public void setJjlx(String jjlx) {
		this.jjlx = jjlx;
	}

	@Column(name = "njjhy", length = 5)
	public String getNjjhy() {
		return this.njjhy;
	}

	public void setNjjhy(String njjhy) {
		this.njjhy = njjhy;
	}

	@Column(name = "njjlx", length = 3)
	public String getNjjlx() {
		return this.njjlx;
	}

	public void setNjjlx(String njjlx) {
		this.njjlx = njjlx;
	}

	@Column(name = "zcrq", length = 23)
	public Timestamp getZcrq() {
		return this.zcrq;
	}

	public void setZcrq(Timestamp zcrq) {
		this.zcrq = zcrq;
	}

	@Column(name = "zgrs", precision = 6, scale = 0)
	public Integer getZgrs() {
		return this.zgrs;
	}

	public void setZgrs(Integer zgrs) {
		this.zgrs = zgrs;
	}

	@Column(name = "zgmc", length = 70)
	public String getZgmc() {
		return this.zgmc;
	}

	public void setZgmc(String zgmc) {
		this.zgmc = zgmc;
	}

	@Column(name = "zczj", precision = 14, scale = 4)
	public Double getZczj() {
		return this.zczj;
	}

	public void setZczj(Double zczj) {
		this.zczj = zczj;
	}

	@Column(name = "hbzl", length = 3)
	public String getHbzl() {
		return this.hbzl;
	}

	public void setHbzl(String hbzl) {
		this.hbzl = hbzl;
	}

	@Column(name = "wftzgb", length = 3)
	public String getWftzgb() {
		return this.wftzgb;
	}

	public void setWftzgb(String wftzgb) {
		this.wftzgb = wftzgb;
	}

	@Column(name = "xzqh", length = 6)
	public String getXzqh() {
		return this.xzqh;
	}

	public void setXzqh(String xzqh) {
		this.xzqh = xzqh;
	}

	@Column(name = "yzbm", length = 6)
	public String getYzbm() {
		return this.yzbm;
	}

	public void setYzbm(String yzbm) {
		this.yzbm = yzbm;
	}

	@Column(name = "jgdz", length = 240)
	public String getJgdz() {
		return this.jgdz;
	}

	public void setJgdz(String jgdz) {
		this.jgdz = jgdz;
	}

	@Column(name = "dhhm", length = 16)
	public String getDhhm() {
		return this.dhhm;
	}

	public void setDhhm(String dhhm) {
		this.dhhm = dhhm;
	}

	@Column(name = "mobile", length = 15)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "url", length = 50)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "pzjgdm", length = 9)
	public String getPzjgdm() {
		return this.pzjgdm;
	}

	public void setPzjgdm(String pzjgdm) {
		this.pzjgdm = pzjgdm;
	}

	@Column(name = "pzjgmc", length = 70)
	public String getPzjgmc() {
		return this.pzjgmc;
	}

	public void setPzjgmc(String pzjgmc) {
		this.pzjgmc = pzjgmc;
	}

	@Column(name = "pzwh", length = 31)
	public String getPzwh() {
		return this.pzwh;
	}

	public void setPzwh(String pzwh) {
		this.pzwh = pzwh;
	}

	@Column(name = "gk", length = 1)
	public String getGk() {
		return this.gk;
	}

	public void setGk(String gk) {
		this.gk = gk;
	}

	@Column(name = "bzjgdm", length = 6)
	public String getBzjgdm() {
		return this.bzjgdm;
	}

	public void setBzjgdm(String bzjgdm) {
		this.bzjgdm = bzjgdm;
	}

	@Column(name = "tbr", length = 30)
	public String getTbr() {
		return this.tbr;
	}

	public void setTbr(String tbr) {
		this.tbr = tbr;
	}

	@Column(name = "tbrzjhm", length = 25)
	public String getTbrzjhm() {
		return this.tbrzjhm;
	}

	public void setTbrzjhm(String tbrzjhm) {
		this.tbrzjhm = tbrzjhm;
	}

	@Column(name = "tbrzjlx", length = 1)
	public String getTbrzjlx() {
		return this.tbrzjlx;
	}

	public void setTbrzjlx(String tbrzjlx) {
		this.tbrzjlx = tbrzjlx;
	}

	@Column(name = "tbrmobile", length = 15)
	public String getTbrmobile() {
		return this.tbrmobile;
	}

	public void setTbrmobile(String tbrmobile) {
		this.tbrmobile = tbrmobile;
	}

	@Column(name = "timeflag", length = 23)
	public Timestamp getTimeflag() {
		return this.timeflag;
	}

	public void setTimeflag(Timestamp timeflag) {
		this.timeflag = timeflag;
	}

	@Column(name = "tbrfax", length = 16)
	public String getTbrfax() {
		return this.tbrfax;
	}

	public void setTbrfax(String tbrfax) {
		this.tbrfax = tbrfax;
	}

	@Column(name = "tbrmail", length = 50)
	public String getTbrmail() {
		return this.tbrmail;
	}

	public void setTbrmail(String tbrmail) {
		this.tbrmail = tbrmail;
	}

	@Column(name = "sqfbsl")
	public Integer getSqfbsl() {
		return this.sqfbsl;
	}

	public void setSqfbsl(Integer sqfbsl) {
		this.sqfbsl = sqfbsl;
	}

	@Column(name = "qtxxcp", length = 1)
	public String getQtxxcp() {
		return this.qtxxcp;
	}

	public void setQtxxcp(String qtxxcp) {
		this.qtxxcp = qtxxcp;
	}

	@Column(name = "tbrbz", length = 200)
	public String getTbrbz() {
		return this.tbrbz;
	}

	public void setTbrbz(String tbrbz) {
		this.tbrbz = tbrbz;
	}

	@Column(name = "bzrq", length = 23)
	public Timestamp getBzrq() {
		return this.bzrq;
	}

	public void setBzrq(Timestamp bzrq) {
		this.bzrq = bzrq;
	}

	@Column(name = "yxqxe", length = 23)
	public Timestamp getZfrq() {
		return this.zfrq;
	}

	public void setZfrq(Timestamp zfrq) {
		this.zfrq = zfrq;
	}

	@Column(name = "lrr", length = 30)
	public String getLrr() {
		return this.lrr;
	}

	public void setLrr(String lrr) {
		this.lrr = lrr;
	}
	@Column(name = "blflag", length = 30)
	public String getBlflag() {
		return blflag;
	}

	public void setBlflag(String blflag) {
		this.blflag = blflag;
	}

	@Column(name = "spnotype", length = 30)
	public String getSpnotype() {
		return spnotype;
	}

	public void setSpnotype(String spnotype) {
		this.spnotype = spnotype;
	}
	@Column(name = "spnoxxnr", length = 30)
	public String getSpnoxxnr() {
		return spnoxxnr;
	}

	public void setSpnoxxnr(String spnoxxnr) {
		this.spnoxxnr = spnoxxnr;
	}
	@Column(name = "endflagtime", length = 30)
	public Timestamp getEndflagtime() {
		return endflagtime;
	}

	public void setEndflagtime(Timestamp endflagtime) {
		this.endflagtime = endflagtime;
	}
	@Column(name = "memo", length = 30)
	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
	@Column(name = "zch", length = 30)
	public String getZch() {
		return zch;
	}

	public void setZch(String zch) {
		this.zch = zch;
	}
	
	
	
}