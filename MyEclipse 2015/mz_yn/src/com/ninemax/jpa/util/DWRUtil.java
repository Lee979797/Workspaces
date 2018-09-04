package com.ninemax.jpa.util;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 11-2-18
 * Time: ÏÂÎç3:53
 */

import java.util.HashMap;
import java.util.Iterator;

public class DWRUtil {
	public static boolean getBadWordsInPost(String content) {
		HashMap hm = ForbidLoad.getInstance().getForbidwordsHm();
		String badWords = "";
		Iterator it = hm.values().iterator();
		content = StringUtils.clearHtml(content);
		content = content.replaceAll(" ", "");
		content = content.replaceAll("&nbsp;", "");
		while (it.hasNext()) {
			badWords = (String) it.next();
			if (content.indexOf(badWords) != -1) {
				
				return false;
			}
		}
		return true;
	}

	public static String getBadWords(String content) {
		HashMap hm = ForbidLoad.getInstance().getForbidwordsHm();
		String badWords = "";
		Iterator it = hm.values().iterator();
		//content = StringUtils.clearHtml(content);
		content = content.replaceAll(" ", "");
		content = content.replaceAll("&nbsp;", "");
		while (it.hasNext()) {
			badWords = (String) it.next();
			if (content.indexOf(badWords) != -1) {
			
				return badWords;
			}
		}
		return "";
	}

}
