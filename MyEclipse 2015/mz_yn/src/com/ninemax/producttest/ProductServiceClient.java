package com.ninemax.producttest;

import java.net.MalformedURLException;
import java.net.URL;

import org.codehaus.xfire.client.Client;

public class ProductServiceClient {

public static void main(String[] args) {
		
		String soapUrl = "http://192.168.12.102:7777/services/JgdmExsistService?wsdl";
		
		try {
			Client client = new Client(new URL(soapUrl));
			client.addOutHandler(new ClientAuthenticationHandler("admin","123456"));
			
			Object [] results = client.invoke("exsistEnterprise",new Object[]{"684651903"});
			String returnXml = results[0].toString();
			
			System.out.println(returnXml);
			
		} catch (MalformedURLException e) { 
			
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();

		}
		
	}
}
