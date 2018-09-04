package com.ninemax.jpa.code.action;

import com.ninemax.jpa.code.bus.TCzjlBus;
import com.ninemax.jpa.code.bus.TZrxzqhBus;
import com.ninemax.jpa.code.dao.TZrxzqhDAO;
import com.ninemax.jpa.code.model.TCzjl;
import com.ninemax.jpa.code.model.TZrxzqh;
import com.ninemax.jpa.system.model.Bzjgdm;
import com.ninemax.jpa.system.model.User;
import com.ninemax.jpa.util.ExportTxtUtil;
import com.ninemax.jpa.util.clsPageComponent;
import com.ninemax.jpa.util.clsStringTool;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.directwebremoting.impl.ExportUtil;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-9-3
 * Time: 下午3:32
 */
public class  LogManagerAction extends ActionSupport implements SessionAware {
    private static Logger log = Logger.getLogger(LogManagerAction.class);
    public LogManagerAction() {
        czjlBus = new TCzjlBus();
    }
    private Map<String, Object> session;
    private String currentPath = "";
    private List<TCzjl> list;
    private String startDate;
    private String endDate;
    private String jgdm;
    private String xzqh;
    private String type;  // 办证机构代码     -- 对应表字段：xzqh
    private String name; //操作员 - 登录用户名 -- 对应表字段：name
    private String tyshxydm;

    //业务操作类
    private TCzjlBus czjlBus;

    //分页变量
    private clsPageComponent pages;
    private Integer rowNumsView = 20;
    private Integer pageno = 1;
    private String orderbyColum;
    private String orderbyMethod;
	private TZrxzqhDAO tzDAO = new TZrxzqhDAO();
////////////////     省级用户操作日志           ///////////////
    /**
     * 操作记录列表查询 -- 省级
     * @return
     */
    public String provincialOperList(){
        currentPath = "/product/jsp/log/provincialOperList.jsp";
        if (pages == null)
            pages = new clsPageComponent();
        Map<String, String> params = new HashedMap();
        if(!clsStringTool.isEmpty(startDate)){
            params.put("startDate",startDate);
        }

        if(!clsStringTool.isEmpty(endDate)){
            params.put("endDate",endDate);
        }

        if(!clsStringTool.isEmpty(tyshxydm)){
            params.put("tyshxydm",tyshxydm);
        }
        if(!clsStringTool.isEmpty(xzqh)){
        	params.put("xzqh",xzqh);
        }
        if(!clsStringTool.isEmpty(type)){
            params.put("type",type);
        }
        if(!clsStringTool.isEmpty(name)){
        	params.put("name",name);
        }
        list = czjlBus.listOperRecords(params, pageno, rowNumsView, pages,orderbyColum,orderbyMethod);
        return this.SUCCESS;
    }

    /**
     * 操作日志导出txt - 省级
     * @return
     */
    public String export(){
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        String path = ServletActionContext.getServletContext().getRealPath("/txt/log.txt");
        File file = new File(path);
        Map<String, String> params = new HashedMap();
        if(!clsStringTool.isEmpty(startDate)){
            params.put("startDate",startDate);
        }
        if(!clsStringTool.isEmpty(endDate)){
            params.put("endDate",endDate);
        }
        if(!clsStringTool.isEmpty(jgdm)){
            params.put("jgdm",jgdm);
        }
        if(!clsStringTool.isEmpty(xzqh)){
        	params.put("xzqh",xzqh);
        }
        if(!clsStringTool.isEmpty(name)){
        	params.put("name",name);
        }
        list = czjlBus.listOperRecords(params);
        //导出txt
        List<String> properties = new ArrayList<String>();
        properties.add("jgdm");
        properties.add("name");
        properties.add("type");
        properties.add("date");
        String[] strings = new String[]{"机构代码","操作员","操作类型","操作日期"};
        ExportTxtUtil.setTitle(strings);
        ExportTxtUtil.setProperties(properties);
        ExportTxtUtil.transferModelToTxt(file,(List)list);
        try {
            //导出的代码
            byte[] bt = null;
            ServletOutputStream outt = null;
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream(4096);
            byte[] cache = new byte[4096];
            for (int offset = fis.read(cache); offset != -1; offset = fis.read(cache)) {
                    byteOutputStream.write(cache, 0, offset);
            }
            bt = byteOutputStream.toByteArray();
            response.reset();
            response.setContentType("application/octet-stream");
            response.addHeader("Content-Disposition","attachment; filename=" + java.net.URLEncoder.encode(file.getName(), "UTF-8"));
            outt = response.getOutputStream();
            outt.write(bt);
            outt.flush();
            outt.close();
            fis.close();
            if(file.exists()){
                file.delete();
            }
        } catch (IOException e) {
            log.error(LogManagerAction.class,e);
        }
        return null;
    }
///////////////////////////////////
////////////////     市级用户操作日志           ///////////////
    /**
     * 操作记录列表查询 -- 市级
     * @return
     */
    public String  cityOperList(){
    	currentPath = "/product/jsp/log/cityOperList.jsp";
        //////////////////
        Object  obj = session.get("sysUser");
        String bzjgdm = ""; // 区分：办证机构代码 - 用户查询记录范围
        if(obj!=null){
        	User sysuser = (User)obj;
        	bzjgdm = sysuser.getBzjgdm().toString();
        	}
		Bzjgdm tz = tzDAO.findById(bzjgdm);
//		if(!tz.getBzjgflag()){// 判断 T_zyxhzqh:bzjg_flg字段  - 标志位（1）仅查自己
//			bzjgdm = bzjgdm.substring(0,4);
//		}
		bzjgdm = bzjgdm.substring(0,4);
		
		
/*		TZrxzqhBus zrxzqhBus=new TZrxzqhBus();
		Map<String, String> zrxzqhMap = zrxzqhBus.getMap();
		Iterator<Map.Entry<String, String>> it = zrxzqhMap.entrySet().iterator();
    	while(it.hasNext()){   
    		 Map.Entry<String, String> entry=it.next();   
    		 String key=entry.getKey();  
    		 if(!key.startsWith(bzjgdm)){
    			 it.remove();
    		 }
    	}
    	ActionContext.getContext().put("bzjgdmMap", zrxzqhMap);*/
	/*	if(obj!=null){
			User sysuser = (User)obj;
			if(sysuser.getUserName().matches("admin")){
				bzjgdm = bzjgdm.substring(0,2);
				
			}
		}*/
		/////////////////
    	if (pages == null)
    		pages = new clsPageComponent();
    	Map<String, String> params = new HashedMap();
    	if(!clsStringTool.isEmpty(startDate)){
    		params.put("startDate",startDate);
    	}
    	
    	if(!clsStringTool.isEmpty(endDate)){
    		params.put("endDate",endDate);
    	}
    	
    	if(!clsStringTool.isEmpty(tyshxydm)){
    		params.put("tyshxydm",tyshxydm);
    	}
        if(!clsStringTool.isEmpty(xzqh)){
        	params.put("xzqh",xzqh);
        }
        if(!clsStringTool.isEmpty(type)){
            params.put("type",type);
        }
        if(!clsStringTool.isEmpty(name)){
        	params.put("name",name);
        }
    	if(!clsStringTool.isEmpty(bzjgdm)){
    		params.put("bzjgdm",bzjgdm);
    	}

    	list = czjlBus.listOperRecords(params, pageno, rowNumsView, pages,orderbyColum,orderbyMethod);
    	return this.SUCCESS;
    }
    
    /**
     * 操作日志导出txt - 市级
     * @return
     */
    public String cityExport(){
        //////////////////
        Object  obj = session.get("sysUser");
        String bzjgdm = ""; // 区分：办证机构代码 - 用户查询记录范围
        if(obj!=null){
        	User sysuser = (User)obj;
        	bzjgdm = sysuser.getBzjgdm();
        	}
        Bzjgdm tz = tzDAO.findById(bzjgdm);
	/*	if(!tz.getBzjgflag()){// 判断 T_zyxhzqh:bzjg_flg字段  - 标志位（1）仅查自己
			bzjgdm = bzjgdm.substring(0,4);
		}*/
		/////////////////
    	HttpServletRequest request = ServletActionContext.getRequest();
    	HttpServletResponse response = ServletActionContext.getResponse();
    	String path = ServletActionContext.getServletContext().getRealPath("/txt/log.txt");
    	File file = new File(path);
    	Map<String, String> params = new HashedMap();
    	if(!clsStringTool.isEmpty(startDate)){
    		params.put("startDate",startDate);
    	}
    	if(!clsStringTool.isEmpty(endDate)){
    		params.put("endDate",endDate);
    	}
    	if(!clsStringTool.isEmpty(jgdm)){
    		params.put("jgdm",jgdm);
    	}
        if(!clsStringTool.isEmpty(xzqh)){
        	params.put("xzqh",xzqh);
        }
        if(!clsStringTool.isEmpty(name)){
        	params.put("name",name);
        }
    	if(!clsStringTool.isEmpty(bzjgdm)){
    		params.put("bzjgdm",bzjgdm);
    	}
    	list = czjlBus.listOperRecords(params);
    	//导出txt
    	List<String> properties = new ArrayList<String>();
    	properties.add("jgdm");
    	properties.add("name");
    	properties.add("type");
    	properties.add("date");
    	String[] strings = new String[]{"机构代码","操作员","操作类型","操作日期"};
    	ExportTxtUtil.setTitle(strings);
    	ExportTxtUtil.setProperties(properties);
    	ExportTxtUtil.transferModelToTxt(file,(List)list);
    	try {
    		//导出的代码
    		byte[] bt = null;
    		ServletOutputStream outt = null;
    		FileInputStream fis = new FileInputStream(file);
    		ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream(4096);
    		byte[] cache = new byte[4096];
    		for (int offset = fis.read(cache); offset != -1; offset = fis.read(cache)) {
    			byteOutputStream.write(cache, 0, offset);
    		}
    		bt = byteOutputStream.toByteArray();
    		response.reset();
    		response.setContentType("application/octet-stream");
    		response.addHeader("Content-Disposition","attachment; filename=" + java.net.URLEncoder.encode(file.getName(), "UTF-8"));
    		outt = response.getOutputStream();
    		outt.write(bt);
    		outt.flush();
    		outt.close();
    		fis.close();
    		if(file.exists()){
    			file.delete();
    		}
    	} catch (IOException e) {
            log.error(LogManagerAction.class,e);
    	}
    	return null;
    }
///////////////////////////////////
////////////////     仅本人用户操作日志           ///////////////
    /**
     * 操作记录列表查询 -- 仅本人
     * @return
     */
    public String userOperList(){
    	currentPath = "/product/jsp/log/userOperList.jsp";
        //////////////////
        Object  obj = session.get("sysUser");
       // String loginName = ""; //操作员 - 登录用户名
        if(obj!=null){
        	User sysuser = (User)obj;
        	name = sysuser.getUserName().toString();
        	}
		/////////////////
    	if (pages == null)
    		pages = new clsPageComponent();
    	Map<String, String> params = new HashedMap();
    	if(!clsStringTool.isEmpty(startDate)){
    		params.put("startDate",startDate);
    	}
    	
    	if(!clsStringTool.isEmpty(endDate)){
    		params.put("endDate",endDate);
    	}
    	
    	if(!clsStringTool.isEmpty(tyshxydm)){
    		params.put("tyshxydm",tyshxydm);
    	}
        if(!clsStringTool.isEmpty(xzqh)){
        	params.put("xzqh",xzqh);
        }
        if(!clsStringTool.isEmpty(type)){
            params.put("type",type);
        }
        if(!clsStringTool.isEmpty(name)){
        	params.put("name",name);
        }
    	//if(!clsStringTool.isEmpty(loginName)){
    		//params.put("loginName",loginName);
    	//}
    	list = czjlBus.listOperRecords(params, pageno, rowNumsView, pages,orderbyColum,orderbyMethod);
    	return this.SUCCESS;
    }
    
    /**
     * 操作日志导出txt - 仅本人
     * @return
     */
    public String userExport(){
        //////////////////
        Object  obj = session.get("sysUser");
        String loginName = ""; //操作员 - 登录用户名
        if(obj!=null){
        	User sysuser = (User)obj;
        	loginName = sysuser.getUserName().toString();
        	}
		/////////////////
    	HttpServletRequest request = ServletActionContext.getRequest();
    	HttpServletResponse response = ServletActionContext.getResponse();
    	String path = ServletActionContext.getServletContext().getRealPath("/txt/log.txt");
    	File file = new File(path);
    	Map<String, String> params = new HashedMap();
    	if(!clsStringTool.isEmpty(startDate)){
    		params.put("startDate",startDate);
    	}
    	if(!clsStringTool.isEmpty(endDate)){
    		params.put("endDate",endDate);
    	}
    	if(!clsStringTool.isEmpty(jgdm)){
    		params.put("jgdm",jgdm);
    	}
        if(!clsStringTool.isEmpty(xzqh)){
        	params.put("xzqh",xzqh);
        }
        if(!clsStringTool.isEmpty(name)){
        	params.put("name",name);
        }
    	if(!clsStringTool.isEmpty(loginName)){
    		params.put("loginName",loginName);
    	}
    	list = czjlBus.listOperRecords(params);
    	//导出txt
    	List<String> properties = new ArrayList<String>();
    	properties.add("jgdm");
    	properties.add("name");
    	properties.add("type");
    	properties.add("date");
    	String[] strings = new String[]{"机构代码","操作员","操作类型","操作日期"};
    	ExportTxtUtil.setTitle(strings);
    	ExportTxtUtil.setProperties(properties);
    	ExportTxtUtil.transferModelToTxt(file,(List)list);
    	try {
    		//导出的代码
    		byte[] bt = null;
    		ServletOutputStream outt = null;
    		FileInputStream fis = new FileInputStream(file);
    		ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream(4096);
    		byte[] cache = new byte[4096];
    		for (int offset = fis.read(cache); offset != -1; offset = fis.read(cache)) {
    			byteOutputStream.write(cache, 0, offset);
    		}
    		bt = byteOutputStream.toByteArray();
    		response.reset();
    		response.setContentType("application/octet-stream");
    		response.addHeader("Content-Disposition","attachment; filename=" + java.net.URLEncoder.encode(file.getName(), "UTF-8"));
    		outt = response.getOutputStream();
    		outt.write(bt);
    		outt.flush();
    		outt.close();
    		fis.close();
    		if(file.exists()){
    			file.delete();
    		}
    	} catch (IOException e) {
            log.error(LogManagerAction.class,e);
    	}
    	return null;
    }
///////////////////////////////////
    
    public static void main(String[] args) {
        new LogManagerAction().export();
    }

    public String getCurrentPath() {
        return currentPath;
    }

    public void setCurrentPath(String currentPath) {
        this.currentPath = currentPath;
    }

    public List<TCzjl> getList() {
        return list;
    }

    public void setList(List<TCzjl> list) {
        this.list = list;
    }

    public clsPageComponent getPages() {
        return pages;
    }

    public void setPages(clsPageComponent pages) {
        this.pages = pages;
    }

    public Integer getRowNumsView() {
        return rowNumsView;
    }

    public void setRowNumsView(Integer rowNumsView) {
        this.rowNumsView = rowNumsView;
    }

    public Integer getPageno() {
        return pageno;
    }

    public void setPageno(Integer pageno) {
        this.pageno = pageno;
    }

    public String getOrderbyColum() {
        return orderbyColum;
    }

    public void setOrderbyColum(String orderbyColum) {
        this.orderbyColum = orderbyColum;
    }

    public String getOrderbyMethod() {
        return orderbyMethod;
    }

    public void setOrderbyMethod(String orderbyMethod) {
        this.orderbyMethod = orderbyMethod;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getJgdm() {
        return jgdm;
    }

    public void setJgdm(String jgdm) {
        this.jgdm = jgdm;
    }

	public String getXzqh() {
		return xzqh;
	}

	public void setXzqh(String xzqh) {
		this.xzqh = xzqh;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

	public String getTyshxydm() {
		return tyshxydm;
	}

	public void setTyshxydm(String tyshxydm) {
		this.tyshxydm = tyshxydm;
	}
    
    
}
