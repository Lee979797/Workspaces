//������Լ��ĳ����
//����decryptMode3DES�������ܣ��û����������Ҫ����
//
package com.ninemax.jpa.util;

public class clsThreeDes
{
    //private static final String Algorithm = "DESede"; //���� �����㷨,���� DES,DESede,Blowfish
    //private static final byte[] keyBytes = {0,1,2,3,4,5,6,7,8,9,'a','b','c','d','e','f','g', 'h','i','j','k','l','m','n'};//24�ֽڵ���Կ
    private static final char[] seed = { 'h','j','k','m','n',0,1,2,3,4,5,7,8,9,'a','c','d','e','f','g'};
   /* public static byte[] encryptMode(byte[] keybyte, byte[] src) {
        try {
             //������Կ
             SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);

             //����
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
    
    //keybyteΪ������Կ������Ϊ24�ֽ�
    //srcΪ���ܺ�Ļ�����
    public static byte[] decryptMode(byte[] keybyte, byte[] src)
    {
        try
        {
            //������Կ
            SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);
            //����
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

    //ת��ʮ�������ַ�����byte
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

    //���ܺ�����str����
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
     
        	ch = (byte)(buff[i] ^ seed[i]);
            ch = (byte)(~ch + i);
            String tmpCh = String.valueOf(java.lang.Integer.toHexString(ch&0xFF));
            if(tmpCh.length()<2){
            	tmpCh="0"+tmpCh;
            }
 
            result += tmpCh;
        }

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
            
            ch = (byte)(java.lang.Integer.parseInt(str,16)&0xFF);//Convert.ToByte(str, 16);
            ch = (byte)(~(ch - i));
            ch = (byte)(ch ^ seed[i]);
            char cc = (char)ch;

           // Integer.toBinaryString();
            
            result += String.valueOf(cc);
        }
        return result.trim();
    }

    public static void main(String[] args) {
    	String jm = Decrypt("b7b6b6b5b5e4e4e4e4e4e4e3e3e3bdbdb8bfbec1",seed);
    	System.out.println("���ܺ�:"+jm);
	}

    
}
