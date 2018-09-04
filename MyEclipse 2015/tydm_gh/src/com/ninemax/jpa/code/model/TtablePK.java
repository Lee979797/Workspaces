package com.ninemax.jpa.code.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-10
 * Time: ÉÏÎç10:30
 * To change this template use File | Settings | File Templates.
 */
public class TtablePK implements Serializable {
    private String tablecode;

    @Id
    @Column(name = "tablecode")
    public String getTablecode() {
        return tablecode;
    }

    public void setTablecode(String tablecode) {
        this.tablecode = tablecode;
    }

    private String columncode;

    @Id
    @Column(name = "columncode")
    public String getColumncode() {
        return columncode;
    }

    public void setColumncode(String columncode) {
        this.columncode = columncode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TtablePK ttablePK = (TtablePK) o;

        if (columncode != null ? !columncode.equals(ttablePK.columncode) : ttablePK.columncode != null) return false;
        if (tablecode != null ? !tablecode.equals(ttablePK.tablecode) : ttablePK.tablecode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tablecode != null ? tablecode.hashCode() : 0;
        result = 31 * result + (columncode != null ? columncode.hashCode() : 0);
        return result;
    }
}
