package com.ninemax.jpa.system.model;
// default package

import javax.persistence.*;
import java.util.Date;


/**
 * SysManage_log entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="DB_SysManage_log")

public class SysManage_log  implements java.io.Serializable {


    // Fields    

     private Integer operid;
     private String userid;
     private String username;
     private String operkindId;
     private String opervalue;
     private Date operdate;
     private String memo;


    // Constructors

    /** default constructor */
    public SysManage_log() {
    }

	/** minimal constructor */
    public SysManage_log(Integer operid) {
        this.operid = operid;
    }
    
    /** full constructor */
    public SysManage_log(Integer operid, String userid, String username, String operkindId, String opervalue, Date operdate, String memo) {
        this.operid = operid;
        this.userid = userid;
        this.username = username;
        this.operkindId = operkindId;
        this.opervalue = opervalue;
        this.operdate = operdate;
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
    
    @Column(name="operkind_id", unique=false, nullable=true, insertable=true, updatable=true, length=8)

    public String getOperkindId() {
        return this.operkindId;
    }
    
    public void setOperkindId(String operkindId) {
        this.operkindId = operkindId;
    }
    
    @Column(name="opervalue", unique=false, nullable=true, insertable=true, updatable=true, length=200)

    public String getOpervalue() {
        return this.opervalue;
    }
    
    public void setOpervalue(String opervalue) {
        this.opervalue = opervalue;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="operdate", unique=false, nullable=true, insertable=true, updatable=true, length=23)

    public Date getOperdate() {
        return this.operdate;
    }
    
    public void setOperdate(Date operdate) {
        this.operdate = operdate;
    }
    
    @Column(name="memo", unique=false, nullable=true, insertable=true, updatable=true, length=10)

    public String getMemo() {
        return this.memo;
    }
    
    public void setMemo(String memo) {
        this.memo = memo;
    }
   








}