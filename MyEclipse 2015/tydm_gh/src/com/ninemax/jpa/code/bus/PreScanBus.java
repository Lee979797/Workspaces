package com.ninemax.jpa.code.bus;

import com.ninemax.jpa.code.model.PreScan;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.global.InitSysParams;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by ninemax-199 on 14-2-8.
 */
public class PreScanBus {
    private static Logger log = Logger
            .getLogger(TJgdmSaveBus.class);

    public List<PreScan> getAll() {
        List<PreScan> scans = EntityManagerHelper.createQuery("select model from PreScan model ").getResultList();
        EntityManagerHelper.closeEntityManager();
        return scans;
    }

    public static Boolean isQzsm(String xzqh, Integer type, String jglx) {
        List<PreScan> scans = InitSysParams.scans;
        for (PreScan scan : scans) {
            if (scan.getXzqh().equals(xzqh.trim()) &&
                    scan.getType().equals(type)) {
                String lxs = scan.getJglxs();
                if (lxs != null && lxs.trim().length() > 0) {
                    String[] jglxs = lxs.split(",");
                    for (String lx : jglxs) {
                        if (lx.trim().equals(jglx.trim())) {
                            return true;
                        }
                    }
                }

            }
        }
        return false;
    }
}
