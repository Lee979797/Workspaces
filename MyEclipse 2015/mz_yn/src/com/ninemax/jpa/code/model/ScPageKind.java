package com.ninemax.jpa.code.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-9-12
 * Time: ÏÂÎç1:07
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "SC_PAGEKIND")
@Entity
public class ScPageKind {
    private String pagekindId;

    @javax.persistence.Column(name = "PAGEKIND_ID")
    @Id
    public String getPagekindId() {
        return pagekindId;
    }

    public void setPagekindId(String pagekindId) {
        this.pagekindId = pagekindId;
    }

    private String pagekindName;

    @javax.persistence.Column(name = "PAGEKIND_NAME")
    @Basic
    public String getPagekindName() {
        return pagekindName;
    }

    public void setPagekindName(String pagekindName) {
        this.pagekindName = pagekindName;
    }

    private String pagekindKey;

    @javax.persistence.Column(name = "PAGEKIND_KEY")
    @Basic
    public String getPagekindKey() {
        return pagekindKey;
    }

    public void setPagekindKey(String pagekindKey) {
        this.pagekindKey = pagekindKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScPageKind that = (ScPageKind) o;

        if (pagekindId != null ? !pagekindId.equals(that.pagekindId) : that.pagekindId != null) return false;
        if (pagekindKey != null ? !pagekindKey.equals(that.pagekindKey) : that.pagekindKey != null) return false;
        if (pagekindName != null ? !pagekindName.equals(that.pagekindName) : that.pagekindName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pagekindId != null ? pagekindId.hashCode() : 0;
        result = 31 * result + (pagekindName != null ? pagekindName.hashCode() : 0);
        result = 31 * result + (pagekindKey != null ? pagekindKey.hashCode() : 0);
        return result;
    }
}
