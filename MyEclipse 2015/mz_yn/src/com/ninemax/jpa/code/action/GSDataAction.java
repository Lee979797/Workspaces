package com.ninemax.jpa.code.action;

import com.ninemax.jpa.code.model.Page;
import com.ninemax.jpa.code.model.TJgdm;
import com.ninemax.jpa.code.model.TJgdmSave;
import com.ninemax.jpa.global.CheckEntityManagerHelper;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.system.model.User;
import com.ninemax.jpa.util.PropertiesUtils;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * * User: zhhuiyan
 * Date: 13-8-4
 * Time: 下午3:19
 * Name:${Name}
 */
public class GSDataAction extends ActionSupport implements SessionAware {
    private static Logger log = Logger.getLogger(GSDataAction.class);
    private String currentPath = "";
    private String name;
    private TJgdmSave jgdmSave;
    private List<TJgdm> jgdms;
    private Page page;
    private Map<String, Object> session;
    private static Map<String, String> gsdzbs = new ConcurrentHashMap<String, String>();

    static {
        EntityManager em = EntityManagerHelper.getEntityManager();
        List<Object[]> obs = em.createNativeQuery("select bzjgdm ,dz from gsdzb ").getResultList();
        for (Object[] objects : obs) {
            System.out.println("objects[0].toString().trim()" + objects[1].toString().trim());
            gsdzbs.put(objects[0].toString().trim(), objects[1].toString().trim());
        }
    }


    private EntityManager manager() {
        return CheckEntityManagerHelper.getEntityManager();
    }

    private void closeEntityManager() {
        CheckEntityManagerHelper.closeEntityManager();
    }

    private Object make(Object[] objs, Class clazz) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {

    	int i = 0;
        Object jgdm = clazz.newInstance();
        PropertiesUtils.loadFile("gsdjb");
        Properties datas = PropertiesUtils.getDatas();
        for (Map.Entry<Object, Object> entry : datas.entrySet()) {
            if ("table".equals(entry.getKey()))
                continue;
            i++;
            Method method = null;
            if ("Gk".equals(entry.getKey())) {
                method = clazz.getDeclaredMethod("set" + entry.getKey(), String.class);
                method.setAccessible(true);
                method.invoke(jgdm, objs[i - 1] == null ? "" : objs[i - 1].toString());
            } else if ("Zgrs".equals(entry.getKey()) || "Fksl".equals(entry.getKey()) || "Fbsl".equals(entry.getKey())) {
                method = clazz.getDeclaredMethod("set" + entry.getKey(), Integer.class);
                method.setAccessible(true);
                method.invoke(jgdm, objs[i - 1] == null ? null : Integer.valueOf(objs[i - 1].toString()));
            } else if (objs[i - 1] instanceof String) {
                method = clazz.getDeclaredMethod("set" + entry.getKey(), String.class);
                method.setAccessible(true);
                method.invoke(jgdm, (String) objs[i - 1]);
            } else if (objs[i - 1] instanceof Date) {
                method = clazz.getDeclaredMethod("set" + entry.getKey(), Date.class);
                method.setAccessible(true);
                method.invoke(jgdm, (Date) objs[i - 1]);
            } else if (objs[i - 1] instanceof Double) {
                method = clazz.getDeclaredMethod("set" + entry.getKey(), Double.class);
                method.setAccessible(true);
                method.invoke(jgdm, (Double) objs[i - 1]);
            }else if ("Zczj".equals(entry.getKey())) {
                method = clazz.getDeclaredMethod("set" + entry.getKey(), Double.class);
                method.setAccessible(true);
                //BigDecimal a = new BigDecimal("1.00");
                Double b=new Double(objs[i - 1].toString());
                method.invoke(jgdm,  b);
            } else if (objs[i - 1] instanceof Integer) {
                method = clazz.getDeclaredMethod("set" + entry.getKey(), Integer.class);
                method.setAccessible(true);
                method.invoke(jgdm, (Integer) objs[i - 1]);
            }


        }
        return jgdm;
    }

    public String list() {
       // System.out.println("sqlsadasda");
        currentPath = "/product/jsp/certificate/list.jsp";
        HttpServletRequest request = ServletActionContext.getRequest();
        User user = (User) session.get("sysUser");
        try {
            if (page == null) {
                page = new Page();
                page.setOrderByType("desc");
            }
            PropertiesUtils.loadFile("gsdjb");
            Properties datas = PropertiesUtils.getDatas();
            String tableName = datas.getProperty("table");
            String bzjgdmName = datas.getProperty("Bzjgdm");
            String jgmc=datas.getProperty("Jgmc");
            String bak4=datas.getProperty("Bak4");
            if(jgdmSave==null){
            	jgdmSave=new TJgdmSave();
            }
            String jgmcVa=jgdmSave.getJgmc();
            String bak4Va=jgdmSave.getBak4();
            
            String bzjgdm = gsdzbs.get(user.getBzjgdm().trim());
            bzjgdm = bzjgdm == null ? "" : bzjgdm;
            String select = " select ";

            for (Map.Entry<Object, Object> entry : datas.entrySet()) {
                if ("id".equals(entry.getKey()) || "table".equals(entry.getKey()))
                    continue;
                select += entry.getValue() + ",";
            }
            select = select.substring(0, select.lastIndexOf(","));
            String sql = select + "  from " + tableName + " where state='0' and " + bzjgdmName + " ='" + bzjgdm + "'";
            String sqlJoin="";
            if(jgmcVa!=null&&!"".equals(jgmcVa)){
            	sqlJoin+=" and "+jgmc+"='"+jgmcVa+"'";
            }
            if(bak4Va!=null&&!"".equals(bak4Va)){
            	sqlJoin+= " and "+bak4+"='"+bak4Va+"'";
            }
            sql+=sqlJoin;
            List<Object[]> objects = manager().createNativeQuery(sql).setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                    .getResultList();
            page.setTotalRecord((Integer) manager().createNativeQuery(" select count(1)  from " + tableName + " where state='0' and " + bzjgdmName + " ='" + bzjgdm + "'"+sqlJoin)
                    .getResultList().get(0));
            jgdms = new ArrayList<TJgdm>();
            if (objects != null && !objects.isEmpty()) {
                for (Object[] objs : objects) {
                    jgdms.add((TJgdm) make(objs, TJgdm.class));
                }
            }
            return SUCCESS;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeEntityManager();
        }
        return ERROR;
    }

    public String show() {
        try {
            PropertiesUtils.loadFile("gsdjb");
            Properties datas = PropertiesUtils.getDatas();
            String idName = datas.getProperty("Bak4");
            String tableName = datas.getProperty("table");
            String select = " select ";
            for (Map.Entry<Object, Object> entry : datas.entrySet()) {
                if ("table".equals(entry.getKey()))
                    continue;
                select += entry.getValue() + ",";
            }
            select = select.substring(0, select.lastIndexOf(","));
            System.out.println("select = " + select);
            List<Object[]> objects = manager().createNativeQuery(select + "  from " + tableName + " where " + idName + "='" + jgdmSave.getBak4() + "'").getResultList();
            if (objects != null && !objects.isEmpty()) {
                jgdmSave = (TJgdmSave) make(objects.get(0), TJgdmSave.class);
            }
        } catch (RuntimeException re) {
            log.error(GSDataAction.class, re);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeEntityManager();
        }
        currentPath = "/product/jsp/certificate/addinfomationEnter.jsp";
        return SUCCESS;
    }

    //消息头
    protected String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TJgdmSave getJgdmSave() {
        return jgdmSave;
    }

    public void setJgdmSave(TJgdmSave jgdmSave) {
        this.jgdmSave = jgdmSave;
    }

    public String getCurrentPath() {
        return currentPath;
    }

    public void setCurrentPath(String currentPath) {
        this.currentPath = currentPath;
    }

    public Page getPage() {
        return page;
    }

    public List<TJgdm> getJgdms() {
        return jgdms;
    }

    public void setJgdms(List<TJgdm> jgdms) {
        this.jgdms = jgdms;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
