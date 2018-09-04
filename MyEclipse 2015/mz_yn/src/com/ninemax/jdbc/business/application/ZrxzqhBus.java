package com.ninemax.jdbc.business.application;

import com.ninemax.jdbc.dao.application.ZrxzqhDAO;
import com.ninemax.jdbc.to.system.clsProvinceTO;
import com.ninemax.jpa.util.clsStringTool;

import java.util.List;

public class ZrxzqhBus {

	ZrxzqhDAO xzdao = new ZrxzqhDAO();
	
	public List<clsProvinceTO> getFirstGradeElement(){
		return xzdao.getFatherElements();
	}
	
	public List<clsProvinceTO> getSecondGradeElement(String id){
		if(!clsStringTool.isEmpty(id)){
			String newId = id.substring(0, 2);
			List<clsProvinceTO> resultList = xzdao.getChildElements(newId+"%00", id);
			if(resultList == null || resultList.size() <= 0){
				return this.getCityGradeElement(id);
			}
			return resultList;
		}
		return null;
	}
	
	public List<clsProvinceTO> getThirdGradeElement(String id){
		if(!clsStringTool.isEmpty(id)){
			String newsecondeId = id.substring(0, 2);
			List<clsProvinceTO> resultList = xzdao.getChildElements(newsecondeId+"%00", newsecondeId + "0000");
			if(resultList != null  && resultList.size() >0){
				String newId = id.substring(0, 4);
				return xzdao.getChildElements(newId+"%", id);
			}
		}
		return null;
	}
	
	public List<clsProvinceTO> getCityGradeElement(String id){
		if(!clsStringTool.isEmpty(id)){
			String newId = id.substring(0, 2);
			return xzdao.getChildElements(newId+"%", id);
		}
		return null;
	}
	
	public clsProvinceTO getProById(String id){
		return xzdao.getProById(id);
	}
}
