/*
 * @(#)ZslyService.java 2008-10-11
 *
 * Copyright LHQ. All rights reserved.
 */

package com.lhq.prj.bms.service.impl;
import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.IZslyDao;
import com.lhq.prj.bms.po.Tjgdm;
import com.lhq.prj.bms.po.Zsly;
import com.lhq.prj.bms.po.User;
import com.lhq.prj.bms.dao.IUserDao;
import com.lhq.prj.bms.service.IZslyService;

/**    
 * Create on 2008-10-11 ����07:11:35
 *
 * ͼ��軹��¼ҵ���ʵ����
 *
 * @author �����
 * @version  1.0
 */
public class ZslyService implements IZslyService {
	
	private IZslyDao zslyDao;
	private IUserDao userDao;

	public void setZslyDao(IZslyDao zslyDao) {
		this.zslyDao = zslyDao;
	}
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public boolean deleteZsly(Integer logId) {
		Integer flag = zslyDao.deleteById(logId);
		if (flag != null) {
			return true;
		}
		return false;
	}

	public Page findByPage(Page page) {
		page.setRoot(zslyDao.findByPage(page));
		page.setTotalProperty(zslyDao.findByCount(page));
		return page;
	}

	public Object saveZsly(Zsly zsly) throws Exception {
		Object flag = zslyDao.saveZsly(zsly);
		if(flag != null){
//			Zssc zssc = new Zssc(zsly.getZsscId());
//			zssc.setLogId((Integer)flag);
//			zssc.setCurrentReaderId(zsly.getReaderId());
//			zssc.setCurrentReader(zsly.getReader());
//			zssc.setState(0);
//			zsscDao.update(zssc);
		}
		return flag;
	}

	public boolean updateZsly(Zsly zsly) throws Exception {
		 
		Integer zslyCount=zslyDao.findByZsbh(zsly);
		if(zslyCount!=0){
			Integer flag = zslyDao.update(zsly);
			if (null != flag) {
				String zsbhPre=zsly.getZsbh().substring(0,8);
				String zslx=zsly.getZslx();
				User user = new User();
				if (zslx != "1" && !"1".equals(zslx)) {
					user.setZsbhPre(zsbhPre);
				}else{
					user.setZsbhPre_fb(zsbhPre);
				}
				user.setUserName(zsly.getCzy());
				flag = userDao.updateSet(user);
				return true;
			}
		}
		return false;
	}

}
 