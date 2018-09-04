package com.ninemax.jpa.code.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-6-20
 * Time: ÏÂÎç3:06
 * To change this template use File | Settings | File Templates.
 */

public class TSppz {
    private String ywlx;

    @Id
    public String getYwlx() {
        return ywlx;
    }

    public void setYwlx(String ywlx) {
        this.ywlx = ywlx;
    }

    private String ywmc;

    @Basic
    public String getYwmc() {
        return ywmc;
    }

    public void setYwmc(String ywmc) {
        this.ywmc = ywmc;
    }

    private String tablename;

    @Basic
    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    private String columnlabel;

    @Basic
    public String getColumnlabel() {
        return columnlabel;
    }

    public void setColumnlabel(String columnlabel) {
        this.columnlabel = columnlabel;
    }

    private String columnname;

    @Basic
    public String getColumnname() {
        return columnname;
    }

    public void setColumnname(String columnname) {
        this.columnname = columnname;
    }

    private String condition;

    @Basic
    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    private String link1;

    @javax.persistence.Column(name = "link1")
    @Basic
    public String getLink1() {
        return link1;
    }

    public void setLink1(String link1) {
        this.link1 = link1;
    }

    private String link2;

    @javax.persistence.Column(name = "link2")
    @Basic
    public String getLink2() {
        return link2;
    }

    public void setLink2(String link2) {
        this.link2 = link2;
    }

    private String link3;

    @javax.persistence.Column(name = "link3")
    @Basic
    public String getLink3() {
        return link3;
    }

    public void setLink3(String link3) {
        this.link3 = link3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TSppz tSppz = (TSppz) o;

        if (columnlabel != null ? !columnlabel.equals(tSppz.columnlabel) : tSppz.columnlabel != null) return false;
        if (columnname != null ? !columnname.equals(tSppz.columnname) : tSppz.columnname != null) return false;
        if (condition != null ? !condition.equals(tSppz.condition) : tSppz.condition != null) return false;
        if (link1 != null ? !link1.equals(tSppz.link1) : tSppz.link1 != null) return false;
        if (link2 != null ? !link2.equals(tSppz.link2) : tSppz.link2 != null) return false;
        if (link3 != null ? !link3.equals(tSppz.link3) : tSppz.link3 != null) return false;
        if (tablename != null ? !tablename.equals(tSppz.tablename) : tSppz.tablename != null) return false;
        if (ywlx != null ? !ywlx.equals(tSppz.ywlx) : tSppz.ywlx != null) return false;
        if (ywmc != null ? !ywmc.equals(tSppz.ywmc) : tSppz.ywmc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ywlx != null ? ywlx.hashCode() : 0;
        result = 31 * result + (ywmc != null ? ywmc.hashCode() : 0);
        result = 31 * result + (tablename != null ? tablename.hashCode() : 0);
        result = 31 * result + (columnlabel != null ? columnlabel.hashCode() : 0);
        result = 31 * result + (columnname != null ? columnname.hashCode() : 0);
        result = 31 * result + (condition != null ? condition.hashCode() : 0);
        result = 31 * result + (link1 != null ? link1.hashCode() : 0);
        result = 31 * result + (link2 != null ? link2.hashCode() : 0);
        result = 31 * result + (link3 != null ? link3.hashCode() : 0);
        return result;
    }
}
