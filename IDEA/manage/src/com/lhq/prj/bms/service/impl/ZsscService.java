package com.lhq.prj.bms.service.impl;

import java.util.Date;
import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Zsly;
import com.lhq.prj.bms.dao.IZslyDao;
import com.lhq.prj.bms.dao.IZsscDao;
import com.lhq.prj.bms.dao.IZuserDao;
import com.lhq.prj.bms.po.Center;
import com.lhq.prj.bms.po.Ywset;
import com.lhq.prj.bms.po.Zssc;
import com.lhq.prj.bms.po.Zuser;
import com.lhq.prj.bms.service.IZsscService;

/**    
 * ZsscService.java Create on 2008-9-16 ����10:40:48   
 *
 *
 *
 * Copyright (c) 2008 by MTA.
 *
 * @author �����
 * @version 1.0  
 */
public class ZsscService implements IZsscService {
	
	private IZsscDao zsscDao;
	private IZslyDao zslyDao;
	
	public void setZsscDao(IZsscDao zsscDao) {
		this.zsscDao = zsscDao;
	}
	
	public void setZslyDao(IZslyDao zslyDao) {
		this.zslyDao = zslyDao;
	}
	
	public boolean deleteZssc(Integer zsscId) {
		Integer flag = zsscDao.deleteById(zsscId);
		if(flag != null){
			return true;
		}
		return false;
	}

	public List findAll() {
		return zsscDao.findAll();
	}

	public Page findByPage(Page page) {
		page.setRoot(zsscDao.findByPage(page));
		page.setTotalProperty(zsscDao.findByCount(page));
		return page;
	}

	//此处问题，需解决证书资源分配的重复问题
	public Object saveZssc(Zssc zssc) {
		Long qsbh=Long.valueOf(zssc.getQsbh());
		Long jzbh=Long.valueOf(zssc.getJzbh());
		String zslx=zssc.getZstype();
		String ssds=zssc.getNote();//借用note字段传输ssds
		zssc.setNote(null);//借用note字段传输ssds后，清空note
		String ssbzjg=zssc.getFpbzjg();
		Date fpsj=zssc.getLrsj();

		for (Long i=qsbh; i<jzbh+1; i++) {
			Zsly zsly = new Zsly();
			zsly.setZsbh(String.valueOf(i));
			zsly.setZslx(zslx);
			zsly.setSsds(ssds);
			zsly.setSsbzjg(ssbzjg);
			zsly.setFpsj(fpsj);
			zsly.setFlag("0");
			try {
				zslyDao.saveZsly(zsly);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return zsscDao.saveZssc(zssc);
	}

	public boolean updateZssc(Zssc zssc) throws Exception {
		Integer flag = zsscDao.update(zssc);
		if(flag != null){
			return true;
		}
		return false;
	}

	public Page findZsscByCenter(Page page) {
		page.setRoot(zsscDao.findZsscByCenter((Center) page.getConditions().get(0)));
		return page;
	}


}
 