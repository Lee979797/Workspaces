/**
 * Created by IntelliJ IDEA.
 * User: jun
 * Date: 11-8-30
 * Time: 下午2:45
 * To change this template use File | Settings | File Templates.
 */
function startAction(url) {
    window.location.href = url;
}
function query() {
    document.searchForm.pageno.value = 1;
    checkForm();
}
function checkForm() {
    var specialChar = CheckSpecialChar(document.searchForm.searchValue.value, special_char.searchs);
    if (specialChar) {
        ymPrompt.alert('查询关键字不能包含' + specialChar + '字符！', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                searchForm.searchValue.focus();
            }
        });
        return false;
    }
    if (!isNumber(document.searchForm.pageno.value)) {

        ymPrompt.alert('请输入数字！', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                searchForm.pageno.focus();
            }
        });
        return false;
    } else {
        var pageCount = parseInt(document.getElementById("totalPages").value);
        if (document.searchForm.pageno.value > pageCount) {

            ymPrompt.alert('输入数字不能大于总页数！', 330, 220, '提示信息', function (data) {
                if (data == "ok") {
                    searchForm.pageno.focus();
                }
            });
            return false;
        }

    }
    document.searchForm.submit();
}
function changeS(obj, userId,userName) {
    dwr.engine.setAsync(false);
    var flag = false;
    UserBo.changeUser(userId, function (data) {
        flag = data;
    });
    if (flag) {
        var d;
        if (obj.innerHTML.trim() == '是') {
            d = '否';
        } else {
            d = '是';
        }
        ymPrompt.alert('更改用户（' + userName + '）超期扫描状态为"' + d + '"！', 330, 220, '提示信息', function () {
            obj.innerHTML = d;
        });
    } else {
        ymPrompt.alert('更改用户（' + userName + '）超期扫描失败，请稍后再试！', 330, 220, '提示信息');
    }

}