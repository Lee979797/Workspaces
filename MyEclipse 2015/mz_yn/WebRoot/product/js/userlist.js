/**
 * Created by IntelliJ IDEA.
 * User: jun
 * Date: 11-8-30
 * Time: ����2:45
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
        ymPrompt.alert('��ѯ�ؼ��ֲ��ܰ���' + specialChar + '�ַ���', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                searchForm.searchValue.focus();
            }
        });
        return false;
    }
    if (!isNumber(document.searchForm.pageno.value)) {

        ymPrompt.alert('���������֣�', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                searchForm.pageno.focus();
            }
        });
        return false;
    } else {
        var pageCount = parseInt(document.getElementById("totalPages").value);
        if (document.searchForm.pageno.value > pageCount) {

            ymPrompt.alert('�������ֲ��ܴ�����ҳ����', 330, 220, '��ʾ��Ϣ', function (data) {
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
        if (obj.innerHTML.trim() == '��') {
            d = '��';
        } else {
            d = '��';
        }
        ymPrompt.alert('�����û���' + userName + '������ɨ��״̬Ϊ"' + d + '"��', 330, 220, '��ʾ��Ϣ', function () {
            obj.innerHTML = d;
        });
    } else {
        ymPrompt.alert('�����û���' + userName + '������ɨ��ʧ�ܣ����Ժ����ԣ�', 330, 220, '��ʾ��Ϣ');
    }

}