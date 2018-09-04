package com.ninemax.nacao.util;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

import java.io.*;
/**
 * author  yxf
 * 此程序主要是将txt转为pdf
 * 
 */

public class JAVAtoPDF {
    
	//这个可以将目录下的所有txt->pdf
    public static void generatePDF(String filePath) {
    	
    	File fileName = null;
    	
    	fileName = new File(filePath);

            if(filePath.indexOf(".text") != -1 || filePath.indexOf(".text") != -1)  {
//            	System.out.println("文件名:"+fileName);
            	makePDF(filePath);
            }
    }
    
    public static void makePDF(String fileName) {
        try {
        	//首先创建一个字体
            BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            Font FontChinese = new Font(bfChinese, 12, Font.NORMAL);
            String line = null;
            Document document;
            document = new Document(PageSize.A4, 50, 50, 50, 50);
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            PdfWriter.getInstance(document, new FileOutputStream(fileName.substring(0,fileName.indexOf("."))+"_00.pdf"));
            document.open();
            while ((line = in.readLine()) != null)
                document.add(new Paragraph(12, line, FontChinese));
            document.close();
        }catch(Exception e) {
            System.err.println(e.getMessage());
        }
        
        PdfHandle pp=new PdfHandle();
       
        pp.notAllowPrint(fileName.substring(0,fileName.indexOf("."))+"_00.pdf", fileName.substring(0,fileName.indexOf("."))+".pdf");

    }
    
    
    public static void main(String[] args) throws IOException {
        String sInput="E:/111.text";
//        try {
//        	//输入
//            InputStreamReader fp = new InputStreamReader(System.in);
//            BufferedReader br = new BufferedReader(fp);
//            sInput = br.readLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        String path = sInput;
//        if (args.length != 0) {
//            path = args[0];
//        }
//        File dir = new File(path);
//        System.out.print("path" + path );
//        //判断是否是有此文件目录
//        if (!dir.isDirectory()) {
//            System.out.println("没有此目录");
//            return;
//        }
        generatePDF(sInput);
    }
} 