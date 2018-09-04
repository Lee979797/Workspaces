package com.ninemax.jpa.util;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: zhhuiyan
 * Date: 12-6-14
 * Time: 上午9:30
 */
public class RegUtils {
    private static Logger log = Logger.getLogger(RegUtils.class);

    public static void main(String[] args) {
        Pattern p = Pattern.compile("(.*[1-9]+)");
        Matcher m = p.matcher("350101");
        while (m.find()) {
            String filter = m.group();
            System.out.println("filter = " + filter);
        }


        /*File f
                = new File(".");
        String in = "test\\";
        String out = "test\\out\\";
        Map<String, String> regexs = new HashMap<String, String>();
        regexs.put("name=[\\\"\\\']([\\d\\w]+)[\\\"\\\']", "$0 id=\\\"$1\\\" ");
        doReplace(in, out, regexs);*/
    }

    /**
     * 正则目录替换
     *
     * @param in
     * @param out
     * @param map
     */
    public static void doReplace(String in, String out, Map<String, String> map) {
        File f = new File(in);
        BufferedReader br = null;
        FileWriter fw = null;
        if (f.exists() && f.isDirectory()) {
            f.setReadable(true);
            File[] files = f.listFiles();
            for (int i = 0; i < files.length; i++) {
                File file = files[i];
                if (files[i].exists() && files[i].isFile() && !files[i].isDirectory()) {
                    doReplace(files[i], new File(out + files[i].getName()), map);
                }
            }
        }
    }

    /**
     * 正则-文件替换
     *
     * @param in
     * @param out
     * @param map
     */
    public static void doReplace(File in, File out, Map<String, String> map) {

        BufferedReader br = null;

        FileWriter fw = null;
        try {

            br = new BufferedReader(new InputStreamReader(new FileInputStream(in)));
            String data = null;
            if (out == null)
                return;
            out.setWritable(true);
            fw = new FileWriter(out);
            while ((data = br.readLine()) != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    data = replace(data, entry.getKey(), entry.getValue());
                }


                fw.write(data + "\n", 0, data.length() + 1);
            }
            fw.flush();
        } catch (FileNotFoundException e)

        {
            log.error(e);
        } catch (IOException e) {
            log.error(e);
        } finally {
            try {
                if (br != null)
                    br.close();
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                log.error(e);
            }
        }

    }

    /**
     * 正则-文本数据替换
     *
     * @param data
     * @param regex
     * @param replacement
     * @return
     */
    public static String replace(String data, String regex, String replacement) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(data);
        String data1 = null;
        String data2 = null;
        while (m.find()) {
            if (!"".equals(m.group())) {
                data1 = m.group();
                data2 = data1.replaceAll(regex, replacement).toLowerCase();
                data = data.replace(data1, data2);

            }

        }
        return data;
    }
}
