package com.ninemax.jpa.system.bo;

import com.ninemax.jpa.system.dao.FieldTypeDAO;
import com.ninemax.jpa.system.model.FieldType;

import java.util.List;

public class FieldTypeBo {
	private FieldTypeDAO fieldTypeDao = new FieldTypeDAO();
	
	public List<FieldType> findAll() {
		return fieldTypeDao.findAll();
	}

}
