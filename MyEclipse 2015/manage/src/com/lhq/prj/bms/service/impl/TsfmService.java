package com.lhq.prj.bms.service.impl;

import java.util.Date;
import java.util.List;

import com.lhq.prj.bms.core.CheckCode;
import com.lhq.prj.bms.core.MyUtils;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Tjgdm;
import com.lhq.prj.bms.dao.ITjgdmDao;
import com.lhq.prj.bms.dao.ITsfmDao;
import com.lhq.prj.bms.dao.IZuserDao;
import com.lhq.prj.bms.po.Center;
import com.lhq.prj.bms.po.Ywset;
import com.lhq.prj.bms.po.Tsfm;
import com.lhq.prj.bms.po.Zuser;
import com.lhq.prj.bms.service.ITsfmService;

/**    
 * TsfmService.java Create on 2008-9-16 ����10:40:48   
 *
 *
 *
 * Copyright (c) 2008 by MTA.
 *
 * @author �����
 * @version 1.0  
 */
public class TsfmService implements ITsfmService {
	
	private ITsfmDao tsfmDao;
	private ITjgdmDao tjgdmDao;
	
	public void setTsfmDao(ITsfmDao tsfmDao) {
		this.tsfmDao = tsfmDao;
	}
	
	public void setTjgdmDao(ITjgdmDao tjgdmDao) {
		this.tjgdmDao = tjgdmDao;
	}
	
	public boolean deleteTsfm(Integer tsfmId) {
		Integer flag = tsfmDao.deleteById(tsfmId);
		if(flag != null){
			return true;
		}
		return false;
	}

	public List findAll() {
		return tsfmDao.findAll();
	}

	public Page findByPage(Page page) {
		page.setRoot(tsfmDao.findByPage(page));
		page.setTotalProperty(tsfmDao.findByCount(page));
		return page;
	}

	//此处问题，需解决证书资源分配的重复问题
	public Object saveTsfm(Tsfm tsfm) {
		
		String strCenterid=tsfm.getCenterid();
		String fmlx=tsfm.getFmtype();
		String strMemo="";
		String ywlx = "";
		if("0".equals(fmlx)){
			strMemo="其它部门，特殊赋码";
			ywlx = "预赋码";
		}else{
			strMemo="省间迁入，特殊赋码";
			ywlx = "迁出";
		}
		String fmjgmc=tsfm.getFmjgmc();
		String fmjgdm=tsfm.getFmjgdm();
		String strQsdm=tsfm.getQsdm();
		Integer dmsl=tsfm.getDmsl();
		String userid=String.valueOf(tsfm.getUserid());
		String username=tsfm.getUsername();
		String name=tsfm.getName();
		
		tsfm.setNote(null);//借用note字段传输ssds后，清空note
		String bzjgdm=tsfm.getFpbzjg();
		Date fpsj=tsfm.getLrsj();
		
		int count = tjgdmDao.CheckCodeTjgdm(tsfm);
		if(count >=1){
			return null;
		}

		for (int i=0; i<dmsl; i++) {
			String strJgdm=CheckCode.getCheckCode(CheckCode.mdAddOne(strQsdm, i));
			
			Tjgdm tjgdm = new Tjgdm();
			tjgdm.setCenterid(strCenterid);
			tjgdm.setJgdm(strJgdm);
			tjgdm.setPzjgmc(fmjgmc);
			tjgdm.setPzjgdm(fmjgdm);
			tjgdm.setBzjgdm(bzjgdm);
			tjgdm.setYwlx(ywlx);
			tjgdm.setZbsl(1);
			tjgdm.setDybz("N");
			tjgdm.setHandleUserid(userid);
			tjgdm.setHandleUsername(username);
			tjgdm.setHandleName(name);
			tjgdm.setHandleDate(fpsj);
			tjgdm.setMemo(strMemo);
			tjgdm.setUp_Dflag(1);
			try {
				tjgdmDao.saveTjgdm(tjgdm);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return tsfmDao.saveTsfm(tsfm);
	}

	public boolean updateTsfm(Tsfm tsfm) throws Exception {
		Integer flag = tsfmDao.update(tsfm);
		if(flag != null){
			return true;
		}
		return false;
	}

	public Page findTsfmByCenter(Page page) {
		page.setRoot(tsfmDao.findTsfmByCenter((Center) page.getConditions().get(0)));
		return page;
	}


}
 