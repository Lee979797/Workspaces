package com.lhq.prj.bms.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.IJglxDao;
import com.lhq.prj.bms.po.Jglx;

/**
 * JglxDao.java Create on 2008-9-18 下午08:20:57
 * 
 * 职务管理持久层
 * 
 * Copyright (c) 2012 by MTA.
 * 
 * @author YQ
 * @version 1.0
 */
public class JglxDao extends SqlMapClientDaoSupport implements IJglxDao {

	public Integer deleteById(Integer jglxid) {
		return getSqlMapClientTemplate().delete("Jglx.deleteById", jglxid);
	}

	public List findAll() {
		return getSqlMapClientTemplate().queryForList("Jglx.findAll");
	}
	
	public int findByCount(Page page) {
		return (Integer) getSqlMapClientTemplate().queryForObject("Jglx.findByCount", page);
	}

	public List findByPage(Page page) {
		return getSqlMapClientTemplate().queryForList("Jglx.findByPage", page);
	}

	public List findByPjglx(String pjglx) {
		return getSqlMapClientTemplate().queryForList("Jglx.findByPjglx", pjglx);
	}
	
	public Object saveJglx(Jglx jglx) {
		return getSqlMapClientTemplate().insert("Jglx.save", jglx);
	}

	public Integer update(Jglx jglx) throws Exception {
		return getSqlMapClientTemplate().update("Jglx.update", jglx);
	}
	public String findByJglxdm(String jglxdm) {
		// TODO Auto-generated method stub
		return (String) getSqlMapClientTemplate().queryForObject("Jglx.findByJglxdm",jglxdm);
	}
}
