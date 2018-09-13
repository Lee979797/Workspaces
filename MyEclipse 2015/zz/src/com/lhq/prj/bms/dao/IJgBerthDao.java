package com.lhq.prj.bms.dao;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.JgBerth;

public interface IJgBerthDao {

	List findByPage(Page page);

	int findByCount(Page page);

	Object saveJgBerth(JgBerth jb);

	int updateJgBerth(JgBerth jb);

	JgBerth findJgBerthByJgmc(JgBerth jb);

	int delJgBerth(JgBerth jb);

}
