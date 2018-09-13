package com.lhq.prj.bms.service.impl;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.IJgBerthDao;
import com.lhq.prj.bms.po.JgBerth;
import com.lhq.prj.bms.service.IJgBerthService;

public class JgBerthService implements IJgBerthService{

	private IJgBerthDao jgberthDao;

	public void setJgberthDao(IJgBerthDao jgberthDao) {
		this.jgberthDao = jgberthDao;
	}

	public Page findAllJgBerth(Page page) {
		// TODO Auto-generated method stub
		page.setRoot(jgberthDao.findByPage(page));
		page.setTotalProperty(jgberthDao.findByCount(page));
		return page;
	}
	
	public boolean saveJgBerth(JgBerth jb) {
		// TODO Auto-generated method stub
		boolean flag = false;
		
		if(jgberthDao.saveJgBerth(jb) != null){
			flag = true;
		}
		
		return flag;
	}

	public int updateJgBerth(JgBerth jb) {
		// TODO Auto-generated method stub
		return jgberthDao.updateJgBerth(jb);
	}

	public int findJgBerthByJgmc(JgBerth jb) {
		// TODO Auto-generated method stub
		int id = 0;
		jb = jgberthDao.findJgBerthByJgmc(jb);
		if(jb != null){
			id = jb.getJgid();
		}
		return id;
	}

	public boolean delJgBerth(JgBerth jb) {
		// TODO Auto-generated method stub
		boolean flag = false;
		
		if(jgberthDao.delJgBerth(jb) == 1){
			flag = true;
		}
		
		return flag;
	}

}
