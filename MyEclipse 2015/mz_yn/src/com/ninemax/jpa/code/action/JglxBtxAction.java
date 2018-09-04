/**
 *
 */
package com.ninemax.jpa.code.action;

import com.ninemax.jpa.code.model.TJglx;
import com.ninemax.jpa.code.model.TJglxBsx;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.global.InitSysParams;
import com.ninemax.jpa.util.ActionUtils;
import com.opensymphony.xwork2.ActionSupport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Liuzy
 */
public class JglxBtxAction extends ActionSupport {
    private static final String path = "/product/jsp/frame/";

    private String currentPath = path + "";
    private TJglx jglx;

    private String btxs;
    private String message;

    public String show() {

        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                List<TJglxBsx> jglxBsxes = em.createQuery("select model from TJglxBsx model where  model.jglx=:jglx").setParameter("jglx", jglx.getDm().trim()).getResultList();
                jglx.setMc(InitSysParams.jglxMap.get(jglx.getDm()));
                btxs = "";
                for (TJglxBsx bsx : jglxBsxes) {
                    btxs += bsx.getBsx() + ",";
                }
                currentPath = path + "/managebtx.jsp";
            }
        }.nSyTemplate();
    }

    public String list() {

        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                currentPath = path + "/jglx_list.jsp";
            }
        }.nSyTemplate();
    }

    public String save() {
        return new ActionUtils() {
            public Map<String, String> getBtxs() throws RuntimeException {
                StringBuilder result = new StringBuilder();
                Map<String, String> map = new HashMap<String, String>();
                String jglx = "";
                final String sql = "select model from TJglxBsx model order by model.jglx";

                List<TJglxBsx> jglxBsxes = em.createQuery(sql).getResultList();
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
                return map;
            }

            @Override
            protected void excute() throws Exception {
                em.createQuery("delete  from TJglxBsx model where  model.jglx=:jglx").setParameter("jglx", jglx.getDm().trim()).executeUpdate();
                em.flush();
                if (btxs != null && !"".equals(btxs)) {
                    String btx[] = btxs.split(",");
                    for (String item : btx) {
                        TJglxBsx bsx = new TJglxBsx();
                        bsx.setBsx(item.trim());
                        bsx.setJglx(jglx.getDm().trim());
                        em.persist(bsx);
                    }
                }
                jglx.setMc(InitSysParams.jglxMap.get(jglx.getDm()));
                InitSysParams.btxs = getBtxs();
                message = "机构类型必填项设置成功";
                currentPath = path + "/managebtx.jsp";
            }
        }.template();
    }

    public String getCurrentPath() {
        return currentPath;
    }

    public void setCurrentPath(String currentPath) {
        this.currentPath = currentPath;
    }

    public TJglx getJglx() {
        return jglx;
    }

    public void setJglx(TJglx jglx) {
        this.jglx = jglx;
    }

    public String getBtxs() {
        return btxs;
    }

    public void setBtxs(String btxs) {
        this.btxs = btxs;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
