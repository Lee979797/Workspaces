package com.ninemax.jpa.code.bus;

import com.ninemax.jdbc.dao.clsPageComponent;
import com.ninemax.jpa.code.dao.TNjjhyDAO;
import com.ninemax.jpa.code.model.TNNJjhy;
import com.ninemax.jpa.code.model.TNjjhy;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-5-20
 * Time: ÏÂÎç1:51
 */
public class TNjjhyBus {

    private TNjjhyDAO njjhyDAO = new TNjjhyDAO();

    public List<TNjjhy> getListPage(String mc,int pageSize, int pageNo, clsPageComponent pageComponent) {
        return njjhyDAO.getListPage(mc,pageSize,pageNo,pageComponent);
    }

    public List<TNNJjhy> get2k1ListPage(String mc,int pageSize, int pageNo, clsPageComponent pageComponent) {
        return njjhyDAO.getTKOListPage(mc, pageSize, pageNo, pageComponent);
    }

    public Map<String,String> getMap(){
        Map<String,String> hashMap = null;
        List<TNjjhy> list = njjhyDAO.findAll();
        if(list!=null&&list.size()>0){
            hashMap = new TreeMap<String, String>(
                    new Comparator<String>() {
                        public int compare(String obj1, String obj2) {

                            if(obj1==null)
                                return -1;
                            return obj1.compareTo(obj2);
                        }
                    });
            for(TNjjhy tNjjhy:list){
                if(tNjjhy!=null){
                    hashMap.put(tNjjhy.getDm(),tNjjhy.getMc());
                }
            }
        }
        return hashMap;
    }
    public Map<String,String> getBigMap(){
        Map<String,String> hashMap = null;
        List<TNjjhy> list = njjhyDAO.findBigAll();
        if(list!=null&&list.size()>0){
            hashMap = new TreeMap<String, String>(
                    new Comparator<String>() {
                        public int compare(String obj1, String obj2) {

                            if(obj1==null)
                                return -1;
                            return obj1.compareTo(obj2);
                        }
                    });
            for(TNjjhy tNjjhy:list){
                if(tNjjhy!=null){
                    hashMap.put(tNjjhy.getDm(),tNjjhy.getMc());
                }
            }
        }
        return hashMap;
    }

    public Map<String,String> get2k1Map(){
        Map<String,String> hashMap = null;
        List<TNNJjhy> list = njjhyDAO.find2k1All();
        if(list!=null&&list.size()>0){
            hashMap = new TreeMap<String, String>(
                    new Comparator<String>() {
                        public int compare(String obj1, String obj2) {

                            if(obj1==null)
                                return -1;
                            return obj1.compareTo(obj2);
                        }
                    });
            for(TNNJjhy tNjjhy:list){
                if(tNjjhy!=null){
                    hashMap.put(tNjjhy.getDm(),tNjjhy.getMc());
                }
            }
        }
        return hashMap;
    }
    
    public Map<String,TNNJjhy> get2k1Map2(){
    	Map<String,TNNJjhy> hashMap = null;
    	List<TNNJjhy> list = njjhyDAO.find2k1All();
    	if(list!=null&&list.size()>0){
    		hashMap = new TreeMap<String, TNNJjhy>(
    				new Comparator<String>() {
    					public int compare(String obj1, String obj2) {
    						
    						if(obj1==null)
    							return -1;
    						return obj1.compareTo(obj2);
    					}
    				});
    		for(TNNJjhy tNjjhy:list){
    			if(tNjjhy!=null){
    				hashMap.put(tNjjhy.getDm(),tNjjhy);
    			}
    		}
    	}
    	return hashMap;
    }
}
