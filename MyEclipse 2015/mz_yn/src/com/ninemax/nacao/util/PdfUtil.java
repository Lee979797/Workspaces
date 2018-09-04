package com.ninemax.nacao.util;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Iterator;
import java.util.List;

public class PdfUtil {
	public static String GenerateImgBySun(String pdfPath, String replacePath) {
		StringBuffer sb = new StringBuffer("");
		try {
			
			File file = new File(pdfPath);
			RandomAccessFile raf = new RandomAccessFile(file, "r");
			FileChannel channel = raf.getChannel();
			ByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY, 0,
					channel.size());
			PDFFile pdffile = new PDFFile(buf);

			for (int i = 1; i <= pdffile.getNumPages(); i++) {
				PDFPage page = pdffile.getPage(i);

				Rectangle rect = new Rectangle(0, 0, (int) page.getBBox()
						.getWidth(), (int) page.getBBox().getHeight());
				
				Image img = page.getImage(rect.width, rect.height, rect, null,
						true, true);
				BufferedImage tag = new BufferedImage(rect.width, rect.height,
						BufferedImage.TYPE_INT_RGB);
				tag.getGraphics().drawImage(img, 0, 0, rect.width, rect.height,
						null);
				String imagePath = pdfPath.substring(0, pdfPath
						.lastIndexOf("."))
						+ "_" + i + ".jpg";
				FileOutputStream out = new FileOutputStream(imagePath); // 输出到文件流
				JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
				encoder.encode(tag); // JPEG编码
				out.close();
				imagePath = imagePath.replace(replacePath, "");
				sb.append("<br/><div style=\"text-align: center;border:1px solid\"><img src=\""+imagePath+"\" width=\""+rect.width+"\"  height=\""+rect.height+"\"/></div>");
				if(i%10==0&&i<pdffile.getNumPages()){
					sb.append("[NextPage][/NextPage]");
				}
			}
			return sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
			return "<div style=\"text-align: center;border:1px solid\"><iframe src=\""+pdfPath.replace(replacePath, "")+"\" align=\"middle\" width=\"600px\" height=\"1000px\"></iframe></div>";
		}

	}

	public static void main(final String[] args) {
			System.out.println(PdfUtil.GenerateImgBySun("C:\\Users\\ninemaxer\\Desktop\\img\\a.pdf","C:\\Users"));
		// processPdf("C:\\Users\\ninemaxer\\Desktop\\a.pdf");
	}

	public static void processPdfByApache(String path) {
		try {
			PDDocument doc = PDDocument.load(path);
			int pageCount = doc.getNumberOfPages();
			System.out.println(pageCount);
			List pages = doc.getDocumentCatalog().getAllPages();
			for (int i = 0; i < pages.size(); i++) {
				PDPage page = (PDPage) pages.get(i);
				BufferedImage image = page.convertToImage();
				Iterator iter = ImageIO.getImageWritersBySuffix("jpg");
				ImageWriter writer = (ImageWriter) iter.next();
				File outFile = new File(
						"C:\\Users\\ninemaxer\\Desktop\\img\\box" + i + ".jpg");
				FileOutputStream out = new FileOutputStream(outFile);
				ImageOutputStream outImage = ImageIO
						.createImageOutputStream(out);
				writer.setOutput(outImage);
				writer.write(new IIOImage(image, null, null));
			}
			doc.close();
			System.out.println("over");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
