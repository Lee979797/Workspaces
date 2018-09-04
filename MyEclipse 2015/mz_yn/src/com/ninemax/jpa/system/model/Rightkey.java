package com.ninemax.jpa.system.model;
// default package

import javax.persistence.*;


/**
 * Rightkey entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="SM_RIGHTKEY")

public class Rightkey  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String rightkeyId;
     private String rightkeyName;
     private String rightkeyDepth;
     private String rightkeyKind;
     private String rightkeyFunc;
     private String rightkeyFullname;
     private String pictrue;
     private String parentid;
     private String linkpage;
     private String orderby;
     private String type;


    // Constructors

    /** default constructor */
    public Rightkey() {
    }

	/** minimal constructor */
    public Rightkey(Integer id, String rightkeyId, String rightkeyName, String rightkeyDepth, String rightkeyKind, String rightkeyFunc, String rightkeyFullname) {
        this.id = id;
        this.rightkeyId = rightkeyId;
        this.rightkeyName = rightkeyName;
        this.rightkeyDepth = rightkeyDepth;
        this.rightkeyKind = rightkeyKind;
        this.rightkeyFunc = rightkeyFunc;
        this.rightkeyFullname = rightkeyFullname;
    }
    
    /** full constructor */
    public Rightkey(Integer id, String rightkeyId, String rightkeyName, String rightkeyDepth, String rightkeyKind, String rightkeyFunc, String rightkeyFullname, String pictrue, String parentid, String linkpage, String orderby, String type) {
        this.id = id;
        this.rightkeyId = rightkeyId;
        this.rightkeyName = rightkeyName;
        this.rightkeyDepth = rightkeyDepth;
        this.rightkeyKind = rightkeyKind;
        this.rightkeyFunc = rightkeyFunc;
        this.rightkeyFullname = rightkeyFullname;
        this.pictrue = pictrue;
        this.parentid = parentid;
        this.linkpage = linkpage;
        this.orderby = orderby;
        this.type = type;
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
    
    @Column(name="RIGHTKEY_ID", unique=false, nullable=false, insertable=true, updatable=true, length=10)

    public String getRightkeyId() {
        return this.rightkeyId;
    }
    
    public void setRightkeyId(String rightkeyId) {
        this.rightkeyId = rightkeyId;
    }
    
    @Column(name="RIGHTKEY_NAME", unique=false, nullable=false, insertable=true, updatable=true, length=20)

    public String getRightkeyName() {
        return this.rightkeyName;
    }
    
    public void setRightkeyName(String rightkeyName) {
        this.rightkeyName = rightkeyName;
    }
    
    @Column(name="RIGHTKEY_DEPTH", unique=false, nullable=false, insertable=true, updatable=true, length=2)

    public String getRightkeyDepth() {
        return this.rightkeyDepth;
    }
    
    public void setRightkeyDepth(String rightkeyDepth) {
        this.rightkeyDepth = rightkeyDepth;
    }
    
    @Column(name="RIGHTKEY_KIND", unique=false, nullable=false, insertable=true, updatable=true, length=20)

    public String getRightkeyKind() {
        return this.rightkeyKind;
    }
    
    public void setRightkeyKind(String rightkeyKind) {
        this.rightkeyKind = rightkeyKind;
    }
    
    @Column(name="RIGHTKEY_FUNC", unique=false, nullable=false, insertable=true, updatable=true, length=20)

    public String getRightkeyFunc() {
        return this.rightkeyFunc;
    }
    
    public void setRightkeyFunc(String rightkeyFunc) {
        this.rightkeyFunc = rightkeyFunc;
    }
    
    @Column(name="RIGHTKEY_FULLNAME", unique=false, nullable=false, insertable=true, updatable=true, length=30)

    public String getRightkeyFullname() {
        return this.rightkeyFullname;
    }
    
    public void setRightkeyFullname(String rightkeyFullname) {
        this.rightkeyFullname = rightkeyFullname;
    }
    
    @Column(name="PICTRUE", unique=false, nullable=true, insertable=true, updatable=true, length=30)

    public String getPictrue() {
        return this.pictrue;
    }
    
    public void setPictrue(String pictrue) {
        this.pictrue = pictrue;
    }
    
    @Column(name="PARENTID", unique=false, nullable=true, insertable=true, updatable=true, length=6)

    public String getParentid() {
        return this.parentid;
    }
    
    public void setParentid(String parentid) {
        this.parentid = parentid;
    }
    
    @Column(name="LINKPAGE", unique=false, nullable=true, insertable=true, updatable=true, length=200)

    public String getLinkpage() {
        return this.linkpage;
    }
    
    public void setLinkpage(String linkpage) {
        this.linkpage = linkpage;
    }
    
    @Column(name="ORDERBY", unique=false, nullable=true, insertable=true, updatable=true, length=4)

    public String getOrderby() {
        return this.orderby;
    }
    
    public void setOrderby(String orderby) {
        this.orderby = orderby;
    }
    
    @Column(name="TYPE", unique=false, nullable=true, insertable=true, updatable=true, length=4)

    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
   








}