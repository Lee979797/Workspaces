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
     * 更新该用户组下角色
     *
     * @param groupId 用户组ID
     * @param roles   角色
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
     * 根据用户组ID删除用户组数据
     *
     * @param groupId
     * @return
     */
    public int DeleteUserGroup(String groupId) {

        clsUGRoleDetailDAO uGRoleDetailDAO = new clsUGRoleDetailDAO();
        clsUserGroupDAO userGroupDAO = new clsUserGroupDAO();
        if (isUsedByUsers(groupId)) {//用户组下有用了，不能删除
            return -1;
        }
        userGroupDAO.DeleteUserGroup(groupId);
        uGRoleDetailDAO.DeleteByGroupId(groupId);//删除用户组的角色
        return 1;
    }


    /**
     * 修改用户组
     *
     * @param userGroup
     * @return
     */
    public int ModifyUserGroup(UserGroup userGroup) {

        List<UserGroup> newUserGroup = userGroupDAO.findByUsergroupName(userGroup.getUsergroupName());

        if (newUserGroup != null && newUserGroup.size() > 0) {//用户组名称存在，如果新id和老id不一样说明角色名称已经在别的组使用不能修改
            String newId = String.valueOf(newUserGroup.get(0).getUsergroupId());
            if (!String.valueOf(newUserGroup.get(0).getUsergroupId()).equals(newId)) {
                return -1;
            }
        }

        if (userGroupDAO.update(userGroup)) {

            return 1;
        } else {
            return -2;//操作失败
        }

    }

    /**
     * 添加用户组
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
            return -2;//操作失败
        }

    }

    /**
     * 用户组名是否存在
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
     * 分配角色时，判断角色是否已经被分配
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
     * 取用户组的权限，即用户组角色权限的集合
     */
    public ArrayList GetGourpRightKeys(String groupId) {
        RoleRightkeyBo roleRightKeyBo = new RoleRightkeyBo();
        UGRoleBo uGRoleBo = new UGRoleBo();
        ArrayList array = new ArrayList();
        ArrayList roles = uGRoleBo.getRoleIdsByGroupId(groupId);
        if (roles != null && roles.size() > 0) {
            for (Object role : roles) {
                String roleId = String.valueOf(((Role) role).getRoleId());
                //取权限

                ArrayList rightKeysByRoleId = roleRightKeyBo.getKeyIdsByRoleId(roleId);
                array.addAll(rightKeysByRoleId);
            }
        }

        return array;
    }

    /**
     * 查找有没有对应记录
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
