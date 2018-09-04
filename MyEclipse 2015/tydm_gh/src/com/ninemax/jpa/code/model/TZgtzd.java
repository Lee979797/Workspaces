package com.ninemax.jpa.code.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-19
 * Time: ÏÂÎç5:10
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.IdClass(com.ninemax.jpa.code.model.TZgtzdPK.class)
@javax.persistence.Table(name = "t_zgtzd")
@Entity
public class TZgtzd {
    private String zglsh;

    @javax.persistence.Column(name = "zglsh")
    @Id
    public String getZglsh() {
        return zglsh;
    }

    public void setZglsh(String zglsh) {
        this.zglsh = zglsh;
    }

    private String lshjc;

    @javax.persistence.Column(name = "lshjc")
    @Basic
    public String getLshjc() {
        return lshjc;
    }

    public void setLshjc(String lshjc) {
        this.lshjc = lshjc;
    }

    private String bzjgdm;

    @javax.persistence.Column(name = "bzjgdm")
    @Id
    public String getBzjgdm() {
        return bzjgdm;
    }

    public void setBzjgdm(String bzjgdm) {
        this.bzjgdm = bzjgdm;
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

    private String fddbr;

    @javax.persistence.Column(name = "fddbr")
    @Basic
    public String getFddbr() {
        return fddbr;
    }

    public void setFddbr(String fddbr) {
        this.fddbr = fddbr;
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

    private String zch;

    @javax.persistence.Column(name = "zch")
    @Basic
    public String getZch() {
        return zch;
    }

    public void setZch(String zch) {
        this.zch = zch;
    }

    private Date scrq;

    @javax.persistence.Column(name = "scrq")
    @Basic
    public Date getScrq() {
        return scrq;
    }

    public void setScrq(Date scrq) {
        this.scrq = scrq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TZgtzd tZgtzd = (TZgtzd) o;

        if (bzjgdm != null ? !bzjgdm.equals(tZgtzd.bzjgdm) : tZgtzd.bzjgdm != null) return false;
        if (fddbr != null ? !fddbr.equals(tZgtzd.fddbr) : tZgtzd.fddbr != null) return false;
        if (jgdm != null ? !jgdm.equals(tZgtzd.jgdm) : tZgtzd.jgdm != null) return false;
        if (jgmc != null ? !jgmc.equals(tZgtzd.jgmc) : tZgtzd.jgmc != null) return false;
        if (lshjc != null ? !lshjc.equals(tZgtzd.lshjc) : tZgtzd.lshjc != null) return false;
        if (scrq != null ? !scrq.equals(tZgtzd.scrq) : tZgtzd.scrq != null) return false;
        if (zch != null ? !zch.equals(tZgtzd.zch) : tZgtzd.zch != null) return false;
        if (zglsh != null ? !zglsh.equals(tZgtzd.zglsh) : tZgtzd.zglsh != null) return false;
        if (zjhm != null ? !zjhm.equals(tZgtzd.zjhm) : tZgtzd.zjhm != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = zglsh != null ? zglsh.hashCode() : 0;
        result = 31 * result + (lshjc != null ? lshjc.hashCode() : 0);
        result = 31 * result + (bzjgdm != null ? bzjgdm.hashCode() : 0);
        result = 31 * result + (jgdm != null ? jgdm.hashCode() : 0);
        result = 31 * result + (jgmc != null ? jgmc.hashCode() : 0);
        result = 31 * result + (fddbr != null ? fddbr.hashCode() : 0);
        result = 31 * result + (zjhm != null ? zjhm.hashCode() : 0);
        result = 31 * result + (zch != null ? zch.hashCode() : 0);
        result = 31 * result + (scrq != null ? scrq.hashCode() : 0);
        return result;
    }
}
