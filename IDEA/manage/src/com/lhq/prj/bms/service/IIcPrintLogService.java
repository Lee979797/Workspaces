package com.lhq.prj.bms.service;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.IcPrintLog;

public interface IIcPrintLogService {

	boolean saveICKxlh(IcPrintLog icPrintLog);

	Page findByPage(Page page);

}
