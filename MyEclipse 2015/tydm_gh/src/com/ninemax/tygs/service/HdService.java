package com.ninemax.tygs.service;
import javax.xml.namespace.QName;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

import com.ninemax.jpa.util.CommonPropertiesUtil;

import java.io.*;
public class HdService {

	/**
	 * @param args
	 */
	public String getbgxx(){
		System.out.println("======");
        //使用RPC方式调用WebService 
		RPCServiceClient serviceClient = null;
		String result="";
		 String value = CommonPropertiesUtil.getValue("common.properties", "hd_gsurl");
		try {
			serviceClient = new RPCServiceClient();
			System.out.println("======");
			Options options = serviceClient.getOptions();
			//指定调用WebService的URL
			EndpointReference targetEPR = new EndpointReference(value);
			options.setTo(targetEPR);
			//指定sayHello方法的参数值
			
			Object[] opAddEntryArgs = new Object[] {"szhy"};
			//指定sayHello方法返回值的数据类型的Class对象
			Class[] classes = new Class[] {String.class};
			//指定要调用的sayHello方法及WSDL文件的命名空间
			QName opAddEntry = new QName("http://loushang.ws", "getQydjBgxx");
			//调用sayHello方法并输出该方法的返回值
			result = serviceClient.invokeBlocking(opAddEntry, opAddEntryArgs, classes)[0].toString();
			serviceClient.cleanupTransport();  //为了防止连接超时
			
			
			
			//System.out.println(serviceClient.invokeBlocking(opAddEntry, opAddEntryArgs, classes)[0]);
		} catch (AxisFault e) {
			e.printStackTrace();
		}
		return result;
	}
	public String getfzxx(){
		System.out.println("======");
        //使用RPC方式调用WebService 
		RPCServiceClient serviceClient = null;
		String result="";
		 String value = CommonPropertiesUtil.getValue("common.properties", "hd_gsurl");
		try {
			serviceClient = new RPCServiceClient();
			System.out.println("======");
			Options options = serviceClient.getOptions();
			//指定调用WebService的URL
			EndpointReference targetEPR = new EndpointReference(value);
			options.setTo(targetEPR);
			//指定sayHello方法的参数值
			
			Object[] opAddEntryArgs = new Object[] {"szhy"};
			//指定sayHello方法返回值的数据类型的Class对象
			Class[] classes = new Class[] {String.class};
			//指定要调用的sayHello方法及WSDL文件的命名空间
			QName opAddEntry = new QName("http://loushang.ws", "getQydjJbxxZx");
			//调用sayHello方法并输出该方法的返回值
			result = serviceClient.invokeBlocking(opAddEntry, opAddEntryArgs, classes)[0].toString();
			serviceClient.cleanupTransport();  //为了防止连接超时
			
			
			
			//System.out.println(serviceClient.invokeBlocking(opAddEntry, opAddEntryArgs, classes)[0]);
		} catch (AxisFault e) {
			e.printStackTrace();
		}
		return result;
	}
	public String tsbgxx(String zch,String ff){
		System.out.println("======");
        //使用RPC方式调用WebService 
		RPCServiceClient serviceClient = null;
		String result="";
		String value = CommonPropertiesUtil.getValue("common.properties", "hd_gsurl");
		try {
			serviceClient = new RPCServiceClient();
			System.out.println("======");
			Options options = serviceClient.getOptions();
			//指定调用WebService的URL
			EndpointReference targetEPR = new EndpointReference(value);
			options.setTo(targetEPR);
			//指定sayHello方法的参数值
			
			Object[] opAddEntryArgs = new Object[] {"szhy",zch};
			//指定sayHello方法返回值的数据类型的Class对象
			Class[] classes = new Class[] {String.class};
			//指定要调用的sayHello方法及WSDL文件的命名空间
			QName opAddEntry = new QName("http://loushang.ws", ff);
			//调用sayHello方法并输出该方法的返回值
			result = serviceClient.invokeBlocking(opAddEntry, opAddEntryArgs, classes)[0].toString();
			serviceClient.cleanupTransport();  //为了防止连接超时
			
			
			
			//System.out.println(serviceClient.invokeBlocking(opAddEntry, opAddEntryArgs, classes)[0]);
		} catch (AxisFault e) {
			e.printStackTrace();
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
