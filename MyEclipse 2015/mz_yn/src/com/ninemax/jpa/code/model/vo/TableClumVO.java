package com.ninemax.jpa.code.model.vo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Administrator
 *
 */
@Table(name = "t_table_ww")
@Entity
public class TableClumVO implements java.io.Serializable{
    private int id;
    private String taskName;
    private String localClumName;
    private String remoteClumName;
    private String localeTableName;
    private String remoteTable_name;
    private String flag;
    private String info;
    private String info1;
    private String info2;
    
    @Column(name = "id")
    @Id	
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
    @Column(name = "local_clum_name")
    @Basic
	public String getLocalClumName() {
		return localClumName;
	}
	public void setLocalClumName(String localClumName) {
		this.localClumName = localClumName;
	}
    @Column(name = "remote_clum_name")
    @Basic
	public String getRemoteClumName() {
		return remoteClumName;
	}
	public void setRemoteClumName(String remoteClumName) {
		this.remoteClumName = remoteClumName;
	}
    @Column(name = "locale_table_name")
    @Basic
	public String getLocaleTableName() {
		return localeTableName;
	}
	public void setLocaleTableName(String localeTableName) {
		this.localeTableName = localeTableName;
	}
    @Column(name = "remote_table_name")
    @Basic
	public String getRemoteTable_name() {
		return remoteTable_name;
	}
	public void setRemoteTable_name(String remoteTableName) {
		remoteTable_name = remoteTableName;
	}
    @Column(name = "flag")
    @Basic
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
    @Column(name = "info")
    @Basic
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
    @Column(name = "info1")
    @Basic
	public String getInfo1() {
		return info1;
	}
	public void setInfo1(String info1) {
		this.info1 = info1;
	}
    @Column(name = "info2")
    @Basic
	public String getInfo2() {
		return info2;
	}
	public void setInfo2(String info2) {
		this.info2 = info2;
	}
    @Column(name = "task_name")
    @Basic
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
}
