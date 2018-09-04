package com.ninemax.jpa.code.bus;

import com.ninemax.jpa.code.dao.TZsdsDAO;
import com.ninemax.jpa.code.model.TZsds;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.util.clsPageComponent;
import com.ninemax.jpa.util.clsStringTool;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-6-21
 * Time: ÏÂÎç1:50
 */
public class TZsdsBus {
    private static Logger log = Logger.getLogger(TZsdsBus.class);
    private TZsdsDAO dao;

    public TZsdsBus(){
        dao = new TZsdsDAO();
    }

    public List<TZsds> listTZsds(Map<String, String> params, Integer pageno, Integer rowNumsView, clsPageComponent pages,String orderbyColum,String orderbyMethod) {
        List<TZsds> list=null;
		try{
			String jql = " from TZsds model where 1=1";
			List<Object> pms = new ArrayList();
			if(params!=null && params.size()>0){
				for(Map.Entry<String, String> param : params.entrySet()){
					String key = param.getKey();
					String value = param.getValue();
					if(!clsStringTool.isEmpty(value)){
						if(key.equals("jgdm")){
							jql += " and jgdm = ?";
							pms.add(value);
						}
                        if(key.equals("bzjgdm")){
                            jql += " and substring(djh,4,6) = ?";
                            pms.add(value);
                        }
					}
				}
			}
            String orderByContent="";
            if (!clsStringTool.isEmpty(orderbyColum)
                    && !clsStringTool.isEmpty(orderbyMethod)) {
                orderByContent =orderbyColum + " "+ orderbyMethod;
            } else {
                orderByContent = " model.djrq desc";
            }
            jql += " order by "+ orderByContent;
			list = dao.listTZsds(jql,pageno,rowNumsView,pages,pms);
		}catch(Exception e){
			log.error(e);
		} finally {
			EntityManagerHelper.closeEntityManager();
		}

		return list;
    }
}
