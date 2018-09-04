package com.ninemax.jpa.code.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * User: yzhhui
 * Date: 13-3-20
 * Time: ÉÏÎç9:55
 */
public class TJglxBsxPK implements Serializable {
    private String jglx;

    @Id
    @Column(name = "jglx")
    public String getJglx() {
        return jglx;
    }

    public void setJglx(String jglx) {
        this.jglx = jglx;
    }

    private String bsx;

    @Id
    @Column(name = "bsx")
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

        TJglxBsxPK that = (TJglxBsxPK) o;

        if (bsx != null ? !bsx.equals(that.bsx) : that.bsx != null) return false;
        if (jglx != null ? !jglx.equals(that.jglx) : that.jglx != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = jglx != null ? jglx.hashCode() : 0;
        result = 31 * result + (bsx != null ? bsx.hashCode() : 0);
        return result;
    }
}
