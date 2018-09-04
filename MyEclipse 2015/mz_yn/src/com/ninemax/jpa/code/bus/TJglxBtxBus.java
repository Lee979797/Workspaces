package com.ninemax.jpa.code.bus;


import com.ninemax.jpa.code.model.OrgTypeMes;
import com.ninemax.jpa.code.model.ScanManage;
import com.ninemax.jpa.code.model.TJglxBsx;
import com.ninemax.jpa.code.model.TSplxType;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.global.InitSysParams;
import com.ninemax.jpa.system.model.ScFields;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-5-17
 * Time: 下午6:21
 */
public class TJglxBtxBus {
    public String getBtx(String jglx) throws RuntimeException {
        if (jglx == null || "".equals(jglx)) {
            return "";
        }
        return InitSysParams.btxs.get(jglx);
    }

    public Map<String, String> getBtxs() throws RuntimeException {
        StringBuilder result = new StringBuilder();
        Map<String, String> map = new HashMap<String, String>();
        String jglx = "";
        try {
            final String sql = "select model from TJglxBsx model order by model.jglx";

            List<TJglxBsx> jglxBsxes = EntityManagerHelper.getEntityManager().createQuery(sql).getResultList();
            for (TJglxBsx bsx : jglxBsxes) {
                if (jglx.equals(bsx.getJglx())) {
                    result.append("#").append(bsx.getBsx().trim()).append(",");
                } else {
                    if (result.length() > 1)
                        map.put(jglx, result.substring(0, result.length() - 1));
                    jglx = bsx.getJglx();
                    result = new StringBuilder();
                    result.append("#").append(bsx.getBsx().trim()).append(",");
                }
            }
            if (result.length() > 1)
                map.put(jglx, result.substring(0, result.length() - 1));
        } catch (Exception e) {
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return map;
    }

    
    public Map<String, String> getOrg() throws RuntimeException {
        StringBuilder result = new StringBuilder();
        Map<String, String> map = new HashMap<String, String>();
        String jglx = "";
        try {
            final String sql = "select model from TJglxBsx model order by model.jglx";

            OrgTypeMes orgType = EntityManagerHelper.getEntityManager().find(OrgTypeMes.class, 1);
            map.put("1", orgType.getOrg1());
            map.put("2", orgType.getOrg2());
            map.put("3", orgType.getOrg3());
            map.put("4", orgType.getOrg4());
            map.put("5", orgType.getOrg5());
            map.put("6", orgType.getOrg6());
            map.put("7", orgType.getOrg7());
            map.put("8", orgType.getOrg8());
            map.put("9", orgType.getOrg9());
            map.put("A", orgType.getOrg10());
            map.put("B", orgType.getOrg11());
            map.put("C", orgType.getOrg12());
        
        } catch (Exception e) {
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return map;
    }

  //前置扫描管理
    public Map<String, String> getfrontZrxzqh() throws RuntimeException {
        StringBuilder result = new StringBuilder();
        Map<String, String> map = new HashMap<String, String>();
        String jglx = "";
        try {
            final String sql = "select model from ScanManage model ";

            List<ScanManage> scanManage = EntityManagerHelper.getEntityManager().createQuery(sql).getResultList();
            for(ScanManage  scan:scanManage){
            	map.put(scan.getXzqh()+"", scan.getStatus());
            }

        } catch (Exception e) {
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return map;
    }
    
    //审核业务类型
    public Map<String, String> getLx() throws RuntimeException {
        StringBuilder result = new StringBuilder();
        Map<String, String> map = new HashMap<String, String>();
        String jglx = "";
        try {
            final String sql = "select model from TSplxType model ";

            List<TSplxType> lxManage = EntityManagerHelper.getEntityManager().createQuery(sql).getResultList();
            for(TSplxType  scan:lxManage){
            	map.put(scan.getSplxdm()+"", scan.getSplxmc());
            }

        } catch (Exception e) {
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return map;
    }
    
    
    
    public String getFieldName(String fieldCode) throws RuntimeException {

        for (ScFields field : InitSysParams.fields) {
            if (fieldCode.trim().equals(field.getFieldCode().trim()))
                return field.getFieldName();
        }
        return "";
    }
}
