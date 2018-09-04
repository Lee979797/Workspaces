package com.ninemax.jpa.system.model;
// default package

import javax.persistence.*;


/**
 * Cpfl entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="sc_cpfl")

public class Cpfl  implements java.io.Serializable {




     private Integer id;
     private String cpdm;
     private String skcb;
     private String zryy;
     private String bz;
     private String wj;



    public Cpfl() {
    }


    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", unique=true, nullable=false)

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    @Column(name="cpdm", length=50)

    public String getCpdm() {
        return this.cpdm;
    }
    
    public void setCpdm(String cpdm) {
        this.cpdm = cpdm;
    }
    
    @Column(name="skcb", length=500)

    public String getSkcb() {
        return this.skcb;
    }
    
    public void setSkcb(String skcb) {
        this.skcb = skcb;
    }
    
    @Column(name="zryy")

    public String getZryy() {
        return this.zryy;
    }
    
    public void setZryy(String zryy) {
        this.zryy = zryy;
    }
    
    @Column(name="bz", length=500)

    public String getBz() {
        return this.bz;
    }
    
    public void setBz(String bz) {
        this.bz = bz;
    }
    
    @Column(name="wj", length=20)

    public String getWj() {
        return this.wj;
    }
    
    public void setWj(String wj) {
        this.wj = wj;
    }
   








}