package com.ninemax.nacao.util.msg;

/**
 * Created by IntelliJ IDEA.
 * User: zhanghongbin
 * Date: 2010-5-6
 * Time: 17:10:13
 * To change this template use File | Settings | File Templates.
 */
public class MailMsg implements IMsg {

    private String title;
    private String mailaddr;
    private String content;
    public MailMsg(String title,String mailaddr,String content){
         this.title = title;
        this.mailaddr = mailaddr;
        this.content = content;
    }
    public boolean send() {
        /*SendMail themail = new SendMail();
		return themail.send(title,mailaddr,content,"");*/
    	return false;
    }
}
