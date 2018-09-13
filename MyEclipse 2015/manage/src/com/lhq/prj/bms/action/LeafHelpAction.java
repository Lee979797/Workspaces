package com.lhq.prj.bms.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;

import com.lhq.prj.bms.core.BaseAction;
import com.lhq.prj.bms.po.LeafHelp;
import com.lhq.prj.bms.service.ILeafHelpService;

public class LeafHelpAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//节点帮助参数
	private ILeafHelpService leafHelpService;
	private String leafId;
	private String keyWs;
	private String title;
	private String content;
	private boolean success;
	
	//图片上传参数
	private static final int BUFFER_SIZE = 16*1024;
	private String fileURL;
	private File imgfile;
	private String imgfileFileName;

	public String uploadImg() throws Exception{
		String exp = imgfileFileName.substring(imgfileFileName.lastIndexOf("."));
		
		imgfileFileName = UUID.randomUUID().toString();
		fileURL = ServletActionContext.getServletContext().getRealPath("upload")+"\\"+imgfileFileName+exp;
		
		File newFile = new File(fileURL);
		copy(imgfile,newFile);
		//getResponse().setContentType("text/json;charset=utf-8");
		String str = "{success:true,fileURL:'upload/"+imgfileFileName+exp+"'}";
		getResponse().getWriter().write(str);
		return NONE;
	}
	private static void copy(File src,File dst){
		try{
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);
			out = new BufferedOutputStream(new FileOutputStream(dst), BUFFER_SIZE);
			byte[] buffer = new byte[BUFFER_SIZE];
			while(in.read(buffer)>0){
				out.write(buffer);
			}
		} finally {
			if(null != in){
				in.close();
			}
			if(null != out){
				out.close();
			}
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public String saveLeafHelp(){
		LeafHelp lh = new LeafHelp();
		lh.setTitle(title);
		lh.setLeafId(leafId);
		lh.setKeyWs(keyWs);
		lh.setContent(content);
		
		success = leafHelpService.saveLeafHelp(lh);
		
		return SUCCESS;
	}
	
	
	
	

	public String getFileURL() {
		return fileURL;
	}

	public void setFileURL(String fileURL) {
		this.fileURL = fileURL;
	}
	
	public File getImgfile() {
		return imgfile;
	}

	public void setImgfile(File imgfile) {
		this.imgfile = imgfile;
	}
	public String getImgfileFileName() {
		return imgfileFileName;
	}
	public void setImgfileFileName(String imgfileFileName) {
		this.imgfileFileName = imgfileFileName;
	}
	public String getLeafId() {
		return leafId;
	}
	public void setLeafId(String leafId) {
		this.leafId = leafId;
	}
	public String getKeyWs() {
		return keyWs;
	}
	public void setKeyWs(String keyWs) {
		this.keyWs = keyWs;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public void setLeafHelpService(ILeafHelpService leafHelpService) {
		this.leafHelpService = leafHelpService;
	}

}
