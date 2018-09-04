package com.ninemax.jpa.global;

import java.util.HashMap;

public class ConstantsMsg {
	public static HashMap<String,String> hash = new HashMap<String,String>();
	
	public HashMap<String,String> getMsgmap(){
		hash.put("ok", "操作成功");
		hash.put("no", "操作失败");
		hash.put("fail","操作失败");
		hash.put("idexisting", "该代码已存在");
		hash.put("nameexisting", "该名称已存在");
		hash.put("checknull", "请选择需要审核的条目");
		return hash;
	}
	
	

}
