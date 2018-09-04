package com.ninemax.jpa.system.bo;

import com.ninemax.jpa.system.dao.PoliticalLandscapeDAO;
import com.ninemax.jpa.system.model.PoliticalLandscape;

import java.util.List;

public class PoliticalLandscapeBo {
	private PoliticalLandscapeDAO politicalLandscapeDAO = new PoliticalLandscapeDAO();
	
	public List<PoliticalLandscape> findAll() {
		return politicalLandscapeDAO.findAll();
	}
	public boolean save(PoliticalLandscape PoliticalLandscape){
		return politicalLandscapeDAO.save(PoliticalLandscape);
	}
	public boolean update(PoliticalLandscape PoliticalLandscape){
		return politicalLandscapeDAO.update(PoliticalLandscape);
	}
	public boolean delete(PoliticalLandscape PoliticalLandscape){
		return politicalLandscapeDAO.delete(PoliticalLandscape);
	}
	public PoliticalLandscape findById(int id){
		return politicalLandscapeDAO.findById(id);
	}

}
