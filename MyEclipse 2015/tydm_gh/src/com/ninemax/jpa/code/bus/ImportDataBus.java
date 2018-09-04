package com.ninemax.jpa.code.bus;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


import com.ninemax.jpa.code.dao.ImportDataDAO;
import com.ninemax.jpa.code.model.vo.DbConfigVO;
import com.ninemax.jpa.code.model.vo.TableClumVO;
import com.ninemax.jpa.code.model.vo.TaskNameVO;
import com.ninemax.jpa.code.model.vo.TtableVO;
import org.apache.log4j.Logger;

public class ImportDataBus {
    private static Logger log = Logger.getLogger(ImportDataBus.class);
    private Connection conn;
	private Statement stmt;
	ResultSet rs;
	private String url  ;
	private String classforname = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private ImportDataDAO importDataDAO = new ImportDataDAO();
	/**
	 * 连接,保存
	 * 
	 * @param ip
	 * @param dataBaseName
	 * @param uid
	 * @param pwd
	 * @return
	 */
	public int getConnection(String ip, String dataBaseName, String uid,
			String pwd,String tableName) {
		int messag = 0;  // 成功
		url = "jdbc:sqlserver://" + ip + ":1433;DatabaseName="
				+ dataBaseName + "";

			try {
				Class.forName(classforname);
			} catch (ClassNotFoundException e1) {
				messag = 1;
				e1.printStackTrace();
			}
			    try {
			    	 conn = DriverManager.getConnection(url, uid, pwd);
					stmt = conn.createStatement();
				} catch (Exception e) {
					messag = 2;
                    log.error(ImportDataBus.class,e);
				}

		// 判断相应表存不存在
		if(messag == 0){
			int totalCount = 0;
			String sqlQuery = "select count(*) totalCount from sysobjects where name = '"+tableName+"'";
			try {
				rs = stmt.executeQuery(sqlQuery);
				while (rs.next())
					totalCount = rs.getInt("totalCount");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
                log.error(ImportDataBus.class,e);
			}
			if(totalCount == 0){
				messag = 3;
			}
		}
		try {
			if(conn != null) conn.close();
			if(stmt != null)stmt.close();
		} catch (SQLException e) {
			messag = 5;
            log.error(ImportDataBus.class,e);
		}
		// 保存参数配置
		DbConfigVO dcv = new DbConfigVO();
		dcv.setIpAddr(ip);
		dcv.setDataBaseName(dataBaseName);
		dcv.setPwd(pwd);
		dcv.setTableName(tableName);
		dcv.setDataBaseType("sqlServer");
		dcv.setUid(uid);
		dcv.setInfo("sqlServer");
		importDataDAO.dbConfigOpera(dcv);
		return messag;
	}
	/**
	 * 字段匹配保存，验证条件查询语句
	 * @param list
	 * @return
	 */
	public String clumMatch(String clumIds,String localClumNames,String remoteClumNames,String sqlQuery){
		String flag = "匹配成功！";
		String [] clumId = clumIds.split("[,]");
		String [] localClumName = localClumNames.split("[,]");
		String [] remoteClumName = remoteClumNames.split("[,]");
		// 存储SQL执行语句
		 importDataDAO.inserSelectQuery(localClumNames, remoteClumNames,sqlQuery);
	    // 对存储SQL语句进行验证
		flag = importDataDAO.executeTesting();
		return flag;
	}
	/**
	 * 获取数据库参数 - 临时保存参数
	 * @return
	 */
     public DbConfigVO getConnectConfigData(){
          return importDataDAO.getConnectConfigData();
     }
     public DbConfigVO getTaskInfoData(String taskName){
    	 return importDataDAO.getTaskInfoData(taskName);
     }
     /**
      * 查询本地待导入匹配字段 - 默认没有选择状态下，对应任务
      * @return 
      */
     public List<TableClumVO>  getTableClum(){
    	return  importDataDAO.getTableClum();
     }
     /**
      * 查询本地待导入匹配字段 - 选择状态下
      * @return 
      */
     public List<TableClumVO>  getTtableClum(String taskName){
    	 return  importDataDAO.getTableClum(taskName);
     }
     /**
      * 查询本地待导入匹配字段 - 导入数据显示字段列出
      * @return 
      */
     public List<TableClumVO>  getTtableClumRemote(String taskName){
    	 return  importDataDAO.getTableClumRemote(taskName);
     }
     /**
      *  根据指定表名，取出相应字段
      * @return 字段列表 
      */
     public List<String>  getClumByTableName(){
    	 DbConfigVO dcv = getConnectConfigData();
    	 List<String> list = importDataDAO.getClumByTableName(dcv.getTableName());
    	 return list;
     }
     /**
      *  根据指定表名，取出相应字段
      * @return 字段列表 
      */
     public List<String>  getClumByTableName(String taskName){
    	 DbConfigVO dcv = getConnectConfigData();
    	 List<String> list = importDataDAO.getClumByTableName(dcv.getTableName());
    	 return list;
     }
  //////////////////////////////////////////////   任       务    ////////////////////////////////////////////////////////////////////////   
     /**
      *  保存任务
      * @param taskName
      * @return
      */
     public int taskSave(String taskName,String dabaseConfigs,String localClumNames,String remoteClumNames,String infoClums){
 		int flag = 0;  // 成功
		String [] dabaseConfig = dabaseConfigs.split("[|]");
 		TaskNameVO tnv = this.dataConfig2TaskVo(taskName,localClumNames,remoteClumNames,dabaseConfig);
 		importDataDAO.taskSave(tnv);
  		importDataDAO.tableClumSave(taskName,localClumNames,remoteClumNames,infoClums);
		return flag; 
     }
     /**
      * 删除任务
      * @param taskName
      * @return
      */
     public  int taskDelete(String taskName){
    	 int flag = 0;
    	 importDataDAO.taskDelete(taskName);
    	 return flag;
     }
     /**
      * 覆盖任务
      * @param taskName
      * @return
      */
     public int taskCover(String taskName,String dabaseConfigs,String localClumNames,String remoteClumNames,String infoClums){
    	 int flag = 0;
    	 this.taskDelete(taskName);
    	 this.taskSave(taskName,dabaseConfigs,localClumNames,remoteClumNames,infoClums);
    	 return flag;
     }
     /**
      * 任务查询
      * @param tastName
      * @return
      */
     public String taskByName(String tastName){
    	 StringBuilder sb = new StringBuilder("");
    	 List<TableClumVO> tableClumList = importDataDAO.getTableClumRemote(tastName);
    	 TaskNameVO tnv = importDataDAO.taskList(tastName);
    	 sb.append(tnv.getIpAddr()+"|");   // 数据库服务器IP地址
    	 sb.append(tnv.getDataBaseName()+"|"); // 数据库名
    	 sb.append(tnv.getUid()+"|"); // 用户名
    	 sb.append(tnv.getPwd()+"|"); // 密码
    	 sb.append(tnv.getTableName()+"|"); // 表名
    	// 导入所选字段
    	 for(int i = 0; i < tableClumList.size();i++){
    		 sb.append(tableClumList.get(i).getRemoteClumName());
    		 if((i+1)<tableClumList.size()){
    			 sb.append(",");
    		 }
    	 }
    	 sb.append("|"); 
    	 sb.append(tnv.getStrForSql()+"|"); // 条件语句
    	 return sb.toString(); 
     }
     /**
      * 任务列表 
      * @return
      */
     public List<TaskNameVO> taskList(){
    	 return importDataDAO.taskList();
     }
     /**
      * 任务名重复判断
      * @param taskName
      * @return 0 不重复
      */
     public int taskRepeat(String taskName,String dabaseConfigs,String localClumNames,String remoteClumNames,String infoClums){
    	 int totalCount = 0;
    		// 判断相应表存不存在
    	 totalCount = importDataDAO.taskRepeat(taskName);
    	 if(totalCount == 0){
    	 		//保存任务
    	 		this.taskSave(taskName,dabaseConfigs,localClumNames,remoteClumNames,infoClums);
    	 }
    	 return totalCount;
     }
     // 页面传过来的字符串参数整理，放进任务表（t_taskinfo_ww）对象里头
     public TaskNameVO dataConfig2TaskVo(String taskName,String localClumNames,String remoteClumNames,String [] dabaseConfig){
    	 TaskNameVO tnv = new  TaskNameVO();
  		tnv.setIpAddr(dabaseConfig[0]);
 		tnv.setDataBaseName(dabaseConfig[1]);
 		tnv.setUid(dabaseConfig[2]);
 		tnv.setPwd(dabaseConfig[3]);
 		tnv.setTableName(dabaseConfig[4]);
 		tnv.setTaskName(taskName);
		tnv.setStrForSql(dabaseConfig[5]);
 		String [] localClumName = localClumNames.split("[|]");
 		String [] remoteClumName = remoteClumNames.split("[|]");
 		String localClums = "";
 		String remoteClums = "";
 		for (int i = 0; i < remoteClumName.length; i++) {
 		   if(!(remoteClumName[i]==null || "".equals(remoteClumName[i]))){
 			  localClums +=  localClumName[i];
 			  remoteClums += remoteClumName[i];
			    if(i+1<remoteClumName.length){
			    	localClums +=",";
			    	remoteClums +=",";
			    }
		   }
 		}
		String remoteCon = "openrowset('SQLOLEDB','"+tnv.getIpAddr()+"';'"+tnv.getUid()+"';'"+tnv.getPwd()+"',"+tnv.getDataBaseName()+".dbo."+tnv.getTableName()+")";
		// 追加语句前半部分insert
		String strInsertSql = "insert into t_jgdm_ww"+"("+localClums+") ";
		// 追加语句后半部分select
		String strSelectSql = " select  "+remoteClums+"  from "+remoteCon+" where 1=1";
		String executeSql =  strInsertSql+' '+strSelectSql+' '+tnv.getStrForSql();
		tnv.setExecuteSql(executeSql);
    	return tnv;
     }
 /////////////////////////////////////////////////////   任       务         ///////////////////////////////////////////////////////////////////    
}
