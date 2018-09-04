package com.ninemax.jpa.code.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-10-26
 * Time: ÉÏÎç10:44
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "t_ywlc")
@Entity
public class TYwlc {
    private String ywlsh;

    @javax.persistence.Column(name = "ywlsh")
    @Id
    public String getYwlsh() {
        return ywlsh;
    }

    public void setYwlsh(String ywlsh) {
        this.ywlsh = ywlsh;
    }

    private Integer ywlclx;

    @javax.persistence.Column(name = "ywlclx")
    @Basic
    public Integer getYwlclx() {
        return ywlclx;
    }

    public void setYwlclx(Integer ywlclx) {
        this.ywlclx = ywlclx;
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

    private String isend;

    @javax.persistence.Column(name = "isend")
    @Basic
    public String getIsend() {
        return isend;
    }

    public void setIsend(String isend) {
        this.isend = isend;
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

    private String jgmc;

    @javax.persistence.Column(name = "jgmc")
    @Basic
    public String getJgmc() {
        return jgmc;
    }

    public void setJgmc(String jgmc) {
        this.jgmc = jgmc;
    }

    private String bzjgdm;

    @javax.persistence.Column(name = "bzjgdm")
    @Basic
    public String getBzjgdm() {
        return bzjgdm;
    }

    public void setBzjgdm(String bzjgdm) {
        this.bzjgdm = bzjgdm;
    }

    private Date clsj;

    @javax.persistence.Column(name = "clsj")
    @Basic
    public Date getClsj() {
        return clsj;
    }

    public void setClsj(Date clsj) {
        this.clsj = clsj;
    }

    private Long id;

    @javax.persistence.Column(name = "id")
    @Basic
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    private String userName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TYwlc tYwlc = (TYwlc) o;

        if (bzjgdm != null ? !bzjgdm.equals(tYwlc.bzjgdm) : tYwlc.bzjgdm != null) return false;
        if (clsj != null ? !clsj.equals(tYwlc.clsj) : tYwlc.clsj != null) return false;
        if (id != null ? !id.equals(tYwlc.id) : tYwlc.id != null) return false;
        if (isend != null ? !isend.equals(tYwlc.isend) : tYwlc.isend != null) return false;
        if (jgdm != null ? !jgdm.equals(tYwlc.jgdm) : tYwlc.jgdm != null) return false;
        if (jgmc != null ? !jgmc.equals(tYwlc.jgmc) : tYwlc.jgmc != null) return false;
        if (type != null ? !type.equals(tYwlc.type) : tYwlc.type != null) return false;
        if (ywlclx != null ? !ywlclx.equals(tYwlc.ywlclx) : tYwlc.ywlclx != null) return false;
        if (ywlsh != null ? !ywlsh.equals(tYwlc.ywlsh) : tYwlc.ywlsh != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ywlsh != null ? ywlsh.hashCode() : 0;
        result = 31 * result + (ywlclx != null ? ywlclx.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (isend != null ? isend.hashCode() : 0);
        result = 31 * result + (jgdm != null ? jgdm.hashCode() : 0);
        result = 31 * result + (jgmc != null ? jgmc.hashCode() : 0);
        result = 31 * result + (bzjgdm != null ? bzjgdm.hashCode() : 0);
        result = 31 * result + (clsj != null ? clsj.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
