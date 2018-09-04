package com.ninemax.tygs.model;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * TQybgxx entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="t_qydjbgxx")

public class TQybgxx  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String pripid;
     private String regno;
     private String entName;
     private String tstime;
     private String status;

  
    @Id 
    
    @Column(name="id", unique=true, nullable=false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    @Column(name="pripid", length=50)

    public String getPripid() {
        return this.pripid;
    }
    
    public void setPripid(String pripid) {
        this.pripid = pripid;
    }
    
    @Column(name="regno", length=50)

    public String getRegno() {
        return this.regno;
    }
    
    public void setRegno(String regno) {
        this.regno = regno;
    }
    
    @Column(name="entName", length=500)

    public String getEntName() {
        return this.entName;
    }
    
    public void setEntName(String entName) {
        this.entName = entName;
    }
    
    @Column(name="tstime", length=50)

    public String getTstime() {
        return this.tstime;
    }
    
    public void setTstime(String tstime) {
        this.tstime = tstime;
    }
    @Column(name="status", length=1)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
   








}