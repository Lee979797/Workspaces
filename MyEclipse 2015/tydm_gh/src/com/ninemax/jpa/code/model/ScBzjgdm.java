package com.ninemax.jpa.code.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-6-18
 * Time: ÉÏÎç10:44
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "SC_bzjgdm")
@Entity
public class ScBzjgdm {
    private String dm;

    @javax.persistence.Column(name = "dm")
    @Id
    public String getDm() {
        return dm;
    }

    public void setDm(String dm) {
        this.dm = dm;
    }

    private String mc;

    @javax.persistence.Column(name = "mc")
    @Basic
    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }

    private String xzqhId;

    @javax.persistence.Column(name = "xzqh_id")
    @Basic
    public String getXzqhId() {
        return xzqhId;
    }

    public void setXzqhId(String xzqhId) {
        this.xzqhId = xzqhId;
    }

    private String zrxzqhId;

    @javax.persistence.Column(name = "zrxzqh_id")
    @Basic
    public String getZrxzqhId() {
        return zrxzqhId;
    }

    public void setZrxzqhId(String zrxzqhId) {
        this.zrxzqhId = zrxzqhId;
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

    private String superdm;

    @javax.persistence.Column(name = "superdm")
    @Basic
    public String getSuperdm() {
        return superdm;
    }

    public void setSuperdm(String superdm) {
        this.superdm = superdm;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScBzjgdm scBzjgdm = (ScBzjgdm) o;

        if (dm != null ? !dm.equals(scBzjgdm.dm) : scBzjgdm.dm != null) return false;
        if (flag != null ? !flag.equals(scBzjgdm.flag) : scBzjgdm.flag != null) return false;
        if (jgmc != null ? !jgmc.equals(scBzjgdm.jgmc) : scBzjgdm.jgmc != null) return false;
        if (mc != null ? !mc.equals(scBzjgdm.mc) : scBzjgdm.mc != null) return false;
        if (superdm != null ? !superdm.equals(scBzjgdm.superdm) : scBzjgdm.superdm != null) return false;
        if (xzqhId != null ? !xzqhId.equals(scBzjgdm.xzqhId) : scBzjgdm.xzqhId != null) return false;
        if (zrxzqhId != null ? !zrxzqhId.equals(scBzjgdm.zrxzqhId) : scBzjgdm.zrxzqhId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dm != null ? dm.hashCode() : 0;
        result = 31 * result + (mc != null ? mc.hashCode() : 0);
        result = 31 * result + (xzqhId != null ? xzqhId.hashCode() : 0);
        result = 31 * result + (zrxzqhId != null ? zrxzqhId.hashCode() : 0);
        result = 31 * result + (flag != null ? flag.hashCode() : 0);
        result = 31 * result + (superdm != null ? superdm.hashCode() : 0);
        result = 31 * result + (jgmc != null ? jgmc.hashCode() : 0);
        return result;
    }
}
