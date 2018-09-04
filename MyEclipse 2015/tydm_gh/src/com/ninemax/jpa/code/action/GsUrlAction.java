package com.ninemax.jpa.code.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.ninemax.jpa.code.model.Certificate;
import com.ninemax.jpa.code.model.Consignee;
import com.ninemax.jpa.code.model.Page;
import com.ninemax.jpa.util.ActionUtils;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 工商二维码数据提取
 * @author liupeng
 *
 */
public class GsUrlAction extends ActionSupport implements SessionAware {

	private String currentPath;
	private static final String path = "/product/jsp/consignee/";
	private Map<String, Object> session;
	private Page page;
	private List<Certificate> cerList;

	private Certificate certificate;
	private String newPath;
	
	private String gsUrl;
	
	public void daLian(){
		
		
		
       
        
        
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		response.setContentType("text/html; charset=utf-8");
		//request.setCharacterEncoding("GBK"); 
		
		response.setContentType("text/xml;charset=utf-8");  
        response.setHeader("Cache-Control", "no-cache");  
        String nameString=(String) request.getAttribute("gsUrl");
        
        //response.setContentType("text/html;charset=utf-8");  
        
        System.out.println("sb:"+gsUrl.toString());  
          
        try {
			String des = new String(gsUrl.toString().getBytes("UTF-8"),"UTF-8");
		} catch (UnsupportedEncodingException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}  
		try {
			request.setCharacterEncoding("gbk");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String ss=request.getParameter("gsUrl");
      //  response.setContentType("text/html; charset=GBK");

		 if (gsUrl != null && !gsUrl.equals("")) {
			 try {
				gsUrl = URLDecoder.decode(gsUrl, "utf-8");
				 
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
	        }
		 
		//gsUrl="注册号：210242000018300|名称：大连铭盛贸易有限公司|住所：辽宁省大连保税区泰华大厦B座503#|类型：  有限责任公司(自然人独资)|法定代表人：庄辉|公示网址：http://gsxt.lngs.gov.cn";
		
		Map<String,String> mapJson=new HashMap<String,String>();
		String [] urlValues=gsUrl.split("\\|");
		
		for(String values:urlValues){
			
			String [] value=values.split("：");
			mapJson.put(value[0], value[1]);
		}
		
		//使用JSONArray
		JSONArray jsonArray = new JSONArray();
	
		
		JSONObject jsonObject = new JSONObject();
		for(Map.Entry<String, String> maps: mapJson.entrySet()){
			if("发照日期".equals(maps.getKey())){
				jsonObject.put("fzrq", maps.getValue());
			}else if("经营范围".equals(maps.getKey())){
				jsonObject.put("jyfw", maps.getValue());
			}else if("成立日期".equals(maps.getKey())){
				jsonObject.put("clrq", maps.getValue().replace("月", "-").replace("年","-").replace("日", ""));
			}else if("名称".equals(maps.getKey())){
				jsonObject.put("jgmc", maps.getValue());
			}else if("注册号".equals(maps.getKey())){
				jsonObject.put("zch", maps.getValue());
			}else if("法定代表人".equals(maps.getKey())){
				jsonObject.put("fddbr", maps.getValue());
			}else if("注册资本".equals(maps.getKey())){
				jsonObject.put("zczj", maps.getValue().replace(maps.getValue().replaceAll("[^\u4E00-\u9FA5]", ""), ""));
			}else if("经营范围".equals(maps.getKey())){
				jsonObject.put("jyfw", maps.getValue());
			}else if("住所".equals(maps.getKey())){
				jsonObject.put("jgdz", maps.getValue());
			}else if("营业期限自".equals(maps.getKey())){
				jsonObject.put("jyqxS", maps.getValue().trim());
			}else if("营业期限至".equals(maps.getKey())){
				jsonObject.put("jyqxE", maps.getValue());
			}else{
				
				jsonObject.put(maps.getKey(), maps.getValue());
			}
		}
		//JSONObject.fromObject(map).write(response.getWriter()); 
		//页面输出JSONArray的内容
		
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(jsonObject);
		    out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public String getCurrentPath() {
		return currentPath;
	}
	public void setCurrentPath(String currentPath) {
		this.currentPath = currentPath;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}

	public String getGsUrl() {
		return gsUrl;
	}

	public void setGsUrl(String gsUrl) {
		this.gsUrl = gsUrl;
	}
	
	
	
	

}
