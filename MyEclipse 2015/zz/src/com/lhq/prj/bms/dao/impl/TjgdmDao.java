package com.lhq.prj.bms.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.ITjgdmDao;
import com.lhq.prj.bms.po.Tjgdm;

/**
 * TjgdmDao.java Create on 2012-5-12
 * 
 * 证书管理持久层实现
 * 
 * Copyright (c) 2012 by YQ.
 * @author
 * @version 1.0
 */
public class TjgdmDao extends SqlMapClientDaoSupport implements ITjgdmDao {
	public Integer deleteById(Integer orgid) {
		return getSqlMapClientTemplate().delete("Tjgdm.deleteById", orgid);
	}

	public int findByCount(Page page) {
		return (Integer) getSqlMapClientTemplate().queryForObject("Tjgdm.findByCount", page);
	}

	public List findByPage(Page page) {
		return getSqlMapClientTemplate().queryForList("Tjgdm.findByPage", page);
	}

	public Object saveTjgdm(Tjgdm tjgdm) {
		return getSqlMapClientTemplate().insert("Tjgdm.save", tjgdm);
	}

	public Integer update(Tjgdm tjgdm) throws Exception {
		return getSqlMapClientTemplate().update("Tjgdm.update", tjgdm);
	}

	public Tjgdm findById(Integer orgid) {
		return (Tjgdm) getSqlMapClientTemplate().queryForObject("Tjgdm.findById",orgid);
	}
	
	public Tjgdm findByJgdm(Tjgdm tjgdm) {
		return (Tjgdm) getSqlMapClientTemplate().queryForObject("Tjgdm.findByJgdm",tjgdm);
	}

	public List findConditionsTjgdm(Tjgdm tjgdm) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("Tjgdm.findConditionsTjgdm", tjgdm);
	}

}
