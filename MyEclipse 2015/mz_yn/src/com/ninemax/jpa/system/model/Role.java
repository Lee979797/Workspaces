package com.ninemax.jpa.system.model;
// default package

import javax.persistence.*;


/**
 * Role entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SM_ROLE")
public class Role implements java.io.Serializable {

    // Fields
    private Integer roleId;
    private String roleName;
    private String roleKind;
    private String roleMemo;
    private String roleStatus;


    // Constructors

    /**
     * default constructor
     */
    public Role() {
    }

    /**
     * minimal constructor
     */
    public Role(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * full constructor
     */
    public Role(Integer roleId, String roleName, String roleKind, String roleMemo, String roleStatus) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleKind = roleKind;
        this.roleMemo = roleMemo;
        this.roleStatus = roleStatus;
    }


    // Property accessors
    @Id

    @Column(name = "ROLE_ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getRoleId() {
        return this.roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Column(name = "ROLE_NAME", unique = false, nullable = true, insertable = true, updatable = true, length = 20)

    public String getRoleName() {
        return this.roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Column(name = "ROLE_KIND", unique = false, nullable = true, insertable = true, updatable = true, length = 1)

    public String getRoleKind() {
        return this.roleKind;
    }

    public void setRoleKind(String roleKind) {
        this.roleKind = roleKind;
    }

    @Column(name = "ROLE_MEMO", unique = false, nullable = true, insertable = true, updatable = true, length = 50)

    public String getRoleMemo() {
        return this.roleMemo;
    }

    public void setRoleMemo(String roleMemo) {
        this.roleMemo = roleMemo;
    }

    @Column(name = "ROLE_STATUS", unique = false, nullable = true, insertable = true, updatable = true, length = 1)

    public String getRoleStatus() {
        return this.roleStatus;
    }

    public void setRoleStatus(String roleStatus) {
        this.roleStatus = roleStatus;
    }


}