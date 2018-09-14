package com.lhq.prj.bms.service.impl;

import java.util.List;

import com.lhq.prj.bms.dao.IDictIndexDao;
import com.lhq.prj.bms.po.DictIndex;
import com.lhq.prj.bms.service.IDictIndexService;

/**
 * SubjectService.java Create on 2008-9-21 ����03:59:22
 * 
 * ��Ŀ����ҵ��ʵ��
 * 
 * Copyright (c) 2008 by MTA.
 * 
 * @author �����
 * @version 1.0
 */
public class DictIndexService implements IDictIndexService {

	private IDictIndexDao dictIndexDao;

	public void setDictIndexDao(IDictIndexDao dictIndexDao) {
		this.dictIndexDao = dictIndexDao;
	}

	public boolean deleteDictIndex(Integer subjectId) {
		Integer flag = dictIndexDao.deleteById(subjectId);
		if (null != flag) {
			return true;
		}
		return false;
	}

	public List findAll() {
		return dictIndexDao.findAll();
	}

	public Object saveDictIndex(DictIndex dictIndex) {
		return dictIndexDao.saveDictIndex(dictIndex);
	}

	public boolean updateDictIndex(DictIndex dictIndex) throws Exception {
		Integer flag = dictIndexDao.update(dictIndex);
		if (null != flag) {
			return true;
		}
		return false;
	}

}
