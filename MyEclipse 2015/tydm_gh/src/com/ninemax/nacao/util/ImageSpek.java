package com.ninemax.nacao.util;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/*******************************************************************************
 * ����ͼ�ࣨͨ�ã� ��java���ܽ�jpg��bmp��png��gifͼƬ�ļ������еȱȻ�ǵȱȵĴ�Сת���� ����ʹ�÷���
 * compressPic(��ͼƬ·��,����СͼƬ·��,��ͼƬ�ļ���,����СͼƬ����,����СͼƬ���,����СͼƬ�߶�,�Ƿ�ȱ�����(Ĭ��Ϊtrue))
 */
public class ImageSpek {
	private static File file = null; // �ļ�����
	private static String inputDir; // ����ͼ·��
	private static String outputDir; // ���ͼ·��
	private static String inputFileName; // ����ͼ�ļ���
	private static String outputFileName; // ���ͼ�ļ���
	private static int outputWidth = 115; // Ĭ�����ͼƬ��
	private static int outputHeight = 90; // Ĭ�����ͼƬ��
	private static boolean proportion = true; // �Ƿ�ȱ����ű��(Ĭ��Ϊ�ȱ�����)

	public ImageSpek() { // ��ʼ������
		inputDir = "";
		outputDir = "";
		inputFileName = "";
		outputFileName = "";
		outputWidth = 100;
		outputHeight = 120;
	}

	public void setInputDir(String inputDir) {
		ImageSpek.inputDir = inputDir;
	}

	public void setOutputDir(String outputDir) {
		ImageSpek.outputDir = outputDir;
	}

	public void setInputFileName(String inputFileName) {
		ImageSpek.inputFileName = inputFileName;
	}

	public void setOutputFileName(String outputFileName) {
		ImageSpek.outputFileName = outputFileName;
	}

	public void setOutputWidth(int outputWidth) {
		ImageSpek.outputWidth = outputWidth;
	}

	public void setOutputHeight(int outputHeight) {
		ImageSpek.outputHeight = outputHeight;
	}

	public static void setWidthAndHeight(int width, int height) {
		outputWidth = width;
		outputHeight = height;
	}

	/*
	 * ���ͼƬ��С ������� String path ��ͼƬ·��
	 */
	public static long getPicSize(String path) {
		file = new File(path);
		return file.length();
	}

	// ͼƬ����
	public static String compressPic() {
		try {
			// ���Դ�ļ�
			file = new File(inputDir + "\\" + inputFileName);
			if (!file.exists()) {
				return "";
			}
			Image img = ImageIO.read(file);
			// �ж�ͼƬ��ʽ�Ƿ���ȷ
			if (img.getWidth(null) == -1) {
				System.out.println(" can't read,retry!" + "<BR>");
				return "no";
			} else {
				int newWidth;
				int newHeight;
				// �ж��Ƿ��ǵȱ�����
				if (proportion == true) {
					// Ϊ�ȱ����ż��������ͼƬ��ȼ��߶�
					double rate1 = ((double) img.getWidth(null))
							/ (double) outputWidth * 1.0;
					double rate2 = ((double) img.getHeight(null))
							/ (double) outputHeight * 1.0;
					// �������ű��ʴ�Ľ������ſ���
					double rate = rate1 > rate2 ? rate1 : rate2;
					newWidth = (int) (((double) img.getWidth(null)) / rate);
					newHeight = (int) (((double) img.getHeight(null)) / rate);
				} else {
					newWidth = outputWidth; // �����ͼƬ���
					newHeight = outputHeight; // �����ͼƬ�߶�
				}
				BufferedImage tag = new BufferedImage((int) newWidth,
						(int) newHeight, BufferedImage.TYPE_INT_RGB);

				/*
				 * Image.SCALE_SMOOTH �������㷨 ��������ͼƬ��ƽ���ȵ� ���ȼ����ٶȸ� ���ɵ�ͼƬ�����ȽϺ� ���ٶ���
				 */
				tag.getGraphics().drawImage(
						img.getScaledInstance(newWidth, newHeight,
								Image.SCALE_SMOOTH), 0, 0, null);
				FileOutputStream out = new FileOutputStream(outputDir + "\\"
						+ outputFileName);
				// JPEGImageEncoder������������ͼƬ���͵�ת��
				JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
				encoder.encode(tag);
				out.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return "ok";
	}

	public static String compressPic(String inputDir, String outputDir,
			String inputFileName, String outputFileName, int width, int height,
			boolean gp) {
		// ����ͼ·��
		ImageSpek.inputDir = inputDir;
		// ���ͼ·��
		ImageSpek.outputDir = outputDir;
		// ����ͼ�ļ���
		ImageSpek.inputFileName = inputFileName;
		// ���ͼ�ļ���
		ImageSpek.outputFileName = outputFileName;
		// ����ͼƬ����
		setWidthAndHeight(width, height);
		// �Ƿ��ǵȱ����� ���
		proportion = gp;
		return compressPic();
	}

	public static void SpekAfterImage(String DefaultImagePath,
			String SpekImagePath, int SpekWidth, int SpekHeight,
			String ImageFormat) {
		try {
			File fi = new File(DefaultImagePath); // ��ͼ�ļ�
			File fo = new File(SpekImagePath); // ��Ҫת������Сͼ�ļ�
			BufferedImage bis = ImageIO.read(fi);
			Image SpekImage = bis.getScaledInstance(SpekWidth, SpekHeight,
					bis.SCALE_SMOOTH);
			AffineTransformOp atf_op = new AffineTransformOp(AffineTransform
					.getScaleInstance((double) SpekWidth / bis.getTileWidth(),
							(double) SpekHeight / bis.getHeight()),
					AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
			SpekImage = atf_op.filter(bis, null);
			ImageIO.write((BufferedImage) SpekImage, ImageFormat, fo);
		} catch (Exception e) {
			throw new RuntimeException("ImageIo.write error in CreatThum.:"
					+ e.getMessage());
		}
	}


	public static boolean delAllFile(String path) {
		boolean flag = false;
		File file = new File(path);
		if (!file.exists()) {
			return flag;
		}
		if (!file.isDirectory()) {
			return flag;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				delAllFile(path + "/" + tempList[i]);// ��ɾ���ļ���������ļ�
				// delFolder(path + "/" + tempList[i]);// ��ɾ�����ļ���
				flag = true;
			}
		}
		return flag;
	}

	public static void delFolder(String folderPath) {
		try {
			delAllFile(folderPath); // ɾ����������������
			String filePath = folderPath;
			filePath = filePath.toString();
			File myFilePath = new File(filePath);
			myFilePath.delete(); // ɾ�����ļ���
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}