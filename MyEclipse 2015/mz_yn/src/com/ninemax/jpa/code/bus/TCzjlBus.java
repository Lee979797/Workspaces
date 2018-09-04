package com.ninemax.jpa.code.bus;

import com.ninemax.jpa.code.dao.TCzjlDAO;
import com.ninemax.jpa.code.dao.TOperateTypeDAO;
import com.ninemax.jpa.code.model.TCzjl;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.util.DateUtil;
import com.ninemax.jpa.util.clsPageComponent;
import com.ninemax.jpa.util.clsStringTool;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-5-18
 * Time: 下午4:24
 */
public class TCzjlBus {
    private static Logger log = Logger
            .getLogger(TCzjlBus.class);
    private TCzjlDAO dao = new TCzjlDAO();
    private TOperateTypeDAO typeDAO = new TOperateTypeDAO();

    /**
     * 检查机构代码是否做了其他type的业务 
     *
     * @param jgdm
     * @param type
     * @param date
     * @return
     */
    public Boolean checkJGNotDoOtherBus(String jgdm, String type, Date date) {
        List<TCzjl> czjls = dao.findByDmWithDateNotInType(jgdm, date, type);
        if (czjls == null || czjls.isEmpty())
            return true;
        for (int i = 0; i < czjls.size(); i++) {
            TCzjl czjl = czjls.get(i);
            if (typeDAO.findById(czjl.getType().replaceAll("[0\\s]", "")).getMain())
                return false;
        }
        return true;
    }

    /**
     * 获取机构代码日期内做一个业务的次数
     *
     * @param jgdm
     * @param type
     * @param date
     * @return
     */
    public Integer getJGBusTimes(String jgdm, String type, Date date) {
        return dao.findCountByDmWithDateType(jgdm, date, type);
    }

    /**
     * 操作记录查询 
     * @param params
     * @param pageno
     * @param rowNumsView
     * @param pages
     * @return
     */
    public List<TCzjl> listOperRecords(Map<String, String> params, Integer pageno, Integer rowNumsView, clsPageComponent pages,String orderbyColum,String orderbyMethod) {
        List<TCzjl> list = null;
        try {
            String jql = "from TCzjl model where 1=1"; 
            List<Object> pms = new ArrayList();
            if (params != null && params.size() > 0) {
                for (Map.Entry<String, String> param : params.entrySet()) {
                    String key = param.getKey();
                    String value = param.getValue();
                    if("startDate".equals(key)){
                        jql += " and model.date >= '"+value+""+" 00:00:00'";
                    }else if("endDate".equals(key)){
                        jql += " and model.date <= '"+value+""+" 23:59:59'";
                    }else if("bzjgdm".equals(key)){
                    	jql +=" and model.xzqh like '"+value+"%'";
                    }else if("name".equals(key)){
                    	jql +=" and model.name like '%"+value+"%'";
                    }else if("type".equals(key)){
                    	if(value.equals("1")){
                    		jql +=" and model.type in ('1','1A')";
                    	}else{
                    		jql +=" and model.type = '"+value+"'";
                    	}
                    	
                    }else{
                        jql += " and " + key + " = ?";
                        pms.add(value);
                    }
                }
            }
           String orderByContent="";
            if (!clsStringTool.isEmpty(orderbyColum)
                    && !clsStringTool.isEmpty(orderbyMethod)) {
                orderByContent =orderbyColum + " "+ orderbyMethod;
            } else {
                orderByContent = " id desc";
            }
            jql += " order by "+ orderByContent;
            list = dao.listOperRecords(jql, pageno, rowNumsView, pages, pms);
        } catch (Exception e) {
            log.error("TCzjlBus listOperRecords error " + e.toString());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }

        return list;
    }

    /**
     * 操作记录查询
     * @param params
     * @return
     */
    public List<TCzjl> listOperRecords(Map<String, String> params) {
        List<TCzjl> list = null;
        try {
            String jql = "from TCzjl model where 1=1";
            List<Object> pms = new ArrayList();
            if (params != null && params.size() > 0) {
                for (Map.Entry<String, String> param : params.entrySet()) {
                    String key = param.getKey();
                    String value = param.getValue();
                    if("startDate".equals(key)){
                        jql += " and model.date >= '"+value+""+" 00:00:00'";
                    }else if("endDate".equals(key)){
                        jql += " and model.date <= '"+value+""+" 23:59:59'";
                    }else if("bzjgdm".equals(key)){
                    	jql +=" and model.xzqh like '"+value+"%'";
                    }else if("loginName".equals(key)){
                    	jql +=" and model.name = '"+value+"'";
                    }else{
                        jql += " and " + key + " = ?";
                        pms.add(value);
                    }
                }
            }
            jql += " order by id desc ";
            list = dao.listOperRecords(jql,pms);
        } catch (Exception e) {
            log.error("TCzjlBus listOperRecords error " + e.toString());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }

        return list;
    }
}
