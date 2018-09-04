package com.ninemax.jpa.code.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-8-15
 * Time: ÏÂÎç5:41
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "SM_Recode")
@Entity
public class SmRecode {
    private Integer tempid;

    @javax.persistence.Column(name = "tempid")
    @Id
    public Integer getTempid() {
        return tempid;
    }

    public void setTempid(Integer tempid) {
        this.tempid = tempid;
    }

    private String jgdm;

    @javax.persistence.Column(name = "JGDM")
    @Basic
    public String getJgdm() {
        return jgdm;
    }

    public void setJgdm(String jgdm) {
        this.jgdm = jgdm;
    }

    private String jgmc;

    @javax.persistence.Column(name = "JGMC")
    @Basic
    public String getJgmc() {
        return jgmc;
    }

    public void setJgmc(String jgmc) {
        this.jgmc = jgmc;
    }

    private Date bzrq;

    @javax.persistence.Column(name = "BZRQ")
    @Basic
    public Date getBzrq() {
        return bzrq;
    }

    public void setBzrq(Date bzrq) {
        this.bzrq = bzrq;
    }

    private Date bgrq;

    @javax.persistence.Column(name = "BGRQ")
    @Basic
    public Date getBgrq() {
        return bgrq;
    }

    public void setBgrq(Date bgrq) {
        this.bgrq = bgrq;
    }

    private Date zfrq;

    @javax.persistence.Column(name = "ZFRQ")
    @Basic
    public Date getZfrq() {
        return zfrq;
    }

    public void setZfrq(Date zfrq) {
        this.zfrq = zfrq;
    }

    private Date lastdate;

    @javax.persistence.Column(name = "LASTDATE")
    @Basic
    public Date getLastdate() {
        return lastdate;
    }

    public void setLastdate(Date lastdate) {
        this.lastdate = lastdate;
    }

    private String jglx;

    @javax.persistence.Column(name = "JGLX")
    @Basic
    public String getJglx() {
        return jglx;
    }

    public void setJglx(String jglx) {
        this.jglx = jglx;
    }

    private String bzjgdm;

    @javax.persistence.Column(name = "BZJGDM")
    @Basic
    public String getBzjgdm() {
        return bzjgdm;
    }

    public void setBzjgdm(String bzjgdm) {
        this.bzjgdm = bzjgdm;
    }

    private String fddbr;

    @javax.persistence.Column(name = "FDDBR")
    @Basic
    public String getFddbr() {
        return fddbr;
    }

    public void setFddbr(String fddbr) {
        this.fddbr = fddbr;
    }

    private String zjlx;

    @javax.persistence.Column(name = "ZJLX")
    @Basic
    public String getZjlx() {
        return zjlx;
    }

    public void setZjlx(String zjlx) {
        this.zjlx = zjlx;
    }

    private String zjhm;

    @javax.persistence.Column(name = "ZJHM")
    @Basic
    public String getZjhm() {
        return zjhm;
    }

    public void setZjhm(String zjhm) {
        this.zjhm = zjhm;
    }

    private String jyfw;

    @javax.persistence.Column(name = "JYFW")
    @Basic
    public String getJyfw() {
        return jyfw;
    }

    public void setJyfw(String jyfw) {
        this.jyfw = jyfw;
    }

    private String jjhy;

    @javax.persistence.Column(name = "JJHY")
    @Basic
    public String getJjhy() {
        return jjhy;
    }

    public void setJjhy(String jjhy) {
        this.jjhy = jjhy;
    }

    private String jjlx;

    @javax.persistence.Column(name = "JJLX")
    @Basic
    public String getJjlx() {
        return jjlx;
    }

    public void setJjlx(String jjlx) {
        this.jjlx = jjlx;
    }

    private Date zcrq;

    @javax.persistence.Column(name = "ZCRQ")
    @Basic
    public Date getZcrq() {
        return zcrq;
    }

    public void setZcrq(Date zcrq) {
        this.zcrq = zcrq;
    }

    private String zgdm;

    @javax.persistence.Column(name = "ZGDM")
    @Basic
    public String getZgdm() {
        return zgdm;
    }

    public void setZgdm(String zgdm) {
        this.zgdm = zgdm;
    }

    private String pzjgdm;

    @javax.persistence.Column(name = "PZJGDM")
    @Basic
    public String getPzjgdm() {
        return pzjgdm;
    }

    public void setPzjgdm(String pzjgdm) {
        this.pzjgdm = pzjgdm;
    }

    private String xzqh;

    @javax.persistence.Column(name = "XZQH")
    @Basic
    public String getXzqh() {
        return xzqh;
    }

    public void setXzqh(String xzqh) {
        this.xzqh = xzqh;
    }

    private String jgdz;

    @javax.persistence.Column(name = "JGDZ")
    @Basic
    public String getJgdz() {
        return jgdz;
    }

    public void setJgdz(String jgdz) {
        this.jgdz = jgdz;
    }

    private String yzbm;

    @javax.persistence.Column(name = "YZBM")
    @Basic
    public String getYzbm() {
        return yzbm;
    }

    public void setYzbm(String yzbm) {
        this.yzbm = yzbm;
    }

    private String dhhm;

    @javax.persistence.Column(name = "DHHM")
    @Basic
    public String getDhhm() {
        return dhhm;
    }

    public void setDhhm(String dhhm) {
        this.dhhm = dhhm;
    }

    private String cLdate;

    @javax.persistence.Column(name = "CLdate")
    @Basic
    public String getcLdate() {
        return cLdate;
    }

    public void setcLdate(String cLdate) {
        this.cLdate = cLdate;
    }

    private String type;

    @javax.persistence.Column(name = "Type")
    @Basic
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private Boolean zt;

    @javax.persistence.Column(name = "ZT")
    @Basic
    public Boolean getZt() {
        return zt;
    }

    public void setZt(Boolean zt) {
        this.zt = zt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SmRecode smRecode = (SmRecode) o;

        if (bgrq != null ? !bgrq.equals(smRecode.bgrq) : smRecode.bgrq != null) return false;
        if (bzjgdm != null ? !bzjgdm.equals(smRecode.bzjgdm) : smRecode.bzjgdm != null) return false;
        if (bzrq != null ? !bzrq.equals(smRecode.bzrq) : smRecode.bzrq != null) return false;
        if (cLdate != null ? !cLdate.equals(smRecode.cLdate) : smRecode.cLdate != null) return false;
        if (dhhm != null ? !dhhm.equals(smRecode.dhhm) : smRecode.dhhm != null) return false;
        if (fddbr != null ? !fddbr.equals(smRecode.fddbr) : smRecode.fddbr != null) return false;
        if (jgdm != null ? !jgdm.equals(smRecode.jgdm) : smRecode.jgdm != null) return false;
        if (jgdz != null ? !jgdz.equals(smRecode.jgdz) : smRecode.jgdz != null) return false;
        if (jglx != null ? !jglx.equals(smRecode.jglx) : smRecode.jglx != null) return false;
        if (jgmc != null ? !jgmc.equals(smRecode.jgmc) : smRecode.jgmc != null) return false;
        if (jjhy != null ? !jjhy.equals(smRecode.jjhy) : smRecode.jjhy != null) return false;
        if (jjlx != null ? !jjlx.equals(smRecode.jjlx) : smRecode.jjlx != null) return false;
        if (jyfw != null ? !jyfw.equals(smRecode.jyfw) : smRecode.jyfw != null) return false;
        if (lastdate != null ? !lastdate.equals(smRecode.lastdate) : smRecode.lastdate != null) return false;
        if (pzjgdm != null ? !pzjgdm.equals(smRecode.pzjgdm) : smRecode.pzjgdm != null) return false;
        if (tempid != null ? !tempid.equals(smRecode.tempid) : smRecode.tempid != null) return false;
        if (type != null ? !type.equals(smRecode.type) : smRecode.type != null) return false;
        if (xzqh != null ? !xzqh.equals(smRecode.xzqh) : smRecode.xzqh != null) return false;
        if (yzbm != null ? !yzbm.equals(smRecode.yzbm) : smRecode.yzbm != null) return false;
        if (zcrq != null ? !zcrq.equals(smRecode.zcrq) : smRecode.zcrq != null) return false;
        if (zfrq != null ? !zfrq.equals(smRecode.zfrq) : smRecode.zfrq != null) return false;
        if (zgdm != null ? !zgdm.equals(smRecode.zgdm) : smRecode.zgdm != null) return false;
        if (zjhm != null ? !zjhm.equals(smRecode.zjhm) : smRecode.zjhm != null) return false;
        if (zjlx != null ? !zjlx.equals(smRecode.zjlx) : smRecode.zjlx != null) return false;
        if (zt != null ? !zt.equals(smRecode.zt) : smRecode.zt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tempid != null ? tempid.hashCode() : 0;
        result = 31 * result + (jgdm != null ? jgdm.hashCode() : 0);
        result = 31 * result + (jgmc != null ? jgmc.hashCode() : 0);
        result = 31 * result + (bzrq != null ? bzrq.hashCode() : 0);
        result = 31 * result + (bgrq != null ? bgrq.hashCode() : 0);
        result = 31 * result + (zfrq != null ? zfrq.hashCode() : 0);
        result = 31 * result + (lastdate != null ? lastdate.hashCode() : 0);
        result = 31 * result + (jglx != null ? jglx.hashCode() : 0);
        result = 31 * result + (bzjgdm != null ? bzjgdm.hashCode() : 0);
        result = 31 * result + (fddbr != null ? fddbr.hashCode() : 0);
        result = 31 * result + (zjlx != null ? zjlx.hashCode() : 0);
        result = 31 * result + (zjhm != null ? zjhm.hashCode() : 0);
        result = 31 * result + (jyfw != null ? jyfw.hashCode() : 0);
        result = 31 * result + (jjhy != null ? jjhy.hashCode() : 0);
        result = 31 * result + (jjlx != null ? jjlx.hashCode() : 0);
        result = 31 * result + (zcrq != null ? zcrq.hashCode() : 0);
        result = 31 * result + (zgdm != null ? zgdm.hashCode() : 0);
        result = 31 * result + (pzjgdm != null ? pzjgdm.hashCode() : 0);
        result = 31 * result + (xzqh != null ? xzqh.hashCode() : 0);
        result = 31 * result + (jgdz != null ? jgdz.hashCode() : 0);
        result = 31 * result + (yzbm != null ? yzbm.hashCode() : 0);
        result = 31 * result + (dhhm != null ? dhhm.hashCode() : 0);
        result = 31 * result + (cLdate != null ? cLdate.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (zt != null ? zt.hashCode() : 0);
        return result;
    }
}
