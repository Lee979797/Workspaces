package com.ninemax.jpa.code.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-6-21
 * Time: ÏÂÎç1:43
 */
@javax.persistence.IdClass(com.ninemax.jpa.code.model.TZsdsPK.class)
@javax.persistence.Table(name = "t_zsds")
@Entity
public class TZsds {
    private String jgdm;

    @javax.persistence.Column(name = "jgdm", nullable = false, insertable = true, updatable = true, length = 9, precision = 0)
    @Id
    public String getJgdm() {
        return jgdm;
    }

    public void setJgdm(String jgdm) {
        this.jgdm = jgdm;
    }

    private String jgmc;

    @javax.persistence.Column(name = "jgmc", nullable = false, insertable = true, updatable = true, length = 120, precision = 0)
    @Basic
    public String getJgmc() {
        return jgmc;
    }

    public void setJgmc(String jgmc) {
        this.jgmc = jgmc;
    }

    private String djh;

    @javax.persistence.Column(name = "djh", nullable = false, insertable = true, updatable = true, length = 25, precision = 0)
    @Id
    public String getDjh() {
        return djh;
    }

    public void setDjh(String djh) {
        this.djh = djh;
    }

    private Timestamp djrq;

    @javax.persistence.Column(name = "djrq", nullable = true, insertable = true, updatable = true, length = 23, precision = 3)
    @Basic
    public Timestamp getDjrq() {
        return djrq;
    }

    public void setDjrq(Timestamp djrq) {
        this.djrq = djrq;
    }

    private String st;

    @javax.persistence.Column(name = "st", nullable = true, insertable = true, updatable = true, length = 1, precision = 0)
    @Basic
    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
    }

    private String czy;

    @javax.persistence.Column(name = "czy", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public String getCzy() {
        return czy;
    }

    public void setCzy(String czy) {
        this.czy = czy;
    }

    private Timestamp bgrq;

    @javax.persistence.Column(name = "bgrq", nullable = true, insertable = true, updatable = true, length = 23, precision = 3)
    @Basic
    public Timestamp getBgrq() {
        return bgrq;
    }

    public void setBgrq(Timestamp bgrq) {
        this.bgrq = bgrq;
    }

    private String gsreason;

    @javax.persistence.Column(name = "gsreason", nullable = true, insertable = true, updatable = true, length = 200, precision = 0)
    @Basic
    public String getGsreason() {
        return gsreason;
    }

    public void setGsreason(String gsreason) {
        this.gsreason = gsreason;
    }

    private String gsyj;

    @javax.persistence.Column(name = "gsyj", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String getGsyj() {
        return gsyj;
    }

    public void setGsyj(String gsyj) {
        this.gsyj = gsyj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TZsds tZsds = (TZsds) o;

        if (bgrq != null ? !bgrq.equals(tZsds.bgrq) : tZsds.bgrq != null) return false;
        if (czy != null ? !czy.equals(tZsds.czy) : tZsds.czy != null) return false;
        if (djh != null ? !djh.equals(tZsds.djh) : tZsds.djh != null) return false;
        if (djrq != null ? !djrq.equals(tZsds.djrq) : tZsds.djrq != null) return false;
        if (gsreason != null ? !gsreason.equals(tZsds.gsreason) : tZsds.gsreason != null) return false;
        if (gsyj != null ? !gsyj.equals(tZsds.gsyj) : tZsds.gsyj != null) return false;
        if (jgdm != null ? !jgdm.equals(tZsds.jgdm) : tZsds.jgdm != null) return false;
        if (jgmc != null ? !jgmc.equals(tZsds.jgmc) : tZsds.jgmc != null) return false;
        if (st != null ? !st.equals(tZsds.st) : tZsds.st != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = jgdm != null ? jgdm.hashCode() : 0;
        result = 31 * result + (jgmc != null ? jgmc.hashCode() : 0);
        result = 31 * result + (djh != null ? djh.hashCode() : 0);
        result = 31 * result + (djrq != null ? djrq.hashCode() : 0);
        result = 31 * result + (st != null ? st.hashCode() : 0);
        result = 31 * result + (czy != null ? czy.hashCode() : 0);
        result = 31 * result + (bgrq != null ? bgrq.hashCode() : 0);
        result = 31 * result + (gsreason != null ? gsreason.hashCode() : 0);
        result = 31 * result + (gsyj != null ? gsyj.hashCode() : 0);
        return result;
    }
}
