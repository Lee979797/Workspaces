package com.ninemax.jpa.code.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-11
 * Time: ÏÂÎç3:11
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "t_zysh")
@Entity
public class TZysh {
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

    private String xzqh;

    @javax.persistence.Column(name = "xzqh")
    @Basic
    public String getXzqh() {
        return xzqh;
    }

    public void setXzqh(String xzqh) {
        this.xzqh = xzqh;
    }

    private String type;

    @javax.persistence.Column(name = "type")
    @Basic
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String shtype;

    @javax.persistence.Column(name = "shtype")
    @Basic
    public String getShtype() {
        return shtype;
    }

    public void setShtype(String shtype) {
        this.shtype = shtype;
    }

    private String shreason;

    @javax.persistence.Column(name = "shreason")
    @Basic
    public String getShreason() {
        return shreason;
    }

    public void setShreason(String shreason) {
        this.shreason = shreason;
    }

    private Integer shsl;

    @javax.persistence.Column(name = "shsl")
    @Basic
    public Integer getShsl() {
        return shsl;
    }

    public void setShsl(Integer shsl) {
        this.shsl = shsl;
    }

    private Date shsj;

    @javax.persistence.Column(name = "shsj")
    @Basic
    public Date getShsj() {
        return shsj;
    }

    public void setShsj(Date shsj) {
        this.shsj = shsj;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TZysh tZysh = (TZysh) o;

        if (id != null ? !id.equals(tZysh.id) : tZysh.id != null) return false;
        if (jgdm != null ? !jgdm.equals(tZysh.jgdm) : tZysh.jgdm != null) return false;
        if (shreason != null ? !shreason.equals(tZysh.shreason) : tZysh.shreason != null) return false;
        if (shsj != null ? !shsj.equals(tZysh.shsj) : tZysh.shsj != null) return false;
        if (shsl != null ? !shsl.equals(tZysh.shsl) : tZysh.shsl != null) return false;
        if (shtype != null ? !shtype.equals(tZysh.shtype) : tZysh.shtype != null) return false;
        if (type != null ? !type.equals(tZysh.type) : tZysh.type != null) return false;
        if (xzqh != null ? !xzqh.equals(tZysh.xzqh) : tZysh.xzqh != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (xzqh != null ? xzqh.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (shtype != null ? shtype.hashCode() : 0);
        result = 31 * result + (shreason != null ? shreason.hashCode() : 0);
        result = 31 * result + (shsl != null ? shsl.hashCode() : 0);
        result = 31 * result + (shsj != null ? shsj.hashCode() : 0);
        result = 31 * result + (jgdm != null ? jgdm.hashCode() : 0);
        return result;
    }
}
