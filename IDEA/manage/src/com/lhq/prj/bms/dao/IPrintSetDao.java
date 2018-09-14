package com.lhq.prj.bms.dao;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.PrintSet;

public interface IPrintSetDao {

	PrintSet findCardPrintSet(String username);

	boolean saveCardPrintSet(String username, PrintSet printset);

}
