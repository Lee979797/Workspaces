package com.ninemax.jpa.code.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-10-24
 * Time: ÏÂÎç3:59
 */
@javax.persistence.Table(name = "t_ywlc_lx")
@Entity
public class TYwlcLx {

    @javax.persistence.Column(name = "id")
    @Id
    @GeneratedValue
    private int id;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    private int czlxdm;

    @javax.persistence.Column(name = "czlxdm", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getCzlxdm() {
        return czlxdm;
    }

    public void setCzlxdm(int czlxdm) {
        this.czlxdm = czlxdm;
    }

    private String czlxmc;

    @javax.persistence.Column(name = "czlxmc", nullable = false, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String getCzlxmc() {
        return czlxmc;
    }

    public void setCzlxmc(String czlxmc) {
        this.czlxmc = czlxmc;
    }

    private String type;

    @javax.persistence.Column(name = "type", nullable = false, insertable = true, updatable = true, length = 1, precision = 0)
    @Basic
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TYwlcLx tYwlcLx = (TYwlcLx) o;

        if (czlxdm != tYwlcLx.czlxdm) return false;
        if (czlxmc != null ? !czlxmc.equals(tYwlcLx.czlxmc) : tYwlcLx.czlxmc != null) return false;
        if (type != null ? !type.equals(tYwlcLx.type) : tYwlcLx.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = czlxdm;
        result = 31 * result + (czlxmc != null ? czlxmc.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
