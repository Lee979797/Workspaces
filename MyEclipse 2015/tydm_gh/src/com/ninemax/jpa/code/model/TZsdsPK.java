package com.ninemax.jpa.code.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-6-21
 * Time: ÏÂÎç1:43
 */
public class TZsdsPK implements Serializable {
    private String jgdm;

    @Id
    @Column(name = "jgdm", nullable = false, insertable = true, updatable = true, length = 9, precision = 0)
    public String getJgdm() {
        return jgdm;
    }

    public void setJgdm(String jgdm) {
        this.jgdm = jgdm;
    }

    private String djh;

    @Id
    @Column(name = "djh", nullable = false, insertable = true, updatable = true, length = 25, precision = 0)
    public String getDjh() {
        return djh;
    }

    public void setDjh(String djh) {
        this.djh = djh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TZsdsPK tZsdsPK = (TZsdsPK) o;

        if (djh != null ? !djh.equals(tZsdsPK.djh) : tZsdsPK.djh != null) return false;
        if (jgdm != null ? !jgdm.equals(tZsdsPK.jgdm) : tZsdsPK.jgdm != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = jgdm != null ? jgdm.hashCode() : 0;
        result = 31 * result + (djh != null ? djh.hashCode() : 0);
        return result;
    }
}
