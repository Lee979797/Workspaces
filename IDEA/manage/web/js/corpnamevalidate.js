/*****************************************************************************************************
*******申请的名称要符合以下几点文字要求，如果不符合将不能申请。
*******1、名称中不能有阿拉伯数字（全角和半角都不行）；
*******2、名称中不能有全角的大写字母，不能有全角和半角的小写字母；
*******3、名称中可以是有“•”和“《》”，不能有其它的标点符号。
*******************************************************************************************************/

/**************************************************主function*****************************************/
function namevalidate(strname,txtstr){
    //0、名称中不能有全角和半角的空格    
	for(var i=0;i<txtstr.length;i++){
		if(txtstr.charCodeAt(i)==32 || txtstr.charCodeAt(i)==12288){
			alert(strname+"中不能包含全角和半角空格！");
			return false;
		}
	}
	//1、名称中不能有阿拉伯数字（全角和半角都不行）
	var numagrs=["0","1","2","3","4","5","6","7","8","9"];
	for(var i=0;i<numagrs.length;i++){
		if(txtstr.indexOf(numagrs[i])>=0){
			alert(strname+"中不能包含半角阿拉伯数字！");
			return false;
		}
		if(txtstr.indexOf(String.fromCharCode(numagrs[i].charCodeAt(0)+65248))>=0){
			alert(strname+"中不能包含全角阿拉伯数字！");
			return false;
		}
	}
	//2、名称中不能有全角的大写字母，不能有全角和半角的小写字母
	var charagrs=["a","b","c","d","e","f","g","h","i","g","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"]
	for(var i=0;i<charagrs.length;i++){
		if(txtstr.indexOf(charagrs[i])>=0){
			alert(strname+"中不能包含半角小写字母！");
			return false;
		}
		if(txtstr.indexOf(String.fromCharCode(charagrs[i].charCodeAt(0)+65248))>=0){
			alert(strname+"中不能包含全角小写字母！");
			return false;
		}
		if(txtstr.indexOf(String.fromCharCode(charagrs[i].toUpperCase().charCodeAt(0)+65248))>=0){
			alert(strname+"中不能包含全角大写字母！");
			return false;
		}
	}
	var noteagrs=["(",")","|","、",",",".","?","/",">","<",";",":","\"","'","{","}","[","]","`","~","!","@","#","$","%","^","&","*","-","_","+","=","\\"]
	//3、名称中可以是有“•”和“《》”，不能有其它的标点符号。
	for(var i=0;i<charagrs.length;i++){
		if(txtstr.indexOf(noteagrs[i])>=0){
			alert(strname+"中不能包含半角标点符号！");
			return false;
		}
		if(String.fromCharCode(noteagrs[i].charCodeAt(0)+65248)!="•" 
		&& String.fromCharCode(noteagrs[i].charCodeAt(0)+65248)!="《"
		&& String.fromCharCode(noteagrs[i].charCodeAt(0)+65248)!="》"){
			if(txtstr.indexOf(String.fromCharCode(noteagrs[i].charCodeAt(0)+65248))>=0){
				alert(strname+"中不能包含除了•和《》全角标点符号！");
				return false;
			}
		}
	}
	return true;
}


/**************************************************其它function*****************************************/
/**
**全角空格为12288，半角空格为32 
**其他字符半角(33-126)与全角(65281-65374)的对应关系是：均相差65248 
**yanxiaoyan 2007-8-14 全角转半角和半角转全角
**/

//半角转换为全角函数
function ToDBC(txtstring){
	var   tmp   =   "";
	for(var i=0;i<txtstring.length;i++){
		if(txtstring.charCodeAt(i)==32){
			tmp= tmp+  String.fromCharCode(12288);
		}
		if(txtstring.charCodeAt(i)<127){
			tmp=tmp+String.fromCharCode(txtstring.charCodeAt(i)+65248);
		}
	}
 	return tmp;     
}

//全角转换为半角函数
function ToCDB(str){   
        var   tmp   =   "";   
        for(var   i=0;i<str.length;i++)   
        {   
            if(str.charCodeAt(i)>65248&&str.charCodeAt(i)<65375)   
            {   
                tmp   +=   String.fromCharCode(str.charCodeAt(i)-65248);   
            }   
            else   
            {   
                tmp   +=   String.fromCharCode(str.charCodeAt(i));   
            }   
        }   
    return   tmp   
} 