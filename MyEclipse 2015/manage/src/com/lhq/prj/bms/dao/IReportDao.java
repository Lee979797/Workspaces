package com.lhq.prj.bms.dao;

import java.util.List;

import com.lhq.prj.bms.po.Report;

public interface IReportDao {

	List findByHandleDate(Report report);

	List findXzqhYwReport(Report report);

	List findNumByXzqh(Report report);

}
