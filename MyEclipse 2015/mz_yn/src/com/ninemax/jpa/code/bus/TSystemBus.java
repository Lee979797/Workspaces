package com.ninemax.jpa.code.bus;

import com.ninemax.jpa.code.dao.TOperateTypeDAO;
import com.ninemax.jpa.code.dao.TSystemDAO;
import com.ninemax.jpa.code.model.TSystem;
import com.ninemax.jpa.global.InitSysParams;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-5-18
 * Time: ����1:33
 */
public class TSystemBus {
    private TSystemDAO systemDao = new TSystemDAO();
    private TOperateTypeDAO typeDAO = new TOperateTypeDAO();

    /**
     * �Ƿ���ڻ�������
     *
     * @param codeName
     * @return
     */
    public boolean isExistCodeName(String codeName) {
        List<TSystem> list = systemDao.findByProperty("jgmc", codeName);
        if (list != null && list.size() > 0) {
            return true;
        } else
            return false;
    }

    /**
     * ����ע��Ų�ѯ�б�
     *
     * @param zch
     * @return
     */
    public List<TSystem> isExistZch(String zch) {
        return systemDao.findByProperty("zch", zch);
    }


    /**
     * ҵ��bz �Ƿ���Ҫ���
     *
     * @param bz
     * @return
     */
    public Boolean isNeedAudia(String bz) {
        boolean bIsneedsp = false;
/*       if (systemDao.findByProperty(bz, true).size() > 0) {
            bIsneedsp = true;
        }*/
        if("fzhfsh".equals(bz)){
        	return true;
        }
        return false;
    }

    public Boolean isYwlc() {
        return InitSysParams.system.getIsYwlc();
    }

    /**
     * ÿ���Ƿ�ֻ����һ��ҵ��
     *
     * @return
     */
    public Boolean isOneKind() {
        return InitSysParams.system.getOneKind();
    }

    /**
     * ҵ��ÿ�������������ٴ�
     *
     * @return
     */
    public Integer busTimes() {
        return InitSysParams.system.getBusTimes();
    }

    /**
     * �Ƿ�����Ҫҵ��
     *
     * @param czlxdm
     * @return
     */
    public boolean isMainBus(String czlxdm) {
        return typeDAO.findById(czlxdm).getMain();

    }

    public String checkCF(int je) {
        TSystem system =   InitSysParams.system;
        if (system.getCfjesx() != null && je > system.getCfjesx())
            return "false:����������ʡ���Ĺ涨��������ޣ�" + system.getCfjesx() + "Ԫ";
        if (system.getGtcfsz() != null && je < system.getGtcfsz())
            return "false:����������ʡ���Ĺ涨��������ޣ�" + system.getGtcfsz() + "Ԫ";
        return "true";
    }

    public TSystem getTSystem() {
        return systemDao.findAll().get(0);
    }

}
