package com.ninemax.jpa.util;

import sun.misc.BASE64Decoder;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;

public class WriteImageData {

	private static File dirFile = null;

	private static FileOutputStream fs = null;

	private static byte[] bytes = null;

	private static ByteArrayInputStream inStream = null;

	private static byte[] buffer = null;

	private static int byteread = 0;

	private static boolean result = false;

	private static BASE64Decoder base64Decoder = null;
		
	public static boolean WriteImageFile(String fileName, String content)
			throws Exception {
		boolean result = false;
		File dirFile = null;
		String strPath = fileName.substring(0, fileName.lastIndexOf("/"));
		try {
			dirFile = new File(strPath);
			// dirFile=dirFile.getAbsoluteFile();
			// dirFile.getAbsolutePath()
			if (!(dirFile.exists()) && !(dirFile.isDirectory())) {
				boolean creadok = dirFile.mkdirs();
				if (!creadok) {
					throw new Exception("创建文件夹失败!");
				}
			}
			byte[] bytes = new sun.misc.BASE64Decoder().decodeBuffer(content);

			ByteArrayInputStream inStream = new ByteArrayInputStream(bytes);

			byte[] buffer = new byte[content.length()];

			FileOutputStream fs = new FileOutputStream(fileName);

			int byteread = 0;

			while ((byteread = inStream.read(buffer)) != -1) {
				fs.write(buffer, 0, byteread);
				result = true;
				fs.close();
			}
		} catch (Exception e) {
			result = false;
			throw new Exception("写文件出错!");
		} finally {

			dirFile = null;
		}
		return result;
	}

	public static boolean WriteImageByStream(String fileName, String content)
			throws Exception {
		if (dirFile == null) {
			String strPath = fileName.substring(0, fileName.lastIndexOf("/"));
			dirFile = new File(strPath);
			if (!(dirFile.exists()) && !(dirFile.isDirectory())) {
				boolean creadok = dirFile.mkdirs();
				if (!creadok) {
					throw new Exception("创建文件夹失败!");
				}
			}
			
		}

		try {
			fs = new FileOutputStream(fileName);

			base64Decoder = new BASE64Decoder();

			bytes = base64Decoder.decodeBuffer(content);

			inStream = new ByteArrayInputStream(bytes);

			buffer = new byte[content.length()];

			while ((byteread = inStream.read(buffer)) != -1) {
				fs.write(buffer, 0, byteread);
			}

			result = true;

		} catch (Exception e) {
			result = false;
			throw new Exception("写文件出错!");
		} finally {
			fs.close();
		}
		return result;
	}
}
