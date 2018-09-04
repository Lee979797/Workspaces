package com.ninemax.jpa.system.action;

import com.ninemax.jpa.global.BaseAction;
import com.ninemax.jpa.system.bo.SysManage_logBo;
import com.ninemax.jpa.system.bo.UserGroupBo;
import com.ninemax.jpa.system.model.SysManage_log;
import com.ninemax.jpa.system.model.User;
import com.ninemax.jpa.system.model.UserGroup;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

public class GroupAction extends BaseAction{
	private UserGroupBo userGroupBo = new UserGroupBo();
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
		}else if (method.equals("manageRole")) {
			manageRole(request, response);
		}
	}
	
	String message = "";
	
	private void add(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		UserGroup userGroup = new UserGroup() ;
		
		this.bindingForm2Bean(userGroup,request.getParameterMap());
		
		HttpSession session = request.getSession();
		User ses_sysUserTO = (User)session.getAttribute("sysUser");
		Date newDate = new Date();
		
		int intResult = userGroupBo.AddUserGroup(userGroup);
		if(intResult==-1){
			
			message = "existGroup";
			this.sendRedirect(response, formatUrl(request.getParameter("currentPage"),"msg="+message));
		}else if(intResult==1){
			
			//操作成功，写日志
			SysManage_log sysManage_log = new SysManage_log();
			sysManage_log.setOperkindId("");
			sysManage_log.setMemo("添加用户组");
			sysManage_log.setOpervalue(userGroup.getUsergroupName());
			sysManage_log.setUserid(String.valueOf(ses_sysUserTO.getUserId()));
			sysManage_log.setUsername(ses_sysUserTO.getUserName());
			sysManage_log.setOperdate(newDate);
			
			sysManage_logBo.save(sysManage_log);
			
			message = "AddGroupSuc";
			this.sendRedirect(response, formatUrl(request.getParameter("currentPage"),"msg="+message));
		}else{
			message = "serverbusy";
			this.sendRedirect(response, formatUrl(request.getParameter("currentPage"),"msg="+message));
		}
	}
	private void modify(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		UserGroup userGroup = new UserGroup() ;
		
		this.bindingForm2Bean(userGroup,request.getParameterMap());
		
		HttpSession session = request.getSession();
		User ses_sysUserTO = (User)session.getAttribute("sysUser");
		Date newDate = new Date();
		
		
		int intResult = userGroupBo.ModifyUserGroup(userGroup);
		if(intResult==-1){
			
			message = "existGroup";
			this.sendRedirect(response, formatUrl(request.getParameter("currentPage"),"msg="+message));
		}else if(intResult==1){
			
			//操作成功，写日志
			SysManage_log sysManage_log = new SysManage_log();
			sysManage_log.setOperkindId("");
			sysManage_log.setMemo("修改用户组");
			sysManage_log.setOpervalue(userGroup.getUsergroupName());
			sysManage_log.setUserid(String.valueOf(ses_sysUserTO.getUserId()));
			sysManage_log.setUsername(ses_sysUserTO.getUserName());
			sysManage_log.setOperdate(newDate);
			
			sysManage_logBo.save(sysManage_log);
			
			message = "ModGroupSuc";
			this.sendRedirect(response, formatUrl(request.getParameter("currentPage"),"msg="+message));
		}else{
			message = "serverbusy";
			this.sendRedirect(response, formatUrl(request.getParameter("currentPage"),"msg="+message));
		}
	}
	
	/** 
	 * 删除角色
	 * @return -3 角色编号为空，-1 角色已经赋予用户组，-2 该角色已经赋予用户
	 **/
	private void delete(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
		User ses_sysUserTO = (User)session.getAttribute("sysUser");
		Date newDate = new Date();
		
		String usergroup_id= request.getParameter("usergroup_id");
		int intResult = userGroupBo.DeleteUserGroup(usergroup_id);
		if(intResult==1){
			
			UserGroup userGroup = userGroupBo.findById(Integer.valueOf(usergroup_id));
			//操作成功，写日志
			SysManage_log sysManage_log = new SysManage_log();
			sysManage_log.setOperkindId("");
			sysManage_log.setMemo("删除用户组");
			sysManage_log.setOpervalue(userGroup.getUsergroupName());
			sysManage_log.setUserid(String.valueOf(ses_sysUserTO.getUserId()));
			sysManage_log.setUsername(ses_sysUserTO.getUserName());
			sysManage_log.setOperdate(newDate);
			
			sysManage_logBo.save(sysManage_log);
			
			message = "delGroupSuc";
		//	this.sendRedirect(response, "/product/jsp/group/groupList.jsp?msg="+message);
			response.getWriter().write(message);
    		return;
		}else  if(intResult==-1){
    		
    		message = "groupHasTOUser";
			
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
		request.getRequestDispatcher("/product/jsp/group/groupList.jsp").forward(request, response);   

	}
	
	private void manageRole(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		UserGroup userGroup = new UserGroup() ;

		this.bindingForm2Bean(userGroup,request.getParameterMap());
		
		HttpSession session = request.getSession();
		User ses_sysUserTO = (User)session.getAttribute("sysUser");
		Date newDate = new Date();
		
		String[] roles = request.getParameterValues("selectedrole");
    	String group_id = request.getParameter("group_id");
    	boolean result = userGroupBo.UpdateRoles(group_id, roles);
    	
    	
    	String group_name = userGroupBo.findById(Integer.parseInt(group_id)).getUsergroupName();

    	//操作成功，写日志
		SysManage_log sysManage_log = new SysManage_log();
		sysManage_log.setOperkindId("");
		sysManage_log.setMemo("分配角色");
		sysManage_log.setOpervalue("角色="+group_name);
		sysManage_log.setUserid(String.valueOf(ses_sysUserTO.getUserId()));
		sysManage_log.setUsername(ses_sysUserTO.getUserName());
		sysManage_log.setOperdate(newDate);
		
		sysManage_logBo.save(sysManage_log);
		
    	message = "manageGroupRole";
		
		if(result){
			this.sendRedirect(response, formatUrl(request.getParameter("currentPage"),"msg="+message));
		}else{
			this.sendRedirect(response, formatUrl(request.getParameter("currentPage"),"msg=no"));
		}
	}

	
	private String formatUrl(String url,String params){
		if(!url.contains("?")){
			url+="?";
		}else{
			url+="&";
		}
		return url+params;
	}

}
