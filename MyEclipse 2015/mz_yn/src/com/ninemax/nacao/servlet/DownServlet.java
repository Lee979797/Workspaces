package com.ninemax.nacao.servlet;



import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;

public class DownServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DownServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
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
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("GBK");
//		System.out.println("---->"+request.getParameter("path"));
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
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
	String downfilename = request.getParameter("path");	//获取请求的文件地址
	//downfilename= new String(downfilename.getBytes("GBK"),"ISO-8859-1");
	try {	
		String tempName[] = downfilename.replaceAll("\\\\","/").split("/"); 
		String savename = tempName[tempName.length-1];
		savename = new String(savename.getBytes("gbk"),"ISO-8859-1");						
		if ((downfilename != null) && (savename != null)) {	//判断要下载的文件是否为空
			SmartUpload mydown = new SmartUpload();	
			mydown.initialize(getServletConfig(), request, response);	//使用初始化方法
			mydown.setContentDisposition(null);	//弹出”文件下载“对话框
			mydown.downloadFile(downfilename,"text/html",savename);	//调用文件下载方法
		}	
	} catch (Exception e) {			
		RequestDispatcher rd = request.getRequestDispatcher("/upload.jsp");
		rd.forward(request, response);
	}
}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}
}
