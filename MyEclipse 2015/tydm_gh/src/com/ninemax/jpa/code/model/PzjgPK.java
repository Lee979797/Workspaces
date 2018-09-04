package com.ninemax.jpa.code.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * User: yzhhui
 * Date: 13-4-11
 * Time: ÏÂÎç3:49
 */
@Embeddable
public class PzjgPK implements Serializable {
    private String pzjgdm;
    private String bzjgdm;

    @Column(name = "pzjgdm")
    public String getPzjgdm() {
        return pzjgdm;
    }

    public void setPzjgdm(String pzjgdm) {
        this.pzjgdm = pzjgdm;
    }

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

        PzjgPK serialPK = (PzjgPK) o;

        if (pzjgdm != null ? !pzjgdm.equals(serialPK.pzjgdm) : serialPK.pzjgdm != null) return false;
        if (bzjgdm != null ? !bzjgdm.equals(serialPK.bzjgdm) : serialPK.bzjgdm != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pzjgdm != null ? pzjgdm.hashCode() : 0;
        result = 31 * result + (bzjgdm != null ? bzjgdm.hashCode() : 0);
        return result;
    }
}
