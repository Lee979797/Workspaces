package com.ninemax.jpa.code.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-20
 * Time: ÏÂÎç2:01
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "t_bajlb")
@Entity
public class TBajlb {
    private Integer id;

    @javax.persistence.Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    private Date barq;

    @javax.persistence.Column(name = "barq")
    @Basic
    public Date getBarq() {
        return barq;
    }

    public void setBarq(Date barq) {
        this.barq = barq;
    }

    private Date lrsj;

    @javax.persistence.Column(name = "lrsj")
    @Basic
    public Date getLrsj() {
        return lrsj;
    }

    public void setLrsj(Date lrsj) {
        this.lrsj = lrsj;
    }

    private String lrr;

    @javax.persistence.Column(name = "lrr")
    @Basic
    public String getLrr() {
        return lrr;
    }

    public void setLrr(String lrr) {
        this.lrr = lrr;
    }

    private Boolean cfbz;

    @javax.persistence.Column(name = "cfbz")
    @Basic
    public Boolean getCfbz() {
        return cfbz;
    }

    public void setCfbz(Boolean cfbz) {
        this.cfbz = cfbz;
    }

    private Date yxrq;

    @javax.persistence.Column(name = "yxrq")
    @Basic
    public Date getYxrq() {
        return yxrq;
    }

    public void setYxrq(Date yxrq) {
        this.yxrq = yxrq;
    }

    private String bayy;

    @javax.persistence.Column(name = "bayy")
    @Basic
    public String getBayy() {
        return bayy;
    }

    public void setBayy(String bayy) {
        this.bayy = bayy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TBajlb tBajlb = (TBajlb) o;

        if (barq != null ? !barq.equals(tBajlb.barq) : tBajlb.barq != null) return false;
        if (bayy != null ? !bayy.equals(tBajlb.bayy) : tBajlb.bayy != null) return false;
        if (bzjgdm != null ? !bzjgdm.equals(tBajlb.bzjgdm) : tBajlb.bzjgdm != null) return false;
        if (cfbz != null ? !cfbz.equals(tBajlb.cfbz) : tBajlb.cfbz != null) return false;
        if (id != null ? !id.equals(tBajlb.id) : tBajlb.id != null) return false;
        if (jgdm != null ? !jgdm.equals(tBajlb.jgdm) : tBajlb.jgdm != null) return false;
        if (jgmc != null ? !jgmc.equals(tBajlb.jgmc) : tBajlb.jgmc != null) return false;
        if (lrr != null ? !lrr.equals(tBajlb.lrr) : tBajlb.lrr != null) return false;
        if (lrsj != null ? !lrsj.equals(tBajlb.lrsj) : tBajlb.lrsj != null) return false;
        if (yxrq != null ? !yxrq.equals(tBajlb.yxrq) : tBajlb.yxrq != null) return false;
        if (zfrq != null ? !zfrq.equals(tBajlb.zfrq) : tBajlb.zfrq != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (jgdm != null ? jgdm.hashCode() : 0);
        result = 31 * result + (jgmc != null ? jgmc.hashCode() : 0);
        result = 31 * result + (zfrq != null ? zfrq.hashCode() : 0);
        result = 31 * result + (bzjgdm != null ? bzjgdm.hashCode() : 0);
        result = 31 * result + (barq != null ? barq.hashCode() : 0);
        result = 31 * result + (lrsj != null ? lrsj.hashCode() : 0);
        result = 31 * result + (lrr != null ? lrr.hashCode() : 0);
        result = 31 * result + (cfbz != null ? cfbz.hashCode() : 0);
        result = 31 * result + (yxrq != null ? yxrq.hashCode() : 0);
        result = 31 * result + (bayy != null ? bayy.hashCode() : 0);
        return result;
    }
}
