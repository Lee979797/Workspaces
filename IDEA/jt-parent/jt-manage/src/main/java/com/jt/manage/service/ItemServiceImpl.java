package com.jt.manage.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.common.vo.EasyUIResult;
import com.jt.manage.mapper.ItemMapper;
import com.jt.manage.pojo.Item;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemMapper itemMapper;
	
	/**
	 * 1.获取记录总数  2.查询分页数据
	 * 
	 *  select * from tb_item limit 0,20
		select * from tb_item limit 20,20
		select * from tb_item limit 40,20
		
		第N页
		select * from tb_item limit (page-1) * rows,20
	 * 
	 */
	@Override
	public EasyUIResult findItemByPage(Integer page, Integer rows) {
		//查询记录总数
		int total = itemMapper.findItemConunt();
		
		int start = (page - 1) * rows;
		
		List<Item> itemList = itemMapper.findItemList(start,rows);
		
		return new EasyUIResult(total, itemList);
	}

	@Override
	public String findItemCatName(Long itemCatId) {
		
		return itemMapper.findItemCatById(itemCatId);
	}

	@Override
	public int findCount() {
		
		
		return itemMapper.TestfindCount();
	}
	
	/**
	 * 案例:
	 * 	 new Date   表示服务器时间                 时间可能存在差异
	 * 	 now()      表示数据库服务器时间
	 * 	 秒杀业务:
	 	 时间必须统一.要么都使用服务器时间 要么使用数据库时间
	 */
	@Override
	public void save(Item item) {
		//封装完整的数据
		item.setStatus(1); //数据正常
		item.setCreated(new Date());
		item.setUpdated(item.getCreated());
		itemMapper.insert(item);
	}
}
