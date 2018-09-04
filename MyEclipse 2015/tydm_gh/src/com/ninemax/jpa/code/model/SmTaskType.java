package com.ninemax.jpa.code.model;

import java.util.*;

/**
 * User: yzhhui
 * Date: 13-4-16
 * Time: 下午1:43
 */
public enum SmTaskType {
    新增(0), 其他赋码(1), 预赋码更新(2), 变更(3), 换证(4), 年检(5), 省间迁入(6), 省间迁出(7), 预赋码(8), 省内迁入(9), 省内迁出(10), 注销恢复(11), 注销(12), 挂失(13);
    private Integer value;
    private static Map<String, String> dtypes;
    private static Map<Integer, String> ptypes;

    SmTaskType(Integer name) {
        value = name;
    }

    public static String get(Integer value) {
        SmTaskType[] types = SmTaskType.values();
        for (SmTaskType type : types) {
            if (type.value.equals(value))
                return type.name();
        }
        return null;
    }

    public static Map<String, String> dTypes() {
        if (dtypes == null) {
            SmTaskType[] types = SmTaskType.values();
            dtypes = new HashMap<String, String>();
            for (SmTaskType type : types) {
                dtypes.put(getDfileType(type.getValue()), type.getValue().toString());
            }
        }

        return dtypes;
    }

    public static Map<Integer, String> problemTypes() {
        if (ptypes == null) {
            ptypes = new HashMap<Integer, String>();
            ptypes.put(1, "图像不清晰");
            ptypes.put(2, "图像黑边、倾斜");
            ptypes.put(3, "图像混扫");
            ptypes.put(4, "图像残缺");
            ptypes.put(5, "建档日期错误");
            ptypes.put(6, "档案分类错误");
            ptypes.put(7, "申请表标识问题");
            ptypes.put(8, "批准证书标识问题");
            ptypes.put(9, "身份证明文件标识问题");
            ptypes.put(10, "其他文件标示问题");
            ptypes.put(11, "其他问题");
            ptypes.put(12, "批准文件不合格");
            ptypes.put(13, "缺页问题");
            ptypes.put(14, "未定问题");
            ptypes.put(15, "机构不应赋码");
            ptypes.put(16, "批准文件公章问题");
            ptypes.put(17, "申领表公章问题");
            ptypes.put(18, "申领表信息问题");
            ptypes.put(19, "小微认定错误");
            ptypes.put(20, "批量问题");
            ptypes.put(21, "多个问题");
            ptypes.put(22, "年检执照问题");
        }
        return ptypes;
    }

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name();
    }

    public static String getDfileType(Integer value) {
        switch (value) {
            case 0:
            case 1:
            case 2:
                return "申请";
            case 3:
                return "变更";
            case 4:
                return "换证";
            case 5:
                return "年度验证";
            case 6:
                return "迁入";
            case 7:
                return "迁出";
            case 8:
                return "预赋码";
            case 9:
                return "迁入";
            case 10:
                return "迁出";
            case 11:
                return "换证";
            case 12:
                return "注销";
            case 13:
                return "补证";
            default:
                return "其他";


        }
    }
}
