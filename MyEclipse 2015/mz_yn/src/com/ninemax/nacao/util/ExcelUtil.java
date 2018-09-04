package com.ninemax.nacao.util;

import com.ninemax.nacao.to.publishInfo.clsNewsInfoTO;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class ExcelUtil {

	public static String readerExcel2003(String filePath) {
		Workbook wb;
		StringBuffer sb = new StringBuffer("");
		try {
			wb = Workbook.getWorkbook(new File(filePath));
			for (int k = 0; k < wb.getNumberOfSheets(); k++) {

				Sheet s = wb.getSheet(k);// ��1��sheet
				s.getName();
				Cell c;
				int row = s.getRows();// ������
				int col = s.getColumns();// ������
				sb
						.append("<table cellspacing=\"0\" cellpadding=\"0\" rules=\"cols,rows\"  border=\"1\">");
				for (int i = 0; i < row; i++) {
					if (i == 0) {
						sb.append("<tr bgcolor=\"#CCCCCC\">");
					} else {
						sb.append("<tr>");
					}
					for (int j = 0; j < col; j++) {
						sb.append("<td>");
						c = s.getCell(j, i);
						sb.append(c.getContents().trim() + "&nbsp;");
						sb.append("</td>");
					}
					sb.append("</tr>");
				}
				sb.append("<tr align=\"center\"><td colspan=\"100\">"
						+ s.getName() + "</td></tr>");
				sb.append("</table><br/>");
			}
			return sb.toString();
		} catch (BiffException e) {
			e.printStackTrace();
			return "";
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

	public static List<clsNewsInfoTO> readExcel03(String path,String kindCode,String userID) {
		Workbook wb;
		List<clsNewsInfoTO> list = new ArrayList<clsNewsInfoTO>();
		try {
			wb = Workbook.getWorkbook(new File(path));
			clsNewsInfoTO infoTO;
			Sheet s = wb.getSheet(0);// ��1��sheet
			int row = s.getRows();// ������
			int col = s.getColumns();// ������
			int titleNum = 0,contentNum = 0;
			for (int r = 1; r <row; r++) {
				infoTO = new clsNewsInfoTO();
				infoTO.setId(UUID.randomUUID().toString());
				
				if(titleNum==0){
					for(int c=0;c<col;c++){
						System.out.println(s.getCell(c, 0).getContents());
							if("TITLE".equals(s.getCell(c, 0).getContents())){
								infoTO.setTitle(s.getCell(c, r).getContents());
								titleNum = c;
							}
							if("CONTENT".equals(s.getCell(c, 0).getContents())){
								infoTO.setContent(s.getCell(c, r).getContents());
								contentNum = c;
							}
						}
						
					}else{
						infoTO.setTitle(s.getCell(titleNum, r).getContents());
						infoTO.setContent(s.getCell(contentNum, r).getContents());
					}
					if("".equals(infoTO.getTitle())){
						throw new IllegalArgumentException("�����excel��"+(r+1)+"��TITLE�������쳣����������֮�����µ��룡");
					}
					infoTO.setAddtime(DateProcess.getSysTime());
					infoTO.setModifytime(DateProcess.getSysTime());
					infoTO.setContent(s.getCell(1, r).getContents());
					infoTO.setIssyschronize("");
					infoTO.setKind("1");
					infoTO.setLastoper("");
					infoTO.setStatus("0");
					infoTO.setUserid(userID);
					infoTO.setAllowRemark("0");
					infoTO.setKind(kindCode);
					infoTO.setWeb_id("totalWebSite");
					infoTO.setTitlecolor("#000");
					infoTO.setDeputy_title("");
					infoTO.setLink_title("");
					infoTO.setPub_date("");
					infoTO.setPub_company("");
					infoTO.setIshead("0");
				list.add(infoTO);
			}
			
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;

	}

	public static String readerExcel2007(String filePath) {
		XSSFWorkbook xwb;
		StringBuffer sb = new StringBuffer("");
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			// ���� XSSFWorkbook ����strPath �����ļ�·��
			xwb = new XSSFWorkbook(filePath);

			// ѭ��������Sheet
			for (int numSheet = 0; numSheet < xwb.getNumberOfSheets(); numSheet++) {
				XSSFSheet xSheet = xwb.getSheetAt(numSheet);
				sb
						.append("<table cellspacing=\"0\" cellpadding=\"0\" rules=\"cols,rows\"  border=\"1\">");
				if (xSheet == null) {
					continue;
				}
				// ѭ����Row
				for (int rowNum = 0; rowNum <= xSheet.getLastRowNum(); rowNum++) {
					XSSFRow xRow = xSheet.getRow(rowNum);
					if (rowNum == 0) {
						sb.append("<tr bgcolor=\"#CCCCCC\">");
					} else {
						sb.append("<tr>");
					}
					if (xRow == null) {
						continue;
					}
					// ѭ����Cell
					for (int cellNum = 0; cellNum <= xRow.getLastCellNum(); cellNum++) {
						XSSFCell xCell = xRow.getCell(cellNum);
						if (xCell == null) {
							continue;
						}
						sb.append("<td>");

						if (xCell.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN) {
							sb.append(xCell.getBooleanCellValue());
						} else if (xCell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
							if (HSSFDateUtil.isCellDateFormatted(xCell)) {
								double d = xCell.getNumericCellValue();
								Date date = HSSFDateUtil.getJavaDate(d);
								sb.append(sf.format(date).toString());
							} else {
								sb.append(xCell.getNumericCellValue());
							}

						} else {
							sb.append(xCell.getStringCellValue().trim());
						}
						sb.append("</td>");
					}
					sb.append("</tr>");
				}
				sb.append("<tr align=\"center\"><td colspan=\"100\">"
						+ xSheet.getSheetName() + "</td></tr>");
				sb.append("</table><br/>");
			}
			return sb.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}

	}

	public static void main(String[] args) {
		// System.out.println(ExcelUtil.readerExcel2003("C:\\Users\\ninemaxer\\Desktop\\aa.xls"));
		System.out.println(ExcelUtil
				.readerExcel2007("C://temp2014//2.xlsx"));
		System.out.println("'CONTENT");
	}
}
