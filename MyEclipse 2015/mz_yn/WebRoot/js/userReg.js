function checkForm(){

    var userType = document.getElementsByName("usertype");
    var value = "";
    for(var i=0;i<userType.length;i++){
        if(userType[i].checked==true){
            value = userType[i].value;
            break;
        }
    }
    if(value=='1'){
        if(!checkCodeName()){
            return false;
        }
    }
    if(value=='2'){
        if(!checkjgdm()){
            return false;
        }
        if(!checkjgmc()){
            return false;
        }
        if(!checkDjh()){
            return false;
        }
        if(!checkfddbr()){
            return false;
        }
        if(!checkZjlx()){
            return false;
        }
        if(!checkZjhm()){
            return false;
        }
    }
    if(!checkUserName()){
        return false;
    }
    if(!checkPwd()){
        return false;
    }
    if(!checkPwdAgain()){
        return false;
    }
    if(!checkJbrName()){
        return false;
    }
    if(!checkCellPhone()){
        return false;
    }
    if(!checkEmailZS()){
        return false;
    }
    if(!checkJbrzjlx()){
        return false;
    }
    if(!checkJbrzzhm()){
        return false;
    }

    for(var i=0;i<document.getElementsByTagName("input").length;i++){
        if(!isEmpty(document.getElementsByTagName("input")[i].value)){
           trimIntputValue(document.getElementsByTagName("input")[i]);
        }
    }
    document.userForm.submit();
    document.userForm.button.disabled;

}

function checkjgdm()
{
    if(isEmpty(userForm.jgdm.value)){
            document.getElementById("tishi2").innerHTML='请输入组织机构代码！';
            return false;
    }else{
        if(userForm.jgdm.value.length<9){
            document.getElementById("tishi2").innerHTML='组织机构代码长度不能小于9位！';
            return false;
        }
        dwr.engine.setAsync(false);
        var flag = false;
        var isExist = false;
        codecheck.isCheckCode(userForm.jgdm.value,function(data){
            if(data==true)
            {
                flag = true;
            }
        });
        dwr.engine.setAsync(true);
        if(flag==true){
            dwr.engine.setAsync(false);
            TjgdmBus.FindByJgdm(userForm.jgdm.value,function(data){
                if(data.length>0)
                {
                    flag = true;
                }else
                    flag = false;
            });
            dwr.engine.setAsync(true);
        }
        if(flag==false){
            document.getElementById("tishi2").innerHTML='组织机构代码不正确或不存在！';
            return false;
        }else{
            //判断机构代码是否已被注册
            var flag = false;
            dwr.engine.setAsync(false);
            zsUserBus.findUserNameByJgdm(userForm.jgdm.value,function(data){
                if(data!=null&&data!=""){
                    flag = true;
                }
            });
            dwr.engine.setAsync(true);
            if(flag==true){
                document.getElementById("tishi2").innerHTML='组织机构代码已经注册，请更换!';
                return false;
            }else{
                document.getElementById("tishi2").innerHTML='<font color=\'#999\'>组织机构代码OK！</font>';
                trimIntputValue(userForm.jgdm);
                return true;
            }
        }
    }
}

function checkJbrzjlx(){
    if(isEmpty(userForm.jbrzjlx.value)){
        document.getElementById("tishi14").innerHTML='请选择经办人证件类型！';
        return false;
    }else{
        document.getElementById("tishi14").innerHTML='<font color=\'#999\'>经办人证件类型OK！</font>';
        return true;
    }
}

function checkZjlx(){
    if(isEmpty(userForm.zjlx.value)){
        document.getElementById("tishi6").innerHTML='请选择证件类型！';
        return false;
    }else{
        document.getElementById("tishi6").innerHTML='<font color=\'#999\'>证件类型OK！</font>';
        return true;
    }
}

function checkJbrzzhm(){
    if(isEmpty(userForm.jbrzjhm.value)){
        document.getElementById("tishi15").innerHTML='请输入经办人证件号码！';
        return false;
    }else{
        if(document.userForm.jbrzjlx.value==0){
            if(CheckIdentify(document.userForm.jbrzjhm)==false){
                    document.getElementById("tishi15").innerHTML='证件号码格式错误！';
                    return false;
            }else{
                    document.getElementById("tishi15").innerHTML='<font color=\'#999\'>经办人证件号码OK！</font>';
                    return true;
            }
        }else{
            document.getElementById("tishi15").innerHTML='<font color=\'#999\'>经办人证件号码OK！</font>';
            return true;
        }
    }
}

function checkZjhm(){
    if(isEmpty(userForm.zjhm.value)){
        document.getElementById("tishi7").innerHTML='请输入证件号码！';
        return false;
    }else{
        if(document.userForm.zjlx.value==0){
            if(CheckIdentify(document.userForm.zjhm)==false){
                document.getElementById("tishi7").innerHTML='证件号码格式错误！';
                return false;
            }else{
                document.getElementById("tishi7").innerHTML='<font color=\'#999\'>证件号码OK！</font>';
                return true;
            }
        }else{
            document.getElementById("tishi7").innerHTML='<font color=\'#999\'>证件号码OK！</font>';
            return true;
        }
    }
}

//检验身份证输入有效性
function CheckIdentify(thisObject){
 var allValid=true;
 var strVar=thisObject.value;

 if (!(strVar.length==15 || strVar.length==18)){
    thisObject.focus();
    allValid=false;
    return allValid;
 }
 if (strVar.length==15){
   if (!fCheckSpecialString(strVar,"0123456789")){
      thisObject.focus();
      allValid=false;
      return allValid;

   }
   if (!fIsIDCheckCode(strVar,15)){
      thisObject.focus();
      allValid=false;
      return allValid;

   }
 }
 if (strVar.length==18){
   if (!fIsIDCheckCode(strVar,18)){
      thisObject.focus();
      allValid=false;
      return allValid;
   }
 }
 return allValid;
}

function fCheckSpecialString(thisString,strCheckString){
	var allValid = true;
	for (i = 0;i<thisString.length;i++)
	{
	  ch = thisString.charAt(i);
	  for (j = 0;  j < strCheckString.length;  j++){
	     if (ch == strCheckString.charAt(j))
	     break;
	  }
	  if (j == strCheckString.length)
	  {
	       allValid = false;
	       break;
	  }
	}
        return allValid;
}

//身份证是否满足检验要求
//aflag 18检验18位的身份证,检验其检验码
//aflag 15检验15位的身份证中6位日期的有效性
function fIsIDCheckCode(aStrCode,aFlag){
    var strOrigin="";
    //判断前17位


    var wi=new Array(7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2,1);
    var i=0;
    var sum=0;
    var ai=new Array("1","0","X","9","8","7","6","5","4","3","2");
    var strCheck="";
    if (aFlag==18){
      strOrigin=aStrCode.substring(0,17);
    //按照检验算法进行运算
      for(i=0;i<17;i++){
        strCheck=strOrigin.substring(i,i+1);
      //alert(strCheck);
        sum=sum+wi[i]*parseInt(strCheck);
      //alert(sum);
      }
      sum=sum % 11;
      strOrigin=strOrigin+ai[sum];
      if (strOrigin==aStrCode){
        return true;
      }else{
        return false;
      }

    }else {
      strOrigin=aStrCode.substring(6,12);
      strCheck="19"+strOrigin.substring(0,2)+"-"+strOrigin.substring(2,4)+"-"+strOrigin.substring(4,6);
      /*strCheck=strOrigin.substring(0,2);
      if (!(strCheck>="00" && strCheck<="99")){
         return false;
      }
      strCheck=strOrigin.substring(2,4);
      if (!(strCheck>="01" && strCheck<="12")){
         return false;
      }
      strCheck=strOrigin.substring(4,6);
      if (!(strCheck>="01" && strCheck<="31")){
         return false;
      }*/
      return IsCorrDate(strCheck);
    }
}

function IsCorrDate(strDate)
{
	var strY;					   //string year
	var strM;                      //string month
	var strD;					   //string date
	var blnFlag;                   //mark leap year

	if(strDate.length!=10){
	   alert("日期格式长度10位!格式为:yyyy-mm-dd")
	   oDate.focus();
	   return false;
	}
	strY=strDate.substring(0,4);
	strM=strDate.substring(5,7);
	strD=strDate.substring(8,10);
	strFlag=strDate.substring(4,5);
	if(strFlag!="-"){
	   //alert("格式为:yyyy-mm-dd")
	   return false;
	}
	strFlag=strDate.substring(7,8);
	if(strFlag!="-"){
	   //alert("格式为:yyyy-mm-dd")
	   return false;
	}

        if (strDate<"1900-01-01"){
	   //alert("日期应该大于1900-01-01")
	   return false;

        }
        if (strDate>"2100-12-31"){
	   //alert("日期应该小于2100-12-31")
	   return false;

        }

	if (strY.length!=4)
	{
	   //alert("年份为4位!")
	   return false;

	}
	if (strM.length!=2)
	{
	   //alert("月份为2位!")
	   return false;
	}
	if (strD.length!=2)
	{
	   //alert("日期为2位!")
	   return false;
	}

	if(strY%4==0)
	{
		if(strY%100==0)
		{
			if(strY%400==0)
			{
				blnFlag=true;
			}
			else
			{
				blnFlag=false;
			}
		}
		else
		{
			blnFlag=true;
		}
	}
	else
	{
		blnFlag=false;
	}


	switch (strM)
	{
		case "01":
		{
			if(strD>=1&&strD<=31)
			{
				return true;
			}
			else
			{
				//alert("日期有误!")
				return false;
			}
			break;
		}
		case "02":
		{
			if(blnFlag)
			{
				if(strD>=1&&strD<=29)
				{
					return true;
				}
				else
				{
					//alert("日期有误!")
					return false;
				}
			}
			else
			{
				if(strD>=1&&strD<=28)
				{
					return true;
				}
				else
				{
					//alert("日期有误!")
					return false;
				}
			}
			break;
		}
		case "03":
		{
			if(strD>=1&&strD<=31)
			{
				return true;
			}
			else
			{
				//alert("日期有误!")
				return false;
			}
			break;
		}
		case "04":
		{
			if(strD>=1&&strD<=30)
			{
				return true;
			}
			else
			{
				//alert("日期有误!")
				return false;
			}
			break;
		}
		case "05":
		{
			if(strD>=1&&strD<=31)
			{
				return true;
			}
			else
			{
				//alert("日期有误!")
				return false;
			}
			break;
		}
		case "06":
		{
			if(strD>=1&&strD<=30)
			{
				return true;
			}
			else
			{
				//alert("日期有误!")
				return false;
			}
			break;
		}
		case "07":
		{
			if(strD>=1&&strD<=31)
			{
				return true;
			}
			else
			{
				//alert("日期有误!")
				return false;
			}
			break;
		}
		case "08":
		{
			if(strD>=1&&strD<=31)
			{
				return true;
			}
			else
			{
				//alert("日期有误!")
				return false;
			}
			break;
		}
		case "09":
		{
			if(strD>=1&&strD<=30)
			{
				return true;
			}
			else
			{
				//alert("日期有误!")
				return false;
			}
			break;
		}
		case "10":
		{
			if(strD>=1&&strD<=31)
			{
				return true;
			}
			else
			{
				//alert("日期有误!")
				return false;
			}
			break;
		}
		case "11":
		{
			if(strD>=1&&strD<=30)
			{
				return true;
			}
			else
			{
				//alert("日期有误!")
				return false;
			}
			break;
		}
		case "12":
		{
			if(strD>=1&&strD<=31)
			{
				return true;
			}
			else
			{
				//alert("日期有误!")
				return false;
			}
			break;
		}
		default:
		{
			//alert("月份有误!")
			return false;
		}
	}

}

function checkjgmc(){
    if(isEmpty(userForm.jgmc.value)){
        document.getElementById("tishi3").innerHTML='请输入机构名称！';
        return false;
    }else{
        document.getElementById("tishi3").innerHTML='<font color=\'#999\'>机构名称OK！</font>';
        return true;
    }
}

function checkCodeName(){
    if(isEmpty(userForm.codeName.value)){
        document.getElementById("tishi1").innerHTML='请输入机构名称！';
        return false;
    }else{
        document.getElementById("tishi1").innerHTML='<font color=\'#999\'>机构名称OK！</font>';
        return true;
    }
}

function checkJbrName(){
    if(isEmpty(userForm.jbrxm.value)){
        document.getElementById("tishi11").innerHTML='请输入经办人姓名！';
        return false;
    }else{
        document.getElementById("tishi11").innerHTML='<font color=\'#999\'>经办人姓名OK！</font>';
        return true;
    }
}

function checkfddbr(){
    if(isEmpty(userForm.fddbr.value)){
        document.getElementById("tishi5").innerHTML='请输入法定代表人或负责人！';
        return false;
    }else{
        document.getElementById("tishi5").innerHTML='<font color=\'#999\'>法定代表人或负责人OK！</font>';
        return true;
    }
}

function checkDjh(){
    if(isEmpty(userForm.djh.value)){
        document.getElementById("tishi4").innerHTML='请输入登记号！';
        return false;
    }else{
        document.getElementById("tishi4").innerHTML='<font color=\'#999\'>登记号OK！</font>';
        return true;
    }
}

function checkUserName(){
    if(isEmpty(userForm.username.value)){
        document.getElementById("tishi8").innerHTML='请输入用户名！';
        return false;
    }else{
         trimIntputValue(userForm.username);
         var specialChar = CheckSpecialChar(userForm.username.value,special_char.username);
         if(specialChar){
             document.getElementById("tishi8").innerHTML='用户名不能包含'+specialChar+'字符！';
             return false;
         }else{
             //判断用户名是否已被注册
            var flag = false;
            dwr.engine.setAsync(false);
            smUserBus.isExistUserName(userForm.username.value,function(data){
                if(data==true){
                    flag = true;
                }
            });
            dwr.engine.setAsync(true);
            if(flag==true){
                document.getElementById("tishi8").innerHTML='用户名已经存在!';
                return false;
            }else{
                document.getElementById("tishi8").innerHTML='<font color=\'#999\'>用户名OK！</font>';
                return true;
            }
         }
    }
}

function checkEmailZS(){
    if(isEmpty(userForm.jbremail.value)){
        document.getElementById("tishi13").innerHTML='请输入经办人邮箱！';
        return false;
    }else{
        if(!checkEmail(userForm.jbremail.value)){
            document.getElementById("tishi13").innerHTML='经办人邮箱格式不正确！';
            return false;
        }else{
            document.getElementById("tishi13").innerHTML='<font color=\'#999\'>经办人邮箱OK！</font>';
            trimIntputValue(userForm.jbremail);
            return true;
        }
    }
}


function checkCellPhone(){
    if(isEmpty(userForm.jbrmobile.value)){
        document.getElementById("tishi12").innerHTML='经办人手机不能为空！';
        return false;
    }else{
		if(!isNumber(userForm.jbrmobile.value)){
            document.getElementById("tishi12").innerHTML='经办人手机格式不正确！';
			return false;
		}else{
            document.getElementById("tishi12").innerHTML='<font color=\'#999\'>经办人手机格式OK！</font>';
            trimIntputValue(userForm.jbrmobile);
            return true;
        }
	}
}

function checkPwd(){
    if(isEmpty(userForm.password.value)){
         document.getElementById("tishi9").innerHTML='请输入密码！';
         return false;

    }else{
         var specialChar = CheckSpecialChar(userForm.password.value,special_char.passwd);
         if(specialChar){
             document.getElementById("tishi9").innerHTML='密码不能包含'+specialChar+'字符！';
             return false;
         }
        if(userForm.password.value.length < 6){
            document.getElementById("tishi9").innerHTML='您输入的密码不能少于6个字符！';
            return false;
        }else{
            document.getElementById("tishi9").innerHTML='<font color=\'#999\'>密码OK！</font>';
            trimIntputValue(userForm.password);
            return true;
        }
    }
}

function checkPwdAgain(){
    if(isEmpty(userForm.user_password2.value)){
         document.getElementById("tishi10").innerHTML='请输入确认密码！';
         return false;
    }else{
         var specialChar = CheckSpecialChar(userForm.user_password2.value,special_char.passwd);
         if(specialChar){
             document.getElementById("tishi10").innerHTML='确认密码不能包含'+specialChar+'字符！';
             return false;
         }
    }

    if(userForm.password.value!=userForm.user_password2.value){
         document.getElementById("tishi10").innerHTML='密码输入不一致，请重新输入！';
         return false;
    }else{
         document.getElementById("tishi10").innerHTML='<font color=\'#999\'>确认密码OK！</font>';
         trimIntputValue(userForm.user_password2);
         return true;
    }
}

function checkRealName(){
    if(isEmpty(userForm.userChinesename.value)){
            document.getElementById("tishi5").innerHTML='请输入真实姓名！';
		    return false;
    }else{
         if(userForm.userChinesename.value.length > 10){
             document.getElementById("tishi5").innerHTML='您输入的中文名称太长，请保持在10个字符内！';
             return false;
         }
         var specialChar = CheckSpecialChar(userForm.userChinesename.value,special_char.username);
         if(specialChar){
             document.getElementById("tishi5").innerHTML='姓名不能包含'+specialChar+'字符！';
             return false;
         }else{
             document.getElementById("tishi5").innerHTML='<font color=\'#999\'>真实姓名OK！</font>';
             trimIntputValue(userForm.userChinesename);
             return true;
         }
    }
}

function checkTel(){
    if(isEmpty(document.userForm.userPhone.value)){
        document.getElementById("tishi6").innerHTML='请输入电话号码！';
        return false;
    }else if(!isPhoneNumber(document.userForm.userPhone.value)){
        document.getElementById("tishi6").innerHTML='请输入正确的电话号码！';
        return false;
    }else{
        document.getElementById("tishi6").innerHTML='<font color=\'#999\'>电话号码OK！</font>';
        trimIntputValue(userForm.userPhone);
        return true;
    }
}


var isname = false;
var isemail = false;
function checkName(username){

	if(isEmpty(userForm.userName.value)){
        document.getElementById("tishi").innerHTML='请输入用户名！';
        return false;

    }else{
         var specialChar = CheckSpecialChar(userForm.userName.value,special_char.username);
         if(specialChar){
             document.getElementById("tishi").innerHTML='用户名不能包含'+specialChar+'字符！';
             return false;
         }
    }
	//UserBus.isExistZSuserName(username,doChackName);



}

function doChackName(result){

	//alert(result);
	if(result){//已经存在
         document.getElementById("tishi").innerHTML='用户名已经被使用，请重新选择！';
         userForm.userName.focus();
	}else{
	     document.getElementById("tishi").innerHTML='<font color=\'#999\'>用户名可用！</font>';
        return true;
	}

}


function isPhoneNumber(s)
{
    var patrn=/^([0-9]|[-]|[,]){1,40}$/;
    if (!patrn.exec(s))
    {
        return false;
    }
    return true;
}

function showUserType(type){

    if(type==1){
         document.getElementById("noCode").style.display="block";
         document.getElementById("hasCode").style.display="none";
    }

    if(type==2){
         document.getElementById("noCode").style.display="none";
         document.getElementById("hasCode").style.display="block";
    }

}


