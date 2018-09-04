package com.ninemax.jpa.code.interceptor;

import com.ninemax.jpa.code.model.TJgdm;
import com.ninemax.jpa.code.model.TYwlc;
import com.ninemax.jpa.code.model.TYwlcDy;
import com.ninemax.jpa.code.model.TYwlcLog;
import com.ninemax.jpa.util.ActionUtils;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * User: zhhuiyan
 * Date: 12-12-6
 * Time: 下午5:06
 */
public class YwlcInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        log.info(actionInvocation.getInvocationContext().getName());
        if (Action.SUCCESS.equals(actionInvocation.invoke()))
            return after();
        return Action.ERROR;
    }

    public String after() throws Exception {
        final HttpServletRequest request = ServletActionContext.getRequest();
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                request.getParameter("ywlclx");
                Integer ywlclx = (Integer) request.getAttribute("ywlclx");
                String type = (String) request.getAttribute("type");
                TJgdm jgdm = (TJgdm) request.getAttribute("jgdm");
                TYwlc ywlc = (TYwlc) request.getAttribute("ywlc");
                TYwlcDy ywlcDy;
                log.info(type + ":" + ywlclx + ":" + jgdm);
                if ("年检".equals(type)) {
                    ywlcDy = ywlcDy(ywlclx, type);
                    List<TYwlc> ywlcs = em.createQuery(sql(jgdm, ywlcDy)).getResultList();
                    if (ywlcs != null && !ywlcs.isEmpty()) {
                        ywlc = ywlcs.get(0);
                        log(ywlc);
                        update_ywlc(ywlc, jgdm, ywlcDy);
                    }
                    return;
                }
                String allJgdms = (String) request.getAttribute("allJgdms");
                if (12 == ywlclx) {
                    if (ywlc != null && ywlc.getYwlsh() != null && !"".equals(ywlc.getYwlsh())) {
                        ywlc = em.find(TYwlc.class, ywlc.getYwlsh());
                        ywlcDy = ywlcDy(ywlc.getYwlclx(), type);
                        ywlc = update_ywlc(ywlc, jgdm, ywlcDy);
                    } else {
                        List<TYwlc> ywlcs = em.createQuery("select model  from  TYwlc model,TYwlcDy dy ,TYwlcDy ywlcdy where " +
                                " model.jgdm='" + jgdm.getJgdm() + "' and model.type=dy.type and model.ywlclx=dy.ywlclx " +
                                "and dy.ywlclx=ywlcdy.ywlclx and dy.lcsx=ywlcdy.lcsx-1 " +
                                "and ywlcdy.type='" + type + "'").getResultList();
                        if (ywlcs == null || ywlcs.isEmpty()) {
                            log.error(YwlcInterceptor.class, new Throwable("证书打印流程错误！"));
                        }else{
                            ywlc = ywlcs.get(0);
                        }

                    }
                } else {

                    ywlcDy = ywlcDy(ywlclx, type);
                    if (allJgdms != null && !"".equals(allJgdms)) {
                        String[] dms = allJgdms.split(",");
                        for (String dm : dms) {
                            if (dm.length() != 9)
                                continue;
                            jgdm = em.find(TJgdm.class, dm);
                            List<TYwlc> ywlcs = em.createQuery(sql(jgdm, ywlcDy)).getResultList();
                            if (ywlcs != null && !ywlcs.isEmpty()) {
                                ywlc = ywlcs.get(0);
                                ywlc = update_ywlc(ywlc, jgdm, ywlcDy);
                            } /*else {
                                ywlc = new_ywlc(jgdm, ywlcDy);
                            }*/
                        }

                    } else {
                        List<TYwlc> ywlcs = em.createQuery(sql(jgdm, ywlcDy)).getResultList();
                        if (ywlcs != null && !ywlcs.isEmpty()) {
                            ywlc = ywlcs.get(0);
                            ywlc = update_ywlc(ywlc, jgdm, ywlcDy);
                        }/* else {
                            ywlc = new_ywlc(jgdm, ywlcDy);
                        }*/
                    }
                }

                if (ywlc != null)
                    log(ywlc);
            }

            private String sql(TJgdm jgdm, TYwlcDy ywlcDy) throws Exception {
                String sql = "select  model from TYwlc model where  model.isend<> '2' and model.ywlclx=" + ywlcDy.getYwlclx() + "" +
                        " and model.type in (select ywdy.type from TYwlcDy ywdy where ywdy.ywlclx=" + ywlcDy.getYwlclx() +
                        "      and ywdy.lcsx =" + (ywlcDy.getLcsx() - 1) +
                        ") and model.bzjgdm='" + jgdm.getBzjgdm() +
                        "' and model.jgdm = '" + jgdm.getJgdm() + "'";
                return sql;
            }

            private TYwlcDy ywlcDy(int ywlclx, String type) throws Exception {
                log.info("TYwlcDy:" + ywlclx + ":" + type);
                return (TYwlcDy) em.createQuery("select dy from TYwlcDy  dy where dy.ywlclx=" + ywlclx + " and dy.type='" + type + "')").getSingleResult();

            }

            private void log(TYwlc ywlc) throws Exception {
                TYwlcLog log = new TYwlcLog();
                log.setBzjgdm(ywlc.getBzjgdm());
                log.setClsj(new Date());
                log.setIsend(ywlc.getIsend());
                log.setJgdm(ywlc.getJgdm());
                log.setJgmc(ywlc.getJgmc());
                log.setType(ywlc.getType());
                log.setYwlclx(ywlc.getYwlclx());
                log.setYwlsh(ywlc.getYwlsh());
                em.persist(log);
            }

            private TYwlc new_ywlc(TJgdm jgdm, TYwlcDy ywlcDy) throws Exception {
                TYwlc ywlc = new TYwlc();
                ywlc.setYwlclx(ywlcDy.getYwlclx());
                ywlc.setBzjgdm(jgdm.getBzjgdm());
                ywlc.setId(id());
                ywlc.setJgdm(jgdm.getJgdm());
                ywlc.setJgmc(jgdm.getJgmc());
                ywlc.setYwlsh(Calendar.getInstance().get(Calendar.YEAR) + "00000000".substring(8 - (ywlc.getId().toString().length())) + ywlc.getId());
                ywlc.setIsend("2");
                ywlc.setType(ywlcDy.getType());
                ywlc.setClsj(new Date());
                em.persist(ywlc);
                return ywlc;
            }

            private TYwlc update_ywlc(TYwlc ywlc, TJgdm jgdm, TYwlcDy ywlcDy) throws Exception {
                ywlc.setIsend(ywlcDy.getIsend());
                ywlc.setType(ywlcDy.getType());
                ywlc.setJgmc(jgdm.getJgmc());
                ywlc.setClsj(new Date());
                em.merge(ywlc);
                em.persist(ywlc);
                return ywlc;
            }

            private Long id() throws Exception {
                return (Long) em.createQuery("select max(model.id) from TYwlc model").getSingleResult() + 1;
            }

        }.template();
    }
}
