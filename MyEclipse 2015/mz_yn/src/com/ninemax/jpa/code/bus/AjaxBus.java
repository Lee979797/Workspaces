package com.ninemax.jpa.code.bus;

import com.ninemax.jpa.code.dao.*;
import com.ninemax.jpa.code.model.*;
import com.ninemax.jpa.global.InitSysParams;
import com.ninemax.jpa.system.model.Bzjgdm;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA. User: zhaoxun Date: 12-5-18 Time: 下午5:38
 */
public class AjaxBus {
	private Pattern scptn = Pattern.compile("^([1-9]+(0*[1-9])?)0+$");;
	private String center = null;
	private TJjhyDAO jjhyDAO = new TJjhyDAO();

	private TJjlxDAO jjlxDAO = new TJjlxDAO();

	private TNjjhyDAO njjhyDAO = new TNjjhyDAO();

	private TNjjlxDAO njjlxDAO = new TNjjlxDAO();
	private TZgjgDAO zgjgDAO = new TZgjgDAO();
	private TJgdmDAO jgdmDAO = new TJgdmDAO();
	private Map<String, String> map;
	private TJjhydzBus tJjhydzBus = new TJjhydzBus();

	private String flagJgdm;

	private String getCenter() {
		if (center == null) {
			Matcher m = scptn.matcher(InitSysParams.system.getXzqhdm());
			if (m.find()) {
				center = m.group(1);
			} else {
				center = "";
			}
		}
		return center;
	}

	public TPzjg getPzjg(String dm, String bzjgdm) {
		List<TPzjg> list = new ArrayList<TPzjg>();
		for (TPzjg pzjg : InitSysParams.pzjgs) {
			if (pzjg.getId().getBzjgdm().equals(bzjgdm)
					&& pzjg.getId().getPzjgdm().equals(dm)) {
				return pzjg;
			}
		}
		TJgdm tJgdm = jgdmDAO.findById(dm);
		if (tJgdm != null ) {
			PzjgPK pk = new PzjgPK();
			pk.setPzjgdm(dm);
			pk.setBzjgdm(bzjgdm);
			TPzjg pzjg = new TPzjg();
			pzjg.setPzjgmc(tJgdm.getJgmc());
			return pzjg;
		} else
			return null;
	}

	public TJjhy getTjjhy(String dm) {
		return jjhyDAO.findById(dm);
	}

	public TNNJjhy getTNNjjhy(String dm) {
		return njjhyDAO.findByDM(dm);
	}

	public TJjlx getTjjlx(String dm) {
		return jjlxDAO.findById(dm);
	}

	public TNjjhy getTNjjhy(String dm) {
		TNjjhy njjhy = njjhyDAO.findById(dm);
		if (njjhy != null) {
			String jjdm = njjhy.getDm();
			map = tJjhydzBus.getMap();
			njjhy
					.setDm(jjdm
							+ ":"
							+ (map.get(jjdm.trim()) == null ? "" : map.get(jjdm
									.trim())));
			njjhy.setMc(njjhy.getMc()
					+ ":"
					+ (InitSysParams.jjhyMap.get(InitSysParams.jjhyDzMap
							.get(jjdm.trim())) == null ? ""
							: InitSysParams.jjhyMap.get(InitSysParams.jjhyDzMap
									.get(jjdm))));
		}
		return njjhy;
	}

	public TNjjlx getTNjjlx(String dm) {
		TNjjlx njjlx = njjlxDAO.findById(dm);
		if (njjlx != null) {
			String lxdm = njjlx.getDm();
			njjlx.setDm(lxdm
					+ ":"
					+ (InitSysParams.jjlxDzMap.get(lxdm) == null ? ""
							: InitSysParams.jjlxDzMap.get(lxdm)));
			njjlx.setMc(njjlx.getMc()
					+ ":"
					+ (InitSysParams.jjlxMap.get(InitSysParams.jjlxDzMap
							.get(lxdm)) == null ? "" : InitSysParams.jjlxMap
							.get(InitSysParams.jjlxDzMap.get(lxdm))));
		}
		return njjlx;
	}

	public TZgjg getTZgjgById(String dm) {
		TZgjg zgjg = new TZgjg();
		zgjg.setDm(dm);
		zgjg.setMc(InitSysParams.zgjgMap.get(dm));
		return zgjg;
	}

	public TZgjg getZgjgByMc(String dm) {
		TZgjg zgjg = new TZgjg();
		if (dm != null)
			for (Map.Entry<String, String> entry : InitSysParams.zgjgMap
					.entrySet()) {
				if (dm.equals(entry.getValue())) {
					zgjg.setDm(entry.getKey());
					zgjg.setMc(entry.getValue());
					break;
				}
			}
		return zgjg;
	}

	public THb getTHb(String dm) {
		THb hb = new THb();
		hb.setDm(dm);
		hb.setMc(InitSysParams.hbMap.get(dm));
		return hb;
	}

	public TJjlx getJjlx(String dm) {
		TJjlx hb = new TJjlx();
		hb.setDm(dm);
		hb.setMc(InitSysParams.jjlxMap.get(dm));
		return hb;
	}

	public TNNjjlx getNNTjjlx(String dm) {
		return njjlxDAO.findbyDM(dm);
	}

	public Map<String, String> get(String method) {
		return get(method, null, false);
	}

	public Map<String, String> get(String method, String bzjgdm, boolean filter) {
		Map<String, String> map = new HashMap<String, String>();
		if ("pzjg".equals(method) && bzjgdm != null) {
			map = InitSysParams.bzjgPzjgMaps.get(bzjgdm);
		}
		if ("nnjjhy".equals(method)) {
			map = InitSysParams.jjhy2k1Map;
		}
		if ("jjhydz".equals(method)) {
			map = InitSysParams.jjhyDzMap;
		}
		if ("jjlxdz".equals(method)) {
			map = InitSysParams.jjlxDzMap;
		}
		if ("nnjjlx".equals(method)) {
			map = InitSysParams.jjlx2k1Map;
		}
		if ("njjhy".equals(method)) {
			map = InitSysParams.njjhyMap;
		}
		if ("jjhy".equals(method)) {
			map = InitSysParams.jjhyMap;
		}
		if ("njjlx".equals(method)) {
			map = InitSysParams.njjlxMap;
		}
		if ("jjlx".equals(method)) {
			map = InitSysParams.jjlxMap;
		}
		if ("zgjg".equals(method)) {

			map = InitSysParams.zgjgMap;

		}
		if ("wfgb".equals(method)) {
			map = InitSysParams.gjMap;
		}
		if ("xzqh".equals(method)) {
			//map = InitSysParams.xzqhMapNoSJ;
			
			map = new TreeMap<String, String>(new Comparator<String>() {
				public int compare(String obj1, String obj2) {
					if (obj1 == null)
						return -1;
					return obj1.compareTo(obj2);
				}
			});
			boolean flag = false;
			for (Map.Entry<String, Bzjgdm> entry : InitSysParams.bzjgdmMapMc2
					.entrySet()) {
				if (filter) {
					if (entry.getKey().equals(bzjgdm))
						continue;

					if (entry.getKey().startsWith(getCenter())) {
						flag = true;
						for (String city : InitSysParams.cityFilters) {
							if (entry.getKey().startsWith(city)) {
								flag = false;
								break;
							}
						}
						if (flag)
							continue;
					}
				}
				map.put(entry.getKey(), entry.getValue().getSoMc());
			}
			
		}
		if ("zrxzqh".equals(method)) {
			map = new TreeMap<String, String>(new Comparator<String>() {
				public int compare(String obj1, String obj2) {
					if (obj1 == null)
						return -1;
					return obj1.compareTo(obj2);
				}
			});
			for (Map.Entry<String, String> entry : InitSysParams.zrxzqhMap
					.entrySet()) {
				map.put(entry.getKey(), entry.getValue());
			}
			if (filter) {
				map.remove(bzjgdm);
			}
		}
		if ("bzjgdm".equals(method)) {
			map = new TreeMap<String, String>(new Comparator<String>() {
				public int compare(String obj1, String obj2) {
					if (obj1 == null)
						return -1;
					return obj1.compareTo(obj2);
				}
			});
			boolean flag = false;
			for (Map.Entry<String, String> entry : InitSysParams.bzjgdmMap
					.entrySet()) {
				if (filter) {
					if (entry.getKey().equals(bzjgdm))
						continue;

					if (entry.getKey().startsWith(getCenter())) {
						flag = true;
						for (String city : InitSysParams.cityFilters) {
							if (entry.getKey().startsWith(city)) {
								flag = false;
								break;
							}
						}
						if (flag)
							continue;
					}
				}
				map.put(entry.getKey(), entry.getValue());
			}

		}
		if ("sccenter".equals(method)) {
			map = new TreeMap<String, String>(new Comparator<String>() {
				public int compare(String obj1, String obj2) {
					if (obj1 == null)
						return -1;
					return obj1.compareTo(obj2);
				}
			});
			boolean flag = false;
			for (Map.Entry<String, String> entry : InitSysParams.scCenterMap
					.entrySet()) {
				if (filter) {
					if (entry.getKey().equals(bzjgdm))
						continue;

					if (entry.getKey().startsWith(getCenter())) {
						flag = true;
						for (String city : InitSysParams.cityFilters) {
							if (entry.getKey().startsWith(city)) {
								flag = false;
								break;
							}
						}
						if (flag)
							continue;
					}
				}
				map.put(entry.getKey(), entry.getValue());
			}
		}
		if (method.contains("zycp")) {
			map = InitSysParams.zycpMap;
		}
		if ("jglx".equals(method)) {
			map = InitSysParams.jglxMap;
		}
		if ("njglx".equals(method)) {
			map = InitSysParams.njglxMap;
		}
		if ("hbzl".equals(method)) {
			map = InitSysParams.hbMap;
		}
		return map;
	}

	public JSONObject get(String method, String value) {
		JSONObject object = new JSONObject();
		object.put("dm", value);
		if ("pzjg".equals(method)) {
			String mc = get(method).get(value);
			if (mc == null) {
				TJgdm tJgdm = jgdmDAO.findById(value);
				if (tJgdm != null) {
					object.put("mc", tJgdm.getJgmc());

				}
			}
			return object;
		}
		flagJgdm = value;
		object.put("mc", get(method).get(value));
		/*if ("nnjjhy".equals(method)) {
			value = get("jjhydz").get(value);
			object.put("dzdm", value);
			object.put("dzmc", get("njjhy").get(value));
		}*/
		if ("njjlx".equals(method)) {
			value = get("jjlxdz").get(value);
			object.put("dzdm", value);
			object.put("dzmc", get("jjlx").get(value));
		}
		if ("zgjg".equals(method)) {

			
			if (InitSysParams.zgjgMap.get(value) == null && value.length() > 8) {
				if (!(value == null || "".equals(value))) {
					TJgdm tJgdm = jgdmDAO.findById(value);
					if(tJgdm==null){
						tJgdm=new TJgdm();
					}
					flagJgdm = tJgdm.getJgmc();
					// map=InitSysParams.zgjgMap.put(flagJgdm, tJgdm.getJgmc());
				}
			} else {
				flagJgdm = InitSysParams.zgjgMap.get(value);

			}
			object.put("mc", flagJgdm);

		}

		return object;
	}

	public String getAjaxInfo(String method, String value, String bzjgdm,
			boolean filter) {
		List<JSONObject> list = new ArrayList<JSONObject>();
		JSONArray array = null;
		int i = 0;
		Map<String, String> map = get(method, bzjgdm, filter);
		for (Map.Entry<String, String> entry : map.entrySet()) {
			if (entry.getKey().startsWith(value)
					|| (method.contains("jjhy") && entry.getKey().trim()
							.startsWith(value, 1))) {
				JSONObject object = new JSONObject();
				object.put("dm", entry.getKey().trim());
				object.put("mc", entry.getValue());
				list.add(object);
				i++;
				if (i == 15)
					break;
			}
		}
		array = JSONArray.fromObject(list);
		return array != null ? array.toString() : null;
	}

	public String isLegal(String jglx, String pzjgdm) {
		for (TJglxPzjg jglxPzjg : InitSysParams.jglxPzjgs) {
			if (jglxPzjg.getJglx().equals(jglx)
					&& jglxPzjg.getPzjgdm().equals(pzjgdm)) {
				return "true";
			}
		}
		return "false";
	}

	public String getPzjgLegal(String jglx, String bzjgdm) {
		List<TJglxPzjg> jglxPzjgs = new ArrayList<TJglxPzjg>();
		for (TJglxPzjg jglxPzjg : InitSysParams.jglxPzjgs) {
			if (jglxPzjg.getJglx().equals(jglx)) {
				jglxPzjgs.add(jglxPzjg);
			}
		}
		for (TPzjg pzjg : InitSysParams.pzjgs) {
			if (pzjg.getId().getBzjgdm().trim().equals(bzjgdm)) {
				for (TJglxPzjg jglxPzjg : jglxPzjgs) {
					if (jglxPzjg.getPzjgdm().equals(pzjg.getId().getPzjgdm())) {
						return jglxPzjg.getPzjgdm();
					}
				}
			}
		}

		return "";
	}

	// 更新主管机构表
	public String updateZgjg(String zgdm, String zgmc) {
		TZgjg zgjg = zgjgDAO.findByRealId(zgdm);
		if (zgjg != null) {
			return "no";
		} else {
			zgjg = new TZgjg();
			zgjg.setDm(zgdm);
			zgjg.setMc(zgmc);
			zgjgDAO.save(zgjg);
			return "ok";
		}
	}
}
