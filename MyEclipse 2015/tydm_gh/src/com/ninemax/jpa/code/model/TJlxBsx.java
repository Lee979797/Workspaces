package com.ninemax.jpa.code.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-9-20
 * Time: ÉÏÎç10:26
 */
@javax.persistence.Table(name = "sc_jglx_bsx")
@Entity
public class TJlxBsx {

    @Id
    private String jglx;

    private String bsx;

    @javax.persistence.Column(name = "jglx", nullable = false, insertable = true, updatable = true, length = 1, precision = 0)
    public String getJglx() {
        return jglx;
    }

    public void setJglx(String jglx) {
        this.jglx = jglx;
    }

    @javax.persistence.Column(name = "bsx", nullable = false, insertable = true, updatable = true, length = 20, precision = 0)
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

        TJlxBsx tJlxBsx = (TJlxBsx) o;

        if (bsx != null ? !bsx.equals(tJlxBsx.bsx) : tJlxBsx.bsx != null) return false;
        if (jglx != null ? !jglx.equals(tJlxBsx.jglx) : tJlxBsx.jglx != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = jglx != null ? jglx.hashCode() : 0;
        result = 31 * result + (bsx != null ? bsx.hashCode() : 0);
        return result;
    }
}
