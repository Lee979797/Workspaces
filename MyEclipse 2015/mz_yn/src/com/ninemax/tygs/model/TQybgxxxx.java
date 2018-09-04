package com.ninemax.tygs.model;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * TQybgxxxx entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="t_qydjbgxx_bg")

public class TQybgxxxx  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String pripid;
     private String before;
     private String after;
     private String tstime;
     private String bgsx;

    // Constructors

   
    // Property accessors
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
    
    @Column(name="before", length=500)

    public String getBefore() {
        return this.before;
    }
    
    public void setBefore(String before) {
        this.before = before;
    }
    
    @Column(name="after", length=500)

    public String getAfter() {
        return this.after;
    }
    
    public void setAfter(String after) {
        this.after = after;
    }
    
    @Column(name="tstime", length=50)

    public String getTstime() {
        return this.tstime;
    }
    
    public void setTstime(String tstime) {
        this.tstime = tstime;
    }
    @Column(name="bgsx", length=50)
	public String getBgsx() {
		return bgsx;
	}

	public void setBgsx(String bgsx) {
		this.bgsx = bgsx;
	}
   








}