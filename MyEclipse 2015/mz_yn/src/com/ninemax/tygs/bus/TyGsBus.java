package com.ninemax.tygs.bus;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import net.sf.json.JSONObject;

import com.ninemax.jpa.code.model.TJgdm;
import com.ninemax.jpa.global.InitSysParams;
import com.ninemax.jpa.system.model.User;
import com.ninemax.jpa.util.DateUtil;
import com.ninemax.tygs.action.TyGsAction;
import com.ninemax.tygs.dao.TyGsDao;
import com.ninemax.tygs.model.TQybgxx;
import com.ninemax.tygs.model.TQybgxxxx;
import com.ninemax.tygs.model.TQyfzxx;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.Attribute; 
public class TyGsBus {
	
	private static Logger log = Logger.getLogger(TyGsBus.class);
	
	TyGsDao tygsDao=new TyGsDao();
	
	
	/**
	 * 更新工商状态
	 * 
	 * LP
	 * 2015-5-28
	 * @param id
	 * @return
	 * Version @1.0
	 */
	public boolean  updateStatus(String id){
		return tygsDao.upStatus(id);
	}
	
	public boolean  update(String id){
		return tygsDao.update(id);
	}
	
	public boolean  updatefz(String id){
		return tygsDao.updatefz(id);
	}
	
	/**
	 * 工商推送
	 * LP
	 * 2015-5-30
	 * @param jgdm
	 * Version @1.0
	 */
	public void ts(TJgdm jgdm,User user){
		
	tygsDao.ts(jgdm,user);
	}
	public void addbgxx(List<TQybgxx> list){
		System.out.println("list"+list.size());
		TQybgxx bg=new TQybgxx();
		for(int i=0;i<list.size();i++){
		
	
			bg.setEntName(list.get(i).getEntName());
			bg.setPripid(list.get(i).getPripid());
			bg.setRegno(list.get(i).getRegno());
			bg.setTstime(DateUtil.dateToStr(new Date()));
			bg.setStatus("0");
			tygsDao.add(bg);
		}
		
	}
	public void addbgxx_xx(List<TQybgxxxx> list){
		TQybgxxxx bg=new TQybgxxxx();
		for(int i=0;i<list.size();i++){
			
		
		 bg.setPripid(list.get(0).getPripid());
		 bg.setBgsx(list.get(i).getBgsx());
		 bg.setBefore(list.get(i).getBefore());
		 bg.setAfter(list.get(i).getAfter());
		 bg.setTstime(DateUtil.dateToStr(new Date()));
			tygsDao.add(bg);
		}
	}
	public void addfzxx(List<TQyfzxx> list){
		System.out.println("list"+list.size());
		TQyfzxx fz=new TQyfzxx();
		for(int i=0;i<list.size();i++){
		
	
			fz.setEntName(list.get(i).getEntName());
			
			fz.setRegno(list.get(i).getRegno());
			fz.setTstime(DateUtil.dateToStr(new Date()));
			fz.setStatus("0");
			tygsDao.add(fz);
		}
		
	}
	
}
