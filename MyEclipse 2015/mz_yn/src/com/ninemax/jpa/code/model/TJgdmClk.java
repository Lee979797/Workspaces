package com.ninemax.jpa.code.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * TJgdmClk entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="t_jgdm_clk")
public class TJgdmClk  implements java.io.Serializable{
    private String jgdm;
    private String jgmc;
    private String tyshxydm;
    private String zch;
    private Integer dflag;
    private String memo;
    private String memo1;
    private String memo2;
    private String memo3;
    
	@Column(name = "tyshxydm",unique = true, nullable = false, length = 18)
    public String getTyshxydm() {
        return this.tyshxydm;
    }    
    public void setTyshxydm(String tyshxydm) {
        this.tyshxydm = tyshxydm;
    }
    
    @Id
    @Column(name="jgdm", nullable=false, length=9)
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
        this.jgmc = jgmc;
    }
    
	@Column(name="dflag")
	public Integer getDflag() {
		return dflag;
	}
	public void setDflag(Integer dflag) {
		this.dflag = dflag;
	}
	
    @Column(name="zch", length=70)
    public String getZch() {
        return this.zch;
    }  
    public void setZch(String zch) {
        this.zch = zch;
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

    @Override
	public String toString() {
		return "TJgdmClk [jgdm=" + jgdm + ", jgmc=" + jgmc + ", tyshxydm="
				+ tyshxydm + ", zch=" + zch + ", dflag=" + dflag + ", memo="
				+ memo + ", memo1=" + memo1 + ", memo2=" + memo2 + ", memo3="
				+ memo3 + "]";
	}
}