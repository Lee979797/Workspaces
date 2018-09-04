/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-5-30
 * Time: 下午1:45
 * To change this template use File | Settings | File Templates.
 */
function checkform()
{
	if(!checkaddress())
	{
		return false;
	}else if(!checklinkman())
	{
		return false;
	}else if(!checkpost())
	{
		return false;
	}else if(!checktel())
	{
		return false;
	}else if(!checkemail())
	{
		return false;
	}else if(!checkaddress())
	{
		return false;
	}else if(!checkrevenueid())
	{
		return false;
	}else if(!checkfax()){
        return false;
    }else if(!checkCodeEn()){
        return false;
    }else if(!checkMemo()){
        return false;
    }else{
        var flag = null;
	    dwr.engine.setAsync(false);
        for(var i=0;i<document.getElementsByTagName("input").length;i++){
            if(document.getElementsByTagName("input")[i].value.length>0&&document.getElementsByTagName("input")[i].alt=="badword"){
                ForbidUtil.getBadWords(document.getElementsByTagName("input")[i].value,{callback:function(dwrreturn){
                        flag=dwrreturn;
                    }
                });
            }
            if(flag!=""&&flag!=null){
                ymPrompt.alert({message:"请去除输入框中的不文明用语或敏感词:", width:330, height:220, title:'提示信息'});
                document.getElementsByTagName("input")[i].focus();
                return false;
	        }
        }
        ForbidUtil.getBadWords(document.form1.memo.value,{callback:function(dwrreturn){
                flag=dwrreturn;
	        }
	    });
        if(flag!=""&&flag!=null){
            ymPrompt.alert({message:"请去除备注中的不文明用语或敏感词:", width:330, height:220, title:'提示信息'});
            return false;
        }
    }
    for(var i=0;i<document.getElementsByTagName("input").length;i++){
        if(!isEmpty(document.getElementsByTagName("input")[i].value)){
            trimIntputValue(document.getElementsByTagName("input")[i]);
        }
    }
	document.form1.submit();
    document.form1.botton1.disabled = true;
}

function checkEmpty(gotopage){
    var flag = false;//判断用户是否填写了信息
    for(var i=0;i<document.getElementsByTagName("input").length;i++){
        if(document.getElementsByTagName("input")[i].alt=="badword"){
            if(!isEmpty(document.getElementsByTagName("input")[i].value)){
                 flag = true;
                 break;
            }
        }
    }
    if(!isEmpty(document.form1.memo.value)){
         flag = true;
    }
    if(flag){
        //确认填写信息是否保存
       ymPrompt.confirmInfo('您现在要填写其他信息，此页信息是否保存?',330,220,'提示信息',function (data){if(data == 'ok'){
            return false;
        }else{
            window.location.href=gotopage;
        }
        }
        ) ;
        return false;
    }else{
        window.location.href=gotopage;
    }
}

function checkaddress()
{
	if(isEmpty(document.getElementById('address').value))
	{
		ymPrompt.alert({message:'生产厂址不能为空！', width:330, height:220, title:'提示信息'});
		return false;
	}
	else
	{
        trimIntputValue(document.getElementById('address'));
		return true;
	}
}

function checklinkman(){
   if(isEmpty(document.getElementById('linkman').value))
	{
		ymPrompt.alert({message:'联系人不能为空！', width:330, height:220, title:'提示信息'});
		return false;
	}
	else
	{
        trimIntputValue(document.getElementById('linkman'));
		return true;
	}
}

function checkrevenueid()
{
	if(!isEmpty(document.getElementById('revenueid').value))
	{
		trimIntputValue(document.getElementById('revenueid'));
		return true;
	}else
        return true;

}

function checkpost()
{
	if(isEmpty(document.getElementById('post').value))
	{
		ymPrompt.alert({message:'邮政编码不能为空！', width:330, height:220, title:'提示信息'});
		return false;
	}else if(!isPostCode(document.getElementById('post').value)){
        ymPrompt.alert({message:'邮政编码格式不对！', width:330, height:220, title:'提示信息'});
		return false;
    }else
	{
        trimIntputValue(document.getElementById('post'));
		return true;
	}
}

function checkfax(){
    if(!isEmpty(document.getElementById('fax').value)){
       if(!checkTel(document.getElementById('fax').value)){
            ymPrompt.alert({message:'传真格式不正确！', width:330, height:220, title:'提示信息'});
            return false;
       }else
            return true;
    }else{
        trimIntputValue(document.getElementById('fax'));
        return true;
    }
}

function checkCodeEn(){
    if(!isEmpty(document.getElementById('codeen').value)){
        if(!isChinese(document.getElementById('codeen').value))
        {
            ymPrompt.alert({message:'不能输入汉字！', width:330, height:220, title:'提示信息'});
            return false
        }else
            return true;
    }else
        return true;
}

function checkMemo(){
    if(document.getElementById('memo').value.length>200)
    {
        ymPrompt.alert({message:'备注太长，字数不得超过200个字！', width:330, height:220, title:'提示信息'});
        return false;
    }else
        return true;
}

function isChinese(strTemp)
{

    var i;
    for(i=0;i<strTemp.length;i++)
    {
        if((strTemp.charCodeAt(i)<0)||(strTemp.charCodeAt(i))>255)
        {
            return false;
        }
    }
    return true;
}

function checktel()
{
	if(isEmpty(document.getElementById('tel').value))
	{
		ymPrompt.alert({message:'联系电话不能为空！', width:330, height:220, title:'提示信息'});
		return false;
	}else if(!checkTel(document.getElementById('tel').value)){
        return false;
    }else
	{
        trimIntputValue(document.getElementById('tel'));
		return true;
	}
}

//function checkzlfzrtel(){
//    if(!isEmpty(document.getElementById('zlfzrlxfs').value)){
//       if(!checkTel(document.getElementById('zlfzrlxfs').value)){
//            ymPrompt.alert({message:'负责人联系电话格式不正确！', width:330, height:220, title:'提示信息'});
//            return false;
//       }else
//            return true;
//    }else
//        return true;
//}

function checkTel(tel){
var reg=/^[\d|\-|\s|\_]+$/;
var isOk = reg.test(tel);
if(isOk==false){
   ymPrompt.alert({message:'联系电话格式不正确！', width:330, height:220, title:'提示信息'});
}else{

}
if(isOk && tel.indexOf("-")<0){
   isOk = checkmobile(tel);
}else if(isOk && tel.indexOf("-")>0){
   var firstTel = tel.substring(tel.indexOf("-"));
   if(firstTel.length>1){
    firstTel = firstTel.substring(1);
    if(firstTel.indexOf("-")<0){
     if(firstTel.length!=7 && firstTel.length!=8){
         isOk = isOk && false;
         ymPrompt.alert({message:'区号后电话长度不对！', width:330, height:220, title:'提示信息'});
     }
    }else{
     firstTel = firstTel.substring(0,firstTel.indexOf("-"));
     if(firstTel.length!=7 && firstTel.length!=8){
         isOk = isOk && false;
         ymPrompt.alert({message:'区号后电话长度不对！', width:330, height:220, title:'提示信息'});
     }
    }
   }else{
        isOk = isOk && false;
       ymPrompt.alert({message:'区号后电话长度不对！', width:330, height:220, title:'提示信息'});
   }
}
return isOk;
};

function checkmobile(mob){
    //手机判断
    var reg0=/^13\d{5,9}$/;   //130--139。至少7位
    var reg1=/^153\d{4,8}$/;  //联通153。至少7位
    var reg2=/^159\d{4,8}$/;  //移动159。至少7位
    var reg3=/^189\d{4,8}$/;  //电信
    var reg4=/^158\d{4,8}$/;
    var my=false;
    if (reg0.test(mob))my=true;
    if (reg1.test(mob))my=true;
    if (reg2.test(mob))my=true;
    if (reg3.test(mob))my=true;
    if (reg4.test(mob))my=true;
    if (!my){
        ymPrompt.alert({message:'对不起，您输入的联系电话错误！', width:330, height:220, title:'提示信息'});
    }
    return my;
}

function checkemail()
{
	var flag = true;
	var _email =document.getElementById('email').value;
	if(!isEmpty(_email))
	{
		if(!checkEmail(_email))
		{
			ymPrompt.alert({message:'E-Mail格式不正确！', width:330, height:220, title:'提示信息'});

			flag = false;
		}
	}
	return flag;

}

function uploadenterpriseImg(){
    var _codeid= document.getElementById('codeid').value;
	if(_codeid==null||_codeid=="") return ;
    var _brandcn  = document.getElementById('brandcn').value;
	var strs= new Array();
	strs= 	_brandcn.split(",");
	if(strs.length >=3)
	{
		ymPrompt.alert({message:'最多只能上传3张商标图片，不能再进行上传！', width:330, height:220, title:'提示信息'});
		return ;
	}
    tanchuceng(660,450,'上传企业商标图片','uploadenterpriseImages.jsp?codeid='+_codeid);
}

function  setsbImg(codeid,oper)
{
    var isIE=!!window.ActiveXObject;  //判断是否为IE浏览器
    var isIE6=isIE&&!window.XMLHttpRequest;
    var isIE8=isIE&&!!document.documentMode;
    var isIE7=isIE&&!isIE6&&!isIE8;
    dwr.engine.setAsync(false);
    var _cpsb="";
    enterpriseImage.findEnterprisesbImageByCodeid(codeid,"1","1",function(data){
		var _html="<div class=\"updatpic_top\"></div>";
		 if(data.length>0)
		 {

			for(var i =1;i<=data.length;i++)
			{
				if(i==1)
				{
					_cpsb+=data[i-1].memo3;
				}
				else
				{
					_cpsb=_cpsb+","+data[i-1].memo3;
				}
				var storage=data[i-1].storage;

				if(data[i-1].storage.lastIndexOf(".")==data[i-1].storage.length-1)
				{
					storage="./images/none.jpg";
				}
				_html=_html+"<a href=\"javascript:void(0);\"><img src=\""+storage+"\" alt=\""+data[i-1].memo3+" "+data[i-1].memo4+"\" width=\"35\" height=\"35\" style=\"padding-right:2px;cursor:pointer\"  onclick=\"clickImg('"+data[i-1].eid+"',this);\" /></a>"
			}
		}
		document.getElementById("divsbimg").innerHTML=_html;
		document.getElementById('brandcn').value=_cpsb;
        if(isIE){
              parent.document.all.main.height   =   document.body.scrollHeight;
        }
    });
    dwr.engine.setAsync(true);
    enterprisetest.updateCpsb(codeid,_cpsb,function(data){
    });
}

function deleteImage()
{
	var _imageid = document.getElementById('enterpriseid').value;
	var codeid = document.getElementById('codeid').value;
	if(_imageid!="")
	{
		ymPrompt.confirmInfo('您确认删除该图片信息吗?',330,220,'提示信息',function (data){
		if(data == 'ok')
		{

			enterpriseImage.deleteEnterpriseImageByImageId(_imageid,function(data){
						if(data==true)
							setsbImg(codeid,'delete');
				});

		}
		else
		{
			return false;
		}
		});
	}else{
        ymPrompt.alert({message:'请选择要删除的图片！', width:330, height:220, title:'提示信息'});
    }
	document.getElementById('enterpriseid').value="";
}

var selectedObject="" ;
function  clickImg(eid,obj)
{
	if(selectedObject=="")
	{
		selectedObject=obj;

	}else
	{
		selectedObject.style.width='35px';
		selectedObject.style.height='35px';
		selectedObject=obj;
	}
	obj.style.width='45px';
	obj.style.height='45px';

	document.getElementById('enterpriseid').value=eid;
    parent.document.all.main.height   =   document.body.scrollHeight;

}

//iframe弹出层
function tanchuceng(width, height, tit, url) {
    var winWinth =$(window).width(), winHeight = $(document).height();
    $("body").append("<div class='winbj' id='winbj'></div>");
    $("body").append("<div class='tanChu'><div class='tanChutit'><span class='tanchuTxt'>" + tit + "</span><span class='tanchuClose' id='haojyclose'><img src='./js/alert/skin/dmm-green/images/close.gif'></span></div><iframe class='winIframe' frameborder='0' hspace='0' src=" + url + "></iframe></div>");
    $(".winbj").css({ width: winWinth, height: winHeight, background: "#000", position: "absolute", left: "0", top: "0" });
    $(".winbj").fadeTo(0, 0.1);
    var tanchuLeft = $(window).width() / 2 - width / 2;
    var tanchuTop = $(window).height() / 2 - height / 2 + $(window).scrollTop();
    $(".tanChu").css({ width: width, height: height, border: "3px #739DD3 solid", left: tanchuLeft, top: tanchuTop, background: "#739DD3", position: "absolute" });
    $(".tanChutit").css({ width: width, height: "25px", "border-bottom": "1px #739DD3 solid", background: "#739DD3", "line-height": "25px" });
    $(".tanchuTxt").css({ "text-indent": "5px", "float": "left", "font-size": "12px","color": "#fff"});
    $(".tanchuClose").css({ "width": "40px", "float": "right", "font-size": "12px", "color": "#fff", "cursor": "pointer" });
    var winIframeHeight = height - 26;
    $(".winIframe").css({ width: width, height: winIframeHeight, "border-bottom": "1px #739DD3 solid", background: "#ffffff" });
    $(".tanchuClose").hover(
       function() {
           $(this).css("color", "#8E7D99");
       }, function() {
           $(this).css("color", "#666");
       }
      );
    $(".tanchuClose").click(function() {
        $(".winbj").remove();
        $(".tanChu").remove();
    });
}
//iframe弹出层end

window.onresize=function(){
try
{
document.getElementById('winbj').style.width="100%";
}catch(e){}
}


function privewEnterpriseImage()
{

	var _eid = document.getElementById('enterpriseid').value;
	if(_eid!="")
	{
		window.open('privewEnterpriseImage.jsp?eid='+_eid);

	}else
	{
			ymPrompt.alert({message:'请先选择图片再进行预览！', width:330, height:220, title:'提示信息'});

	}


}