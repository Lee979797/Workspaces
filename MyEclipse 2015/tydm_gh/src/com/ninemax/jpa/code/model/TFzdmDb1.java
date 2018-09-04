package com.ninemax.jpa.code.model;

import javax.persistence.*;
import java.util.Date;

/**
 * User: yzhhui
 * Date: 13-4-23
 * Time: ����10:48
 */
@javax.persistence.Table(name = "T_FZDM")
@Entity
public class TFzdmDb1 {
    private Integer id;

    @javax.persistence.Column(name = "ID", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer  getId() {
        return id;
    }

    public void  setId(Integer id) {
        this.id = id;
    }

    private String jgdm;

    @javax.persistence.Column(name = "JGDM", nullable = false, insertable = true, updatable = true, length = 9, precision = 0)
    @Basic
    public String  getJgdm() {
        return jgdm;
    }

    public void  setJgdm(String jgdm) {
        this.jgdm = jgdm;
    }

    private String jgmc;

    @javax.persistence.Column(name = "JGMC", nullable = true, insertable = true, updatable = true, length = 120, precision = 0)
    @Basic
    public String  getJgmc() {
        return jgmc;
    }

    public void  setJgmc(String jgmc) {
        this.jgmc = jgmc;
    }

    private String jyfw;

    @javax.persistence.Column(name = "JYFW", nullable = true, insertable = true, updatable = true, length = 2000, precision = 0)
    @Basic
    public String  getJyfw() {
        return jyfw;
    }

    public void  setJyfw(String jyfw) {
        this.jyfw = jyfw;
    }

    private String xzqh;

    @javax.persistence.Column(name = "XZQH", nullable = true, insertable = true, updatable = true, length = 6, precision = 0)
    @Basic
    public String  getXzqh() {
        return xzqh;
    }

    public void  setXzqh(String xzqh) {
        this.xzqh = xzqh;
    }

    private String jgdz;

    @javax.persistence.Column(name = "JGDZ", nullable = true, insertable = true, updatable = true, length = 240, precision = 0)
    @Basic
    public String  getJgdz() {
        return jgdz;
    }

    public void  setJgdz(String jgdz) {
        this.jgdz = jgdz;
    }

    private String fddbr;

    @javax.persistence.Column(name = "FDDBR", nullable = true, insertable = true, updatable = true, length = 60, precision = 0)
    @Basic
    public String  getFddbr() {
        return fddbr;
    }

    public void  setFddbr(String fddbr) {
        this.fddbr = fddbr;
    }

    private String zjlx;

    @javax.persistence.Column(name = "ZJLX", nullable = true, insertable = true, updatable = true, length = 2, precision = 0)
    @Basic
    public String  getZjlx() {
        return zjlx;
    }

    public void  setZjlx(String zjlx) {
        this.zjlx = zjlx;
    }

    private String zjhm;

    @javax.persistence.Column(name = "ZJHM", nullable = true, insertable = true, updatable = true, length = 25, precision = 0)
    @Basic
    public String  getZjhm() {
        return zjhm;
    }

    public void  setZjhm(String zjhm) {
        this.zjhm = zjhm;
    }

    private String bzjgdm;

    @javax.persistence.Column(name = "BZJGDM", nullable = true, insertable = true, updatable = true, length = 6, precision = 0)
    @Basic
    public String  getBzjgdm() {
        return bzjgdm;
    }

    public void  setBzjgdm(String bzjgdm) {
        this.bzjgdm = bzjgdm;
    }

    private String jjhy;

    @javax.persistence.Column(name = "JJHY", nullable = true, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public String  getJjhy() {
        return jjhy;
    }

    public void  setJjhy(String jjhy) {
        this.jjhy = jjhy;
    }

    private String jglx;

    @javax.persistence.Column(name = "JGLX", nullable = true, insertable = true, updatable = true, length = 1, precision = 0)
    @Basic
    public String  getJglx() {
        return jglx;
    }

    public void  setJglx(String jglx) {
        this.jglx = jglx;
    }

    private String jjlx;

    @javax.persistence.Column(name = "JJLX", nullable = true, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public String  getJjlx() {
        return jjlx;
    }

    public void  setJjlx(String jjlx) {
        this.jjlx = jjlx;
    }

    private String zch;

    @javax.persistence.Column(name = "ZCH", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String  getZch() {
        return zch;
    }

    public void  setZch(String zch) {
        this.zch = zch;
    }

    private Date zcrq;

    @javax.persistence.Column(name = "ZCRQ", nullable = true, insertable = true, updatable = true, length = 23, precision = 3)
    @Basic
    public Date  getZcrq() {
        return zcrq;
    }

    public void  setZcrq(Date zcrq) {
        this.zcrq = zcrq;
    }

    private Double zczj;

    @javax.persistence.Column(name = "ZCZJ", nullable = true, insertable = true, updatable = true, length = 14, precision = 4)
    @Basic
    public Double  getZczj() {
        return zczj;
    }

    public void  setZczj(Double zczj) {
        this.zczj = zczj;
    }

    private String hbzl;

    @javax.persistence.Column(name = "HBZL", nullable = true, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public String  getHbzl() {
        return hbzl;
    }

    public void  setHbzl(String hbzl) {
        this.hbzl = hbzl;
    }

    private String wftzgb;

    @javax.persistence.Column(name = "WFTZGB", nullable = true, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public String  getWftzgb() {
        return wftzgb;
    }

    public void  setWftzgb(String wftzgb) {
        this.wftzgb = wftzgb;
    }

    private Integer zgrs;

    @javax.persistence.Column(name = "ZGRS", nullable = true, insertable = true, updatable = true, length = 6, precision = 0)
    @Basic
    public Integer  getZgrs() {
        return zgrs;
    }

    public void  setZgrs(Integer zgrs) {
        this.zgrs = zgrs;
    }

    private String yzbm;

    @javax.persistence.Column(name = "YZBM", nullable = true, insertable = true, updatable = true, length = 6, precision = 0)
    @Basic
    public String  getYzbm() {
        return yzbm;
    }

    public void  setYzbm(String yzbm) {
        this.yzbm = yzbm;
    }

    private String dhhm;

    @javax.persistence.Column(name = "DHHM", nullable = true, insertable = true, updatable = true, length = 16, precision = 0)
    @Basic
    public String  getDhhm() {
        return dhhm;
    }

    public void  setDhhm(String dhhm) {
        this.dhhm = dhhm;
    }

    private String pzjgdm;

    @javax.persistence.Column(name = "PZJGDM", nullable = true, insertable = true, updatable = true, length = 9, precision = 0)
    @Basic
    public String  getPzjgdm() {
        return pzjgdm;
    }

    public void  setPzjgdm(String pzjgdm) {
        this.pzjgdm = pzjgdm;
    }

    private String pzjgmc;

    @javax.persistence.Column(name = "PZJGMC", nullable = true, insertable = true, updatable = true, length = 70, precision = 0)
    @Basic
    public String  getPzjgmc() {
        return pzjgmc;
    }

    public void  setPzjgmc(String pzjgmc) {
        this.pzjgmc = pzjgmc;
    }

    private String pzwh;

    @javax.persistence.Column(name = "PZWH", nullable = true, insertable = true, updatable = true, length = 31, precision = 0)
    @Basic
    public String  getPzwh() {
        return pzwh;
    }

    public void  setPzwh(String pzwh) {
        this.pzwh = pzwh;
    }

    private Date pwrq;

    @javax.persistence.Column(name = "PWRQ", nullable = true, insertable = true, updatable = true, length = 23, precision = 3)
    @Basic
    public Date  getPwrq() {
        return pwrq;
    }

    public void  setPwrq(Date pwrq) {
        this.pwrq = pwrq;
    }

    private String zgdm;

    @javax.persistence.Column(name = "ZGDM", nullable = true, insertable = true, updatable = true, length = 9, precision = 0)
    @Basic
    public String  getZgdm() {
        return zgdm;
    }

    public void  setZgdm(String zgdm) {
        this.zgdm = zgdm;
    }

    private String zgmc;

    @javax.persistence.Column(name = "ZGMC", nullable = true, insertable = true, updatable = true, length = 70, precision = 0)
    @Basic
    public String  getZgmc() {
        return zgmc;
    }

    public void  setZgmc(String zgmc) {
        this.zgmc = zgmc;
    }

    private String gk;

    @javax.persistence.Column(name = "GK", nullable = true, insertable = true, updatable = true, length = 1, precision = 0)
    @Basic
    public String  getGk() {
        return gk;
    }

    public void  setGk(String gk) {
        this.gk = gk;
    }

    private Date scbzrq;

    @javax.persistence.Column(name = "SCBZRQ", nullable = true, insertable = true, updatable = true, length = 23, precision = 3)
    @Basic
    public Date  getScbzrq() {
        return scbzrq;
    }

    public void  setScbzrq(Date scbzrq) {
        this.scbzrq = scbzrq;
    }

    private Date bzrq;

    @javax.persistence.Column(name = "BZRQ", nullable = true, insertable = true, updatable = true, length = 23, precision = 3)
    @Basic
    public Date  getBzrq() {
        return bzrq;
    }

    public void  setBzrq(Date bzrq) {
        this.bzrq = bzrq;
    }

    private Date zfrq;

    @javax.persistence.Column(name = "ZFRQ", nullable = true, insertable = true, updatable = true, length = 23, precision = 3)
    @Basic
    public Date  getZfrq() {
        return zfrq;
    }

    public void  setZfrq(Date zfrq) {
        this.zfrq = zfrq;
    }

    private Date njrq;

    @javax.persistence.Column(name = "NJRQ", nullable = true, insertable = true, updatable = true, length = 23, precision = 3)
    @Basic
    public Date  getNjrq() {
        return njrq;
    }

    public void  setNjrq(Date njrq) {
        this.njrq = njrq;
    }

    private Date njqx;

    @javax.persistence.Column(name = "NJQX", nullable = true, insertable = true, updatable = true, length = 23, precision = 3)
    @Basic
    public Date  getNjqx() {
        return njqx;
    }

    public void  setNjqx(Date njqx) {
        this.njqx = njqx;
    }

    private String njr;

    @javax.persistence.Column(name = "NJR", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public String  getNjr() {
        return njr;
    }

    public void  setNjr(String njr) {
        this.njr = njr;
    }

    private String bgbj;

    @javax.persistence.Column(name = "BGBJ", nullable = true, insertable = true, updatable = true, length = 1, precision = 0)
    @Basic
    public String  getBgbj() {
        return bgbj;
    }

    public void  setBgbj(String bgbj) {
        this.bgbj = bgbj;
    }

    private Date bgrq;

    @javax.persistence.Column(name = "BGRQ", nullable = true, insertable = true, updatable = true, length = 23, precision = 3)
    @Basic
    public Date  getBgrq() {
        return bgrq;
    }

    public void  setBgrq(Date bgrq) {
        this.bgrq = bgrq;
    }

    private String qzbz;

    @javax.persistence.Column(name = "QZBZ", nullable = true, insertable = true, updatable = true, length = 1, precision = 0)
    @Basic
    public String  getQzbz() {
        return qzbz;
    }

    public void  setQzbz(String qzbz) {
        this.qzbz = qzbz;
    }

    private Date qzrq;

    @javax.persistence.Column(name = "QZRQ", nullable = true, insertable = true, updatable = true, length = 23, precision = 3)
    @Basic
    public Date  getQzrq() {
        return qzrq;
    }

    public void  setQzrq(Date qzrq) {
        this.qzrq = qzrq;
    }

    private Date lastdate;

    @javax.persistence.Column(name = "LASTDATE", nullable = true, insertable = true, updatable = true, length = 23, precision = 3)
    @Basic
    public Date  getLastdate() {
        return lastdate;
    }

    public void  setLastdate(Date lastdate) {
        this.lastdate = lastdate;
    }

    private String xgr;

    @javax.persistence.Column(name = "XGR", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public String  getXgr() {
        return xgr;
    }

    public void  setXgr(String xgr) {
        this.xgr = xgr;
    }

    private String njjlx;

    @javax.persistence.Column(name = "NJJLX", nullable = true, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public String  getNjjlx() {
        return njjlx;
    }

    public void  setNjjlx(String njjlx) {
        this.njjlx = njjlx;
    }

    private String njjhy;

    @javax.persistence.Column(name = "NJJHY", nullable = true, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public String  getNjjhy() {
        return njjhy;
    }

    public void  setNjjhy(String njjhy) {
        this.njjhy = njjhy;
    }

    private String email;

    @javax.persistence.Column(name = "EMAIL", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String  getEmail() {
        return email;
    }

    public void  setEmail(String email) {
        this.email = email;
    }

    private String mobile;

    @javax.persistence.Column(name = "MOBILE", nullable = true, insertable = true, updatable = true, length = 15, precision = 0)
    @Basic
    public String  getMobile() {
        return mobile;
    }

    public void  setMobile(String mobile) {
        this.mobile = mobile;
    }

    private String url;

    @javax.persistence.Column(name = "URL", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String  getUrl() {
        return url;
    }

    public void  setUrl(String url) {
        this.url = url;
    }

    private String dybz;

    @javax.persistence.Column(name = "DYBZ", nullable = true, insertable = true, updatable = true, length = 1, precision = 0)
    @Basic
    public String  getDybz() {
        return dybz;
    }

    public void  setDybz(String dybz) {
        this.dybz = dybz;
    }

    private String fkbz;

    @javax.persistence.Column(name = "FKBZ", nullable = true, insertable = true, updatable = true, length = 1, precision = 0)
    @Basic
    public String  getFkbz() {
        return fkbz;
    }

    public void  setFkbz(String fkbz) {
        this.fkbz = fkbz;
    }

    private Integer fksl;

    @javax.persistence.Column(name = "FKSL", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public Integer  getFksl() {
        return fksl;
    }

    public void  setFksl(Integer fksl) {
        this.fksl = fksl;
    }

    private String zslsh;

    @javax.persistence.Column(name = "ZSLSH", nullable = true, insertable = true, updatable = true, length = 6, precision = 0)
    @Basic
    public String  getZslsh() {
        return zslsh;
    }

    public void  setZslsh(String zslsh) {
        this.zslsh = zslsh;
    }

    private Integer zbsl;

    @javax.persistence.Column(name = "ZBSL", nullable = true, insertable = true, updatable = true, length = 2, precision = 0)
    @Basic
    public Integer  getZbsl() {
        return zbsl;
    }

    public void  setZbsl(Integer zbsl) {
        this.zbsl = zbsl;
    }

    private Integer fbsl;

    @javax.persistence.Column(name = "FBSL", nullable = true, insertable = true, updatable = true, length = 2, precision = 0)
    @Basic
    public Integer  getFbsl() {
        return fbsl;
    }

    public void  setFbsl(Integer fbsl) {
        this.fbsl = fbsl;
    }

    private String lry;

    @javax.persistence.Column(name = "LRY", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public String  getLry() {
        return lry;
    }

    public void  setLry(String lry) {
        this.lry = lry;
    }

    private String gstbr;

    @javax.persistence.Column(name = "GSTBR", nullable = true, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public String  getGstbr() {
        return gstbr;
    }

    public void  setGstbr(String gstbr) {
        this.gstbr = gstbr;
    }

    private String gslsh;

    @javax.persistence.Column(name = "GSLSH", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public String  getGslsh() {
        return gslsh;
    }

    public void  setGslsh(String gslsh) {
        this.gslsh = gslsh;
    }

    private String wjwtbr;

    @javax.persistence.Column(name = "WJWTBR", nullable = true, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public String  getWjwtbr() {
        return wjwtbr;
    }

    public void  setWjwtbr(String wjwtbr) {
        this.wjwtbr = wjwtbr;
    }

    private String wjwlsh;

    @javax.persistence.Column(name = "WJWLSH", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public String  getWjwlsh() {
        return wjwlsh;
    }

    public void  setWjwlsh(String wjwlsh) {
        this.wjwlsh = wjwlsh;
    }

    private String djblx;

    @javax.persistence.Column(name = "DJBLX", nullable = true, insertable = true, updatable = true, length = 1, precision = 0)
    @Basic
    public String  getDjblx() {
        return djblx;
    }

    public void  setDjblx(String djblx) {
        this.djblx = djblx;
    }

    private String zycp1;

    @javax.persistence.Column(name = "ZYCP1", nullable = true, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public String  getZycp1() {
        return zycp1;
    }

    public void  setZycp1(String zycp1) {
        this.zycp1 = zycp1;
    }

    private String zycp2;

    @javax.persistence.Column(name = "ZYCP2", nullable = true, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public String  getZycp2() {
        return zycp2;
    }

    public void  setZycp2(String zycp2) {
        this.zycp2 = zycp2;
    }

    private String zycp3;

    @javax.persistence.Column(name = "ZYCP3", nullable = true, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public String  getZycp3() {
        return zycp3;
    }

    public void  setZycp3(String zycp3) {
        this.zycp3 = zycp3;
    }

    private String tbrxm;

    @javax.persistence.Column(name = "TBRXM", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public String  getTbrxm() {
        return tbrxm;
    }

    public void  setTbrxm(String tbrxm) {
        this.tbrxm = tbrxm;
    }

    private String tbrsfzh;

    @javax.persistence.Column(name = "TBRSFZH", nullable = true, insertable = true, updatable = true, length = 25, precision = 0)
    @Basic
    public String  getTbrsfzh() {
        return tbrsfzh;
    }

    public void  setTbrsfzh(String tbrsfzh) {
        this.tbrsfzh = tbrsfzh;
    }

    private String tbrlxfs;

    @javax.persistence.Column(name = "TBRLXFS", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String  getTbrlxfs() {
        return tbrlxfs;
    }

    public void  setTbrlxfs(String tbrlxfs) {
        this.tbrlxfs = tbrlxfs;
    }

    private String yjflag;

    @javax.persistence.Column(name = "YJFLAG", nullable = true, insertable = true, updatable = true, length = 1, precision = 0)
    @Basic
    public String  getYjflag() {
        return yjflag;
    }

    public void  setYjflag(String yjflag) {
        this.yjflag = yjflag;
    }

    private String isca;

    @javax.persistence.Column(name = "ISCA", nullable = true, insertable = true, updatable = true, length = 1, precision = 0)
    @Basic
    public String  getIsca() {
        return isca;
    }

    public void  setIsca(String isca) {
        this.isca = isca;
    }

    private Date gsfzrq;

    @javax.persistence.Column(name = "GSFZRQ", nullable = true, insertable = true, updatable = true, length = 23, precision = 3)
    @Basic
    public Date  getGsfzrq() {
        return gsfzrq;
    }

    public void  setGsfzrq(Date gsfzrq) {
        this.gsfzrq = gsfzrq;
    }

    private String jydz;

    @javax.persistence.Column(name = "JYDZ", nullable = true, insertable = true, updatable = true, length = 120, precision = 0)
    @Basic
    public String  getJydz() {
        return jydz;
    }

    public void  setJydz(String jydz) {
        this.jydz = jydz;
    }

    private String jyyb;

    @javax.persistence.Column(name = "JYYB", nullable = true, insertable = true, updatable = true, length = 6, precision = 0)
    @Basic
    public String  getJyyb() {
        return jyyb;
    }

    public void  setJyyb(String jyyb) {
        this.jyyb = jyyb;
    }

    private String jydh;

    @javax.persistence.Column(name = "JYDH", nullable = true, insertable = true, updatable = true, length = 16, precision = 0)
    @Basic
    public String  getJydh() {
        return jydh;
    }

    public void  setJydh(String jydh) {
        this.jydh = jydh;
    }

    private String jfly;

    @javax.persistence.Column(name = "JFLY", nullable = true, insertable = true, updatable = true, length = 16, precision = 0)
    @Basic
    public String  getJfly() {
        return jfly;
    }

    public void  setJfly(String jfly) {
        this.jfly = jfly;
    }

    private String khyh;

    @javax.persistence.Column(name = "KHYH", nullable = true, insertable = true, updatable = true, length = 100, precision = 0)
    @Basic
    public String  getKhyh() {
        return khyh;
    }

    public void  setKhyh(String khyh) {
        this.khyh = khyh;
    }

    private String khzh;

    @javax.persistence.Column(name = "KHZH", nullable = true, insertable = true, updatable = true, length = 30, precision = 0)
    @Basic
    public String  getKhzh() {
        return khzh;
    }

    public void  setKhzh(String khzh) {
        this.khzh = khzh;
    }

    private String memo1;

    @javax.persistence.Column(name = "MEMO1", nullable = true, insertable = true, updatable = true, length = 500, precision = 0)
    @Basic
    public String  getMemo1() {
        return memo1;
    }

    public void  setMemo1(String memo1) {
        this.memo1 = memo1;
    }

    private String memo2;

    @javax.persistence.Column(name = "MEMO2", nullable = true, insertable = true, updatable = true, length = 500, precision = 0)
    @Basic
    public String  getMemo2() {
        return memo2;
    }

    public void  setMemo2(String memo2) {
        this.memo2 = memo2;
    }

    private String fzr;

    @javax.persistence.Column(name = "FZR", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public String  getFzr() {
        return fzr;
    }

    public void  setFzr(String fzr) {
        this.fzr = fzr;
    }

    private Date fzrq;

    @javax.persistence.Column(name = "FZRQ", nullable = true, insertable = true, updatable = true, length = 23, precision = 3)
    @Basic
    public Date  getFzrq() {
        return fzrq;
    }

    public void  setFzrq(Date fzrq) {
        this.fzrq = fzrq;
    }

    private String fzreason;

    @javax.persistence.Column(name = "FZREASON", nullable = true, insertable = true, updatable = true, length = 200, precision = 0)
    @Basic
    public String  getFzreason() {
        return fzreason;
    }

    public void  setFzreason(String fzreason) {
        this.fzreason = fzreason;
    }

    private String fzyj;

    @javax.persistence.Column(name = "FZYJ", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String  getFzyj() {
        return fzyj;
    }

    public void  setFzyj(String fzyj) {
        this.fzyj = fzyj;
    }

    private String importdate;

    @javax.persistence.Column(name = "IMPORTDATE", nullable = false, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String  getImportdate() {
        return importdate;
    }

    public void  setImportdate(String importdate) {
        this.importdate = importdate;
    }

    private String ssss;

    @javax.persistence.Column(name = "SSSS", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
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

        TFzdmDb1 tFzdmDb1 = (TFzdmDb1) o;

        if (bgbj != null ? !bgbj.equals(tFzdmDb1.bgbj) : tFzdmDb1.bgbj != null) return false;
        if (bgrq != null ? !bgrq.equals(tFzdmDb1.bgrq) : tFzdmDb1.bgrq != null) return false;
        if (bzjgdm != null ? !bzjgdm.equals(tFzdmDb1.bzjgdm) : tFzdmDb1.bzjgdm != null) return false;
        if (bzrq != null ? !bzrq.equals(tFzdmDb1.bzrq) : tFzdmDb1.bzrq != null) return false;
        if (dhhm != null ? !dhhm.equals(tFzdmDb1.dhhm) : tFzdmDb1.dhhm != null) return false;
        if (djblx != null ? !djblx.equals(tFzdmDb1.djblx) : tFzdmDb1.djblx != null) return false;
        if (dybz != null ? !dybz.equals(tFzdmDb1.dybz) : tFzdmDb1.dybz != null) return false;
        if (email != null ? !email.equals(tFzdmDb1.email) : tFzdmDb1.email != null) return false;
        if (fbsl != null ? !fbsl.equals(tFzdmDb1.fbsl) : tFzdmDb1.fbsl != null) return false;
        if (fddbr != null ? !fddbr.equals(tFzdmDb1.fddbr) : tFzdmDb1.fddbr != null) return false;
        if (fkbz != null ? !fkbz.equals(tFzdmDb1.fkbz) : tFzdmDb1.fkbz != null) return false;
        if (fksl != null ? !fksl.equals(tFzdmDb1.fksl) : tFzdmDb1.fksl != null) return false;
        if (fzr != null ? !fzr.equals(tFzdmDb1.fzr) : tFzdmDb1.fzr != null) return false;
        if (fzreason != null ? !fzreason.equals(tFzdmDb1.fzreason) : tFzdmDb1.fzreason != null) return false;
        if (fzrq != null ? !fzrq.equals(tFzdmDb1.fzrq) : tFzdmDb1.fzrq != null) return false;
        if (fzyj != null ? !fzyj.equals(tFzdmDb1.fzyj) : tFzdmDb1.fzyj != null) return false;
        if (gk != null ? !gk.equals(tFzdmDb1.gk) : tFzdmDb1.gk != null) return false;
        if (gsfzrq != null ? !gsfzrq.equals(tFzdmDb1.gsfzrq) : tFzdmDb1.gsfzrq != null) return false;
        if (gslsh != null ? !gslsh.equals(tFzdmDb1.gslsh) : tFzdmDb1.gslsh != null) return false;
        if (gstbr != null ? !gstbr.equals(tFzdmDb1.gstbr) : tFzdmDb1.gstbr != null) return false;
        if (hbzl != null ? !hbzl.equals(tFzdmDb1.hbzl) : tFzdmDb1.hbzl != null) return false;
        if (id != null ? !id.equals(tFzdmDb1.id) : tFzdmDb1.id != null) return false;
        if (importdate != null ? !importdate.equals(tFzdmDb1.importdate) : tFzdmDb1.importdate != null) return false;
        if (isca != null ? !isca.equals(tFzdmDb1.isca) : tFzdmDb1.isca != null) return false;
        if (jfly != null ? !jfly.equals(tFzdmDb1.jfly) : tFzdmDb1.jfly != null) return false;
        if (jgdm != null ? !jgdm.equals(tFzdmDb1.jgdm) : tFzdmDb1.jgdm != null) return false;
        if (jgdz != null ? !jgdz.equals(tFzdmDb1.jgdz) : tFzdmDb1.jgdz != null) return false;
        if (jglx != null ? !jglx.equals(tFzdmDb1.jglx) : tFzdmDb1.jglx != null) return false;
        if (jgmc != null ? !jgmc.equals(tFzdmDb1.jgmc) : tFzdmDb1.jgmc != null) return false;
        if (jjhy != null ? !jjhy.equals(tFzdmDb1.jjhy) : tFzdmDb1.jjhy != null) return false;
        if (jjlx != null ? !jjlx.equals(tFzdmDb1.jjlx) : tFzdmDb1.jjlx != null) return false;
        if (jydh != null ? !jydh.equals(tFzdmDb1.jydh) : tFzdmDb1.jydh != null) return false;
        if (jydz != null ? !jydz.equals(tFzdmDb1.jydz) : tFzdmDb1.jydz != null) return false;
        if (jyfw != null ? !jyfw.equals(tFzdmDb1.jyfw) : tFzdmDb1.jyfw != null) return false;
        if (jyyb != null ? !jyyb.equals(tFzdmDb1.jyyb) : tFzdmDb1.jyyb != null) return false;
        if (khyh != null ? !khyh.equals(tFzdmDb1.khyh) : tFzdmDb1.khyh != null) return false;
        if (khzh != null ? !khzh.equals(tFzdmDb1.khzh) : tFzdmDb1.khzh != null) return false;
        if (lastdate != null ? !lastdate.equals(tFzdmDb1.lastdate) : tFzdmDb1.lastdate != null) return false;
        if (lry != null ? !lry.equals(tFzdmDb1.lry) : tFzdmDb1.lry != null) return false;
        if (memo1 != null ? !memo1.equals(tFzdmDb1.memo1) : tFzdmDb1.memo1 != null) return false;
        if (memo2 != null ? !memo2.equals(tFzdmDb1.memo2) : tFzdmDb1.memo2 != null) return false;
        if (mobile != null ? !mobile.equals(tFzdmDb1.mobile) : tFzdmDb1.mobile != null) return false;
        if (njjhy != null ? !njjhy.equals(tFzdmDb1.njjhy) : tFzdmDb1.njjhy != null) return false;
        if (njjlx != null ? !njjlx.equals(tFzdmDb1.njjlx) : tFzdmDb1.njjlx != null) return false;
        if (njqx != null ? !njqx.equals(tFzdmDb1.njqx) : tFzdmDb1.njqx != null) return false;
        if (njr != null ? !njr.equals(tFzdmDb1.njr) : tFzdmDb1.njr != null) return false;
        if (njrq != null ? !njrq.equals(tFzdmDb1.njrq) : tFzdmDb1.njrq != null) return false;
        if (pwrq != null ? !pwrq.equals(tFzdmDb1.pwrq) : tFzdmDb1.pwrq != null) return false;
        if (pzjgdm != null ? !pzjgdm.equals(tFzdmDb1.pzjgdm) : tFzdmDb1.pzjgdm != null) return false;
        if (pzjgmc != null ? !pzjgmc.equals(tFzdmDb1.pzjgmc) : tFzdmDb1.pzjgmc != null) return false;
        if (pzwh != null ? !pzwh.equals(tFzdmDb1.pzwh) : tFzdmDb1.pzwh != null) return false;
        if (qzbz != null ? !qzbz.equals(tFzdmDb1.qzbz) : tFzdmDb1.qzbz != null) return false;
        if (qzrq != null ? !qzrq.equals(tFzdmDb1.qzrq) : tFzdmDb1.qzrq != null) return false;
        if (scbzrq != null ? !scbzrq.equals(tFzdmDb1.scbzrq) : tFzdmDb1.scbzrq != null) return false;
        if (ssss != null ? !ssss.equals(tFzdmDb1.ssss) : tFzdmDb1.ssss != null) return false;
        if (tbrlxfs != null ? !tbrlxfs.equals(tFzdmDb1.tbrlxfs) : tFzdmDb1.tbrlxfs != null) return false;
        if (tbrsfzh != null ? !tbrsfzh.equals(tFzdmDb1.tbrsfzh) : tFzdmDb1.tbrsfzh != null) return false;
        if (tbrxm != null ? !tbrxm.equals(tFzdmDb1.tbrxm) : tFzdmDb1.tbrxm != null) return false;
        if (url != null ? !url.equals(tFzdmDb1.url) : tFzdmDb1.url != null) return false;
        if (wftzgb != null ? !wftzgb.equals(tFzdmDb1.wftzgb) : tFzdmDb1.wftzgb != null) return false;
        if (wjwlsh != null ? !wjwlsh.equals(tFzdmDb1.wjwlsh) : tFzdmDb1.wjwlsh != null) return false;
        if (wjwtbr != null ? !wjwtbr.equals(tFzdmDb1.wjwtbr) : tFzdmDb1.wjwtbr != null) return false;
        if (xgr != null ? !xgr.equals(tFzdmDb1.xgr) : tFzdmDb1.xgr != null) return false;
        if (xzqh != null ? !xzqh.equals(tFzdmDb1.xzqh) : tFzdmDb1.xzqh != null) return false;
        if (yjflag != null ? !yjflag.equals(tFzdmDb1.yjflag) : tFzdmDb1.yjflag != null) return false;
        if (yzbm != null ? !yzbm.equals(tFzdmDb1.yzbm) : tFzdmDb1.yzbm != null) return false;
        if (zbsl != null ? !zbsl.equals(tFzdmDb1.zbsl) : tFzdmDb1.zbsl != null) return false;
        if (zch != null ? !zch.equals(tFzdmDb1.zch) : tFzdmDb1.zch != null) return false;
        if (zcrq != null ? !zcrq.equals(tFzdmDb1.zcrq) : tFzdmDb1.zcrq != null) return false;
        if (zczj != null ? !zczj.equals(tFzdmDb1.zczj) : tFzdmDb1.zczj != null) return false;
        if (zfrq != null ? !zfrq.equals(tFzdmDb1.zfrq) : tFzdmDb1.zfrq != null) return false;
        if (zgdm != null ? !zgdm.equals(tFzdmDb1.zgdm) : tFzdmDb1.zgdm != null) return false;
        if (zgmc != null ? !zgmc.equals(tFzdmDb1.zgmc) : tFzdmDb1.zgmc != null) return false;
        if (zgrs != null ? !zgrs.equals(tFzdmDb1.zgrs) : tFzdmDb1.zgrs != null) return false;
        if (zjhm != null ? !zjhm.equals(tFzdmDb1.zjhm) : tFzdmDb1.zjhm != null) return false;
        if (zjlx != null ? !zjlx.equals(tFzdmDb1.zjlx) : tFzdmDb1.zjlx != null) return false;
        if (zslsh != null ? !zslsh.equals(tFzdmDb1.zslsh) : tFzdmDb1.zslsh != null) return false;
        if (zycp1 != null ? !zycp1.equals(tFzdmDb1.zycp1) : tFzdmDb1.zycp1 != null) return false;
        if (zycp2 != null ? !zycp2.equals(tFzdmDb1.zycp2) : tFzdmDb1.zycp2 != null) return false;
        if (zycp3 != null ? !zycp3.equals(tFzdmDb1.zycp3) : tFzdmDb1.zycp3 != null) return false;

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
        result = 31 * result + (isca != null ? isca.hashCode() : 0);
        result = 31 * result + (gsfzrq != null ? gsfzrq.hashCode() : 0);
        result = 31 * result + (jydz != null ? jydz.hashCode() : 0);
        result = 31 * result + (jyyb != null ? jyyb.hashCode() : 0);
        result = 31 * result + (jydh != null ? jydh.hashCode() : 0);
        result = 31 * result + (jfly != null ? jfly.hashCode() : 0);
        result = 31 * result + (khyh != null ? khyh.hashCode() : 0);
        result = 31 * result + (khzh != null ? khzh.hashCode() : 0);
        result = 31 * result + (memo1 != null ? memo1.hashCode() : 0);
        result = 31 * result + (memo2 != null ? memo2.hashCode() : 0);
        result = 31 * result + (fzr != null ? fzr.hashCode() : 0);
        result = 31 * result + (fzrq != null ? fzrq.hashCode() : 0);
        result = 31 * result + (fzreason != null ? fzreason.hashCode() : 0);
        result = 31 * result + (fzyj != null ? fzyj.hashCode() : 0);
        result = 31 * result + (importdate != null ? importdate.hashCode() : 0);
        result = 31 * result + (ssss != null ? ssss.hashCode() : 0);
        return result;
    }
}
