package com.ninemax.jpa.code.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-8-15
 * Time: ÏÂÎç6:49
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "T_PROJGDM_GJ")
@Entity
public class TProjgdmGj {
    private String jgdm;

    @javax.persistence.Column(name = "JGDM")
    @Id
    public String getJgdm() {
        return jgdm;
    }

    public void setJgdm(String jgdm) {
        this.jgdm = jgdm;
    }

    private String jgmc;

    @javax.persistence.Column(name = "JGMC")
    @Basic
    public String getJgmc() {
        return jgmc;
    }

    public void setJgmc(String jgmc) {
        this.jgmc = jgmc;
    }

    private String bzjgdm;

    @javax.persistence.Column(name = "BZJGDM")
    @Basic
    public String getBzjgdm() {
        return bzjgdm;
    }

    public void setBzjgdm(String bzjgdm) {
        this.bzjgdm = bzjgdm;
    }

    private String zdqzbz;

    @javax.persistence.Column(name = "ZDQZBZ")
    @Basic
    public String getZdqzbz() {
        return zdqzbz;
    }

    public void setZdqzbz(String zdqzbz) {
        this.zdqzbz = zdqzbz;
    }

    private String dawtbz;

    @javax.persistence.Column(name = "DAWTBZ")
    @Basic
    public String getDawtbz() {
        return dawtbz;
    }

    public void setDawtbz(String dawtbz) {
        this.dawtbz = dawtbz;
    }

    private String sjwtbz;

    @javax.persistence.Column(name = "SJWTBZ")
    @Basic
    public String getSjwtbz() {
        return sjwtbz;
    }

    public void setSjwtbz(String sjwtbz) {
        this.sjwtbz = sjwtbz;
    }

    private String zdqzbz1;

    @javax.persistence.Column(name = "ZDQZBZ1")
    @Basic
    public String getZdqzbz1() {
        return zdqzbz1;
    }

    public void setZdqzbz1(String zdqzbz1) {
        this.zdqzbz1 = zdqzbz1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TProjgdmGj that = (TProjgdmGj) o;

        if (bzjgdm != null ? !bzjgdm.equals(that.bzjgdm) : that.bzjgdm != null) return false;
        if (dawtbz != null ? !dawtbz.equals(that.dawtbz) : that.dawtbz != null) return false;
        if (jgdm != null ? !jgdm.equals(that.jgdm) : that.jgdm != null) return false;
        if (jgmc != null ? !jgmc.equals(that.jgmc) : that.jgmc != null) return false;
        if (sjwtbz != null ? !sjwtbz.equals(that.sjwtbz) : that.sjwtbz != null) return false;
        if (zdqzbz != null ? !zdqzbz.equals(that.zdqzbz) : that.zdqzbz != null) return false;
        if (zdqzbz1 != null ? !zdqzbz1.equals(that.zdqzbz1) : that.zdqzbz1 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = jgdm != null ? jgdm.hashCode() : 0;
        result = 31 * result + (jgmc != null ? jgmc.hashCode() : 0);
        result = 31 * result + (bzjgdm != null ? bzjgdm.hashCode() : 0);
        result = 31 * result + (zdqzbz != null ? zdqzbz.hashCode() : 0);
        result = 31 * result + (dawtbz != null ? dawtbz.hashCode() : 0);
        result = 31 * result + (sjwtbz != null ? sjwtbz.hashCode() : 0);
        result = 31 * result + (zdqzbz1 != null ? zdqzbz1.hashCode() : 0);
        return result;
    }
}
