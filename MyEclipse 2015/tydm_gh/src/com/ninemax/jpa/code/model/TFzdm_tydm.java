package com.ninemax.jpa.code.model;


// default package

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * TFzdm entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="t_fzdm")

public class TFzdm_tydm  implements java.io.Serializable {


    // Fields    

     private String jgdm;
     private String jgmc;
     private String jglx;
     private String njglx;
     private String fddbr;
     private String zjlx;
     private String zjhm;
     private String jyfw;
     private String jjhy;
     private String jjlx;
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
     private String bzjgdm;
     private String zycp1;
     private String zycp2;
     private String zycp3;
     private Double zczj;
     private String hbzl;
     private String wftzgb;
     private Integer zgrs;
     private Byte fbsl;
     private String zslsh;
     private String bgbj;
     private Date bgrq;
     private String lry;
     private Date njrq;
     private String njr;
     private Date njqx;
     private String xgr;
     private Byte zbsl;
     private String zch;
     private String qzbz;
     private Date qzrq;
     private String zgmc;
     private String pzjgmc;
     private String gslsh;
     private String gstbr;
     private String wjwlsh;
     private String pzwh;
     private Date pwrq;
     private String wjwtbr;
     private String gk;
     private String fkbz;
     private Integer fksl;
     private String dybz;
     private String email;
     private String url;
     private String mobile;
     private Date lastdate;
     private String czflag;
     private String fzr;
     private String djblx;
     private String sjzt;
     private String yjflag;
     private Date fzrq;
     private String fzyj;
     private String fzreason;
     private String jyjg;
     private Short fz;
     private String njjhy;
     private String memo;
     private String njjlx;
     private String memo2;
     private String tbrxm;
     private String tbrsfzh;
     private String tbrlxfs;
     private Date gsfzrq;
     private String jydz;
     private String jyyb;
     private String jydh;
     private String jfly;
     private String khyh;
     private String khzh;
     private String jgxydm;
     private String memo3;
     private String memo4;
     private String memoBak1;
     private String memoBak2;
     private String memoBak3;
     private String memoBak4;
     private String memoBak5;
     private String tyshxydm;
     private String jyzt;
     private String scjyxzqh;
     private String tbrzjlx;
     private String ywlx;
     private String hsfs;
     private String ismini;

     private String jhbz;



   
    // Property accessors
    @Id 
    
    @Column(name="jgdm", unique=true, nullable=false, length=9)

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
    
    @Column(name="jglx", length=1)

    public String getJglx() {
        return this.jglx;
    }
    
    public void setJglx(String jglx) {
        this.jglx = jglx;
    }
    
    @Column(name="njglx", length=2)

    public String getNjglx() {
        return this.njglx;
    }
    
    public void setNjglx(String njglx) {
        this.njglx = njglx;
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
    
    @Column(name="jjhy", length=5)

    public String getJjhy() {
        return this.jjhy;
    }
    
    public void setJjhy(String jjhy) {
        this.jjhy = jjhy;
    }
    
    @Column(name="jjlx", length=3)

    public String getJjlx() {
        return this.jjlx;
    }
    
    public void setJjlx(String jjlx) {
        this.jjlx = jjlx;
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
    
    @Column(name="bzjgdm", length=6)

    public String getBzjgdm() {
        return this.bzjgdm;
    }
    
    public void setBzjgdm(String bzjgdm) {
        this.bzjgdm = bzjgdm;
    }
    
    @Column(name="zycp1", length=5)

    public String getZycp1() {
        return this.zycp1;
    }
    
    public void setZycp1(String zycp1) {
        this.zycp1 = zycp1;
    }
    
    @Column(name="zycp2", length=5)

    public String getZycp2() {
        return this.zycp2;
    }
    
    public void setZycp2(String zycp2) {
        this.zycp2 = zycp2;
    }
    
    @Column(name="zycp3", length=5)

    public String getZycp3() {
        return this.zycp3;
    }
    
    public void setZycp3(String zycp3) {
        this.zycp3 = zycp3;
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
    
    @Column(name="fbsl", precision=2, scale=0)

    public Byte getFbsl() {
        return this.fbsl;
    }
    
    public void setFbsl(Byte fbsl) {
        this.fbsl = fbsl;
    }
    
    @Column(name="zslsh", length=6)

    public String getZslsh() {
        return this.zslsh;
    }
    
    public void setZslsh(String zslsh) {
        this.zslsh = zslsh;
    }
    
    @Column(name="bgbj", length=1)

    public String getBgbj() {
        return this.bgbj;
    }
    
    public void setBgbj(String bgbj) {
        this.bgbj = bgbj;
    }
    
    @Column(name="bgrq", length=23)

    public Date getBgrq() {
        return this.bgrq;
    }
    
    public void setBgrq(Date bgrq) {
        this.bgrq = bgrq;
    }
    
    @Column(name="lry", length=10)

    public String getLry() {
        return this.lry;
    }
    
    public void setLry(String lry) {
        this.lry = lry;
    }
    
    @Column(name="njrq", length=23)

    public Date getNjrq() {
        return this.njrq;
    }
    
    public void setNjrq(Date njrq) {
        this.njrq = njrq;
    }
    
    @Column(name="njr", length=10)

    public String getNjr() {
        return this.njr;
    }
    
    public void setNjr(String njr) {
        this.njr = njr;
    }
    
    @Column(name="njqx", length=23)

    public Date getNjqx() {
        return this.njqx;
    }
    
    public void setNjqx(Date njqx) {
        this.njqx = njqx;
    }
    
    @Column(name="xgr", length=10)

    public String getXgr() {
        return this.xgr;
    }
    
    public void setXgr(String xgr) {
        this.xgr = xgr;
    }
    
    @Column(name="zbsl", precision=2, scale=0)

    public Byte getZbsl() {
        return this.zbsl;
    }
    
    public void setZbsl(Byte zbsl) {
        this.zbsl = zbsl;
    }
    
    @Column(name="zch", length=70)

    public String getZch() {
        return this.zch;
    }
    
    public void setZch(String zch) {
        this.zch = zch;
    }
    
    @Column(name="qzbz", length=1)

    public String getQzbz() {
        return this.qzbz;
    }
    
    public void setQzbz(String qzbz) {
        this.qzbz = qzbz;
    }
    
    @Column(name="qzrq", length=23)

    public Date getQzrq() {
        return this.qzrq;
    }
    
    public void setQzrq(Date qzrq) {
        this.qzrq = qzrq;
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
    
    @Column(name="gslsh", length=10)

    public String getGslsh() {
        return this.gslsh;
    }
    
    public void setGslsh(String gslsh) {
        this.gslsh = gslsh;
    }
    
    @Column(name="gstbr", length=8)

    public String getGstbr() {
        return this.gstbr;
    }
    
    public void setGstbr(String gstbr) {
        this.gstbr = gstbr;
    }
    
    @Column(name="wjwlsh", length=10)

    public String getWjwlsh() {
        return this.wjwlsh;
    }
    
    public void setWjwlsh(String wjwlsh) {
        this.wjwlsh = wjwlsh;
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
    
    @Column(name="wjwtbr", length=8)

    public String getWjwtbr() {
        return this.wjwtbr;
    }
    
    public void setWjwtbr(String wjwtbr) {
        this.wjwtbr = wjwtbr;
    }
    
    @Column(name="gk", length=1)

    public String getGk() {
        return this.gk;
    }
    
    public void setGk(String gk) {
        this.gk = gk;
    }
    
    @Column(name="fkbz", length=1)

    public String getFkbz() {
        return this.fkbz;
    }
    
    public void setFkbz(String fkbz) {
        this.fkbz = fkbz;
    }
    
    @Column(name="fksl")

    public Integer getFksl() {
        return this.fksl;
    }
    
    public void setFksl(Integer fksl) {
        this.fksl = fksl;
    }
    
    @Column(name="dybz", length=1)

    public String getDybz() {
        return this.dybz;
    }
    
    public void setDybz(String dybz) {
        this.dybz = dybz;
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
    
    @Column(name="lastdate", length=23)

    public Date getLastdate() {
        return this.lastdate;
    }
    
    public void setLastdate(Date lastdate) {
        this.lastdate = lastdate;
    }
    
    @Column(name="czflag", length=1)

    public String getCzflag() {
        return this.czflag;
    }
    
    public void setCzflag(String czflag) {
        this.czflag = czflag;
    }
    
    @Column(name="fzr", length=10)

    public String getFzr() {
        return this.fzr;
    }
    
    public void setFzr(String fzr) {
        this.fzr = fzr;
    }
    
    @Column(name="djblx", length=1)

    public String getDjblx() {
        return this.djblx;
    }
    
    public void setDjblx(String djblx) {
        this.djblx = djblx;
    }
    
    @Column(name="sjzt", length=1)

    public String getSjzt() {
        return this.sjzt;
    }
    
    public void setSjzt(String sjzt) {
        this.sjzt = sjzt;
    }
    
    @Column(name="yjflag", length=1)

    public String getYjflag() {
        return this.yjflag;
    }
    
    public void setYjflag(String yjflag) {
        this.yjflag = yjflag;
    }
    
    @Column(name="fzrq", length=23)

    public Date getFzrq() {
        return this.fzrq;
    }
    
    public void setFzrq(Date fzrq) {
        this.fzrq = fzrq;
    }
    
    @Column(name="fzyj", length=50)

    public String getFzyj() {
        return this.fzyj;
    }
    
    public void setFzyj(String fzyj) {
        this.fzyj = fzyj;
    }
    
    @Column(name="fzreason", length=200)

    public String getFzreason() {
        return this.fzreason;
    }
    
    public void setFzreason(String fzreason) {
        this.fzreason = fzreason;
    }
    
    @Column(name="jyjg", length=30)

    public String getJyjg() {
        return this.jyjg;
    }
    
    public void setJyjg(String jyjg) {
        this.jyjg = jyjg;
    }
    
    @Column(name="fz")

    public Short getFz() {
        return this.fz;
    }
    
    public void setFz(Short fz) {
        this.fz = fz;
    }
    
    @Column(name="njjhy", length=5)

    public String getNjjhy() {
        return this.njjhy;
    }
    
    public void setNjjhy(String njjhy) {
        this.njjhy = njjhy;
    }
    
    @Column(name="memo", length=500)

    public String getMemo() {
        return this.memo;
    }
    
    public void setMemo(String memo) {
        this.memo = memo;
    }
    
    @Column(name="njjlx", length=3)

    public String getNjjlx() {
        return this.njjlx;
    }
    
    public void setNjjlx(String njjlx) {
        this.njjlx = njjlx;
    }
    
    @Column(name="memo2", length=500)

    public String getMemo2() {
        return this.memo2;
    }
    
    public void setMemo2(String memo2) {
        this.memo2 = memo2;
    }
    
    @Column(name="tbrxm", length=60)

    public String getTbrxm() {
        return this.tbrxm;
    }
    
    public void setTbrxm(String tbrxm) {
        this.tbrxm = tbrxm;
    }
    
    @Column(name="tbrsfzh", length=25)

    public String getTbrsfzh() {
        return this.tbrsfzh;
    }
    
    public void setTbrsfzh(String tbrsfzh) {
        this.tbrsfzh = tbrsfzh;
    }
    
    @Column(name="tbrlxfs", length=50)

    public String getTbrlxfs() {
        return this.tbrlxfs;
    }
    
    public void setTbrlxfs(String tbrlxfs) {
        this.tbrlxfs = tbrlxfs;
    }
    
    @Column(name="gsfzrq", length=23)

    public Date getGsfzrq() {
        return this.gsfzrq;
    }
    
    public void setGsfzrq(Date gsfzrq) {
        this.gsfzrq = gsfzrq;
    }
    
    @Column(name="jydz", length=240)

    public String getJydz() {
        return this.jydz;
    }
    
    public void setJydz(String jydz) {
        this.jydz = jydz;
    }
    
    @Column(name="jyyb", length=6)

    public String getJyyb() {
        return this.jyyb;
    }
    
    public void setJyyb(String jyyb) {
        this.jyyb = jyyb;
    }
    
    @Column(name="jydh", length=25)

    public String getJydh() {
        return this.jydh;
    }
    
    public void setJydh(String jydh) {
        this.jydh = jydh;
    }
    
    @Column(name="jfly", length=16)

    public String getJfly() {
        return this.jfly;
    }
    
    public void setJfly(String jfly) {
        this.jfly = jfly;
    }
    
    @Column(name="khyh", length=100)

    public String getKhyh() {
        return this.khyh;
    }
    
    public void setKhyh(String khyh) {
        this.khyh = khyh;
    }
    
    @Column(name="khzh", length=25)

    public String getKhzh() {
        return this.khzh;
    }
    
    public void setKhzh(String khzh) {
        this.khzh = khzh;
    }
    
    @Column(name="jgxydm", length=50)

    public String getJgxydm() {
        return this.jgxydm;
    }
    
    public void setJgxydm(String jgxydm) {
        this.jgxydm = jgxydm;
    }
    
    @Column(name="memo3", length=500)

    public String getMemo3() {
        return this.memo3;
    }
    
    public void setMemo3(String memo3) {
        this.memo3 = memo3;
    }
    
    @Column(name="memo4", length=500)

    public String getMemo4() {
        return this.memo4;
    }
    
    public void setMemo4(String memo4) {
        this.memo4 = memo4;
    }
    
    @Column(name="memo_bak1", length=500)

    public String getMemoBak1() {
        return this.memoBak1;
    }
    
    public void setMemoBak1(String memoBak1) {
        this.memoBak1 = memoBak1;
    }
    
    @Column(name="memo_bak2", length=500)

    public String getMemoBak2() {
        return this.memoBak2;
    }
    
    public void setMemoBak2(String memoBak2) {
        this.memoBak2 = memoBak2;
    }
    
    @Column(name="memo_bak3", length=500)

    public String getMemoBak3() {
        return this.memoBak3;
    }
    
    public void setMemoBak3(String memoBak3) {
        this.memoBak3 = memoBak3;
    }
    
    @Column(name="memo_bak4", length=500)

    public String getMemoBak4() {
        return this.memoBak4;
    }
    
    public void setMemoBak4(String memoBak4) {
        this.memoBak4 = memoBak4;
    }
    
    @Column(name="memo_bak5", length=500)

    public String getMemoBak5() {
        return this.memoBak5;
    }
    
    public void setMemoBak5(String memoBak5) {
        this.memoBak5 = memoBak5;
    }
    
    @Column(name="tyshxydm", length=18)

    public String getTyshxydm() {
        return this.tyshxydm;
    }
    
    public void setTyshxydm(String tyshxydm) {
        this.tyshxydm = tyshxydm;
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
    

    
    @Column(name="jhbz", length=6)

    public String getJhbz() {
        return this.jhbz;
    }
    
    public void setJhbz(String jhbz) {
        this.jhbz = jhbz;
    }
   








}