package com.ninemax.jpa.code.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 13-4-9
 * Time: ÏÂÎç4:26
 */
public class TJglxPzjgPK implements Serializable {
    private String jglx;

    @Id
    @Column(name = "jglx", nullable = false, insertable = true, updatable = true, length = 1, precision = 0)
    public String getJglx() {
        return jglx;
    }

    public void setJglx(String jglx) {
        this.jglx = jglx;
    }

    private String pzjgdm;

    @Id
    @Column(name = "pzjgdm", nullable = false, insertable = true, updatable = true, length = 9, precision = 0)
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

        TJglxPzjgPK that = (TJglxPzjgPK) o;

        if (jglx != null ? !jglx.equals(that.jglx) : that.jglx != null) return false;
        if (pzjgdm != null ? !pzjgdm.equals(that.pzjgdm) : that.pzjgdm != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = jglx != null ? jglx.hashCode() : 0;
        result = 31 * result + (pzjgdm != null ? pzjgdm.hashCode() : 0);
        return result;
    }
}
