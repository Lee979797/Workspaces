package com.ninemax.jpa.util;


import com.ninemax.jpa.code.action.IssueCertificateAction;

import org.apache.log4j.Logger;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;


public class CodeAssignClient {
    private static Logger log = Logger.getLogger(IssueCertificateAction.class);
    private String end = "\r\n";
    private String twoHyphens = "--";
    private String boundary = "*****";

    private void initHttpsConnection() {
        SSLContext sc;
        TrustManager[] trustAllCerts = new TrustManager[]{new javax.net.ssl.X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            public void checkClientTrusted(
                    java.security.cert.X509Certificate[] certs, String authType) {
            }

            public void checkServerTrusted(
                    java.security.cert.X509Certificate[] certs, String authType) {
            }
        }};

        try {
            sc = SSLContext.getInstance("SSL");
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

    private HttpURLConnection createConnection(String url) throws IOException {
        this.initHttpsConnection();
        URL urlObj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
//		con.setDoInput(true); //默认值为 true
        con.setDoOutput(true); //默认值为 false
        con.setUseCaches(false);
        con.setRequestMethod("POST");
//		con.setRequestProperty("Connection","Keep-Alive");
        con.setRequestProperty("Charset", "UTF-8");

        return con;
    }

    private void writeFile(DataOutputStream dos, String name, String filePath) throws IOException {
        StringBuilder builder = new StringBuilder();
        builder.append(twoHyphens).append(boundary).append(end);
        builder.append("Content-Disposition: form-data; name=\"").append(name).append("\"; filename=\"").append(filePath).append("\"").append(end);
        builder.append(end);
        dos.writeBytes(builder.toString());
        FileInputStream fis = new FileInputStream(filePath);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = fis.read(buffer)) != -1) {
            dos.write(buffer, 0, length);
        }
        dos.writeBytes(end);
    }

    public synchronized String assign(String url, String method, Map<String, String> parameters, String[]... files) {
        this.initHttpsConnection();
        
        System.out.println("url:"+url);
        System.out.println("method:"+method);
        System.out.println("parameters:"+parameters);
        System.out.println("files:"+files);

        
        
        
        HttpURLConnection con = null;
        String res = null;
        File tempFile = new File(UserPropertiesData.getValueByPropertyName("tempPath") + "/log.txt");
        FileWriter writer = null;
        try {
            if (!tempFile.exists()) {
                tempFile.createNewFile();
            }
            writer = new FileWriter(tempFile, true);
        } catch (IOException e) {
            log.error(CodeAssignClient.class, e);
        }
        
        DataOutputStream dos=null;
        try {
            if (writer != null)
                writer.write("请求开始:" + Calendar.getInstance().getTimeInMillis() + "\n");
            con = this.createConnection(url + "/" + method);
            System.out.println("开始拿到接口连接;;;;;");
            dos = new DataOutputStream(con.getOutputStream());
            System.out.println("已经拿到连接");
            parameters.put(Constants.LoginUserName, PropertiesUtils.getValue("userName").toString());
            parameters.put(Constants.LoginPassword, PropertiesUtils.getValue("password").toString());
            dos.writeBytes(make(parameters));
            if (files != null) {
                for (String[] file : files) {
                    if (file == null)
                        continue;
                    this.writeFile(dos, file[0], file[1]);
                }
            } 
            dos.flush();
            res = response(con);
        } catch (IOException e){
            log.error(CodeAssignClient.class, e);
            res = "{flag:'3',info:'网络异常'}";
        }finally{
        	try {
				dos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
        if (writer != null) {
            try {
                writer.write("请求结束:" + Calendar.getInstance().getTimeInMillis() + "\n");
                writer.write("请求结果:" + res + "\n");
                writer.flush();
//                writer.close();
            } catch (IOException e) {
                log.error(CodeAssignClient.class, e);
            }finally{
            	try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
            }

        }
        return res;
    }

    private String make(Map<String, String> parameters) throws IOException {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            builder.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue(), "UTF-8")).append("&");
        }
        return builder.toString();
    }

    private String response(HttpURLConnection con) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
        StringBuilder builder = new StringBuilder();
        String temp;
        while ((temp = reader.readLine()) != null) {
            builder.append(temp);
        }

        return builder.toString();
    }
}
