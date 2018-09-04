package com.ninemax.jpa.code.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * User: yzhhui
 * Date: 13-4-11
 * Time: ÏÂÎç3:49
 */
@javax.persistence.IdClass(SerialPK.class)
@javax.persistence.Table(name = "s_serial")
@Entity
public class Serial {
    private String tableType;

    @javax.persistence.Column(name = "table_type")
    @Id
    public String getTableType() {
        return tableType;
    }

    public void setTableType(String tableType) {
        this.tableType = tableType;
    }

    private String xzqhCode;

    @javax.persistence.Column(name = "xzqh_code")
    @Id
    public String getXzqhCode() {
        return xzqhCode;
    }

    public void setXzqhCode(String xzqhCode) {
        this.xzqhCode = xzqhCode;
    }

    private String tableName;

    @javax.persistence.Column(name = "table_name")
    @Basic
    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    private Integer flowId;

    @javax.persistence.Column(name = "flow_id")
    @Basic
    public Integer getFlowId() {
        return flowId;
    }

    public void setFlowId(Integer flowId) {
        this.flowId = flowId;
    }

    private String flowIdLen;

    @javax.persistence.Column(name = "flow_id_len")
    @Basic
    public String getFlowIdLen() {
        return flowIdLen;
    }

    public void setFlowIdLen(String flowIdLen) {
        this.flowIdLen = flowIdLen;
    }

    private String year;

    @javax.persistence.Column(name = "year")
    @Basic
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Serial serial = (Serial) o;

        if (!flowId.equals(serial.flowId)) return false;
        if (flowIdLen != null ? !flowIdLen.equals(serial.flowIdLen) : serial.flowIdLen != null) return false;
        if (tableName != null ? !tableName.equals(serial.tableName) : serial.tableName != null) return false;
        if (tableType != null ? !tableType.equals(serial.tableType) : serial.tableType != null) return false;
        if (xzqhCode != null ? !xzqhCode.equals(serial.xzqhCode) : serial.xzqhCode != null) return false;
        if (year != null ? !year.equals(serial.year) : serial.year != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tableType != null ? tableType.hashCode() : 0;
        result = 31 * result + (xzqhCode != null ? xzqhCode.hashCode() : 0);
        result = 31 * result + (tableName != null ? tableName.hashCode() : 0);
        result = 31 * result + flowId;
        result = 31 * result + (flowIdLen != null ? flowIdLen.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        return result;
    }
}
