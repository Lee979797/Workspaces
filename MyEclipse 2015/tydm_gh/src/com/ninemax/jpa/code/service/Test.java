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

import com.ninemax.tygs.bus.TyGsBus;
import com.ninemax.tygs.model.TQybgxx;
import com.ninemax.tygs.model.TQybgxxxx;

import flex.messaging.io.ArrayList;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String xml="";
		File tempFile = new File("c://tydm//getQydjBgxx.xml");
		InputStream imputStream;
		 List<TQybgxx> list=new ArrayList();
		 List<TQybgxxxx> bglist=new ArrayList();
		 TQybgxx tqyxx=new TQybgxx();
		 TQybgxxxx bgxx=new TQybgxxxx();
		 String regno="";
		 Set<String> files = new HashSet<String>();
		 
	
		try {
			imputStream = new FileInputStream(tempFile);
			xml=IOUtils.toString(imputStream,"gb2312");
			Document document = isXmlFile(xml);

			Element root = document.getRootElement();
			 System.out.println("根节点：" + root.getName()); // 拿到根节点的名称
			  Iterator iter = root.elementIterator("element"); // 获取根节点下的子节点head
		
			  while(iter.hasNext()){
				
				   Element recordEle = (Element) iter.next();
				   Iterator iters = recordEle.elementIterator("attributes");
			
				   while(iters.hasNext()){
					   Element recordEles = (Element) iters.next();
					   Iterator iterss = recordEles.elementIterator("attribute");
				
					   while(iterss.hasNext()){
						  
						
						   Element recordEless = (Element) iterss.next();
						   regno=recordEless.attributeValue("id");
						   if("pripid".equals(regno)){
							   System.out.println("pripid"+recordEless.getTextTrim());
							   tqyxx.setPripid(recordEless.getTextTrim());
						   }
						   if("regno".equals(regno)){
							   System.out.println("regno"+recordEless.getTextTrim());
							 
							   tqyxx.setRegno(recordEless.getTextTrim());
						   }
						   if("entName".equals(regno)){
							   System.out.println("entName"+recordEless.getTextTrim());
							   tqyxx.setEntName(recordEless.getTextTrim());
						   }
						  
						
						 
					
						
						   
					   }
					 
			
				
					   
				   }
				   list.add(tqyxx);
				   list=null;
				   System.out.println("list==="+list.size());
				   
				 /*  for(TQybgxx e:list){
					   System.out.println(e.getRegno());
					   System.out.println(e.getPripid());
					   System.out.println(e.getEntName());
				   }*/
				  /* Iterator itersss = recordEle.elementIterator("items");
				   while(itersss.hasNext()){
					   Element recordElesss = (Element) itersss.next();
					   Iterator iterssss = recordElesss.elementIterator("item");
					   while(iterssss.hasNext()){
						   Element recordElessss = (Element) iterssss.next();
						   Iterator itersssss = recordElessss.elementIterator("attribute");
				
						
							   
						   while(itersssss.hasNext()){
							   Element recordElesssss = (Element) itersssss.next();
							   String sx=recordElesssss.getTextTrim();
							   bgxx.setPripid(list.get(i).getRegno());
							   System.out.println("id="+list.get(i).getRegno());
							   bgxx.setBgsx(sx);
							   bgxx.setBefore(sx);
							   bgxx.setAfter(sx);
							   
						   }
						   
						   bglist.add(bgxx);
						   System.out.println("uuu==="+bglist.size());
					   }
				
				   }
				*/
				
			   }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
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
