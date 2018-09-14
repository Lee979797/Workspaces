package com.lhq.prj.bms.dao;

import com.lhq.prj.bms.po.LeafHelp;

public interface ILeafHelpDao {

	int findByLeafId(String leafId);

	Object save(LeafHelp lh);

	Integer update(LeafHelp lh);

}
