package com.ninemax.jpa.code.action;

	/**
	 *
	 */
	import com.ninemax.jpa.code.bus.*;
    import com.ninemax.jpa.code.dao.ImportRun;
    import com.ninemax.jpa.code.model.vo.DbConfigVO;
    import com.ninemax.jpa.code.model.vo.TableClumVO;
    import com.ninemax.jpa.code.model.vo.TaskNameVO;
    import com.ninemax.jpa.util.TxtUtil;
	import com.opensymphony.xwork2.ActionSupport;
	import org.apache.struts2.interceptor.SessionAware;
	import java.util.List;
    import java.util.Map;
	/**
	 * @author yanzh
	 */
	public class BusinessImportDataAction extends ActionSupport implements SessionAware {
		private DbConfigVO dbConfigVO;
		private TableClumVO tableClumVO;
		private TaskNameVO taskNameVO;
		private List<TableClumVO> tcvList;
		private List<TaskNameVO> taskList;
		private List<String> clumList;
		private ImportDataBus importDataBus = new ImportDataBus();
        private String currentPath = "/product/jsp/importData/";
        private String strForSql;  
        private String taskName;
        private String flag;
	    public String connect() {
	        currentPath = currentPath + "connectConfig.jsp";
	            flag = "0";  // 选择任务时，默认显示 标识
		        dbConfigVO = importDataBus.getConnectConfigData();
		        tcvList = importDataBus.getTableClum();
		        clumList = importDataBus.getClumByTableName();
		        taskList = importDataBus.taskList();
		        strForSql = dbConfigVO.getStrForSql();
	        return this.SUCCESS;
	    }
        public String taskConnect(){
	        currentPath = currentPath + "connectConfig.jsp";
            flag = "1";  // 选择任务时，默认显示 标识
            dbConfigVO = importDataBus.getTaskInfoData(taskName);
            tcvList = importDataBus.getTtableClum(taskName);
 	        clumList = importDataBus.getClumByTableName(taskName);
 	        taskList = importDataBus.taskList();
 	        strForSql = dbConfigVO.getStrForSql();
        	return this.SUCCESS;
        }
	    public String importData() {
            // 文件属性 可写
    		TxtUtil txu = new TxtUtil();
    		txu.setWrite();
	        taskList = importDataBus.taskList();
	        currentPath = currentPath + "importData.jsp";
	        return this.SUCCESS;  
	    }
        public String importStart(){
        	if("0".equals(flag)){
            	ImportRun importRun = new ImportRun(taskName);
            	new Thread(importRun).start();
            	currentPath = currentPath + "onLoading.jsp";
        	}else{
    	        taskList = importDataBus.taskList();
    	        currentPath = currentPath + "importData.jsp";
        	}
	        return this.SUCCESS;  
        }
	    public String importDelete(){
    		importDataBus.taskDelete(taskName);
	        taskList = importDataBus.taskList();
	        currentPath = currentPath + "importData.jsp";
	        return this.SUCCESS; 
	    }
		@Override
		public void setSession(Map<String, Object> arg0) {
			// TODO Auto-generated method stub
			
		}
		public String getCurrentPath() {
			return currentPath;
		}
		public void setCurrentPath(String currentPath) {
			this.currentPath = currentPath;
		}
		public DbConfigVO getDbConfigVO() {
			return dbConfigVO;
		}
		public void setDbConfigVO(DbConfigVO dbConfigVO) {
			this.dbConfigVO = dbConfigVO;
		}
		public TableClumVO getTableClumVO() {
			return tableClumVO;
		}
		public void setTableClumVO(TableClumVO tableClumVO) {
			this.tableClumVO = tableClumVO;
		}
		public List<String> getClumList() {
			return clumList;
		}
		public void setClumList(List<String> clumList) {
			this.clumList = clumList;
		}
		public String getStrForSql() {
			return strForSql;
		}
		public void setStrForSql(String strForSql) {
			this.strForSql = strForSql;
		}

		public String getTaskName() {
			return taskName;
		}

		public void setTaskName(String taskName) {
			this.taskName = taskName;
		}

		public TaskNameVO getTaskNameVO() {
			return taskNameVO;
		}

		public void setTaskNameVO(TaskNameVO taskNameVO) {
			this.taskNameVO = taskNameVO;
		}

		public List<TaskNameVO> getTaskList() {
			return taskList;
		}

		public void setTaskList(List<TaskNameVO> taskList) {
			this.taskList = taskList;
		}

		public String getFlag() {
			return flag;
		}

		public void setFlag(String flag) {
			this.flag = flag;
		}

		public List<TableClumVO> getTcvList() {
			return tcvList;
		}

		public void setTcvList(List<TableClumVO> tcvList) {
			this.tcvList = tcvList;
		}


	}

