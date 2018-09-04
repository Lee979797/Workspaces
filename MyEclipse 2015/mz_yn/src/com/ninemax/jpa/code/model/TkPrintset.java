package com.ninemax.jpa.code.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-6-25
 * Time: ÏÂÎç5:45
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.IdClass(TkPrintsetPK.class)
@javax.persistence.Table(name = "tk_printset")
@Entity
public class TkPrintset {
    private String userid;

    @javax.persistence.Column(name = "userid")
    @Id
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    private String bzjgdm;

    @javax.persistence.Column(name = "bzjgdm")
    @Id
    public String getBzjgdm() {
        return bzjgdm;
    }

    public void setBzjgdm(String bzjgdm) {
        this.bzjgdm = bzjgdm;
    }

    private String printPort;

    @javax.persistence.Column(name = "PrintPort")
    @Basic
    public String getPrintPort() {
        return printPort;
    }

    public void setPrintPort(String printPort) {
        this.printPort = printPort;
    }

    private Short communicationPort;

    @javax.persistence.Column(name = "CommunicationPort")
    @Basic
    public Short getCommunicationPort() {
        return communicationPort;
    }

    public void setCommunicationPort(Short communicationPort) {
        this.communicationPort = communicationPort;
    }

    private Integer baudRate;

    @javax.persistence.Column(name = "BaudRate")
    @Basic
    public Integer getBaudRate() {
        return baudRate;
    }

    public void setBaudRate(Integer baudRate) {
        this.baudRate = baudRate;
    }

    private Short printerType;

    @javax.persistence.Column(name = "PrinterType")
    @Basic
    public Short getPrinterType() {
        return printerType;
    }

    public void setPrinterType(Short printerType) {
        this.printerType = printerType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TkPrintset that = (TkPrintset) o;

        if (baudRate != null ? !baudRate.equals(that.baudRate) : that.baudRate != null) return false;
        if (bzjgdm != null ? !bzjgdm.equals(that.bzjgdm) : that.bzjgdm != null) return false;
        if (communicationPort != null ? !communicationPort.equals(that.communicationPort) : that.communicationPort != null)
            return false;
        if (printPort != null ? !printPort.equals(that.printPort) : that.printPort != null) return false;
        if (printerType != null ? !printerType.equals(that.printerType) : that.printerType != null) return false;
        if (userid != null ? !userid.equals(that.userid) : that.userid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userid != null ? userid.hashCode() : 0;
        result = 31 * result + (bzjgdm != null ? bzjgdm.hashCode() : 0);
        result = 31 * result + (printPort != null ? printPort.hashCode() : 0);
        result = 31 * result + (communicationPort != null ? communicationPort.hashCode() : 0);
        result = 31 * result + (baudRate != null ? baudRate.hashCode() : 0);
        result = 31 * result + (printerType != null ? printerType.hashCode() : 0);
        return result;
    }
}
