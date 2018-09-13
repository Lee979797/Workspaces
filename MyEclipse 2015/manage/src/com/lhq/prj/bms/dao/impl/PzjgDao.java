package com.lhq.prj.bms.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.IPzjgDao;
import com.lhq.prj.bms.po.Pzjg;

/**
 * PzjgDao.java Create on 2008-9-18 下午08:20:57
 * 
 * 职务管理持久层
 * 
 * Copyright (c) 2012 by MTA.
 * 
 * @author YQ
 * @version 1.0
 */
public class PzjgDao extends SqlMapClientDaoSupport implements IPzjgDao {

	public Integer deleteById(Integer pzjgid) {
		return getSqlMapClientTemplate().delete("Pzjg.deleteById", pzjgid);
	}

	public List findAll() {
		return getSqlMapClientTemplate().queryForList("Pzjg.findAll");
	}
	
	public int findByCount(Page page) {
		return (Integer) getSqlMapClientTemplate().queryForObject("Pzjg.findByCount", page);
	}

	public List findByPage(Page page) {
		return getSqlMapClientTemplate().queryForList("Pzjg.findByPage", page);
	}

	public List findByBzjgdm(String bzjgdm) {
		return getSqlMapClientTemplate().queryForList("Pzjg.findByBzjgdm", bzjgdm);
	}
	
	public Object savePzjg(Pzjg pzjg) {
		return getSqlMapClientTemplate().insert("Pzjg.save", pzjg);
	}

	public Integer update(Pzjg pzjg) throws Exception {
		return getSqlMapClientTemplate().update("Pzjg.update", pzjg);
	}
	public Pzjg findMcByDm(Pzjg pzjg) {
		return (Pzjg) getSqlMapClientTemplate().queryForObject("Pzjg.findMcByDm", pzjg);
	}
}
