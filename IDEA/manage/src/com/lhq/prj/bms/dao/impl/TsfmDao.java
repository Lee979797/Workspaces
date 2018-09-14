package com.lhq.prj.bms.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.ITsfmDao;
import com.lhq.prj.bms.po.Center;
import com.lhq.prj.bms.po.Tsfm;

/**
 * TsfmDao.java Create on 2008-9-16 ����10:43:05
 * 
 * ���ų־ò�ʵ��
 * 
 * Copyright (c) 2008 by MTA.
 * 
 * @author �����
 * @version 1.0
 */
public class TsfmDao extends SqlMapClientDaoSupport implements ITsfmDao {

	public Integer deleteById(Integer tsfmId) {
		return getSqlMapClientTemplate().delete("Tsfm.deleteById", tsfmId);
	}

	public List findAll() {
		return getSqlMapClientTemplate().queryForList("Tsfm.findAll");
	}

	public int findByCount(Page page) {
		return (Integer) getSqlMapClientTemplate().queryForObject("Tsfm.findByCount", page);
	}

	public List findByPage(Page page) {
		return getSqlMapClientTemplate().queryForList("Tsfm.findByPage", page);
	}

	public Object saveTsfm(Tsfm tsfm) {
		return getSqlMapClientTemplate().insert("Tsfm.save", tsfm);
	}

	public Integer update(Tsfm tsfm) throws Exception {
		return getSqlMapClientTemplate().update("Tsfm.update", tsfm);
	}

	public List findTsfmByCenter(Center center) {
		return getSqlMapClientTemplate().queryForList("Tsfm.findTsfmByCenter",center);
	}

}
