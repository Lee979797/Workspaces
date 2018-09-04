function checkForm() {
    var roleName = $("#roleName");
    var roleMemo = $("#roleMemo");

    if (isEmptys(roleName.val())) {


        ymPrompt.alert('�������ɫ���ƣ�', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                roleName.focus();
            }
        });
        return false;

    } else {
        var specialChar = CheckSpecialChar(roleName.val(), special_char.username);
        if (specialChar) {
            ymPrompt.alert('��ɫ���Ʋ��ܰ���' + specialChar + '�ַ���', 330, 220, '��ʾ��Ϣ', function (data) {
                if (data == "ok") {
                    roleName.focus();
                }
            });

            return false;
        }
    }

    if (isEmptys(roleMemo.val())) {

        ymPrompt.alert('��������ϸ������', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                roleMemo.focus();
            }
        });

        return false;

    } else {

        var specialChar = CheckSpecialChar(roleMemo.val(), special_char.passwd);
        if (specialChar) {
            ymPrompt.alert('��ϸ�������ܰ���' + specialChar + '�ַ���', 330, 220, '��ʾ��Ϣ', function (data) {
                if (data == "ok") {
                    roleMemo.focus();
                }
            });

            return false;
        } else {
            if (roleMemo.val().length > 50) {
                ymPrompt.alert('��ϸ�������ö���50���ַ���', 330, 220, '��ʾ��Ϣ', function (data) {
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

        $("#roleDiv").html("<span style='color: red; '>�������ɫ���ƣ�</span>");
        roleName.focus();
        return false;

    } else {
        var specialChar = CheckSpecialChar(roleName.val(), special_char.username);
        if (specialChar) {
            $("#roleDiv").html("<span style='color: red; '>��ɫ���Ʋ��ܰ���" + specialChar + "�ַ���</span>");
            roleName.focus();
            return false;
        }
    }

    RoleBo.isExistRoleName(roleName.val(), roleId ? roleId.val() : null, doChackName);
}

function doChackName(result) {
    if (result) {//�Ѿ�����
        $("#roleDiv").html("<span style='color: red; '>��ɫ�����Ѿ���ʹ�ã�������ѡ��</span>");
        $("#roleName").focus();
        $("#saveButton").attr("disabled", true);
    } else {
        $("#roleDiv").html("<span style='color: green; '>��ɫ���ƿ��ã�</span>");
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
