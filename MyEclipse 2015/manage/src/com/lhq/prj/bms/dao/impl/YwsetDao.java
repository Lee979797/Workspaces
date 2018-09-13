package com.lhq.prj.bms.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.IYwsetDao;
import com.lhq.prj.bms.po.Ywset;

/**
 * YwsetDao.java Create on 2008-9-16 ����10:43:05
 * 
 * ���ų־ò�ʵ��
 * 
 * Copyright (c) 2008 by MTA.
 * 
 * @author �����
 * @version 1.0
 */
public class YwsetDao extends SqlMapClientDaoSupport implements IYwsetDao {

	public Integer deleteById(Integer ywsetId) {
		return getSqlMapClientTemplate().delete("Ywset.deleteById", ywsetId);
	}

	public List findAll(Ywset ywset) {
		return getSqlMapClientTemplate().queryForList("Ywset.findAll",ywset);
	}

	public int findByCount(Page page) {
		return (Integer) getSqlMapClientTemplate().queryForObject("Ywset.findByCount", page);
	}

	public List findByPage(Page page) {
		return getSqlMapClientTemplate().queryForList("Ywset.findByPage", page);
	}

	public Object saveYwset(Ywset ywset) {
		return getSqlMapClientTemplate().insert("Ywset.save", ywset);
	}

	public Integer update(Ywset ywset) throws Exception {
		return getSqlMapClientTemplate().update("Ywset.update", ywset);
	}

	public List findYwsetByBzjg(String bzjgdm) {
		return getSqlMapClientTemplate().queryForList("Ywset.findYwsetByBzjg",bzjgdm);
	}
	
	public List findYwsetByNotBzjg(String bzjgdm) {
		return getSqlMapClientTemplate().queryForList("Ywset.findYwsetByNotBzjg",bzjgdm);
	}
}
