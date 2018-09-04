package com.ninemax.jdbc.dao.system;

import com.ninemax.jdbc.dao.DataAccess;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.system.model.User;
import com.ninemax.jpa.system.model.ZSuser;
import com.ninemax.jpa.util.clsStringTool;
import org.apache.log4j.Logger;
import sun.jdbc.rowset.CachedRowSet;

import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class clsUserDAO {

    private static Logger log = Logger.getLogger(clsUserDAO.class);

    public clsUserDAO() {

    }

    public static int GetCountByRoleId(String role_id) {

        DataAccess dataAccessObject = new DataAccess();
        CachedRowSet crs = null;
        int intCount = 0;
        String sql = "select count(*) as num from sm_usermanage where role_id='" + role_id + "' and user_status='0'";
        try {

            crs = dataAccessObject.query(sql);
            if (crs.next()) {
                intCount = crs.getInt("num");
            }
        } catch (Exception e) {
            log.error("error", e);
            throw new RuntimeException(e.getMessage(), e);
        }
        return intCount;
    }


    public int GetCountByDepartment(String dept_id) {

        DataAccess dataAccessObject = new DataAccess();
        CachedRowSet crs = null;
        int intCount = 0;
        String sql = "select count(*) as num from sm_usermanage where user_branch='" + dept_id + "' and user_status='0'";
        try {

            crs = dataAccessObject.query(sql);
            if (crs.next()) {
                intCount = crs.getInt("num");
            }
        } catch (Exception e) {
            log.error("error", e);
            throw new RuntimeException(e.getMessage(), e);
        }
        return intCount;
    }


    public ArrayList GetByDepartment(String dept_id) {

        DataAccess dataAccessObject = new DataAccess();
        ArrayList users = new ArrayList();

        String sql = "select * from sm_usermanage where user_branch='" + dept_id + "' and user_kind='0' and user_status='0'";
        try {
            CachedRowSet crs = dataAccessObject.query(sql);
            while (crs.next()) {
                User userTO = setUserTO(crs);
                users.add(userTO);
            }
        } catch (Exception e) {
            log.error("error", e);
            throw new RuntimeException(e.getMessage(), e);
        }
        return users;
    }

    public static int GetCountByGroupId(String group_id) {

        DataAccess dataAccessObject = new DataAccess();
        CachedRowSet crs = null;
        int intCount = 0;
        String sql = "select count(*) as num from sm_usermanage where usergroup_id='" + group_id + "' and user_status='0'";
        try {

            crs = dataAccessObject.query(sql);
            if (crs.next()) {
                intCount = crs.getInt("num");
            }

        } catch (Exception e) {
            log.error("error", e);
            throw new RuntimeException(e.getMessage(), e);
        }
        return intCount;
    }


    public User FindUserById(String userId) {

        DataAccess dataAccessObject = new DataAccess();
        CachedRowSet crs = null;
        User userTO = null;

        String sql = "select * from SM_UserManage where user_id='" + userId + "'";
        try {

            crs = dataAccessObject.query(sql);
            if (crs.next()) {

                userTO = setUserTO(crs);
            }
        } catch (Exception e) {
            log.error("error", e);
            throw new RuntimeException(e.getMessage(), e);
        }

        return userTO;
    }

    public List getAllUsersByGroupId(String groupId) {

        DataAccess dataAccessObject = new DataAccess();
        CachedRowSet crs = null;
        User userTO = null;
        List list = new ArrayList();
        String sql = "select * from sm_usermanage  where user_branch ='" + groupId + "' and  user_kind = '1'";
        try {

            crs = dataAccessObject.query(sql);

            while (crs.next()) {
                userTO = setUserTO(crs);
                list.add(userTO);
            }
        } catch (Exception e) {
            log.error("error", e);
            throw new RuntimeException(e.getMessage(), e);
        }

        return list;
    }

    public static void main(String g[]) throws SQLException {

        try {

        } catch (Exception e) {
            log.error("error", e);
            throw new RuntimeException(e.getMessage(), e);
        }


    }

    public String FindUserNameById(String userId) {

        DataAccess dataAccessObject = new DataAccess();
        CachedRowSet crs = null;
        String userName = null;
        String sql = "select user_name from SM_UserManage where user_id='" + userId + "'";
        try {

            crs = dataAccessObject.query(sql);
            if (crs.next()) {
                userName = crs.getString("user_name");
            }
        } catch (Exception e) {
            log.error("error", e);
            throw new RuntimeException(e.getMessage(), e);
        }

        return userName;
    }


    public User FindUserByName(String userName) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        String sql = "select model from User model where model.userName='" + userName + "' and model.userStatus='0'";
        try {
            List<User> users = em.createQuery(sql).getResultList();
            if (users != null && !users.isEmpty())
                return users.get(0);
        } catch (Exception e) {
            log.error("error", e);
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return null;
    }

    /**
     * IC卡验证
     *
     * @param jgdm
     * @return
     */
    public User checkIC(String jgdm) {

        DataAccess dataAccessObject = new DataAccess();
        CachedRowSet crs = null;
        User userTO = null;

        String sql = "select * from SM_UserManage where iccade='" + clsStringTool.convertNull(jgdm) + "' and user_status='0'";
        try {
            //	clsLog.logDebug("userSQL="+sql);
            crs = dataAccessObject.query(sql);
            if (crs.next()) {

                userTO = setUserTO(crs);
            }
        } catch (Exception e) {
            log.error("error", e);
            throw new RuntimeException(e.getMessage(), e);
        }

        return userTO;
    }

    /**
     * CA验证
     *
     * @param name
     * @return
     */
    public User checkCA(String name,String chooseName) {

        DataAccess dataAccessObject = new DataAccess();
        CachedRowSet crs = null;
        User userTO = null;

        String sql = "select * from SM_UserManage where cncode='" + clsStringTool.convertNull(name) + "' and user_status='0' and user_name = '"+chooseName+"'";
        try {
            //	clsLog.logDebug("userSQL="+sql);
            crs = dataAccessObject.query(sql);
            if (crs.next()) {

                userTO = setUserTO(crs);
            }
        } catch (Exception e) {
            log.error("error", e);
            throw new RuntimeException(e.getMessage(), e);
        }

        return userTO;
    }

    public List<User> userCAList(String name) {

        DataAccess dataAccessObject = new DataAccess();
        CachedRowSet crs = null;
        User userTO = null;
        List<User> list = null;

        String sql = "select * from SM_UserManage where cncode='" + clsStringTool.convertNull(name) + "' and user_status='0'";
        try {
            //	clsLog.logDebug("userSQL="+sql);
            crs = dataAccessObject.query(sql);
            list = new ArrayList<User>();
            while (crs.next()) {
                userTO = setUserTO(crs);
                list.add(userTO);
            }
        } catch (Exception e) {
            log.error("error", e);
            throw new RuntimeException(e.getMessage(), e);
        }
        return list;
    }

    public static ArrayList getUserIdByRoleId(String role_id) {

        DataAccess dataAccessObject = new DataAccess();
        CachedRowSet crs = null;
        ArrayList arrUserId = new ArrayList();
        String sql = "select user_id from sm_usermanage where role_id='" + role_id + "' and user_status='0'";

        try {

            crs = dataAccessObject.query(sql);
            while (crs.next()) {
                arrUserId.add(crs.getString("user_id").trim());
            }

        } catch (Exception e) {
            log.error("error", e);
            throw new RuntimeException(e.getMessage(), e);
        }
        return arrUserId;

    }

    public static ArrayList getUserIdByGroupId(String group_id) {

        DataAccess dataAccessObject = new DataAccess();
        CachedRowSet crs = null;
        ArrayList arrUserId = new ArrayList();
        String sql = "select user_id from sm_usermanage where usergroup_id='" + group_id + "' and user_status='0'";
        try {

            crs = dataAccessObject.query(sql);
            while (crs.next()) {
                arrUserId.add(crs.getString("user_id").trim());
            }

        } catch (Exception e) {
            log.error("error", e);
            throw new RuntimeException(e.getMessage(), e);
        }
        return arrUserId;

    }


    /**
     * ql更新登录时间
     *
     * @return false/true
     */
    public boolean UpdateLastLogin(String userId) {

        boolean reuslt = false;
        java.text.SimpleDateFormat sd = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sd.format(new java.util.Date());
        DataAccess dataAccessObject = new DataAccess();
        String sql = "update sm_usermanage set lastlogin='" + date + "' where user_id='" + userId + "'";
        try {
            if (dataAccessObject.execute(sql) == 1) {
                reuslt = true;
            } else {
                reuslt = false;
            }
        } catch (Exception e) {
            log.error("error", e);
            throw new RuntimeException(e.getMessage(), e);
        }
        return reuslt;
    }


//    public static ArrayList getUserIdByUgId(String group_id){
//		
//    	DataAccess dataAccessObject  = new DataAccess();
//		CachedRowSet crs = null;
//		
//		ArrayList arrUserId = new ArrayList();
//	//	String sql = "select * from sm_usermanage where usergroup_id like '%"+group_id+"%' and user_status='0'";
//		String sql = "select user_id,user_name,substr(user_province,0,2)||'0000' user_province from sm_usermanage where usergroup_id like '%"+group_id+"%' and user_status='0'";
//		try{
//			
//			crs = dataAccessObject.query(sql);
//			while(crs.next()){
//				AudiUser audiUser = new AudiUser();
//				audiUser.setAreaCode(crs.getString("user_province").trim());
//				audiUser.setId(crs.getString("user_id").trim());
//				audiUser.setName(crs.getString("user_name").trim());
//				arrUserId.add(audiUser);
//			}
//			
//		}catch(Exception e){}
//		return arrUserId;
//	
//	}

//    public ArrayList getAudiUserByProvince(String user_province){
//		
//    	DataAccess dataAccessObject  = new DataAccess();
//		CachedRowSet crs = null;
//		
//		ArrayList arrUserId = new ArrayList();
//	//	String sql = "select * from sm_usermanage where trim(user_province) = '"+user_province.trim()+"' and user_status='0'";
//		String sql = "select user_id,user_name,substr(user_province,0,2)||'0000' user_province from sm_usermanage where substr(trim(user_province), 0, 2) = substr('"+user_province.trim()+"',0,2) and user_status='0'";
//		try{
//			
//			crs = dataAccessObject.query(sql);
//			while(crs.next()){
//				AudiUser audiUser = new AudiUser();
//				audiUser.setAreaCode(crs.getString("user_province").trim());
//				audiUser.setId(crs.getString("user_id").trim());
//				audiUser.setName(crs.getString("user_name").trim());
//				arrUserId.add(audiUser);
//			}
//			
//		}catch(Exception e){}
//		return arrUserId;
//	
//	}

    public String getGroupIdByUserId(String userId) {

        DataAccess dataAccessObject = new DataAccess();
        CachedRowSet crs = null;
        String strGroupId = "";
        String sql = "select usergroup_id from sm_usermanage where user_id='" + userId + "' and user_status='0'";
        try {

            crs = dataAccessObject.query(sql);
            while (crs.next()) {
                strGroupId = crs.getString("usergroup_id").trim();
            }

        } catch (Exception e) {
            log.error("error", e);
            e.printStackTrace();
        }
        return strGroupId;

    }


    public static String getUserIdByName(String user_name) throws SQLException {

        DataAccess dataAccessObject = new DataAccess();
        CachedRowSet crs = null;
        String strUser_id = "";
        String sql = "select user_id from sm_usermanage where user_name='" + user_name + "' and user_status='0'";


        crs = dataAccessObject.query(sql);
        if (crs.next()) {
            strUser_id = crs.getString("user_id");
        }


        return strUser_id;

    }


    public static boolean CheckPassword(String user_name, String password) {
        DataAccess dataAccessObject = new DataAccess();
        CachedRowSet crs = null;
        boolean strUser_id = false;
        String sql = "select * from sm_usermanage u where user_name='" + user_name + "' and user_password='" + password + "'  and user_status='0'";
        try {

            crs = dataAccessObject.query(sql);
            if (crs.next()) {
                strUser_id = true;
            }

        } catch (Exception e) {
            log.error("error", e);
            e.printStackTrace();
        }
        return strUser_id;
    }

    public static boolean checkXzqh(String user_name, String password) {
        DataAccess dataAccessObject = new DataAccess();
        CachedRowSet crs = null;
        boolean strUser_id = false;
        String sql = "select * from sm_usermanage u where user_name='" + user_name + "' and user_password='" + password + "'  and user_status='0' and (select count(1) from t_zrxzqh zr where  u.bzjgdm=zr.xzqh and zr.flag='1' )!=0";
        try {

            crs = dataAccessObject.query(sql);
            if (crs.next()) {
                strUser_id = true;
            }

        } catch (Exception e) {
            log.error("error", e);
            e.printStackTrace();
        }
        return strUser_id;
    }

    public User CheckPasswordForGov(String user_name, String password) {
        DataAccess dataAccessObject = new DataAccess();
        CachedRowSet crs = null;
        User userTO = null;

        String sql = "select * from sm_usermanage where user_name='" + user_name + "' and user_password='" + password + "'";

        try {

            crs = dataAccessObject.query(sql);
            if (crs.next()) {
                userTO = setUserTO(crs);
            }

        } catch (Exception e) {
            log.error("error", e);
            e.printStackTrace();
        }
        return userTO;
    }

    public boolean DeleteUser(String userId) {

        boolean reuslt = false;
        DataAccess dataAccessObject = new DataAccess();
        String sql = "update sm_usermanage set user_status='1' where user_id='" + userId + "'";
        try {
            if (dataAccessObject.execute(sql) == 1) {
                reuslt = true;
            } else {
                reuslt = false;
            }
        } catch (Exception e) {
            log.error("error", e);
            e.printStackTrace();
        }
        return reuslt;
    }

    public boolean userStatus(String userId, String user_status) {

        boolean reuslt = false;
        DataAccess dataAccessObject = new DataAccess();
        String sql = "update sm_usermanage set user_status='" + user_status + "' where user_id='" + userId + "'";

        try {
            if (dataAccessObject.execute(sql) == 1) {
                reuslt = true;
            } else {
                reuslt = false;
            }
        } catch (Exception e) {
            log.error("error", e);
            e.printStackTrace();
        }
        return reuslt;
    }

    public void ChanagePassword(String userId, String newPassword) {


        DataAccess dataAccessObject = new DataAccess();
        String sql = "update sm_usermanage set user_password='" + newPassword + "' where user_id='" + userId + "'";
        try {
            dataAccessObject.execute(sql);
        } catch (Exception e) {
            log.error("error", e);
            e.printStackTrace();
        }

    }


    /**
     * 周鹏鹏
     * 查找出 相关子站点的所有用户，删除站点的时候一并所属的用户
     *
     * @param web_id
     * @return
     */
    public ArrayList findUserByWeb_id(String web_id) {
        DataAccess dataAccessObject = new DataAccess();
        CachedRowSet crs = null;
        ArrayList arrUserId = new ArrayList();
        String sql = "select user_id from sm_usermanage where trim(item1) = '" + web_id.trim() + "' and user_status='0'";
        try {

            crs = dataAccessObject.query(sql);
            while (crs.next()) {
                arrUserId.add(crs.getString("user_id").trim());
            }

        } catch (Exception e) {
            log.error("error", e);
            e.printStackTrace();
        }
        return arrUserId;
    }

    public static String hasPngByUserID(String userId, String user_province) {

        DataAccess dataAccessObject = new DataAccess();
        CachedRowSet crs = null;
        String strUser_id = "";
        //	String sql = "select user_id from sm_usermanage where user_id='"+userId+"' and user_province = '"+user_province+"' and png is not null ";
        String sql = "select user_id from sm_usermanage where user_id='" + userId + "' and substr(user_province,0,2) = substr('" + user_province + "',0,2) and png is not null ";
        try {

            crs = dataAccessObject.query(sql);
            if (crs.next()) {
                strUser_id = crs.getString("user_id");
            }

        } catch (Exception e) {
            log.error("error", e);
            e.printStackTrace();
        }
        return strUser_id;
    }

    public static String getUserProvinceByUserID(String userId) {

        DataAccess dataAccessObject = new DataAccess();
        CachedRowSet crs = null;
        String strUser_province = "";
        //	String sql = "select user_province from sm_usermanage where trim(user_id)='"+userId.trim()+"'  ";
        String sql = "select substr(user_province, 0, 2)||'0000' user_province from sm_usermanage where trim(user_id)='" + userId.trim() + "'  ";
        try {

            crs = dataAccessObject.query(sql);
            if (crs.next()) {
                strUser_province = crs.getString("user_province");
            }

        } catch (Exception e) {
            log.error("error", e);
            e.printStackTrace();
        }
        return strUser_province;
    }

    /**
     * 为工作流提供
     *
     * @param dept_id
     * @return
     */
    public ArrayList GetByDepartmentForWork(String dept_id) {

        DataAccess dataAccessObject = new DataAccess();
        ArrayList users = new ArrayList();

        String sql = "select * from sm_usermanage where user_branch='" + dept_id + "' and user_status='0'";
        try {
            CachedRowSet crs = dataAccessObject.query(sql);
            while (crs.next()) {
                User userTO = setUserTO(crs);
                users.add(userTO);
            }
        } catch (Exception e) {
            log.error("error", e);
            e.printStackTrace();
        }
        return users;
    }

    /**
     * 为工作流提供省份用户
     *
     * @param areaCodes
     * @return
     */
    public ArrayList GetUserByAreaCodeForWork(String areaCodes) {

        DataAccess dataAccessObject = new DataAccess();
        ArrayList users = new ArrayList();

        String sql = "select * from sm_usermanage where substr(user_province,0,2) in (" + areaCodes + ") and user_status='0'";
        try {
            CachedRowSet crs = dataAccessObject.query(sql);
            while (crs.next()) {
                User userTO = setUserTO(crs);
                users.add(userTO);
            }
        } catch (Exception e) {
            log.error("error", e);
            e.printStackTrace();
        }
        return users;
    }


    public User hasKeyByUserID(String userId) {

        DataAccess dataAccessObject = new DataAccess();
        CachedRowSet crs = null;
        User userTO = null;
        String strUser_id = "";
        String sql = "select * from sm_usermanage where user_id='" + userId + "' and png is not null ";

        try {

            crs = dataAccessObject.query(sql);
            if (crs.next()) {

                userTO = setUserTO(crs);

            }

        } catch (Exception e) {
            log.error("error", e);
            e.printStackTrace();
        }
        return userTO;
    }

    public static String getUserIdByEmail(String user_email) {

        DataAccess dataAccessObject = new DataAccess();
        CachedRowSet crs = null;
        String strUser_id = "";
        String sql = "select user_id from sm_usermanage where user_email='" + user_email + "' and user_status='0'";

        try {

            crs = dataAccessObject.query(sql);
            if (crs.next()) {
                strUser_id = crs.getString("user_id");
            }

        } catch (Exception e) {
            log.error("error", e);
            e.printStackTrace();
        }
        return strUser_id;

    }

    public static String getZSUserIdByName(String user_name) {

        DataAccess dataAccessObject = new DataAccess();
        CachedRowSet crs = null;
        String strUser_id = "";
        String sql = "select user_id from sm_ZSuser where user_name='" + user_name + "' and user_status='0'";

        try {

            crs = dataAccessObject.query(sql);
            if (crs.next()) {
                strUser_id = crs.getString("user_id");
            }

        } catch (Exception e) {
            log.error("error", e);
            e.printStackTrace();
        }
        return strUser_id;

    }

    public boolean DeleteZSUser(String userId) {

        boolean reuslt = false;
        DataAccess dataAccessObject = new DataAccess();
        String sql = "update sm_ZSuser set user_status='1' where user_id='" + userId + "'";
        try {
            if (dataAccessObject.execute(sql) == 1) {
                reuslt = true;
            } else {
                reuslt = false;
            }
        } catch (Exception e) {
            log.error("error", e);
            e.printStackTrace();
        }
        return reuslt;
    }

    public ZSuser FindZSUserById(String userId) {

        DataAccess dataAccessObject = new DataAccess();
        CachedRowSet crs = null;
        ZSuser userTO = null;

        String sql = "select * from sm_ZSuser where user_id='" + userId + "'";
        try {

            crs = dataAccessObject.query(sql);
            if (crs.next()) {

                userTO = setZSUserTO(crs);
            }
        } catch (Exception e) {
            log.error("error", e);
            e.printStackTrace();
        }

        return userTO;
    }

    public void ChanageZSPassword(String userId, String newPassword) {


        DataAccess dataAccessObject = new DataAccess();
        String sql = "update sm_ZSuser set user_password='" + newPassword + "' where user_id='" + userId + "'";
        try {
            dataAccessObject.execute(sql);
        } catch (Exception e) {
            log.error("error", e);
            e.printStackTrace();
        }

    }

    public static String getZSUserIdByEmail(String user_email) {

        DataAccess dataAccessObject = new DataAccess();
        CachedRowSet crs = null;
        String strUser_id = "";
        String sql = "select user_id from sm_ZSuser where user_email='" + user_email + "' and user_status='0'";

        try {

            crs = dataAccessObject.query(sql);
            if (crs.next()) {
                strUser_id = crs.getString("user_id");
            }

        } catch (Exception e) {
            log.error("error", e);
            e.printStackTrace();
        }
        return strUser_id;

    }

    private static User setUserTO(CachedRowSet crs) throws SQLException {

        User userTO = new User();

        userTO.setLastlogin(crs.getString("lastLogin"));
        userTO.setRegdate(crs.getString("regDate"));
        userTO.setUserStatus(crs.getString("user_Status").trim());
        userTO.setUserKind(crs.getString("user_kind").trim());
        userTO.setUserChinesename(crs.getString("User_chineseName"));
        userTO.setUserBranch(crs.getString("User_branch"));
        userTO.setUserName(crs.getString("user_name").trim());
        userTO.setUserIp(crs.getString("user_ip"));
        userTO.setUserId(crs.getInt("user_id"));
        userTO.setUsergroupId(crs.getString("usergroup_id").trim());
        userTO.setUserProvince(crs.getString("user_province"));

        userTO.setUserWork(crs.getString("user_work"));  //人员类型
        userTO.setBzjgdm(crs.getString("bzjgdm"));
        userTO.setDb(crs.getString("db"));
        userTO.setZrxzqu(crs.getString("zrxzqu"));
        return userTO;
    }

    private static ZSuser setZSUserTO(CachedRowSet crs) throws SQLException {

        ZSuser userTO = new ZSuser();
        userTO.setLastlogin(crs.getString("lastLogin"));
        userTO.setRegdate(crs.getString("regDate"));
        userTO.setUserStatus(crs.getString("user_Status").trim());
        userTO.setUserKind(crs.getString("user_kind").trim());
        userTO.setUserChinesename(crs.getString("User_chineseName"));
        userTO.setUserBranch(crs.getString("User_branch"));
        userTO.setUserName(crs.getString("user_name").trim());
        userTO.setUserIp(crs.getString("user_ip"));
        userTO.setUserId(crs.getInt("user_id"));
        //userTO.setUsergroupId(crs.getString("usergroup_id").trim());
        //userTO.setUserProvince(crs.getString("user_province"));

        userTO.setUserWork(crs.getString("user_work"));  //人员类型
        userTO.setBzjgdm(crs.getString("bzjgdm"));
        //userTO.setDb(crs.getString("db"));
        //userTO.setZrxzqu(crs.getString("zrxzqu"));
        return userTO;
    }


    public static String findUserByChineseName(String userLoginValue) {
        DataAccess dataAccessObject = new DataAccess();
        CachedRowSet crs = null;
        String userName = null;
        String sql = "select user_name from SM_UserManage where USER_CHINESENAME = '" + userLoginValue + "'";
        try {
            crs = dataAccessObject.query(sql);
            if (crs.next()) {
                userName = crs.getString("user_name");
            }
        } catch (Exception e) {
            log.error("error", e);
            e.printStackTrace();
        }
        return userName;
    }
}
