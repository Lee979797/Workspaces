package com.ninemax.jpa.system.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-8-17
 * Time: ÏÂÎç12:22
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "SC_Fields")
@Entity
public class ScFields {
    private String fieldId;

    @javax.persistence.Column(name = "Field_id")
    @Id
    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    private String fieldName;

    @javax.persistence.Column(name = "Field_name")
    @Basic
    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    private String fieldCode;

    @javax.persistence.Column(name = "Field_code")
    @Basic
    public String getFieldCode() {
        return fieldCode;
    }

    public void setFieldCode(String fieldCode) {
        this.fieldCode = fieldCode;
    }

    private String fieldtypeId;

    @javax.persistence.Column(name = "Fieldtype_id")
    @Basic
    public String getFieldtypeId() {
        return fieldtypeId;
    }

    public void setFieldtypeId(String fieldtypeId) {
        this.fieldtypeId = fieldtypeId;
    }

    private Integer fieldLength;

    @javax.persistence.Column(name = "Field_length")
    @Basic
    public Integer getFieldLength() {
        return fieldLength;
    }

    public void setFieldLength(Integer fieldLength) {
        this.fieldLength = fieldLength;
    }

    private String fieldColor;

    @javax.persistence.Column(name = "Field_Color")
    @Basic
    public String getFieldColor() {
        return fieldColor;
    }

    public void setFieldColor(String fieldColor) {
        this.fieldColor = fieldColor;
    }

    private String isShow;

    @javax.persistence.Column(name = "isShow")
    @Basic
    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String show) {
        isShow = show;
    }

    private String isInput;

    @javax.persistence.Column(name = "isInput")
    @Basic
    public String getIsInput() {
        return isInput;
    }

    public void setIsInput(String input) {
        isInput = input;
    }

    private String belongTable;

    @javax.persistence.Column(name = "BelongTable")
    @Basic
    public String getBelongTable() {
        return belongTable;
    }

    public void setBelongTable(String belongTable) {
        this.belongTable = belongTable;
    }

    private String memo1;

    @javax.persistence.Column(name = "memo1")
    @Basic
    public String getMemo1() {
        return memo1;
    }

    public void setMemo1(String memo1) {
        this.memo1 = memo1;
    }

    private String memo2;

    @javax.persistence.Column(name = "memo2")
    @Basic
    public String getMemo2() {
        return memo2;
    }

    public void setMemo2(String memo2) {
        this.memo2 = memo2;
    }

    private Boolean required;

    @javax.persistence.Column(name = "required")
    @Basic
    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScFields scFields = (ScFields) o;

        if (belongTable != null ? !belongTable.equals(scFields.belongTable) : scFields.belongTable != null)
            return false;
        if (fieldCode != null ? !fieldCode.equals(scFields.fieldCode) : scFields.fieldCode != null) return false;
        if (fieldColor != null ? !fieldColor.equals(scFields.fieldColor) : scFields.fieldColor != null) return false;
        if (fieldId != null ? !fieldId.equals(scFields.fieldId) : scFields.fieldId != null) return false;
        if (fieldLength != null ? !fieldLength.equals(scFields.fieldLength) : scFields.fieldLength != null)
            return false;
        if (fieldName != null ? !fieldName.equals(scFields.fieldName) : scFields.fieldName != null) return false;
        if (fieldtypeId != null ? !fieldtypeId.equals(scFields.fieldtypeId) : scFields.fieldtypeId != null)
            return false;
        if (isInput != null ? !isInput.equals(scFields.isInput) : scFields.isInput != null) return false;
        if (isShow != null ? !isShow.equals(scFields.isShow) : scFields.isShow != null) return false;
        if (memo1 != null ? !memo1.equals(scFields.memo1) : scFields.memo1 != null) return false;
        if (memo2 != null ? !memo2.equals(scFields.memo2) : scFields.memo2 != null) return false;
        if (required != null ? !required.equals(scFields.required) : scFields.required != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fieldId != null ? fieldId.hashCode() : 0;
        result = 31 * result + (fieldName != null ? fieldName.hashCode() : 0);
        result = 31 * result + (fieldCode != null ? fieldCode.hashCode() : 0);
        result = 31 * result + (fieldtypeId != null ? fieldtypeId.hashCode() : 0);
        result = 31 * result + (fieldLength != null ? fieldLength.hashCode() : 0);
        result = 31 * result + (fieldColor != null ? fieldColor.hashCode() : 0);
        result = 31 * result + (isShow != null ? isShow.hashCode() : 0);
        result = 31 * result + (isInput != null ? isInput.hashCode() : 0);
        result = 31 * result + (belongTable != null ? belongTable.hashCode() : 0);
        result = 31 * result + (memo1 != null ? memo1.hashCode() : 0);
        result = 31 * result + (memo2 != null ? memo2.hashCode() : 0);
        result = 31 * result + (required != null ? required.hashCode() : 0);
        return result;
    }
}
