package com.lhq.prj.bms.core;

import java.io.File;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class SpringMail_Batch_Attach_HTML {
	private Configuration cfg = new Configuration();

	private static JavaMailSender sender = null;

	private static FreeMarkerConfigurer freeMarker = null;

	public static void main(String[] args) throws Exception {
		// init
		ApplicationContext ctx = new FileSystemXmlApplicationContext(
				"src/applicationContext-mail.xml");
		JavaMailSender sender = (JavaMailSender) ctx.getBean("mailSender");
		SpringMail_Batch_Attach_HTML.sender = sender;
		SpringMail_Batch_Attach_HTML.freeMarker = (FreeMarkerConfigurer) ctx
				.getBean("freeMarker");

		SpringMail_Batch_Attach_HTML springMail = new SpringMail_Batch_Attach_HTML();
		//发送简单邮件
		springMail.sendMail(sender);
		//给某个人发送邮件，基于模板
		springMail.sendMessage("洒江河风景阿嫂法拉", "wytdq@126.com");

		//给某些人发送邮件，带附件
		List toList = new ArrayList();
		toList.add("xxx@sina.COM");
		toList.add("xxx@163.COM");
		toList.add("TIANDEQING@ECODE.NET.CN");
		springMail.sendBatchEmail("邮件批量发送测试", toList);
	}

	// 发送一封文本邮件给一个收件人
	private void sendMail(JavaMailSender sender) throws Exception {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("tiandeqing@ecode.net.cn"); // 接收人
		mail.setFrom("tiandeqing@ecode.net.cn"); // 发送人
		mail.setSubject("test by amigo");
		// 嵌入ftl模版
		cfg.setClassForTemplateLoading(getClass(), "/mail");
		Map root = new HashMap();
		root.put("username", "sucre"); // 模板变量
		Template t = cfg.getTemplate("notify-mail.ftl");
		StringWriter writer = new StringWriter();
		t.process(root, writer);
		// 把模版内容写入邮件中
		mail.setText(writer.toString());
		sender.send(mail);
		System.out.println("邮件发送成功！");
	}

	/**
	 * 发送带模板的单个html格式邮件
	 * 
	 * @throws Exception
	 */
	public void sendMessage(String content, String address) throws Exception {
		MimeMessage msg = sender.createMimeMessage();
		// 设置utf-8或GBK编码，否则邮件会有乱码，true表示为multipart邮件
		MimeMessageHelper helper = new MimeMessageHelper(msg, true, "utf-8");
		helper.setTo(address); // 邮件接收地址
		helper.setFrom("tiandeqing@ecode.net.cn"); // 邮件发送地址,这里必须和xml里的邮件地址相同一致
		helper.setSubject("测试ccc"); // 主题
		String htmlText = getMailText(content); // 使用模板生成html邮件内容
		helper.setText(htmlText, true); // 邮件内容，注意加参数true，表示启用html格式
		sender.send(msg); // 发送邮件
		System.out.println("sendMessage(String content,String address) OK");
	}

	/**
	 * 批量发送多媒体邮件
	 * */
	public void sendBatchEmail(String content, List address)
			throws MessagingException, UnsupportedEncodingException {
		MimeMessage msg = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg, true, "utf-8");
		
		StringBuffer html = new StringBuffer();
        html.append("<html>");
        html.append("<head>");
        html.append("<meta http-equiv='Content-Type' content='text/html; charset=gbk'>");
        html.append("</head>");
        html.append("<body bgcolor='#ccccff'>");
        html.append("<center>");
        html.append("<h1>你好，Jarry</h1>").append(content);
        html.append("<img src='cid:myimg'>");//显示图片
        html.append("<p>logo:");
        html.append("<img src='cid:vedio'>");
        html.append("</center>");
        html.append("</body>");
        html.append("</html>");
        
		String toList = getMailList(address);
		InternetAddress[] iaToList = new InternetAddress().parse(toList);
		msg.setRecipients(Message.RecipientType.TO, iaToList);
		helper.setFrom("tiandeqing@ecode.net.cn");
		helper.setSubject("批量发送测试");
		helper.setText(html.toString(), true);
		// 添加内嵌文件，第1个参数为cid标识这个文件,第2个参数为资源
		helper.addInline("myimg", new File("D:\\My Documents\\My Pictures\\tian.JPG")); // 附件内容
		helper.addInline("vedio", new File("D:\\My Documents\\My Pictures\\vedio.JPG"));
		File file = new File("D:\\My Documents\\My Pictures\\hibernate框架.jpg");
		// 这里的方法调用和插入图片是不同的（插入到最后，并且直接显示），使用MimeUtility.encodeWord()来解决附件名称的中文问题
		helper.addAttachment(MimeUtility.encodeWord(file.getName()), file);
		// 如果主题出现乱码，可以使用该函数，也可以使用下面的函数
		// helper.setSubject(MimeUtility.encodeText(String text,String
		// charset,String encoding))
		// 第2个参数表示字符集，第三个为目标编码格式。
		// MimeUtility.encodeWord(String word,String charset,String encoding)
		sender.send(msg);
		System.out.println("sendBatchEmail OK");
	}

	/**
	 * 集合转换字符串
	 */
	public String getMailList(List<String> to) {
		StringBuffer toList = new StringBuffer();
		int length = to.size();
		if (to != null && length < 2) {
			toList.append(to.get(0));
		} else {
			for (int i = 0; i < length; i++) {
				toList.append(to.get(i));
				if (i != (length - 1)) {
					toList.append(",");
				}
			}
		}
		return toList.toString();
	}

	// 通过模板构造邮件内容，参数content将替换模板文件中的${content}标签。
	private String getMailText(String content) throws Exception {
		String htmlText = "";
		// 通过指定模板名获取FreeMarker模板实例
		Template tpl = freeMarker.getConfiguration().getTemplate(
				"registerUser.ftl");
		Map map = new HashMap(); // FreeMarker通过Map传递动态数据
		map.put("content", content); // 注意动态数据的key和模板标签中指定的属性相匹配
		// 解析模板并替换动态数据，最终content将替换模板文件中的${content}标签。
		htmlText = FreeMarkerTemplateUtils.processTemplateIntoString(tpl, map);
		return htmlText;
	}
}
