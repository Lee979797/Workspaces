function checkForm(actions) {
    var name = $("#userName");
    var selectIndex = document.getElementById("bzjgdm").selectedIndex;//����ǵڼ�����ѡ����
    var selectText = document.getElementById("bzjgdm").options[selectIndex].text //��ñ�ѡ�е���Ŀ���ı�
    //var sect=document.getElementById("zrxzqu").options;
    $("#printName").val(selectText);
    if (actions != "mod") {
        if (isEmpty(name.val())) {
            ymPrompt.alert('�������û�����', 330, 220, '��ʾ��Ϣ', function (data) {
                if (data == "ok") {
                    name.focus();
                }
            });

            return false;

        } else {
            var specialChar = CheckSpecialChar(name.val(), special_char.username);
            if (specialChar) {
                ymPrompt.alert('�û������ܰ���' + specialChar + '�ַ���', 330, 220, '��ʾ��Ϣ', function (data) {
                    if (data == "ok") {
                        name.focus();
                    }
                });
                return false;
            }
        }


        if (isEmpty(userForm.user_password1.value)) {
            ymPrompt.alert('���������룡', 330, 220, '��ʾ��Ϣ', function (data) {
                if (data == "ok") {
                    userForm.user_password1.focus();
                }
            });

            return false;

        } else {

            var specialChar = CheckSpecialChar(userForm.user_password1.value, special_char.passwd);
            if (specialChar) {
                ymPrompt.alert('���벻�ܰ���' + specialChar + '�ַ���', 330, 220, '��ʾ��Ϣ', function (data) {
                    if (data == "ok") {
                        userForm.user_password1.focus();
                    }
                });


                return false;
            }
            if (userForm.user_password1.value.length < 6) {
                ymPrompt.alert('����������벻������6���ַ���', 330, 220, '��ʾ��Ϣ', function (data) {
                    if (data == "ok") {
                        userForm.user_password1.focus();
                    }
                });

                return false;

            }

        }

        if (isEmpty(userForm.user_password2.value)) {
            ymPrompt.alert('������ȷ�����룡', 330, 220, '��ʾ��Ϣ', function (data) {
                if (data == "ok") {
                    userForm.user_password2.focus();
                }
            });

            return false;

        } else {

            var specialChar = CheckSpecialChar(userForm.user_password2.value, special_char.passwd);
            if (specialChar) {
                ymPrompt.alert('ȷ�����벻�ܰ���' + specialChar + '�ַ���', 330, 220, '��ʾ��Ϣ', function (data) {
                    if (data == "ok") {
                        userForm.user_password2.focus();
                    }
                });

                return false;
            }

        }

        if (userForm.user_password1.value != userForm.user_password2.value) {
            ymPrompt.alert('�������벻һ�£����������룡', 330, 220, '��ʾ��Ϣ', function (data) {
                if (data == "ok") {
                    userForm.user_password1.focus();
                }
            });

            return false;
        }
    }

    if (isEmpty(userForm.userChinesename.value)) {
        ymPrompt.alert('������������', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                userForm.userChinesename.focus();
            }
        });

        return false;

    } else {
        if (userForm.userChinesename.value.length > 10) {
            ymPrompt.alert('���������������̫�����뱣����10���ַ��ڣ�', 330, 220, '��ʾ��Ϣ', function (data) {
                if (data == "ok") {
                    userForm.userChinesename.focus();
                }
            });

            return false;
        }
        var specialChar = CheckSpecialChar(userForm.userChinesename.value, special_char.username);
        if (specialChar) {
            ymPrompt.alert('�������ܰ���' + specialChar + '�ַ���', 330, 220, '��ʾ��Ϣ', function (data) {
                if (data == "ok") {
                    userForm.userChinesename.focus();
                }
            });

            return false;
        }
    }

/*
    if (isEmpty(userForm.userLostpwshow.value)) {
        ymPrompt.alert('�����������ѯ���⣡', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                userForm.userLostpwshow.focus();
            }
        });

        return false;

    } else {
        var specialChar = CheckSpecialChar(userForm.userLostpwshow.value, special_char.username);
        if (specialChar) {
            ymPrompt.alert('�����ѯ���ⲻ�ܰ���' + specialChar + '�ַ���', 330, 220, '��ʾ��Ϣ', function (data) {
                if (data == "ok") {
                    userForm.userLostpwshow.focus();
                }
            });

            return false;
        }

    }

    if (isEmpty(userForm.userShowproblem.value)) {
        ymPrompt.alert('�����������ѯ�𰸣�', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                userForm.userShowproblem.focus();
            }
        });

        return false;

    } else {
        var specialChar = CheckSpecialChar(userForm.userShowproblem.value, special_char.username);
        if (specialChar) {
            ymPrompt.alert('�����ѯ�𰸲��ܰ���' + specialChar + '�ַ���', 330, 220, '��ʾ��Ϣ', function (data) {
                if (data == "ok") {
                    userForm.userShowproblem.focus();
                }
            });

            return false;
        }
    }

    if (userForm.userLostpwshow.value == "0") {
        if (userForm.userlostpwshow.value == userForm.userShowproblem.value) {
            ymPrompt.alert('�����ѯ�𰸲����������ѯ����һ�£�', 330, 220, '��ʾ��Ϣ', function (data) {
                if (data == "ok") {
                    userForm.userShowproblem.focus();
                }
            });

            return false;
        }

    }
    else {
        if (userForm.userLostpwshow.value == userForm.userShowproblem.value) {
            ymPrompt.alert('�����ѯ�𰸲����������ѯ����һ�£�', 330, 220, '��ʾ��Ϣ', function (data) {
                if (data == "ok") {
                    userForm.userShowproblem.focus();
                }
            });

            return false;
        }
    }

    if (!isEmpty(userForm.userIp.value)) {
        if (!isIP(userForm.userIp.value)) {
            ymPrompt.alert('IP��ʽ����ȷ��', 330, 220, '��ʾ��Ϣ', function (data) {
                if (data == "ok") {
                    userForm.userIp.focus();
                }
            });

            return false;
        }
    }
*/

    /*if(!isEmpty($("#CalendarSelector2").value)){

     var birthday = $("#CalendarSelector2").value;
     var dateArr = getCurrentDate();
     //var sysDate = dateArr[0]+"-"+dateArr[1]+"-"+dateArr[2];
     if(checkIsValidDate(birthday)){
     if(birthday.length==7){
     birthday = birthday+"-01";
     }
     if(checkDateEarlier(birthday,dateArr)>0){
     ymPrompt.alert('�������ڲ��ܴ��ڵ�ǰ���ڣ�',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){ userForm.userBirthday.focus();}});

     userForm.userBirthday.focus();
     return false;
     }
     //return true;
     }else{
     ymPrompt.alert('�������ڸ�ʽ����',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){ userForm.userBirthday.focus();}});
     userForm.userBirthday.focus();
     return false;
     }
     }else{
     ymPrompt.alert('������������ڣ�',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){ userForm.userBirthday.focus();}});

     userForm.userBirthday.focus();
     return false;
     }


    if (!isEmpty(userForm.userFax.value)) {
        if (!isNumber(userForm.userFax.value)) {
            //ymPrompt.alert('�����ʽ����ȷ��',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){ userForm.userFax.focus();}});

            //return false;
        }
    }
    */
    if (isEmpty(userForm.usergroupId.value)) {

        ymPrompt.alert('��ѡ���û��飡', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                userForm.user_branch.focus();
            }
        });

        return false;
    }


   /* if (isEmpty(userForm.firstXzqh.value)) {
        ymPrompt.alert('��ѡ��ʡ���ģ�', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                userForm.province.focus();
            }
        });
        return false;
    }
*/
    /* if (isEmpty(userForm.userClass.value)) {
    	ymPrompt.alert('��ѡ�񼶱�', 330, 220, '��ʾ��Ϣ', function (data) {
    		if (data == "ok") {
    			userForm.userClass.focus();
    		}
    	});
    	return false;
    }*/
    if (isEmpty(userForm.zrxzqu.value)) {
        ymPrompt.alert('��ѡ������������', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                userForm.twoXzqh.focus();
            }
        });
        return false;
    }
    if (isEmpty(userForm.bzjgdm.value)) {
    	ymPrompt.alert('��ѡ����׼�������ƣ�', 330, 220, '��ʾ��Ϣ', function (data) {
    		if (data == "ok") {
    			userForm.zrxzqu.focus();
    		}
    	});
    	return false;
    }

//	if(isEmpty(userForm.bzjgdm.value)){
//
//		ymPrompt.alert('��ѡ��������֤�㣡',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){ userForm.province.focus();}});
//
//			return false;
//	}


    /*  if (!isEmpty(userForm.userPostid.value)) {
        if (!isPostCode(userForm.userPostid.value)) {
            ymPrompt.alert('���������ʽ����ȷ��', 330, 220, '��ʾ��Ϣ', function (data) {
                if (data == "ok") {
                    userForm.userPostid.focus();
                }
            });

            return false;
        }
    }
*/

    if (!isEmpty(userForm.userMobile.value)) {
        if (!isNumber(userForm.userMobile.value)) {
            ymPrompt.alert('�ֻ���ʽ����ȷ��', 330, 220, '��ʾ��Ϣ', function (data) {
                if (data == "ok") {
                    userForm.userMobile.focus();
                }
            });

            return false;
        }
    }
/*
    if (!isEmpty(userForm.userPhone.value)) {
        var str = userForm.userPhone.value;
        //var reg=/(^[0-9]{3,4}\-[0-9]{7,8}$)|(^[0-9]{7,8}$)|(^\([0-9]{3,4}\)[0-9]{3,8}$)|(^0{0,1}13[0-9]{9}$)/;
        var reg = /^((0\d{2,3})-)(\d{7,8})(-(\d{2,}))?$/;

        if (reg.test(str) == false) {
            //ymPrompt.alert('�绰��ʽ����ȷ��',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){ userForm.userPhone.focus();}});

            //return false;
        }
    }
*/
    if (!isEmpty(userForm.userEmail.value)) {

        if (!checkEmail(userForm.userEmail.value)) {
            ymPrompt.alert('���������ʽ����ȷ��', 330, 220, '��ʾ��Ϣ', function (data) {
                if (data == "ok") {
                    userForm.userEmail.focus();
                }
            });

            return false;
        }
    }
    document.getElementById('saveButton').disabled = true;
    userForm.submit();
    //}
}


function initPassword() {

    if (isEmpty(userForm.user_password1.value)) {
        ymPrompt.alert('�����������룡', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                userForm.user_password1.focus();
            }
        });

        return false;

    } else {

        var specialChar = CheckSpecialChar(userForm.user_password1.value, special_char.passwd);
        if (specialChar) {
            ymPrompt.alert('���벻�ܰ���' + specialChar + '�ַ���', 330, 220, '��ʾ��Ϣ', function (data) {
                if (data == "ok") {
                    userForm.user_password1.focus();
                }
            });

            return false;
        }
        if (userForm.user_password1.value.length < 6) {
            ymPrompt.alert('����������벻������6���ַ���', 330, 220, '��ʾ��Ϣ', function (data) {
                if (data == "ok") {
                    userForm.user_password1.focus();
                }
            });

            return false;

        }
    }

    if (isEmpty(userForm.user_password2.value)) {
        ymPrompt.alert('������ȷ�������룡', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                userForm.user_password2.focus();
            }
        });

        return false;

    } else {

        var specialChar = CheckSpecialChar(userForm.user_password2.value, special_char.passwd);
        if (specialChar) {
            ymPrompt.alert('ȷ�����벻�ܰ���' + specialChar + '�ַ���', 330, 220, '��ʾ��Ϣ', function (data) {
                if (data == "ok") {
                    userForm.user_password2.focus();
                }
            });

            return false;
        }
    }

    if (userForm.user_password1.value != userForm.user_password2.value) {
        ymPrompt.alert('�������벻һ�£����������룡', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                userForm.user_password1.focus();
            }
        });

        return false;
    }

    userForm.submit();

}

function modPassword() {

    if (isEmpty(userForm.user_password.value)) {
        ymPrompt.alert('�����������룡', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                userForm.user_password.focus();
            }
        });


        return false;

    } else {

        var specialChar = CheckSpecialChar(userForm.user_password.value, special_char.passwd);
        if (specialChar) {
            ymPrompt.alert('���벻�ܰ���' + specialChar + '�ַ���', 330, 220, '��ʾ��Ϣ', function (data) {
                if (data == "ok") {
                    userForm.user_password.focus();
                }
            });

            return false;
        }
    }

    if (isEmpty(userForm.user_password1.value)) {
        ymPrompt.alert('�����������룡', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                userForm.user_password1.focus();
            }
        });


        return false;

    } else {

        var specialChar = CheckSpecialChar(userForm.user_password1.value, special_char.passwd);
        if (specialChar) {
            ymPrompt.alert('���벻�ܰ���' + specialChar + '�ַ���', 330, 220, '��ʾ��Ϣ', function (data) {
                if (data == "ok") {
                    userForm.user_password1.focus();
                }
            });

            return false;
        }
    }

    if (isEmpty(userForm.user_password2.value)) {
        ymPrompt.alert('������ȷ�������룡', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                userForm.user_password2.focus();
            }
        });

        return false;

    } else {

        var specialChar = CheckSpecialChar(userForm.user_password2.value, special_char.passwd);
        if (specialChar) {
            ymPrompt.alert('ȷ�����벻�ܰ���' + specialChar + '�ַ���', 330, 220, '��ʾ��Ϣ', function (data) {
                if (data == "ok") {
                    userForm.user_password2.focus();
                }
            });

            return false;
        }
    }

    if (userForm.user_password1.value != userForm.user_password2.value) {
        ymPrompt.alert('�������벻һ�£����������룡', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                userForm.user_password1.focus();
            }
        });

        return false;
    }

    userForm.submit();

}
var isname = false;
var isemail = false;
function checkName() {
    var name = $("#userName");
    var userId = $("#userId");
    if (isEmpty(name.val())) {
        $("#userDiv").css('color', 'red').html('�������û�����');
        return false;

    } else {
        var specialChar = CheckSpecialChar(name.val(), special_char.username);
        if (specialChar) {
            $("#userDiv").css('color', 'red').html('�û������ܰ���' + specialChar + '�ַ���');
            return false;
        }
    }
    UserBus.isExistUsername(name.val(), userId ? userId.val() : null, doChackName);
}

function doChackName(result) {
    if (result) {
        $("#userDiv").css('color', 'red').html('�û����Ѿ���ʹ�ã�������ѡ��');
        $("#saveButton").attr("disabled", true);

    } else {
        $("#userDiv").css('color', 'green').html('�û������ã�');
        isname = true;
        $("#saveButton").attr("disabled", false);
    }

}

function checkPassword2(userPwd2) {

    if (isEmpty(userForm.user_password2.value)) {

        $("#pwd2Div").html("<font color='red'>������ȷ�����룡</FONT>");
        //userForm.user_password2.focus();
        return false;

    } else {
        if (userForm.user_password1.value != userForm.user_password2.value) {

            $("#pwd2Div").html("<font color='red'>�������벻һ�£����������룡</font>");
            $("#user_password2").focus();
            $("#saveButton").attr("disabled", true);

        } else {
            $("#pwd2Div").html("<font color='green'>��������һ�£�</font>");
            $("#saveButton").attr("disabled", false);
        }

    }

}


function checkblogName(status) {
    var name = $("#userName");
    if (status == 1) {
        if (isEmpty(name.val())) {
            this.checked = false;
            $("#userDiv").css('color', 'red').html('�������û�����');
            name.focus();
            return false;
        } else {
            $("#blogUrl").val("http://" + window.location.host + "/blog/" + name.val());
            $("#blogUrl").css("display", "block");
        }
    } else if (status == 0) {
        $("#blogUrl").css("display", "none");
    }
}

function valifyEmail(user_id) {
    dwr.engine.setAsync(false);
    var email = $("#userEmail");
    if (!isEmpty(email.val())) {
        var reg2 = /^([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{1,3}$/;
        if (!reg2.test(email.val())) {
            $("#userEmailInfo").css('color', 'red').html('�������������Ϲ淶,���磺test@yahoo.com��');
            $("#saveButton").attr("disabled", true);
            return false;
        }
    }
    if (!user_id)
        user_id = null;
    var flag = true;
    UserBus.isExistUserEmail(email.val(), user_id, function (result) {
        flag = result;

    });
    if (flag) {
        $("#userEmailInfo").css('color', 'red').html('�ʼ���ַ�Ѿ���ʹ�ã�');
        $("#saveButton").attr("disabled", true);
        return false;
    } else {
        $("#userEmailInfo").css("color", "green").html("�ʼ���ַ���ã�");
        isemail = true;
        $("#saveButton").attr("disabled", false);
        return true;
    }
}

function changetext(option) {
    var uXzqh = $("#threeXzqh");
    var text = $("#dbdiv");

    var dmId = option.value;

    dwr.engine.setAsync(false);
    ProvinceBus.IsExistTwo(dmId, {callback: function (citys) {
        if (citys == false) {
            uXzqh.val('0000');
        }
    }});
    dwr.engine.setAsync(true);

    if (uXzqh.length > 0) {
        text.css("display", 'none');
    } else {
        text.css("display", 'inline');

    }

}


function checkPwshow() {

    if ($("#userLostpwshow").val() == "0") {
        //
        $("#userlostpwshow").css("display", 'block');

    } else {
        $("#userlostpwshow").css("display", 'none');
    }
}
$(function () {
    $("#userIp").bind("blur", function () {
        if (isIP(this.value)) {
            $("#ipInfo").css("color", "green").html("IP��ַ��ȷ��");
            return true;
        } else {
            $("#ipInfo").css("color", "red").html("��������ȷ��IP��ַ�����磺192.168.0.1��");

            return false;
        }
    });
    $("#userCardid").bind("blur", function () {
        if (Tools.isIdentify(this.value)) {
            $("#cardIdInfo").css("color", "green").html("���֤����ȷ��");
            return true;
        } else {
            $("#cardIdInfo").css("color", "red").html("��������ȷ�����֤�ţ�");

            return false;
        }
    });
    $("#userFax").bind("blur", function () {
        if (isFax(this.value)) {
            $("#userFaxInfo").css("color", "green").html("���������ȷ��");
            return true;
        } else {
            $("#userFaxInfo").css("color", "red").html("��������ȷ�Ĵ������,����:010-88888888��");
            return false;
        }
    });
    $("#userPhone").bind("blur", function () {
        if (isTel(this.value)) {
            $("#userPhoneInfo").css("color", "green").html("�绰������ȷ��");
            return true;
        } else {
            $("#userPhoneInfo").css("color", "red").html("��������ȷ�ĵ绰����,����:010-88888888��");
            return false;
        }
    });
    $("#userMobile").bind("blur", function () {
        if (isPhone(this.value)) {
            $("#userMobileInfo").css("color", "green").html("�ֻ�������ȷ��");
            return true;
        } else {
            $("#userMobileInfo").css("color", "red").html("��������ȷ���ֻ�����,����:13011111111��");

            return false;
        }
    });
    $("#userPostid").bind("blur", function () {
        if (isPost(this.value)) {
            $("#userPostidInfo").css("color", "green").html("����������ȷ��");
            return true;
        } else {
            $("#userPostidInfo").css("color", "red").html("��������ȷ����������,����:100100!");

            return false;
        }
    });

});
