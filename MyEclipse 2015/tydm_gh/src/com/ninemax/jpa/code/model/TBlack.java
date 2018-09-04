package com.ninemax.jpa.code.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-8-7
 * Time: ÉÏÎç11:16
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "t_black")
@Entity
public class TBlack {
    private Long id;

    @javax.persistence.Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    private String jgdm;

    @javax.persistence.Column(name = "jgdm")
    @Basic
    public String getJgdm() {
        return jgdm;
    }

    public void setJgdm(String jgdm) {
        this.jgdm = jgdm;
    }

    private String jglx;

    @javax.persistence.Column(name = "jglx")
    @Basic
    public String getJglx() {
        return jglx;
    }

    public void setJglx(String jglx) {
        this.jglx = jglx;
    }

    private String jgmc;

    @javax.persistence.Column(name = "jgmc")
    @Basic
    public String getJgmc() {
        return jgmc;
    }

    public void setJgmc(String jgmc) {
        this.jgmc = jgmc;
    }

    private String jgdz;

    @javax.persistence.Column(name = "jgdz")
    @Basic
    public String getJgdz() {
        return jgdz;
    }

    public void setJgdz(String jgdz) {
        this.jgdz = jgdz;
    }

    private Date bzrq;

    @javax.persistence.Column(name = "bzrq")
    @Basic
    public Date getBzrq() {
        return bzrq;
    }

    public void setBzrq(Date bzrq) {
        this.bzrq = bzrq;
    }

    private Date zfrq;

    @javax.persistence.Column(name = "zfrq")
    @Basic
    public Date getZfrq() {
        return zfrq;
    }

    public void setZfrq(Date zfrq) {
        this.zfrq = zfrq;
    }

    private String yxdate;

    @javax.persistence.Column(name = "yxdate")
    @Basic
    public String getYxdate() {
        return yxdate;
    }

    public void setYxdate(String yxdate) {
        this.yxdate = yxdate;
    }

    private String djh;

    @javax.persistence.Column(name = "djh")
    @Basic
    public String getDjh() {
        return djh;
    }

    public void setDjh(String djh) {
        this.djh = djh;
    }

    private String lsh;

    @javax.persistence.Column(name = "lsh")
    @Basic
    public String getLsh() {
        return lsh;
    }

    public void setLsh(String lsh) {
        this.lsh = lsh;
    }

    private String type;

    @javax.persistence.Column(name = "type")
    @Basic
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private Date czrq;

    @javax.persistence.Column(name = "czrq")
    @Basic
    public Date getCzrq() {
        return czrq;
    }

    public void setCzrq(Date czrq) {
        this.czrq = czrq;
    }

    private String czr;

    @javax.persistence.Column(name = "czr")
    @Basic
    public String getCzr() {
        return czr;
    }

    public void setCzr(String czr) {
        this.czr = czr;
    }

    private String zsbh;

    @javax.persistence.Column(name = "zsbh")
    @Basic
    public String getZsbh() {
        return zsbh;
    }

    public void setZsbh(String zsbh) {
        this.zsbh = zsbh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TBlack black = (TBlack) o;

        if (bzrq != null ? !bzrq.equals(black.bzrq) : black.bzrq != null) return false;
        if (czr != null ? !czr.equals(black.czr) : black.czr != null) return false;
        if (czrq != null ? !czrq.equals(black.czrq) : black.czrq != null) return false;
        if (djh != null ? !djh.equals(black.djh) : black.djh != null) return false;
        if (id != null ? !id.equals(black.id) : black.id != null) return false;
        if (jgdm != null ? !jgdm.equals(black.jgdm) : black.jgdm != null) return false;
        if (jgdz != null ? !jgdz.equals(black.jgdz) : black.jgdz != null) return false;
        if (jglx != null ? !jglx.equals(black.jglx) : black.jglx != null) return false;
        if (jgmc != null ? !jgmc.equals(black.jgmc) : black.jgmc != null) return false;
        if (lsh != null ? !lsh.equals(black.lsh) : black.lsh != null) return false;
        if (type != null ? !type.equals(black.type) : black.type != null) return false;
        if (xzqh != null ? !xzqh.equals(black.xzqh) : black.xzqh != null) return false;
        if (yxdate != null ? !yxdate.equals(black.yxdate) : black.yxdate != null) return false;
        if (zfrq != null ? !zfrq.equals(black.zfrq) : black.zfrq != null) return false;
        if (zsbh != null ? !zsbh.equals(black.zsbh) : black.zsbh != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (xzqh != null ? xzqh.hashCode() : 0);
        result = 31 * result + (jgdm != null ? jgdm.hashCode() : 0);
        result = 31 * result + (jglx != null ? jglx.hashCode() : 0);
        result = 31 * result + (jgmc != null ? jgmc.hashCode() : 0);
        result = 31 * result + (jgdz != null ? jgdz.hashCode() : 0);
        result = 31 * result + (bzrq != null ? bzrq.hashCode() : 0);
        result = 31 * result + (zfrq != null ? zfrq.hashCode() : 0);
        result = 31 * result + (yxdate != null ? yxdate.hashCode() : 0);
        result = 31 * result + (djh != null ? djh.hashCode() : 0);
        result = 31 * result + (lsh != null ? lsh.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (czrq != null ? czrq.hashCode() : 0);
        result = 31 * result + (czr != null ? czr.hashCode() : 0);
        result = 31 * result + (zsbh != null ? zsbh.hashCode() : 0);
        return result;
    }
}
