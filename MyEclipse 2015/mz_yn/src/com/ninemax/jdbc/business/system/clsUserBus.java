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
     * �����û�ID�õ��û�����
     *
     * @param userId �û�ID
     * @return
     */
    public User FindUserById(String userId) {
        return userDAO.FindUserById(userId);
    }

    /**
     * ���ݲ���id��ò����������û�
     *
     * @param groupId
     * @return
     */
    public List getAllUsersByGroupId(String groupId) {
        return userDAO.getAllUsersByGroupId(groupId);
    }

    /**
     * �����û�ID�õ��û���
     *
     * @param userId �û�ID
     * @return
     */
    public String FindUserNameById(String userId) {
        return userDAO.FindUserNameById(userId);
    }

    /**
     * �����û����õ��û�����
     *
     * @param userName
     * @return
     */
    public User FindUserByName(String userName) {
        return userDAO.FindUserByName(userName);
    }


    /**
     * ql���µ�¼ʱ��
     *
     * @param userId �û�ID
     * @return false/true
     */
    public boolean UpdateLastLogin(String userId) {
        return userDAO.UpdateLastLogin(userId);
    }

    /**
     * �û���¼
     *
     * @param username �û���
     * @param password ����
     * @return
     */
    public static int Login(String username, String password) throws SQLException {
        //Commented automatically
        if (clsStringTool.isEmpty(username)) return -3;//�û���Ϊ��
        if (clsStringTool.isEmpty(password)) return -4;//����Ϊ��

        if (!isExistUsername(username)) {//�û���������
            return -2;
        }

        if (clsUserDAO.CheckPassword(username, password)) {
            return 1;
        } else {
            return -1;//�������
        }

        //return 0;
    }

    /**
     * Ϊ���������ṩ��¼�ӿ�
     *
     * @param username �û���
     * @param password ����
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
                return userTO;//��¼ʧ��
            }
        } else {
            return userTO;//��¼ʧ��
        }

    }

    /**
     * �����û�Ȩ��
     *
     * @param userId   �û�ID
     * @param keys     Ȩ��
     * @param isDelete �Ƿ����
     * @return
     */
    public boolean UpdateUserRightKey(String userId, String[] keys, boolean isDelete) {

        boolean result = false;
        if (clsStringTool.isEmpty(userId)) return false;


        if (isDelete) {
            userRightKeyDAO.DeleteKeyByUserId(userId);//�����������Ȩ��
        }

        if (keys != null) {//���¸���ɫ��Ȩ��
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
     * �޸��û���
     *
     * @param userId     �û�ID
     * @param newGroupId �û���ID
     */
    public void ModifyUserGroup(String userId, String newGroupId) {


        String oldGroupId = GetGroupIdByUserId(userId);
        if (!newGroupId.equals(oldGroupId)) {

            userRightKeyDAO.DeleteKeyByUserId(userId);//����ɾ��Ȩ��

            AddRightToUser(userId, newGroupId);

        }

    }

    /**
     * ���û���Ȩ��
     *
     * @param userId  �û�ID
     * @param groupId �û���ID
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
     * ɾ���û�
     *
     * @param userId �û�ID
     */
    public void DeleteUser(String userId) {

        userDAO.DeleteUser(userId);
        //ɾ�����Ȩ��
        userRightKeyDAO.DeleteKeyByUserId(userId);
        //return userDAO.DeleteUser(userId);
    }


    /**
     * �����û�״̬
     *
     * @param userId      �û�ID
     * @param user_status 0:���� 1:ɾ�� 2:ͣ��
     */
    public void userStatus(String userId, String user_status) {

        userDAO.userStatus(userId, user_status);
        //ɾ�����Ȩ��
//		userRightKeyDAO.DeleteKeyByUserId(userId);
        //return userDAO.DeleteUser(userId);
    }

    /**
     * �û������Ƿ����
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
     * �ʼ���ַ�Ƿ����
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
     * ͳ���û������û�����
     *
     * @param group_id �û���
     * @return
     */
    public static int GetCountByGroupId(String group_id) {
        return clsUserDAO.GetCountByGroupId(group_id);
    }

    /**
     * ���û����������û�
     *
     * @param group_id �û���
     * @return
     */
    public static ArrayList GetUserIdByGroupId(String group_id) {
        return clsUserDAO.getUserIdByGroupId(group_id);
    }

    /**
     * �����û����õ��û�ID
     *
     * @param user_name
     * @return
     */
    public static String GetUserIdByName(String user_name) throws SQLException {
        return clsUserDAO.getUserIdByName(user_name);
    }

    /**
     * �����û�ID�õ��û���
     *
     * @param userId �û�ID
     * @return
     */
    public String GetGroupIdByUserId(String userId) {
        return userDAO.getGroupIdByUserId(userId);
    }

    /**
     * �޸��û�����
     *
     * @param userId      �û�ID
     * @param newPassword ������
     */
    public void ChanagePassword(String userId, String newPassword) {
        userDAO.ChanagePassword(userId, newPassword);
    }


    /**
     * �����ɫʱ���жϽ�ɫ�Ƿ��Ѿ�������
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
     * ������
     * ���ҳ� �����վ��������û���ɾ��վ���ʱ��һ���������û�
     *
     * @param web_id
     * @return
     */
    public ArrayList findUserByWeb_id(String web_id) {
        return userDAO.findUserByWeb_id(web_id);
    }


    /**
     * �õ��û�����ʡ��
     *
     * @param userID
     * @return
     */
    public static String getUserProvinceByUserID(String userID) {
        return clsUserDAO.getUserProvinceByUserID(userID);
    }


//    /**
//     * �õ�������ϵ����for GOV
//     * @param user_id
//     * @return
//     */
//    public clsBaseGroupSortTO getBaseGroupSort(String user_id){
//    	return userDAO.getBaseGroupSort(user_id);
//    }


    /**
     * ����ʡ��ID�õ����б�
     *
     * @param provinceId ʡ��ID
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
     * �����û������Ƿ����
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
     * ɾ���û�
     *
     * @param userId �û�ID
     */
    public void DeleteZSUser(String userId) {

        userDAO.DeleteZSUser(userId);
        //ɾ�����Ȩ��
        //userRightKeyDAO.DeleteKeyByUserId(userId);
        //return userDAO.DeleteUser(userId);
    }

    /**
     * �����û�ID�õ��û�����
     *
     * @param userId �û�ID
     * @return
     */
    public ZSuser FindZSuserById(String userId) {
        return userDAO.FindZSUserById(userId);
    }

    /**
     * �޸������û�����
     *
     * @param userId      �û�ID
     * @param newPassword ������
     */
    public void ChanageZSPassword(String userId, String newPassword) {
        userDAO.ChanageZSPassword(userId, newPassword);
    }

    /**
     * �����û��ʼ���ַ�Ƿ����
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
