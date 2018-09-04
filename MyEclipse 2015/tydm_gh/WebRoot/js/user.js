function checkForm(actions) {

    if (actions != "mod") {
        if (isEmpty(userForm.userName.value)) {
            ymPrompt.alert('�������û�����', 330, 220, '��ʾ��Ϣ', function (data) {
                if (data == "ok") {
                    userForm.userName.focus();
                }
            });

            return false;

        } else {
            var specialChar = CheckSpecialChar(userForm.userName.value, special_char.username);
            if (specialChar) {
                ymPrompt.alert('�û������ܰ���' + specialChar + '�ַ���', 330, 220, '��ʾ��Ϣ', function (data) {
                    if (data == "ok") {
                        userForm.userName.focus();
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
    if (!isEmpty(document.getElementById("CalendarSelector2").value)) {

        var birthday = document.getElementById("CalendarSelector2").value;
        var dateArr = getChineseDate();
        var sysDate = dateArr[0] + "-" + dateArr[1] + "-" + dateArr[2];
        if (checkIsValidDate(birthday)) {
            if (birthday.length == 7) {
                birthday = birthday + "-01";
            }
            if (checkDateEarlier(birthday, sysDate) > 0) {
                ymPrompt.alert('�������ڲ��ܴ��ڵ�ǰ���ڣ�', 330, 220, '��ʾ��Ϣ', function (data) {
                    if (data == "ok") {
                        userForm.userBirthday.focus();
                    }
                });

                userForm.userBirthday.focus();
                return false;
            }
        } else {
            ymPrompt.alert('�������ڸ�ʽ����', 330, 220, '��ʾ��Ϣ', function (data) {
                if (data == "ok") {
                    userForm.userBirthday.focus();
                }
            });
            userForm.userBirthday.focus();
            return false;
        }
    } else {
        ymPrompt.alert('������������ڣ�', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                userForm.userBirthday.focus();
            }
        });

        userForm.userBirthday.focus();
        return false;
    }

    if (isEmpty(userForm.userPhone.value)) {
        ymPrompt.alert('������绰��', 330, 220, '��ʾ��Ϣ', function (data) {
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
            //ymPrompt.alert('�绰��ʽ����ȷ��',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){ userForm.userPhone.focus();}});

            //return false;
        }
    }

    if (!isEmpty(userForm.userFax.value)) {
        if (!isNumber(userForm.userFax.value)) {
            //ymPrompt.alert('�����ʽ����ȷ��',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){ userForm.userFax.focus();}});

            //return false;
        }
    }


    if (isEmpty(userForm.userEmail.value)) {
        ymPrompt.alert('������������䣡', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                userForm.userEmail.focus();
            }
        });

        return false;

    } else {

        if (!checkEmail(userForm.userEmail.value)) {
            ymPrompt.alert('���������ʽ����ȷ��', 330, 220, '��ʾ��Ϣ', function (data) {
                if (data == "ok") {
                    userForm.userEmail.focus();
                }
            });

            return false;
        }
    }
    if (isEmpty(userForm.province.value)) {

        ymPrompt.alert('��ѡ�����������ģ�', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                userForm.province.focus();
            }
        });

        return false;
    }

    if (isEmpty(userForm.usergroupId.value)) {

        ymPrompt.alert('��ѡ���û��飡', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                userForm.user_branch.focus();
            }
        });

        return false;
    }

    if (!isEmpty(userForm.userPostid.value)) {
        if (!isPostCode(userForm.userPostid.value)) {
            ymPrompt.alert('���������ʽ����ȷ��', 330, 220, '��ʾ��Ϣ', function (data) {
                if (data == "ok") {
                    userForm.userPostid.focus();
                }
            });

            return false;
        }
    }


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

