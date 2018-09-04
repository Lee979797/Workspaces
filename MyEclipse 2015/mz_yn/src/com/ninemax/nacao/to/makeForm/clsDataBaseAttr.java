package com.ninemax.nacao.to.makeForm;

/**
 * 
 * @author 周鹏鹏
 * @company ninmax
 * 
 */
public class clsDataBaseAttr {

	private String id = "";//连接ID
	private String dbType = ""; //数据库类型
	private String dbUserName = ""; //数据库 用户名
	private String dbUserPas = "";//数据库 密码
	private String dbHost = "";//数据库 ip
	private String dbName = ""; // 数据库名
	private String port = ""; //端口号
	private String loadClass= ""; //要加在的驱动类
	private String url = ""; //最终生成的url
	private String add_time = ""; //添加时间
	private String web_id = ""; //关联的站点ID
	private String dbConName = "";//建立的连接名称
	
	
	public String getDbConName() {
		return dbConName;
	}
	public void setDbConName(String dbConName) {
		this.dbConName = dbConName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLoadClass() {
		return loadClass;
	}
	public void setLoadClass(String loadClass) {
		this.loadClass = loadClass;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getAdd_time() {
		return add_time;
	}
	public void setAdd_time(String add_time) {
		this.add_time = add_time;
	}
	public String getWeb_id() {
		return web_id;
	}
	public void setWeb_id(String web_id) {
		this.web_id = web_id;
	}
	public String getDbType() {
		return dbType;
	}
	public void setDbType(String dbType) {
		this.dbType = dbType;
	}
	public String getDbUserName() {
		return dbUserName;
	}
	public void setDbUserName(String dbUserName) {
		this.dbUserName = dbUserName;
	}
	public String getDbUserPas() {
		return dbUserPas;
	}
	public void setDbUserPas(String dbUserPas) {
		this.dbUserPas = dbUserPas;
	}
	public String getDbHost() {
		return dbHost;
	}
	public void setDbHost(String dbHost) {
		this.dbHost = dbHost;
	}
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	
}
