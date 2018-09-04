/**
 * Created by IntelliJ IDEA.
 * User: jun
 * Date: 11-8-30
 * Time: 上午10:43
 * To change this template use File | Settings | File Templates.
 */
function _submit() {
    ymPrompt.alert("提交成功！", 330,220, "提示信息", function (data) {
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
//========添加上传图片项========
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
    C1.innerHTML = "<input type=\"file\" name=\"pictrue" + optionNum + "\" id=\"pictrue" + optionNum + "\"  onChange=\"javascript:PreviewImg(this);\" size=\"35\" /><span style=\"color:#6699CC; cursor:pointer\" title=\"点击浏览图片\" onclick='yulan()' >预览</span>&nbsp;<span style=\"color:#6699CC; cursor:pointer\" title=\"点击添加上传图片！\" id='href" + optionNum + "' onclick='deleteRow(" + optionNum + ")' >删除</span>";
}

function deleteRow(num) {
    var TG = document.getElementById("tableG");
    if (optionNum > 1) {
        document.getElementById("href" + (optionNum - 1)).innerHTML = "删除";
    }
    TG.deleteRow(num - 1);
    optionNum--;
}

//dwr 提交
function selectAl() {
    //确认是否分发数据
    var newAray = new Array();
    var newArayEmpty = new Array();
    var j = 0;
    var l = 0;
    for (var i = 0; i < document.getElementsByName('ck').length; i++) {
        if (document.getElementsByName('ck')[i].checked) {
            newAray[j] = document.getElementsByName('ck')[i].value;//选中的记录
            j++;
        }
    }
    for (var q = 0; q < document.getElementsByName('ck').length; q++)
        if (!(document.getElementsByName('ck')[q].checked)) {
            newArayEmpty[l] = document.getElementsByName('ck')[q].value;//没选中的记录（用于把isShow字段归0）
            l++;
        }

    ymPrompt.confirmInfo('您确认提交您所选中的必填项?', 300, 185, '提示信息', function (data) {
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
        var _log = {userid:document.getElementById("userid").value, username:document.getElementById("username").value, opervalue:"必填项修改成功", operdate:new Date(), memo:"必填项修改"};
        syslogbo.save(_log);
        document.searchForm.submit();
    } else if (data == "fail") {
        ymPrompt.errorInfo("数据提交失败！", 300, 185, "提示信息", function () {
            history.go(0);
        });
    } else {
        ymPrompt.errorInfo("数据提交失败！", 300, 185, "提示信息", function () {
            history.go(0);
        });
    }
}