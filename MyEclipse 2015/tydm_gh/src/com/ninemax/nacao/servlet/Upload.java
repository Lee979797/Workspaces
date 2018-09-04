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
    //TODO���������action�У��ǵ�request����
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	AttachmentBus attachmentBus = new AttachmentBus();
        String savePath = CommonPropertiesUtil.getValue("common.properties", "filepath");;
        String uuid = request.getSession().getAttribute("uuid").toString(); // �˴ι�����ĸ���Ψһ��ʶ
        
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
        //�������ѭ����һ��һ���ı��浽ָ��Ŀ¼�У��������½��ļ�����ʽ??����copy
        while (it.hasNext()) {
            FileItem item = it.next();
            //�ж��ύ�������Ƿ���????�����ı���formField??
            if (!item.isFormField()) {
                name = item.getName();
                //TODO:�����size��type���Բ�Ҫ
                long size = item.getSize();
                String type = item.getContentType();
                System.out.println(size + " " + type);
                //��Ӧ���Ǳ����Ե����
                if (name == null || name.trim().equals("")) {
                    continue;
                }
                //��չ����ʽ�� 
                if (name.lastIndexOf(".") >= 0) {
                   extName = name.substring(name.lastIndexOf("."));
                   fileName= name.replaceAll(extName, "").trim();
                }
                File file = null;
                //TODO:���do whileҪ��??
                //���ѭ��������Ҳ�Ƿ���??�ģ������ɣ����жϣ�������������
                do {
                    //�����ļ�����
                	 SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss"); 
                	 String str=sdf.format(new Date());    

                	//TODO:���name����ֻ��UUID��??Ҫ��UUID+�ָ�??ԭ�ļ���??
                	 name = fileName + str;
                    file = new File(tempPath + name + extName);
                } while (file.exists());
                File saveFile = new File(tempPath + name + extName);
                try {
                    item.write(saveFile);
                    //�ļ��ѱ��� -> ��ʼ�����ļ������Ϣ
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
        //TODO:�����������ļ����Ѿ������浽�˷������У����Ӿ���Ψһ���ļ�������Ҫ������������service��������
        //        response.getWriter().print(name + extName);
    }
}

