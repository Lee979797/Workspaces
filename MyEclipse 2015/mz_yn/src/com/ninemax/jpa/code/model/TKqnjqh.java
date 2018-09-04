package com.ninemax.jpa.code.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * User: zhhuiyan
 * Date: 12-6-12
 * Time: ÏÂÎç1:23
 */
@javax.persistence.Table(name = "t_kqnjqh")
@Entity
public class TKqnjqh {
    private String xzqh;

    @javax.persistence.Column(name = "xzqh")
    @Id
    public String getXzqh() {
        return xzqh;
    }

    public void setXzqh(String xzqh) {
        this.xzqh = xzqh;
    }

    private String sfkq;

    @javax.persistence.Column(name = "sfkq")
    @Basic
    public String getSfkq() {
        return sfkq;
    }

    public void setSfkq(String sfkq) {
        this.sfkq = sfkq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TKqnjqh tKqnjqh = (TKqnjqh) o;

        if (sfkq != null ? !sfkq.equals(tKqnjqh.sfkq) : tKqnjqh.sfkq != null) return false;
        if (xzqh != null ? !xzqh.equals(tKqnjqh.xzqh) : tKqnjqh.xzqh != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = xzqh != null ? xzqh.hashCode() : 0;
        result = 31 * result + (sfkq != null ? sfkq.hashCode() : 0);
        return result;
    }
}
