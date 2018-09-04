package com.ninemax.nacao.util;

import com.itextpdf.text.Document;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;

import java.io.FileOutputStream;

public class PdfHandle {

	public void hideBars(String inputFile, String outFile) {
		// ����һ��PDF
		try {
			// ����һ��reader
			PdfReader reader = new PdfReader(inputFile);
			int n = reader.getNumberOfPages();
			// �õ���һҳ
			Rectangle psize = reader.getPageSize(1);
			float width = psize.getHeight();
			float height = psize.getWidth();

			// step 1: ����һ��document����
			Document document = new Document(new Rectangle(width, height));
			// step 2: ����һ��write
			PdfCopy writer = new PdfCopy(document,
					new FileOutputStream(outFile));
			// �������ز˵����͹�����
//			writer.setViewerPreferences(PdfWriter.HideMenubar| PdfWriter.HideToolbar);
			
			writer.setViewerPreferences(PdfWriter.HideMenubar   
                    | PdfWriter.HideToolbar);   
//			writer.setViewerPreferences(PdfWriter.HideWindowUI);   
			
			// writer.setViewerPreferences(PdfWriter.Zoom);
			// step 3: �� document
			document.open();
			// step 4: һҳһҳ�������
			int i = 0;
			while (i < n) {
				document.newPage();
				i++;
				PdfImportedPage page1 = writer.getImportedPage(reader, i);
				writer.addPage(page1);
				System.out.println("Processed page " + i);
			}

			// step 5: �ر�document

			document.close();
		} catch (Exception de) {
			de.printStackTrace();
		}
	}

	public void notAllowPrint(String inputFile, String outFile) {
		try {
			PdfReader reader = new PdfReader(inputFile);
			// ���ü���Ȩ��
			PdfEncryptor.encrypt(reader, new FileOutputStream(outFile), null,
					null, PdfWriter.ALLOW_ASSEMBLY | PdfWriter.ALLOW_FILL_IN
							| PdfWriter.ALLOW_SCREENREADERS, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String g[]) {

		PdfHandle pp=new PdfHandle(); 
        pp.hideBars("e:\\1.pdf", "e:\\4.pdf"); 
        pp.notAllowPrint("e:\\1.pdf", "e:\\5.pdf"); 

		
	}

}
