package com.ninemax.jpa.code.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-6-11
 * Time: ÏÂÎç2:38
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.IdClass(com.ninemax.jpa.code.model.TkFkkPK.class)
@javax.persistence.Table(name = "tk_fkk")
@Entity
public class TkFkk {
    private Long kxlh;

    @javax.persistence.Column(name = "kxlh")
    @Id
    public Long getKxlh() {
        return kxlh;
    }

    public void setKxlh(Long kxlh) {
        this.kxlh = kxlh;
    }

    private Integer lsh;

    @javax.persistence.Column(name = "lsh")
    @Basic
    public Integer getLsh() {
        return lsh;
    }

    public void setLsh(Integer lsh) {
        this.lsh = lsh;
    }

    private Date cshsj;

    @javax.persistence.Column(name = "cshsj")
    @Basic
    public Date getCshsj() {
        return cshsj;
    }

    public void setCshsj(Date cshsj) {
        this.cshsj = cshsj;
    }

    private String operatenum;

    @javax.persistence.Column(name = "operatenum")
    @Basic
    public String getOperatenum() {
        return operatenum;
    }

    public void setOperatenum(String operatenum) {
        this.operatenum = operatenum;
    }

    private String jgdm;

    @javax.persistence.Column(name = "jgdm")
    @Id
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

    private String bfjgmc;

    @javax.persistence.Column(name = "bfjgmc")
    @Basic
    public String getBfjgmc() {
        return bfjgmc;
    }

    public void setBfjgmc(String bfjgmc) {
        this.bfjgmc = bfjgmc;
    }

    private Date fksj;

    @javax.persistence.Column(name = "fksj")
    @Basic
    public Date getFksj() {
        return fksj;
    }

    public void setFksj(Date fksj) {
        this.fksj = fksj;
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

    private String jglxmc;

    @javax.persistence.Column(name = "jglxmc")
    @Basic
    public String getJglxmc() {
        return jglxmc;
    }

    public void setJglxmc(String jglxmc) {
        this.jglxmc = jglxmc;
    }

    private String fddbr;

    @javax.persistence.Column(name = "fddbr")
    @Basic
    public String getFddbr() {
        return fddbr;
    }

    public void setFddbr(String fddbr) {
        this.fddbr = fddbr;
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

    private String jgdz;

    @javax.persistence.Column(name = "jgdz")
    @Basic
    public String getJgdz() {
        return jgdz;
    }

    public void setJgdz(String jgdz) {
        this.jgdz = jgdz;
    }

    private String yzbm;

    @javax.persistence.Column(name = "yzbm")
    @Basic
    public String getYzbm() {
        return yzbm;
    }

    public void setYzbm(String yzbm) {
        this.yzbm = yzbm;
    }

    private String dhhm;

    @javax.persistence.Column(name = "dhhm")
    @Basic
    public String getDhhm() {
        return dhhm;
    }

    public void setDhhm(String dhhm) {
        this.dhhm = dhhm;
    }

    private Double zczj;

    @javax.persistence.Column(name = "zczj")
    @Basic
    public Double getZczj() {
        return zczj;
    }

    public void setZczj(Double zczj) {
        this.zczj = zczj;
    }

    private String hbzl;

    @javax.persistence.Column(name = "hbzl")
    @Basic
    public String getHbzl() {
        return hbzl;
    }

    public void setHbzl(String hbzl) {
        this.hbzl = hbzl;
    }

    private String hbzlmc;

    @javax.persistence.Column(name = "hbzlmc")
    @Basic
    public String getHbzlmc() {
        return hbzlmc;
    }

    public void setHbzlmc(String hbzlmc) {
        this.hbzlmc = hbzlmc;
    }

    private String jjlx;

    @javax.persistence.Column(name = "jjlx")
    @Basic
    public String getJjlx() {
        return jjlx;
    }

    public void setJjlx(String jjlx) {
        this.jjlx = jjlx;
    }

    private String jjlxmc;

    @javax.persistence.Column(name = "jjlxmc")
    @Basic
    public String getJjlxmc() {
        return jjlxmc;
    }

    public void setJjlxmc(String jjlxmc) {
        this.jjlxmc = jjlxmc;
    }

    private String wftzgb;

    @javax.persistence.Column(name = "wftzgb")
    @Basic
    public String getWftzgb() {
        return wftzgb;
    }

    public void setWftzgb(String wftzgb) {
        this.wftzgb = wftzgb;
    }

    private String wftzgbmc;

    @javax.persistence.Column(name = "wftzgbmc")
    @Basic
    public String getWftzgbmc() {
        return wftzgbmc;
    }

    public void setWftzgbmc(String wftzgbmc) {
        this.wftzgbmc = wftzgbmc;
    }

    private Date njrq;

    @javax.persistence.Column(name = "njrq")
    @Basic
    public Date getNjrq() {
        return njrq;
    }

    public void setNjrq(Date njrq) {
        this.njrq = njrq;
    }

    private Date njqx;

    @javax.persistence.Column(name = "njqx")
    @Basic
    public Date getNjqx() {
        return njqx;
    }

    public void setNjqx(Date njqx) {
        this.njqx = njqx;
    }

    private String zch;

    @javax.persistence.Column(name = "zch")
    @Basic
    public String getZch() {
        return zch;
    }

    public void setZch(String zch) {
        this.zch = zch;
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

    private Date lastdate;

    @javax.persistence.Column(name = "lastdate")
    @Basic
    public Date getLastdate() {
        return lastdate;
    }

    public void setLastdate(Date lastdate) {
        this.lastdate = lastdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TkFkk tkFkk = (TkFkk) o;

        if (kxlh != tkFkk.kxlh) return false;
        if (lsh != tkFkk.lsh) return false;
        if (bfjgmc != null ? !bfjgmc.equals(tkFkk.bfjgmc) : tkFkk.bfjgmc != null) return false;
        if (cshsj != null ? !cshsj.equals(tkFkk.cshsj) : tkFkk.cshsj != null) return false;
        if (dhhm != null ? !dhhm.equals(tkFkk.dhhm) : tkFkk.dhhm != null) return false;
        if (fddbr != null ? !fddbr.equals(tkFkk.fddbr) : tkFkk.fddbr != null) return false;
        if (fksj != null ? !fksj.equals(tkFkk.fksj) : tkFkk.fksj != null) return false;
        if (flag != null ? !flag.equals(tkFkk.flag) : tkFkk.flag != null) return false;
        if (hbzl != null ? !hbzl.equals(tkFkk.hbzl) : tkFkk.hbzl != null) return false;
        if (hbzlmc != null ? !hbzlmc.equals(tkFkk.hbzlmc) : tkFkk.hbzlmc != null) return false;
        if (jgdm != null ? !jgdm.equals(tkFkk.jgdm) : tkFkk.jgdm != null) return false;
        if (jgdz != null ? !jgdz.equals(tkFkk.jgdz) : tkFkk.jgdz != null) return false;
        if (jglx != null ? !jglx.equals(tkFkk.jglx) : tkFkk.jglx != null) return false;
        if (jglxmc != null ? !jglxmc.equals(tkFkk.jglxmc) : tkFkk.jglxmc != null) return false;
        if (jgmc != null ? !jgmc.equals(tkFkk.jgmc) : tkFkk.jgmc != null) return false;
        if (jjlx != null ? !jjlx.equals(tkFkk.jjlx) : tkFkk.jjlx != null) return false;
        if (jjlxmc != null ? !jjlxmc.equals(tkFkk.jjlxmc) : tkFkk.jjlxmc != null) return false;
        if (lastdate != null ? !lastdate.equals(tkFkk.lastdate) : tkFkk.lastdate != null) return false;
        if (njqx != null ? !njqx.equals(tkFkk.njqx) : tkFkk.njqx != null) return false;
        if (njrq != null ? !njrq.equals(tkFkk.njrq) : tkFkk.njrq != null) return false;
        if (operatenum != null ? !operatenum.equals(tkFkk.operatenum) : tkFkk.operatenum != null) return false;
        if (wftzgb != null ? !wftzgb.equals(tkFkk.wftzgb) : tkFkk.wftzgb != null) return false;
        if (wftzgbmc != null ? !wftzgbmc.equals(tkFkk.wftzgbmc) : tkFkk.wftzgbmc != null) return false;
        if (xzqh != null ? !xzqh.equals(tkFkk.xzqh) : tkFkk.xzqh != null) return false;
        if (yzbm != null ? !yzbm.equals(tkFkk.yzbm) : tkFkk.yzbm != null) return false;
        if (zch != null ? !zch.equals(tkFkk.zch) : tkFkk.zch != null) return false;
        if (zczj != null ? !zczj.equals(tkFkk.zczj) : tkFkk.zczj != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        Integer result = 0;
        result = 31 * result + lsh;
        result = 31 * result + (cshsj != null ? cshsj.hashCode() : 0);
        result = 31 * result + (operatenum != null ? operatenum.hashCode() : 0);
        result = 31 * result + (jgdm != null ? jgdm.hashCode() : 0);
        result = 31 * result + (jgmc != null ? jgmc.hashCode() : 0);
        result = 31 * result + (bfjgmc != null ? bfjgmc.hashCode() : 0);
        result = 31 * result + (fksj != null ? fksj.hashCode() : 0);
        result = 31 * result + (jglx != null ? jglx.hashCode() : 0);
        result = 31 * result + (jglxmc != null ? jglxmc.hashCode() : 0);
        result = 31 * result + (fddbr != null ? fddbr.hashCode() : 0);
        result = 31 * result + (xzqh != null ? xzqh.hashCode() : 0);
        result = 31 * result + (jgdz != null ? jgdz.hashCode() : 0);
        result = 31 * result + (yzbm != null ? yzbm.hashCode() : 0);
        result = 31 * result + (dhhm != null ? dhhm.hashCode() : 0);
        result = 31 * result + (zczj != null ? zczj.hashCode() : 0);
        result = 31 * result + (hbzl != null ? hbzl.hashCode() : 0);
        result = 31 * result + (hbzlmc != null ? hbzlmc.hashCode() : 0);
        result = 31 * result + (jjlx != null ? jjlx.hashCode() : 0);
        result = 31 * result + (jjlxmc != null ? jjlxmc.hashCode() : 0);
        result = 31 * result + (wftzgb != null ? wftzgb.hashCode() : 0);
        result = 31 * result + (wftzgbmc != null ? wftzgbmc.hashCode() : 0);
        result = 31 * result + (njrq != null ? njrq.hashCode() : 0);
        result = 31 * result + (njqx != null ? njqx.hashCode() : 0);
        result = 31 * result + (zch != null ? zch.hashCode() : 0);
        result = 31 * result + (flag != null ? flag.hashCode() : 0);
        result = 31 * result + (lastdate != null ? lastdate.hashCode() : 0);
        return result;
    }
}
