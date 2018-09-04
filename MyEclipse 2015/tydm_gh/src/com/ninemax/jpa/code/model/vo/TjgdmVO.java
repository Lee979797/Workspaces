package com.ninemax.jpa.code.model.vo;
import javax.persistence.Basic;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-8-14
 * Time: ÉÏÎç9:25
 */
public class TjgdmVO {

    public TjgdmVO() {
    }

    public TjgdmVO(String jgdm, String jgmc, Date bzrq,String tyshxydm) {
        this.jgdm = jgdm; 
        this.jgmc = jgmc;
        this.bzrq = bzrq;
        this.tyshxydm = tyshxydm;
    }
    public TjgdmVO(String jgdm, String jgmc, Date bzrq,String tyshxydm,String xzqh,String zch) {
    	this.jgdm = jgdm; 
    	this.jgmc = jgmc;
    	this.bzrq = bzrq;
    	this.tyshxydm = tyshxydm;
    	this.xzqh=xzqh;
    	this.zch=zch;
    }

    public TjgdmVO(Integer id,String jgdm, String jgmc, Date bzrq, String flag,String shflag) {
        this.id = id;
        this.jgdm = jgdm;
        this.jgmc = jgmc;
        this.bzrq = bzrq;
        this.flag = flag;
        this.shflag = shflag;
    }


    public TjgdmVO(Integer id,String jgdm, String jgmc, Date bzrq, String fddbr,String zjhm, String flag,String shflag,String tyshxydm) {
        this.id = id;
        this.jgdm = jgdm;
        this.jgmc = jgmc;
        this.bzrq = bzrq;
        this.fddbr = fddbr;
        this.zjhm = zjhm;
        this.flag = flag;
        this.shflag = shflag;
        this.tyshxydm = tyshxydm;
    }

    public TjgdmVO(Integer id,String jgdm, String jgmc, Date bzrq) {
        this.id = id;
        this.jgdm = jgdm;
        this.jgmc = jgmc;
        this.bzrq = bzrq;
    }

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String jgdm;

    public String getJgdm() {
        return jgdm;
    }

    public void setJgdm(String jgdm) {
        this.jgdm = jgdm;
    }

    private String jgmc;

    public String getJgmc() {
        return jgmc;
    }

    public void setJgmc(String jgmc) {
        this.jgmc = jgmc;
    }

    private Date bzrq;

    public Date getBzrq() {
        return bzrq;
    }

    public void setBzrq(Date bzrq) {
        this.bzrq = bzrq;
    }

    private String flag;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    private String shflag;

    public String getShflag() {
        return shflag;
    }

    public void setShflag(String shflag) {
        this.shflag = shflag;
    }

    private String fddbr;

    public String getFddbr() {
        return fddbr;
    }

    public void setFddbr(String fddbr) {
        this.fddbr = fddbr;
    }

    private String zjhm;

    public String getZjhm() {
        return zjhm;
    }

    public void setZjhm(String zjhm) {
        this.zjhm = zjhm;
    }

    private String pzwh;

    public String getPzwh() {
        return pzwh;
    }

    public void setPzwh(String pzwh) {
        this.pzwh = pzwh;
    }
    private String bak3;

	public String getBak3() {
		return bak3;
	}

	public void setBak3(String bak3) {
		this.bak3 = bak3;
	}
	private String tyshxydm;

	public String getTyshxydm() {
		return tyshxydm;
	}

	public void setTyshxydm(String tyshxydm) {
		this.tyshxydm = tyshxydm;
	}
	
	public String xzqh;
	
	
	public String getXzqh() {
		return xzqh;
	}

	public void setXzqh(String xzqh) {
		this.xzqh = xzqh;
	}

	public String zch;

	public String getZch() {
		return zch;
	}

	public void setZch(String zch) {
		this.zch = zch;
	}
	
    
}
