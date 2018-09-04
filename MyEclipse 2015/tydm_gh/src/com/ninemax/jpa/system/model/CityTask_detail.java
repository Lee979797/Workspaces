package com.ninemax.jpa.system.model;
// default package

import javax.persistence.*;


/**
 * CityTask_detail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="db_CityTask_detail")

public class CityTask_detail  implements java.io.Serializable {


    // Fields    
     private int id;
     private String citySiteId;
     private String taksId;
     private String codeId;
     private String finishdate;
     private String status;
     private String memo;

    // Constructors

    /** default constructor */
    public CityTask_detail() {
    }

    // Property accessors

    @Id
    @Column(name="id", unique=true, nullable=false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="CitySite_id",nullable = false,length = 8)
    public String getCitySiteId() {
        return citySiteId;
    }

    public void setCitySiteId(String citySiteId) {
        this.citySiteId = citySiteId;
    }

    @Column(name = "TaskID",nullable = false,length = 9)
    public String getTaksId() {
        return taksId;
    }

    public void setTaksId(String taksId) {
        this.taksId = taksId;
    }

    @Column(name="Code_id", nullable=false, length=9)

    public String getCodeId() {
        return this.codeId;
    }
    
    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }
    
    @Column(name="Finishdate", length=23)

    public String getFinishdate() {
        return this.finishdate;
    }
    
    public void setFinishdate(String finishdate) {
        this.finishdate = finishdate;
    }
    
    @Column(name="Status", length=2)

    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    @Column(name="Memo", length=10)

    public String getMemo() {
        return this.memo;
    }
    
    public void setMemo(String memo) {
        this.memo = memo;
    }
   








}