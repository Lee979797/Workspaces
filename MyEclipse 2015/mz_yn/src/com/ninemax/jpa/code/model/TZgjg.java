package com.ninemax.jpa.code.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-5-20
 * Time: ÉÏÎç11:04
 */
@javax.persistence.Table(name = "t_zgjg")
@Entity
public class TZgjg {
    private String jgdm;

    @javax.persistence.Column(name = "jgdm", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Id
    public String getDm() {
        return jgdm;
    }

    public void setDm(String jgdm) {
        this.jgdm = jgdm;
    }

    private String zgjgmc;

    @javax.persistence.Column(name = "zgjgmc", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public String getMc() {
        return zgjgmc;
    }

    public void setMc(String zgjgmc) {
        this.zgjgmc = zgjgmc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TZgjg tZgjg = (TZgjg) o;

        if (jgdm != null ? !jgdm.equals(tZgjg.jgdm) : tZgjg.jgdm != null) return false;
        if (zgjgmc != null ? !zgjgmc.equals(tZgjg.zgjgmc) : tZgjg.zgjgmc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = jgdm != null ? jgdm.hashCode() : 0;
        result = 31 * result + (zgjgmc != null ? zgjgmc.hashCode() : 0);
        return result;
    }
}
