package com.ninemax.jpa.system.model;
// default package

import javax.persistence.*;


/**
 * UserGroup entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="SM_USERGROUP")

public class UserGroup  implements java.io.Serializable {


    // Fields    

     private Integer usergroupId;
     private String usergroupName;
     private String usergroupMemo;
     private String usergroupStatus;
     private String usergroupKind;


    // Constructors

    /** default constructor */
    public UserGroup() {
    }

	/** minimal constructor */
    public UserGroup(Integer usergroupId, String usergroupName) {
        this.usergroupId = usergroupId;
        this.usergroupName = usergroupName;
    }
    
    /** full constructor */
    public UserGroup(Integer usergroupId, String usergroupName, String usergroupMemo, String usergroupStatus, String usergroupKind) {
        this.usergroupId = usergroupId;
        this.usergroupName = usergroupName;
        this.usergroupMemo = usergroupMemo;
        this.usergroupStatus = usergroupStatus;
        this.usergroupKind = usergroupKind;
    }

   
    // Property accessors
    @Id
    
    @Column(name="USERGROUP_ID", unique=true, nullable=false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Integer getUsergroupId() {
        return this.usergroupId;
    }
    
    public void setUsergroupId(Integer usergroupId) {
        this.usergroupId = usergroupId;
    }
    
    @Column(name="USERGROUP_NAME", unique=false, nullable=false, insertable=true, updatable=true, length=40)

    public String getUsergroupName() {
        return this.usergroupName;
    }
    
    public void setUsergroupName(String usergroupName) {
        this.usergroupName = usergroupName;
    }
    
    @Column(name="USERGROUP_MEMO", unique=false, nullable=true, insertable=true, updatable=true, length=50)

    public String getUsergroupMemo() {
        return this.usergroupMemo;
    }
    
    public void setUsergroupMemo(String usergroupMemo) {
        this.usergroupMemo = usergroupMemo;
    }
    
    @Column(name="USERGROUP_STATUS", unique=false, nullable=true, insertable=true, updatable=true, length=1)

    public String getUsergroupStatus() {
        return this.usergroupStatus;
    }
    
    public void setUsergroupStatus(String usergroupStatus) {
        this.usergroupStatus = usergroupStatus;
    }
    
    @Column(name="USERGROUP_KIND", unique=false, nullable=true, insertable=true, updatable=true, length=1)

    public String getUsergroupKind() {
        return this.usergroupKind;
    }
    
    public void setUsergroupKind(String usergroupKind) {
        this.usergroupKind = usergroupKind;
    }
   








}