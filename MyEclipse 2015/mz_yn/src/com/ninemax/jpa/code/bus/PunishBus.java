package com.ninemax.jpa.code.bus;

import com.ninemax.jpa.code.dao.PunishDAO;
import com.ninemax.jpa.code.model.TCfjlb;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.util.clsPageComponent;
import flex.messaging.io.ArrayList;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Liuzy
 * 
 */
public class PunishBus {
    private static Logger log = Logger.getLogger(PunishBus.class);
	private PunishDAO dao;

	public PunishBus() {
		dao = new PunishDAO();
	}

	public List<TCfjlb> findCfList(Map<String,String> params,Integer pageno,Integer rowNumsView,clsPageComponent pages){
		List<TCfjlb> tcs = null;
		try{
			String jql = "from TCfjlb tc where tc.cfbz='0'";
			List<String> pms = new ArrayList();
			tcs = dao.findListbyhql(jql,pageno,rowNumsView,pages,pms);
		}catch (Exception e)
	    {
	    	log.error(e);
	    } finally {
			EntityManagerHelper.closeEntityManager();
		}
		return tcs;
	}

    public String isNewChuFa(String jgdm){
        List<TCfjlb> tcs = null;
		try{
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("cfbz",false);
            map.put("jgdm",jgdm);
			tcs = dao.findByPropertys(map);
            if(tcs!=null&&tcs.size()>0){
                return String.valueOf(tcs.get(0).getId());
            }
		}catch (Exception e)
	    {
	    	log.error(e);
	    } finally {
			EntityManagerHelper.closeEntityManager();
		}
		return "-1";

    }
}
