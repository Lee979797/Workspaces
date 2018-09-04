package com.ninemax.jpa.code.model;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-5-17
 * Time: ÏÂÎç2:10
 */
@Table(name = "t_pzjg")
@Entity
public class TPzjg {
    private PzjgPK id;
    private String pzjgmc;

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "pzjgdm", column = @Column(name = "pzjgdm")),
            @AttributeOverride(name = "bzjgdm", column = @Column(name = "bzjgdm"))})
    public PzjgPK getId() {
        return id;
    }

    public void setId(PzjgPK id) {
        this.id = id;
    }

    @Column(name = "pzjgmc", nullable = false, insertable = true, updatable = true, length = 70, precision = 0)
    @Basic
    public String getPzjgmc() {
        return pzjgmc;
    }

    public void setPzjgmc(String pzjgmc) {
        this.pzjgmc = pzjgmc;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TPzjg tPzjg = (TPzjg) o;

        if (id != null ? !id.equals(tPzjg.id) : tPzjg.id != null) return false;
        if (pzjgmc != null ? !pzjgmc.equals(tPzjg.pzjgmc) : tPzjg.pzjgmc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (pzjgmc != null ? pzjgmc.hashCode() : 0);
        return result;
    }
}
