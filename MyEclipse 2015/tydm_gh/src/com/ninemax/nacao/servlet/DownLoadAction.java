package com.ninemax.nacao.servlet;

import com.ninemax.jpa.code.model.TSmrwwc;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.global.ThamsEntityManagerHelper;
import com.ninemax.jpa.util.DateUtil;
import com.ninemax.jpa.util.FileHelp;
import com.ninemax.jpa.util.FtpUtil;
import com.ninemax.jpa.util.UserPropertiesData;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-12-27
 * Time: ÏÂÎç1:43
 */
public class DownLoadAction extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            EntityManager em = EntityManagerHelper.getEntityManager();
            String id = request.getParameter("id");
            TSmrwwc task = em.find(TSmrwwc.class, Integer.valueOf(id));
            String filePath = task.getImagePath();
            System.out.println("filePath = " + filePath);
            FtpUtil ftpUtil = new FtpUtil();
            String imagePath = (filePath.substring(0, filePath.lastIndexOf("\\")));
            String name = filePath.substring(filePath.lastIndexOf("\\") + 1);
            if (ftpUtil.connectServer(imagePath)) {
                response.reset();
                response.setContentType("application/image/tiff,CHARSET=utf-8");
                String str = URLEncoder.encode(name, "utf-8");
                response.addHeader("Content-Disposition", "attachment; filename=" + str + "");
                java.io.OutputStream os = response.getOutputStream();
                if (ftpUtil.download(name, os)) {
                }
                os.flush();
                os.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
