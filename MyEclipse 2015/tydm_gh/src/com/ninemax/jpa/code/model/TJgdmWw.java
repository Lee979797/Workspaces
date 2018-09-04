package com.ninemax.jpa.code.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-8-8
 * Time: ÏÂÎç2:37
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "t_jgdm_ww")
@Entity
public class TJgdmWw {
    private Long id;

    @javax.persistence.Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String jgdm;

    @javax.persistence.Column(name = "jgdm")
    @Basic
    public String getJgdm() {
        return jgdm;
    }

    public void setJgdm(String jgdm) {
        this.jgdm = jgdm;
    }

    private String jgmc;

    @javax.persistence.Column(name = "jgmc")
    @Basic
    public String getJgmc() {
        return jgmc;
    }

    public void setJgmc(String jgmc) {
        this.jgmc = jgmc;
    }

    private String jglx;

    @javax.persistence.Column(name = "jglx")
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

    @javax.persistence.Column(name = "fddbr")
    @Basic
    public String getFddbr() {
        return fddbr;
    }

    public void setFddbr(String fddbr) {
        this.fddbr = fddbr;
    }

    private String zjlx;

    @javax.persistence.Column(name = "zjlx")
    @Basic
    public String getZjlx() {
        return zjlx;
    }

    public void setZjlx(String zjlx) {
        this.zjlx = zjlx;
    }

    private String zjhm;

    @javax.persistence.Column(name = "zjhm")
    @Basic
    public String getZjhm() {
        return zjhm;
    }

    public void setZjhm(String zjhm) {
        this.zjhm = zjhm;
    }

    private String jyfw;

    @javax.persistence.Column(name = "jyfw")
    @Basic
    public String getJyfw() {
        return jyfw;
    }

    public void setJyfw(String jyfw) {
        this.jyfw = jyfw;
    }

    private String jjhy;

    @javax.persistence.Column(name = "jjhy")
    @Basic
    public String getJjhy() {
        return jjhy;
    }

    public void setJjhy(String jjhy) {
        this.jjhy = jjhy;
    }

    private String jjlx;

    @javax.persistence.Column(name = "jjlx")
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

    @javax.persistence.Column(name = "zcrq")
    @Basic
    public Date getZcrq() {
        return zcrq;
    }

    public void setZcrq(Date zcrq) {
        this.zcrq = zcrq;
    }

    private String zgdm;

    @javax.persistence.Column(name = "zgdm")
    @Basic
    public String getZgdm() {
        return zgdm;
    }

    public void setZgdm(String zgdm) {
        this.zgdm = zgdm;
    }

    private String pzjgdm;

    @javax.persistence.Column(name = "pzjgdm")
    @Basic
    public String getPzjgdm() {
        return pzjgdm;
    }

    public void setPzjgdm(String pzjgdm) {
        this.pzjgdm = pzjgdm;
    }

    private String xzqh;

    @javax.persistence.Column(name = "xzqh")
    @Basic
    public String getXzqh() {
        return xzqh;
    }

    public void setXzqh(String xzqh) {
        this.xzqh = xzqh;
    }

    private String jgdz;

    @javax.persistence.Column(name = "jgdz")
    @Basic
    public String getJgdz() {
        return jgdz;
    }

    public void setJgdz(String jgdz) {
        this.jgdz = jgdz;
    }

    private String yzbm;

    @javax.persistence.Column(name = "yzbm")
    @Basic
    public String getYzbm() {
        return yzbm;
    }

    public void setYzbm(String yzbm) {
        this.yzbm = yzbm;
    }

    private String dhhm;

    @javax.persistence.Column(name = "dhhm")
    @Basic
    public String getDhhm() {
        return dhhm;
    }

    public void setDhhm(String dhhm) {
        this.dhhm = dhhm;
    }

    private Date scbzrq;

    @javax.persistence.Column(name = "scbzrq")
    @Basic
    public Date getScbzrq() {
        return scbzrq;
    }

    public void setScbzrq(Date scbzrq) {
        this.scbzrq = scbzrq;
    }

    private Date bzrq;

    @javax.persistence.Column(name = "bzrq")
    @Basic
    public Date getBzrq() {
        return bzrq;
    }

    public void setBzrq(Date bzrq) {
        this.bzrq = bzrq;
    }

    private Date zfrq;

    @javax.persistence.Column(name = "zfrq")
    @Basic
    public Date getZfrq() {
        return zfrq;
    }

    public void setZfrq(Date zfrq) {
        this.zfrq = zfrq;
    }

    private String bzjgdm;

    @javax.persistence.Column(name = "bzjgdm")
    @Basic
    public String getBzjgdm() {
        return bzjgdm;
    }

    public void setBzjgdm(String bzjgdm) {
        this.bzjgdm = bzjgdm;
    }

    private String zycp1;

    @javax.persistence.Column(name = "zycp1")
    @Basic
    public String getZycp1() {
        return zycp1;
    }

    public void setZycp1(String zycp1) {
        this.zycp1 = zycp1;
    }

    private String zycp2;

    @javax.persistence.Column(name = "zycp2")
    @Basic
    public String getZycp2() {
        return zycp2;
    }

    public void setZycp2(String zycp2) {
        this.zycp2 = zycp2;
    }

    private String zycp3;

    @javax.persistence.Column(name = "zycp3")
    @Basic
    public String getZycp3() {
        return zycp3;
    }

    public void setZycp3(String zycp3) {
        this.zycp3 = zycp3;
    }

    private Double zczj;

    @javax.persistence.Column(name = "zczj")
    @Basic
    public Double getZczj() {
        return zczj;
    }

    public void setZczj(Double zczj) {
        this.zczj = zczj;
    }

    private String hbzl;

    @javax.persistence.Column(name = "hbzl")
    @Basic
    public String getHbzl() {
        return hbzl;
    }

    public void setHbzl(String hbzl) {
        this.hbzl = hbzl;
    }

    private String wftzgb;

    @javax.persistence.Column(name = "wftzgb")
    @Basic
    public String getWftzgb() {
        return wftzgb;
    }

    public void setWftzgb(String wftzgb) {
        this.wftzgb = wftzgb;
    }

    private Integer zgrs;

    @javax.persistence.Column(name = "zgrs")
    @Basic
    public Integer getZgrs() {
        return zgrs;
    }

    public void setZgrs(Integer zgrs) {
        this.zgrs = zgrs;
    }

    private Integer fbsl;

    @javax.persistence.Column(name = "fbsl")
    @Basic
    public Integer getFbsl() {
        return fbsl;
    }

    public void setFbsl(Integer fbsl) {
        this.fbsl = fbsl;
    }

    private String zslsh;

    @javax.persistence.Column(name = "zslsh")
    @Basic
    public String getZslsh() {
        return zslsh;
    }

    public void setZslsh(String zslsh) {
        this.zslsh = zslsh;
    }

    private String bgbj;

    @javax.persistence.Column(name = "bgbj")
    @Basic
    public String getBgbj() {
        return bgbj;
    }

    public void setBgbj(String bgbj) {
        this.bgbj = bgbj;
    }

    private Date bgrq;

    @javax.persistence.Column(name = "bgrq")
    @Basic
    public Date getBgrq() {
        return bgrq;
    }

    public void setBgrq(Date bgrq) {
        this.bgrq = bgrq;
    }

    private String lry;

    @javax.persistence.Column(name = "lry")
    @Basic
    public String getLry() {
        return lry;
    }

    public void setLry(String lry) {
        this.lry = lry;
    }

    private Date njrq;

    @javax.persistence.Column(name = "njrq")
    @Basic
    public Date getNjrq() {
        return njrq;
    }

    public void setNjrq(Date njrq) {
        this.njrq = njrq;
    }

    private String njr;

    @javax.persistence.Column(name = "njr")
    @Basic
    public String getNjr() {
        return njr;
    }

    public void setNjr(String njr) {
        this.njr = njr;
    }

    private Date njqx;

    @javax.persistence.Column(name = "njqx")
    @Basic
    public Date getNjqx() {
        return njqx;
    }

    public void setNjqx(Date njqx) {
        this.njqx = njqx;
    }

    private String xgr;

    @javax.persistence.Column(name = "xgr")
    @Basic
    public String getXgr() {
        return xgr;
    }

    public void setXgr(String xgr) {
        this.xgr = xgr;
    }

    private Integer zbsl;

    @javax.persistence.Column(name = "zbsl")
    @Basic
    public Integer getZbsl() {
        return zbsl;
    }

    public void setZbsl(Integer zbsl) {
        this.zbsl = zbsl;
    }

    private String zch;

    @javax.persistence.Column(name = "zch")
    @Basic
    public String getZch() {
        return zch;
    }

    public void setZch(String zch) {
        this.zch = zch;
    }

    private String qzbz;

    @javax.persistence.Column(name = "qzbz")
    @Basic
    public String getQzbz() {
        return qzbz;
    }

    public void setQzbz(String qzbz) {
        this.qzbz = qzbz;
    }

    private Date qzrq;

    @javax.persistence.Column(name = "qzrq")
    @Basic
    public Date getQzrq() {
        return qzrq;
    }

    public void setQzrq(Date qzrq) {
        this.qzrq = qzrq;
    }

    private String zgmc;

    @javax.persistence.Column(name = "zgmc")
    @Basic
    public String getZgmc() {
        return zgmc;
    }

    public void setZgmc(String zgmc) {
        this.zgmc = zgmc;
    }

    private String pzjgmc;

    @javax.persistence.Column(name = "pzjgmc")
    @Basic
    public String getPzjgmc() {
        return pzjgmc;
    }

    public void setPzjgmc(String pzjgmc) {
        this.pzjgmc = pzjgmc;
    }

    private String gslsh;

    @javax.persistence.Column(name = "gslsh")
    @Basic
    public String getGslsh() {
        return gslsh;
    }

    public void setGslsh(String gslsh) {
        this.gslsh = gslsh;
    }

    private String gstbr;

    @javax.persistence.Column(name = "gstbr")
    @Basic
    public String getGstbr() {
        return gstbr;
    }

    public void setGstbr(String gstbr) {
        this.gstbr = gstbr;
    }

    private String wjwlsh;

    @javax.persistence.Column(name = "wjwlsh")
    @Basic
    public String getWjwlsh() {
        return wjwlsh;
    }

    public void setWjwlsh(String wjwlsh) {
        this.wjwlsh = wjwlsh;
    }

    private String pzwh;

    @javax.persistence.Column(name = "pzwh")
    @Basic
    public String getPzwh() {
        return pzwh;
    }

    public void setPzwh(String pzwh) {
        this.pzwh = pzwh;
    }

    private Date pwrq;

    @javax.persistence.Column(name = "pwrq")
    @Basic
    public Date getPwrq() {
        return pwrq;
    }

    public void setPwrq(Date pwrq) {
        this.pwrq = pwrq;
    }

    private String wjwtbr;

    @javax.persistence.Column(name = "wjwtbr")
    @Basic
    public String getWjwtbr() {
        return wjwtbr;
    }

    public void setWjwtbr(String wjwtbr) {
        this.wjwtbr = wjwtbr;
    }

    private String gk;

    @javax.persistence.Column(name = "gk")
    @Basic
    public String getGk() {
        return gk;
    }

    public void setGk(String gk) {
        this.gk = gk;
    }

    private String fkbz;

    @javax.persistence.Column(name = "fkbz")
    @Basic
    public String getFkbz() {
        return fkbz;
    }

    public void setFkbz(String fkbz) {
        this.fkbz = fkbz;
    }

    private Integer fksl;

    @javax.persistence.Column(name = "fksl")
    @Basic
    public Integer getFksl() {
        return fksl;
    }

    public void setFksl(Integer fksl) {
        this.fksl = fksl;
    }

    private String dybz;

    @javax.persistence.Column(name = "dybz")
    @Basic
    public String getDybz() {
        return dybz;
    }

    public void setDybz(String dybz) {
        this.dybz = dybz;
    }

    private String email;

    @javax.persistence.Column(name = "email")
    @Basic
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String url;

    @javax.persistence.Column(name = "url")
    @Basic
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String mobile;

    @javax.persistence.Column(name = "mobile")
    @Basic
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    private String djblx;

    @javax.persistence.Column(name = "djblx")
    @Basic
    public String getDjblx() {
        return djblx;
    }

    public void setDjblx(String djblx) {
        this.djblx = djblx;
    }

    private String jyjg;

    @javax.persistence.Column(name = "jyjg")
    @Basic
    public String getJyjg() {
        return jyjg;
    }

    public void setJyjg(String jyjg) {
        this.jyjg = jyjg;
    }

    private Short fz;

    @javax.persistence.Column(name = "fz")
    @Basic
    public Short getFz() {
        return fz;
    }

    public void setFz(Short fz) {
        this.fz = fz;
    }

    private String njjhy;

    @javax.persistence.Column(name = "njjhy")
    @Basic
    public String getNjjhy() {
        return njjhy;
    }

    public void setNjjhy(String njjhy) {
        this.njjhy = njjhy;
    }

    private String memo;

    @javax.persistence.Column(name = "memo")
    @Basic
    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    private String njjlx;

    @javax.persistence.Column(name = "njjlx")
    @Basic
    public String getNjjlx() {
        return njjlx;
    }

    public void setNjjlx(String njjlx) {
        this.njjlx = njjlx;
    }

    private String memo2;

    @javax.persistence.Column(name = "memo2")
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

    private String tbrxm;

    @javax.persistence.Column(name = "tbrxm")
    @Basic
    public String getTbrxm() {
        return tbrxm;
    }

    public void setTbrxm(String tbrxm) {
        this.tbrxm = tbrxm;
    }

    private String tbrsfzh;

    @javax.persistence.Column(name = "tbrsfzh")
    @Basic
    public String getTbrsfzh() {
        return tbrsfzh;
    }

    public void setTbrsfzh(String tbrsfzh) {
        this.tbrsfzh = tbrsfzh;
    }

    private String tbrlxfs;

    @javax.persistence.Column(name = "tbrlxfs")
    @Basic
    public String getTbrlxfs() {
        return tbrlxfs;
    }

    public void setTbrlxfs(String tbrlxfs) {
        this.tbrlxfs = tbrlxfs;
    }

    private Date gsfzrq;

    @javax.persistence.Column(name = "gsfzrq")
    @Basic
    public Date getGsfzrq() {
        return gsfzrq;
    }

    public void setGsfzrq(Date gsfzrq) {
        this.gsfzrq = gsfzrq;
    }

    private String jydz;

    @javax.persistence.Column(name = "jydz")
    @Basic
    public String getJydz() {
        return jydz;
    }

    public void setJydz(String jydz) {
        this.jydz = jydz;
    }

    private String jyyb;

    @javax.persistence.Column(name = "jyyb")
    @Basic
    public String getJyyb() {
        return jyyb;
    }

    public void setJyyb(String jyyb) {
        this.jyyb = jyyb;
    }

    private String jydh;

    @javax.persistence.Column(name = "jydh")
    @Basic
    public String getJydh() {
        return jydh;
    }

    public void setJydh(String jydh) {
        this.jydh = jydh;
    }

    private String jfly;

    @javax.persistence.Column(name = "jfly")
    @Basic
    public String getJfly() {
        return jfly;
    }

    public void setJfly(String jfly) {
        this.jfly = jfly;
    }

    private String khyh;

    @javax.persistence.Column(name = "khyh")
    @Basic
    public String getKhyh() {
        return khyh;
    }

    public void setKhyh(String khyh) {
        this.khyh = khyh;
    }

    private String khzh;

    @javax.persistence.Column(name = "khzh")
    @Basic
    public String getKhzh() {
        return khzh;
    }

    public void setKhzh(String khzh) {
        this.khzh = khzh;
    }

    private String userid;

    @javax.persistence.Column(name = "userid")
    @Basic
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    private String fzyj;

    @javax.persistence.Column(name = "fzyj")
    @Basic
    public String getFzyj() {
        return fzyj;
    }

    public void setFzyj(String fzyj) {
        this.fzyj = fzyj;
    }

    private String fzreason;

    @javax.persistence.Column(name = "fzreason")
    @Basic
    public String getFzreason() {
        return fzreason;
    }

    public void setFzreason(String fzreason) {
        this.fzreason = fzreason;
    }

    private String type;

    @javax.persistence.Column(name = "type")
    @Basic
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String djh;

    @javax.persistence.Column(name = "djh")
    @Basic
    public String getDjh() {
        return djh;
    }

    public void setDjh(String djh) {
        this.djh = djh;
    }

    private Date djrq;

    @javax.persistence.Column(name = "djrq")
    @Basic
    public Date getDjrq() {
        return djrq;
    }

    public void setDjrq(Date djrq) {
        this.djrq = djrq;
    }

    private String gsreason;

    @javax.persistence.Column(name = "gsreason")
    @Basic
    public String getGsreason() {
        return gsreason;
    }

    public void setGsreason(String gsreason) {
        this.gsreason = gsreason;
    }

    private String gsyj;

    @javax.persistence.Column(name = "gsyj")
    @Basic
    public String getGsyj() {
        return gsyj;
    }

    public void setGsyj(String gsyj) {
        this.gsyj = gsyj;
    }

    private String status;

    @javax.persistence.Column(name = "status")
    @Basic
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private Date clrq;

    @javax.persistence.Column(name = "clrq")
    @Basic
    public Date getClrq() {
        return clrq;
    }

    public void setClrq(Date clrq) {
        this.clrq = clrq;
    }

    private String shDate;

    @javax.persistence.Column(name = "shDate")
    @Basic
    public String getShDate() {
        return shDate;
    }

    public void setShDate(String shDate) {
        this.shDate = shDate;
    }

    private String shSuggest;

    @javax.persistence.Column(name = "shSuggest")
    @Basic
    public String getShSuggest() {
        return shSuggest;
    }

    public void setShSuggest(String shSuggest) {
        this.shSuggest = shSuggest;
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

        TJgdmWw tJgdmWw = (TJgdmWw) o;

        if (bgbj != null ? !bgbj.equals(tJgdmWw.bgbj) : tJgdmWw.bgbj != null) return false;
        if (bgrq != null ? !bgrq.equals(tJgdmWw.bgrq) : tJgdmWw.bgrq != null) return false;
        if (bzjgdm != null ? !bzjgdm.equals(tJgdmWw.bzjgdm) : tJgdmWw.bzjgdm != null) return false;
        if (bzrq != null ? !bzrq.equals(tJgdmWw.bzrq) : tJgdmWw.bzrq != null) return false;
        if (clrq != null ? !clrq.equals(tJgdmWw.clrq) : tJgdmWw.clrq != null) return false;
        if (dhhm != null ? !dhhm.equals(tJgdmWw.dhhm) : tJgdmWw.dhhm != null) return false;
        if (djblx != null ? !djblx.equals(tJgdmWw.djblx) : tJgdmWw.djblx != null) return false;
        if (djh != null ? !djh.equals(tJgdmWw.djh) : tJgdmWw.djh != null) return false;
        if (djrq != null ? !djrq.equals(tJgdmWw.djrq) : tJgdmWw.djrq != null) return false;
        if (dybz != null ? !dybz.equals(tJgdmWw.dybz) : tJgdmWw.dybz != null) return false;
        if (email != null ? !email.equals(tJgdmWw.email) : tJgdmWw.email != null) return false;
        if (fbsl != null ? !fbsl.equals(tJgdmWw.fbsl) : tJgdmWw.fbsl != null) return false;
        if (fddbr != null ? !fddbr.equals(tJgdmWw.fddbr) : tJgdmWw.fddbr != null) return false;
        if (fkbz != null ? !fkbz.equals(tJgdmWw.fkbz) : tJgdmWw.fkbz != null) return false;
        if (fksl != null ? !fksl.equals(tJgdmWw.fksl) : tJgdmWw.fksl != null) return false;
        if (fz != null ? !fz.equals(tJgdmWw.fz) : tJgdmWw.fz != null) return false;
        if (fzreason != null ? !fzreason.equals(tJgdmWw.fzreason) : tJgdmWw.fzreason != null) return false;
        if (fzyj != null ? !fzyj.equals(tJgdmWw.fzyj) : tJgdmWw.fzyj != null) return false;
        if (gk != null ? !gk.equals(tJgdmWw.gk) : tJgdmWw.gk != null) return false;
        if (gsfzrq != null ? !gsfzrq.equals(tJgdmWw.gsfzrq) : tJgdmWw.gsfzrq != null) return false;
        if (gslsh != null ? !gslsh.equals(tJgdmWw.gslsh) : tJgdmWw.gslsh != null) return false;
        if (gsreason != null ? !gsreason.equals(tJgdmWw.gsreason) : tJgdmWw.gsreason != null) return false;
        if (gstbr != null ? !gstbr.equals(tJgdmWw.gstbr) : tJgdmWw.gstbr != null) return false;
        if (gsyj != null ? !gsyj.equals(tJgdmWw.gsyj) : tJgdmWw.gsyj != null) return false;
        if (hbzl != null ? !hbzl.equals(tJgdmWw.hbzl) : tJgdmWw.hbzl != null) return false;
        if (id != null ? !id.equals(tJgdmWw.id) : tJgdmWw.id != null) return false;
        if (jfly != null ? !jfly.equals(tJgdmWw.jfly) : tJgdmWw.jfly != null) return false;
        if (jgdm != null ? !jgdm.equals(tJgdmWw.jgdm) : tJgdmWw.jgdm != null) return false;
        if (jgdz != null ? !jgdz.equals(tJgdmWw.jgdz) : tJgdmWw.jgdz != null) return false;
        if (jglx != null ? !jglx.equals(tJgdmWw.jglx) : tJgdmWw.jglx != null) return false;
        if (jgmc != null ? !jgmc.equals(tJgdmWw.jgmc) : tJgdmWw.jgmc != null) return false;
        if (jjhy != null ? !jjhy.equals(tJgdmWw.jjhy) : tJgdmWw.jjhy != null) return false;
        if (jjlx != null ? !jjlx.equals(tJgdmWw.jjlx) : tJgdmWw.jjlx != null) return false;
        if (jydh != null ? !jydh.equals(tJgdmWw.jydh) : tJgdmWw.jydh != null) return false;
        if (jydz != null ? !jydz.equals(tJgdmWw.jydz) : tJgdmWw.jydz != null) return false;
        if (jyfw != null ? !jyfw.equals(tJgdmWw.jyfw) : tJgdmWw.jyfw != null) return false;
        if (jyjg != null ? !jyjg.equals(tJgdmWw.jyjg) : tJgdmWw.jyjg != null) return false;
        if (jyyb != null ? !jyyb.equals(tJgdmWw.jyyb) : tJgdmWw.jyyb != null) return false;
        if (khyh != null ? !khyh.equals(tJgdmWw.khyh) : tJgdmWw.khyh != null) return false;
        if (khzh != null ? !khzh.equals(tJgdmWw.khzh) : tJgdmWw.khzh != null) return false;
        if (lry != null ? !lry.equals(tJgdmWw.lry) : tJgdmWw.lry != null) return false;
        if (memo != null ? !memo.equals(tJgdmWw.memo) : tJgdmWw.memo != null) return false;
        if (memo2 != null ? !memo2.equals(tJgdmWw.memo2) : tJgdmWw.memo2 != null) return false;
        if (mobile != null ? !mobile.equals(tJgdmWw.mobile) : tJgdmWw.mobile != null) return false;
        if (njjhy != null ? !njjhy.equals(tJgdmWw.njjhy) : tJgdmWw.njjhy != null) return false;
        if (njjlx != null ? !njjlx.equals(tJgdmWw.njjlx) : tJgdmWw.njjlx != null) return false;
        if (njqx != null ? !njqx.equals(tJgdmWw.njqx) : tJgdmWw.njqx != null) return false;
        if (njr != null ? !njr.equals(tJgdmWw.njr) : tJgdmWw.njr != null) return false;
        if (njrq != null ? !njrq.equals(tJgdmWw.njrq) : tJgdmWw.njrq != null) return false;
        if (pwrq != null ? !pwrq.equals(tJgdmWw.pwrq) : tJgdmWw.pwrq != null) return false;
        if (pzjgdm != null ? !pzjgdm.equals(tJgdmWw.pzjgdm) : tJgdmWw.pzjgdm != null) return false;
        if (pzjgmc != null ? !pzjgmc.equals(tJgdmWw.pzjgmc) : tJgdmWw.pzjgmc != null) return false;
        if (pzwh != null ? !pzwh.equals(tJgdmWw.pzwh) : tJgdmWw.pzwh != null) return false;
        if (qzbz != null ? !qzbz.equals(tJgdmWw.qzbz) : tJgdmWw.qzbz != null) return false;
        if (qzrq != null ? !qzrq.equals(tJgdmWw.qzrq) : tJgdmWw.qzrq != null) return false;
        if (scbzrq != null ? !scbzrq.equals(tJgdmWw.scbzrq) : tJgdmWw.scbzrq != null) return false;
        if (shDate != null ? !shDate.equals(tJgdmWw.shDate) : tJgdmWw.shDate != null) return false;
        if (shSuggest != null ? !shSuggest.equals(tJgdmWw.shSuggest) : tJgdmWw.shSuggest != null) return false;
        if (status != null ? !status.equals(tJgdmWw.status) : tJgdmWw.status != null) return false;
        if (tbrlxfs != null ? !tbrlxfs.equals(tJgdmWw.tbrlxfs) : tJgdmWw.tbrlxfs != null) return false;
        if (tbrsfzh != null ? !tbrsfzh.equals(tJgdmWw.tbrsfzh) : tJgdmWw.tbrsfzh != null) return false;
        if (tbrxm != null ? !tbrxm.equals(tJgdmWw.tbrxm) : tJgdmWw.tbrxm != null) return false;
        if (type != null ? !type.equals(tJgdmWw.type) : tJgdmWw.type != null) return false;
        if (url != null ? !url.equals(tJgdmWw.url) : tJgdmWw.url != null) return false;
        if (userid != null ? !userid.equals(tJgdmWw.userid) : tJgdmWw.userid != null) return false;
        if (wftzgb != null ? !wftzgb.equals(tJgdmWw.wftzgb) : tJgdmWw.wftzgb != null) return false;
        if (wjwlsh != null ? !wjwlsh.equals(tJgdmWw.wjwlsh) : tJgdmWw.wjwlsh != null) return false;
        if (wjwtbr != null ? !wjwtbr.equals(tJgdmWw.wjwtbr) : tJgdmWw.wjwtbr != null) return false;
        if (xgr != null ? !xgr.equals(tJgdmWw.xgr) : tJgdmWw.xgr != null) return false;
        if (xzqh != null ? !xzqh.equals(tJgdmWw.xzqh) : tJgdmWw.xzqh != null) return false;
        if (yzbm != null ? !yzbm.equals(tJgdmWw.yzbm) : tJgdmWw.yzbm != null) return false;
        if (zbsl != null ? !zbsl.equals(tJgdmWw.zbsl) : tJgdmWw.zbsl != null) return false;
        if (zch != null ? !zch.equals(tJgdmWw.zch) : tJgdmWw.zch != null) return false;
        if (zcrq != null ? !zcrq.equals(tJgdmWw.zcrq) : tJgdmWw.zcrq != null) return false;
        if (zczj != null ? !zczj.equals(tJgdmWw.zczj) : tJgdmWw.zczj != null) return false;
        if (zfrq != null ? !zfrq.equals(tJgdmWw.zfrq) : tJgdmWw.zfrq != null) return false;
        if (zgdm != null ? !zgdm.equals(tJgdmWw.zgdm) : tJgdmWw.zgdm != null) return false;
        if (zgmc != null ? !zgmc.equals(tJgdmWw.zgmc) : tJgdmWw.zgmc != null) return false;
        if (zgrs != null ? !zgrs.equals(tJgdmWw.zgrs) : tJgdmWw.zgrs != null) return false;
        if (zjhm != null ? !zjhm.equals(tJgdmWw.zjhm) : tJgdmWw.zjhm != null) return false;
        if (zjlx != null ? !zjlx.equals(tJgdmWw.zjlx) : tJgdmWw.zjlx != null) return false;
        if (zslsh != null ? !zslsh.equals(tJgdmWw.zslsh) : tJgdmWw.zslsh != null) return false;
        if (zycp1 != null ? !zycp1.equals(tJgdmWw.zycp1) : tJgdmWw.zycp1 != null) return false;
        if (zycp2 != null ? !zycp2.equals(tJgdmWw.zycp2) : tJgdmWw.zycp2 != null) return false;
        if (zycp3 != null ? !zycp3.equals(tJgdmWw.zycp3) : tJgdmWw.zycp3 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
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
        result = 31 * result + (zczj != null ? zczj.hashCode() : 0);
        result = 31 * result + (hbzl != null ? hbzl.hashCode() : 0);
        result = 31 * result + (wftzgb != null ? wftzgb.hashCode() : 0);
        result = 31 * result + (zgrs != null ? zgrs.hashCode() : 0);
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
        result = 31 * result + (fksl != null ? fksl.hashCode() : 0);
        result = 31 * result + (dybz != null ? dybz.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (djblx != null ? djblx.hashCode() : 0);
        result = 31 * result + (jyjg != null ? jyjg.hashCode() : 0);
        result = 31 * result + (fz != null ? fz.hashCode() : 0);
        result = 31 * result + (njjhy != null ? njjhy.hashCode() : 0);
        result = 31 * result + (memo != null ? memo.hashCode() : 0);
        result = 31 * result + (njjlx != null ? njjlx.hashCode() : 0);
        result = 31 * result + (memo2 != null ? memo2.hashCode() : 0);
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
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (fzyj != null ? fzyj.hashCode() : 0);
        result = 31 * result + (fzreason != null ? fzreason.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (djh != null ? djh.hashCode() : 0);
        result = 31 * result + (djrq != null ? djrq.hashCode() : 0);
        result = 31 * result + (gsreason != null ? gsreason.hashCode() : 0);
        result = 31 * result + (gsyj != null ? gsyj.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (clrq != null ? clrq.hashCode() : 0);
        result = 31 * result + (shDate != null ? shDate.hashCode() : 0);
        result = 31 * result + (shSuggest != null ? shSuggest.hashCode() : 0);
        return result;
    }
}
