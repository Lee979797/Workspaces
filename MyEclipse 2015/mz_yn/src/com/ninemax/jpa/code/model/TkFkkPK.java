package com.ninemax.jpa.code.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-6-11
 * Time: ÏÂÎç2:38
 * To change this template use File | Settings | File Templates.
 */
public class TkFkkPK implements Serializable {
    private Long kxlh;

    @Id
    @Column(name = "kxlh")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long getKxlh() {
        return kxlh;
    }

    public void setKxlh(Long kxlh) {
        this.kxlh = kxlh;
    }

    private String jgdm;

    @Id
    @Column(name = "jgdm")
    public String getJgdm() {
        return jgdm;
    }

    public void setJgdm(String jgdm) {
        this.jgdm = jgdm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TkFkkPK tkFkkPK = (TkFkkPK) o;

        if (kxlh != tkFkkPK.kxlh) return false;
        if (jgdm != null ? !jgdm.equals(tkFkkPK.jgdm) : tkFkkPK.jgdm != null) return false;

        return true;
    }

}
