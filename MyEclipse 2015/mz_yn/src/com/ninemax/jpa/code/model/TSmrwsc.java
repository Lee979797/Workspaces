package com.ninemax.jpa.code.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author TengWuChao
 *	
 */
@Table(name = "t_smrwsc")
@Entity
public class TSmrwsc {
	 private Integer id;
	    @Column(name = "id", nullable = false, insertable = true, updatable = true, length = 18, precision = 0)
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
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

	    private String jgmc;

	    @Column(name = "jgmc", nullable = true, insertable = true, updatable = true, length = 400, precision = 0)
	    @Basic
	    public String getJgmc() {
	        return jgmc;
	    }

	    public void setJgmc(String jgmc) {
	        this.jgmc = jgmc;
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

	    private String fddbr;

	    @Column(name = "fddbr", nullable = true, insertable = true, updatable = true, length = 100, precision = 0)
	    @Basic
	    public String getFddbr() {
	        return fddbr;
	    }

	    public void setFddbr(String fddbr) {
	        this.fddbr = fddbr;
	    }

	    private String zjhm;

	    @Column(name = "zjhm", nullable = true, insertable = true, updatable = true, length = 42, precision = 0)
	    @Basic
	    public String getZjhm() {
	        return zjhm;
	    }

	    public void setZjhm(String zjhm) {
	        this.zjhm = zjhm;
	    }

	    private String zjlx;

	    @Column(name = "zjlx", nullable = true, insertable = true, updatable = true, length = 2, precision = 0)
	    @Basic
	    public String getZjlx() {
	        return zjlx;
	    }

	    public void setZjlx(String zjlx) {
	        this.zjlx = zjlx;
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

	    private String jjhy;

	    @Column(name = "jjhy", nullable = true, insertable = true, updatable = true, length = 5, precision = 0)
	    @Basic
	    public String getJjhy() {
	        return jjhy;
	    }

	    public void setJjhy(String jjhy) {
	        this.jjhy = jjhy;
	    }

	    private String jjlx;

	    @Column(name = "jjlx", nullable = true, insertable = true, updatable = true, length = 3, precision = 0)
	    @Basic
	    public String getJjlx() {
	        return jjlx;
	    }

	    public void setJjlx(String jjlx) {
	        this.jjlx = jjlx;
	    }

	    private Date zcrq;

	    @Column(name = "zcrq", nullable = true, insertable = true, updatable = true, length = 23, precision = 3)
	    @Basic
	    public Date getZcrq() {
	        return zcrq;
	    }

	    public void setZcrq(Date zcrq) {
	        this.zcrq = zcrq;
	    }

	    private String zgdm;

	    @Column(name = "zgdm", nullable = true, insertable = true, updatable = true, length = 9, precision = 0)
	    @Basic
	    public String getZgdm() {
	        return zgdm;
	    }

	    public void setZgdm(String zgdm) {
	        this.zgdm = zgdm;
	    }

	    private String pzjgdm;

	    @Column(name = "pzjgdm", nullable = true, insertable = true, updatable = true, length = 9, precision = 0)
	    @Basic
	    public String getPzjgdm() {
	        return pzjgdm;
	    }

	    public void setPzjgdm(String pzjgdm) {
	        this.pzjgdm = pzjgdm;
	    }

	    private String xzqh;

	    @Column(name = "xzqh", nullable = true, insertable = true, updatable = true, length = 6, precision = 0)
	    @Basic
	    public String getXzqh() {
	        return xzqh;
	    }

	    public void setXzqh(String xzqh) {
	        this.xzqh = xzqh;
	    }

	    private String jgdz;

	    @Column(name = "jgdz", nullable = true, insertable = true, updatable = true, length = 240, precision = 0)
	    @Basic
	    public String getJgdz() {
	        return jgdz;
	    }

	    public void setJgdz(String jgdz) {
	        this.jgdz = jgdz;
	    }

	    private String yzbm;

	    @Column(name = "yzbm", nullable = true, insertable = true, updatable = true, length = 6, precision = 0)
	    @Basic
	    public String getYzbm() {
	        return yzbm;
	    }

	    public void setYzbm(String yzbm) {
	        this.yzbm = yzbm;
	    }

	    private String dhhm;

	    @Column(name = "dhhm", nullable = true, insertable = true, updatable = true, length = 25, precision = 0)
	    @Basic
	    public String getDhhm() {
	        return dhhm;
	    }

	    public void setDhhm(String dhhm) {
	        this.dhhm = dhhm;
	    }

	    private Date bzrq;

	    @Column(name = "bzrq", nullable = true, insertable = true, updatable = true, length = 23, precision = 3)
	    @Basic
	    public Date getBzrq() {
	        return bzrq;
	    }

	    public void setBzrq(Date bzrq) {
	        this.bzrq = bzrq;
	    }

	    private int zgrs;

	    @Column(name = "zgrs", nullable = true, insertable = true, updatable = true, length = 6, precision = 0)
	    @Basic
	    public int getZgrs() {
	        return zgrs;
	    }

	    public void setZgrs(int zgrs) {
	        this.zgrs = zgrs;
	    }

	    private Date njrq;

	    @Column(name = "njrq", nullable = true, insertable = true, updatable = true, length = 23, precision = 3)
	    @Basic
	    public Date getNjrq() {
	        return njrq;
	    }

	    public void setNjrq(Date njrq) {
	        this.njrq = njrq;
	    }

	    private Date bgrq;

	    @Column(name = "bgrq", nullable = true, insertable = true, updatable = true, length = 23, precision = 3)
	    @Basic
	    public Date getBgrq() {
	        return bgrq;
	    }

	    public void setBgrq(Date bgrq) {
	        this.bgrq = bgrq;
	    }

	    private String zch;

	    @Column(name = "zch", nullable = true, insertable = true, updatable = true, length = 70, precision = 0)
	    @Basic
	    public String getZch() {
	        return zch;
	    }

	    public void setZch(String zch) {
	        this.zch = zch;
	    }

	    private String qzbz;

	    @Column(name = "qzbz", nullable = true, insertable = true, updatable = true, length = 1, precision = 0)
	    @Basic
	    public String getQzbz() {
	        return qzbz;
	    }

	    public void setQzbz(String qzbz) {
	        this.qzbz = qzbz;
	    }

	    private String zgmc;

	    @Column(name = "zgmc", nullable = true, insertable = true, updatable = true, length = 200, precision = 0)
	    @Basic
	    public String getZgmc() {
	        return zgmc;
	    }

	    public void setZgmc(String zgmc) {
	        this.zgmc = zgmc;
	    }

	    private String pzjgmc;

	    @Column(name = "pzjgmc", nullable = true, insertable = true, updatable = true, length = 200, precision = 0)
	    @Basic
	    public String getPzjgmc() {
	        return pzjgmc;
	    }

	    public void setPzjgmc(String pzjgmc) {
	        this.pzjgmc = pzjgmc;
	    }

	    private String pzwh;

	    @Column(name = "pzwh", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
	    @Basic
	    public String getPzwh() {
	        return pzwh;
	    }

	    public void setPzwh(String pzwh) {
	        this.pzwh = pzwh;
	    }

	    private Date pwrq;

	    @Column(name = "pwrq", nullable = true, insertable = true, updatable = true, length = 23, precision = 3)
	    @Basic
	    public Date getPwrq() {
	        return pwrq;
	    }

	    public void setPwrq(Date pwrq) {
	        this.pwrq = pwrq;
	    }

	    private String gk;

	    @Column(name = "gk", nullable = true, insertable = true, updatable = true, length = 1, precision = 0)
	    @Basic
	    public String getGk() {
	        return gk;
	    }

	    public void setGk(String gk) {
	        this.gk = gk;
	    }

	    private String type;

	    @Column(name = "type", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
	    @Basic
	    public String getType() {
	        return type;
	    }

	    public void setType(String type) {
	        this.type = type;
	    }
	    private String czr;

	    @Column(name = "czr", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
	    @Basic
	    public String getCzr() {
	        return czr;
	    }

	    public void setCzr(String czr) {
	        this.czr = czr;
	    }

	    private Date compleTime;

	    @Column(name = "compleTime", nullable = true, insertable = true, updatable = true, length = 23, precision = 3)
	    @Basic
	    public Date getCompleTime() {
	        return compleTime;
	    }

	    public void setCompleTime(Date compleTime) {
	        this.compleTime = compleTime;
	    }

	    private Boolean status;

	    @Column(name = "status", nullable = true, insertable = true, updatable = true, length = 1, precision = 0)
	    @Basic
	    public Boolean getStatus() {
	        return status;
	    }

	    public void setStatus(Boolean status) {
	        this.status = status;
	    }

	    private Date createTime;

	    @Column(name = "createTime", nullable = true, insertable = true, updatable = true, length = 23, precision = 3)
	    @Basic
	    public Date getCreateTime() {
	        return createTime;
	    }

	    public void setCreateTime(Date createTime) {
	        this.createTime = createTime;
	    }

	    private String imagePath;

	    @Column(name = "imagePath", nullable = true, insertable = true, updatable = true, length = 120, precision = 0)
	    @Basic
	    public String getImagePath() {
	        return imagePath;
	    }

	    public void setImagePath(String ImagePath) {
	        this.imagePath = ImagePath;
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;

	        TSmrwsc tSmrw = (TSmrwsc) o;

	        if (id != tSmrw.id) return false;
	        if (status != tSmrw.status) return false;
	        if (zgrs != tSmrw.zgrs) return false;
	        if (bgrq != null ? !bgrq.equals(tSmrw.bgrq) : tSmrw.bgrq != null) return false;
	        if (bzjgdm != null ? !bzjgdm.equals(tSmrw.bzjgdm) : tSmrw.bzjgdm != null) return false;
	        if (bzrq != null ? !bzrq.equals(tSmrw.bzrq) : tSmrw.bzrq != null) return false;
	        if (compleTime != null ? !compleTime.equals(tSmrw.compleTime) : tSmrw.compleTime != null) return false;
	        if (createTime != null ? !createTime.equals(tSmrw.createTime) : tSmrw.createTime != null) return false;
	        if (dhhm != null ? !dhhm.equals(tSmrw.dhhm) : tSmrw.dhhm != null) return false;
	        if (fddbr != null ? !fddbr.equals(tSmrw.fddbr) : tSmrw.fddbr != null) return false;
	        if (gk != null ? !gk.equals(tSmrw.gk) : tSmrw.gk != null) return false;
	        if (imagePath != null ? !imagePath.equals(tSmrw.imagePath) : tSmrw.imagePath != null) return false;
	        if (jgdm != null ? !jgdm.equals(tSmrw.jgdm) : tSmrw.jgdm != null) return false;
	        if (jgdz != null ? !jgdz.equals(tSmrw.jgdz) : tSmrw.jgdz != null) return false;
	        if (jglx != null ? !jglx.equals(tSmrw.jglx) : tSmrw.jglx != null) return false;
	        if (jgmc != null ? !jgmc.equals(tSmrw.jgmc) : tSmrw.jgmc != null) return false;
	        if (jjhy != null ? !jjhy.equals(tSmrw.jjhy) : tSmrw.jjhy != null) return false;
	        if (jjlx != null ? !jjlx.equals(tSmrw.jjlx) : tSmrw.jjlx != null) return false;
	        if (njrq != null ? !njrq.equals(tSmrw.njrq) : tSmrw.njrq != null) return false;
	        if (pwrq != null ? !pwrq.equals(tSmrw.pwrq) : tSmrw.pwrq != null) return false;
	        if (pzjgdm != null ? !pzjgdm.equals(tSmrw.pzjgdm) : tSmrw.pzjgdm != null) return false;
	        if (pzjgmc != null ? !pzjgmc.equals(tSmrw.pzjgmc) : tSmrw.pzjgmc != null) return false;
	        if (pzwh != null ? !pzwh.equals(tSmrw.pzwh) : tSmrw.pzwh != null) return false;
	        if (qzbz != null ? !qzbz.equals(tSmrw.qzbz) : tSmrw.qzbz != null) return false;
	        if (type != null ? !type.equals(tSmrw.type) : tSmrw.type != null) return false;
	        if (xzqh != null ? !xzqh.equals(tSmrw.xzqh) : tSmrw.xzqh != null) return false;
	        if (yzbm != null ? !yzbm.equals(tSmrw.yzbm) : tSmrw.yzbm != null) return false;
	        if (zch != null ? !zch.equals(tSmrw.zch) : tSmrw.zch != null) return false;
	        if (zcrq != null ? !zcrq.equals(tSmrw.zcrq) : tSmrw.zcrq != null) return false;
	        if (zgdm != null ? !zgdm.equals(tSmrw.zgdm) : tSmrw.zgdm != null) return false;
	        if (zgmc != null ? !zgmc.equals(tSmrw.zgmc) : tSmrw.zgmc != null) return false;
	        if (zjhm != null ? !zjhm.equals(tSmrw.zjhm) : tSmrw.zjhm != null) return false;
	        if (zjlx != null ? !zjlx.equals(tSmrw.zjlx) : tSmrw.zjlx != null) return false;

	        return true;
	    }

	    @Override
	    public int hashCode() {
	        int result = id;
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
	        result = 31 * result + zgrs;
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
	        result = 31 * result + (status==null ?0:status? 1 : 0);
	        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
	        result = 31 * result + (imagePath != null ? imagePath.hashCode() : 0);
	        return result;
	    }
}
