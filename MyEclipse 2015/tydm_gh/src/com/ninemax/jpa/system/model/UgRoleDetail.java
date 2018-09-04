package com.ninemax.jpa.system.model;
// default package

import javax.persistence.*;


/**
 * UgRoleDetail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="SM_UGROLEDETAIL")

public class UgRoleDetail  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String usergroupId;
     private String roleId;


    // Constructors

    /** default constructor */
    public UgRoleDetail() {
    }

    
    /** full constructor */
    public UgRoleDetail(Integer id, String usergroupId, String roleId) {
        this.id = id;
        this.usergroupId = usergroupId;
        this.roleId = roleId;
    }

   
    // Property accessors
    @Id
    
    @Column(name="ID", unique=true, nullable=false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    @Column(name="USERGROUP_ID", unique=false, nullable=false, insertable=true, updatable=true, length=4)

    public String getUsergroupId() {
        return this.usergroupId;
    }
    
    public void setUsergroupId(String usergroupId) {
        this.usergroupId = usergroupId;
    }
    
    @Column(name="ROLE_ID", unique=false, nullable=false, insertable=true, updatable=true, length=4)

    public String getRoleId() {
        return this.roleId;
    }
    
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
   








}