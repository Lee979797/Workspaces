package com.ninemax.jpa.code.bus;

import com.ninemax.jpa.code.dao.TFzdmDAO;
import com.ninemax.jpa.code.model.TFzdm;
import com.ninemax.jpa.code.model.TFzdmBs;
import com.ninemax.jpa.code.model.TJgdmBs;
import com.ninemax.jpa.global.CheckEntityManagerHelper;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.system.model.User;
import com.ninemax.jpa.util.clsPageComponent;
import com.ninemax.jpa.util.clsStringTool;
import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-5-21
 * Time: 下午2:06
 */
public class TFzdmBus {

    private static Logger log = Logger
                .getLogger(TFzdmBus.class);


    private TFzdmDAO dao = new TFzdmDAO();
    private HandleBus handleBus = new HandleBus();

    public boolean isJgmcAndZchRepeat(String jgmc, String zch, String jgdm) {
        String jpql = "select model from TFzdm model where model.jgmc=:jgmc and model.zch =:zch";
        List<TFzdm> fzdms = dao.findByJgmcAndZch(jgmc, zch);
        if (fzdms == null || fzdms.isEmpty() || (fzdms.size() == 1 && fzdms.get(0).getJgdm().equals(jgdm))) {
            return false;
        } else
            return true;
    }

    public boolean isExit(String jgdm) {
        String jpql = "select model from TFzdm model where model.jgmc=:jgmc and model.zch =:zch";
        List<TFzdm> fzdms = dao.findByProperty("jgdm", jgdm);
        if (fzdms == null || fzdms.isEmpty()) {
            return false;
        } else
            return true;
    }


    /**
     * 判断机构代码是否存在注销库
     *
     * @param jgdm
     * @return
     * @author zx
     */
    public boolean isExitJgdm(String jgdm) {
        String jpql = "select model from TFzdm model where model.jgmc=:jgmc";
        List<TFzdm> fzdms = dao.findByProperty("jgdm", jgdm);
        if (fzdms == null || fzdms.isEmpty()) {
            return false;
        } else
            return true;
    }

    /**
     * 判断统一代码是否存在注销库
     *
     * @param tydm
     * @return
     * @author zx
     */
    public boolean isExitTydm(String tydm) {
        String jpql = "select model from TFzdm model where model.jgmc=:jgmc";
        List<TFzdm> fzdms = dao.findByProperty("tyshxydm", tydm);
        if (fzdms == null || fzdms.isEmpty()) {
            return false;
        } else
            return true;
    }
    
    
    /**
     * 判断是否存在机构名称
     * @param codeName
     * @param jgdm
     * @return
     */
    public boolean isExistCodeName(String codeName, String jgdm) {
        List<TFzdm> list = dao.findByProperty("jgmc", codeName);
        jgdm=jgdm.length()==18?jgdm.substring(8,17):jgdm;
        if (list == null || list.isEmpty() || (list.size() == 1 && list.get(0).getJgdm().equals(jgdm))) {
            return false;
        } else
            return true;
    }
    
    /**
     * BS 库
     * LP
     * 2016-4-6
     * @param codeName
     * @param jgdm
     * @return
     * Version @1.0
     */
    public boolean isExistCodeNameBs(String codeName, String jgdm) {
    	List<TFzdmBs> list = dao.findByPropertyBs("jgmc", codeName);
    	jgdm=jgdm.length()==18?jgdm.substring(8,17):jgdm;
    	if (list == null || list.isEmpty() || (list.size() == 1 && list.get(0).getJgdm().equals(jgdm))) {
    		return false;
    	} else
    		return true;
    }

    /**
     * 根据注册号查询列表
     *
     * @param zch
     * @return
     */
    public List<TFzdm> isExistZch(String zch, String jglx) {
        Map<String, Object> params = new HashedMap();
        params.put("zch", zch);
        //params.put("jglx", jglx);
        return dao.findByPropertys(params);

    }
    /**
     * 根据机构代码 办证机构代码获取注销代码
     *
     * @param jgdm
     * @param bzjgdm
     * @return
     */
    public TFzdm getFzdm(String jgdm, String bzjgdm) {
        Map<String, Object> map = new HashMap();
        map.put("jgdm", jgdm);
        map.put("bzjgdm", bzjgdm);
        List<TFzdm> list = dao.findByPropertys(map);
        if (list != null && list.size() > 0) {
            return list.get(0);
        } else
            return null;
    }

    public List<TFzdm> listFzTjgdm(User user,Map<String, String> params, Integer pageno, Integer rowNumsView, clsPageComponent pages,String orderbyColum,String orderbyMethod) {
        List<TFzdm> list = null;
        try {
            String cond = handleBus.sql(user);
            String jql = "from TFzdm model where "+cond;
            List<Object> pms = new ArrayList();
            if (params != null && params.size() > 0) {
                for (Map.Entry<String, String> param : params.entrySet()) {
                    String key = param.getKey();
                    String value = param.getValue();
                    if ("jgmc".equals(key)) {
                        value = "%" + value + "%";
                        jql += " and " + key + " like ?";
                    } else
                        jql += " and " + key + " = ?";
                    pms.add(value);
                }
            }
            String orderByContent="";
            if (!clsStringTool.isEmpty(orderbyColum)
                    && !clsStringTool.isEmpty(orderbyMethod)) {
                orderByContent =orderbyColum + " "+ orderbyMethod;
            } else {
                orderByContent = " model.fzrq desc";
            }
            jql += " order by "+ orderByContent;
            list = dao.listFzTjgdm(jql, pageno, rowNumsView, pages, pms);
        } catch (Exception e) {
            log.error("TFzdmBus listFzTjgdm error " + e.toString());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return list;
    }

    public TFzdm findById(String id) {
        return dao.findById(id);
    }
    
    public TFzdmBs findByIdBs(String id) {
    	TFzdmBs tfzdm = CheckEntityManagerHelper.getEntityManager().find(TFzdmBs.class, id);
    	CheckEntityManagerHelper.closeEntityManager();
    	
    	return tfzdm;
    }

    public boolean isExistFrdb(String frdb, String jgdm) {
        List<TFzdm> list = dao.findByProperty("fddbr", frdb);
        if (list == null || list.isEmpty() || (list.size() == 1 && list.get(0).getJgdm().equals(jgdm))) {
            return false;
        } else
            return true;
    }

    /**
     * 判断证件号码是否存在
     *
     * @param zjlx
     * @param zjhm
     * @param jgdm
     * @return
     */
    public boolean isExistZjhm(String zjlx,String zjhm, String jgdm,String jglx) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("zjlx",zjlx);
        map.put("zjhm",zjhm);
        List<TFzdm> list = dao.findByPropertys(map,jglx);
        if (list == null || list.isEmpty() || (list.size() == 1 && list.get(0).getJgdm().equals(jgdm))) {
            return false;
        } else
            return true;
    }
    public boolean isExistZjhmBs(String zjlx,String zjhm, String jgdm,String jglx) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("zjlx",zjlx);
        map.put("zjhm",zjhm);
        List<TFzdmBs> list = dao.findByPropertyBs(map,jglx);
        if (list == null || list.isEmpty() || (list.size() == 1 && list.get(0).getJgdm().equals(jgdm))) {
            return false;
        } else
            return true;
    }
}
