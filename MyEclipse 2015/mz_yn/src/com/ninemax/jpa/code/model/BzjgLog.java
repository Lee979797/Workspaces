package com.ninemax.jpa.code.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-8-15
 * Time: ÏÂÎç5:41
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "BZJG_LOG")
@Entity
public class BzjgLog {
    private Integer id;

    @javax.persistence.Column(name = "ID")
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String bzjgId;

    @javax.persistence.Column(name = "BZJG_ID")
    @Basic
    public String getBzjgId() {
        return bzjgId;
    }

    public void setBzjgId(String bzjgId) {
        this.bzjgId = bzjgId;
    }

    private Integer zkcount;

    @javax.persistence.Column(name = "ZKCOUNT")
    @Basic
    public Integer getZkcount() {
        return zkcount;
    }

    public void setZkcount(Integer zkcount) {
        this.zkcount = zkcount;
    }

    private Integer fzcount;

    @javax.persistence.Column(name = "FZCOUNT")
    @Basic
    public Integer getFzcount() {
        return fzcount;
    }

    public void setFzcount(Integer fzcount) {
        this.fzcount = fzcount;
    }

    private Integer delcount;

    @javax.persistence.Column(name = "DELCOUNT")
    @Basic
    public Integer getDelcount() {
        return delcount;
    }

    public void setDelcount(Integer delcount) {
        this.delcount = delcount;
    }

    private Integer qzcount;

    @javax.persistence.Column(name = "QZCOUNT")
    @Basic
    public Integer getQzcount() {
        return qzcount;
    }

    public void setQzcount(Integer qzcount) {
        this.qzcount = qzcount;
    }

    private String logDate;

    @javax.persistence.Column(name = "LOG_DATE")
    @Basic
    public String getLogDate() {
        return logDate;
    }

    public void setLogDate(String logDate) {
        this.logDate = logDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BzjgLog bzjgLog = (BzjgLog) o;

        if (bzjgId != null ? !bzjgId.equals(bzjgLog.bzjgId) : bzjgLog.bzjgId != null) return false;
        if (delcount != null ? !delcount.equals(bzjgLog.delcount) : bzjgLog.delcount != null) return false;
        if (fzcount != null ? !fzcount.equals(bzjgLog.fzcount) : bzjgLog.fzcount != null) return false;
        if (id != null ? !id.equals(bzjgLog.id) : bzjgLog.id != null) return false;
        if (logDate != null ? !logDate.equals(bzjgLog.logDate) : bzjgLog.logDate != null) return false;
        if (qzcount != null ? !qzcount.equals(bzjgLog.qzcount) : bzjgLog.qzcount != null) return false;
        if (zkcount != null ? !zkcount.equals(bzjgLog.zkcount) : bzjgLog.zkcount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (bzjgId != null ? bzjgId.hashCode() : 0);
        result = 31 * result + (zkcount != null ? zkcount.hashCode() : 0);
        result = 31 * result + (fzcount != null ? fzcount.hashCode() : 0);
        result = 31 * result + (delcount != null ? delcount.hashCode() : 0);
        result = 31 * result + (qzcount != null ? qzcount.hashCode() : 0);
        result = 31 * result + (logDate != null ? logDate.hashCode() : 0);
        return result;
    }
}
