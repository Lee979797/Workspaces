package com.ninemax.jpa.code.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-19
 * Time: ÏÂÎç5:10
 * To change this template use File | Settings | File Templates.
 */
public class TZgtzdPK implements Serializable {
    private String zglsh;

    @Id
    @Column(name = "zglsh")
    public String getZglsh() {
        return zglsh;
    }

    public void setZglsh(String zglsh) {
        this.zglsh = zglsh;
    }

    private String bzjgdm;

    @Id
    @Column(name = "bzjgdm")
    public String getBzjgdm() {
        return bzjgdm;
    }

    public void setBzjgdm(String bzjgdm) {
        this.bzjgdm = bzjgdm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TZgtzdPK tZgtzdPK = (TZgtzdPK) o;

        if (bzjgdm != null ? !bzjgdm.equals(tZgtzdPK.bzjgdm) : tZgtzdPK.bzjgdm != null) return false;
        if (zglsh != null ? !zglsh.equals(tZgtzdPK.zglsh) : tZgtzdPK.zglsh != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = zglsh != null ? zglsh.hashCode() : 0;
        result = 31 * result + (bzjgdm != null ? bzjgdm.hashCode() : 0);
        return result;
    }
}
