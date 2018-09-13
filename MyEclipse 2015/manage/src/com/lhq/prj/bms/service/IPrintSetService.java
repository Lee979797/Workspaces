package com.lhq.prj.bms.service;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.PrintSet;

public interface IPrintSetService {

	PrintSet findCardPrintSet(String username);

	boolean saveCardPrintSet(String username, PrintSet printset);

}
