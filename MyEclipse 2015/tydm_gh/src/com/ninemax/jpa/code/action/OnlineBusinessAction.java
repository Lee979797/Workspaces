    /**
     *
     */
    package com.ninemax.jpa.code.action;

    import com.ninemax.jpa.code.bus.SerialBus;
    import com.ninemax.jpa.code.bus.WsbzXbBus;
    import com.ninemax.jpa.code.model.*;
    import com.ninemax.jpa.code.model.vo.Wzx;
    import com.ninemax.jpa.global.CodeEntityManagerHelper;
    import com.ninemax.jpa.global.InitSysParams;
    import com.ninemax.jpa.system.model.User;
    import com.ninemax.jpa.util.*;
    import javax.persistence.EntityManager;
    import java.util.Calendar;
    import java.util.Date;
    import java.util.List;
    import java.util.Map;

    /**
     * @author liuzy
     * 2013-06-17
     */
    public class OnlineBusinessAction extends CommonJgdmAction {
        private static final String path = "/product/jsp/onlinebusiness/";
        private WsbzXbBus wsbzBus;
        private String wftzgb;
        private List<TFzdm> fzdms;

        private Date startDate;
        private Date endDate;
        private String type;
        private String ywlx;
        private String djh;
        private String xbid;

        private String allJgdms;


        public OnlineBusinessAction() {
            serialBus = new SerialBus();
            wsbzBus = new WsbzXbBus();
        }

        public String search() {
            return new ActionUtils(session) {
                @Override
                protected void excute() throws Exception {
                    if ("unvalidate".equals(type)) {
                        TSpdmtemp spdm = getSpdm(em, mc, "04");
                        if (spdm != null) {
                            jgdm = new TJgdm();
                            BeanUtilsEx.copyProperties(jgdm, spdm);
                        } else {
                            TFzdm fzdm = em.find(TFzdm.class, mc);
                            em.clear();
                            if (fzdm == null) {
                                throw new Exception("注销代码不存在");
                            }
                            jgdm = new TJgdm();

                            BeanUtilsEx.copyProperties(jgdm, fzdm);
                            jgdm.setBzrq(new Date());
                            jgdm.setNjrq(null);
                            TZrxzqh zrxzqh = InitSysParams.zrxzqhMap2.get(getUser().getBzjgdm());
                            if ("1".equals(zrxzqh.getNjfs())) {
                                Date date = DateUtil.strToDate(Calendar.getInstance().get(Calendar.YEAR) + "-" + zrxzqh.getNjqsrq().substring(0, 2) + "-" + zrxzqh.getNjqsrq().substring(2, 4));
                                if (date.after(new Date())) {
                                    jgdm.setNjqx(DateUtil.strToDate(Calendar.getInstance().get(Calendar.YEAR) + "-" + zrxzqh.getNjjzrq().substring(0, 2) + "-" + zrxzqh.getNjjzrq().substring(2, 4)));
                                } else {
                                    jgdm.setNjqx(DateUtil.strToDate((Calendar.getInstance().get(Calendar.YEAR) + 1) + "-" + zrxzqh.getNjjzrq().substring(0, 2) + "-" + zrxzqh.getNjjzrq().substring(2, 4)));

                                }
                            } else {
                                jgdm.setNjqx(DateUtil.yearAfter(jgdm.getBzrq(), 1));
                            }


                        }
                    }  else if ("update_no".equals(type)) {
                        TSpdmtemp spdm = getSpdm(em, mc, "07");
                        if (spdm == null) {
                            jgdm = wsbzBus.findJgdmById(Integer.parseInt(xbid));
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(jgdm.getBzrq() != null ? jgdm.getBzrq() : (new Date()));
                            jgdm.setZfrq(DateUtil.strToDate((calendar.get(Calendar.YEAR) + 4) + "-" + (calendar.get(Calendar.MONTH)+1) + "-" + calendar.get(Calendar.DAY_OF_MONTH)));

                            TZrxzqh xzqh = em.find(TZrxzqh.class, getUser().getBzjgdm());
                            em.clear();
                            Date real;
                            if (xzqh.getNjfs().equals("0")) {
                                real = DateUtil.yearAfter(jgdm.getNjrq() == null ? new Date() : jgdm.getNjrq(), 1);
                                jgdm.setNjqx(real);
                            } else {
                                Date date = DateUtil.strToDate(Calendar.getInstance().get(Calendar.YEAR) + "-" + xzqh.getNjqsrq().substring(0, 2) + "-" + xzqh.getNjqsrq().substring(2, 4));
                                if (date.after(new Date())) {
                                    jgdm.setNjqx(DateUtil.strToDate(Calendar.getInstance().get(Calendar.YEAR) + "-" + xzqh.getNjjzrq().substring(0, 2) + "-" + xzqh.getNjjzrq().substring(2, 4)));
                                } else {
                                    jgdm.setNjqx(DateUtil.strToDate((Calendar.getInstance().get(Calendar.YEAR) + 1) + "-" + xzqh.getNjjzrq().substring(0, 2) + "-" + xzqh.getNjjzrq().substring(2, 4)));

                                }
                            }
                        } else {
                            jgdm = new TJgdm();
                            BeanUtilsEx.copyProperties(jgdm, spdm);
                        }

                    } else if ("check".equals(type)) {
                        TSpdmtemp spdm;
                        spdm = getSpdm(em, mc, "12");
                        if (spdm != null) {
                            jgdm = new TJgdm();
                            BeanUtilsEx.copyProperties(jgdm, spdm);
                        } else {
    //                        jgdm = em.find(TJgdm.class, mc);
                            jgdm = wsbzBus.findJgdmById(Integer.parseInt(xbid));
                            if(jgdm.getEmail()!=null&&jgdm.getEmail().equals("null")){
                            	jgdm.setEmail(null);
                            }
                            TJgdm t2 = em.find(TJgdm.class,jgdm.getJgdm());
                            jgdm.setZfrq(t2.getZfrq());jgdm.setBzrq(t2.getBzrq());

                            TZrxzqh xzqh = em.find(TZrxzqh.class, getUser().getBzjgdm());
                            em.clear();
                            Date real;
                            if (xzqh.getNjfs().equals("0")) {
                                real = DateUtil.yearAfter(jgdm.getNjrq() == null ? new Date() : jgdm.getNjrq(), 1);
                                jgdm.setNjqx(real);
                            } else {
                                Date date = DateUtil.strToDate(Calendar.getInstance().get(Calendar.YEAR) + "-" + xzqh.getNjqsrq().substring(0, 2) + "-" + xzqh.getNjqsrq().substring(2, 4));
                                if (date.after(new Date())) {
                                    jgdm.setNjqx(DateUtil.strToDate(Calendar.getInstance().get(Calendar.YEAR) + "-" + xzqh.getNjjzrq().substring(0, 2) + "-" + xzqh.getNjjzrq().substring(2, 4)));
                                } else {
                                    jgdm.setNjqx(DateUtil.strToDate((Calendar.getInstance().get(Calendar.YEAR) + 1) + "-" + xzqh.getNjjzrq().substring(0, 2) + "-" + xzqh.getNjjzrq().substring(2, 4)));

                                }
                            }

                        }
                    } else if ("validate".equals(type)) {
                        TSpdmtemp spdm = getSpdm(em, mc, "01");
                        if (spdm != null) {
                            jgdm = new TJgdm();
                            BeanUtilsEx.copyProperties(jgdm, spdm);
                        } else {
                            jgdm = em.find(TJgdm.class, mc);
                            Wzx zx = wsbzBus.findWzx(xbid);
                            fzyj = zx.getZxyj();
                            fzreason = zx.getZxyy();
                        }

                    } else {
                        TSpdmtemp spdm = getSpdm(em, mc, "03");
                        if (spdm != null) {
                            jgdm = new TJgdm();
                            BeanUtilsEx.copyProperties(jgdm, spdm);
                        } else {
                            jgdm = em.find(TJgdm.class, mc);
                        }
                    }
                    if (chufa(em)) {
                        source = "business_" + source;
                        return;
                    }

                    em.clear();
                    //    setSource(type);
                    currentPath = path + (type == null ? "" : type) + "Business.jsp";
                }
            }.nSyTemplate();

        }

        public String auditUpdate_no() {
            final TJgdm[] jgdmArr = {null};
            String result = new ActionUtils(session) {
                @Override
                protected void excute() throws Exception {
                    User user = (User) session.get("sysUser");
                    if (jgdm.getJgdm() == null) {
                        setMessage("输入机构代码错误");
                        currentPath = path + "search.jsp?source=" + source;
                        return;
                    }
                    deleteSp(em, jgdm.getJgdm(), "07");
                    TSpdmtemp spdm = new TSpdmtemp();
                    jgdm.setLry(user.getUserName());
                    TJgdm jgdm1 = em.find(TJgdm.class, jgdm.getJgdm());
                    em.clear();
                    BeanUtilsEx.copyProperties(jgdm1, jgdm);
                    BeanUtilsEx.copyProperties(spdm, jgdm1);

                    jgdmArr[0] = jgdm1;

                    spdm.setCzreason(fzreason);
                    spdm.setCzyj(fzyj);
                    Map<Object, Object> map = BeanUtilsEx.describe(spdm);
    //                for (Map.Entry<Object, Object> entry : map.entrySet()) {
    //                    System.out.println("entry= " + entry.getKey() + ":" + entry.getValue());
    //                }
                    em.persist(spdm);
                    TSp sp = new TSp();
                    sp.setGllsh(spdm.getLsh());
                    sp.setGllsh(spdm.getLsh());
                    sp.setFlag("0");
                    sp.setShflag("0");
                    sp.setYwlx("07");
                    sp.setSubmitType(submitType);
                    sp.setJgdm(jgdm.getJgdm());
                    sp.setRecexzqh(InitSysParams.system.getXzqhdm().trim());
                    sp.setSendxzqh(jgdm.getBzjgdm());
                    sp.setSendman(user.getUserName());
                    sp.setSendtime(new Date());
                    em.persist(sp);
                    em.flush();
                    setTitle("审核 &gt;&gt; 网上业务 &gt;&gt; 发送变更申请");
                    setMessage("向省中心提交机构代码（" + jgdm.getJgdm() + "）变更请求成功！");
                    currentPath = path + "success.jsp";
                }
            }.template();

            if(result.equalsIgnoreCase("SUCCESS")){
                wsbzBus.saveWsyw(jgdmArr[0].getJgdm(),jgdmArr[0].getJgmc(),"2","3",djh);
            }
            return result;
        }

        public String sameName(final String shType) {
            return new ActionUtils(session) {
                @Override
                protected void excute() throws Exception {
                    User user = (User) session.get("sysUser");
                    if (jgdm.getJgdm() == null) {
                        setMessage("输入机构代码错误");
                        currentPath = path + "search.jsp?source=" + source;
                        return;
                    }
                    deleteSp(em, jgdm.getJgdm(), shType);
                    TSpdmtemp spdm = new TSpdmtemp();
                    jgdm.setLry(user.getUserName());
                    em.clear();
                    BeanUtilsEx.copyProperties(spdm, jgdm);
                    spdm.setCzreason(fzreason);
                    spdm.setCzyj(fzyj);
                    em.persist(spdm);
                    em.merge(spdm);
                    TSp sp = new TSp();
                    sp.setGllsh(spdm.getLsh());
                    sp.setGllsh(spdm.getLsh());
                    sp.setFlag("0");
                    sp.setShflag("0");
                    sp.setYwlx(shType);
                    sp.setSubmitType(submitType);
                    sp.setJgdm(jgdm.getJgdm());
                    sp.setRecexzqh(InitSysParams.system.getXzqhdm().trim());
                    sp.setSendxzqh(jgdm.getBzjgdm());
                    sp.setSendman(user.getUserName());
                    sp.setSendtime(new Date());
    //                Map<Object, Object> map = BeanUtilsEx.describe(sp);
    //                for (Map.Entry<Object, Object> entry : map.entrySet()) {
    //                    System.out.println("entry.getKey()+\":\"+entry.getValue() = " + entry.getKey() + ":" + entry.getValue());
    //                }
                    em.persist(sp);
                    em.flush();
                    setMessage("向省中心提交机构代码（" + jgdm.getJgdm() + "）" + (submitType == 1 ? "重名注册" : submitType == 2 ? "重注册号" : "重名重注册") + "审核请求成功！");
                    currentPath = path + "success.jsp";
                }
            }.template();
        }
        public String update_no() {
            if (submitType != 0) {
                return auditUpdate_no();
            }
            final TJgdm[] jgdmArr = {null};
            String result = new ActionUtils(session) {
                @Override
                protected void excute() throws Exception {
                    TJgdm jgdm2 = em.find(TJgdm.class, jgdm.getJgdm());
                    em.clear();

                    User user = (User) session.get("sysUser");
                    TBgk bgk = new TBgk();
                    BeanUtilsEx.copyProperties(bgk, jgdm2);
                    bgk.setBgsj(new Date());
                    em.persist(bgk);
                    if (audit) {
                        TSpdmtemp spdm = getSpdm(em, jgdm.getJgdm(), "07");
                        BeanUtilsEx.copyProperties(jgdm, spdm);
                    }

                    addCzjl(em, jgdm, "更新机构代码", "2", null);

                    jgdm.setDybz("2");
                    List<TZs> zses = em.createQuery("select model from TZs model where model.flag= ?1 and model.jgdm=?2").setParameter(1, "1").setParameter(2, jgdm.getJgdm()).getResultList();
                    for (TZs zs : zses) {
                        zs.setFlag("2");
                        zs.setLastdate(new Date());
                        em.merge(zs);
                    }
                    if (("1".equals(jgdm2.getFkbz())) || ("1".equals(jgdm.getFkbz()))) {
                        List<TkKxxk> kxxks = em.createQuery(" SELECT model FROM TkKxxk model WHERE model.kxlh is not null and model.jgdm =:jgdm").setParameter("jgdm", jgdm.getJgdm()).getResultList();
                        Date date = new Date();
                        if (kxxks != null && !kxxks.isEmpty()) {
                            for (TkKxxk kxxk : kxxks) {
                                TkFzk fzk = new TkFzk();
                                fzk.setJgdm(jgdm.getJgdm());
                                fzk.setKxlh(kxxk.getKxlh());
                                fzk.setFzsj(date);
                                fzk.setOperater(user.getUserName());
                                fzk.setXzqh(user.getBzjgdm());
                                em.persist(fzk);
                            }
                        }
                        em.createQuery("delete from TkKxxk where jgdm=:jgdm").setParameter("jgdm", jgdm.getJgdm()).executeUpdate();
                        for (int i = 0; i < jgdm.getFksl(); ++i) {
                            TkKxxk kxxk = new TkKxxk();
                            kxxk.setCzy(user.getUserName());
                            kxxk.setJgdm(jgdm.getJgdm());
                            kxxk.setBkbz("0");
                            kxxk.setCzsj(date);
                            kxxk.setSqsj(new Date());
                            kxxk.setFkbz("1");
                            kxxk.setFlag("0");
                            kxxk.setGsbz("0");
                            kxxk.setSbbz("0");
                            kxxk.setXzqh(user.getBzjgdm());
                            kxxk.setXgbz("0");
                            kxxk.setHaveDown("0");
                            em.persist(kxxk);
                            addCzjl(em, jgdm, "写卡信息", "Q", kxxk.getLsh().longValue());
                        }
                    }
                    dy = "0";
                    jgdm.setBgrq(new Date());
                    jgdm.setLastdate(new Date());
                    jgdm.setLry(user.getUserName());
                    jgdm.setLastdate(new Date());
                    jgdm.setWtbz(0);
                    /*   BeanUtilsEx.copyProperties(jgdm2, jgdm);
                    Map<Object, Object> map = BeanUtilsEx.describe(jgdm2);
                    for (Map.Entry<Object, Object> entry : map.entrySet()) {
                        System.out.println("name::value=|" + entry.getKey() + "|" + entry.getValue());
                    }*/
                    jgdm.setLastdate(new Date());
                    jgdm.setDybz("2");
                    em.merge(jgdm);
                    ywlclx = 6;
                    type = "1".equals(jgdm.getDybz()) ? "无证书变更" : "变更";
                    addTSmrw(em, SmTaskType.变更);
                    if (audit) {
                        clearSp(em, jgdm, "07");
                    }
                    if (!source.equals("update_no")) {
                        EntityManager manager = CodeEntityManagerHelper.getEntityManager();
                        manager.getTransaction().begin();
                        try {

                            manager.createQuery("delete from SmProJgdm model where model.jgdm=?1").setParameter(1, jgdm.getJgdm()).executeUpdate();
                            manager.flush();
                            manager.getTransaction().commit();
                        } catch (Exception e) {
                            manager.getTransaction().rollback();
                            throw e;
                        } finally {
                            CodeEntityManagerHelper.closeEntityManager();
                        }
                        em.createQuery("delete  from  TProjgdmGj model where model.jgdm=?1").setParameter(1, jgdm.getJgdm()).executeUpdate();
                    }
                    deleteSp(em, jgdm.getJgdm(), "07");
                    jgdmArr[0] = jgdm;
                    em.flush();
                    currentPath = path + "updateSuccess.jsp";
                }
            }.template();

            if(result.equalsIgnoreCase("SUCCESS")){
                if(clsStringTool.isEmpty(djh)){
    //                if(wsbzBus.isWsywByjgdm(jgdmArr[0].getJgdm(),"2")){
                        wsbzBus.updateXbByjgdm(jgdmArr[0].getJgdm(),"3","2",jgdmArr[0]);
                        wsbzBus.delWsywByjgdm(jgdmArr[0].getJgdm(),"2");
    //                }
                }else{
    //                if(wsbzBus.isWsyw(djh,"2")){
                        wsbzBus.updateXb(djh,"3","2",jgdmArr[0]);
                        wsbzBus.delWsyw(djh,"2");
    //                }
                }
            }
            return result;
        }

        /**
         * 年检
         *
         * @return String
         */
        public String check() {
            if (submitType != 0) {
                return sameName("12");
            }
            final TJgdm[] jgdmArr = {null};
            String result =  new ActionUtils(session) {
                @Override
                protected void excute() throws Exception {
                    TJgdm jgdm2 = em.find(TJgdm.class, jgdm.getJgdm());

                    em.clear();

                    TBgk bgk = new TBgk();
                    BeanUtilsEx.copyProperties(bgk, jgdm2);
                    bgk.setBgsj(new Date());

                    em.persist(bgk);
                    if (audit) {
                        TSpdmtemp spdm = getSpdm(em, jgdm.getJgdm(), "12");
                        BeanUtilsEx.copyProperties(jgdm, spdm);
                    }
                    jgdm.setNjrq(new Date());
                    jgdm.setLastdate(new Date());
                    User user = (User) session.get("sysUser");
                    jgdm.setNjr(user.getUserName());
                    String dybz1 = jgdm2.getDybz();
                    BeanUtilsEx.copyProperties(jgdm2, jgdm);
                    jgdm2.setDybz(dybz1);
                    jgdm2.setLastdate(new Date());
                    em.merge(jgdm2);

                    jgdmArr[0] = jgdm2;
                    jgdm = jgdm2;
                    ywlclx = 6;
                    type = "年检";
                    addTSmrw(em, SmTaskType.年检);
                    addCzjl(em, jgdm, "年检", "6", null);
                    fksl = jgdm.getFksl() - jgdm2.getFksl();
                    if ((fksl >= 1)) {
                        for (int i = 0; i < fksl; ++i) {
                            TkKxxk kxxk = new TkKxxk();
                            kxxk.setCzy(user.getUserName());
                            kxxk.setJgdm(jgdm.getJgdm());
                            kxxk.setBkbz("0");
                            kxxk.setCzsj(new Date());
                            kxxk.setSqsj(new Date());
                            kxxk.setFkbz("1");
                            kxxk.setFlag("0");
                            kxxk.setGsbz("0");
                            kxxk.setSbbz("0");
                            kxxk.setXzqh(user.getBzjgdm());
                            kxxk.setXgbz("0");
                            kxxk.setHaveDown("0");
                            em.persist(kxxk);
                            addCzjl(em, jgdm, "写卡信息", "Q", kxxk.getLsh().longValue());
                        }
                    }
                    deleteSp(em, jgdm.getJgdm(), "12");
                    source = "check";
                    currentPath = path + "checkSuccess.jsp";
                }
            }.template();

            if(result.equalsIgnoreCase("success")){
                if(clsStringTool.isEmpty(djh)){
                    wsbzBus.updateXbByjgdm(jgdmArr[0].getJgdm(),"3","1",jgdmArr[0]);
                }else{
                    wsbzBus.updateXb(djh,"3","1",jgdmArr[0]);
                }
            }
           return result;
        }

        public String auditValidate() {
            final TJgdm[] jgdmArr = {null};
            String result = new ActionUtils(session) {
                @Override
                protected void excute() throws Exception {
                    User user = (User) session.get("sysUser");
                    if (jgdm.getJgdm() == null) {
                        throw new Exception("输入机构代码错误");
                    }
                    jgdm = em.find(TJgdm.class, jgdm.getJgdm());
                    jgdmArr[0] = jgdm;
                    deleteSp(em, jgdm.getJgdm(), "01");
                    TSpdmtemp spdm = new TSpdmtemp();
                    BeanUtilsEx.copyProperties(spdm, jgdm);
                    spdm.setLry(user.getUserName());
                    spdm.setCzreason(fzreason);
                    spdm.setCzyj(fzyj);
                    em.persist(spdm);
                    TSp sp = new TSp();
                    sp.setGllsh(spdm.getLsh());
                    sp.setFlag("0");
                    sp.setShflag("0");
                    sp.setYwlx("01");
                    sp.setSubmitType(submitType);
                    sp.setJgdm(jgdm.getJgdm());
                    sp.setRecexzqh(InitSysParams.system.getXzqhdm().trim());
                    sp.setSendxzqh(jgdm.getBzjgdm());
                    sp.setSendman(user.getUserName());
                    sp.setSendtime(new Date());
                    em.persist(sp);
                    setTitle("审核 &gt;&gt; 网上业务 &gt;&gt; 代码注销 &gt;&gt; 发送申请");
                    setMessage("向省中心提交机构代码（" + jgdm.getJgdm() + "）" + (submitType == 0 ? "" : submitType == 1 ? "重名" : submitType == 2 ? "重注册号" : "名称和注册号重复") + "注销请求成功！");
                    setSource("validate");
                    currentPath = path + "success.jsp";
                }
            }.template();

            if(result.equalsIgnoreCase("success")){
                wsbzBus.saveWsyw(jgdmArr[0].getJgdm(),jgdmArr[0].getJgmc(),"6","3",djh);
            }
            return result;
        }

        public String validateDM() {
            if (submitType != 0) {
                return auditValidate();
            }
            String result = new ActionUtils(session) {
                @Override
                protected void excute() throws Exception {
                    User user = (User) session.get("sysUser");
                    jgdm = em.find(TJgdm.class, jgdm.getJgdm());
                    TFzdm fzdm = new TFzdm();
                    if (audit) {
                        TSpdmtemp spdm = getSpdm(em, jgdm.getJgdm(), "01");
                        if (spdm == null) {
                            throw new Exception("提交审核数据不存在");
                        } else {
                            BeanUtilsEx.copyProperties(fzdm, spdm);
                        }
                    } else {
                        BeanUtilsEx.copyProperties(fzdm, jgdm);
                    }

                    fzdm.setFzyj(fzyj);
                    fzdm.setFzreason(fzreason);
                    fzdm.setFzrq(new Date());
                    fzdm.setFzr(user.getUserName());
                    em.persist(fzdm);
                    String sql = "delete TJgdm where jgdm='" + jgdm.getJgdm() + "'";
                    em.createQuery(sql).executeUpdate();
                    addCzjl(em, jgdm, "代码注销", "3", null);
                    if (("1".equals(jgdm.getDybz()))) {
                        TBlack black = new TBlack();
                        BeanUtilsEx.copyProperties(black, jgdm);
                        black.setXzqh(InitSysParams.system.getXzqhdm().trim());
                        black.setCzr(user.getUserName());
                        black.setDjh("组代管-" + InitSysParams.system.getXzqhdm().trim() + "-" + jgdm.getZslsh());
                        if (jgdm.getBzrq() != null && jgdm.getZfrq() != null)
                            black.setYxdate("自" + DateUtil.dateToStr(jgdm.getBzrq()) + "至" + DateUtil.dateToStr(jgdm.getZfrq()));
                        black.setCzrq(new Date());
                        em.persist(black);
                        sql = "update  TZs set flag='" + 0 + "' where  jgdm='" + jgdm.getJgdm() + "'";
                        em.createQuery(sql).executeUpdate();
                    }
                    if ("1".equals(jgdm.getFkbz())) {
                        sql = "SELECT model FROM TkFkk model WHERE model.jgdm =:jgdm";
                        Date date = new Date();
                        List<TkFkk> fkks = em.createQuery(sql).setParameter("jgdm", jgdm.getJgdm()).getResultList();
                        if (fkks != null && !fkks.isEmpty())
                            for (int i = 0; i < fkks.size(); i++) {
                                TkFkk kxxk = fkks.get(i);
                                TkFzk fzk = new TkFzk();
                                fzk.setJgdm(jgdm.getJgdm());
                                fzk.setKxlh(kxxk.getKxlh());
                                fzk.setFzsj(date);
                                fzk.setOperater(user.getUserName());
                                fzk.setXzqh(user.getBzjgdm());
                                em.persist(fzk);
                            }
                        sql = "select model from TkKxxk model where model.jgdm=:jgdm";
                        List<TkKxxk> kxxks = em.createQuery(sql).setParameter("jgdm", jgdm.getJgdm()).getResultList();
                        for (int i = 0; i < kxxks.size(); i++) {
                            TkKxxk kxxk = kxxks.get(i);
                            addCzjl(em, jgdm, "删除卡信息", "B", kxxk.getLsh().longValue());
                        }
                        sql = "delete TkKxxk where jgdm='" + jgdm.getJgdm() + "'";
                        em.createQuery(sql).executeUpdate();
                    } else if ("2".equals(jgdm.getFkbz())) {
                        sql = "select model from TkFkk model where model.jgdm=:jgdm";
                        List<TkFkk> fkks = em.createQuery(sql).setParameter("jgdm", jgdm.getJgdm()).getResultList();
                        if (fkks != null && !fkks.isEmpty()) {
                            for (int i = 0; i < fkks.size(); i++) {
                                TkFkk fkk = fkks.get(i);
                                TkFzk fzk = new TkFzk();
                                fzk.setFzsj(new Date());
                                fzk.setKxlh(fkk.getKxlh());
                                fzk.setJgdm(fkk.getJgdm());
                                fzk.setOperater(user.getUserName());
                                em.persist(fzk);
                                TBlack black = new TBlack();
                                BeanUtilsEx.copyProperties(black, jgdm);
                                black.setXzqh(user.getBzjgdm());
                                black.setLsh(fkk.getKxlh().toString());
                                black.setType("2");
                                black.setCzr(user.getUserName());
                                black.setCzrq(new Date());
                                em.persist(black);
                            }
                            sql = ("UPDATE TkFkk SET flag='0' WHERE flag='1' and jgdm=:jgdm");
                            em.createQuery(sql).setParameter("jgdm", jgdm.getJgdm()).executeUpdate();


                        }
                        sql = "select model from TkKxxk model where model.jgdm=:jgdm";
                        List<TkKxxk> kxxks = em.createQuery(sql).setParameter("jgdm", jgdm.getJgdm()).getResultList();
                        for (TkKxxk kxxk : kxxks) {
                            addCzjl(em, jgdm, "注销卡信息", "B", kxxk.getLsh().longValue());
                        }
                        sql = ("DELETE from  TkKxxk WHERE jgdm=:jgdm");
                        em.createQuery(sql).setParameter("jgdm", jgdm.getJgdm()).executeUpdate();
                    }
                    addTSmrw(em, SmTaskType.注销);
                    ywlclx = 7;
                    type = "注销";
                   deleteSp(em, jgdm.getJgdm(), "01");
                    setTitle("审核 &gt;&gt;网上业务 &gt;&gt; 代码注销 &gt;&gt; 代码注销成功");
                    setMessage(" 机构代码(" + jgdm.getJgdm() + ")注销成功，暂时已经无法使用,若还想重新使用此机构代码,可在已注销恢复模块中操作！");
                    setSource("validate");

                    currentPath = path + "success.jsp";
                }
            }.template();

            if(result.equalsIgnoreCase("SUCCESS")){
                if(clsStringTool.isEmpty(djh)){
    //                if(wsbzBus.isWsywByjgdm(jgdm.getJgdm(),"6")){
                        wsbzBus.updateFzByjgdm(jgdm.getJgdm());
                        wsbzBus.delWsywByjgdm(jgdm.getJgdm(),"6");
    //                }
                }else{
    //                if(wsbzBus.isWsyw(djh,"6")){
                        wsbzBus.updateFz(djh);
                        wsbzBus.delWsyw(djh,"6");
    //                }
                }
            }
            return result;
        }


        public Date getStartDate() {
            return startDate;
        }

        public void setStartDate(Date startDate) {
            this.startDate = startDate;
        }

        public Date getEndDate() {
            return endDate;
        }

        public void setEndDate(Date endDate) {
            this.endDate = endDate;
        }


        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<TFzdm> getFzdms() {
            return fzdms;
        }

        public void setFzdms(List<TFzdm> fzdms) {
            this.fzdms = fzdms;
        }

        public String getAllJgdms() {
            return allJgdms;
        }

        public void setAllJgdms(String allJgdms) {
            this.allJgdms = allJgdms;
        }

        public String getWftzgb() {
            return wftzgb;
        }

        public void setWftzgb(String wftzgb) {
            this.wftzgb = wftzgb;
        }

        public String getYwlx() {
            return ywlx;
        }

        public void setYwlx(String ywlx) {
            this.ywlx = ywlx;
        }

        public String getDjh() {
            return djh;
        }

        public void setDjh(String djh) {
            this.djh = djh;
        }

        public String getXbid() {
            return xbid;
        }

        public void setXbid(String xbid) {
            this.xbid = xbid;
        }
    }