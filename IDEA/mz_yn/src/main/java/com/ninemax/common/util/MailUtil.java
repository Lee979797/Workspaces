package com.ninemax.common.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailUtil {
    private static Properties properties;
    private static Message msg;
    private static Transport transport;
    //初始化Mail信息
    public MailUtil(){
        properties = new Properties();
        properties.setProperty("mail.debug", "true");//调试模式发送
        properties.setProperty("mail.smtp.auth", "true");//身份验证设置
        properties.setProperty("mail.host", "smtp.163.com");//发件人邮箱主机名
        properties.setProperty("mail.transport.protocol", "smtp");//发件协议
        Session session = Session.getInstance(properties);
        msg = new MimeMessage(session);
        try {
            msg.setSubject("REIMBURSE邮件提醒");
            msg.setFrom(new InternetAddress("lee_6692@163.com"));//设置发件人
            transport = session.getTransport();
            transport.connect("lee_6692@163.com", "bsAutoSender123");//设置发件人在该邮箱主机上的用户名密码
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 得到邮箱地址邮箱内容发送。
     */
    public void sendMail(String address, String text) throws MessagingException {
        msg.setText(text);
        transport.sendMessage(msg, new Address[]{new InternetAddress(address)});
        transport.close();
    }

}