function checkForm() {
    var roleName = $("#roleName");
    var roleMemo = $("#roleMemo");

    if (isEmptys(roleName.val())) {


        ymPrompt.alert('请输入角色名称！', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                roleName.focus();
            }
        });
        return false;

    } else {
        var specialChar = CheckSpecialChar(roleName.val(), special_char.username);
        if (specialChar) {
            ymPrompt.alert('角色名称不能包含' + specialChar + '字符！', 330, 220, '提示信息', function (data) {
                if (data == "ok") {
                    roleName.focus();
                }
            });

            return false;
        }
    }

    if (isEmptys(roleMemo.val())) {

        ymPrompt.alert('请输入详细描述！', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                roleMemo.focus();
            }
        });

        return false;

    } else {

        var specialChar = CheckSpecialChar(roleMemo.val(), special_char.passwd);
        if (specialChar) {
            ymPrompt.alert('详细描述不能包含' + specialChar + '字符！', 330, 220, '提示信息', function (data) {
                if (data == "ok") {
                    roleMemo.focus();
                }
            });

            return false;
        } else {
            if (roleMemo.val().length > 50) {
                ymPrompt.alert('详细描述不得多于50个字符！', 330, 220, '提示信息', function (data) {
                    if (data == "ok") {
                        roleMemo.focus();
                    }
                });

                return false;
            }
        }
    }
    $("#saveButton").attr("disabled", true);
    roleForm.submit();
}

function dosome() {
}
var checkName = "0";
function checkRoleName() {
    var roleName = $("#roleName");
    var roleId = $("#roleId");
    if (isEmpty(roleName.val())) {

        $("#roleDiv").html("<span style='color: red; '>请输入角色名称！</span>");
        roleName.focus();
        return false;

    } else {
        var specialChar = CheckSpecialChar(roleName.val(), special_char.username);
        if (specialChar) {
            $("#roleDiv").html("<span style='color: red; '>角色名称不能包含" + specialChar + "字符！</span>");
            roleName.focus();
            return false;
        }
    }

    RoleBo.isExistRoleName(roleName.val(), roleId ? roleId.val() : null, doChackName);
}

function doChackName(result) {
    if (result) {//已经存在
        $("#roleDiv").html("<span style='color: red; '>角色名称已经被使用，请重新选择！</span>");
        $("#roleName").focus();
        $("#saveButton").attr("disabled", true);
    } else {
        $("#roleDiv").html("<span style='color: green; '>角色名称可用！</span>");
        $("#saveButton").attr("disabled", false);
    }
    checkName = "1";
}
function resetValue() {
    checkName = "0";
    $("#saveButton").attr("disabled", false);
}
function isEmptys(str) {
    if (str == null || (str.Trim() == null) || (str.Trim().length == 0)) return true;
    else return(false);
}
