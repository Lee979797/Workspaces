function checkForm(actions) {

    if (actions != "mod") {
        if (isEmpty(userForm.userName.value)) {
            ymPrompt.alert('请输入用户名！', 330, 220, '提示信息', function (data) {
                if (data == "ok") {
                    userForm.userName.focus();
                }
            });

            return false;

        } else {
            var specialChar = CheckSpecialChar(userForm.userName.value, special_char.username);
            if (specialChar) {
                ymPrompt.alert('用户名不能包含' + specialChar + '字符！', 330, 220, '提示信息', function (data) {
                    if (data == "ok") {
                        userForm.userName.focus();
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
    if (!isEmpty(document.getElementById("CalendarSelector2").value)) {

        var birthday = document.getElementById("CalendarSelector2").value;
        var dateArr = getChineseDate();
        var sysDate = dateArr[0] + "-" + dateArr[1] + "-" + dateArr[2];
        if (checkIsValidDate(birthday)) {
            if (birthday.length == 7) {
                birthday = birthday + "-01";
            }
            if (checkDateEarlier(birthday, sysDate) > 0) {
                ymPrompt.alert('出生日期不能大于当前日期！', 330, 220, '提示信息', function (data) {
                    if (data == "ok") {
                        userForm.userBirthday.focus();
                    }
                });

                userForm.userBirthday.focus();
                return false;
            }
        } else {
            ymPrompt.alert('出生日期格式有误！', 330, 220, '提示信息', function (data) {
                if (data == "ok") {
                    userForm.userBirthday.focus();
                }
            });
            userForm.userBirthday.focus();
            return false;
        }
    } else {
        ymPrompt.alert('请输入出生日期！', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                userForm.userBirthday.focus();
            }
        });

        userForm.userBirthday.focus();
        return false;
    }

    if (isEmpty(userForm.userPhone.value)) {
        ymPrompt.alert('请输入电话！', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                userForm.userPhone.focus();
            }
        });

        return false;

    } else {
        var str = userForm.userPhone.value;
        //var reg=/(^[0-9]{3,4}\-[0-9]{7,8}$)|(^[0-9]{7,8}$)|(^\([0-9]{3,4}\)[0-9]{3,8}$)|(^0{0,1}13[0-9]{9}$)/;
        var reg = /^((0\d{2,3})-)(\d{7,8})(-(\d{2,}))?$/;

        if (reg.test(str) == false) {
            //ymPrompt.alert('电话格式不正确！',330,220,'提示信息',function(data){if(data == "ok"){ userForm.userPhone.focus();}});

            //return false;
        }
    }

    if (!isEmpty(userForm.userFax.value)) {
        if (!isNumber(userForm.userFax.value)) {
            //ymPrompt.alert('传真格式不正确！',330,220,'提示信息',function(data){if(data == "ok"){ userForm.userFax.focus();}});

            //return false;
        }
    }


    if (isEmpty(userForm.userEmail.value)) {
        ymPrompt.alert('请输入电子邮箱！', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                userForm.userEmail.focus();
            }
        });

        return false;

    } else {

        if (!checkEmail(userForm.userEmail.value)) {
            ymPrompt.alert('电子邮箱格式不正确！', 330, 220, '提示信息', function (data) {
                if (data == "ok") {
                    userForm.userEmail.focus();
                }
            });

            return false;
        }
    }
    if (isEmpty(userForm.province.value)) {

        ymPrompt.alert('请选择所属分中心！', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                userForm.province.focus();
            }
        });

        return false;
    }

    if (isEmpty(userForm.usergroupId.value)) {

        ymPrompt.alert('请选择用户组！', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                userForm.user_branch.focus();
            }
        });

        return false;
    }

    if (!isEmpty(userForm.userPostid.value)) {
        if (!isPostCode(userForm.userPostid.value)) {
            ymPrompt.alert('邮政编码格式不正确！', 330, 220, '提示信息', function (data) {
                if (data == "ok") {
                    userForm.userPostid.focus();
                }
            });

            return false;
        }
    }


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

