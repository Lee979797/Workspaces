package com.lhq.prj.bms.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.IDictDetailDao;
import com.lhq.prj.bms.po.DictDetail;
import com.lhq.prj.bms.po.DictIndex;

/**    
 * CategoryDao.java Create on 2008-9-21 ����04:26:45   
 *
 * �������־ò�ʵ��
 *
 * Copyright (c) 2008 by MTA.
 *
 * @author �����
 * @version 1.0  
 */
public class DictDetailDao extends SqlMapClientDaoSupport implements IDictDetailDao {

	public Integer deleteById(Integer categoryId) {
		return getSqlMapClientTemplate().delete("DictDetail.deleteById", categoryId);
	}

	public List findAll() {
		return getSqlMapClientTemplate().queryForList("DictDetail.findAll");
	}

	public int findByCount(Page page) {
		return (Integer) getSqlMapClientTemplate().queryForObject("DictDetail.findByCount", page);
	}

	public List findByPage(Page page) {
		return getSqlMapClientTemplate().queryForList("DictDetail.findByPage", page);
	}

	public Object saveDictDetail(DictDetail dictDetail) {
		return getSqlMapClientTemplate().insert("DictDetail.save", dictDetail);
	}

	public Integer update(DictDetail dictDetail) throws Exception {
		return getSqlMapClientTemplate().update("DictDetail.update", dictDetail);
	}

	public List findDictDetailByDictIndex(DictIndex dictIndex) {
		return getSqlMapClientTemplate().queryForList("DictDetail.findCategoryBySubject",dictIndex);
	}

	public List findAllBySubjectid(Integer subjectId ) {
		return getSqlMapClientTemplate().queryForList("DictDetail.findAllBySubjectid",subjectId);
	}
	
	public List findByCategoryid(Integer categoryId ) {
		return getSqlMapClientTemplate().queryForList("DictDetail.findByCategoryid",categoryId);
	}
}
 