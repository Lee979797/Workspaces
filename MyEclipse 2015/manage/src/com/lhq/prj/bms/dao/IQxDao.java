package com.lhq.prj.bms.dao;

import java.util.List;

import com.lhq.prj.bms.po.Qx;

public interface IQxDao {

	void deleteByBzjgCode(Qx qx);

	int saveQxSet(Qx qx);

	List findByBzjgCode(Qx qx);

}
