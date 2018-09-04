function checkForm() {
    var name = $("#usergroupName");
    var memo = $("#usergroupMemo");
    if (isEmpty(name.val())) {
        ymPrompt.alert('�����������ƣ�', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                name.focus();
            }
        });

        return false;

    } else {
        var specialChar = CheckSpecialChar(name.val(), special_char.username);
        if (specialChar) {
            ymPrompt.alert('�����Ʋ��ܰ���' + specialChar + '�ַ���', 330, 220, '��ʾ��Ϣ', function (data) {
                if (data == "ok") {
                    name.focus();
                }
            });

            return false;
        }
    }

    if (isEmpty(memo.val())) {
        ymPrompt.alert('��������ϸ������', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                memo.focus();
            }
        });

        return false;

    } else {

        var specialChar = CheckSpecialChar(memo.val(), special_char.passwd);
        if (specialChar) {
            ymPrompt.alert('��ϸ�������ܰ���' + specialChar + '�ַ���', 330, 220, '��ʾ��Ϣ', function (data) {
                if (data == "ok") {
                    memo.focus();
                }
            });

            return false;
        }
        if (memo.val().realLength() > 500) {
            memo.val(memo.val().zh_substr(0, 500));
            ymPrompt.alert({message: '��ϸ����̫�����������ó���500���ַ���250�����֣�', width: 330, height: 220, title: '��ʾ��Ϣ'});
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
        $("#groupDiv").html('<span style="color: red; ">�����������ƣ�</span>');
        name.focus();
        return false;

    } else {
        var specialChar = CheckSpecialChar(name.val(), special_char.username);
        if (specialChar) {
            $("#groupDiv").html('<span style="color: red; ">�����Ʋ��ܰ���' + specialChar + '�ַ���</span>');
            name.focus();
            return false;
        }
    }
    var id = $("#usergroupId");
    UserGroupBo.isExistName(name.val(), id ? id.val() : null, doChackName);

}

function doChackName(result) {

    //alert(result);
    if (result) {//�Ѿ�����
        $("#groupDiv").html('<span style="color: red; ">�������Ѿ���ʹ�ã�������ѡ��</span>');
        $("#usergroupName").focus();
        $("#saveButton").attr("disabled", true);

    } else {
        $("#groupDiv").html('<span style="color: green; ">�����ƿ��ã�</span>');
        $("#saveButton").attr("disabled", false);
    }
    checkName = "1";
}
function resetValue() {
    checkName = "0";
    $("#saveButton").attr("disabled", false);
}