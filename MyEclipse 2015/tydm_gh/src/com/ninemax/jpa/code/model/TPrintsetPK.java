package com.ninemax.jpa.code.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-11
 * Time: ÏÂÎç1:23
 * To change this template use File | Settings | File Templates.
 */
public class TPrintsetPK implements Serializable {
    private String item;

    @Id
    @Column(name = "item")
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    private String userid;

    @Id
    @Column(name = "userid")
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TPrintsetPK that = (TPrintsetPK) o;

        if (item != null ? !item.equals(that.item) : that.item != null) return false;
        if (userid != null ? !userid.equals(that.userid) : that.userid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = item != null ? item.hashCode() : 0;
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        return result;
    }
}
