package com.ninemax.jpa.code.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-11
 * Time: ÉÏÎç10:59
 * To change this template use File | Settings | File Templates.
 */
public class TZsslPK implements Serializable {
    private String xzqh;

    @Id
    @Column(name = "xzqh")
    public String getXzqh() {
        return xzqh;
    }

    public void setXzqh(String xzqh) {
        this.xzqh = xzqh;
    }

    private String type;

    @Id
    @Column(name = "type")
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

        TZsslPK tZsslPK = (TZsslPK) o;

        if (type != null ? !type.equals(tZsslPK.type) : tZsslPK.type != null) return false;
        if (xzqh != null ? !xzqh.equals(tZsslPK.xzqh) : tZsslPK.xzqh != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = xzqh != null ? xzqh.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
