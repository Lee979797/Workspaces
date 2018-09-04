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
 * Time: 下午1:33
 */
public class TSystemBus {
    private TSystemDAO systemDao = new TSystemDAO();
    private TOperateTypeDAO typeDAO = new TOperateTypeDAO();

    /**
     * 是否存在机构名称
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
     * 根据注册号查询列表
     *
     * @param zch
     * @return
     */
    public List<TSystem> isExistZch(String zch) {
        return systemDao.findByProperty("zch", zch);
    }


    /**
     * 业务bz 是否需要审核
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
     * 每天是否只能做一种业务
     *
     * @return
     */
    public Boolean isOneKind() {
        return InitSysParams.system.getOneKind();
    }

    /**
     * 业务每天最多可以做多少次
     *
     * @return
     */
    public Integer busTimes() {
        return InitSysParams.system.getBusTimes();
    }

    /**
     * 是否是主要业务
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
            return "false:处罚金额高于省中心规定的最高上限：" + system.getCfjesx() + "元";
        if (system.getGtcfsz() != null && je < system.getGtcfsz())
            return "false:处罚金额低于省中心规定的最低下限：" + system.getGtcfsz() + "元";
        return "true";
    }

    public TSystem getTSystem() {
        return systemDao.findAll().get(0);
    }

}
