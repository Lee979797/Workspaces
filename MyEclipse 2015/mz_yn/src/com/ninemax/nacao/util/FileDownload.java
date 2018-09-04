package com.ninemax.nacao.util;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

/**
 * <p>Title: </p>
 *
 * <p>Description:文件下载操作 </p>
 *
 * <p>Copyright: Copyright (c) 2006-6-2</p>
 *
 * <p>Company: 九瑞</p>
 *
 * @author 张宏彬
 * @version 3.0
 */
final public class FileDownload {

	private final static String ZIP = "application/x-zip-compressed";
	private final static String PDF = "application/pdf";
	private final static String HTML = "text/html";
	private final static String CAJ = "application/caj";

	/**
	 * zip文件下载
	 * @param filePath String
	 * @param fileName String
	 * @param response HttpServletResponse
	 * @return boolean
	 */
	public static boolean ZIPDownload(String filePath, PageContext pageContext)
			throws Exception {
		return FileDownload(filePath, ZIP, pageContext);
	}

	/**
	 * pdf 文件下载
	 * @param filePath String
	 * @param fileName String
	 * @param response HttpServletResponse
	 * @return boolean
	 */
	public static boolean PDFDownload(String filePath, PageContext pageContext)
			throws Exception {
		return FileDownload(filePath, PDF, pageContext);
	}

	/**
	 * html 文件下载
	 * @param filePath String
	 * @param fileName String
	 * @param response HttpServletResponse
	 * @return boolean
	 */
	public static boolean HTMLDownload(String filePath, PageContext pageContext)
			throws Exception {
		return FileDownload(filePath, HTML, pageContext);
	}

	/**
	 * caj文件下载
	 * @param filePath String
	 * @param fileName String
	 * @param response HttpServletResponse
	 * @return boolean
	 */
	public static boolean CAJDownload(String filePath, PageContext pageContext)
			throws Exception {
		return FileDownload(filePath, CAJ, pageContext);
	}

	/**
	 * 各种文件下载
	 * @param fileName String
	 * @param contentType String
	 * @param response HttpServletResponse
	 * @return boolean
	 */
	public static boolean FileDownload(String filePath, String contentType,
			PageContext pageContext) throws Exception {
		if (filePath == null || filePath.equals("")) {
			throw new IllegalArgumentException("File '" + filePath
					+ "' not found.");
		}
		if (pageContext == null) {
			throw new Exception("pageContext is null");
		}
		//ServletContext servletContext = pageContext.getServletContext();
		File fileInfo = new File(filePath);
		if (!fileInfo.exists()) {
			throw new SecurityException("Physical path is denied.");
		}
		HttpServletResponse response = (HttpServletResponse) pageContext
				.getResponse();
		contentType = contentType == null || contentType.equals("") ? "application/x-msdownload"
				: contentType;
		response.setContentType(contentType);
		response.setContentLength((int) fileInfo.length());
		String fileName = fileInfo.getName();
		response.setHeader("Content-Disposition", "attachment;filename="
				+ fileName);
		FileInputStream inputStream = null;
		OutputStream output = null;
		BufferedInputStream bInputStream = null;
		try {
			inputStream = new FileInputStream(filePath);
			bInputStream = new BufferedInputStream(inputStream, 1024);
			byte[] b = new byte[1024];
			int n = 0;
			output = response.getOutputStream();
			while ((n = bInputStream.read(b)) != -1) {
				output.write(b, 0, n);
			}
			output.flush();
			output.close();
			inputStream.close();
			bInputStream.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage() + "------downLoad");
			return false;
		}
		return true;
	}
}
