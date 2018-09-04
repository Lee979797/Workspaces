package com.ninemax.nacao.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NewsDownServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletInputStream ss = request.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(ss));
		StringBuffer sb = new StringBuffer(ss.available());
		String foo=null;
		while((foo=br.readLine())!=null){
			sb.append(foo);
		}
		ss.close();
		br.close();

	}

}
