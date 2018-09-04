package com.ninemax.jpa.code.service;

import com.ninemax.jpa.code.model.*;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.global.ThamsEntityManagerHelper;
import com.ninemax.jpa.system.model.User;
import com.ninemax.jpa.util.BeanUtilsEx;
import com.ninemax.jpa.util.DateUtil;
import com.ninemax.jpa.util.FtpUtil;
import com.ninemax.jpa.util.StringUtils;
import com.ninemax.jpa.util.UserPropertiesData;

import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author zhhuiyan
 *         Date: 13-8-6
 *         Time: 下午5:46
 *         Name:
 *         2014-1-3 zhhuiyan 修改添加档案新增的日志记录类型为D6
 */
public class ScanServlet extends HttpServlet {
    private static Logger log = Logger.getLogger(ScanEditServlet.class);
    private static File tempFile = new File(UserPropertiesData.getValueByPropertyName("tempPath") + "/Filelog.log");
    private  FileWriter writer = null;

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String fileName = req.getParameter("fileName");
        String createTime = req.getParameter("createTime");
        String type = req.getParameter("type");
        String database = req.getParameter("database");
        String wdidbs = req.getParameter("wdidbs");
        if (wdidbs != null && !wdidbs.equals("")) {
            wdidbs = URLDecoder.decode(wdidbs, "UTF-8");
        }
        String id = req.getParameter("id");
        String dm = req.getParameter("jgdm");
        String mc = req.getParameter("jgmc");  
//        String mc="";
        if (mc != null && !mc.equals("")) {
        	mc = URLDecoder.decode(mc, "UTF-8");
        }
       
        User user = (User) session.getAttribute("sysUser");
        int fSize=Integer.parseInt(req.getParameter("fSize"));
        TJgdm jgdm = null;
        DFile0 dfile = null;
        EFile0 efile = null;
        //    session.removeAttribute(fileName);
        fileName= URLDecoder.decode(fileName, "UTF-8");
        String file = (String) session.getAttribute(fileName); // req.getParameter("file");
      /**
       * 修复档案上传丢失字节问题        liupeng
       */
        int len=file.length();
        if(fSize!=len){
        	log(fileName,dm,fSize,len);
        	session.removeAttribute(fileName);
        	System.out.println("===============文件异常！！！==============="+dm+":"+fileName);
        	resp.getOutputStream().print("fileNo");
            return;
        }
        
        
        EntityManager thamsManager = ThamsEntityManagerHelper.getEntityManager();
        EntityTransaction thamsTransaction = thamsManager.getTransaction();
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        session.removeAttribute(fileName);
        Date createDate = DateUtil.strToDate(createTime);
        TSmrw task = null;
        if (id != null && !"".equals(id)) {
            task = em.find(TSmrw.class, Integer.valueOf(id.trim()));
            em.clear();
        } else {
            if (database == null || database.equals(TJgdm.class.getName())) {
                jgdm = em.find(TJgdm.class, dm);
                task = new TSmrw();
                BeanUtilsEx.copyProperties(task, jgdm);
            } else if (database.equals(TQzjgdm.class.getName())) {
                TQzjgdm qzjgdm = em.find(TQzjgdm.class, Integer.valueOf(dm));
                if (qzjgdm != null) {
                    task = new TSmrw();
                    BeanUtilsEx.copyProperties(task, qzjgdm);
                }
            } else if (database.equals(TFzdm.class.getName())) {
                TFzdm fzdm = em.find(TFzdm.class, dm);
                if (fzdm != null) {
                    task = new TSmrw();
                    BeanUtilsEx.copyProperties(task, fzdm);
                }
            } else if (database.equals(TBgk.class.getName())) {
                TBgk bgk = em.find(TBgk.class, Long.valueOf(dm.trim()));
                if (bgk != null) {
                    task = new TSmrw();
                    BeanUtilsEx.copyProperties(task, bgk);
                }
            }

            task.setBzjgdm(user.getBzjgdm());
            task.setId(null);
            task.setType(type);
        }
        task.setJgmc(mc);
        task.setStatus(true);
        task.setCreateTime(createDate);
        task.setCompleTime(new Date());
        if (task.getType() == null)
            task.setType(type);
        List<DFile0> file0s = thamsManager.createQuery("select model from DFile0 model where  model.arctype=?1 and model.bzjgdm=?2 and  model.newdate>=?3 and model.jgdm=?4 ").
                setParameter(1, SmTaskType.getDfileType(Integer.valueOf(task.getType()))).
                setParameter(2, user.getBzjgdm()).
                setParameter(3, createDate).
                setParameter(4, dm).
                getResultList();
        thamsManager.clear();
        if (file0s != null && !file0s.isEmpty()) {
            dfile = file0s.get(0);
        }
        if (dfile == null || !(1 == dfile.getAttr() || 2 == dfile.getAttr())) {
            String filePath;
            filePath = DateUtil.dateToStr(new Date(), "yyyy") + "\\" + user.getBzjgdm() + "\\" + DateUtil.dateToStr(new Date(), "yyyyMMdd") + "\\";
            task.setImagePath(filePath + fileName + ".tif");
        }

        if (dfile == null) {
            dfile = new DFile0();
               /* List<Integer> integers = thamsManager.createQuery("select MAX (model.did) from  DFile0 model").getResultList();
                if (integers == null || integers.isEmpty() || integers.size() <= 0 || integers.get(0) == null) {
                    did = 2;
                } else {
                    did = (integers.get(0) % 2 == 1 ? (integers.get(0) + 2) : (integers.get(0) + 1));
                }*/
            BeanUtilsEx.copyProperties(dfile, task, 1, thamsManager, "d_file0");
            dfile.setCreator("bs_" + user.getBzjgdm().trim());
            dfile.setCreatetime(DateUtil.strToDate(DateUtil.dateToStr(task.getCreateTime())));
            dfile.setFddbr(StringUtils.toDBC(task.getFddbr() == null ? "" : task.getFddbr().trim()) + (task.getZjhm() == null ? "" : task.getZjhm().trim()));
            dfile.setNewdate(task.getCreateTime());
            dfile.setModifydate(DateUtil.strToDate(DateUtil.dateToStr(task.getCompleTime())));
            dfile.setArctype(SmTaskType.getDfileType(Integer.valueOf(task.getType())));
            if (dfile.getArctype().equals("年度验证") || dfile.getArctype().equals("变更")) {
                System.out.printf("setEditor1");
                if ("7".equals(dfile.getJglx().trim())) {
                    System.out.printf("setEditor11");
                    //dfile.setEditor("法人身份证+批准成立文件");
                    dfile.setEditor("批准+法人");

                } else {
                    System.out.printf("setEditor12");
                    dfile.setEditor("法人身份证");
                }
            }
            dfile.setDocmemo((user.getBzjgdm() == null ? "" : user.getBzjgdm().trim()) + "-" + DateUtil.dateToStr(new Date(), "yyyyMMdd") + dfile.getJgdm().trim() + (dfile.getJglx() == null ? "" : dfile.getJglx().trim()));
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
            if ("预赋码".equals(dfile.getArctype()))
                dfile.setGk("1");
            efile = new EFile0();
            efile.setEfilename(fileName + ".tif");
            efile.setTitle(dm + task.getJgmc());
            efile.setExt("tif");
            efile.setPzm(FtpUtil.getSFwqpz().getPzname());
            efile.setPathname(task.getImagePath().substring(0, task.getImagePath().lastIndexOf("\\")));
            efile.setStatus(0);
            efile.setAttr(1);
            efile.setAttrex(0);
            efile.setCreator(user.getUserName());
            efile.setCreatetime(new Date());
        } else {
            dfile.setNewdate(createDate);
            dfile.setPagesame(-1);
            dfile.setErrorflag(-1);
            dfile.setAttr(1);
            dfile.setIsMini(wdidbs != null && wdidbs.contains("小微企业证明材料") ? 1 : 0);
            efile = (EFile0) thamsManager.createQuery("select model from EFile0  model where model.pid=?1 ").setParameter(1, dfile.getDid()).getSingleResult();
            task.setImagePath(efile.getPathname() + "\\" + efile.getEfilename());
        }
        try {
            writeFileByFTP(file, task.getImagePath(), session);
        } catch (Exception e) {
            log.error(ScanServlet.class, e);
            resp.getOutputStream().print("nok");
            return;
        }
        TSmrwwc smrwwc = new TSmrwwc();
        if (task.getType() == null) {
            task.setType(type);
        }
        BeanUtilsEx.copyProperties(smrwwc, task);
        TCzjl czjl = new TCzjl();
        czjl.setJgdm(dm);
        czjl.setMemo("电子档案上传");
        czjl.setName(user.getUserName());
        if (task.getId() == null) {
            czjl.setType("D6");
        } else {
            czjl.setType("DA");
        }
        czjl.setDate(new Date());
        czjl.setXzqh(user.getBzjgdm());
        smrwwc.setId(null);
        smrwwc.setJgmc(mc);
        synchronized (log) {
            thamsTransaction.begin();
            tx.begin();
            try {
                thamsManager.createQuery("delete  from  PFile0 model where model.pid=?1 ").setParameter(1, dfile.getDid()).executeUpdate();
                if (dfile.getDid() == null) {
                    thamsManager.persist(dfile);
                } else {
                    thamsManager.merge(dfile);
                }
                thamsManager.flush();
                efile.setPid(dfile.getDid());
                if (efile.getDid() == null) {
                    thamsManager.persist(efile);
                } else {
                    thamsManager.merge(efile);
                }
                String[] imagePages = null;
                if (wdidbs != null && !wdidbs.equals("")) {
                    imagePages = wdidbs.split("%");
                    for (int i = 0; i < imagePages.length; i++) {
                        PFile0 pFile0 = new PFile0();
                        pFile0.setPid(dfile.getDid());
                        pFile0.setPageno(i + 1);
                        pFile0.setPagetype(imagePages[i]);
                        thamsManager.persist(pFile0);
                    }
                }
                thamsManager.flush();
                em.persist(smrwwc);
                em.persist(czjl);
                em.createQuery("delete from TSmrw where jgdm=?1 and type=?2 ").setParameter(1, task.getJgdm()).setParameter(2, type).executeUpdate();
                em.flush();
                thamsTransaction.commit();
                tx.commit();
            } catch (Exception e) {
                log.error(ScanServlet.class, e);
                tx.rollback();
                thamsTransaction.rollback();
                resp.getOutputStream().print("nok");
                return;
            } finally {
                EntityManagerHelper.closeEntityManager();
                ThamsEntityManagerHelper.closeEntityManager();
            }
        }

        resp.getOutputStream().print("ok");
    }

    private void writeFileByFTP(String file, String filePath, HttpSession session) throws Exception {
        FtpUtil ftpUtil = new FtpUtil();
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
    
    public synchronized void log(String fileName,String dm,int cSize,int sSize){
    	  

        try {
      	  if (!tempFile.exists()) {
      		  tempFile.createNewFile();
      	  }
      	  
      	  double size = (double) tempFile.length() / 1024 / 1024; 
      	  if(size>5 ){
      		  writer = new FileWriter(tempFile, false);
      	  }else{
      		  writer = new FileWriter(tempFile, true);
      	  }

            writer.write("fileName:" + fileName + "\n");
            writer.write("jgdm:【" + dm + "】");
            writer.write("源文件大小(" + cSize + ")");
            writer.write("实际文件大小(" + sSize + ")");
            writer.write("TIME:" +new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+  "\r\n");
            writer.flush();
            writer.close();
        } catch (IOException e) {
          
        }
  	
  }

    @Override
    public void destroy() {
        super.destroy();
    }
}
