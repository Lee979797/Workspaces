package com.ninemax.jpa.code.model;

import javax.persistence.*;
import java.util.Date;

/**
 * User: yzhhui
 * Date: 13-4-23
 * Time: ÉÏÎç10:48
 */
@javax.persistence.Table(name = "T_QZDM")
@Entity
public class TQzdmDb1 {
    private Integer id;

    @javax.persistence.Column(name = "ID")
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer  getId() {
        return id;
    }

    public void  setId(Integer id) {
        this.id = id;
    }

    private String jgdm;

    @javax.persistence.Column(name = "JGDM")
    @Basic
    public String  getJgdm() {
        return jgdm;
    }

    public void  setJgdm(String jgdm) {
        this.jgdm = jgdm;
    }

    private String jgmc;

    @javax.persistence.Column(name = "JGMC")
    @Basic
    public String  getJgmc() {
        return jgmc;
    }

    public void  setJgmc(String jgmc) {
        this.jgmc = jgmc;
    }

    private String jyfw;

    @javax.persistence.Column(name = "JYFW")
    @Basic
    public String  getJyfw() {
        return jyfw;
    }

    public void  setJyfw(String jyfw) {
        this.jyfw = jyfw;
    }

    private String xzqh;

    @javax.persistence.Column(name = "XZQH")
    @Basic
    public String  getXzqh() {
        return xzqh;
    }

    public void  setXzqh(String xzqh) {
        this.xzqh = xzqh;
    }

    private String jgdz;

    @javax.persistence.Column(name = "JGDZ")
    @Basic
    public String  getJgdz() {
        return jgdz;
    }

    public void  setJgdz(String jgdz) {
        this.jgdz = jgdz;
    }

    private String fddbr;

    @javax.persistence.Column(name = "FDDBR")
    @Basic
    public String  getFddbr() {
        return fddbr;
    }

    public void  setFddbr(String fddbr) {
        this.fddbr = fddbr;
    }

    private String zjlx;

    @javax.persistence.Column(name = "ZJLX")
    @Basic
    public String  getZjlx() {
        return zjlx;
    }

    public void  setZjlx(String zjlx) {
        this.zjlx = zjlx;
    }

    private String zjhm;

    @javax.persistence.Column(name = "ZJHM")
    @Basic
    public String  getZjhm() {
        return zjhm;
    }

    public void  setZjhm(String zjhm) {
        this.zjhm = zjhm;
    }

    private String bzjgdm;

    @javax.persistence.Column(name = "BZJGDM")
    @Basic
    public String  getBzjgdm() {
        return bzjgdm;
    }

    public void  setBzjgdm(String bzjgdm) {
        this.bzjgdm = bzjgdm;
    }

    private String jjhy;

    @javax.persistence.Column(name = "JJHY")
    @Basic
    public String  getJjhy() {
        return jjhy;
    }

    public void  setJjhy(String jjhy) {
        this.jjhy = jjhy;
    }

    private String jglx;

    @javax.persistence.Column(name = "JGLX")
    @Basic
    public String  getJglx() {
        return jglx;
    }

    public void  setJglx(String jglx) {
        this.jglx = jglx;
    }

    private String jjlx;

    @javax.persistence.Column(name = "JJLX")
    @Basic
    public String  getJjlx() {
        return jjlx;
    }

    public void  setJjlx(String jjlx) {
        this.jjlx = jjlx;
    }

    private String zch;

    @javax.persistence.Column(name = "ZCH")
    @Basic
    public String  getZch() {
        return zch;
    }

    public void  setZch(String zch) {
        this.zch = zch;
    }

    private Date zcrq;

    @javax.persistence.Column(name = "ZCRQ")
    @Basic
    public Date  getZcrq() {
        return zcrq;
    }

    public void  setZcrq(Date zcrq) {
        this.zcrq = zcrq;
    }

    private Double zczj;

    @javax.persistence.Column(name = "ZCZJ")
    @Basic
    public Double  getZczj() {
        return zczj;
    }

    public void  setZczj(Double zczj) {
        this.zczj = zczj;
    }

    private String hbzl;

    @javax.persistence.Column(name = "HBZL")
    @Basic
    public String  getHbzl() {
        return hbzl;
    }

    public void  setHbzl(String hbzl) {
        this.hbzl = hbzl;
    }

    private String wftzgb;

    @javax.persistence.Column(name = "WFTZGB")
    @Basic
    public String  getWftzgb() {
        return wftzgb;
    }

    public void  setWftzgb(String wftzgb) {
        this.wftzgb = wftzgb;
    }

    private Integer zgrs;

    @javax.persistence.Column(name = "ZGRS")
    @Basic
    public Integer  getZgrs() {
        return zgrs;
    }

    public void  setZgrs(Integer zgrs) {
        this.zgrs = zgrs;
    }

    private String yzbm;

    @javax.persistence.Column(name = "YZBM")
    @Basic
    public String  getYzbm() {
        return yzbm;
    }

    public void  setYzbm(String yzbm) {
        this.yzbm = yzbm;
    }

    private String dhhm;

    @javax.persistence.Column(name = "DHHM")
    @Basic
    public String  getDhhm() {
        return dhhm;
    }

    public void  setDhhm(String dhhm) {
        this.dhhm = dhhm;
    }

    private String pzjgdm;

    @javax.persistence.Column(name = "PZJGDM")
    @Basic
    public String  getPzjgdm() {
        return pzjgdm;
    }

    public void  setPzjgdm(String pzjgdm) {
        this.pzjgdm = pzjgdm;
    }

    private String pzjgmc;

    @javax.persistence.Column(name = "PZJGMC")
    @Basic
    public String  getPzjgmc() {
        return pzjgmc;
    }

    public void  setPzjgmc(String pzjgmc) {
        this.pzjgmc = pzjgmc;
    }

    private String pzwh;

    @javax.persistence.Column(name = "PZWH")
    @Basic
    public String  getPzwh() {
        return pzwh;
    }

    public void  setPzwh(String pzwh) {
        this.pzwh = pzwh;
    }

    private Date pwrq;

    @javax.persistence.Column(name = "PWRQ")
    @Basic
    public Date  getPwrq() {
        return pwrq;
    }

    public void  setPwrq(Date pwrq) {
        this.pwrq = pwrq;
    }

    private String zgdm;

    @javax.persistence.Column(name = "ZGDM")
    @Basic
    public String  getZgdm() {
        return zgdm;
    }

    public void  setZgdm(String zgdm) {
        this.zgdm = zgdm;
    }

    private String zgmc;

    @javax.persistence.Column(name = "ZGMC")
    @Basic
    public String  getZgmc() {
        return zgmc;
    }

    public void  setZgmc(String zgmc) {
        this.zgmc = zgmc;
    }

    private String gk;

    @javax.persistence.Column(name = "GK")
    @Basic
    public String  getGk() {
        return gk;
    }

    public void  setGk(String gk) {
        this.gk = gk;
    }

    private Date scbzrq;

    @javax.persistence.Column(name = "SCBZRQ")
    @Basic
    public Date  getScbzrq() {
        return scbzrq;
    }

    public void  setScbzrq(Date scbzrq) {
        this.scbzrq = scbzrq;
    }

    private Date bzrq;

    @javax.persistence.Column(name = "BZRQ")
    @Basic
    public Date  getBzrq() {
        return bzrq;
    }

    public void  setBzrq(Date bzrq) {
        this.bzrq = bzrq;
    }

    private Date zfrq;

    @javax.persistence.Column(name = "ZFRQ")
    @Basic
    public Date  getZfrq() {
        return zfrq;
    }

    public void  setZfrq(Date zfrq) {
        this.zfrq = zfrq;
    }

    private Date njrq;

    @javax.persistence.Column(name = "NJRQ")
    @Basic
    public Date  getNjrq() {
        return njrq;
    }

    public void  setNjrq(Date njrq) {
        this.njrq = njrq;
    }

    private Date njqx;

    @javax.persistence.Column(name = "NJQX")
    @Basic
    public Date  getNjqx() {
        return njqx;
    }

    public void  setNjqx(Date njqx) {
        this.njqx = njqx;
    }

    private String njr;

    @javax.persistence.Column(name = "NJR")
    @Basic
    public String  getNjr() {
        return njr;
    }

    public void  setNjr(String njr) {
        this.njr = njr;
    }

    private String bgbj;

    @javax.persistence.Column(name = "BGBJ")
    @Basic
    public String  getBgbj() {
        return bgbj;
    }

    public void  setBgbj(String bgbj) {
        this.bgbj = bgbj;
    }

    private Date bgrq;

    @javax.persistence.Column(name = "BGRQ")
    @Basic
    public Date  getBgrq() {
        return bgrq;
    }

    public void  setBgrq(Date bgrq) {
        this.bgrq = bgrq;
    }

    private String qzbz;

    @javax.persistence.Column(name = "QZBZ")
    @Basic
    public String  getQzbz() {
        return qzbz;
    }

    public void  setQzbz(String qzbz) {
        this.qzbz = qzbz;
    }

    private Date qzrq;

    @javax.persistence.Column(name = "QZRQ")
    @Basic
    public Date  getQzrq() {
        return qzrq;
    }

    public void  setQzrq(Date qzrq) {
        this.qzrq = qzrq;
    }

    private Date lastdate;

    @javax.persistence.Column(name = "LASTDATE")
    @Basic
    public Date  getLastdate() {
        return lastdate;
    }

    public void  setLastdate(Date lastdate) {
        this.lastdate = lastdate;
    }

    private String xgr;

    @javax.persistence.Column(name = "XGR")
    @Basic
    public String  getXgr() {
        return xgr;
    }

    public void  setXgr(String xgr) {
        this.xgr = xgr;
    }

    private String njjlx;

    @javax.persistence.Column(name = "NJJLX")
    @Basic
    public String  getNjjlx() {
        return njjlx;
    }

    public void  setNjjlx(String njjlx) {
        this.njjlx = njjlx;
    }

    private String njjhy;

    @javax.persistence.Column(name = "NJJHY")
    @Basic
    public String  getNjjhy() {
        return njjhy;
    }

    public void  setNjjhy(String njjhy) {
        this.njjhy = njjhy;
    }

    private String email;

    @javax.persistence.Column(name = "EMAIL")
    @Basic
    public String  getEmail() {
        return email;
    }

    public void  setEmail(String email) {
        this.email = email;
    }

    private String mobile;

    @javax.persistence.Column(name = "MOBILE")
    @Basic
    public String  getMobile() {
        return mobile;
    }

    public void  setMobile(String mobile) {
        this.mobile = mobile;
    }

    private String url;

    @javax.persistence.Column(name = "URL")
    @Basic
    public String  getUrl() {
        return url;
    }

    public void  setUrl(String url) {
        this.url = url;
    }

    private String dybz;

    @javax.persistence.Column(name = "DYBZ")
    @Basic
    public String  getDybz() {
        return dybz;
    }

    public void  setDybz(String dybz) {
        this.dybz = dybz;
    }

    private String fkbz;

    @javax.persistence.Column(name = "FKBZ")
    @Basic
    public String  getFkbz() {
        return fkbz;
    }

    public void  setFkbz(String fkbz) {
        this.fkbz = fkbz;
    }

    private Integer fksl;

    @javax.persistence.Column(name = "FKSL")
    @Basic
    public Integer  getFksl() {
        return fksl;
    }

    public void  setFksl(Integer fksl) {
        this.fksl = fksl;
    }

    private String zslsh;

    @javax.persistence.Column(name = "ZSLSH")
    @Basic
    public String  getZslsh() {
        return zslsh;
    }

    public void  setZslsh(String zslsh) {
        this.zslsh = zslsh;
    }

    private Integer zbsl;

    @javax.persistence.Column(name = "ZBSL")
    @Basic
    public Integer  getZbsl() {
        return zbsl;
    }

    public void  setZbsl(Integer zbsl) {
        this.zbsl = zbsl;
    }

    private Integer fbsl;

    @javax.persistence.Column(name = "FBSL")
    @Basic
    public Integer  getFbsl() {
        return fbsl;
    }

    public void  setFbsl(Integer fbsl) {
        this.fbsl = fbsl;
    }

    private String lry;

    @javax.persistence.Column(name = "LRY")
    @Basic
    public String  getLry() {
        return lry;
    }

    public void  setLry(String lry) {
        this.lry = lry;
    }

    private String gstbr;

    @javax.persistence.Column(name = "GSTBR")
    @Basic
    public String  getGstbr() {
        return gstbr;
    }

    public void  setGstbr(String gstbr) {
        this.gstbr = gstbr;
    }

    private String gslsh;

    @javax.persistence.Column(name = "GSLSH")
    @Basic
    public String  getGslsh() {
        return gslsh;
    }

    public void  setGslsh(String gslsh) {
        this.gslsh = gslsh;
    }

    private String wjwtbr;

    @javax.persistence.Column(name = "WJWTBR")
    @Basic
    public String  getWjwtbr() {
        return wjwtbr;
    }

    public void  setWjwtbr(String wjwtbr) {
        this.wjwtbr = wjwtbr;
    }

    private String wjwlsh;

    @javax.persistence.Column(name = "WJWLSH")
    @Basic
    public String  getWjwlsh() {
        return wjwlsh;
    }

    public void  setWjwlsh(String wjwlsh) {
        this.wjwlsh = wjwlsh;
    }

    private String djblx;

    @javax.persistence.Column(name = "DJBLX")
    @Basic
    public String  getDjblx() {
        return djblx;
    }

    public void  setDjblx(String djblx) {
        this.djblx = djblx;
    }

    private String zycp1;

    @javax.persistence.Column(name = "ZYCP1")
    @Basic
    public String  getZycp1() {
        return zycp1;
    }

    public void  setZycp1(String zycp1) {
        this.zycp1 = zycp1;
    }

    private String zycp2;

    @javax.persistence.Column(name = "ZYCP2")
    @Basic
    public String  getZycp2() {
        return zycp2;
    }

    public void  setZycp2(String zycp2) {
        this.zycp2 = zycp2;
    }

    private String zycp3;

    @javax.persistence.Column(name = "ZYCP3")
    @Basic
    public String  getZycp3() {
        return zycp3;
    }

    public void  setZycp3(String zycp3) {
        this.zycp3 = zycp3;
    }

    private String tbrxm;

    @javax.persistence.Column(name = "TBRXM")
    @Basic
    public String  getTbrxm() {
        return tbrxm;
    }

    public void  setTbrxm(String tbrxm) {
        this.tbrxm = tbrxm;
    }

    private String tbrsfzh;

    @javax.persistence.Column(name = "TBRSFZH")
    @Basic
    public String  getTbrsfzh() {
        return tbrsfzh;
    }

    public void  setTbrsfzh(String tbrsfzh) {
        this.tbrsfzh = tbrsfzh;
    }

    private String tbrlxfs;

    @javax.persistence.Column(name = "TBRLXFS")
    @Basic
    public String  getTbrlxfs() {
        return tbrlxfs;
    }

    public void  setTbrlxfs(String tbrlxfs) {
        this.tbrlxfs = tbrlxfs;
    }

    private String yjflag;

    @javax.persistence.Column(name = "YJFLAG")
    @Basic
    public String  getYjflag() {
        return yjflag;
    }

    public void  setYjflag(String yjflag) {
        this.yjflag = yjflag;
    }

    private String jfly;

    @javax.persistence.Column(name = "JFLY")
    @Basic
    public String  getJfly() {
        return jfly;
    }

    public void  setJfly(String jfly) {
        this.jfly = jfly;
    }

    private String khyh;

    @javax.persistence.Column(name = "KHYH")
    @Basic
    public String  getKhyh() {
        return khyh;
    }

    public void  setKhyh(String khyh) {
        this.khyh = khyh;
    }

    private String khzh;

    @javax.persistence.Column(name = "KHZH")
    @Basic
    public String  getKhzh() {
        return khzh;
    }

    public void  setKhzh(String khzh) {
        this.khzh = khzh;
    }

    private String memo1;

    @javax.persistence.Column(name = "MEMO1")
    @Basic
    public String  getMemo1() {
        return memo1;
    }

    public void  setMemo1(String memo1) {
        this.memo1 = memo1;
    }

    private String memo2;

    @javax.persistence.Column(name = "MEMO2")
    @Basic
    public String  getMemo2() {
        return memo2;
    }

    public void  setMemo2(String memo2) {
        this.memo2 = memo2;
    }

    private String isca;

    @javax.persistence.Column(name = "ISCA")
    @Basic
    public String  getIsca() {
        return isca;
    }

    public void  setIsca(String isca) {
        this.isca = isca;
    }

    private Date gsfzrq;

    @javax.persistence.Column(name = "GSFZRQ")
    @Basic
    public Date  getGsfzrq() {
        return gsfzrq;
    }

    public void  setGsfzrq(Date gsfzrq) {
        this.gsfzrq = gsfzrq;
    }

    private String jydz;

    @javax.persistence.Column(name = "JYDZ")
    @Basic
    public String  getJydz() {
        return jydz;
    }

    public void  setJydz(String jydz) {
        this.jydz = jydz;
    }

    private String jyyb;

    @javax.persistence.Column(name = "JYYB")
    @Basic
    public String  getJyyb() {
        return jyyb;
    }

    public void  setJyyb(String jyyb) {
        this.jyyb = jyyb;
    }

    private String jydh;

    @javax.persistence.Column(name = "JYDH")
    @Basic
    public String  getJydh() {
        return jydh;
    }

    public void  setJydh(String jydh) {
        this.jydh = jydh;
    }

    private String qrdxzqh;

    @javax.persistence.Column(name = "QRDXZQH")
    @Basic
    public String  getQrdxzqh() {
        return qrdxzqh;
    }

    public void  setQrdxzqh(String qrdxzqh) {
        this.qrdxzqh = qrdxzqh;
    }

    private String qrdszxdm;

    @javax.persistence.Column(name = "QRDSZXDM")
    @Basic
    public String  getQrdszxdm() {
        return qrdszxdm;
    }

    public void  setQrdszxdm(String qrdszxdm) {
        this.qrdszxdm = qrdszxdm;
    }

    private String qrdbzjgdm;

    @javax.persistence.Column(name = "QRDBZJGDM")
    @Basic
    public String  getQrdbzjgdm() {
        return qrdbzjgdm;
    }

    public void  setQrdbzjgdm(String qrdbzjgdm) {
        this.qrdbzjgdm = qrdbzjgdm;
    }

    private Date qcrq;

    @javax.persistence.Column(name = "QCRQ")
    @Basic
    public Date  getQcrq() {
        return qcrq;
    }

    public void  setQcrq(Date qcrq) {
        this.qcrq = qcrq;
    }

    private String qzr;

    @javax.persistence.Column(name = "QZR")
    @Basic
    public String  getQzr() {
        return qzr;
    }

    public void  setQzr(String qzr) {
        this.qzr = qzr;
    }

    private String importdate;

    @javax.persistence.Column(name = "IMPORTDATE")
    @Basic
    public String  getImportdate() {
        return importdate;
    }

    public void  setImportdate(String importdate) {
        this.importdate = importdate;
    }

    private String ssss;

    @javax.persistence.Column(name = "SSSS")
    @Basic
    public String  getSsss() {
        return ssss;
    }

    public void  setSsss(String ssss) {
        this.ssss = ssss;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TQzdmDb1 tQzdmDb1 = (TQzdmDb1) o;

        if (bgbj != null ? !bgbj.equals(tQzdmDb1.bgbj) : tQzdmDb1.bgbj != null) return false;
        if (bgrq != null ? !bgrq.equals(tQzdmDb1.bgrq) : tQzdmDb1.bgrq != null) return false;
        if (bzjgdm != null ? !bzjgdm.equals(tQzdmDb1.bzjgdm) : tQzdmDb1.bzjgdm != null) return false;
        if (bzrq != null ? !bzrq.equals(tQzdmDb1.bzrq) : tQzdmDb1.bzrq != null) return false;
        if (dhhm != null ? !dhhm.equals(tQzdmDb1.dhhm) : tQzdmDb1.dhhm != null) return false;
        if (djblx != null ? !djblx.equals(tQzdmDb1.djblx) : tQzdmDb1.djblx != null) return false;
        if (dybz != null ? !dybz.equals(tQzdmDb1.dybz) : tQzdmDb1.dybz != null) return false;
        if (email != null ? !email.equals(tQzdmDb1.email) : tQzdmDb1.email != null) return false;
        if (fbsl != null ? !fbsl.equals(tQzdmDb1.fbsl) : tQzdmDb1.fbsl != null) return false;
        if (fddbr != null ? !fddbr.equals(tQzdmDb1.fddbr) : tQzdmDb1.fddbr != null) return false;
        if (fkbz != null ? !fkbz.equals(tQzdmDb1.fkbz) : tQzdmDb1.fkbz != null) return false;
        if (fksl != null ? !fksl.equals(tQzdmDb1.fksl) : tQzdmDb1.fksl != null) return false;
        if (gk != null ? !gk.equals(tQzdmDb1.gk) : tQzdmDb1.gk != null) return false;
        if (gsfzrq != null ? !gsfzrq.equals(tQzdmDb1.gsfzrq) : tQzdmDb1.gsfzrq != null) return false;
        if (gslsh != null ? !gslsh.equals(tQzdmDb1.gslsh) : tQzdmDb1.gslsh != null) return false;
        if (gstbr != null ? !gstbr.equals(tQzdmDb1.gstbr) : tQzdmDb1.gstbr != null) return false;
        if (hbzl != null ? !hbzl.equals(tQzdmDb1.hbzl) : tQzdmDb1.hbzl != null) return false;
        if (id != null ? !id.equals(tQzdmDb1.id) : tQzdmDb1.id != null) return false;
        if (importdate != null ? !importdate.equals(tQzdmDb1.importdate) : tQzdmDb1.importdate != null) return false;
        if (isca != null ? !isca.equals(tQzdmDb1.isca) : tQzdmDb1.isca != null) return false;
        if (jfly != null ? !jfly.equals(tQzdmDb1.jfly) : tQzdmDb1.jfly != null) return false;
        if (jgdm != null ? !jgdm.equals(tQzdmDb1.jgdm) : tQzdmDb1.jgdm != null) return false;
        if (jgdz != null ? !jgdz.equals(tQzdmDb1.jgdz) : tQzdmDb1.jgdz != null) return false;
        if (jglx != null ? !jglx.equals(tQzdmDb1.jglx) : tQzdmDb1.jglx != null) return false;
        if (jgmc != null ? !jgmc.equals(tQzdmDb1.jgmc) : tQzdmDb1.jgmc != null) return false;
        if (jjhy != null ? !jjhy.equals(tQzdmDb1.jjhy) : tQzdmDb1.jjhy != null) return false;
        if (jjlx != null ? !jjlx.equals(tQzdmDb1.jjlx) : tQzdmDb1.jjlx != null) return false;
        if (jydh != null ? !jydh.equals(tQzdmDb1.jydh) : tQzdmDb1.jydh != null) return false;
        if (jydz != null ? !jydz.equals(tQzdmDb1.jydz) : tQzdmDb1.jydz != null) return false;
        if (jyfw != null ? !jyfw.equals(tQzdmDb1.jyfw) : tQzdmDb1.jyfw != null) return false;
        if (jyyb != null ? !jyyb.equals(tQzdmDb1.jyyb) : tQzdmDb1.jyyb != null) return false;
        if (khyh != null ? !khyh.equals(tQzdmDb1.khyh) : tQzdmDb1.khyh != null) return false;
        if (khzh != null ? !khzh.equals(tQzdmDb1.khzh) : tQzdmDb1.khzh != null) return false;
        if (lastdate != null ? !lastdate.equals(tQzdmDb1.lastdate) : tQzdmDb1.lastdate != null) return false;
        if (lry != null ? !lry.equals(tQzdmDb1.lry) : tQzdmDb1.lry != null) return false;
        if (memo1 != null ? !memo1.equals(tQzdmDb1.memo1) : tQzdmDb1.memo1 != null) return false;
        if (memo2 != null ? !memo2.equals(tQzdmDb1.memo2) : tQzdmDb1.memo2 != null) return false;
        if (mobile != null ? !mobile.equals(tQzdmDb1.mobile) : tQzdmDb1.mobile != null) return false;
        if (njjhy != null ? !njjhy.equals(tQzdmDb1.njjhy) : tQzdmDb1.njjhy != null) return false;
        if (njjlx != null ? !njjlx.equals(tQzdmDb1.njjlx) : tQzdmDb1.njjlx != null) return false;
        if (njqx != null ? !njqx.equals(tQzdmDb1.njqx) : tQzdmDb1.njqx != null) return false;
        if (njr != null ? !njr.equals(tQzdmDb1.njr) : tQzdmDb1.njr != null) return false;
        if (njrq != null ? !njrq.equals(tQzdmDb1.njrq) : tQzdmDb1.njrq != null) return false;
        if (pwrq != null ? !pwrq.equals(tQzdmDb1.pwrq) : tQzdmDb1.pwrq != null) return false;
        if (pzjgdm != null ? !pzjgdm.equals(tQzdmDb1.pzjgdm) : tQzdmDb1.pzjgdm != null) return false;
        if (pzjgmc != null ? !pzjgmc.equals(tQzdmDb1.pzjgmc) : tQzdmDb1.pzjgmc != null) return false;
        if (pzwh != null ? !pzwh.equals(tQzdmDb1.pzwh) : tQzdmDb1.pzwh != null) return false;
        if (qcrq != null ? !qcrq.equals(tQzdmDb1.qcrq) : tQzdmDb1.qcrq != null) return false;
        if (qrdbzjgdm != null ? !qrdbzjgdm.equals(tQzdmDb1.qrdbzjgdm) : tQzdmDb1.qrdbzjgdm != null) return false;
        if (qrdszxdm != null ? !qrdszxdm.equals(tQzdmDb1.qrdszxdm) : tQzdmDb1.qrdszxdm != null) return false;
        if (qrdxzqh != null ? !qrdxzqh.equals(tQzdmDb1.qrdxzqh) : tQzdmDb1.qrdxzqh != null) return false;
        if (qzbz != null ? !qzbz.equals(tQzdmDb1.qzbz) : tQzdmDb1.qzbz != null) return false;
        if (qzr != null ? !qzr.equals(tQzdmDb1.qzr) : tQzdmDb1.qzr != null) return false;
        if (qzrq != null ? !qzrq.equals(tQzdmDb1.qzrq) : tQzdmDb1.qzrq != null) return false;
        if (scbzrq != null ? !scbzrq.equals(tQzdmDb1.scbzrq) : tQzdmDb1.scbzrq != null) return false;
        if (ssss != null ? !ssss.equals(tQzdmDb1.ssss) : tQzdmDb1.ssss != null) return false;
        if (tbrlxfs != null ? !tbrlxfs.equals(tQzdmDb1.tbrlxfs) : tQzdmDb1.tbrlxfs != null) return false;
        if (tbrsfzh != null ? !tbrsfzh.equals(tQzdmDb1.tbrsfzh) : tQzdmDb1.tbrsfzh != null) return false;
        if (tbrxm != null ? !tbrxm.equals(tQzdmDb1.tbrxm) : tQzdmDb1.tbrxm != null) return false;
        if (url != null ? !url.equals(tQzdmDb1.url) : tQzdmDb1.url != null) return false;
        if (wftzgb != null ? !wftzgb.equals(tQzdmDb1.wftzgb) : tQzdmDb1.wftzgb != null) return false;
        if (wjwlsh != null ? !wjwlsh.equals(tQzdmDb1.wjwlsh) : tQzdmDb1.wjwlsh != null) return false;
        if (wjwtbr != null ? !wjwtbr.equals(tQzdmDb1.wjwtbr) : tQzdmDb1.wjwtbr != null) return false;
        if (xgr != null ? !xgr.equals(tQzdmDb1.xgr) : tQzdmDb1.xgr != null) return false;
        if (xzqh != null ? !xzqh.equals(tQzdmDb1.xzqh) : tQzdmDb1.xzqh != null) return false;
        if (yjflag != null ? !yjflag.equals(tQzdmDb1.yjflag) : tQzdmDb1.yjflag != null) return false;
        if (yzbm != null ? !yzbm.equals(tQzdmDb1.yzbm) : tQzdmDb1.yzbm != null) return false;
        if (zbsl != null ? !zbsl.equals(tQzdmDb1.zbsl) : tQzdmDb1.zbsl != null) return false;
        if (zch != null ? !zch.equals(tQzdmDb1.zch) : tQzdmDb1.zch != null) return false;
        if (zcrq != null ? !zcrq.equals(tQzdmDb1.zcrq) : tQzdmDb1.zcrq != null) return false;
        if (zczj != null ? !zczj.equals(tQzdmDb1.zczj) : tQzdmDb1.zczj != null) return false;
        if (zfrq != null ? !zfrq.equals(tQzdmDb1.zfrq) : tQzdmDb1.zfrq != null) return false;
        if (zgdm != null ? !zgdm.equals(tQzdmDb1.zgdm) : tQzdmDb1.zgdm != null) return false;
        if (zgmc != null ? !zgmc.equals(tQzdmDb1.zgmc) : tQzdmDb1.zgmc != null) return false;
        if (zgrs != null ? !zgrs.equals(tQzdmDb1.zgrs) : tQzdmDb1.zgrs != null) return false;
        if (zjhm != null ? !zjhm.equals(tQzdmDb1.zjhm) : tQzdmDb1.zjhm != null) return false;
        if (zjlx != null ? !zjlx.equals(tQzdmDb1.zjlx) : tQzdmDb1.zjlx != null) return false;
        if (zslsh != null ? !zslsh.equals(tQzdmDb1.zslsh) : tQzdmDb1.zslsh != null) return false;
        if (zycp1 != null ? !zycp1.equals(tQzdmDb1.zycp1) : tQzdmDb1.zycp1 != null) return false;
        if (zycp2 != null ? !zycp2.equals(tQzdmDb1.zycp2) : tQzdmDb1.zycp2 != null) return false;
        if (zycp3 != null ? !zycp3.equals(tQzdmDb1.zycp3) : tQzdmDb1.zycp3 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (jgdm != null ? jgdm.hashCode() : 0);
        result = 31 * result + (jgmc != null ? jgmc.hashCode() : 0);
        result = 31 * result + (jyfw != null ? jyfw.hashCode() : 0);
        result = 31 * result + (xzqh != null ? xzqh.hashCode() : 0);
        result = 31 * result + (jgdz != null ? jgdz.hashCode() : 0);
        result = 31 * result + (fddbr != null ? fddbr.hashCode() : 0);
        result = 31 * result + (zjlx != null ? zjlx.hashCode() : 0);
        result = 31 * result + (zjhm != null ? zjhm.hashCode() : 0);
        result = 31 * result + (bzjgdm != null ? bzjgdm.hashCode() : 0);
        result = 31 * result + (jjhy != null ? jjhy.hashCode() : 0);
        result = 31 * result + (jglx != null ? jglx.hashCode() : 0);
        result = 31 * result + (jjlx != null ? jjlx.hashCode() : 0);
        result = 31 * result + (zch != null ? zch.hashCode() : 0);
        result = 31 * result + (zcrq != null ? zcrq.hashCode() : 0);
        result = 31 * result + (zczj != null ? zczj.hashCode() : 0);
        result = 31 * result + (hbzl != null ? hbzl.hashCode() : 0);
        result = 31 * result + (wftzgb != null ? wftzgb.hashCode() : 0);
        result = 31 * result + (zgrs != null ? zgrs.hashCode() : 0);
        result = 31 * result + (yzbm != null ? yzbm.hashCode() : 0);
        result = 31 * result + (dhhm != null ? dhhm.hashCode() : 0);
        result = 31 * result + (pzjgdm != null ? pzjgdm.hashCode() : 0);
        result = 31 * result + (pzjgmc != null ? pzjgmc.hashCode() : 0);
        result = 31 * result + (pzwh != null ? pzwh.hashCode() : 0);
        result = 31 * result + (pwrq != null ? pwrq.hashCode() : 0);
        result = 31 * result + (zgdm != null ? zgdm.hashCode() : 0);
        result = 31 * result + (zgmc != null ? zgmc.hashCode() : 0);
        result = 31 * result + (gk != null ? gk.hashCode() : 0);
        result = 31 * result + (scbzrq != null ? scbzrq.hashCode() : 0);
        result = 31 * result + (bzrq != null ? bzrq.hashCode() : 0);
        result = 31 * result + (zfrq != null ? zfrq.hashCode() : 0);
        result = 31 * result + (njrq != null ? njrq.hashCode() : 0);
        result = 31 * result + (njqx != null ? njqx.hashCode() : 0);
        result = 31 * result + (njr != null ? njr.hashCode() : 0);
        result = 31 * result + (bgbj != null ? bgbj.hashCode() : 0);
        result = 31 * result + (bgrq != null ? bgrq.hashCode() : 0);
        result = 31 * result + (qzbz != null ? qzbz.hashCode() : 0);
        result = 31 * result + (qzrq != null ? qzrq.hashCode() : 0);
        result = 31 * result + (lastdate != null ? lastdate.hashCode() : 0);
        result = 31 * result + (xgr != null ? xgr.hashCode() : 0);
        result = 31 * result + (njjlx != null ? njjlx.hashCode() : 0);
        result = 31 * result + (njjhy != null ? njjhy.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (dybz != null ? dybz.hashCode() : 0);
        result = 31 * result + (fkbz != null ? fkbz.hashCode() : 0);
        result = 31 * result + (fksl != null ? fksl.hashCode() : 0);
        result = 31 * result + (zslsh != null ? zslsh.hashCode() : 0);
        result = 31 * result + (zbsl != null ? zbsl.hashCode() : 0);
        result = 31 * result + (fbsl != null ? fbsl.hashCode() : 0);
        result = 31 * result + (lry != null ? lry.hashCode() : 0);
        result = 31 * result + (gstbr != null ? gstbr.hashCode() : 0);
        result = 31 * result + (gslsh != null ? gslsh.hashCode() : 0);
        result = 31 * result + (wjwtbr != null ? wjwtbr.hashCode() : 0);
        result = 31 * result + (wjwlsh != null ? wjwlsh.hashCode() : 0);
        result = 31 * result + (djblx != null ? djblx.hashCode() : 0);
        result = 31 * result + (zycp1 != null ? zycp1.hashCode() : 0);
        result = 31 * result + (zycp2 != null ? zycp2.hashCode() : 0);
        result = 31 * result + (zycp3 != null ? zycp3.hashCode() : 0);
        result = 31 * result + (tbrxm != null ? tbrxm.hashCode() : 0);
        result = 31 * result + (tbrsfzh != null ? tbrsfzh.hashCode() : 0);
        result = 31 * result + (tbrlxfs != null ? tbrlxfs.hashCode() : 0);
        result = 31 * result + (yjflag != null ? yjflag.hashCode() : 0);
        result = 31 * result + (jfly != null ? jfly.hashCode() : 0);
        result = 31 * result + (khyh != null ? khyh.hashCode() : 0);
        result = 31 * result + (khzh != null ? khzh.hashCode() : 0);
        result = 31 * result + (memo1 != null ? memo1.hashCode() : 0);
        result = 31 * result + (memo2 != null ? memo2.hashCode() : 0);
        result = 31 * result + (isca != null ? isca.hashCode() : 0);
        result = 31 * result + (gsfzrq != null ? gsfzrq.hashCode() : 0);
        result = 31 * result + (jydz != null ? jydz.hashCode() : 0);
        result = 31 * result + (jyyb != null ? jyyb.hashCode() : 0);
        result = 31 * result + (jydh != null ? jydh.hashCode() : 0);
        result = 31 * result + (qrdxzqh != null ? qrdxzqh.hashCode() : 0);
        result = 31 * result + (qrdszxdm != null ? qrdszxdm.hashCode() : 0);
        result = 31 * result + (qrdbzjgdm != null ? qrdbzjgdm.hashCode() : 0);
        result = 31 * result + (qcrq != null ? qcrq.hashCode() : 0);
        result = 31 * result + (qzr != null ? qzr.hashCode() : 0);
        result = 31 * result + (importdate != null ? importdate.hashCode() : 0);
        result = 31 * result + (ssss != null ? ssss.hashCode() : 0);
        return result;
    }
}
