package com.ninemax.jpa.code.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-10-10
 * Time: ÏÂÎç4:36
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "t_jgdm_cysh")
@Entity
public class TJgdmCysh {
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

    private String jglx;

    @javax.persistence.Column(name = "jglx")
    @Basic
    public String getJglx() {
        return jglx;
    }

    public void setJglx(String jglx) {
        this.jglx = jglx;
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

    private String zjlx;

    @javax.persistence.Column(name = "zjlx")
    @Basic
    public String getZjlx() {
        return zjlx;
    }

    public void setZjlx(String zjlx) {
        this.zjlx = zjlx;
    }

    private String zjhm;

    @javax.persistence.Column(name = "zjhm")
    @Basic
    public String getZjhm() {
        return zjhm;
    }

    public void setZjhm(String zjhm) {
        this.zjhm = zjhm;
    }

    private String jyfw;

    @javax.persistence.Column(name = "jyfw")
    @Basic
    public String getJyfw() {
        return jyfw;
    }

    public void setJyfw(String jyfw) {
        this.jyfw = jyfw;
    }

    private String jjhy;

    @javax.persistence.Column(name = "jjhy")
    @Basic
    public String getJjhy() {
        return jjhy;
    }

    public void setJjhy(String jjhy) {
        this.jjhy = jjhy;
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

    private Date zcrq;

    @javax.persistence.Column(name = "zcrq")
    @Basic
    public Date getZcrq() {
        return zcrq;
    }

    public void setZcrq(Date zcrq) {
        this.zcrq = zcrq;
    }

    private String zgdm;

    @javax.persistence.Column(name = "zgdm")
    @Basic
    public String getZgdm() {
        return zgdm;
    }

    public void setZgdm(String zgdm) {
        this.zgdm = zgdm;
    }

    private String pzjgdm;

    @javax.persistence.Column(name = "pzjgdm")
    @Basic
    public String getPzjgdm() {
        return pzjgdm;
    }

    public void setPzjgdm(String pzjgdm) {
        this.pzjgdm = pzjgdm;
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

    private String bzjgdm;

    @javax.persistence.Column(name = "bzjgdm")
    @Basic
    public String getBzjgdm() {
        return bzjgdm;
    }

    public void setBzjgdm(String bzjgdm) {
        this.bzjgdm = bzjgdm;
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

    private String wftzgb;

    @javax.persistence.Column(name = "wftzgb")
    @Basic
    public String getWftzgb() {
        return wftzgb;
    }

    public void setWftzgb(String wftzgb) {
        this.wftzgb = wftzgb;
    }

    private Integer zgrs;

    @javax.persistence.Column(name = "zgrs")
    @Basic
    public Integer getZgrs() {
        return zgrs;
    }

    public void setZgrs(Integer zgrs) {
        this.zgrs = zgrs;
    }

    private Date bgrq;

    @javax.persistence.Column(name = "bgrq")
    @Basic
    public Date getBgrq() {
        return bgrq;
    }

    public void setBgrq(Date bgrq) {
        this.bgrq = bgrq;
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

    private String zgmc;

    @javax.persistence.Column(name = "zgmc")
    @Basic
    public String getZgmc() {
        return zgmc;
    }

    public void setZgmc(String zgmc) {
        this.zgmc = zgmc;
    }

    private String pzjgmc;

    @javax.persistence.Column(name = "pzjgmc")
    @Basic
    public String getPzjgmc() {
        return pzjgmc;
    }

    public void setPzjgmc(String pzjgmc) {
        this.pzjgmc = pzjgmc;
    }

    private String pzwh;

    @javax.persistence.Column(name = "pzwh")
    @Basic
    public String getPzwh() {
        return pzwh;
    }

    public void setPzwh(String pzwh) {
        this.pzwh = pzwh;
    }

    private String gk;

    @javax.persistence.Column(name = "gk")
    @Basic
    public String getGk() {
        return gk;
    }

    public void setGk(String gk) {
        this.gk = gk;
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

    private String njjhy;

    @javax.persistence.Column(name = "njjhy")
    @Basic
    public String getNjjhy() {
        return njjhy;
    }

    public void setNjjhy(String njjhy) {
        this.njjhy = njjhy;
    }

    private String njjlx;

    @javax.persistence.Column(name = "njjlx")
    @Basic
    public String getNjjlx() {
        return njjlx;
    }

    public void setNjjlx(String njjlx) {
        this.njjlx = njjlx;
    }

    private String wtbz;

    @javax.persistence.Column(name = "wtbz")
    @Basic
    public String getWtbz() {
        return wtbz;
    }

    public void setWtbz(String wtbz) {
        this.wtbz = wtbz;
    }

    private String wtbz1;

    @javax.persistence.Column(name = "wtbz1")
    @Basic
    public String getWtbz1() {
        return wtbz1;
    }

    public void setWtbz1(String wtbz1) {
        this.wtbz1 = wtbz1;
    }

    private String wtbz2;

    @javax.persistence.Column(name = "wtbz2")
    @Basic
    public String getWtbz2() {
        return wtbz2;
    }

    public void setWtbz2(String wtbz2) {
        this.wtbz2 = wtbz2;
    }

    private String wtbz3;

    @javax.persistence.Column(name = "wtbz3")
    @Basic
    public String getWtbz3() {
        return wtbz3;
    }

    public void setWtbz3(String wtbz3) {
        this.wtbz3 = wtbz3;
    }

    private String wtbz4;

    @javax.persistence.Column(name = "wtbz4")
    @Basic
    public String getWtbz4() {
        return wtbz4;
    }

    public void setWtbz4(String wtbz4) {
        this.wtbz4 = wtbz4;
    }

    private String wtbz5;

    @javax.persistence.Column(name = "wtbz5")
    @Basic
    public String getWtbz5() {
        return wtbz5;
    }

    public void setWtbz5(String wtbz5) {
        this.wtbz5 = wtbz5;
    }

    private String wtbz6;

    @javax.persistence.Column(name = "wtbz6")
    @Basic
    public String getWtbz6() {
        return wtbz6;
    }

    public void setWtbz6(String wtbz6) {
        this.wtbz6 = wtbz6;
    }

    private String wtbz7;

    @javax.persistence.Column(name = "wtbz7")
    @Basic
    public String getWtbz7() {
        return wtbz7;
    }

    public void setWtbz7(String wtbz7) {
        this.wtbz7 = wtbz7;
    }

    private String wtbz8;

    @javax.persistence.Column(name = "wtbz8")
    @Basic
    public String getWtbz8() {
        return wtbz8;
    }

    public void setWtbz8(String wtbz8) {
        this.wtbz8 = wtbz8;
    }

    private String wtbz9;

    @javax.persistence.Column(name = "wtbz9")
    @Basic
    public String getWtbz9() {
        return wtbz9;
    }

    public void setWtbz9(String wtbz9) {
        this.wtbz9 = wtbz9;
    }

    private String wtbz10;

    @javax.persistence.Column(name = "wtbz10")
    @Basic
    public String getWtbz10() {
        return wtbz10;
    }

    public void setWtbz10(String wtbz10) {
        this.wtbz10 = wtbz10;
    }

    private String zdqzbz;

    @javax.persistence.Column(name = "zdqzbz")
    @Basic
    public String getZdqzbz() {
        return zdqzbz;
    }

    public void setZdqzbz(String zdqzbz) {
        this.zdqzbz = zdqzbz;
    }

    private String sjwtbz;

    @javax.persistence.Column(name = "sjwtbz")
    @Basic
    public String getSjwtbz() {
        return sjwtbz;
    }

    public void setSjwtbz(String sjwtbz) {
        this.sjwtbz = sjwtbz;
    }

    private String dawtbz;

    @javax.persistence.Column(name = "dawtbz")
    @Basic
    public String getDawtbz() {
        return dawtbz;
    }

    public void setDawtbz(String dawtbz) {
        this.dawtbz = dawtbz;
    }

    private String shoper;

    @javax.persistence.Column(name = "shoper")
    @Basic
    public String getShoper() {
        return shoper;
    }

    public void setShoper(String shoper) {
        this.shoper = shoper;
    }

    private String shbz;

    @javax.persistence.Column(name = "shbz")
    @Basic
    public String getShbz() {
        return shbz;
    }

    public void setShbz(String shbz) {
        this.shbz = shbz;
    }

    private String status;

    @javax.persistence.Column(name = "status")
    @Basic
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private Date shdate;

    @javax.persistence.Column(name = "shdate")
    @Basic
    public Date getShdate() {
        return shdate;
    }

    public void setShdate(Date shdate) {
        this.shdate = shdate;
    }

    private Date cydate;

    @javax.persistence.Column(name = "cydate")
    @Basic
    public Date getCydate() {
        return cydate;
    }

    public void setCydate(Date cydate) {
        this.cydate = cydate;
    }

    private String pc;

    @javax.persistence.Column(name = "pc")
    @Basic
    public String getPc() {
        return pc;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }

    private String lry;

    @javax.persistence.Column(name = "lry")
    @Basic
    public String getLry() {
        return lry;
    }

    public void setLry(String lry) {
        this.lry = lry;
    }

    private String njglx;

    @javax.persistence.Column(name = "njglx")
    @Basic
    public String getNjglx() {
        return njglx;
    }

    public void setNjglx(String njglx) {
        this.njglx = njglx;
    }

    private String smr;

    @javax.persistence.Column(name = "smr")
    @Basic
    public String getSmr() {
        return smr;
    }

    public void setSmr(String smr) {
        this.smr = smr;
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

    private String tbrxm;

    @javax.persistence.Column(name = "tbrxm")
    @Basic
    public String getTbrxm() {
        return tbrxm;
    }

    public void setTbrxm(String tbrxm) {
        this.tbrxm = tbrxm;
    }

    private String tbrsfzh;

    @javax.persistence.Column(name = "tbrsfzh")
    @Basic
    public String getTbrsfzh() {
        return tbrsfzh;
    }

    public void setTbrsfzh(String tbrsfzh) {
        this.tbrsfzh = tbrsfzh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TJgdmCysh tJgdmCysh = (TJgdmCysh) o;

        if (bgrq != null ? !bgrq.equals(tJgdmCysh.bgrq) : tJgdmCysh.bgrq != null) return false;
        if (bzjgdm != null ? !bzjgdm.equals(tJgdmCysh.bzjgdm) : tJgdmCysh.bzjgdm != null) return false;
        if (bzrq != null ? !bzrq.equals(tJgdmCysh.bzrq) : tJgdmCysh.bzrq != null) return false;
        if (cydate != null ? !cydate.equals(tJgdmCysh.cydate) : tJgdmCysh.cydate != null) return false;
        if (dawtbz != null ? !dawtbz.equals(tJgdmCysh.dawtbz) : tJgdmCysh.dawtbz != null) return false;
        if (dhhm != null ? !dhhm.equals(tJgdmCysh.dhhm) : tJgdmCysh.dhhm != null) return false;
        if (fddbr != null ? !fddbr.equals(tJgdmCysh.fddbr) : tJgdmCysh.fddbr != null) return false;
        if (gk != null ? !gk.equals(tJgdmCysh.gk) : tJgdmCysh.gk != null) return false;
        if (hbzl != null ? !hbzl.equals(tJgdmCysh.hbzl) : tJgdmCysh.hbzl != null) return false;
        if (jgdm != null ? !jgdm.equals(tJgdmCysh.jgdm) : tJgdmCysh.jgdm != null) return false;
        if (jgdz != null ? !jgdz.equals(tJgdmCysh.jgdz) : tJgdmCysh.jgdz != null) return false;
        if (jglx != null ? !jglx.equals(tJgdmCysh.jglx) : tJgdmCysh.jglx != null) return false;
        if (jgmc != null ? !jgmc.equals(tJgdmCysh.jgmc) : tJgdmCysh.jgmc != null) return false;
        if (jjhy != null ? !jjhy.equals(tJgdmCysh.jjhy) : tJgdmCysh.jjhy != null) return false;
        if (jjlx != null ? !jjlx.equals(tJgdmCysh.jjlx) : tJgdmCysh.jjlx != null) return false;
        if (jyfw != null ? !jyfw.equals(tJgdmCysh.jyfw) : tJgdmCysh.jyfw != null) return false;
        if (lastdate != null ? !lastdate.equals(tJgdmCysh.lastdate) : tJgdmCysh.lastdate != null) return false;
        if (lry != null ? !lry.equals(tJgdmCysh.lry) : tJgdmCysh.lry != null) return false;
        if (njglx != null ? !njglx.equals(tJgdmCysh.njglx) : tJgdmCysh.njglx != null) return false;
        if (njjhy != null ? !njjhy.equals(tJgdmCysh.njjhy) : tJgdmCysh.njjhy != null) return false;
        if (njjlx != null ? !njjlx.equals(tJgdmCysh.njjlx) : tJgdmCysh.njjlx != null) return false;
        if (njqx != null ? !njqx.equals(tJgdmCysh.njqx) : tJgdmCysh.njqx != null) return false;
        if (njrq != null ? !njrq.equals(tJgdmCysh.njrq) : tJgdmCysh.njrq != null) return false;
        if (pc != null ? !pc.equals(tJgdmCysh.pc) : tJgdmCysh.pc != null) return false;
        if (pzjgdm != null ? !pzjgdm.equals(tJgdmCysh.pzjgdm) : tJgdmCysh.pzjgdm != null) return false;
        if (pzjgmc != null ? !pzjgmc.equals(tJgdmCysh.pzjgmc) : tJgdmCysh.pzjgmc != null) return false;
        if (pzwh != null ? !pzwh.equals(tJgdmCysh.pzwh) : tJgdmCysh.pzwh != null) return false;
        if (shbz != null ? !shbz.equals(tJgdmCysh.shbz) : tJgdmCysh.shbz != null) return false;
        if (shdate != null ? !shdate.equals(tJgdmCysh.shdate) : tJgdmCysh.shdate != null) return false;
        if (shoper != null ? !shoper.equals(tJgdmCysh.shoper) : tJgdmCysh.shoper != null) return false;
        if (sjwtbz != null ? !sjwtbz.equals(tJgdmCysh.sjwtbz) : tJgdmCysh.sjwtbz != null) return false;
        if (smr != null ? !smr.equals(tJgdmCysh.smr) : tJgdmCysh.smr != null) return false;
        if (status != null ? !status.equals(tJgdmCysh.status) : tJgdmCysh.status != null) return false;
        if (tbrsfzh != null ? !tbrsfzh.equals(tJgdmCysh.tbrsfzh) : tJgdmCysh.tbrsfzh != null) return false;
        if (tbrxm != null ? !tbrxm.equals(tJgdmCysh.tbrxm) : tJgdmCysh.tbrxm != null) return false;
        if (wftzgb != null ? !wftzgb.equals(tJgdmCysh.wftzgb) : tJgdmCysh.wftzgb != null) return false;
        if (wtbz != null ? !wtbz.equals(tJgdmCysh.wtbz) : tJgdmCysh.wtbz != null) return false;
        if (wtbz1 != null ? !wtbz1.equals(tJgdmCysh.wtbz1) : tJgdmCysh.wtbz1 != null) return false;
        if (wtbz10 != null ? !wtbz10.equals(tJgdmCysh.wtbz10) : tJgdmCysh.wtbz10 != null) return false;
        if (wtbz2 != null ? !wtbz2.equals(tJgdmCysh.wtbz2) : tJgdmCysh.wtbz2 != null) return false;
        if (wtbz3 != null ? !wtbz3.equals(tJgdmCysh.wtbz3) : tJgdmCysh.wtbz3 != null) return false;
        if (wtbz4 != null ? !wtbz4.equals(tJgdmCysh.wtbz4) : tJgdmCysh.wtbz4 != null) return false;
        if (wtbz5 != null ? !wtbz5.equals(tJgdmCysh.wtbz5) : tJgdmCysh.wtbz5 != null) return false;
        if (wtbz6 != null ? !wtbz6.equals(tJgdmCysh.wtbz6) : tJgdmCysh.wtbz6 != null) return false;
        if (wtbz7 != null ? !wtbz7.equals(tJgdmCysh.wtbz7) : tJgdmCysh.wtbz7 != null) return false;
        if (wtbz8 != null ? !wtbz8.equals(tJgdmCysh.wtbz8) : tJgdmCysh.wtbz8 != null) return false;
        if (wtbz9 != null ? !wtbz9.equals(tJgdmCysh.wtbz9) : tJgdmCysh.wtbz9 != null) return false;
        if (xzqh != null ? !xzqh.equals(tJgdmCysh.xzqh) : tJgdmCysh.xzqh != null) return false;
        if (ywlx != null ? !ywlx.equals(tJgdmCysh.ywlx) : tJgdmCysh.ywlx != null) return false;
        if (yzbm != null ? !yzbm.equals(tJgdmCysh.yzbm) : tJgdmCysh.yzbm != null) return false;
        if (zch != null ? !zch.equals(tJgdmCysh.zch) : tJgdmCysh.zch != null) return false;
        if (zcrq != null ? !zcrq.equals(tJgdmCysh.zcrq) : tJgdmCysh.zcrq != null) return false;
        if (zczj != null ? !zczj.equals(tJgdmCysh.zczj) : tJgdmCysh.zczj != null) return false;
        if (zdqzbz != null ? !zdqzbz.equals(tJgdmCysh.zdqzbz) : tJgdmCysh.zdqzbz != null) return false;
        if (zfrq != null ? !zfrq.equals(tJgdmCysh.zfrq) : tJgdmCysh.zfrq != null) return false;
        if (zgdm != null ? !zgdm.equals(tJgdmCysh.zgdm) : tJgdmCysh.zgdm != null) return false;
        if (zgmc != null ? !zgmc.equals(tJgdmCysh.zgmc) : tJgdmCysh.zgmc != null) return false;
        if (zgrs != null ? !zgrs.equals(tJgdmCysh.zgrs) : tJgdmCysh.zgrs != null) return false;
        if (zjhm != null ? !zjhm.equals(tJgdmCysh.zjhm) : tJgdmCysh.zjhm != null) return false;
        if (zjlx != null ? !zjlx.equals(tJgdmCysh.zjlx) : tJgdmCysh.zjlx != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = jgdm != null ? jgdm.hashCode() : 0;
        result = 31 * result + (jgmc != null ? jgmc.hashCode() : 0);
        result = 31 * result + (jglx != null ? jglx.hashCode() : 0);
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
        result = 31 * result + (bzrq != null ? bzrq.hashCode() : 0);
        result = 31 * result + (zfrq != null ? zfrq.hashCode() : 0);
        result = 31 * result + (bzjgdm != null ? bzjgdm.hashCode() : 0);
        result = 31 * result + (zczj != null ? zczj.hashCode() : 0);
        result = 31 * result + (hbzl != null ? hbzl.hashCode() : 0);
        result = 31 * result + (wftzgb != null ? wftzgb.hashCode() : 0);
        result = 31 * result + (zgrs != null ? zgrs.hashCode() : 0);
        result = 31 * result + (bgrq != null ? bgrq.hashCode() : 0);
        result = 31 * result + (njrq != null ? njrq.hashCode() : 0);
        result = 31 * result + (njqx != null ? njqx.hashCode() : 0);
        result = 31 * result + (zch != null ? zch.hashCode() : 0);
        result = 31 * result + (zgmc != null ? zgmc.hashCode() : 0);
        result = 31 * result + (pzjgmc != null ? pzjgmc.hashCode() : 0);
        result = 31 * result + (pzwh != null ? pzwh.hashCode() : 0);
        result = 31 * result + (gk != null ? gk.hashCode() : 0);
        result = 31 * result + (lastdate != null ? lastdate.hashCode() : 0);
        result = 31 * result + (njjhy != null ? njjhy.hashCode() : 0);
        result = 31 * result + (njjlx != null ? njjlx.hashCode() : 0);
        result = 31 * result + (wtbz != null ? wtbz.hashCode() : 0);
        result = 31 * result + (wtbz1 != null ? wtbz1.hashCode() : 0);
        result = 31 * result + (wtbz2 != null ? wtbz2.hashCode() : 0);
        result = 31 * result + (wtbz3 != null ? wtbz3.hashCode() : 0);
        result = 31 * result + (wtbz4 != null ? wtbz4.hashCode() : 0);
        result = 31 * result + (wtbz5 != null ? wtbz5.hashCode() : 0);
        result = 31 * result + (wtbz6 != null ? wtbz6.hashCode() : 0);
        result = 31 * result + (wtbz7 != null ? wtbz7.hashCode() : 0);
        result = 31 * result + (wtbz8 != null ? wtbz8.hashCode() : 0);
        result = 31 * result + (wtbz9 != null ? wtbz9.hashCode() : 0);
        result = 31 * result + (wtbz10 != null ? wtbz10.hashCode() : 0);
        result = 31 * result + (zdqzbz != null ? zdqzbz.hashCode() : 0);
        result = 31 * result + (sjwtbz != null ? sjwtbz.hashCode() : 0);
        result = 31 * result + (dawtbz != null ? dawtbz.hashCode() : 0);
        result = 31 * result + (shoper != null ? shoper.hashCode() : 0);
        result = 31 * result + (shbz != null ? shbz.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (shdate != null ? shdate.hashCode() : 0);
        result = 31 * result + (cydate != null ? cydate.hashCode() : 0);
        result = 31 * result + (pc != null ? pc.hashCode() : 0);
        result = 31 * result + (lry != null ? lry.hashCode() : 0);
        result = 31 * result + (njglx != null ? njglx.hashCode() : 0);
        result = 31 * result + (smr != null ? smr.hashCode() : 0);
        result = 31 * result + (ywlx != null ? ywlx.hashCode() : 0);
        result = 31 * result + (tbrxm != null ? tbrxm.hashCode() : 0);
        result = 31 * result + (tbrsfzh != null ? tbrsfzh.hashCode() : 0);
        return result;
    }
}
