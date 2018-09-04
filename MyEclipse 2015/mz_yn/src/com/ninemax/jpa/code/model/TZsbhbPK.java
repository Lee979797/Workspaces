package com.ninemax.jpa.code.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-16
 * Time: ÏÂÎç6:13
 * To change this template use File | Settings | File Templates.
 */
public class TZsbhbPK implements Serializable {
    private String zsbh;

    @Id
    @Column(name = "zsbh")
    public String getZsbh() {
        return zsbh;
    }

    public void setZsbh(String zsbh) {
        this.zsbh = zsbh;
    }

    private String zslx;

    @Id
    @Column(name = "zslx")
    public String getZslx() {
        return zslx;
    }

    public void setZslx(String zslx) {
        this.zslx = zslx;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TZsbhbPK tZsbhbPK = (TZsbhbPK) o;

        if (zsbh != null ? !zsbh.equals(tZsbhbPK.zsbh) : tZsbhbPK.zsbh != null) return false;
        if (zslx != null ? !zslx.equals(tZsbhbPK.zslx) : tZsbhbPK.zslx != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = zsbh != null ? zsbh.hashCode() : 0;
        result = 31 * result + (zslx != null ? zslx.hashCode() : 0);
        return result;
    }
}
