package com.lhq.prj.bms.service.impl;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.IDictDetailDao;
import com.lhq.prj.bms.po.DictDetail;
import com.lhq.prj.bms.po.DictIndex;
import com.lhq.prj.bms.po.Jjlx;
import com.lhq.prj.bms.service.IDictDetailService;


public class DictDetailService implements IDictDetailService {

	private IDictDetailDao dictDetailDao;

	public void setDictDetailDao(IDictDetailDao dictDetailDao) {
		this.dictDetailDao = dictDetailDao;
	}

	public boolean deleteDictDetail(Integer deptId) {
		Integer flag = dictDetailDao.deleteById(deptId);
		if (flag != null) {
			return true;
		}
		return false;
	}

	public List findAll() {
		return dictDetailDao.findAll();
	}
	
	public List findAllBySubjectid(Integer subjectId) {
		return dictDetailDao.findAllBySubjectid(subjectId);
	}
	
	public List findByCategoryid(Integer categoryId) {
		return dictDetailDao.findByCategoryid(categoryId);
	}

	public Page findByPage(Page page) {
		page.setRoot(dictDetailDao.findByPage(page));
		page.setTotalProperty(dictDetailDao.findByCount(page));
		return page;
	}

	public Object saveDictDetail(DictDetail dept) {
		return dictDetailDao.saveDictDetail(dept);
	}

	public boolean updateDictDetail(DictDetail dept) throws Exception {
		Integer flag = dictDetailDao.update(dept);
		if (flag != null) {
			return true;
		}
		return false;
	}

	public Page findDictDetailByDictIndex(Page page) {
		page.setRoot(dictDetailDao.findDictDetailByDictIndex((DictIndex) page.getConditions().get(0)));
		return page;
	}
	
	public DictDetail findMcByDm(DictDetail dictDetail) {
		return dictDetailDao.findMcByDm(dictDetail);
	}
}
