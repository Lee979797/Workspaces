package com.ninemax.jpa.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class QueryString {
	
	private StringBuffer query = new StringBuffer();
	
	public QueryString(String name, String value) {
		encode(name, value);
	}
	
	public synchronized void add(String name, String value) {
		query.append('&');
		encode(name, value);
	}
	
	private synchronized void encode(String name, String value) {
		try {
			query.append(URLEncoder.encode(name, "UTF-8"));
			query.append('=');
			query.append(URLEncoder.encode(value, "UTF-8"));
		} catch (UnsupportedEncodingException ex) {
			throw new RuntimeException("Broken VM does not support UTF-8");
		}
	}
	
	public String getQuery() {
		return query.toString();
	}
	
	public String toString() {
		return getQuery();
	}
	

	
	public static String getBase64(String s){
		if(s==null)return null;

		String str = (new BASE64Encoder()).encode(s.getBytes());
		
//		if(str.indexOf("+") != -1){
//			return str.replace("+", "@");
//		}
		return str;
	}

	public static String getFromBase64(String s){
		if(s==null)return null;
//		if(s.indexOf("@") != -1){
//			s.replace("@", "+");
//		}
		BASE64Decoder decoder= new BASE64Decoder();

		try{
			byte[] b= decoder.decodeBuffer(s);
			return new String(b);
		}catch(Exception e){
			return null;
		}
	}

}

