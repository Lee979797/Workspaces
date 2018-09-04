package com.ninemax.jpa.system.bo;

import com.ninemax.jdbc.business.system.clsUserBus;
import com.ninemax.jpa.system.dao.UserDAO;
import com.ninemax.jpa.system.model.User;
import com.ninemax.jpa.util.clsPageComponent;
import com.ninemax.jpa.util.clsStringTool;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class UserBo {
    private UserDAO userDAO = new UserDAO();

    public List<User> findAll() {
        return userDAO.findAll();
    }

    public List<User> findPageList(String searchField, String searchValue, String orderbyColum, String orderbyMethod, int pageSize, int pageNo, clsPageComponent pageComponent) throws ParseException {
        return userDAO.findPageList(searchField, searchValue, orderbyColum, orderbyMethod, pageSize, pageNo, pageComponent);
    }

    public boolean save(User User) {
        return userDAO.save(User);
    }

    public boolean update(User User) {
        return userDAO.update(User);
    }

    public boolean delete(User User) {
        return userDAO.delete(User);
    }

    public User findById(int id) {
        return userDAO.findById(id);
    }

    /**
     * �����û����õ�ע���û�����
     *
     * @param user_name
     * @return
     */
    public User FindByName(String user_name) {
        List<User> user = userDAO.FindByName(user_name);
        if (user != null && user.size() > 0) {
            return user.get(0);
        } else
            return null;

    }

    /**
     * �����û����õ�ע���û�����
     *
     * @param user_name
     * @return
     */
    public User FindByChineseName(String user_name) {
        List<User> user = userDAO.FindByChineseName(user_name);
        if (user != null && user.size() > 0) {
            return user.get(0);
        } else
            return null;

    }

    /**
     * �����û�ID�õ�ע���û�����
     *
     * @param userId �û�ID
     * @return
     */
    public User GetRegUser(String userId) {

        return userDAO.findById(Integer.valueOf(userId));
    }


    /**
     * �޸��û�
     *
     * @param user
     * @return
     */
    public int ModifyRegUser(User user) {

//		String newUserId = userDAO.FindByName(user.getUserName()).get(0).getUserId();
        //String userId = regUserTO.getUser_id();

        /*if(!clsStringTool.isEmpty(newUserId)){
              if(!regUserTO.getUser_id().equals(newUserId)){
                  return -1;//�û��Ѿ�����
              }
          }*/
        if (userDAO.update(user)) {

            //ModifyUserGroup(regUserTO.getUser_id(),regUserTO.getUserGroup_id());//�����õ�Ȩ��
            return 1;
        } else {
            return -2;
        }
    }


    public boolean changeUser(Integer userId) {
        User user = userDAO.findById(userId);
        if (user.getNeedScan() == null)
            user.setNeedScan(true);
        user.setNeedScan(!user.getNeedScan());
        return userDAO.update(user);
    }

    /**
     * ����û�
     *
     * @param user
     * @return
     */
    public int AddRegUser(User user) throws SQLException {
        clsUserBus userBus = new clsUserBus();
        if (userBus.isExistUsername(user.getUserName())) {//�û����Ѿ�����
            return -1;
        }

        boolean userId = userDAO.save(user);
        if (userId) {//���ʧ��

            //���û���Ȩ��
            userBus.AddRightToUser(String.valueOf(user.getUserId()), user.getUsergroupId());
            return 1;
        } else {
            return -2;
        }

    }

    /**
     * �û���¼
     *
     * @param username �û���
     * @param password ����
     * @return
     */
    public int Login(String username, String password) throws SQLException {
        //Commented automatically
        if (clsStringTool.isEmpty(username)) return -3;//�û���Ϊ��
        if (clsStringTool.isEmpty(password)) return -4;//����Ϊ��

        if (!com.ninemax.jdbc.business.system.clsUserBus.isExistUsername(username)) {
            //�û���������
            return -2;
        }

        if (!userDAO.CheckPassword(username, password)) {
            return -1;
        }
 /*       if (!userDAO.checkXzqh(username, password)) {
            return -5;//��������δ׼��
        }*/
        return 1;
        //return 0;
    }

    /**
     * IC����֤
     *
     * @param jgdm
     * @return
     */
    public User checkIC(String jgdm) {
        return userDAO.checkIC(jgdm);
    }

    /**
     * CA��֤
     *
     * @param name
     * @return
     */
    public User checkCA(String name, String chooseName) {
        return userDAO.checkCA(name, chooseName);
    }

    public List<User> userCAList(String cn) {
        return userDAO.userCAList(cn);
    }
}
