package com.lhq.prj.bms.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.IFuncDao;
import com.lhq.prj.bms.po.Func;

/**
 * FuncDao.java Create on 2008-9-18 ����08:20:57
 * 
 * ְ�����־ò�
 * 
 * Copyright (c) 2008 by MTA.
 * 
 * @author �����
 * @version 1.0
 */
public class FuncDao extends SqlMapClientDaoSupport implements IFuncDao {

	public Integer deleteById(Integer funcId) {
		return getSqlMapClientTemplate().delete("Func.deleteById", funcId);
	}

	public List findAll() {
		return getSqlMapClientTemplate().queryForList("Func.findAll");
	}

	public Object saveFunc(Func func) {
		return getSqlMapClientTemplate().insert("Func.save", func);
	}

	public Integer update(Func func) throws Exception {
		return getSqlMapClientTemplate().update("Func.update", func);
	}
	
	public List findByFuncCode(Page page) {
		return getSqlMapClientTemplate().queryForList("Func.findByFuncCode",page);
	}

}
