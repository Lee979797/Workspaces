//欄位變色
 var bgColorOther = "#8080FF";
 
 
 
// 以唯一id取得该对象
function getbyid(objid){
	return document.getElementById(objid);
}

// 給指定的select添加新的option選項 optionIndex插入位置
function addOption(objSelect,optionVal,optionText,optionIndex){
 var  _o=document.createElement("Option");  
 _o.text=optionText;
 _o.value=optionVal; 
 objSelect.add(_o,optionIndex);
}

// 删除select中的某个value
function removeOption(objSelect,optionVal){
	if(objSelect==null)return;
	for(i=0;i<objSelect.length;i++){
		if(objSelect.options[i].value==optionVal){
			objSelect.remove(i);
		}
	}
}

// 设置select控件选中为哪项 obj:select控件 strval:option的value值
function setSelect(obj,strval){
	if(obj!=null){
		for(i=0;i<obj.options.length;i++){
			if(obj.options[i].value==strval){
				obj.options[i].selected=true;
				return;
			}
		}
	}
}

// 将str中的str1全部替换为str2
function replaceAll(str,str1,str2){
	while(str.indexOf(str1)!=-1){
		str=str.replace(str1,str2);
	}
	return str;
}

// 检查并调整件t的时间格式为yyyy-mm-dd的形式
function checkDate(t) {
	var tval=t.value;
	tval=replaceAll(replaceAll(tval,".","/"),"-","/")
	dDate = new Date(tval);
	if (dDate == "NaN") {t.value = ""; return;}
 
	iYear = dDate.getFullYear()

	if ((iYear > 1899)&&(iYear < 1950)) {

		sYear = "" + iYear + ""
		if (t.value.indexOf(sYear,1) == -1) {
			iYear += 100
			sDate = (dDate.getMonth() + 1) + "/" + dDate.getDate() + "/" + iYear
			dDate = new Date(sDate)
		}
	}
	t.value = formatDate(dDate);
}

function formatDate(sDate) {
	var sScrap = "";
	var dScrap = new Date(sDate);
	if (dScrap == "NaN") return sScrap;
	
	iDay = dScrap.getDate();
	iMon = dScrap.getMonth();
	iYea = dScrap.getFullYear();
        
        if ((iMon + 1) < 10)
        {
            sScrap = iYea + "-0" + (iMon + 1);
        }
        else
        {
            sScrap = iYea + "-" + (iMon + 1);
        }
        
        if ((iDay) < 10)
        {
            sScrap = sScrap + "-0" + iDay;
        }
        else
        {
            sScrap = sScrap + "-" + iDay;
        }
        
	//sScrap = iYea + " / " + (iMon + 1) + " / " + iDay ;
	return sScrap;
}

// 检查所有必输入项目 若有为空的 则使其变为蓝色 str为用 $ 符号区分的所有待检查的控件的name值
function needcheck(str){
	var flg=true;
	var objnames = str.split("$");
	if(objnames==null)return true;
	for(i=0;i<objnames.length;i++){
		var objs = document.getElementsByName(objnames[i]);
		for(j=0;j<objs.length;j++){
			var obj=objs[j];
			if(obj.value==""){
				flg=false;
				setbackground(obj,bgColorOther);
			}else{
				setbackground(obj,"white");			
			}
		}
	}
	return flg;
}

//设置控件的背景颜色
function setbackground(obj,colorstr){
	obj.style.background=colorstr;
}


// 取得名称为obj.name的控件在页面中的index值  参数:准备查找index值的控件
function getObjIndex(obj){
	var objs=document.getElementsByName(obj.name);
	for(i=0;i<objs.length;i++){
		if(objs[i]==obj){
			return i;
		}
	}
}

// 删除字串左边或右边指定的连续字符 src:带操作字串 mode=1左边 mode=2右边 str要删除的字符串
function trimSideStr(src,mode,str)	{
	var alen = str.length;
	while(1){
		if(src.length<alen){
			return src;
		}
		if(mode=="1"){
			var astr = src.substring(0,alen);
			if(astr==str){
				src=src.substring(alen,src.length);
			}else{
				return src;				
			}
		}else if(mode=="2"){
			var astr = src.substring(src.length-alen,src.length);
			if(astr==str){
				src=src.substring(0,src.length-alen);
			}else{
				return src;				
			}
		}
	}
}
 
 // 判断数组array中是否包含值为str的
function hasContain(array,str){
	for(i=0;i<array.length;i++){
		if(array[i]==str){
			return true;
		}
	}
	return false;    
}

//手机号检查
function checkMobile(inMobileNo){
/**
	var patrn=/^((\(\d{3}\))|(\d{3}\-))?1[3,5]\d{9}$/;   
	if (!patrn.exec(s)) return false  
	return true  
	**/
	var i;   
	var vaMobileHead = new Array("130","131","132","133","134","135","136","137","138","139","158","159");   

	if (inMobileNo.length != 11) {   
		return false;   
	}   
	for (i = 0; i < inMobileNo.length; i++) {   
		if (!(inMobileNo.charAt(0) >= "0" && inMobileNo.charAt(0) <= "9")) {   
			return false;   
		}   
	}   
	if (!hasContain(vaMobileHead, inMobileNo.substring(0, 3))) {   
		return false;   
	}   
	return true;   	
}


function encryptPassword(input) { 
	if(input == null || input == "") {
		return input;
	}
	keyStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";
	var output = "";   
	var chr1, chr2, chr3;   
	var enc1, enc2, enc3, enc4;   
	var i = 0;   
	do {      
		chr1 = input.charCodeAt(i++);     
		chr2 = input.charCodeAt(i++);      
		chr3 = input.charCodeAt(i++);      
		enc1 = chr1 >> 2;      
		enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);      
		enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);      
		enc4 = chr3 & 63;      
		if (isNaN(chr2)) {         
			enc3 = enc4 = 64;      
		} else if (isNaN(chr3)) {         
			enc4 = 64;      
		}      
		output = output + keyStr.charAt(enc1) + keyStr.charAt(enc2) + keyStr.charAt(enc3) + keyStr.charAt(enc4);   
	} while (i < input.length);
	
	return output;
}
