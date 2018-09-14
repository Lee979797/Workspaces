package com.lhq.prj.bms.service.impl;

import java.util.Date;
import java.util.List;

import com.lhq.prj.bms.core.CheckCode;
import com.lhq.prj.bms.core.MyUtils;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.CodeDetail;
import com.lhq.prj.bms.dao.ICodeDetailDao;
import com.lhq.prj.bms.dao.ICodeManageDao;
import com.lhq.prj.bms.dao.IZuserDao;
import com.lhq.prj.bms.po.Center;
import com.lhq.prj.bms.po.Ywset;
import com.lhq.prj.bms.po.CodeManage;
import com.lhq.prj.bms.po.Zuser;
import com.lhq.prj.bms.service.ICodeManageService;

/**    
 * CodeManageService.java Create on 2008-9-16 ����10:40:48   
 *
 *
 *
 * Copyright (c) 2008 by MTA.
 *
 * @author �����
 * @version 1.0  
 */
public class CodeManageService implements ICodeManageService {
	
	private ICodeManageDao codeManageDao;
	private ICodeDetailDao codeDetailDao;
	
	public void setCodeManageDao(ICodeManageDao codeManageDao) {
		this.codeManageDao = codeManageDao;
	}
	
	public void setCodeDetailDao(ICodeDetailDao codeDetailDao) {
		this.codeDetailDao = codeDetailDao;
	}
	
	public boolean deleteCodeManage(Integer codeManageId) {
		Integer flag = codeManageDao.deleteById(codeManageId);
		if(flag != null){
			return true;
		}
		return false;
	}

	public List findAll() {
		return codeManageDao.findAll();
	}

	public Page findByPage(Page page) {
		page.setRoot(codeManageDao.findByPage(page));
		page.setTotalProperty(codeManageDao.findByCount(page));
		return page;
	}

	//此处问题，需解决证书资源分配的重复问题
	public Object saveCodeManage(CodeManage codeManage) {
		
		String strCenterid=codeManage.getCenterid();
		String fmlx=codeManage.getFmtype();
		String fmjgmc=codeManage.getFmjgmc();
		String fmjgdm=codeManage.getFmjgdm();
		String strQsdm=codeManage.getQsdm();
		Integer dmsl=codeManage.getDmsl();
		String userid=String.valueOf(codeManage.getUserid());
		String username=codeManage.getUsername();
		String name=codeManage.getName();
		
		codeManage.setNote(null);//借用note字段传输ssds后，清空note
		String bzjgdm=codeManage.getFpbzjg();
		Date fpsj=codeManage.getLrsj();

		for (int i=0; i<dmsl; i++) {
			String strJgdm=CheckCode.getCheckCode(CheckCode.mdAddOne(strQsdm, i));;
			CodeDetail codeDetail = new CodeDetail();
			codeDetail.setJgdm(strJgdm);
			codeDetail.setDmlx(fmlx);
			try {
				codeDetailDao.saveCodeDetail(codeDetail);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return codeManageDao.saveCodeManage(codeManage);
	}

	public boolean updateCodeManage(CodeManage codeManage) throws Exception {
		Integer flag = codeManageDao.update(codeManage);
		if(flag != null){
			return true;
		}
		return false;
	}

	public Page findCodeManageByCenter(Page page) {
		page.setRoot(codeManageDao.findCodeManageByCenter((Center) page.getConditions().get(0)));
		return page;
	}


}
 