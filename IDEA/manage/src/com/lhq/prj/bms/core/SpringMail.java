package com.lhq.prj.bms.core;

import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.mail.MessagingException;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionContext;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class SpringMail {
	
	private Configuration cfg = new Configuration();
	
	private Map appSysConfig;
	/**
	* 发送邮件
	* 
	* @param toReceiveMail 接收邮箱地址
	* @param fromReceiveMail  发送邮箱地址
	* @param title  邮件标题
	* @throws MessagingException
	*/
	public void sendMail(String toReceiveMail, String fromReceiveMail, String title,String bzjgName,String cnname,String username,String password) throws Exception  {
		String fileRealPath = ServletActionContext.getServletContext().getRealPath("WEB-INF/classes/applicationContext-mail.xml");
		ApplicationContext ctx = new FileSystemXmlApplicationContext(fileRealPath);
		JavaMailSender sender = (JavaMailSender) ctx.getBean("mailSender");
		
		appSysConfig = ActionContext.getContext().getApplication();
		String sysWebUrl=appSysConfig.get("sysWebUrl").toString();
		String sysAppName=appSysConfig.get("sysAppName").toString();
		String sysAppTel=appSysConfig.get("sysAppTel").toString();
		String sysAppEmail=appSysConfig.get("sysAppEmail").toString();
		String sysCenterName=appSysConfig.get("sysCenterName").toString();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String sysMailDate=format.format(new Date());
		
		try{
			SimpleMailMessage mail = new SimpleMailMessage();  
			mail.setTo(toReceiveMail); //接收人  
			mail.setFrom(fromReceiveMail); //发送人  
			mail.setSubject(title);  
			//嵌入ftl模版  
			cfg.setClassForTemplateLoading(getClass(), "mail");  //问题  http://www.chineselinuxuniversity.net/articles/45953.shtml，http://www.docin.com/p-609125122.html
			Map root = new HashMap();
			root.put("bzjgName", bzjgName); //模板变量 
			root.put("cnname", cnname); //模板变量 
			root.put("username", username); //模板变量 
			root.put("password", password); //模板变量
			root.put("sysWebUrl",sysWebUrl); //模板变量
			root.put("sysAppName", sysAppName); //模板变量
			root.put("sysAppTel", sysAppTel); //模板变量
			root.put("sysAppEmail", sysAppEmail); //模板变量
			root.put("sysCenterName", sysCenterName); //模板变量
			root.put("sysMailDate", sysMailDate); //模板变量
			Template t = cfg.getTemplate("notify-mail.ftl","utf-8");
			//Template t = cfg.getTemplate("notify-mail.ftl");  
			StringWriter writer = new StringWriter();  
			t.process(root, writer);  
			//把模版内容写入邮件中  
			mail.setText(writer.toString());  
			sender.send(mail);
		}catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		System.out.println("邮件发送成功！");  
	}
}
