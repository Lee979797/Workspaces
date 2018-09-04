package com.ninemax.nacao.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet; 

public class CountStartListener extends HttpServlet implements ServletContextListener 
{ 
	private static final long serialVersionUID = 1824920962239905170L; 
	public CountStartListener() 
	{ 
	   // TODO Auto-generated constructor stub 
	} 
	public void contextDestroyed(ServletContextEvent arg0) 
	{ 
	   // TODO Auto-generated method stub 
	} 
	   public void contextInitialized(ServletContextEvent arg0) 
	{    
	  // DoCountTask.dotask(); 
	} 
}

