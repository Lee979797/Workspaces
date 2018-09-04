package com.ninemax.jpa.code.model;

import java.util.*;

/**
 * User: yzhhui
 * Date: 13-4-16
 * Time: ����1:43
 */
public enum SmTaskType {
    ����(0), ��������(1), Ԥ�������(2), ���(3), ��֤(4), ���(5), ʡ��Ǩ��(6), ʡ��Ǩ��(7), Ԥ����(8), ʡ��Ǩ��(9), ʡ��Ǩ��(10), ע���ָ�(11), ע��(12), ��ʧ(13);
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
            ptypes.put(1, "ͼ������");
            ptypes.put(2, "ͼ��ڱߡ���б");
            ptypes.put(3, "ͼ���ɨ");
            ptypes.put(4, "ͼ���ȱ");
            ptypes.put(5, "�������ڴ���");
            ptypes.put(6, "�����������");
            ptypes.put(7, "������ʶ����");
            ptypes.put(8, "��׼֤���ʶ����");
            ptypes.put(9, "���֤���ļ���ʶ����");
            ptypes.put(10, "�����ļ���ʾ����");
            ptypes.put(11, "��������");
            ptypes.put(12, "��׼�ļ����ϸ�");
            ptypes.put(13, "ȱҳ����");
            ptypes.put(14, "δ������");
            ptypes.put(15, "������Ӧ����");
            ptypes.put(16, "��׼�ļ���������");
            ptypes.put(17, "�����������");
            ptypes.put(18, "�������Ϣ����");
            ptypes.put(19, "С΢�϶�����");
            ptypes.put(20, "��������");
            ptypes.put(21, "�������");
            ptypes.put(22, "���ִ������");
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
                return "����";
            case 3:
                return "���";
            case 4:
                return "��֤";
            case 5:
                return "�����֤";
            case 6:
                return "Ǩ��";
            case 7:
                return "Ǩ��";
            case 8:
                return "Ԥ����";
            case 9:
                return "Ǩ��";
            case 10:
                return "Ǩ��";
            case 11:
                return "��֤";
            case 12:
                return "ע��";
            case 13:
                return "��֤";
            default:
                return "����";


        }
    }
}
