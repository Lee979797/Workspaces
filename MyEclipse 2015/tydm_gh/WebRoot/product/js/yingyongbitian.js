/**
 * Created by IntelliJ IDEA.
 * User: jun
 * Date: 11-8-30
 * Time: ����10:43
 * To change this template use File | Settings | File Templates.
 */
function _submit() {
    ymPrompt.alert("�ύ�ɹ���", 330,220, "��ʾ��Ϣ", function (data) {
        if (data == 'ok') {
            location.href = '#';
        }
    });
}

function yulan() {
    //    document.getElementById("tupiandiv").style.display = "block";
    window.open("see_seetupian.html");

}
function closediv() {
    document.getElementById("tupiandiv").style.display = "none";

}
function addrows() {
    //    document.getElementById("tupiandiv").style.display = "block";
    document.getElementById("displaynonerow").style.display = "block";

}
//========����ϴ�ͼƬ��========
var optionNum = 0;
function addOption() {
    var TG = document.getElementById("tableG");
    var count = TG.rows.length;
    var R = TG.insertRow(count);
    var C1 = R.insertCell();
    optionNum++;
    if (optionNum > 1) {
        document.getElementById("href" + (optionNum - 1)).innerHTML = "";
    }
    C1 = R.insertCell();
    C1.align = "left";
    C1.innerHTML = "<input type=\"file\" name=\"pictrue" + optionNum + "\" id=\"pictrue" + optionNum + "\"  onChange=\"javascript:PreviewImg(this);\" size=\"35\" /><span style=\"color:#6699CC; cursor:pointer\" title=\"������ͼƬ\" onclick='yulan()' >Ԥ��</span>&nbsp;<span style=\"color:#6699CC; cursor:pointer\" title=\"�������ϴ�ͼƬ��\" id='href" + optionNum + "' onclick='deleteRow(" + optionNum + ")' >ɾ��</span>";
}

function deleteRow(num) {
    var TG = document.getElementById("tableG");
    if (optionNum > 1) {
        document.getElementById("href" + (optionNum - 1)).innerHTML = "ɾ��";
    }
    TG.deleteRow(num - 1);
    optionNum--;
}

//dwr �ύ
function selectAl() {
    //ȷ���Ƿ�ַ�����
    var newAray = new Array();
    var newArayEmpty = new Array();
    var j = 0;
    var l = 0;
    for (var i = 0; i < document.getElementsByName('ck').length; i++) {
        if (document.getElementsByName('ck')[i].checked) {
            newAray[j] = document.getElementsByName('ck')[i].value;//ѡ�еļ�¼
            j++;
        }
    }
    for (var q = 0; q < document.getElementsByName('ck').length; q++)
        if (!(document.getElementsByName('ck')[q].checked)) {
            newArayEmpty[l] = document.getElementsByName('ck')[q].value;//ûѡ�еļ�¼�����ڰ�isShow�ֶι�0��
            l++;
        }

    ymPrompt.confirmInfo('��ȷ���ύ����ѡ�еı�����?', 300, 185, '��ʾ��Ϣ', function (data) {
            if (data == 'ok') {
                // alert(newAray.length);
                ScFieldsBo.selectAl(newAray, newArayEmpty, callback);
            } else {
                return false;
            }
        }
    )
}
function callback(data) {
    if (data == "success") {
        var _log = {userid:document.getElementById("userid").value, username:document.getElementById("username").value, opervalue:"�������޸ĳɹ�", operdate:new Date(), memo:"�������޸�"};
        syslogbo.save(_log);
        document.searchForm.submit();
    } else if (data == "fail") {
        ymPrompt.errorInfo("�����ύʧ�ܣ�", 300, 185, "��ʾ��Ϣ", function () {
            history.go(0);
        });
    } else {
        ymPrompt.errorInfo("�����ύʧ�ܣ�", 300, 185, "��ʾ��Ϣ", function () {
            history.go(0);
        });
    }
}