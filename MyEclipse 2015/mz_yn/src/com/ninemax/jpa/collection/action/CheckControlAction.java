package com.ninemax.jpa.collection.action;

import com.ninemax.jpa.collection.dao.CheckControlDAO;
import com.ninemax.jpa.collection.model.CheckControl;
import com.ninemax.jpa.system.bo.SysManage_logBo;
import com.ninemax.jpa.system.model.SysManage_log;
import com.ninemax.jpa.system.model.User;
import com.ninemax.jpa.util.clsStringTool;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;


public class CheckControlAction extends HttpServlet {
	private static final String CONTENT_TYPE = "text/html; charset=GBK";
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	//设置编码类型
        //response.setContentType(CONTENT_TYPE);
        request.setCharacterEncoding("GBK");
        SysManage_logBo sysManage_logBo = new SysManage_logBo();
        HttpSession session = request.getSession();
        //clsSysUserTO ses_sysUserTO = (clsSysUserTO)session.getAttribute("sysUser");
		String operFlag = request.getParameter("operFlag");
		operFlag = "add";
		User sysuser = (User)session.getAttribute("sysUser");
		String c_userid = String.valueOf(sysuser.getUserId());
		String returnMess = "";
        CheckControlDAO checkcontroldao = new CheckControlDAO();
        boolean isSuccessFlag = false;
        if("add".equals(operFlag)){
        	boolean isDelete = checkcontroldao.delete(" delete CheckControl ");
        	if(isDelete || true){
        		String[] groupArray = request.getParameterValues("jgdm");
            	//CheckControl checkControl = null;
        		if(groupArray != null && groupArray.length > 0){
	            	for(String jgdm : groupArray){
	            		CheckControl checkControl = new CheckControl();
	            		checkControl.setBzjgdm(clsStringTool.convertNull(jgdm));
	            		checkControl.setBz(c_userid);
	            		isSuccessFlag = checkcontroldao.save(checkControl);
	            	}
        		}else{
        			isSuccessFlag = true;
        		}
        	}
        	if(isSuccessFlag){
                //操作成功，写日志
                SysManage_log sysManage_log = new SysManage_log();
                sysManage_log.setOperkindId("");
                sysManage_log.setMemo("审核控制");
                sysManage_log.setOpervalue("更新审核控制");
                sysManage_log.setUserid(String.valueOf(sysuser.getUserId()));
                sysManage_log.setUsername(sysuser.getUserName());
                sysManage_log.setOperdate(new Date());

			sysManage_logBo.save(sysManage_log);
        		returnMess = "success";
        	}else{
        		returnMess = "failure";
        	}
        	response.sendRedirect(request.getContextPath() + "/product/jsp/frame/list_checkControl.jsp?msg=" + returnMess + "&oper=mod");
        }

	}

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
