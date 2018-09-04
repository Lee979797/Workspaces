/**
 * Created by ninemax-199 on 14-3-18.
 */
function s() {
    var elements = [];
    for (var i = 0; i < arguments.length; i++) {
        var element = arguments[i];
        if (typeof element == 'string')
            element = document.getElementById(element);
        if (arguments.length == 1)
            return element;
        elements.push(element);
    }
    return elements;
}
function show(message) {
    hideElement();
    var event = (document.all) ? window.event.srcElement : arguments[1];
    var shield = document.createElement("DIV");//产生一个背景遮罩层
    shield.id = "shield";
    shield.style.left = "0px";
    shield.style.top = "0px";
    shield.style.position = 'absolute';
    shield.style.width = '100%';
    shield.style.background = "#333";
    shield.style.textAlign = "center";
    shield.style.zIndex = "10000";
    shield.style.opacity = "0";
    shield.style.filter = "alpha(opacity = 0)";
    shield.style.height = ((document.documentElement.clientHeight > document.documentElement.scrollHeight) ? document.documentElement.clientHeight : document.documentElement.scrollHeight) + "px";
    var alertFrame = document.createElement("DIV");//产生一个提示框
    alertFrame.id = "alertFram";
    alertFrame.style.position = 'absolute';
    alertFrame.style.width = '200px';
    alertFrame.style.height = '162px';
    alertFrame.style.left = "35%";
    alertFrame.style.top = '30px';
    alertFrame.style.background = "#fff";
    alertFrame.style.textAlign = 'center';
    alertFrame.style.zIndex = "10001";
    alertFrame.style.lineHeight = "50px";
    if (typeof(message) == "undefined") {
        message = " 正在服务器上执行, 请稍候";
    }
    alertFrame.innerHTML = "<div style='width:100%; border:#58a3cb solid 1px; text-align:center;padding-top:10px'>" +
        "<img src='/product/images/allloading.gif'><br>" + message + " </div>";
    document.body.appendChild(alertFrame);
    document.body.appendChild(shield);
    this.setOpacity = function (obj, opacity) {
        if (opacity >= 1)opacity = opacity / 100;
        try {
            obj.style.opacity = opacity;
            if (obj.filters.length > 0 && obj.filters("alpha")) {
                obj.filters("alpha").opacity = opacity * 100;
            } else {
                obj.style.filter = "alpha(opacity='" + (opacity * 100) + "')";
            }
        } catch (e) {
        }
    };
    var c = 0;
    this.doAlpha = function () {
        if (++c > 20) {
            clearInterval(ad);
            return 0;
        }
        setOpacity(shield, c);
    };
    var ad = setInterval("doAlpha()", 1);//渐变效果
    // event.blur();
    document.body.onselectstart = document.body.oncontextmenu = function () {
        return false;
    }
}
//隐藏页面上一些特殊的控件
function hideElement() {
    var element = ['IMG', 'SELECT', 'OBJECT', 'IFRAME'];
    for (var j = 0; j < element.length; j++) {
        try {
            var tagName = element[j];
            for (var i = 0; i < document.all.tags(tagName).length; i++) {
                var objTemp = document.all.tags(tagName)[i];
                if (!objTemp || !objTemp.offsetParent)
                    continue;
                objTemp.disabled = "disabled"
            }
        }
        catch (e) {
        }
    }
}
function close() {
    var shield = s("shield");
    var alertFrame = s("alertFram");
    if (alertFrame != null) {
        document.body.removeChild(alertFrame);
    }
    if (shield != null) {
        document.body.removeChild(shield);
    }
    document.body.onselectstart = document.body.oncontextmenu = function () {
        return true
    };
}
function ajaxCode(flag, busForm, id, org_name, reg_num, org_address) {

    show('发送赋码请求中...');

    var code = null;
    var data = id != null ? {
        stype: 'only-text',
        id: id,
        flag: flag,
        'code-type': '3'
    } : {
        'org-name': org_name,
        'reg-num': reg_num,
        'org-address': org_address,
        stype: 'only-text',
        flag: flag,
        'code-type': '1'
    };
    $.ajax({
        type: 'post',//可选get
        url: '/code/assign',//这里是接收数据的程序
        data: data,//传给数据，多个参数用&连接
        dataType: 'Json',//服务器返回的数据类型 可选XML ,Json jsonp script html text等
        complete: comeback});
    function comeback(msg) {
        close();
        var jsonData = eval("(" + msg.responseText + ")");
        code = jsonData.code;
        flag = jsonData.flag;
        if ('0' == flag) {
            // ymPrompt.confirmInfo({message: "取码成功！"+jsonData.code+"点击‘确定’提交数据；点击‘取消’，放弃该码！", width: 330, height: 220, title: '提示信息', handler: function (tp) {
            //   if (tp == 'ok') {
            $.ajax({
                type: 'post',//可选get
                url: '/code/assign',//这里是接收数据的程序
                data: {
                    stype: 'confirm',
                    code: code
                },//传给的数据，多个参数用&连接
                dataType: 'Json',//服务器返回的数据类型 可选XML ,Json jsonp script html text等
                complete: conformed
            })
        } else if ('1' == flag) {
              var rep = asyInfo(jsonData.info);
            ymPrompt.confirmInfo({message: "<span style='color: #333;'>疑似赋码，点击确定重新获取代码！</span></br>" +rep,
                width: 430, height: 330, title: '提示信息', handler: function (tp) {
                    if (tp == 'ok') {
                        ajaxCode(1, busForm, id, org_name, reg_num, org_address);
                    }
                }});
        } else if ('2' == flag) {
                 var rep = asyInfo(jsonData.info);
            ymPrompt.alert({message: "重复赋码！</br>" +rep, width: 430, height: 270, title: '提示信息', handler: function (tp) {
            }});
        } else if ('3' == flag) {
            ymPrompt.confirmInfo({message: jsonData.info + ",从国家中心取码失败,是否从本地码段库取码？",
                width: 330, height: 220, title: '提示信息', handler: function (tp) {
                    if (tp == 'ok') {
                        busForm.submit();
                    }
                }});
        } else {
            ymPrompt.confirmInfo({message: "集中赋码异常，是否从本地库获取代码？",
                width: 330, height: 220, title: '提示信息', handler: function (tp) {
                    if (tp == 'ok') {
                        busForm.submit();
                    }
                }});
        }
    }

    function asyInfo(info) {
        info = info.replace(/\{/g, "");
        info = info.replace(/}/g, "<br/>");
        info = info.replace(/orgName:/g, "<span style='color: red; '>机构名称</span>:");
        info = info.replace(/regNum:/g, "<span style='color: red; '>注册号</span>:");
        info = info.replace(/orgAddress:/g, "<span style='color: red; '>单位地址</span>:");
        info = info.replace(/code:/g, "<span style='color: red; '>机构代码</span>:");
        return info;
    }

    function conformed(msg) {
        var data = eval("(" + msg.responseText + ")");
        close();
        if ('0' == data.flag) {
            busForm.sslcode.value = code;
            busForm.submit();
            return true;
        } else {
            ymPrompt.alert({message: data.info, width: 330, height: 200, title: '提示信息', handler: function (tp) {
            }});
            return false;
        }
    }
}

