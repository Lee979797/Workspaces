package com.ninemax.jdbc.business.system;

import com.ninemax.jdbc.dao.system.clsUGRoleDetailDAO;
import com.ninemax.jdbc.dao.system.clsUserDAO;
import com.ninemax.jdbc.dao.system.clsUserRightKeyDAO;
import com.ninemax.jpa.global.InitSysParams;
import com.ninemax.jpa.system.model.*;
import com.ninemax.jpa.util.clsStringTool;
import com.ninemax.jpa.util.clsThreeDes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class clsUserBus {


    private clsUserDAO userDAO = null;
    private clsUserRightKeyDAO userRightKeyDAO = null;
    private clsRightKeyBus rightKeyBus = null;
    private clsUserRightKeyBus userRightKeyBus = null;

    public clsUserBus() {


        userDAO = new clsUserDAO();
        userRightKeyDAO = new clsUserRightKeyDAO();
        rightKeyBus = new clsRightKeyBus();
        userRightKeyBus = new clsUserRightKeyBus();
    }

    /**
     * 根据用户ID得到用户对象
     *
     * @param userId 用户ID
     * @return
     */
    public User FindUserById(String userId) {
        return userDAO.FindUserById(userId);
    }

    /**
     * 根据部门id获得部门下所有用户
     *
     * @param groupId
     * @return
     */
    public List getAllUsersByGroupId(String groupId) {
        return userDAO.getAllUsersByGroupId(groupId);
    }

    /**
     * 根据用户ID得到用户名
     *
     * @param userId 用户ID
     * @return
     */
    public String FindUserNameById(String userId) {
        return userDAO.FindUserNameById(userId);
    }

    /**
     * 根据用户名得到用户对象
     *
     * @param userName
     * @return
     */
    public User FindUserByName(String userName) {
        return userDAO.FindUserByName(userName);
    }


    /**
     * ql更新登录时间
     *
     * @param userId 用户ID
     * @return false/true
     */
    public boolean UpdateLastLogin(String userId) {
        return userDAO.UpdateLastLogin(userId);
    }

    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    public static int Login(String username, String password) throws SQLException {
        //Commented automatically
        if (clsStringTool.isEmpty(username)) return -3;//用户名为空
        if (clsStringTool.isEmpty(password)) return -4;//密码为空

        if (!isExistUsername(username)) {//用户名不存在
            return -2;
        }

        if (clsUserDAO.CheckPassword(username, password)) {
            return 1;
        } else {
            return -1;//密码错误
        }

        //return 0;
    }

    /**
     * 为电子政务提供登录接口
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    public User LoginForGov(String username, String password) {
        User userTO = null;
        clsUserDAO userDAO = new clsUserDAO();
        String strPassword = clsThreeDes.encryptMode3DES(password);
        String userKind = userDAO.FindUserByName(username).getUserKind();

        if ("1".equals(userKind)) {

            userTO = userDAO.CheckPasswordForGov(username, strPassword);

            if (userTO != null) {
                return userTO;
            } else {
                return userTO;//登录失败
            }
        } else {
            return userTO;//登录失败
        }

    }

    /**
     * 更新用户权限
     *
     * @param userId   用户ID
     * @param keys     权限
     * @param isDelete 是否更新
     * @return
     */
    public boolean UpdateUserRightKey(String userId, String[] keys, boolean isDelete) {

        boolean result = false;
        if (clsStringTool.isEmpty(userId)) return false;


        if (isDelete) {
            userRightKeyDAO.DeleteKeyByUserId(userId);//首先清除所有权限
        }

        if (keys != null) {//重新给角色赋权限
            if (keys.length > 0) {
                //userRightKeyDAO.AddKeyToUser(userId,parentRightKey);

                for (int index = 0; index < keys.length; index++) {
                    //clsLog.logDebug("keys["+index+"]="+keys[index]);
                    userRightKeyDAO.AddKeyToUser(userId, keys[index]);
                }
            }
        }
        return false;
    }

    /**
     * 修改用户组
     *
     * @param userId     用户ID
     * @param newGroupId 用户组ID
     */
    public void ModifyUserGroup(String userId, String newGroupId) {


        String oldGroupId = GetGroupIdByUserId(userId);
        if (!newGroupId.equals(oldGroupId)) {

            userRightKeyDAO.DeleteKeyByUserId(userId);//首先删除权限

            AddRightToUser(userId, newGroupId);

        }

    }

    /**
     * 给用户赋权限
     *
     * @param userId  用户ID
     * @param groupId 用户组ID
     */
    public static void AddRightToUser(String userId, String groupId) {

        clsUGRoleDetailDAO uGRoleDetailDAO = new clsUGRoleDetailDAO();
        ArrayList roles = uGRoleDetailDAO.getRoleIdsByGroupId(groupId);
        if (roles != null) {

            if (roles.size() > 0) {
                for (int index = 0; index < roles.size(); index++) {

                    Role roleTO = (Role) roles.get(index);
                    String roleId = String.valueOf(roleTO.getRoleId());
                    clsUserRightKeyBus userRightKeyBus = new clsUserRightKeyBus();
                    userRightKeyBus.AddRoleRightToUser(userId, roleId);

                }
            }
        }
    }

    /**
     * 删除用户
     *
     * @param userId 用户ID
     */
    public void DeleteUser(String userId) {

        userDAO.DeleteUser(userId);
        //删除相关权限
        userRightKeyDAO.DeleteKeyByUserId(userId);
        //return userDAO.DeleteUser(userId);
    }


    /**
     * 更改用户状态
     *
     * @param userId      用户ID
     * @param user_status 0:启用 1:删除 2:停用
     */
    public void userStatus(String userId, String user_status) {

        userDAO.userStatus(userId, user_status);
        //删除相关权限
//		userRightKeyDAO.DeleteKeyByUserId(userId);
        //return userDAO.DeleteUser(userId);
    }

    /**
     * 用户名称是否存在
     *
     * @param username
     * @return
     */
    public static boolean isExistUsername(String username, String user_id) throws SQLException {

        String userId = clsUserDAO.getUserIdByName(username);

        return !clsStringTool.isEmpty(userId) && !userId.equals(user_id);

    }

    public static boolean isExistUsername(String username) throws SQLException {

        String userId = clsUserDAO.getUserIdByName(username);

        return !clsStringTool.isEmpty(userId);

    }

    /**
     * 邮件地址是否存在
     *
     * @param user_email
     * @return
     */
    public static boolean isExistUserEmail(String user_email, String user_id) {

        String userId = clsUserDAO.getUserIdByEmail(user_email);

        return !(clsStringTool.isEmpty(userId) || userId.equals(user_id));

    }

    public static boolean isExistUserEmail(String user_email) {

        String userId = clsUserDAO.getUserIdByEmail(user_email);

        return !clsStringTool.isEmpty(userId);

    }

    /**
     * 统计用户组下用户数量
     *
     * @param group_id 用户组
     * @return
     */
    public static int GetCountByGroupId(String group_id) {
        return clsUserDAO.GetCountByGroupId(group_id);
    }

    /**
     * 该用户组中所有用户
     *
     * @param group_id 用户组
     * @return
     */
    public static ArrayList GetUserIdByGroupId(String group_id) {
        return clsUserDAO.getUserIdByGroupId(group_id);
    }

    /**
     * 根据用户名得到用户ID
     *
     * @param user_name
     * @return
     */
    public static String GetUserIdByName(String user_name) throws SQLException {
        return clsUserDAO.getUserIdByName(user_name);
    }

    /**
     * 根据用户ID得到用户组
     *
     * @param userId 用户ID
     * @return
     */
    public String GetGroupIdByUserId(String userId) {
        return userDAO.getGroupIdByUserId(userId);
    }

    /**
     * 修改用户密码
     *
     * @param userId      用户ID
     * @param newPassword 新密码
     */
    public void ChanagePassword(String userId, String newPassword) {
        userDAO.ChanagePassword(userId, newPassword);
    }


    /**
     * 分配角色时，判断角色是否已经被分配
     */
    public boolean constainsUserId(String userId, ArrayList selectedUsers) {
        boolean result = false;
        if (selectedUsers != null && selectedUsers.size() > 0) {
            for (int index = 0; index < selectedUsers.size(); index++) {
                String tmpUserId = (String) selectedUsers.get(index);

                if (userId.equals(tmpUserId)) {
                    return true;
                }
            }
        }
        return result;

    }

    /**
     * 周鹏鹏
     * 查找出 相关子站点的所有用户，删除站点的时候一并所属的用户
     *
     * @param web_id
     * @return
     */
    public ArrayList findUserByWeb_id(String web_id) {
        return userDAO.findUserByWeb_id(web_id);
    }


    /**
     * 得到用户所属省份
     *
     * @param userID
     * @return
     */
    public static String getUserProvinceByUserID(String userID) {
        return clsUserDAO.getUserProvinceByUserID(userID);
    }


//    /**
//     * 得到行政体系对象for GOV
//     * @param user_id
//     * @return
//     */
//    public clsBaseGroupSortTO getBaseGroupSort(String user_id){
//    	return userDAO.getBaseGroupSort(user_id);
//    }


    /**
     * 根据省份ID得到市列表
     *
     * @param provinceId 省份ID
     * @return
     */
    public List<Bzjgdm> getChildProvince(String provinceId) {
        if (clsStringTool.isEmpty(provinceId) || provinceId.length() < 6) {
            return Collections.emptyList();
        }

        List<Bzjgdm> allProvince = InitSysParams.BzjgdmList;
        List<Bzjgdm> childProvince = new ArrayList<Bzjgdm>();
        for (int i = 0; i < allProvince.size(); i++) {
            Bzjgdm bzjgdm = new Bzjgdm();
            bzjgdm = (Bzjgdm) allProvince.get(i);
            String id = bzjgdm.getDm();
           // String depth = bzjgdm.getSuperdm();
            if (id.substring(0, 2).indexOf(provinceId.substring(0, 2)) > -1 && !id.equals(provinceId)) {
                childProvince.add(bzjgdm);
            }
        }
        return childProvince;
    }

    public List<Bzjgdm> getBzjgdmByXzqhID(String xzqh_id) {
        clsBzjgdmBus bzjgdmBus = new clsBzjgdmBus();
        List<Bzjgdm> bazjdms = bzjgdmBus.FindBzjgdmByXzqhID(xzqh_id);
        return bazjdms;
    }


    public int getHasRightKeyNum(String userID, String rightkeyID) {
        int userNum = 0;
        List<Rightkey>  rightKeys = rightKeyBus.ListFirstRight(rightkeyID);
        if (rightKeys != null && rightKeys.size() > 0) {
            int topNum = 1;
            for (Rightkey rightKey : rightKeys) {

                String rightKeyId = rightKey.getRightkeyId();
                if (userRightKeyBus.HasRight(userID, rightKeyId)) {
                    userNum++;
                }
            }
        }
        return userNum;
    }

    /**
     * 自述用户名称是否存在
     *
     * @param username
     * @return
     */
    public static boolean isExistZSuserName(String username) {

        String userId = clsUserDAO.getZSUserIdByName(username);

        if (clsStringTool.isEmpty(userId)) {
            return false;
        } else {
            return true;
        }

    }

    /**
     * 删除用户
     *
     * @param userId 用户ID
     */
    public void DeleteZSUser(String userId) {

        userDAO.DeleteZSUser(userId);
        //删除相关权限
        //userRightKeyDAO.DeleteKeyByUserId(userId);
        //return userDAO.DeleteUser(userId);
    }

    /**
     * 根据用户ID得到用户对象
     *
     * @param userId 用户ID
     * @return
     */
    public ZSuser FindZSuserById(String userId) {
        return userDAO.FindZSUserById(userId);
    }

    /**
     * 修改自述用户密码
     *
     * @param userId      用户ID
     * @param newPassword 新密码
     */
    public void ChanageZSPassword(String userId, String newPassword) {
        userDAO.ChanageZSPassword(userId, newPassword);
    }

    /**
     * 自述用户邮件地址是否存在
     *
     * @param user_email
     * @return
     */
    public static boolean isExistZSUserEmail(String user_email) {

        String userId = clsUserDAO.getZSUserIdByEmail(user_email);

        if (clsStringTool.isEmpty(userId)) {
            return false;
        } else {
            return true;
        }

    }


    public String findUserByChineseName(String userLoginValue) {
        return clsUserDAO.findUserByChineseName(userLoginValue);
    }
}
