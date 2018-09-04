package com.ninemax.jpa.system.bo;

import com.ninemax.jpa.system.dao.GroupDAO;
import com.ninemax.jpa.system.model.Group;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class GroupBo {
	private GroupDAO groupDAO = new GroupDAO();
	
	public List<Group> findAll() {
		return groupDAO.findAll();
	}
	public HashMap<String,Group> getAllMapBean() {
		HashMap<String,Group> map = new LinkedHashMap<String,Group>();
		for(Group group:groupDAO.findAll()){
			map.put(String.valueOf(group.getGroupId()), group);
		}
		return map;
	}

}
