package com.ninemax.jpa.util;

import com.ninemax.jpa.code.model.*;
import com.ninemax.jpa.global.InitSysParams;
import com.ninemax.jpa.global.ThamsEntityManagerHelper;
import com.ninemax.jpa.system.model.User;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ninemax-199
 * Date: 13-10-8
 * Time: 下午6:07
 * To change this template use File | Settings | File Templates.
 */
public class SmrwUtils {
    public static void addTSmrw(EntityManager em, SmTaskType type, TJgdm jgdm, User user) {
        if (isrw(type)) {
            addrw(em, type, jgdm, user);
        }
    }

    private static boolean isrw(SmTaskType type) {
        TSystem system = InitSysParams.system;
        if (system.getIsSmTask())
            switch (type) {
                case 省内迁入:
                    return system.getSnqrSmTask();
                case 新增:
                    return system.getAddJgdmSmTask();
                case 其他赋码:
                    return system.getQtfmSmTask();
                case 预赋码更新:
                    return system.getAddJgdmSmTask();
                case 变更:
                    return system.getBgSmTask();
                case 换证:
                    return system.getHzSmTask();
                case 年检:
                    return system.getNjSmTask();
                case 省间迁入:
                    return system.getSjjrSmTask();
                case 省间迁出:
                    return system.getSjqcSmTask();
                case 预赋码:
                    return system.getYfmSmTask();
                case 省内迁出:
                    return system.getSnqcSmTask();
                case 注销恢复:
                    return system.getFzhfSmTask();
                case 注销:
                    return system.getFzSmTask();
            }

        return false;
    }

    private static void rw(EntityManager em, SmTaskType type, TJgdm jgdm) {
        List<TSmrw> rws = em.createQuery("select model from TSmrw model where model.type=?1 and model.createTime >= ?2 and model.jgdm=?3 ")
                .setParameter(1, type.getValue().toString())
                .setParameter(2, DateUtil.strToDate(DateUtil.dateToStr(new Date())))
                .setParameter(3, jgdm.getJgdm()).getResultList();
        if (rws.isEmpty() || rws.size() <= 0) {
            TSmrw task = new TSmrw();
            BeanUtilsEx.copyProperties(task, jgdm);
            task.setId(null);
            task.setCreateTime(new Date());
            task.setStatus(false);
            task.setType(type.getValue().toString());
            em.persist(task);
        }
    }

    private static void addrw(EntityManager em, SmTaskType type, TJgdm jgdm, User user) {
        if (InitSysParams.system.getQzsm() == null || !InitSysParams.system.getQzsm()) {
            rw(em, type, jgdm);
        } else {
            List<TQzsm> rws = em.createQuery("select model from TQzsm model where model.type=?1 and model.createTime >= ?2 and model.jgdm=?3 ").setParameter(1, type.getValue().toString())
                    .setParameter(2, DateUtil.strToDate(DateUtil.dateToStr(new Date())))
                    .setParameter(3, jgdm.getJgdm()).getResultList();
            if (!rws.isEmpty() && rws.size() > 0) {
                TQzsm qzsm = rws.get(0);
                makeDfile(em, qzsm, user);
            } else {
                //TODO 是否需要
                rw(em, type, jgdm);
            }
        }
    }

    private static void makeDfile(EntityManager em, TQzsm task, User user) {
        EntityManager thamsManager = ThamsEntityManagerHelper.getEntityManager();
        String[] names = task.getImagePath().split("\\.")[0].split("\\\\");
        String fileName = names[names.length - 1];
        List<TArchivePage> pages = em.createQuery("select model from TArchivePage model where  model.archid=?1 order by  model.pageno ").setParameter(1, fileName).getResultList();
        String wdidbs = "";
        em.clear();
        for (TArchivePage page : pages) {
            wdidbs += (page.getPagetype() + "%");
            em.remove(page);
        }
        DFile0 dfile = new DFile0();
        List<Integer> integers = thamsManager.createQuery("select MAX (model.did) from  DFile0 model").getResultList();
        int did;
        if (integers == null || integers.isEmpty() || integers.size() <= 0 || integers.get(0) == null) {
            did = 2;
        } else {
            did = (integers.get(0) % 2 == 1 ? (integers.get(0) + 2) : (integers.get(0) + 1));
        }
        BeanUtilsEx.copyProperties(dfile, task, 1, thamsManager, "d_file0");
        dfile.setDid(did);
        dfile.setCreator("bs_" + user.getBzjgdm().trim());
        dfile.setCreatetime(DateUtil.strToDate(DateUtil.dateToStr(task.getCreateTime())));
        dfile.setFddbr(task.getFddbr() + task.getZjhm());
        dfile.setNewdate(task.getCreateTime());
        dfile.setModifydate(DateUtil.strToDate(DateUtil.dateToStr(task.getCompleTime())));
        dfile.setArctype(SmTaskType.getDfileType(Integer.valueOf(task.getType())));
        dfile.setDocmemo(user.getBzjgdm() + "-" + DateUtil.dateToStr(new Date(), "yyyyMMdd") + dfile.getJgdm() + dfile.getJglx());
        dfile.setIsMini(wdidbs != null && wdidbs.contains("小微企业证明材料") ? 1 : 0);
        dfile.setAttr(1);
        dfile.setStatus(0);
        dfile.setPageflag(0);
        dfile.setPagesame(0);
        dfile.setScamodal(-1);
        dfile.setErrorflag(-1);
        dfile.setPid(-1);
        dfile.setQzh("-1");
        dfile.setDocid(fileName);
             /*   Map<Object,Object> a= BeanUtilsEx.describe(dfile);
                for (Map.Entry<Object,Object> s:a.entrySet()){
                    System.out.println("s.getKey()" + s.getKey() + ":" + s.getValue());
                }*/
        thamsManager.persist(dfile);
        integers = thamsManager.createQuery("select MAX (model.did) from  EFile0 model").getResultList();
        if (integers == null || integers.isEmpty() || integers.size() <= 0 || integers.get(0) == null) {
            did = 2;
        } else {
            did = (integers.get(0) % 2 == 1 ? (integers.get(0) + 2) : (integers.get(0) + 1));
        }
        EFile0 efile = new EFile0();
        efile.setDid(did);
        efile.setPid(dfile.getDid());
        efile.setEfilename(fileName + ".tif");
        efile.setTitle(task.getJgdm() + task.getJgmc());
        efile.setExt("tif");
        efile.setPzm(new FtpUtil().getSFwqpz().getPzname());
        efile.setPathname(task.getImagePath().substring(0, task.getImagePath().lastIndexOf("\\")));
        efile.setStatus(0);
        efile.setAttr(1);
        efile.setAttrex(0);
        efile.setCreator(user.getUserName());
        efile.setCreatetime(new Date());
        thamsManager.persist(efile);
        String[] imagePages = wdidbs.split("%");
        for (int i = 0; i < imagePages.length; i++) {
            did += 2;
            PFile0 pFile0 = new PFile0();
            pFile0.setDid(did);
            pFile0.setPid(dfile.getDid());
            pFile0.setPageno(i + 1);
            pFile0.setPagetype(imagePages[i]);
            thamsManager.persist(pFile0);
            thamsManager.flush();
        }
        TSmrwwc smrwwc = new TSmrwwc();
        BeanUtilsEx.copyProperties(smrwwc, task);
        smrwwc.setId(null);
        em.persist(smrwwc);
        em.remove(em.getReference(TQzsm.class, task.getId()));
        thamsManager.flush();
    }
}
