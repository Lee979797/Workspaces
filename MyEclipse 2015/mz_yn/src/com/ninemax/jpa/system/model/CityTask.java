package com.ninemax.jpa.system.model;
// default package

import javax.persistence.*;


/**
 * CityTask entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="db_CityTask")

public class CityTask  implements java.io.Serializable {


    // Fields    

     private CityTaskId id;
     private String taskName;
     private String taskCount;
     private String finishCount;
     private String giveoutdate;
     private String status;
     private String memo;


    // Constructors

    /** default constructor */
    public CityTask() {
    }

	/** minimal constructor */
    public CityTask(CityTaskId id, String taskName, String taskCount) {
        this.id = id;
        this.taskName = taskName;
        this.taskCount = taskCount;
    }
    
    /** full constructor */
    public CityTask(CityTaskId id, String taskName, String taskCount, String finishCount, String giveoutdate, String status, String memo) {
        this.id = id;
        this.taskName = taskName;
        this.taskCount = taskCount;
        this.finishCount = finishCount;
        this.giveoutdate = giveoutdate;
        this.status = status;
        this.memo = memo;
    }

   
    // Property accessors
    @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="taskId", column=@Column(name="TaskID", nullable=false, length=15) ), 
        @AttributeOverride(name="citySiteId", column=@Column(name="CitySite_id", nullable=false, length=8) ) } )

    public CityTaskId getId() {
        return this.id;
    }
    
    public void setId(CityTaskId id) {
        this.id = id;
    }
    
    @Column(name="TaskName", nullable=false, length=30)

    public String getTaskName() {
        return this.taskName;
    }
    
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    
    @Column(name="TaskCount", nullable=false, length=10)

    public String getTaskCount() {
        return this.taskCount;
    }
    
    public void setTaskCount(String taskCount) {
        this.taskCount = taskCount;
    }
    
    @Column(name="FinishCount", length=10)

    public String getFinishCount() {
        return this.finishCount;
    }
    
    public void setFinishCount(String finishCount) {
        this.finishCount = finishCount;
    }
    
    @Column(name="Giveoutdate", length=23)

    public String getGiveoutdate() {
        return this.giveoutdate;
    }
    
    public void setGiveoutdate(String giveoutdate) {
        this.giveoutdate = giveoutdate;
    }
    
    @Column(name="Status", length=2)

    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    @Column(name="Memo", length=10)

    public String getMemo() {
        return this.memo;
    }
    
    public void setMemo(String memo) {
        this.memo = memo;
    }
   








}