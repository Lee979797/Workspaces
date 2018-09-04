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
 * Time: 上午10:56
 * Name:${Name}
 */
public class EXcelAction {
    private static Logger log = Logger.getLogger(EXcelAction.class);

    private List<TJgdm> jgdms ;
    /**
     * 操作日志导出txt - 省级
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
        //导出txt
        List<String> properties = new ArrayList<String>();
        properties.add("jgdm");
        properties.add("name");
        properties.add("type");
        properties.add("date");
        String[] strings = new String[]{"机构代码","操作员","操作类型","操作日期"};
        ExportTxtUtil.setTitle(strings);
        ExportTxtUtil.setProperties(properties);
//        ExportTxtUtil.transferModelToTxt(file,(List)list);
        try {
            //导出的代码
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
        // 第一步，创建一个webbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet("学生表一");
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        HSSFRow row = sheet.createRow((int) 0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

        HSSFCell cell = row.createCell( 0);
        cell.setCellValue("学号");
        cell.setCellStyle(style);
        cell = row.createCell(1);
        cell.setCellValue("姓名");
        cell.setCellStyle(style);
        cell = row.createCell(2);
        cell.setCellValue("年龄");
        cell.setCellStyle(style);
        cell = row.createCell(3);
        cell.setCellValue("生日");
        cell.setCellStyle(style);

        // 第五步，写入实体数据 实际应用中这些数据从数据库得到，
//        List list = CreateSimpleExcelToDisk.getStudent();
//
//        for (int i = 0; i < jgdms.size(); i++)
//        {
//            row = sheet.createRow((int) i + 1);
//            Student stu = (Student) list.get(i);
//            // 第四步，创建单元格，并设置值
//            row.createCell(0).setCellValue((double) stu.getId());
//            row.createCell(1).setCellValue(stu.getName());
//            row.createCell(2).setCellValue((double) stu.getAge());
//            cell = row.createCell(3);
//            cell.setCellValue(new SimpleDateFormat("yyyy-mm-dd").format(stu
//                    .getBirth()));
//        }
        // 第六步，将文件存到指定位置
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
