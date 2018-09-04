package com.ninemax.jpa.system.model;
// default package

import javax.persistence.*;


/**
 * UserRightKey entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="SM_USERRIGHTKEY")

public class UserRightKey  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String userId;
     private String rightkeyId;
     private String isrole;


    // Constructors

    /** default constructor */
    public UserRightKey() {
    }

	/** minimal constructor */
    public UserRightKey(Integer id, String userId) {
        this.id = id;
        this.userId = userId;
    }
    
    /** full constructor */
    public UserRightKey(Integer id, String userId, String rightkeyId, String isrole) {
        this.id = id;
        this.userId = userId;
        this.rightkeyId = rightkeyId;
        this.isrole = isrole;
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
    
    @Column(name="USER_ID", unique=false, nullable=false, insertable=true, updatable=true, length=8)

    public String getUserId() {
        return this.userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    @Column(name="RIGHTKEY_ID", unique=false, nullable=true, insertable=true, updatable=true, length=8)

    public String getRightkeyId() {
        return this.rightkeyId;
    }
    
    public void setRightkeyId(String rightkeyId) {
        this.rightkeyId = rightkeyId;
    }
    
    @Column(name="ISROLE", unique=false, nullable=true, insertable=true, updatable=true, length=1)

    public String getIsrole() {
        return this.isrole;
    }
    
    public void setIsrole(String isrole) {
        this.isrole = isrole;
    }
   








}