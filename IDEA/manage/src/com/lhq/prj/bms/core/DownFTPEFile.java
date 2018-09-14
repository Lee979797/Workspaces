package com.lhq.prj.bms.core;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import com.lhq.prj.bms.db.DBConnction;




public class DownFTPEFile {
	private String tblName  = "";
	private String PID   = "";
	private String DID   = "";
	private String saveFilePath = "";
	private String saveFileName = "";
	private String ftpFileName = "";
	private String eFileName = "";
	private String orignalName ="";
	private String eExt = "";
	private String ePathName = "";
	private String ePageType = "";
	
	public DownFTPEFile(){
		
	}
	
	public String getPZM(){
		Connection conn       = null;
		PreparedStatement pst = null;
		ResultSet         rs  = null;
		
		String aDID = null;
		String aPZM = null;
		String aEFileName = null;
		String aTitle = null;
		String aExtName = null;
		String aPathName = null;
		String SQLString = null;
	
		SQLString = " Select DID,PZM,EFILENAME,TITLE,EXT,PATHNAME from " + this.getTblName() + " Where PID = " + this.getPID();

		//System.out.println("EFileSrch = " +SQLString);
		
		try{
			conn = DBConnction.getConnection();			
			pst = conn.prepareStatement(SQLString, 
										ResultSet.TYPE_SCROLL_INSENSITIVE,
										ResultSet.CONCUR_READ_ONLY);
		    
			rs = pst.executeQuery();//执行查询

			if(rs.next()){				
				aDID = rs.getString("DID");	
				this.setDID(aDID==null?"":aDID.trim()); //DID
				aPZM = rs.getString("PZM");
				aPZM = aPZM==null?"":aPZM.trim();
				aEFileName = rs.getString("EFILENAME");
				this.setEFileName(aEFileName==null?"":aEFileName.trim()); //电子文件名称
				aTitle = rs.getString("TITLE");
				this.setOrignalName(aTitle==null?"":aTitle.trim());//原始文件名称
				aExtName = rs.getString("EXT");
				this.setEExt(aExtName==null?"":aExtName.trim());  //后缀名				
				aPathName = rs.getString("PATHNAME");
				this.setEPathName(aPathName==null?"":aPathName.trim()); //FTP相对路径
			}			
		}
		catch(Exception e)
		{
			System.out.println("getPZM() of DownFTPEFile.java throws : "+e.toString());
		}
		finally
		{
			DBConnction.closeConnection(conn,pst,rs);
		}
		return aPZM;
	}
	
	public ArrayList<String> getPZInfo(){
		Connection conn       = null;
		PreparedStatement pst = null;
		ResultSet         rs  = null;
		
		ArrayList<String> FTPInfo = null;
		
		String PZM = this.getPZM();
		
		if((PZM == null) || (PZM ==""))
		{
			return FTPInfo;
		}	
		
		FTPInfo = new ArrayList<String>();

		try{
			String SQLString = "SELECT CCFS,SERVERADDR, SAVEDBNAME, USERNAME, PASSWD,PORT FROM S_FWQPZ WHERE PZNAME ='" + PZM + "'";
			
			conn = DBConnction.getConnection();			
			pst = conn.prepareStatement(SQLString, 
										ResultSet.TYPE_SCROLL_INSENSITIVE,
										ResultSet.CONCUR_READ_ONLY);
		    
			rs = pst.executeQuery();//执行查询
			
			String aCCFS = null;
			String aSERVERADDR = null;
			String aSAVEDBNAME = null;
			String aUSERNAME = null;
			String aPASSWD = null;
			String aPORT = null;
			
			if(rs.next()){
				aCCFS = rs.getString("CCFS");
				aSERVERADDR = rs.getString("SERVERADDR");
				aSAVEDBNAME = rs.getString("SAVEDBNAME");
				aUSERNAME = rs.getString("USERNAME");
				aPASSWD = rs.getString("PASSWD");
				aPORT = rs.getString("PORT");
				
				FTPInfo.add(aCCFS==null?"":aCCFS.trim());
				FTPInfo.add(aSERVERADDR==null?"":aSERVERADDR.trim());
				FTPInfo.add(aSAVEDBNAME==null?"":aSAVEDBNAME.trim()); //FTP的虚拟路径，或本地存储路径
				FTPInfo.add(aUSERNAME==null?"":aUSERNAME.trim());
				FTPInfo.add(aPASSWD==null?"":aPASSWD.trim());
				FTPInfo.add(aPORT==null?"":aPORT.trim());
			}
			
			//得到P_FILE0中PageType的描述信息
			SQLString = " SELECT PageType FROM P_FILE0 WHERE PID = " + this.getDID() + " order by PageNo ";
			//System.out.println("SQLString="+SQLString);
			pst = conn.prepareStatement(SQLString, 
										ResultSet.TYPE_SCROLL_INSENSITIVE,
										ResultSet.CONCUR_READ_ONLY);
		    
			rs = pst.executeQuery();//执行查询
			String aPageTypeString="";
			while(rs.next()){
				aPageTypeString = aPageTypeString + rs.getString("PageType")+",";
			}
			this.setEPageType(aPageTypeString);
		}
		catch(Exception e)
		{
			System.out.println("getFTPFile() of DownFTPEFile.java throws : "+e.toString());
		}
		finally
		{
			DBConnction.closeConnection(conn,pst,rs);
		}

		return FTPInfo;
	}
	
	
	public String FormatPath(String aPath){
		String tmpStr = aPath;
		//路径分割符统一处理为“/”
		tmpStr = tmpStr.replace("\\", "/");
		
		//去掉开头的“/”
		if (tmpStr.charAt(0)=='/')
		{
			tmpStr = tmpStr.substring(1,tmpStr.length());
		}
		
		//去掉末尾的“/”
		if (tmpStr.endsWith("/")){
			tmpStr = tmpStr.substring(0,tmpStr.length()-1);
		}
		return tmpStr;
	}
	
	//如果有后缀名，则去掉后缀名
	public String FormatName(String aName, String aExtName){
		String newName = aName;		
		if (newName.toUpperCase().endsWith(aExtName.toUpperCase())){
			int i = newName.lastIndexOf('.');
	        if ((i >-1) && (i < (newName.length()))) {
	        	newName = newName.substring(0, i);
	        }
		}		
		//newName = newName + aExtName;
		return newName;
	}
	
	//将URL路径编码为GBK
	public String strEncode(String aStr){		
		String tmpString = "";
		String[] tmpArry = aStr.split("[/]",-1);

		for(int i=0; i<tmpArry.length; i++){
			try {
				tmpString = tmpString + "/" + java.net.URLEncoder.encode(tmpArry[i],"GBK");//编码转换
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}			
		}
		
		tmpString = FormatPath(tmpString);
		return tmpString;
	}
	
	
	public String getFileFromServer(){
    
		String CCFS,FTPIP,VPATH,FTPUSER,FTPPASS,FTPPORT;
		String newFileName = null;
		
		URL ftpURL = null;
		InputStream is = null;
		OutputStream os = null;
		BufferedInputStream inputStream = null;
		
		ArrayList<String> PZInfo = null;
		
		PZInfo = this.getPZInfo();
		
		if (PZInfo==null){
			return newFileName;
		}
		
		CCFS = PZInfo.get(0).toString();    //CCFS //存储方式：1＝FTP服务方式，2＝本地存储方式
		FTPIP = PZInfo.get(1).toString();    //FTP IP
		VPATH = PZInfo.get(2).toString();    //VirtualPath//FTP的虚拟路径，或本地存储路径
		FTPUSER = PZInfo.get(3).toString();  //FTP User
		FTPPASS = PZInfo.get(4).toString();  //FTP Password
		FTPPORT = PZInfo.get(5).toString();  //FTP Port
		
		
		String fileName = this.getEFileName().toUpperCase();
		String titleName = this.getOrignalName().toUpperCase(); //原始电子文件名称
		
		String extName = this.getEExt().toLowerCase();
		if (!extName.startsWith(".")){
			extName = "."+extName;
		}
		
		String savePath = this.getSaveFilePath();//FTP方式下载后保存的本地路径
		
		//System.out.println("fileName1="+fileName);
		//如果有后缀名，则去掉后缀名
		fileName  = FormatName(fileName,extName);
		//System.out.println("fileName2="+fileName);
		
		titleName = FormatName(titleName,extName);
		
		//加上小写的后缀名
		fileName = fileName+extName;
		//titleName = titleName+extName;
		
		this.setFtpFileName(fileName);  //FTP上保存的文件名称
		this.setOrignalName(titleName); //文件原始名称
		
		VPATH = FormatPath(VPATH) + "/" + FormatPath(this.getEPathName()); //组合虚拟路径
		
		//System.out.println("VPATH="+VPATH);
		
		//FTP存储方式
		if(CCFS.equals("1")||CCFS=="1"){
	
			try{
				if (!(new java.io.File(savePath).isDirectory())) //如果文件夹不存在
		        {
					new java.io.File(savePath).mkdir();      //不存在该路径文件夹，则建立此文件夹
		        }
			}catch(Exception e){
				e.printStackTrace();        //创建文件夹失败
				return null;
			}
			
			newFileName = savePath + "/" + this.getSaveFileName()+extName;  //得到保存路径和文件名称：绝对路径
			
			//System.out.println("savePath="+savePath);
			//System.out.println("fileName="+fileName);
			
			String URLString = "ftp://"+ FTPUSER+ ":"+ FTPPASS+ "@"+ FTPIP+ ":"+ FTPPORT+"/"+ VPATH	+ "/"+ fileName;
			
			//System.out.println("GetFTPPath = "+URLString);
			
			try{
				ftpURL = new URL(URLString);
				
				is = ftpURL.openStream();
				inputStream = new BufferedInputStream(is);
				os = new BufferedOutputStream(new FileOutputStream(newFileName));
				
				byte[] buf = new byte[512*2];
				int size = inputStream.read(buf);
				
				while(size != -1) {
					os.write(buf, 0, size);
					size = inputStream.read(buf);
				}
				
				inputStream.close();
				os.close();			
			}catch(Exception e){
				System.out.println("Error in getFileFromServer() of DownFTPEFile.java:"+e.getMessage());
				return null;
			}
			finally
			{
				try
				{
					if(ftpURL!=null)
						ftpURL =null;
				 
					if(os!=null)
					{
						os.close();
						os=null;
					}
					
					if(inputStream!=null)
					{
						inputStream.close();
						inputStream=null;
					}
					
					if(is != null)
					{
						is.close();
						is = null;
					}	
				}
				catch(Exception eee)
				{
					System.out.println("getFileFromFTP() of DownFTPEFile.java throw:"+eee);	
				}
			}
		}else{
			//本地存储方式
			if(CCFS.equals("2")||CCFS=="2"){
				newFileName = VPATH +"/" + fileName;			
			}
		}
		
		//System.out.println("DownFromFilePath="+newFileName);
		return newFileName;
	}
	

	public String getTblName() {
		return tblName;
	}

	public void setTblName(String tblName) {
		this.tblName = tblName;
	}

	public String getPID() {
		return PID;
	}

	public void setPID(String pid) {
		PID = pid;
	}

	public String getEFileName() {
		return eFileName;
	}

	public void setEFileName(String fileName) {
		eFileName = fileName;
	}

	public String getEExt() {
		return eExt;
	}

	public void setEExt(String ext) {
		eExt = ext;
	}

	public String getSaveFilePath() {
		return saveFilePath;
	}

	public void setSaveFilePath(String saveFilePath) {
		this.saveFilePath = saveFilePath;
	}

	public String getEPathName() {
		return ePathName;
	}

	public void setEPathName(String pathName) {
		ePathName = pathName;
	}

	public String getSaveFileName() {
		return saveFileName;
	}

	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}

	public String getFtpFileName() {
		return ftpFileName;
	}

	public void setFtpFileName(String ftpFileName) {
		this.ftpFileName = ftpFileName;
	}

	public String getOrignalName() {
		return orignalName;
	}

	public void setOrignalName(String orignalName) {
		this.orignalName = orignalName;
	}

	public String getDID() {
		return DID;
	}

	public void setDID(String did) {
		DID = did;
	}

	public String getEPageType() {
		return ePageType;
	}

	public void setEPageType(String pageType) {
		ePageType = pageType;
	}
}
