package com.ninemax.jpa.system.model;
// default package

import javax.persistence.*;
import java.sql.Timestamp;


/**
 * NationalTask entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="DB_NationalTask")

public class NationalTask  implements java.io.Serializable {


    // Fields    

     private String taskid;
     private String beginCodeid;
     private String endCodeid;
     private String taskCount;
     private String finishCount;
     private String getdate;
     private Timestamp giveoutdate;
     private String status;
     private String memo;
     @Transient
     private String finishRate;
     private String ffstatus;

    // Constructors

    /** default constructor */
    public NationalTask() {
    }

	/** minimal constructor */
    public NationalTask(String taskid) {
        this.taskid = taskid;
    }
    
    /** full constructor */
    public NationalTask(String taskid, String beginCodeid, String endCodeid, String taskCount, String finishCount, String getdate, Timestamp giveoutdate, String status, String memo) {
        this.taskid = taskid;
        this.beginCodeid = beginCodeid;
        this.endCodeid = endCodeid;
        this.taskCount = taskCount;
        this.finishCount = finishCount;
        this.getdate = getdate;
        this.giveoutdate = giveoutdate;
        this.status = status;
        this.memo = memo;
    }

   
    // Property accessors
    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="Taskid", unique=true, nullable=false, length=15)

    public String getTaskid() {
        return this.taskid;
    }
    
    public void setTaskid(String taskid) {
        this.taskid = taskid;
    }
    
    @Column(name="BeginCodeid", length=9)

    public String getBeginCodeid() {
        return this.beginCodeid;
    }
    
    public void setBeginCodeid(String beginCodeid) {
        this.beginCodeid = beginCodeid;
    }
    
    @Column(name="EndCodeid", length=9)

    public String getEndCodeid() {
        return this.endCodeid;
    }
    
    public void setEndCodeid(String endCodeid) {
        this.endCodeid = endCodeid;
    }
    
    @Column(name="TaskCount", length=10)

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
    
    @Column(name="Getdate", length=23)

    public String getGetdate() {
        return this.getdate;
    }
    
    public void setGetdate(String getdate) {
        this.getdate = getdate;
    }
    
    @Column(name="Giveoutdate", length=23)

    public Timestamp getGiveoutdate() {
        return this.giveoutdate;
    }
    
    public void setGiveoutdate(Timestamp giveoutdate) {
        this.giveoutdate = giveoutdate;
    }
    
    @Column(name="status", length=2)

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

     public String getFinishRate() {
        return finishRate;
    }

    public void setFinishRate(String finishRate) {
        this.finishRate = finishRate;
    }

    @Column(name = "ffstatus",length = 2)
    public String getFfstatus() {
        return ffstatus;
    }

    public void setFfstatus(String ffstatus) {
        this.ffstatus = ffstatus;
    }

}