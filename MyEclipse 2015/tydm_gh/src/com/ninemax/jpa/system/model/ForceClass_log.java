package com.ninemax.jpa.system.model;
// default package

import javax.persistence.*;
import java.util.Date;


/**
 * ForceClass entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="DB_ForceClass_log")

public class ForceClass_log  implements java.io.Serializable {


    // Fields    

     private Integer operid;
     private String userid;
     private String username;
     private String citysiteId;
     private String citysiteName;
     private String operName;
     private String productName;
     private String tongue;
     private String productClass;
     private Date operDate;
     private String memo;


    // Constructors

    /** default constructor */
    public ForceClass_log() {
    }

	/** minimal constructor */
    public ForceClass_log(Integer operid) {
        this.operid = operid;
    }
    
    /** full constructor */
    public ForceClass_log(Integer operid, String userid, String username, String citysiteId, String citysiteName, String operName, String productName, String tongue, String productClass, Date operDate, String memo) {
        this.operid = operid;
        this.userid = userid;
        this.username = username;
        this.citysiteId = citysiteId;
        this.citysiteName = citysiteName;
        this.operName = operName;
        this.productName = productName;
        this.tongue = tongue;
        this.productClass = productClass;
        this.operDate = operDate;
        this.memo = memo;
    }

   
    // Property accessors
    @Id
    
    @Column(name="operid", unique=true, nullable=false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Integer getOperid() {
        return this.operid;
    }
    
    public void setOperid(Integer operid) {
        this.operid = operid;
    }
    
    @Column(name="userid", unique=false, nullable=true, insertable=true, updatable=true, length=10)

    public String getUserid() {
        return this.userid;
    }
    
    public void setUserid(String userid) {
        this.userid = userid;
    }
    
    @Column(name="username", unique=false, nullable=true, insertable=true, updatable=true, length=20)

    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    @Column(name="Citysite_id", unique=false, nullable=true, insertable=true, updatable=true, length=8)

    public String getCitysiteId() {
        return this.citysiteId;
    }
    
    public void setCitysiteId(String citysiteId) {
        this.citysiteId = citysiteId;
    }
    
    @Column(name="Citysite_name", unique=false, nullable=true, insertable=true, updatable=true, length=50)

    public String getCitysiteName() {
        return this.citysiteName;
    }
    
    public void setCitysiteName(String citysiteName) {
        this.citysiteName = citysiteName;
    }
    
    @Column(name="oper_name", unique=false, nullable=true, insertable=true, updatable=true, length=10)

    public String getOperName() {
        return this.operName;
    }
    
    public void setOperName(String operName) {
        this.operName = operName;
    }
    
    @Column(name="product_name", unique=false, nullable=true, insertable=true, updatable=true, length=50)

    public String getProductName() {
        return this.productName;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    @Column(name="Tongue", unique=false, nullable=true, insertable=true, updatable=true, length=50)

    public String getTongue() {
        return this.tongue;
    }
    
    public void setTongue(String tongue) {
        this.tongue = tongue;
    }
    
    @Column(name="Product_class", unique=false, nullable=true, insertable=true, updatable=true, length=6)

    public String getProductClass() {
        return this.productClass;
    }
    
    public void setProductClass(String productClass) {
        this.productClass = productClass;
    }
@Temporal(TemporalType.DATE)
    @Column(name="Oper_date", unique=false, nullable=true, insertable=true, updatable=true, length=23)

    public Date getOperDate() {
        return this.operDate;
    }
    
    public void setOperDate(Date operDate) {
        this.operDate = operDate;
    }
    
    @Column(name="Memo", unique=false, nullable=true, insertable=true, updatable=true, length=10)

    public String getMemo() {
        return this.memo;
    }
    
    public void setMemo(String memo) {
        this.memo = memo;
    }
   








}