package com.ninemax.jpa.code.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-6-26
 * Time: ÏÂÎç2:55
 * To change this template use File | Settings | File Templates.
 */
public class TkGskPK implements Serializable {
    private Long kxlh;

    @Id
    @Column(name = "kxlh")
    public Long getKxlh() {
        return kxlh;
    }

    public void setKxlh(Long kxlh) {
        this.kxlh = kxlh;
    }

    private Date gssj;

    @Id
    @Column(name = "gssj")
    public Date getGssj() {
        return gssj;
    }

    public void setGssj(Date gssj) {
        this.gssj = gssj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TkGskPK tkGskPK = (TkGskPK) o;

        if (gssj != null ? !gssj.equals(tkGskPK.gssj) : tkGskPK.gssj != null) return false;
        if (kxlh != null ? !kxlh.equals(tkGskPK.kxlh) : tkGskPK.kxlh != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = kxlh != null ? kxlh.hashCode() : 0;
        result = 31 * result + (gssj != null ? gssj.hashCode() : 0);
        return result;
    }
}
