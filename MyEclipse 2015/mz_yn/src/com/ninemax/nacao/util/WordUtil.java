package com.ninemax.nacao.util;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.model.PicturesTable;
import org.apache.poi.hwpf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFPictureData;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WordUtil {

	/**
	 * @param args
	 * @throws java.io.IOException
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testWord();
	}
	
    public static List processWordImage2007(String docxPath,String replacePath){
    	List imagelist = new ArrayList();
    	try {
    		XWPFDocument docx = new XWPFDocument(POIXMLDocument.openPackage(docxPath)); 
    		//提取.docx正文文本 
    		List list =docx.getAllPictures();
    		for(int i=0;i<list.size();i++){
    			XWPFPictureData xd = (XWPFPictureData)list.get(i);
    			System.out.println(xd.getFileName());
    			String imagePath=docxPath.substring(0, docxPath.lastIndexOf("."))+"_"+xd.getFileName();
    			OutputStream out = new FileOutputStream(new File(imagePath));
    			out.write(xd.getData());
    			imagePath=imagePath.replace(replacePath, "");
                imagelist.add(imagePath);
    		}
    		return imagelist;
		} catch (IOException e) {
			return imagelist;
		}
	}
    public static List processWordImage2003(String docPath,String replacePath) {
    	List imagelist = new ArrayList();
    	try {
    	HWPFDocument msWord = new HWPFDocument(new FileInputStream(docPath));
        PicturesTable pTable = msWord.getPicturesTable();
        List<Picture> list =pTable.getAllPictures();
        
        for(int i=0;i<list.size();i++){
        	    Picture pic = list.get(i);
                String fileName = pic.suggestFullFileName();
                System.out.println(fileName);
                String imagePath=docPath.substring(0, docPath.lastIndexOf("."))+"_"+i+fileName;
                OutputStream out = new FileOutputStream(new File(imagePath));
                pic.writeImageContent(out);
                imagePath=imagePath.replace(replacePath, "");
                imagelist.add(imagePath);
        }
        return imagelist;
    	} catch (IOException e) {
			return imagelist;
		}
	}
    public static void testWord() {
    	   try {
    	    FileInputStream in = new FileInputStream("c:\\200610_.doc");// 载入文档
    	    POIFSFileSystem pfs = new POIFSFileSystem(in);
    	    HWPFDocument hwpf = new HWPFDocument(pfs);
    	    Range range = hwpf.getRange();// 得到文档的读取范围
    	    TableIterator it = new TableIterator(range);
    	    // 迭代文档中的表格
    	    while (it.hasNext()) {
    	     Table tb = (Table) it.next();
    	     // 迭代行，默认从0开始
    	     for (int i = 2; i < tb.numRows()-1; i++) {
    	      TableRow tr = tb.getRow(i);
    	      // 迭代列，默认从0开始
    	      for (int j = 0; j < tr.numCells(); j++) {
    	        TableCell td = tr.getCell(j);
    	        TableCell td2 = tr.getCell(j);// 取得单元格
    	       System.out.print(td.text().replaceAll("", "")+"  ");
    	       // 取得单元格的内容
    	       for (int k = 0; k < td.numParagraphs(); k++) {
    	        Paragraph para = td.getParagraph(k);
    	        String s = para.text();
    	        Paragraph para2 = td2.getParagraph(k);
    	        String s2 = para2.text();
    	       // System.out.println(s.replaceAll("\r", "").replaceAll(" ","")+":"+s2.replaceAll("\r", "").replaceAll(" ",""));
    	       }

    	      }
    	      System.out.println("");
    	     } 
    	    }
    	   } catch (Exception e) {
    	    e.printStackTrace();
    	   }
    	}




}
