package com.ninemax.jpa.system.model;
// default package

import javax.persistence.*;


/**
 * Group entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="SC_GROUP")

public class Group  implements java.io.Serializable {


    // Fields    

     private Integer groupId;
     private String groupName;
     private String groupDesc;
     private String isgroup;
     private Long groupLimit;
     private String groupParent;
     private String groupSort;


    // Constructors

    /** default constructor */
    public Group() {
    }

	/** minimal constructor */
    public Group(Integer groupId) {
        this.groupId = groupId;
    }
    
    /** full constructor */
    public Group(Integer groupId, String groupName, String groupDesc, String isgroup, Long groupLimit, String groupParent, String groupSort) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.groupDesc = groupDesc;
        this.isgroup = isgroup;
        this.groupLimit = groupLimit;
        this.groupParent = groupParent;
        this.groupSort = groupSort;
    }

   
    // Property accessors
    @Id
    
    @Column(name="GROUP_ID", unique=true, nullable=false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Integer getGroupId() {
        return this.groupId;
    }
    
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
    
    @Column(name="GROUP_NAME", unique=false, nullable=true, insertable=true, updatable=true, length=100)

    public String getGroupName() {
        return this.groupName;
    }
    
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    
    @Column(name="GROUP_DESC", unique=false, nullable=true, insertable=true, updatable=true, length=200)

    public String getGroupDesc() {
        return this.groupDesc;
    }
    
    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }
    
    @Column(name="ISGROUP", unique=false, nullable=true, insertable=true, updatable=true, length=2)

    public String getIsgroup() {
        return this.isgroup;
    }
    
    public void setIsgroup(String isgroup) {
        this.isgroup = isgroup;
    }
    
    @Column(name="GROUP_LIMIT", unique=false, nullable=true, insertable=true, updatable=true, precision=18, scale=0)

    public Long getGroupLimit() {
        return this.groupLimit;
    }
    
    public void setGroupLimit(Long groupLimit) {
        this.groupLimit = groupLimit;
    }
    
    @Column(name="GROUP_PARENT", unique=false, nullable=true, insertable=true, updatable=true, length=10)

    public String getGroupParent() {
        return this.groupParent;
    }
    
    public void setGroupParent(String groupParent) {
        this.groupParent = groupParent;
    }
    
    @Column(name="GROUP_SORT", unique=false, nullable=true, insertable=true, updatable=true, length=2)

    public String getGroupSort() {
        return this.groupSort;
    }
    
    public void setGroupSort(String groupSort) {
        this.groupSort = groupSort;
    }
   








}