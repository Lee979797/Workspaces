package com.ninemax.jpa.code.model;

import javax.persistence.*;
import java.util.Date;

/**
 * User: ninemax-199
 * Date: 13-10-8
 * Time: ÏÂÎç2:53
 */
@javax.persistence.Table(name = "t_qzsm")
@Entity
public class TQzsm {
    private Integer id;
    private String jgdm;
    private String jgmc;
    private String bzjgdm;
    private String fddbr;
    private String zjhm;
    private String zjlx;
    private String jglx;
    private String jjhy;
    private String jjlx;
    private Date zcrq;
    private String zgdm;
    private String pzjgdm;
    private String xzqh;
    private String jgdz;
    private String yzbm;
    private String dhhm;
    private Date bzrq;
    private Integer zgrs;
    private Date njrq;
    private Date bgrq;
    private String zch;
    private String qzbz;
    private String zgmc;
    private String pzjgmc;
    private String pzwh;
    private Date pwrq;
    private String gk;
    private String type;
    private Date compleTime;
    private Boolean status;
    private Date createTime;
    private String imagePath;

    @javax.persistence.Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @javax.persistence.Column(name = "jgdm")
    @Basic
    public String getJgdm() {
        return jgdm;
    }

    public void setJgdm(String jgdm) {
        this.jgdm = jgdm;
    }

    @javax.persistence.Column(name = "jgmc")
    @Basic
    public String getJgmc() {
        return jgmc;
    }

    public void setJgmc(String jgmc) {
        this.jgmc = jgmc;
    }

    @javax.persistence.Column(name = "bzjgdm")
    @Basic
    public String getBzjgdm() {
        return bzjgdm;
    }

    public void setBzjgdm(String bzjgdm) {
        this.bzjgdm = bzjgdm;
    }

    @javax.persistence.Column(name = "fddbr")
    @Basic
    public String getFddbr() {
        return fddbr;
    }

    public void setFddbr(String fddbr) {
        this.fddbr = fddbr;
    }

    @javax.persistence.Column(name = "zjhm")
    @Basic
    public String getZjhm() {
        return zjhm;
    }

    public void setZjhm(String zjhm) {
        this.zjhm = zjhm;
    }

    @javax.persistence.Column(name = "zjlx")
    @Basic
    public String getZjlx() {
        return zjlx;
    }

    public void setZjlx(String zjlx) {
        this.zjlx = zjlx;
    }

    @javax.persistence.Column(name = "jglx")
    @Basic
    public String getJglx() {
        return jglx;
    }

    public void setJglx(String jglx) {
        this.jglx = jglx;
    }

    @javax.persistence.Column(name = "jjhy")
    @Basic
    public String getJjhy() {
        return jjhy;
    }

    public void setJjhy(String jjhy) {
        this.jjhy = jjhy;
    }

    @javax.persistence.Column(name = "jjlx")
    @Basic
    public String getJjlx() {
        return jjlx;
    }

    public void setJjlx(String jjlx) {
        this.jjlx = jjlx;
    }

    @javax.persistence.Column(name = "zcrq")
    @Basic
    public Date getZcrq() {
        return zcrq;
    }

    public void setZcrq(Date zcrq) {
        this.zcrq = zcrq;
    }

    @javax.persistence.Column(name = "zgdm")
    @Basic
    public String getZgdm() {
        return zgdm;
    }

    public void setZgdm(String zgdm) {
        this.zgdm = zgdm;
    }

    @javax.persistence.Column(name = "pzjgdm")
    @Basic
    public String getPzjgdm() {
        return pzjgdm;
    }

    public void setPzjgdm(String pzjgdm) {
        this.pzjgdm = pzjgdm;
    }

    @javax.persistence.Column(name = "xzqh")
    @Basic
    public String getXzqh() {
        return xzqh;
    }

    public void setXzqh(String xzqh) {
        this.xzqh = xzqh;
    }

    @javax.persistence.Column(name = "jgdz")
    @Basic
    public String getJgdz() {
        return jgdz;
    }

    public void setJgdz(String jgdz) {
        this.jgdz = jgdz;
    }

    @javax.persistence.Column(name = "yzbm")
    @Basic
    public String getYzbm() {
        return yzbm;
    }

    public void setYzbm(String yzbm) {
        this.yzbm = yzbm;
    }

    @javax.persistence.Column(name = "dhhm")
    @Basic
    public String getDhhm() {
        return dhhm;
    }

    public void setDhhm(String dhhm) {
        this.dhhm = dhhm;
    }

    @javax.persistence.Column(name = "bzrq")
    @Basic
    public Date getBzrq() {
        return bzrq;
    }

    public void setBzrq(Date bzrq) {
        this.bzrq = bzrq;
    }

    @javax.persistence.Column(name = "zgrs")
    @Basic
    public Integer getZgrs() {
        return zgrs;
    }

    public void setZgrs(Integer zgrs) {
        this.zgrs = zgrs;
    }

    @javax.persistence.Column(name = "njrq")
    @Basic
    public Date getNjrq() {
        return njrq;
    }

    public void setNjrq(Date njrq) {
        this.njrq = njrq;
    }

    @javax.persistence.Column(name = "bgrq")
    @Basic
    public Date getBgrq() {
        return bgrq;
    }

    public void setBgrq(Date bgrq) {
        this.bgrq = bgrq;
    }

    @javax.persistence.Column(name = "zch")
    @Basic
    public String getZch() {
        return zch;
    }

    public void setZch(String zch) {
        this.zch = zch;
    }

    @javax.persistence.Column(name = "qzbz")
    @Basic
    public String getQzbz() {
        return qzbz;
    }

    public void setQzbz(String qzbz) {
        this.qzbz = qzbz;
    }

    @javax.persistence.Column(name = "zgmc")
    @Basic
    public String getZgmc() {
        return zgmc;
    }

    public void setZgmc(String zgmc) {
        this.zgmc = zgmc;
    }

    @javax.persistence.Column(name = "pzjgmc")
    @Basic
    public String getPzjgmc() {
        return pzjgmc;
    }

    public void setPzjgmc(String pzjgmc) {
        this.pzjgmc = pzjgmc;
    }

    @javax.persistence.Column(name = "pzwh")
    @Basic
    public String getPzwh() {
        return pzwh;
    }

    public void setPzwh(String pzwh) {
        this.pzwh = pzwh;
    }

    @javax.persistence.Column(name = "pwrq")
    @Basic
    public Date getPwrq() {
        return pwrq;
    }

    public void setPwrq(Date pwrq) {
        this.pwrq = pwrq;
    }

    @javax.persistence.Column(name = "gk")
    @Basic
    public String getGk() {
        return gk;
    }

    public void setGk(String gk) {
        this.gk = gk;
    }

    @javax.persistence.Column(name = "type")
    @Basic
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @javax.persistence.Column(name = "compleTime")
    @Basic
    public Date getCompleTime() {
        return compleTime;
    }

    public void setCompleTime(Date compleTime) {
        this.compleTime = compleTime;
    }

    @javax.persistence.Column(name = "status")
    @Basic
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @javax.persistence.Column(name = "createTime")
    @Basic
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @javax.persistence.Column(name = "imagePath")
    @Basic
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TQzsm tQzsm = (TQzsm) o;

        if (bgrq != null ? !bgrq.equals(tQzsm.bgrq) : tQzsm.bgrq != null) return false;
        if (bzjgdm != null ? !bzjgdm.equals(tQzsm.bzjgdm) : tQzsm.bzjgdm != null) return false;
        if (bzrq != null ? !bzrq.equals(tQzsm.bzrq) : tQzsm.bzrq != null) return false;
        if (compleTime != null ? !compleTime.equals(tQzsm.compleTime) : tQzsm.compleTime != null) return false;
        if (createTime != null ? !createTime.equals(tQzsm.createTime) : tQzsm.createTime != null) return false;
        if (dhhm != null ? !dhhm.equals(tQzsm.dhhm) : tQzsm.dhhm != null) return false;
        if (fddbr != null ? !fddbr.equals(tQzsm.fddbr) : tQzsm.fddbr != null) return false;
        if (gk != null ? !gk.equals(tQzsm.gk) : tQzsm.gk != null) return false;
        if (id != null ? !id.equals(tQzsm.id) : tQzsm.id != null) return false;
        if (imagePath != null ? !imagePath.equals(tQzsm.imagePath) : tQzsm.imagePath != null) return false;
        if (jgdm != null ? !jgdm.equals(tQzsm.jgdm) : tQzsm.jgdm != null) return false;
        if (jgdz != null ? !jgdz.equals(tQzsm.jgdz) : tQzsm.jgdz != null) return false;
        if (jglx != null ? !jglx.equals(tQzsm.jglx) : tQzsm.jglx != null) return false;
        if (jgmc != null ? !jgmc.equals(tQzsm.jgmc) : tQzsm.jgmc != null) return false;
        if (jjhy != null ? !jjhy.equals(tQzsm.jjhy) : tQzsm.jjhy != null) return false;
        if (jjlx != null ? !jjlx.equals(tQzsm.jjlx) : tQzsm.jjlx != null) return false;
        if (njrq != null ? !njrq.equals(tQzsm.njrq) : tQzsm.njrq != null) return false;
        if (pwrq != null ? !pwrq.equals(tQzsm.pwrq) : tQzsm.pwrq != null) return false;
        if (pzjgdm != null ? !pzjgdm.equals(tQzsm.pzjgdm) : tQzsm.pzjgdm != null) return false;
        if (pzjgmc != null ? !pzjgmc.equals(tQzsm.pzjgmc) : tQzsm.pzjgmc != null) return false;
        if (pzwh != null ? !pzwh.equals(tQzsm.pzwh) : tQzsm.pzwh != null) return false;
        if (qzbz != null ? !qzbz.equals(tQzsm.qzbz) : tQzsm.qzbz != null) return false;
        if (status != null ? !status.equals(tQzsm.status) : tQzsm.status != null) return false;
        if (type != null ? !type.equals(tQzsm.type) : tQzsm.type != null) return false;
        if (xzqh != null ? !xzqh.equals(tQzsm.xzqh) : tQzsm.xzqh != null) return false;
        if (yzbm != null ? !yzbm.equals(tQzsm.yzbm) : tQzsm.yzbm != null) return false;
        if (zch != null ? !zch.equals(tQzsm.zch) : tQzsm.zch != null) return false;
        if (zcrq != null ? !zcrq.equals(tQzsm.zcrq) : tQzsm.zcrq != null) return false;
        if (zgdm != null ? !zgdm.equals(tQzsm.zgdm) : tQzsm.zgdm != null) return false;
        if (zgmc != null ? !zgmc.equals(tQzsm.zgmc) : tQzsm.zgmc != null) return false;
        if (zgrs != null ? !zgrs.equals(tQzsm.zgrs) : tQzsm.zgrs != null) return false;
        if (zjhm != null ? !zjhm.equals(tQzsm.zjhm) : tQzsm.zjhm != null) return false;
        if (zjlx != null ? !zjlx.equals(tQzsm.zjlx) : tQzsm.zjlx != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (jgdm != null ? jgdm.hashCode() : 0);
        result = 31 * result + (jgmc != null ? jgmc.hashCode() : 0);
        result = 31 * result + (bzjgdm != null ? bzjgdm.hashCode() : 0);
        result = 31 * result + (fddbr != null ? fddbr.hashCode() : 0);
        result = 31 * result + (zjhm != null ? zjhm.hashCode() : 0);
        result = 31 * result + (zjlx != null ? zjlx.hashCode() : 0);
        result = 31 * result + (jglx != null ? jglx.hashCode() : 0);
        result = 31 * result + (jjhy != null ? jjhy.hashCode() : 0);
        result = 31 * result + (jjlx != null ? jjlx.hashCode() : 0);
        result = 31 * result + (zcrq != null ? zcrq.hashCode() : 0);
        result = 31 * result + (zgdm != null ? zgdm.hashCode() : 0);
        result = 31 * result + (pzjgdm != null ? pzjgdm.hashCode() : 0);
        result = 31 * result + (xzqh != null ? xzqh.hashCode() : 0);
        result = 31 * result + (jgdz != null ? jgdz.hashCode() : 0);
        result = 31 * result + (yzbm != null ? yzbm.hashCode() : 0);
        result = 31 * result + (dhhm != null ? dhhm.hashCode() : 0);
        result = 31 * result + (bzrq != null ? bzrq.hashCode() : 0);
        result = 31 * result + (zgrs != null ? zgrs.hashCode() : 0);
        result = 31 * result + (njrq != null ? njrq.hashCode() : 0);
        result = 31 * result + (bgrq != null ? bgrq.hashCode() : 0);
        result = 31 * result + (zch != null ? zch.hashCode() : 0);
        result = 31 * result + (qzbz != null ? qzbz.hashCode() : 0);
        result = 31 * result + (zgmc != null ? zgmc.hashCode() : 0);
        result = 31 * result + (pzjgmc != null ? pzjgmc.hashCode() : 0);
        result = 31 * result + (pzwh != null ? pzwh.hashCode() : 0);
        result = 31 * result + (pwrq != null ? pwrq.hashCode() : 0);
        result = 31 * result + (gk != null ? gk.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (compleTime != null ? compleTime.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (imagePath != null ? imagePath.hashCode() : 0);
        return result;
    }
}
