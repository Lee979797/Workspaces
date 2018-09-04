package com.ninemax.tygs.model;
// default package

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * TDmsjId entity. @author MyEclipse Persistence Tools
 */
@javax.persistence.Table(name = "t_dmsj_qd")
@Entity
public class TDmsj   {

	// Fields

	 private Integer id;
     private String bzdwdm;
     private String bzdwmc;
     private String zzh;
     private String zzmc;
     private Date gxrq;
     private Date hzsj;
     private Date xcgxrq;
     private String zzsyzdm;
     private String zzsyzmc;
     private String yxxbs;
     private String zzfj;
     private Date fstime;
     private String fsflag;
     private String appid;
     private String businessid;
     private String lsh;
     private String yfm;
     private Date hqtime;
     private String tydm;
	// Constructors



	// Property accessors

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="bzdwdm", length=6)

    public String getBzdwdm() {
        return this.bzdwdm;
    }
    
    public void setBzdwdm(String bzdwdm) {
        this.bzdwdm = bzdwdm;
    }

    @Column(name="bzdwmc", length=400)

    public String getBzdwmc() {
        return this.bzdwmc;
    }
    
    public void setBzdwmc(String bzdwmc) {
        this.bzdwmc = bzdwmc;
    }

    @Column(name="zzh", length=20)

    public String getZzh() {
        return this.zzh;
    }
    
    public void setZzh(String zzh) {
        this.zzh = zzh;
    }

    @Column(name="zzmc", length=100)

    public String getZzmc() {
        return this.zzmc;
    }
    
    public void setZzmc(String zzmc) {
        this.zzmc = zzmc;
    }

    @Column(name="gxrq", length=23)

    public Date getGxrq() {
        return this.gxrq;
    }
    
    public void setGxrq(Date gxrq) {
        this.gxrq = gxrq;
    }

    @Column(name="hzsj", length=23)

    public Date getHzsj() {
        return this.hzsj;
    }
    
    public void setHzsj(Date hzsj) {
        this.hzsj = hzsj;
    }

    @Column(name="xcgxrq", length=23)

    public Date getXcgxrq() {
        return this.xcgxrq;
    }
     
    public void setXcgxrq(Date xcgxrq) {
        this.xcgxrq = xcgxrq;
    }

    @Column(name="zzsyzdm", length=18)

    public String getZzsyzdm() {
        return this.zzsyzdm;
    }
    
    public void setZzsyzdm(String zzsyzdm) {
        this.zzsyzdm = zzsyzdm;
    }

    @Column(name="zzsyzmc", length=400)

    public String getZzsyzmc() {
        return this.zzsyzmc;
    }
    
    public void setZzsyzmc(String zzsyzmc) {
        this.zzsyzmc = zzsyzmc;
    }

    @Column(name="yxxbs", length=1)

    public String getYxxbs() {
        return this.yxxbs;
    }
    
    public void setYxxbs(String yxxbs) {
        this.yxxbs = yxxbs;
    }

    @Column(name="zzfj", length=500)

    public String getZzfj() {
        return this.zzfj;
    }
    
    public void setZzfj(String zzfj) {
        this.zzfj = zzfj;
    }

    @Column(name="fstime", length=23)

    public Date getFstime() {
        return this.fstime;
    }
    
    public void setFstime(Date fstime) {
        this.fstime = fstime;
    }

    @Column(name="fsflag", length=1)

    public String getFsflag() {
        return this.fsflag;
    }
    
    public void setFsflag(String fsflag) {
        this.fsflag = fsflag;
    }

    @Column(name="appid", length=100)

    public String getAppid() {
        return this.appid;
    }
    
    public void setAppid(String appid) {
        this.appid = appid;
    }

    @Column(name="businessid", length=50)

    public String getBusinessid() {
        return this.businessid;
    }
    
    public void setBusinessid(String businessid) {
        this.businessid = businessid;
    }

    @Column(name="lsh", length=100)

    public String getLsh() {
        return this.lsh;
    }
    
    public void setLsh(String lsh) {
        this.lsh = lsh;
    }

    @Column(name="yfm", length=9)

    public String getYfm() {
        return this.yfm;
    }
    
    public void setYfm(String yfm) {
        this.yfm = yfm;
    }

    @Column(name="hqtime", length=23)

    public Date getHqtime() {
        return this.hqtime;
    }
    
    public void setHqtime(Date hqtime) {
        this.hqtime = hqtime;
    }

    @Column(name="tydm", length=18)

    public String getTydm() {
        return this.tydm;
    }
    
    public void setTydm(String tydm) {
        this.tydm = tydm;
    }
   
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TDmsj))
			return false;
		TDmsj castOther = (TDmsj) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getBzdwdm() == castOther.getBzdwdm()) || (this
						.getBzdwdm() != null
						&& castOther.getBzdwdm() != null && this.getBzdwdm()
						.equals(castOther.getBzdwdm())))
				&& ((this.getBzdwmc() == castOther.getBzdwmc()) || (this
						.getBzdwmc() != null
						&& castOther.getBzdwmc() != null && this.getBzdwmc()
						.equals(castOther.getBzdwmc())))
				&& ((this.getZzh() == castOther.getZzh()) || (this.getZzh() != null
						&& castOther.getZzh() != null && this.getZzh().equals(
						castOther.getZzh())))
				&& ((this.getZzmc() == castOther.getZzmc()) || (this.getZzmc() != null
						&& castOther.getZzmc() != null && this.getZzmc()
						.equals(castOther.getZzmc())))
				&& ((this.getGxrq() == castOther.getGxrq()) || (this.getGxrq() != null
						&& castOther.getGxrq() != null && this.getGxrq()
						.equals(castOther.getGxrq())))
				&& ((this.getHzsj() == castOther.getHzsj()) || (this.getHzsj() != null
						&& castOther.getHzsj() != null && this.getHzsj()
						.equals(castOther.getHzsj())))
				&& ((this.getXcgxrq() == castOther.getXcgxrq()) || (this
						.getXcgxrq() != null
						&& castOther.getXcgxrq() != null && this.getXcgxrq()
						.equals(castOther.getXcgxrq())))
				&& ((this.getZzsyzdm() == castOther.getZzsyzdm()) || (this
						.getZzsyzdm() != null
						&& castOther.getZzsyzdm() != null && this.getZzsyzdm()
						.equals(castOther.getZzsyzdm())))
				&& ((this.getZzsyzmc() == castOther.getZzsyzmc()) || (this
						.getZzsyzmc() != null
						&& castOther.getZzsyzmc() != null && this.getZzsyzmc()
						.equals(castOther.getZzsyzmc())))
				&& ((this.getYxxbs() == castOther.getYxxbs()) || (this
						.getYxxbs() != null
						&& castOther.getYxxbs() != null && this.getYxxbs()
						.equals(castOther.getYxxbs())))
				&& ((this.getZzfj() == castOther.getZzfj()) || (this.getZzfj() != null
						&& castOther.getZzfj() != null && this.getZzfj()
						.equals(castOther.getZzfj())))
				&& ((this.getFstime() == castOther.getFstime()) || (this
						.getFstime() != null
						&& castOther.getFstime() != null && this.getFstime()
						.equals(castOther.getFstime())))
				&& ((this.getFsflag() == castOther.getFsflag()) || (this
						.getFsflag() != null
						&& castOther.getFsflag() != null && this.getFsflag()
						.equals(castOther.getFsflag())))
				&& ((this.getAppid() == castOther.getAppid()) || (this
						.getAppid() != null
						&& castOther.getAppid() != null && this.getAppid()
						.equals(castOther.getAppid())))
				&& ((this.getBusinessid() == castOther.getBusinessid()) || (this
						.getBusinessid() != null
						&& castOther.getBusinessid() != null && this
						.getBusinessid().equals(castOther.getBusinessid())))
				&& ((this.getLsh() == castOther.getLsh()) || (this.getLsh() != null
						&& castOther.getLsh() != null && this.getLsh().equals(
						castOther.getLsh())))
				&& ((this.getYfm() == castOther.getYfm()) || (this.getYfm() != null
						&& castOther.getYfm() != null && this.getYfm().equals(
						castOther.getYfm())))
				&& ((this.getHqtime() == castOther.getHqtime()) || (this
						.getHqtime() != null
						&& castOther.getHqtime() != null && this.getHqtime()
						.equals(castOther.getHqtime())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result
				+ (getBzdwdm() == null ? 0 : this.getBzdwdm().hashCode());
		result = 37 * result
				+ (getBzdwmc() == null ? 0 : this.getBzdwmc().hashCode());
		result = 37 * result
				+ (getZzh() == null ? 0 : this.getZzh().hashCode());
		result = 37 * result
				+ (getZzmc() == null ? 0 : this.getZzmc().hashCode());
		result = 37 * result
				+ (getGxrq() == null ? 0 : this.getGxrq().hashCode());
		result = 37 * result
				+ (getHzsj() == null ? 0 : this.getHzsj().hashCode());
		result = 37 * result
				+ (getXcgxrq() == null ? 0 : this.getXcgxrq().hashCode());
		result = 37 * result
				+ (getZzsyzdm() == null ? 0 : this.getZzsyzdm().hashCode());
		result = 37 * result
				+ (getZzsyzmc() == null ? 0 : this.getZzsyzmc().hashCode());
		result = 37 * result
				+ (getYxxbs() == null ? 0 : this.getYxxbs().hashCode());
		result = 37 * result
				+ (getZzfj() == null ? 0 : this.getZzfj().hashCode());
		result = 37 * result
				+ (getFstime() == null ? 0 : this.getFstime().hashCode());
		result = 37 * result
				+ (getFsflag() == null ? 0 : this.getFsflag().hashCode());
		result = 37 * result
				+ (getAppid() == null ? 0 : this.getAppid().hashCode());
		result = 37
				* result
				+ (getBusinessid() == null ? 0 : this.getBusinessid()
						.hashCode());
		result = 37 * result
				+ (getLsh() == null ? 0 : this.getLsh().hashCode());
		result = 37 * result
				+ (getYfm() == null ? 0 : this.getYfm().hashCode());
		result = 37 * result
				+ (getHqtime() == null ? 0 : this.getHqtime().hashCode());
		return result;
	}

}