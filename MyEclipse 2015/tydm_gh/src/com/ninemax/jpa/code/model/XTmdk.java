package com.ninemax.jpa.code.model;
// default package

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * XTmdkId entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="xt_mdk_tydm")

public class XTmdk  implements java.io.Serializable {


    // Fields    

     private String jgdm;
     private String dmflag;
     private Date createTime;

     @Id
    @Column(name="jgdm", nullable=false, length=9)

    public String getJgdm() {
        return this.jgdm;
    }
    
    public void setJgdm(String jgdm) {
        this.jgdm = jgdm;
    }

    @Column(name="dmflag", nullable=false, length=1)

    public String getDmflag() {
        return this.dmflag;
    }
    
    public void setDmflag(String dmflag) {
        this.dmflag = dmflag;
    }

    @Column(name="createTime", length=23)

    public Date getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof XTmdk) ) return false;
		 XTmdk castOther = ( XTmdk ) other; 
         
		 return ( (this.getJgdm()==castOther.getJgdm()) || ( this.getJgdm()!=null && castOther.getJgdm()!=null && this.getJgdm().equals(castOther.getJgdm()) ) )
 && ( (this.getDmflag()==castOther.getDmflag()) || ( this.getDmflag()!=null && castOther.getDmflag()!=null && this.getDmflag().equals(castOther.getDmflag()) ) )
 && ( (this.getCreateTime()==castOther.getCreateTime()) || ( this.getCreateTime()!=null && castOther.getCreateTime()!=null && this.getCreateTime().equals(castOther.getCreateTime()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getJgdm() == null ? 0 : this.getJgdm().hashCode() );
         result = 37 * result + ( getDmflag() == null ? 0 : this.getDmflag().hashCode() );
         result = 37 * result + ( getCreateTime() == null ? 0 : this.getCreateTime().hashCode() );
         return result;
   }   





}