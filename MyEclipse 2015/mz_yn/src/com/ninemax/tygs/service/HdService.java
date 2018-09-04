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
        //ʹ��RPC��ʽ����WebService 
		RPCServiceClient serviceClient = null;
		String result="";
		 String value = CommonPropertiesUtil.getValue("common.properties", "hd_gsurl");
		try {
			serviceClient = new RPCServiceClient();
			System.out.println("======");
			Options options = serviceClient.getOptions();
			//ָ������WebService��URL
			EndpointReference targetEPR = new EndpointReference(value);
			options.setTo(targetEPR);
			//ָ��sayHello�����Ĳ���ֵ
			
			Object[] opAddEntryArgs = new Object[] {"szhy"};
			//ָ��sayHello��������ֵ���������͵�Class����
			Class[] classes = new Class[] {String.class};
			//ָ��Ҫ���õ�sayHello������WSDL�ļ��������ռ�
			QName opAddEntry = new QName("http://loushang.ws", "getQydjBgxx");
			//����sayHello����������÷����ķ���ֵ
			result = serviceClient.invokeBlocking(opAddEntry, opAddEntryArgs, classes)[0].toString();
			serviceClient.cleanupTransport();  //Ϊ�˷�ֹ���ӳ�ʱ
			
			
			
			//System.out.println(serviceClient.invokeBlocking(opAddEntry, opAddEntryArgs, classes)[0]);
		} catch (AxisFault e) {
			e.printStackTrace();
		}
		return result;
	}
	public String getfzxx(){
		System.out.println("======");
        //ʹ��RPC��ʽ����WebService 
		RPCServiceClient serviceClient = null;
		String result="";
		 String value = CommonPropertiesUtil.getValue("common.properties", "hd_gsurl");
		try {
			serviceClient = new RPCServiceClient();
			System.out.println("======");
			Options options = serviceClient.getOptions();
			//ָ������WebService��URL
			EndpointReference targetEPR = new EndpointReference(value);
			options.setTo(targetEPR);
			//ָ��sayHello�����Ĳ���ֵ
			
			Object[] opAddEntryArgs = new Object[] {"szhy"};
			//ָ��sayHello��������ֵ���������͵�Class����
			Class[] classes = new Class[] {String.class};
			//ָ��Ҫ���õ�sayHello������WSDL�ļ��������ռ�
			QName opAddEntry = new QName("http://loushang.ws", "getQydjJbxxZx");
			//����sayHello����������÷����ķ���ֵ
			result = serviceClient.invokeBlocking(opAddEntry, opAddEntryArgs, classes)[0].toString();
			serviceClient.cleanupTransport();  //Ϊ�˷�ֹ���ӳ�ʱ
			
			
			
			//System.out.println(serviceClient.invokeBlocking(opAddEntry, opAddEntryArgs, classes)[0]);
		} catch (AxisFault e) {
			e.printStackTrace();
		}
		return result;
	}
	public String tsbgxx(String zch,String ff){
		System.out.println("======");
        //ʹ��RPC��ʽ����WebService 
		RPCServiceClient serviceClient = null;
		String result="";
		String value = CommonPropertiesUtil.getValue("common.properties", "hd_gsurl");
		try {
			serviceClient = new RPCServiceClient();
			System.out.println("======");
			Options options = serviceClient.getOptions();
			//ָ������WebService��URL
			EndpointReference targetEPR = new EndpointReference(value);
			options.setTo(targetEPR);
			//ָ��sayHello�����Ĳ���ֵ
			
			Object[] opAddEntryArgs = new Object[] {"szhy",zch};
			//ָ��sayHello��������ֵ���������͵�Class����
			Class[] classes = new Class[] {String.class};
			//ָ��Ҫ���õ�sayHello������WSDL�ļ��������ռ�
			QName opAddEntry = new QName("http://loushang.ws", ff);
			//����sayHello����������÷����ķ���ֵ
			result = serviceClient.invokeBlocking(opAddEntry, opAddEntryArgs, classes)[0].toString();
			serviceClient.cleanupTransport();  //Ϊ�˷�ֹ���ӳ�ʱ
			
			
			
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
