/**
 * 
 */
package com.ninemax.jpa.util;

import org.apache.log4j.Logger;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;

/**
 * @author Liuzy
 *
 */
public class Img2Base64 {
    private static Logger log = Logger.getLogger(Img2Base64.class);
	public static String GetImageStr(String imgFile)
    throws Exception
  {
    InputStream in = null;
    byte[] data = (byte[])null;
    String s = "";
    try
    {
      in = new FileInputStream(imgFile);
      if (in.available() > 0) {
        data = new byte[in.available()];
        in.read(data);
        in.close();

        BASE64Encoder encoder = new BASE64Encoder();
        s = encoder.encode(data);
      }
    }
    catch (FileNotFoundException fnfe) {
      log.error(fnfe);
    }
    catch (Exception e) {
      log.error(e);
      throw new Exception("¶ÁÈ¡Í¼ÏñÎÄ¼þ´íÎó£¡");
    }
    return s;
  }

  public static String GetImageStr_old(String imgFile)
  {
    InputStream in = null;
    byte[] data = (byte[])null;
    try
    {
      in = new FileInputStream(imgFile);
      data = new byte[in.available()];
      in.read(data);
      in.close();
    }
    catch (IOException e) {
      log.error(e);
    }

    BASE64Encoder encoder = new BASE64Encoder();
    return encoder.encode(data);
  }

  public static boolean GenerateImage(String imgStr, String imgFilePath)
  {
    if (imgStr == null)
      return false;
    BASE64Decoder decoder = new BASE64Decoder();
    try
    {
      byte[] b = decoder.decodeBuffer(imgStr);
      for (int i = 0; i < b.length; i++) {
        if (b[i] < 0)
        {
          int tmp36_34 = i;
          byte[] tmp36_33 = b; 
          tmp36_33[tmp36_34] = (byte)(tmp36_33[tmp36_34] + 256);
        }
      }

      OutputStream out = new FileOutputStream(imgFilePath);
      out.write(b);
      out.flush();
      out.close();
    }
    catch (Exception e) {
      log.error(e);
    }
    return true;
  }
}
