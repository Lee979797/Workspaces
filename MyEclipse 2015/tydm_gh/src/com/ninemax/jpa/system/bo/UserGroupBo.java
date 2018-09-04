package com.ninemax.jpa.system.bo;

import com.ninemax.jdbc.dao.system.clsUGRoleDetailDAO;
import com.ninemax.jdbc.dao.system.clsUserDAO;
import com.ninemax.jdbc.dao.system.clsUserGroupDAO;
import com.ninemax.jpa.system.dao.UserGroupDAO;
import com.ninemax.jpa.system.model.Role;
import com.ninemax.jpa.system.model.UserGroup;
import com.ninemax.jpa.util.clsPageComponent;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class UserGroupBo {
    private UserGroupDAO userGroupDAO = new UserGroupDAO();

    public List<UserGroup> findAll() {
        return userGroupDAO.findAll();
    }

    public List<UserGroup> findPageList(String searchField, String searchValue, String kind, String orderbyColum, String orderbyMethod, int pageSize, int pageNo, clsPageComponent pageComponent) throws ParseException {
        return userGroupDAO.findPageList(searchField, searchValue, kind, orderbyColum, orderbyMethod, pageSize, pageNo, pageComponent);
    }

    public boolean save(UserGroup userGroup) {
        return userGroupDAO.save(userGroup);
    }

    public boolean update(UserGroup userGroup) {
        return userGroupDAO.update(userGroup);
    }

    public boolean delete(UserGroup userGroup) {
        return userGroupDAO.delete(userGroup);
    }

    public UserGroup findById(int id) {
        return userGroupDAO.findById(id);
    }

    /**
     * ���¸��û����½�ɫ
     *
     * @param groupId �û���ID
     * @param roles   ��ɫ
     * @return
     */
    public boolean UpdateRoles(String groupId, String[] roles) {
        clsUGRoleDetailDAO uGRoleDetailDAO = new clsUGRoleDetailDAO();

        uGRoleDetailDAO.DeleteByGroupId(groupId);

        if (roles != null) {

            if (roles.length > 0) {
                for (int index = 0; index < roles.length; index++) {
                    uGRoleDetailDAO.addRoleToGroup(roles[index], groupId);

                }
            }
        }
        return true;
    }


    /**
     * �����û���IDɾ���û�������
     *
     * @param groupId
     * @return
     */
    public int DeleteUserGroup(String groupId) {

        clsUGRoleDetailDAO uGRoleDetailDAO = new clsUGRoleDetailDAO();
        clsUserGroupDAO userGroupDAO = new clsUserGroupDAO();
        if (isUsedByUsers(groupId)) {//�û����������ˣ�����ɾ��
            return -1;
        }
        userGroupDAO.DeleteUserGroup(groupId);
        uGRoleDetailDAO.DeleteByGroupId(groupId);//ɾ���û���Ľ�ɫ
        return 1;
    }


    /**
     * �޸��û���
     *
     * @param userGroup
     * @return
     */
    public int ModifyUserGroup(UserGroup userGroup) {

        List<UserGroup> newUserGroup = userGroupDAO.findByUsergroupName(userGroup.getUsergroupName());

        if (newUserGroup != null && newUserGroup.size() > 0) {//�û������ƴ��ڣ������id����id��һ��˵����ɫ�����Ѿ��ڱ����ʹ�ò����޸�
            String newId = String.valueOf(newUserGroup.get(0).getUsergroupId());
            if (!String.valueOf(newUserGroup.get(0).getUsergroupId()).equals(newId)) {
                return -1;
            }
        }

        if (userGroupDAO.update(userGroup)) {

            return 1;
        } else {
            return -2;//����ʧ��
        }

    }

    /**
     * ����û���
     *
     * @param userGroup
     * @return
     */
    public int AddUserGroup(UserGroup userGroup) {

        if (isExistName(userGroup.getUsergroupName(), userGroup.getUsergroupId())) {
            return -1;
        }

        if (userGroupDAO.save(userGroup)) {

            return 1;
        } else {
            return -2;//����ʧ��
        }

    }

    /**
     * �û������Ƿ����
     *
     * @param name
     * @param id
     * @return
     */
    public boolean isExistName(String name, Integer id) {
        List<UserGroup> userGroup = userGroupDAO.findByUsergroupName(name);
        return userGroup.size() >= 1 && !(userGroup.size() == 1 && userGroup.get(0).getUsergroupId().equals(id));

    }


    public boolean isUsedByUsers(String groupId) {

        int userNumber = clsUserDAO.GetCountByGroupId(groupId);

        return userNumber > 0;
    }

    /**
     * �����ɫʱ���жϽ�ɫ�Ƿ��Ѿ�������
     */
    public boolean constainsRole_id(String role_id, ArrayList selectedRoles) {
        boolean result = false;
        if (selectedRoles != null && selectedRoles.size() > 0) {
            for (Object selectedRole : selectedRoles) {
                Role role = (Role) selectedRole;
                String tmpRole_id = String.valueOf(role.getRoleId());
                if (role_id.equals(tmpRole_id)) {
                    return true;
                }
            }
        }
        return result;

    }

    public List<UserGroup> GetGroupByKind(String kind) {
        return userGroupDAO.ListGroupByKind(kind);
    }

    /**
     * ȡ�û����Ȩ�ޣ����û����ɫȨ�޵ļ���
     */
    public ArrayList GetGourpRightKeys(String groupId) {
        RoleRightkeyBo roleRightKeyBo = new RoleRightkeyBo();
        UGRoleBo uGRoleBo = new UGRoleBo();
        ArrayList array = new ArrayList();
        ArrayList roles = uGRoleBo.getRoleIdsByGroupId(groupId);
        if (roles != null && roles.size() > 0) {
            for (Object role : roles) {
                String roleId = String.valueOf(((Role) role).getRoleId());
                //ȡȨ��

                ArrayList rightKeysByRoleId = roleRightKeyBo.getKeyIdsByRoleId(roleId);
                array.addAll(rightKeysByRoleId);
            }
        }

        return array;
    }

    /**
     * ������û�ж�Ӧ��¼
     *
     * @param usergroup_id
     * @return
     */
    public boolean isExitUserGroupId(String usergroup_id) {
        return userGroupDAO.isExitUserGroupId(usergroup_id.trim());

    }

    public boolean constainsKeyId(String keyid, ArrayList keyids) {
        boolean result = false;
        if (keyids != null && keyids.size() > 0) {
            for (int index = 0; index < keyids.size(); index++) {
                String tmpKeyId = (String) keyids.get(index);

                if (keyid.equals(tmpKeyId)) {
                    return true;
                }
            }
        }
        return result;

    }

}
