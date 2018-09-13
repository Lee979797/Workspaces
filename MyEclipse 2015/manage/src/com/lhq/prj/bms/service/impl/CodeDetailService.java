/*
 * @(#)CodeDetailService.java 2008-10-11
 *
 * Copyright LHQ. All rights reserved.
 */

package com.lhq.prj.bms.service.impl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.ICodeDetailDao;
import com.lhq.prj.bms.po.Tjgdm;
import com.lhq.prj.bms.dao.ITjgdmDao;
import com.lhq.prj.bms.po.CodeDetail;
import com.lhq.prj.bms.po.User;
import com.lhq.prj.bms.dao.IUserDao;
import com.lhq.prj.bms.service.ICodeDetailService;

/**    
 * Create on 2008-10-11 ����07:11:35
 *
 * ͼ��軹��¼ҵ���ʵ����
 *
 * @author �����
 * @version  1.0
 */
public class CodeDetailService implements ICodeDetailService {
	
	private ICodeDetailDao codeDetailDao;
	private IUserDao userDao;
	private ITjgdmDao tjgdmDao;

	public void setCodeDetailDao(ICodeDetailDao codeDetailDao) {
		this.codeDetailDao = codeDetailDao;
	}
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	public void setTjgdmDao(ITjgdmDao tjgdmDao) {
		this.tjgdmDao = tjgdmDao;
	}
	public boolean deleteCodeDetail(String jgdm) {
		Integer flag = codeDetailDao.deleteByJgdm(jgdm);
		if (flag != null) {
			return true;
		}
		return false;
	}

	public Page findByPage(Page page) {
		page.setRoot(codeDetailDao.findByPage(page));
		page.setTotalProperty(codeDetailDao.findByCount(page));
		return page;
	}

	public Object saveCodeDetail(CodeDetail codeDetail) throws Exception {
		Object flag = codeDetailDao.saveCodeDetail(codeDetail);
		if(flag != null){
//			Zssc zssc = new Zssc(codeDetail.getZsscId());
//			zssc.setLogId((Integer)flag);
//			zssc.setCurrentReaderId(codeDetail.getReaderId());
//			zssc.setCurrentReader(codeDetail.getReader());
//			zssc.setState(0);
//			zsscDao.update(zssc);
		}
		return flag;
	}

	public boolean updateCodeDetail(CodeDetail codeDetail) throws Exception {
		 
		Integer codeDetailCount=codeDetailDao.findByJgdm(codeDetail);
		if(codeDetailCount!=0){
			Integer flag = codeDetailDao.update(codeDetail);
			if (null != flag) {
				String zsbhPre=codeDetail.getJgdm().substring(0,8);
				String dmlx=codeDetail.getDmlx();
				User user = new User();
				if (dmlx != "1" && !"1".equals(dmlx)) {
					user.setZsbhPre(zsbhPre);
				}else{
					user.setZsbhPre_fb(zsbhPre);
				}
				user.setUserName(codeDetail.getFumaUsername());
				flag = userDao.updateSet(user);
				return true;
			}
		}
		return false;
	}
	
	public Page findByDmmdPage(Page page) {
		page.setRoot(codeDetailDao.findByDmmdPage(page));
		page.setTotalProperty(codeDetailDao.findByDmmdCount(page));
		return page;
	}
	
	public CodeDetail createCode(CodeDetail codeDetail) {
		return codeDetailDao.createCode(codeDetail);
	}
	
}
 