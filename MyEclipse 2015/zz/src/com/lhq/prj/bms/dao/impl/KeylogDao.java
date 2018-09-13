package com.lhq.prj.bms.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.IKeylogDao;


/**
 * KeyDao.java Create on 2012-5-12
 * 
 * 主键管理持久层实现
 * 
 * Copyright (c) 2012 by YQ.
 * @author
 * @version 1.0
 */

public class KeylogDao extends SqlMapClientDaoSupport implements IKeylogDao {
	
	public List createByKey(Page page) {

	    //执行存储过程maximum
		return getSqlMapClientTemplate().queryForList("Keylog.createByKeylog",page);
		
		//return getSqlMapClientTemplate().queryForList("Keylog.createByKeylog", page);
	}
	
}
