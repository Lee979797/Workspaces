package com.ninemax.nacao.util;

import com.ninemax.nacao.to.system.clsSystemConfig;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

public class SystemTool {

	/**
	 * 获取当前操作系统名称. return 操作系统名称 例如:windows xp,linux 等.
	 */
	public static String getOSName() {
		return System.getProperty("os.name").toLowerCase();
	}

	/**
	 * 获取unix网卡的mac地址. 非windows的系统默认调用本方法获取.如果有特殊系统请继续扩充新的取mac地址方法.
	 * 
	 * @return mac地址
	 */
	public static String getUnixMACAddress() {
		String mac = null;
		BufferedReader bufferedReader = null;
		Process process = null;
		try {
			process = Runtime.getRuntime().exec("ifconfig eth0");// linux下的命令，一般取eth0作为本地主网卡
																	// 显示信息中包含有mac地址信息
			bufferedReader = new BufferedReader(new InputStreamReader(process
					.getInputStream()));
			String line = null;
			int index = -1;
			while ((line = bufferedReader.readLine()) != null) {
				index = line.toLowerCase().indexOf("hwaddr");// 寻找标示字符串[hwaddr]
				if (index >= 0) {// 找到了
					mac = line.substring(index + "hwaddr".length() + 1).trim();// 取出mac地址并去除2边空格
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
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
	 * 获取widnows网卡的mac地址.
	 * 
	 * @return mac地址
	 */
	public static String getWindowsMACAddress() {
		String mac = null;
		BufferedReader bufferedReader = null;
		Process process = null;
		try {
			process = Runtime.getRuntime().exec("ipconfig /all");// windows下的命令，显示信息中包含有mac地址信息
			bufferedReader = new BufferedReader(new InputStreamReader(process
					.getInputStream()));
			String line = null;
			int index = -1;
			while ((line = bufferedReader.readLine()) != null) {
				index = line.toLowerCase().indexOf("physical address");// 寻找标示字符串[physical address]
				if(index < 0){
					index = line.toLowerCase().indexOf("物理地址");
				}
				if (index >= 0) {// 找到了
					index = line.indexOf(":");// 寻找":"的位置
					if (index >= 0) {
						mac = line.substring(index + 1).trim();// 取出mac地址并去除2边空格
					}
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
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
	 * 获取当前服务端IP
	 */

	public static String getServerIp(){
		InetAddress localhost = null;;
		try {
			localhost = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
		String  ip=localhost.getHostAddress(); 
		System.out.println("服务器端的IP = "+ip);
		return ip;
	}
	/**
	 * 测试用的main方法.
	 * 
	 * @param argc
	 *            运行参数.
	 */
	public static String getServerMac() {
		String os = getOSName();
		System.out.println(os);
		if (os.startsWith("windows")) {
			// 本地是windows
			String mac = getWindowsMACAddress();
			return mac;
		} else {
			// 本地是非windows系统 一般就是unix
			String mac = getUnixMACAddress();
			return mac;
		}
	}
	/**
	 * 该应用是否进行索引
	 * @return
	 */
	public static boolean wheatherIndex(){
		InputStream is;
		String TomcatSerialId="";
		try {
		File file = new File(clsSystemConfig.getTomcatSerialIdPath());
		is = new FileInputStream(file);
		Properties   dbProps   =   new   Properties();    
        dbProps.load(is);
        TomcatSerialId=dbProps.getProperty("tomcatSerialId");
		}catch (Exception e1) {
			TomcatSerialId="web2";
			System.out.println("属性文件没有找到");
		} 
		System.out.println("TomcatSerialId____"+TomcatSerialId);
        if(TomcatSerialId.equals(clsSystemConfig.getTomcatSerialId())){
        	return true;
        }else{
        	return false;
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
