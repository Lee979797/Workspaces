package CertificateAuthorityServices.snca;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class readConfig {
	private HashMap hashmap = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public HashMap readcfg() {
		hashmap = new HashMap();
		readConfig("config.ini");
		return hashmap;
	}

	private boolean readConfig(String configfile) {
		try {

			 String str =
			 this.getClass().getProtectionDomain().getCodeSource()
			 .getLocation().getFile();
			 //System.out.println(">>>>>>>>"+str);
			 str = str.substring(0, str.indexOf("/classes"));
			 // ��ȡ�����ļ�
			 str = str + "/classes/conf/" + configfile;
			 System.out.println(str);
			 FileInputStream fi = new FileInputStream(str);
//			InputStream fi = null;
//			ClassLoader classLoader = Thread.currentThread()
//					.getContextClassLoader();
//			try {
//				fi = classLoader.getResourceAsStream("/conf/" + configfile);
//			} catch (Exception e) {
//			}
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(fi));
			String line;
			String name = null, value = null;
			while (true) {
				line = reader.readLine();
				if (line == null) {
					break;
				}
				if (line.equals("")) {
					continue;
				}
				if (line.charAt(0) == '*') {
					continue;
				}
				line = line.trim();
				StringTokenizer sz = new StringTokenizer(line, "#");
				// String[]lines=line.split("#");
				if (sz.hasMoreTokens()) {
					name = sz.nextToken().toUpperCase().trim();
				}
				if (sz.hasMoreTokens()) {
					value = sz.nextToken().trim();
				}
				hashmap.put(name, value);
			}
			reader.close();
			fi.close();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

}
