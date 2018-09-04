package com.ninemax.jpa.collection.bo;

import com.ninemax.jpa.collection.dao.FieldsDAO;
import com.ninemax.jpa.collection.model.Fields;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class FieldsBo {

	private FieldsDAO  filedsdao = new FieldsDAO();
	public FieldsBo() {}
	
	public HashMap<String,Fields> getFieldsMapByFieldName() {
		HashMap<String,Fields> map = new HashMap<String,Fields>();
		for(Fields fields:filedsdao.findAll()){
			map.put(String.valueOf(fields.getFieldName()), fields);
		}
		return map;
	}
	
	
	public HashMap<String,Fields> getFieldsMapByFieldCode() {
		HashMap<String,Fields> map = new HashMap<String,Fields>();
		for(Fields fields:filedsdao.findAll()){
			map.put(String.valueOf(fields.getFieldCode().trim()), fields);
		}
		return map;
	}
	
	
	public Fields getFieldsByFieldCode(String fieldcode) {
		
		HashMap<String,Fields> map = new HashMap<String,Fields>();
		for(Fields fields:filedsdao.findAll()){
			map.put(String.valueOf(fields.getFieldCode()), fields);
		}
		return map.get(fieldcode);
	}
	
	public Fields getFieldsByFieldCode1(String filedcode)
	{
		
		List<Fields> list=	filedsdao.findByProperty("fieldCode", filedcode);
		
		if(list.size()>0)
		{
			return list.get(0);
		}
		else
		{
			return null;
		}
		
	}
	

	public List<String> findAllFieldcode()
	{
		List<Fields> flist=	filedsdao.findAll();
		
		List<String> list = new ArrayList<String>();
		
		for(Fields f :flist)
		{
			list.add(f.getFieldCode());
		}

		return list;
	}
	
	
}
