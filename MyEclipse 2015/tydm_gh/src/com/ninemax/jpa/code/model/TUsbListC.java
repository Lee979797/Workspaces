package com.ninemax.jpa.code.model;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: zhhui
 * Date: 13-9-2
 * Time: ÏÂÎç3:54
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "t_usb_list_c")
@Entity
public class TUsbListC {
    private long id;

    @javax.persistence.Column(name = "id")
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    private String ukey;

    @javax.persistence.Column(name = "ukey")
    @Basic
    public String getUkey() {
        return ukey;
    }

    public void setUkey(String ukey) {
        this.ukey = ukey;
    }

    private String time;

    @javax.persistence.Column(name = "time")
    @Basic
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private String bzjg;

    @javax.persistence.Column(name = "bzjg")
    @Basic
    public String getBzjg() {
        return bzjg;
    }

    public void setBzjg(String bzjg) {
        this.bzjg = bzjg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TUsbListC tUsbListC = (TUsbListC) o;

        if (id != tUsbListC.id) return false;
        if (bzjg != null ? !bzjg.equals(tUsbListC.bzjg) : tUsbListC.bzjg != null) return false;
        if (jgdm != null ? !jgdm.equals(tUsbListC.jgdm) : tUsbListC.jgdm != null) return false;
        if (time != null ? !time.equals(tUsbListC.time) : tUsbListC.time != null) return false;
        if (ukey != null ? !ukey.equals(tUsbListC.ukey) : tUsbListC.ukey != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (jgdm != null ? jgdm.hashCode() : 0);
        result = 31 * result + (ukey != null ? ukey.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (bzjg != null ? bzjg.hashCode() : 0);
        return result;
    }
}
