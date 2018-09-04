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
	 * 添加系统公告
	 * @return
	 */
	public int addSysMessage(SystemMessageTO sysMessTO){
		
		SystemMessageDAO sysMessDao = new SystemMessageDAO();
		int sys_id = 0;
		sys_id = sysMessDao.addSysMess(sysMessTO);
		if(sys_id == 0){
			return 0;//添加失败
		}else{
			return sys_id;//添加成功
		}
		
	}

    public String modSysMessage(SystemMessageTO systemMessageTO){
		SystemMessageDAO sysMessDao = new SystemMessageDAO();
		return sysMessDao.modSysMessage(systemMessageTO);
	}
	
	/**
	 * 系统通知列表
	 * @param pageNo
	 * @param pageSize
	 * @param pageCom
	 * @return
	 */
	public ArrayList listSysMessage(String keyword, int pageNo,int pageSize, clsPageComponent pageCom){
		
		return new SystemMessageDAO().listSysMessage(keyword, pageNo, pageSize, pageCom);
	}
	
	/**
	 * 政务公告列表
	 * @param pageNo
	 * @param pageSize
	 * @param pageCom
	 * @return
	 */
	public ArrayList listAdministrativeNotice(String keyword, int pageNo, int pageSize, clsPageComponent pageCom){
		
		return new SystemMessageDAO().listAdministrativeNotice(keyword, pageNo, pageSize, pageCom);
	}
	/**
	 * 政务公告列表 - 最近一个月
	 * @param pageNo
	 * @param pageSize
	 * @param pageCom
	 * @return
	 */
	public ArrayList listAdministrativeNoticeOneMonth(String keyword, int pageNo, int pageSize, clsPageComponent pageCom){
		
		return new SystemMessageDAO().listAdministrativeNoticeOneMonth(keyword, pageNo, pageSize, pageCom);
	}
	
	/**
	 * 删除系统公告
	 * @param sys_id
	 * @return
	 */
	public boolean delSysMessage(String sys_id,String userId,String userName){

		SystemMessageDAO sysMessDao = new SystemMessageDAO();
        boolean flag = false;
        flag =  sysMessDao.delSysMessage(sys_id);
        if(flag){
            //操作成功，写日志
            SysManage_log sysManage_log = new SysManage_log();
            sysManage_log.setOperkindId("");
            sysManage_log.setMemo("删除公告");
            sysManage_log.setOpervalue("删除公告");
            sysManage_log.setUserid(String.valueOf(userId));
            sysManage_log.setUsername(userName);
            sysManage_log.setOperdate(DateUtil.getCurrentSystemDateTime());
            new SysManage_logDAO().save(sysManage_log);
        }
		return flag;
	}
	
	/**
	 * 设置公告置顶
	 * 如果之前有置顶公告，先取消置顶，再设置新公告置顶
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
	 * 根据sys_id查询系统公告数据
	 * @param sys_id
	 * @return
	 */
	public SystemMessageTO findBySysID(String sys_id){
		
		return new SystemMessageDAO().findBySysID(sys_id);
	}
	
	/**
	 * 站内信息发件箱
	 * @param pageNo
	 * @param pageSize
	 * @param pageCom
	 * @return
	 */
	public ArrayList listUserSendMessage(String keyword,String type , int pageNo, int pageSize, clsPageComponent pageCom, String from_person){
		
		return new SystemMessageDAO().listUserSendMessage(keyword,type, pageNo, pageSize, pageCom, from_person);
	}
	
	/**
	 * GOV站内信息发件箱
	 * @param pageNo
	 * @param pageSize
	 * @param pageCom
	 * @return
	 */
	public Map listUserSendMessageForGov(String keyword, int pageNo, int pageSize, String from_person){
		
		return new SystemMessageDAO().listUserSendMessageForGov(keyword, pageNo, pageSize, from_person);
	}
	
	/**
	 * 得到用户发出留言总条数
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
	 * 提取用户收到的信息
	 * @param pageCom
	 * @param object_type  对象类型
	 * @param send_object  发送对象
	 * @param c_userid   用户ID
	 * @return
	 */
	public ArrayList extractionUserMess(clsPageComponent pageCom, String object_type, String send_object, String c_userid){
		
		return new SystemMessageDAO().extractionUserMess(pageCom, object_type, send_object, c_userid);
	}
	
	/**
	 * 提取用户收到的系统公告、通知信息
	 * @param pageCom
	 * @param object_type  对象类型
	 * @param send_object  发送对象
	 * @param c_userid   用户ID
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
	 * 得到置顶公告数据
	 * @param 
	 * @return
	 */
	public SystemMessageTO getMessTop(){
		
		return new SystemMessageDAO().getMessTop();
	}
	
	/**
	 * 后台首页得到置顶公告对象
	 * @param user_id
	 * @return
	 */
	public SystemMessageTO getMessTopByUserID(String user_id){
		
		return new SystemMessageDAO().getMessTopByUserID(user_id);
	}

    //获得最新发布的公告
    public List<SystemMessageTO> getFirstTop() {
        return new SystemMessageDAO().getFirstTop();
    }
}
