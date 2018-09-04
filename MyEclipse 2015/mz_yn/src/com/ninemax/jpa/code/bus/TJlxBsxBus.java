package com.ninemax.jpa.code.bus;

import com.ninemax.jpa.code.dao.TJlxBsxDAO;
import com.ninemax.jpa.code.model.TJlxBsx;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-9-20
 * Time: ионГ10:44
 */
public class TJlxBsxBus {

    private TJlxBsxDAO dao = new TJlxBsxDAO();

    public String getJglxBsx(){
        String returnValue = "";
        List<TJlxBsx> list = dao.findByProperty("bsx","1");
        if(list!=null&&list.size()>0){
            for(TJlxBsx bsx:list){
                returnValue += bsx.getJglx();
            }
        }
        return returnValue;
    }
}
