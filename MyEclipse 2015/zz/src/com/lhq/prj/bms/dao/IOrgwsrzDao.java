package com.lhq.prj.bms.dao;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Orgwsrz;

public interface IOrgwsrzDao {

	public Object saveOrgwsrz(Orgwsrz orgwsrz);

	public List findByPage(Page page);

	public int findByCount(Page page);
}
