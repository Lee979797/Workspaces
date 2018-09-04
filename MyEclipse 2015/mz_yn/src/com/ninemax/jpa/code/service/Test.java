package com.ninemax.jpa.code.service;

import javax.xml.namespace.QName;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;
import org.apache.commons.io.IOUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.Attribute; 

import com.ninemax.jpa.util.StringUtils;
import com.ninemax.tygs.bus.TyGsBus;
import com.ninemax.tygs.model.TQybgxx;
import com.ninemax.tygs.model.TQybgxxxx;

import flex.messaging.io.ArrayList;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.Vector;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
public class Test {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	
		/*String s = "AAsf9897&^%,,，，方的身份的事fdferf";
		String res="";
	
		 char[] str=s.toCharArray();
		for(int i=0;i<str.length;i++){
			//System.out.println(str[i]);
			//System.out.println(new String(str));
			if(isfuhao(str[i])){
			
				str[i]=ToSBC(str[i]);
				//System.out.println(res1);
			}
			res+=str[i];
		}
		System.out.println(res);
		System.out.println(s);
*/
	//connect("10.20.21.48",22,"bianban","bianban123");
		sshSftp("10.20.21.48", "bianban", "bianban123", 22);  
	}
	public static ChannelSftp connect(String host, int port, String username,
			String password) {
			ChannelSftp sftp = null;
			try {
			JSch jsch = new JSch();
			jsch.getSession(username, host, port);
			Session sshSession = jsch.getSession(username, host, port);
			System.out.println("Session created.");
			sshSession.setPassword(password);
			Properties sshConfig = new Properties();
			sshConfig.put("StrictHostKeyChecking", "no");
			sshSession.setConfig(sshConfig);
			sshSession.connect();
			System.out.println("Session connected.");
			System.out.println("Opening Channel.");
			Channel channel = sshSession.openChannel("sftp");
			channel.connect();
			sftp = (ChannelSftp) channel;
			System.out.println("Connected to " + host + ".");
			} catch (Exception e) {
					e.printStackTrace();
			}
			System.out.println(sftp);
			return sftp;
			}
/*	 public static void sshSftp(String ip, String user, String psw   
	            ,int port) throws Exception{  
	        System.out.println("开始用户名密码方式登陆");  
	        Session session = null;  
	          
	        JSch jsch = new JSch();  
	          
	        if(port <=0){  
	            //连接服务器，采用默认端口  
	            session = jsch.getSession(user, ip);  
	        }else{  
	         	 System.out.println("22");  
	            //采用指定的端口连接服务器  
	            session = jsch.getSession(user, ip ,port);  
	         	 System.out.println("33");  
	        }  
	  
	        //如果服务器连接不上，则抛出异常  
	        if (session == null) {  
	        	 System.out.println("11");  
	            throw new Exception("session is null");  
	        }  
	          
	        //设置登陆主机的密码  
	        session.setPassword(psw);//设置密码     
	        //设置第一次登陆的时候提示，可选值：(ask | yes | no)  
	        session.setConfig("StrictHostKeyChecking", "no");  
	        //设置登陆超时时间     
	        //session.connect(30000);  
	          
	        //sftp(session, "aa.log");  
	        System.out.println("sftp成功");  
	    } */
	 public static void sshSftp(String ip, String user, String psw ,int port) throws Exception{
			Session session = null;
			Channel channel = null;

			
			JSch jsch = new JSch();
			
			
			if(port <=0){
				//连接服务器，采用默认端口
				session = jsch.getSession(user, ip);
			}else{
				//采用指定的端口连接服务器
				session = jsch.getSession(user, ip ,port);
			}

			//如果服务器连接不上，则抛出异常
			if (session == null) {
				throw new Exception("session is null");
			}
			
			//设置登陆主机的密码
			session.setPassword(psw);//设置密码   
			//设置第一次登陆的时候提示，可选值：(ask | yes | no)
			session.setConfig("StrictHostKeyChecking", "no");
			//设置登陆超时时间   
			session.connect(30000);
				
			try {
				//创建sftp通信通道
				channel = (Channel) session.openChannel("sftp");
				channel.connect(1000);
				ChannelSftp sftp = (ChannelSftp) channel;
				
				
				//进入服务器指定的文件夹
				sftp.cd("domains");
				
				//列出服务器指定的文件列表
				Vector v = sftp.ls("*.txt");
				for(int i=0;i<v.size();i++){
					System.out.println(v.get(i));
				}
				
				//以下代码实现从本地上传一个文件到服务器，如果要实现下载，对换以下流就可以了
				OutputStream outstream = sftp.put("1.txt");
				InputStream instream = new FileInputStream(new File("c:/print.txt"));
				
				byte b[] = new byte[1024];
				int n;
			    while ((n = instream.read(b)) != -1) {
			    	outstream.write(b, 0, n);
			    }
			    
			    outstream.flush();
			    outstream.close();
			    instream.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.disconnect();
				channel.disconnect();
			}
		}
	 public static char ToSBC(char input) {
		 String res="";
		 String res1="";
         //char c[] = input.toCharArray();

           if (input == ' ') {
        	   input = '\u3000';
           } else if (input < '\177') {
        	   input = (char) (input + 65248);
           }
         
         return input;
}
	private static boolean isfuhao(char fh){
		//System.out.println("===="+fh);
		String reg="[\\pP‘’“”]";
		String res=String.valueOf(fh);
		//System.out.println("++++++"+res);
		boolean isCract =res.matches(reg);
		//System.out.println("----------"+isCract);
		return isCract;
	}
	private static Document isXmlFile(String file) throws DocumentException, UnsupportedEncodingException {
		Document document = null;
			SAXReader reader = new SAXReader();
			
			//File tempFile = new File("c://t_jgdm_wsyw.xml");
			
			
			InputStream imputStream = new ByteArrayInputStream(file.getBytes());
			//InputStream imputStream = new FileInputStream(tempFile);
			InputStreamReader strInStream = new InputStreamReader(imputStream,
					"gb2312");
			document = reader.read(strInStream);

		return document;
	}
	
}
