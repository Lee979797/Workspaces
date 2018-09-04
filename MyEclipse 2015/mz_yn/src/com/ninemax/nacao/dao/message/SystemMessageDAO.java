package com.ninemax.nacao.dao.message;

import com.ninemax.jdbc.dao.DataAccess;
import com.ninemax.jdbc.dao.clsPageComponent;
import com.ninemax.nacao.to.message.SystemMessageTO;
import com.ninemax.nacao.util.clsStringTool;
import sun.jdbc.rowset.CachedRowSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangxf
 */
public class SystemMessageDAO {

    /**
     * 添加系统公告
     *
     * @param sysMessTO
     * @return
     */
    public int addSysMess(SystemMessageTO sysMessTO) { 
    	int i = 0;
        DataAccess dataAccessObject = new DataAccess();
        String sql = "insert into SM_SYSTEM_MESSAGE ("
                + "OPER_DATE,"
                + "FROM_PERSON,"
                + "SEND_TIME,"
                + "SEND_OBJECT,"
                + "SEND_CONTENT,"
                + "SEND_TITLE,"
                + "MEMO,"
                + "TOP_STATUS,"
                + "TYPE,"
                + "SEND_STATUS,"
                + "OBJECT_TYPE"
                + ") values ("
                + "'" + com.ninemax.jpa.util.clsStringTool.convertNull(sysMessTO.getOper_date()) + "',"
                + "'" + com.ninemax.jpa.util.clsStringTool.convertNull(sysMessTO.getFrom_person()) + "',"
                + "'" + com.ninemax.jpa.util.clsStringTool.convertNull(sysMessTO.getSend_time()) + "',"
                + "'" + com.ninemax.jpa.util.clsStringTool.convertNull(sysMessTO.getSend_object()) + "',"
                + "'" + com.ninemax.jpa.util.clsStringTool.convertNull(sysMessTO.getSend_content()) + "',"
                + "'" + com.ninemax.jpa.util.clsStringTool.convertNull(sysMessTO.getSend_title()) + "',"
                + "'" + com.ninemax.jpa.util.clsStringTool.convertNull(sysMessTO.getMemo()) + "',"
                + "'" + com.ninemax.jpa.util.clsStringTool.convertNull(sysMessTO.getTop_status()) + "',"
                + "'" + com.ninemax.jpa.util.clsStringTool.convertNull(sysMessTO.getType()) + "',"
                + "'" + com.ninemax.jpa.util.clsStringTool.convertNull(sysMessTO.getSend_status()) + "',"
                + "'" + com.ninemax.jpa.util.clsStringTool.convertNull(sysMessTO.getObject_type()) + "'"
                + ")";
        String returnValue = "";
        try {
        	i = dataAccessObject.executeGetId(sql) ;//返回生成主键值
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    public String modSysMessage(SystemMessageTO systemMessageTO) {
        DataAccess dataAccessObject = new DataAccess();
        StringBuffer sql = new StringBuffer();
        sql.append("UPDATE SM_SYSTEM_MESSAGE SET ");
        sql.append("OPER_DATE = '" + com.ninemax.jpa.util.clsStringTool.convertNull(systemMessageTO.getOper_date()) + "' , ");
        sql.append("FROM_PERSON = '" + com.ninemax.jpa.util.clsStringTool.convertNull(systemMessageTO.getFrom_person()) + "' , ");
        sql.append("SEND_TIME = '" + com.ninemax.jpa.util.clsStringTool.convertNull(systemMessageTO.getSend_time()) + "' , ");
        sql.append("SEND_OBJECT = '" + com.ninemax.jpa.util.clsStringTool.convertNull(systemMessageTO.getSend_object()) + "' , ");
        sql.append("SEND_CONTENT = '" + com.ninemax.jpa.util.clsStringTool.convertNull(systemMessageTO.getSend_content()) + "' , ");
        sql.append("SEND_TITLE = '" + com.ninemax.jpa.util.clsStringTool.convertNull(systemMessageTO.getSend_title()) + "' , ");
        sql.append("MEMO = '" + com.ninemax.jpa.util.clsStringTool.convertNull(systemMessageTO.getMemo()) + "' , ");
        sql.append("TOP_STATUS = '" + com.ninemax.jpa.util.clsStringTool.convertNull(systemMessageTO.getSend_status()) + "' , ");
        sql.append("TYPE = '" + com.ninemax.jpa.util.clsStringTool.convertNull(systemMessageTO.getType()) + "' , ");
        sql.append("SEND_STATUS = '" + com.ninemax.jpa.util.clsStringTool.convertNull(systemMessageTO.getSend_status()) + "' , ");
        sql.append("OBJECT_TYPE = '" + com.ninemax.jpa.util.clsStringTool.convertNull(systemMessageTO.getObject_type()) + "' ");
        sql.append(" WHERE IDS='" + systemMessageTO.getSys_id() + "'");
        try {
            int count = dataAccessObject.execute(sql.toString());
            return count + "";
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }

    /**
     * 系统通知列表
     *
     * @param pageNo
     * @param pageSize
     * @param pageCom
     * @return
     */
    public ArrayList listSysMessage(String keyword, int pageNo, int pageSize, clsPageComponent pageCom) {
        ArrayList array = new ArrayList();
        String sql = "select * from sm_system_message where send_status = '1' and type = '0'";

        if (!clsStringTool.isEmpty(keyword)) {
            sql += " and send_title like '%" + keyword + "%' ";
        }

        sql += " order by oper_date desc ";
        try {
            pageCom.setTotalSize(sql);
            pageCom.setPageSize(pageSize);
            pageCom.setTotalPages();
            pageCom.setLastPage();
            pageCom.setStartIndex(pageNo);
            pageCom.setCurrentPage(pageNo);

            CachedRowSet crs = pageCom.getResultList(sql);
            while (crs.next()) {
                SystemMessageTO sysMessTo = setSysMessTo(crs);
                array.add(sysMessTo);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return array;
    }

    /**
     * 政务公告列表
     *
     * @param pageNo
     * @param pageSize
     * @param pageCom
     * @return
     */
    public ArrayList listAdministrativeNotice(String keyword, int pageNo, int pageSize, clsPageComponent pageCom) {
        ArrayList array = new ArrayList();
        String sql = "select * from sm_system_message where send_status = '1' and type = '3'";

        if (!clsStringTool.isEmpty(keyword)) {
            sql += " and send_title like '%" + keyword + "%' ";
        }
//        String orderByContent = "";
//		orderByContent = " oper_date desc ";
        try {
            pageCom.setTotalSize(sql);
            pageCom.setPageSize(pageSize);
            pageCom.setTotalPages();
            pageCom.setLastPage();
            pageCom.setStartIndex(pageNo);
            pageCom.setCurrentPage(pageNo);
//            pageCom.setOrderByContent(orderByContent);

            CachedRowSet crs = pageCom.getResultList(sql);
            while (crs.next()) {
                SystemMessageTO sysMessTo = setSysMessTo(crs);
                array.add(sysMessTo);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return array;
    }
    /**
     * 政务公告列表 - 最近一个
     *
     * @param pageNo
     * @param pageSize
     * @param pageCom
     * @return
     */
    public ArrayList listAdministrativeNoticeOneMonth(String keyword, int pageNo, int pageSize, clsPageComponent pageCom) {
    	ArrayList array = new ArrayList();
    	String sql = "select * from sm_system_message where  type = '3' and  oper_date > dateadd(month,-1,getdate()) ";
    	
    	if (!clsStringTool.isEmpty(keyword)) {
    		sql += " and send_title like '%" + keyword + "%' ";
    	}
    	
//        String orderByContent = "";
//		orderByContent = " oper_date desc ";
    	try {
    		pageCom.setTotalSize(sql);
    		pageCom.setPageSize(pageSize);
    		pageCom.setTotalPages();
    		pageCom.setLastPage();
    		pageCom.setStartIndex(pageNo);
    		pageCom.setCurrentPage(pageNo);
    		pageCom.setOrderByContent("oper_date desc");
    		
    		CachedRowSet crs = pageCom.getResultList(sql);
    		while (crs.next()) {
    			SystemMessageTO sysMessTo = setSysMessTo(crs);
    			array.add(sysMessTo);
    		}
    	} catch (Exception e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	
    	return array;
    }

    /**
     * 获得系统公告数据集对象
     *
     * @param crs
     * @return
     * @throws Exception
     */
    private SystemMessageTO setSysMessTo(CachedRowSet crs) throws Exception {

        SystemMessageTO sysMessTo = new SystemMessageTO();
        sysMessTo.setSys_id(crs.getString("ids"));
        sysMessTo.setFrom_person(crs.getString("from_person"));
        sysMessTo.setMemo(crs.getString("memo"));
        sysMessTo.setOper_date(crs.getString("oper_date"));
        sysMessTo.setSend_content(crs.getString("send_content"));
        sysMessTo.setSend_object(crs.getString("send_object"));
        sysMessTo.setSend_status(crs.getString("send_status"));
        sysMessTo.setSend_time(crs.getString("send_time"));
        sysMessTo.setSend_title(crs.getString("send_title"));
        sysMessTo.setTop_status(crs.getString("top_status"));
        sysMessTo.setType(crs.getString("type"));
        sysMessTo.setObject_type(crs.getString("object_type"));

        return sysMessTo;
    }

    /**
     * 删除系统公告
     *
     * @param sys_id 
     * @return
     */ 
    public boolean delSysMessage(String sys_id) {
        DataAccess dataAccessObject = new DataAccess();
        boolean reuslt = false;
        String sql = " delete from sm_system_message  where ids = '" + sys_id + "'";

        try {
            if (dataAccessObject.execute(sql) == 1) {
                reuslt = true;
            } else {
                reuslt = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return reuslt;
    }

    /**
     * 设置公告置顶
     *
     * @param sys_id
     * @return
     */
    public boolean messSetTop(String sys_id, String top_status) {
        DataAccess dataAccessObject = new DataAccess();
        boolean reuslt = false;
        String sql = "update sm_system_message set top_status = '" + top_status + "' where ids = '" + sys_id + "'";

        try {
            if (dataAccessObject.execute(sql) == 1) {
                reuslt = true;
            } else {
                reuslt = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return reuslt;
    }

    /**
     * 得到置顶公告对象
     *
     * @return
     */
    public SystemMessageTO getMessTop() {
        DataAccess dataAccessObject = new DataAccess();
        SystemMessageTO sysMessTo = null;

        String sql = "select * from sm_system_message where top_status = '1' and send_status = '1' ";

        try {

            CachedRowSet crs = dataAccessObject.query(sql);
            if (crs.next()) {
                sysMessTo = setSysMessTo(crs);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sysMessTo;
    }

    /**
     * 后台首页得到置顶公告对象
     *
     * @return
     */
    public SystemMessageTO getMessTopByUserID(String c_userid) {
        DataAccess dataAccessObject = new DataAccess();
        SystemMessageTO sysMessTo = null;

        //	String sql = "select * from sm_system_message where top_status = '1' and send_status = '1' ";
        String sql = "select * from sm_system_message where "
                + "ids = (select max(sys_id) from sm_user_message "
                + "where type = '0' and c_userid = '" + c_userid + "') and send_status = '1' and type='0' ";
        try {

            CachedRowSet crs = dataAccessObject.query(sql);
            if (crs.next()) {
                sysMessTo = setSysMessTo(crs);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sysMessTo;
    }

    /**
     * 根据sys_id查询系统公告数据
     *
     * @param sys_id
     * @return
     */
    public SystemMessageTO findBySysID(String sys_id) {
        DataAccess dataAccessObject = new DataAccess();
        SystemMessageTO sysMessTo = null;

        String sql = "select * from sm_system_message where ids = '" + sys_id + "'";
        try {

            CachedRowSet crs = dataAccessObject.query(sql);
            if (crs.next()) {
                sysMessTo = setSysMessTo(crs);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sysMessTo;
    }

    /**
     * 站内信息发件箱
     *
     * @param pageNo
     * @param pageSize
     * @param pageCom
     * @param from_person
     * @return
     */
    public ArrayList listUserSendMessage(String keyword, String type, int pageNo, int pageSize, clsPageComponent pageCom, String from_person) {
        ArrayList array = new ArrayList();
        String sql = "select * from sm_system_message where send_status = '1' and from_person = '" + from_person + "' ";

        if (!clsStringTool.isEmpty(keyword)) {
            sql += " and send_title like '%" + keyword + "%' ";
        }
//		if(!clsStringTool.isEmpty(type)){
        sql += " and type != '2' ";
//        }
        sql += " order by oper_date desc ";
        try {
            pageCom.setTotalSize(sql);
            pageCom.setPageSize(pageSize);
            pageCom.setTotalPages();
            pageCom.setLastPage();
            pageCom.setStartIndex(pageNo);
            pageCom.setCurrentPage(pageNo);

            CachedRowSet crs = pageCom.getResultList(sql);
            while (crs.next()) {
                SystemMessageTO sysMessTo = setSysMessTo(crs);
                array.add(sysMessTo);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return array;
    }

    /**
     * Gov站内信息发件箱
     *
     * @param pageNo
     * @param pageSize
     * @param from_person
     * @return
     */
    public Map listUserSendMessageForGov(String keyword, int pageNo, int pageSize, String from_person) {
        ArrayList array = new ArrayList();
        clsPageComponent pageCom = new clsPageComponent();
        Map map = new HashMap();
        String sql = "select * from sm_system_message where send_status = '1' and type = '1' and from_person = '" + from_person + "' ";

        if (!clsStringTool.isEmpty(keyword)) {
            sql += " and send_title like '%" + keyword + "%' ";
        }
        sql += " order by oper_date desc ";
        try {
            pageCom.setTotalSize(sql);
            pageCom.setPageSize(pageSize);
            pageCom.setTotalPages();
            pageCom.setLastPage();
            pageCom.setStartIndex(pageNo);
            pageCom.setCurrentPage(pageNo);

            CachedRowSet crs = pageCom.getResultList(sql);
            while (crs.next()) {
                SystemMessageTO sysMessTo = setSysMessTo(crs);
                array.add(sysMessTo);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        map.put("1", pageCom.getTotalSize());
        map.put("2", array);
        return map;
    }

    /**
     * 得到用户发出留言总条数
     *
     * @param c_userid
     * @param type
     * @return
     */

    public int getUserSendMessageNum(String c_userid, String type) {

        DataAccess dataAccessObject = new DataAccess();
        int messNum = 0;
        String sql = "select count(*) as amount from sm_system_message where send_status = '1' and from_person = "
                + "'" + c_userid + "'"
                + " and type = "
                + "'" + type + "'";


        try {
            CachedRowSet rs = dataAccessObject.query(sql);
            if (rs.next()) {
                messNum = rs.getInt("amount");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return messNum;
    }

    /**
     * 提取用户收到的信息
     *
     * @param pageCom
     * @param object_type 对象类型
     * @param send_object 发送对象
     * @param c_userid    用户ID
     * @return
     */
    public ArrayList extractionUserMess(clsPageComponent pageCom, String object_type, String send_object, String c_userid) {
        ArrayList array = new ArrayList();
        String sql = "select * from sm_system_message s where "
                + " s.object_type='" + object_type + "' "
                + " and (s.type='0' or  s.type ='1') "
                + " and send_status='1' ";

        if ("0".equals(object_type)) {
        } else if ("2".equals(object_type)) {
            sql += " and send_object like '%" + send_object + "%' ";
        } else {
            sql += " and send_object='" + send_object + "' ";
        }

        sql += " and s.IDS not in "
                + " (select u.sys_id from sm_user_message u where "
                + "u.c_userid='" + c_userid + "'"
                + ")";

        try {

            CachedRowSet crs = pageCom.getResultList(sql);
            while (crs.next()) {
                SystemMessageTO sysMessTo = setSysMessTo(crs);
                array.add(sysMessTo);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return array;
    }


    /**
     * 提取用户收到的系统公告、通知信息
     *
     * @param pageCom
     * @param object_type 对象类型
     * @param send_object 发送对象
     * @param c_userid    用户ID
     * @return
     */
    public ArrayList extractionUserMessNotice(clsPageComponent pageCom, String object_type, String send_object, String c_userid) {
        ArrayList array = new ArrayList();
        String sql = "select * from sm_system_message s where "
                + " s.object_type like '%" + object_type + "%' "
                + " and (s.type='0' or  s.type ='3') "
                + " and send_status='1' ";

        sql += " and send_object like '%," + send_object + ",%' ";

        sql += " and s.IDS not in "
                + " (select u.sys_id from sm_user_message u where "
                + "u.c_userid='" + c_userid + "'"
                + ")";

        try {

            CachedRowSet crs = pageCom.getResultList(sql);
            while (crs.next()) {
                SystemMessageTO sysMessTo = setSysMessTo(crs);
                array.add(sysMessTo);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return array;
    }

    public List<SystemMessageTO> getFirstTop() {
        List<SystemMessageTO> list = new ArrayList<SystemMessageTO>();
        DataAccess dataAccessObject = new DataAccess();

        String sql = "select  * from sm_system_message where type = '3' and  oper_date > dateadd(month,-1,getdate())  order by oper_date desc";
        try {
            CachedRowSet crs = dataAccessObject.query(sql);
            while (crs.next()) {
                list.add(setSysMessTo(crs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }
}
