package com.ninemax.jpa.system.model;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * PoliticalLandscape entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="SC_POLITICALLANDSCAPE")

public class PoliticalLandscape  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String faceName;
     private String orderby;


    // Constructors

    /** default constructor */
    public PoliticalLandscape() {
    }

	/** minimal constructor */
    public PoliticalLandscape(Integer id) {
        this.id = id;
    }
    
    /** full constructor */
    public PoliticalLandscape(Integer id, String faceName, String orderby) {
        this.id = id;
        this.faceName = faceName;
        this.orderby = orderby;
    }

   
    // Property accessors
    @Id
    
    @Column(name="ID", unique=true, nullable=false, insertable=true, updatable=true)

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    @Column(name="FACE_NAME", unique=false, nullable=true, insertable=true, updatable=true, length=50)

    public String getFaceName() {
        return this.faceName;
    }
    
    public void setFaceName(String faceName) {
        this.faceName = faceName;
    }
    
    @Column(name="ORDERBY", unique=false, nullable=true, insertable=true, updatable=true, length=2)

    public String getOrderby() {
        return this.orderby;
    }
    
    public void setOrderby(String orderby) {
        this.orderby = orderby;
    }
   








}