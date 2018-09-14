package com.lhq.prj.bms.service.impl;

import com.lhq.prj.bms.dao.ILeafHelpDao;
import com.lhq.prj.bms.po.LeafHelp;
import com.lhq.prj.bms.service.ILeafHelpService;

public class LeafHelpService implements ILeafHelpService {
	private ILeafHelpDao leafHelpDao;
	public void setLeafHelpDao(ILeafHelpDao leafHelpDao) {
		this.leafHelpDao = leafHelpDao;
	}


	@Override
	public boolean saveLeafHelp(LeafHelp lh) {
		// TODO Auto-generated method stub
		boolean flag = false;
		int find = leafHelpDao.findByLeafId(lh.getLeafId());
		if(find == 0){
			int i = (Integer)leafHelpDao.save(lh);
			if(i>0){
				flag = true;
			}
		}else{
			int u = leafHelpDao.update(lh);
			if(u>0){
				flag = true;
			}
		}
		return flag;
	}

}
