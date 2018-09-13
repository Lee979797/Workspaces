package com.lhq.prj.bms.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.IBzjgDao;
import com.lhq.prj.bms.po.Center;
import com.lhq.prj.bms.po.Bzjg;

/**
 * BzjgDao.java Create on 2008-9-16 ����10:43:05
 * 
 * ���ų־ò�ʵ��
 * 
 * Copyright (c) 2008 by MTA.
 * 
 * @author �����
 * @version 1.0
 */
public class BzjgDao extends SqlMapClientDaoSupport implements IBzjgDao {

	public Integer deleteById(Integer bzjgId) {
		return getSqlMapClientTemplate().delete("Bzjg.deleteById", bzjgId);
	}

	public List findAll() {
		return getSqlMapClientTemplate().queryForList("Bzjg.findAll");
	}

	public int findByCount(Page page) {
		return (Integer) getSqlMapClientTemplate().queryForObject("Bzjg.findByCount", page);
	}

	public List findByPage(Page page) {
		return getSqlMapClientTemplate().queryForList("Bzjg.findByPage", page);
	}

	public Object saveBzjg(Bzjg bzjg) {
		return getSqlMapClientTemplate().insert("Bzjg.save", bzjg);
	}

	public Integer update(Bzjg bzjg) throws Exception {
		return getSqlMapClientTemplate().update("Bzjg.update", bzjg);
	}

	public List findBzjgByCenter(Center center) {
		return getSqlMapClientTemplate().queryForList("Bzjg.findBzjgByCenter",center);
	}
	
	public Bzjg findByBzjgdm(String bzjgCode) {
		return (Bzjg)getSqlMapClientTemplate().queryForObject("Bzjg.findByBzjgdm", bzjgCode);
	}
}
