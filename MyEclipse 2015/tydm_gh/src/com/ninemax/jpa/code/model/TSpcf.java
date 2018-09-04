package com.ninemax.jpa.code.model;

import javax.persistence.*;

/**
 * User: ninemax-199
 * Date: 13-1-31
 * Time: ÏÂÎç4:53
 */
@javax.persistence.Table(name = "t_spcf")
@Entity
public class TSpcf {
    private Long lsh;

    @javax.persistence.Column(name = "lsh")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getLsh() {
        return lsh;
    }

    public void setLsh(Long lsh) {
        this.lsh = lsh;
    }

    private String jgdm;

    @javax.persistence.Column(name = "jgdm")
    @Basic
    public String getJgdm() {
        return jgdm;
    }

    public void setJgdm(String jgdm) {
        this.jgdm = jgdm;
    }

    private String jgmc;

    @javax.persistence.Column(name = "jgmc")
    @Basic
    public String getJgmc() {
        return jgmc;
    }

    public void setJgmc(String jgmc) {
        this.jgmc = jgmc;
    }

    private String zch;

    @javax.persistence.Column(name = "zch")
    @Basic
    public String getZch() {
        return zch;
    }

    public void setZch(String zch) {
        this.zch = zch;
    }


    private Boolean canUse;

    @javax.persistence.Column(name = "canUse")
    public Boolean getCanUse() {
        return canUse;
    }

    public void setCanUse(Boolean canUse) {
        this.canUse = canUse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TSpcf that = (TSpcf) o;

        if (canUse == that.canUse) if (lsh.equals(that.lsh))
            if (!(jgdm != null ? !jgdm.equals(that.jgdm) : that.jgdm != null))
                if (!(jgmc != null ? !jgmc.equals(that.jgmc) : that.jgmc != null)) return true;
        return false;
    }

    @Override
    public int hashCode() {
        Integer result = (int) (lsh ^ (lsh >>> 32));
        result = 31 * result + (jgdm != null ? jgdm.hashCode() : 0);
        result = 31 * result + (jgmc != null ? jgmc.hashCode() : 0);
        result = 31 * result + (zch != null ? zch.hashCode() : 0);
        result = 31 * result + (canUse ? 1 : 0);
        return result;
    }
}
