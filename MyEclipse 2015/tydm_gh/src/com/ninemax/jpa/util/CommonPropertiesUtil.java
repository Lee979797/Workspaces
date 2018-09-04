package com.ninemax.jpa.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CommonPropertiesUtil {

	public static String getValue(String fileName,String name){
		InputStream in = CommonPropertiesUtil.class.getClassLoader().getResourceAsStream(fileName);
    	Properties p = new Properties();
    	try {
    		   p.load(in);
    		   in.close();
    		  } catch (IOException e) {
    		   System.out.println("===================>�����ļ�:"+fileName+",δ�ҵ�");
    		  }
    		  String value= p.getProperty(name);
    		  p.clear();
   		   if(value==null){
   			   System.out.println("===================>�����ļ�:"+fileName+"��--"+name+"����,δ�ҵ�");   
   		   }
		return value;
	}
}
