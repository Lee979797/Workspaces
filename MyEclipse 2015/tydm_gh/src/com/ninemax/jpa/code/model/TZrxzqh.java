package com.ninemax.jpa.code.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-9-11
 * Time: ÏÂÎç3:41
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "t_zrxzqh")
@Entity
public class TZrxzqh {
    private String xzqh;

    @javax.persistence.Column(name = "xzqh")
    @Id
    public String getXzqh() {
        return xzqh;
    }

    public void setXzqh(String xzqh) {
        this.xzqh = xzqh;
    }

    private String mc;

    @javax.persistence.Column(name = "mc")
    @Basic
    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
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

    private String jgdm;

    @javax.persistence.Column(name = "jgdm")
    @Basic
    public String getJgdm() {
        return jgdm;
    }

    public void setJgdm(String jgdm) {
        this.jgdm = jgdm;
    }

    private String zdlevel;

    @javax.persistence.Column(name = "zdlevel")
    @Basic
    public String getZdlevel() {
        return zdlevel;
    }

    public void setZdlevel(String zdlevel) {
        this.zdlevel = zdlevel;
    }

    private String sjxzqh;

    @javax.persistence.Column(name = "sjxzqh")
    @Basic
    public String getSjxzqh() {
        return sjxzqh;
    }

    public void setSjxzqh(String sjxzqh) {
        this.sjxzqh = sjxzqh;
    }

    private String fzxzqh;

    @javax.persistence.Column(name = "fzxzqh")
    @Basic
    public String getFzxzqh() {
        return fzxzqh;
    }

    public void setFzxzqh(String fzxzqh) {
        this.fzxzqh = fzxzqh;
    }

    private String dkxzqh;

    @javax.persistence.Column(name = "dkxzqh")
    @Basic
    public String getDkxzqh() {
        return dkxzqh;
    }

    public void setDkxzqh(String dkxzqh) {
        this.dkxzqh = dkxzqh;
    }

    private String dzxzqh;

    @javax.persistence.Column(name = "dzxzqh")
    @Basic
    public String getDzxzqh() {
        return dzxzqh;
    }

    public void setDzxzqh(String dzxzqh) {
        this.dzxzqh = dzxzqh;
    }

    private Integer ywlj;

    @javax.persistence.Column(name = "ywlj")
    @Basic
    public Integer getYwlj() {
        return ywlj;
    }

    public void setYwlj(Integer ywlj) {
        this.ywlj = ywlj;
    }

    private Integer zqywlj;

    @javax.persistence.Column(name = "zqywlj")
    @Basic
    public Integer getZqywlj() {
        return zqywlj;
    }

    public void setZqywlj(Integer zqywlj) {
        this.zqywlj = zqywlj;
    }

    private Integer sbywlj;

    @javax.persistence.Column(name = "sbywlj")
    @Basic
    public Integer getSbywlj() {
        return sbywlj;
    }

    public void setSbywlj(Integer sbywlj) {
        this.sbywlj = sbywlj;
    }

    private String ip;

    @javax.persistence.Column(name = "ip")
    @Basic
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    private String xrcd;

    @javax.persistence.Column(name = "xrcd")
    @Basic
    public String getXrcd() {
        return xrcd;
    }

    public void setXrcd(String xrcd) {
        this.xrcd = xrcd;
    }

    private String fzflag;

    @javax.persistence.Column(name = "fzflag")
    @Basic
    public String getFzflag() {
        return fzflag;
    }

    public void setFzflag(String fzflag) {
        this.fzflag = fzflag;
    }

    private String dkflag;

    @javax.persistence.Column(name = "dkflag")
    @Basic
    public String getDkflag() {
        return dkflag;
    }

    public void setDkflag(String dkflag) {
        this.dkflag = dkflag;
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

    private String lxr;

    @javax.persistence.Column(name = "lxr")
    @Basic
    public String getLxr() {
        return lxr;
    }

    public void setLxr(String lxr) {
        this.lxr = lxr;
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

    private String dz;

    @javax.persistence.Column(name = "dz")
    @Basic
    public String getDz() {
        return dz;
    }

    public void setDz(String dz) {
        this.dz = dz;
    }

    private String dh;

    @javax.persistence.Column(name = "dh")
    @Basic
    public String getDh() {
        return dh;
    }

    public void setDh(String dh) {
        this.dh = dh;
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

    private String reportcode;

    @javax.persistence.Column(name = "reportcode")
    @Basic
    public String getReportcode() {
        return reportcode;
    }

    public void setReportcode(String reportcode) {
        this.reportcode = reportcode;
    }

    private String njfs;

    @javax.persistence.Column(name = "njfs")
    @Basic
    public String getNjfs() {
        return njfs;
    }

    public void setNjfs(String njfs) {
        this.njfs = njfs;
    }

    private String njqsrq;

    @javax.persistence.Column(name = "njqsrq")
    @Basic
    public String getNjqsrq() {
        return njqsrq;
    }

    public void setNjqsrq(String njqsrq) {
        this.njqsrq = njqsrq;
    }

    private String njjzrq;

    @javax.persistence.Column(name = "njjzrq")
    @Basic
    public String getNjjzrq() {
        return njjzrq;
    }

    public void setNjjzrq(String njjzrq) {
        this.njjzrq = njjzrq;
    }

    private String zstg1;

    @javax.persistence.Column(name = "zstg1")
    @Basic
    public String getZstg1() {
        return zstg1;
    }

    public void setZstg1(String zstg1) {
        this.zstg1 = zstg1;
    }

    private String zstg2;

    @javax.persistence.Column(name = "zstg2")
    @Basic
    public String getZstg2() {
        return zstg2;
    }

    public void setZstg2(String zstg2) {
        this.zstg2 = zstg2;
    }

    private Boolean njtsbz;

    @javax.persistence.Column(name = "njtsbz")
    @Basic
    public Boolean getNjtsbz() {
        return njtsbz;
    }

    public void setNjtsbz(Boolean njtsbz) {
        this.njtsbz = njtsbz;
    }

    private String jc;

    @javax.persistence.Column(name = "jc")
    @Basic
    public String getJc() {
        return jc;
    }

    public void setJc(String jc) {
        this.jc = jc;
    }

    private String cfbz;

    @javax.persistence.Column(name = "cfbz")
    @Basic
    public String getCfbz() {
        return cfbz;
    }

    public void setCfbz(String cfbz) {
        this.cfbz = cfbz;
    }

    private String csxzqh;

    @javax.persistence.Column(name = "csxzqh")
    @Basic
    public String getCsxzqh() {
        return csxzqh;
    }

    public void setCsxzqh(String csxzqh) {
        this.csxzqh = csxzqh;
    }

    private Boolean fmflag;

    @javax.persistence.Column(name = "fmflag")
    @Basic
    public Boolean getFmflag() {
        return fmflag;
    }

    public void setFmflag(Boolean fmflag) {
        this.fmflag = fmflag;
    }
    private Boolean smdr;

    @javax.persistence.Column(name = "smdr")
    @Basic
    public Boolean getSmdr() {
        return smdr;
    }

    public void setSmdr(Boolean smdr) {
        this.smdr = smdr;
    }
    private Boolean bzjgflag;

    @javax.persistence.Column(name = "bzjgflag")
    @Basic
    public Boolean getBzjgflag() {
        return bzjgflag;
    }

    public void setBzjgflag(Boolean bzjgflag) {
        this.bzjgflag = bzjgflag;
    }

    private Integer smyq;

    @javax.persistence.Column(name = "smyq")
    @Basic
    public  Integer getSmyq() {
        return smyq;
    }

    public  void setSmyq(Integer smyq) {
        this.smyq = smyq;
    }
    private Integer dayq;

    @javax.persistence.Column(name = "dayq")
    @Basic
    public  Integer getDayq() {
        return dayq;
    }

    public  void setDayq(Integer dayq) {
        this.dayq = dayq;
    }
    private Integer sjyq;

    @javax.persistence.Column(name = "sjyq")
    @Basic
    public  Integer getSjyq() {
        return sjyq;
    }

    public  void setSjyq(Integer sjyq) {
        this.sjyq = sjyq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TZrxzqh zrxzqh = (TZrxzqh) o;

        if (bzjgflag != null ? !bzjgflag.equals(zrxzqh.bzjgflag) : zrxzqh.bzjgflag != null) return false;
        if (cfbz != null ? !cfbz.equals(zrxzqh.cfbz) : zrxzqh.cfbz != null) return false;
        if (csxzqh != null ? !csxzqh.equals(zrxzqh.csxzqh) : zrxzqh.csxzqh != null) return false;
        if (dh != null ? !dh.equals(zrxzqh.dh) : zrxzqh.dh != null) return false;
        if (dkflag != null ? !dkflag.equals(zrxzqh.dkflag) : zrxzqh.dkflag != null) return false;
        if (dkxzqh != null ? !dkxzqh.equals(zrxzqh.dkxzqh) : zrxzqh.dkxzqh != null) return false;
        if (dz != null ? !dz.equals(zrxzqh.dz) : zrxzqh.dz != null) return false;
        if (dzxzqh != null ? !dzxzqh.equals(zrxzqh.dzxzqh) : zrxzqh.dzxzqh != null) return false;
        if (flag != null ? !flag.equals(zrxzqh.flag) : zrxzqh.flag != null) return false;
        if (fmflag != null ? !fmflag.equals(zrxzqh.fmflag) : zrxzqh.fmflag != null) return false;
        if (fzflag != null ? !fzflag.equals(zrxzqh.fzflag) : zrxzqh.fzflag != null) return false;
        if (fzxzqh != null ? !fzxzqh.equals(zrxzqh.fzxzqh) : zrxzqh.fzxzqh != null) return false;
        if (ip != null ? !ip.equals(zrxzqh.ip) : zrxzqh.ip != null) return false;
        if (jc != null ? !jc.equals(zrxzqh.jc) : zrxzqh.jc != null) return false;
        if (jgdm != null ? !jgdm.equals(zrxzqh.jgdm) : zrxzqh.jgdm != null) return false;
        if (jgmc != null ? !jgmc.equals(zrxzqh.jgmc) : zrxzqh.jgmc != null) return false;
        if (lxr != null ? !lxr.equals(zrxzqh.lxr) : zrxzqh.lxr != null) return false;
        if (mc != null ? !mc.equals(zrxzqh.mc) : zrxzqh.mc != null) return false;
        if (njfs != null ? !njfs.equals(zrxzqh.njfs) : zrxzqh.njfs != null) return false;
        if (njjzrq != null ? !njjzrq.equals(zrxzqh.njjzrq) : zrxzqh.njjzrq != null) return false;
        if (njqsrq != null ? !njqsrq.equals(zrxzqh.njqsrq) : zrxzqh.njqsrq != null) return false;
        if (njtsbz != null ? !njtsbz.equals(zrxzqh.njtsbz) : zrxzqh.njtsbz != null) return false;
        if (reportcode != null ? !reportcode.equals(zrxzqh.reportcode) : zrxzqh.reportcode != null) return false;
        if (sbywlj != null ? !sbywlj.equals(zrxzqh.sbywlj) : zrxzqh.sbywlj != null) return false;
        if (sjxzqh != null ? !sjxzqh.equals(zrxzqh.sjxzqh) : zrxzqh.sjxzqh != null) return false;
        if (xrcd != null ? !xrcd.equals(zrxzqh.xrcd) : zrxzqh.xrcd != null) return false;
        if (xzqh != null ? !xzqh.equals(zrxzqh.xzqh) : zrxzqh.xzqh != null) return false;
        if (ywlj != null ? !ywlj.equals(zrxzqh.ywlj) : zrxzqh.ywlj != null) return false;
        if (yzbm != null ? !yzbm.equals(zrxzqh.yzbm) : zrxzqh.yzbm != null) return false;
        if (zdlevel != null ? !zdlevel.equals(zrxzqh.zdlevel) : zrxzqh.zdlevel != null) return false;
        if (zqywlj != null ? !zqywlj.equals(zrxzqh.zqywlj) : zrxzqh.zqywlj != null) return false;
        if (zsbh != null ? !zsbh.equals(zrxzqh.zsbh) : zrxzqh.zsbh != null) return false;
        if (zstg1 != null ? !zstg1.equals(zrxzqh.zstg1) : zrxzqh.zstg1 != null) return false;
        if (zstg2 != null ? !zstg2.equals(zrxzqh.zstg2) : zrxzqh.zstg2 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = xzqh != null ? xzqh.hashCode() : 0;
        result = 31 * result + (mc != null ? mc.hashCode() : 0);
        result = 31 * result + (jgmc != null ? jgmc.hashCode() : 0);
        result = 31 * result + (jgdm != null ? jgdm.hashCode() : 0);
        result = 31 * result + (zdlevel != null ? zdlevel.hashCode() : 0);
        result = 31 * result + (sjxzqh != null ? sjxzqh.hashCode() : 0);
        result = 31 * result + (fzxzqh != null ? fzxzqh.hashCode() : 0);
        result = 31 * result + (dkxzqh != null ? dkxzqh.hashCode() : 0);
        result = 31 * result + (dzxzqh != null ? dzxzqh.hashCode() : 0);
        result = 31 * result + (ywlj != null ? ywlj.hashCode() : 0);
        result = 31 * result + (zqywlj != null ? zqywlj.hashCode() : 0);
        result = 31 * result + (sbywlj != null ? sbywlj.hashCode() : 0);
        result = 31 * result + (ip != null ? ip.hashCode() : 0);
        result = 31 * result + (xrcd != null ? xrcd.hashCode() : 0);
        result = 31 * result + (fzflag != null ? fzflag.hashCode() : 0);
        result = 31 * result + (dkflag != null ? dkflag.hashCode() : 0);
        result = 31 * result + (zsbh != null ? zsbh.hashCode() : 0);
        result = 31 * result + (lxr != null ? lxr.hashCode() : 0);
        result = 31 * result + (yzbm != null ? yzbm.hashCode() : 0);
        result = 31 * result + (dz != null ? dz.hashCode() : 0);
        result = 31 * result + (dh != null ? dh.hashCode() : 0);
        result = 31 * result + (flag != null ? flag.hashCode() : 0);
        result = 31 * result + (reportcode != null ? reportcode.hashCode() : 0);
        result = 31 * result + (njfs != null ? njfs.hashCode() : 0);
        result = 31 * result + (njqsrq != null ? njqsrq.hashCode() : 0);
        result = 31 * result + (njjzrq != null ? njjzrq.hashCode() : 0);
        result = 31 * result + (zstg1 != null ? zstg1.hashCode() : 0);
        result = 31 * result + (zstg2 != null ? zstg2.hashCode() : 0);
        result = 31 * result + (njtsbz != null ? njtsbz.hashCode() : 0);
        result = 31 * result + (jc != null ? jc.hashCode() : 0);
        result = 31 * result + (cfbz != null ? cfbz.hashCode() : 0);
        result = 31 * result + (csxzqh != null ? csxzqh.hashCode() : 0);
        result = 31 * result + (fmflag != null ? fmflag.hashCode() : 0);
        result = 31 * result + (bzjgflag != null ? bzjgflag.hashCode() : 0);
        return result;
    }
}
