package com.ninemax.jpa.code.service;

import com.ninemax.jpa.code.model.*;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.system.model.User;
import com.ninemax.jpa.util.DateUtil;
import com.ninemax.jpa.util.FilePathStr;
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

/**
 * @author zhhuiyan
 *         Date: 13-8-6
 *         Time: 下午5:46
 *         Name:${Name}
 */
public class QzsmServlet extends HttpServlet {
    private static Logger log = Logger.getLogger(ScanEditServlet.class);
    private FtpUtil ftpUtil;

    @Override
    public void init() throws ServletException {
        super.init();
        ftpUtil = new FtpUtil();
    }

    @Override
    protected synchronized void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String fileName = req.getParameter("fileName");
        String type = req.getParameter("type");
        String wdidbs = req.getParameter("wdidbs");
        String id = req.getParameter("id");
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        User user = (User) session.getAttribute("sysUser");
        tx.begin();
        try {

            String file = req.getParameter("file");
            TQzsm task = em.find(TQzsm.class, Integer.valueOf(id));
            em.clear();
            task.setBzjgdm(user.getBzjgdm());
            task.setStatus(true);
            task.setCreateTime(new Date());
            task.setCompleTime(new Date());
            if (task.getType() == null)
                task.setType(type);
            fileName = URLDecoder.decode(fileName, "UTF-8");
            String filePath;
            filePath = DateUtil.dateToStr(new Date(), "yyyy") + "\\" + user.getBzjgdm() + "\\" + DateUtil.dateToStr(new Date(), "yyyyMMdd") + "\\";
            if (filePath.matches("\\\\.*")) {
                filePath = session.getServletContext().getRealPath(filePath);
            }
            FilePathStr.createFilePath(filePath);
            task.setImagePath(filePath + fileName + ".tif");
            String[] imagePages = null;
            if (wdidbs != null && !wdidbs.equals("")) {
                wdidbs = URLDecoder.decode(wdidbs, "UTF-8");
                imagePages = wdidbs.split("%");
                for (int i = 0; i < imagePages.length; i++) {
                    em.createNativeQuery(" insert into T_ARCHIVEPAGE(ARCHID,PAGENO,PAGETYPE) values('"+fileName+"','" + (i + 1)+"','"+imagePages[i]+"') ").executeUpdate();
                }
            }
            writeFileByFTP(file, task.getImagePath(), session);
            em.merge(task);
            em.flush();
            tx.commit();

        } catch (Exception e) {
            log.error(QzsmServlet.class, e);
            tx.rollback();
            resp.getOutputStream().print("nok");
            return;
        } finally {
            EntityManagerHelper.closeEntityManager();
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
                } else
                    throw new Exception("上传字节数<0！");
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
        try {
            ftpUtil.closeServer();
            ftpUtil = null;
        } catch (Exception e) {
            log.error(QzsmServlet.class, e);
        }
    }
}
