package com.lhq.prj.bms.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.lhq.prj.bms.dao.IReportDao;
import com.lhq.prj.bms.po.Report;

public class ReportDao extends SqlMapClientDaoSupport implements IReportDao {

	@Override
	public List findByHandleDate(Report report) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("Report.findByHandleDate",report);
	}

	@Override
	public List findXzqhYwReport(Report report) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("Report.findXzqhByBzjgdm",report);
	}

	@Override
	public List findNumByXzqh(Report report) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("Report.findNumByXzqh",report);
	}

}
