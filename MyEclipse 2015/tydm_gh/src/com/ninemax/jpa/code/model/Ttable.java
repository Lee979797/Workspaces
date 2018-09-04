package com.ninemax.jpa.code.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-10
 * Time: ÉÏÎç10:30
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.IdClass(com.ninemax.jpa.code.model.TtablePK.class)
@javax.persistence.Table(name = "ttable")
@Entity
public class Ttable {
    private String tablecode;

    @javax.persistence.Column(name = "tablecode")
    @Id
    public String getTablecode() {
        return tablecode;
    }

    public void setTablecode(String tablecode) {
        this.tablecode = tablecode;
    }

    private String tablename;

    @javax.persistence.Column(name = "tablename")
    @Basic
    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    private String columncode;

    @javax.persistence.Column(name = "columncode")
    @Id
    public String getColumncode() {
        return columncode;
    }

    public void setColumncode(String columncode) {
        this.columncode = columncode;
    }

    private String columnname;

    @javax.persistence.Column(name = "columnname")
    @Basic
    public String getColumnname() {
        return columnname;
    }

    public void setColumnname(String columnname) {
        this.columnname = columnname;
    }

    private String sql;

    @javax.persistence.Column(name = "sql")
    @Basic
    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
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

    private Integer sn;

    @javax.persistence.Column(name = "sn")
    @Basic
    public Integer getSn() {
        return sn;
    }

    public void setSn(Integer sn) {
        this.sn = sn;
    }

    private String func;

    @javax.persistence.Column(name = "func")
    @Basic
    public String getFunc() {
        return func;
    }

    public void setFunc(String func) {
        this.func = func;
    }

    private String tjflag;

    @javax.persistence.Column(name = "tjflag")
    @Basic
    public String getTjflag() {
        return tjflag;
    }

    public void setTjflag(String tjflag) {
        this.tjflag = tjflag;
    }

    private Boolean blxflag;

    @javax.persistence.Column(name = "blxflag")
    @Basic
    public Boolean getBlxflag() {
        return blxflag;
    }

    public void setBlxflag(Boolean blxflag) {
        this.blxflag = blxflag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ttable ttable = (Ttable) o;

        if (blxflag != null ? !blxflag.equals(ttable.blxflag) : ttable.blxflag != null) return false;
        if (columncode != null ? !columncode.equals(ttable.columncode) : ttable.columncode != null) return false;
        if (columnname != null ? !columnname.equals(ttable.columnname) : ttable.columnname != null) return false;
        if (func != null ? !func.equals(ttable.func) : ttable.func != null) return false;
        if (sn != null ? !sn.equals(ttable.sn) : ttable.sn != null) return false;
        if (sql != null ? !sql.equals(ttable.sql) : ttable.sql != null) return false;
        if (tablecode != null ? !tablecode.equals(ttable.tablecode) : ttable.tablecode != null) return false;
        if (tablename != null ? !tablename.equals(ttable.tablename) : ttable.tablename != null) return false;
        if (tjflag != null ? !tjflag.equals(ttable.tjflag) : ttable.tjflag != null) return false;
        if (type != null ? !type.equals(ttable.type) : ttable.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tablecode != null ? tablecode.hashCode() : 0;
        result = 31 * result + (tablename != null ? tablename.hashCode() : 0);
        result = 31 * result + (columncode != null ? columncode.hashCode() : 0);
        result = 31 * result + (columnname != null ? columnname.hashCode() : 0);
        result = 31 * result + (sql != null ? sql.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (sn != null ? sn.hashCode() : 0);
        result = 31 * result + (func != null ? func.hashCode() : 0);
        result = 31 * result + (tjflag != null ? tjflag.hashCode() : 0);
        result = 31 * result + (blxflag != null ? blxflag.hashCode() : 0);
        return result;
    }
}
