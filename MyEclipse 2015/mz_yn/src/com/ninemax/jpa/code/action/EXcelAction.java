package com.ninemax.jpa.code.action;

import com.ninemax.jpa.code.model.TJgdm;
import com.ninemax.jpa.util.ExportTxtUtil;
import com.ninemax.jpa.util.clsStringTool;
import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.*;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * * User: zhhuiyan
 * Date: 13-5-9
 * Time: ����10:56
 * Name:${Name}
 */
public class EXcelAction {
    private static Logger log = Logger.getLogger(EXcelAction.class);

    private List<TJgdm> jgdms ;
    /**
     * ������־����txt - ʡ��
     * @return
     */
    public String export(){
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        String path = ServletActionContext.getServletContext().getRealPath("/txt/export.xls");
        File file = new File(path);
        Map<String, String> params = new HashedMap();
//        if(!clsStringTool.isEmpty(startDate)){
//            params.put("startDate",startDate);
//        }
//        if(!clsStringTool.isEmpty(endDate)){
//            params.put("endDate",endDate);
//        }
//        if(!clsStringTool.isEmpty(jgdm)){
//            params.put("jgdm",jgdm);
//        }
//        if(!clsStringTool.isEmpty(xzqh)){
//            params.put("xzqh",xzqh);
//        }
//        if(!clsStringTool.isEmpty(name)){
//            params.put("name",name);
//        }
//        list = czjlBus.listOperRecords(params);
        //����txt
        List<String> properties = new ArrayList<String>();
        properties.add("jgdm");
        properties.add("name");
        properties.add("type");
        properties.add("date");
        String[] strings = new String[]{"��������","����Ա","��������","��������"};
        ExportTxtUtil.setTitle(strings);
        ExportTxtUtil.setProperties(properties);
//        ExportTxtUtil.transferModelToTxt(file,(List)list);
        try {
            //�����Ĵ���
            byte[] bt = null;
            ServletOutputStream outt = null;
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream(4096);
            byte[] cache = new byte[4096];
            for (int offset = fis.read(cache); offset != -1; offset = fis.read(cache)) {
                byteOutputStream.write(cache, 0, offset);
            }
            bt = byteOutputStream.toByteArray();
            response.reset();
            response.setContentType("application/octet-stream");
            response.addHeader("Content-Disposition","attachment; filename=" + java.net.URLEncoder.encode(file.getName(), "UTF-8"));
            outt = response.getOutputStream();
            outt.write(bt);
            outt.flush();
            outt.close();
            fis.close();
            if(file.exists()){
                file.delete();
            }
        } catch (IOException e) {
          log.error(EXcelAction.class,e);
        }
        return null;
    }
    public  void main(String[] args) throws Exception
    {
        // ��һ��������һ��webbook����Ӧһ��Excel�ļ�
        HSSFWorkbook wb = new HSSFWorkbook();
        // �ڶ�������webbook�����һ��sheet,��ӦExcel�ļ��е�sheet
        HSSFSheet sheet = wb.createSheet("ѧ����һ");
        // ����������sheet����ӱ�ͷ��0��,ע���ϰ汾poi��Excel����������������short
        HSSFRow row = sheet.createRow((int) 0);
        // ���Ĳ���������Ԫ�񣬲�����ֵ��ͷ ���ñ�ͷ����
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // ����һ�����и�ʽ

        HSSFCell cell = row.createCell( 0);
        cell.setCellValue("ѧ��");
        cell.setCellStyle(style);
        cell = row.createCell(1);
        cell.setCellValue("����");
        cell.setCellStyle(style);
        cell = row.createCell(2);
        cell.setCellValue("����");
        cell.setCellStyle(style);
        cell = row.createCell(3);
        cell.setCellValue("����");
        cell.setCellStyle(style);

        // ���岽��д��ʵ������ ʵ��Ӧ������Щ���ݴ����ݿ�õ���
//        List list = CreateSimpleExcelToDisk.getStudent();
//
//        for (int i = 0; i < jgdms.size(); i++)
//        {
//            row = sheet.createRow((int) i + 1);
//            Student stu = (Student) list.get(i);
//            // ���Ĳ���������Ԫ�񣬲�����ֵ
//            row.createCell(0).setCellValue((double) stu.getId());
//            row.createCell(1).setCellValue(stu.getName());
//            row.createCell(2).setCellValue((double) stu.getAge());
//            cell = row.createCell(3);
//            cell.setCellValue(new SimpleDateFormat("yyyy-mm-dd").format(stu
//                    .getBirth()));
//        }
        // �����������ļ��浽ָ��λ��
        try
        {
            FileOutputStream fout = new FileOutputStream("E:/students.xls");
            wb.write(fout);
            fout.close();
        }
        catch (Exception e)
        {
            log.error(EXcelAction.class,e);
        }
    }

    public List<TJgdm> getJgdms() {
        return jgdms;
    }

    public void setJgdms(List<TJgdm> jgdms) {
        this.jgdms = jgdms;
    }
}
