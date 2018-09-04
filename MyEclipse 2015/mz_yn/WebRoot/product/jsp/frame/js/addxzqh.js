/**
 * Created by IntelliJ IDEA.
 * User: jun
 * Date: 11-9-2
 * Time: 下午3:43
 * To change this template use File | Settings | File Templates.
 */
function checkForm() {
    if (isEmpty(document.searchForm.userid.value)) {
        ymPrompt.alert("请输入办证机构！", 330,220, "提示信息", function (data) {
            if (data == "ok") {
                document.searchForm.userid.focus();
            }
        });
        return false;
    } else if (!isNumber(document.searchForm.userid.value)) {
        ymPrompt.alert("请输入六位数字！", 330,220, "提示信息", function (data) {
            if (data == "ok") {
                document.searchForm.userid.focus();
            }
        });
        return false;
    } else if (document.searchForm.userid.value.length != 6) {
        ymPrompt.alert("办证机构为六位数字！", 330,220, "提示信息", function (data) {
            if (data == "ok") {
                document.searchForm.userid.focus();
            }
        });
        return false;
    } else if (!document.searchForm.userid.value.startWith(document.searchForm.userProvince.value)) {
        ymPrompt.alert("请输入以" + document.searchForm.userProvince.value + "为开头的办证机构！", 330,220, "提示信息", function (data) {
            if (data == "ok") {
                document.searchForm.userid.value = document.searchForm.userProvince.value;
                document.searchForm.userid.focus();
            }
        });
        return false;
    }
    if (isEmpty(document.searchForm.userName.value)) {
        ymPrompt.alert("请输入名称！", 330,220, "提示信息", function (data) {
            if (data == "ok") {
                document.searchForm.userName.focus();
            }
        });
        return false;
    } else if (document.searchForm.userName.value.length > 100) {
        ymPrompt.alert("输入的名称不得超过200个字符！", 330,220, "提示信息", function (data) {
            if (data == "ok") {
                document.searchForm.userName.focus();
            }
        });
        return false;
    }

    document.searchForm.submit();
}

function checkFormCenter() {
//    var center = document.getElementById("province").value;
//    if(isEmpty(center)){
//        ymPrompt.alert({message:"请选择分中心！", width:330, height:220, title:'提示信息'});
//        return false;
//    }
    var startdate1 = document.getElementById("startDate1").value;
    var endDate1 = document.getElementById("endDate1").value;
    var startdate2 = document.getElementById("startDate2").value;
    var endDate2 = document.getElementById("endDate2").value;
    if (Number(startdate1) > Number(endDate1)) {
        ymPrompt.alert({message:"起始时间不能大于结束时间！", width:330, height:220, title:"提示信息"});
        return false;
    } else if ((Number(startdate1) === Number(endDate1) && Number(startdate2) >= Number(endDate2) )) {
        ymPrompt.alert({message:"起始时间不能大于结束时间！", width:330, height:220, title:"提示信息"});
        return false;
    } else {
        document.searchForm.submit();
        return true;
    }
}
String.prototype.startWith = function (str) {
    if (str == null || str == "" || this.length == 0 || str.length > this.length)
        return false;
    if (this.substr(0, str.length) == str)
        return true;
    else
        return false;
    return true;
}

