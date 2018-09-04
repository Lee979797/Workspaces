package com.ninemax.producttest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.codehaus.xfire.client.Client;

import com.ninemax.jpa.code.bus.AuditingBus;
import com.ninemax.jpa.code.bus.WsbzXbBus;
import com.ninemax.jpa.code.model.Page;
import com.ninemax.jpa.util.ActionUtils;
import com.opensymphony.xwork2.ActionSupport;

public class ProductServiceClientAction extends ActionSupport implements
		SessionAware {
	private static final String path = "/productTest/";
	private String currentPath = "";
	private String returnXml = "";
	private String jgdmString = "";

	public String getCurrentPath() {
		return currentPath;
	}

	public void setCurrentPath(String currentPath) {
		this.currentPath = currentPath;
	}

	public static String getPath() {
		return path;
	}

	public String getReturnXml() {
		return returnXml;
	}

	public void setReturnXml(String returnXml) {
		this.returnXml = returnXml;
	}

	
	public String getJgdmString() {
		return jgdmString;
	}

	public void setJgdmString(String jgdmString) {
		this.jgdmString = jgdmString;
	}

	public String productService() {
		return new ActionUtils() {
			@Override
			protected void excute() throws Exception {
				String soapUrl = "http://192.168.12.102:7777/services/JgdmExsistService?wsdl";

				try {
					Client client = new Client(new URL(soapUrl));
					client.addOutHandler(new ClientAuthenticationHandler(
							"admin", "123456"));

//					Object[] results = client.invoke("exsistEnterprise",
//							new Object[] { "684651903" });
					System.out.println("jgdmString = "+jgdmString);
					Object[] results = client.invoke("exsistEnterprise",
							new Object[] { jgdmString });
					returnXml = results[0].toString();

					System.out.println(returnXml);
//					HttpServletRequest request = ServletActionContext.getRequest();
//					request.setAttribute("jgdmString", jgdmString);

				} catch (MalformedURLException e) {

					e.printStackTrace();
				} catch (Exception e) {

					e.printStackTrace();

				}
				currentPath = path + "webserviceQueryResult.jsp";
			}
		}.template();
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub

	}

}
