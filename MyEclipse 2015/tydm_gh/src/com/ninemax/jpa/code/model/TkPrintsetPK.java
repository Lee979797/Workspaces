package com.ninemax.jpa.code.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-6-25
 * Time: ÏÂÎç5:45
 * To change this template use File | Settings | File Templates.
 */
public class TkPrintsetPK implements Serializable {
    private String userid;

    @Id
    @Column(name = "userid")
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    private String bzjgdm;

    @Id
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

        TkPrintsetPK that = (TkPrintsetPK) o;

        if (bzjgdm != null ? !bzjgdm.equals(that.bzjgdm) : that.bzjgdm != null) return false;
        if (userid != null ? !userid.equals(that.userid) : that.userid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userid != null ? userid.hashCode() : 0;
        result = 31 * result + (bzjgdm != null ? bzjgdm.hashCode() : 0);
        return result;
    }
}
