package com.ninemax.jpa.system.model;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**  省内t_zrxzqh
 *   省间SC_bzjgdm
 * Bzjgdm entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="sc_bzjgdm")

public class Bzjgdm  implements java.io.Serializable {


    // Fields    

     private String dm;
     private String mc;
     private String depth;
     private String dmF;
     private String soMc;



    @Id
    
    @Column(name="bzjg_id", unique=true, nullable=false, insertable=true, updatable=true, length=10)

    public String getDm() {
        return this.dm;
    }
    
    public void setDm(String dm) {
        this.dm = dm;
    }
    
    @Column(name="bzjg_name", unique=false, nullable=true, insertable=true, updatable=true, length=200)

    public String getMc() {
        return this.mc;
    }
    
    public void setMc(String mc) {
        this.mc = mc;
    }

    @Column(name="type", unique=true, nullable=false, insertable=true, updatable=true, length=10)

    public String getDepth() {
    	return depth;
    }
    
    public void setDepth(String depth) {
    	this.depth = depth;
    }


	@Column(name="sjbzjg_id", unique=true, nullable=false, insertable=true, updatable=true, length=10)
	public String getDmF() {
		return dmF;
	}
	
	public void setDmF(String dmF) {
		this.dmF = dmF;
	}

	@Column(name="mc")
	public String getSoMc() {
		return soMc;
	}

	public void setSoMc(String soMc) {
		this.soMc = soMc;
	}

	
	
    
    







}