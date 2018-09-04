package com.ninemax.jpa.system.bo;

import com.ninemax.jdbc.dao.system.clsRoleRightKeyDAO;
import com.ninemax.jdbc.dao.system.clsUGRoleDetailDAO;
import com.ninemax.jpa.system.dao.RoleDAO;
import com.ninemax.jpa.system.model.Role;
import com.ninemax.jpa.util.clsPageComponent;

import java.text.ParseException;
import java.util.List;

public class RoleBo {
    private RoleDAO roleDAO = new RoleDAO();

    public List<Role> findAll() {
        return roleDAO.findAll();
    }

    public List<Role> findPageList(String searchField, String searchValue, String orderbyColum, String orderbyMethod, int pageSize, int pageNo, clsPageComponent pageComponent) throws ParseException {
        return roleDAO.findPageList(searchField, searchValue, orderbyColum, orderbyMethod, pageSize, pageNo, pageComponent);
    }

    public int save(Role role) {
        if (isExistRoleName(role.getRoleName(),role.getRoleId())) {//角色名称已经存在
            return -1;
        }
        if (roleDAO.save(role)) {
            return 1;
        } else {
            return -2;//操作失败
        }

    }

    public boolean update(Role role) {
        return roleDAO.update(role);
    }

    public boolean delete(Role role) {
        return roleDAO.delete(role);
    }

    public Role findById(int id) {
        return roleDAO.findById(id);
    }

    public List<Role> findByRoleName(String roleName
    ) {
        return roleDAO.findByRoleName(roleName);
    }

    /**
     * 角色名称是否存在
     *
     * @param name
     * @param id
     * @return
     */
    public boolean isExistRoleName(String name,
                                   Integer id) {

        List<Role> role = roleDAO.findByRoleName(name);
        if (role.size() > 0) {
            if (role.size() == 1 && role.get(0).getRoleId().equals(id)) {
                return false;
            }
            return true;
        } else {
            return false;
        }

    }

    /**
     * 判断角色是否被用户组使用
     *
     * @param roleId
     * @return
     */
    public boolean isUsedBuGroup(String roleId) {
        clsUGRoleDetailDAO uGRoleDetailDAO = new clsUGRoleDetailDAO();
        int groupNumber = uGRoleDetailDAO.getCountByRoleId(roleId);
        if (groupNumber > 0) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * 根据角色名称得到角色对象
     *
     * @param role_name
     * @return
     */
    public List<Role> GetRoleByName(String role_name) {
        return roleDAO.findByRoleName(role_name);
    }

    public List<Role> ListRoleByKind(String role_kind) {
        return roleDAO.findByRoleKind(role_kind);
    }


    /**
     * 修改角色
     *
     * @param role @see com.ninemax.jpa.system.model.Role
     * @return
     */
    public int ModifyRole(Role role) {

        List<Role> newRole = roleDAO.findByRoleName(role.getRoleName());//根据新填写的角色名称取得的对象

        if (newRole != null && newRole.size() > 0) {//用户名存在，如果新id和老id不一样说明角色名称已经在别的角色使用不能修改
            int newRoleId = newRole.get(0).getRoleId();
            if (role.getRoleId() != newRoleId) {
                return -1;
            }
        }

        if (roleDAO.update(role)) {
            return 1;
        } else {
            return -2;//数据库操作失败
        }

    }

    /**
     * 根据角色ID删除角色数据
     *
     * @param roleId
     * @return
     */
    public int DeleteRole(String roleId) {

        int intResult = 1;


        if (isUsedBuGroup(roleId)) {
            return -1;//角色已经赋予用户组
        }

        clsRoleRightKeyDAO roleRightKeyDAO = new clsRoleRightKeyDAO();
        roleRightKeyDAO.DeleteKeyByRoleId(roleId);//删除角色权限

        //Role role = new Role();
        //role = roleDAO.findById(Integer.valueOf(roleId));
        //boolean flag = roleDAO.delete(role);//删除角色
        roleDAO.deleteById(Role.class, Integer.valueOf(roleId));
        return intResult;
    }


    /**
     * 根据角色ID修改权限
     *
     * @param roleId   角色ID
     * @param keys     权限
     * @param isUpdate 是否修改
     * @return
     */
    public boolean UpdateRightKey(String roleId, String[] keys, boolean isUpdate) {

        boolean result = false;
        RoleRightkeyBo roleRightKeyBo = new RoleRightkeyBo();
        Role roleTO = roleDAO.findById(Integer.valueOf(roleId));
        if (roleTO == null) return false;//role——id为空
        result = roleRightKeyBo.UpdateRoleRightKey(roleId, keys, isUpdate);


        return result;
    }

    public static void main(String[] args) {
        RoleBo roledao = new RoleBo();
        try {
            roledao.DeleteRole("33");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
