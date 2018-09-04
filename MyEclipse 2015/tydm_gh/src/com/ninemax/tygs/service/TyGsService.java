package com.ninemax.tygs.service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;

import javax.persistence.EntityManager;

import org.apache.commons.io.IOUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.tygs.bus.TyGsBus;

import com.ninemax.tygs.model.TGsbgsx;
import com.ninemax.tygs.model.TQybgxx;
import com.ninemax.tygs.model.TQybgxxxx;
import com.ninemax.tygs.model.TQyfzxx;

import flex.messaging.io.ArrayList;


public class TyGsService extends TimerTask {

	@Override
	public void run() {
		String xml="";
		//File tempFile = new File("");
		InputStream imputStream;
		List<TQyfzxx> list=new ArrayList();
		HdService service=new HdService();
		List<TQyfzxx> fzlist=new ArrayList();
		TQyfzxx tqyxx=new TQyfzxx();
	
		String regno="";

		try {
				//imputStream = new FileInputStream(tempFile);
				xml=service.getfzxx();
				System.out.println("注销接口"+xml);
				if(!"1".equals(xml)&&!"0".equals(xml)){
				//xml=IOUtils.toString(imputStream,"gb2312");
				Document document = isXmlFile(xml);
				TyGsBus bus=new TyGsBus();
			
				Element root = document.getRootElement();
				
				  Iterator iter = root.elementIterator("element"); // 获取根节点下的子节点head
			
				   while(iter.hasNext()){
					
					   Element recordEle = (Element) iter.next();
					   Iterator iters = recordEle.elementIterator("attribute");
				
					   while(iters.hasNext()){
						   Element recordEless = (Element) iters.next();
						   regno=recordEless.attributeValue("id");
						   
						   if("regno".equals(regno)){
							   //System.out.println("regno"+recordEless.getTextTrim());
							   tqyxx.setRegno(recordEless.getTextTrim());
						   }
						   if("entName".equals(regno)){
							   // System.out.println("entName"+recordEless.getTextTrim());
							   tqyxx.setEntName(recordEless.getTextTrim());
						   }
					   }
					 	   list.clear();
						   list.add(tqyxx);
						   bus.addfzxx(list);					 
				   }
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
			InputStreamReader strInStream = new InputStreamReader(imputStream,"gb2312");
			document = reader.read(strInStream);
			return document;
	}

}
