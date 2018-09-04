package com.ninemax.jpa.code.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-6-11
 * Time: ÏÂÎç2:38
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "tk_fzk")
@Entity
public class TkFzk {
    private Long id;

    @javax.persistence.Column(name = "id")
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Long kxlh;

    @javax.persistence.Column(name = "kxlh")
    @Basic
    public Long getKxlh() {
        return kxlh;
    }

    public void setKxlh(Long kxlh) {
        this.kxlh = kxlh;
    }

    private String jgdm;

    @javax.persistence.Column(name = "jgdm")
    @Basic
    public String getJgdm() {
        return jgdm;
    }

    public void setJgdm(String jgdm) {
        this.jgdm = jgdm;
    }

    private Date fzsj;

    @javax.persistence.Column(name = "fzsj")
    @Basic
    public Date getFzsj() {
        return fzsj;
    }

    public void setFzsj(Date fzsj) {
        this.fzsj = fzsj;
    }

    private String operater;

    @javax.persistence.Column(name = "operater")
    @Basic
    public String getOperater() {
        return operater;
    }

    public void setOperater(String operater) {
        this.operater = operater;
    }

    private String xzqh;

    @javax.persistence.Column(name = "xzqh")
    @Basic
    public String getXzqh() {
        return xzqh;
    }

    public void setXzqh(String xzqh) {
        this.xzqh = xzqh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TkFzk tkFzk = (TkFzk) o;

        if (id != tkFzk.id) return false;
        if (kxlh != tkFzk.kxlh) return false;
        if (fzsj != null ? !fzsj.equals(tkFzk.fzsj) : tkFzk.fzsj != null) return false;
        if (jgdm != null ? !jgdm.equals(tkFzk.jgdm) : tkFzk.jgdm != null) return false;
        if (operater != null ? !operater.equals(tkFzk.operater) : tkFzk.operater != null) return false;
        if (xzqh != null ? !xzqh.equals(tkFzk.xzqh) : tkFzk.xzqh != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        Integer result = (int) (id ^ (id >>> 32));
        result = 31 * result + (jgdm != null ? jgdm.hashCode() : 0);
        result = 31 * result + (fzsj != null ? fzsj.hashCode() : 0);
        result = 31 * result + (operater != null ? operater.hashCode() : 0);
        result = 31 * result + (xzqh != null ? xzqh.hashCode() : 0);
        return result;
    }
}
