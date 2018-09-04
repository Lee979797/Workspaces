package com.ninemax.jpa.code.model;
// default package

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * XTmdsourceId entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="xt_mdsource_tydm")

public class XTmdsource  implements java.io.Serializable {


    // Fields    

     private Integer xh;
     private String qsmd;
     private String jzmd;
     private Integer mdsl;
     private String mdtype;
     private Boolean mdzt;
     private Date lrsj;


     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="xh", nullable=false)

    public Integer getXh() {
        return this.xh;
    }
    
    public void setXh(Integer xh) {
        this.xh = xh;
    }

    @Column(name="qsmd", length=8)

    public String getQsmd() {
        return this.qsmd;
    }
    
    public void setQsmd(String qsmd) {
        this.qsmd = qsmd;
    }

    @Column(name="jzmd", length=8)

    public String getJzmd() {
        return this.jzmd;
    }
    
    public void setJzmd(String jzmd) {
        this.jzmd = jzmd;
    }

    @Column(name="mdsl")

    public Integer getMdsl() {
        return this.mdsl;
    }
    
    public void setMdsl(Integer mdsl) {
        this.mdsl = mdsl;
    }

    @Column(name="mdtype", length=1)

    public String getMdtype() {
        return this.mdtype;
    }
    
    public void setMdtype(String mdtype) {
        this.mdtype = mdtype;
    }

    @Column(name="mdzt")

    public Boolean getMdzt() {
        return this.mdzt;
    }
    
    public void setMdzt(Boolean mdzt) {
        this.mdzt = mdzt;
    }

    @Column(name="lrsj", length=23)

    public Date getLrsj() {
        return this.lrsj;
    }
    
    public void setLrsj(Date lrsj) {
        this.lrsj = lrsj;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof XTmdsource) ) return false;
		 XTmdsource castOther = ( XTmdsource ) other; 
         
		 return ( (this.getXh()==castOther.getXh()) || ( this.getXh()!=null && castOther.getXh()!=null && this.getXh().equals(castOther.getXh()) ) )
 && ( (this.getQsmd()==castOther.getQsmd()) || ( this.getQsmd()!=null && castOther.getQsmd()!=null && this.getQsmd().equals(castOther.getQsmd()) ) )
 && ( (this.getJzmd()==castOther.getJzmd()) || ( this.getJzmd()!=null && castOther.getJzmd()!=null && this.getJzmd().equals(castOther.getJzmd()) ) )
 && ( (this.getMdsl()==castOther.getMdsl()) || ( this.getMdsl()!=null && castOther.getMdsl()!=null && this.getMdsl().equals(castOther.getMdsl()) ) )
 && ( (this.getMdtype()==castOther.getMdtype()) || ( this.getMdtype()!=null && castOther.getMdtype()!=null && this.getMdtype().equals(castOther.getMdtype()) ) )
 && ( (this.getMdzt()==castOther.getMdzt()) || ( this.getMdzt()!=null && castOther.getMdzt()!=null && this.getMdzt().equals(castOther.getMdzt()) ) )
 && ( (this.getLrsj()==castOther.getLrsj()) || ( this.getLrsj()!=null && castOther.getLrsj()!=null && this.getLrsj().equals(castOther.getLrsj()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getXh() == null ? 0 : this.getXh().hashCode() );
         result = 37 * result + ( getQsmd() == null ? 0 : this.getQsmd().hashCode() );
         result = 37 * result + ( getJzmd() == null ? 0 : this.getJzmd().hashCode() );
         result = 37 * result + ( getMdsl() == null ? 0 : this.getMdsl().hashCode() );
         result = 37 * result + ( getMdtype() == null ? 0 : this.getMdtype().hashCode() );
         result = 37 * result + ( getMdzt() == null ? 0 : this.getMdzt().hashCode() );
         result = 37 * result + ( getLrsj() == null ? 0 : this.getLrsj().hashCode() );
         return result;
   }   





}