package com.ninemax.jpa.code.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-10-24
 * Time: ÏÂÎç3:59
 */
@javax.persistence.Table(name = "t_ywlc_dy")
@Entity
public class TYwlcDy {

    @javax.persistence.Column(name = "id")
    @Id
    private int id;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    private int ywlclx;

    @javax.persistence.Column(name = "ywlclx", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getYwlclx() {
        return ywlclx;
    }

    public void setYwlclx(int ywlclx) {
        this.ywlclx = ywlclx;
    }

    private Integer lcsx;

    @javax.persistence.Column(name = "lcsx", nullable = true, insertable = true, updatable = true, length = 1, precision = 0)
    @Basic
    public Integer getLcsx() {
        return lcsx;
    }

    public void setLcsx(Integer lcsx) {
        this.lcsx = lcsx;
    }

    private String type;

    @javax.persistence.Column(name = "type", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String isend;

    @javax.persistence.Column(name = "isend", nullable = true, insertable = true, updatable = true, length = 1, precision = 0)
    @Basic
    public String getIsend() {
        return isend;
    }

    public void setIsend(String isend) {
        this.isend = isend;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TYwlcDy tYwlcDy = (TYwlcDy) o;

        if (ywlclx != tYwlcDy.ywlclx) return false;
        if (isend != null ? !isend.equals(tYwlcDy.isend) : tYwlcDy.isend != null) return false;
        if (lcsx != null ? !lcsx.equals(tYwlcDy.lcsx) : tYwlcDy.lcsx != null) return false;
        if (type != null ? !type.equals(tYwlcDy.type) : tYwlcDy.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ywlclx;
        result = 31 * result + (lcsx != null ? lcsx.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (isend != null ? isend.hashCode() : 0);
        return result;
    }
}
