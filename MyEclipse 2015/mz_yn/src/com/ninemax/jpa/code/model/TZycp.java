package com.ninemax.jpa.code.model;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-5-18
 * Time: ÏÂÎç2:03
 */
@Table(name = "t_zycp")
@Entity
public class TZycp {
    private String dm;

    @Column(name = "dm", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Id
    public String getDm() {
        return dm;
    }

    public void setDm(String dm) {
        this.dm = dm;
    }

    private String mc;

    @Column(name = "mc", nullable = false, insertable = true, updatable = true, length = 254, precision = 0)
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

        TZycp tZycp = (TZycp) o;

        if (dm != null ? !dm.equals(tZycp.dm) : tZycp.dm != null) return false;
        if (mc != null ? !mc.equals(tZycp.mc) : tZycp.mc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dm != null ? dm.hashCode() : 0;
        result = 31 * result + (mc != null ? mc.hashCode() : 0);
        return result;
    }
}
