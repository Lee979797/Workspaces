package com.ninemax.jpa.code.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * User: yzhhui
 * Date: 13-4-11
 * Time: ÏÂÎç3:49
 */
public class PreScanPK implements Serializable {
    private String xzqh;
    private Integer type;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PreScanPK preScan = (PreScanPK) o;

        if (type != null ? !type.equals(preScan.type) : preScan.type != null) return false;
        if (xzqh != null ? !xzqh.equals(preScan.xzqh) : preScan.xzqh != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = xzqh != null ? xzqh.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
