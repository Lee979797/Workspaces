package com.ninemax.jpa.collection.bo;

import com.ninemax.jpa.system.dao.ForbidwordDAO;
import com.ninemax.jpa.system.model.Forbidword;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForbidwordBo {
	
	
	private ForbidwordDAO forbidworddao = new ForbidwordDAO();
	
	public ForbidwordBo(){}
	
	
	public Forbidword findForbidwordByword(String word)
	{
		
		List<Forbidword> list = forbidworddao.findAll();
		
		Map<String,Forbidword> map = new HashMap<String, Forbidword>();
		
		for(Forbidword fd :list)
		{
			map.put(fd.getForbidWord(), fd);
		}
		
		Forbidword fd = new Forbidword();
		
		fd=map.get(word);
		
		return fd;
		
	}

}
