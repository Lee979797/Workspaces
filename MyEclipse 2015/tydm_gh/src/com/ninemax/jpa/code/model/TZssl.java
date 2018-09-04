package com.ninemax.jpa.code.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-11
 * Time: ÉÏÎç10:59
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.IdClass(com.ninemax.jpa.code.model.TZsslPK.class)
@javax.persistence.Table(name = "t_zssl")
@Entity
public class TZssl {
    private String xzqh;

    @javax.persistence.Column(name = "xzqh")
    @Id
    public String getXzqh() {
        return xzqh;
    }

    public void setXzqh(String xzqh) {
        this.xzqh = xzqh;
    }

    private String type;

    @javax.persistence.Column(name = "type")
    @Id
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private Integer kcsl;

    @javax.persistence.Column(name = "kcsl")
    @Basic
    public Integer getKcsl() {
        return kcsl;
    }

    public void setKcsl(Integer kcsl) {
        this.kcsl = kcsl;
    }

    private Integer kcsx;

    @javax.persistence.Column(name = "kcsx")
    @Basic
    public Integer getKcsx() {
        if (kcsl == null)
            return 0;
        return kcsx;
    }

    public void setKcsx(Integer kcsx) {
        this.kcsx = kcsx;
    }

    private Integer kcxx;

    @javax.persistence.Column(name = "kcxx")
    @Basic
    public Integer getKcxx() {
        return kcxx;
    }

    public void setKcxx(Integer kcxx) {
        this.kcxx = kcxx;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TZssl tZssl = (TZssl) o;

        if (kcsl != null ? !kcsl.equals(tZssl.kcsl) : tZssl.kcsl != null) return false;
        if (kcsx != null ? !kcsx.equals(tZssl.kcsx) : tZssl.kcsx != null) return false;
        if (kcxx != null ? !kcxx.equals(tZssl.kcxx) : tZssl.kcxx != null) return false;
        if (type != null ? !type.equals(tZssl.type) : tZssl.type != null) return false;
        if (xzqh != null ? !xzqh.equals(tZssl.xzqh) : tZssl.xzqh != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = xzqh != null ? xzqh.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (kcsl != null ? kcsl.hashCode() : 0);
        result = 31 * result + (kcsx != null ? kcsx.hashCode() : 0);
        result = 31 * result + (kcxx != null ? kcxx.hashCode() : 0);
        return result;
    }
}
