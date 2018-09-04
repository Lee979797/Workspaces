package com.ninemax.tygs.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 
/**
 * TGssjId entity. @author MyEclipse Persistence Tools
 */
@javax.persistence.Table(name = "t_gssj")
@Entity
public class TGssj {

	// Fields
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String lsh;
    private String zch;
    private String jgdm;
    private String slxm;
    private String jglx;
    private String jgmc;
    private String fddbr;
    private String zjhm;
    private String zjlx;
    private String jyfw;
    private Date zcrq;
    private String pzjgdm;
    private String pzjgmc;
    private String xzqh;
    private String jgdz;
    private String yzbm;
    private String jjhy2011;
    private String jjlx2011;
    private String dhhm;
    private String mobile;
    private Double zczj;
    private String hbzl;
    private String wftzgb;
    private Integer zgrs;
    private String tbrxm;
    private String tbzjhm;
    private Date jyqx;
    private Date addtime;
    private Date updatetime;
    private Date hqtime;
    private String tqflag;
    private String sjly;
    private String zgmc;
    private String zgdm;
    private String swdjzh;
    private String appid;
    private String pzwh;
    private Date pwrq;
    private String nbqk;
    private String ztzt;
    private String sjqk;
    private String tycode;


 
  
   // Property accessors

   @Column(name="id", nullable=false)

   public Integer getId() {
       return this.id;
   }
   
   public void setId(Integer id) {
       this.id = id;
   }

   @Column(name="lsh", length=100)

   public String getLsh() {
       return this.lsh;
   }
   
   public void setLsh(String lsh) {
       this.lsh = lsh;
   }

   @Column(name="zch", length=70)

   public String getZch() {
       return this.zch;
   }
   
   public void setZch(String zch) {
       this.zch = zch;
   }

   @Column(name="jgdm", length=9)

   public String getJgdm() {
       return this.jgdm;
   }
   
   public void setJgdm(String jgdm) {
       this.jgdm = jgdm;
   }

   @Column(name="slxm", length=2)

   public String getSlxm() {
       return this.slxm;
   }
   
   public void setSlxm(String slxm) {
       this.slxm = slxm;
   }

   @Column(name="jglx", length=5)

   public String getJglx() {
       return this.jglx;
   }
   
   public void setJglx(String jglx) {
       this.jglx = jglx;
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

   @Column(name="zjhm", length=42)

   public String getZjhm() {
       return this.zjhm;
   }
   
   public void setZjhm(String zjhm) {
       this.zjhm = zjhm;
   }

   @Column(name="zjlx", length=2)

   public String getZjlx() {
       return this.zjlx;
   }
   
   public void setZjlx(String zjlx) {
       this.zjlx = zjlx;
   }

   @Column(name="jyfw", length=2000)

   public String getJyfw() {
       return this.jyfw;
   }
   
   public void setJyfw(String jyfw) {
       this.jyfw = jyfw;
   }

   @Column(name="zcrq", length=23)

   public Date getZcrq() {
       return this.zcrq;
   }
   
   public void setZcrq(Date zcrq) {
       this.zcrq = zcrq;
   }

   @Column(name="pzjgdm", length=9)

   public String getPzjgdm() {
       return this.pzjgdm;
   }
   
   public void setPzjgdm(String pzjgdm) {
       this.pzjgdm = pzjgdm;
   }

   @Column(name="pzjgmc", length=200)

   public String getPzjgmc() {
       return this.pzjgmc;
   }
   
   public void setPzjgmc(String pzjgmc) {
       this.pzjgmc = pzjgmc;
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

   @Column(name="jjhy2011", length=7)

   public String getJjhy2011() {
       return this.jjhy2011;
   }
   
   public void setJjhy2011(String jjhy2011) {
       this.jjhy2011 = jjhy2011;
   }

   @Column(name="jjlx2011", length=7)

   public String getJjlx2011() {
       return this.jjlx2011;
   }
   
   public void setJjlx2011(String jjlx2011) {
       this.jjlx2011 = jjlx2011;
   }

   @Column(name="dhhm", length=25)

   public String getDhhm() {
       return this.dhhm;
   }
   
   public void setDhhm(String dhhm) {
       this.dhhm = dhhm;
   }

   @Column(name="mobile", length=25)

   public String getMobile() {
       return this.mobile;
   }
   
   public void setMobile(String mobile) {
       this.mobile = mobile;
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

   @Column(name="tbrxm", length=100)

   public String getTbrxm() {
       return this.tbrxm;
   }
   
   public void setTbrxm(String tbrxm) {
       this.tbrxm = tbrxm;
   }

   @Column(name="tbzjhm", length=42)

   public String getTbzjhm() {
       return this.tbzjhm;
   }
   
   public void setTbzjhm(String tbzjhm) {
       this.tbzjhm = tbzjhm;
   }

   @Column(name="jyqx", length=23)

   public Date getJyqx() {
       return this.jyqx;
   }
   
   public void setJyqx(Date jyqx) {
       this.jyqx = jyqx;
   }

   @Column(name="addtime", length=23)

   public Date getAddtime() {
       return this.addtime;
   }
   
   public void setAddtime(Date addtime) {
       this.addtime = addtime;
   }

   @Column(name="updatetime", length=23)

   public Date getUpdatetime() {
       return this.updatetime;
   }
   
   public void setUpdatetime(Date updatetime) {
       this.updatetime = updatetime;
   }

   @Column(name="hqtime", length=23)

   public Date getHqtime() {
       return this.hqtime;
   }
   
   public void setHqtime(Date hqtime) {
       this.hqtime = hqtime;
   }

   @Column(name="tqflag", length=1)

   public String getTqflag() {
       return this.tqflag;
   }
   
   public void setTqflag(String tqflag) {
       this.tqflag = tqflag;
   }

   @Column(name="sjly", length=6)

   public String getSjly() {
       return this.sjly;
   }
   
   public void setSjly(String sjly) {
       this.sjly = sjly;
   }

   @Column(name="zgmc", length=100)

   public String getZgmc() {
       return this.zgmc;
   }
   
   public void setZgmc(String zgmc) {
       this.zgmc = zgmc;
   }

   @Column(name="zgdm", length=9)

   public String getZgdm() {
       return this.zgdm;
   }
   
   public void setZgdm(String zgdm) {
       this.zgdm = zgdm;
   }

   @Column(name="swdjzh", length=100)

   public String getSwdjzh() {
       return this.swdjzh;
   }
   
   public void setSwdjzh(String swdjzh) {
       this.swdjzh = swdjzh;
   }

   @Column(name="appid", length=100)

   public String getAppid() {
       return this.appid;
   }
   
   public void setAppid(String appid) {
       this.appid = appid;
   }

   @Column(name="pzwh", length=50)

   public String getPzwh() {
       return this.pzwh;
   }
   
   public void setPzwh(String pzwh) {
       this.pzwh = pzwh;
   }

   @Column(name="pwrq", length=23)

   public Date getPwrq() {
       return this.pwrq;
   }
   
   public void setPwrq(Date pwrq) {
       this.pwrq = pwrq;
   }

   @Column(name="nbqk", length=4)

   public String getNbqk() {
       return this.nbqk;
   }
   
   public void setNbqk(String nbqk) {
       this.nbqk = nbqk;
   }

   @Column(name="ztzt", length=30)

   public String getZtzt() {
       return this.ztzt;
   }
   
   public void setZtzt(String ztzt) {
       this.ztzt = ztzt;
   }

   @Column(name="sjqk", length=500)

   public String getSjqk() {
       return this.sjqk;
   }
   
   public void setSjqk(String sjqk) {
       this.sjqk = sjqk;
   }

   @Column(name="tycode", length=18)

   public String getTycode() {
       return this.tycode;
   }
   
   public void setTycode(String tycode) {
       this.tycode = tycode;
   }
  
	
	
	

}