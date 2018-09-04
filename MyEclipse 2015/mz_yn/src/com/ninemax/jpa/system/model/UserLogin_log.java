package com.ninemax.jpa.system.model;
// default package

import javax.persistence.*;


/**
 * UserLogin_log entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="DB_UserLogin_log")

public class UserLogin_log  implements java.io.Serializable {


    // Fields    

     private Integer loginid;
     private String userid;
     private String username;
     private String userIp;
     private String logindate;
     private String memo;


    // Constructors

    /** default constructor */
    public UserLogin_log() {
    }

	/** minimal constructor */
    public UserLogin_log(Integer loginid, String userid, String username) {
        this.loginid = loginid;
        this.userid = userid;
        this.username = username;
    }
    
    /** full constructor */
    public UserLogin_log(Integer loginid, String userid, String username, String userIp, String logindate, String memo) {
        this.loginid = loginid;
        this.userid = userid;
        this.username = username;
        this.userIp = userIp;
        this.logindate = logindate;
        this.memo = memo;
    }

   
    // Property accessors
    @Id
    
    @Column(name="loginid", unique=true, nullable=false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Integer getLoginid() {
        return this.loginid;
    }
    
    public void setLoginid(Integer loginid) {
        this.loginid = loginid;
    }
    
    @Column(name="userid", unique=false, nullable=false, insertable=true, updatable=true, length=10)

    public String getUserid() {
        return this.userid;
    }
    
    public void setUserid(String userid) {
        this.userid = userid;
    }
    
    @Column(name="username", unique=false, nullable=false, insertable=true, updatable=true, length=20)

    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    @Column(name="user_ip", unique=false, nullable=true, insertable=true, updatable=true, length=20)

    public String getUserIp() {
        return this.userIp;
    }
    
    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }
    
    @Column(name="logindate", unique=false, nullable=true, insertable=true, updatable=true, length=21)

    public String getLogindate() {
        return this.logindate;
    }
    
    public void setLogindate(String logindate) {
        this.logindate = logindate;
    }
    
    @Column(name="memo", unique=false, nullable=true, insertable=true, updatable=true, length=10)

    public String getMemo() {
        return this.memo;
    }
    
    public void setMemo(String memo) {
        this.memo = memo;
    }
   








}