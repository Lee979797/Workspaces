package com.ninemax.jpa.code.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-6-26
 * Time: ÏÂÎç2:22
 * To change this template use File | Settings | File Templates.
 */
@Table(name = "tk_xgk")
@Entity
public class TkXgk {
    private Integer lsh;

    @Column(name = "lsh")
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer getLsh() {
        return lsh;
    }

    public void setLsh(Integer lsh) {
        this.lsh = lsh;
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

    private Long kxlh;

    @Column(name = "kxlh")
    @Basic
    public Long getKxlh() {
        return kxlh;
    }

    public void setKxlh(Long kxlh) {
        this.kxlh = kxlh;
    }

    private Date xgsj;

    @Column(name = "xgsj")
    @Basic
    public Date getXgsj() {
        return xgsj;
    }

    public void setXgsj(Date xgsj) {
        this.xgsj = xgsj;
    }

    private String operater;

    @Column(name = "operater")
    @Basic
    public String getOperater() {
        return operater;
    }

    public void setOperater(String operater) {
        this.operater = operater;
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

    private String bfjgmc;

    @Column(name = "bfjgmc")
    @Basic
    public String getBfjgmc() {
        return bfjgmc;
    }

    public void setBfjgmc(String bfjgmc) {
        this.bfjgmc = bfjgmc;
    }

    private Date fksj;

    @Column(name = "fksj")
    @Basic
    public Date getFksj() {
        return fksj;
    }

    public void setFksj(Date fksj) {
        this.fksj = fksj;
    }

    private String jglx;

    @Column(name = "jglx")
    @Basic
    public String getJglx() {
        return jglx;
    }

    public void setJglx(String jglx) {
        this.jglx = jglx;
    }

    private String jglxmc;

    @Column(name = "jglxmc")
    @Basic
    public String getJglxmc() {
        return jglxmc;
    }

    public void setJglxmc(String jglxmc) {
        this.jglxmc = jglxmc;
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

    private String xzqh;

    @Column(name = "xzqh")
    @Basic
    public String getXzqh() {
        return xzqh;
    }

    public void setXzqh(String xzqh) {
        this.xzqh = xzqh;
    }

    private String jgdz;

    @Column(name = "jgdz")
    @Basic
    public String getJgdz() {
        return jgdz;
    }

    public void setJgdz(String jgdz) {
        this.jgdz = jgdz;
    }

    private String yzbm;

    @Column(name = "yzbm")
    @Basic
    public String getYzbm() {
        return yzbm;
    }

    public void setYzbm(String yzbm) {
        this.yzbm = yzbm;
    }

    private String dhhm;

    @Column(name = "dhhm")
    @Basic
    public String getDhhm() {
        return dhhm;
    }

    public void setDhhm(String dhhm) {
        this.dhhm = dhhm;
    }

    private Double zczj;

    @Column(name = "zczj")
    @Basic
    public Double getZczj() {
        return zczj;
    }

    public void setZczj(Double zczj) {
        this.zczj = zczj;
    }

    private String hbzl;

    @Column(name = "hbzl")
    @Basic
    public String getHbzl() {
        return hbzl;
    }

    public void setHbzl(String hbzl) {
        this.hbzl = hbzl;
    }

    private String hbzlmc;

    @Column(name = "hbzlmc")
    @Basic
    public String getHbzlmc() {
        return hbzlmc;
    }

    public void setHbzlmc(String hbzlmc) {
        this.hbzlmc = hbzlmc;
    }

    private String jjlx;

    @Column(name = "jjlx")
    @Basic
    public String getJjlx() {
        return jjlx;
    }

    public void setJjlx(String jjlx) {
        this.jjlx = jjlx;
    }

    private String jjlxmc;

    @Column(name = "jjlxmc")
    @Basic
    public String getJjlxmc() {
        return jjlxmc;
    }

    public void setJjlxmc(String jjlxmc) {
        this.jjlxmc = jjlxmc;
    }

    private String wftzgb;

    @Column(name = "wftzgb")
    @Basic
    public String getWftzgb() {
        return wftzgb;
    }

    public void setWftzgb(String wftzgb) {
        this.wftzgb = wftzgb;
    }

    private String wftzgbmc;

    @Column(name = "wftzgbmc")
    @Basic
    public String getWftzgbmc() {
        return wftzgbmc;
    }

    public void setWftzgbmc(String wftzgbmc) {
        this.wftzgbmc = wftzgbmc;
    }

    private Date njrq;

    @Column(name = "njrq")
    @Basic
    public Date getNjrq() {
        return njrq;
    }

    public void setNjrq(Date njrq) {
        this.njrq = njrq;
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

    private String zch;

    @Column(name = "zch")
    @Basic
    public String getZch() {
        return zch;
    }

    public void setZch(String zch) {
        this.zch = zch;
    }

    private String flag;

    @Column(name = "flag")
    @Basic
    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TkXgk tkXgk = (TkXgk) o;

        if (bfjgmc != null ? !bfjgmc.equals(tkXgk.bfjgmc) : tkXgk.bfjgmc != null) return false;
        if (dhhm != null ? !dhhm.equals(tkXgk.dhhm) : tkXgk.dhhm != null) return false;
        if (fddbr != null ? !fddbr.equals(tkXgk.fddbr) : tkXgk.fddbr != null) return false;
        if (fksj != null ? !fksj.equals(tkXgk.fksj) : tkXgk.fksj != null) return false;
        if (flag != null ? !flag.equals(tkXgk.flag) : tkXgk.flag != null) return false;
        if (hbzl != null ? !hbzl.equals(tkXgk.hbzl) : tkXgk.hbzl != null) return false;
        if (hbzlmc != null ? !hbzlmc.equals(tkXgk.hbzlmc) : tkXgk.hbzlmc != null) return false;
        if (jgdm != null ? !jgdm.equals(tkXgk.jgdm) : tkXgk.jgdm != null) return false;
        if (jgdz != null ? !jgdz.equals(tkXgk.jgdz) : tkXgk.jgdz != null) return false;
        if (jglx != null ? !jglx.equals(tkXgk.jglx) : tkXgk.jglx != null) return false;
        if (jglxmc != null ? !jglxmc.equals(tkXgk.jglxmc) : tkXgk.jglxmc != null) return false;
        if (jgmc != null ? !jgmc.equals(tkXgk.jgmc) : tkXgk.jgmc != null) return false;
        if (jjlx != null ? !jjlx.equals(tkXgk.jjlx) : tkXgk.jjlx != null) return false;
        if (jjlxmc != null ? !jjlxmc.equals(tkXgk.jjlxmc) : tkXgk.jjlxmc != null) return false;
        if (kxlh != null ? !kxlh.equals(tkXgk.kxlh) : tkXgk.kxlh != null) return false;
        if (lsh != null ? !lsh.equals(tkXgk.lsh) : tkXgk.lsh != null) return false;
        if (njqx != null ? !njqx.equals(tkXgk.njqx) : tkXgk.njqx != null) return false;
        if (njrq != null ? !njrq.equals(tkXgk.njrq) : tkXgk.njrq != null) return false;
        if (operater != null ? !operater.equals(tkXgk.operater) : tkXgk.operater != null) return false;
        if (wftzgb != null ? !wftzgb.equals(tkXgk.wftzgb) : tkXgk.wftzgb != null) return false;
        if (wftzgbmc != null ? !wftzgbmc.equals(tkXgk.wftzgbmc) : tkXgk.wftzgbmc != null) return false;
        if (xgsj != null ? !xgsj.equals(tkXgk.xgsj) : tkXgk.xgsj != null) return false;
        if (xzqh != null ? !xzqh.equals(tkXgk.xzqh) : tkXgk.xzqh != null) return false;
        if (yzbm != null ? !yzbm.equals(tkXgk.yzbm) : tkXgk.yzbm != null) return false;
        if (zch != null ? !zch.equals(tkXgk.zch) : tkXgk.zch != null) return false;
        if (zczj != null ? !zczj.equals(tkXgk.zczj) : tkXgk.zczj != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lsh != null ? lsh.hashCode() : 0;
        result = 31 * result + (jgdm != null ? jgdm.hashCode() : 0);
        result = 31 * result + (kxlh != null ? kxlh.hashCode() : 0);
        result = 31 * result + (xgsj != null ? xgsj.hashCode() : 0);
        result = 31 * result + (operater != null ? operater.hashCode() : 0);
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
        return result;
    }
}
