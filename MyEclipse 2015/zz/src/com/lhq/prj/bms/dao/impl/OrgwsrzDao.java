package com.lhq.prj.bms.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.IOrgwsrzDao;
import com.lhq.prj.bms.po.Orgwsrz;

public class OrgwsrzDao extends SqlMapClientDaoSupport implements IOrgwsrzDao {

	public Object saveOrgwsrz(Orgwsrz orgwsrz) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().insert("Orgwsrz.save", orgwsrz);
	}

	public List findByPage(Page page) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("Orgwsrz.findByPage", page);
	}

	public int findByCount(Page page) {
		// TODO Auto-generated method stub
		return (Integer) getSqlMapClientTemplate().queryForObject("Orgwsrz.findByCount", page);
	}

}
