package com.lhq.prj.bms.dao.impl;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.IIcPrintLogDao;
import com.lhq.prj.bms.po.IcPrintLog;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class IcPrintLogDao extends SqlMapClientDaoSupport implements IIcPrintLogDao {

	public int saveICKxlh(IcPrintLog icPrintLog) {
		// TODO Auto-generated method stub
		return (Integer)getSqlMapClientTemplate().insert("IcPrintLog.save", icPrintLog);
	}

	public IcPrintLog findByCondition(String ickxlh) {
		// TODO Auto-generated method stub
		return (IcPrintLog)getSqlMapClientTemplate().queryForObject("IcPrintLog.findByCondition", ickxlh);
	}

	public int updateICKxlh(IcPrintLog icPrintLog) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().update("IcPrintLog.update", icPrintLog);
	}

	public List findByPage(Page page) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("IcPrintLog.findByPage", page);
	}

	public int findByCount(Page page) {
		// TODO Auto-generated method stub
		return (Integer) getSqlMapClientTemplate().queryForObject("IcPrintLog.findByCount", page);
	}
	
}
