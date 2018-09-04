package com.ninemax.jpa.system.model;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * FieldType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="SC_FieldType")

public class FieldType  implements java.io.Serializable {


    // Fields    

     private String fieldTypeId;
     private String fieldTypeName;


    // Constructors

    /** default constructor */
    public FieldType() {
    }

	/** minimal constructor */
    public FieldType(String fieldTypeId) {
        this.fieldTypeId = fieldTypeId;
    }
    
    /** full constructor */
    public FieldType(String fieldTypeId, String fieldTypeName) {
        this.fieldTypeId = fieldTypeId;
        this.fieldTypeName = fieldTypeName;
    }

   
    // Property accessors
    @Id 
    
    @Column(name="FieldType_id", unique=true, nullable=false, length=2)

    public String getFieldTypeId() {
        return this.fieldTypeId;
    }
    
    public void setFieldTypeId(String fieldTypeId) {
        this.fieldTypeId = fieldTypeId;
    }
    
    @Column(name="FieldType_name", length=10)

    public String getFieldTypeName() {
        return this.fieldTypeName;
    }
    
    public void setFieldTypeName(String fieldTypeName) {
        this.fieldTypeName = fieldTypeName;
    }
   








}