package com.lhq.prj.bms.service.impl;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.IPrintSetDao;
import com.lhq.prj.bms.po.PrintSet;
import com.lhq.prj.bms.service.IPrintSetService;

public class PrintSetService implements IPrintSetService {

	private IPrintSetDao printSetDao;
	
	public PrintSet findCardPrintSet(String username) {
		// TODO Auto-generated method stub
		
		return printSetDao.findCardPrintSet(username);
	}

	public void setPrintSetDao(IPrintSetDao printSetDao) {
		this.printSetDao = printSetDao;
	}

	public boolean saveCardPrintSet(String username, PrintSet printset) {
		// TODO Auto-generated method stub
		return printSetDao.saveCardPrintSet(username, printset);
	}


}
