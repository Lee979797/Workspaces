package com.lhq.prj.bms.service.impl;

import java.lang.reflect.Proxy;
import java.net.MalformedURLException;
import java.util.Map;
import java.util.Properties;

import com.lhq.prj.bms.service.AllocateCodeService;
import com.lhq.prj.bms.core.PasswordHandler;
import com.opensymphony.xwork2.ActionContext;

import org.apache.ws.security.handler.WSHandlerConstants;
import org.codehaus.xfire.client.Client;
import org.codehaus.xfire.client.XFireProxy;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.security.wss4j.WSS4JInHandler;
import org.codehaus.xfire.security.wss4j.WSS4JOutHandler;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;
import org.codehaus.xfire.util.dom.DOMInHandler;
import org.codehaus.xfire.util.dom.DOMOutHandler;


public class AutoAllocateCodeClientEncrypt {

	private static String url = "";
	private Map appSysConfig;
	private XFireProxyFactory serviceFactory = new XFireProxyFactory();
	
	protected void configEncryptProperties(Properties properties) {
		properties.put(WSHandlerConstants.ACTION, WSHandlerConstants.ENCRYPT);
		properties.put(WSHandlerConstants.ENCRYPTION_USER, "server");
		properties.put(WSHandlerConstants.ENC_PROP_FILE,
				"META-INF/xfire/outsecurity_sign.properties");
		properties.put(WSHandlerConstants.PW_CALLBACK_CLASS,
				PasswordHandler.class.getName());
	}

	protected void configDecryptProperties(Properties properties) {
		properties.put(WSHandlerConstants.ACTION, WSHandlerConstants.ENCRYPT);
		properties.put(WSHandlerConstants.USER, "client");
		properties.put(WSHandlerConstants.DEC_PROP_FILE,
				"META-INF/xfire/outsecurity_sign.properties");
		properties.put(WSHandlerConstants.PW_CALLBACK_CLASS,
				PasswordHandler.class.getName());
		properties.put(WSHandlerConstants.ENABLE_SIGNATURE_CONFIRMATION,
				"false");
	}

	/**
	 * @param args
	 */

	public String applyCode(String center_id, String dmlx, String jgmc,
			String zch, String flag) {
		AllocateCodeService service = getAllocateCodeService("AllocateCodeService");
		String result = "发生异常，申请失败";
		try {
			result = service.applyCode(center_id, dmlx, jgmc, zch, flag);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public String successConfirm(String center_id, String jgmc, String zch,
			String jgdm) {
		AllocateCodeService service = getAllocateCodeService("AllocateCodeService");
		String result = "";
		try {
			result = service.successConfirm(center_id, jgmc, zch, jgdm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	private AllocateCodeService getAllocateCodeService(String serviceName) {

		Service serviceModel = new ObjectServiceFactory()
				.create(AllocateCodeService.class);

		AllocateCodeService service = null;
		try {
			appSysConfig = ActionContext.getContext().getApplication();
			if(appSysConfig.get("sysAutoCodeServerUrl")!=null && !"".equals(appSysConfig.get("sysAutoCodeServerUrl"))){
				url = "http://" + appSysConfig.get("sysAutoCodeServerUrl") + "/AutoAllocateCode/services/";
			}else{
				url = "http://190.15.15.129:7001/AutoAllocateCode/services/";
			}
			System.out.print(url);
			service = (AllocateCodeService) serviceFactory.create(serviceModel,
					url + serviceName);
			// 获取访问服务的客户端对象
			Client client = ((XFireProxy) Proxy.getInvocationHandler(service))
					.getClient();

			// 负责加密
			client.addOutHandler(new DOMOutHandler());
			Properties properties = new Properties();
			configEncryptProperties(properties);
			client.addOutHandler(new WSS4JOutHandler(properties));

			// 负责解密
			client.addInHandler(new DOMInHandler());
			Properties properties2 = new Properties();
			configDecryptProperties(properties2);
			client.addInHandler(new WSS4JInHandler(properties2));

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return service;
	}
}
