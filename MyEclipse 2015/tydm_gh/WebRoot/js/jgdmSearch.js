var flag = false;
function handler(tp) {
    if (true) {
        if (tp == 'ok') {
            document.thisForm.submit();
            flag = false;
        }
    }
}

/**
 * �����Ƿ���Ҫ���
 * @param tType  ��Ҫ��˵�ҵ������
 * @param jgdm
 */
function needAudia(jgdm, tType) {  
    dwr.engine.setAsync(false);
    var result = false;
    var ywlx = document.getElementById('ywlx');
    var czlx = "0";
    switch (tType) {
        case 'sqbscsh':
        {
            czlx = "7";
            ywlx.value = '00';
            break;
        }
        case 'fzsh':
        {
            czlx = "3";
            ywlx.value = '01';
            break;
        }
        case 'hzsh':
        {
            czlx = "8";
            ywlx.value = '02';
            break;
        }
        case 'deletesh':
        {
            czlx = "K";
            ywlx.value = '03';
            break;
        }

        case 'fzhfsh':
        {
            czlx = "C";
            ywlx.value = '04';
            break;
        }
        case 'qzsh':
        {
            czlx = "9";
            ywlx.value = '05';
            break;
        }
        case 'cmzcsh':
        {
            czlx = "I";
            ywlx.value = '06';
            break;
        }
        case 'bgsh':
        {
            czlx = "2";
            ywlx.value = '17';
            break;
        }
        default :
        {
            ywlx.value = tType;
        }

    }
    if (/^\d+$/.test(tType)) {
        return getSpResult2(jgdm, tType);
    }
    sysBus.isNeedAudia(tType, function (b) {
        result = b;
    });
    if (result) {
        getSpResult(jgdm, tType);
        return true;
    } else {
        return getSpResult2(jgdm, tType);
    }
}
/**
 * ������ҵ���Ƿ���ҵ���������
 * @param jgdm
 * @param czlx
 */
function ywkz(jgdm, czlx) {
	
	/**
    czlx = getbusType(czlx);
    if (czlx == undefined || czlx == "") {
        return true;
    }
    var result = false;
    //����Ҫҵ����
    sysBus.isMainBus(czlx, function (b) {
        result = b;
    });
    if (!result) {
        return true;
    } else {
        //ֻ����һҵ����
        sysBus.isOneKind(function (b) {
            result = b;
        });
        if (result) {
            //û������������Ҫҵ��
            czjlBus.checkJGNotDoOtherBus(jgdm, czlx, new Date(), function (b) {
                result = b;
            });
            if (!result) {
                ymPrompt.alert({ width: 330, height: 220, message: "�������루" + jgdm + "��,������������Ҫҵ�񣬲��ܰ����ҵ�������հ���"});
                return false;
            }
        }
        var times = 0;
        //ÿ����Ҫ����ÿ����԰���Ĵ���
        sysBus.busTimes(function (ps) {
            times = ps;
        });
        czjlBus.getJGBusTimes(jgdm, czlx, new Date(), function (ps) {
            result = times > ps;
        });

        if (!result) {
            ymPrompt.alert({ width: 330, height: 220, message: "�������루" + jgdm + "��,��ҵ������Ѵﵽ����������ߴ������������ٰ���"});
            return false;
        }
    }
    
    */
    return true;
}
/**
 * ��ȡ����������Ӧҵ��������������
 * @param jgdm
 * @param tType
 */
function getSpResult(jgdm, tType) {
    spBus.checkforAudia(jgdm, tType, function (srt) {
        var index = srt.indexOf(":");
        var s1 = srt.substring(0, index);
        var s2 = srt.substring(index + 1, srt.length);
        if (s1 == "0") {
            ymPrompt.alert({message: s2, width: 330, height: 220, slideShowHide: false, title: '��ʾ��Ϣ'});
        } else if (s1 == "1") {
            ymPrompt.alert({message: s2, width: 330, height: 220, slideShowHide: false, title: '��ʾ��Ϣ'});
        } else if (s1 == "2") {
            document.getElementById("needAudit").value = false;
            document.getElementById("audit").value = true;
            ymPrompt.alert({message: s2, width: 330, height: 220, slideShowHide: false, title: '��ʾ��Ϣ', handler: handler});
        } else if (s1 == "3") {
            document.getElementById("needAudit").value = true;
            document.getElementById("audit").value = true;
            ymPrompt.confirmInfo({message: s2, width: 330, height: 220, slideShowHide: false, title: '��ʾ��Ϣ', handler: handler});
            result = true;
        } else if (s1 == "4") {
            document.getElementById("needAudit").value = true;
            document.getElementById("audit").value = false;
            ymPrompt.alert({message: s2, width: 330, height: 220, slideShowHide: false, title: '��ʾ��Ϣ', handler: handler});
        } else {
            ymPrompt.errorInfo({message: "ϵͳ��������", width: 330, height: 220, slideShowHide: false, title: '��ʾ��Ϣ'});
        }

    });
}
function getSpResult2(jgdm, tType) {
    var flag = false;
    spBus.checkforAudia(jgdm, tType, function (srt) {
        var index = srt.indexOf(":");
        var s1 = srt.substring(0, index);
        var s2 = srt.substring(index + 1, srt.length);
        if (s1 == "1") {
            ymPrompt.alert({message: s2, width: 330, height: 220, slideShowHide: false, title: '��ʾ��Ϣ'});
            flag = true;
        } else if (s1 == "2") {
            document.getElementById("needAudit").value = false;
            document.getElementById("audit").value = true;
            ymPrompt.alert({message: s2, width: 330, height: 220, slideShowHide: false, title: '��ʾ��Ϣ', handler: handler});
            flag = true;
        } else if (s1 == "3") {
            document.getElementById("needAudit").value = false;
            document.getElementById("audit").value = false;
            ymPrompt.confirmInfo({message: s2, width: 330, height: 220, slideShowHide: false, title: '��ʾ��Ϣ', handler: handler});
            flag = true;
        }

    });
    return flag;
}
function spccf(jgdm) {
    var flag = false;
    spBus.getSpcf(jgdm, function (srt) {
        var index = srt.indexOf(":");
        var s1 = srt.substring(0, index);
        var s2 = srt.substring(index + 1, srt.length);
        if (s1 == "1") {
            ymPrompt.alert({message: s2, width: 330, height: 220, slideShowHide: false, title: '��ʾ��Ϣ'});
        } else if (s1 == "2") {
            document.getElementById("needAudit").value = false;
            document.getElementById("audit").value = true;
            ymPrompt.alert({message: s2, width: 330, height: 220, slideShowHide: false, title: '��ʾ��Ϣ', handler: handler});
        } else if (s1 == "3") {
            document.getElementById("needAudit").value = true;
            document.getElementById("audit").value = true;
            ymPrompt.confirmInfo({message: s2, width: 330, height: 220, slideShowHide: false, title: '��ʾ��Ϣ', handler: handler});
            result = true;
        } else if (s1 == "4") {
            document.getElementById("needAudit").value = true;
            document.getElementById("audit").value = false;
            ymPrompt.alert({message: s2, width: 330, height: 220, slideShowHide: false, title: '��ʾ��Ϣ', handler: handler});
        } else {
            flag = true;
        }

    });
    return  flag;
}
/**
 *  �����������ʽ�Ƿ���ȷ
 * @param jgdm ��������
 */
function checkJgdmCode(jgdm) {
    if (!/[a-zA-z0-9]{9}/.test(jgdm)) {
        ymPrompt.alert({message: "��������ȷ�Ļ������룡", width: 330, height: 220, slideShowHide: false, title: '��ʾ��Ϣ'});
        return false;
    }
    dwr.engine.setAsync(false);
    var b = false;
    codecheck.isCheckCode(jgdm.trim(), function (value) {
        b = value;
    });
    if (!b) {
        ymPrompt.alert({message: "��������ȷ�Ļ������룡", width: 330, height: 220, slideShowHide: false, title: '��ʾ��Ϣ'});
        return false;
    }
    return true;
}
/**
 * �����������Ƿ����
 * @param jgdm  ��������
 */
function checkJgdmExit(jgdm) {
    dwr.engine.setAsync(false);
    var b = false;
    jgdmBus.check(jgdm, function (value) {
        var vs = value.split(":");
        if ("false" == vs[0]) {
            ymPrompt.alert({message: vs[1], slideShowHide: false, width: 330, height: 220, title: '��ʾ��Ϣ', handler: handler});
            b = false;
        } else {
            b = true;
        }
    });
    return b;
}
/**
 * ���������ڲ�������Ҫ����
 * @param jgdm
 * @param bzjgdm
 */
function checkJgdmICExit(jgdm, bzjgdm,userName) {
    dwr.engine.setAsync(false);
    var b = false;
    jgdmBus.checkJgdmForIC(jgdm, bzjgdm,userName,function (value) {
        var vs = value.split(":");
        if ("false" == vs[0]) {
            ymPrompt.alert({message: vs[1], slideShowHide: false, width: 330, height: 220, title: '��ʾ��Ϣ', handler: handler});
            b = false;
        } else {
            b = true;
        }
    });

    return b;
}
/**
 * ���������ڲ�������Ҫ����
 * @param jgdm
 * @param bzjgdm
 */
function checkICExit(jgdm) {
    dwr.engine.setAsync(false);
    var b = false;
    kxxkBus.checkICForWrite(jgdm, function (value) {
        b = value;
    });
    return b;
}
/**
 *    ����Ƿ��Ѿ�����
 * @param jgdm
 * @param bzjgdm
 */

function checkICFCExit(jgdm) {
    dwr.engine.setAsync(false);
    var b = false;
    kxxkBus.checkICForLoss(jgdm, function (value) {
        b = value;
        if (b) {
        } else {
            ymPrompt.alert({message: "��������(" + jgdm + ")û�з������ܽ��й�ʧ��ע��������������Ȳ�����",
                slideShowHide: false, width: 330, height: 220, title: '��ʾ��Ϣ', handler: handler});
        }
    });
    return b;
}

/**
 * �����������Ƿ������ע��������
 * @param jgdm
 */
function checkFzdmExit(jgdm) {
    dwr.engine.setAsync(false);
    var b = false;
    fzdmBus.isExit(jgdm, function (value) {
        b = value;
        if (!b) {
            ymPrompt.alert({message: "��������û�б�ע�������߲����ڣ�",
                slideShowHide: false, width: 330, height: 220, title: '��ʾ��Ϣ'});
        }
    });
    /* jgdmBus.checkQzsm(jgdm, '11','${sysUser.userName}', function (value) {
     b = value;
     if (!b) {
     ymPrompt.alert({message: "����������Ҫ�����ǰ��ɨ�裬���ָܻ���",
     slideShowHide: false, width: 330, height: 220, title: '��ʾ��Ϣ'});
     }
     });*/
    return b;
}
/**
 *   �����������Ƿ����
 * @param jgdm
 * @param bzjgdm
 */
function checkJgdmSaveWithBzjgdm(jgdm, bzjgdm,userName) {
    dwr.engine.setAsync(false);
    var b = false;
    jgdmBus.checkSave(jgdm, bzjgdm,userName, function (value) {
        var vs = value.split(":");
        if ("false" == vs[0]) {
            ymPrompt.alert({message: vs[1],
                slideShowHide: false, width: 330, height: 220, title: '��ʾ��Ϣ', handler: handler});
            b = false;
        } else {
            b = true;
        }
    });
    return b;
}
/**
 *   �����������Ƿ����
 * @param jgdm
 * @param bzjgdm
 */
function checkJgdmWithBzjgdm(jgdm, bzjgdm,userName) {
    dwr.engine.setAsync(false);
    var b = false;
    jgdmBus.check(jgdm, bzjgdm,userName, function (value) {
        var vs = value.split(":");
        if ("false" == vs[0]) {
            ymPrompt.alert({message: vs[1],
                slideShowHide: false, width: 330, height: 220, title: '��ʾ��Ϣ'});
            b = false;
        } else {
            b = true;
        }
    });
    return b;
}
function checkJgdmWithBzjgdmNoPrint(jgdm, bzjgdm,userName) {
    dwr.engine.setAsync(false);
    var b = false;
    jgdmBus.checkNoPrint(jgdm, bzjgdm,userName, function (value) {
        var vs = value.split(":");
        if ("false" == vs[0]) {
            ymPrompt.alert({message: vs[1],
                slideShowHide: false, width: 330, height: 220, title: '��ʾ��Ϣ'});
            b = false;
        } else {
            b = true;
        }
    });
    return b;
}
function checkJgdmWithBzjgdmForQz(jgdm, bzjgdm,userName) {
    dwr.engine.setAsync(false);
    var b = false;
    jgdmBus.checkQz(jgdm, bzjgdm,userName, function (value) {
        var vs = value.split(":");
        if ("false" == vs[0]) {
            ymPrompt.alert({message: vs[1],
                slideShowHide: false, width: 330, height: 220, title: '��ʾ��Ϣ'});
            b = false;
        } else {
            b = true;
        }
    });
    return b;
}
/**
 * ���Ǩַ�Ļ��������Ƿ���� ��Ǩַǰ���ڵ�ǰbzjg
 * @param jgdm   ��������
 * @param bzjgdm       ��֤��������
 * @param type      Ǩַ������
 */
function checkQzjgdmExitForIn(jgdm, bzjgdm,userName, type) {
    dwr.engine.setAsync(false);
    var flag = false;
    qzjgdmBus.checkForIn(jgdm, bzjgdm,userName, type, function (b) {
        flag = b;
    });
    return flag;
}
/**
 *  ���Ǩַ�Ļ��������Ƿ���� type
 * @param jgdm       ��������
 * @param type     01 ʡ�� 03 ��ʡ��
 */
function checkQzjgdmExitForRedo(jgdm, bzjgdm,userName, type) {
    dwr.engine.setAsync(false);
    var flag = false;
    qzjgdmBus.checkForRedo(jgdm, bzjgdm,userName, type, function (b) {
        flag = b;
    });
    return flag;
}
/**
 *   ���Ǩַ�Ļ���������qtmd�Ƿ����
 * @param jgdm    ��������
 */
function checkQtmdkExit(jgdm) {
    dwr.engine.setAsync(false);
    var flag = false;
    qtmdkBus.existCode(jgdm, 5, function (value) {
        flag = value;
        if (!flag)
            ymPrompt.alert({message: "��������(" + jgdm + ")������ο���;���Ҫ��Ӵ���Ϣ,����ʡ������ϵ,�Ѵ������������ο���!",
                slideShowHide: false, width: 330, height: 220, title: '��ʾ��Ϣ'});
    });
    return flag;
}
/**
 *  �ж� jgdm �Ƿ����
 * @param jgdm
 */
function checkNOExit(jgdm) {
    var b = false;
    jgdmBus.isExit(jgdm, function (value) {
        if (value)
            ymPrompt.alert({message: "��������(" + jgdm + ")�Ѿ�����!", width: 330, height: 220,
                slideShowHide: false, title: '��ʾ��Ϣ'});
        b = !value;
    });
    return b;
}
function ches(obj) {
    switch (event.keyCode) {
        case 13:
            if (fCheckValue)
                fCheckValue();
            else
                obj.submit();
            return false;
        default:
            return true;
    }

}
function chesKey() {
    return event.keyCode != 13;

}
function rightValues(obj) {
    if (event.keyCode == "35" ||
        event.keyCode == "36" ||
        event.keyCode == "37" ||
        event.keyCode == "38" ||
        event.keyCode == "39" ||
        event.keyCode == "40") {
        return;
    }

    if (!(obj && obj.value && obj.value.length > 0 && !/^[A-Z0-9]{1,9}$/.test(obj.value))) {
    } else {
        obj.value = obj.value.trim().toUpperCase();
        obj.value = obj.value.replace(/[^A-Z0-9]/gm, "");
        obj.focus();
    }
}
function getbusType(bus) {
    switch (bus) {
        case "update_no":
            return '2';
        case "update":
            return '2';
        case "loss":
            return 'A';
        case "validate":
            return '3';
        case "check":
            return '6';
        case "supplement":
            return 'KP';
        case "back":
            return 'S';
        case "check2":
            return 'K6';
        case "update2":
            return 'R';
        case "unvalidate":
            return 'C';
        case "validate2":
            return 'B';
        case "delete":
            return 'K';
        case "outerIn":
            return '9';
        case "innerIn":
            return '9';
        default:
            return "";
    }

}