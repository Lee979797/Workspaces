package com.ninemax.jpa.system.bo;

import com.ninemax.jpa.system.dao.ForbidLoad;
import com.ninemax.jpa.system.dao.ForbidwordDAO;
import com.ninemax.jpa.system.model.Forbidword;
import com.ninemax.jpa.util.clsPageComponent;
import com.ninemax.jpa.util.clsStringTool;
import org.apache.log4j.Logger;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ForbidwordBo {
	private static Logger log = Logger.getLogger(ForbidwordBo.class);
	private ForbidwordDAO forbidwordDAO = new ForbidwordDAO();

	public List<Forbidword> findAll() {
		return forbidwordDAO.findAll();
	}
	public List<Forbidword> findPageList(String searchField, String searchValue,String orderbyColum,String orderbyMethod,int pageSize,int pageNo,clsPageComponent pageComponent) throws ParseException  {
		return forbidwordDAO.findPageList(searchField, searchValue,orderbyColum,orderbyMethod,pageSize, pageNo, pageComponent);
	}
	public boolean save(Forbidword forbidword){
		return forbidwordDAO.save(forbidword);
	}
	public boolean update(Forbidword forbidword){
		return forbidwordDAO.update(forbidword);
	}
	public boolean delete(Forbidword forbidword){
		return forbidwordDAO.delete(forbidword);
	}
	public Forbidword findById(int id){
		return forbidwordDAO.findById(id);
	}
	
	public boolean isExistForbidWord(String word){
		List<Forbidword> forbidwords = new ArrayList() ;
		try {
			
			forbidwords = forbidwordDAO.getForBidIDByWord(clsStringTool.isEmpty(word)?"":word.trim());
			
		} catch (Exception e) {
			log.error("error", e);
			log.error(e);
		}

		if(forbidwords.size()<1){
			return false;
		}else{
			return true;
		}
		
	}
	
	public static boolean getBadWordsInPost(String content) {
		HashMap hm = ForbidLoad.getInstance().getForbidwordsHm();
		String badWords = "";
		Iterator it = hm.values().iterator();
		content = clsStringTool.clearHtml(content);
		content = content.replaceAll(" ", "");
		content = content.replaceAll("&nbsp;", "");
		while (it.hasNext()) {
			badWords = (String) it.next();
			if (content.indexOf(badWords) != -1) {
	
				return false;
			}
		}
		return true;
	}
	
	public static boolean getBadWords(String content) {
		HashMap hm = ForbidLoad.getInstance().getForbidwordsHm();
		String badWords = "";
		Iterator it = hm.values().iterator();
		//content = clsStringTool.clearHtml(content);
		content = content.replaceAll(" ", "");
		content = content.replaceAll("&nbsp;", "");
		while (it.hasNext()) {
			badWords = (String) it.next();
			if (content.indexOf(badWords) != -1) {

				return false;
			}
		}
		return true;
	}

}
