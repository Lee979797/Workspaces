package com.ninemax.nacao.util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;

public class OnlineListener implements HttpSessionListener, 
  HttpSessionAttributeListener { 
	// 参数 
	ServletContext sc; 
	ArrayList list = new ArrayList(); 
	// 新建一个session时触发此操作 
	public void sessionCreated(HttpSessionEvent se) { 
	  sc=se.getSession().getServletContext(); 
	  System.out.println("新建一个session"); 
	} 
	// 销毁一个session时触发此操作 
	public void sessionDestroyed(HttpSessionEvent se) { 
	  System.out.println("销毁一个session"); 
	  if (!list.isEmpty()) { 
	   list.remove((String) se.getSession().getAttribute("onLine")); 
	   sc.setAttribute("list", list); 
	  } 
	} 
	// 在session中添加对象时触发此操作，在list中添加一个对象 
	public void attributeAdded(HttpSessionBindingEvent sbe) { 
	  if("onLine".equals(sbe.getSession().getAttribute("onLine"))){
		  list.add((String) sbe.getValue()); 
		  sc.setAttribute("list", list); 
	  }
	} 
	// 修改、删除session中添加对象时触发此操作 
	public void attributeRemoved(HttpSessionBindingEvent arg0) { 
	} 
	public void attributeReplaced(HttpSessionBindingEvent arg0) { 
	} 
} 

