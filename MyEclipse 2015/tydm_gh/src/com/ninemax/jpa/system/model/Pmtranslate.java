package com.ninemax.jpa.system.model;


import javax.persistence.*;


/**
 * Pmtranslate entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="SM_PMTRANSLATE")

public class Pmtranslate  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String enName;
     private String cnName;


    // Constructors

    /** default constructor */
    public Pmtranslate() {
    }

	/** minimal constructor */
    public Pmtranslate(Integer id) {
        this.id = id;
    }
    
    /** full constructor */
    public Pmtranslate(Integer id, String enName, String cnName) {
        this.id = id;
        this.enName = enName;
        this.cnName = cnName;
    }

   
    // Property accessors
    @Id
    
    @Column(name="ID", unique=true, nullable=false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    @Column(name="EN_NAME", unique=false, nullable=true, insertable=true, updatable=true, length=100)

    public String getEnName() {
        return this.enName;
    }
    
    public void setEnName(String enName) {
        this.enName = enName;
    }
    
    @Column(name="CN_NAME", unique=false, nullable=true, insertable=true, updatable=true, length=100)

    public String getCnName() {
        return this.cnName;
    }
    
    public void setCnName(String cnName) {
        this.cnName = cnName;
    }
   








}