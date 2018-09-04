package com.ninemax.jpa.code.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-5-18
 * Time: ÉÏÎç11:27
 */
@javax.persistence.Table(name = "t_qzjgdm")
@Entity
public class TQzjgdm {
    private Integer id;

    @javax.persistence.Column(name = "id")
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String jgdm;

    @javax.persistence.Column(name = "jgdm", nullable = false, insertable = true, updatable = true, length = 9, precision = 0)
    @Basic
    public String getJgdm() {
        return jgdm;
    }

    public void setJgdm(String jgdm) {
        this.jgdm = jgdm;
    }

    private String jgmc;

    @javax.persistence.Column(name = "jgmc", nullable = true, insertable = true, updatable = true, length = 120, precision = 0)
    @Basic
    public String getJgmc() {
        return jgmc;
    }

    public void setJgmc(String jgmc) {
        this.jgmc = jgmc;
    }


    private String jglx;

    @javax.persistence.Column(name = "jglx", nullable = true, insertable = true, updatable = true, length = 1, precision = 0)
    @Basic
    public String getJglx() {
        return jglx;
    }

    public void setJglx(String jglx) {
        this.jglx = jglx;
    }

    private String njglx;

    @javax.persistence.Column(name = "njglx", nullable = true, insertable = true, updatable = true, length = 1, precision = 0)
    @Basic
    public String getNjglx() {
        return njglx;
    }

    public void setNjglx(String njglx) {
        this.njglx = njglx;
    }

    private String fddbr;

    @javax.persistence.Column(name = "fddbr", nullable = true, insertable = true, updatable = true, length = 30, precision = 0)
    @Basic
    public String getFddbr() {
        return fddbr;
    }

    public void setFddbr(String fddbr) {
        this.fddbr = fddbr;
    }

    private String zjlx;

    @javax.persistence.Column(name = "zjlx", nullable = true, insertable = true, updatable = true, length = 2, precision = 0)
    @Basic
    public String getZjlx() {
        return zjlx;
    }

    public void setZjlx(String zjlx) {
        this.zjlx = zjlx;
    }

    private String zjhm;

    @javax.persistence.Column(name = "zjhm", nullable = true, insertable = true, updatable = true, length = 25, precision = 0)
    @Basic
    public String getZjhm() {
        return zjhm;
    }

    public void setZjhm(String zjhm) {
        this.zjhm = zjhm;
    }

    private String jyfw;

    @javax.persistence.Column(name = "jyfw", nullable = true, insertable = true, updatable = true, length = 200, precision = 0)
    @Basic
    public String getJyfw() {
        return jyfw;
    }

    public void setJyfw(String jyfw) {
        this.jyfw = jyfw;
    }

    private String jjhy;

    @javax.persistence.Column(name = "jjhy", nullable = true, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public String getJjhy() {
        return jjhy;
    }

    public void setJjhy(String jjhy) {
        this.jjhy = jjhy;
    }

    private String jjlx;

    @javax.persistence.Column(name = "jjlx", nullable = true, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public String getJjlx() {
        return jjlx;
    }

    public void setJjlx(String jjlx) {
        this.jjlx = jjlx;
    }

    private String nnjjhy;

    @javax.persistence.Column(name = "jjhy2011", nullable = true, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public String getNnjjhy() {
        return nnjjhy;
    }

    public void setNnjjhy(String nnjjhy) {
        this.nnjjhy = nnjjhy;
    }

    private String nnjjlx;

    @javax.persistence.Column(name = "jjlx2011", nullable = true, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public String getNnjjlx() {
        return nnjjlx;
    }

    public void setNnjjlx(String nnjjlx) {
        this.nnjjlx = nnjjlx;
    }

    private Date zcrq;

    @javax.persistence.Column(name = "zcrq", nullable = true, insertable = true, updatable = true, length = 23, precision = 3)
    @Basic
    public Date getZcrq() {
        return zcrq;
    }

    public void setZcrq(Date zcrq) {
        this.zcrq = zcrq;
    }

    private String zgdm;

    @javax.persistence.Column(name = "zgdm", nullable = true, insertable = true, updatable = true, length = 9, precision = 0)
    @Basic
    public String getZgdm() {
        return zgdm;
    }

    public void setZgdm(String zgdm) {
        this.zgdm = zgdm;
    }

    private String pzjgdm;

    @javax.persistence.Column(name = "pzjgdm", nullable = true, insertable = true, updatable = true, length = 9, precision = 0)
    @Basic
    public String getPzjgdm() {
        return pzjgdm;
    }

    public void setPzjgdm(String pzjgdm) {
        this.pzjgdm = pzjgdm;
    }

    private String qzxzqh;

    @javax.persistence.Column(name = "qzxzqh", nullable = true, insertable = true, updatable = true, length = 6, precision = 0)
    @Basic
    public String getQzxzqh() {
        return qzxzqh;
    }

    public void setQzxzqh(String qzxzqh) {
        this.qzxzqh = qzxzqh;
    }

    private String xzqh;

    @javax.persistence.Column(name = "xzqh", nullable = true, insertable = true, updatable = true, length = 6, precision = 0)
    @Basic
    public String getXzqh() {
        return xzqh;
    }

    public void setXzqh(String xzqh) {
        this.xzqh = xzqh;
    }

    private String jgdz;

    @javax.persistence.Column(name = "jgdz", nullable = true, insertable = true, updatable = true, length = 120, precision = 0)
    @Basic
    public String getJgdz() {
        return jgdz;
    }

    public void setJgdz(String jgdz) {
        this.jgdz = jgdz;
    }

    private String yzbm;

    @javax.persistence.Column(name = "yzbm", nullable = true, insertable = true, updatable = true, length = 6, precision = 0)
    @Basic
    public String getYzbm() {
        return yzbm;
    }

    public void setYzbm(String yzbm) {
        this.yzbm = yzbm;
    }

    private String dhhm;

    @javax.persistence.Column(name = "dhhm", nullable = true, insertable = true, updatable = true, length = 16, precision = 0)
    @Basic
    public String getDhhm() {
        return dhhm;
    }

    public void setDhhm(String dhhm) {
        this.dhhm = dhhm;
    }

    private Date scbzrq;

    @javax.persistence.Column(name = "scbzrq", nullable = true, insertable = true, updatable = true, length = 23, precision = 3)
    @Basic
    public Date getScbzrq() {
        return scbzrq;
    }

    public void setScbzrq(Date scbzrq) {
        this.scbzrq = scbzrq;
    }

    private Date bzrq;

    @javax.persistence.Column(name = "bzrq", nullable = true, insertable = true, updatable = true, length = 23, precision = 3)
    @Basic
    public Date getBzrq() {
        return bzrq;
    }

    public void setBzrq(Date bzrq) {
        this.bzrq = bzrq;
    }

    private Date zfrq;

    @javax.persistence.Column(name = "zfrq", nullable = true, insertable = true, updatable = true, length = 23, precision = 3)
    @Basic
    public Date getZfrq() {
        return zfrq;
    }

    public void setZfrq(Date zfrq) {
        this.zfrq = zfrq;
    }

    private String bzjgdm;

    @javax.persistence.Column(name = "bzjgdm", nullable = true, insertable = true, updatable = true, length = 6, precision = 0)
    @Basic
    public String getBzjgdm() {
        return bzjgdm;
    }

    public void setBzjgdm(String bzjgdm) {
        this.bzjgdm = bzjgdm;
    }

    private String zycp1;

    @javax.persistence.Column(name = "zycp1", nullable = true, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public String getZycp1() {
        return zycp1;
    }

    public void setZycp1(String zycp1) {
        this.zycp1 = zycp1;
    }

    private String zycp2;

    @javax.persistence.Column(name = "zycp2", nullable = true, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public String getZycp2() {
        return zycp2;
    }

    public void setZycp2(String zycp2) {
        this.zycp2 = zycp2;
    }

    private String zycp3;

    @javax.persistence.Column(name = "zycp3", nullable = true, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public String getZycp3() {
        return zycp3;
    }

    public void setZycp3(String zycp3) {
        this.zycp3 = zycp3;
    }

    private Double zczj;

    @javax.persistence.Column(name = "zczj", nullable = true, insertable = true, updatable = true, length = 24)
    @Basic
    public Double getZczj() {
        return zczj;
    }

    public void setZczj(Double zczj) {
        this.zczj = zczj;
    }

    private String hbzl;

    @javax.persistence.Column(name = "hbzl", nullable = true, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public String getHbzl() {
        return hbzl;
    }

    public void setHbzl(String hbzl) {
        this.hbzl = hbzl;
    }

    private String wftzgb;

    @javax.persistence.Column(name = "wftzgb", nullable = true, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public String getWftzgb() {
        return wftzgb;
    }

    public void setWftzgb(String wftzgb) {
        this.wftzgb = wftzgb;
    }

    private Integer zgrs;

    @javax.persistence.Column(name = "zgrs", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public Integer getZgrs() {
        return zgrs;
    }

    public void setZgrs(Integer zgrs) {
        this.zgrs = zgrs;
    }

    private Integer fbsl;

    @javax.persistence.Column(name = "fbsl", nullable = true, insertable = true, updatable = true, length = 2, precision = 0)
    @Basic
    public Integer getFbsl() {
        return fbsl;
    }

    public void setFbsl(Integer fbsl) {
        this.fbsl = fbsl;
    }

    private String zslsh;

    @javax.persistence.Column(name = "zslsh", nullable = true, insertable = true, updatable = true, length = 6, precision = 0)
    @Basic
    public String getZslsh() {
        return zslsh;
    }

    public void setZslsh(String zslsh) {
        this.zslsh = zslsh;
    }

    private String bgbj;

    @javax.persistence.Column(name = "bgbj", nullable = true, insertable = true, updatable = true, length = 1, precision = 0)
    @Basic
    public String getBgbj() {
        return bgbj;
    }

    public void setBgbj(String bgbj) {
        this.bgbj = bgbj;
    }

    private Date bgrq;

    @javax.persistence.Column(name = "bgrq", nullable = true, insertable = true, updatable = true, length = 23, precision = 3)
    @Basic
    public Date getBgrq() {
        return bgrq;
    }

    public void setBgrq(Date bgrq) {
        this.bgrq = bgrq;
    }

    private String lry;

    @javax.persistence.Column(name = "lry", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public String getLry() {
        return lry;
    }

    public void setLry(String lry) {
        this.lry = lry;
    }

    private Date njrq;

    @javax.persistence.Column(name = "njrq", nullable = true, insertable = true, updatable = true, length = 23, precision = 3)
    @Basic
    public Date getNjrq() {
        return njrq;
    }

    public void setNjrq(Date njrq) {
        this.njrq = njrq;
    }

    private String njr;

    @javax.persistence.Column(name = "njr", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public String getNjr() {
        return njr;
    }

    public void setNjr(String njr) {
        this.njr = njr;
    }

    private Date njqx;

    @javax.persistence.Column(name = "njqx", nullable = true, insertable = true, updatable = true, length = 23, precision = 3)
    @Basic
    public Date getNjqx() {
        return njqx;
    }

    public void setNjqx(Date njqx) {
        this.njqx = njqx;
    }

    private String xgr;

    @javax.persistence.Column(name = "xgr", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public String getXgr() {
        return xgr;
    }

    public void setXgr(String xgr) {
        this.xgr = xgr;
    }

    private Integer zbsl;

    @javax.persistence.Column(name = "zbsl", nullable = true, insertable = true, updatable = true, length = 2, precision = 0)
    @Basic
    public Integer getZbsl() {
        return zbsl;
    }

    public void setZbsl(Integer zbsl) {
        this.zbsl = zbsl;
    }

    private String zch;

    @javax.persistence.Column(name = "zch", nullable = true, insertable = true, updatable = true, length = 31, precision = 0)
    @Basic
    public String getZch() {
        return zch;
    }

    public void setZch(String zch) {
        this.zch = zch;
    }

    private String qzbz;

    @javax.persistence.Column(name = "qzbz", nullable = true, insertable = true, updatable = true, length = 1, precision = 0)
    @Basic
    public String getQzbz() {
        return qzbz;
    }

    public void setQzbz(String qzbz) {
        this.qzbz = qzbz;
    }

    private Date qzrq;

    @javax.persistence.Column(name = "qzrq", nullable = true, insertable = true, updatable = true, length = 23, precision = 3)
    @Basic
    public Date getQzrq() {
        return qzrq;
    }

    public void setQzrq(Date qzrq) {
        this.qzrq = qzrq;
    }

    private String zgmc;

    @javax.persistence.Column(name = "zgmc", nullable = true, insertable = true, updatable = true, length = 70, precision = 0)
    @Basic
    public String getZgmc() {
        return zgmc;
    }

    public void setZgmc(String zgmc) {
        this.zgmc = zgmc;
    }

    private String pzjgmc;

    @javax.persistence.Column(name = "pzjgmc", nullable = true, insertable = true, updatable = true, length = 70, precision = 0)
    @Basic
    public String getPzjgmc() {
        return pzjgmc;
    }

    public void setPzjgmc(String pzjgmc) {
        this.pzjgmc = pzjgmc;
    }

    private String gslsh;

    @javax.persistence.Column(name = "gslsh", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public String getGslsh() {
        return gslsh;
    }

    public void setGslsh(String gslsh) {
        this.gslsh = gslsh;
    }

    private String gstbr;

    @javax.persistence.Column(name = "gstbr", nullable = true, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public String getGstbr() {
        return gstbr;
    }

    public void setGstbr(String gstbr) {
        this.gstbr = gstbr;
    }

    private String wjwlsh;

    @javax.persistence.Column(name = "wjwlsh", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public String getWjwlsh() {
        return wjwlsh;
    }

    public void setWjwlsh(String wjwlsh) {
        this.wjwlsh = wjwlsh;
    }

    private String pzwh;

    @javax.persistence.Column(name = "pzwh", nullable = true, insertable = true, updatable = true, length = 31, precision = 0)
    @Basic
    public String getPzwh() {
        return pzwh;
    }

    public void setPzwh(String pzwh) {
        this.pzwh = pzwh;
    }

    private Date pwrq;

    @javax.persistence.Column(name = "pwrq", nullable = true, insertable = true, updatable = true, length = 23, precision = 3)
    @Basic
    public Date getPwrq() {
        return pwrq;
    }

    public void setPwrq(Date pwrq) {
        this.pwrq = pwrq;
    }

    private String wjwtbr;

    @javax.persistence.Column(name = "wjwtbr", nullable = true, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public String getWjwtbr() {
        return wjwtbr;
    }

    public void setWjwtbr(String wjwtbr) {
        this.wjwtbr = wjwtbr;
    }

    private String gk;

    @javax.persistence.Column(name = "gk", nullable = true, insertable = true, updatable = true, length = 1, precision = 0)
    @Basic
    public String getGk() {
        return gk;
    }

    public void setGk(String gk) {
        this.gk = gk;
    }

    private String fkbz;

    @javax.persistence.Column(name = "fkbz", nullable = true, insertable = true, updatable = true, length = 1, precision = 0)
    @Basic
    public String getFkbz() {
        return fkbz;
    }

    public void setFkbz(String fkbz) {
        this.fkbz = fkbz;
    }

    private Integer fksl;

    @javax.persistence.Column(name = "fksl", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public Integer getFksl() {
        return fksl;
    }

    public void setFksl(Integer fksl) {
        this.fksl = fksl;
    }

    private String dybz;

    @javax.persistence.Column(name = "dybz", nullable = true, insertable = true, updatable = true, length = 1, precision = 0)
    @Basic
    public String getDybz() {
        return dybz;
    }

    public void setDybz(String dybz) {
        this.dybz = dybz;
    }

    private String email;

    @javax.persistence.Column(name = "email", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String url;

    @javax.persistence.Column(name = "url", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String mobile;

    @javax.persistence.Column(name = "mobile", nullable = true, insertable = true, updatable = true, length = 15, precision = 0)
    @Basic
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    private String djblx;

    @javax.persistence.Column(name = "djblx", nullable = true, insertable = true, updatable = true, length = 1, precision = 0)
    @Basic
    public String getDjblx() {
        return djblx;
    }

    public void setDjblx(String djblx) {
        this.djblx = djblx;
    }

    private Date lastdate;

    @javax.persistence.Column(name = "lastdate", nullable = true, insertable = true, updatable = true, length = 23, precision = 3)
    @Basic
    public Date getLastdate() {
        return lastdate;
    }

    public void setLastdate(Date lastdate) {
        this.lastdate = lastdate;
    }

    private String czflag;

    @javax.persistence.Column(name = "czflag", nullable = true, insertable = true, updatable = true, length = 1, precision = 0)
    @Basic
    public String getCzflag() {
        return czflag;
    }

    public void setCzflag(String czflag) {
        this.czflag = czflag;
    }

    private String sjzt;

    @javax.persistence.Column(name = "sjzt", nullable = true, insertable = true, updatable = true, length = 1, precision = 0)
    @Basic
    public String getSjzt() {
        return sjzt;
    }

    public void setSjzt(String sjzt) {
        this.sjzt = sjzt;
    }

    private String jyjg;

    @javax.persistence.Column(name = "jyjg", nullable = true, insertable = true, updatable = true, length = 30, precision = 0)
    @Basic
    public String getJyjg() {
        return jyjg;
    }

    public void setJyjg(String jyjg) {
        this.jyjg = jyjg;
    }

    private Short fz;

    @javax.persistence.Column(name = "fz", nullable = true, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public Short getFz() {
        return fz;
    }

    public void setFz(Short fz) {
        this.fz = fz;
    }

    private String njjhy;

    @javax.persistence.Column(name = "njjhy", nullable = true, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public String getNjjhy() {
        return njjhy;
    }

    public void setNjjhy(String njjhy) {
        this.njjhy = njjhy;
    }

    private String memo;

    @javax.persistence.Column(name = "memo", nullable = true, insertable = true, updatable = true, length = 500, precision = 0)
    @Basic
    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    private String njjlx;

    @javax.persistence.Column(name = "njjlx", nullable = true, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public String getNjjlx() {
        return njjlx;
    }

    public void setNjjlx(String njjlx) {
        this.njjlx = njjlx;
    }

    private String memo2;

    @javax.persistence.Column(name = "memo2", nullable = true, insertable = true, updatable = true, length = 500, precision = 0)
    @Basic
    public String getMemo2() {
        return memo2;
    }

    public void setMemo2(String memo2) {
        this.memo2 = memo2;
    }

    private String memo3;

    @javax.persistence.Column(name = "memo3")
    @Basic
    public String getMemo3() {
        return memo3;
    }

    public void setMemo3(String memo3) {
        this.memo3 = memo3;
    }

    private String memo4;

    @javax.persistence.Column(name = "memo4")
    @Basic
    public String getMemo4() {
        return memo4;
    }

    public void setMemo4(String memo4) {
        this.memo4 = memo4;
    }

    private String bak1;

    @javax.persistence.Column(name = "memo_bak1")
    @Basic
    public String getBak1() {
        return bak1;
    }

    public void setBak1(String bak1) {
        this.bak1 = bak1;
    }

    private String bak2;

    @javax.persistence.Column(name = "memo_bak2")
    @Basic
    public String getBak2() {
        return bak2;
    }

    public void setBak2(String bak2) {
        this.bak2 = bak2;
    }

    private String bak3;

    @javax.persistence.Column(name = "memo_bak3")
    @Basic
    public String getBak3() {
        return bak3;
    }

    public void setBak3(String bak3) {
        this.bak3 = bak3;
    }

    private String bak4;

    @javax.persistence.Column(name = "memo_bak4")
    @Basic
    public String getBak4() {
        return bak4;
    }

    public void setBak4(String bak4) {
        this.bak4 = bak4;
    }

    private String bak5;

    @javax.persistence.Column(name = "memo_bak5")
    @Basic
    public String getBak5() {
        return bak5;
    }

    public void setBak5(String bak5) {
        this.bak5 = bak5;
    }

    private String qrdszxdm;

    @javax.persistence.Column(name = "qrdszxdm", nullable = true, insertable = true, updatable = true, length = 6, precision = 0)
    @Basic
    public String getQrdszxdm() {
        return qrdszxdm;
    }

    public void setQrdszxdm(String qrdszxdm) {
        this.qrdszxdm = qrdszxdm;
    }

    private String qrdbzjgdm;

    @javax.persistence.Column(name = "qrdbzjgdm", nullable = true, insertable = true, updatable = true, length = 6, precision = 0)
    @Basic
    public String getQrdbzjgdm() {
        return qrdbzjgdm;
    }

    public void setQrdbzjgdm(String qrdbzjgdm) {
        this.qrdbzjgdm = qrdbzjgdm;
    }

    private String tbrxm;

    @javax.persistence.Column(name = "tbrxm", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public String getTbrxm() {
        return tbrxm;
    }

    public void setTbrxm(String tbrxm) {
        this.tbrxm = tbrxm;
    }

    private String tbrsfzh;

    @javax.persistence.Column(name = "tbrsfzh", nullable = true, insertable = true, updatable = true, length = 25, precision = 0)
    @Basic
    public String getTbrsfzh() {
        return tbrsfzh;
    }

    public void setTbrsfzh(String tbrsfzh) {
        this.tbrsfzh = tbrsfzh;
    }

    private String tbrlxfs;

    @javax.persistence.Column(name = "tbrlxfs", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String getTbrlxfs() {
        return tbrlxfs;
    }

    public void setTbrlxfs(String tbrlxfs) {
        this.tbrlxfs = tbrlxfs;
    }

    private Date gsfzrq;

    @javax.persistence.Column(name = "gsfzrq", nullable = true, insertable = true, updatable = true, length = 23, precision = 3)
    @Basic
    public Date getGsfzrq() {
        return gsfzrq;
    }

    public void setGsfzrq(Date gsfzrq) {
        this.gsfzrq = gsfzrq;
    }

    private String jydz;

    @javax.persistence.Column(name = "jydz", nullable = true, insertable = true, updatable = true, length = 120, precision = 0)
    @Basic
    public String getJydz() {
        return jydz;
    }

    public void setJydz(String jydz) {
        this.jydz = jydz;
    }

    private String jyyb;

    @javax.persistence.Column(name = "jyyb", nullable = true, insertable = true, updatable = true, length = 6, precision = 0)
    @Basic
    public String getJyyb() {
        return jyyb;
    }

    public void setJyyb(String jyyb) {
        this.jyyb = jyyb;
    }

    private String jydh;

    @javax.persistence.Column(name = "jydh", nullable = true, insertable = true, updatable = true, length = 16, precision = 0)
    @Basic
    public String getJydh() {
        return jydh;
    }

    public void setJydh(String jydh) {
        this.jydh = jydh;
    }

    private String jfly;

    @javax.persistence.Column(name = "jfly", nullable = true, insertable = true, updatable = true, length = 16, precision = 0)
    @Basic
    public String getJfly() {
        return jfly;
    }

    public void setJfly(String jfly) {
        this.jfly = jfly;
    }

    private String khyh;

    @javax.persistence.Column(name = "khyh", nullable = true, insertable = true, updatable = true, length = 100, precision = 0)
    @Basic
    public String getKhyh() {
        return khyh;
    }

    public void setKhyh(String khyh) {
        this.khyh = khyh;
    }

    private String khzh;

    @javax.persistence.Column(name = "khzh", nullable = true, insertable = true, updatable = true, length = 25, precision = 0)
    @Basic
    public String getKhzh() {
        return khzh;
    }

    public void setKhzh(String khzh) {
        this.khzh = khzh;
    }

    private String yjflag;

    @javax.persistence.Column(name = "yjflag", nullable = true, insertable = true, updatable = true, length = 1, precision = 0)
    @Basic
    public String getYjflag() {
        return yjflag;
    }

    public void setYjflag(String yjflag) {
        this.yjflag = yjflag;
    }

    private String jgxydm;

    @javax.persistence.Column(name = "jgxydm", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String getJgxydm() {
        return jgxydm;
    }

    public void setJgxydm(String jgxydm) {
        this.jgxydm = jgxydm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TQzjgdm tQzjgdm = (TQzjgdm) o;

        if (fksl != tQzjgdm.fksl) return false;
        if (fz != tQzjgdm.fz) return false;
        if (id != tQzjgdm.id) return false;
        if (zgrs != tQzjgdm.zgrs) return false;
        if (bgbj != null ? !bgbj.equals(tQzjgdm.bgbj) : tQzjgdm.bgbj != null) return false;
        if (bgrq != null ? !bgrq.equals(tQzjgdm.bgrq) : tQzjgdm.bgrq != null) return false;
        if (bzjgdm != null ? !bzjgdm.equals(tQzjgdm.bzjgdm) : tQzjgdm.bzjgdm != null) return false;
        if (bzrq != null ? !bzrq.equals(tQzjgdm.bzrq) : tQzjgdm.bzrq != null) return false;
        if (czflag != null ? !czflag.equals(tQzjgdm.czflag) : tQzjgdm.czflag != null) return false;
        if (dhhm != null ? !dhhm.equals(tQzjgdm.dhhm) : tQzjgdm.dhhm != null) return false;
        if (djblx != null ? !djblx.equals(tQzjgdm.djblx) : tQzjgdm.djblx != null) return false;
        if (dybz != null ? !dybz.equals(tQzjgdm.dybz) : tQzjgdm.dybz != null) return false;
        if (email != null ? !email.equals(tQzjgdm.email) : tQzjgdm.email != null) return false;
        if (fbsl != null ? !fbsl.equals(tQzjgdm.fbsl) : tQzjgdm.fbsl != null) return false;
        if (fddbr != null ? !fddbr.equals(tQzjgdm.fddbr) : tQzjgdm.fddbr != null) return false;
        if (fkbz != null ? !fkbz.equals(tQzjgdm.fkbz) : tQzjgdm.fkbz != null) return false;
        if (gk != null ? !gk.equals(tQzjgdm.gk) : tQzjgdm.gk != null) return false;
        if (gsfzrq != null ? !gsfzrq.equals(tQzjgdm.gsfzrq) : tQzjgdm.gsfzrq != null) return false;
        if (gslsh != null ? !gslsh.equals(tQzjgdm.gslsh) : tQzjgdm.gslsh != null) return false;
        if (gstbr != null ? !gstbr.equals(tQzjgdm.gstbr) : tQzjgdm.gstbr != null) return false;
        if (hbzl != null ? !hbzl.equals(tQzjgdm.hbzl) : tQzjgdm.hbzl != null) return false;
        if (jfly != null ? !jfly.equals(tQzjgdm.jfly) : tQzjgdm.jfly != null) return false;
        if (jgdm != null ? !jgdm.equals(tQzjgdm.jgdm) : tQzjgdm.jgdm != null) return false;
        if (jgdz != null ? !jgdz.equals(tQzjgdm.jgdz) : tQzjgdm.jgdz != null) return false;
        if (jglx != null ? !jglx.equals(tQzjgdm.jglx) : tQzjgdm.jglx != null) return false;
        if (jgmc != null ? !jgmc.equals(tQzjgdm.jgmc) : tQzjgdm.jgmc != null) return false;
        if (jjhy != null ? !jjhy.equals(tQzjgdm.jjhy) : tQzjgdm.jjhy != null) return false;
        if (jjlx != null ? !jjlx.equals(tQzjgdm.jjlx) : tQzjgdm.jjlx != null) return false;
        if (jydh != null ? !jydh.equals(tQzjgdm.jydh) : tQzjgdm.jydh != null) return false;
        if (jydz != null ? !jydz.equals(tQzjgdm.jydz) : tQzjgdm.jydz != null) return false;
        if (jyfw != null ? !jyfw.equals(tQzjgdm.jyfw) : tQzjgdm.jyfw != null) return false;
        if (jyjg != null ? !jyjg.equals(tQzjgdm.jyjg) : tQzjgdm.jyjg != null) return false;
        if (jyyb != null ? !jyyb.equals(tQzjgdm.jyyb) : tQzjgdm.jyyb != null) return false;
        if (khyh != null ? !khyh.equals(tQzjgdm.khyh) : tQzjgdm.khyh != null) return false;
        if (khzh != null ? !khzh.equals(tQzjgdm.khzh) : tQzjgdm.khzh != null) return false;
        if (lastdate != null ? !lastdate.equals(tQzjgdm.lastdate) : tQzjgdm.lastdate != null) return false;
        if (lry != null ? !lry.equals(tQzjgdm.lry) : tQzjgdm.lry != null) return false;
        if (memo != null ? !memo.equals(tQzjgdm.memo) : tQzjgdm.memo != null) return false;
        if (memo2 != null ? !memo2.equals(tQzjgdm.memo2) : tQzjgdm.memo2 != null) return false;
        if (mobile != null ? !mobile.equals(tQzjgdm.mobile) : tQzjgdm.mobile != null) return false;
        if (njjhy != null ? !njjhy.equals(tQzjgdm.njjhy) : tQzjgdm.njjhy != null) return false;
        if (njjlx != null ? !njjlx.equals(tQzjgdm.njjlx) : tQzjgdm.njjlx != null) return false;
        if (njqx != null ? !njqx.equals(tQzjgdm.njqx) : tQzjgdm.njqx != null) return false;
        if (njr != null ? !njr.equals(tQzjgdm.njr) : tQzjgdm.njr != null) return false;
        if (njrq != null ? !njrq.equals(tQzjgdm.njrq) : tQzjgdm.njrq != null) return false;
        if (pwrq != null ? !pwrq.equals(tQzjgdm.pwrq) : tQzjgdm.pwrq != null) return false;
        if (pzjgdm != null ? !pzjgdm.equals(tQzjgdm.pzjgdm) : tQzjgdm.pzjgdm != null) return false;
        if (pzjgmc != null ? !pzjgmc.equals(tQzjgdm.pzjgmc) : tQzjgdm.pzjgmc != null) return false;
        if (pzwh != null ? !pzwh.equals(tQzjgdm.pzwh) : tQzjgdm.pzwh != null) return false;
        if (qrdbzjgdm != null ? !qrdbzjgdm.equals(tQzjgdm.qrdbzjgdm) : tQzjgdm.qrdbzjgdm != null) return false;
        if (qrdszxdm != null ? !qrdszxdm.equals(tQzjgdm.qrdszxdm) : tQzjgdm.qrdszxdm != null) return false;
        if (qzbz != null ? !qzbz.equals(tQzjgdm.qzbz) : tQzjgdm.qzbz != null) return false;
        if (qzrq != null ? !qzrq.equals(tQzjgdm.qzrq) : tQzjgdm.qzrq != null) return false;
        if (qzxzqh != null ? !qzxzqh.equals(tQzjgdm.qzxzqh) : tQzjgdm.qzxzqh != null) return false;
        if (scbzrq != null ? !scbzrq.equals(tQzjgdm.scbzrq) : tQzjgdm.scbzrq != null) return false;
        if (sjzt != null ? !sjzt.equals(tQzjgdm.sjzt) : tQzjgdm.sjzt != null) return false;
        if (tbrlxfs != null ? !tbrlxfs.equals(tQzjgdm.tbrlxfs) : tQzjgdm.tbrlxfs != null) return false;
        if (tbrsfzh != null ? !tbrsfzh.equals(tQzjgdm.tbrsfzh) : tQzjgdm.tbrsfzh != null) return false;
        if (tbrxm != null ? !tbrxm.equals(tQzjgdm.tbrxm) : tQzjgdm.tbrxm != null) return false;
        if (url != null ? !url.equals(tQzjgdm.url) : tQzjgdm.url != null) return false;
        if (wftzgb != null ? !wftzgb.equals(tQzjgdm.wftzgb) : tQzjgdm.wftzgb != null) return false;
        if (wjwlsh != null ? !wjwlsh.equals(tQzjgdm.wjwlsh) : tQzjgdm.wjwlsh != null) return false;
        if (wjwtbr != null ? !wjwtbr.equals(tQzjgdm.wjwtbr) : tQzjgdm.wjwtbr != null) return false;
        if (xgr != null ? !xgr.equals(tQzjgdm.xgr) : tQzjgdm.xgr != null) return false;
        if (xzqh != null ? !xzqh.equals(tQzjgdm.xzqh) : tQzjgdm.xzqh != null) return false;
        if (yjflag != null ? !yjflag.equals(tQzjgdm.yjflag) : tQzjgdm.yjflag != null) return false;
        if (yzbm != null ? !yzbm.equals(tQzjgdm.yzbm) : tQzjgdm.yzbm != null) return false;
        if (zbsl != null ? !zbsl.equals(tQzjgdm.zbsl) : tQzjgdm.zbsl != null) return false;
        if (zch != null ? !zch.equals(tQzjgdm.zch) : tQzjgdm.zch != null) return false;
        if (zcrq != null ? !zcrq.equals(tQzjgdm.zcrq) : tQzjgdm.zcrq != null) return false;
        if (zfrq != null ? !zfrq.equals(tQzjgdm.zfrq) : tQzjgdm.zfrq != null) return false;
        if (zgdm != null ? !zgdm.equals(tQzjgdm.zgdm) : tQzjgdm.zgdm != null) return false;
        if (zgmc != null ? !zgmc.equals(tQzjgdm.zgmc) : tQzjgdm.zgmc != null) return false;
        if (zjhm != null ? !zjhm.equals(tQzjgdm.zjhm) : tQzjgdm.zjhm != null) return false;
        if (zjlx != null ? !zjlx.equals(tQzjgdm.zjlx) : tQzjgdm.zjlx != null) return false;
        if (zslsh != null ? !zslsh.equals(tQzjgdm.zslsh) : tQzjgdm.zslsh != null) return false;
        if (zycp1 != null ? !zycp1.equals(tQzjgdm.zycp1) : tQzjgdm.zycp1 != null) return false;
        if (zycp2 != null ? !zycp2.equals(tQzjgdm.zycp2) : tQzjgdm.zycp2 != null) return false;
        if (zycp3 != null ? !zycp3.equals(tQzjgdm.zycp3) : tQzjgdm.zycp3 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (jgdm != null ? jgdm.hashCode() : 0);
        result = 31 * result + (jgmc != null ? jgmc.hashCode() : 0);
        result = 31 * result + (jglx != null ? jglx.hashCode() : 0);
        result = 31 * result + (fddbr != null ? fddbr.hashCode() : 0);
        result = 31 * result + (zjlx != null ? zjlx.hashCode() : 0);
        result = 31 * result + (zjhm != null ? zjhm.hashCode() : 0);
        result = 31 * result + (jyfw != null ? jyfw.hashCode() : 0);
        result = 31 * result + (jjhy != null ? jjhy.hashCode() : 0);
        result = 31 * result + (jjlx != null ? jjlx.hashCode() : 0);
        result = 31 * result + (zcrq != null ? zcrq.hashCode() : 0);
        result = 31 * result + (zgdm != null ? zgdm.hashCode() : 0);
        result = 31 * result + (pzjgdm != null ? pzjgdm.hashCode() : 0);
        result = 31 * result + (qzxzqh != null ? qzxzqh.hashCode() : 0);
        result = 31 * result + (xzqh != null ? xzqh.hashCode() : 0);
        result = 31 * result + (jgdz != null ? jgdz.hashCode() : 0);
        result = 31 * result + (yzbm != null ? yzbm.hashCode() : 0);
        result = 31 * result + (dhhm != null ? dhhm.hashCode() : 0);
        result = 31 * result + (scbzrq != null ? scbzrq.hashCode() : 0);
        result = 31 * result + (bzrq != null ? bzrq.hashCode() : 0);
        result = 31 * result + (zfrq != null ? zfrq.hashCode() : 0);
        result = 31 * result + (bzjgdm != null ? bzjgdm.hashCode() : 0);
        result = 31 * result + (zycp1 != null ? zycp1.hashCode() : 0);
        result = 31 * result + (zycp2 != null ? zycp2.hashCode() : 0);
        result = 31 * result + (zycp3 != null ? zycp3.hashCode() : 0);
        result = 31 * result + (hbzl != null ? hbzl.hashCode() : 0);
        result = 31 * result + (wftzgb != null ? wftzgb.hashCode() : 0);
        result = 31 * result + zgrs;
        result = 31 * result + (fbsl != null ? fbsl.hashCode() : 0);
        result = 31 * result + (zslsh != null ? zslsh.hashCode() : 0);
        result = 31 * result + (bgbj != null ? bgbj.hashCode() : 0);
        result = 31 * result + (bgrq != null ? bgrq.hashCode() : 0);
        result = 31 * result + (lry != null ? lry.hashCode() : 0);
        result = 31 * result + (njrq != null ? njrq.hashCode() : 0);
        result = 31 * result + (njr != null ? njr.hashCode() : 0);
        result = 31 * result + (njqx != null ? njqx.hashCode() : 0);
        result = 31 * result + (xgr != null ? xgr.hashCode() : 0);
        result = 31 * result + (zbsl != null ? zbsl.hashCode() : 0);
        result = 31 * result + (zch != null ? zch.hashCode() : 0);
        result = 31 * result + (qzbz != null ? qzbz.hashCode() : 0);
        result = 31 * result + (qzrq != null ? qzrq.hashCode() : 0);
        result = 31 * result + (zgmc != null ? zgmc.hashCode() : 0);
        result = 31 * result + (pzjgmc != null ? pzjgmc.hashCode() : 0);
        result = 31 * result + (gslsh != null ? gslsh.hashCode() : 0);
        result = 31 * result + (gstbr != null ? gstbr.hashCode() : 0);
        result = 31 * result + (wjwlsh != null ? wjwlsh.hashCode() : 0);
        result = 31 * result + (pzwh != null ? pzwh.hashCode() : 0);
        result = 31 * result + (pwrq != null ? pwrq.hashCode() : 0);
        result = 31 * result + (wjwtbr != null ? wjwtbr.hashCode() : 0);
        result = 31 * result + (gk != null ? gk.hashCode() : 0);
        result = 31 * result + (fkbz != null ? fkbz.hashCode() : 0);
        result = 31 * result + fksl;
        result = 31 * result + (dybz != null ? dybz.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (djblx != null ? djblx.hashCode() : 0);
        result = 31 * result + (lastdate != null ? lastdate.hashCode() : 0);
        result = 31 * result + (czflag != null ? czflag.hashCode() : 0);
        result = 31 * result + (sjzt != null ? sjzt.hashCode() : 0);
        result = 31 * result + (jyjg != null ? jyjg.hashCode() : 0);
        result = 31 * result + (int) fz;
        result = 31 * result + (njjhy != null ? njjhy.hashCode() : 0);
        result = 31 * result + (memo != null ? memo.hashCode() : 0);
        result = 31 * result + (njjlx != null ? njjlx.hashCode() : 0);
        result = 31 * result + (memo2 != null ? memo2.hashCode() : 0);
        result = 31 * result + (qrdszxdm != null ? qrdszxdm.hashCode() : 0);
        result = 31 * result + (qrdbzjgdm != null ? qrdbzjgdm.hashCode() : 0);
        result = 31 * result + (tbrxm != null ? tbrxm.hashCode() : 0);
        result = 31 * result + (tbrsfzh != null ? tbrsfzh.hashCode() : 0);
        result = 31 * result + (tbrlxfs != null ? tbrlxfs.hashCode() : 0);
        result = 31 * result + (gsfzrq != null ? gsfzrq.hashCode() : 0);
        result = 31 * result + (jydz != null ? jydz.hashCode() : 0);
        result = 31 * result + (jyyb != null ? jyyb.hashCode() : 0);
        result = 31 * result + (jydh != null ? jydh.hashCode() : 0);
        result = 31 * result + (jfly != null ? jfly.hashCode() : 0);
        result = 31 * result + (khyh != null ? khyh.hashCode() : 0);
        result = 31 * result + (khzh != null ? khzh.hashCode() : 0);
        result = 31 * result + (yjflag != null ? yjflag.hashCode() : 0);
        return result;
    }
}
