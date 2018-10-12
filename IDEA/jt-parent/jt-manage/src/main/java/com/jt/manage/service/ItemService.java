package com.jt.manage.service;

import com.jt.common.vo.EasyUIResult;
import com.jt.manage.pojo.Item;

public interface ItemService {

	EasyUIResult findItemByPage(Integer page, Integer rows);

	String findItemCatName(Long itemCatId);

	int findCount();

	void save(Item item);

}
