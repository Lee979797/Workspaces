package com.lhq.prj.bms.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.ICodeManageDao;
import com.lhq.prj.bms.po.Center;
import com.lhq.prj.bms.po.CodeManage;

/**
 * CodeManageDao.java Create on 2008-9-16 ����10:43:05
 * 
 * ���ų־ò�ʵ��
 * 
 * Copyright (c) 2008 by MTA.
 * 
 * @author �����
 * @version 1.0
 */
public class CodeManageDao extends SqlMapClientDaoSupport implements ICodeManageDao {

	public Integer deleteById(Integer codeManageId) {
		return getSqlMapClientTemplate().delete("CodeManage.deleteById", codeManageId);
	}

	public List findAll() {
		return getSqlMapClientTemplate().queryForList("CodeManage.findAll");
	}

	public int findByCount(Page page) {
		return (Integer) getSqlMapClientTemplate().queryForObject("CodeManage.findByCount", page);
	}

	public List findByPage(Page page) {
		return getSqlMapClientTemplate().queryForList("CodeManage.findByPage", page);
	}

	public Object saveCodeManage(CodeManage codeManage) {
		return getSqlMapClientTemplate().insert("CodeManage.save", codeManage);
	}

	public Integer update(CodeManage codeManage) throws Exception {
		return getSqlMapClientTemplate().update("CodeManage.update", codeManage);
	}

	public List findCodeManageByCenter(Center center) {
		return getSqlMapClientTemplate().queryForList("CodeManage.findCodeManageByCenter",center);
	}

}
