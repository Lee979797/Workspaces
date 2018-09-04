package com.ninemax.jpa.code.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * User: yzhhui
 * Date: 13-4-11
 * Time: ÏÂÎç3:49
 */
public class SerialPK implements Serializable {
    private String tableType;

    @Id
    @Column(name = "table_type")
    public  String getTableType() {
        return tableType;
    }

    public    void setTableType(String tableType) {
        this.tableType = tableType;
    }

    private String xzqhCode;

    @Id
    @Column(name = "xzqh_code")
    public  String getXzqhCode() {
        return xzqhCode;
    }

    public    void setXzqhCode(String xzqhCode) {
        this.xzqhCode = xzqhCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SerialPK serialPK = (SerialPK) o;

        if (tableType != null ? !tableType.equals(serialPK.tableType) : serialPK.tableType != null) return false;
        if (xzqhCode != null ? !xzqhCode.equals(serialPK.xzqhCode) : serialPK.xzqhCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tableType != null ? tableType.hashCode() : 0;
        result = 31 * result + (xzqhCode != null ? xzqhCode.hashCode() : 0);
        return result;
    }
}
