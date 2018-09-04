package com.ninemax.jpa.code.service;

import com.ninemax.jpa.code.model.*;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.global.ThamsEntityManagerHelper;
import com.ninemax.jpa.util.DateUtil;
import com.ninemax.jpa.util.FtpUtil;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * * User: zhhuiyan
 * Date: 13-8-6
 * Time: 下午5:46
 * Name:${Name}
 */
public class ScanEditServlet extends HttpServlet {
    private static Logger log = Logger.getLogger(ScanEditServlet.class);
    private FtpUtil ftpUtil;

    @Override
    public void init() throws ServletException {
        super.init();
        ftpUtil = new FtpUtil();//To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    protected synchronized void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String newdate = req.getParameter("newdate");
        String wdidbs = req.getParameter("wdidbs");
        if (wdidbs != null && !wdidbs.equals(""))
            wdidbs = URLDecoder.decode(wdidbs, "UTF-8");
        String did = req.getParameter("did");
        String arctype = req.getParameter("arctype");
        EntityManager thamsManager = ThamsEntityManagerHelper.getEntityManager();
        EntityTransaction thamsTransaction = thamsManager.getTransaction();
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        thamsTransaction.begin();
        tx.begin();
        try {
            Date createDate = null;
            if (newdate != null && !"".equals(newdate))
                createDate = DateUtil.strToDate(newdate);
            //  String file = session.getAttribute(fileName).toString();
            DFile0 dfile = null;
            EFile0 efile = null;
            //   session.removeAttribute(fileName);
          //  String file = req.getParameter("file");
            String fileName = req.getParameter("fileName");
            fileName= URLDecoder.decode(fileName, "UTF-8");
            String file = (String) session.getAttribute(fileName); // req.getParameter("file");
            session.removeAttribute(fileName);
            dfile = thamsManager.find(DFile0.class, Integer.valueOf(did));
            thamsManager.clear();
            List<TSmrwwc> smrwwcs = em.createQuery("select model from  TSmrwwc model where model.imagePath like '%" + dfile.getDocid() + "%' ").getResultList();
            for (TSmrwwc smrwwc : smrwwcs) {
                smrwwc.setCreateTime(dfile.getNewdate());
            }

            if (createDate != null)
                dfile.setNewdate(createDate);
            if (arctype != null && !"".equals(arctype)) {
                for (Map.Entry<String, String> entry : SmTaskType.dTypes().entrySet()) {
                    if (entry.getValue().equals(arctype)) {
                        dfile.setArctype(entry.getKey());
                    }
                }
            }
            efile = (EFile0) thamsManager.createQuery("select model from EFile0  model where model.pid=?1 ").setParameter(1, dfile.getDid()).getSingleResult();
            String[] imagePages = null;

            imagePages = wdidbs.split("%");
            writeFileByFTP(file, efile.getPathname() + "\\" + efile.getEfilename(), session);
            file = null;
            System.gc();
            dfile.setPagesame(-1);
            dfile.setAttr(1);
            dfile.setErrorflag(-1);
            dfile.setIsMini(wdidbs != null && wdidbs.contains("小微企业证明材料") ? 1 : 0);
            thamsManager.merge(dfile);
            thamsManager.flush();
            thamsManager.createQuery("delete  from  PFile0 model where model.pid=?1").setParameter(1, dfile.getDid()).executeUpdate();
            thamsManager.flush();
            for (int i = 0; i < imagePages.length; i++) {
                PFile0 pFile0 = new PFile0();
                pFile0.setPid(dfile.getDid());
                pFile0.setPageno(i + 1);
                pFile0.setPagetype(imagePages[i]);
                thamsManager.persist(pFile0);
                thamsManager.flush();
            }
            thamsTransaction.commit();
            tx.commit();
        } catch (Exception e) {
            log.error(ScanEditServlet.class, e);
            tx.rollback();
            thamsTransaction.rollback();
            resp.getOutputStream().print("nok");
            return;
        } finally {
            EntityManagerHelper.closeEntityManager();
            ThamsEntityManagerHelper.closeEntityManager();
        }
        resp.getOutputStream().print("ok");
    }

    private void writeFileByFTP(String file, String filePath, HttpSession session) throws Exception {
        if (ftpUtil == null)
            ftpUtil = new FtpUtil();
        try {
            String path = filePath.substring(0, filePath.lastIndexOf("\\"));
            if (ftpUtil.connectServer(path)) {
                if (ftpUtil.upload(file, filePath.substring(filePath.lastIndexOf("\\") + 1), session)) {
                    log.info("档案上传成功!");
                } else {
                    throw new Exception("上传字节数<0！");
                }
            } else {
                throw new Exception("没有配置ftp服务器");
            }
        } finally {
            ftpUtil.closeServer();
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("GBK");
        doPost(request, response);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
