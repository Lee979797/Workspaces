package com.ninemax.jpa.code.model;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-5-18
 * Time: ÏÂÎç2:03
 */
@Table(name = "sc_gj")
@Entity
public class TGj {
    private String mc;

    @Column(name = "mc", nullable = false, insertable = true, updatable = true, length = 24, precision = 0)
    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }

    private String zfdm;

    @Column(name = "zfdm", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public String getZfdm() {
        return zfdm;
    }

    public void setZfdm(String zfdm) {
        this.zfdm = zfdm;
    }

    private String dm;

    @Column(name = "dm", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Id
    public String getDm() {
        return dm;
    }

    public void setDm(String dm) {
        this.dm = dm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TGj tGj = (TGj) o;

        if (dm != null ? !dm.equals(tGj.dm) : tGj.dm != null) return false;
        if (mc != null ? !mc.equals(tGj.mc) : tGj.mc != null) return false;
        if (zfdm != null ? !zfdm.equals(tGj.zfdm) : tGj.zfdm != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mc != null ? mc.hashCode() : 0;
        result = 31 * result + (zfdm != null ? zfdm.hashCode() : 0);
        result = 31 * result + (dm != null ? dm.hashCode() : 0);
        return result;
    }
}
