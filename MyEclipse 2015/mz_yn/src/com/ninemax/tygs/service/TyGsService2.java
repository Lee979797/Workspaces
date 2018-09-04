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

import flex.messaging.io.ArrayList;


public class TyGsService2 extends TimerTask {
	static Map<String,String> bgsxMap=new HashMap<String,String>();
	static{
		List<TGsbgsx> list=EntityManagerHelper.getEntityManager().createQuery("from TGsbgsx").getResultList();
		for(TGsbgsx bz:list){
			bgsxMap.put( bz.getDm(),bz.getMc());
			
		}
		EntityManagerHelper.getEntityManager().close();
}
	@Override
	public void run() {
		String xml="";
		//File tempFile = new File("");
		InputStream imputStream;
		List<TQybgxx> list=new ArrayList();
		HdService service=new HdService();
		List<TQybgxxxx> bglist=new ArrayList();
		TQybgxx tqyxx=new TQybgxx();
		TQybgxxxx bgxx=new TQybgxxxx();
		String regno="";
		String pid="";
		try {
				//imputStream = new FileInputStream(tempFile);
				xml=service.getbgxx();
				System.out.println("变更接口"+xml);
				if(!"1".equals(xml)&&!"0".equals(xml)){
				//xml=IOUtils.toString(imputStream,"gb2312");
				Document document = isXmlFile(xml);
				TyGsBus bus=new TyGsBus();
			
				Element root = document.getRootElement();
				
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
								   //System.out.println("pripid"+recordEless.getTextTrim());
								   tqyxx.setPripid(recordEless.getTextTrim());
							   }
							   if("regno".equals(regno)){
								   //System.out.println("regno"+recordEless.getTextTrim());
								   tqyxx.setRegno(recordEless.getTextTrim());
							   }
							   if("entName".equals(regno)){
								   //System.out.println("entName"+recordEless.getTextTrim());
								   tqyxx.setEntName(recordEless.getTextTrim());
							   }
 
						   }
						   list.clear();
						   list.add(tqyxx);
						   pid=list.get(0).getRegno();
						   bus.addbgxx(list);
					   }
					  
					   Iterator itersss = recordEle.elementIterator("items");
					   while(itersss.hasNext()){
						   Element recordElesss = (Element) itersss.next();
						   Iterator iterssss = recordElesss.elementIterator("item");
						   while(iterssss.hasNext()){
							   Element recordElessss = (Element) iterssss.next();
							   Iterator itersssss = recordElessss.elementIterator("attribute");
							   while(itersssss.hasNext()){
								   Element recordElesssss = (Element) itersssss.next();
								   regno=recordElesssss.attributeValue("id");
								  
								   if("altitemid".equals(regno)){
									   //System.out.println(recordElesssss.getTextTrim());
									   String bgsx=bgsxMap.get(recordElesssss.getTextTrim());
									  
									   bgxx.setBgsx(bgsx);
								   }
								   if("before".equals(regno)){
									   //System.out.println(recordElesssss.getTextTrim());
									   bgxx.setBefore(recordElesssss.getTextTrim());
								   }
								 
								   if("after".equals(regno)){
									   //System.out.println(recordElesssss.getTextTrim());
									   bgxx.setAfter(recordElesssss.getTextTrim());
								   }
								  
								   bgxx.setPripid(pid);
							   }
							
							   bglist.clear();
							   bglist.add(bgxx);
							   bus.addbgxx_xx(bglist);
						   }
					
					   }
					
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
