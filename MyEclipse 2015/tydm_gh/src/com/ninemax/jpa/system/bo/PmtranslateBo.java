package com.ninemax.jpa.system.bo;

import com.ninemax.jpa.system.dao.PmtranslateDAO;
import com.ninemax.jpa.system.model.Pmtranslate;

import java.util.HashMap;
import java.util.List;

public class PmtranslateBo {
	
private PmtranslateDAO pmtranslateDAO = new PmtranslateDAO();
	
	public List<Pmtranslate> findAll() {
		return pmtranslateDAO.findAll();
	}
	
	public boolean save(Pmtranslate Pmtranslate){
		return pmtranslateDAO.save(Pmtranslate);
	}
	public boolean update(Pmtranslate Pmtranslate){
		return pmtranslateDAO.update(Pmtranslate);
	}
	public boolean delete(Pmtranslate Pmtranslate){
		return pmtranslateDAO.delete(Pmtranslate);
	}
	public Pmtranslate findById(int id){
		return pmtranslateDAO.findById(id);
	}
	
	/**
	 * 操作结果提示中文
	 * @return
	 */
	public HashMap GetPMS()  {
		HashMap hash = new HashMap();
		List<Pmtranslate> pmtranslates = pmtranslateDAO.findAll();
		for(Pmtranslate p: pmtranslates){
			hash.put(p.getEnName(), p.getCnName());
		}
		return hash;
	}
	
	

}
