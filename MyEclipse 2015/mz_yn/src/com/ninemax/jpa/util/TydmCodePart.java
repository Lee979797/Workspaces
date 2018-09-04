package com.ninemax.jpa.util;

import com.ninemax.jpa.code.action.TextCode4;

public class TydmCodePart {
    public static String mdAddOne(String Qsmd, int distance) {
       if(distance==0)
           return Qsmd;
        int index = -1;
        for (int i = 0; i < Qsmd.length(); i++) {
            if (((byte) Qsmd.charAt(i) >= 48) && ((byte) Qsmd.charAt(i) <= 57))
                continue;
            index = i;
        }
        String Qsmd_qz;
        String Qsmd_hz;
        if (index > -1) {
            Qsmd_qz = Qsmd.substring(0, index + 1);
            Qsmd_hz = Qsmd.substring(index + 1, Qsmd.length());
        } else {
            Qsmd_qz = "";
            Qsmd_hz = Qsmd;
        }

        String Qsmd_hz_int = Integer.toString(Integer.parseInt(Qsmd_hz) + distance);
        return Qsmd_qz + charReplicate('0', Qsmd_hz.length() - Qsmd_hz_int.length()) + Qsmd_hz_int;
    }

    public static String charReplicate(char char_in, int i) {
        String Result = "";
        for (int j = 1; j <= i; j++) {
            Result = Result + char_in;
        }
        return Result;
    }

    public static int getMdsl(String Qsmd, String Jzmd) {
        int Result = 2;
        TextCode4  t=new TextCode4();
        while (!t.codeNext(Qsmd).equals(Jzmd)) {
 			 System.out.println("====:"+t.codeNext(Qsmd));
 			Result+=1;
 			
 			Qsmd=t.codeNext(Qsmd);
 		}
        return Result;
    }

    public static int getZssl(String qsbh, String jzbh) {
        int Result = 0;
        int index = -1;
        for (int i = 0; i < qsbh.length(); i++)
            if (((byte) qsbh.charAt(i) < 48) || ((byte) qsbh.charAt(i) > 57))
                index = i;
        long qsbh_hz;
        long jzbh_hz;
        if (index > -1) {
            qsbh_hz = Long.parseLong(qsbh.substring(index + 1, qsbh.length()));
            jzbh_hz = Long.parseLong(jzbh.substring(index + 1, jzbh.length()));
        } else {
            qsbh_hz = Long.parseLong(qsbh);
            jzbh_hz = Long.parseLong(jzbh);
        }
        Result = (int) (jzbh_hz - qsbh_hz + 1L);
        return Result;
    }

    public static String bhAddOne(String Qsmd, int distance) {
        String Result = "";

        int index = -1;
        for (int i = 0; i < Qsmd.length(); i++) {
            if (((byte) Qsmd.charAt(i) >= 48) && ((byte) Qsmd.charAt(i) <= 57))
                continue;
            index = i;
        }
        String Qsmd_qz;
        String Qsmd_hz;
        if (index > -1) {
            Qsmd_qz = Qsmd.substring(0, index + 1);
            Qsmd_hz = Qsmd.substring(index + 1, Qsmd.length());
        } else {
            Qsmd_qz = "";
            Qsmd_hz = Qsmd;
        }

        String Qsmd_hz_int = Long.toString(Long.parseLong(Qsmd_hz) + distance);
        Result = Qsmd_qz + charReplicate('0', Qsmd_hz.length() - Qsmd_hz_int.length()) + Qsmd_hz_int;
        return Result;
    }

}
