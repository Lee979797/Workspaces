package com.ninemax.jpa.code.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-6-8
 * Time: ÏÂÎç6:22
 */
@javax.persistence.Table(name = "t_qtmdk")
@Entity
public class TQtmdk {
    private String jgdm;

    @javax.persistence.Column(name = "jgdm", nullable = false, insertable = true, updatable = true, length = 9, precision = 0)
    @Id
    public String getJgdm() {
        return jgdm;
    }

    public void setJgdm(String jgdm) {
        this.jgdm = jgdm;
    }

    private String dmflag;

    @javax.persistence.Column(name = "dmflag", nullable = false, insertable = true, updatable = true, length = 1, precision = 0)
    @Basic
    public String getDmflag() {
        return dmflag;
    }

    public void setDmflag(String dmflag) {
        this.dmflag = dmflag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TQtmdk tQtmdk = (TQtmdk) o;

        if (dmflag != null ? !dmflag.equals(tQtmdk.dmflag) : tQtmdk.dmflag != null) return false;
        if (jgdm != null ? !jgdm.equals(tQtmdk.jgdm) : tQtmdk.jgdm != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = jgdm != null ? jgdm.hashCode() : 0;
        result = 31 * result + (dmflag != null ? dmflag.hashCode() : 0);
        return result;
    }
}
