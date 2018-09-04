package com.ninemax.jpa.code.model;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-10-9
 * Time: ÏÂÎç1:55
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "P_FILE0")
@Entity
public class PFile0 {
    private Integer did;

    @javax.persistence.Column(name = "DID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    private Integer pid;

    @javax.persistence.Column(name = "PID")
    @Basic
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    private Integer arcid;

    @javax.persistence.Column(name = "ARCID")
    @Basic
    public Integer getArcid() {
        return arcid;
    }

    public void setArcid(Integer arcid) {
        this.arcid = arcid;
    }

    private Integer pageid;

    @javax.persistence.Column(name = "PAGEID")
    @Basic
    public Integer getPageid() {
        return pageid;
    }

    public void setPageid(Integer pageid) {
        this.pageid = pageid;
    }

    private Integer pageno;

    @javax.persistence.Column(name = "PAGENO")
    @Basic
    public Integer getPageno() {
        return pageno;
    }

    public void setPageno(Integer pageno) {
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

    private String bz;

    @javax.persistence.Column(name = "BZ")
    @Basic
    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PFile0 pFile0 = (PFile0) o;

        if (arcid != null ? !arcid.equals(pFile0.arcid) : pFile0.arcid != null) return false;
        if (bz != null ? !bz.equals(pFile0.bz) : pFile0.bz != null) return false;
        if (did != null ? !did.equals(pFile0.did) : pFile0.did != null) return false;
        if (pageid != null ? !pageid.equals(pFile0.pageid) : pFile0.pageid != null) return false;
        if (pageno != null ? !pageno.equals(pFile0.pageno) : pFile0.pageno != null) return false;
        if (pagetype != null ? !pagetype.equals(pFile0.pagetype) : pFile0.pagetype != null) return false;
        if (pid != null ? !pid.equals(pFile0.pid) : pFile0.pid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = did != null ? did.hashCode() : 0;
        result = 31 * result + (pid != null ? pid.hashCode() : 0);
        result = 31 * result + (arcid != null ? arcid.hashCode() : 0);
        result = 31 * result + (pageid != null ? pageid.hashCode() : 0);
        result = 31 * result + (pageno != null ? pageno.hashCode() : 0);
        result = 31 * result + (pagetype != null ? pagetype.hashCode() : 0);
        result = 31 * result + (bz != null ? bz.hashCode() : 0);
        return result;
    }
}
