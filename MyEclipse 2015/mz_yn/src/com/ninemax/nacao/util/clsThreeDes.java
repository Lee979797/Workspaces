//添加上自己的程序包
//调用decryptMode3DES函数解密，用户名、口令都需要解密
//
package com.ninemax.nacao.util;

public class clsThreeDes
{
    //private static final String Algorithm = "DESede"; //定义 加密算法,可用 DES,DESede,Blowfish
    //private static final byte[] keyBytes = {0,1,2,3,4,5,6,7,8,9,'a','b','c','d','e','f','g', 'h','i','j','k','l','m','n'};//24字节的密钥
    private static final char[] seed = { 'h','j','k','m','n',0,1,2,3,4,5,7,8,9,'a','c','d','e','f','g'};
   /* public static byte[] encryptMode(byte[] keybyte, byte[] src) {
        try {
             //生成密钥
             SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);

             //加密
             Cipher c1 = Cipher.getInstance(Algorithm);
             c1.init(Cipher.ENCRYPT_MODE, deskey);
             return c1.doFinal(src);
         } catch (java.security.NoSuchAlgorithmException e1) {
             e1.printStackTrace();
         } catch (javax.crypto.NoSuchPaddingException e2) {
             e2.printStackTrace();
         } catch (java.lang.Exception e3) {
             e3.printStackTrace();
         }
         return null;
     }
    
    //keybyte为加密密钥，长度为24字节
    //src为加密后的缓冲区
    public static byte[] decryptMode(byte[] keybyte, byte[] src)
    {
        try
        {
            //生成密钥
            SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);
            //解密
            Cipher c1 = Cipher.getInstance(Algorithm);
            c1.init(Cipher.DECRYPT_MODE, deskey);
            return c1.doFinal(src);
        }
        catch (java.security.NoSuchAlgorithmException e1)
        {
            e1.printStackTrace();
        }
        catch (javax.crypto.NoSuchPaddingException e2)
        {
            e2.printStackTrace();
        }
        catch (java.lang.Exception e3)
        {
            e3.printStackTrace();
        }
        return null;
    }

    //转换十六进制字符串成byte
    public static String hex2byte(String str)
    {
        try
        {
             String strtp="";
             String stmp="";
             byte encoded[]=new byte[str.length()/2];
             for(int i=0;i<str.length();i=i+2)
                 encoded[i/2]=0;
             for (int n=0;n<str.length();n=n+2)
             {
                 strtp=str.substring(n,n+2);
                 encoded[n/2]=(byte)(java.lang.Integer.parseInt(strtp,16)&0xFF);
             }
             return new String(encoded,"ISO-8859-1");
        }
        catch (java.lang.Exception exx)
        {
                return null;
        }
    }*/

    //解密函数，str密文
    public static  String decryptMode3DES(String str)
    {
       /* str=hex2byte(str);
        String strtp="";
        try
        {
                byte[] encoded=str.getBytes("ISO-8859-1");
                byte[] srcBytes= decryptMode(keyBytes,encoded);
                return new String(srcBytes,"ISO-8859-1");
        }
        catch (java.lang.Exception exx)
        {
            //System.out.print(exx.getMessage()); 
        	return null;
        }*/
    	return Decrypt( str , seed);
    }
    
    /*public   static   String   byte2hex(byte[]   bytes)   {   
        String   hs   =   "";   
        String   stmp   =   "";   
        for   (int   n   =   0;   n   <   bytes.length;   n++)   {   
            stmp   =   (java.lang.Integer.toHexString(bytes[n]&0xFF));   
            if   (stmp.length()   ==   1)   hs   =   hs   +   "0"   +   stmp;   
            else   hs   =   hs   +   stmp;   
            if   (n   <   bytes.length   -   1)   hs   =   hs   ;   
        }   
        return   hs.toUpperCase();   
    }  */
    
    public static String encryptMode3DES(String str){
    	//return byte2hex(encryptMode(keyBytes,str.getBytes()));
        return Encrypt( str, seed);
    }
    
    public static String Encrypt(String strText,char[] seed)
    {
        String result = "";
        //char[] seed = new char[] { 'N','A','C','A','O','O','R','G','P','W'};
        int intTextLength = strText.length();
        
        if(intTextLength<seed.length){
        	int intSpacheLength = seed.length-intTextLength;
        	for(int index=0;index<intSpacheLength;index++){
        		strText = " "+strText;
        	}
        }
        
        
        char[] buff = strText.toCharArray();
        byte ch;
        for (int i = 0; i < seed.length; i++)
        {
        	//System.out.println("char="+buff[i]);
        	ch = (byte)(buff[i] ^ seed[i]);
            ch = (byte)(~ch + i);
            String tmpCh = String.valueOf(Integer.toHexString(ch&0xFF));
            if(tmpCh.length()<2){
            	tmpCh="0"+tmpCh;
            }
            //System.out.println("tmpCh="+tmpCh);
            result += tmpCh;
        }
        //System.out.println("result="+result);
        return result;
    }

    public static String Decrypt(String strText ,char[] seed)
    {
        String result = "";
        String str = "";
        //char[] seed = new char[] { 'N', 'A', 'C', 'A', 'O', 'O', 'R', 'G', 'P', 'W' };

        byte ch;
        for (int i = 0; i < seed.length; i++)
        {
        	
        	str = strText.substring(i * 2, i * 2+2);
            
            ch = (byte)(Integer.parseInt(str,16)&0xFF);//Convert.ToByte(str, 16);
            ch = (byte)(~(ch - i));
            ch = (byte)(ch ^ seed[i]);
            char cc = (char)ch;
            //System.out.println(cc);
           // Integer.toBinaryString();
            
            result += String.valueOf(cc);
        }
        return result.trim();
    }

    
    //测试用例
    public static void main(String[] args)
    {
        
        System.out.println("trip4110:" +encryptMode3DES("/usr/crm/newsUploadFile/1282544999547_643.pdf"));
        System.out.println("trip4110:" +decryptMode3DES("b8e1e9e3c2a19297db9ea99a90b0fcff040c0ff1"));

    }
    
}
