package com.ninemax.nacao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.tags.TableColumn;
import org.htmlparser.tags.TableHeader;
import org.htmlparser.tags.TableRow;
import org.htmlparser.tags.TableTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import com.ninemax.jpa.code.bus.GSUrlBus;
import com.ninemax.jpa.util.DateUtil;
import com.ninemax.jpa.util.UserPropertiesData;
import com.ninemax.nacao.util.WebContent;



import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 工商二维码提取数据
 * @author liupeng
 *
 */
public class GsUrlData extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("GBK");
        response.setContentType("text/html; charset=GBK");
		PrintWriter out = response.getWriter();
		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
	
		String gsUrl=request.getParameter("gsUrl");
		 if (gsUrl != null && !gsUrl.equals("")) {
			 gsUrl = URLDecoder.decode(gsUrl, "UTF-8");
	        }
		
		 //大连工商
		 GSUrlBus gs= new GSUrlBus();
		 //gs.changChun(gsUrl);
		 
		//JSONObject.fromObject(map).write(response.getWriter()); 
		//页面输出JSONArray的内容
		PrintWriter out= response.getWriter();
		//out.print(gs.daLian(gsUrl));
		out.print(gs.changChun(gsUrl));
		out.close();
	}
	
	
}
