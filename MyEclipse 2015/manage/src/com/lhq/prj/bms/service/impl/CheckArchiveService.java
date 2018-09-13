package com.lhq.prj.bms.service.impl;

import com.lhq.prj.bms.dao.IOrgnewDao;
import com.lhq.prj.bms.dao.ITjgdmDao;
import com.lhq.prj.bms.po.CheckArchive;
import com.lhq.prj.bms.po.Orgnew;
import com.lhq.prj.bms.po.Tjgdm;
import com.lhq.prj.bms.service.ICheckArchiveService;

public class CheckArchiveService implements ICheckArchiveService {

	private IOrgnewDao orgnewDao;
	private ITjgdmDao tjgdmDao;
	
	
	public CheckArchive checkArchive(Orgnew orgnew) {
		
		Tjgdm tjgdm = new Tjgdm();
		tjgdm.setJgdm(orgnew.getJgdm());
		
		tjgdm = tjgdmDao.findByJgdm(tjgdm);
		orgnew = orgnewDao.findById(orgnew.getOrgid());
		
		CheckArchive ca = new CheckArchive();
		if(orgnew.getYwlx().equals("预赋码")){
			ca.setJglxdmOld("");
		}else{
			ca.setJglxdmOld(orgnew.getJglxdmOld());
		}
		
		//ca.setZchInfo((tjgdm==null||tjgdm.getZch()==null)?true:orgnew.getZch().equals(tjgdm.getZch()));
		if(tjgdm==null || tjgdm.getZch()==null || orgnew.getZch()==null){
			ca.setZchInfo(true);
		}else{
			ca.setZchInfo(orgnew.getZch().equals(tjgdm.getZch()));
		}
		
		if(tjgdm!=null && tjgdm.getFddbr()!=null && tjgdm.getZjhm()!=null){
			if(orgnew.getFddbr().equals(tjgdm.getFddbr())&&orgnew.getZjhm().equals(tjgdm.getZjhm())){
				ca.setFrInfo(true);
			}else{
				ca.setFrInfo(false);
			}
		}else{
			ca.setFrInfo(true);
		}
		
		return ca;
	}

	public void setOrgnewDao(IOrgnewDao orgnewDao) {
		this.orgnewDao = orgnewDao;
	}

	public void setTjgdmDao(ITjgdmDao tjgdmDao) {
		this.tjgdmDao = tjgdmDao;
	}

}
