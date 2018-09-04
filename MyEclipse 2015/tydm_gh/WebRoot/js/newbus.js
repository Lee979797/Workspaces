/**
 * User: Administrator
 * Date: 12-5-18
 * Time: 上午10:29
 * To change this template use File | Settings | File Templates.
 */
var mes;
var flg = false;
var flgs = false;
function fCheckValue(type) {
	
	if (confirm("确认要提交？ ")) {
    var jgdm = document.getElementById("needJgdm");
   // confirm(jgdm+"111111111111");
  /*  if (jgdm != undefined || jgdm != null) {

        if (checkItem(document.getElementById("jgdm"), "机构代码")) {
            return false;
        } else {
        if (type == undefined) {
            if (!judgeJgdm()) {
                return false;
            }
        	 }
        }
        
      
    }*/
   /* var name = document.getElementById("jgmc");
    confirm(name+"aaaaaaaaaaa");
    if(name.indexOf("工会")==-1){
    	confirm("机构名称中必须包含有‘工会’两字！");
  
    }*/
   
    if (checkItem1(document.getElementById("jgmc"), "名称")) {
        return false;   
    }
   if(document.getElementById("jglx").value =="0"){
    	ymPrompt.alert('请选择机构类型!', 330, 220, '提示信息', function (data) {
			if (data == "ok") {
				document.getElementById("jglx").focus();
			}
		});
    	 return false;
    }
   
    if(type=='xb'){
    	if(document.getElementById("formType").value=='1'){
    		  if (checkItem(document.getElementById("jgdm"), "机构代码")) {
    		        return false;
    		    }
    		  if(!checkJgdm()){
    			  ymPrompt.alert({message: "机构代码不正确!!",
    				  slideShowHide: false, width: 330, height: 220, title: '提示信息', handler: function () {
    				  jgdm.focus()
    			  }});
    			  return false;
    		  }
    	}
    }
    if (!fCheckDateSpecialYear(document.getElementById("yxqxs"), document.getElementById("zfrq"), 5)) {
		ymPrompt.alert('有效期限自不能超过有效期限至5年，请重新输入!', 330, 220, '提示信息', function (data) {
			if (data == "ok") {
				document.getElementById("zfrq").focus();
			}
		});
		return false;
	}
    
    if (checkItem(document.getElementById("jgmc"), "名称")) {
        return false;
      
    }
    
    
    
    if (checkItem(document.getElementById("jgmc"), "名称")) {
        return false;
      
    }
    if (checkItem(document.getElementById("jgdz"), "住所地址")) {
    	return false;
    }
    if (checkItem(document.getElementById("xzqh"), "行政区划")) {
    	return false;
    }
    if (checkItem(document.getElementById("yzbm"), "邮政编码")) {
        return false;
    }
    if (checkItem(document.getElementById("zcrq"), "成立日期")) {
    	return false;
    }
    if (checkItem(document.getElementById("bzrq"), "发证日期")) {
    	return false;
    }
    
/*    if (checkItem(document.getElementById("jlwh"), "批复建立工会文号")) {
    	return false;
    }
    if (checkItem(document.getElementById("jlrq"), "审批日期")) {
    	return false;
    }*/
    
    if (checkItem(document.getElementById("xjwh"), "批复选举结果文号")) {
    	return false;
    }
    if (checkItem(document.getElementById("xjrq"), "审批日期")) {
    	return false;
    }
    
    
   /* 
    if (checkItem(document.getElementById("dhhm"), "电话")) {
    	return false;
    }
    if (checkItem(document.getElementById("zgmc"), "审批单位")) {
    	return false;
    }
    if (checkItem(document.getElementById("zgrs"), "现职工人数")) {
    	return false;
    }
   /* if (checkItem(document.getElementById("gbrs"), "专职工会干部数")) {
    	return false;
    }
    if (checkItem(document.getElementById("ghjs"), "工会届数")) {
    	return false;
    }
    if (checkItem(document.getElementById("ghzxdh"), "电话")) {
    	return false;
    }*/
    if (checkItem(document.getElementById("hyrs"), "会员人数")) {
    	return false;
    }
/*    if (checkItem(document.getElementById("ghzxmc"), "工会主席姓名")) {
    	return false;
    }*/
/*    if (checkItem(document.getElementById("snjylj"), "上年结余累计(万元)")) {
    	return false;
    }
    if (checkItem(document.getElementById("hhsr"), "年会员缴纳会费收入(万元)")) {
    	return false;
    }
    if (checkItem(document.getElementById("lcsr"), "年2％拨交工会经费本级留成收入(万元)")) {
    	return false;
    }*/
    if (checkItem(document.getElementById("qtsr"), "经费情况(万元)")) {
    	return false;
    }
    if (checkItem(document.getElementById("mz"), "民族")) {
    	return false;
    }
/*    if (checkItem(document.getElementById("gdzj"), "固定资产情况(万元)")) {
    	return false;
    }*/
/*    if (checkItem(document.getElementById("ldzj"), " 流动资金(万元)")) {
    	return false;
    }
    if (checkItem(document.getElementById("hjzj"), "合计")) {
    	return false;
    */}
  /*  if (checkItem(document.getElementById("bgcs"), "办 公 场 所(平方米)M2")) {
    	return false;
    }
    if (checkItem(document.getElementById("hdcs"), "活 动 场 所(平方米)M2")) {
    	return false;
    }
    if (checkItem(document.getElementById("qtcs"), "其 他 场 所")) {
    	return false;
    }*/
  /*  if (checkItem(document.getElementById("cshj"), "场所情况")) {
    	return false;
    }*/
    if(type=='bg'){
    	if(document.getElementById("isdang").value=='1' || document.getElementById("isdang").value=='2'){
    		if (checkItem(document.getElementById("xm"), "法人姓名")) {
    	    	return false;
    	    }
    	 /*   if (checkItem(document.getElementById("xl"), "文化程度")) {
    	    	return false;
    	    }*/
/*    	    if (checkItem(document.getElementById("csrq"), "出生年月")) {
    	    	return false;
    	    }*/
    	    if (checkItem(document.getElementById("zzmm"), "政治面貌")) {
    	    	return false;
    	    }
    	    if (checkItem(document.getElementById("lxmobile"), "法定代表人手机")) {
    	    	return false;
    	    }
    	   /* if (checkItem(document.getElementById("lxdh"), "法人座机")) {
    	    	return false;
    	    }*/
    	   /* if (checkItem(document.getElementById("yb"), "邮编")) {
    	    	return false;
    	    }
    	    if (checkItem(document.getElementById("email1"), "电子邮箱")) {
    	    	return false;
    	    }*/
    	    if (checkItem(document.getElementById("iszz"), "属专职兼职")) {
    	    	return false;
    	    }
    	    if (checkItem(document.getElementById("zw"), "现任工会职务")) {
    	    	return false;
    	    }
    	    if (checkItem(document.getElementById("rzsj"), "本届任职起始时间")) {
    	    	return false;
    	    }
    	   

/*    	    if (checkItem(document.getElementById("qtzw"), "现任其他职务")) {
    	    	    	return false;
    	    }*/
    	 
/*    	    if (checkItem(document.getElementById("rhsj"), "何时加入工会组织")) {
    	    	return false;
    	    }*/
    	    if (checkItem(document.getElementById("zjhm"), "身份证号码")) {
    	    	return false;
    	    }
    	}
    }else{
    	if (checkItem(document.getElementById("xm"), "法人姓名")) {
        	return false;
        }
      /*  if (checkItem(document.getElementById("xl"), "文化程度")) {
        	return false;
        }*/
/*        if (checkItem(document.getElementById("csrq"), "出生年月")) {
        	return false;
        }*/
        if (checkItem(document.getElementById("zzmm"), "政治面貌")) {
        	return false;
        }
        if (checkItem(document.getElementById("lxmobile"), "法定代表人手机")) {
        	return false;
        }
      /*  if (checkItem(document.getElementById("lxdh"), "法人座机")) {
        	return false;
        }*/
      /*  if (checkItem(document.getElementById("yb"), "邮编")) {
        	return false;
        }*/
       /* if (checkItem(document.getElementById("email1"), "电子邮箱")) {
        	return false;
        }*/
        if (checkItem(document.getElementById("zw"), "现任工会职务")) {
        	return false;
        }
        if (checkItem(document.getElementById("rzsj"), "本届任职起始时间")) {
        	return false;
        }

/*        if (checkItem(document.getElementById("qtzw"), "现任其他职务")) {
        	return false;
        }*/

/*        if (checkItem(document.getElementById("rhsj"), "何时加入工会组织")) {
        	return false;
        }*/
        if (checkItem(document.getElementById("zjhm"), "身份证号码")) {
        	return false;
        }
    }
    
    
    /*if (checkItem(document.getElementById("fddbr"), "法人代表")) {
        return false;
    }
    if (checkItem(document.getElementById("zjhm"), "证件号码")) {
        return false;
    }*/

  
   /* if (checkItem(document.getElementById("nnjjhy"), "经济行业")) {
     return false;
     }*/
    if (checkItem(document.getElementById("yxqxs"), "有效期限自")) {
        return false;
    }
   /* if (checkItem(document.getElementById("njqx"), "年检期限")) {
        return false;
    }*/
   if (checkItem(document.getElementById("zfrq"), "有效期限至")) {
        return false;
    }
   if (checkItem(document.getElementById("xb"), "性别")) {
       return false;
   }
  /*  if (checkItem(document.getElementById("zczj"), "注册资金")) {
        return false;
    }*/
   /* if (checkZCZJ(document.getElementById("zczj"), "注册资金")) {
        return false;
    }*/
  /*  if (checkZCZJ(document.getElementById("snjylj"), "上年结余累计(万元)")) {
    	return false;
    }
    if (checkZCZJ(document.getElementById("hhsr"), "年会员缴纳会费收入(万元)")) {
    	return false;
    }
    if (checkZCZJ(document.getElementById("lcsr"), "年2％拨交工会经费本级留成收入(万元)")) {
    	return false;
    }*/
  /*  if (checkZCZJ(document.getElementById("qtsr"), "经费情况(万元)")) {
    	return false;
    }*/
 /*   if (checkZCZJ(document.getElementById("gdzj"), "固定资金(万元)")) {
    	return false;
    }*/
  /*  if (checkZCZJ(document.getElementById("ldzj"), " 流动资金(万元)")) {
    	return false;
    }
    if (checkZCZJ(document.getElementById("hjzj"), "合计")) {
    	return false;
    }*/
   /* if (checkItem(document.getElementById("email"), "邮箱")) {
        return false;
    }*/
    /*if (checkItem(document.getElementById("url"), "网址")) {
        return false;
    }*/
    //var jglxVal = document.getElementById("jglx").value;
/*    if (checkItem(document.getElementById("pzjgdm"), "批准机构")) {
        return false;
    }*/
    /*if (jglxVal != '4' && jglxVal != '7' && jglxVal != '8' && jglxVal != '9') {
        if (checkPzjgmcByJglx() == false) {
            ymPrompt.alert("机构类型与批准机构不对应，请重新填写!", 330, 220, "提示信息");
            return false;
        }
    }*/
    /*if (checkItem(document.getElementById("pzjgmc, "批准机构名称")) {
     return false;
     }*/
   if (checkItem(document.getElementById("tbrmobile"), "经办人手机")) {
       return false;
   }
   
  if (checkItem(document.getElementById("tbrxm"), "经办人姓名")) {
        return false;
    }
    if (checkItem(document.getElementById("tbrsfzh"), "经办人证件号码")) {
        return false;
    }
    if (!fCheckEssItem(type,document.busForm)) {
        return false;
    }
/*    if(type=='2'){
    	
    	if (!fCheckDateSpecialYear(document.getElementById("yxqxs"), document.getElementById("zfrq"), 4)) {
    		ymPrompt.alert('有效期限自不能超过有效期限至4年，请重新输入!', 330, 220, '提示信息', function (data) {
    			if (data == "ok") {
    				document.getElementById("zfrq").focus();
    			}
    		});
    		return false;
    	}
    }else{
    	if (!fCheckDateSpecialYear(document.getElementById("yxqxs"), document.getElementById("zfrq"), 5)) {
    		ymPrompt.alert('有效期限自不能超过有效期限至5年，请重新输入!', 330, 220, '提示信息', function (data) {
    			if (data == "ok") {
    				document.getElementById("zfrq").focus();
    			}
    		});
    		return false;
    	}
    }*/
 /*   if (checkNotNull != undefined && !checkNotNull()) {
        return false;
    }*/
    if (emailCheck(document.getElementById('email1')) == false) {
        document.getElementById('email1').focus();
        return false;
    }
    /*if (URLCheck(document.getElementById('url')) == false) {
        document.getElementById('url').focus();
        return false;
    }*/
    if(type=='bg'){
    	if(document.getElementById("isdang").value=='1' || document.getElementById("isdang").value=='2'){
    		 if (checkSj(document.getElementById('lxmobile'),"法定代表人") == false) {
    		        document.getElementById('mobile').focus();
    		        return false;
    		    }
    		    if (telCheck(document.getElementById('lxdh'),"法定代表人") == false) {
    		        document.getElementById('frdhhm').focus();
    		        return false;
    		    }
    	}
    }else{
    	
    	if (checkSj(document.getElementById('lxmobile'),"法定代表人") == false) {
    		document.getElementById('mobile').focus();
    		return false;
    	}
    	if (telCheck(document.getElementById('lxdh'),"法定代表人") == false) {
    		document.getElementById('frdhhm').focus();
    		return false;
    	}
    }
    if (checkSj(document.getElementById('tbrmobile'),"经办人") == false) {
        document.getElementById('tbrmobile').focus();
        return false;
    }
 /*   if (telCheck(document.getElementById('tbrlxfs'),"经办人") == false) {
        document.getElementById('tbrlxfs').focus();
        return false;
    }*/
    if(document.getElementById('tbrsfzh').value!=""){
    	
    	if(!checkSfzh(document.getElementById('tbrsfzh'),document.getElementById('tbrzjlx').value)){
    		ymPrompt.alert({message: "经办人证件号码无效！", width: 330, height: 220, title: '提示信息'});
    		document.getElementById('tbrsfzh').focus();
       	 	return false;
    	}
    }
    if(type=='bg'){
    	if(document.getElementById("isdang").value=='1' || document.getElementById("isdang").value=='2'){
    		  if(!checkSfzh(document.getElementById('zjhm'),document.getElementById('zjlx').value)){
    				ymPrompt.alert({message: "法人证件号码无效！", width: 330, height: 220, title: '提示信息'});
    				document.getElementById('zjhm').focus();
    		   	 	return false;
    			}
    	}
    }else{
    	
    	if(!checkSfzh(document.getElementById('zjhm'),document.getElementById('zjlx').value)){
    		ymPrompt.alert({message: "法人证件号码无效！", width: 330, height: 220, title: '提示信息'});
    		document.getElementById('zjhm').focus();
    		return false;
    	}
    }
  /*  if (!tbrZjh()) {
        var zjlx3 = document.getElementById("tbrzjlx").value;
        var zjhm2 = document.getElementById("tbrsfzh");
        if (zjhm2.value.trim().length != 18 && zjlx3 == '0') {
            ymPrompt.alert("身份证号不为18位，请重新输入！", 330, 220, "提示信息", function (data) {
                if (data == "ok") {
                    zjhm2.focus();
                }
            });
            return false;
        }
        if (!confirm("输入的证件号码存在问题，您仍然要保存吗？")) {
            zjhm2.focus();
            return false;
        }
    }*/
        /*if (!confirm("输入的证件号码存在问题，您仍然要保存吗？")) {
            zjhm2.focus();
            return false;
        }*/
    /*  } else {
        var jgdm = document.getElementById("jgdm");
        if (jgdm) {
            var datas = [];
            dwr.engine.setAsync(false);
            jgdmBus.isZjhmHasCFJL(document.getElementById("zjhm").value, jgdm.value, function (data) {
                datas = data.split(":");
            });
            if (datas[0] == "true") {
                ymPrompt.alert(datas[1], 330, 220, "提示信息", function (data) {
                    if (data == "ok") {
                        document.getElementById("zjhm").focus();
                    }
                });
                return false;
            }

        }
        var nameType = document.getElementById("nameType");
        var aa = 4;
        if (nameType && nameType.value) {
            if (nameType.value == "add" || nameType.value == "update") {
                aa = 0
            } else if (nameType.value == "check") {
                aa = 1
            } else if (nameType.value == "certChangeName") {
                aa = 2
            }
        }
        if (aa == 0 || aa == 1) {
            dwr.engine.setAsync(false);
            jgdmBus.isZjhmHasHzcq(document.getElementById("zjhm").value, jgdm ? jgdm.value : "", aa, function (data) {
                datas = data.split(":");
            });
            var a = "<a style='text-decoration:underline;color:#0000ff;' target='_blank' href='" + '/bsweb/certificate_hzcqList.action?value=' + document.getElementById("zjhm").value + "' >查看</a>";
            if (datas[0] == "true") {
                ymPrompt.alert(datas[1] + a, 330, 220, "提示信息", function (data) {
                    if (data == "ok") {
                        document.getElementById("zjhm").focus();
                    }
                });
                return false;
            }
        }

    }*/
  
    var retVal = judgeCodeName();
    if(retVal=='1'){
    	ymPrompt.alert({message: "该工会名称已经存在！", width: 330, height: 220, title: '提示信息'});
		document.getElementById('jgmc').focus();
		return false; 
    }
    /*if (retVal != '') {
      if($("#formType").val()=='1'){
    		if(retVal=='5'){
    			document.getElementById("mcInfo").innerHTML = '机构名称已经存在其它库中，不能提交!&nbsp;<a style="text-decoration:underline;color:#0000ff;" target="_blank" href=' + hf + ' >查看</a>';
        		return '1';
    		}
    		
    	}
       
        ymPrompt.confirmInfo({message:  retVal+ "点击‘确定’提交审核，审核通过后可以使用该名称，否则需要重新填写；点击‘取消’，重新填写机构名称！", width: 330, height: 220, title: '提示信息', handler: function (tp) {
            if (tp == 'ok') {
                var form = document.forms[0];
                console.log(form)
                document.getElementById("submitType").value = '1';
                form.submit();
                return false;
            }
        }});
        return false;
    }*/
    //强制修改页面不进行重名审核
   /* if (type == undefined || type != 'forceUpdate') {
        var jgmc=document.getElementById("jgmc").value; 
        if (jgmc.indexOf("合作社")>0) {
        	
        	 ymPrompt.confirmInfo({message: "机构名称中包含‘合作社’，需提交审核，审核通过以后才能使用", width: 330, height: 220, title: '提示信息', handler: function (tp) {
                 if (tp == 'ok') {
                     var form = document.forms[0];
                     document.getElementById("submitType").value = '4';
                     form.submit();
                     return false;
                 }
             }});
        	 return false; 
        	
        }
        if (retVal != '') {
            if (!judgeZch()) {
                ymPrompt.alert({message: "注册号和机构名称与系统中其他机构的有重复，请确认填写的注册号与机构名称的使用情况，重新填写后再提交！", width: 330, height: 220, title: '提示信息', handler: function (tp) {
                    if (tp == 'ok') {
                          var form = document.forms[0];
                         document.getElementById("submitType").value = '3';
                         form.submit();
                        return false;
                    }
                }}); 
                return false;
            }
            if (false) {
                ymPrompt.alert({message: retVal + "，请重新填写机构名称！", width: 330, height: 220, title: '提示信息', handler: function (tp) {
                    if (tp == 'ok') {
                        return false;
                    }
                }});
                return false;
            }
            ymPrompt.confirmInfo({message: retVal + "点击‘确定’提交审核，审核通过后可以使用该名称，否则需要重新填写；点击‘取消’，重新填写机构名称！", width: 330, height: 220, title: '提示信息', handler: function (tp) {
                if (tp == 'ok') {
                    var form = document.forms[0];
                    document.getElementById("submitType").value = '1';
                    form.submit();
                    return false;
                }
            }});
            return false;
        }
     
        if (!judgeZch()) {
            ymPrompt.confirmInfo({message: mes + "点击‘确定’提交审核，审核通过后可以使用该注册号，否则需要重新填写；点击‘取消’，重新填写注册号！", width: 330, height: 220, title: '提示信息', handler: function (tp) {
                if (tp == 'ok') {
                    var form = document.forms[0];
                    document.getElementById("submitType").value = '2';
                    form.submit();
                    return false;
                }
            }});
            return false;
        }
    }*/

  /*  var strVar = document.getElementById("zch");
    if (strVar && strVar.value && /^\d+$/.test(strVar.value.trim())) {
        if (strVar.value.length < 15 || strVar.value.length > 18) {
            if (!confirm("输入的注册号长度不在15位到18位之间，您仍然要保存吗？")) {
                document.getElementById("zch").focus();
                return false;
            }
        }
    }*/

   /* if (flg != true) {

        if (document.getElementById("xzqh1").innerText.trim() == jgdz.value.trim()) {
            ymPrompt.confirmInfo("行政区划名称不能和机构地址相同,是否继续？", 330, 220, "提示信息", function (data) {
                if (data == "ok") {

                    flg = true;
                    document.busForm.submit();

                } else {
                    jgdz.focus();
                    flg = false;
                }
            });
            return flg;

        }


    }
*/
    /*if (document.getElementById("zczj").value >= 1000) {
     if (!confirm("输入的注册资金已经超过1000万，您确认要保存吗？")) {
     document.getElementById("zczj").focus();
     return false;
     }
     }*/

    document.busForm.submit();
    return true;
	}

function checkRysl(num){
	if(num.value!=''&&num.value!='0'){
		if(num.value>100){
			return false;
		}else{
			return true;
		}
		
	}else{
		return true;
	}
}






function clearPzjg() {
    var jglx = document.getElementById("jglx").value;
    if (jglx == '4' || jglx == '7' || jglx == '8' || jglx == '9') {
        document.getElementById("pzjgdm").value = "";
        document.getElementById("pzjginfo").innerText = "";
    }
    if (jglx == '1' || jglx == '2' || jglx == 'B') {
    	document.getElementById("memo2").value = "小型微型企业";
    }else{
    	document.getElementById("memo2").value = "";
    }

    if (/[246789c]/i.test(jglx)) {
        document.getElementById("zczj").value = "0";

    } else {
        document.getElementById("zczj").value = "";
    }
}

function sycjyyb(obj) {
    document.getElementById("jyyb").value = obj.value;
}

function getLeftChars(varField) {
    var i = 0;
    var counter = 0;
    var cap = 2000;
    for (i = 0; i < varField.value.length; i++) {
        if (varField.value.charCodeAt(i) > 127 || varField.value.charCodeAt(i) == 94) {
            cap = 2000;
        }
    }
    var leftchars = cap - varField.value.length;
    return (leftchars);
}
function onCharsChange(varField) {
    var leftChars = getLeftChars(varField);
    if (leftChars >= 0) {
        document.busForm.charsmonitor.value = leftChars;
        return true;
    } else {
        document.busForm.charsmonitor.value = "0";
        ymPrompt.alert({message: "经营范围中只能输入1000字符！", width: 330, height: 220, title: '提示信息'});
        var len = document.getElementById("jyfw").value.length + leftChars;
        document.getElementById("jyfw").value = document.getElementById("jyfw").value.substring(0, len);
        leftChars = getLeftChars(document.getElementById("jyfw"));
        if (leftChars >= 0) {
            document.busForm.charsmonitor.value = leftChars;
        }
        return false;
    }
}
function getLeftChars1(varField) {
    var i = 0;
    var counter = 0;
    var cap = 0;
    for (i = 0; i < varField.value.length; i++) {
        if (varField.value.charCodeAt(i) > 127 || varField.value.charCodeAt(i) == 94) {
            cap = 0;
        }
    }
    var leftchars = varField.value.length - 35;
    return (leftchars);
}
function onCharsChange1(varField) {
    var leftChars = getLeftChars1(varField);
    if (leftChars <= 0) {
        document.busForm.charsmonitor1.value = leftChars + 35;
        return true;
    } else {
        document.busForm.charsmonitor1.value = "35";
        ymPrompt.alert({message: "只能输入35个字符！！", width: 330, height: 220, title: '提示信息'});
        var e = document.getElementById("zch");
        var len = e.value.length - leftChars;
        e.value = e.value.substring(0, len);
        leftChars = getLeftChars1(e);
        if (leftChars <= 0) {
            document.busForm.charsmonitor1.value = leftChars + 35;
        }
        return false;
    }
}

function onCharsChange_sfzh(varField) {
    document.busForm.charsmonitor_sfzh.value = varField.value.length;
    return true;
}

function onCharsChange_tbrsfzh(varField) {
    document.busForm.charsmonitor_tbrsfzh.value = varField.value.length;
    return true;
}
function onCharsChange_tbrlxfs(varField) {
    document.busForm.charsmonitor_tbrlxfs.value = varField.value.length;
    return true;
}
function onCharsChange_dhhm(varField) {
    document.busForm.charsmonitor_dhhm.value = varField.value.length;
    return true;
}

function onCharsChange_frsj(varField) {
    document.busForm.charsmonitor_frsj.value = varField.value.length;
    return true;
}

function onCharsChange_jydh(varField) {
    document.busForm.charsmonitor_jydh.value = varField.value.length;
    return true;
}

function infoPush(){
	var jgdm = document.getElementById("jgdm");
    tjgdmSaveBus.findJgdmBs(jgdm.value, function (data) {
        if (data != null) {
        	$("#jgmc").val(data.jgmc);
        	$("#jgdz").val(data.jgdz);
        	$("#fddbr").val(data.fddbr);
        	$("#jyfw").val(data.jyfw);
        	$("#zczj").val(data.zczj);
        	$("#zcrq").val(data.memo5);
        } else {
        	ymPrompt.alert({message: "未找到代码信息!", width: 330, height: 220, title: '提示信息'});
        }
    });
}

function judgeJgdm(dmInfo) {
    var jgdm = document.getElementById("jgdm");
    var flag = true;
    if (isEmpty(jgdm.value)) {
        if (dmInfo) {
        	ymPrompt.alert({message: "请输入机构代码！", width: 330, height: 220, title: '提示信息'});
            //dmInfo.innerHTML = '请输入机构代码!';
        } else {
            ymPrompt.alert({message: "请输入机构代码!",
                slideShowHide: false, width: 330, height: 220, title: '提示信息', handler: function () {
                    jgdm.focus()
                }});
        }
        flag = false;
    }
    if (!flag)
        return flag;
    dwr.engine.setAsync(false);
    codecheck.isCheckCode(jgdm.value, function (value) {
        if (value != true) {
            if (dmInfo) {
            	ymPrompt.alert({message: "机构代码不正确!", width: 330, height: 220, title: '提示信息'});
                //dmInfo.innerHTML = '<font color="red">机构代码不正确!</font>';
            } else {
                ymPrompt.alert({message: "机构代码不正确!!",
                    slideShowHide: false, width: 330, height: 220, title: '提示信息', handler: function () {
                        jgdm.focus()
                    }});
            }
            flag = false;
        } else {
            if (dmInfo)
               // dmInfo.innerHTML = '';
            flag = true;
        }
    });
    if (flag) {
        tjgdmSaveBus.isExistJgdm(jgdm.value, function (data) {
            if (data == true) {
                if (dmInfo) {
                	ymPrompt.alert({message: "机构代码已经存在!", width: 330, height: 220, title: '提示信息'});
                    //dmInfo.innerHTML = '<font color="red">机构代码已经存在!</font>';
                } else {
                    ymPrompt.alert({message: "机构代码已经存在!",
                        slideShowHide: false, width: 330, height: 220, title: '提示信息', handler: function () {
                            jgdm.focus()
                        }});
                }
                flag = false;
            } else {
                if (dmInfo)
                    //dmInfo.innerHTML = '';
                flag = true;
            }
        });
    }
    if (!flag)
        return flag;
   /* qtmdkBus.existCode(jgdm.value, 4, function (value) {
        flag = value;

    });*/
    if (false) {
        if (dmInfo) {
            //dmInfo.innerHTML = '<font color="red">机构代码(' + jgdm.value+ ')不在码段库中;如果要添加此信息,请与省中心联系,把此码段添到其他码段库中!</font>';
        } else {
            ymPrompt.alert({message: "机构代码(" + jgdm.value + ")不在码段库中;如果要添加此信息,请与省中心联系,把此码段添到其他码段库中!",
                slideShowHide: false, width: 330, height: 220, title: '提示信息', handler: function () {
                    jgdm.focus()
                }});
        }
        return false;
    }
    dwr.engine.setAsync(true);
    return true;
}
function checkJgdm() {
    var jgdm = document.getElementById("jgdm");
    var flag = true;

  
    dwr.engine.setAsync(false);
    codecheck.isCheckCode(jgdm.value, function (value) {
        if (value != true) {
         
                ymPrompt.alert({message: "机构代码不正确!!",
                    slideShowHide: false, width: 330, height: 220, title: '提示信息', handler: function () {
                        jgdm.focus()
                    }});
            
            flag = false;
        }else{
        	flag=true
        }
    });
    dwr.engine.setAsync(true);
    return flag;
}
function checkZgjgdm(zgjgdm) {
    if (zgjgdm != null && zgjgdm != '') {
        dwr.engine.setAsync(false);
        codecheck.isCheckCode(zgjgdm, function (value) {
            if (value != true) {
            	//ymPrompt.alert({message: "主管机构代码不正确!", width: 330, height: 220, title: '提示信息'});
                //document.getElementById("zgjgdmInfo").innerHTML = '<font color="red">主管机构代码不正确!</font>';
            } else {
                //document.getElementById("zgjgdmInfo").innerHTML = '';
            }
        });
    } else {
        //document.getElementById("zgjgdmInfo").innerHTML = '';
        document.getElementById("zgmc").value = '';
    }
}

function checkTelPage(obj) {
    var strVar = obj.value;
    var reg = /^(0\d{2,3}\d{7,8})(-\d{1,6})?$/;
    if (!reg.test(strVar)) {
    	ymPrompt.alert({message: "电话格式有误!正确格式如:01088888888或01088888888-8!", width: 330, height: 220, title: '提示信息'});
        //document.getElementById("telInfo").innerHTML = '电话格式有误!正确格式如:01088888888或01088888888-8!';
    } else {
    	
        //document.getElementById("telInfo").innerHTML = '<font color="green">联系电话可以使用!</font>';
    }
}

function checkPostPage(obj, type) {
    var val = obj.value;
    if (type == 'post') {
        if (val == "") {
        	ymPrompt.alert({message: "邮政编不能为空!正确格式,例如:101500", width: 330, height: 220, title: '提示信息'});
           // document.getElementById("postInfo").innerHTML = '邮政编不能为空!正确格式,例如:101500';
            return false;
        } else if (val.length != 6) {
        	ymPrompt.alert({message: "邮政编码长度不正确!正确格式,例如:101500", width: 330, height: 220, title: '提示信息'});
            //document.getElementById("postInfo").innerHTML = '邮政编码长度不正确!正确格式,例如:101500';
            return false;
        } else if (val.substring(0, 2) == "00") {
        	ymPrompt.alert({message: "邮政编码格式不正确!正确格式,例如:101500", width: 330, height: 220, title: '提示信息'});
           // document.getElementById("postInfo").innerHTML = '邮政编码格式不正确!正确格式,例如:101500';
            return false;
        } else {
        	
            //document.getElementById("postInfo").innerHTML = '<font color="green">邮政编码可以使用!</font>';
            return true;
        }
    } else {
        if (val != null && val != "") {
            if (val.length != 6) {
            	ymPrompt.alert({message: "邮政编码长度不正确!正确格式,例如:101500", width: 330, height: 220, title: '提示信息'});
               // document.getElementById("jbrPostInfo").innerHTML = '邮政编码长度不正确!正确格式,例如:101500';
                return false;
            } else if (val.substring(0, 2) == "00") {
            	ymPrompt.alert({message: "邮政编码格式不正确!正确格式,例如:101500", width: 330, height: 220, title: '提示信息'});
                //document.getElementById("jbrPostInfo").innerHTML = '邮政编码格式不正确!正确格式,例如:101500';
                return false;
            } else {
               // document.getElementById("jbrPostInfo").innerHTML = '<font color="green">邮政编码可以使用!</font>';
                return true;
            }
        }
        return false;
    }
}

function checkJbrTelPage(obj) {
    if (filterKeyUp()) {
        return;
    }
    if (/^[-0-9]*$/.test(obj.value)) {
        return;
    }
    obj.value = obj.value.replace(/[^-0-9]/g, '');
    var reg = /^((1[358]\d{9})|((0\d{2,3}-?)?\d{7,8}(-?\d{1,6})?))$/;
    if (!reg.test(obj.value)) {
    	ymPrompt.alert({message: "电话格式有误!正确格式如:03123456789-123或13123456789!", width: 330, height: 220, title: '提示信息'});
        //document.getElementById("jbrTelInfo").innerHTML = '<span style="color: red; ">电话格式有误!正确格式如:03123456789-123或13123456789!</span>';
    } else {
        //document.getElementById("jbrTelInfo").innerHTML = '<span style="color: green; ">联系电话可以使用!</span>';
    }
}

function judgeCodeName() {
	if($("#formType").val()=='1'){
		return '';
	}
	
    var e = document.getElementById("jgmc");
    var jgdm = document.getElementById("jgdm");
    if (jgdm == undefined || jgdm.value == '' || jgdm.value.trim() == 'null') {
        jgdm = document.getElementById("id");
    }
    if (e.value == "" || e.value == null) {
        //document.getElementById("mcInfo").innerHTML = '机构名称不能为空!';
    	   //document.getElementById("jgmc").parentElement.style.border = " solid red";
        return false;
    }
    /*if (e.value.realLength() > 240) {
     document.getElementById("mcInfo").innerHTML = '输入的机构名称字节不能大于240个字符或100个汉字，请修改!';
     e.value = e.value.zh_substr(0, 240);
     return false;
     }*/

    //判断用户名是否已被注册
    var flag = false;
    var sourceTable;
    dwr.engine.setAsync(false);
    var nameType = document.getElementById("nameType");
    if (nameType != undefined && nameType == 'check') {
        return '';
    }
    if (e && e.value) {
        tjgdmSaveBus.isExistCodeName(e.value, (jgdm && jgdm.value) ? jgdm.value : "", (nameType && nameType.value ) ? nameType.value : "", function (data) {
            if (data != '') {
                flag = true;
                sourceTable = data.split(':')[1];
            }
        });
        dwr.engine.setAsync(true);
        var emc = encodeURI(encodeURI(e.value));
        var hf = "/bsweb/certificate_jgmcList.action?jgmc=" + emc;
        if (flag == true) {
        
        		document.getElementById("mcInfo").innerHTML = '机构名称已经存在' + sourceTable + '里!&nbsp;<a style="text-decoration:underline;color:#0000ff;" target="_blank" href=' + hf + ' >查看</a>';
        		return '1';
        	
        } else {
            document.getElementById("mcInfo").innerHTML = '<font color="green"></font>';
            return '';
        }
    }

}
function addYzbm(){
  	 dwr.engine.setAsync(false);
  	 var dm=document.getElementById("xzqh").value;
  	tjgdmSaveBus.getYzbm(dm, function (value) {
           if (value != '') {
               value=value.split(":");
               document.getElementById("yzbm").value=value[0];
               document.getElementById("frdhhm").value=value[1]+"-";
               
           }
       });
  }
function addZgdm(){
 	 dwr.engine.setAsync(false);
 	 var dm=document.getElementById("zgmc").value;
 	tjgdmSaveBus.getZgdm(dm, function (value) {
          if (value != '') {
             
              document.getElementById("zgdm").value=value;
              
          }else{
        	  ymPrompt.alert({message: "没有找到对应的主管代码！", width: 330, height: 220, title: '提示信息'});
          }
      });
 }
function addZgmc(){
	 dwr.engine.setAsync(false);
	 var dm=document.getElementById("zgdm").value;
	tjgdmSaveBus.getZgmc(dm, function (value) {
         if (value != '') {
            
             document.getElementById("zgmc").value=value;
             
         }else{
        	 ymPrompt.alert({message: "没有找到对应的主管名称！", width: 330, height: 220, title: '提示信息'});
         }
     });
}
function judgeFddbr() {
    var jgdm = document.getElementById("jgdm");
    if (jgdm == undefined || jgdm.value == '' || jgdm.value.trim() == 'null') {
        jgdm = document.getElementById("id");
    }
    var fddbr = document.getElementById("fddbr").value;
    if (fddbr == null || fddbr == "") {
        //document.getElementById("fddbrInfo").innerHTML = '法人代表不能为空!';
        return false;
    }
    //判断法人代表是否已被注册
 /*   var flag = false;
    dwr.engine.setAsync(false);
    tjgdmSaveBus.isExistFrdb(fddbr, jgdm == undefined ? "" : jgdm.value, function (data) {
        if (data == true) {
            flag = true;
        }
    });
    dwr.engine.setAsync(true);
    if (flag == true) {
        fddbr = encodeURI(encodeURI(fddbr));
        var hf = '/bsweb/certificate_frdbList.action?fddbr=' + fddbr;
        document.getElementById("fddbrInfo").innerHTML = "法人代表已经存在!&nbsp;<a style='text-decoration:underline;color:#0000ff;' target='_blank' href=" + hf + " >查看</a>";
        return false;
    } else {
        document.getElementById("fddbrInfo").innerHTML = '<font color="green">法人代表可以使用!</font>';
        return true;
    }*/
}
function checkSj(url,name) {
    if (url.value != null && url.value != "") {
    	
    	if(url.value.length!=11){
    		ymPrompt.alert({message: "请输入有效的"+name+"手机号码！", width: 330, height: 220, title: '提示信息'});
    		return false;
    	}else if(url.value.substring(0,1)!=1||!(Number(url.value.substring(1,2))>=3&&Number(url.value.substring(1,2))<=9)){
    		ymPrompt.alert({message: "请输入有效的"+name+"手机号码！", width: 330, height: 220, title: '提示信息'});
    		return false;
    	}
    	else{
    		return true;
    	}
        /*if (Tools.isPhone(url.value)) {
            //warning.innerHTML = "";
            return true;
        } else {
        	ymPrompt.alert({message: "请输入有效的"+name+"手机号码！", width: 330, height: 220, title: '提示信息'});
            //warning.innerHTML = "请输入有效的手机号码！";
            return false;
        }*/
    
    }else {
    	//warning.innerHTML = "";
    	return true;
    }
}
function judgeFddbrZjh(jglx) {
	var sourceTable;
    var jgdm = document.getElementById("jgdm");
    if (jgdm == undefined || jgdm.value == '' || jgdm.value.trim() == 'null') {
        jgdm = document.getElementById("id");
    }
    var zjlx = document.getElementById("zjlx").value;
    var zjhm = document.getElementById("zjhm").value;
    if (zjhm == null || zjhm == "") {
    	//ymPrompt.alert({message: "证件号码不能为空!", width: 330, height: 220, title: '提示信息'});
        document.getElementById("zjhmInfo").innerHTML = '证件号码不能为空!';
        return false;
    }
    //判断证件号是否已被注册
    if(jglx!="2"){
    var flag = false;
    dwr.engine.setAsync(false);
    tjgdmSaveBus.isExistZjhm(zjlx, zjhm, jgdm == undefined ? "" : jgdm.value,jglx, function (data) {
        if (data != '') {
            flag = true;
            sourceTable = data.split(':')[1];
        }
       // flag = data;
    });

  /*  if (!flag && zjlx == 0 && zjhm.length == 18) {
        tjgdmSaveBus.isExistZjhm(zjlx, zjhm.substr(0, 6) + zjhm.substr(8, 9), jgdm == undefined ? "" : jgdm.value,jglx, function (data) {
            flag = data;
        });
    }*/
    dwr.engine.setAsync(true);
    if (flag == true) {
        zjhm = encodeURI(encodeURI(zjhm));
        var hf = '/bsweb/certificate_zjhmList.action?zjlx=' + zjlx + '&zjhm=' + zjhm;
        if(sourceTable=='有效库' || sourceTable=='临时库' ||  sourceTable=='代码有效库'){
        	
        	document.getElementById("zjhmInfo").innerHTML = "证件号码已经存在"+sourceTable+"里!&nbsp;<a style='text-decoration:underline;color:#0000ff;' target='_blank' href=" + hf + " >查看</a>";
        	return '0';
        }else{
        	document.getElementById("zjhmInfo").innerHTML = "证件号码已经存在"+sourceTable+"里!&nbsp;<a style='text-decoration:underline;color:#0000ff;' target='_blank' href=" + hf + " >查看</a>";
        	return '1';
        }
    } else {
      /*  if (zjlx == '0') {
            if (fCheckIdentify(document.getElementById("zjhm"))) {
                document.getElementById("zjhmInfo").innerHTML = '<font color="green">证件号码可以使用!</font>';
                return true;
            } else
                return false;
        } else {*/
            document.getElementById("zjhmInfo").innerHTML = '<font color="green">证件号码可以使用!</font>';
            return "2";
        //}
    }
   }
}
function checkSfzh(url,zjlx){
if (zjlx == '0') {
   /* if (fCheckIdentify(document.getElementById("zjhm"))) {
       // document.getElementById("zjhmInfo").innerHTML = '<font color="green">证件号码可以使用!</font>';
        return true;
    } else
        return false;
} else {
    //document.getElementById("zjhmInfo").innerHTML = '<font color="green">证件号码可以使用!</font>';
    return true;
  }*/
	if(url.value.length != 18){
		return false;
	}
	if (url.value.length == 18) {
        if (!fIsIDCheckCode(url.value, 18)) {
            /*ymPrompt.alert('输入的身份证号无效!', 330, 220, '提示信息', function (data) {
             if (data == "ok") {
             thisObject.focus();
             }
             });
             allValid = false;
             return allValid;*/

            /*if (!confirm("输入的"+title+"无效，您确认要保存吗？")) {
             thisObject.focus();
             return false;
             }*/
        /*	ymPrompt.alert(name+'身份证无效!', 330, 220, '提示信息', function (data) {
    			if (data == "ok") {
    				url.focus();
    			}
    		});*/
        		//ymPrompt.alert({message: "证件号码不能为空!", width: 330, height: 220, title: '提示信息'});
                //document.getElementById("jbrzjhmInfo").innerHTML = '经办人证件号码不符合国家编码规则，请确认是否输入正确!';
                return false;
            
        //}
    }
}else{
	return true;
}
}
return true;
}
function tbrZjh() {
    var jgdm = document.getElementById("jgdm");
    if (jgdm == undefined || jgdm.value == '' || jgdm.value.trim() == 'null') {
        jgdm = document.getElementById("id");
    }
    var zjlx = document.getElementById("tbrzjlx").value;
    var zjhm = document.getElementById("tbrsfzh").value;

    if (zjhm == null || zjhm == "") {
    	ymPrompt.alert({message: "证件号码不能为空!", width: 330, height: 220, title: '提示信息'});
        //document.getElementById("zjhmInfo").innerHTML = '证件号码不能为空!';
        return false;
    }
    //判断证件号是否已被注册
    /*var flag = false;
    dwr.engine.setAsync(false);
    tjgdmSaveBus.isExistZjhm(zjlx, zjhm, jgdm == undefined ? "" : jgdm.value, function (data) {
        flag = data;
    });

    if (!flag && zjlx == 0 && zjhm.length == 18) {
        tjgdmSaveBus.isExistZjhm(zjlx, zjhm.substr(0, 6) + zjhm.substr(8, 9), jgdm == undefined ? "" : jgdm.value, function (data) {
            flag = data;
        });
    }
    dwr.engine.setAsync(true);
    if (flag) {
        zjhm = encodeURI(encodeURI(zjhm));
        var hf = '/bsweb/certificate_zjhmList.action?zjlx=' + zjlx + '&zjhm=' + zjhm;
        document.getElementById("zjhmInfo").innerHTML = "证件号码已经存在!&nbsp;<a style='text-decoration:underline;color:#0000ff;' target='_blank' href=" + hf + " >查看</a>";
        return true;
    } else {
        if (zjlx == '0') {
            if (fCheckIdentify(document.getElementById("zjhm"))) {
                document.getElementById("zjhmInfo").innerHTML = '<font color="green">证件号码可以使用!</font>';
                return true;
            } else
                return false;
        } else {
            document.getElementById("zjhmInfo").innerHTML = '<font color="green">证件号码可以使用!</font>';
            return true;
        }
    }*/
}

function judgeZbrZjhm() {
    var strTbrsfzh = document.getElementById("tbrsfzh").value;
    //判断经办人证件号码是否为15,18位，如果是，则认为是身份证号
    if (strTbrsfzh.length == 15 || strTbrsfzh.length == 18) {
        fCheckIdentify(document.getElementById("tbrsfzh"));
    }
}

function copyAddress() {
    document.getElementById("jydz").value = document.getElementById("jgdz").value;
}
function copyZjhm() {
    document.getElementById("tbrsfzh").value = document.getElementById("zjhm").value;
    onCharsChange_tbrsfzh(document.getElementById("tbrsfzh"));
}

function checkPzjgmcByJglx() {
    var jglx = document.getElementById("jglx").value;
    var pzjgdm = document.getElementById("pzjgdm").value;
    dwr.engine.setAsync(false);
    var flag = false;
    ajaxBus.isLegal(jglx, pzjgdm, function (data) {
        if (data == 'false') {
            flag = false;
        } else
            flag = true;
    });
    return flag;
}

function judgeZch() {
    var e = document.getElementById("zch");
    var jglx = document.getElementById("jglx").value;
    if (jglx == 0) {
        document.getElementById("zchInfo").innerHTML = '机构类型不能为空!';
        return false;
    }
    var jjlx = document.getElementById("jjlx").value;
    var jgdm = document.getElementById("jgdm");
    var zchInfo = document.getElementById("zchInfo");
    if (jgdm == undefined || jgdm.value == '' || jgdm.value.trim() == 'null') {
        jgdm = document.getElementById("id");
    }
    var formType = document.getElementById("formType");
    var nameType = document.getElementById("nameType");
    if (e.value == "" || e.value == null) {
       /* document.getElementById("zchInfo").innerHTML = '注册号不能为空!';
        mes = "注册号不能为空!";*/
        return false;
    }
    //判断注册号是否已被注册
/*    var flag = false;
    var sourceTable;
    dwr.engine.setAsync(false);
    var evalue = e.value.toDBC();

    
    tjgdmSaveBus.isExistZch(evalue, jgdm == undefined ? "" : jgdm.value, jglx, formType == undefined ? "" : formType.value, nameType == undefined ? "" : nameType.value, function (data) {
        if (data != '') {
            flag = true;
            sourceTable = data.split(':')[1];
        }
    });
    if (flag == true) {
        zchInfo.innerHTML = "注册号已经存在" + sourceTable + "里!";
        mes = "注册号已经存在" + sourceTable + "里!";
        return false;
    }
    if (/^[12bB]$/.test(jglx.trim())) {
        tjgdmSaveBus.valifyZch(evalue, jjlx, function (data) {
            if (data == 'true') {
                zchInfo.innerHTML = '<font color="green">注册号可以使用!</font>';
            } else {
                flag = false;
                zchInfo.innerHTML = data.split(":")[1];
            }
        });
    }*/

    //dwr.engine.setAsync(true);
    return true;
}
function ajaxGet(value, name, label, dz) {
    var dm = document.getElementById(name);
    var mc = document.getElementById(name + "1");
    var mothod = label ? label : name;
    if(value!=""){
    ajaxBus.get(mothod, value, function (data) {
        if (data != null) {
            //document.getElementById("jydz").value = data.mc.trim();
            dm.value = value;
            if (data.mc) {
                //if (name == 'xzqh')
                //    document.getElementById("jgdz").value = data.mc.trim();
                mc.innerText = data.mc.length > 50 ? data.mc.substring(0, 50) + '...' : data.mc;
            }

            else
                mc.innerText = "未找到名称";
            if (dz) {
                var dzdm = document.getElementById(dz);
                var dzmc = document.getElementById(dz + "1");
                if (data.dzdm) {
                    dzdm.value = data.dzdm;
                } else {
                    dzdm.value = "";
                }
                if (data.dzmc)
                    dzmc.innerText = data.dzmc;
                else
                    dzmc.innerText = "未找到名称";
            }
        } else {
            dm.value = "";
            mc.innerText = "未找到名称";
        }
    });
    }
}
function fGetName(name, value) {
    dwr.engine.setAsync(false);
    if (name == 'wfgb') {
        ajaxGet(value, 'wftzgb', name);
    } else if (name == 'nnjjhy') {
        ajaxGet(value, name, name, 'njjhy');

    } else if (name == 'njjlx') {
        ajaxGet(value, name, name, 'jjlx');
    } else if (name == 'pzjgdm' || name == 'pzjg') {
        var bzjgdm = $("#bzjgdm").val();
        ajaxBus.getPzjg(value, bzjgdm, function (data) {
            if (data != null) {
                document.getElementById("pzjgdm").value = value;
                document.getElementById("pzjginfo").innerText = data.pzjgmc;
                document.getElementById("pzjgmc1").value = data.pzjgmc;
            } else {
                document.getElementById("pzjgdm").value = "";
                document.getElementById("pzjginfo").innerText = "未找到名称";
            }
        });
    } /*else if (name == 'zgjg') {
        ajaxBus.get("zgjg", value, function (data) {
            if (data != null) {
                document.getElementById("zgdm").value = value;
                if (data.mc)
                    document.getElementById("zgmc").value = data.mc;
                else
                    document.getElementById("zgmc").value = "";
            } else {
                document.getElementById("zgdm").value = "";
                document.getElementById("zgmc").value = "";
            }
        });
    } else if (name == 'zgmc') {
        ajaxBus.getZgjgByMc(value, function (data) {
            if (data && data.dm) {
                document.getElementById("zgdm").value = data.dm;
            }
            document.getElementById("zgmc").value = value;
        });
    }*/ else if (name.indexOf('zycp') >= 0) {
        ajaxGet(value, name, 'zycp'); 
    } else {
        ajaxGet(value, name);
    }
}
//公告弹出窗口 网页
function gonggaoPopUpWindow(name, strPage) {
    viewSubGonggaoDetail(strPage, name);
}

function viewSubGonggaoDetail(feeId, name) {
    if ('t_gg' == name) {
        ymPrompt.win({message: feeId, handler: callback, width: 600, height: 500, dragOut: false, title: '公告信息', iframe: true});
    }
    if ('t_atta' == name) {
        ymPrompt.win({message: feeId, handler: callback, width: 600, height: 500, dragOut: false, title: '添加附件', iframe: true});
    }

}


function selectUpWindow(name) {
    var names = name.split("_");
    if (names.length > 1) {
        name = names[1];
    }
    ymPrompt.win({message: "/bsweb/select_search.action?source=" + name, handler: callback, width: 630, height: 460, dragOut: false, title: '信息查询', iframe: true});

}

function emailCheck(email) {
    var re = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;
    if (email.value != null && email.value != "") {
        if (re.test(email.value)) {
            //warning.innerHTML = "";
            return true;
        } else {
        	ymPrompt.alert({message: "请输入有效的e-mail地址！", width: 330, height: 220, title: '提示信息'});
            //warning.innerHTML = "请输入有效的e-mail地址！";
            return false;
        }
    } else {
        //warning.innerHTML = "";
        return true;
    }

}
/**
 * @return {boolean}
 */
function URLCheck(url) {
    if (url && url.value&&url.value!='http://') {
        if (Tools.isURL(url.value)) {
            //warning.innerHTML = "";
            return true;
        } else {
        	ymPrompt.alert({message: "请输入有效的网址！", width: 330, height: 220, title: '提示信息'});
            //warning.innerHTML = "请输入有效的网址！";
            return false;
        }
    } else {
        //warning.innerHTML = "";
        return true;
    }
}
function mobileCheck(url,name) {
    if (url.value != null && url.value != "") {
        if (Tools.isPhone(url.value)) {
            //warning.innerHTML = "";
            return true;
        } else {
        	ymPrompt.alert({message: "请输入有效的"+name+"手机号码！", width: 330, height: 220, title: '提示信息'});
            //warning.innerHTML = "请输入有效的手机号码！";
            return false;
        }
    } else {
        //warning.innerHTML = "";
        return true;
    }
}
function telCheck(url,name) {
    if (url.value != null && url.value != "") {
        if (Tools.isTel(url.value)) {
            //warning.innerHTML = "";
            return true;
        } else {
        	ymPrompt.alert({message: "请输入有效的"+name+"座机号码！", width: 330, height: 220, title: '提示信息'});
            //warning.innerHTML = "请输入有效的手机号码！";
            return false;
        }
    } else {
        //warning.innerHTML = "";
        return true;
    }
}
function getGSData() {
    ymPrompt.win({message: '/bsweb/gsData_get?name=' + $("#jgmc").val(), width: 630, height: 460, dragOut: false, title: '信息查询', iframe: true, handler: function (data) {
        if (data != 'close' && data != '') {
            var values = data.split(';');
            $("#jgdz").val(values[0]);
            $("#dhhm").val(values[1]);
            $("#fddbr").val(values[2]);
            $("#zch").val(values[3]);
            $("#jyfw").val(values[4]);


        }
    }});
}
function callback(tp) {
    if (tp != 'close' && tp != '') {
        var values = tp.split(';');
        fGetName(values[0], values[1]);
    }
}
function addDate(dd,dadd){
	var a = new Date(dd)
	a = a.valueOf()
	a = a + dadd * 24 * 60 * 60 * 1000
	a = new Date(a)
	return a;
	}
	
	
function changeBzrq(thisobject) {

    var strBzrq;
    var strYear;
    var strOthers1;
    var iYear1;
    strBzrq = thisobject.value;
    var date = thisobject.value.split("-");
    strYear = strBzrq.substring(0, 4);
    strOthers1 = strBzrq.substring(4, 10);
    var njjzrq = document.getElementById("njjzrq");
    var njfs = document.getElementById("njfs");
    if (njjzrq && njfs && njfs.value && njfs.value == "1") {
        document.getElementById("njqx").value = ((new Date().getFullYear() + 1) + "-" + njjzrq.value.substr(0, 2) + "-" + njjzrq.value.substr(2, 3));
    } else {
        iYear1 = parseInt(strYear) + 1;
        //document.getElementById("njqx").value = iYear1.toString() + strOthers1;
    }
    var date2 = (Number(date[0]) + 4) + "-";
    date2 += (Number(date[1]).toString().length < 2 ? '0' : "");
    date2 += (Number(date[1])) + "-";
    date2 += ((Number(date[2]) - 1).toString().length < 2 ? '0' : "");
    date2 += Number(date[2]) - 1;
    
  //抓取現在日期
    strBzrq=strBzrq.replace(/\-/g, "/");
	var now = new Date(strBzrq);
	var years = now.getYear()+4;
	var months = now.getMonth()+1;
	var days = now.getDate();
	var hours = now.getHours();
	//抓取前一天日期
	NextNow = addDate(years+"/"+months+"/"+days,-1);
	years = NextNow.getYear();
	months = NextNow.getMonth()+1;
	days = NextNow.getDate();

	var txt=months<10?"0":"";
	var txtDay=days<10?"0":"";

	var date2 = (Number(date[0]) + 4) + "-"+txt+months+"-"+txtDay+days;
    document.getElementById("zfrq").value = date2;

}

$(function () {
    function toSBC() {
        if (filterKeyUp())
            return false;
        if (this.value != null) {
            this.value = this.value.toSBC();
        }
        return true;
    }

    $("input[readonly!=readonly]").bind('focus', function () {
        $(this).removeClass('input_off');
        $(this).addClass('input_on');
    }).bind('keyup blur ', function () {
        $(this).removeClass('input_on');
        $(this).addClass('input_off');
    });
    var gsfzrq = $("#gsfzrq");
    if (gsfzrq) {
        if (gsfzrq.val() == "1900-01-01") {
            gsfzrq.val("");
        }
    }
/*    var dhhm = $("#dhhm");
    if (dhhm) {
        dhhm.bind("keyup paste blur ", function () {
            var pou = $("input[name='charsmonitor_dhhm']");
            pou.val(this.value.length);
            if (filterKeyUp()) {
                return;
            }
            if (/^[-0-9]*$/.test(this.value)) {
                return;
            }
            this.value = this.value.replace(/[^-0-9]/g, '');
            pou.val(this.value.length);
        }).blur(function () {
            var reg = /^((1[358]\d{9})|((0\d{2,3}-?)?\d{7,8}(-?\d{1,6})?))$/;
            if (!reg.test(this.value)) {
            	//ymPrompt.alert({message: "电话格式有误!正确格式如:03123456789-123或13123456789!", width: 330, height: 220, title: '提示信息'});
                //document.getElementById("telInfo").innerHTML = '<span style="color: red; ">电话格式有误!正确格式如:03123456789-123或13123456789!</span>';
            } else {
               // document.getElementById("telInfo").innerHTML = '<span style="color: green; ">联系电话可以使用!</span>';
            }
        });
    }*/
 /*   var mobile = $("#mobile");
    
    if (mobile) {
        mobile.bind("keyup paste blur ", function () {
            var pou = $("input[name='charsmonitor_frsj']");
            pou.val(this.value.length);
            if (filterKeyUp()) {
                return;
            }
            if (/^[-0-9]*$/.test(this.value)) {
                return;
            }
            this.value = this.value.replace(/[^-0-9]/g, '');
            pou.val(this.value.length);
        }).blur(function () {
            var reg = /^(1[3458]\d{9})$/;
            if(mobile.val()!=""){
            if (!reg.test(this.value)) {
            	ymPrompt.alert({message: "非正确手机或电话格式!", width: 330, height: 220, title: '提示信息'});
                //document.getElementById("mobile_warning").innerHTML = '<span style="color: red; ">非正确手机或电话格式!</span>';
            } else {
                //document.getElementById("mobile_warning").innerHTML = '<span style="color: green; ">号码可以使用!</span>';
            }
            }
        });
    }*/
    var jglx = $("#jglx");
    if (jglx) {
        jglx.bind("select change", function () {
            dwr.engine.setAsync(false);
            var lx = jglx.val();
            if (lx == null || lx.trim() == "") {
                return;
            }
            if (lx == '1' || lx == '2' || lx == 'B') {
            	document.getElementById("memo2").value = "小型微型企业";
            }else{
            	document.getElementById("memo2").value = "";
            }
            btxBus.getBtx(lx.trim(), function (data) {
                $(".required").remove();
                $("#btxs").val(data);
                $(data).after('<span class="required">*</span>');
            });
            ajaxBus.getPzjgLegal(jglx, $("#bzjgdm").val(), function (data) {
                fGetName("pzjg", data);
            });
        });
    }
    var zjlx = $("#zjlx");
    if (zjlx) {
        zjlx.bind("change select", function () {
            return judgeFddbrZjh();
        });
    }
    var fbsl = $("#fbsl");
    if (fbsl) {
        fbsl.bind("keyup paste blur", function () {
            if (filterKeyUp())
                return true;
            if (this.value && this.value.length > 0 && !/^\d*$/.test(this.value)) {
                this.value = this.value.replace(/[\D\s]/gm, "");
                this.focus();
            }
            if (this.value && this.value.length > 0 && /^0+\d+$/.test(this.value)) {
                this.value = this.value.replace(/^0*(\d+)$/, "$1");
                this.focus();
            }
            return true;
        })
    }
    var jyfw = $("#jyfw");
    if (jyfw) {
        jyfw.bind("keyup", function () {
            if (filterKeyUp())
                return false;
            /*if (this.value != null) {
             this.value = this.value.toSBC();
             }*/
            showLength(this, document.getElementById("jyfwlength"), 2000);
            return true;
        }).bind("paste", function () {
            showLength(this, document.getElementById("jyfwlength"), 2000);
        }).bind("focus", function () {
            this.className = 'input_on';
        }).bind("blur", function () {
            this.className = 'input_off';
        });
    }
    var jydz = $("#jydz");
    if (jydz) {
        jydz.bind("keyup", function () {
            if (filterKeyUp())
                return false;
            /*if (this.value != null) {
             this.value = this.value.toSBC();
             }*/
            showLength(this, document.getElementById("jydzlength"), 2000);
            return true;
        }).bind("paste", function () {
            showLength(this, document.getElementById("jydzlength"), 2000);
        }).bind("focus", function () {
            this.className = 'input_on';
        }).bind("blur", function () {
            this.className = 'input_off';
        });
    }
    if (document.getElementById("njjhy") != null) {
        var njjhy = $("#njjhy");
        if (njjhy) {
            njjhy.blur(function () {
                fGetName('njjhy', this.value);
                return false;
            });
            njjhy.autocomplete({
                source: "/action/autoComplete?method=njjhy&rand=" + new Date().getTime(),
                select: function (event, ui) {
                    this.value = ui.item.dm;
                    fGetName('njjhy', ui.item == null ? "" : ui.item.dm);
                    return false;
                }/*,
                 change: function (event, ui) {
                 fGetName('njjhy', ui.item == null ? "" : ui.item.dm);
                 return false;
                 }*/
            });
            //折行格式
            /*$("#njjhy").data("autocomplete")._renderItem = function (ul, item) {return $("<li></li>").data("item.autocomplete", item).append("<a>" + item.dm + "<br>" + item.mc + "</a>").appendTo(ul);};*/
            njjhy.data("autocomplete")._renderItem = function (ul, item) {
                var a = document.getElementById("njjhy");
                a.value = a.value.toUpperCase();
                return $("<li></li>").data("item.autocomplete", item)
                    .append("<a style='width:188px;height:20px;'>"
                        + "<span style='float:left;'>" + item.dm
                        + "</span>" + "<span style='float:right;'>"
                        + (item.mc.length > 11 ? item.mc.substring(0, 10) + '...' : item.mc) + "</span>"
                        + "</a>").appendTo(ul);
            };
        }
    }

    if (document.getElementById("jjhy") != null) {
        var jjhy = $("#jjhy");
        if (jjhy) {
            jjhy.blur(function () {
                fGetName('jjhy', this.value);
            });
            jjhy.autocomplete({
                source: "/action/autoComplete?method=jjhy&rand=" + new Date().getTime(),
                select: function (event, ui) {
                    fGetName('jjhy', ui.item == null ? "" : ui.item.dm);
                    return false;
                }/*,
                 change: function (event, ui) {
                 fGetName('jjhy', ui.item == null ? "" : ui.item.dm);
                 return false;
                 }*/
            });
            jjhy.data("autocomplete")._renderItem = function (ul, item) {
                var a = document.getElementById("jjhy");
                a.value = a.value.toUpperCase();
                return $("<li></li>").data("item.autocomplete", item).append("<a style='width:188px;height:20px;'>" + "<span style='float:left;'>" + item.dm + "</span>" + "<span style='float:right;'>" + (item.mc.length > 11 ? item.mc.substring(0, 10) + '...' : item.mc) + "</span>" + "</a>").appendTo(ul);
            };
        }
    }

    if (document.getElementById("nnjjhy") != null) {
        var nnjjhy = $("#nnjjhy");
        if (nnjjhy) {
            nnjjhy.blur(function () {
                fGetName('nnjjhy', this.value);
                return false;
            });
            nnjjhy.autocomplete({
                source: "/action/autoComplete?method=nnjjhy&rand=" + new Date().getTime(),
                select: function (event, ui) {
                    fGetName('nnjjhy', ui.item == null ? "" : ui.item.dm);
                    return false;
                }/*,
                 change: function (event, ui) {
                 fGetName('nnjjhy', ui.item == null ? "" : ui.item.dm);
                 return false;
                 }*/
            });
            nnjjhy.data("autocomplete")._renderItem = function (ul, item) {
                var a = document.getElementById("nnjjhy");
                a.value = a.value.toUpperCase();
                return $("<li></li>").data("item.autocomplete", item).append("<a style='width:188px;height:20px;'>" + "<span style='float:left;'>" + item.dm + "</span>" + "<span style='float:right;'>" + (item.mc.length > 11 ? item.mc.substring(0, 10) + '...' : item.mc) + "</span>" + "</a>").appendTo(ul);
            };
        }
    }

    if (document.getElementById("njjlx") != null) {
        var njjlx = $("#njjlx");
        if (njjlx) {
            njjlx.blur(function () {
                fGetName('njjlx', this.value);
            });
            njjlx.autocomplete({
                source: "/action/autoComplete?method=njjlx&rand=" + new Date().getTime(),
                select: function (event, ui) {
                    fGetName('njjlx', ui.item == null ? "" : ui.item.dm);
                    return false;
                }/*,
                 change: function (event, ui) {
                 fGetName('njjlx', ui.item == null ? "" : ui.item.dm);
                 return false;
                 }*/
            });
            njjlx.data("autocomplete")._renderItem = function (ul, item) {
                return $("<li></li>").data("item.autocomplete", item).append("<a style='width:188px;height:20px;'>" + "<span style='float:left;'>" + item.dm + "</span>" + "<span style='float:right;'>" + (item.mc.length > 11 ? item.mc.substring(0, 10) + '...' : item.mc) + "</span>" + "</a>").appendTo(ul);
            };

        }
    }
    if (document.getElementById("jjlx") != null) {
        var jjlx = $("#jjlx");
        if (jjlx) {
            jjlx.blur(function () {
                fGetName('jjlx', this.value);
            });
            jjlx.autocomplete({
                source: "/action/autoComplete?method=jjlx&rand=" + new Date().getTime(),
                select: function (event, ui) {
                    fGetName('jjlx', ui.item == null ? "" : ui.item.dm);
                    return false;
                }/*,
                 change: function (event, ui) {
                 fGetName('jjlx', ui.item == null ? "" : ui.item.dm);
                 return false;
                 }*/
            });
            jjlx.data("autocomplete")._renderItem = function (ul, item) {
                return $("<li></li>").data("item.autocomplete", item).append("<a style='width:188px;height:20px;'>" + "<span style='float:left;'>" + item.dm + "</span>" + "<span style='float:right;'>" + (item.mc.length > 11 ? item.mc.substring(0, 10) + '...' : item.mc) + "</span>" + "</a>").appendTo(ul);
            };

        }
    }

    if (document.getElementById("nnjjlx") != null) {
        var nnjjlx = $("#nnjjlx");
        if (nnjjlx) {
            nnjjlx.blur(function () {
                fGetName('nnjjlx', this.value);
                return false;
            });
            nnjjlx.autocomplete({
                source: "/action/autoComplete?method=nnjjlx&rand=" + new Date().getTime(),
                select: function (event, ui) {
                    fGetName('nnjjlx', ui.item == null ? "" : ui.item.dm);
                    return false;
                }/*,
                 change: function (event, ui) {
                 fGetName('nnjjlx', ui.item == null ? "" : ui.item.dm);
                 return false;
                 }*/
            });
            nnjjlx.data("autocomplete")._renderItem = function (ul, item) {
                return $("<li></li>").data("item.autocomplete", item).append("<a style='width:188px;height:20px;'>" + "<span style='float:left;'>" + item.dm + "</span>" + "<span style='float:right;'>" + (item.mc.length > 11 ? item.mc.substring(0, 10) + '...' : item.mc) + "</span>" + "</a>").appendTo(ul);
            };
        }
    }


    var zgdm = $("#zgdm");
    if (zgdm) {
       /* zgdm.blur(function () {
            fGetName('zgjg', this.value);
            checkZgjgdm(this.value);
            return false;
        });
        zgdm.autocomplete({
            source: "/action/autoComplete?method=zgjg&rand=" + new Date().getTime(),
            select: function (event, ui) {
                fGetName('zgjg', ui.item == null ? "" : ui.item.dm);
                checkZgjgdm(this.value);
                return false;
            },
            change: function (event, ui) {
                fGetName('zgjg', ui.item == null ? $("#zgdm").val() : ui.item.dm);
                checkZgjgdm(this.value);
                return false;
            }

        });
        zgdm.data("autocomplete")._renderItem = function (ul, item) {
            return $("<li></li>").data("item.autocomplete", item).append("<a style='width:188px;height:20px;'>" + "<span style='float:left;'>" + item.dm + "</span>" + "<span style='float:right;'>" + (item.mc.length > 8 ? item.mc.substring(0, 8) + '...' : item.mc) + "</span>" + "</a>").appendTo(ul);
        };*/
    }
    var zgmc = $("#zgmc");
   if (zgmc) {
       /* zgmc.blur(function () {
            if (zgmc.val().realLength() > 200) {
                zgmc.val(zgmc.val().zh_substr(0, 200));
                ymPrompt.alert({message: "系统限制主管机构名称最长200字符或者100汉字!", width: 330, height: 220, title: '提示信息', handler: function (tp) {
                    if ("ok" == tp) {
                        zgmc.focus();
                    }
                }});

            }
            //    fGetName('zgmc', this.value);
            return false;
        });*/
    }

    if (document.getElementById("wftzgb") != null) {
        var wftzgb = $("#wftzgb");
        if (wftzgb) {
            wftzgb.blur(function () {
                fGetName('wfgb', this.value);
                return false;
            });
            wftzgb.autocomplete({
                source: "/action/autoComplete?method=wfgb&rand=" + new Date().getTime(),
                select: function (event, ui) {
                    fGetName('wfgb', ui.item == null ? "" : ui.item.dm);
                    return false;
                }/*,
                 change: function (event, ui) {
                 fGetName('wfgb', ui.item == null ? "" : ui.item.dm);
                 //$('#wftzgb1').html(ui.item==null?"":ui.item.mc);
                 return false;
                 }*/
            });
            wftzgb.data("autocomplete")._renderItem = function (ul, item) {
                return $("<li></li>").data("item.autocomplete", item).append("<a style='width:188px;height:20px;'>" + "<span style='float:left;'>" + item.dm + "</span>" + "<span style='float:right;'>" + (item.mc.length > 11 ? item.mc.substring(0, 10) + '...' : item.mc) + "</span>" + "</a>").appendTo(ul);
            };
        }
    }

    var xzqh = $("#xzqh");
    if (xzqh) {
        xzqh.change(function () {
            if (xzqh.attr("readonly")) {
                return false;
            }
            fGetName('xzqh', this.value);
            return false;
        });
        xzqh.autocomplete({
            source: "/action/autoComplete?method=xzqh&rand=" + new Date().getTime(),
            select: function (event, ui) {
                fGetName('xzqh', ui.item == null ? "" : ui.item.dm);
                return false;
            }/*,
             change: function (event, ui) {
             ui.item == null ? fGetName('xzqh', ui.item == null ? "" : this.value) : "";
             return false;
             }*/
        });
        xzqh.data("autocomplete")._renderItem = function (ul, item) {
            return $("<li></li>").data("item.autocomplete", item).append("<a style='width:188px;height:20px;'>" + "<span style='float:left;'>" + item.dm + "</span>" + "<span style='float:right;'>" + (item.mc.length > 10 ? item.mc.substring(0, 9) + '...' : item.mc) + "</span>" + "</a>").appendTo(ul);
        };
    }

    /*var jgmc = $("#jgmc,#fddbr,#jgdz").keyup(toSBC);*/
    var fddbr = $("#fddbr");
    if (fddbr) {
        fddbr.change(function () {
            $("#zjhm").val("");
        });
    }
    var pzjgdm = $("#pzjgdm");
    if (pzjgdm) {
        pzjgdm.blur(function () {
            fGetName('pzjgdm', this.value);
            return false;
        });
        pzjgdm.autocomplete({
            source: "/action/autoComplete?method=pzjg&rand=" + new Date().getTime() + "&bzjgdm=" + $("#bzjgdm").val(),
            select: function (event, ui) {
                fGetName('pzjgdm', ui.item == null ? "" : ui.item.dm);
                return false;
            }
        });
      /*  pzjgdm.data("autocomplete")._renderItem = function (ul, item) {
            return $("<li></li>").data("item.autocomplete", item).append("<a style='width:188px;height:20px;'>" + "<span style='float:left;'>" + item.dm + "</span>" + "<span style='float:right;'>" + (item.mc.length > 9 ? item.mc.substring(0, 8) + '...' : item.mc) + "</span>" + "</a>").appendTo(ul);
        };*/
    }

    if (document.getElementById("zycp1") != null) {
        var zycp1 = $("#zycp1");
        if (zycp1) {
            zycp1.blur(function () {
                fGetName('zycp1', this.value);
                return false;
            });
            zycp1.autocomplete({
                source: "/action/autoComplete?method=zycp&rand=" + new Date().getTime(),
                select: function (event, ui) {
                    fGetName('zycp1', ui.item == null ? "" : ui.item.dm);
                    return false;
                }/*,
                 change: function (event, ui) {
                 fGetName('zycp1', ui.item == null ? "" : ui.item.dm);
                 return false;
                 }*/
            });
            zycp1.data("autocomplete")._renderItem = function (ul, item) {
                return $("<li></li>").data("item.autocomplete", item).append("<a style='width:188px;height:20px;'>" + "<span style='float:left;'>" + item.dm + "</span>" + "<span style='float:right;'>" + (item.mc.length > 11 ? item.mc.substring(0, 10) + '...' : item.mc) + "</span>" + "</a>").appendTo(ul);
            };
        }
    }

    if (document.getElementById("zycp2") != null) {
        var zycp2 = $("#zycp2");
        if (zycp2) {
            zycp2.blur(function () {
                fGetName('zycp2', this.value);
                return false;
            });
            zycp2.autocomplete({
                source: "/action/autoComplete?method=zycp&rand=" + new Date().getTime(),
                select: function (event, ui) {
                    fGetName('zycp2', ui.item == null ? "" : ui.item.dm);
                    return false;
                }/*,
                 change: function (event, ui) {
                 fGetName('zycp2', ui.item == null ? "" : ui.item.dm);
                 return false;
                 }*/
            });
            zycp2.data("autocomplete")._renderItem = function (ul, item) {
                return $("<li></li>").data("item.autocomplete", item).append("<a style='width:188px;height:20px;'>" + "<span style='float:left;'>" + item.dm + "</span>" + "<span style='float:right;'>" + (item.mc.length > 11 ? item.mc.substring(0, 10) + '...' : item.mc) + "</span>" + "</a>").appendTo(ul);
            };
        }
    }

    if (document.getElementById("zycp3") != null) {
        var zycp3 = $("#zycp3");
        if (zycp3) {
            zycp3.blur(function () {
                fGetName('zycp3', this.value);
                return false;
            });
            zycp3.autocomplete({
                source: "/action/autoComplete?method=zycp&rand=" + new Date().getTime(),
                select: function (event, ui) {
                    fGetName('zycp3', ui.item == null ? "" : ui.item.dm);
                    return false;
                }/*,
                 change: function (event, ui) {
                 fGetName('zycp3', ui.item == null ? "" : ui.item.dm);
                 return false;
                 }*/
            });
            zycp3.data("autocomplete")._renderItem = function (ul, item) {
                return $("<li></li>").data("item.autocomplete", item).append("<a style='width:188px;height:20px;'>" + "<span style='float:left;'>" + item.dm + "</span>" + "<span style='float:right;'>" + (item.mc.length > 11 ? item.mc.substring(0, 10) + '...' : item.mc) + "</span>" + "</a>").appendTo(ul);
            };
        }
    }
});

function fChangeDangJian(type){
	
	if(type=='0'){
		
		$("#jbxx").show();
		$("#fddbrxx").hide();
		$("#jbxxwh").show();
		$("#frxxwh").hide();
		}else if(type=='1'){
		
			$("#jbxx").hide();
			$("#fddbrxx").show();
			$("#jbxxwh").hide();
			$("#frxxwh").show();
			}else{
				$("#jbxx").show();
				$("#fddbrxx").show();
				$("#jbxxwh").show();
				$("#frxxwh").show();
			}
}
function copy(){
	document.getElementById("tbrxm").value=document.getElementById("fddbr").value;
	document.getElementById("tbrsfzh").value=document.getElementById("zjhm").value;
	document.getElementById("tbrmobile").value=document.getElementById("mobile").value;
	document.getElementById("tbrlxfs").value=document.getElementById("frdhhm").value;
	var jj="";
	var jjid="";
	jjid=document.getElementById("zjlx").value;
	var jjhy=document.getElementById("tbrzjlx");
	
	for(var i=0;i<jjhy.options.length;i++){
		
			jj=jjhy.options[i].value;
			
		
		if(jj == jjid){
			
			jjhy.options[i].selected=true;
		
			}
		}
}
function copyFr(){
	document.getElementById("fzrXm").value=document.getElementById("fddbr").value;
	document.getElementById("fzrZjhm").value=document.getElementById("zjhm").value;
	document.getElementById("fzrMobile").value=document.getElementById("mobile").value;
	document.getElementById("fzrLxdh").value=document.getElementById("frdhhm").value;
	var jj="";
	var jjid="";
	jjid=document.getElementById("zjlx").value;
	var jjhy=document.getElementById("ryzjlx");
	
	for(var i=0;i<jjhy.options.length;i++){
		
		jj=jjhy.options[i].value;
		
		
		if(jj == jjid){
			
			jjhy.options[i].selected=true;
			
		}
	}
}
