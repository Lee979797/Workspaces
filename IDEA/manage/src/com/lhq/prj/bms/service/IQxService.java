package com.lhq.prj.bms.service;

import java.util.List;

import com.lhq.prj.bms.po.Qx;

public interface IQxService {

	boolean saveQxSet(Qx qx);

	void deleteByBzjgCode(Qx qx);

	List findByBzjgCode(Qx qx);

}
