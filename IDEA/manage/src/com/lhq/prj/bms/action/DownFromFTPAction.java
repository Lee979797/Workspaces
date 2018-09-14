package com.lhq.prj.bms.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

import com.lhq.prj.bms.core.BaseAction;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import org.apache.struts2.ServletActionContext;
//import com.opensymphony.xwork2.ActionSupport;
import com.lhq.prj.bms.core.DownFTPEFile;



@SuppressWarnings("serial")
public class DownFromFTPAction extends BaseAction{

	private static final long serialVersionUID = 1L;

	private String tableName  = "";
	private String PID = "";	
	private String filePath = "";
	private String fileShowName = "";
	private String fileShowTitle = "";
	private String ePageType = "";
	
	private String JSONDataString = "";
	
	public String getJSONDataString() {
		return JSONDataString;
	}
	public void setJSONDataString(String dataString) {
		JSONDataString = dataString;
	}
	public String getFileShowTitle() {
		return fileShowTitle;
	}
	public void setFileShowTitle(String fileShowTitle) {
		this.fileShowTitle = fileShowTitle;
	}
	public DownFromFTPAction(){
		
	}		
	
	@Override
	public String execute() {
		//得到request
	  	HttpServletRequest request = ServletActionContext.getRequest();
	  	HttpSession session = request.getSession();
	    
	  	String table_Name = "";
		String aPID = "";
		String savePath = "";
		String saveFileName = "";

		savePath = session.getServletContext().getRealPath("/")+"efile";
		savePath = savePath.replace("\\", "/");
		saveFileName = session.getAttribute("username").toString(); //以登录用户名作为下载的文件的名字
		
	  	if ((request.getParameter("tblname")!=null)&&
	  	    (!request.getParameter("tblname").equals(""))){
	  		table_Name = request.getParameter("tblname").toString();
	  	}
	  	
	  	if ((request.getParameter("pid")!=null)&&
		  	(!request.getParameter("pid").equals(""))){
	  		aPID = request.getParameter("pid").toString();
	  	}
	  	
		try
		{		
		    if ((!table_Name.equals(""))&&(table_Name!="")){
		    	this.setTableName(table_Name);
		    }
		    
		    if ((!aPID.equals(""))&&(aPID!="")){
		    	this.setPID(aPID);
		    }	
		    
		    DownFTPEFile DownEFile = new DownFTPEFile();
		  	
		    DownEFile.setSaveFilePath(savePath);
		    DownEFile.setSaveFileName(saveFileName);
		    DownEFile.setPID(this.getPID());         
		    DownEFile.setTblName(this.getTableName()); 
		    
		    String saveFilePath = DownEFile.getFileFromServer();
   
		    if (saveFilePath==null){
		    	this.setJSONDataString("{success:false,msg:'文件读取失败'}");
		    	return ERROR;
		    }
		    
		    this.setFilePath(saveFilePath);
		    this.setFileShowName(DownEFile.getFtpFileName());
		    this.setFileShowTitle(DownEFile.getOrignalName());
		    this.setEPageType(DownEFile.getEPageType());
		    
		    session.setAttribute("FileSavePath", this.getFilePath());
		    session.setAttribute("FileShowName", this.getFileShowName());
		    session.setAttribute("FileShowTitle", this.getFileShowTitle());
		    session.setAttribute("EPageType", this.getEPageType());
		    
		    this.setJSONDataString("{success:true,msg:'文件读取成功'}");
			return SUCCESS;
			
		}catch(Exception e)
		{
			System.out.println("execute() of DownFromFTPAction.java throws : "+e.toString());
			this.setJSONDataString("{success:false,msg:'"+e.toString()+"'}");
			return ERROR;
		}
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	public String getPID() {
		return PID;
	}

	public void setPID(String pid) {
		PID = pid;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileShowName() {
		return fileShowName;
	}

	public void setFileShowName(String fileShowName) {
		this.fileShowName = fileShowName;
	}

	public String getEPageType() {
		return ePageType;
	}

	public void setEPageType(String pageType) {
		ePageType = pageType;
	}
}
