package com.lhq.prj.bms.core;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;


public class CodeAssignClient {
	
	private String end = "\r\n";
	private String twoHyphens = "--";
	private String boundary = "*****";

	private void initHttpsConnection() {
		SSLContext sc = null;
		TrustManager[] trustAllCerts = new TrustManager[] { new javax.net.ssl.X509TrustManager() {
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			public void checkClientTrusted(
					java.security.cert.X509Certificate[] certs, String authType) {
			}

			public void checkServerTrusted(
					java.security.cert.X509Certificate[] certs, String authType) {
			}
		} };

		try {
			sc = SSLContext.getInstance("TLS");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection
					.setDefaultSSLSocketFactory(sc.getSocketFactory());
		} catch (Exception e) {
		}

		HostnameVerifier hv = new HostnameVerifier() {
			public boolean verify(String urlHostName, SSLSession session) {
				return urlHostName.equals(session.getPeerHost());
			}
		};
		HttpsURLConnection.setDefaultHostnameVerifier(hv);
		
	}
	
	private HttpsURLConnection createConnection(String url) throws IOException {
		this.initHttpsConnection();
		URL urlObj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) urlObj.openConnection();
//		con.setDoInput(true); //默认值为 true
		con.setDoOutput(true); //默认值为 false
		con.setUseCaches(false);
		con.setRequestMethod("POST");
//		con.setRequestProperty("Connection", "Keep-Alive");
		con.setRequestProperty("Charset", "UTF-8");
		con.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
		return con;
	}
	
	//name=对应input的name值，value对应input的value值
	private void writeText(DataOutputStream dos, String name, String value) throws IOException {
		value = null == value ? "" : value;
		StringBuffer buf = new StringBuffer();		
		buf.append(twoHyphens).append(boundary).append(end);
		buf.append("Content-Disposition: form-data; name=\"").append(name).append("\"").append(end);		
		buf.append(end);
		dos.writeBytes(buf.toString());
		dos.write(value.getBytes("UTF-8"));
		dos.writeBytes(end);
	}
	
	//name=对应input的name值，filePath对应要上传的文件名（包括路径在内）
	private void writeFile(DataOutputStream dos, String name, String filePath) throws IOException {
		File file = new File(filePath);
		if (!file.exists() || !file.isFile()) {
			return;
		}
		StringBuffer buf = new StringBuffer();
		//写入文件名到http head
		buf.append(twoHyphens).append(boundary).append(end);
		buf.append("Content-Disposition: form-data; name=\"").append(name).append("\"; filename=\"").append(filePath).append("\"").append(end);;		
		buf.append(end);
		dos.writeBytes(buf.toString());
		//写入文件内容到 http body
		FileInputStream fis = new FileInputStream(filePath); 
        int bufferSize = 1024;  
        byte[] buffer = new byte[bufferSize];  
        int length = -1;  
        while ((length = fis.read(buffer)) != -1) {  
        	dos.write(buffer, 0, length);  
        }
        dos.writeBytes(end);
	}

	/**
	 * 包含附件的赋码访问
	 * @param url
	 * @param keyValues
	 * @param uploadFiles
	 * @return
	 * @throws IOException
	 */
	public String complexApply(String url, String[][] keyValues, String[][] uploadFiles) throws IOException {
		//创建连接
		HttpsURLConnection con = this.createConnection(url);
		DataOutputStream dos = new DataOutputStream(con.getOutputStream());

		//向流中写入文本参数部分
		for (int i = 0; i < keyValues.length; i++) {
			this.writeText(dos, keyValues[i][0], keyValues[i][1]);
		}
		//向流中写入文件部分
		for (int i = 0; i < uploadFiles.length; i++) {
			this.writeFile(dos, uploadFiles[i][0], uploadFiles[i][1]);
		}
		//写入结束行
		dos.writeBytes(twoHyphens + boundary + twoHyphens + end);
		dos.flush();

		// 定义BufferedReader输入流来读取URL的响应
		BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream(),"utf-8"));
		StringBuffer buf = new StringBuffer();
		String temp = "";
		while ((temp = reader.readLine()) != null) {
			buf.append(temp);
		}
		return buf.toString();
	}
	
	/**
	 * 简单赋码访问
	 * @param url
	 * @param userName
	 * @param password
	 * @param orgName
	 * @param regNum
	 * @param orgAddress
	 * @param codeType
	 * @param flag 0:成功，1：疑似赋码，2：重复赋码，3：失败
	 * @return
	 * @throws IOException 
	 */
	public String onlyTextApply(String url, String userName, String password, 
			String orgName, String regNum, String orgAddress, String codeType, String flag) throws IOException {
		//创建连接
		this.initHttpsConnection();
		URL urlObj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) urlObj.openConnection();
//		con.setDoInput(true); //默认值为 true
		con.setDoOutput(true); //默认值为 false
		con.setUseCaches(false);
		con.setRequestMethod("POST");
//		con.setRequestProperty("Connection", "Keep-Alive");
		con.setRequestProperty("Charset", "UTF-8");
//		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		DataOutputStream dos = new DataOutputStream(con.getOutputStream());

		StringBuffer buf = new StringBuffer();
		buf.append(Constants.LoginUserName).append("=").append(URLEncoder.encode(userName, "UTF-8")).append("&") //必须url encode 否则乱码
		.append(Constants.LoginPassword).append("=").append(password).append("&");
		
		buf.append(Constants.OrganizationName).append("=").append(URLEncoder.encode(orgName, "UTF-8")).append("&")
		.append(Constants.RegisterNumber).append("=").append(URLEncoder.encode(regNum, "UTF-8")).append("&")
		.append(Constants.OrganizationAddress).append("=").append(URLEncoder.encode(orgAddress, "UTF-8")).append("&")
		.append(Constants.CodeType).append("=").append(codeType).append("&")
		.append(Constants.IsRepeatedFlag).append("=").append(flag);
		
		dos.writeBytes(buf.toString());
		dos.flush();
		
		// 定义BufferedReader输入流来读取URL的响应
		BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream(),"utf-8"));
		buf.delete(0, buf.length());
		String temp = "";
		while ((temp = reader.readLine()) != null) {
			buf.append(temp);
		}
		return buf.toString();
	}
    
	/**
	 * 赋码确认
	 * @param url
	 * @param userName
	 * @param password
	 * @param code
	 * @return
	 * @throws IOException
	 */
	public String confirm(String url, String userName, String password, String code) throws IOException {
		//创建连接
		this.initHttpsConnection();
		URL urlObj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) urlObj.openConnection();
//		con.setDoInput(true); //默认值为 true
		con.setDoOutput(true); //默认值为 false
		con.setUseCaches(false);
		con.setRequestMethod("POST");
//		con.setRequestProperty("Connection", "Keep-Alive");
		con.setRequestProperty("Charset", "UTF-8");
//		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		DataOutputStream dos = new DataOutputStream(con.getOutputStream());

		StringBuffer buf = new StringBuffer();
		buf.append(Constants.LoginUserName).append("=").append(URLEncoder.encode(userName, "UTF-8")).append("&") //必须url encode 否则乱码
		.append(Constants.LoginPassword).append("=").append(password).append("&")
		.append(Constants.ConfirmCode).append("=").append(code);
		dos.writeBytes(buf.toString());
		dos.flush();
		
		// 定义BufferedReader输入流来读取URL的响应
		BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream(),"utf-8"));
		buf.delete(0, buf.length());
		String temp = "";
		while ((temp = reader.readLine()) != null) {
			buf.append(temp);
		}
		return buf.toString();
	}
	
}
