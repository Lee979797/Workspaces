package com.ninemax.nacao.servlet;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.com.jit.ida.util.pki.cipher.Session;

import com.ninemax.jpa.global.InitSysParams;
import com.ninemax.jpa.util.CommonPropertiesUtil;
import com.ninemax.nacao.business.message.AttachmentBus;
import com.ninemax.nacao.to.message.AttachmentTO;

@SuppressWarnings("serial") 
public class Upload extends HttpServlet {
    @SuppressWarnings("unchecked")
    //TODO：如果是在action中，记得request对象
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	AttachmentBus attachmentBus = new AttachmentBus();
        String savePath = CommonPropertiesUtil.getValue("common.properties", "filepath");;
        String uuid = request.getSession().getAttribute("uuid").toString(); // 此次公告里的附件唯一标识
        
        String tempPath = savePath + "/uploadsTempFolder/";
        File f1 = new File(tempPath);
        System.out.println(tempPath);
        if (!f1.exists()) {
            f1.mkdirs();
        }
        DiskFileItemFactory fac = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(fac);
        upload.setHeaderEncoding("utf-8");
        List fileList = null;
        try {
           fileList = upload.parseRequest(request);
        } catch (FileUploadException ex) {
            return;
        }
        Iterator<FileItem> it = fileList.iterator();
        String name = "";
        String extName = "";
        String fileName = "";
        //在下面的循环中一个一个的保存到指定目录中，这里是新建文件的形式??不是copy
        while (it.hasNext()) {
            FileItem item = it.next();
            //判断提交上来的是否是????完整的表单域（formField??
            if (!item.isFormField()) {
                name = item.getName();
                //TODO:下面的size和type可以不要
                long size = item.getSize();
                String type = item.getContentType();
                System.out.println(size + " " + type);
                //这应该是保护性的语句
                if (name == null || name.trim().equals("")) {
                    continue;
                }
                //扩展名格式： 
                if (name.lastIndexOf(".") >= 0) {
                   extName = name.substring(name.lastIndexOf("."));
                   fileName= name.replaceAll(extName, "").trim();
                }
                File file = null;
                //TODO:这个do while要改??
                //这个循环的作用也是防御??的？先生成，再判断，否则重新生成
                do {
                    //生成文件名：
                	 SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss"); 
                	 String str=sdf.format(new Date());    

                	//TODO:这个name不能只用UUID，??要用UUID+分隔??原文件名??
                	 name = fileName + str;
                    file = new File(tempPath + name + extName);
                } while (file.exists());
                File saveFile = new File(tempPath + name + extName);
                try {
                    item.write(saveFile);
                    //文件已保存 -> 开始保存文件相关信息
                    AttachmentTO attachmentTO = new AttachmentTO();
                    attachmentTO.setFileName(item.getName());
                    attachmentTO.setSaveName(name+extName);
                    attachmentTO.setMessage_ids(uuid);
                    attachmentBus.saveAttachmentInfo(attachmentTO);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        request.setAttribute("uuid", uuid);
        response.setContentType ("text/plain;charset=utf-8");  
        response.getWriter().append("!"); 
        //TODO:这样，所有文件就已经被保存到了服务器中，链接就是唯一的文件名，需要保存下来交给service层来处理
        //        response.getWriter().print(name + extName);
    }
}

