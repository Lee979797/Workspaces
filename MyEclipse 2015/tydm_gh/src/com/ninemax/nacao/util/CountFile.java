package com.ninemax.nacao.util;

import java.io.*;

public class CountFile {

	 public static void writeFile(String filename,long count)
     {
         try{
             PrintWriter pw = new PrintWriter(new FileWriter(filename));
             pw.print(count);
             pw.close();
             
         }catch(IOException e)
         {
             e.printStackTrace();
         }
     }
     public static long readFile(String filename)
     {
         long count = 0;
         try{
             File f = new File(filename);
             if(!f.exists())
             {
                 writeFile(filename,1);
             }
             BufferedReader br = new BufferedReader(new FileReader(f));
             count = Long.parseLong(br.readLine());
             
         }catch(IOException e)
         {
             e.printStackTrace();
         }
         return count;
     }

}
