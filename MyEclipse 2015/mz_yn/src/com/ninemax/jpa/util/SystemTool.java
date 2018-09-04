package com.ninemax.jpa.util;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;


public class SystemTool {
    private static Logger log = Logger.getLogger(SystemTool.class);
	/**
	 * ��ȡ��ǰ����ϵͳ����. return ����ϵͳ���� ����:windows xp,linux ��.
	 */
	public static String getOSName() {
		return System.getProperty("os.name").toLowerCase();
	}

	/**
	 * ��ȡunix������mac��ַ. ��windows��ϵͳĬ�ϵ��ñ�������ȡ.���������ϵͳ����������µ�ȡmac��ַ����.
	 * 
	 * @return mac��ַ
	 */
	public static String getUnixMACAddress() {
		String mac = null;
		BufferedReader bufferedReader = null;
		Process process = null;
		try {
			process = Runtime.getRuntime().exec("ifconfig eth0");// linux�µ����һ��ȡeth0��Ϊ����������
																	// ��ʾ��Ϣ�а�����mac��ַ��Ϣ
			bufferedReader = new BufferedReader(new InputStreamReader(process
					.getInputStream()));
			String line = null;
			int index = -1;
			while ((line = bufferedReader.readLine()) != null) {
				index = line.toLowerCase().indexOf("hwaddr");// Ѱ�ұ�ʾ�ַ���[hwaddr]
				if (index >= 0) {// �ҵ���
					mac = line.substring(index + "hwaddr".length() + 1).trim();// ȡ��mac��ַ��ȥ��2�߿ո�
					break;
				}
			}
		} catch (IOException e) {
			log.error(e);
		} finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			bufferedReader = null;
			process = null;
		}

		return mac;
	}

	/**
	 * ��ȡwidnows������mac��ַ.
	 * 
	 * @return mac��ַ
	 */
	public static String getWindowsMACAddress() {
		String mac = null;
		BufferedReader bufferedReader = null;
		Process process = null;
		try {
			process = Runtime.getRuntime().exec("ipconfig /all");// windows�µ������ʾ��Ϣ�а�����mac��ַ��Ϣ
			bufferedReader = new BufferedReader(new InputStreamReader(process
					.getInputStream()));
			String line = null;
			int index = -1;
			while ((line = bufferedReader.readLine()) != null) {
				index = line.toLowerCase().indexOf("physical address");// Ѱ�ұ�ʾ�ַ���[physical address]
				if(index < 0){
					index = line.toLowerCase().indexOf("�����ַ");
				}
				if (index >= 0) {// �ҵ���
					index = line.indexOf(":");// Ѱ��":"��λ��
					if (index >= 0) {
						mac = line.substring(index + 1).trim();// ȡ��mac��ַ��ȥ��2�߿ո�
					}
					break;
				}
			}
		} catch (IOException e) {
			log.error(e);
		} finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			bufferedReader = null;
			process = null;
		}

		return mac;
	}
	
	/**
	 * ��ȡ��ǰ�����IP
	 */

	public static String getServerIp(){
		InetAddress localhost = null;;
		try {
			localhost = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			log.error(e);
		}   
		String  ip=localhost.getHostAddress(); 
		return ip;
	}
	/**
	 * �����õ�main����.
	 * 
	 * @param argc
	 *            ���в���.
	 */
	public static String getServerMac() {
		String os = getOSName();
		if (os.startsWith("windows")) {
			// ������windows
			String mac = getWindowsMACAddress();
			return mac;
		} else {
			// �����Ƿ�windowsϵͳ һ�����unix
			String mac = getUnixMACAddress();
			return mac;
		}
	}
	
	public static String getClientIp(HttpServletRequest request){
		String ip = request.getHeader("x-forwarded-for");    
		   if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {    
		        ip = request.getHeader("Proxy-Client-IP");    
		   }    
		   if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {    
		       ip = request.getHeader("WL-Proxy-Client-IP");    
		   }    
		   if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {    
		     ip = request.getRemoteAddr();    
		   }    
		   return ip; 
	}

}
