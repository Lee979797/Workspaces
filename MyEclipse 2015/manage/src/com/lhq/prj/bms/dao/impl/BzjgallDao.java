package com.lhq.prj.bms.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.IBzjgallDao;
import com.lhq.prj.bms.po.Bzjgall;

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
public class BzjgallDao extends SqlMapClientDaoSupport implements IBzjgallDao {

	public Integer deleteById(Integer bzjgid) {
		return getSqlMapClientTemplate().delete("Bzjgall.deleteById", bzjgid);
	}

	public List findAll() {
		return getSqlMapClientTemplate().queryForList("Bzjgall.findAll");
	}
	
	public int findByCount(Page page) {
		return (Integer) getSqlMapClientTemplate().queryForObject("Bzjgall.findByCount", page);
	}

	public List findByPage(Page page) {
		return getSqlMapClientTemplate().queryForList("Bzjgall.findByPage", page);
	}

	public Object saveBzjgall(Bzjgall bzjgall) {
		return getSqlMapClientTemplate().insert("Bzjgall.save", bzjgall);
	}

	public Integer update(Bzjgall bzjgall) throws Exception {
		return getSqlMapClientTemplate().update("Bzjgall.update", bzjgall);
	}

}
