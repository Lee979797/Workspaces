package com.ninemax.jpa.code.model;

import javax.persistence.*;

/**
 * Created by ninemax-199 on 14-2-8.
 */
@Entity
@IdClass(PreScanPK.class)
@Table(name = "pre_Scan")
public class PreScan {

    private String xzqh;
    private Integer type;
    private String jglxs;

    @Id
    @Column(name = "xzqh")
    public String getXzqh() {
        return xzqh;
    }

    public void setXzqh(String xzqh) {
        this.xzqh = xzqh;
    }

    @Id
    @Column(name = "type")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Basic
    @Column(name = "jglxs")
    public String getJglxs() {
        return jglxs;
    }

    public void setJglxs(String jglxs) {
        this.jglxs = jglxs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PreScan preScan = (PreScan) o;

        if (jglxs != null ? !jglxs.equals(preScan.jglxs) : preScan.jglxs != null) return false;
        if (type != null ? !type.equals(preScan.type) : preScan.type != null) return false;
        if (xzqh != null ? !xzqh.equals(preScan.xzqh) : preScan.xzqh != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = xzqh != null ? xzqh.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (jglxs != null ? jglxs.hashCode() : 0);
        return result;
    }
}
