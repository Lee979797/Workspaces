package com.ninemax.jpa.system.model;
// default package

import javax.persistence.*;


/**
 * Forbidword entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="DB_FORBIDWORD")

public class Forbidword  implements java.io.Serializable {


    // Fields    

     private Integer forbidId;
     private String forbidWord;
     private String operdate;


    // Constructors

    /** default constructor */
    public Forbidword() {
    }

	/** minimal constructor */
    public Forbidword(Integer forbidId) {
        this.forbidId = forbidId;
    }
    
    /** full constructor */
    public Forbidword(Integer forbidId, String forbidWord, String operdate) {
        this.forbidId = forbidId;
        this.forbidWord = forbidWord;
        this.operdate = operdate;
    }

   
    // Property accessors
    @Id
    
    @Column(name="FORBID_ID", unique=true, nullable=false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Integer getForbidId() {
        return this.forbidId;
    }
    
    public void setForbidId(Integer forbidId) {
        this.forbidId = forbidId;
    }
    
    @Column(name="FORBID_WORD", unique=false, nullable=true, insertable=true, updatable=true, length=20)

    public String getForbidWord() {
        return this.forbidWord;
    }
    
    public void setForbidWord(String forbidWord) {
        this.forbidWord = forbidWord;
    }
    
    @Column(name="OPERDATE", unique=false, nullable=true, insertable=true, updatable=true, length=21)

    public String getOperdate() {
        return this.operdate;
    }
    
    public void setOperdate(String operdate) {
        this.operdate = operdate;
    }
   








}