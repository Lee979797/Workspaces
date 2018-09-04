/**
 * 
 */
package com.ninemax.jpa.util;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author haojy 2011-9-1  ����09:44:39
 *
 */
public class CheckSQLInjection extends HttpServlet implements Filter {



	@SuppressWarnings("static-access")
	public void doFilter(ServletRequest req, ServletResponse resp,FilterChain chain) throws IOException, ServletException 
	{
		
		HttpServletRequest  request= (HttpServletRequest)req;		
		SQLInjection  sql_injection = new SQLInjection();
		String queryString =  request.getQueryString();
		String fromUrl = request.getRequestURI();
		if(fromUrl != null && (clsStringTool.convertNull(fromUrl)).endsWith("action/ExportEnterpriseProductAction")){
			chain.doFilter(req, resp);
		}
		if(queryString == null || queryString.trim().equals("")){
			chain.doFilter(req, resp);
		} else{
			if (sql_injection.injection(queryString))
			{
				//�ж�URL���������Ƿ����ע����룬�ǵĻ�����ת��ĳҳ��
				RequestDispatcher rd=	request.getRequestDispatcher("/sqlinjection.html");
				rd.forward(req, resp);

				return;
			}else
			{
				chain.doFilter(req, resp);
			}
		}
	}


	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
