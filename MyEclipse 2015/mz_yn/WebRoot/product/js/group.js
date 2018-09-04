function checkForm() {
    var name = $("#usergroupName");
    var memo = $("#usergroupMemo");
    if (isEmpty(name.val())) {
        ymPrompt.alert('请输入组名称！', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                name.focus();
            }
        });

        return false;

    } else {
        var specialChar = CheckSpecialChar(name.val(), special_char.username);
        if (specialChar) {
            ymPrompt.alert('组名称不能包含' + specialChar + '字符！', 330, 220, '提示信息', function (data) {
                if (data == "ok") {
                    name.focus();
                }
            });

            return false;
        }
    }

    if (isEmpty(memo.val())) {
        ymPrompt.alert('请输入详细描述！', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                memo.focus();
            }
        });

        return false;

    } else {

        var specialChar = CheckSpecialChar(memo.val(), special_char.passwd);
        if (specialChar) {
            ymPrompt.alert('详细描述不能包含' + specialChar + '字符！', 330, 220, '提示信息', function (data) {
                if (data == "ok") {
                    memo.focus();
                }
            });

            return false;
        }
        if (memo.val().realLength() > 500) {
            memo.val(memo.val().zh_substr(0, 500));
            ymPrompt.alert({message: '详细描述太长，字数不得超过500个字符或250个汉字！', width: 330, height: 220, title: '提示信息'});
            return false;
        }
    }
    $("#saveButton").attr("disabled", true);
    groupForm.submit();
}

function dosome() {
}
var checkName = "0";
function checkGroupName() {
    var name = $("#usergroupName");
    if (isEmpty(name.val())) {
        $("#groupDiv").html('<span style="color: red; ">请输入组名称！</span>');
        name.focus();
        return false;

    } else {
        var specialChar = CheckSpecialChar(name.val(), special_char.username);
        if (specialChar) {
            $("#groupDiv").html('<span style="color: red; ">组名称不能包含' + specialChar + '字符！</span>');
            name.focus();
            return false;
        }
    }
    var id = $("#usergroupId");
    UserGroupBo.isExistName(name.val(), id ? id.val() : null, doChackName);

}

function doChackName(result) {

    //alert(result);
    if (result) {//已经存在
        $("#groupDiv").html('<span style="color: red; ">组名称已经被使用，请重新选择！</span>');
        $("#usergroupName").focus();
        $("#saveButton").attr("disabled", true);

    } else {
        $("#groupDiv").html('<span style="color: green; ">组名称可用！</span>');
        $("#saveButton").attr("disabled", false);
    }
    checkName = "1";
}
function resetValue() {
    checkName = "0";
    $("#saveButton").attr("disabled", false);
}