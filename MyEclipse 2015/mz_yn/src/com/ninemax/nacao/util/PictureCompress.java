package com.ninemax.nacao.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;

public class PictureCompress {

	public static BufferedImage resize(BufferedImage source, int targetW,int targetH) {
		// targetW��targetH�ֱ��ʾĿ�곤�Ϳ�
		int type = source.getType();
		BufferedImage target = null;
		double sx = (double) targetW / source.getWidth();
		double sy = (double) targetH / source.getHeight();
		// ������ʵ����targetW��targetH��Χ��ʵ�ֵȱ����š��������Ҫ�ȱ�����
		// �������if else���ע�ͼ���
		if (sx > sy) 
		{
			sx = sy;
			targetW = (int) (sx * source.getWidth());
		} 
		else 
		{
			sy = sx;
			targetH = (int) (sy * source.getHeight());
		}
		if (type == BufferedImage.TYPE_CUSTOM) { // handmade
			ColorModel cm = source.getColorModel();
			WritableRaster raster = cm.createCompatibleWritableRaster(targetW,targetH);
			boolean alphaPremultiplied = cm.isAlphaPremultiplied();
			target = new BufferedImage(cm, raster, alphaPremultiplied, null);
		} else
			target = new BufferedImage(targetW, targetH, type);
		Graphics2D g = target.createGraphics();
		// smoother than exlax:
		g.setRenderingHint(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);
		g.drawRenderedImage(source, AffineTransform.getScaleInstance(sx, sy));
		g.dispose();
		return target;
	}

	public static boolean saveImageAsJpg(String fromFileStr, String saveToFileStr,	int width, int hight) throws Exception {
		try{
		BufferedImage srcImage;
		// String ex =
		// fromFileStr.substring(fromFileStr.indexOf("."),fromFileStr.length());
		String imgType = "JPEG";
		if (fromFileStr.toLowerCase().endsWith(".png")) {
			imgType = "PNG";
		}
		// System.out.println(ex);
		File saveFile = new File(saveToFileStr);
		File fromFile = new File(fromFileStr);
		srcImage = ImageIO.read(fromFile);
		if (width > 0 || hight > 0) {
			srcImage = resize(srcImage, width, hight);
		}
		ImageIO.write(srcImage, imgType, saveFile);
		return true;
		}catch(Exception e){
			return false;
		}

	}

	public static void main(String argv[]) {
		try {
			// ����1(from),����2(to),����3(��),����4(��)
			PictureCompress.saveImageAsJpg("c:/i/E.jpg", "c:/i/E.jpg",50, 50);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
