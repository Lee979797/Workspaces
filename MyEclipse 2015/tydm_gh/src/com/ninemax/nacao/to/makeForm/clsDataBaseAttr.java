package com.ninemax.nacao.to.makeForm;

/**
 * 
 * @author ������
 * @company ninmax
 * 
 */
public class clsDataBaseAttr {

	private String id = "";//����ID
	private String dbType = ""; //���ݿ�����
	private String dbUserName = ""; //���ݿ� �û���
	private String dbUserPas = "";//���ݿ� ����
	private String dbHost = "";//���ݿ� ip
	private String dbName = ""; // ���ݿ���
	private String port = ""; //�˿ں�
	private String loadClass= ""; //Ҫ���ڵ�������
	private String url = ""; //�������ɵ�url
	private String add_time = ""; //���ʱ��
	private String web_id = ""; //������վ��ID
	private String dbConName = "";//��������������
	
	
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
