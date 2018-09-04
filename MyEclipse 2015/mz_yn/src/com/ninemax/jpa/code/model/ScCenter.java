package com.ninemax.jpa.code.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-6-18
 * Time: ÉÏÎç10:25
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "sc_center")
@Entity
public class ScCenter {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScCenter scCenter = (ScCenter) o;

        if (dm != null ? !dm.equals(scCenter.dm) : scCenter.dm != null) return false;
        if (mc != null ? !mc.equals(scCenter.mc) : scCenter.mc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dm != null ? dm.hashCode() : 0;
        result = 31 * result + (mc != null ? mc.hashCode() : 0);
        return result;
    }
}
