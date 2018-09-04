package com.ninemax.jpa.code.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-5-23
 * Time: ÉÏÎç10:03
 */
@Table(name = "t_zs")
@Entity
public class TZs {
    private long lsh;

    @Column(name = "lsh")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getLsh() {
        return lsh;
    }

    public void setLsh(long lsh) {
        this.lsh = lsh;
    }

    private String jgdm;

    @Column(name = "jgdm", nullable = true, insertable = true, updatable = true, length = 9, precision = 0)
    @Basic
    public String getJgdm() {
        return jgdm;
    }

    public void setJgdm(String jgdm) {
        this.jgdm = jgdm;
    }

    private String jglx;

    @Column(name = "jglx", nullable = true, insertable = true, updatable = true, length = 1, precision = 0)
    @Basic
    public String getJglx() {
        return jglx;
    }

    public void setJglx(String jglx) {
        this.jglx = jglx;
    }

    private String jgmc;

    @Column(name = "jgmc", nullable = true, insertable = true, updatable = true, length = 120, precision = 0)
    @Basic
    public String getJgmc() {
        return jgmc;
    }

    public void setJgmc(String jgmc) {
        this.jgmc = jgmc;
    }

    private String jgdz;

    @Column(name = "jgdz", nullable = true, insertable = true, updatable = true, length = 120, precision = 0)
    @Basic
    public String getJgdz() {
        return jgdz;
    }

    public void setJgdz(String jgdz) {
        this.jgdz = jgdz;
    }

    private String yxq;

    @Column(name = "yxq", nullable = true, insertable = true, updatable = true, length = 36, precision = 0)
    @Basic
    public String getYxq() {
        return yxq;
    }

    public void setYxq(String yxq) {
        this.yxq = yxq;
    }

    private String bzjgdm;

    @Column(name = "bzjgdm", nullable = true, insertable = true, updatable = true, length = 6, precision = 0)
    @Basic
    public String getBzjgdm() {
        return bzjgdm;
    }

    public void setBzjgdm(String bzjgdm) {
        this.bzjgdm = bzjgdm;
    }

    private String bzjgmc;

    @Column(name = "bzjgmc", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String getBzjgmc() {
        return bzjgmc;
    }

    public void setBzjgmc(String bzjgmc) {
        this.bzjgmc = bzjgmc;
    }

    private Date fzsj;

    @Column(name = "fzsj", nullable = true, insertable = true, updatable = true, length = 23, precision = 3)
    @Basic
    public Date getFzsj() {
        return fzsj;
    }

    public void setFzsj(Date fzsj) {
        this.fzsj = fzsj;
    }

    private String djh;

    @Column(name = "djh", nullable = true, insertable = true, updatable = true, length = 25, precision = 0)
    @Basic
    public String getDjh() {
        return djh;
    }

    public void setDjh(String djh) {
        this.djh = djh;
    }

    private String zslsh;

    @Column(name = "zslsh", nullable = true, insertable = true, updatable = true, length = 6, precision = 0)
    @Basic
    public String getZslsh() {
        return zslsh;
    }

    public void setZslsh(String zslsh) {
        this.zslsh = zslsh;
    }

    private String zstype;

    @Column(name = "zstype", nullable = true, insertable = true, updatable = true, length = 1, precision = 0)
    @Basic
    public String getZstype() {
        return zstype;
    }

    public void setZstype(String zstype) {
        this.zstype = zstype;
    }

    private String fzr;

    @Column(name = "fzr", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public String getFzr() {
        return fzr;
    }

    public void setFzr(String fzr) {
        this.fzr = fzr;
    }

    private String flag;

    @Column(name = "flag", nullable = true, insertable = true, updatable = true, length = 1, precision = 0)
    @Basic
    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    private String zsbh;

    @Column(name = "zsbh", nullable = true, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    public String getZsbh() {
        return zsbh;
    }

    public void setZsbh(String zsbh) {
        this.zsbh = zsbh;
    }

    private Date lastdate;

    @Column(name = "lastdate", nullable = true, insertable = true, updatable = true, length = 23, precision = 3)
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

        TZs tZs = (TZs) o;

        if (lsh != tZs.lsh) return false;
        if (bzjgdm != null ? !bzjgdm.equals(tZs.bzjgdm) : tZs.bzjgdm != null) return false;
        if (bzjgmc != null ? !bzjgmc.equals(tZs.bzjgmc) : tZs.bzjgmc != null) return false;
        if (djh != null ? !djh.equals(tZs.djh) : tZs.djh != null) return false;
        if (flag != null ? !flag.equals(tZs.flag) : tZs.flag != null) return false;
        if (fzr != null ? !fzr.equals(tZs.fzr) : tZs.fzr != null) return false;
        if (fzsj != null ? !fzsj.equals(tZs.fzsj) : tZs.fzsj != null) return false;
        if (jgdm != null ? !jgdm.equals(tZs.jgdm) : tZs.jgdm != null) return false;
        if (jgdz != null ? !jgdz.equals(tZs.jgdz) : tZs.jgdz != null) return false;
        if (jglx != null ? !jglx.equals(tZs.jglx) : tZs.jglx != null) return false;
        if (jgmc != null ? !jgmc.equals(tZs.jgmc) : tZs.jgmc != null) return false;
        if (lastdate != null ? !lastdate.equals(tZs.lastdate) : tZs.lastdate != null) return false;
        if (yxq != null ? !yxq.equals(tZs.yxq) : tZs.yxq != null) return false;
        if (zsbh != null ? !zsbh.equals(tZs.zsbh) : tZs.zsbh != null) return false;
        if (zslsh != null ? !zslsh.equals(tZs.zslsh) : tZs.zslsh != null) return false;
        if (zstype != null ? !zstype.equals(tZs.zstype) : tZs.zstype != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (lsh ^ (lsh >>> 32));
        result = 31 * result + (jgdm != null ? jgdm.hashCode() : 0);
        result = 31 * result + (jglx != null ? jglx.hashCode() : 0);
        result = 31 * result + (jgmc != null ? jgmc.hashCode() : 0);
        result = 31 * result + (jgdz != null ? jgdz.hashCode() : 0);
        result = 31 * result + (yxq != null ? yxq.hashCode() : 0);
        result = 31 * result + (bzjgdm != null ? bzjgdm.hashCode() : 0);
        result = 31 * result + (bzjgmc != null ? bzjgmc.hashCode() : 0);
        result = 31 * result + (fzsj != null ? fzsj.hashCode() : 0);
        result = 31 * result + (djh != null ? djh.hashCode() : 0);
        result = 31 * result + (zslsh != null ? zslsh.hashCode() : 0);
        result = 31 * result + (zstype != null ? zstype.hashCode() : 0);
        result = 31 * result + (fzr != null ? fzr.hashCode() : 0);
        result = 31 * result + (flag != null ? flag.hashCode() : 0);
        result = 31 * result + (zsbh != null ? zsbh.hashCode() : 0);
        result = 31 * result + (lastdate != null ? lastdate.hashCode() : 0);
        return result;
    }
}
