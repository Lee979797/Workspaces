/**
 *
 */
package com.ninemax.jpa.code.action;

import com.ninemax.jpa.code.bus.*;
import com.ninemax.jpa.code.model.*;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.global.InitSysParams;
import com.ninemax.jpa.system.model.User;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import java.util.*;

/**
 * @author yanzh
 */
public class BusinessSelectAction extends ActionSupport implements SessionAware {
    private static Logger log = Logger.getLogger(BusinessSelectAction.class);
    private String source;
    private String mc;
    private Boolean filter;
    private String currentPath = "";
    private Map<String, Object> session;

    private Page page;
    private List<Model> dmmcs = null;

    public BusinessSelectAction() {
    }

    public String search() {
        currentPath = "/product/jsp/common/" + "pubSel.jsp";
        return this.SUCCESS;
    }

    public String result() {
    	source=source.replace("t_", "");
        User user = (User) session.get("sysUser");
        dmmcs = new ArrayList<Model>();
        if (page == null) {
            page = new Page();
            page.setPageSize(15);
        }
        if (mc == null) {
            mc = "";
        }
        List<Model> list = new ArrayList<Model>();
        Map<String, String> maps = null;
        if("bgxzqh".equals(source)){
        	 maps = new AjaxBus().get("xzqh", user.getBzjgdm(), filter);
        }else{
        	 maps = new AjaxBus().get(source, user.getBzjgdm(), filter);
        }
        filter = filter == null ? false : filter;

        if(maps==null){
        	maps=new HashMap<String,String>();
        }
        if("nnjjhy".equals(source)){
        	Map<String, TNNJjhy> jjhyMap =InitSysParams.jjhy2k1Map2;
            for (Map.Entry<String, TNNJjhy> entry : jjhyMap.entrySet()) {
                if (entry.getKey().contains(mc)||entry.getValue().getMc().contains(mc)||entry.getValue().getMemo().contains(mc)) {
                    Model model = new Model();
                    model.setColumn1(entry.getKey());
                    model.setColumn2(entry.getValue().getMc());
                    model.setColumn3(entry.getValue().getMemo());
                    list.add(model);
                }
            }
        	
        }else{
        for (Map.Entry<String, String> entry : maps.entrySet()) {
            if (entry.getKey().startsWith(mc)
                    || (source.contains("jjhy0000") && entry.getKey().trim().startsWith(mc, 1))
                    || (entry.getValue()!=null&&entry.getValue().contains(mc))) {
                Model model = new Model();
                model.setColumn1(entry.getKey());
                model.setColumn2(entry.getValue());
                list.add(model);
            }
        }
        }
        if (source != null && (source.contains("zgjg") || source.contains("pzjg"))) {
            if (list.size() <= 0 && mc.length() == 9) {
                List<Object[]> objects = EntityManagerHelper.getEntityManager().
                        createQuery(" select model.jgdm ,model.jgmc from TJgdm model where model.jgdm = ?1 or model.jgmc like ?2 ").
                        setParameter(1, mc).setParameter(2, "%" + mc + "%").getResultList();
                for (Object[] objs : objects) {
                    Model model = new Model();
                    model.setColumn1(objs[0] == null ? "" : objs[0].toString());
                    model.setColumn2(objs[1] == null ? "" : objs[1].toString());
                    list.add(model);
                }
                EntityManagerHelper.closeEntityManager();
            }
        }
        page.setTotalRecord(list.size());
        int end = page.getStartRecord() + page.getPageSize();
        end = end > list.size() ? list.size() : end;
        dmmcs.addAll(list.subList(page.getStartRecord(), end));
        System.out.println(dmmcs+"==================");
        currentPath = "/product/jsp/common/" + "listResult.jsp";
        return this.SUCCESS;
    }


    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }

    public String getCurrentPath() {
        return currentPath;
    }

    public void setCurrentPath(String currentPath) {
        this.currentPath = currentPath;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }


    public List<Model> getDmmcs() {
        return dmmcs;
    }

    public void setDmmcs(List<Model> dmmcs) {
        this.dmmcs = dmmcs;
    }

    public Boolean getFilter() {
        return filter;
    }

    public void setFilter(Boolean filter) {
        this.filter = filter;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
