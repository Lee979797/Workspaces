package com.ninemax.jpa.code.bus;

import com.ninemax.jdbc.dao.clsPageComponent;
import com.ninemax.jpa.code.dao.TGjDAO;
import com.ninemax.jpa.code.model.ScDzzlx;
import com.ninemax.jpa.code.model.ScMz;
import com.ninemax.jpa.code.model.ScWjdyy;
import com.ninemax.jpa.code.model.ScZw;
import com.ninemax.jpa.code.model.ScZzmm;
import com.ninemax.jpa.code.model.TGj;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-5-18
 * Time: ÏÂÎç4:24
 */
public class TGjBus {

    private TGjDAO dao = new TGjDAO();

    public TGj findGjByDm(String dm){
        return dao.findById(dm);
    }

    public Map<String,String> getMap(){
        Map<String,String> hashMap = null;
        List<TGj> list = dao.findAll();
        if(list!=null&&list.size()>0){
            hashMap = new HashMap<String,String>();
            for(TGj gj:list){
                if(gj!=null){
                    hashMap.put(gj.getDm(),gj.getMc());
                }
            }
        }
        return hashMap;
    }   
    public List<TGj> getGjList(){
       
        return dao.findAll();
        
      
    }
    public List<ScZw> getZwList(){
        
        return dao.findAllZw();
        
      
    }
  public List<ScMz> getMzList(){
        
        return dao.findAllMz();
        
      
    }
  public List<ScZzmm> getZzmmList(){
      
      return dao.findAllZzmm();
      
    
  }
  public List<ScDzzlx> getDzzlx(){
      
      return dao.findAllDzzlx();
      
    
  }
  public List<ScWjdyy> getWjdyy(){
      
      return dao.findAllWjdyy();
      
    
  }

    public List<TGj> getListPage(String userInput, int pageSize, int pageNo, clsPageComponent pageComponent) {
        return dao.getListPage(userInput,pageSize,pageNo,pageComponent);
    }
}
