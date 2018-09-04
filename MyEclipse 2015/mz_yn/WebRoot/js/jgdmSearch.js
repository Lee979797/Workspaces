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
 * 操作是否需要审核
 * @param tType  需要审核的业务类型
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
 * 检查相关业务是否有业务操作限制
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
    //是主要业务吗
    sysBus.isMainBus(czlx, function (b) {
        result = b;
    });
    if (!result) {
        return true;
    } else {
        //只允许单一业务吗
        sysBus.isOneKind(function (b) {
            result = b;
        });
        if (result) {
            //没有已做其他主要业务？
            czjlBus.checkJGNotDoOtherBus(jgdm, czlx, new Date(), function (b) {
                result = b;
            });
            if (!result) {
                ymPrompt.alert({ width: 330, height: 220, message: "机构代码（" + jgdm + "）,已做了其他主要业务，不能办理该业务，请择日办理！"});
                return false;
            }
        }
        var times = 0;
        //每种主要可以每天可以办理的次数
        sysBus.busTimes(function (ps) {
            times = ps;
        });
        czjlBus.getJGBusTimes(jgdm, czlx, new Date(), function (ps) {
            result = times > ps;
        });

        if (!result) {
            ymPrompt.alert({ width: 330, height: 220, message: "机构代码（" + jgdm + "）,该业务今天已达到允许办理的最高次数，请择日再办理！"});
            return false;
        }
    }
    
    */
    return true;
}
/**
 * 获取机构代码相应业务申请的审批结果
 * @param jgdm
 * @param tType
 */
function getSpResult(jgdm, tType) {
    spBus.checkforAudia(jgdm, tType, function (srt) {
        var index = srt.indexOf(":");
        var s1 = srt.substring(0, index);
        var s2 = srt.substring(index + 1, srt.length);
        if (s1 == "0") {
            ymPrompt.alert({message: s2, width: 330, height: 220, slideShowHide: false, title: '提示信息'});
        } else if (s1 == "1") {
            ymPrompt.alert({message: s2, width: 330, height: 220, slideShowHide: false, title: '提示信息'});
        } else if (s1 == "2") {
            document.getElementById("needAudit").value = false;
            document.getElementById("audit").value = true;
            ymPrompt.alert({message: s2, width: 330, height: 220, slideShowHide: false, title: '提示信息', handler: handler});
        } else if (s1 == "3") {
            document.getElementById("needAudit").value = true;
            document.getElementById("audit").value = true;
            ymPrompt.confirmInfo({message: s2, width: 330, height: 220, slideShowHide: false, title: '提示信息', handler: handler});
            result = true;
        } else if (s1 == "4") {
            document.getElementById("needAudit").value = true;
            document.getElementById("audit").value = false;
            ymPrompt.alert({message: s2, width: 330, height: 220, slideShowHide: false, title: '提示信息', handler: handler});
        } else {
            ymPrompt.errorInfo({message: "系统发生错误", width: 330, height: 220, slideShowHide: false, title: '提示信息'});
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
            ymPrompt.alert({message: s2, width: 330, height: 220, slideShowHide: false, title: '提示信息'});
            flag = true;
        } else if (s1 == "2") {
            document.getElementById("needAudit").value = false;
            document.getElementById("audit").value = true;
            ymPrompt.alert({message: s2, width: 330, height: 220, slideShowHide: false, title: '提示信息', handler: handler});
            flag = true;
        } else if (s1 == "3") {
            document.getElementById("needAudit").value = false;
            document.getElementById("audit").value = false;
            ymPrompt.confirmInfo({message: s2, width: 330, height: 220, slideShowHide: false, title: '提示信息', handler: handler});
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
            ymPrompt.alert({message: s2, width: 330, height: 220, slideShowHide: false, title: '提示信息'});
        } else if (s1 == "2") {
            document.getElementById("needAudit").value = false;
            document.getElementById("audit").value = true;
            ymPrompt.alert({message: s2, width: 330, height: 220, slideShowHide: false, title: '提示信息', handler: handler});
        } else if (s1 == "3") {
            document.getElementById("needAudit").value = true;
            document.getElementById("audit").value = true;
            ymPrompt.confirmInfo({message: s2, width: 330, height: 220, slideShowHide: false, title: '提示信息', handler: handler});
            result = true;
        } else if (s1 == "4") {
            document.getElementById("needAudit").value = true;
            document.getElementById("audit").value = false;
            ymPrompt.alert({message: s2, width: 330, height: 220, slideShowHide: false, title: '提示信息', handler: handler});
        } else {
            flag = true;
        }

    });
    return  flag;
}
/**
 *  检查机构代码格式是否正确
 * @param jgdm 机构代码
 */
function checkJgdmCode(jgdm) {
    if (!/[a-zA-z0-9]{9}/.test(jgdm)) {
        ymPrompt.alert({message: "请输入正确的机构代码！", width: 330, height: 220, slideShowHide: false, title: '提示信息'});
        return false;
    }
    dwr.engine.setAsync(false);
    var b = false;
    codecheck.isCheckCode(jgdm.trim(), function (value) {
        b = value;
    });
    if (!b) {
        ymPrompt.alert({message: "请输入正确的机构代码！", width: 330, height: 220, slideShowHide: false, title: '提示信息'});
        return false;
    }
    return true;
}
/**
 * 检查机构代码是否存在
 * @param jgdm  机构代码
 */
function checkJgdmExit(jgdm) {
    dwr.engine.setAsync(false);
    var b = false;
    jgdmBus.check(jgdm, function (value) {
        var vs = value.split(":");
        if ("false" == vs[0]) {
            ymPrompt.alert({message: vs[1], slideShowHide: false, width: 330, height: 220, title: '提示信息', handler: handler});
            b = false;
        } else {
            b = true;
        }
    });
    return b;
}
/**
 * 检查机构存在不存在需要发卡
 * @param jgdm
 * @param bzjgdm
 */
function checkJgdmICExit(jgdm, bzjgdm,userName) {
    dwr.engine.setAsync(false);
    var b = false;
    jgdmBus.checkJgdmForIC(jgdm, bzjgdm,userName,function (value) {
        var vs = value.split(":");
        if ("false" == vs[0]) {
            ymPrompt.alert({message: vs[1], slideShowHide: false, width: 330, height: 220, title: '提示信息', handler: handler});
            b = false;
        } else {
            b = true;
        }
    });

    return b;
}
/**
 * 检查机构存在不存在需要发卡
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
 *    检查是否已经发卡
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
            ymPrompt.alert({message: "机构代码(" + jgdm + ")没有发卡不能进行挂失，注销，变更及卡年检等操作！",
                slideShowHide: false, width: 330, height: 220, title: '提示信息', handler: handler});
        }
    });
    return b;
}

/**
 * 检查机构代码是否存在于注销代码中
 * @param jgdm
 */
function checkFzdmExit(jgdm) {
    dwr.engine.setAsync(false);
    var b = false;
    fzdmBus.isExit(jgdm, function (value) {
        b = value;
        if (!b) {
            ymPrompt.alert({message: "机构代码没有被注销，或者不存在！",
                slideShowHide: false, width: 330, height: 220, title: '提示信息'});
        }
    });
    /* jgdmBus.checkQzsm(jgdm, '11','${sysUser.userName}', function (value) {
     b = value;
     if (!b) {
     ymPrompt.alert({message: "机构代码需要先完成前置扫描，才能恢复！",
     slideShowHide: false, width: 330, height: 220, title: '提示信息'});
     }
     });*/
    return b;
}
/**
 *   检查机构代码是否存在
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
                slideShowHide: false, width: 330, height: 220, title: '提示信息', handler: handler});
            b = false;
        } else {
            b = true;
        }
    });
    return b;
}
/**
 *   检查机构代码是否存在
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
                slideShowHide: false, width: 330, height: 220, title: '提示信息'});
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
                slideShowHide: false, width: 330, height: 220, title: '提示信息'});
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
                slideShowHide: false, width: 330, height: 220, title: '提示信息'});
            b = false;
        } else {
            b = true;
        }
    });
    return b;
}
/**
 * 检查迁址的机构代码是否存在 切迁址前不在当前bzjg
 * @param jgdm   机构代码
 * @param bzjgdm       办证机构代码
 * @param type      迁址的类型
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
 *  检查迁址的机构代码是否存在 type
 * @param jgdm       机构代码
 * @param type     01 省内 03 是省间
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
 *   检查迁址的机构代码在qtmd是否存在
 * @param jgdm    机构代码
 */
function checkQtmdkExit(jgdm) {
    dwr.engine.setAsync(false);
    var flag = false;
    qtmdkBus.existCode(jgdm, 5, function (value) {
        flag = value;
        if (!flag)
            ymPrompt.alert({message: "机构代码(" + jgdm + ")不在码段库中;如果要添加此信息,请与省中心联系,把此码段添到其他码段库中!",
                slideShowHide: false, width: 330, height: 220, title: '提示信息'});
    });
    return flag;
}
/**
 *  判断 jgdm 是否存在
 * @param jgdm
 */
function checkNOExit(jgdm) {
    var b = false;
    jgdmBus.isExit(jgdm, function (value) {
        if (value)
            ymPrompt.alert({message: "机构代码(" + jgdm + ")已经存在!", width: 330, height: 220,
                slideShowHide: false, title: '提示信息'});
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