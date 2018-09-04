package com.ninemax.jpa.code.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-10-24
 * Time: ÏÂÎç3:59
 */
@javax.persistence.Table(name = "t_ywlc_log")
@Entity
public class TYwlcLog {

    @javax.persistence.Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public int getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    private String ywlsh;

    @javax.persistence.Column(name = "ywlsh", nullable = false, insertable = true, updatable = true, length = 12, precision = 0)
    @Basic
    public String getYwlsh() {
        return ywlsh;
    }

    public void setYwlsh(String ywlsh) {
        this.ywlsh = ywlsh;
    }

    private int ywlclx;

    @javax.persistence.Column(name = "ywlclx", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getYwlclx() {
        return ywlclx;
    }

    public void setYwlclx(int ywlclx) {
        this.ywlclx = ywlclx;
    }

    private String type;

    @javax.persistence.Column(name = "type", nullable = false, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String isend;

    @javax.persistence.Column(name = "isend", nullable = false, insertable = true, updatable = true, length = 1, precision = 0)
    @Basic
    public String getIsend() {
        return isend;
    }

    public void setIsend(String isend) {
        this.isend = isend;
    }

    private String jgdm;

    @javax.persistence.Column(name = "jgdm", nullable = true, insertable = true, updatable = true, length = 9, precision = 0)
    @Basic
    public String getJgdm() {
        return jgdm;
    }

    public void setJgdm(String jgdm) {
        this.jgdm = jgdm;
    }

    private String jgmc;

    @javax.persistence.Column(name = "jgmc", nullable = true, insertable = true, updatable = true, length = 200, precision = 0)
    @Basic
    public String getJgmc() {
        return jgmc;
    }

    public void setJgmc(String jgmc) {
        this.jgmc = jgmc;
    }

    private String bzjgdm;

    @javax.persistence.Column(name = "bzjgdm", nullable = false, insertable = true, updatable = true, length = 6, precision = 0)
    @Basic
    public String getBzjgdm() {
        return bzjgdm;
    }

    public void setBzjgdm(String bzjgdm) {
        this.bzjgdm = bzjgdm;
    }

    private Date clsj;
    @javax.persistence.Column(name = "clsj")
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    public Date getClsj() {
        return clsj;
    }

    public void setClsj(Date clsj) {
        this.clsj = clsj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TYwlcLog tYwlcLog = (TYwlcLog) o;

        if (ywlclx != tYwlcLog.ywlclx) return false;
        if (bzjgdm != null ? !bzjgdm.equals(tYwlcLog.bzjgdm) : tYwlcLog.bzjgdm != null) return false;
        if (isend != null ? !isend.equals(tYwlcLog.isend) : tYwlcLog.isend != null) return false;
        if (jgdm != null ? !jgdm.equals(tYwlcLog.jgdm) : tYwlcLog.jgdm != null) return false;
        if (jgmc != null ? !jgmc.equals(tYwlcLog.jgmc) : tYwlcLog.jgmc != null) return false;
        if (type != null ? !type.equals(tYwlcLog.type) : tYwlcLog.type != null) return false;
        if (ywlsh != null ? !ywlsh.equals(tYwlcLog.ywlsh) : tYwlcLog.ywlsh != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ywlsh != null ? ywlsh.hashCode() : 0;
        result = 31 * result + ywlclx;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (isend != null ? isend.hashCode() : 0);
        result = 31 * result + (jgdm != null ? jgdm.hashCode() : 0);
        result = 31 * result + (jgmc != null ? jgmc.hashCode() : 0);
        result = 31 * result + (bzjgdm != null ? bzjgdm.hashCode() : 0);
        return result;
    }
}
