package com.ninemax.jpa.code.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-6-8
 * Time: ÉÏÎç10:45
 */
@javax.persistence.Table(name = "t_mdk")
@Entity
public class TMdk {
    private String jgdm;

    @javax.persistence.Column(name = "jgdm", nullable = false, insertable = true, updatable = true, length = 9, precision = 0)
    @Id
    public String getJgdm() {
        return jgdm;
    }

    public void setJgdm(String jgdm) {
        this.jgdm = jgdm;
    }
  /*  private Integer id;
    @javax.persistence.Column(name = "id")
    @Basic
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}*/
	private String dmflag;

    @javax.persistence.Column(name = "dmflag", nullable = false, insertable = true, updatable = true, length = 1, precision = 0)
    @Basic
    public String getDmflag() {
        return dmflag;
    }

    public void setDmflag(String dmflag) {
        this.dmflag = dmflag;
    }
    private Date createTime;
    @javax.persistence.Column(name = "createTime")
    @Basic
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TMdk tMdk = (TMdk) o;

        if (dmflag != null ? !dmflag.equals(tMdk.dmflag) : tMdk.dmflag != null) return false;
        if (jgdm != null ? !jgdm.equals(tMdk.jgdm) : tMdk.jgdm != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = jgdm != null ? jgdm.hashCode() : 0;
        result = 31 * result + (dmflag != null ? dmflag.hashCode() : 0);
        return result;
    }
}
