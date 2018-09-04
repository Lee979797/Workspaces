package com.ninemax.jpa.collection.model;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 
 * @author  haojy
 *
 */
@Entity
@Table(name="sc_xzqh")

public class Xzqh  implements java.io.Serializable {


    // Fields    

     private String xzqhId;
     private String xzqhName;


    // Constructors

    /** default constructor */
    public Xzqh() {
    }

	/** minimal constructor */
    public Xzqh(String xzqhId) {
        this.xzqhId = xzqhId;
    }
    
    /** full constructor */
    public Xzqh(String xzqhId, String xzqhName) {
        this.xzqhId = xzqhId;
        this.xzqhName = xzqhName;
    }

   
    // Property accessors
    @Id 
    
    @Column(name="xzqh_id", unique=true, nullable=false, length=10)

    public String getXzqhId() {
        return this.xzqhId;
    }
    
    public void setXzqhId(String xzqhId) {
        this.xzqhId = xzqhId;
    }
    
    @Column(name="xzqh_name", length=100)

    public String getXzqhName() {
        return this.xzqhName;
    }
    
    public void setXzqhName(String xzqhName) {
        this.xzqhName = xzqhName;
    }
   








}