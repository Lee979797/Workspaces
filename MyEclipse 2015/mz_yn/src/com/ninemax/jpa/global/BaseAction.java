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
	 * ��form�����ֵ�����󣬿ɽ�ʡװ�����Ե�ʱ�䣬����ע�⣬�˷���ֻװ��form�и����ֶ�name[0]��value��������һ�����������name���ȴ���1�������Լ�д����
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
	 * ֱ��������ַ���.
	 */
	protected void renderText(HttpServletResponse response, String text) {
		render(response, text, "text/plain;charset=UTF-8");
	}
	/**
	 * ֱ�������HTML.
	 */
	protected void renderHtml(HttpServletResponse response, String text) {
		render(response, text, "text/html;charset=UTF-8");
	}

	/**
	 * ֱ�������XML.
	 */
	protected void renderXML(HttpServletResponse response, String text) {
		render(response, text, "text/xml;charset=UTF-8");
	}

	/**
	 * ���¼��ظ����ڣ�url�仯
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
	 * ���¼��ظ����ڣ�url����
	 * @param response
	 */
	protected void refreshOpener(HttpServletResponse response) {
		this.renderHtml(response,
						"<script>window.close();opener.location.replace(opener.location);</script>");
	}
	
	/**
	 * ֱ�����
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
