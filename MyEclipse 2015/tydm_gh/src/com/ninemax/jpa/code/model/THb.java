package com.ninemax.jpa.code.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-5-17
 * Time: ����2:10
 */
@javax.persistence.Table(name = "sc_hbzl")
@Entity
public class THb {
    private String dm;


    @javax.persistence.Column(name = "dm", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Id
    public String getDm() {
        return dm;
    }

    public void setDm(String dm) {
        this.dm = dm;
    }

    private String mc;

    @javax.persistence.Column(name = "mc", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
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

        THb tHb = (THb) o;

        if (dm != null ? !dm.equals(tHb.dm) : tHb.dm != null) return false;
        if (mc != null ? !mc.equals(tHb.mc) : tHb.mc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dm != null ? dm.hashCode() : 0;
        result = 31 * result + (mc != null ? mc.hashCode() : 0);
        return result;
    }
}
