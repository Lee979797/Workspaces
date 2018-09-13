package com.lhq.prj.bms.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.ISfwqpzDao;
import com.lhq.prj.bms.po.Orgnew;
import com.lhq.prj.bms.po.Sfwqpz;

/**
 * SfwqpzDao.java Create on 2012-5-5 
 * 
 * 临时档案 管理持久层实现
 * 
 * Copyright (c) 2012 by YQ.
 * @author
 * @version 1.0
 */
public class SfwqpzDao extends SqlMapClientDaoSupport implements ISfwqpzDao {
	
	public Sfwqpz findByPzname(String PZNAME) {
		return (Sfwqpz) getSqlMapClientTemplate().queryForObject("Sfwqpz.findByPzname",PZNAME);
	}

}
