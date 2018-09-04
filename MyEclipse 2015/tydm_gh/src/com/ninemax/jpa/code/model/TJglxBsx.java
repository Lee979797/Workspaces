package com.ninemax.jpa.code.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * User: yzhhui
 * Date: 13-3-20
 * Time: ÉÏÎç9:55
 */
@javax.persistence.IdClass(com.ninemax.jpa.code.model.TJglxBsxPK.class)
@javax.persistence.Table(name = "sc_jglx_bsx")
@Entity
public class TJglxBsx {
    private String jglx;

    @javax.persistence.Column(name = "jglx")
    @Id
    public String getJglx() {
        return jglx;
    }

    public void setJglx(String jglx) {
        this.jglx = jglx;
    }

    private String bsx;

    @javax.persistence.Column(name = "bsx")
    @Id
    public String getBsx() {
        return bsx;
    }

    public void setBsx(String bsx) {
        this.bsx = bsx;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TJglxBsx tJglxBsx = (TJglxBsx) o;

        if (bsx != null ? !bsx.equals(tJglxBsx.bsx) : tJglxBsx.bsx != null) return false;
        if (jglx != null ? !jglx.equals(tJglxBsx.jglx) : tJglxBsx.jglx != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = jglx != null ? jglx.hashCode() : 0;
        result = 31 * result + (bsx != null ? bsx.hashCode() : 0);
        return result;
    }
}
