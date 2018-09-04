package com.ninemax.jpa.code.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-19
 * Time: ÏÂÎç5:10
 * To change this template use File | Settings | File Templates.
 */
@Table(name = "t_zgtzd_mx")
@Entity
public class TZgtzdMx {
    private Integer id;

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String zglsh;

    @Column(name = "zglsh")
    @Basic
    public String getZglsh() {
        return zglsh;
    }

    public void setZglsh(String zglsh) {
        this.zglsh = zglsh;
    }

    private String jgdm;

    @Column(name = "jgdm")
    @Basic
    public String getJgdm() {
        return jgdm;
    }

    public void setJgdm(String jgdm) {
        this.jgdm = jgdm;
    }

    private String jgmc;

    @Column(name = "jgmc")
    @Basic
    public String getJgmc() {
        return jgmc;
    }

    public void setJgmc(String jgmc) {
        this.jgmc = jgmc;
    }

    private String fddbr;

    @Column(name = "fddbr")
    @Basic
    public String getFddbr() {
        return fddbr;
    }

    public void setFddbr(String fddbr) {
        this.fddbr = fddbr;
    }

    private String zjhm;

    @Column(name = "zjhm")
    @Basic
    public String getZjhm() {
        return zjhm;
    }

    public void setZjhm(String zjhm) {
        this.zjhm = zjhm;
    }

    private String zch;

    @Column(name = "zch")
    @Basic
    public String getZch() {
        return zch;
    }

    public void setZch(String zch) {
        this.zch = zch;
    }

    private Date bzrq;

    @Column(name = "bzrq")
    @Basic
    public Date getBzrq() {
        return bzrq;
    }

    public void setBzrq(Date bzrq) {
        this.bzrq = bzrq;
    }

    private Date zfrq;

    @Column(name = "zfrq")
    @Basic
    public Date getZfrq() {
        return zfrq;
    }

    public void setZfrq(Date zfrq) {
        this.zfrq = zfrq;
    }

    private Date njqx;

    @Column(name = "njqx")
    @Basic
    public Date getNjqx() {
        return njqx;
    }

    public void setNjqx(Date njqx) {
        this.njqx = njqx;
    }

    private String bzjgdm;

    @Column(name = "bzjgdm")
    @Basic
    public String getBzjgdm() {
        return bzjgdm;
    }

    public void setBzjgdm(String bzjgdm) {
        this.bzjgdm = bzjgdm;
    }

    private String type;

    @Column(name = "type")
    @Basic
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String bzjgjc;

    @Column(name = "bzjgjc")
    @Basic
    public String getBzjgjc() {
        return bzjgjc;
    }

    public void setBzjgjc(String bzjgjc) {
        this.bzjgjc = bzjgjc;
    }

    private String zxdh;

    @Column(name = "zxdh")
    @Basic
    public String getZxdh() {
        return zxdh;
    }

    public void setZxdh(String zxdh) {
        this.zxdh = zxdh;
    }

    private String note;

    @Column(name = "note")
    @Basic
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TZgtzdMx tZgtzdMx = (TZgtzdMx) o;

        if (bzjgdm != null ? !bzjgdm.equals(tZgtzdMx.bzjgdm) : tZgtzdMx.bzjgdm != null) return false;
        if (bzjgjc != null ? !bzjgjc.equals(tZgtzdMx.bzjgjc) : tZgtzdMx.bzjgjc != null) return false;
        if (bzrq != null ? !bzrq.equals(tZgtzdMx.bzrq) : tZgtzdMx.bzrq != null) return false;
        if (fddbr != null ? !fddbr.equals(tZgtzdMx.fddbr) : tZgtzdMx.fddbr != null) return false;
        if (id != null ? !id.equals(tZgtzdMx.id) : tZgtzdMx.id != null) return false;
        if (jgdm != null ? !jgdm.equals(tZgtzdMx.jgdm) : tZgtzdMx.jgdm != null) return false;
        if (jgmc != null ? !jgmc.equals(tZgtzdMx.jgmc) : tZgtzdMx.jgmc != null) return false;
        if (njqx != null ? !njqx.equals(tZgtzdMx.njqx) : tZgtzdMx.njqx != null) return false;
        if (note != null ? !note.equals(tZgtzdMx.note) : tZgtzdMx.note != null) return false;
        if (type != null ? !type.equals(tZgtzdMx.type) : tZgtzdMx.type != null) return false;
        if (zch != null ? !zch.equals(tZgtzdMx.zch) : tZgtzdMx.zch != null) return false;
        if (zfrq != null ? !zfrq.equals(tZgtzdMx.zfrq) : tZgtzdMx.zfrq != null) return false;
        if (zglsh != null ? !zglsh.equals(tZgtzdMx.zglsh) : tZgtzdMx.zglsh != null) return false;
        if (zjhm != null ? !zjhm.equals(tZgtzdMx.zjhm) : tZgtzdMx.zjhm != null) return false;
        if (zxdh != null ? !zxdh.equals(tZgtzdMx.zxdh) : tZgtzdMx.zxdh != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (zglsh != null ? zglsh.hashCode() : 0);
        result = 31 * result + (jgdm != null ? jgdm.hashCode() : 0);
        result = 31 * result + (jgmc != null ? jgmc.hashCode() : 0);
        result = 31 * result + (fddbr != null ? fddbr.hashCode() : 0);
        result = 31 * result + (zjhm != null ? zjhm.hashCode() : 0);
        result = 31 * result + (zch != null ? zch.hashCode() : 0);
        result = 31 * result + (bzrq != null ? bzrq.hashCode() : 0);
        result = 31 * result + (zfrq != null ? zfrq.hashCode() : 0);
        result = 31 * result + (njqx != null ? njqx.hashCode() : 0);
        result = 31 * result + (bzjgdm != null ? bzjgdm.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (bzjgjc != null ? bzjgjc.hashCode() : 0);
        result = 31 * result + (zxdh != null ? zxdh.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        return result;
    }
}
