package com.ninemax.jpa.code.model;
// default package

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * TJgdmdmId entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="t_jgdm_dm")

public class TJgdmdm  implements java.io.Serializable {


    // Fields    

     private String jgdm;
     private String jgmc;
     private String fddbr;
     private String jgdz;
     private Date zcrq;
     private String zch;
     private Date bzrq;


    // Constructors





   
    // Property accessors
    @Id
    @Column(name="jgdm", length=9)

    public String getJgdm() {
        return this.jgdm;
    }
    
    public void setJgdm(String jgdm) {
        this.jgdm = jgdm;
    }

    @Column(name="jgmc", length=240)

    public String getJgmc() {
        return this.jgmc;
    }
    
    public void setJgmc(String jgmc) {
        this.jgmc = jgmc;
    }

    @Column(name="fddbr", length=100)

    public String getFddbr() {
        return this.fddbr;
    }
    
    public void setFddbr(String fddbr) {
        this.fddbr = fddbr;
    }

    @Column(name="jgdz", length=240)

    public String getJgdz() {
        return this.jgdz;
    }
    
    public void setJgdz(String jgdz) {
        this.jgdz = jgdz;
    }

    @Column(name="zcrq", length=23)

    public Date getZcrq() {
        return this.zcrq;
    }
    
    public void setZcrq(Date zcrq) {
        this.zcrq = zcrq;
    }

    @Column(name="zch", length=70)

    public String getZch() {
        return this.zch;
    }
    
    public void setZch(String zch) {
        this.zch = zch;
    }

    @Column(name="bzrq", length=23)

    public Date getBzrq() {
        return this.bzrq;
    }
    
    public void setBzrq(Date bzrq) {
        this.bzrq = bzrq;
    }
   








}