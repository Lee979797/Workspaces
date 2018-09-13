package com.lhq.prj.bms.service;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Report;

public interface IReportService {

	List findByHandleDate(Report report);

	List findXzqhYwReport(Report report);

}
