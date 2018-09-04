package com.ninemax.jpa.system.action;

import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.ninemax.jdbc.business.system.clsRightKeyBus;
import com.ninemax.jpa.global.BaseAction;
import com.ninemax.jpa.system.bo.RightkeyBo;
import com.ninemax.jpa.system.model.Rightkey;
import org.apache.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class RightKeyAction extends BaseAction{
	private static Logger log = Logger.getLogger(RightKeyAction.class);
	private RightkeyBo rightkeyBo = new RightkeyBo();
	private static final String CONTENT_TYPE = "text/html; charset=GBK";
	
	private ServletConfig config;

	public void init(ServletConfig config) throws ServletException {

		this.config = config;
	}

	public final ServletConfig getServletConfig() {
		return config;

	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("GBK");
		response.setContentType("text/html; charset=GBK");
		

		
		
		response.setContentType(CONTENT_TYPE);
		String realPath = request.getRealPath("/");
		String uploadPath = realPath + "/product/jsp/images/menu/"; // 用于存放上传文件的目录
		String tempPath = realPath + "/product/jsp/images/tmp/"; // 用于存放临时文件的目录
		String ContentType = request.getContentType();
		
		try {
			if (ContentType!=null && ContentType.indexOf("multipart/form-data") > -1) {
				
				// 初始化
				SmartUpload mySmartUpload = new SmartUpload();
				mySmartUpload.init(config);
				mySmartUpload.service(request, response);
				mySmartUpload.setMaxFileSize(1024 * 1024 * 50);
				// mySmartUpload.setAllowedFilesList("gif,GIF,jpg,JPG,jpeg,JPEG,swf,SWF");
				try {
					mySmartUpload.upload();
				} catch (SmartUploadException e1) {
				  	log.error("error", e1);
					e1.printStackTrace();
				}
				String pageName = request.getRequestURI();
				String strUploadPathURL, strUrl;
				String strFileName = "";
				Request smRequest = mySmartUpload.getRequest();
				String method = smRequest.getParameter("method");
				String currentPage = smRequest.getParameter("currentPage");
				
				if (!new File(uploadPath).isDirectory())
					new File(uploadPath).mkdirs();
				if (!new File(tempPath).isDirectory())
					new File(tempPath).mkdirs();
				

		if (method == null) {
			return;
		} else if (method.equals("add")) {
		//	add(request, response);
			Rightkey rightkey = new Rightkey() ;
			
		//	this.bindingForm2Bean(rightkey,request.getParameterMap());
			String rightkeyId = smRequest.getParameter("rightkeyId");
			String rightkeyName = smRequest.getParameter("rightkeyName");
			String rightkeyDepth = smRequest.getParameter("rightkeyDepth");
			String rightkeyFunc = smRequest.getParameter("rightkeyFunc");
			String rightkeyKind = smRequest.getParameter("rightkeyKind");
			String rightkeyFullname = smRequest.getParameter("rightkeyFullname");
			String parentid = smRequest.getParameter("parentid");
			String linkpage = smRequest.getParameter("linkpage");
			String orderby = smRequest.getParameter("orderby");
			String type = smRequest.getParameter("type");
			
			
			

				
				
				String message = "";

				
				String prictrueName = "";

				com.jspsmart.upload.File myFile = mySmartUpload.getFiles()
						.getFile(0);
				if (!myFile.isMissing()) {

					long Size = myFile.getSize(); 
					// 生成不重复的图片名称
					Date dt = new Date();
					strFileName = dt.getTime()
							+ "_"
							+ (new Double(Math.random() * 10000))
									.intValue() + "."
							+ myFile.getFileExt().toLowerCase();
					myFile.saveAs(uploadPath + strFileName,
							mySmartUpload.SAVE_PHYSICAL);
					prictrueName = strFileName;
				}
				
				rightkey.setPictrue(prictrueName);
				
				rightkey.setLinkpage(linkpage);
				rightkey.setOrderby(orderby);
				rightkey.setParentid(parentid);
				rightkey.setRightkeyDepth(rightkeyDepth);
				rightkey.setRightkeyFullname(rightkeyFullname);
				rightkey.setRightkeyFunc(rightkeyFunc);
				rightkey.setRightkeyId(rightkeyId);
				rightkey.setRightkeyKind(rightkeyKind);
				rightkey.setRightkeyName(rightkeyName);
				rightkey.setType(type);
				
				rightkeyBo.save(rightkey);
				
			this.sendRedirect(response, currentPage);
				return;
			
		} else if (method.equals("modify")) {
			Rightkey rightkey = new Rightkey() ;
			
			//	this.bindingForm2Bean(rightkey,request.getParameterMap());
				String id = smRequest.getParameter("id");
				String rightkeyId = smRequest.getParameter("rightkeyId");
				String rightkeyName = smRequest.getParameter("rightkeyName");
				String rightkeyDepth = smRequest.getParameter("rightkeyDepth");
				String rightkeyFunc = smRequest.getParameter("rightkeyFunc");
				String rightkeyKind = smRequest.getParameter("rightkeyKind");
				String rightkeyFullname = smRequest.getParameter("rightkeyFullname");
				String parentid = smRequest.getParameter("parentid");
				String linkpage = smRequest.getParameter("linkpage");
				String orderby = smRequest.getParameter("orderby");
				String type = smRequest.getParameter("type");
				String prictrueName = smRequest.getParameter("prictrue");
				
				com.jspsmart.upload.File myFile = mySmartUpload.getFiles()
				.getFile(0);
		if (!myFile.isMissing()) {
			
			long Size = myFile.getSize(); 
			// 生成不重复的图片名称
			Date dt = new Date();
			strFileName = dt.getTime()
					+ "_"
					+ (new Double(Math.random() * 10000))
							.intValue() + "."
					+ myFile.getFileExt().toLowerCase();
			try {
				myFile.saveAs(uploadPath + strFileName,
						mySmartUpload.SAVE_PHYSICAL);
			} catch (SmartUploadException e) {
			  	log.error("error", e);
				e.printStackTrace();
			}
			File oldFile = new File(uploadPath+prictrueName);
			
			if(oldFile.exists())oldFile.delete();
			prictrueName = strFileName;

		}
		
		
		rightkey.setPictrue(prictrueName);
		
		rightkey.setId(Integer.valueOf(id));
		rightkey.setLinkpage(linkpage);
		rightkey.setOrderby(orderby);
		rightkey.setParentid(parentid);
		rightkey.setRightkeyDepth(rightkeyDepth);
		rightkey.setRightkeyFullname(rightkeyFullname);
		rightkey.setRightkeyFunc(rightkeyFunc);
		rightkey.setRightkeyId(rightkeyId);
		rightkey.setRightkeyKind(rightkeyKind);
		rightkey.setRightkeyName(rightkeyName);
		rightkey.setType(type);
		
		rightkeyBo.update(rightkey);

		this.sendRedirect(response, currentPage);
			return;
		
		}
		}else{
			String method = request.getParameter("method");
			String currentPage = request.getParameter("currentPage");
			clsRightKeyBus rightKeyBus = new clsRightKeyBus();
			if("delete".equals(method)){
				String id = request.getParameter("rightkeyId");
				int result = rightKeyBus.DeteleRightKey(id);
				
				this.sendRedirect(response, currentPage);
				return;
			}
			
		}
				
		} catch (Exception e) {
		  	log.error("error", e);
			e.printStackTrace();
		}
	}
	
	
}
