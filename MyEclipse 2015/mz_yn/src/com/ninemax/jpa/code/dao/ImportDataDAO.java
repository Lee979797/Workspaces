package com.ninemax.jpa.code.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.ninemax.jdbc.dao.DataAccess;
import org.apache.log4j.Logger;
import sun.jdbc.rowset.CachedRowSet;

import com.ninemax.jpa.code.model.vo.DbConfigVO;
import com.ninemax.jpa.code.model.vo.TableClumVO;
import com.ninemax.jpa.code.model.vo.TaskNameVO;
import com.ninemax.jpa.global.EntityManagerHelper;

public class ImportDataDAO {
    private static Logger log = Logger.getLogger(ImportDataDAO.class);
	/**
	 * ���ݿ����ò���ɾ��������
	 * @param dcv
	 * @return
	 */
	public boolean dbConfigOpera(DbConfigVO dcv){
		boolean flag = true;
		EntityManager em = EntityManagerHelper.getEntityManager();
		em.getTransaction().begin();
        String queryString = "delete from  t_dbconfig_ww";
        em.createNativeQuery(queryString).executeUpdate();
		em.persist(dcv);
		em.getTransaction().commit();
		em.close();
		return flag;
	}
	/**
	 * �������ݿ���� - ��ʱ����
	 * @return
	 */
	public DbConfigVO getConnectConfigData(){
		StringBuilder sb = new StringBuilder("select ");
		sb.append(" * ");
		sb.append(" from t_dbconfig_ww   where  info = 'sqlServer'");
    	DataAccess dataAccessObject = new DataAccess();
    	DbConfigVO dcv = new DbConfigVO();
		try {
			CachedRowSet rs = dataAccessObject.query(sb.toString());
			while (rs.next()) {
				dcv.setDataBaseName(rs.getString("database_name")==null?"":rs.getString("database_name").trim());
				dcv.setDataBaseType(rs.getString("database_type")==null?"":rs.getString("database_type").trim());
				dcv.setInfo(rs.getString("info")==null?"":rs.getString("info").trim());
				dcv.setIpAddr(rs.getString("ip_addr")==null?"":rs.getString("ip_addr").trim());
				dcv.setPwd(rs.getString("pwd")==null?"":rs.getString("pwd").trim());
				dcv.setTableName(rs.getString("table_name")==null?"":rs.getString("table_name").trim());
				dcv.setUid(rs.getString("uid")==null?"":rs.getString("uid").trim());
				dcv.setStrForSql(rs.getString("strForSql")==null?"":rs.getString("strForSql").trim());
				dcv.setStrInsertSql(rs.getString("strInsertSql")==null?"":rs.getString("strInsertSql").trim());
				dcv.setStrSelectSql(rs.getString("strSelectSql")==null?"":rs.getString("strSelectSql").trim());
				dcv.setStrSelectTSql(rs.getString("strSelectTSql")==null?"":rs.getString("strSelectTSql").trim());
		}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	 return dcv;
	}
	/**
	 * �������ݿ���� - ��ʽ����
	 * @param taskName
	 * @return
	 */
	public DbConfigVO getTaskInfoData(String taskName){
		StringBuilder sb = new StringBuilder("select ");
		sb.append(" * ");
		sb.append(" from t_taskinfo_ww   where  task_name = '"+taskName+"' ");
		DataAccess dataAccessObject = new DataAccess();
		DbConfigVO dcv = new DbConfigVO();
		try {
			CachedRowSet rs = dataAccessObject.query(sb.toString());
			while (rs.next()) {
				dcv.setDataBaseName(rs.getString("database_name")==null?"":rs.getString("database_name").trim());
				dcv.setDataBaseType(rs.getString("database_type")==null?"":rs.getString("database_type").trim());
				dcv.setInfo(rs.getString("info")==null?"":rs.getString("info").trim());
				dcv.setIpAddr(rs.getString("ip_addr")==null?"":rs.getString("ip_addr").trim());
				dcv.setPwd(rs.getString("pwd")==null?"":rs.getString("pwd").trim());
				dcv.setTableName(rs.getString("table_name")==null?"":rs.getString("table_name").trim());
				dcv.setUid(rs.getString("uid")==null?"":rs.getString("uid").trim());
				dcv.setStrForSql(rs.getString("strForSql")==null?"":rs.getString("strForSql").trim());
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return dcv;
	}
 
    /**
     * ��ѯ���ش�����ƥ���ֶ�  ttable_ww
     * @return �ֶ��б�
     */
    public List<TableClumVO> getTableClum(){
    	List<TableClumVO> list = new ArrayList<TableClumVO>();
    	StringBuilder sb = new StringBuilder("select ");
    	sb.append(" * ");
    	sb.append(" from ttable_ww ");
    	DataAccess dataAccessObject = new DataAccess();
    	try {
    		CachedRowSet rs = dataAccessObject.query(sb.toString());
    		while (rs.next()) {
    			TableClumVO tcv = new TableClumVO();
    			tcv.setId(rs.getInt("id"));
    			tcv.setLocalClumName(rs.getString("name").trim());
    			tcv.setRemoteClumName("");
    			tcv.setInfo(rs.getString("name_cn").trim());
    			list.add(tcv);
    		}	
    	} catch (SQLException e1) {
    		// TODO Auto-generated catch block
    		e1.printStackTrace();
    	}
    	return list;
    }

    /**
     * ��ѯ���ش�����ƥ���ֶ�  t_table_ww
     * @return �ֶ��б�
     */
    public List<TableClumVO> getTableClum(String taskName){
    	List<TableClumVO> list = new ArrayList<TableClumVO>();
    	StringBuilder sb = new StringBuilder("select ");
    	sb.append(" * ");
    	sb.append(" from t_table_ww where task_name = '"+taskName+"'"+" order by  remote_clum_name desc" );
    	DataAccess dataAccessObject = new DataAccess();
    	try {
    		CachedRowSet rs = dataAccessObject.query(sb.toString());
    		while (rs.next()) {
    			TableClumVO tcv = new TableClumVO();
    			tcv.setId(rs.getInt("id"));
    			tcv.setLocalClumName(rs.getString("local_clum_name")==null?"":rs.getString("local_clum_name").trim());
    			tcv.setRemoteClumName(rs.getString("remote_clum_name")==null?"":rs.getString("remote_clum_name").trim());
    			list.add(tcv);
    		}	
    	} catch (SQLException e1) {
    		// TODO Auto-generated catch block
    		e1.printStackTrace();
    	}
    	return list;
    }
    /**
     * ��ѯ���ش�����ƥ���ֶ�  t_table_ww
     * @return �ֶ��б� remote ��Ч�ֶ��г� 
     */
    public List<TableClumVO> getTableClumRemote(String taskName){
    	List<TableClumVO> list = new ArrayList<TableClumVO>();
    	StringBuilder sb = new StringBuilder("select ");
    	sb.append(" * ");
    	sb.append(" from t_table_ww where task_name = '"+taskName+"'"+" order by  remote_clum_name desc" );
    	DataAccess dataAccessObject = new DataAccess();
    	try {
    		CachedRowSet rs = dataAccessObject.query(sb.toString());
    		while (rs.next()) {
    			if(!(rs.getString("remote_clum_name")==null||"".equals(rs.getString("remote_clum_name")))){
    			TableClumVO tcv = new TableClumVO();
    			tcv.setId(rs.getInt("id"));
    			tcv.setLocalClumName(rs.getString("local_clum_name")==null?"":rs.getString("local_clum_name").trim());
    			tcv.setRemoteClumName(rs.getString("remote_clum_name")==null?"":rs.getString("remote_clum_name").trim());
    			list.add(tcv);
    			}
    		}	
    	} catch (SQLException e1) {
    		// TODO Auto-generated catch block
    		e1.printStackTrace();
    	}
    	return list;
    }
    /**
     * �ֶ��б�
     * @param tableName
     * @return �ֶ��б�
     */
    public List<String>  getClumByTableName(String tableName){
    	List<String>  list = new ArrayList<String>();
		StringBuilder sb = new StringBuilder("select c.name clumName,a.name tableName from syscolumns c ,sysobjects a  ");
		sb.append(" where c.id=a.id and a.name = ");
		sb.append("'"+tableName+"'");
    	DataAccess dataAccessObject = new DataAccess();
		try {
			CachedRowSet rs = dataAccessObject.query(sb.toString());
			while (rs.next()) {
                list.add(rs.getString("clumName"));
		  }	
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	return list;
    }
 
    /**
     * ���� ��ѯ���ͼӹ�ֵ 
     * @return
     */
    public String strByType(String str){
    	String value = "";
    	return value;
    }
    /**
     * ƴ��¼׷�����
     * @param localClumNames
     * @param remoteClumNames
     * @return
     */
    public int inserSelectQuery(String localClumNames,String remoteClumNames,String sqlQuery){
    	int flag = 0;
		DbConfigVO dcv = getConnectConfigData();
		String remoteCon = "openrowset('SQLOLEDB','"+dcv.getIpAddr()+"';'"+dcv.getUid()+"';'"+dcv.getPwd()+"',"+dcv.getDataBaseName()+".dbo."+dcv.getTableName()+")";
		// ׷�����ǰ�벿��insert
		String strInsertSql = "insert into t_jgdm_ww"+"("+localClumNames+") ";
		// ׷������벿��select
		String strSelectSql = " select  "+remoteClumNames+"  from "+remoteCon+" where 1=1";
		// ׷������벿��select - ������֤��
		String strSelectTSql = " select  top 0 "+remoteClumNames+"  from "+remoteCon+" where 1=1";
		
		dcv.setStrInsertSql(strInsertSql);
		dcv.setStrSelectSql(strSelectSql);
		dcv.setStrSelectTSql(strSelectTSql);
		dcv.setStrForSql(sqlQuery);
		// ����
		EntityManager em = EntityManagerHelper.getEntityManager();
		em.getTransaction().begin();
        String queryString = "delete from  t_dbconfig_ww";
        em.createNativeQuery(queryString).executeUpdate();
		em.persist(dcv);
		em.getTransaction().commit();
		em.close();
		return flag;
    }
 //////////////////////////////////   
    /**
     *  ƥ����֤
     * @return
     */
    public String executeTesting(){
    	String flag = "ƥ��ɹ���";
    	int isFlag = 0;
		DbConfigVO dcv = getConnectConfigData();
    	// ��֤   ��벿�ִ��������
    	isFlag = testSelect(dcv);
    	if(isFlag != 0){
    		flag = "ƥ���ֶδ��";
    		return flag;
    	}
    	// ��֤ ����������������
    	isFlag =testSelettByFor(dcv);
    	if(isFlag != 0){
    		flag = "�����������";
    		return flag;
    	}
    	// ��֤�������
    	isFlag = testInsertAll(dcv);
    	if(isFlag != 0){
    		flag = "�ֶγ��Ȼ����Ͳ�ƥ�䣡";
    		return flag;
    	}
    	return flag;
    }
    
    private int testSelect(DbConfigVO dcv){
    	int flag = 0;
    	String strSelectSql = dcv.getStrSelectSql();	 
    	DataAccess dataAccessObject = new DataAccess();
		try {
			CachedRowSet rs = dataAccessObject.query(strSelectSql);
			if (rs.next()) {
		  }
		} catch (SQLException e1) {
			flag = 1;
			e1.printStackTrace();
		}
    	return flag;
    }
    private int testSelettByFor(DbConfigVO dcv){
    	int flag = 0;
    	String strSelectSql = dcv.getStrSelectSql();
    	String strForSql = dcv.getStrForSql();
    	String connectSql = strSelectSql+" "+strForSql;
    	DataAccess dataAccessObject = new DataAccess();
    	try {
			flag = dataAccessObject.executeMessage(connectSql);
		} catch (SQLException e) {
			flag = 1;
			log.error(e);
		}
    	return flag;
    }
    private int testInsertAll(DbConfigVO dcv){
    	int flag = 0;	
    	String strInsertSql = dcv.getStrInsertSql();
    	String strSelectTSql = dcv.getStrSelectTSql();
    	String strForSql = dcv.getStrForSql();
    	String connectSql = strInsertSql+" "+strSelectTSql+" "+strForSql;
    	DataAccess dataAccessObject = new DataAccess();
		try {
			flag = dataAccessObject.executeMessage(connectSql);
		} catch (SQLException e) {
			flag = 1;
			log.error(e);
		}
    	return flag;
    }
 ////////////////////////////////////////////////////////
    /**
     * ��������
     */
    public int taskSave(TaskNameVO tnv){
    	int flag = 0;
		EntityManager em = EntityManagerHelper.getEntityManager();
		em.getTransaction().begin();
		em.persist(tnv);
		em.getTransaction().commit();
		em.close();
		return flag;
    }
    /**
     * �����ֶ�ƥ���ϵ - t_table_ww
     * @param taskName
     * @param localClumNames
     * @param remoteClumNames
     * @param infoClums
     * @return
     */
    public int tableClumSave(String taskName,String localClumNames,String remoteClumNames,String infoClums){
    	int flag = 0;
 		String [] localClumName = localClumNames.split("[|]");
 		String [] remoteClumName = remoteClumNames.split("[|]");
 		String [] infoClum = infoClums.split("[|]");
 		for (int i = 0; i < localClumName.length; i++) {
 			  TableClumVO tcv = new TableClumVO();
 			  tcv.setLocalClumName(localClumName[i]);
 			  if(i <  remoteClumName.length){
 				 tcv.setRemoteClumName(remoteClumName[i]);
 			  }else{
 				 tcv.setRemoteClumName("");
 			  }
 			  tcv.setInfo(infoClum[i]);
 			  tcv.setTaskName(taskName);
 			  EntityManager em = EntityManagerHelper.getEntityManager();
 			  em.getTransaction().begin();
 			  em.persist(tcv);
 			  em.getTransaction().commit();
 			  em.close();              
 		}
    	return flag;
    }
    /**
     * ɾ������
     * @param taskName
     * @return
     */
    public boolean taskDelete(String taskName){
		boolean flag = true;
		EntityManager em = EntityManagerHelper.getEntityManager();
		em.getTransaction().begin();
		// ���ݿ������������
        String sb = "delete from t_taskinfo_ww where task_name = '"+taskName+"'";
        // �ֶ�ƥ������
        String sp = "delete from t_table_ww where task_name = '"+taskName+"'";
        em.createNativeQuery(sp).executeUpdate();
        em.createNativeQuery(sb).executeUpdate();
		em.getTransaction().commit();
		em.close();
		return flag;
    }
    /**
     * �ظ����
     * @param taskName
     * @return
     */
    public int taskRepeat(String taskName){
    	int totalCount = 0;
    	String sqlQuery = "select count(task_name) totalCount from t_taskinfo_ww where task_name = '"+taskName+"'";
    	DataAccess dataAccessObject = new DataAccess();
		try {
			CachedRowSet rs = dataAccessObject.query(sqlQuery);
			while (rs.next()) {
				totalCount = rs.getInt("totalCount");
		  }
		} catch (SQLException e1) {
			totalCount = -1;
			e1.printStackTrace();
		}
		return totalCount;
    }
    /**
     * �����ѯ
     * @return
     */
    public TaskNameVO taskList(String taskName){
    	TaskNameVO tnv = new TaskNameVO();
    	String strSql = "select * from t_taskinfo_ww where task_name ='"+taskName+"'";
    	DataAccess dataAccessObject = new DataAccess();
		try {
			CachedRowSet rs = dataAccessObject.query(strSql);
			while (rs.next()) {
				tnv.setId(rs.getInt("id"));
				tnv.setTaskName(rs.getString("task_name")==null?"":rs.getString("task_name").trim());
				tnv.setIpAddr(rs.getString("ip_addr")==null?"":rs.getString("ip_addr").trim());
				tnv.setDataBaseName(rs.getString("database_name")==null?"":rs.getString("database_name").trim());
				tnv.setUid(rs.getString("uid")==null?"":rs.getString("uid").trim());
				tnv.setPwd(rs.getString("pwd")==null?"":rs.getString("pwd").trim());
				tnv.setTableName(rs.getString("table_name")==null?"":rs.getString("table_name").trim());
				tnv.setDataBaseType(rs.getString("database_type")==null?"":rs.getString("database_type").trim());
				tnv.setStrForSql(rs.getString("strForSql")==null?"":rs.getString("strForSql").trim());
				tnv.setExecuteSql(rs.getString("execute_sql")==null?"":rs.getString("execute_sql").trim());
				tnv.setInfo(rs.getString("info")==null?"":rs.getString("info").trim());
		  }	
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	return tnv;
    }
    /**
     * �����б� - ��ʾ 
     * @return
     */
    public List<TaskNameVO> taskList(){
    	List<TaskNameVO> list = new ArrayList<TaskNameVO>();
    	String strSql = "select * from t_taskinfo_ww";
    	DataAccess dataAccessObject = new DataAccess();
		try {
			CachedRowSet rs = dataAccessObject.query(strSql);
			while (rs.next()) {
				TaskNameVO tnv = new TaskNameVO();
				tnv.setId(rs.getInt("id"));
				tnv.setTaskName(rs.getString("task_name")==null?"":rs.getString("task_name").trim());
                list.add(tnv);
		  }	
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	return list;
    }
    /**
     * ��ʼ���� 
     * @return
     */
    public int  startImportData(String taskName){
    	int flag = 0;	
    	TaskNameVO tnv = this.taskList(taskName);
    	String connectSql = tnv.getExecuteSql();
    	DataAccess dataAccessObject = new DataAccess();
    	try {
    		flag = dataAccessObject.executeMessage(connectSql);
    	} catch (SQLException e) {
    		flag = 1;
    		log.error(e);
    	}
    	return flag;
    }
}
