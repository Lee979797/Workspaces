package com.ninemax.jpa.code.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-6-26
 * Time: ÏÂÎç2:55
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.IdClass(TkGskPK.class)
@javax.persistence.Table(name = "tk_gsk")
@Entity
public class TkGsk {
    private Long kxlh;

    @javax.persistence.Column(name = "kxlh")
    @Id
    public Long getKxlh() {
        return kxlh;
    }

    public void setKxlh(Long kxlh) {
        this.kxlh = kxlh;
    }

    private String jgdm;

    @javax.persistence.Column(name = "jgdm")
    @Basic
    public String getJgdm() {
        return jgdm;
    }

    public void setJgdm(String jgdm) {
        this.jgdm = jgdm;
    }

    private Date gssj;

    @javax.persistence.Column(name = "gssj")
    @Id
    public Date getGssj() {
        return gssj;
    }

    public void setGssj(Date gssj) {
        this.gssj = gssj;
    }

    private String gsyy;

    @javax.persistence.Column(name = "gsyy")
    @Basic
    public String getGsyy() {
        return gsyy;
    }

    public void setGsyy(String gsyy) {
        this.gsyy = gsyy;
    }

    private String czy;

    @javax.persistence.Column(name = "czy")
    @Basic
    public String getCzy() {
        return czy;
    }

    public void setCzy(String czy) {
        this.czy = czy;
    }

    private String xzqh;

    @javax.persistence.Column(name = "xzqh")
    @Basic
    public String getXzqh() {
        return xzqh;
    }

    public void setXzqh(String xzqh) {
        this.xzqh = xzqh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TkGsk tkGsk = (TkGsk) o;

        if (czy != null ? !czy.equals(tkGsk.czy) : tkGsk.czy != null) return false;
        if (gssj != null ? !gssj.equals(tkGsk.gssj) : tkGsk.gssj != null) return false;
        if (gsyy != null ? !gsyy.equals(tkGsk.gsyy) : tkGsk.gsyy != null) return false;
        if (jgdm != null ? !jgdm.equals(tkGsk.jgdm) : tkGsk.jgdm != null) return false;
        if (kxlh != null ? !kxlh.equals(tkGsk.kxlh) : tkGsk.kxlh != null) return false;
        if (xzqh != null ? !xzqh.equals(tkGsk.xzqh) : tkGsk.xzqh != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = kxlh != null ? kxlh.hashCode() : 0;
        result = 31 * result + (jgdm != null ? jgdm.hashCode() : 0);
        result = 31 * result + (gssj != null ? gssj.hashCode() : 0);
        result = 31 * result + (gsyy != null ? gsyy.hashCode() : 0);
        result = 31 * result + (czy != null ? czy.hashCode() : 0);
        result = 31 * result + (xzqh != null ? xzqh.hashCode() : 0);
        return result;
    }
}
