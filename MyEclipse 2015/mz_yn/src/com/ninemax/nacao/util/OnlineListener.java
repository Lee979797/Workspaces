package com.ninemax.nacao.util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;

public class OnlineListener implements HttpSessionListener, 
  HttpSessionAttributeListener { 
	// ���� 
	ServletContext sc; 
	ArrayList list = new ArrayList(); 
	// �½�һ��sessionʱ�����˲��� 
	public void sessionCreated(HttpSessionEvent se) { 
	  sc=se.getSession().getServletContext(); 
	  System.out.println("�½�һ��session"); 
	} 
	// ����һ��sessionʱ�����˲��� 
	public void sessionDestroyed(HttpSessionEvent se) { 
	  System.out.println("����һ��session"); 
	  if (!list.isEmpty()) { 
	   list.remove((String) se.getSession().getAttribute("onLine")); 
	   sc.setAttribute("list", list); 
	  } 
	} 
	// ��session����Ӷ���ʱ�����˲�������list�����һ������ 
	public void attributeAdded(HttpSessionBindingEvent sbe) { 
	  if("onLine".equals(sbe.getSession().getAttribute("onLine"))){
		  list.add((String) sbe.getValue()); 
		  sc.setAttribute("list", list); 
	  }
	} 
	// �޸ġ�ɾ��session����Ӷ���ʱ�����˲��� 
	public void attributeRemoved(HttpSessionBindingEvent arg0) { 
	} 
	public void attributeReplaced(HttpSessionBindingEvent arg0) { 
	} 
} 

