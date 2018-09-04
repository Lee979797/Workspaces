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
    var shield = document.createElement("DIV");//����һ���������ֲ�
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
    var alertFrame = document.createElement("DIV");//����һ����ʾ��
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
        message = " ���ڷ�������ִ��, ���Ժ�";
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
    var ad = setInterval("doAlpha()", 1);//����Ч��
    // event.blur();
    document.body.onselectstart = document.body.oncontextmenu = function () {
        return false;
    }
}
//����ҳ����һЩ����Ŀؼ�
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

    show('���͸���������...');

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
        type: 'post',//��ѡget
        url: '/code/assign',//�����ǽ������ݵĳ���
        data: data,//�������ݣ����������&����
        dataType: 'Json',//���������ص��������� ��ѡXML ,Json jsonp script html text��
        complete: comeback});
    function comeback(msg) {
        close();
        var jsonData = eval("(" + msg.responseText + ")");
        code = jsonData.code;
        flag = jsonData.flag;
        if ('0' == flag) {
            // ymPrompt.confirmInfo({message: "ȡ��ɹ���"+jsonData.code+"�����ȷ�����ύ���ݣ������ȡ�������������룡", width: 330, height: 220, title: '��ʾ��Ϣ', handler: function (tp) {
            //   if (tp == 'ok') {
            $.ajax({
                type: 'post',//��ѡget
                url: '/code/assign',//�����ǽ������ݵĳ���
                data: {
                    stype: 'confirm',
                    code: code
                },//���������ݣ����������&����
                dataType: 'Json',//���������ص��������� ��ѡXML ,Json jsonp script html text��
                complete: conformed
            })
        } else if ('1' == flag) {
              var rep = asyInfo(jsonData.info);
            ymPrompt.confirmInfo({message: "<span style='color: #333;'>���Ƹ��룬���ȷ�����»�ȡ���룡</span></br>" +rep,
                width: 430, height: 330, title: '��ʾ��Ϣ', handler: function (tp) {
                    if (tp == 'ok') {
                        ajaxCode(1, busForm, id, org_name, reg_num, org_address);
                    }
                }});
        } else if ('2' == flag) {
                 var rep = asyInfo(jsonData.info);
            ymPrompt.alert({message: "�ظ����룡</br>" +rep, width: 430, height: 270, title: '��ʾ��Ϣ', handler: function (tp) {
            }});
        } else if ('3' == flag) {
            ymPrompt.confirmInfo({message: jsonData.info + ",�ӹ�������ȡ��ʧ��,�Ƿ�ӱ�����ο�ȡ�룿",
                width: 330, height: 220, title: '��ʾ��Ϣ', handler: function (tp) {
                    if (tp == 'ok') {
                        busForm.submit();
                    }
                }});
        } else {
            ymPrompt.confirmInfo({message: "���и����쳣���Ƿ�ӱ��ؿ��ȡ���룿",
                width: 330, height: 220, title: '��ʾ��Ϣ', handler: function (tp) {
                    if (tp == 'ok') {
                        busForm.submit();
                    }
                }});
        }
    }

    function asyInfo(info) {
        info = info.replace(/\{/g, "");
        info = info.replace(/}/g, "<br/>");
        info = info.replace(/orgName:/g, "<span style='color: red; '>��������</span>:");
        info = info.replace(/regNum:/g, "<span style='color: red; '>ע���</span>:");
        info = info.replace(/orgAddress:/g, "<span style='color: red; '>��λ��ַ</span>:");
        info = info.replace(/code:/g, "<span style='color: red; '>��������</span>:");
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
            ymPrompt.alert({message: data.info, width: 330, height: 200, title: '��ʾ��Ϣ', handler: function (tp) {
            }});
            return false;
        }
    }
}

