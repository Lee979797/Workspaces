package com.ninemax.jpa.code.bus;


import com.ninemax.jdbc.dao.clsPageComponent;
import com.ninemax.jpa.code.dao.TJglxDAO;
import com.ninemax.jpa.code.model.TJglx;
import com.ninemax.jpa.code.model.TNJglx;
import com.ninemax.jpa.code.model.TNNjjlx;
import com.ninemax.jpa.code.model.TNjjhy;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-5-17
 * Time: 下午6:21
 */
public class TJglxBus {

    private TJglxDAO dao = new TJglxDAO();

    public List<TJglx> findAll(){
        return dao.findAll();
    }
  
    
    public List<TJglx> getListPage(String mc,int pageSize, int pageNo, clsPageComponent pageComponent) {
        return dao.getListPage(mc,pageSize,pageNo,pageComponent);
    }

    public List<TNJglx> findNAll(){
        return dao.findNAll();
    }

    public Map<String,String> getMap(){
        Map<String,String> hashMap = null;
        List<TJglx> list = dao.findAll();
        if(list!=null&&list.size()>0){
            hashMap =new TreeMap<String, String>(
                    new Comparator<String>() {
                        public int compare(String obj1, String obj2) {

                            if(obj1==null)
                                return -1;
                            return obj1.compareTo(obj2);
                        }
                    });
            for(TJglx tNjjhy:list){
                if(tNjjhy!=null){
                    hashMap.put(tNjjhy.getDm(),tNjjhy.getMc());
                }
            }
        }
        return hashMap;
    }
    public Map<String,String> getNMap(){
        Map<String,String> hashMap = null;
        List<TNJglx> list = dao.findNAll();
        if(list!=null&&list.size()>0){
            hashMap =new TreeMap<String, String>(
                    new Comparator<String>() {
                        public int compare(String obj1, String obj2) {

                            if(obj1==null)
                                return -1;
                            return obj1.compareTo(obj2);
                        }
                    });
            for(TNJglx tNjjhy:list){
                if(tNjjhy!=null){
                    hashMap.put(tNjjhy.getDm(),tNjjhy.getMc());
                }
            }
        }
        return hashMap;
    }
    /**
     * 根据dm查询机构类型实体
     * @param dm
     * @return
     */
    public TJglx findTjglx(String dm){
        return dao.findById(dm);
    }

}
