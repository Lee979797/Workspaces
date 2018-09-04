package com.ninemax.jpa.code.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-5-29
 * Time: ÏÂÎç3:33
 */
@javax.persistence.Table(name = "t_jjlxdz")
@Entity
public class TJjlxdz {
    private String newdm;

    @javax.persistence.Column(name = "newdm", nullable = false, insertable = true, updatable = true, length = 255, precision = 0)
    @Id
    public String getNewdm() {
        return newdm;
    }

    public void setNewdm(String newdm) {
        this.newdm = newdm;
    }

    private String olddm;

    @javax.persistence.Column(name = "olddm", nullable = true, insertable = true, updatable = true, length = 255, precision = 0)
    @Basic
    public String getOlddm() {
        return olddm;
    }

    public void setOlddm(String olddm) {
        this.olddm = olddm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TJjlxdz tJjlxdz = (TJjlxdz) o;

        if (newdm != null ? !newdm.equals(tJjlxdz.newdm) : tJjlxdz.newdm != null) return false;
        if (olddm != null ? !olddm.equals(tJjlxdz.olddm) : tJjlxdz.olddm != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = newdm != null ? newdm.hashCode() : 0;
        result = 31 * result + (olddm != null ? olddm.hashCode() : 0);
        return result;
    }
}
