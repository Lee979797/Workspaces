package com.lhq.prj.bms.dao;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.IcPrintLog;

public interface IIcPrintLogDao {
	public int saveICKxlh(IcPrintLog icPrintLog);

	public IcPrintLog findByCondition(String ickxlh);

	public int updateICKxlh(IcPrintLog icPrintLog);

	public List findByPage(Page page);

	public int findByCount(Page page);
}
