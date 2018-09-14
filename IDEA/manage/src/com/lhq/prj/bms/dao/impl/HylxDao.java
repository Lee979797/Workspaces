package com.lhq.prj.bms.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.IHylxDao;
import com.lhq.prj.bms.po.Hylx;
import com.lhq.prj.bms.po.Jjlx;

/**
 * HylxDao.java Create on 2008-9-18 下午08:20:57
 * 
 * 职务管理持久层
 * 
 * Copyright (c) 2012 by MTA.
 * 
 * @author YQ
 * @version 1.0
 */
public class HylxDao extends SqlMapClientDaoSupport implements IHylxDao {

	public Integer deleteById(Integer hylxid) {
		return getSqlMapClientTemplate().delete("Hylx.deleteById", hylxid);
	}

	public List findAll() {
		return getSqlMapClientTemplate().queryForList("Hylx.findAll");
	}
	
	public int findByCount(Page page) {
		return (Integer) getSqlMapClientTemplate().queryForObject("Hylx.findByCount", page);
	}

	public List findByPage(Page page) {
		return getSqlMapClientTemplate().queryForList("Hylx.findByPage", page);
	}

	public List findByHylx1(String phylx1) {
		return getSqlMapClientTemplate().queryForList("Hylx.findByHylx", phylx1);
	}
	
	public Object saveHylx(Hylx hylx) {
		return getSqlMapClientTemplate().insert("Hylx.save", hylx);
	}

	public Integer update(Hylx hylx) throws Exception {
		return getSqlMapClientTemplate().update("Hylx.update", hylx);
	}
	
	public Hylx findMcByDm(String code) {
		return (Hylx) getSqlMapClientTemplate().queryForObject("Hylx.findMcByDm", code);
	}
}
