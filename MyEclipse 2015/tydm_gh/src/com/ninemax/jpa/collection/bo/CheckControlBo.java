package com.ninemax.jpa.collection.bo;

import com.ninemax.jpa.collection.dao.CheckControlDAO;
import com.ninemax.jpa.collection.model.CheckControl;

import java.util.List;

public class CheckControlBo {
	
	
	private CheckControlDAO checkcontroldao = new CheckControlDAO();
	
	public CheckControlBo(){}
	
	public boolean findcheckcontorlBycode(String code)
	{
		
		List<CheckControl> list = checkcontroldao.findByProperty("bzjgdm", code);
		
		if(list.size()>0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

}
