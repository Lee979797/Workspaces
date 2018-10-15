package com.jt.manage.controller;

import com.jt.common.vo.EasyUIResult;
import com.jt.common.vo.SysResult;
import com.jt.manage.pojo.Item;
import com.jt.manage.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	
	//同时入库3张表
	//http://localhost:8091/item/query?page=1&rows=20
	@RequestMapping("/query")
	@ResponseBody	//将对象转化为JSON串返回
	public EasyUIResult findItemByPage(Integer page,Integer rows){
		 
		return itemService.findItemByPage(page,rows);
	}
	
	
	/**
	 * 说明:为什么会出现乱码
	 * 原因:是因为@ResponseBody采取的策略不同
	 * 
	 * 如果返回的是对象 那么采用utf-8编码格式 
	 * 如果返回的是String串, 则采用iso-8859-1格式
	 * 
	 * 源码:StringHttpMessageConverter
	 * public static final Charset DEFAULT_CHARSET = Charset.forName("ISO-8859-1");
	 * 
	 * 解决办法:如果采用字符串返回,则使用手动的编码格式
	 * @RequestMapping(value="/cat/queryItemCatName",produces="text/html;charset=utf-8")
	 * 
	 * @param itemCatId
	 * @return
	 */
	//http://localhost:8091/item/cat/queryItemName
	@RequestMapping(value="/cat/queryItemCatName",produces="text/html;charset=utf-8")
	@ResponseBody
	public String findItemCatName(Long itemCatId){

		//根据商品分类ID查询商品分类的名称
		return itemService.findItemCatName(itemCatId);
	}
	
	@RequestMapping("/findCount")
	@ResponseBody
	public int findCount(){
		
		return itemService.findCount();
	}
	
	//item/save
	@RequestMapping("/save")
	@ResponseBody
	public SysResult saveItem(Item item){
		try {
			itemService.save(item);
			return SysResult.oK();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SysResult.build(201,"商品新增失败");
	}
	
	
	
	
	
	
	
	
	
	
	
}
