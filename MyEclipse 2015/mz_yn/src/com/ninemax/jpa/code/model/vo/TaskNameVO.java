package com.ninemax.jpa.code.model.vo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 数据库参数对象 - 正式存任务
 * @author Administrator
 *
 */
@Table(name = "t_taskinfo_ww")
@Entity
public class TaskNameVO {
	private int id; 
	private String taskName;      // 任务名
	private String ipAddr;        // 数据库服务器ip地址
	private String dataBaseName;  // 数据库名
    private String uid;       // 数据库用户名
    private String pwd;       // 数据库密码
    private String tableName;  // 表名
    private String dataBaseType; // 数据库类型
    private String strForSql;     // 条件语句
    private String executeSql;   // 整理拼写的插入数据SQL执行语句
    private String info;
    
    @Column(name = "id")
    @Id	
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
    @Column(name = "ip_addr")
    @Basic
	public String getIpAddr() {
		return ipAddr;
	}
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
    @Column(name = "database_name")
    @Basic
	public String getDataBaseName() {
		return dataBaseName;
	}
	public void setDataBaseName(String dataBaseName) {
		this.dataBaseName = dataBaseName;
	}
    @Column(name = "uid")
    @Basic
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
    @Column(name = "pwd")
    @Basic
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
    @Column(name = "table_name")
    @Basic
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
    @Column(name = "database_type")
    @Basic
	public String getDataBaseType() {
		return dataBaseType;
	}
	public void setDataBaseType(String dataBaseType) {
		this.dataBaseType = dataBaseType;
	}
    @Column(name = "info")
    @Basic
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
    @Column(name = "strForSql")
    @Basic
	public String getStrForSql() {
		return strForSql;
	}
	public void setStrForSql(String strForSql) {
		this.strForSql = strForSql;
	}
    @Column(name = "task_name")
    @Basic
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
    @Column(name = "execute_sql")
    @Basic
	public String getExecuteSql() {
		return executeSql;
	}
	public void setExecuteSql(String executeSql) {
		this.executeSql = executeSql;
	}
}
