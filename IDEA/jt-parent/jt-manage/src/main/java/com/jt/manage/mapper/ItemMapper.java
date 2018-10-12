package com.jt.manage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.jt.common.mapper.SysMapper;
import com.jt.manage.pojo.Item;

public interface ItemMapper extends SysMapper<Item>{
	
	
	
	int findItemConunt();
	
	/**
	 * 根据分页实现数据查询
	 * Mybatis中有要求,只能进行单值传递
	 * 如果需要传递多个参数:
	 * 1.将数据封装为对象
	 * 2.将数据封装为Map<k,v>
	 * 3.将数据封装为list/array
	 * @param start
	 * @param rows
	 * @return
	 */
	List<Item> findItemList(@Param("start") int start,
                            @Param("rows") Integer rows);
	
	
	//查询商品分类的名称
	String findItemCatById(Long itemCatId);
	
	
	
	
	
	
	
}
