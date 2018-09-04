package com.ninemax.jpa.code.bus;

import com.ninemax.jpa.code.dao.*;
import com.ninemax.jpa.code.model.*;
import com.ninemax.jpa.code.model.vo.Wba;
import com.ninemax.jpa.code.model.vo.Wzx;
import com.ninemax.jpa.global.WsbzEntityManagerHelper;
import com.ninemax.jpa.util.BeanUtilsEx;
import com.ninemax.jpa.util.clsStringTool;
import net.sf.cglib.beans.BeanCopier;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.lang.reflect.*;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: liuzy
 * Date: 13-6-13
 * Time: ÉÏÎç11:02
 */
public class WsbzXbBus {

    private static Logger log = Logger.getLogger(WsbzXbBus.class);

    private WsbzXbDAO dao;

    public WsbzXbBus() {
        dao = new WsbzXbDAO();
    }

    public static void main(String[] args) {
        WsbzXbBus w = new WsbzXbBus();
//        w.findByJgdm(null);
        w.findWzx("1");
/*
        List<WXb> list = w.dao.findByProperty("jgdm", "015184383");
        TJgdmSave jgdmSave = new TJgdmSave();
        if (list != null && list.size() > 0) {
            w.jgdmBeanUtil(jgdmSave,list.get(0));
        }
*/

    }

    public TJgdmSave findByJgdm(Map<String,Object> params) {
        List<WXb> list = dao.findByPropertys(params);

        TJgdmSave jgdmSave = null;

        if (list != null && list.size() > 0) {
            jgdmSave = new TJgdmSave();
            jgdmBeanUtil(jgdmSave,list.get(0));
        }
        return jgdmSave;
    }

    private void jgdmBeanUtil(TJgdmSave jgdmSave,WXb wxb){
        Class<TJgdmSave> bsJgdm = (Class<TJgdmSave>) jgdmSave.getClass();
        Class<WXb> wsJgdm = (Class<WXb>) wxb.getClass();

        java.lang.reflect.Field[] field = bsJgdm.getDeclaredFields();
        java.lang.reflect.Field[] field2 = wsJgdm.getDeclaredFields();

        try{
            for (java.lang.reflect.Field f : field) {

                String filed_name = f.getName();
                String filed_form_name = f.getName();
                filed_name = filed_name.substring(0, 1).toUpperCase() + filed_name.substring(1);
                Method method = null;
                boolean isHave = false;
                for (java.lang.reflect.Field f2 : field2) {
                    if (filed_form_name.equals(f2.getName())) {
                        isHave = true;
                        break;
                    }
                }

                if (!filed_name.toLowerCase().equals("serialVersionUID".toLowerCase()) && isHave) {
                    if(f.getType().equals(String.class)){
                        method = wsJgdm.getMethod("get" + filed_name);
                        bsJgdm.getMethod("set"+filed_name,String.class).invoke(jgdmSave,clsStringTool.convertNull(""+method.invoke(wxb)));
                    }else if(f.getType().equals(Integer.class)){
                        method = wsJgdm.getMethod("get" + filed_name);
                        bsJgdm.getMethod("set"+filed_name,Integer.class).invoke(jgdmSave,method.invoke(wxb));
                    }else if(f.getType().equals(Date.class)){
                        method = wsJgdm.getMethod("get" + filed_name);
                        bsJgdm.getMethod("set"+filed_name,Date.class).invoke(jgdmSave,method.invoke(wxb));
                    }else if(f.getType().equals(Double.class)){
                        method = wsJgdm.getMethod("get" + filed_name);
                        bsJgdm.getMethod("set"+filed_name,Double.class).invoke(jgdmSave,method.invoke(wxb));
                    }

                }

            }
        }catch (Exception e){
            log.error(e);
        }

    }

    public TJgdmSave findById(Integer id) {
        TJgdmSave jgdmSave = null;
        WXb xb = dao.findById(id);
        if (xb != null) {
            jgdmSave = new TJgdmSave();
            BeanCopier beanCopier = BeanCopier.create(WXb.class,TJgdmSave.class,false);
            beanCopier.copy(xb,jgdmSave,null);
            jgdmSave.setNnjjhy(xb.getJjhy());
//            jgdmSave.setNnjjhy(xb.getNjjhy());
            jgdmSave.setZgmc(xb.getZgjgmc());
            jgdmSave.setJjhy(null);
            if(jgdmSave.getFksl()!=null && jgdmSave.getFksl()>0){
                jgdmSave.setFkbz("1");
            }else{
                jgdmSave.setFkbz("0");
            }
            String jflyName = new OnlineBus().getJflyName(jgdmSave.getJfly());
            jgdmSave.setJfly(jflyName);
        }
        return jgdmSave;
    }

    public TJgdm findJgdmById(Integer id) {
        TJgdm jgdm = null;
        WXb xb = dao.findById(id);
        if (xb != null) {
            jgdm = new TJgdm();
            BeanCopier beanCopier = BeanCopier.create(WXb.class,TJgdm.class,false);
            beanCopier.copy(xb,jgdm,null);
            jgdm.setNnjjhy(xb.getJjhy());
            jgdm.setZgmc(xb.getZgjgmc());
            jgdm.setJjhy("");

            if(jgdm.getFksl()!=null && jgdm.getFksl()>0){
                jgdm.setFkbz("1");
            }else{
                jgdm.setFkbz("0");
            }
            String jflyName = new OnlineBus().getJflyName(jgdm.getJfly());
            jgdm.setJfly(jflyName);
        }
        return jgdm;
    }

    public void saveWsyw(String jgdm,String jgmc,String ywlx,String zt,String djh){
        String sql = "insert into t_wsyw(jgdm,jgmc,ywlx,zt,lastdate,djh) values('"+jgdm+"','"+jgmc+"','"+ywlx+"','"+zt+"',getdate(),'"+djh+"')";
        dao.queryWsyw(sql);
    }

    public String findWsywDjh(String jgmc,String ywlx){
        String sql = "select djh from t_wsyw where jgmc='"+jgmc+"' and ywlx='"+ywlx+"'";
        return dao.findDjhBySql(sql);
    }

    public boolean isWsyw(String djh,String ywlx){
        String sql = "select count(*) from t_wsyw where djh='"+djh+"' and ywlx='"+ywlx+"'";
        return dao.isWsyw(sql);
    }

    public boolean isWsywByjgmc(String jgmc,String ywlx){
        String sql = "select count(*) from t_wsyw where jgmc='"+jgmc+"' and ywlx='"+ywlx+"'";
        return dao.isWsyw(sql);
    }

    public boolean isWsywByjgdm(String jgdm,String ywlx){
        String sql = "select count(*) from t_wsyw where jgdm='"+jgdm+"' and ywlx='"+ywlx+"'";
        return dao.isWsyw(sql);
    }

    public void delWsyw(String djh,String ywlx){
        String sql = "delete from t_wsyw where djh='"+djh+"' and ywlx='"+ywlx+"'";
        dao.queryWsyw(sql);
    }

    public void delWsywByjgdm(String jgdm,String ywlx){
        String sql = "delete from t_wsyw where jgdm='"+jgdm+"' and ywlx='"+ywlx+"'";
        dao.queryWsyw(sql);
    }

    public void delWsywByjgmc(String jgmc,String ywlx){
        String sql = "delete from t_wsyw where jgmc='"+jgmc+"' and ywlx='"+ywlx+"'";
        dao.queryWsyw(sql);
    }

    public void updateXb(String djh,String zt,String ywlx,TJgdm tj){
        Map<String,Object> params = new HashMap<String, Object>();
        params.put("djh",djh);
        params.put("zt",zt);
        if(!clsStringTool.isEmpty(ywlx)){
            params.put("lb",Integer.parseInt(ywlx));
        }
        List<WXb> xbs = dao.findByPropertys(params);
        if(xbs!=null && xbs.size()>0){
            WXb xb = xbs.get(0);
            if(tj!=null){
                BeanUtilsEx.copyProperties(xb,tj);
                xb.setJjhy(tj.getNnjjhy().trim());
            }
            xb.setZt("4");
            dao.updateXb(xb);
        }

    }

    public void updateXbByjgdm(String jgdm,String zt,String ywlx,TJgdm tj){
        Map<String,Object> params = new HashMap<String, Object>();
        params.put("jgdm",jgdm);
        params.put("zt",zt);
        if(!clsStringTool.isEmpty(ywlx)){
            params.put("lb",Integer.parseInt(ywlx));
        }
        List<WXb> xbs = dao.findByPropertys(params);
        if(xbs!=null && xbs.size()>0){
            WXb xb = xbs.get(0);
            if(tj!=null){
                BeanUtilsEx.copyProperties(xb,tj);
            }
            xb.setZt("4");

            dao.updateXb(xb);
        }

    }

    public void updateXbByjgmc(String jgmc,String zt,String ywlx,TJgdm tj){
        Map<String,Object> params = new HashMap<String, Object>();
        params.put("jgmc",jgmc);
        params.put("zt",zt);
        if(!clsStringTool.isEmpty(ywlx)){
            params.put("lb",Integer.parseInt(ywlx));
        }
        List<WXb> xbs = dao.findByPropertys(params);
        if(xbs!=null && xbs.size()>0){
            WXb xb = xbs.get(0);
            if(tj!=null){
                BeanUtilsEx.copyProperties(xb,tj);
            }
            xb.setZt("4");
            dao.updateXb(xb);
        }

    }

    public void updateFz(String djh){
        String sql = "update w_zx set w_zx_zt='4' where w_zx_djh='"+djh+"'";
        dao.queryWs(sql);
    }

    public void updateFzByjgdm(String jgdm){
       String sql = "update w_zx set w_zx_zt='4' where w_zx_jgdm='"+jgdm+"'";
        dao.queryWs(sql);
    }

    public void updateWgs(String jgdm){
        String sql = "update w_gs set w_gs_zt='4' where w_gs_jgdm = '"+jgdm+"'";
        dao.queryWs(sql);
    }

    public void updateWba(String jgdm){
        String sql = "update w_ba set w_ba_zt='3' where w_ba_jgdm = '"+jgdm+"'";
        dao.queryWs(sql);
    }

    public Wgs findWgs(String id){
        Wgs gs = null;
        EntityManager em = WsbzEntityManagerHelper.getEntityManager();
        try {
            String strsql = "SELECT w_gs_zsdjh,w_gs_gsyj,w_gs_gsyy,w_gs_ic from w_gs where w_gs_id='"+id+"'";
            Query query = em.createNativeQuery(strsql);
            Object[] wgs = (Object[])query.getSingleResult();
            if(wgs!=null){
                gs = new Wgs();
                gs.setZsdjh(""+wgs[0]);
                gs.setGsyj("" + wgs[1]);
                gs.setGsyy("" + wgs[2]);
                gs.setIc(""+wgs[3]);
            }
        } catch (Exception e) {
            log.error(WsbzXbBus.class, e);
        } finally {
            WsbzEntityManagerHelper.closeEntityManager();
        }
        return gs;
    }


    public Wba findWba(String id){
        Wba ba = null;
        EntityManager em = WsbzEntityManagerHelper.getEntityManager();
        try {
            String strsql = "SELECT w_ba_bazfrq,w_ba_barq,w_ba_bayy from w_ba where w_ba_id='"+id+"'";
            Query query = em.createNativeQuery(strsql);
            Object[] wgs = (Object[])query.getSingleResult();
            if(wgs!=null){
                ba = new Wba();
                ba.setBazfrq("" + wgs[0]);
                ba.setBarq("" + wgs[1]);
                ba.setBayy("" + wgs[2]);
            }
        } catch (Exception e) {
            log.error(WsbzXbBus.class, e);
        } finally {
            WsbzEntityManagerHelper.closeEntityManager();
        }
        return ba;
    }

    public Wzx findWzx(String id){
        Wzx gs = null;
        EntityManager em = WsbzEntityManagerHelper.getEntityManager();
        try {
            String strsql = "SELECT w_zx_zxyj,w_zx_zxyy from w_zx where w_zx_id='"+id+"'";

            Query query = em.createNativeQuery(strsql);


            Object[] wgs = (Object[])query.getSingleResult();
            if(wgs!=null){
                gs = new Wzx();
                gs.setZxyj(""+wgs[0]);
                gs.setZxyy("" + wgs[1]);
            }
        } catch (Exception e) {
            log.error(WsbzXbBus.class, e);
        } finally {
            WsbzEntityManagerHelper.closeEntityManager();
        }
        return gs;
    }

}
