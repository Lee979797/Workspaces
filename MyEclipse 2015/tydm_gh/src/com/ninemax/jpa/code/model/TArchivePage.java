package com.ninemax.jpa.code.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * User: zhhuiyan
 * Date: 12-9-12
 * Time: ÏÂÎç1:07
 */
@javax.persistence.Table(name = "T_ARCHIVEPAGE")
@Entity
public class TArchivePage {
    private String archid;

    @javax.persistence.Column(name = "ARCHID")
    @Id
    public String getArchid() {
        return archid;
    }

    public void setArchid(String archid) {
        this.archid = archid;
    }

    private String pagekindid;

    @javax.persistence.Column(name = "PAGEKINDID")
    @Basic
    public String getPagekindid() {
        return pagekindid;
    }

    public void setPagekindid(String pagekindid) {
        this.pagekindid = pagekindid;
    }

    private String pageno;

    @javax.persistence.Column(name = "PAGENO")
    @Basic
    public String getPageno() {
        return pageno;
    }

    public void setPageno(String pageno) {
        this.pageno = pageno;
    }

    private String pagetype;

    @javax.persistence.Column(name = "PAGETYPE")
    @Basic
    public String getPagetype() {
        return pagetype;
    }

    public void setPagetype(String pagetype) {
        this.pagetype = pagetype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TArchivePage that = (TArchivePage) o;

        if (archid != null ? !archid.equals(that.archid) : that.archid != null) return false;
        if (pagekindid != null ? !pagekindid.equals(that.pagekindid) : that.pagekindid != null) return false;
        if (pageno != null ? !pageno.equals(that.pageno) : that.pageno != null) return false;
        if (pagetype != null ? !pagetype.equals(that.pagetype) : that.pagetype != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = archid != null ? archid.hashCode() : 0;
        result = 31 * result + (pagekindid != null ? pagekindid.hashCode() : 0);
        result = 31 * result + (pageno != null ? pageno.hashCode() : 0);
        result = 31 * result + (pagetype != null ? pagetype.hashCode() : 0);
        return result;
    }
}
