package com.ninemax.jpa.collection.model;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Fields entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="SC_Fields")

public class Fields  implements java.io.Serializable {

 

     private String fieldId;
     private String fieldName;
     private String fieldCode;
     private String fieldtypeId;
     private Integer fieldLength;
     private String fieldColor;
     private String isShow;
     private String isInput;
     private String belongTable;
     private String memo1;
     private String memo2;



    public Fields() {
    }

    @Id 
    
    @Column(name="Field_id", unique=true, nullable=false, length=4)

    public String getFieldId() {
        return this.fieldId;
    }
    
    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }
    
    @Column(name="Field_name", length=50)

    public String getFieldName() {
        return this.fieldName;
    }
    
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
    
    @Column(name="Field_code", length=20)

    public String getFieldCode() {
        return this.fieldCode;
    }
    
    public void setFieldCode(String fieldCode) {
        this.fieldCode = fieldCode;
    }
    
    @Column(name="Fieldtype_id", length=2)

    public String getFieldtypeId() {
        return this.fieldtypeId;
    }
    
    public void setFieldtypeId(String fieldtypeId) {
        this.fieldtypeId = fieldtypeId;
    }
    
    @Column(name="Field_length")

    public Integer getFieldLength() {
        return this.fieldLength;
    }
    
    public void setFieldLength(Integer fieldLength) {
        this.fieldLength = fieldLength;
    }
    
    @Column(name="Field_Color", length=10)

    public String getFieldColor() {
        return this.fieldColor;
    }
    
    public void setFieldColor(String fieldColor) {
        this.fieldColor = fieldColor;
    }
    
    @Column(name="isShow", length=2)

    public String getIsShow() {
        return this.isShow;
    }
    
    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }
    
    @Column(name="isInput", length=2)

    public String getIsInput() {
        return this.isInput;
    }
    
    public void setIsInput(String isInput) {
        this.isInput = isInput;
    }
    
    @Column(name="BelongTable", length=30)

    public String getBelongTable() {
        return this.belongTable;
    }
    
    public void setBelongTable(String belongTable) {
        this.belongTable = belongTable;
    }
    
    @Column(name="memo1", length=10)

    public String getMemo1() {
        return this.memo1;
    }
    
    public void setMemo1(String memo1) {
        this.memo1 = memo1;
    }
    
    @Column(name="memo2", length=10)

    public String getMemo2() {
        return this.memo2;
    }
    
    public void setMemo2(String memo2) {
        this.memo2 = memo2;
    }
   








}