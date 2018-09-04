package com.ninemax.tygs.model;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * TGsbgsx entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="t_gsbgsx")

public class TGsbgsx  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String dm;
     private String mc;


    @Id 
    
    @Column(name="id", unique=true, nullable=false)

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    @Column(name="dm", length=50)

    public String getDm() {
        return this.dm;
    }
    
    public void setDm(String dm) {
        this.dm = dm;
    }
    
    @Column(name="mc", length=50)

    public String getMc() {
        return this.mc;
    }
    
    public void setMc(String mc) {
        this.mc = mc;
    }
   








}