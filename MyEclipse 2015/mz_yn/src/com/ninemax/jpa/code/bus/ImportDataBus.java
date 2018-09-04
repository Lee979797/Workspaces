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
	 * ����,����
	 * 
	 * @param ip
	 * @param dataBaseName
	 * @param uid
	 * @param pwd
	 * @return
	 */
	public int getConnection(String ip, String dataBaseName, String uid,
			String pwd,String tableName) {
		int messag = 0;  // �ɹ�
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

		// �ж���Ӧ��治����
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
		// �����������
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
	 * �ֶ�ƥ�䱣�棬��֤������ѯ���
	 * @param list
	 * @return
	 */
	public String clumMatch(String clumIds,String localClumNames,String remoteClumNames,String sqlQuery){
		String flag = "ƥ��ɹ���";
		String [] clumId = clumIds.split("[,]");
		String [] localClumName = localClumNames.split("[,]");
		String [] remoteClumName = remoteClumNames.split("[,]");
		// �洢SQLִ�����
		 importDataDAO.inserSelectQuery(localClumNames, remoteClumNames,sqlQuery);
	    // �Դ洢SQL��������֤
		flag = importDataDAO.executeTesting();
		return flag;
	}
	/**
	 * ��ȡ���ݿ���� - ��ʱ�������
	 * @return
	 */
     public DbConfigVO getConnectConfigData(){
          return importDataDAO.getConnectConfigData();
     }
     public DbConfigVO getTaskInfoData(String taskName){
    	 return importDataDAO.getTaskInfoData(taskName);
     }
     /**
      * ��ѯ���ش�����ƥ���ֶ� - Ĭ��û��ѡ��״̬�£���Ӧ����
      * @return 
      */
     public List<TableClumVO>  getTableClum(){
    	return  importDataDAO.getTableClum();
     }
     /**
      * ��ѯ���ش�����ƥ���ֶ� - ѡ��״̬��
      * @return 
      */
     public List<TableClumVO>  getTtableClum(String taskName){
    	 return  importDataDAO.getTableClum(taskName);
     }
     /**
      * ��ѯ���ش�����ƥ���ֶ� - ����������ʾ�ֶ��г�
      * @return 
      */
     public List<TableClumVO>  getTtableClumRemote(String taskName){
    	 return  importDataDAO.getTableClumRemote(taskName);
     }
     /**
      *  ����ָ��������ȡ����Ӧ�ֶ�
      * @return �ֶ��б� 
      */
     public List<String>  getClumByTableName(){
    	 DbConfigVO dcv = getConnectConfigData();
    	 List<String> list = importDataDAO.getClumByTableName(dcv.getTableName());
    	 return list;
     }
     /**
      *  ����ָ��������ȡ����Ӧ�ֶ�
      * @return �ֶ��б� 
      */
     public List<String>  getClumByTableName(String taskName){
    	 DbConfigVO dcv = getConnectConfigData();
    	 List<String> list = importDataDAO.getClumByTableName(dcv.getTableName());
    	 return list;
     }
  //////////////////////////////////////////////   ��       ��    ////////////////////////////////////////////////////////////////////////   
     /**
      *  ��������
      * @param taskName
      * @return
      */
     public int taskSave(String taskName,String dabaseConfigs,String localClumNames,String remoteClumNames,String infoClums){
 		int flag = 0;  // �ɹ�
		String [] dabaseConfig = dabaseConfigs.split("[|]");
 		TaskNameVO tnv = this.dataConfig2TaskVo(taskName,localClumNames,remoteClumNames,dabaseConfig);
 		importDataDAO.taskSave(tnv);
  		importDataDAO.tableClumSave(taskName,localClumNames,remoteClumNames,infoClums);
		return flag; 
     }
     /**
      * ɾ������
      * @param taskName
      * @return
      */
     public  int taskDelete(String taskName){
    	 int flag = 0;
    	 importDataDAO.taskDelete(taskName);
    	 return flag;
     }
     /**
      * ��������
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
      * �����ѯ
      * @param tastName
      * @return
      */
     public String taskByName(String tastName){
    	 StringBuilder sb = new StringBuilder("");
    	 List<TableClumVO> tableClumList = importDataDAO.getTableClumRemote(tastName);
    	 TaskNameVO tnv = importDataDAO.taskList(tastName);
    	 sb.append(tnv.getIpAddr()+"|");   // ���ݿ������IP��ַ
    	 sb.append(tnv.getDataBaseName()+"|"); // ���ݿ���
    	 sb.append(tnv.getUid()+"|"); // �û���
    	 sb.append(tnv.getPwd()+"|"); // ����
    	 sb.append(tnv.getTableName()+"|"); // ����
    	// ������ѡ�ֶ�
    	 for(int i = 0; i < tableClumList.size();i++){
    		 sb.append(tableClumList.get(i).getRemoteClumName());
    		 if((i+1)<tableClumList.size()){
    			 sb.append(",");
    		 }
    	 }
    	 sb.append("|"); 
    	 sb.append(tnv.getStrForSql()+"|"); // �������
    	 return sb.toString(); 
     }
     /**
      * �����б� 
      * @return
      */
     public List<TaskNameVO> taskList(){
    	 return importDataDAO.taskList();
     }
     /**
      * �������ظ��ж�
      * @param taskName
      * @return 0 ���ظ�
      */
     public int taskRepeat(String taskName,String dabaseConfigs,String localClumNames,String remoteClumNames,String infoClums){
    	 int totalCount = 0;
    		// �ж���Ӧ��治����
    	 totalCount = importDataDAO.taskRepeat(taskName);
    	 if(totalCount == 0){
    	 		//��������
    	 		this.taskSave(taskName,dabaseConfigs,localClumNames,remoteClumNames,infoClums);
    	 }
    	 return totalCount;
     }
     // ҳ�洫�������ַ������������Ž������t_taskinfo_ww��������ͷ
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
		// ׷�����ǰ�벿��insert
		String strInsertSql = "insert into t_jgdm_ww"+"("+localClums+") ";
		// ׷������벿��select
		String strSelectSql = " select  "+remoteClums+"  from "+remoteCon+" where 1=1";
		String executeSql =  strInsertSql+' '+strSelectSql+' '+tnv.getStrForSql();
		tnv.setExecuteSql(executeSql);
    	return tnv;
     }
 /////////////////////////////////////////////////////   ��       ��         ///////////////////////////////////////////////////////////////////    
}
