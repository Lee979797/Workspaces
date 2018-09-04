package com.ninemax.jpa.code.bus;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.tags.TableColumn;
import org.htmlparser.tags.TableHeader;
import org.htmlparser.tags.TableRow;
import org.htmlparser.tags.TableTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import com.ninemax.jpa.util.UserPropertiesData;
import com.ninemax.nacao.util.WebContent;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 工商二维码提取
 * @author liupeng
 *
 */
public class GSUrlBus {
	
	
	
	/**
	 * 长春 和 河南
	 * @param gsUrl
	 * @return
	 */
	public JSONObject changChun(String gsUrl){
		//使用JSONArray
		JSONArray jsonArray = new JSONArray();
	
		String key=null;
		String value=null;
		Map<String,String> mapJson=new HashMap<String,String>();
		JSONObject jsonObject = new JSONObject();
		for(Map.Entry<String, String> maps: getHtmlData(gsUrl).entrySet()){
			key=maps.getKey().trim();
			value=maps.getValue().trim();
			
			if("发照日期".equals(key)){
				jsonObject.put("fzrq", value);
			}else if("经营范围".equals(key.replace("<br/>", ""))){
				jsonObject.put("jyfw", value);
			}else if("成立日期".equals(key)){
				jsonObject.put("clrq", value.replace("月", "-").replace("年","-").replace("日", ""));
			}else if("名称".equals(key)){
				jsonObject.put("jgmc", value);
			}else if("注册号".equals(key)){
				jsonObject.put("zch", value);
			}else if("法定代表人".equals(key)||"经营者".equals(key)){
				jsonObject.put("fddbr", value);
			}else if("注册资本".equals(key)){
				jsonObject.put("zczj", value.replace(value.replaceAll("[^\u4E00-\u9FA5]", ""), ""));
			}else if("经营范围".equals(key)){
				jsonObject.put("jyfw", value);
			}else if("住所".equals(key)||"经营场所".equals(key)){
				jsonObject.put("jgdz", value);
			}else if("营业期限自".equals(key)){
				jsonObject.put("jyqxS", value);
			}else if("营业期限至".equals(key)){
				jsonObject.put("jyqxE", value);
			}else{
				
				jsonObject.put(key, value);
			}
		}
		
		
		if(jsonObject.size()==0){
			jsonObject.put("mes", "暂无查询信息！");
		}else{
			jsonObject.put("mes", "");
		}
		
		return jsonObject;
	}
	
	
	
	/**
	 * 大连
	 * @param gsUrl
	 * @return
	 */
	public JSONObject daLian(String gsUrl){
		
		Map<String,String> mapJson=new HashMap<String,String>();
		String [] urlValues=gsUrl.split("\\|");
		for(String values:urlValues){
			
			String [] value=values.split("：");
			if(value.length>1){
				mapJson.put(value[0], value[1]);
			}
		}
		
		//使用JSONArray
		JSONArray jsonArray = new JSONArray();
	
		
		JSONObject jsonObject = new JSONObject();
		for(Map.Entry<String, String> maps: mapJson.entrySet()){
			if("发照日期".equals(maps.getKey())){
				jsonObject.put("fzrq", maps.getValue());
			}else if("经营范围".equals(maps.getKey())){
				jsonObject.put("jyfw", maps.getValue());
			}else if("成立日期".equals(maps.getKey())){
				jsonObject.put("clrq", maps.getValue().replace("月", "-").replace("年","-").replace("日", ""));
			}else if("名称".equals(maps.getKey())){
				jsonObject.put("jgmc", maps.getValue());
			}else if("注册号".equals(maps.getKey())){
				jsonObject.put("zch", maps.getValue());
			}else if("法定代表人".equals(maps.getKey())){
				jsonObject.put("fddbr", maps.getValue());
			}else if("注册资本".equals(maps.getKey())){
				jsonObject.put("zczj", maps.getValue().replace(maps.getValue().replaceAll("[^\u4E00-\u9FA5]", ""), ""));
			}else if("经营范围".equals(maps.getKey())){
				jsonObject.put("jyfw", maps.getValue());
			}else if("住所".equals(maps.getKey())){
				jsonObject.put("jgdz", maps.getValue());
			}else if("营业期限自".equals(maps.getKey())){
				jsonObject.put("jyqxS", maps.getValue().trim());
			}else if("营业期限至".equals(maps.getKey())){
				jsonObject.put("jyqxE", maps.getValue());
			}else{
				
				jsonObject.put(maps.getKey(), maps.getValue());
			}
		}
		
		if(jsonObject.size()==0){
			jsonObject.put("mes", "暂无查询信息！");
		}else{
			jsonObject.put("mes", "");
		}
		return jsonObject;
		
	}

	/**
	 * 解析HTML
	 * @param url
	 * @return
	 */
	public Map<String, String> getHtmlData(String url) {
		Parser parser = null;
		NodeList tableList = null;
		NodeFilter tableFilter = null;

		Map<String, String> map = new HashMap<String, String>();

		WebContent web = new WebContent();
		final StringBuffer sb = new StringBuffer();

		//String initUrl = "http://218.62.29.139:8080/aiccips/GSpublicity/GSpublicityList.html?service=entInfo&entNo=6de07ce0-0145-1000-e01b-1202c0a80043&regOrg=220104";

		String initUrl=null;
		if (!"".equals(url)) {
			initUrl = url.replace(UserPropertiesData.getValueByPropertyName("domain"), UserPropertiesData.getValueByPropertyName("domainIp"));
		}
		//河南二维码专用
		String [] urls=initUrl.split(";");
		initUrl=urls[urls.length-1].replace("企业信用信息公示系统网址:", "");
		try {
			String content = web.getOneHtml(initUrl);
			// final Pattern pa =
			// Pattern.compile("<div id=\"jibenxinxi\"></br><table cellspacing=\"0\" cellpadding=\"0\" class=\"detailsList\" id=\"baseinfo\">(.*?)</table> </br><table  cellpadding=\"0\" cellspacing=\"0\" class=\"detailsList\" id=\"touzirentop\" style=\"\" >",
			// Pattern.DOTALL);
            final Pattern pa = Pattern.compile("<body>(.*?)</body>");

			final Matcher ma = pa.matcher(content);
			while (ma.find()) {
				sb.append(ma.group());
			}
			parser = Parser.createParser(sb.toString(), "GBK");
			// parser = new Parser("http://www.hao123.com");
			tableFilter = new NodeClassFilter(TableTag.class);
			// tableFilter = new TagNameFilter("TABLE");

			tableList = parser.extractAllNodesThatMatch(tableFilter);

			for (int i = 0; i < 1; i++) {
				TableTag table = (TableTag) tableList.elementAt(i);
				// 取得表中的行集
				TableRow[] rows = table.getRows();
				// 遍历每行
				for (int r = 0; r < rows.length; r++) {
					TableRow tr = rows[r];
					TableColumn[] td = tr.getColumns();
					TableHeader[] headers = tr.getHeaders();
					// 行中的列
					for (int c = 0; c < td.length; c++) {

						//System.out.print(headers[c].getStringText() + ": ");
						//System.out.print(td[c].toPlainTextString() + " ");
						map.put(headers[c].getStringText(), td[c].toPlainTextString());
						//System.out.println();
					}
					//System.out.println();

				}
			}
		} catch (ParserException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}


}
