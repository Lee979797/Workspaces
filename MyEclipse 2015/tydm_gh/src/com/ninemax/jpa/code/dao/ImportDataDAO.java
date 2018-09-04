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
	 * 数据库配置参数删除，保存
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
	 * 返回数据库参数 - 临时保存
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
	 * 返回数据库参数 - 正式保存
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
     * 查询本地待导入匹配字段  ttable_ww
     * @return 字段列表
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
     * 查询本地待导入匹配字段  t_table_ww
     * @return 字段列表
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
     * 查询本地待导入匹配字段  t_table_ww
     * @return 字段列表 remote 有效字段列出 
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
     * 字段列表
     * @param tableName
     * @return 字段列表
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
     * 根据 查询类型加工值 
     * @return
     */
    public String strByType(String str){
    	String value = "";
    	return value;
    }
    /**
     * 拼记录追加语句
     * @param localClumNames
     * @param remoteClumNames
     * @return
     */
    public int inserSelectQuery(String localClumNames,String remoteClumNames,String sqlQuery){
    	int flag = 0;
		DbConfigVO dcv = getConnectConfigData();
		String remoteCon = "openrowset('SQLOLEDB','"+dcv.getIpAddr()+"';'"+dcv.getUid()+"';'"+dcv.getPwd()+"',"+dcv.getDataBaseName()+".dbo."+dcv.getTableName()+")";
		// 追加语句前半部分insert
		String strInsertSql = "insert into t_jgdm_ww"+"("+localClumNames+") ";
		// 追加语句后半部分select
		String strSelectSql = " select  "+remoteClumNames+"  from "+remoteCon+" where 1=1";
		// 追加语句后半部分select - 测试验证用
		String strSelectTSql = " select  top 0 "+remoteClumNames+"  from "+remoteCon+" where 1=1";
		
		dcv.setStrInsertSql(strInsertSql);
		dcv.setStrSelectSql(strSelectSql);
		dcv.setStrSelectTSql(strSelectTSql);
		dcv.setStrForSql(sqlQuery);
		// 更新
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
     *  匹配验证
     * @return
     */
    public String executeTesting(){
    	String flag = "匹配成功！";
    	int isFlag = 0;
		DbConfigVO dcv = getConnectConfigData();
    	// 验证   后半部分待插入语句
    	isFlag = testSelect(dcv);
    	if(isFlag != 0){
    		flag = "匹配字段错语！";
    		return flag;
    	}
    	// 验证 加入条件语句后的语句
    	isFlag =testSelettByFor(dcv);
    	if(isFlag != 0){
    		flag = "条件加入错误！";
    		return flag;
    	}
    	// 验证整条语句
    	isFlag = testInsertAll(dcv);
    	if(isFlag != 0){
    		flag = "字段长度或类型不匹配！";
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
     * 保存任务
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
     * 保存字段匹配关系 - t_table_ww
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
     * 删除任务
     * @param taskName
     * @return
     */
    public boolean taskDelete(String taskName){
		boolean flag = true;
		EntityManager em = EntityManagerHelper.getEntityManager();
		em.getTransaction().begin();
		// 数据库参数配置数据
        String sb = "delete from t_taskinfo_ww where task_name = '"+taskName+"'";
        // 字段匹配数据
        String sp = "delete from t_table_ww where task_name = '"+taskName+"'";
        em.createNativeQuery(sp).executeUpdate();
        em.createNativeQuery(sb).executeUpdate();
		em.getTransaction().commit();
		em.close();
		return flag;
    }
    /**
     * 重复检查
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
     * 任务查询
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
     * 任务列表 - 显示 
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
     * 开始导入 
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
