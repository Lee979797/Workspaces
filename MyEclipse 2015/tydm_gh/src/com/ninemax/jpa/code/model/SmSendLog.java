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
@javax.persistence.Table(name = "SM_SendLog")
@Entity
public class SmSendLog {
    private Integer tempid;

    @javax.persistence.Column(name = "tempid")
    @Id
    public Integer getTempid() {
        return tempid;
    }

    public void setTempid(Integer tempid) {
        this.tempid = tempid;
    }

    private Integer zkCount;

    @javax.persistence.Column(name = "zkCount")
    @Basic
    public Integer getZkCount() {
        return zkCount;
    }

    public void setZkCount(Integer zkCount) {
        this.zkCount = zkCount;
    }

    private Integer fzCount;

    @javax.persistence.Column(name = "fzCount")
    @Basic
    public Integer getFzCount() {
        return fzCount;
    }

    public void setFzCount(Integer fzCount) {
        this.fzCount = fzCount;
    }

    private Integer delCount;

    @javax.persistence.Column(name = "delCount")
    @Basic
    public Integer getDelCount() {
        return delCount;
    }

    public void setDelCount(Integer delCount) {
        this.delCount = delCount;
    }

    private Integer qzCount;

    @javax.persistence.Column(name = "qzCount")
    @Basic
    public Integer getQzCount() {
        return qzCount;
    }

    public void setQzCount(Integer qzCount) {
        this.qzCount = qzCount;
    }

    private Integer zkSendSuccCount;

    @javax.persistence.Column(name = "zkSendSuccCount")
    @Basic
    public Integer getZkSendSuccCount() {
        return zkSendSuccCount;
    }

    public void setZkSendSuccCount(Integer zkSendSuccCount) {
        this.zkSendSuccCount = zkSendSuccCount;
    }

    private Integer fzSendSuccCount;

    @javax.persistence.Column(name = "fzSendSuccCount")
    @Basic
    public Integer getFzSendSuccCount() {
        return fzSendSuccCount;
    }

    public void setFzSendSuccCount(Integer fzSendSuccCount) {
        this.fzSendSuccCount = fzSendSuccCount;
    }

    private Integer delSendSuccCount;

    @javax.persistence.Column(name = "delSendSuccCount")
    @Basic
    public Integer getDelSendSuccCount() {
        return delSendSuccCount;
    }

    public void setDelSendSuccCount(Integer delSendSuccCount) {
        this.delSendSuccCount = delSendSuccCount;
    }

    private Integer qzSendSuccCount;

    @javax.persistence.Column(name = "qzSendSuccCount")
    @Basic
    public Integer getQzSendSuccCount() {
        return qzSendSuccCount;
    }

    public void setQzSendSuccCount(Integer qzSendSuccCount) {
        this.qzSendSuccCount = qzSendSuccCount;
    }

    private Integer zkStorageCount;

    @javax.persistence.Column(name = "zkStorageCount")
    @Basic
    public Integer getZkStorageCount() {
        return zkStorageCount;
    }

    public void setZkStorageCount(Integer zkStorageCount) {
        this.zkStorageCount = zkStorageCount;
    }

    private Integer fzStorageCount;

    @javax.persistence.Column(name = "fzStorageCount")
    @Basic
    public Integer getFzStorageCount() {
        return fzStorageCount;
    }

    public void setFzStorageCount(Integer fzStorageCount) {
        this.fzStorageCount = fzStorageCount;
    }

    private Integer delStorageCount;

    @javax.persistence.Column(name = "delStorageCount")
    @Basic
    public Integer getDelStorageCount() {
        return delStorageCount;
    }

    public void setDelStorageCount(Integer delStorageCount) {
        this.delStorageCount = delStorageCount;
    }

    private Integer qzStorageCount;

    @javax.persistence.Column(name = "qzStorageCount")
    @Basic
    public Integer getQzStorageCount() {
        return qzStorageCount;
    }

    public void setQzStorageCount(Integer qzStorageCount) {
        this.qzStorageCount = qzStorageCount;
    }

    private String clDate;

    @javax.persistence.Column(name = "ClDate")
    @Basic
    public String getClDate() {
        return clDate;
    }

    public void setClDate(String clDate) {
        this.clDate = clDate;
    }

    private Integer reCodeCount;

    @javax.persistence.Column(name = "ReCodeCount")
    @Basic
    public Integer getReCodeCount() {
        return reCodeCount;
    }

    public void setReCodeCount(Integer reCodeCount) {
        this.reCodeCount = reCodeCount;
    }

    private Integer reReportedCount;

    @javax.persistence.Column(name = "ReReportedCount")
    @Basic
    public Integer getReReportedCount() {
        return reReportedCount;
    }

    public void setReReportedCount(Integer reReportedCount) {
        this.reReportedCount = reReportedCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SmSendLog smSendLog = (SmSendLog) o;

        if (clDate != null ? !clDate.equals(smSendLog.clDate) : smSendLog.clDate != null) return false;
        if (delCount != null ? !delCount.equals(smSendLog.delCount) : smSendLog.delCount != null) return false;
        if (delSendSuccCount != null ? !delSendSuccCount.equals(smSendLog.delSendSuccCount) : smSendLog.delSendSuccCount != null)
            return false;
        if (delStorageCount != null ? !delStorageCount.equals(smSendLog.delStorageCount) : smSendLog.delStorageCount != null)
            return false;
        if (fzCount != null ? !fzCount.equals(smSendLog.fzCount) : smSendLog.fzCount != null) return false;
        if (fzSendSuccCount != null ? !fzSendSuccCount.equals(smSendLog.fzSendSuccCount) : smSendLog.fzSendSuccCount != null)
            return false;
        if (fzStorageCount != null ? !fzStorageCount.equals(smSendLog.fzStorageCount) : smSendLog.fzStorageCount != null)
            return false;
        if (qzCount != null ? !qzCount.equals(smSendLog.qzCount) : smSendLog.qzCount != null) return false;
        if (qzSendSuccCount != null ? !qzSendSuccCount.equals(smSendLog.qzSendSuccCount) : smSendLog.qzSendSuccCount != null)
            return false;
        if (qzStorageCount != null ? !qzStorageCount.equals(smSendLog.qzStorageCount) : smSendLog.qzStorageCount != null)
            return false;
        if (reCodeCount != null ? !reCodeCount.equals(smSendLog.reCodeCount) : smSendLog.reCodeCount != null)
            return false;
        if (reReportedCount != null ? !reReportedCount.equals(smSendLog.reReportedCount) : smSendLog.reReportedCount != null)
            return false;
        if (tempid != null ? !tempid.equals(smSendLog.tempid) : smSendLog.tempid != null) return false;
        if (zkCount != null ? !zkCount.equals(smSendLog.zkCount) : smSendLog.zkCount != null) return false;
        if (zkSendSuccCount != null ? !zkSendSuccCount.equals(smSendLog.zkSendSuccCount) : smSendLog.zkSendSuccCount != null)
            return false;
        if (zkStorageCount != null ? !zkStorageCount.equals(smSendLog.zkStorageCount) : smSendLog.zkStorageCount != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tempid != null ? tempid.hashCode() : 0;
        result = 31 * result + (zkCount != null ? zkCount.hashCode() : 0);
        result = 31 * result + (fzCount != null ? fzCount.hashCode() : 0);
        result = 31 * result + (delCount != null ? delCount.hashCode() : 0);
        result = 31 * result + (qzCount != null ? qzCount.hashCode() : 0);
        result = 31 * result + (zkSendSuccCount != null ? zkSendSuccCount.hashCode() : 0);
        result = 31 * result + (fzSendSuccCount != null ? fzSendSuccCount.hashCode() : 0);
        result = 31 * result + (delSendSuccCount != null ? delSendSuccCount.hashCode() : 0);
        result = 31 * result + (qzSendSuccCount != null ? qzSendSuccCount.hashCode() : 0);
        result = 31 * result + (zkStorageCount != null ? zkStorageCount.hashCode() : 0);
        result = 31 * result + (fzStorageCount != null ? fzStorageCount.hashCode() : 0);
        result = 31 * result + (delStorageCount != null ? delStorageCount.hashCode() : 0);
        result = 31 * result + (qzStorageCount != null ? qzStorageCount.hashCode() : 0);
        result = 31 * result + (clDate != null ? clDate.hashCode() : 0);
        result = 31 * result + (reCodeCount != null ? reCodeCount.hashCode() : 0);
        result = 31 * result + (reReportedCount != null ? reReportedCount.hashCode() : 0);
        return result;
    }
}
