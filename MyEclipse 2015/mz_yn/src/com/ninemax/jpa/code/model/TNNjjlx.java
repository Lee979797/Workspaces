package com.ninemax.jpa.code.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-5-17
 * Time: ����2:10
 */
@javax.persistence.Table(name = "sc_lx")
@Entity
public class TNNjjlx {
    private String dm;

    @javax.persistence.Column(name = "dm", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Id
    public String getDm() {
        return dm;
    }

    public void setDm(String dm) {
        this.dm = dm;
    }

    private String mc;

    @javax.persistence.Column(name = "mc", nullable = false, insertable = true, updatable = true, length = 40, precision = 0)
    @Basic
    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
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
    
  
}
