package com.ninemax.jpa.global;

import com.ninemax.jpa.code.bus.*;
import com.ninemax.jpa.code.dao.TJglxPzjgDao;
import com.ninemax.jpa.code.model.*;
import com.ninemax.jpa.system.bo.*;
import com.ninemax.jpa.system.model.*;

import java.util.*;

import net.sf.json.JSONObject;

/**
 * @author zhhuiyan
 * @version 1.0
 */
public class InitSysParams {

    private static InitSysParams initSysParams = new InitSysParams();

    private PoliticalLandscapeBo politicalLandscapeBo = null; //政治面貌
    private ForbidwordBo forbidwordBo = null; //敏感字
    private PmtranslateBo pmtranslateBo = null; //错误结果提示中文

    private BzjgdmBo bzjgdmBo = null;
    private THbBus tHbBo = null;
    private TXzqhBus xzqhBo = null;
    private TXzqhBus1 xzqh1Bo = null;
    private TZrxzqhBus zrxzqhBus = null;
    private TJglxBus tJglxBo = null;
    private TZjlxBus tZjlxBo = null;
    private TNjjhyBus tNjjhyBo = null;
    private TJjhyBus jjhyBo = null;
    private TNjjlxBus njjlxBo = null;
    private TJjlxBus jjlxBo = null;
    private TZgjgBus zgjgBo = null;
    private TGjBus gjBo = null;
    private TPzjgBus pzjgBo = null;
    private TZycpBus zycpBo = null;
    private TJjhydzBus jjhyDzBo = null;
    private TJjlxdzBus jjlxDzBo = null;
    private TCflxBus cflxBus = null;
    private ScCenterBus scCenterBus = null;
    private TOperateTypeBus optBus = null;
    private TJglxBtxBus btxBus = null;
    private TJglxPzjgDao jglxPzjgDao = null;
    private TSystemBus systemBus;
    private PreScanBus preScanBus;
    private ScFieldsBo fieldsBo = null;
    private TSppzBus tsppzBus = null;
    /**
     * ImagePath
     */
    public static String ImagePath = "";
    public static TSystem system;


    public static List<Bzjgdm> BzjgdmList = null;
    public static List<PoliticalLandscape> PoliticalLandscapeList = null;
    public static List<Forbidword> forbidwords = null;
    public static HashMap PMTranslates = null;
    public static List<ScFields> fields;
    public static List<PreScan> scans;
    public static ArrayList xzqhs = null;//行政区划
    public static ArrayList sccenter = null;//一级办证机构
    //zx 添加 码表放到内存中
    public static List<THb> thbList = null;
    public static List<TJglx> tjglxList = null;
    public static List<TNJglx> tnJglxList = null;
    public static List<TNNjjlx> tnnJjlxList = null;
    public static List<TGj> gjList = null;
    public static List<ScZw> zwList = null;
    public static List<ScMz> mzList = null;
    public static List<ScZzmm> zzmmList = null;
    public static List<ScWjdyy> yyList = null;
    public static List<ScDzzlx> dzzlxList = null;
    public static List<TZjlx> tZjlxList = null;
    public static List<TJglxPzjg> jglxPzjgs = null;
    public static Map<String, String> zjlxMap = null;
    public static Map<String, String> hbMap = null;
    public static Map<String, String> jglxMap = null;
    public static Map<String, String> njjhyMap = null;
    public static Map<String, String> njjhyBigMap = null;
    public static Map<String, String> jjhyMap = null;
    public static Map<String, String> jjhy2k1Map = null;
    public static Map<String, String> jjhyBigMap = null;
    public static Map<String, TNNJjhy> jjhy2k1Map2 = null;
    public static Map<String, String> jjlxDzMap = null;
    public static Map<String, String> jjhyDzMap = null;
    public static Map<String, String> njjlxMap = null;
    public static Map<String, String> jjlxMap = null;
    public static Map<String, String> jjlx2k1Map = null;
    public static Map<String, String> zgjgMap = null;
    public static Map<String, String> gjMap = null;
    public static Map<String, String> bzjgdmMap = null;
    public static Map<String, Bzjgdm> bzjgdmMapMc = null;
    public static Map<String, String> bzjgdmMapMc1 = null;
    public static Map<String, Bzjgdm> bzjgdmMapMc2 = null;
    public static Map<String, String> xzqhMap = null;
    public static Map<String, String> xzqhMap1 = null;
    public static Map<String, String> xzqhMapNoSJ = null;
    public static Map<String, String> xzqhAllMap = null;
    public static Map<String, String> zrxzqhMap = null;
    public static Map<String, TZrxzqh> zrxzqhMap2 = null;
    public static Map<String, Map<String, String>> bzjgPzjgMaps = null;
    public static List<TPzjg> pzjgs = null;
    public static Map<String, String> zycpMap = null;
    public static Map<String, String> cflxMap = null;
    public static Map<String, String> scCenterMap = null;
    public static Set<String> cityFilters = null;
    public static Map<String, String> optTypeMap = null;
    public static Map<String, String> operTypeAllMap = null;
    public static Map<String, String> requiredItems = null;
    public static Map<String, String> njglxMap = null;
    public static Map<String, String> btxs = null;
    public static Map<String, String> sppzMap = null;
    public static Map<String,String>  orgs=null;
    public static Map<String,String > ywlxMap=null;
    
    public static Map<String,ScXzqhdz > xzqhdzMap=null;
    
    public static Map<String,String> frontZrxzqh=null;

    private InitSysParams() {
        politicalLandscapeBo = new PoliticalLandscapeBo();
        forbidwordBo = new ForbidwordBo();
        pmtranslateBo = new PmtranslateBo();
        tHbBo = new THbBus();
        tJglxBo = new TJglxBus();
        tZjlxBo = new TZjlxBus();
        tNjjhyBo = new TNjjhyBus();
        jjhyBo = new TJjhyBus();
        njjlxBo = new TNjjlxBus();
        jjlxBo = new TJjlxBus();
        zgjgBo = new TZgjgBus();
        gjBo = new TGjBus();
        pzjgBo = new TPzjgBus();

        zycpBo = new TZycpBus();
        jjhyDzBo = new TJjhydzBus();
        jjlxDzBo = new TJjlxdzBus();
        xzqhBo = new TXzqhBus();
        xzqh1Bo = new TXzqhBus1();
        zrxzqhBus = new TZrxzqhBus();
        cflxBus = new TCflxBus();
        bzjgdmBo = new BzjgdmBo();
        scCenterBus = new ScCenterBus();
        optBus = new TOperateTypeBus();
        fieldsBo = new ScFieldsBo();
        systemBus = new TSystemBus();
        btxBus = new TJglxBtxBus();
        jglxPzjgDao = new TJglxPzjgDao();
        preScanBus = new PreScanBus();
        tsppzBus = new TSppzBus();
    }

    public static InitSysParams getInstance() {
        return initSysParams;
    }

    public void InitSysParams() {
        //system = systemBus.getTSystem();
        //PoliticalLandscapeList = politicalLandscapeBo.findAll();
        //forbidwords = forbidwordBo.findAll();
        PMTranslates = pmtranslateBo.GetPMS();
       // thbList = tHbBo.findAll();
        //tjglxList = tJglxBo.findAll();
        //tnJglxList = tJglxBo.findNAll();
        tZjlxList = tZjlxBo.findAll();
        //tnnJjlxList = jjlxBo.findAlljjlx2011();
        zjlxMap = tZjlxBo.getMap();
        hbMap = tHbBo.getMap();
        //jglxMap = tJglxBo.getMap();
        //njglxMap = tJglxBo.getNMap();
       // njjhyMap = tNjjhyBo.getMap();
        //njjhyBigMap = tNjjhyBo.getBigMap();
        //jjhyMap = jjhyBo.getMap();
        jjhy2k1Map = tNjjhyBo.get2k1Map();
        jjhy2k1Map2 = tNjjhyBo.get2k1Map2();
        //jjhyBigMap = jjhyBo.getBigMap();
        //njjlxMap = njjlxBo.getMap();
        //jjlxMap = jjlxBo.getMap();
        ///jjlx2k1Map = njjlxBo.get2k1Map();
       // zgjgMap = zgjgBo.getMap();
        //gjMap = gjBo.getMap();
        gjList =gjBo.getGjList();
        zwList=gjBo.getZwList();
        mzList=gjBo.getMzList();
        zzmmList=gjBo.getZzmmList();
        //dzzlxList=gjBo.getDzzlx();
        //yyList=gjBo.getWjdyy();
       // bzjgPzjgMaps = pzjgBo.getMap();
       // pzjgs = pzjgBo.getAll();
        //zycpMap = zycpBo.getMap();
       // jjhyDzMap = jjhyDzBo.getMap();
        //jjlxDzMap = jjlxDzBo.getMap();
        //cflxMap = cflxBus.getMap();
        xzqhMap = xzqhBo.getMap();
        xzqhMap1 = xzqhBo.getMap1();
        xzqhMapNoSJ = xzqhBo.getMapNoSJ();
        xzqhdzMap=xzqhBo.getMapXzqhDz();
        //xzqhAllMap = xzqh1Bo.getMap();
       // zrxzqhMap = zrxzqhBus.getMap();
       // zrxzqhMap2 = zrxzqhBus.getTZrxzqhMap();
        bzjgdmMap = bzjgdmBo.getMap();
        bzjgdmMapMc = bzjgdmBo.getMapMc();
        bzjgdmMapMc1 = bzjgdmBo.getMap1();
        bzjgdmMapMc2 = bzjgdmBo.getMapMc1();
       // scCenterMap = scCenterBus.getMap();
        //cityFilters = scCenterBus.cityFilters();
        optTypeMap = optBus.getMap2();
        operTypeAllMap = optBus.getMap();
       // fields = fieldsBo.selectAll();
       // ywlxMap = tsppzBus.getMap();

        btxs = btxBus.getBtxs();
       // jglxPzjgs = jglxPzjgDao.findAll();
        //scans = preScanBus.getAll();
        //sppzMap = new TSpBus().getMap();
        //机构类型打印
        //orgs=btxBus.getOrg();
      //前置扫描管理
        frontZrxzqh=btxBus.getfrontZrxzqh();
       // ywlxMap = btxBus.getLx();
     }


    

}
