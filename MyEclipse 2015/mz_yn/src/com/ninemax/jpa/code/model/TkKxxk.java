package com.ninemax.jpa.code.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-6-11
 * Time: ÏÂÎç2:38
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "tk_kxxk")
@Entity
public class TkKxxk {
    private Integer lsh;

    @javax.persistence.Column(name = "lsh")
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer getLsh() {
        return lsh;
    }

    public void setLsh(Integer lsh) {
        this.lsh = lsh;
    }

    private Long kxlh;

    @javax.persistence.Column(name = "kxlh")
    @Basic
    public Long getKxlh() {
        return kxlh;
    }

    public void setKxlh(Long kxlh) {
        this.kxlh = kxlh;
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

    private String xzqh;

    @javax.persistence.Column(name = "xzqh")
    @Basic
    public String getXzqh() {
        return xzqh;
    }

    public void setXzqh(String xzqh) {
        this.xzqh = xzqh;
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

    private String bkbz;

    @javax.persistence.Column(name = "bkbz")
    @Basic
    public String getBkbz() {
        return bkbz;
    }

    public void setBkbz(String bkbz) {
        this.bkbz = bkbz;
    }

    private String gsbz;

    @javax.persistence.Column(name = "gsbz")
    @Basic
    public String getGsbz() {
        return gsbz;
    }

    public void setGsbz(String gsbz) {
        this.gsbz = gsbz;
    }

    private String xgbz;

    @javax.persistence.Column(name = "xgbz")
    @Basic
    public String getXgbz() {
        return xgbz;
    }

    public void setXgbz(String xgbz) {
        this.xgbz = xgbz;
    }

    private String sbbz;

    @javax.persistence.Column(name = "sbbz")
    @Basic
    public String getSbbz() {
        return sbbz;
    }

    public void setSbbz(String sbbz) {
        this.sbbz = sbbz;
    }

    private Date sbdata;

    @javax.persistence.Column(name = "sbdata")
    @Basic
    public Date getSbdata() {
        return sbdata;
    }

    public void setSbdata(Date sbdata) {
        this.sbdata = sbdata;
    }

    private String sbr;

    @javax.persistence.Column(name = "sbr")
    @Basic
    public String getSbr() {
        return sbr;
    }

    public void setSbr(String sbr) {
        this.sbr = sbr;
    }

    private String sbxzqh;

    @javax.persistence.Column(name = "sbxzqh")
    @Basic
    public String getSbxzqh() {
        return sbxzqh;
    }

    public void setSbxzqh(String sbxzqh) {
        this.sbxzqh = sbxzqh;
    }

    private Date czsj;

    @javax.persistence.Column(name = "czsj")
    @Basic
    public Date getCzsj() {
        return czsj;
    }

    public void setCzsj(Date czsj) {
        this.czsj = czsj;
    }

    private String czy;

    @javax.persistence.Column(name = "czy")
    @Basic
    public String getCzy() {
        return czy;
    }

    public void setCzy(String czy) {
        this.czy = czy;
    }

    private Date sqsj;

    @javax.persistence.Column(name = "sqsj")
    @Basic
    public Date getSqsj() {
        return sqsj;
    }

    public void setSqsj(Date sqsj) {
        this.sqsj = sqsj;
    }

    private String flag;

    @javax.persistence.Column(name = "flag")
    @Basic
    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    private String haveDown;

    @javax.persistence.Column(name = "have_down")
    @Basic
    public String getHaveDown() {
        return haveDown;
    }

    public void setHaveDown(String haveDown) {
        this.haveDown = haveDown;
    }

    private Date writecarddate;

    @javax.persistence.Column(name = "writecarddate")
    @Basic
    public Date getWritecarddate() {
        return writecarddate;
    }

    public void setWritecarddate(Date writecarddate) {
        this.writecarddate = writecarddate;
    }

    private boolean lkflag;

    @javax.persistence.Column(name = "lkflag")
    @Basic
    public boolean isLkflag() {
        return lkflag;
    }

    public void setLkflag(boolean lkflag) {
        this.lkflag = lkflag;
    }

    private String lkr;

    @javax.persistence.Column(name = "lkr")
    @Basic
    public String getLkr() {
        return lkr;
    }

    public void setLkr(String lkr) {
        this.lkr = lkr;
    }

    private Date lksj;

    @javax.persistence.Column(name = "lksj")
    @Basic
    public Date getLksj() {
        return lksj;
    }

    public void setLksj(Date lksj) {
        this.lksj = lksj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TkKxxk tkKxxk = (TkKxxk) o;

        if (kxlh != tkKxxk.kxlh) return false;
        if (lkflag != tkKxxk.lkflag) return false;
        if (lsh != tkKxxk.lsh) return false;
        if (bkbz != null ? !bkbz.equals(tkKxxk.bkbz) : tkKxxk.bkbz != null) return false;
        if (czsj != null ? !czsj.equals(tkKxxk.czsj) : tkKxxk.czsj != null) return false;
        if (czy != null ? !czy.equals(tkKxxk.czy) : tkKxxk.czy != null) return false;
        if (fkbz != null ? !fkbz.equals(tkKxxk.fkbz) : tkKxxk.fkbz != null) return false;
        if (flag != null ? !flag.equals(tkKxxk.flag) : tkKxxk.flag != null) return false;
        if (gsbz != null ? !gsbz.equals(tkKxxk.gsbz) : tkKxxk.gsbz != null) return false;
        if (haveDown != null ? !haveDown.equals(tkKxxk.haveDown) : tkKxxk.haveDown != null) return false;
        if (jgdm != null ? !jgdm.equals(tkKxxk.jgdm) : tkKxxk.jgdm != null) return false;
        if (lkr != null ? !lkr.equals(tkKxxk.lkr) : tkKxxk.lkr != null) return false;
        if (lksj != null ? !lksj.equals(tkKxxk.lksj) : tkKxxk.lksj != null) return false;
        if (sbbz != null ? !sbbz.equals(tkKxxk.sbbz) : tkKxxk.sbbz != null) return false;
        if (sbdata != null ? !sbdata.equals(tkKxxk.sbdata) : tkKxxk.sbdata != null) return false;
        if (sbr != null ? !sbr.equals(tkKxxk.sbr) : tkKxxk.sbr != null) return false;
        if (sbxzqh != null ? !sbxzqh.equals(tkKxxk.sbxzqh) : tkKxxk.sbxzqh != null) return false;
        if (sqsj != null ? !sqsj.equals(tkKxxk.sqsj) : tkKxxk.sqsj != null) return false;
        if (writecarddate != null ? !writecarddate.equals(tkKxxk.writecarddate) : tkKxxk.writecarddate != null)
            return false;
        if (xgbz != null ? !xgbz.equals(tkKxxk.xgbz) : tkKxxk.xgbz != null) return false;
        if (xzqh != null ? !xzqh.equals(tkKxxk.xzqh) : tkKxxk.xzqh != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        Integer result = lsh;
        result = 31 * result + (jgdm != null ? jgdm.hashCode() : 0);
        result = 31 * result + (xzqh != null ? xzqh.hashCode() : 0);
        result = 31 * result + (fkbz != null ? fkbz.hashCode() : 0);
        result = 31 * result + (bkbz != null ? bkbz.hashCode() : 0);
        result = 31 * result + (gsbz != null ? gsbz.hashCode() : 0);
        result = 31 * result + (xgbz != null ? xgbz.hashCode() : 0);
        result = 31 * result + (sbbz != null ? sbbz.hashCode() : 0);
        result = 31 * result + (sbdata != null ? sbdata.hashCode() : 0);
        result = 31 * result + (sbr != null ? sbr.hashCode() : 0);
        result = 31 * result + (sbxzqh != null ? sbxzqh.hashCode() : 0);
        result = 31 * result + (czsj != null ? czsj.hashCode() : 0);
        result = 31 * result + (czy != null ? czy.hashCode() : 0);
        result = 31 * result + (sqsj != null ? sqsj.hashCode() : 0);
        result = 31 * result + (flag != null ? flag.hashCode() : 0);
        result = 31 * result + (haveDown != null ? haveDown.hashCode() : 0);
        result = 31 * result + (writecarddate != null ? writecarddate.hashCode() : 0);
        result = 31 * result + (lkflag ? 1 : 0);
        result = 31 * result + (lkr != null ? lkr.hashCode() : 0);
        result = 31 * result + (lksj != null ? lksj.hashCode() : 0);
        return result;
    }
}
