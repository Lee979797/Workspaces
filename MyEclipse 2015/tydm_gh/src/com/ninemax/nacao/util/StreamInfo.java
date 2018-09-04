package com.ninemax.nacao.util;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public final class StreamInfo
{
  public static String getContentFormFileFormat(String filePath, String charset)
  {
    FileInputStream fs = null;
    BufferedReader bufferedReader = null;
    InputStreamReader ir = null;
    StringBuffer sb = new StringBuffer();
    try {
    	System.out.println(filePath);
    	System.out.println(filePath);
      fs = new FileInputStream(filePath);
      ir = new InputStreamReader(fs, charset);
      bufferedReader = new BufferedReader(ir);
      String line = null;

      while ((line = bufferedReader.readLine()) != null)
        sb.append(line + "\n");
    }
    catch (Exception localException) {
    	localException.printStackTrace();
    }
    finally {
      try {
        bufferedReader.close();
        ir.close();
        fs.close();
      } catch (IOException ex1) {
        System.out.println(ex1.getMessage());
      }
    }
    return sb.toString();
  }

  public static String getContentFormFile(String filePath, String charset)
  {
    FileInputStream fs = null;
    BufferedReader bufferedReader = null;
    InputStreamReader ir = null;
    StringBuffer sb = new StringBuffer();
    try {
      fs = new FileInputStream(filePath);
      ir = new InputStreamReader(fs, charset);
      bufferedReader = new BufferedReader(ir);
      String line = null;

      while ((line = bufferedReader.readLine()) != null)
        sb.append(line);
    }
    catch (Exception localException) {
    }
    finally {
      try {
        bufferedReader.close();
        ir.close();
        fs.close();
      } catch (IOException ex1) {
        System.out.println(ex1.getMessage());
      }
    }
    return sb.toString(); }

  public static String GzipDecompression(InputStream is) {
    StringBuffer sb = new StringBuffer();
    InputStreamReader inputStreamReader = null;
    BufferedReader bReader = null;
    GZIPInputStream zipIs = null;
    try {
      zipIs = new GZIPInputStream(is);
      inputStreamReader = new InputStreamReader(zipIs, "utf-8");
      bReader = new BufferedReader(inputStreamReader, 1024);
      char[] cs = new char[1024];
      int i = 0;
      while ((i = bReader.read(cs)) != -1) {
        sb.append(cs, 0, i);
      }
      if (sb.length() == 0)
        return null;
    }
    catch (Exception ex) {
      System.out.println(ex.getMessage());
      return null;
    } finally {
      try {
        bReader.close();
        inputStreamReader.close();
        zipIs.close();
        is.close();
      } catch (IOException localIOException2) {
      }
      bReader = null;
      inputStreamReader = null;
      zipIs = null;
    }
    try
    {
      bReader.close();
      inputStreamReader.close();
      zipIs.close();
      is.close();
    } catch (IOException localIOException3) {
    }
    bReader = null;
    inputStreamReader = null;
    zipIs = null;

    return sb.toString();
  }

  public static String zipDecompression(InputStream is) {
    ZipInputStream zipIs = new ZipInputStream(is);
    StringBuffer sb = new StringBuffer();
    InputStreamReader inputStreamReader = null;
    BufferedReader bReader = null;
    try {
      inputStreamReader = new InputStreamReader(zipIs, "gb2312");
      bReader = new BufferedReader(inputStreamReader, 1024);
      zipIs.getNextEntry();
      char[] cs = new char[1024];
      int i = 0;
      while ((i = bReader.read(cs)) != -1) {
        sb.append(cs, 0, i);
      }
      if (sb.length() == 0)
        return null;
    }
    catch (Exception ex) {
      System.out.println(ex.getMessage());
      return null;
    } finally {
      try {
        bReader.close();
        inputStreamReader.close();
        zipIs.close();
        is.close();
      } catch (IOException localIOException2) {
      }
      bReader = null;
      inputStreamReader = null;
      zipIs = null;
    }
    try
    {
      bReader.close();
      inputStreamReader.close();
      zipIs.close();
      is.close();
    } catch (IOException localIOException3) {
    }
    bReader = null;
    inputStreamReader = null;
    zipIs = null;

    return sb.toString();
  }

  public static String convertStreamAsString(InputStream stream, String charset)
  {
    StringBuffer buffer = new StringBuffer();
    try {
      InputStreamReader inputStreamReader = new InputStreamReader(stream, 
        charset);
      BufferedReader bufferedReader = new BufferedReader(
        inputStreamReader);
      String line = null;
      while ((line = bufferedReader.readLine()) != null) {
        buffer.append(line);
      }
      bufferedReader.close();
      inputStreamReader.close();
      stream.close();
    } catch (Exception ex) {
      System.out.println(ex.getMessage() + "-----convertStreamAsString");
      return ex.getMessage();
    }
    return buffer.toString();
  }

  public static boolean ZIPCompress(String _strPath)
  {
    try
    {
      FileOutputStream fileOutputStream = new FileOutputStream(_strPath + 
        ".zip");
      ZipOutputStream zipOutputStream = new ZipOutputStream(
        fileOutputStream);
      zipOutputStream.setMethod(8);
      int temp = 0;
      File file = new File(_strPath);
      byte[] _byte = new byte[1024];
      for (int i = 0; i < file.list().length; ++i) {
        zipOutputStream.putNextEntry(new ZipEntry(file.list()[i]));
        String _str = _strPath + File.separator + file.list()[i];
        FileInputStream fileInputStream = new FileInputStream(_str);
        BufferedInputStream bufferInputStream = new BufferedInputStream(
          fileInputStream);
        try {
          while ((temp = bufferInputStream.read(_byte)) != -1)
            zipOutputStream.write(_byte, 0, temp);
        }
        catch (Exception e2) {
        }
        bufferInputStream.close();
        fileInputStream.close();
      }
      zipOutputStream.flush();
      zipOutputStream.close();
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
      return false;
    }
    return true;
  }

  public static boolean createLog(String filePath, String content)
  {
    boolean _flag = false;
    FileOutputStream fileOuotStream = null;
    try {
      fileOuotStream = new FileOutputStream(new File(filePath), true);
      BufferedOutputStream buffer = new BufferedOutputStream(
        fileOuotStream);
      buffer.write(content.getBytes());
      buffer.flush();
      buffer.close();
      fileOuotStream.close();
      _flag = true;
    } catch (IOException ex) {
      System.out.println(ex.getMessage() + "create log exception");
      _flag = false;
    } finally {
      return _flag;
    }
  }

  public static String convertByteAsString(byte[] byteArray, String charset)
  {
    try
    {
      return new String(byteArray, charset);
    } catch (Exception ex) {
      System.out
        .println(ex.getMessage() + 
        "------com.ninemax.toolkit.StreamToolKit_lulu.convertByteAsString()"); }
    return null;
  }

  public static InputStream convertByteAsStream(byte[] byteArray)
  {
    return new ByteArrayInputStream(byteArray);
  }

  public static boolean createFileAsByte(byte[] b, String path)
  {
    boolean flag = true;
    FileOutputStream fileOutputStream = null;
    try {
      fileOutputStream = new FileOutputStream(new File(path));
      BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
        fileOutputStream);
      bufferedOutputStream.write(b);
      bufferedOutputStream.flush();
      bufferedOutputStream.close();
      fileOutputStream.close();
    } catch (Exception ex) {
      flag = false;
      System.out.println(ex.getMessage());
    }
    return flag;
  }

  public static boolean createFileAsInputStream(InputStream inputStream, String path)
  {
    try
    {
      FileOutputStream fileOuotStream = new FileOutputStream(
        new File(path));
      BufferedOutputStream buffer = new BufferedOutputStream(
        fileOuotStream);
      BufferedInputStream bInputStream = new BufferedInputStream(
        inputStream);
      int n = 0;
      while ((n = bInputStream.read()) != -1) {
        buffer.write(n);
      }
      buffer.flush();
      buffer.close();
      fileOuotStream.close();
      bInputStream.close();
      inputStream.close();
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
      return false;
    }
    return true;
  }

  public static boolean string2File(String res, String filePath)
  {
    boolean flag = true;
    BufferedReader bufferedReader = null;
    BufferedWriter bufferedWriter = null;
    try {
      File distFile = new File(filePath);
      if (!(distFile.getParentFile().exists()))
        distFile.getParentFile().mkdirs();
      bufferedReader = new BufferedReader(new StringReader(res));
      bufferedWriter = new BufferedWriter(new FileWriter(distFile));
      char[] buf = new char[1024];
      int len;
      while ((len = bufferedReader.read(buf)) != -1) {
        bufferedWriter.write(buf, 0, len);
      }
      bufferedWriter.flush();
      bufferedReader.close();
      bufferedWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
      flag = false;
      return flag;
    } finally {
      if (bufferedReader != null) {
        try {
          bufferedReader.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return flag;
  }

  public static boolean string2TextFile(String text, File distFile, String encoding)
  {
    boolean flag = true;
    if (!(distFile.getParentFile().exists())) distFile.getParentFile().mkdirs();
    OutputStreamWriter writer = null;
    try {
      writer = new OutputStreamWriter(new FileOutputStream(distFile), encoding);
      writer.write(text);
      writer.close();
    } catch (IOException e) {
      flag = false;

      throw new RuntimeException(e);
    } finally {
      if (writer != null) try {
          writer.close();
        }
        catch (IOException e) {
          throw new RuntimeException(e);
        }
    }
    return flag;
  }
}