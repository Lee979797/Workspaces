package com.ninemax.jpa.code.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-6-28
 * Time: ÏÂÎç1:11
 */
@javax.persistence.Table(name = "sc_xzqh1")
@Entity
public class TXzqh1 {
    private String dm;

    @javax.persistence.Column(name = "dm", nullable = false, insertable = true, updatable = true, length = 6, precision = 0)
    @Id
    public String getDm() {
        return dm;
    }

    public void setDm(String dm) {
        this.dm = dm;
    }

    private String mc;

    @javax.persistence.Column(name = "mc", nullable = false, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }

    private String flag;

    @javax.persistence.Column(name = "flag", nullable = true, insertable = true, updatable = true, length = 1, precision = 0)
    @Basic
    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    private String superdm;

    @javax.persistence.Column(name = "superdm", nullable = true, insertable = true, updatable = true, length = 6, precision = 0)
    @Basic
    public String getSuperdm() {
        return superdm;
    }

    public void setSuperdm(String superdm) {
        this.superdm = superdm;
    }

    private String jgmc;

    @javax.persistence.Column(name = "jgmc", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String getJgmc() {
        return jgmc;
    }

    public void setJgmc(String jgmc) {
        this.jgmc = jgmc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TXzqh1 tXzqh1 = (TXzqh1) o;

        if (dm != null ? !dm.equals(tXzqh1.dm) : tXzqh1.dm != null) return false;
        if (flag != null ? !flag.equals(tXzqh1.flag) : tXzqh1.flag != null) return false;
        if (jgmc != null ? !jgmc.equals(tXzqh1.jgmc) : tXzqh1.jgmc != null) return false;
        if (mc != null ? !mc.equals(tXzqh1.mc) : tXzqh1.mc != null) return false;
        if (superdm != null ? !superdm.equals(tXzqh1.superdm) : tXzqh1.superdm != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dm != null ? dm.hashCode() : 0;
        result = 31 * result + (mc != null ? mc.hashCode() : 0);
        result = 31 * result + (flag != null ? flag.hashCode() : 0);
        result = 31 * result + (superdm != null ? superdm.hashCode() : 0);
        result = 31 * result + (jgmc != null ? jgmc.hashCode() : 0);
        return result;
    }
}
