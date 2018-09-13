package com.lhq.prj.bms.core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhq.prj.bms.core.Constants;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class CodeAssignAction extends HttpServlet implements javax.servlet.Servlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7093794606949924842L;

	private static final String URL_Prefix = "https://190.15.15.129:7001/unifyorgcode/services/code-assign/"; 
	
	private static final String ONLY_TEXT_URL = URL_Prefix + "only-text";
	
	private static final String ADD_XML_URL = URL_Prefix + "add-xml";
	
	private static final String ADD_XML_TIFF_URL = URL_Prefix + "add-xml-tiff";
	
	private static final String CONFIRM_CODE_URL = URL_Prefix + "confirm";
	
	private String rootPath = "";
	
	private String tempFileSaveDir = "/upload";

	private String jumpTo = "./visitor-inner.jsp";
	
	private ServletConfig config;

	/**
	 * Constructor of the object.
	 */
	public CodeAssignAction() {
		super();
	}
	
	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.config = config;
		String path = config.getInitParameter("temp-file-save-dir");
		if (null != path && !path.equals("")) {
			tempFileSaveDir = path;
		}
		rootPath = config.getServletContext().getRealPath("/");
		if (rootPath.endsWith(java.io.File.separator)) {
			rootPath = rootPath.substring(0, rootPath.length() - 1);
		}
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String type = request.getParameter("stype");
		
		if (type.equals("only-text")) {
			this.doOnlyTextApply(request, response);
		} else if (type.equals("add-xml")) {
			this.doAddXmlApply(request, response);
		} else if (type.equals("add-xml-tiff")) {
			this.doAddXmlTiffApply(request, response);
		} else if (type.equals("confirm")) {
			this.doConfirmCodeAssign(request, response);
		} else {
			this.sendJsonStr(response, "hello");
		}
	}

	private void doOnlyTextApply(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//从请求中获取参数
		String orgName = request.getParameter(Constants.OrganizationName);
		String regNum = request.getParameter(Constants.RegisterNumber);
		String orgAddress = request.getParameter(Constants.OrganizationAddress);
		String codeType = request.getParameter(Constants.CodeType);
		String isRepeated = request.getParameter(Constants.IsRepeatedFlag);
		
		String userName = request.getParameter(Constants.LoginUserName);
		String password = request.getParameter(Constants.LoginPassword);
		
		//访问接口请求赋码，并得到JSON格式的字符串结果
		String rs = "";
		try {
			rs = new CodeAssignClient().onlyTextApply(ONLY_TEXT_URL, userName, password, orgName,
				regNum, orgAddress, codeType, isRepeated);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//将结果以字符串格式返回给client（AJAX访问）
		this.sendJsonStr(response, rs);
	}

	private void doAddXmlApply(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			SmartUpload mySmartUpload = new SmartUpload();
			//在weblogic和websphere下中文乱码的处理
			mySmartUpload.setCharset("UTF-8");
			
			mySmartUpload.initialize(config, request, response);// Initialization
			mySmartUpload.upload();// Upload
			//从请求中获取参数
			Request req = mySmartUpload.getRequest();
			String orgName = req.getParameter(Constants.OrganizationName);
			String regNum = req.getParameter(Constants.RegisterNumber);
			String orgAddress = req.getParameter(Constants.OrganizationAddress);
			String codeType = req.getParameter(Constants.CodeType);
			String isRepeated = req.getParameter(Constants.IsRepeatedFlag);
			
			String userName = req.getParameter(Constants.LoginUserName);
			String password = req.getParameter(Constants.LoginPassword);
			
			//读取上传文件并缓存在
			String xmlFilePath = "";
			File myFile = null;		
			myFile = mySmartUpload.getFiles().getFile(0); 
			if (!myFile.isMissing()) {
				String fileName = myFile.getFileName();
				xmlFilePath = tempFileSaveDir + fileName;
				myFile.saveAs(xmlFilePath);
			}
			
			//组装参数，访问接口请求赋码，并得到JSON格式的字符串结果
			String[][] keyValues = new String[7][];
			keyValues[0] = new String[] { Constants.LoginUserName, userName };
			keyValues[1] = new String[] { Constants.LoginPassword, password };
			keyValues[2] = new String[] { Constants.OrganizationName, orgName };
			keyValues[3] = new String[] { Constants.RegisterNumber, regNum };
			keyValues[4] = new String[] { Constants.OrganizationAddress, orgAddress };
			keyValues[5] = new String[] { Constants.CodeType, codeType };
			keyValues[6] = new String[] { Constants.IsRepeatedFlag, isRepeated };

			String[][] uploadFiles = new String[1][];
			uploadFiles[0] = new String[] { Constants.XmlFile, rootPath + xmlFilePath };
			String rs = new CodeAssignClient().complexApply(ADD_XML_URL, keyValues, uploadFiles);

			//得到结果后将缓存的文件删除
			java.io.File file = new java.io.File(xmlFilePath);
			if (file.exists()) {
				file.delete();
			}
			
			//将结果写入request，然后转发给结果页面
			request.setAttribute("result", rs);
			request.setAttribute("stype", "add-xml");
			request.getRequestDispatcher(jumpTo).forward(request, response);
		} catch (SmartUploadException e){
			e.printStackTrace();
		}

	}

	public void doAddXmlTiffApply(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			SmartUpload mySmartUpload = new SmartUpload();
			//在weblogic和websphere下中文乱码的处理
			mySmartUpload.setCharset("UTF-8");
			
			mySmartUpload.initialize(config, request, response);// Initialization
			mySmartUpload.upload();// Upload
			//从请求中获取参数
			Request req = mySmartUpload.getRequest();
			String orgName = req.getParameter(Constants.OrganizationName);
			String regNum = req.getParameter(Constants.RegisterNumber);
			String orgAddress = req.getParameter(Constants.OrganizationAddress);
			String codeType = req.getParameter(Constants.CodeType);
			String isRepeated = req.getParameter(Constants.IsRepeatedFlag);

			String userName = req.getParameter(Constants.LoginUserName);
			String password = req.getParameter(Constants.LoginPassword);
			
			//读取上传文件并缓存在
			String xmlFilePath = "";
			String tiffFilePath = "";
			File myFile = null;	
			Files files = mySmartUpload.getFiles();
			//读取xml文件
			myFile = files.getFile(0); 
			if (!myFile.isMissing()) {
				String fileName = myFile.getFileName();
				xmlFilePath = tempFileSaveDir + fileName;
				myFile.saveAs(xmlFilePath);
			}
			//读取tif文件
			myFile = files.getFile(1); 
			if (!myFile.isMissing()) {
				String fileName = myFile.getFileName();
				tiffFilePath = tempFileSaveDir + fileName;
				myFile.saveAs(tiffFilePath);
			}
			
			//组装参数，访问接口请求赋码，并得到JSON格式的字符串结果
			String[][] keyValues = new String[7][];
			keyValues[0] = new String[] { Constants.LoginUserName, userName };
			keyValues[1] = new String[] { Constants.LoginPassword, password };
			keyValues[2] = new String[] { Constants.OrganizationName, orgName };
			keyValues[3] = new String[] { Constants.RegisterNumber, regNum };
			keyValues[4] = new String[] { Constants.OrganizationAddress, orgAddress };
			keyValues[5] = new String[] { Constants.CodeType, codeType };
			keyValues[6] = new String[] { Constants.IsRepeatedFlag, isRepeated };

			String[][] uploadFiles = new String[2][];
			uploadFiles[0] = new String[] { Constants.XmlFile, rootPath + xmlFilePath };
			uploadFiles[1] = new String[] { Constants.TiffFile, rootPath + tiffFilePath };
			String rs = new CodeAssignClient().complexApply(ADD_XML_TIFF_URL, keyValues, uploadFiles);

			System.out.println(rs);
			
			//得到结果后将缓存的文件删除
			java.io.File file = new java.io.File(xmlFilePath);
			if (file.exists()) {
				file.delete();
			}
			file = new java.io.File(tiffFilePath);
			if (file.exists()) {
				file.delete();
			}
			
			//将结果写入request，然后转发给结果页面
			request.setAttribute("result", rs);
			request.setAttribute("stype", "add-xml-tiff");
			request.getRequestDispatcher(jumpTo).forward(request, response);
		} catch (SmartUploadException e){
			e.printStackTrace();
		}

	}

	private void doConfirmCodeAssign(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//从请求中获取参数
		String code = request.getParameter(Constants.ConfirmCode);

		String userName = request.getParameter(Constants.LoginUserName);
		String password = request.getParameter(Constants.LoginPassword);
		
		//访问接口执行赋码确认，并得到JSON格式的字符串结果
		String rs = new CodeAssignClient().confirm(CONFIRM_CODE_URL, userName, password, code);
		//将结果以字符串格式返回给client（AJAX访问）
		this.sendJsonStr(response, rs);
	}
	
	private void sendJsonStr(HttpServletResponse response, String result) throws IOException {
//		response.setContentType("application/x-json");
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-language", "UTF-8");
		PrintWriter out = response.getWriter();
		out.write(result);
		out.flush();
		out.close();
	}

}
