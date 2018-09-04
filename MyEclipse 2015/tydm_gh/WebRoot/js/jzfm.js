function ajaxCode(busForm) {
    var code = null;
    var data = {
        stype: 'only-text',
        'code-type': busForm.codetype.value,
        'flag': busForm.flag.value,
        'org-name': busForm.orgname.value,
        'reg-num': busForm.regnum.value,
        'org-address': busForm.orgaddress.value
    };
    $.ajax({
        type: 'post',//可选get
        url: '/code/assign',//这里是接收数据的程序
        data: data, success: function (data) {
            if (data == undefined || data == null || '' == data) {
                busForm.success.value = "error";
                return;
            }

            code = data.code;
            flag = data.flag;
            if ('0' == flag) {
                busForm.code.value = code;

            }

            if ('1' == flag) {
                busForm.code.value = 'ysfm';

            }
            if ('2' == flag) {
                busForm.code.value = 'cffm';
            }
            if ('3' == flag) {
                busForm.code.value = 'qmsb';
            }
        }});

}
function confm(busForm) {
    $.ajax({
        type: 'post',//可选get
        url: '/code/assign',//这里是接收数据的程序,
        data: {
            stype: 'confirm',
            'user-name': busForm.username.value,
            'password': busForm.password.value,
            'code': busForm.code.value
        }, success: function (data) {
            if (data == undefined || data == null || '' == data) {
                busForm.success.value = "error";
                return;
            }
            if ('0' == data.flag) {
                busForm.success.value = 'success';
            } else {
                busForm.success.value = 'error';
            }
        }});


}