package com.ninemax.jpa.code.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-5-17
 * Time: ÏÂÎç2:10
 */
@javax.persistence.Table(name = "t_njglx")
@Entity
public class TNJglx {
    private String dm;

    @javax.persistence.Column(name = "dm", nullable = false, insertable = true, updatable = true, length = 1, precision = 0)
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TNJglx tJglx = (TNJglx) o;

        if (dm != null ? !dm.equals(tJglx.dm) : tJglx.dm != null) return false;
        if (mc != null ? !mc.equals(tJglx.mc) : tJglx.mc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dm != null ? dm.hashCode() : 0;
        result = 31 * result + (mc != null ? mc.hashCode() : 0);
        return result;
    }
}
