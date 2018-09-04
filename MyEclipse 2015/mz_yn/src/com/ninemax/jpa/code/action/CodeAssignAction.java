package com.ninemax.jpa.code.action;

import com.ninemax.jpa.code.model.TJgdm;
import com.ninemax.jpa.util.Constants;
import com.ninemax.jpa.util.PropertiesUtils;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import javax.net.ssl.*;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by ninemax-199 on 14-3-12.
 */
public class CodeAssignAction extends ActionSupport {
    private static Logger log = Logger.getLogger(IssueCertificateAction.class);

    public CodeAssignAction() {
        SSLContext sc = null;
        TrustManager[] trustAllCerts = new TrustManager[]{
                new javax.net.ssl.X509TrustManager() {
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

    private TJgdm jgdm;
    private String flag;

    public String assign() {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-language", "UTF-8");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            PropertiesUtils.loadFile("unifyorgcode.properties");
            URL urlObj = new URL((String) PropertiesUtils.getValue("url"));
            HttpsURLConnection con = (HttpsURLConnection) urlObj.openConnection();
            con.setDoOutput(true); //默认值为 false
            con.setUseCaches(false);
            con.setRequestMethod("POST");
            con.setRequestProperty("Charset", "UTF-8");
            OutputStream os = con.getOutputStream();
            StringBuffer buf = new StringBuffer();
            buf.append(Constants.LoginUserName).append("=").append((String) PropertiesUtils.getValue("userName")).append("&")
                    .append(Constants.LoginPassword).append("=").append((String) PropertiesUtils.getValue("password")).append("&").
                    append(Constants.OrganizationName).append("=").append(URLEncoder.encode(jgdm.getJgmc(), "UTF-8")).append("&")
                    .append(Constants.RegisterNumber).append("=").append(URLEncoder.encode(jgdm.getZch(), "UTF-8")).append("&")
                    .append(Constants.OrganizationAddress).append("=").append(URLEncoder.encode(jgdm.getJgdz(), "UTF-8")).append("&")
                    .append(Constants.CodeType).append("=").append("B".equals(jgdm.getJglx()) ? "0" : "3").append("&")
                    .append(Constants.IsRepeatedFlag).append("=").append(flag);
            byte[] bytes = buf.toString().getBytes();
            os.write(bytes, 0, bytes.length);
            os.flush();
            os.close();
            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
            buf.delete(0, buf.length());
            String temp = "";
            while ((temp = reader.readLine()) != null) {
                writer.print(temp);
            }
        } catch (IOException e) {
            log.error(CodeAssignAction.class, e);
            if (writer != null) {
                writer.print("{flag:'3',info:'网络出现异常,请重试！'}");
            }
        } finally {
            if (writer != null) {
                writer.flush();
                writer.close();
            }
        }
        return null;
    }

    public TJgdm getJgdm() {
        return jgdm;
    }

    public void setJgdm(TJgdm jgdm) {
        this.jgdm = jgdm;
    }
}
