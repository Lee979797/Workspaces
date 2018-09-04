package com.ninemax.jpa.system.model;

import javax.persistence.*;

@Entity
@Table(name="DB_Portfolio_log")

public class Portfolio_log  implements java.io.Serializable {


	 private static final long serialVersionUID = 1362622573024478655L;
	 private Integer operid;
     private String userid;
     private String username;
     private String citysiteName;
     private String opername;
     private String opervalue;
     private String operdate;
     private String memo;

	public Portfolio_log(Integer operid, String userid, String username, String citysiteName, String opername, String opervalue, String operdate, String memo) {
		this.operid = operid;
		this.userid = userid;
		this.username = username;
		this.citysiteName = citysiteName;
		this.opername = opername;
		this.opervalue = opervalue;
		this.operdate = operdate;
		this.memo = memo;
	}

	public Portfolio_log() {
    }

    @Id
    
    @Column(name="operid", unique=true, nullable=false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Integer getOperid() {
        return this.operid;
    }
    
    public void setOperid(Integer operid) {
        this.operid = operid;
    }
    
    @Column(name="userid")

    public String getUserid() {
        return this.userid;
    }
    
    public void setUserid(String userid) {
        this.userid = userid;
    }
    
    @Column(name="username")

    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    @Column(name="citysite_name")

    public String getCitysiteName() {
        return this.citysiteName;
    }
    
    public void setCitysiteName(String citysiteName) {
        this.citysiteName = citysiteName;
    }
    
    @Column(name="opername")

    public String getOpername() {
        return this.opername;
    }
    
    public void setOpername(String opername) {
        this.opername = opername;
    }
    
    @Column(name="opervalue")

    public String getOpervalue() {
        return this.opervalue;
    }
    
    public void setOpervalue(String opervalue) {
        this.opervalue = opervalue;
    }

    @Column(name="operdate")
    public String getOperdate() {
        return this.operdate;
    }
    
    public void setOperdate(String operdate) {
        this.operdate = operdate;
    }
    
    @Column(name="memo")

    public String getMemo() {
        return this.memo;
    }
    
    public void setMemo(String memo) {
        this.memo = memo;
    }
   








}