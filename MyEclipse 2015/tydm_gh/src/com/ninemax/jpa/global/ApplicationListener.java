package com.ninemax.jpa.global;


import com.ninemax.jpa.code.service.WebServiceTestImp;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;
import javax.xml.ws.Endpoint;

public class ApplicationListener extends HttpServlet implements ServletContextListener {

    public void contextInitialized(ServletContextEvent arg0) {
        // 加载系统参数
        InitSysParams initSysParams = InitSysParams.getInstance();
        initSysParams.InitSysParams();
        InitSysParams.ImagePath = arg0.getServletContext().getInitParameter("systemImagePath");

    }

    public void contextDestroyed(ServletContextEvent arg0) {

    }


}