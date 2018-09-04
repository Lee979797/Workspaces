function checkForm(actions) {
    var name = $("#userName");
    var selectIndex = document.getElementById("bzjgdm").selectedIndex;//获得是第几个被选中了
    var selectText = document.getElementById("bzjgdm").options[selectIndex].text //获得被选中的项目的文本
    //var sect=document.getElementById("zrxzqu").options;
    $("#printName").val(selectText);
    if (actions != "mod") {
        if (isEmpty(name.val())) {
            ymPrompt.alert('请输入用户名！', 330, 220, '提示信息', function (data) {
                if (data == "ok") {
                    name.focus();
                }
            });

            return false;

        } else {
            var specialChar = CheckSpecialChar(name.val(), special_char.username);
            if (specialChar) {
                ymPrompt.alert('用户名不能包含' + specialChar + '字符！', 330, 220, '提示信息', function (data) {
                    if (data == "ok") {
                        name.focus();
                    }
                });
                return false;
            }
        }


        if (isEmpty(userForm.user_password1.value)) {
            ymPrompt.alert('请输入密码！', 330, 220, '提示信息', function (data) {
                if (data == "ok") {
                    userForm.user_password1.focus();
                }
            });

            return false;

        } else {

            var specialChar = CheckSpecialChar(userForm.user_password1.value, special_char.passwd);
            if (specialChar) {
                ymPrompt.alert('密码不能包含' + specialChar + '字符！', 330, 220, '提示信息', function (data) {
                    if (data == "ok") {
                        userForm.user_password1.focus();
                    }
                });


                return false;
            }
            if (userForm.user_password1.value.length < 6) {
                ymPrompt.alert('您输入的密码不能少于6个字符！', 330, 220, '提示信息', function (data) {
                    if (data == "ok") {
                        userForm.user_password1.focus();
                    }
                });

                return false;

            }

        }

        if (isEmpty(userForm.user_password2.value)) {
            ymPrompt.alert('请输入确认密码！', 330, 220, '提示信息', function (data) {
                if (data == "ok") {
                    userForm.user_password2.focus();
                }
            });

            return false;

        } else {

            var specialChar = CheckSpecialChar(userForm.user_password2.value, special_char.passwd);
            if (specialChar) {
                ymPrompt.alert('确认密码不能包含' + specialChar + '字符！', 330, 220, '提示信息', function (data) {
                    if (data == "ok") {
                        userForm.user_password2.focus();
                    }
                });

                return false;
            }

        }

        if (userForm.user_password1.value != userForm.user_password2.value) {
            ymPrompt.alert('密码输入不一致，请重新输入！', 330, 220, '提示信息', function (data) {
                if (data == "ok") {
                    userForm.user_password1.focus();
                }
            });

            return false;
        }
    }

    if (isEmpty(userForm.userChinesename.value)) {
        ymPrompt.alert('请输入姓名！', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                userForm.userChinesename.focus();
            }
        });

        return false;

    } else {
        if (userForm.userChinesename.value.length > 10) {
            ymPrompt.alert('您输入的中文名称太长，请保持在10个字符内！', 330, 220, '提示信息', function (data) {
                if (data == "ok") {
                    userForm.userChinesename.focus();
                }
            });

            return false;
        }
        var specialChar = CheckSpecialChar(userForm.userChinesename.value, special_char.username);
        if (specialChar) {
            ymPrompt.alert('姓名不能包含' + specialChar + '字符！', 330, 220, '提示信息', function (data) {
                if (data == "ok") {
                    userForm.userChinesename.focus();
                }
            });

            return false;
        }
    }

/*
    if (isEmpty(userForm.userLostpwshow.value)) {
        ymPrompt.alert('请输入密码查询问题！', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                userForm.userLostpwshow.focus();
            }
        });

        return false;

    } else {
        var specialChar = CheckSpecialChar(userForm.userLostpwshow.value, special_char.username);
        if (specialChar) {
            ymPrompt.alert('密码查询问题不能包含' + specialChar + '字符！', 330, 220, '提示信息', function (data) {
                if (data == "ok") {
                    userForm.userLostpwshow.focus();
                }
            });

            return false;
        }

    }

    if (isEmpty(userForm.userShowproblem.value)) {
        ymPrompt.alert('请输入密码查询答案！', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                userForm.userShowproblem.focus();
            }
        });

        return false;

    } else {
        var specialChar = CheckSpecialChar(userForm.userShowproblem.value, special_char.username);
        if (specialChar) {
            ymPrompt.alert('密码查询答案不能包含' + specialChar + '字符！', 330, 220, '提示信息', function (data) {
                if (data == "ok") {
                    userForm.userShowproblem.focus();
                }
            });

            return false;
        }
    }

    if (userForm.userLostpwshow.value == "0") {
        if (userForm.userlostpwshow.value == userForm.userShowproblem.value) {
            ymPrompt.alert('密码查询答案不能与密码查询问题一致！', 330, 220, '提示信息', function (data) {
                if (data == "ok") {
                    userForm.userShowproblem.focus();
                }
            });

            return false;
        }

    }
    else {
        if (userForm.userLostpwshow.value == userForm.userShowproblem.value) {
            ymPrompt.alert('密码查询答案不能与密码查询问题一致！', 330, 220, '提示信息', function (data) {
                if (data == "ok") {
                    userForm.userShowproblem.focus();
                }
            });

            return false;
        }
    }

    if (!isEmpty(userForm.userIp.value)) {
        if (!isIP(userForm.userIp.value)) {
            ymPrompt.alert('IP格式不正确！', 330, 220, '提示信息', function (data) {
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
     ymPrompt.alert('出生日期不能大于当前日期！',330,220,'提示信息',function(data){if(data == "ok"){ userForm.userBirthday.focus();}});

     userForm.userBirthday.focus();
     return false;
     }
     //return true;
     }else{
     ymPrompt.alert('出生日期格式有误！',330,220,'提示信息',function(data){if(data == "ok"){ userForm.userBirthday.focus();}});
     userForm.userBirthday.focus();
     return false;
     }
     }else{
     ymPrompt.alert('请输入出生日期！',330,220,'提示信息',function(data){if(data == "ok"){ userForm.userBirthday.focus();}});

     userForm.userBirthday.focus();
     return false;
     }


    if (!isEmpty(userForm.userFax.value)) {
        if (!isNumber(userForm.userFax.value)) {
            //ymPrompt.alert('传真格式不正确！',330,220,'提示信息',function(data){if(data == "ok"){ userForm.userFax.focus();}});

            //return false;
        }
    }
    */
    if (isEmpty(userForm.usergroupId.value)) {

        ymPrompt.alert('请选择用户组！', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                userForm.user_branch.focus();
            }
        });

        return false;
    }


   /* if (isEmpty(userForm.firstXzqh.value)) {
        ymPrompt.alert('请选择省中心！', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                userForm.province.focus();
            }
        });
        return false;
    }
*/
    /* if (isEmpty(userForm.userClass.value)) {
    	ymPrompt.alert('请选择级别！', 330, 220, '提示信息', function (data) {
    		if (data == "ok") {
    			userForm.userClass.focus();
    		}
    	});
    	return false;
    }*/
    if (isEmpty(userForm.zrxzqu.value)) {
        ymPrompt.alert('请选择行政区划！', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                userForm.twoXzqh.focus();
            }
        });
        return false;
    }
    if (isEmpty(userForm.bzjgdm.value)) {
    	ymPrompt.alert('请选择批准机构名称！', 330, 220, '提示信息', function (data) {
    		if (data == "ok") {
    			userForm.zrxzqu.focus();
    		}
    	});
    	return false;
    }

//	if(isEmpty(userForm.bzjgdm.value)){
//
//		ymPrompt.alert('请选择所属办证点！',330,220,'提示信息',function(data){if(data == "ok"){ userForm.province.focus();}});
//
//			return false;
//	}


    /*  if (!isEmpty(userForm.userPostid.value)) {
        if (!isPostCode(userForm.userPostid.value)) {
            ymPrompt.alert('邮政编码格式不正确！', 330, 220, '提示信息', function (data) {
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
            ymPrompt.alert('手机格式不正确！', 330, 220, '提示信息', function (data) {
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
            //ymPrompt.alert('电话格式不正确！',330,220,'提示信息',function(data){if(data == "ok"){ userForm.userPhone.focus();}});

            //return false;
        }
    }
*/
    if (!isEmpty(userForm.userEmail.value)) {

        if (!checkEmail(userForm.userEmail.value)) {
            ymPrompt.alert('电子邮箱格式不正确！', 330, 220, '提示信息', function (data) {
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
        ymPrompt.alert('请输入新密码！', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                userForm.user_password1.focus();
            }
        });

        return false;

    } else {

        var specialChar = CheckSpecialChar(userForm.user_password1.value, special_char.passwd);
        if (specialChar) {
            ymPrompt.alert('密码不能包含' + specialChar + '字符！', 330, 220, '提示信息', function (data) {
                if (data == "ok") {
                    userForm.user_password1.focus();
                }
            });

            return false;
        }
        if (userForm.user_password1.value.length < 6) {
            ymPrompt.alert('您输入的密码不能少于6个字符！', 330, 220, '提示信息', function (data) {
                if (data == "ok") {
                    userForm.user_password1.focus();
                }
            });

            return false;

        }
    }

    if (isEmpty(userForm.user_password2.value)) {
        ymPrompt.alert('请输入确认新密码！', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                userForm.user_password2.focus();
            }
        });

        return false;

    } else {

        var specialChar = CheckSpecialChar(userForm.user_password2.value, special_char.passwd);
        if (specialChar) {
            ymPrompt.alert('确认密码不能包含' + specialChar + '字符！', 330, 220, '提示信息', function (data) {
                if (data == "ok") {
                    userForm.user_password2.focus();
                }
            });

            return false;
        }
    }

    if (userForm.user_password1.value != userForm.user_password2.value) {
        ymPrompt.alert('密码输入不一致，请重新输入！', 330, 220, '提示信息', function (data) {
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
        ymPrompt.alert('请输入老密码！', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                userForm.user_password.focus();
            }
        });


        return false;

    } else {

        var specialChar = CheckSpecialChar(userForm.user_password.value, special_char.passwd);
        if (specialChar) {
            ymPrompt.alert('密码不能包含' + specialChar + '字符！', 330, 220, '提示信息', function (data) {
                if (data == "ok") {
                    userForm.user_password.focus();
                }
            });

            return false;
        }
    }

    if (isEmpty(userForm.user_password1.value)) {
        ymPrompt.alert('请输入新密码！', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                userForm.user_password1.focus();
            }
        });


        return false;

    } else {

        var specialChar = CheckSpecialChar(userForm.user_password1.value, special_char.passwd);
        if (specialChar) {
            ymPrompt.alert('密码不能包含' + specialChar + '字符！', 330, 220, '提示信息', function (data) {
                if (data == "ok") {
                    userForm.user_password1.focus();
                }
            });

            return false;
        }
    }

    if (isEmpty(userForm.user_password2.value)) {
        ymPrompt.alert('请输入确认新密码！', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                userForm.user_password2.focus();
            }
        });

        return false;

    } else {

        var specialChar = CheckSpecialChar(userForm.user_password2.value, special_char.passwd);
        if (specialChar) {
            ymPrompt.alert('确认密码不能包含' + specialChar + '字符！', 330, 220, '提示信息', function (data) {
                if (data == "ok") {
                    userForm.user_password2.focus();
                }
            });

            return false;
        }
    }

    if (userForm.user_password1.value != userForm.user_password2.value) {
        ymPrompt.alert('密码输入不一致，请重新输入！', 330, 220, '提示信息', function (data) {
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
        $("#userDiv").css('color', 'red').html('请输入用户名！');
        return false;

    } else {
        var specialChar = CheckSpecialChar(name.val(), special_char.username);
        if (specialChar) {
            $("#userDiv").css('color', 'red').html('用户名不能包含' + specialChar + '字符！');
            return false;
        }
    }
    UserBus.isExistUsername(name.val(), userId ? userId.val() : null, doChackName);
}

function doChackName(result) {
    if (result) {
        $("#userDiv").css('color', 'red').html('用户名已经被使用，请重新选择！');
        $("#saveButton").attr("disabled", true);

    } else {
        $("#userDiv").css('color', 'green').html('用户名可用！');
        isname = true;
        $("#saveButton").attr("disabled", false);
    }

}

function checkPassword2(userPwd2) {

    if (isEmpty(userForm.user_password2.value)) {

        $("#pwd2Div").html("<font color='red'>请输入确认密码！</FONT>");
        //userForm.user_password2.focus();
        return false;

    } else {
        if (userForm.user_password1.value != userForm.user_password2.value) {

            $("#pwd2Div").html("<font color='red'>密码输入不一致，请重新输入！</font>");
            $("#user_password2").focus();
            $("#saveButton").attr("disabled", true);

        } else {
            $("#pwd2Div").html("<font color='green'>密码输入一致！</font>");
            $("#saveButton").attr("disabled", false);
        }

    }

}


function checkblogName(status) {
    var name = $("#userName");
    if (status == 1) {
        if (isEmpty(name.val())) {
            this.checked = false;
            $("#userDiv").css('color', 'red').html('请输入用户名！');
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
            $("#userEmailInfo").css('color', 'red').html('电子邮箱必须符合规范,例如：test@yahoo.com！');
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
        $("#userEmailInfo").css('color', 'red').html('邮件地址已经被使用！');
        $("#saveButton").attr("disabled", true);
        return false;
    } else {
        $("#userEmailInfo").css("color", "green").html("邮件地址可用！");
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
            $("#ipInfo").css("color", "green").html("IP地址正确！");
            return true;
        } else {
            $("#ipInfo").css("color", "red").html("请输入正确的IP地址，例如：192.168.0.1！");

            return false;
        }
    });
    $("#userCardid").bind("blur", function () {
        if (Tools.isIdentify(this.value)) {
            $("#cardIdInfo").css("color", "green").html("身份证号正确！");
            return true;
        } else {
            $("#cardIdInfo").css("color", "red").html("请输入正确的身份证号！");

            return false;
        }
    });
    $("#userFax").bind("blur", function () {
        if (isFax(this.value)) {
            $("#userFaxInfo").css("color", "green").html("传真号码正确！");
            return true;
        } else {
            $("#userFaxInfo").css("color", "red").html("请输入正确的传真号码,例如:010-88888888！");
            return false;
        }
    });
    $("#userPhone").bind("blur", function () {
        if (isTel(this.value)) {
            $("#userPhoneInfo").css("color", "green").html("电话号码正确！");
            return true;
        } else {
            $("#userPhoneInfo").css("color", "red").html("请输入正确的电话号码,例如:010-88888888！");
            return false;
        }
    });
    $("#userMobile").bind("blur", function () {
        if (isPhone(this.value)) {
            $("#userMobileInfo").css("color", "green").html("手机号码正确！");
            return true;
        } else {
            $("#userMobileInfo").css("color", "red").html("请输入正确的手机号码,例如:13011111111！");

            return false;
        }
    });
    $("#userPostid").bind("blur", function () {
        if (isPost(this.value)) {
            $("#userPostidInfo").css("color", "green").html("邮政编码正确！");
            return true;
        } else {
            $("#userPostidInfo").css("color", "red").html("请输入正确的邮政编码,例如:100100!");

            return false;
        }
    });

});
