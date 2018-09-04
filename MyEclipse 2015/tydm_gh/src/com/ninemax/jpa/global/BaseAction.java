package com.ninemax.jpa.global;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class BaseAction extends HttpServlet{
	
	private static Logger log = Logger.getLogger(BaseAction.class);
	
	/**
	 * 绑定form里面的值到对象，可节省装载属性的时间，但是注意，此方法只装载form中各个字段name[0]的value，可满足一般性需求，如果name长度大于1，则需自己写方法
	 * @param obj
	 * @param map
	 */
	protected void bindingForm2Bean(Object obj,Map map){
		Map processedMap = new HashMap();
		for (Iterator iter = map.entrySet().iterator(); iter.hasNext();) {
			Map.Entry entry = (Map.Entry) iter.next();
			String key = (String)entry.getKey();
			String[] val = (String[])entry.getValue();
			processedMap.put(key, val[0]);
		}
		try {
			BeanUtils.copyProperties(obj, processedMap);
		} catch (IllegalAccessException e) {
			log.error("error", e);
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			log.error("error", e);
			e.printStackTrace();
		}
	}
	
	protected void sendRedirect(HttpServletResponse response, String url){
		try {
			response.sendRedirect(url);
		} catch (IOException e) {
			log.error("error", e);
			e.printStackTrace();
		}
	}

	/**
	 * 直接输出纯字符串.
	 */
	protected void renderText(HttpServletResponse response, String text) {
		render(response, text, "text/plain;charset=UTF-8");
	}
	/**
	 * 直接输出纯HTML.
	 */
	protected void renderHtml(HttpServletResponse response, String text) {
		render(response, text, "text/html;charset=UTF-8");
	}

	/**
	 * 直接输出纯XML.
	 */
	protected void renderXML(HttpServletResponse response, String text) {
		render(response, text, "text/xml;charset=UTF-8");
	}

	/**
	 * 重新加载父窗口，url变化
	 * @param url
	 * @param request
	 * @param response
	 */
	protected void refreshOpener(StringBuffer url, HttpServletRequest request,
			HttpServletResponse response) {
		url.insert(0, request.getContextPath());
		url.insert(0, "<script>window.close();opener.location='");
		url.append("';</script>");
		this.renderHtml(response, url.toString());
	}

	/**
	 * 
	 * 重新加载父窗口，url不变
	 * @param response
	 */
	protected void refreshOpener(HttpServletResponse response) {
		this.renderHtml(response,
						"<script>window.close();opener.location.replace(opener.location);</script>");
	}
	
	/**
	 * 直接输出
	 * @param response
	 * @param text
	 * @param contentType
	 */
	protected void render(HttpServletResponse response, String text,
			String contentType) {
		try {
			response.setContentType(contentType);
			response.getWriter().write(text);
		} catch (IOException e) {
			log.error("error", e);
			e.printStackTrace();
		}
	}

}
