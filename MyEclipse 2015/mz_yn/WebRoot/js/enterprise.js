/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-5-30
 * Time: ����1:45
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
                ymPrompt.alert({message:"��ȥ��������еĲ�������������д�:", width:330, height:220, title:'��ʾ��Ϣ'});
                document.getElementsByTagName("input")[i].focus();
                return false;
	        }
        }
        ForbidUtil.getBadWords(document.form1.memo.value,{callback:function(dwrreturn){
                flag=dwrreturn;
	        }
	    });
        if(flag!=""&&flag!=null){
            ymPrompt.alert({message:"��ȥ����ע�еĲ�������������д�:", width:330, height:220, title:'��ʾ��Ϣ'});
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
    var flag = false;//�ж��û��Ƿ���д����Ϣ
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
        //ȷ����д��Ϣ�Ƿ񱣴�
       ymPrompt.confirmInfo('������Ҫ��д������Ϣ����ҳ��Ϣ�Ƿ񱣴�?',330,220,'��ʾ��Ϣ',function (data){if(data == 'ok'){
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
		ymPrompt.alert({message:'������ַ����Ϊ�գ�', width:330, height:220, title:'��ʾ��Ϣ'});
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
		ymPrompt.alert({message:'��ϵ�˲���Ϊ�գ�', width:330, height:220, title:'��ʾ��Ϣ'});
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
		ymPrompt.alert({message:'�������벻��Ϊ�գ�', width:330, height:220, title:'��ʾ��Ϣ'});
		return false;
	}else if(!isPostCode(document.getElementById('post').value)){
        ymPrompt.alert({message:'���������ʽ���ԣ�', width:330, height:220, title:'��ʾ��Ϣ'});
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
            ymPrompt.alert({message:'�����ʽ����ȷ��', width:330, height:220, title:'��ʾ��Ϣ'});
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
            ymPrompt.alert({message:'�������뺺�֣�', width:330, height:220, title:'��ʾ��Ϣ'});
            return false
        }else
            return true;
    }else
        return true;
}

function checkMemo(){
    if(document.getElementById('memo').value.length>200)
    {
        ymPrompt.alert({message:'��ע̫�����������ó���200���֣�', width:330, height:220, title:'��ʾ��Ϣ'});
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
		ymPrompt.alert({message:'��ϵ�绰����Ϊ�գ�', width:330, height:220, title:'��ʾ��Ϣ'});
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
//            ymPrompt.alert({message:'��������ϵ�绰��ʽ����ȷ��', width:330, height:220, title:'��ʾ��Ϣ'});
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
   ymPrompt.alert({message:'��ϵ�绰��ʽ����ȷ��', width:330, height:220, title:'��ʾ��Ϣ'});
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
         ymPrompt.alert({message:'���ź�绰���Ȳ��ԣ�', width:330, height:220, title:'��ʾ��Ϣ'});
     }
    }else{
     firstTel = firstTel.substring(0,firstTel.indexOf("-"));
     if(firstTel.length!=7 && firstTel.length!=8){
         isOk = isOk && false;
         ymPrompt.alert({message:'���ź�绰���Ȳ��ԣ�', width:330, height:220, title:'��ʾ��Ϣ'});
     }
    }
   }else{
        isOk = isOk && false;
       ymPrompt.alert({message:'���ź�绰���Ȳ��ԣ�', width:330, height:220, title:'��ʾ��Ϣ'});
   }
}
return isOk;
};

function checkmobile(mob){
    //�ֻ��ж�
    var reg0=/^13\d{5,9}$/;   //130--139������7λ
    var reg1=/^153\d{4,8}$/;  //��ͨ153������7λ
    var reg2=/^159\d{4,8}$/;  //�ƶ�159������7λ
    var reg3=/^189\d{4,8}$/;  //����
    var reg4=/^158\d{4,8}$/;
    var my=false;
    if (reg0.test(mob))my=true;
    if (reg1.test(mob))my=true;
    if (reg2.test(mob))my=true;
    if (reg3.test(mob))my=true;
    if (reg4.test(mob))my=true;
    if (!my){
        ymPrompt.alert({message:'�Բ������������ϵ�绰����', width:330, height:220, title:'��ʾ��Ϣ'});
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
			ymPrompt.alert({message:'E-Mail��ʽ����ȷ��', width:330, height:220, title:'��ʾ��Ϣ'});

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
		ymPrompt.alert({message:'���ֻ���ϴ�3���̱�ͼƬ�������ٽ����ϴ���', width:330, height:220, title:'��ʾ��Ϣ'});
		return ;
	}
    tanchuceng(660,450,'�ϴ���ҵ�̱�ͼƬ','uploadenterpriseImages.jsp?codeid='+_codeid);
}

function  setsbImg(codeid,oper)
{
    var isIE=!!window.ActiveXObject;  //�ж��Ƿ�ΪIE�����
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
		ymPrompt.confirmInfo('��ȷ��ɾ����ͼƬ��Ϣ��?',330,220,'��ʾ��Ϣ',function (data){
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
        ymPrompt.alert({message:'��ѡ��Ҫɾ����ͼƬ��', width:330, height:220, title:'��ʾ��Ϣ'});
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

//iframe������
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
//iframe������end

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
			ymPrompt.alert({message:'����ѡ��ͼƬ�ٽ���Ԥ����', width:330, height:220, title:'��ʾ��Ϣ'});

	}


}