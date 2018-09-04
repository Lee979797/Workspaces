package com.ninemax.jpa.code.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * User: yzhhui
 * Date: 13-5-27
 * Time: ÉÏÎç11:18
 */
@javax.persistence.Table(name = "S_FWQPZ")
@Entity
public class SFwqpz {
    private Integer did;
    private String pzname;
    private Integer ccfs;
    private Integer dbtype;
    private String serveraddr;
    private String username;
    private String passwd;
    private String savedbname;
    private String port;
    private Integer isdefault;
    private String bz;

    @javax.persistence.Column(name = "DID")
    @Id
    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    @javax.persistence.Column(name = "PZNAME")
    @Basic
    public String getPzname() {
        return pzname;
    }

    public void setPzname(String pzname) {
        this.pzname = pzname;
    }

    @javax.persistence.Column(name = "CCFS")
    @Basic
    public Integer getCcfs() {
        return ccfs;
    }

    public void setCcfs(Integer ccfs) {
        this.ccfs = ccfs;
    }

    @javax.persistence.Column(name = "DBTYPE")
    @Basic
    public Integer getDbtype() {
        return dbtype;
    }

    public void setDbtype(Integer dbtype) {
        this.dbtype = dbtype;
    }

    @javax.persistence.Column(name = "SERVERADDR")
    @Basic
    public String getServeraddr() {
        return serveraddr;
    }

    public void setServeraddr(String serveraddr) {
        this.serveraddr = serveraddr;
    }

    @javax.persistence.Column(name = "USERNAME")
    @Basic
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @javax.persistence.Column(name = "PASSWD")
    @Basic
    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @javax.persistence.Column(name = "SAVEDBNAME")
    @Basic
    public String getSavedbname() {
        return savedbname;
    }

    public void setSavedbname(String savedbname) {
        this.savedbname = savedbname;
    }

    @javax.persistence.Column(name = "PORT")
    @Basic
    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    @javax.persistence.Column(name = "ISDEFAULT")
    @Basic
    public Integer getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Integer isdefault) {
        this.isdefault = isdefault;
    }

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

        SFwqpz sFwqpz = (SFwqpz) o;

        if (bz != null ? !bz.equals(sFwqpz.bz) : sFwqpz.bz != null) return false;
        if (ccfs != null ? !ccfs.equals(sFwqpz.ccfs) : sFwqpz.ccfs != null) return false;
        if (dbtype != null ? !dbtype.equals(sFwqpz.dbtype) : sFwqpz.dbtype != null) return false;
        if (did != null ? !did.equals(sFwqpz.did) : sFwqpz.did != null) return false;
        if (isdefault != null ? !isdefault.equals(sFwqpz.isdefault) : sFwqpz.isdefault != null) return false;
        if (passwd != null ? !passwd.equals(sFwqpz.passwd) : sFwqpz.passwd != null) return false;
        if (port != null ? !port.equals(sFwqpz.port) : sFwqpz.port != null) return false;
        if (pzname != null ? !pzname.equals(sFwqpz.pzname) : sFwqpz.pzname != null) return false;
        if (savedbname != null ? !savedbname.equals(sFwqpz.savedbname) : sFwqpz.savedbname != null) return false;
        if (serveraddr != null ? !serveraddr.equals(sFwqpz.serveraddr) : sFwqpz.serveraddr != null) return false;
        if (username != null ? !username.equals(sFwqpz.username) : sFwqpz.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = did != null ? did.hashCode() : 0;
        result = 31 * result + (pzname != null ? pzname.hashCode() : 0);
        result = 31 * result + (ccfs != null ? ccfs.hashCode() : 0);
        result = 31 * result + (dbtype != null ? dbtype.hashCode() : 0);
        result = 31 * result + (serveraddr != null ? serveraddr.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (passwd != null ? passwd.hashCode() : 0);
        result = 31 * result + (savedbname != null ? savedbname.hashCode() : 0);
        result = 31 * result + (port != null ? port.hashCode() : 0);
        result = 31 * result + (isdefault != null ? isdefault.hashCode() : 0);
        result = 31 * result + (bz != null ? bz.hashCode() : 0);
        return result;
    }
}
