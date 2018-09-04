package com.ninemax.nacao.util;

import java.io.File;
import java.io.FileInputStream;

public class Office2PDFFolder
{
  public void newFolder(String folderPath)
  {
    try 
    {
      String filePath = folderPath;
      filePath = filePath.toString();
      File myFilePath = new File(filePath);
      if (!(myFilePath.exists()))
        myFilePath.mkdir();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void delFolder(String folderPath)
  {
    try
    {
      delAllFile(folderPath);
      String filePath = folderPath;
      filePath = filePath.toString();
      File myFilePath = new File(filePath);
      myFilePath.delete();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void delAllFile(String path)
  {
    File file = new File(path);
    if (!(file.exists())) {
      return;
    }
    if (!(file.isDirectory())) {
      return;
    }
    String[] tempList = file.list();
    File temp = null;
    for (int i = 0; i < tempList.length; ++i) {
      if (path.endsWith(File.separator))
        temp = new File(path + tempList[i]);
      else {
        temp = new File(path + File.separator + tempList[i]);
      }
      if (temp.isFile()) {
        temp.delete();
      }
      if (temp.isDirectory()) {
        delAllFile(path + "/" + tempList[i]);
        delFolder(path + "/" + tempList[i]);
      }
    }
  }

  public static boolean toPDFFolder(String oldPath, String newPath)
  {
    try
    {
      new File(newPath).mkdirs();
      File a = new File(oldPath);
      String[] file = a.list();
      File temp = null;
      File pdfTemp = null;
      for (int i = 0; i < file.length; ++i) {
        if (oldPath.endsWith(File.separator))
          temp = new File(oldPath + file[i]);
        else {
          temp = new File(oldPath + File.separator + file[i]);
        }

        if (temp.isFile())
        {
          FileInputStream input = new FileInputStream(temp);

          boolean fileExt = false;
          String filePath = "";
          if ((file[i] != null) && (file[i].length() > 0) && ((
            (file[i].toLowerCase().indexOf(".doc") != -1) || (file[i].toLowerCase().indexOf(".docx") != -1)))) {
            fileExt = true;
            filePath = oldPath + File.separator + file[i];
          }


          input.close();
        }
        temp.isDirectory();
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
      return false;
    }

    return true;
  }

  public static void main(String[] args)
  {
    String oldPath = "d:/1";
    String newPath = "d:/2";
    Office2PDFFolder pDFFolder = new Office2PDFFolder();
    toPDFFolder(oldPath, newPath);
  }
}