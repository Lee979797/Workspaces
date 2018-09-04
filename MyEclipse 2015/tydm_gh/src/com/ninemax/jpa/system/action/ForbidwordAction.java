package com.ninemax.jpa.system.action;

import com.ninemax.jdbc.dao.system.ForbidLoad;
import com.ninemax.jpa.global.BaseAction;
import com.ninemax.jpa.global.InitSysParams;
import com.ninemax.jpa.system.bo.ForbidwordBo;
import com.ninemax.jpa.system.bo.SysManage_logBo;
import com.ninemax.jpa.system.dao.ForbidwordDAO;
import com.ninemax.jpa.system.model.Forbidword;
import com.ninemax.jpa.system.model.SysManage_log;
import com.ninemax.jpa.system.model.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ForbidwordAction extends BaseAction{
	private static Logger log = Logger.getLogger(ForbidwordAction.class);
	private ForbidwordBo forbidwordBo = new ForbidwordBo();
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
		}
	}
	
	private void add(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String forbidWords = request.getParameter("forbidWord");
        forbidWords = forbidWords.trim();
		forbidWords = forbidWords.replaceAll("；", ";");
		String[] cutWords = forbidWords.split(";");
		boolean issucess = false;
		
		java.text.SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sd.format(new Date());
		
		HttpSession session = request.getSession();
		User ses_sysUserTO = (User)session.getAttribute("sysUser");
		Date newDate = new Date();
		
		for (String word : cutWords) {
			try {
				Forbidword forbidword = new Forbidword();
				forbidword.setForbidWord(word);
				forbidword.setOperdate(date);
				if(forbidwordBo.save(forbidword)){
					
					//操作成功，写日志
					SysManage_log sysManage_log = new SysManage_log();
					sysManage_log.setOperkindId("");
					sysManage_log.setMemo("添加敏感字");
					sysManage_log.setOpervalue(forbidword.getForbidWord());
					sysManage_log.setUserid(String.valueOf(ses_sysUserTO.getUserId()));
					sysManage_log.setUsername(ses_sysUserTO.getUserName());
					sysManage_log.setOperdate(newDate);
					
					sysManage_logBo.save(sysManage_log);
					
					
					issucess = true;
					ForbidLoad.instance=null;
				}else{
					issucess = false;
					break;
				}
			} catch (Exception e) {
				log.error("error", e);
				e.printStackTrace();
			}
		}

		if (issucess) {
				
				//更新内存变量
				InitSysParams.forbidwords = forbidwordBo.findAll();
				
				
				String message = "OperSuc";
				this.sendRedirect(response, formatUrl(request.getParameter("currentPage"),"msg="+message));
				
		} else {
				String message = "OperFaile";
				this.sendRedirect(response, formatUrl(request.getParameter("currentPage"),"msg="+message));
		}
		
	}
	private void modify(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		Forbidword forbidword = new Forbidword() ;
		
		this.bindingForm2Bean(forbidword,request.getParameterMap());
		
		HttpSession session = request.getSession();
		User ses_sysUserTO = (User)session.getAttribute("sysUser");
		Date newDate = new Date();
		
		boolean issucess = false;
		try {
			
			if(forbidwordBo.update(forbidword)){
				issucess = true;
				ForbidLoad.instance=null;
			}
		} catch (Exception e) {
			log.error("error", e);
			e.printStackTrace();
		}

		if (issucess) {
				
				//更新内存变量
				InitSysParams.forbidwords = forbidwordBo.findAll();
				
				//操作成功，写日志
				SysManage_log sysManage_log = new SysManage_log();
				sysManage_log.setOperkindId("");
				sysManage_log.setMemo("修改敏感字");
				sysManage_log.setOpervalue(forbidword.getForbidWord());
				sysManage_log.setUserid(String.valueOf(ses_sysUserTO.getUserId()));
				sysManage_log.setUsername(ses_sysUserTO.getUserName());
				sysManage_log.setOperdate(newDate);
				
				sysManage_logBo.save(sysManage_log);
				
				String message = "OperSuc";
				this.sendRedirect(response, formatUrl(request.getParameter("currentPage"),"msg="+message));
				
		} else {
				String message = "OperFaile";
				this.sendRedirect(response, formatUrl(request.getParameter("currentPage"),"msg="+message));
		}
		
	}
	private void delete(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
	
		Forbidword forbidword = new Forbidword() ;
		String forbidId = request.getParameter("forbidId");
		forbidword = forbidwordBo.findById(Integer.valueOf(forbidId));
//		this.bindingForm2Bean(forbidword,request.getParameterMap());
		ForbidwordDAO fddao = new ForbidwordDAO();
		HttpSession session = request.getSession();
		User ses_sysUserTO = (User)session.getAttribute("sysUser");
		Date newDate = new Date();
		
		boolean issucess = false;
		String message = "success";
		try {
			if(fddao.delete("delete Forbidword fd where fd.forbidId = " + forbidId)){
				issucess = true;
				ForbidLoad.instance=null;
				//更新内存变量
				InitSysParams.forbidwords = forbidwordBo.findAll();
				
				//操作成功，写日志
				SysManage_log sysManage_log = new SysManage_log();
				sysManage_log.setOperkindId("");
				sysManage_log.setMemo("删除敏感字");
				sysManage_log.setOpervalue(forbidword.getForbidWord());
				sysManage_log.setUserid(String.valueOf(ses_sysUserTO.getUserId()));
				sysManage_log.setUsername(ses_sysUserTO.getUserName());
				sysManage_log.setOperdate(newDate);
				
				sysManage_logBo.save(sysManage_log);
				
			}
		} catch (Exception e) {
			
			message="failed";
			log.error("error", e);
			e.printStackTrace();
		}

		response.getWriter().write(message);
	}
	private void list(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("/product/jsp/forbidword/forbidList.jsp").forward(request, response);   

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
