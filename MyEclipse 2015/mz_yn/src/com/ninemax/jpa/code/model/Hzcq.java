package com.ninemax.jpa.code.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: zhhui
 * Date: 13-10-31
 * Time: ÏÂÎç4:59
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "t_hzcq")
@Entity
public class Hzcq {
    private String jgdm;
    private String jgmc;
    private String bzjgdm;
    private String fddbr;
    private String zjhm;
    private Date zfrq;

    @javax.persistence.Column(name = "jgdm")
    @Id
    public String getJgdm() {
        return jgdm;
    }

    public void setJgdm(String jgdm) {
        this.jgdm = jgdm;
    }

    @javax.persistence.Column(name = "jgmc")
    @Basic
    public String getJgmc() {
        return jgmc;
    }

    public void setJgmc(String jgmc) {
        this.jgmc = jgmc;
    }
    @javax.persistence.Column(name = "bzjgdm")
    @Basic
    public String getBzjgdm() {
        return bzjgdm;
    }

    public void setBzjgdm(String bzjgdm) {
        this.bzjgdm = bzjgdm;
    }

    @javax.persistence.Column(name = "fddbr")
    @Basic
    public String getFddbr() {
        return fddbr;
    }

    public void setFddbr(String fddbr) {
        this.fddbr = fddbr;
    }

    @javax.persistence.Column(name = "zjhm")
    @Basic
    public String getZjhm() {
        return zjhm;
    }

    public void setZjhm(String zjhm) {
        this.zjhm = zjhm;
    }
    @javax.persistence.Column(name = "zfrq")
    @Basic
    public Date getZfrq() {
        return zfrq;
    }

    public void setZfrq(Date zfrq) {
        this.zfrq = zfrq;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hzcq hzcq = (Hzcq) o;

        if (fddbr != null ? !fddbr.equals(hzcq.fddbr) : hzcq.fddbr != null) return false;
        if (jgdm != null ? !jgdm.equals(hzcq.jgdm) : hzcq.jgdm != null) return false;
        if (jgmc != null ? !jgmc.equals(hzcq.jgmc) : hzcq.jgmc != null) return false;
        if (zfrq != null ? !zfrq.equals(hzcq.zfrq) : hzcq.zfrq != null) return false;
        if (zjhm != null ? !zjhm.equals(hzcq.zjhm) : hzcq.zjhm != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = jgdm != null ? jgdm.hashCode() : 0;
        result = 31 * result + (jgmc != null ? jgmc.hashCode() : 0);
        result = 31 * result + (fddbr != null ? fddbr.hashCode() : 0);
        result = 31 * result + (zjhm != null ? zjhm.hashCode() : 0);
        result = 31 * result + (zfrq != null ? zfrq.hashCode() : 0);
        return result;
    }
}
