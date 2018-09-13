package com.lhq.prj.bms.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.IBzjgDao;
import com.lhq.prj.bms.po.Bzjg;

/**
 * BzjgDao.java Create on 2008-9-18 下午08:20:57
 * 
 * 职务管理持久层
 * 
 * Copyright (c) 2012 by MTA.
 * 
 * @author YQ
 * @version 1.0
 */
public class BzjgDao extends SqlMapClientDaoSupport implements IBzjgDao {

	public Integer deleteById(Integer bzjgid) {
		return getSqlMapClientTemplate().delete("Bzjg.deleteById", bzjgid);
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

	public Bzjg findByBzjgdm(Bzjg bzjg) {
		// TODO Auto-generated method stub
		return (Bzjg) getSqlMapClientTemplate().queryForObject("Bzjg.findByBzjgdm", bzjg);
	}

}
