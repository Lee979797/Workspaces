package com.ninemax.jpa.code.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TJgdm entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_jgdm")
public class TJgdm implements java.io.Serializable {

	// Fields

	private String tyshxydm;
	private String jgdm;
	private String jgmc;
	private String jglx;
	private String fddbr;
	private String zjlx;
	private String zjhm;
	private String jyfw;
	private String jjhy2011;
	private String jjlx2011;
	private Date zcrq;
	private String zgdm;
	private String pzjgdm;
	private String xzqh;
	private String jgdz;
	private String yzbm;
	private String bgxzqh;
	private String bgjgdz;
	private String bgyzbm;
	private String dhhm;
	private Date bzrq;
	private Date yxqxe;
	private Date yxqxs;
	private String bzjgdm;
	private Double zczj;
	private String hbzl;
	private Integer zgrs;
	private Date bgrq;
	private String lry;
	private Date njrq;
	private String zch;
	private String zgmc;
	private String pzjgmc;
	private String email;
	private String url;
	private String mobile;
	private Date lastdate;
	private String tbrxm;
	private String tbrsfzh;
	private String tbrlxfs;
	private String jydz;
	private String jyzt;
	private String scjyxzqh;
	private String tbrzjlx;
	private String ywlx;
	private String hsfs;
	private String jhbz;
	private String tbrmobile;
	private String jlwh;
	private Date jlrq;
	private String xjwh;
	private Date xjrq;
	private Integer hyrs;
	private Integer gbrs;
	private Integer ghjs;
	private String ghzxmc;
	private String ghzxdh;
	private Double snjylj;
	private Double hhsr;
	private Double lcsr;
	private Double qtsr;
	private Double gdzj;
	private Double ldzj;
	private Double qtzj;
	private Double hjzj;
	private Double bgcs;
	private Double hdcs;
	private Double qtcs;
	private Double cshj;
	private String cdnl;
	private String memo;
	private String memo1;
	private String memo2;
	private String memo3;
	private String memo4;
	private String memo5;
	private String dybz;
	private String bgwh;
	private String njglx;
	private String njjhy;
	private String njjlx;
	private String FilePach;
	private String Imageurl;
	private String pageTypeStr;
	private String lsh;
	
	//lvwei 20180103 上报字段
	private Integer dflag;	
	private String arch_Id;//自动生成GUID
	
	
	@Id
	@Column(name = "tyshxydm", unique = true, nullable = false, length = 18)
	public String getTyshxydm() {
		return this.tyshxydm;
	}

	public void setTyshxydm(String tyshxydm) {
		this.tyshxydm = tyshxydm;
	}

	@Column(name = "jgdm", unique = true, nullable = false, length = 9)
	public String getJgdm() {
		return this.jgdm;
	}

	public void setJgdm(String jgdm) {
		this.jgdm = jgdm;
	}

	@Column(name = "jgmc")
	public String getJgmc() {
		return this.jgmc;
	}

	public void setJgmc(String jgmc) {
		this.jgmc = jgmc;
	}
    
	@Column(name = "lsh")
	public String getLsh() {
		return this.lsh;
	}

	public void setLsh(String lsh) {
		this.lsh = lsh;
	}
	@Column(name = "jglx", length = 1)
	public String getJglx() {
		return this.jglx;
	}

	public void setJglx(String jglx) {
		this.jglx = jglx;
	}

	@Column(name = "fddbr")
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

	@Column(name = "zjhm", length = 42)
	public String getZjhm() {
		return this.zjhm;
	}

	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}

	@Column(name = "jyfw")
	public String getJyfw() {
		return this.jyfw;
	}

	public void setJyfw(String jyfw) {
		this.jyfw = jyfw;
	}

	@Column(name = "jjhy2011", length = 5)
	public String getJjhy2011() {
		return this.jjhy2011;
	}

	public void setJjhy2011(String jjhy2011) {
		this.jjhy2011 = jjhy2011;
	}

	@Column(name = "jjlx2011", length = 5)
	public String getJjlx2011() {
		return this.jjlx2011;
	}

	public void setJjlx2011(String jjlx2011) {
		this.jjlx2011 = jjlx2011;
	}

	@Column(name = "zcrq", length = 23)
	public Date getZcrq() {
		return this.zcrq;
	}

	public void setZcrq(Date zcrq) {
		this.zcrq = zcrq;
	}

	@Column(name = "zgdm", length = 18)
	public String getZgdm() {
		return this.zgdm;
	}

	public void setZgdm(String zgdm) {
		this.zgdm = zgdm;
	}

	@Column(name = "pzjgdm", length = 18)
	public String getPzjgdm() {
		return this.pzjgdm;
	}

	public void setPzjgdm(String pzjgdm) {
		this.pzjgdm = pzjgdm;
	}

	@Column(name = "xzqh", length = 6)
	public String getXzqh() {
		return this.xzqh;
	}

	public void setXzqh(String xzqh) {
		this.xzqh = xzqh;
	}

	@Column(name = "jgdz")
	public String getJgdz() {
		return this.jgdz;
	}

	public void setJgdz(String jgdz) {
		this.jgdz = jgdz;
	}

	@Column(name = "yzbm", length = 6)
	public String getYzbm() {
		return this.yzbm;
	}

	public void setYzbm(String yzbm) {
		this.yzbm = yzbm;
	}
	
	
	@Column(name = "bgxzqh", length = 6)
	public String getBgxzqh() {
		return this.bgxzqh;
	}

	public void setBgxzqh(String bgxzqh) {
		this.bgxzqh = bgxzqh;
	}

	@Column(name = "bgjgdz")
	public String getBgjgdz() {
		return this.bgjgdz;
	}

	public void setBgjgdz(String bgjgdz) {
		this.bgjgdz = bgjgdz;
	}

	@Column(name = "bgyzbm", length = 6)
	public String getBgyzbm() {
		return this.bgyzbm;
	}

	public void setBgyzbm(String bgyzbm) {
		this.bgyzbm = bgyzbm;
	}

	@Column(name = "dhhm", length = 25)
	public String getDhhm() {
		return this.dhhm;
	}

	public void setDhhm(String dhhm) {
		this.dhhm = dhhm;
	}

	@Column(name = "bzrq", length = 23)
	public Date getBzrq() {
		return this.bzrq;
	}

	public void setBzrq(Date bzrq) {
		this.bzrq = bzrq;
	}

	@Column(name = "yxqxe", length = 23)
	public Date getYxqxe() {
		return this.yxqxe;
	}

	public void setYxqxe(Date yxqxe) {
		this.yxqxe = yxqxe;
	}
	
	@Column(name = "yxqxs", length = 23)
	public Date getYxqxs() {
		return yxqxs;
	}
	
	public void setYxqxs(Date yxqxs) {
		this.yxqxs = yxqxs;
	}


	@Column(name = "bzjgdm", length = 6)
	public String getBzjgdm() {
		return this.bzjgdm;
	}


	public void setBzjgdm(String bzjgdm) {
		this.bzjgdm = bzjgdm;
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

	@Column(name = "zgrs")
	public Integer getZgrs() {
		return this.zgrs;
	}

	public void setZgrs(Integer zgrs) {
		this.zgrs = zgrs;
	}

	@Column(name = "bgrq", length = 23)
	public Date getBgrq() {
		return this.bgrq;
	}

	public void setBgrq(Date bgrq) {
		this.bgrq = bgrq;
	}

	@Column(name = "lry", length = 10)
	public String getLry() {
		return this.lry;
	}

	public void setLry(String lry) {
		this.lry = lry;
	}

	@Column(name = "njrq", length = 23)
	public Date getNjrq() {
		return this.njrq;
	}

	public void setNjrq(Date njrq) {
		this.njrq = njrq;
	}

	@Column(name = "zch", length = 70)
	public String getZch() {
		return this.zch;
	}

	public void setZch(String zch) {
		this.zch = zch;
	}

	@Column(name = "zgmc", length = 200)
	public String getZgmc() {
		return this.zgmc;
	}

	public void setZgmc(String zgmc) {
		this.zgmc = zgmc;
	}

	@Column(name = "pzjgmc", length = 200)
	public String getPzjgmc() {
		return this.pzjgmc;
	}

	public void setPzjgmc(String pzjgmc) {
		this.pzjgmc = pzjgmc;
	}

	@Column(name = "email", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "url", length = 50)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "mobile", length = 15)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "lastdate", length = 23)
	public Date getLastdate() {
		return this.lastdate;
	}

	public void setLastdate(Date lastdate) {
		this.lastdate = lastdate;
	}

	@Column(name = "tbrxm", length = 60)
	public String getTbrxm() {
		return this.tbrxm;
	}

	public void setTbrxm(String tbrxm) {
		this.tbrxm = tbrxm;
	}

	@Column(name = "tbrsfzh", length = 25)
	public String getTbrsfzh() {
		return this.tbrsfzh;
	}

	public void setTbrsfzh(String tbrsfzh) {
		this.tbrsfzh = tbrsfzh;
	}

	@Column(name = "tbrlxfs", length = 50)
	public String getTbrlxfs() {
		return this.tbrlxfs;
	}

	public void setTbrlxfs(String tbrlxfs) {
		this.tbrlxfs = tbrlxfs;
	}

	@Column(name = "jydz", length = 240)
	public String getJydz() {
		return this.jydz;
	}

	public void setJydz(String jydz) {
		this.jydz = jydz;
	}

	@Column(name = "jyzt", length = 50)
	public String getJyzt() {
		return this.jyzt;
	}

	public void setJyzt(String jyzt) {
		this.jyzt = jyzt;
	}

	@Column(name = "scjyxzqh", length = 6)
	public String getScjyxzqh() {
		return this.scjyxzqh;
	}

	public void setScjyxzqh(String scjyxzqh) {
		this.scjyxzqh = scjyxzqh;
	}

	@Column(name = "tbrzjlx", length = 2)
	public String getTbrzjlx() {
		return this.tbrzjlx;
	}

	public void setTbrzjlx(String tbrzjlx) {
		this.tbrzjlx = tbrzjlx;
	}

	@Column(name = "ywlx", length = 50)
	public String getYwlx() {
		return this.ywlx;
	}

	public void setYwlx(String ywlx) {
		this.ywlx = ywlx;
	}

	@Column(name = "hsfs", length = 50)
	public String getHsfs() {
		return this.hsfs;
	}

	public void setHsfs(String hsfs) {
		this.hsfs = hsfs;
	}

	@Column(name = "jhbz", length = 100)
	public String getJhbz() {
		return this.jhbz;
	}

	public void setJhbz(String jhbz) {
		this.jhbz = jhbz;
	}

	@Column(name = "tbrmobile", length = 15)
	public String getTbrmobile() {
		return this.tbrmobile;
	}

	public void setTbrmobile(String tbrmobile) {
		this.tbrmobile = tbrmobile;
	}

	@Column(name = "jlwh", length = 100)
	public String getJlwh() {
		return this.jlwh;
	}

	public void setJlwh(String jlwh) {
		this.jlwh = jlwh;
	}

	@Column(name = "jlrq", length = 23)
	public Date getJlrq() {
		return this.jlrq;
	}

	public void setJlrq(Date jlrq) {
		this.jlrq = jlrq;
	}

	@Column(name = "xjwh", length = 100)
	public String getXjwh() {
		return this.xjwh;
	}

	public void setXjwh(String xjwh) {
		this.xjwh = xjwh;
	}

	@Column(name = "xjrq", length = 23)
	public Date getXjrq() {
		return this.xjrq;
	}

	public void setXjrq(Date xjrq) {
		this.xjrq = xjrq;
	}

	@Column(name = "hyrs")
	public Integer getHyrs() {
		return this.hyrs;
	}

	public void setHyrs(Integer hyrs) {
		this.hyrs = hyrs;
	}

	@Column(name = "gbrs")
	public Integer getGbrs() {
		return this.gbrs;
	}

	public void setGbrs(Integer gbrs) {
		this.gbrs = gbrs;
	}

	@Column(name = "ghjs")
	public Integer getGhjs() {
		return this.ghjs;
	}

	public void setGhjs(Integer ghjs) {
		this.ghjs = ghjs;
	}

	@Column(name = "ghzxmc", length = 100)
	public String getGhzxmc() {
		return this.ghzxmc;
	}

	public void setGhzxmc(String ghzxmc) {
		this.ghzxmc = ghzxmc;
	}

	@Column(name = "ghzxdh", length = 25)
	public String getGhzxdh() {
		return this.ghzxdh;
	}

	public void setGhzxdh(String ghzxdh) {
		this.ghzxdh = ghzxdh;
	}

	@Column(name = "snjylj", precision = 14, scale = 4)
	public Double getSnjylj() {
		return this.snjylj;
	}

	public void setSnjylj(Double snjylj) {
		this.snjylj = snjylj;
	}

	@Column(name = "hhsr", precision = 14, scale = 4)
	public Double getHhsr() {
		return this.hhsr;
	}

	public void setHhsr(Double hhsr) {
		this.hhsr = hhsr;
	}

	@Column(name = "lcsr", precision = 14, scale = 4)
	public Double getLcsr() {
		return this.lcsr;
	}

	public void setLcsr(Double lcsr) {
		this.lcsr = lcsr;
	}

	@Column(name = "qtsr", precision = 14, scale = 4)
	public Double getQtsr() {
		return this.qtsr;
	}

	public void setQtsr(Double qtsr) {
		this.qtsr = qtsr;
	}

	@Column(name = "gdzj", precision = 14, scale = 4)
	public Double getGdzj() {
		return this.gdzj;
	}

	public void setGdzj(Double gdzj) {
		this.gdzj = gdzj;
	}

	@Column(name = "ldzj", precision = 14, scale = 4)
	public Double getLdzj() {
		return this.ldzj;
	}

	public void setLdzj(Double ldzj) {
		this.ldzj = ldzj;
	}

	@Column(name = "qtzj", precision = 14, scale = 4)
	public Double getQtzj() {
		return this.qtzj;
	}

	public void setQtzj(Double qtzj) {
		this.qtzj = qtzj;
	}

	@Column(name = "hjzj", precision = 14, scale = 4)
	public Double getHjzj() {
		return this.hjzj;
	}

	public void setHjzj(Double hjzj) {
		this.hjzj = hjzj;
	}

	@Column(name = "bgcs", precision = 14, scale = 4)
	public Double getBgcs() {
		return this.bgcs;
	}

	public void setBgcs(Double bgcs) {
		this.bgcs = bgcs;
	}

	@Column(name = "hdcs", precision = 14, scale = 4)
	public Double getHdcs() {
		return this.hdcs;
	}

	public void setHdcs(Double hdcs) {
		this.hdcs = hdcs;
	}

	@Column(name = "qtcs", precision = 14, scale = 4)
	public Double getQtcs() {
		return this.qtcs;
	}

	public void setQtcs(Double qtcs) {
		this.qtcs = qtcs;
	}

	@Column(name = "cshj", precision = 14, scale = 4)
	public Double getCshj() {
		return this.cshj;
	}

	public void setCshj(Double cshj) {
		this.cshj = cshj;
	}

	@Column(name = "cdnl", length = 1)
	public String getCdnl() {
		return this.cdnl;
	}

	public void setCdnl(String cdnl) {
		this.cdnl = cdnl;
	}

	@Column(name = "memo", length = 500)
	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Column(name = "memo1", length = 500)
	public String getMemo1() {
		return this.memo1;
	}

	public void setMemo1(String memo1) {
		this.memo1 = memo1;
	}

	@Column(name = "memo2", length = 500)
	public String getMemo2() {
		return this.memo2;
	}

	public void setMemo2(String memo2) {
		this.memo2 = memo2;
	}

	@Column(name = "memo3", length = 500)
	public String getMemo3() {
		return this.memo3;
	}

	public void setMemo3(String memo3) {
		this.memo3 = memo3;
	}

	@Column(name = "memo4", length = 500)
	public String getMemo4() {
		return this.memo4;
	}

	public void setMemo4(String memo4) {
		this.memo4 = memo4;
	}

	@Column(name = "memo5", length = 500)
	public String getMemo5() {
		return this.memo5;
	}

	public void setMemo5(String memo5) {
		this.memo5 = memo5;
	}

	@Column(name = "dybz", length = 500)
	public String getDybz() {
		return dybz;
	}

	public void setDybz(String dybz) {
		this.dybz = dybz;
	}
	@Column(name = "bgwh", length = 500)
	public String getBgwh() {
		return bgwh;
	}

	public void setBgwh(String bgwh) {
		this.bgwh = bgwh;
	}
	@Column(name = "njglx")
	public String getNjglx() {
		return njglx;
	}

	public void setNjglx(String njglx) {
		this.njglx = njglx;
	}
	@Column(name = "njjhy")
	public String getNjjhy() {
		return njjhy;
	}

	public void setNjjhy(String njjhy) {
		this.njjhy = njjhy;
	}
	@Column(name = "njjlx")
	public String getNjjlx() {
		return njjlx;
	}

	public void setNjjlx(String njjlx) {
		this.njjlx = njjlx;
	}
	@Column(name = "FilePach")
	public String getFilePach() {
		return FilePach;
	}

	public void setFilePach(String filePach) {
		FilePach = filePach;
	}
	@Column(name = "Imageurl")
	public String getImageurl() {
		return Imageurl;
	}

	public void setImageurl(String imageurl) {
		Imageurl = imageurl;
	}
	@Column(name = "pageTypeStr")
	public String getPageTypeStr() {
		return pageTypeStr;
	}

	public void setPageTypeStr(String pageTypeStr) {
		this.pageTypeStr = pageTypeStr;
	}
	
	@Column(name="dflag")
	public Integer getDflag() {
		return dflag;
	}
	public void setDflag(Integer dflag) {
		this.dflag = dflag;
	}
	
	@Column(name="arch_Id")
	public String getArch_Id() {
		return arch_Id;
	}

	public void setArch_Id(String arch_Id) {
		this.arch_Id = arch_Id;
	}

	@Override
	public String toString() {
		return "TJgdm [tyshxydm=" + tyshxydm + ", jgdm=" + jgdm + ", jgmc="
				+ jgmc + ", jglx=" + jglx + ", fddbr=" + fddbr + ", zjlx="
				+ zjlx + ", zjhm=" + zjhm + ", jyfw=" + jyfw + ", jjhy2011="
				+ jjhy2011 + ", jjlx2011=" + jjlx2011 + ", zcrq=" + zcrq
				+ ", zgdm=" + zgdm + ", pzjgdm=" + pzjgdm + ", xzqh=" + xzqh
				+ ", jgdz=" + jgdz + ", yzbm=" + yzbm + ", bgxzqh=" + bgxzqh
				+ ", bgjgdz=" + bgjgdz + ", bgyzbm=" + bgyzbm + ", dhhm="
				+ dhhm + ", bzrq=" + bzrq + ", yxqxe=" + yxqxe + ", yxqxs="
				+ yxqxs + ", bzjgdm=" + bzjgdm + ", zczj=" + zczj + ", hbzl="
				+ hbzl + ", zgrs=" + zgrs + ", bgrq=" + bgrq + ", lry=" + lry
				+ ", njrq=" + njrq + ", zch=" + zch + ", zgmc=" + zgmc
				+ ", pzjgmc=" + pzjgmc + ", email=" + email + ", url=" + url
				+ ", mobile=" + mobile + ", lastdate=" + lastdate + ", tbrxm="
				+ tbrxm + ", tbrsfzh=" + tbrsfzh + ", tbrlxfs=" + tbrlxfs
				+ ", jydz=" + jydz + ", jyzt=" + jyzt + ", scjyxzqh="
				+ scjyxzqh + ", tbrzjlx=" + tbrzjlx + ", ywlx=" + ywlx
				+ ", hsfs=" + hsfs + ", jhbz=" + jhbz + ", tbrmobile="
				+ tbrmobile + ", jlwh=" + jlwh + ", jlrq=" + jlrq + ", xjwh="
				+ xjwh + ", xjrq=" + xjrq + ", hyrs=" + hyrs + ", gbrs=" + gbrs
				+ ", ghjs=" + ghjs + ", ghzxmc=" + ghzxmc + ", ghzxdh="
				+ ghzxdh + ", snjylj=" + snjylj + ", hhsr=" + hhsr + ", lcsr="
				+ lcsr + ", qtsr=" + qtsr + ", gdzj=" + gdzj + ", ldzj=" + ldzj
				+ ", qtzj=" + qtzj + ", hjzj=" + hjzj + ", bgcs=" + bgcs
				+ ", hdcs=" + hdcs + ", qtcs=" + qtcs + ", cshj=" + cshj
				+ ", cdnl=" + cdnl + ", memo=" + memo + ", memo1=" + memo1
				+ ", memo2=" + memo2 + ", memo3=" + memo3 + ", memo4=" + memo4
				+ ", memo5=" + memo5 + ", dybz=" + dybz + ", bgwh=" + bgwh
				+ ", njglx=" + njglx + ", njjhy=" + njjhy + ", njjlx=" + njjlx
				+ ", FilePach=" + FilePach + ", Imageurl=" + Imageurl
				+ ", pageTypeStr=" + pageTypeStr + ", lsh=" + lsh + ", dflag="
				+ dflag + ", arch_Id=" + arch_Id + "]";
	}
	
}