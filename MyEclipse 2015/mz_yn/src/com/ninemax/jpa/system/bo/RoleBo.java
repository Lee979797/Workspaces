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
        if (isExistRoleName(role.getRoleName(),role.getRoleId())) {//��ɫ�����Ѿ�����
            return -1;
        }
        if (roleDAO.save(role)) {
            return 1;
        } else {
            return -2;//����ʧ��
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
     * ��ɫ�����Ƿ����
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
     * �жϽ�ɫ�Ƿ��û���ʹ��
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
     * ���ݽ�ɫ���Ƶõ���ɫ����
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
     * �޸Ľ�ɫ
     *
     * @param role @see com.ninemax.jpa.system.model.Role
     * @return
     */
    public int ModifyRole(Role role) {

        List<Role> newRole = roleDAO.findByRoleName(role.getRoleName());//��������д�Ľ�ɫ����ȡ�õĶ���

        if (newRole != null && newRole.size() > 0) {//�û������ڣ������id����id��һ��˵����ɫ�����Ѿ��ڱ�Ľ�ɫʹ�ò����޸�
            int newRoleId = newRole.get(0).getRoleId();
            if (role.getRoleId() != newRoleId) {
                return -1;
            }
        }

        if (roleDAO.update(role)) {
            return 1;
        } else {
            return -2;//���ݿ����ʧ��
        }

    }

    /**
     * ���ݽ�ɫIDɾ����ɫ����
     *
     * @param roleId
     * @return
     */
    public int DeleteRole(String roleId) {

        int intResult = 1;


        if (isUsedBuGroup(roleId)) {
            return -1;//��ɫ�Ѿ������û���
        }

        clsRoleRightKeyDAO roleRightKeyDAO = new clsRoleRightKeyDAO();
        roleRightKeyDAO.DeleteKeyByRoleId(roleId);//ɾ����ɫȨ��

        //Role role = new Role();
        //role = roleDAO.findById(Integer.valueOf(roleId));
        //boolean flag = roleDAO.delete(role);//ɾ����ɫ
        roleDAO.deleteById(Role.class, Integer.valueOf(roleId));
        return intResult;
    }


    /**
     * ���ݽ�ɫID�޸�Ȩ��
     *
     * @param roleId   ��ɫID
     * @param keys     Ȩ��
     * @param isUpdate �Ƿ��޸�
     * @return
     */
    public boolean UpdateRightKey(String roleId, String[] keys, boolean isUpdate) {

        boolean result = false;
        RoleRightkeyBo roleRightKeyBo = new RoleRightkeyBo();
        Role roleTO = roleDAO.findById(Integer.valueOf(roleId));
        if (roleTO == null) return false;//role����idΪ��
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
