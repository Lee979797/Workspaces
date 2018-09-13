package com.lhq.prj.bms.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.lhq.prj.bms.dao.IDictIndexDao;
import com.lhq.prj.bms.po.DictIndex;

/**
 * SubjectDao.java Create on 2008-9-18 ����08:20:57
 * 
 * ��Ŀ����־ò�
 * 
 * Copyright (c) 2008 by MTA.
 * 
 * @author �����
 * @version 1.0
 */
public class DictIndexDao extends SqlMapClientDaoSupport implements IDictIndexDao {

	public Integer deleteById(Integer subjectId) {
		return getSqlMapClientTemplate().delete("DictIndex.deleteById", subjectId);
	}

	public List findAll() {
		return getSqlMapClientTemplate().queryForList("DictIndex.findAll");
	}

	public Object saveDictIndex(DictIndex dictIndex) {
		return getSqlMapClientTemplate().insert("DictIndex.save", dictIndex);
	}

	public Integer update(DictIndex dictIndex) throws Exception {
		return getSqlMapClientTemplate().update("DictIndex.update", dictIndex);
	}

}
