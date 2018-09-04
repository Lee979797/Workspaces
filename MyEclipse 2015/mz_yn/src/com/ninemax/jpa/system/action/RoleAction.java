package com.ninemax.jpa.system.action;

import com.ninemax.jdbc.business.system.clsRightKeyBus;
import com.ninemax.jpa.global.BaseAction;
import com.ninemax.jpa.system.bo.RoleBo;
import com.ninemax.jpa.system.bo.SysManage_logBo;
import com.ninemax.jpa.system.model.Rightkey;
import com.ninemax.jpa.system.model.Role;
import com.ninemax.jpa.system.model.SysManage_log;
import com.ninemax.jpa.system.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class RoleAction extends BaseAction{
	private RoleBo roleBo = new RoleBo();
	private SysManage_logBo sysManage_logBo = new SysManage_logBo();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("GBK");
		response.setContentType("text/html; charset=GBK");
		String method = request.getParameter("method");
		if (method == null) {
			return;
		} else if (method.equals("add")) {
			add(request, response);
		} else if (method.equals("modify")) {
			modify(request, response);
		}else if (method.equals("delete")) {
			delete(request, response);
		}else if (method.equals("list")) {
			list(request, response);
		}else if (method.equals("addRightKeyToRole")) {
			addRightKeyToRole(request, response);
		}
	}
	String message = "";
	
	private void add(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Role role = new Role() ;
		
		this.bindingForm2Bean(role,request.getParameterMap());
		
		HttpSession session = request.getSession();
		User ses_sysUserTO = (User)session.getAttribute("sysUser");
		Date newDate = new Date();
		
		int intResult = roleBo.save(role);
		if(intResult==-1){
			
			message = "existAddRole";
			this.sendRedirect(response, formatUrl(request.getParameter("currentPage"),"msg="+message));
			
		}else if(intResult==1){
			
			//�����ɹ���д��־
			SysManage_log sysManage_log = new SysManage_log();
			sysManage_log.setOperkindId("");
			sysManage_log.setMemo("��ӽ�ɫ");
			sysManage_log.setOpervalue(role.getRoleName());
			sysManage_log.setUserid(String.valueOf(ses_sysUserTO.getUserId()));
			sysManage_log.setUsername(ses_sysUserTO.getUserName());
			sysManage_log.setOperdate(newDate);
			
			sysManage_logBo.save(sysManage_log);
			
			message = "AddRoleSuc";
			this.sendRedirect(response, formatUrl(request.getParameter("currentPage"),"msg="+message));
		}else{
			message = "serverbusy";
			this.sendRedirect(response, formatUrl(request.getParameter("currentPage"),"msg="+message));
		}
	}
	private void modify(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Role role = new Role() ;
		
		HttpSession session = request.getSession();
		User ses_sysUserTO = (User)session.getAttribute("sysUser");
		Date newDate = new Date();
		
		
		this.bindingForm2Bean(role,request.getParameterMap());
		int intResult = roleBo.ModifyRole(role);
		if(intResult==-1){
			
			message = "existModRole";
			this.sendRedirect(response, formatUrl(request.getParameter("currentPage"),"msg="+message));
		}else if(intResult==1){
			
			//�����ɹ���д��־
			SysManage_log sysManage_log = new SysManage_log();
			sysManage_log.setOperkindId("");
			sysManage_log.setMemo("�޸Ľ�ɫ");
			sysManage_log.setOpervalue(role.getRoleName());
			sysManage_log.setUserid(String.valueOf(ses_sysUserTO.getUserId()));
			sysManage_log.setUsername(ses_sysUserTO.getUserName());
			sysManage_log.setOperdate(newDate);
			
			sysManage_logBo.save(sysManage_log);
			
			message = "ModRoleSuc";
			this.sendRedirect(response, formatUrl(request.getParameter("currentPage"),"msg="+message));
		}else{
			message = "serverbusy";
			this.sendRedirect(response, formatUrl(request.getParameter("currentPage"),"msg="+message));
		}
	}
	
	/** 
	 * ɾ����ɫ
	 * @return -3 ��ɫ���Ϊ�գ�-1 ��ɫ�Ѿ������û��飬-2 �ý�ɫ�Ѿ������û�
	 **/
	private void delete(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		String role_id= request.getParameter("role_id");
		Role role = roleBo.findById(Integer.valueOf(role_id));
		
		HttpSession session = request.getSession();
		User ses_sysUserTO = (User)session.getAttribute("sysUser");
		Date newDate = new Date();
		
		int intResult = roleBo.DeleteRole(role_id);
		if(intResult==1){
			
			//�����ɹ���д��־
			SysManage_log sysManage_log = new SysManage_log();
			sysManage_log.setOperkindId("");
			sysManage_log.setMemo("ɾ����ɫ");
			sysManage_log.setOpervalue(role.getRoleName());
			sysManage_log.setUserid(String.valueOf(ses_sysUserTO.getUserId()));
			sysManage_log.setUsername(ses_sysUserTO.getUserName());
			sysManage_log.setOperdate(newDate);
			
			sysManage_logBo.save(sysManage_log);
			
			message = "delRoleSuc";
    		
			response.getWriter().write(message);
    		return;
		}else if(intResult==-1){
    		
    		message = "roleHasTOGroup";
    		
    		response.getWriter().write(message);
    		return;
    	}else if(intResult==-2){
    		
    		message = "roleHasTOUser";
			
    		response.getWriter().write(message);
    		return;
    	}else if(intResult==-3){
    		
    		message = "roleidNULL";
    		
    		response.getWriter().write(message);
    		return;
			
    	}else{
			message = "serverbusy";
			
			response.getWriter().write(message);
			return;
		}
	}
	private void list(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("/product/jsp/role/roleList.jsp").forward(request, response);   

	}
	
	private void addRightKeyToRole(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String role_id= request.getParameter("role_id");
		Role role = roleBo.findById(Integer.valueOf(role_id));
		clsRightKeyBus rightKeyBus = new clsRightKeyBus();
		HttpSession session = request.getSession();
		User ses_sysUserTO = (User)session.getAttribute("sysUser");
		Date newDate = new Date();
			
    	ArrayList superChannels = rightKeyBus.ListChildNode("0");//ȡһ����Ŀ
    	if(superChannels!=null && superChannels.size()>0){
    	    
    		for(int index=0;index<superChannels.size();index++){
    	    
    			boolean isUpdate = false;
    			if(index==0)isUpdate=true;//ֻ�д�ʱɾ��ԭ���е�Ȩ��
    			Rightkey rightKeyTO = (Rightkey)superChannels.get(index);
    			String keyId =  rightKeyTO.getRightkeyId();//һ�����
    			
    			
    			
            	String[] rightkeys = request.getParameterValues(keyId);	
            	
            	roleBo.UpdateRightKey(role_id,rightkeys,isUpdate);
            	
            	
            	String parentRightName = rightKeyBus.GetRightKey(keyId).getRightkeyName();
            	String role_name = role.getRoleName();
            	
            	//�����ɹ���д��־
    			SysManage_log sysManage_log = new SysManage_log();
    			sysManage_log.setOperkindId("");
    			sysManage_log.setMemo("��ɫ��Ȩ");
    			sysManage_log.setOpervalue("��ɫ="+role_name+"  Ȩ��="+parentRightName);
    			sysManage_log.setUserid(String.valueOf(ses_sysUserTO.getUserId()));
    			sysManage_log.setUsername(ses_sysUserTO.getUserName());
    			sysManage_log.setOperdate(newDate);
    			
    		}
    	}
    	
    	
    	
		
		
    	message = "addRightKeyToRole";
    	this.sendRedirect(response, formatUrl(request.getParameter("currentPage"),"msg="+message));

	}
	
	private String formatUrl(String url,String params){
		if(url.indexOf("?")==-1){
			url+="?";
		}else{
			url+="&";
		}
		return url+params;
	}

}
