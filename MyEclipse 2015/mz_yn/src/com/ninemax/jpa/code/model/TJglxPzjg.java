package com.ninemax.jpa.code.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 13-4-9
 * Time: ÏÂÎç4:26
 */
@javax.persistence.IdClass(com.ninemax.jpa.code.model.TJglxPzjgPK.class)
@javax.persistence.Table(name = "sc_jglx_pzjg")
@Entity
public class TJglxPzjg {
    private String jglx;

    @javax.persistence.Column(name = "jglx", nullable = false, insertable = true, updatable = true, length = 1, precision = 0)
    @Id
    public String getJglx() {
        return jglx;
    }

    public void setJglx(String jglx) {
        this.jglx = jglx;
    }

    private String pzjgdm;

    @javax.persistence.Column(name = "pzjgdm", nullable = false, insertable = true, updatable = true, length = 9, precision = 0)
    @Id
    public String getPzjgdm() {
        return pzjgdm;
    }

    public void setPzjgdm(String pzjgdm) {
        this.pzjgdm = pzjgdm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TJglxPzjg tJglxPzjg = (TJglxPzjg) o;

        if (jglx != null ? !jglx.equals(tJglxPzjg.jglx) : tJglxPzjg.jglx != null) return false;
        if (pzjgdm != null ? !pzjgdm.equals(tJglxPzjg.pzjgdm) : tJglxPzjg.pzjgdm != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = jglx != null ? jglx.hashCode() : 0;
        result = 31 * result + (pzjgdm != null ? pzjgdm.hashCode() : 0);
        return result;
    }
}
