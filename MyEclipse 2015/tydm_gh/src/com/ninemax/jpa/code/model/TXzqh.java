package com.ninemax.jpa.code.model;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-5-18
 * Time: ÏÂÎç2:03
 */
@Table(name = "sc_xzqh")
@Entity
public class TXzqh {
    private String dm;

    @Column(name = "dm", nullable = false, insertable = true, updatable = true, length = 6, precision = 0)
    @Id
    public String getDm() {
        return dm;
    }

    public void setDm(String dm) {
        this.dm = dm;
    }

    private String mc;

    @Column(name = "mc", nullable = false, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }
    
    private String depth;
    
    @Column(name = "depth", nullable = false, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String getDepth() {
		return depth;
	}

	public void setDepth(String depth) {
		this.depth = depth;
	}
	
	private String dmF;
	
    @Column(name = "dm_f", nullable = false, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
	public String getDmF() {
		return dmF;
	}

	public void setDmF(String dmF) {
		this.dmF = dmF;
	}

	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TXzqh tXzqh = (TXzqh) o;

        if (dm != null ? !dm.equals(tXzqh.dm) : tXzqh.dm != null) return false;
        if (mc != null ? !mc.equals(tXzqh.mc) : tXzqh.mc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dm != null ? dm.hashCode() : 0;
        result = 31 * result + (mc != null ? mc.hashCode() : 0);
        return result;
    }
}
