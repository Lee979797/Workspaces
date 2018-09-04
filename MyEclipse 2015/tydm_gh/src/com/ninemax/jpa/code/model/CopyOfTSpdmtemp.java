package com.ninemax.jpa.code.model;

// default package

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ninemax.jpa.util.StringUtils;

/**
 * TSpdmtempId entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_spdmtemp")
public class CopyOfTSpdmtemp implements java.io.Serializable {

	// Fields

	private Long lsh;
	private String czreasion;
	private String czyj;
	private String tyshxydm;
    private String jgdm;
    private String jgmc;
    private String jglx;
    private String fddbr;
    private String zjlx;
    private String zjhm;
    private String jyfw;
    private String jjhy2011;
    private String jjlx2011;
    private Date zcrq;
    private String zgdm;
    private String pzjgdm;
    private String xzqh;
    private String jgdz;
    private String yzbm;
    private String dhhm;
    private Date bzrq;
    private Date zfrq;
    private String bzjgdm;
    private Double zczj;
    private String hbzl;
    private Integer zgrs;
    private Date bgrq;
    private String lry;
    private Date njrq;
    private String zch;
    private String zgmc;
    private String pzjgmc;
    private String email;
    private String url;
    private String mobile;
    private Date lastdate;
    private String tbrxm;
    private String tbrsfzh;
    private String tbrlxfs;
    private String jydz;
    private String jyzt;
    private String scjyxzqh;
    private String tbrzjlx;
    private String ywlx;
    private String hsfs;
    private String jhbz;
    private String djxs;
    private String fzxs;
    private String hddy;
    private String jjhlx;
    private String dybz;
    private Integer dwhysl;
    private Integer grhysl;
    private Date yxqxs;
    private String frdhhm;
    private Integer zzrysl;
    private Integer jzrysl;
    private String tbrmobile;
    private String khyh;
    private String kyzh;
    private String isdang;
    private String wjlyy;
    private String dzzlx;
    private String dzzfzr;
    private String dzzfzrzjlx;
    private String dzzfzrzjhm;
    private String djlxr;
    private String djlxrzjlx;
    private String djlxrzjhm;
    private String djlxrdhhm;
    private Date dzzclrq;
    private String sjdzzmc;
    private Integer zzdysl;
    private Integer jzdysl;
    private String memo;
    private String memo1;
    private String memo2;
    private String memo3;
    private String memo4;
    private String memo5;
    private Integer lssl;
    private Integer jssl;
    private Integer cwlssl;



    @Id   
    @javax.persistence.Column(name = "lsh")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getLsh() {
		return this.lsh;
	}


	public void setLsh(Long lsh) {
		this.lsh = lsh;
	}


	@Column(name = "czreason", length = 500)
	public String getCzreasion() {
		return czreasion;
	}

	public void setCzreasion(String czreasion) {
		this.czreasion = czreasion;
	}
	@Column(name = "czyj", length = 500)
	public String getCzyj() {
		return czyj;
	}

	public void setCzyj(String czyj) {
		this.czyj = czyj;
	}
	

	@Column(name = "tyshxydm")

    public String getTyshxydm() {
        return this.tyshxydm;
    }
    
    public void setTyshxydm(String tyshxydm) {
        this.tyshxydm = tyshxydm;
    }
    
    @Column(name="jgdm")

    public String getJgdm() {
        return this.jgdm;
    }
    
    public void setJgdm(String jgdm) {
        this.jgdm = jgdm;
    }
    
    @Column(name="jgmc")

    public String getJgmc() {
        return this.jgmc;
    }
    
    public void setJgmc(String jgmc) {
    	if(!"".equals(jgmc)&&jgmc!=null){
    		this.jgmc = StringUtils.toSBC(jgmc.trim());
    	}else{
    		this.jgmc = jgmc;
    	}
    }
    
    @Column(name="jglx", length=1)

    public String getJglx() {
        return this.jglx;
    }
    
    public void setJglx(String jglx) {
        this.jglx = jglx;
    }
    
    @Column(name="fddbr")

    public String getFddbr() {
        return this.fddbr;
    }
    
    public void setFddbr(String fddbr) {
    	if(!"".equals(fddbr)&&fddbr!=null){
			this.fddbr = StringUtils.toSBC(fddbr.trim());
		}else{
			
			this.fddbr = fddbr;
		}
    }
    
    @Column(name="zjlx", length=2)

    public String getZjlx() {
        return this.zjlx;
    }
    
    public void setZjlx(String zjlx) {
        this.zjlx = zjlx;
    }
    
    @Column(name="zjhm", length=42)

    public String getZjhm() {
        return this.zjhm;
    }
    
    public void setZjhm(String zjhm) {
        this.zjhm = zjhm;
    }
    
    @Column(name="jyfw")

    public String getJyfw() {
        return this.jyfw;
    }
    
    public void setJyfw(String jyfw) {
    	if(!"".equals(jyfw)&&jyfw!=null){
    		this.jyfw = StringUtils.toSBC(jyfw.trim());
    	}else{
    		this.jyfw = jyfw;
    	}
    }
    
    @Column(name="jjhy2011", length=5)

    public String getJjhy2011() {
        return this.jjhy2011;
    }
    
    public void setJjhy2011(String jjhy2011) {
        this.jjhy2011 = jjhy2011;
    }
    
    @Column(name="jjlx2011", length=5)

    public String getJjlx2011() {
        return this.jjlx2011;
    }
    
    public void setJjlx2011(String jjlx2011) {
        this.jjlx2011 = jjlx2011;
    }
    
    @Column(name="zcrq", length=23)

    public Date getZcrq() {
        return this.zcrq;
    }
    
    public void setZcrq(Date zcrq) {
        this.zcrq = zcrq;
    }
    
    @Column(name="zgdm", length=18)

    public String getZgdm() {
        return this.zgdm;
    }
    
    public void setZgdm(String zgdm) {
        this.zgdm = zgdm;
    }
    
    @Column(name="pzjgdm", length=18)

    public String getPzjgdm() {
        return this.pzjgdm;
    }
    
    public void setPzjgdm(String pzjgdm) {
        this.pzjgdm = pzjgdm;
    }
    
    @Column(name="xzqh", length=6)

    public String getXzqh() {
        return this.xzqh;
    }
    
    public void setXzqh(String xzqh) {
        this.xzqh = xzqh;
    }
    
    @Column(name="jgdz")

    public String getJgdz() {
        return this.jgdz;
    }
    
    public void setJgdz(String jgdz) {
    	if(!"".equals(jgdz)&&jgdz!=null){
    		this.jgdz = StringUtils.toSBC(jgdz.trim());
    	}else{
    		
    		this.jgdz = jgdz;
    	}
    }
    
    @Column(name="yzbm", length=6)

    public String getYzbm() {
        return this.yzbm;
    }
    
    public void setYzbm(String yzbm) {
        this.yzbm = yzbm;
    }
    
    @Column(name="dhhm", length=25)

    public String getDhhm() {
        return this.dhhm;
    }
    
    public void setDhhm(String dhhm) {
        this.dhhm = dhhm;
    }
    
    @Column(name="bzrq", length=23)

    public Date getBzrq() {
        return this.bzrq;
    }
    
    public void setBzrq(Date bzrq) {
        this.bzrq = bzrq;
    }
    
    @Column(name="yxqxe", length=23)

    public Date getZfrq() {
        return this.zfrq;
    }
    
    public void setZfrq(Date zfrq) {
        this.zfrq = zfrq;
    }
    
    @Column(name="bzjgdm", length=6)

    public String getBzjgdm() {
        return this.bzjgdm;
    }
    
    public void setBzjgdm(String bzjgdm) {
        this.bzjgdm = bzjgdm;
    }
    
    @Column(name="zczj", precision=14, scale=4)

    public Double getZczj() {
        return this.zczj;
    }
    
    public void setZczj(Double zczj) {
        this.zczj = zczj;
    }
    
    @Column(name="hbzl", length=3)

    public String getHbzl() {
        return this.hbzl;
    }
    
    public void setHbzl(String hbzl) {
        this.hbzl = hbzl;
    }
    
    @Column(name="zgrs")

    public Integer getZgrs() {
        return this.zgrs;
    }
    
    public void setZgrs(Integer zgrs) {
        this.zgrs = zgrs;
    }
    
    @Column(name="bgrq", length=23)

    public Date getBgrq() {
        return this.bgrq;
    }
    
    public void setBgrq(Date bgrq) {
        this.bgrq = bgrq;
    }
    
    @Column(name="lry", length=10)

    public String getLry() {
        return this.lry;
    }
    
    public void setLry(String lry) {
        this.lry = lry;
    }
    
    @Column(name="njrq", length=23)

    public Date getNjrq() {
        return this.njrq;
    }
    
    public void setNjrq(Date njrq) {
        this.njrq = njrq;
    }
    
    @Column(name="zch", length=70)

    public String getZch() {
        return this.zch;
    }
    
    public void setZch(String zch) {
        this.zch = zch;
    }
    
    @Column(name="zgmc", length=200)

    public String getZgmc() {
        return this.zgmc;
    }
    
    public void setZgmc(String zgmc) {
        this.zgmc = zgmc;
    }
    
    @Column(name="pzjgmc", length=200)

    public String getPzjgmc() {
        return this.pzjgmc;
    }
    
    public void setPzjgmc(String pzjgmc) {
        this.pzjgmc = pzjgmc;
    }
    
    @Column(name="email", length=50)

    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Column(name="url", length=50)

    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    @Column(name="mobile", length=15)

    public String getMobile() {
        return this.mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    @Column(name="lastdate", length=23)

    public Date getLastdate() {
        return this.lastdate;
    }
    
    public void setLastdate(Date lastdate) {
        this.lastdate = lastdate;
    }
    
    @Column(name="tbrxm", length=60)

    public String getTbrxm() {
        return this.tbrxm;
    }
    
    public void setTbrxm(String tbrxm) {
        this.tbrxm = tbrxm;
    }
    
    @Column(name="tbrsfzh", length=25)

    public String getTbrsfzh() {
        return this.tbrsfzh;
    }
    
    public void setTbrsfzh(String tbrsfzh) {
        this.tbrsfzh = tbrsfzh;
    }
    
    @Column(name="tbrlxfs", length=50)

    public String getTbrlxfs() {
        return this.tbrlxfs;
    }
    
    public void setTbrlxfs(String tbrlxfs) {
        this.tbrlxfs = tbrlxfs;
    }
    
    @Column(name="jydz", length=240)

    public String getJydz() {
        return this.jydz;
    }
    
    public void setJydz(String jydz) {
        this.jydz = jydz;
    }
    
    @Column(name="jyzt", length=50)

    public String getJyzt() {
        return this.jyzt;
    }
    
    public void setJyzt(String jyzt) {
        this.jyzt = jyzt;
    }
    
    @Column(name="scjyxzqh", length=6)

    public String getScjyxzqh() {
        return this.scjyxzqh;
    }
    
    public void setScjyxzqh(String scjyxzqh) {
        this.scjyxzqh = scjyxzqh;
    }
    
    @Column(name="tbrzjlx", length=2)

    public String getTbrzjlx() {
        return this.tbrzjlx;
    }
    
    public void setTbrzjlx(String tbrzjlx) {
        this.tbrzjlx = tbrzjlx;
    }
    
    @Column(name="ywlx", length=50)

    public String getYwlx() {
        return this.ywlx;
    }
    
    public void setYwlx(String ywlx) {
        this.ywlx = ywlx;
    }
    
    @Column(name="hsfs", length=50)

    public String getHsfs() {
        return this.hsfs;
    }
    
    public void setHsfs(String hsfs) {
        this.hsfs = hsfs;
    }
    
    @Column(name="jhbz", length=100)

    public String getJhbz() {
        return this.jhbz;
    }
    
    public void setJhbz(String jhbz) {
        this.jhbz = jhbz;
    }
    
    @Column(name="djxs", length=100)

    public String getDjxs() {
        return this.djxs;
    }
    
    public void setDjxs(String djxs) {
        this.djxs = djxs;
    }
    
    @Column(name="fzxs", length=100)

    public String getFzxs() {
        return this.fzxs;
    }
    
    public void setFzxs(String fzxs) {
        this.fzxs = fzxs;
    }
    
    @Column(name="hddy", length=240)

    public String getHddy() {
        return this.hddy;
    }
    
    public void setHddy(String hddy) {
        this.hddy = hddy;
    }
    
    @Column(name="jjhlx", length=100)

    public String getJjhlx() {
        return this.jjhlx;
    }
    
    public void setJjhlx(String jjhlx) {
        this.jjhlx = jjhlx;
    }
    
    @Column(name="dybz", length=1)

    public String getDybz() {
        return this.dybz;
    }
    
    public void setDybz(String dybz) {
        this.dybz = dybz;
    }
    
    @Column(name="dwhysl")

    public Integer getDwhysl() {
        return this.dwhysl;
    }
    
    public void setDwhysl(Integer dwhysl) {
        this.dwhysl = dwhysl;
    }
    
    @Column(name="grhysl")

    public Integer getGrhysl() {
        return this.grhysl;
    }
    
    public void setGrhysl(Integer grhysl) {
        this.grhysl = grhysl;
    }
    
    @Column(name="yxqxs", length=23)

    public Date getYxqxs() {
        return this.yxqxs;
    }
    
    public void setYxqxs(Date yxqxs) {
        this.yxqxs = yxqxs;
    }
    
    @Column(name="frdhhm", length=25)

    public String getFrdhhm() {
        return this.frdhhm;
    }
    
    public void setFrdhhm(String frdhhm) {
        this.frdhhm = frdhhm;
    }
    
    @Column(name="zzrysl")

    public Integer getZzrysl() {
        return this.zzrysl;
    }
    
    public void setZzrysl(Integer zzrysl) {
        this.zzrysl = zzrysl;
    }
    
    @Column(name="jzrysl")

    public Integer getJzrysl() {
        return this.jzrysl;
    }
    
    public void setJzrysl(Integer jzrysl) {
        this.jzrysl = jzrysl;
    }
    
    @Column(name="tbrmobile", length=15)

    public String getTbrmobile() {
        return this.tbrmobile;
    }
    
    public void setTbrmobile(String tbrmobile) {
        this.tbrmobile = tbrmobile;
    }
    
    @Column(name="khyh", length=200)

    public String getKhyh() {
        return this.khyh;
    }
    
    public void setKhyh(String khyh) {
        this.khyh = khyh;
    }
    
    @Column(name="kyzh", length=200)

    public String getKyzh() {
        return this.kyzh;
    }
    
    public void setKyzh(String kyzh) {
        this.kyzh = kyzh;
    }
    
    @Column(name="isdang", length=1)

    public String getIsdang() {
        return this.isdang;
    }
    
    public void setIsdang(String isdang) {
        this.isdang = isdang;
    }
    
    @Column(name="wjlyy", length=200)

    public String getWjlyy() {
        return this.wjlyy;
    }
    
    public void setWjlyy(String wjlyy) {
        this.wjlyy = wjlyy;
    }
    
    @Column(name="dzzlx", length=200)

    public String getDzzlx() {
        return this.dzzlx;
    }
    
    public void setDzzlx(String dzzlx) {
        this.dzzlx = dzzlx;
    }
    
    @Column(name="dzzfzr", length=100)

    public String getDzzfzr() {
        return this.dzzfzr;
    }
    
    public void setDzzfzr(String dzzfzr) {
        this.dzzfzr = dzzfzr;
    }
    
    @Column(name="dzzfzrzjlx", length=2)

    public String getDzzfzrzjlx() {
        return this.dzzfzrzjlx;
    }
    
    public void setDzzfzrzjlx(String dzzfzrzjlx) {
        this.dzzfzrzjlx = dzzfzrzjlx;
    }
    
    @Column(name="dzzfzrzjhm", length=42)

    public String getDzzfzrzjhm() {
        return this.dzzfzrzjhm;
    }
    
    public void setDzzfzrzjhm(String dzzfzrzjhm) {
        this.dzzfzrzjhm = dzzfzrzjhm;
    }
    
    @Column(name="djlxr", length=100)

    public String getDjlxr() {
        return this.djlxr;
    }
    
    public void setDjlxr(String djlxr) {
        this.djlxr = djlxr;
    }
    
    @Column(name="djlxrzjlx", length=2)

    public String getDjlxrzjlx() {
        return this.djlxrzjlx;
    }
    
    public void setDjlxrzjlx(String djlxrzjlx) {
        this.djlxrzjlx = djlxrzjlx;
    }
    
    @Column(name="djlxrzjhm", length=42)

    public String getDjlxrzjhm() {
        return this.djlxrzjhm;
    }
    
    public void setDjlxrzjhm(String djlxrzjhm) {
        this.djlxrzjhm = djlxrzjhm;
    }
    
    @Column(name="djlxrdhhm", length=25)

    public String getDjlxrdhhm() {
        return this.djlxrdhhm;
    }
    
    public void setDjlxrdhhm(String djlxrdhhm) {
        this.djlxrdhhm = djlxrdhhm;
    }
    
    @Column(name="dzzclrq", length=23)

    public Date getDzzclrq() {
        return this.dzzclrq;
    }
    
    public void setDzzclrq(Date dzzclrq) {
        this.dzzclrq = dzzclrq;
    }
    
    @Column(name="sjdzzmc", length=400)

    public String getSjdzzmc() {
        return this.sjdzzmc;
    }
    
    public void setSjdzzmc(String sjdzzmc) {
        this.sjdzzmc = sjdzzmc;
    }
    
    @Column(name="zzdysl")

    public Integer getZzdysl() {
        return this.zzdysl;
    }
    
    public void setZzdysl(Integer zzdysl) {
        this.zzdysl = zzdysl;
    }
    
    @Column(name="jzdysl")

    public Integer getJzdysl() {
        return this.jzdysl;
    }
    
    public void setJzdysl(Integer jzdysl) {
        this.jzdysl = jzdysl;
    }
    
    @Column(name="memo", length=500)

    public String getMemo() {
        return this.memo;
    }
    
    public void setMemo(String memo) {
        this.memo = memo;
    }
    
    @Column(name="memo1", length=500)

    public String getMemo1() {
        return this.memo1;
    }
    
    public void setMemo1(String memo1) {
        this.memo1 = memo1;
    }
    
    @Column(name="memo2", length=500)

    public String getMemo2() {
        return this.memo2;
    }
    
    public void setMemo2(String memo2) {
        this.memo2 = memo2;
    }
    
    @Column(name="memo3", length=500)

    public String getMemo3() {
        return this.memo3;
    }
    
    public void setMemo3(String memo3) {
        this.memo3 = memo3;
    }
    
    @Column(name="memo4", length=500)

    public String getMemo4() {
        return this.memo4;
    }
    
    public void setMemo4(String memo4) {
        this.memo4 = memo4;
    }
    
    @Column(name="memo5", length=500)

    public String getMemo5() {
        return this.memo5;
    }
    
    public void setMemo5(String memo5) {
        this.memo5 = memo5;
    }
    @Column(name="lssl")
	public Integer getLssl() {
		return lssl;
	}

	public void setLssl(Integer lssl) {
		this.lssl = lssl;
	}
	@Column(name="jssl")
	public Integer getJssl() {
		return jssl;
	}

	public void setJssl(Integer jssl) {
		this.jssl = jssl;
	}
	@Column(name="cwlssl")
	public Integer getCwlssl() {
		return cwlssl;
	}

	public void setCwlssl(Integer cwlssl) {
		this.cwlssl = cwlssl;
	}
   



	
    
}