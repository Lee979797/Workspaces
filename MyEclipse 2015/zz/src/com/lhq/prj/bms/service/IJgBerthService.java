package com.lhq.prj.bms.service;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.JgBerth;

public interface IJgBerthService {

	Page findAllJgBerth(Page page);

	boolean saveJgBerth(JgBerth jb);

	int updateJgBerth(JgBerth jb);

	int findJgBerthByJgmc(JgBerth jb);

	boolean delJgBerth(JgBerth jb);

}
