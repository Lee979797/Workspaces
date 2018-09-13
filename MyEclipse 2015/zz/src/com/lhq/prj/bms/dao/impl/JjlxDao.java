package com.lhq.prj.bms.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.IJjlxDao;
import com.lhq.prj.bms.po.Jjlx;

/**
 * JjlxDao.java Create on 2008-9-18 下午08:20:57
 * 
 * 职务管理持久层
 * 
 * Copyright (c) 2012 by MTA.
 * 
 * @author YQ
 * @version 1.0
 */
public class JjlxDao extends SqlMapClientDaoSupport implements IJjlxDao {

	public Integer deleteById(Integer jjlxid) {
		return getSqlMapClientTemplate().delete("Jjlx.deleteById", jjlxid);
	}

	public List findAll() {
		return getSqlMapClientTemplate().queryForList("Jjlx.findAll");
	}
	
	public int findByCount(Page page) {
		return (Integer) getSqlMapClientTemplate().queryForObject("Jjlx.findByCount", page);
	}

	public List findByPage(Page page) {
		return getSqlMapClientTemplate().queryForList("Jjlx.findByPage", page);
	}

	public List findByPjjlx(String pjjlx) {
		return getSqlMapClientTemplate().queryForList("Jjlx.findByPjjlx", pjjlx);
	}
	
	public Object saveJjlx(Jjlx jjlx) {
		return getSqlMapClientTemplate().insert("Jjlx.save", jjlx);
	}

	public Integer update(Jjlx jjlx) throws Exception {
		return getSqlMapClientTemplate().update("Jjlx.update", jjlx);
	}

	public Jjlx findMcByDm(String code) {
		// TODO Auto-generated method stub
		return (Jjlx) getSqlMapClientTemplate().queryForObject("Jjlx.findMcByDm", code);
	}


}
