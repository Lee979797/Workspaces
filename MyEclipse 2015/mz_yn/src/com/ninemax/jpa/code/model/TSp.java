package com.ninemax.jpa.code.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-6-19
 * Time: 下午2:28
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "t_sp")
@Entity
public class TSp {

    private Long lsh;

    @javax.persistence.Column(name = "lsh")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getLsh() {
        return lsh;
    }

    public void setLsh(Long lsh) {
        this.lsh = lsh;
    }

    private String tyshxydm;

    @javax.persistence.Column(name = "tyshxydm")
    @Basic
    public String getTyshxydm() {
        return tyshxydm;
    }

    public void setTyshxydm(String tyshxydm) {
        this.tyshxydm = tyshxydm;
    }

    private String sendxzqh;

    @javax.persistence.Column(name = "sendxzqh")
    @Basic
    public String getSendxzqh() {
        return sendxzqh;
    }

    public void setSendxzqh(String sendxzqh) {
        this.sendxzqh = sendxzqh;
    }

    private String sendman;

    @javax.persistence.Column(name = "sendman")
    @Basic
    public String getSendman() {
        return sendman;
    }

    public void setSendman(String sendman) {
        this.sendman = sendman;
    }

    private Date sendtime;

    @javax.persistence.Column(name = "sendtime")
    @Basic
    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    private String ywlx;

    @javax.persistence.Column(name = "ywlx")
    @Basic
    public String getYwlx() {
        return ywlx;
    }

    public void setYwlx(String ywlx) {
        this.ywlx = ywlx;
    }

    private String recexzqh;

    @javax.persistence.Column(name = "recexzqh")
    @Basic
    public String getRecexzqh() {
        return recexzqh;
    }

    public void setRecexzqh(String recexzqh) {
        this.recexzqh = recexzqh;
    }

    private String shman;

    @javax.persistence.Column(name = "shman")
    @Basic
    public String getShman() {
        return shman;
    }

    public void setShman(String shman) {
        this.shman = shman;
    }

    private Date shtime;

    @javax.persistence.Column(name = "shtime")
    @Basic
    public Date getShtime() {
        return shtime;
    }

    public void setShtime(Date shtime) {
        this.shtime = shtime;
    }

    private String shflag;

    @javax.persistence.Column(name = "shflag")
    @Basic
    public String getShflag() {
        return shflag;
    }

    public void setShflag(String shflag) {
        this.shflag = shflag;
    }

    private String shreason;

    @javax.persistence.Column(name = "shreason")
    @Basic
    public String getShreason() {
        return shreason;
    }

    public void setShreason(String shreason) {
        this.shreason = shreason;
    }

    private String flag;

    @javax.persistence.Column(name = "flag")
    @Basic
    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    //0 正常提交，1重名注册，2重注册号，3，重名重注册号
    private Integer submitType;

    @javax.persistence.Column(name = "submitType")
    @Basic
    public Integer getSubmitType() {
        return submitType;
    }

    public void setSubmitType(Integer submitType) {
        this.submitType = submitType;
    }

    private Long gllsh;

    @javax.persistence.Column(name = "gllsh")
    @Basic
    public Long getGllsh() {
        return gllsh;
    }

    public void setGllsh(Long gllsh) {
        this.gllsh = gllsh;
    }
    public String jglx;
    @javax.persistence.Column(name = "jglx")
    @Basic
    public String getJglx() {
        return jglx;
    }

    public void setJglx(String jglx) {
        this.jglx = jglx;
    }
    public String jgmc;
    @javax.persistence.Column(name = "jgmc")
    @Basic
    public String getJgmc() {
		return jgmc;
	}

	public void setJgmc(String jgmc) {
		this.jgmc = jgmc;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TSp sp = (TSp) o;

        if (flag != null ? !flag.equals(sp.flag) : sp.flag != null) return false;
        if (gllsh != null ? !gllsh.equals(sp.gllsh) : sp.gllsh != null) return false;
        if (tyshxydm != null ? !tyshxydm.equals(sp.tyshxydm) : sp.tyshxydm != null) return false;
        if (lsh != null ? !lsh.equals(sp.lsh) : sp.lsh != null) return false;
        if (recexzqh != null ? !recexzqh.equals(sp.recexzqh) : sp.recexzqh != null) return false;
        if (sendman != null ? !sendman.equals(sp.sendman) : sp.sendman != null) return false;
        if (sendtime != null ? !sendtime.equals(sp.sendtime) : sp.sendtime != null) return false;
        if (sendxzqh != null ? !sendxzqh.equals(sp.sendxzqh) : sp.sendxzqh != null) return false;
        if (shflag != null ? !shflag.equals(sp.shflag) : sp.shflag != null) return false;
        if (shman != null ? !shman.equals(sp.shman) : sp.shman != null) return false;
        if (shreason != null ? !shreason.equals(sp.shreason) : sp.shreason != null) return false;
        if (shtime != null ? !shtime.equals(sp.shtime) : sp.shtime != null) return false;
        if (ywlx != null ? !ywlx.equals(sp.ywlx) : sp.ywlx != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lsh != null ? lsh.hashCode() : 0;
        result = 31 * result + (tyshxydm != null ? tyshxydm.hashCode() : 0);
        result = 31 * result + (sendxzqh != null ? sendxzqh.hashCode() : 0);
        result = 31 * result + (sendman != null ? sendman.hashCode() : 0);
        result = 31 * result + (sendtime != null ? sendtime.hashCode() : 0);
        result = 31 * result + (ywlx != null ? ywlx.hashCode() : 0);
        result = 31 * result + (recexzqh != null ? recexzqh.hashCode() : 0);
        result = 31 * result + (shman != null ? shman.hashCode() : 0);
        result = 31 * result + (shtime != null ? shtime.hashCode() : 0);
        result = 31 * result + (shflag != null ? shflag.hashCode() : 0);
        result = 31 * result + (shreason != null ? shreason.hashCode() : 0);
        result = 31 * result + (flag != null ? flag.hashCode() : 0);
        result = 31 * result + (gllsh != null ? gllsh.hashCode() : 0);
        return result;
    }
}
