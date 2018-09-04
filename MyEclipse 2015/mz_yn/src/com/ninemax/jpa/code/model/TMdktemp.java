package com.ninemax.jpa.code.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-11
 * Time: ÏÂÎç3:43
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "t_mdktemp")
@Entity
public class TMdktemp {
    private String jgdm;

    @javax.persistence.Column(name = "jgdm")
    @Id
    public String getJgdm() {
        return jgdm;
    }

    public void setJgdm(String jgdm) {
        this.jgdm = jgdm;
    }

    private String dmflag;

    @javax.persistence.Column(name = "dmflag")
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

        TMdktemp tMdktemp = (TMdktemp) o;

        if (dmflag != null ? !dmflag.equals(tMdktemp.dmflag) : tMdktemp.dmflag != null) return false;
        if (jgdm != null ? !jgdm.equals(tMdktemp.jgdm) : tMdktemp.jgdm != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = jgdm != null ? jgdm.hashCode() : 0;
        result = 31 * result + (dmflag != null ? dmflag.hashCode() : 0);
        return result;
    }
}
