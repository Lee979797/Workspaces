package com.ninemax.jpa.system.model;
// default package

import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 * CityTaskId entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class CityTaskId  implements java.io.Serializable {


    // Fields    

     private String taskId;
     private String citySiteId;


    // Constructors

    /** default constructor */
    public CityTaskId() {
    }

    
    /** full constructor */
    public CityTaskId(String taskId, String citySiteId) {
        this.taskId = taskId;
        this.citySiteId = citySiteId;
    }

   
    // Property accessors

    @Column(name="TaskID", nullable=false, length=15)

    public String getTaskId() {
        return this.taskId;
    }
    
    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    @Column(name="CitySite_id", nullable=false, length=8)

    public String getCitySiteId() {
        return this.citySiteId;
    }
    
    public void setCitySiteId(String citySiteId) {
        this.citySiteId = citySiteId;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof CityTaskId) ) return false;
		 CityTaskId castOther = ( CityTaskId ) other; 
         
		 return ( (this.getTaskId()==castOther.getTaskId()) || ( this.getTaskId()!=null && castOther.getTaskId()!=null && this.getTaskId().equals(castOther.getTaskId()) ) )
 && ( (this.getCitySiteId()==castOther.getCitySiteId()) || ( this.getCitySiteId()!=null && castOther.getCitySiteId()!=null && this.getCitySiteId().equals(castOther.getCitySiteId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getTaskId() == null ? 0 : this.getTaskId().hashCode() );
         result = 37 * result + ( getCitySiteId() == null ? 0 : this.getCitySiteId().hashCode() );
         return result;
   }   





}