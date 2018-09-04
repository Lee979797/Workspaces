package com.ninemax.nacao.business.message;

import com.ninemax.jdbc.dao.clsPageComponent;
import com.ninemax.jpa.system.dao.SysManage_logDAO;
import com.ninemax.jpa.system.model.SysManage_log;
import com.ninemax.jpa.util.DateUtil;
import com.ninemax.nacao.dao.message.SystemMessageDAO;
import com.ninemax.nacao.to.message.SystemMessageTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author yangxf
 *
 */
public class SystemMessageBus {
	
	/**
	 * ���ϵͳ����
	 * @return
	 */
	public int addSysMessage(SystemMessageTO sysMessTO){
		
		SystemMessageDAO sysMessDao = new SystemMessageDAO();
		int sys_id = 0;
		sys_id = sysMessDao.addSysMess(sysMessTO);
		if(sys_id == 0){
			return 0;//���ʧ��
		}else{
			return sys_id;//��ӳɹ�
		}
		
	}

    public String modSysMessage(SystemMessageTO systemMessageTO){
		SystemMessageDAO sysMessDao = new SystemMessageDAO();
		return sysMessDao.modSysMessage(systemMessageTO);
	}
	
	/**
	 * ϵͳ֪ͨ�б�
	 * @param pageNo
	 * @param pageSize
	 * @param pageCom
	 * @return
	 */
	public ArrayList listSysMessage(String keyword, int pageNo,int pageSize, clsPageComponent pageCom){
		
		return new SystemMessageDAO().listSysMessage(keyword, pageNo, pageSize, pageCom);
	}
	
	/**
	 * ���񹫸��б�
	 * @param pageNo
	 * @param pageSize
	 * @param pageCom
	 * @return
	 */
	public ArrayList listAdministrativeNotice(String keyword, int pageNo, int pageSize, clsPageComponent pageCom){
		
		return new SystemMessageDAO().listAdministrativeNotice(keyword, pageNo, pageSize, pageCom);
	}
	/**
	 * ���񹫸��б� - ���һ����
	 * @param pageNo
	 * @param pageSize
	 * @param pageCom
	 * @return
	 */
	public ArrayList listAdministrativeNoticeOneMonth(String keyword, int pageNo, int pageSize, clsPageComponent pageCom){
		
		return new SystemMessageDAO().listAdministrativeNoticeOneMonth(keyword, pageNo, pageSize, pageCom);
	}
	
	/**
	 * ɾ��ϵͳ����
	 * @param sys_id
	 * @return
	 */
	public boolean delSysMessage(String sys_id,String userId,String userName){

		SystemMessageDAO sysMessDao = new SystemMessageDAO();
        boolean flag = false;
        flag =  sysMessDao.delSysMessage(sys_id);
        if(flag){
            //�����ɹ���д��־
            SysManage_log sysManage_log = new SysManage_log();
            sysManage_log.setOperkindId("");
            sysManage_log.setMemo("ɾ������");
            sysManage_log.setOpervalue("ɾ������");
            sysManage_log.setUserid(String.valueOf(userId));
            sysManage_log.setUsername(userName);
            sysManage_log.setOperdate(DateUtil.getCurrentSystemDateTime());
            new SysManage_logDAO().save(sysManage_log);
        }
		return flag;
	}
	
	/**
	 * ���ù����ö�
	 * ���֮ǰ���ö����棬��ȡ���ö����������¹����ö�
	 * @param sys_id
	 * @return
	 */
	public boolean setTopMess(String sys_id){
		SystemMessageDAO sysMessDao = new SystemMessageDAO();
		
		SystemMessageTO sysMessTo = sysMessDao.getMessTop();
		String top_id = "";
		
		if(sysMessTo!=null){
			top_id = sysMessTo.getSys_id();
		}
		
		boolean settop = false;
		if(top_id.length() != 0 && top_id != null){
			
			settop = sysMessDao.messSetTop(top_id, "0");
			
			if(settop == true){
				settop = sysMessDao.messSetTop(sys_id, "1");
			}
		}else{
			settop = sysMessDao.messSetTop(sys_id, "1");
		}
		return settop;
	}
	
	/**
	 * ����sys_id��ѯϵͳ��������
	 * @param sys_id
	 * @return
	 */
	public SystemMessageTO findBySysID(String sys_id){
		
		return new SystemMessageDAO().findBySysID(sys_id);
	}
	
	/**
	 * վ����Ϣ������
	 * @param pageNo
	 * @param pageSize
	 * @param pageCom
	 * @return
	 */
	public ArrayList listUserSendMessage(String keyword,String type , int pageNo, int pageSize, clsPageComponent pageCom, String from_person){
		
		return new SystemMessageDAO().listUserSendMessage(keyword,type, pageNo, pageSize, pageCom, from_person);
	}
	
	/**
	 * GOVվ����Ϣ������
	 * @param pageNo
	 * @param pageSize
	 * @param pageCom
	 * @return
	 */
	public Map listUserSendMessageForGov(String keyword, int pageNo, int pageSize, String from_person){
		
		return new SystemMessageDAO().listUserSendMessageForGov(keyword, pageNo, pageSize, from_person);
	}
	
	/**
	 * �õ��û���������������
	 * @param c_userid
	 * @param type
	 * @return
	 */
	public int getUserSendMessageNum(String c_userid,String type){
		SystemMessageDAO sysUserMessDao = new SystemMessageDAO();
		int unreadNum = 0;
		unreadNum = sysUserMessDao.getUserSendMessageNum(c_userid, type);
		return unreadNum;
	}
	
	/**
	 * ��ȡ�û��յ�����Ϣ
	 * @param pageCom
	 * @param object_type  ��������
	 * @param send_object  ���Ͷ���
	 * @param c_userid   �û�ID
	 * @return
	 */
	public ArrayList extractionUserMess(clsPageComponent pageCom, String object_type, String send_object, String c_userid){
		
		return new SystemMessageDAO().extractionUserMess(pageCom, object_type, send_object, c_userid);
	}
	
	/**
	 * ��ȡ�û��յ���ϵͳ���桢֪ͨ��Ϣ
	 * @param pageCom
	 * @param object_type  ��������
	 * @param send_object  ���Ͷ���
	 * @param c_userid   �û�ID
	 * @return
	 */
	public ArrayList extractionUserMessNotice(clsPageComponent pageCom, String object_type, String send_object, String c_userid){
		
		return new SystemMessageDAO().extractionUserMessNotice(pageCom, object_type, send_object, c_userid);
	}
	 public static void main(String g[]) {

		 SystemMessageBus smb = new SystemMessageBus();
		 clsPageComponent pageCom = new clsPageComponent();
		 smb.extractionUserMess(pageCom, "2", "", "00000001");
			
		}
	
	/**
	 * �õ��ö���������
	 * @param 
	 * @return
	 */
	public SystemMessageTO getMessTop(){
		
		return new SystemMessageDAO().getMessTop();
	}
	
	/**
	 * ��̨��ҳ�õ��ö��������
	 * @param user_id
	 * @return
	 */
	public SystemMessageTO getMessTopByUserID(String user_id){
		
		return new SystemMessageDAO().getMessTopByUserID(user_id);
	}

    //������·����Ĺ���
    public List<SystemMessageTO> getFirstTop() {
        return new SystemMessageDAO().getFirstTop();
    }
}
