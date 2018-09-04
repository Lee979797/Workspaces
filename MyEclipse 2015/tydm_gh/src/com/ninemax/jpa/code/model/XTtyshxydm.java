package com.ninemax.jpa.code.model;
// default package

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * XTtyshxydm entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="xt_tyshxydm")

public class XTtyshxydm  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String jgdm;
     private String jgmc;
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
     private String dhhm;
     private Date scbzrq;
     private Date bzrq;
     private Date zfrq;
     private Double zczj;
     private String hbzl;
     private String wftzgb;
     private Integer zgrs;
     private Date bgrq;
     private String zch;
     private String zgmc;
     private String pzjgmc;
     private String email;
     private String url;
     private String mobile;
     private String tbrsfzh;
     private String tbrxm;
     private String tbrlxfs;
     private String jyzt;
     private String scjyxzqh;
     private String tbrzjlx;
     private String tyshxydm;
     private String ywlx;
     private String hsfs;
     private String ismini;
     private String jhbz;
     private Date importdate;
     private String status;
     private String bfdwxzqh;
    @Id 
    
    @Column(name="id", unique=true, nullable=false)

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    @Column(name="jgdm", nullable=false, length=9)

    public String getJgdm() {
        return this.jgdm;
    }
    
    public void setJgdm(String jgdm) {
        this.jgdm = jgdm;
    }
    
    @Column(name="jgmc", length=400)

    public String getJgmc() {
        return this.jgmc;
    }
    
    public void setJgmc(String jgmc) {
        this.jgmc = jgmc;
    }
    
    @Column(name="fddbr", length=100)

    public String getFddbr() {
        return this.fddbr;
    }
    
    public void setFddbr(String fddbr) {
        this.fddbr = fddbr;
    }
    
    @Column(name="zjlx", length=2)

    public String getZjlx() {
        return this.zjlx;
    }
    
    public void setZjlx(String zjlx) {
        this.zjlx = zjlx;
    }
    
    @Column(name="zjhm", length=42)

    public String getZjhm() {
        return this.zjhm;
    }
    
    public void setZjhm(String zjhm) {
        this.zjhm = zjhm;
    }
    
    @Column(name="jyfw", length=2000)

    public String getJyfw() {
        return this.jyfw;
    }
    
    public void setJyfw(String jyfw) {
        this.jyfw = jyfw;
    }
    
    @Column(name="jjhy2011", length=5)

    public String getJjhy2011() {
        return this.jjhy2011;
    }
    
    public void setJjhy2011(String jjhy2011) {
        this.jjhy2011 = jjhy2011;
    }
    
    @Column(name="jjlx2011", length=5)

    public String getJjlx2011() {
        return this.jjlx2011;
    }
    
    public void setJjlx2011(String jjlx2011) {
        this.jjlx2011 = jjlx2011;
    }
    
    @Column(name="zcrq", length=23)

    public Date getZcrq() {
        return this.zcrq;
    }
    
    public void setZcrq(Date zcrq) {
        this.zcrq = zcrq;
    }
    
    @Column(name="zgdm", length=9)

    public String getZgdm() {
        return this.zgdm;
    }
    
    public void setZgdm(String zgdm) {
        this.zgdm = zgdm;
    }
    
    @Column(name="pzjgdm", length=9)

    public String getPzjgdm() {
        return this.pzjgdm;
    }
    
    public void setPzjgdm(String pzjgdm) {
        this.pzjgdm = pzjgdm;
    }
    
    @Column(name="xzqh", length=6)

    public String getXzqh() {
        return this.xzqh;
    }
    
    public void setXzqh(String xzqh) {
        this.xzqh = xzqh;
    }
    
    @Column(name="jgdz", length=240)

    public String getJgdz() {
        return this.jgdz;
    }
    
    public void setJgdz(String jgdz) {
        this.jgdz = jgdz;
    }
    
    @Column(name="yzbm", length=6)

    public String getYzbm() {
        return this.yzbm;
    }
    
    public void setYzbm(String yzbm) {
        this.yzbm = yzbm;
    }
    
    @Column(name="dhhm", length=25)

    public String getDhhm() {
        return this.dhhm;
    }
    
    public void setDhhm(String dhhm) {
        this.dhhm = dhhm;
    }
    
    @Column(name="scbzrq", length=23)

    public Date getScbzrq() {
        return this.scbzrq;
    }
    
    public void setScbzrq(Date scbzrq) {
        this.scbzrq = scbzrq;
    }
    
    @Column(name="bzrq", length=23)

    public Date getBzrq() {
        return this.bzrq;
    }
    
    public void setBzrq(Date bzrq) {
        this.bzrq = bzrq;
    }
    
    @Column(name="zfrq", length=23)

    public Date getZfrq() {
        return this.zfrq;
    }
    
    public void setZfrq(Date zfrq) {
        this.zfrq = zfrq;
    }
    
    @Column(name="zczj", precision=14, scale=4)

    public Double getZczj() {
        return this.zczj;
    }
    
    public void setZczj(Double zczj) {
        this.zczj = zczj;
    }
    
    @Column(name="hbzl", length=3)

    public String getHbzl() {
        return this.hbzl;
    }
    
    public void setHbzl(String hbzl) {
        this.hbzl = hbzl;
    }
    
    @Column(name="wftzgb", length=3)

    public String getWftzgb() {
        return this.wftzgb;
    }
    
    public void setWftzgb(String wftzgb) {
        this.wftzgb = wftzgb;
    }
    
    @Column(name="zgrs")

    public Integer getZgrs() {
        return this.zgrs;
    }
    
    public void setZgrs(Integer zgrs) {
        this.zgrs = zgrs;
    }
    
    @Column(name="bgrq", length=23)

    public Date getBgrq() {
        return this.bgrq;
    }
    
    public void setBgrq(Date bgrq) {
        this.bgrq = bgrq;
    }
    
    @Column(name="zch", length=70)

    public String getZch() {
        return this.zch;
    }
    
    public void setZch(String zch) {
        this.zch = zch;
    }
    
    @Column(name="zgmc", length=200)

    public String getZgmc() {
        return this.zgmc;
    }
    
    public void setZgmc(String zgmc) {
        this.zgmc = zgmc;
    }
    
    @Column(name="pzjgmc", length=200)

    public String getPzjgmc() {
        return this.pzjgmc;
    }
    
    public void setPzjgmc(String pzjgmc) {
        this.pzjgmc = pzjgmc;
    }
    
    @Column(name="email", length=50)

    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Column(name="url", length=50)

    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    @Column(name="mobile", length=15)

    public String getMobile() {
        return this.mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    @Column(name="tbrsfzh", length=25)

    public String getTbrsfzh() {
        return this.tbrsfzh;
    }
    
    public void setTbrsfzh(String tbrsfzh) {
        this.tbrsfzh = tbrsfzh;
    }
    
    @Column(name="tbrxm", length=100)

    public String getTbrxm() {
        return this.tbrxm;
    }
    
    public void setTbrxm(String tbrxm) {
        this.tbrxm = tbrxm;
    }
    
    @Column(name="tbrlxfs", length=50)

    public String getTbrlxfs() {
        return this.tbrlxfs;
    }
    
    public void setTbrlxfs(String tbrlxfs) {
        this.tbrlxfs = tbrlxfs;
    }
    
    @Column(name="jyzt", length=50)

    public String getJyzt() {
        return this.jyzt;
    }
    
    public void setJyzt(String jyzt) {
        this.jyzt = jyzt;
    }
    
    @Column(name="scjyxzqh", length=6)

    public String getScjyxzqh() {
        return this.scjyxzqh;
    }
    
    public void setScjyxzqh(String scjyxzqh) {
        this.scjyxzqh = scjyxzqh;
    }
    
    @Column(name="tbrzjlx", length=2)

    public String getTbrzjlx() {
        return this.tbrzjlx;
    }
    
    public void setTbrzjlx(String tbrzjlx) {
        this.tbrzjlx = tbrzjlx;
    }
    
    @Column(name="tyshxydm", length=18)

    public String getTyshxydm() {
        return this.tyshxydm;
    }
    
    public void setTyshxydm(String tyshxydm) {
        this.tyshxydm = tyshxydm;
    }
    
    @Column(name="ywlx", length=50)

    public String getYwlx() {
        return this.ywlx;
    }
    
    public void setYwlx(String ywlx) {
        this.ywlx = ywlx;
    }
    
    @Column(name="hsfs", length=50)

    public String getHsfs() {
        return this.hsfs;
    }
    
    public void setHsfs(String hsfs) {
        this.hsfs = hsfs;
    }
    
    @Column(name="ismini", length=50)

    public String getIsmini() {
        return this.ismini;
    }
    
    public void setIsmini(String ismini) {
        this.ismini = ismini;
    }
    
    @Column(name="jhbz", length=100)

    public String getJhbz() {
        return this.jhbz;
    }
    
    public void setJhbz(String jhbz) {
        this.jhbz = jhbz;
    }
    
    @Column(name="importdate", length=23)

    public Date getImportdate() {
        return this.importdate;
    }
    
    public void setImportdate(Date importdate) {
        this.importdate = importdate;
    }
    @Column(name="status", length=1)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
   

    @Column(name="bfdwxzqh", length=6)

	public String getBfdwxzqh() {
		return bfdwxzqh;
	}

	public void setBfdwxzqh(String bfdwxzqh) {
		this.bfdwxzqh = bfdwxzqh;
	}






}