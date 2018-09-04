package com.ninemax.jpa.util;

import java.io.UnsupportedEncodingException;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 13-5-14
 * Time: ����10:09
 */
public class FullCharConverter {

    // ȫ��ת��ǵ� ת������

    public static final String full2HalfChange(String QJstr)
            throws UnsupportedEncodingException {

        StringBuffer outStrBuf = new StringBuffer("");

        String Tstr = "";

        byte[] b = null;

        for (int i = 0; i < QJstr.length(); i++) {

            Tstr = QJstr.substring(i, i + 1);

            // ȫ�ǿո�ת���ɰ�ǿո�

            if (Tstr.equals("��")) {

                outStrBuf.append(" ");

                continue;

            }

            b = Tstr.getBytes("unicode");

            // �õ� unicode �ֽ�����

            if (b[2] == -1) {

                // ��ʾȫ�ǣ�

                b[3] = (byte) (b[3] + 32);

                b[2] = 0;

                outStrBuf.append(new String(b, "unicode"));

            } else {

                outStrBuf.append(Tstr);

            }

        } // end for.

        return outStrBuf.toString();

    }

    // ���תȫ��

    public static final String half2Fullchange(String QJstr)
            throws UnsupportedEncodingException {

        StringBuffer outStrBuf = new StringBuffer("");

        String Tstr = "";

        byte[] b = null;

        for (int i = 0; i < QJstr.length(); i++) {

            Tstr = QJstr.substring(i, i + 1);

            if (Tstr.equals(" ")) {

                // ��ǿո�

                outStrBuf.append(Tstr);

                continue;

            }

            b = Tstr.getBytes("unicode");

            if (b[2] == 0) {

                // ���?

                b[3] = (byte) (b[3] - 32);

                b[2] = -1;

                outStrBuf.append(new String(b, "unicode"));

            } else {

                outStrBuf.append(Tstr);

            }

        }

        return outStrBuf.toString();

    }


    public static void main(String[] args) throws UnsupportedEncodingException {

        // ȫ��ת���

        String QJstr = "hello!�� ȫ��ת�����ģ��� ������������";

        String result = full2HalfChange(QJstr);

       /* System.out.println(QJstr);

        System.out.println(result);

        System.out.println("------------------------------------");*/

        // ���תȫ��

        String str = "java ���� �ٻ� 2345";

      /*  System.out.println(str);

        System.out.println(half2Fullchange(str));

        System.out.println(half2Fullchange(str));
*/
    }


}
