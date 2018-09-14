function FormVerify() {
	this.dateFormatType=3;		//1 代表 2009-09-30 , 2 代表 2009/09/30 , 3 代表 20090930
	this.regDate1 = /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/;
	this.exampleDate1="2009-09-30";
	this.regDate2 = /^(\d{1,4})(\/|\/)(\d{1,2})\2(\d{1,2})$/;
	this.exampleDate2="2009/09/30"; 
	this.regDate3 = /^(\d{1,4})(|\/)(\d{1,2})\2(\d{1,2})$/;
	this.exampleDate3="20090930";
	this.regRequire = /.+/;
	this.regEmail = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
	this.regPhone = /^((\(\d{3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}$/;
	this.regMobile = /^((\(\d{3}\))|(\d{3}\-))?13\d{9}$/,
	this.regUrl = /^http:\/\/[A-Za-z0-9]+\.[A-Za-z0-9]+[\/=\?%\-&_~`@[\]\':+!]*([^<>\"\"])*$/;
	this.regIdCard15 = /^\d{15}(\d{2}[A-Za-z0-9])?$/;	
	this.regIdCard18 = /^\d{17}(?:\d|x|X)$/;
	this.regMoney = /[0-9](\.|\/)(\d{2})$/;;
	this.regNumber = /^\d+$/;
	this.regZip = /^[0-9]\d{5}$/;
	this.regQQ = /^[1-9]\d{4,8}$/;
	this.regZInteger= /^[1-9]\d*$/;
	this.regInteger = /^[-\+]?\d+$/;
	this.regDouble = /^[-\+]?\d+(\.\d+)?$/;
	this.regEnglish = /^[A-Za-z]+$/;
	this.regEnglishAndNumber = /^[A-Za-z0-9]+$/;
	this.regChinese =  /^[\u0391-\uFFE5]+$/;
	this.regUnSafe = /^(([A-Z]*|[a-z]*|\d*|[-_\~!@#\$%\^&\*\.\(\)\[\]\{\}<>\?\\\/\'\"]*)|.{0,5})$|\s/;
	//this.regNotChar=/^[^`~!@#$%^&*()+=|\\\][\]\{\}:;'\,.<>/?]{1}[^`~!@$%^&()+=|\\\][\]\{\}:;'\,.<>?]{0,19}$/;
	//this.regChar=/[(\/)(\\)(')(")(<)(>)]/g;
	this.extArray = new Array(".gif",".jpg",".png",".bmp",".xml",".txt",".doc",".xls",".zip",".rar",".pdf",".dbf");
	//added by zhuzhen_hua@yahoo.com.cn
	this.regYearMonth = /^\d{4}[-]\d{2}$/;
	//this.regDigital = /(^[0-9]{1}[0-9]{0,6}\.[0-9]{0,6}$)|(^[0-9]{1}[0-9]{0,11}$)/;
	//add by li jian
	this.regDigital = /(^[0-9]{1,13}\.[0-9]{0,4}$)|(^[0-9]{1,13}$)/;
	this.regPercentDigital = /(^[0-9]{1,3}\.[0-9]{0,2}$)|(^[0-9]{1,3}$)/;
	this.regPercent = "(^[0-9]{1,3}\\.[0-9]{1,@@@}$)|(^[0-9]{1,3}$)";
	//add by liyun 2008-10-28 for 2ND desc:number(18,6)正则表达式
	this.regNumberDigital =/(^[0-9]{1,12}\.[0-9]{0,6}$)|(^[0-9]{1,12}$)/;
	this.dbcSign =/^[\x00-\xff]*$/;
	//added by wuwei, 2008-11-1 for 2nd 非负整数
	this.regNotNegativeInteger = /(^0$)|(^[1-9]\d*$)/;
	//added by gaoheling,2010-09-02 for time hh:mm or h:m
	this.regTimeNoSecond = /^(0?[1-9]|1[0-9]|2[0-3]):(0?[0-9]|[1-5][0-9])$/;
}

var FormVerify = new FormVerify();


// 数据被转换以前的原始信息
var valid_original_value_list = new Array();
function add_valid_original_value_list( obj, value )
{
	var v = new Array();
	v[0] = obj;
	v[1] = value;
	
	var l = valid_original_value_list.length;
	valid_original_value_list[l] = v;
}

function reset_valid_original_value( )
{
	var obj;
	var value;
	for( var ii=0; ii<valid_original_value_list.length; ii++ ){
		obj = valid_original_value_list[ii][0];
		value = valid_original_value_list[ii][1];
		obj.value = value;
	}
	
	valid_original_value_list = new Array();
}


/*
已经不使用这个函数，改用：_checkInputFieldValid
*************************************************************************************************
此方法检测文本表单输入内容合法性检测
传入参数
field				@输入域，数组 document.getElementsByName('query:para_name')			
minlength			@最小长度，>0时验证非空等
maxlength			@最大长度，0不校验、最大长度和最小长度相等时、最大长度小于最小长度
datatype			@int、double、string、date、money、idcard、mail、phone、mobile、zip、number、url、qq、file
						#int			整数
						#double			1-9和小数点	
						#string			汉字长度算两位
						#password		密码，转换成MD5
						#date			日期			//1 代表 2009-09-30 , 2 代表 2009/09/30 , 3 代表 20090930									
						#money			金额
						#idcard			必须是15位或者18位的数字
						#idcard18		18位身份证，如果是15位身份证，自动转换
						#mail			E-Mail
						#phone			电话号码
						#mobile			移动电话	
						#zip			邮政编码			
						#number			数字		
						#url			url地址
						#qq				qq号码
						#file			file
dataformat			@保留参数:对日期有效
fieldCaption		@输入域标题，用于提示
返回值				
true or false	
*************************************************************************************************
*/
function checkFieldValid(fieldName, notnull, minlength, maxlength, datatype, dataformat, fieldCaption)
{
	var flag = true;
	var field = document.getElementsByName( fieldName );
	for(M=0;M<field.length;M++){
		// 判断域的FORM和当前提交的域是否一致
		if( currentFormName != null && field[M].form != null && field[M].form.name != currentFormName ){
			return true;
		}
		
		flag = _checkFieldValid( field[M], notnull, minlength, maxlength, datatype, dataformat, fieldCaption );
		if( flag == false ){
			return false;
		}
	}//end for
	
	return true;
}

// 检查域，有效性在域的定义中
function checkInputFieldValid( fieldName )
{
	// 检查
	var flag = true;
	var field = document.getElementsByName( fieldName );
	for( var index=0; index<field.length; index++ ){
		flag = _checkInputFieldValid( field, index );
		if( flag == false ){
			return false;
		}
	}//end for
	
	return true;
}


// 检查域的有效性，包括自定义的规则
function _checkInputFieldValid( field, index )
{
	// 判断域的FORM和当前提交的域是否一致
	if( currentFormName != null && field[index].form != null && field[index].form.name != currentFormName ){
		return true;
	}
	
	var flag = true;
	
	// 是否检查有效性
	if( field[index].checkFlag != 'true' ){
		return true;
	}
	
	// 变量
	var checkFlag;
	var notnull;
	var minlength;
	var maxlength;
	var datatype;
	var dataformat;
	var fieldCaption;
	
	// 取有效性参数
	if( field[index].notnull != 'true' ){
		notnull = false;
	}
	else{
		notnull = true;
	}
	
	// 最小长度或最小值
	if( field[index].minvalue == null ){
		minlength = 0;
	}
	else{
		minlength = field[index].minvalue;
	}
	
	// 最大长度或最大值
	if( field[index].maxvalue == null ){
		maxlength = 0;
	}
	else{
		maxlength = field[index].maxvalue;
	}
	
	// 数据类型
	if( field[index].datatype == null ){
		datatype = 'string';
	}
	else{
		datatype = field[index].datatype;
	}
	
	// 数据格式
	if( field[index].dataformat == null ){
		dataformat = '';
	}
	else{
		dataformat = field[index].dataformat;
	}
	
	// 标题
	if( field[index].fieldCaption == null ){
		fieldCaption = '';
	}
	else{
		fieldCaption = field[index].fieldCaption;
	}
	
	// 检查域的自定义规则
	flag = _checkFieldValidatorRule( field, index, field[index].validator, fieldCaption );
	if( flag == false ){
		return false;
	}
	
	// 通用规则检查
	flag = _checkFieldValid( field[index], notnull, minlength, maxlength, datatype, dataformat, fieldCaption );
	if( flag == false ){
		return false;
	}
	
	return true;
}

// 检查域的自定义规则
function _checkFieldValidatorRule( field, index, rule, fieldCaption )
{
	if( rule == null || rule == '' ){
		return true;
	}
	
	var flag = true;
	if( rule.indexOf('/') == 0 && rule.lastIndexOf('/') == rule.length-1 ){
		var obj = field[index];
		var _str = obj.value;
		
		// 检查格式有效性:正则表达式[/表达式/]
		flag = _test_dataformat(_str, rule, fieldCaption);
	}
	else{
		// 自定义校验函数:替换[']
		rule = rule.replace(/`/g, "'");
		
		// 增加参数
		var param = 'field, ' + index + ', "' + fieldCaption + '"';
		var idx = rule.indexOf('(');
		if( idx < 0 ){
			rule = rule + '(' + param + ')';
		}
		else{
			var s = rule.substring(idx+1).trim()
			if( s.charAt(0) != ')' ){
				s = ', ' + s;
			}
			
			rule = rule.substring(0, idx+1) + param + s;
		}
		
		// alert( rule );
		flag = eval( rule );
	}
	
	if( flag == false ){
		field[index].focus();
		return false;
	}
	
	return true;
}


// 检查域的有效性
function _checkFieldValid(field, notnull, minlength, maxlength, datatype, dataformat, fieldCaption)
{
	if( minlength == null ){
		minlength = 0;
	}
	
	if( maxlength == null ){
		maxlength = 0;
	}
	
	// 转成字符串
	if( dataformat == null ){
		dataformat = '';
	}
	else{
		dataformat = '' + dataformat;
	}
	
	// 是否检查有效性
	if( minlength == 0 && 
		maxlength == 0 &&
		datatype == 'string' &&
		dataformat == ''
	)
	{
		return true;
	}
	
	// 取值
	var _str=field.value;
	
	// 检查数值型数据是否能够空
	if( notnull == true && getStringLength(_str)==0 ){
		reset_valid_original_value();
  		alert("输入域[" + fieldCaption + "]不能为空！");
  		field.focus();
  		return false;			
  	}
  	
  	// 如果是文件，需要先看accept,里面保存的文件后缀，如果没有设置这个参数，判断是否是缺省的文件类型
  	var oldFileList = FormVerify.extArray;
  	if( datatype == "file" ){
  		var accept = field.accept;
  		if( accept != null && accept != '' ){
	  		accept = accept.replace( /[;]/g, ',' );
	  		var list = accept.split( ',' );
	  		for( var ii=0; ii<list.length; ii++ ){
	  			var s = list[ii].trim();
	  			var iptr = s.lastIndexOf( '.' );
	  			if( iptr > 0 ){
	  				s = s.substring( iptr );
	  			}
	  			
	  			list[ii] = s;
	  		}
	  		
	  		FormVerify.extArray = list;
	  	}
  	}
	
	// 检查数据有效性
	var flag = checkValueValid( _str, minlength, maxlength, datatype, dataformat, fieldCaption );
	
	// 恢复文件的后缀列表
  	if( datatype == "file" ){
  		FormVerify.extArray = oldFileList;
  	}
	
	// 判断是否有效
	if( flag == false ){
		reset_valid_original_value();
		field.focus();
		return false;
	}
	
	// 转换18位身份证 和 加密密码
	if( _str != null && _str != '' ){
		// 保存原始数据
		add_valid_original_value_list( field, _str );
		
		if( datatype == "idcard18" ){
			field.value = transIdcard18( _str );
		}
		else if( datatype == "password" ){
			field.value = calcMD5( _str );
		}
	}
	
	// 正则表达式[/表达式/]
	if( dataformat.indexOf('/') == 0 && dataformat.lastIndexOf('/') == dataformat.length-1 ){
		flag = _test_dataformat(_str, dataformat, fieldCaption);
		if( flag == false ){
			field[index].focus();
			return false;
		}
	}
}


// 检查数据的有效性
function checkValueValid(value, minlength, maxlength, datatype, dataformat, fieldCaption){
	//>>>>int<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	if (datatype=="int"){			
		//处理数据类型
		if (value.length>0){
			if(isInteger(value,fieldCaption)==false){
				return false;
			}	
		
			//处理数字的大小、非空
			if (checkInteger(value,minlength,maxlength,fieldCaption)==false){
				return false;	
			}
		}
		return true;
		
	//>>>>double<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<	
	}else if (datatype=="double"){
		//处理数据类型
		if (value.length>0){
			if(isDouble(value,fieldCaption)==false){
				return false;
			}
			
			//处理数字的大小、非空
			if (checkInteger(value,minlength,maxlength,fieldCaption)==false){
				return false;	
			}
		}
		return true;
		
	//>>>>money<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 	
	}else if (datatype=="money"){
		if( value.length>0 ){
			if(isMoney(value,fieldCaption)==false){
				return false;
			}
			
			//处理金额的大小、非空
			if (checkInteger(value,minlength,maxlength,fieldCaption)==false){
				return false;	
			}
		}
		return true;
		
	//>>>>String<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<	
	}else if (datatype=="string" || datatype=="password"){
		//处理字符串的长度、非空
		if (checkStrLength(value,minlength,maxlength,fieldCaption)==false){
			return false;	
		}
		return true;

	//>>>>date<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<	
	}else if (datatype=="date"){
		if( dataformat != '1' && dataformat != '2' ){
			dataformat = '3';
		}
		
		if (minlength<=0){
			if (value.length>0){
				if(isValidDate(value,fieldCaption,dataformat)==false){
					return false;
				}	
			}
		}else{
			if (value.length>0){
				if(isValidDate(value,fieldCaption,dataformat)==false){
					return false;
				}	
			}else{
				alert("["+fieldCaption+"]输入不能为空!");
				return false;	
			}
		}
		return true;
		
	//>>>>mail<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 	
	}else if (datatype=="mail"){
		if (minlength<=0){
			if (value.length>0){
				if(isEmail(value,fieldCaption)==false){
					return false;
				}	
			}
		}else{
			if (value.length>0){
				if(isEmail(value,fieldCaption)==false){
					return false;
				}	
			}else{
				alert("["+fieldCaption+"]输入不能为空!");
				return false;	
			}
		}		
		return true;
	//>>>>idcard<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 	
	}else if (datatype=="idcard" || datatype=="idcard18"){
		if (minlength<=0){
			if (value.length>0){
				if(isIdCard(value,fieldCaption)==false){
					return false;
				}	
			}
		}else{
			if (value.length>0){
				if(isIdCard(value,fieldCaption)==false){
					return false;
				}	
			}else{
				alert("["+fieldCaption+"]输入不能为空!");
				return false;	
			}
		}
		
		// 强制检查身份证的校验位
		var	checkValue = strictCheckIdcard(value);
		if( checkValue != null ){
			alert( "["+fieldCaption+"]的校验位不正确，应该是[" + checkValue + "]" );
			return false;
		}
		
		return true;
		
	//>>>>phone<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 	
	}else if (datatype=="phone"){
		if (minlength<=0){
			if (value.length>0){
				if(isPhone(value,fieldCaption)==false){
					return false;
				}	
			}
		}else{
			if (value.length>0){
				if(isPhone(value,fieldCaption)==false){
					return false;
				}	
			}else{
				alert("["+fieldCaption+"]输入不能为空!");
				return false;	
			}
		}		
		return true;
		
	//>>>>mobile<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 	
	}else if (datatype=="mobile"){
		if (minlength<=0){
			if (value.length>0){
				if(isMobile(value,fieldCaption)==false){
					return false;
				}	
			}
		}else{
			if (value.length>0){
				if(isMobile(value,fieldCaption)==false){
					return false;
				}	
			}else{
				alert("["+fieldCaption+"]输入不能为空!");
				return false;	
			}
		}		
		return true;

	//>>>>zip<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 	
	}else if (datatype=="zip"){
		if (minlength<=0){
			if (value.length>0){
				if(isZip(value,fieldCaption)==false){
					return false;
				}	
			}
		}else{
			if (value.length>0){
				if(isZip(value,fieldCaption)==false){
					return false;
				}	
			}else{
				alert("["+fieldCaption+"]输入不能为空!");
				return false;	
			}
		}		
		return true;


	//>>>>url<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 	
	}else if (datatype=="url"){
		if (minlength<=0){
			if (value.length>0){
				if(isUrl(value,fieldCaption)==false){
					return false;
				}	
			}
		}else{
			if (value.length>0){
				if(isUrl(value,fieldCaption)==false){
					return false;
				}	
			}else{
				alert("["+fieldCaption+"]输入不能为空!");
				return false;	
			}
		}		
		return true;

	//>>>>qq<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 	
	}else if (datatype=="qq"){
		if (minlength<=0){
			if (value.length>0){
				if(isQQ(value,fieldCaption)==false){
					return false;
				}	
			}
		}else{
			if (value.length>0){
				if(isQQ(value,fieldCaption)==false){
					return false;
				}	
			}else{
				alert("["+fieldCaption+"]输入不能为空!");
				return false;	
			}
		}		
		return true;
	
	//>>>>number<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 	
	}else if (datatype=="number"){
		//处理字符串的长度、非空
		if (checkStrLength(value,minlength,maxlength,fieldCaption)==false){
			return false;	
		}
		if (value.length>0){
			if(isNumber(value,fieldCaption)==false){
				return false;
			}	
		}
		
		return true;
		
	//>>>>file<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 	
	}else if (datatype=="file"){
		if (minlength<=0){
			if (value.length>0){
				if(isFileType(value,fieldCaption)==false){
					return false;
				}	
			}
		}else{
			if (value.length>0){
				if(isFileType(value,fieldCaption)==false){
					return false;
				}	
			}else{
				alert("["+fieldCaption+"]输入不能为空!");
				return false;	
			}
		}		
		return true;
		
	//>>>>default string<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 
	}else{
		//处理字符串的长度、非空
		if (checkStrLength(value,minlength,maxlength,fieldCaption)==false){
			return false;	
		}
					
		return true;
	}//end if
}

/*	
检测输入非空		
str				输入的字符
Msg				输入域标题,用于提示
返回值			true or false
*/
function isRequire(str,Msg) {
	var reg=FormVerify.regRequire;
	if (reg.test(str.Trim())==false){
		window.alert("["+Msg+"]不能为空!");
		return false;
	}else{		
		return true;
	}
}
/*	
检测时间输入的合法性		hh/h : mm/m
str						输入的Time
Msg						输入域标题,用于提示
返回值					true or false
*/
function isTimeNoSecond(str,Msg) {
	var reg=FormVerify.regTimeNoSecond;
	if (reg.test(str)==false){
		window.alert("["+Msg+"]输入的格式不正确，示例12:00!");
		return false;
	}else{		
		return true;
	}
}

/*	
检测E-Mail输入的合法性		user@user.com
str						输入的E-Mail
Msg						输入域标题,用于提示
返回值					true or false
*/
function isEmail(str,Msg) {
	var reg=FormVerify.regEmail;
	if (reg.test(str)==false){
		window.alert("["+Msg+"]输入的格式不正确!");
		return false;
	}else{		
		return true;
	}
}


/*	
检测电话号码输入的合法性		010-62967799 or 62967799
str						输入的电话号码
Msg						输入域标题,用于提示
返回值					true or false
*/
function isPhone(str,Msg) {
	var reg=FormVerify.regPhone;
	if (reg.test(str)==false){
		window.alert("["+Msg+"]输入的格式不正确!");
		return false;
	}else{		
		return true;
	}
}


/* 
检测移动电话号码输入的合法性		13310922255
str							输入的移动电话号码
Msg							输入域标题,用于提示
返回值						true or false
*/
function isMobile(str,Msg) {
	var reg=FormVerify.regMobile;
	if (reg.test(str)==false){
		window.alert("["+Msg+"]输入的格式不正确!");
		return false;
	}else{		
		return true;
	}
}


/* 
检测连接地址输入的合法性		http://www.sina.com.cn
str						输入的连接地址
Msg						输入域标题,用于提示
返回值					true or false
*/
function isUrl(str,Msg) {
	var reg=FormVerify.regUrl;
	if (reg.test(str.toLowerCase())==false){
		window.alert("["+Msg+"]输入的格式不正确!");
		return false;
	}else{		
		return true;
	}
}


/* 
检测身份证号码输入的合法性	15位或者18位的数字
str						输入的身份证号码
Msg						输入域标题,用于提示
返回值					true or false
*/
function isIdCard(str,Msg) {
	if(str.length==18){
		var reg=FormVerify.regIdCard18;	
	}else{
		var reg=FormVerify.regIdCard15;
	}
		
	if (reg.test(str)==false){
		window.alert("["+Msg+"]输入的格式不正确!");
		return false;
	}else{
		//校验取值范围
		_arrayymd=getIdCardYearMonthDay(str,Msg);		
		if (checkYearMonthDay(_arrayymd,Msg)==false){
			alert("["+Msg+"]中日期的取值范围不正确!");
			return false;		
		}else{
			return true;
		}	
	}//end if
}


//从身份证中取得年、月、日的数组
function getIdCardYearMonthDay(str,Msg){	
	var _array=new Array();
	if(str.length==18){		
		_array[0]=str.substr(6,4);
		_array[1]=str.substr(10,2);
		_array[2]=str.substr(12,2);
	}else if(str.length==15){		
		_array[0]="19"+str.substr(6,2);
		_array[1]=str.substr(8,2);
		_array[2]=str.substr(10,2);	
	}
	return _array
}

// 取出生日期
function getBirthdayFromIdCard( str )
{
	var	val;
	if(str.length==18){
		val = str.substr(6, 8);
	}
	else{
		val = "19" + str.substr(6, 6);
	}
	
	return val;
}

function getGenderFromIdCard( str )
{
	var	val;
	if(str.length==18){
		val = str.substr(17, 1);
	}
	else{
		val = str.substr(15);
	}
	
	if( val == '0' || val == '2' || val == '4' || val == '6' || val == '8' ){
		val = '女';
	}
	else{
		val = '男';
	}
	
	return val;
}

/*
检查是否是金额类型		2355.00
str					传入的金额
Msg					输入域标题,用于提示
返回值				true or false
*/
function isMoney(str,Msg){
	var reg=FormVerify.regMoney;	
	if (reg.test(str)==false){
		alert("["+Msg+"]格式必须是 2355.00!");
		return false;	
	}else{
		return true;
	}
}

/*
检查是否是数字		1-9 	
str				传入的数字
Msg				输入域标题,用于提示
返回值			true or false
*/
function isNumber(str,Msg){
	var reg=FormVerify.regNumber;	
	if (reg.test(str)==false){
		alert("["+Msg+"]必须是0-9的数字!");
		return false;	
	}else{
		return true;
	}
}


/*
检查是否是邮政编码		100085 	
str					传入的邮政编码
Msg					输入域标题,用于提示
返回值				true or false
*/
function isZip(str,Msg){
	var reg=FormVerify.regZip;	
	if (reg.test(str)==false){
		alert("["+Msg+"]必须是六位的数字!");
		return false;	
	}else{
		return true;
	}
}

/*
检查是否是正整数		 	+- 0-9
str					传入的整数
Msg					输入域标题,用于提示
返回值				true or false
*/
function isZInteger(str,Msg){
	var reg=FormVerify.regZInteger;	
	if (reg.test(str)==false){
		alert("["+Msg+"]输入不是正整数类型!");
		return false;	
	}else{
		return true;
	}
}

/*
检查是否是整数		 	+- 0-9
str					传入的整数
Msg					输入域标题,用于提示
返回值				true or false
*/
function isInteger(str,Msg){
	var reg=FormVerify.regInteger;	
	if (reg.test(str)==false){
		alert("["+Msg+"]输入不是整数类型!");
		return false;	
	}else{
		return true;
	}
}


/*
检查是否是QQ号码		 	
str					传入的QQ号码
Msg					输入域标题,用于提示
返回值				true or false
*/
function isQQ(str,Msg){
	var reg=FormVerify.regQQ;	
	if (reg.test(str)==false){
		alert("["+Msg+"]格式不正确!");
		return false;	
	}else{
		return true;
	}
}


/*
检查是否是Double类型	12333.99	 	
str					传入的Double类型
Msg					输入域标题,用于提示
返回值				true or false
*/
function isDouble(str,Msg){
	var reg=FormVerify.regDouble;
	
	if (reg.test(str)==false){
		alert("["+Msg+"]输入不是Double类型!");
		return false;	
	}else{
		return true;
	}
}

/*
检查是否是英文			a-z and A-Z	 	
str					传入的英文
Msg					输入域标题,用于提示
返回值				true or false
*/
function isEnglish(str,Msg){
	var reg=FormVerify.regEnglish;	
	if (reg.test(str)==false){
		alert("["+Msg+"]只能输入英文字母(a-z and A-Z)!");
		return false;	
	}else{
		return true;
	}
}

/*
检查是否是英文或数字		a-z and A-Z and 0-9
str				传入的英文或数字
Msg				输入域标题,用于提示
返回值				true or false
*/
function validateEnglishAndNumber(str, msg) {
	var reg=FormVerify.regEnglishAndNumber;
	
	if (reg.test(str)==false){
		alert("["+msg+"]输入不是英文或数字类型!");
		return false;
	}else{
		return true;
	}
}


/*
检查是否是汉字			只能是汉字	 	
str					传入的汉字
Msg					输入域标题,用于提示
返回值				true or false
*/
function isChinese(str,Msg){
	var reg=FormVerify.regChinese;	
	if (reg.test(str)==false){
		alert("["+Msg+"]只能输入汉字!");
		return false;	
	}else{
		return true;
	}
}

/*
检查是否是汉字			只能是汉字	 	
str					传入的汉字
返回值				true or false
*/
function isChineseNoAlert(str){
	var reg=FormVerify.regChinese;	
	if (reg.test(str)==false){
		return false;	
	}else{
		return true;
	}
} 


/*
检查是否是含有非法字符				
str						传入的字符
Msg						输入域标题,用于提示
返回值					true or false
*/
function isUnSafe(str,Msg){
	var reg=FormVerify.regUnSafe;	
	if (reg.test(str)==false){
		alert("["+Msg+"]输入还有非法字符!");
		return false;	
	}else{
		return true;
	}
}


/*
检查上传文件类型				
str						传入的字符
Msg						输入域标题,用于提示
返回值					true or false
*/
function isFileType(str,Msg) {
	allowSubmit = false; 
	if (!str) {
		return false;
	}
	
	while (str.indexOf("\\") != -1){
		str = str.slice(str.indexOf("\\") + 1);
	}
	
	ext = str.slice(str.indexOf(".")).toLowerCase();	
	for (var i = 0; i < FormVerify.extArray.length; i++) {
		if( FormVerify.extArray[i] == ".*" || FormVerify.extArray[i] == ext ){ 
			allowSubmit = true; 
			break; 
		}
	}
	
	if (allowSubmit==false) {	
		alert("["+Msg+"]只能上传"+ (FormVerify.extArray.join("  ")) + ",\n请重新选择数据类型！");
		return false;
	}
	
	return true;
}


/*
检查是否是合法日期格式,日期的格式从FormVerify类中取得				
str						传入的字符
Msg						输入域标题,用于提示
返回值					true or false
*/
function isValidDate(str,Msg,datetype){
	var exampleDate="";
	var reg=""
	var strlength="";
	
	if (datetype=="2"){
		exampleDate=FormVerify.exampleDate2;
		reg=FormVerify.regDate2;
		strlength=10;
	}
	else if (datetype=="3"){
		exampleDate=FormVerify.exampleDate3;
		reg=FormVerify.regDate3;
		strlength=8;	
	}
	else if (datetype=="1"){
		exampleDate=FormVerify.exampleDate1;
		reg=FormVerify.regDate1;
		strlength=10;	
	}
	else {
		exampleDate=FormVerify.exampleDate1;
		reg=FormVerify.regDate1;
		strlength=10;	
	}
	
	if (str.length!=strlength){
		alert("["+Msg+"]格式不正确,格式必须是"+exampleDate+"!");
		return false;	
	}
	
	if (reg.test(str)==false){
		alert("["+Msg+"]格式不正确,格式必须是"+exampleDate+"!");
		return false;	
	}
	else{
		//校验取值范围
		var _array=getArrayDate(str,datetype);
		if (checkYearMonthDay(_array,Msg)==false){
			alert("["+Msg+"]取值范围不正确!");
			return false;		
		}
		else{
			return true;
		}
	}//end if
}

/*
检查是否是含有特殊字符				
str						传入的字符
Msg						输入域标题,用于提示
返回值					true or false
*/
function isNotChar(str,Msg){	
	reg=FormVerify.regNotChar;	
	if (reg.test(str)==false){
		alert("["+Msg+"]不能含有特殊字符!");
		return false;	
	}else{
		return true;
	}
}



/*
判断输入的字符串的长度，汉字算两个字符
str					输入的待检测字符串
返回值				长度
*/
function getStringLength(str){ 
	var length = 0;
	if(str==null||str.length==0) {
		return length;
	}else {
		for(i=0;i<str.length;i++) {
			 if (str.charCodeAt(i)>255) {
				length += 2;
			}else {
				length++;
			}
		}
	}
	return length;
	//_i=0; 
	//if(str.length>=1){
	//	for(i=0;i<str.length;i++){
	//		if(ChineseLength(str.charAt(i))){
	//			_i=_i+2;
	//		}else{
	//			_i++;
	//		}
	//	}
	//}	
	//return _i;
} 

function ChineseLength(str){
	var reg=FormVerify.regChinese;
	if (reg.test(str)==true){
		return true; //全部是汉字
	}else{
		return false; //含有字符
	}
}


/*
检测输入内容的长度(String、Number)
str				输入的待检测字符串
msg 			输入域标题,用于提示
maxL			最大长度   0 、 小于minL 、 ""
minL			最小长度
返回值			true or false
*/
function checkStrLength(str,minL,maxL,Msg){
    if (minL>0){
    	if (getStringLength(str)==0){
    		alert("["+Msg+"]输入不能为空！");
    		return false;			
    	}else{
    		if (isStrMaxMin(str,minL,maxL,Msg)==false){			
				return false;	
	    	}
    	}
    }else{
    	if (isStrMaxMin(str,minL,maxL,Msg)==false){			
			return false;	
    	}
    }    
}


function isStrMaxMin(str,minL,maxL,Msg){
	if(maxL==0){
		maxL="";
	}
	
	//只判断最小长度
	if (maxL==""){
		if (getStringLength(str)<minL){
			alert("["+Msg+"]输入内容的长度必须大于"+minL+"!");
			return false;	
    	}
    //输入参数错误		
	}else if(maxL<minL){		
		alert("输入的参数错误，最大长度必须大于最小长度！");
		return false;
	}else{
		//在最大长度和最小长度之间
		if (maxL!=minL){
			if (getStringLength(str)<minL ||getStringLength(str)>maxL){
				alert("["+Msg+"]输入内容如果为英文字符或数字,长度必须大于"+minL+" 小于"+maxL+",如果为汉字长度减半!");
				return false;	
			}
		//必须相等
		}else{
			if (getStringLength(str)!=minL){
				alert("["+Msg+"]输入内容的长度必须等于"+minL+"!");
				return false;	
			}
		}
	}	
	return true;
}


/*
检测输入数据的大小是否正确(Integer、Double转换成int在比较大小)
str					输入的待检测字符串
msg 				输入域标题,用于提示
maxL				最大长度   0 、 小于minL 、 ""
minL				最小长度
返回值				true or false
*/
function checkInteger(str,minL,maxL,Msg){
	//检测str
	if(isNaN(parseInt(str))==true){
		alert("输入的数据["+str+"]类型不正确！");
		return false;
	}
	
	if( minL != maxL ){
		if((maxL-minL)<0){		
			alert("输入的参数错误，最大值必须大于最小值");
			return false;
		}
		
		if( minL != -999999999 ){
			if( str - minL < 0 ){
				alert("["+Msg+"]输入数据必须大于"+minL+"!");
				return false;	
	    }
	  }
	  
	  if( maxL != 999999999 ){
			if( str - maxL > 0 ){
				alert("["+Msg+"]输入数据必须小于"+maxL+"!");
				return false;	
	    }
	  }
	}
}


function checkDouble(str,minL,maxL,Msg){
	//检测str
	if(isNaN(parseFloat(str))==true){
		alert("请输入数字！");
		return false;
	}
	
	if( minL != maxL ){
		if((maxL-minL)<0){		
			alert("输入的参数错误，最大值必须大于最小值");
			return false;
		}
		
		if( minL != -999999999 ){
		  if( str - minL < 0 ){
			alert("["+Msg+"]输入数据必须大于"+minL+"!");
			return false;	
	      }
	    }
	  
	    if( maxL != 999999999 ){
		  if( str - maxL > 0 ){
			alert("["+Msg+"]输入数据必须小于"+maxL+"!");
			return false;	
    	  }
	   }
	}
	return true;
}


/*
日期格式转换 			转换完成后的格式2009-09-09
str					输入的日期,必须是日期格式检测之后的日期
formattype  		1 代表 2009-09-30 , 2 代表 2009/09/30 , 3 代表 20090930
返回值				格式化后的日期
*/
function formatDate(str,formattype){
	if(formattype=="1"){
		return str;
	}else if(formattype=="2"){
		if(str.length==10){					
			return str.substr(0,4)+"-"+str.substr(5,2)+"-"+str.substr(8,2);
		}else{
			return str;
		}
	}else if(formattype=="3"){
		if(str.length==8){
			return str.substr(0,4)+"-"+str.substr(4,2)+"-"+str.substr(6,2);
		}else{
			return str;
		}
	}else{
		return str;
	}
}


/*
检查日期中年月日的合法性					
str							传入年月日的数组
Msg							输入域标题,用于提示
返回值						true or false
*/
function checkYearMonthDay(str,Msg){				
	if (str!=null){	
		//处理年	
		var years=str[0];
		if((parseInt(years)%4==0 && parseInt(years)%100!=0) || parseInt(years)%400==0){
			leapyear=true;
		}else{
			leapyear=false;
		}
		if(years.length!=4 || years==0){ 
			return false;
		}
		for(i=0;(i<years.length);i++){
			if("0123456789".indexOf(years.charAt(i))==-1){
			   return false;
			 }
		}
		//处理月
		var months=str[1];
		if(!months || months==0) {
			return false;
		} 
		
		for(i=0;(i<months.length);i++){
			if("0123456789".indexOf(months.charAt(i))==-1){
				return false;
			}
		}
		if(parseInt(months, 10)>12) {
			return false;
		}
		
		
		//处理日
		var days=str[2];
		if(!days || days==0) {
			return false;
		}
		
		for(i=0;(i<days.length);i++){
			if("0123456789".indexOf(days.charAt(i))==-1){
				return false;
			}
		}
		D=30;
		switch(parseInt(months, 10)){
		case 4:
		case 6:
		case 9:
		case 11: D=30; break;
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12: D=31; break;
		case 2: if(leapyear) 
		           D=29;
		        else         
		           D=28;
		}
		if(days>D){
			return false;
		}	
	return true;		
	}//END IF
	
	return false;	
}


/*
获得年、月、日的数组					
str							传入验证后的日期
返回值						年、月、日数组
*/
function getArrayDate(str,datetype){
	var _array=new Array();;
	if (datetype=="1"){
		_array[0]=str.substr(0,4);
		_array[1]=str.substr(5,2);
		_array[2]=str.substr(8,2);
	}else if (datetype=="2"){
		_array[0]=str.substr(0,4);
		_array[1]=str.substr(5,2);
		_array[2]=str.substr(8,2);
	}else if (datetype=="3"){
		_array[0]=str.substr(0,4);
		_array[1]=str.substr(4,2);
		_array[2]=str.substr(6,2);
	}
	return _array;
}






// 严格检查身份证的有效性
function strictCheckIdcard( id )
{
	// 只检查18位身份证
	if( id.length != 18 ){
		return null;
	}
	
	var	checkValue = getIdCheckNumber( id );
	var	iv = id.substring(17).toUpperCase();
	if( checkValue != iv ){
		return checkValue;
	}
	
	return null;
}

// 15位身份证转换成18位身份证
function transIdcard18( id )
{
	if( id.length == 18 ){
		return id.toUpperCase();
	}
	
	if( id.length != 15 ){
		// alert( '身份证的长度错误' );
		return id;
	}
	
	id = id.substr(0, 6) + '19' + id.substr(6);
	return id + getIdCheckNumber(id);
}

function getIdCheckNumber( id )
{
	var	arrVerifyCode = "1,0,X,9,8,7,6,5,4,3,2".split(",");
	var	wi = "7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2".split(",");
	
	var	checkNumber = 0;
	for( i=0; i<17; i++ ){
		checkNumber = checkNumber + parseInt(id.substring(i, i+1)) * wi[i];
	}
	
	var	modValue = checkNumber % 11;
	var	checkValue = arrVerifyCode[modValue];
	
	return checkValue;
}


// 检查两个域的内容是否一致
// 输入参数：字段1列表，字段1编号，字段1标题，字段2名称，字段2标题
function equals( fields, index, caption, field2Name, field2Caption )
{
	var fields2 = document.getElementsByName( field2Name );
	if( fields2.length <= index ){
		alert( "输入域[" + caption + "]和[" + field2Caption + "]的值不相同" );
		return false;
	}
	
	if( fields[index].value != fields2[index].value ){
		alert( "输入域[" + caption + "]和[" + field2Caption + "]的值不相同" );
		return false;
	}
	
	return true;
}



// 检查输入域的内容格式，安装正则表达式
function _test_dataformat( str, dataformat, caprion )
{
	if( dataformat == null || dataformat == '' ){
		return true;
	}
	
	// 删除前后边界
	if( dataformat.indexOf('/') == 0 && dataformat.lastIndexOf('/') == dataformat.length-1 ){
		dataformat = dataformat.substring(1, dataformat.length-1);
	}
	
	var reg = new RegExp( dataformat );
	if( reg.test(str) == false ){
		alert( "[" + caprion + "]输入数据错误!" );
		return false;
	}
	else{
		return true;
	}
}




// md5
/*
 * A JavaScript implementation of the RSA Data Security, Inc. MD5 Message
 * Digest Algorithm, as defined in RFC 1321.
 * Copyright (C) Paul Johnston 1999 - 2000.
 * Updated by Greg Holt 2000 - 2001.
 * See http://pajhome.org.uk/site/legal.html for details.
 */

/*
 * Convert a 32-bit number to a hex string with ls-byte first
 */
var md5_hex_chr = "0123456789ABCDEF";
function rhex(num)
{
  str = "";
  for(j = 0; j <= 3; j++)
    str += md5_hex_chr.charAt((num >> (j * 8 + 4)) & 0x0F) +
           md5_hex_chr.charAt((num >> (j * 8)) & 0x0F);
  return str;
}

/*
 * Convert a string to a sequence of 16-word blocks, stored as an array.
 * Append padding bits and the length, as described in the MD5 standard.
 */
function str2blks_MD5(str)
{
  nblk = ((str.length + 8) >> 6) + 1;
  blks = new Array(nblk * 16);
  for(i = 0; i < nblk * 16; i++) blks[i] = 0;
  for(i = 0; i < str.length; i++)
    blks[i >> 2] |= str.charCodeAt(i) << ((i % 4) * 8);
  blks[i >> 2] |= 0x80 << ((i % 4) * 8);
  blks[nblk * 16 - 2] = str.length * 8;
  return blks;
}

/*
 * Add integers, wrapping at 2^32. This uses 16-bit operations internally 
 * to work around bugs in some JS interpreters.
 */
function __add(x, y)
{
  var lsw = (x & 0xFFFF) + (y & 0xFFFF);
  var msw = (x >> 16) + (y >> 16) + (lsw >> 16);
  return (msw << 16) | (lsw & 0xFFFF);
}

/*
 * Bitwise rotate a 32-bit number to the left
 */
function rol(num, cnt)
{
  return (num << cnt) | (num >>> (32 - cnt));
}

/*
 * These functions implement the basic operation for each round of the
 * algorithm.
 */
function __cmn(q, a, b, x, s, t)
{
  return __add(rol(__add(__add(a, q), __add(x, t)), s), b);
}
function __ff(a, b, c, d, x, s, t)
{
  return __cmn((b & c) | ((~b) & d), a, b, x, s, t);
}
function __gg(a, b, c, d, x, s, t)
{
  return __cmn((b & d) | (c & (~d)), a, b, x, s, t);
}
function __hh(a, b, c, d, x, s, t)
{
  return __cmn(b ^ c ^ d, a, b, x, s, t);
}
function __ii(a, b, c, d, x, s, t)
{
  return __cmn(c ^ (b | (~d)), a, b, x, s, t);
}

/*
 * Take a string and return the hex representation of its MD5.
 */
function calcMD5(str)
{
  x = str2blks_MD5(str);
  a =  1732584193;
  b = -271733879;
  c = -1732584194;
  d =  271733878;

  for(i = 0; i < x.length; i += 16)
  {
    olda = a;
    oldb = b;
    oldc = c;
    oldd = d;

    a = __ff(a, b, c, d, x[i+ 0], 7 , -680876936);
    d = __ff(d, a, b, c, x[i+ 1], 12, -389564586);
    c = __ff(c, d, a, b, x[i+ 2], 17,  606105819);
    b = __ff(b, c, d, a, x[i+ 3], 22, -1044525330);
    a = __ff(a, b, c, d, x[i+ 4], 7 , -176418897);
    d = __ff(d, a, b, c, x[i+ 5], 12,  1200080426);
    c = __ff(c, d, a, b, x[i+ 6], 17, -1473231341);
    b = __ff(b, c, d, a, x[i+ 7], 22, -45705983);
    a = __ff(a, b, c, d, x[i+ 8], 7 ,  1770035416);
    d = __ff(d, a, b, c, x[i+ 9], 12, -1958414417);
    c = __ff(c, d, a, b, x[i+10], 17, -42063);
    b = __ff(b, c, d, a, x[i+11], 22, -1990404162);
    a = __ff(a, b, c, d, x[i+12], 7 ,  1804603682);
    d = __ff(d, a, b, c, x[i+13], 12, -40341101);
    c = __ff(c, d, a, b, x[i+14], 17, -1502002290);
    b = __ff(b, c, d, a, x[i+15], 22,  1236535329);    

    a = __gg(a, b, c, d, x[i+ 1], 5 , -165796510);
    d = __gg(d, a, b, c, x[i+ 6], 9 , -1069501632);
    c = __gg(c, d, a, b, x[i+11], 14,  643717713);
    b = __gg(b, c, d, a, x[i+ 0], 20, -373897302);
    a = __gg(a, b, c, d, x[i+ 5], 5 , -701558691);
    d = __gg(d, a, b, c, x[i+10], 9 ,  38016083);
    c = __gg(c, d, a, b, x[i+15], 14, -660478335);
    b = __gg(b, c, d, a, x[i+ 4], 20, -405537848);
    a = __gg(a, b, c, d, x[i+ 9], 5 ,  568446438);
    d = __gg(d, a, b, c, x[i+14], 9 , -1019803690);
    c = __gg(c, d, a, b, x[i+ 3], 14, -187363961);
    b = __gg(b, c, d, a, x[i+ 8], 20,  1163531501);
    a = __gg(a, b, c, d, x[i+13], 5 , -1444681467);
    d = __gg(d, a, b, c, x[i+ 2], 9 , -51403784);
    c = __gg(c, d, a, b, x[i+ 7], 14,  1735328473);
    b = __gg(b, c, d, a, x[i+12], 20, -1926607734);
    
    a = __hh(a, b, c, d, x[i+ 5], 4 , -378558);
    d = __hh(d, a, b, c, x[i+ 8], 11, -2022574463);
    c = __hh(c, d, a, b, x[i+11], 16,  1839030562);
    b = __hh(b, c, d, a, x[i+14], 23, -35309556);
    a = __hh(a, b, c, d, x[i+ 1], 4 , -1530992060);
    d = __hh(d, a, b, c, x[i+ 4], 11,  1272893353);
    c = __hh(c, d, a, b, x[i+ 7], 16, -155497632);
    b = __hh(b, c, d, a, x[i+10], 23, -1094730640);
    a = __hh(a, b, c, d, x[i+13], 4 ,  681279174);
    d = __hh(d, a, b, c, x[i+ 0], 11, -358537222);
    c = __hh(c, d, a, b, x[i+ 3], 16, -722521979);
    b = __hh(b, c, d, a, x[i+ 6], 23,  76029189);
    a = __hh(a, b, c, d, x[i+ 9], 4 , -640364487);
    d = __hh(d, a, b, c, x[i+12], 11, -421815835);
    c = __hh(c, d, a, b, x[i+15], 16,  530742520);
    b = __hh(b, c, d, a, x[i+ 2], 23, -995338651);

    a = __ii(a, b, c, d, x[i+ 0], 6 , -198630844);
    d = __ii(d, a, b, c, x[i+ 7], 10,  1126891415);
    c = __ii(c, d, a, b, x[i+14], 15, -1416354905);
    b = __ii(b, c, d, a, x[i+ 5], 21, -57434055);
    a = __ii(a, b, c, d, x[i+12], 6 ,  1700485571);
    d = __ii(d, a, b, c, x[i+ 3], 10, -1894986606);
    c = __ii(c, d, a, b, x[i+10], 15, -1051523);
    b = __ii(b, c, d, a, x[i+ 1], 21, -2054922799);
    a = __ii(a, b, c, d, x[i+ 8], 6 ,  1873313359);
    d = __ii(d, a, b, c, x[i+15], 10, -30611744);
    c = __ii(c, d, a, b, x[i+ 6], 15, -1560198380);
    b = __ii(b, c, d, a, x[i+13], 21,  1309151649);
    a = __ii(a, b, c, d, x[i+ 4], 6 , -145523070);
    d = __ii(d, a, b, c, x[i+11], 10, -1120210379);
    c = __ii(c, d, a, b, x[i+ 2], 15,  718787259);
    b = __ii(b, c, d, a, x[i+ 9], 21, -343485551);

    a = __add(a, olda);
    b = __add(b, oldb);
    c = __add(c, oldc);
    d = __add(d, oldd);
  }
  return rhex(a) + rhex(b) + rhex(c) + rhex(d);
}
function wrapUrl(url){
  var date = new Date();
  var ms = date.getTime();
  var pos = url.indexOf("?");
  if(pos>=0){
    url = url+"&timestamp="+ms;
  }else{
    url = url+"?timestamp="+ms;
  }
  return url
}
/**
** 去掉字符串两边的空格
** added by zhuzhen_hua@yahoo.com.cn on 2007-6-12
**/
String.prototype.Trim = function()
{
    return this.replace(/(^[\s\u3000]*)|([\s\u3000]*$)/g, ""); //modified by ww, 2008-12-31，去掉全角空格\u3000
}
/**
** 去掉字符串左边的空格
**/
String.prototype.LTrim = function()
{
    return this.replace(/(^\s*)/g, "");
}
/**
** 去掉字符串右边的空格
**/
String.prototype.RTrim = function()
{
    return this.replace(/(\s*$)/g, "");
}
/**
**校验日期格式， 正确示例：2007-01
**added by zhuzhenhua@yahoo.com.cn on 2007-6-12
**/
function validateDate(str,msg){
   var reg = FormVerify.regYearMonth;
   if(reg.test(str)==false){
     window.alert("["+msg+"]输入格式不正确 正确格式如2007-01");
     return false;
   }else{
     return true;
   }    
}
/**
**校验小数（最多六位小数）
**added by 李大伟
**/
function validateDigital(str,msg){
   var regStr = FormVerify.regNumberDigital;
	
   if(regStr.test(str)==false){
     window.alert("["+msg+"]格式不正确 最多输入十二位整数六位小数");
     return false;
   }
     return true; 
}

/**
**校验百分数（最多2位小数，3为整数）
**added by 李剑
**/
function validatePercentDigital(str,msg){
   var reg = FormVerify.regPercentDigital;
   
   if(reg.test(str)==false){
     window.alert("["+msg+"]格式不正确 最多输入三位整数两位小数");
     return false;
   }else{
     return true;
   }    
}

/**
**校验百分数（最多N位小数,同时不能大于100）
** digitalNum  -> 小数位的个数
**added by 叶青
**/
function validatePercent(str, digitalNum, msg){
   var regStr = FormVerify.regPercent.replace('@@@', digitalNum);
   var reg = new RegExp (regStr);
   
   if(reg.test(str)==false){
     window.alert("["+msg+"]格式不正确 最多输入3位整数" + digitalNum + "位小数");
     return false;
   }else{
     if (parseFloat(str) > 100) {
      	window.alert("["+msg+"]不能大于100");
      	return false;
     }
     return true;
   }
}
// add by larry
function validateDecimal(str, digitalNum, msg){
   var regStr = FormVerify.regDigital;
  
   if(regStr.test(str)==false){
     window.alert("["+msg+"]格式不正确 最多输入十四位整数" + digitalNum + "位小数");
     return false;
   }
     return true;
   }
// add by liyun 2008-10-28 for 2ND desc:校验number(18,6)--------start---------
function validateNumber186(str,msg){
	var regStr = FormVerify.regNumberDigital;
	
   if(regStr.test(str)==false){
     window.alert("["+msg+"]格式不正确 最多输入十二位整数六位小数");
     return false;
   }
     return true;
}
//--------------------------------------------end-----------------------------
/**
** dwr 进度条
** added by zhuzhenhua@yahoo.com.cn on 2007-7-13
**/
function useLoadingMessage(message) {
  var loadingMessage;
  if (message) loadingMessage = message;
  else loadingMessage = "Loading";

  DWREngine.setPreHook(function() {
    var disabledZone = $('disabledZone');
    if (!disabledZone) {
      disabledZone = document.createElement('div');
      disabledZone.setAttribute('id', 'disabledZone');
      disabledZone.style.position = "absolute";
      disabledZone.style.zIndex = "1200";
      disabledZone.style.left = "0px";
      disabledZone.style.top = "0px";
      disabledZone.style.width = "100%";
      disabledZone.style.height = "100%";
      document.body.appendChild(disabledZone);
      var messageZone = document.createElement('div');
      messageZone.setAttribute('id', 'messageZone');
      messageZone.style.position = "relative";
      messageZone.style.zIndex="1300";
      messageZone.style.top = top.document.body.scrollTop;　　//定义显示加载信息层的位置
   　 messageZone.style.left = document.body.clientWidth - "270";　 //定义显示加载信息层的位置
      messageZone.style.width = "200";　　//定义显示加载信息层的宽度
      messageZone.style.height = "25";    //定义显示加载信息层的高度
      messageZone.style.background = "green";//定义显示加载信息层的颜色
      messageZone.style.fontSize="11px";
      messageZone.style.color = "white";
      messageZone.style.fontFamily = "Arial,Helvetica,sans-serif";
      messageZone.style.padding = "5px";
      disabledZone.appendChild(messageZone);
      var text = document.createTextNode(loadingMessage);
      messageZone.appendChild(text);
    }
    else {
      $('messageZone').innerHTML = loadingMessage;
      disabledZone.style.visibility = 'visible';
    }
  });
  DWREngine.setPostHook(function() {
    $('disabledZone').style.visibility = 'hidden';
  });
 }

/**
   checklocation  选择国别的时候是否隐藏
 **/
 function checklocation(title){	              
	$(title+".area").style.display=$$(title+".country")!="156"?"none":"";
	if($$(title+".country")!="156")
	{
		$(title+".area").value="";
	}
	else
	{
		$(title+".area").value="1001";
	}

 }  

/**
   compareNumber  比较数字大小
 **/
 function compareNumber(firstNumber,secondNumber){
 	var firstNumber = parseFloat(firstNumber);
 	var secondNumber = parseFloat(secondNumber);            
	if(firstNumber >= secondNumber)
	{
        	return true; 
	}
	return false;
 }  
 /**
   validateTermDataInfo  验证企业设立股东分期入资数据是否等于出资额－－设立时缴付
 **/
 function validateTermDataInfo(regcapcur,firstmoneyconam,investdate,contermno,actmoneyconam,actgoodsconam,actindustryconam,actlandconam,actotherconam)
 {
 	
 	//判断分期日期
 	var temp = investdate[0].value;
 	var temp1 = contermno[0].value;
 	if(temp==""&&temp1!="")
	{
		alert("缴付时间不能为空，请填写!");
		return false;
	}
 	var current;
 	for(var i=1;i<investdate.length;i++)
 	{
 		if(contermno[i].value=="")
 			continue;
 		current = investdate[i].value;
 		if(current=="")
 		{
 			alert("缴付时间不能为空，请填写!");
 			return false;
 		}
 		if(temp>=current)
 		{
 			alert("缴付时间填写有误，必须从小到大填写!");
 			return false;
 		}
 		temp = investdate[i].value;
 	}
 	//判断结束
 	//判断出资额不能为0
 	var totalCount = 0;
 	for(var i=0;i<actmoneyconam.length;i++)
 	{
 		if(contermno[i].value=="")
 			continue;
 		if(!validateDigital(actmoneyconam[i].value,"货币"))
 			return false;
 		if(!validateDigital(actgoodsconam[i].value,"实物"))
 			return false;
 		if(!validateDigital(actindustryconam[i].value,"知识产权"))
 			return false;	
 		if(!validateDigital(actlandconam[i].value,"土地使用权"))
 			return false;
 		if(!validateDigital(actotherconam[i].value,"其他"))
 			return false;
 			
 		var count = parseFloat(actmoneyconam[i].value)+parseFloat(actgoodsconam[i].value)+parseFloat(actindustryconam[i].value)+parseFloat(actlandconam[i].value)+parseFloat(actotherconam[i].value);
 		
 		totalCount = totalCount + count;
 		if(count==0)
 		{
 			alert("第"+(i+1)+"期的出资额不能为0!");
 			return false;
 		}
 	}
 	
 	totalCount = Math.round(totalCount*1000000)/1000000;
 	//判断分期出资的总额是否＝出资额－设立时缴付
 	var termCap = Math.round((regcapcur - firstmoneyconam)*1000000)/1000000;
 	if(totalCount!=termCap)
 	{
 		alert("分期缴付的总出资额不等于出资额－设立时缴付!");
 		return false;
 	}
 	return true;
 
 }
 
 /**
   validateTermDataInfoForForeign  验证企业设立股东分期入资数据是否等于出资额－－设立时缴付
 **/
 function validateTermDataInfoForForeign(currentYMD,regcapcur,firstmoneyconam,investdate,contermno,actmoneyconam,actgoodsconam,actindustryconam,actlandconam,actotherconam)
 {
 	
 	//判断分期日期
 	var temp = investdate[0].value;
 	var temp1 = contermno[0].value;
 	if(temp==""&&temp1!="")
	{
		alert("缴付时间不能为空，请填写!");
		return false;
	}
 	var current;
 	for(var i=1;i<investdate.length;i++)
 	{
 		if(contermno[i].value=="")
 			continue;
 		current = investdate[i].value;
 		if(current=="")
 		{
 			alert("缴付时间不能为空，请填写!");
 			return false;
 		}
 		if(temp>=current)
 		{
 			alert("缴付时间填写有误，必须从小到大填写!");
 			return false;
 		}
 		temp = investdate[i].value;
 	}
	var currentYear = currentYMD.substring(0,4);
	var currentMonth = currentYMD.substring(5,7);
	var currentDay = currentYMD.substring(8,10);
	
	var maxdate = investdate[0].value;
 	var nowYear = maxdate.substring(0,4);
 	var nowMonth = maxdate.substring(5,7);
 	var nowDay = maxdate.substring(8,10);
 	var nowdate = nowYear + nowMonth + nowDay;
 	
 	var alternation = 3;
 	if (investdate.length == 2){
 		alternation = 6;
 	}
 	var endYear = currentYear;
	var endMonth = (parseInt(currentMonth) + parseInt(alternation))%12;
	if (endMonth < currentMonth){
		endYear = parseInt(currentYear) + 1;
	}
	endMonth = formatNumber(endMonth);
	var endDay = formatNumber(currentDay);
	var endDate = "" + endYear + endMonth + endDay;
	
 	//分多期 第一期 所有金额>=15% 入资日期 <=3个月
 	if (investdate.length > 2){
 		var firstCount = parseFloat(actmoneyconam[0].value)+parseFloat(actgoodsconam[0].value)+parseFloat(actindustryconam[0].value)+parseFloat(actlandconam[0].value)+parseFloat(actotherconam[0].value);
 		if(parseFloat(firstCount)<parseFloat(regcapcur)*0.15){
 			alert("第1期的出资额至少占出资额的百分之十五");
 			return false;
 		} 

 		if(parseFloat(nowdate)>parseFloat(endDate)){
 			alert("第1期的入资日期不大于三个月");
 			return false;
 		}
 	}
 	
 	
 	//分一期 入资日期<=6个月 
 	if (investdate.length == 2){
 	       if(parseFloat(nowdate)>parseFloat(endDate)){
 			alert("入资日期不大于六个月");
 			return false;
 		}
 	}
 	
 	//判断结束
 	//判断出资额不能为0
 	var totalCount = 0;
 	for(var i=0;i<actmoneyconam.length;i++)
 	{
 		if(contermno[i].value=="")
 			continue;
 		if(!validateDigital(actmoneyconam[i].value,"货币"))
 			return false;
 		if(!validateDigital(actgoodsconam[i].value,"实物"))
 			return false;
 		if(!validateDigital(actindustryconam[i].value,"知识产权"))
 			return false;
 		if(!validateDigital(actlandconam[i].value,"土地使用权"))
 			return false;
 		if(!validateDigital(actotherconam[i].value,"其他"))
 			return false;
 			
 		var count = parseFloat(actmoneyconam[i].value)+parseFloat(actgoodsconam[i].value)+parseFloat(actindustryconam[i].value)+parseFloat(actlandconam[i].value)+parseFloat(actotherconam[i].value);
 		
 		totalCount = totalCount + count;
 		if(count==0)
 		{
 			alert("第"+(i+1)+"期的出资额不能为0!");
 			return false;
 		}
 	}
 	
 	totalCount = Math.round(totalCount*1000000)/1000000;
 	//判断分期出资的总额是否＝出资额－设立时缴付
 	var termCap = Math.round((regcapcur - firstmoneyconam)*1000000)/1000000;
 	if(totalCount!=termCap)
 	{
 		alert("分期缴付的总出资额＝出资额－设立时缴付!");
 		return false;
 	}
 	return true;
 
 }
 
   /**
   formatNumber  格式化日期
 **/
 function formatNumber(dateNumber){
 	var realDate = "" + dateNumber;
 	if (realDate.length == 1){
 		realDate = "0"+ dateNumber;
 	}
 	return realDate;
 }
 
 
  /**
   validateTermDataInfoForChange  验证企业设立股东分期入资数据是否等于出资额－－设立时缴付
 **/
 function validateTermDataInfoForChange(firstmoneyconam,investdate,contermno,actmoneyconam,actgoodsconam,actindustryconam,actpatentconam,actlandconam,actotherconam)
 {
 	
 	//判断分期日期
 	var temp = investdate[0].value;
 	var temp1 = contermno[0].value;
 	if(temp==""&&temp1!="")
	{
		alert("缴付时间不能为空，请填写!");
		return false;
	}
 	var current;
 	for(var i=1;i<investdate.length;i++)
 	{
 		if(contermno[i].value=="")
 			continue;
 		current = investdate[i].value;
 		if(current=="")
 		{
 			alert("缴付时间不能为空，请填写!");
 			return false;
 		}
 		if(temp>=current)
 		{
 			alert("缴付时间填写有误，必须从小到大填写!");
 			return false;
 		}
 		temp = investdate[i].value;
 	}
 	//判断结束
 	//判断出资额不能为0
 	var totalCount = 0;
 	for(var i=0;i<actmoneyconam.length;i++)
 	{
 		if(contermno[i].value=="")
 			continue;
 		if(!validateDigital(actmoneyconam[i].value,"货币"))
 			return false;
 		if(!validateDigital(actgoodsconam[i].value,"实物"))
 			return false;
 		if(!validateDigital(actindustryconam[i].value,"知识产权（工业产权）"))
 			return false;
 		if(!validateDigital(actpatentconam[i].value,"知识产权（非专利技术）"))
 			return false;
 		if(!validateDigital(actlandconam[i].value,"土地使用权"))
 			return false;
 		if(!validateDigital(actotherconam[i].value,"其他"))
 			return false;
 			
 		var count = parseFloat(actmoneyconam[i].value)+parseFloat(actgoodsconam[i].value)+parseFloat(actindustryconam[i].value)+parseFloat(actpatentconam[i].value)+parseFloat(actlandconam[i].value)+parseFloat(actotherconam[i].value);
 		
 		totalCount = totalCount + count;
 		if(count==0)
 		{
 			alert("第"+(i+1)+"期的出资额不能为0!");
 			return false;
 		}
 	}
 	
 	totalCount = Math.round(totalCount*1000000)/1000000;
 	//判断分期出资的总额是否＝出资额－设立时缴付
 	var termCap = Math.round((firstmoneyconam)*1000000)/1000000;
 	if(totalCount!=termCap)
 	{
 		alert("分期缴付的总出资额＝出资额－实缴!");
 		return false;
 	}
 	return true;
 
 }
 /****************************************************************************************************
 *add by larry  国有独资分期校验
 *企业变更分期交付校验规则	needtopay:待缴总额   investdate：交付日期  contermno:期次 size：出资方式长度
 /****************************************************************************************************
  /**
   validateTermDataForChanage_Capital
 **/
 function validateTermDataForChanage_Capital(noneactmoney,needtopay,investdate,contermno,size)
 {
 	
 	//判断分期日期
 	var temp = investdate[0].value;
 	var temp1 = contermno[0].value;
 	if(temp==""&&temp1!="")
	{
		alert("缴付时间不能为空，请填写!");
		return false;
	}
 	var current;
 	for(var i=1;i<investdate.length;i++)
 	{
 		if(contermno[i].value=="")
 			continue;
 		current = investdate[i].value;
 		if(current=="")
 		{
 			alert("缴付时间不能为空，请填写!");
 			return false;
 		}
 		if(temp>=current)
 		{
 			alert("缴付时间填写有误，必须从小到大填写!");
 			return false;
 		}
 		temp = investdate[i].value;
 	}
 	//判断结束
 	//判断出资额不能为0
 	var totalCount = 0;
 	var count =0;
 	
 	//分期次数
 	for(var j=0;j<(contermno.length-1);j++)
 	{	
 		//出资方式长度
 		var temp =0;
 		var num = 0;
 		for(var i=0;i<size;i++)
	 	{
	 		if(!validateDigital(noneactmoney[j*size+i].value,window.document.getElementById(i+'_flagName').innerHTML))
	 			return false;
	 		 num = parseFloat(num) + parseFloat(noneactmoney[j*size+i].value);
	 		 temp = temp+1;
	 		 if(temp%size!=0){
	 		  	 continue;
	 		   }
	 		if(num==0)
	 		{
	 			alert("第"+(j+1)+"期的出资额不能为0!");
	 			return false;
	 		}
	 	}
	 	count = parseFloat(num)+parseFloat(count);
 	}
 	
 	totalCount = Math.round(count*1000000)/1000000;
 	//判断分期出资的总额是否＝出资额－设立时缴付
 	var termCap = Math.round((needtopay)*1000000)/1000000;
 	if(totalCount!=termCap)
 	{
 		alert("分期缴付总额【"+count+"】与待缴数额【"+needtopay+"】不等!");
 		return false;
 	}
 	return true;
 
 }
 
 /****************************************************************************************************
 *add by larry  其他企业类型股东分期校验
 *企业变更分期交付校验规则noneactmoney【】:用户填写的分期数据 investorneedtopay【】:股东分期实际的待缴 	needtopay:待缴总额   investdate：交付日期  contermno:期次 size：出资方式长度
 /****************************************************************************************************
  /**
   validateCommonTermDataForChanage_Capital
 **/
 function validateCommonTermDataForChanage_Capital(noneactmoney,investorneedtopay,needtopay,investdate,contermno,size)
 {
 	
 	//判断分期日期
 	var temp = investdate[0].value;
 	var temp1 = contermno[0].value;
 	if(temp==""&&temp1!="")
	{
		alert("缴付时间不能为空，请填写!");
		return false;
	}
 	var current;
 	for(var i=1;i<investdate.length;i++)
 	{
 		if(contermno[i].value=="")
 			continue;
 		current = investdate[i].value;
 		if(current=="")
 		{
 			alert("缴付时间不能为空，请填写!");
 			return false;
 		}
 		if(temp>=current)
 		{
 			alert("缴付时间填写有误，必须从小到大填写!");
 			return false;
 		}
 		temp = investdate[i].value;
 	}
 	//判断结束
 	//判断出资额不能为0
 	var totalCount = 0;
 	var count =0;
 	
 	//分期次数
 	for(var j=0;j<(contermno.length-1);j++)
 	{	
 		//出资方式长度
 		var temp2 = 0;
 		var num = 0;
 		for(var i=0;i<size;i++)
	 	{			
		 		if(!validateDigital(noneactmoney[j*size+i].value,window.document.getElementById(i+'_flagName').innerHTML))
		 			return false;
	 		
	 		 num = parseFloat(num) + parseFloat(noneactmoney[j*size+i].value);
	 		 temp2 = temp2+1;
	 		 //循环到最后一个，判断第j+1期出资额是否为0
	 		 if(temp2%size!=0)
	 		 {
	 		 	continue;
	 		 }
	 		
	 		if(num==0)
	 		{
	 			alert("第"+(j+1)+"期的出资额不能为0!");
	 			return false;
	 		}
	 	}
	 	 count = parseFloat(count)+parseFloat(num);
 	}
 	//当分一期交付时investdate.length=2
 	if(investdate.length==2){
 	
 		for(var i=0;i<size;i++)
	 	{
	 		var num = 0;
	 		if(!validateDigital(noneactmoney[i].value,window.document.getElementById(i+'_flagName').innerHTML))
	 			return false;
	 				 	 
	 		 	 	num = parseFloat(noneactmoney[i].value);//各期每种出资方式的待缴总和	 	 

	 		 if(num!=parseFloat(investorneedtopay[i].value)){
	 		 	alert(window.document.getElementById(i+'_flagName').innerHTML+"的待缴额总和为"+parseFloat(investorneedtopay[i].value));
	 		 	return false;
	 		 }
	 		
	 	}
 	}
 	
 	//出资方式的待缴额必须等于分期的总和
 	for(var j=0;j<(investdate.length-2);j++)
 	{	
 		//出资方式长度
 		for(var i=0;i<size;i++)
	 	{
	 		var num = 0;
	 		if(!validateDigital(noneactmoney[j*size+i].value,window.document.getElementById(i+'_flagName').innerHTML))
	 			return false;
	 			for(var m=0;m<(investdate.length-1);m++){
	 		 	 
	 		 	 	num = parseFloat(num)+parseFloat(noneactmoney[m*size+i].value);//各期每种出资方式的待缴总和
	 		 	 
	 		 	 }
	 		 	 num = Math.round(num*1000000)/1000000;
	 		 	 var needMonay = parseFloat(investorneedtopay[i].value);
	 		 	 needMonay = Math.round(needMonay*100000)/100000;
	 		 if(parseFloat(num)!=parseFloat(needMonay)){
	 		 	alert(window.document.getElementById(i+'_flagName').innerHTML+"的待缴额总和为"+parseFloat(investorneedtopay[i].value));
	 		 	return false;
	 		 }
	 		
	 	}
 	}
 	
 	totalCount = Math.round(count*1000000)/1000000;
 	//判断分期出资的总额是否＝出资额－设立时缴付
 	var termCap = Math.round((needtopay)*1000000)/1000000;
 	if(totalCount!=termCap)
 	{
 		alert("分期交付总额【"+count+"】与待缴数额【"+needtopay+"】不等!");
 		return false;
 	}
 	return true;
 
 }
 
 
 
 
 
 
 
 /*****************************************************************************************************

 /**
   validateTermDataInfoForChange  验证企业变更股东分期入资数据是否等于总待缴额
 **/
 function validateTermDataInfoForChange(totalneedtopay,investdate,contermno,actmoneyconam,actgoodsconam,actindustryconam,actpatentconam,actlandconam,actotherconam)
 {
 	
 	//判断分期日期
 	var temp = investdate[0].value;
 	var temp1 = contermno[0].value;
 	if(temp==""&&temp1!="")
	{
		alert("缴付时间不能为空，请填写!");
		return false;
	}
 	var current;
 	for(var i=1;i<investdate.length;i++)
 	{
 		if(contermno[i].value=="")
 			continue;
 		current = investdate[i].value;
 		if(current=="")
 		{
 			alert("缴付时间不能为空，请填写!");
 			return false;
 		}
 		if(temp>=current)
 		{
 			alert("缴付时间填写有误，必须从小到大填写!");
 			return false;
 		}
 		temp = investdate[i].value;
 	}
 	//判断结束
 	//判断出资额不能为0
 	var totalCount = 0;
 	for(var i=0;i<actmoneyconam.length;i++)
 	{
 		if(contermno[i].value=="")
 			continue;
 		if(!validateDigital(actmoneyconam[i].value,"货币"))
 			return false;
 		if(!validateDigital(actgoodsconam[i].value,"实物"))
 			return false;
 		if(!validateDigital(actindustryconam[i].value,"知识产权（工业产权）"))
 			return false;
 		if(!validateDigital(actpatentconam[i].value,"知识产权（非专利技术）"))
 			return false;
 		if(!validateDigital(actlandconam[i].value,"土地使用权"))
 			return false;
 		if(!validateDigital(actotherconam[i].value,"其他"))
 			return false;
 			
 		var count = parseFloat(actmoneyconam[i].value)+parseFloat(actgoodsconam[i].value)+parseFloat(actindustryconam[i].value)+parseFloat(actpatentconam[i].value)+parseFloat(actlandconam[i].value)+parseFloat(actotherconam[i].value);
 		
 		totalCount = totalCount + count;
 		if(count==0)
 		{
 			alert("第"+(i+1)+"期的出资额不能为0!");
 			return false;
 		}
 	}
 	
 	totalCount = Math.round(totalCount*1000000)/1000000;
 	//判断分期出资的总额是否＝出资额－设立时缴付
 	var termCap = Math.round(totalneedtopay*1000000)/1000000;
 	if(totalCount != termCap) {
 		alert("分期缴付的总出资额应该等于总待缴额!");
 		return false;
 	}
 	return true;
 
 }

 /**
   validateTermDataInfoForChange  验证企业变更股东分期入资数据是否等于总待缴额
 **/
 function validateOtherCapitalInfo(investdate, contermno)
 {

 	//判断分期日期
 	var temp = investdate[0].value;
 	var temp1 = contermno[0].value;
 	if(temp==""&&temp1!="") {
		alert("缴付时间不能为空，请填写!");
		return false;
	} 
	
 	var current;
 	for(var i=1;i<investdate.length;i++)
 	{	
 		if(contermno[i].value=="")
 			continue;
 		current = investdate[i].value;
 		if(current=="")
 		{
 			alert("缴付时间不能为空，请填写!");
 			return false;
 		}
 		if(temp>=current)
 		{
 			alert("缴付时间填写有误，必须从小到大填写!");
 			return false;
 		}
 		temp = investdate[i].value;
 	}

 	return true;
 }

 /**
   validateOneCapitalInfo  验证股东某种出资方式的分期入资数据是否等于总待缴额
 **/
 function validateOneCapitalInfo(contermno, needtopay, money, name)
 {
 	//判断出资额不能为0
 	var totalCount = 0;

 	for(var i=0;i<money.length;i++) {
 		if (contermno[i].value == '') {
 			continue;
 		}
 		
 		if(!validateDigital(money[i].value, name)) {
 			return false; 
 		}

 		var count = parseFloat(money[i].value);

 		totalCount = totalCount + count;

		/*
 		if (count == 0) {
 			alert("第"+(i+1)+"期的出资额不能为0!");
 			return false;
 		}
 		*/
 	}
	
 	totalCount = Math.round(totalCount * 1000000) / 1000000;

 	//判断分期出资的总额是否等于待缴总额
 	var termCap = Math.round(needtopay * 1000000) / 1000000;

 	if(totalCount != termCap) {
 		alert("[" + name + "]的分期缴付的总出资额应该等于[" + name + "]的总待缴额：" + needtopay);
 		return false;
 	} 

 	return true;
 
 }

/*****************************************************************************************************
*******申请的名称要符合以下几点文字要求，如果不符合将不能申请。
*******1、名称中不能有阿拉伯数字（全角和半角都不行）；
*******2、名称中不能有全角的大写字母，不能有全角和半角的小写字母；
*******3、名称中可以是有“?”和“《》”，不能有其它的标点符号。
*******************************************************************************************************/
function validateAppliedName(txtstr,strname){
    //0、名称中不能有全角和半角的空格    
	for(var i=0;i<txtstr.length;i++){
		if(txtstr.charCodeAt(i)==32 || txtstr.charCodeAt(i)==12288){
			alert("["+strname+"]中不能包含全角和半角空格！");
			return false;
		}
	}
	//1、名称中不能有阿拉伯数字（全角和半角都不行）
	var numagrs=["0","1","2","3","4","5","6","7","8","9"];
	for(var i=0;i<numagrs.length;i++){
		if(txtstr.indexOf(numagrs[i])>=0){
			alert("["+strname+"]中不能包含半角阿拉伯数字！");
			return false;
		}
		if(txtstr.indexOf(String.fromCharCode(numagrs[i].charCodeAt(0)+65248))>=0){
			alert("["+strname+"]中不能包含全角阿拉伯数字！");
			return false;
		}
	}
	//2、名称中不能有全角的大写字母，不能有全角和半角的小写字母
	var charagrs=["a","b","c","d","e","f","g","h","i","g","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"]
	for(var i=0;i<charagrs.length;i++){
		if(txtstr.indexOf(charagrs[i])>=0){
			alert("["+strname+"]中不能包含半角小写字母！");
			return false;
		}
		if(txtstr.indexOf(String.fromCharCode(charagrs[i].charCodeAt(0)+65248))>=0){
			alert("["+strname+"]中不能包含全角小写字母！");
			return false;
		}
		if(txtstr.indexOf(String.fromCharCode(charagrs[i].toUpperCase().charCodeAt(0)+65248))>=0){
			alert("["+strname+"]中不能包含全角大写字母！");
			return false;
		}
	}
	var noteagrs=[",",".","?","/",">","<",";",":","\"","'","{","}","[","]","`","~","!","@","#","$","%","^","&","*","(",")","-","_","+","=","|","\\"]
	//3、名称中可以是有“•”,“（）”,“《》”，不能有其它的标点符号。
	for(var i=0;i<charagrs.length;i++){
		if(txtstr.indexOf(noteagrs[i])>=0){
			alert("["+strname+"]中不能包含半角标点符号！");
			return false;
		}
		if(String.fromCharCode(noteagrs[i].charCodeAt(0)+65248)!="•"
		&& String.fromCharCode(noteagrs[i].charCodeAt(0)+65248)!="（"
		&& String.fromCharCode(noteagrs[i].charCodeAt(0)+65248)!="）" 
		&& String.fromCharCode(noteagrs[i].charCodeAt(0)+65248)!="《"
		&& String.fromCharCode(noteagrs[i].charCodeAt(0)+65248)!="》"){
			if(txtstr.indexOf(String.fromCharCode(noteagrs[i].charCodeAt(0)+65248))>=0){
				alert("["+strname+"]中不能包含除了•（）《》全角标点符号！");
				return false;
			}
		}
	}
	return true;
}

/*****************************************************************************************************
*******申请的地址必须是汉字或者全角数字
*******************************************************************************************************/
function validateAddress(txtstr,strname){  
	for(var i=0;i<txtstr.length;i++){
		if(txtstr.charCodeAt(i)<=128){
			alert("["+strname+"]必须是全角");
			return false;
		}
	}
	return true;
}
/**
   checkRegCapRate  在外商投资企业中判断注册资本占投资总额的比例
 **/
 function checkRegCapRate(regcap,totalmoney){
 	var cap = parseFloat(regcap);//注册资本
 	var tMoney = parseFloat(totalmoney);//投资总额
 	if(cap>tMoney)
 	{
 		alert("注册资本不能大于投资总额!")
        	return false;
 	}
 	var standMoney = 0;     //判断标准
	if(tMoney <= 300)
	{
        	standMoney = tMoney * 0.7;
        	if(cap<standMoney)
        	{
        		alert("注册资本不能低于投资总额的十分之七!")
        		return false;
        	}        	
	}
	else if(tMoney>300&&tMoney<=1000)
	{
		standMoney = tMoney * 0.5;
		if(tMoney<=420)
		{
			if(cap<210)
			{
				alert("注册资本不能低于二百一十万!")
        			return false;
			}	
		} 
		else if(cap<standMoney)
        	{
        		alert("注册资本不能低于投资总额的二分之一!")
        		return false;
        	}
	}
	else if(tMoney>1000&&tMoney<=3000)
	{
		standMoney = tMoney * 0.4;
		if(tMoney<=1250)
		{
			if(cap<500)
			{
				alert("注册资本不能低于五百万!")
        			return false;
			}	
		} 
		else if(cap<standMoney)
        	{
        		alert("注册资本不能低于投资总额的五分之二!")
        		return false;
        	}
	}
	else if(tMoney>3000)
	{
		standMoney = tMoney * 0.3;
		if(tMoney<=3600)
		{
			if(cap<1200)
			{
				alert("注册资本不能低于一千二百万!")
        			return false;
			}	
		} 
		else if(cap<standMoney)
        	{
        		alert("注册资本不能低于投资总额的三分之一!")
        		return false;
        	}
	}
	return true;
 }  
 
/**
* 股东变更时，验证缴付信息的值是否合法
*/
function validateTermData(actmoneyconam, 
						  noneactmoneyconam, 
						  actgoodsconam,
						  noneactgoodsconam,
						  actindustryconam, 
						  noneactindustryconam,
						  actpatentconam, 
						  noneactpatentconam,
						  actlandconam, 
						  noneactlandconam,
						  actotherconam,
						  noneactotherconam) {
	
	if(!validateDigital(actmoneyconam, "货币实缴")) {
		return false;
	}
	if(!validateDigital(noneactmoneyconam, "货币待缴")) {
		return false;
	}
	if(!validateDigital(actgoodsconam, "实物实缴")) {
		return false;
	}
	if(!validateDigital(noneactgoodsconam, "实物待缴")) {
		return false;
	}
	if(!validateDigital(actindustryconam, "知识产权（工业产权）实缴")) {
		return false;
	}
	if(!validateDigital(noneactindustryconam, "知识产权（工业产权）待缴")) {
		return false;
	}
	if(!validateDigital(actpatentconam, "知识产权（非专利技术）实缴")) {
		return false;
	}
	if(!validateDigital(noneactpatentconam, "知识产权（非专利技术）待缴")) {
		return false;
	}
	if(!validateDigital(actlandconam, "土地使用权实缴")) {
		return false;
	}
	if(!validateDigital(noneactlandconam, "土地使用权待缴")) {
		return false;
	}
	if(!validateDigital(actotherconam,"其他实缴")) {
		return false;
	}
	if(!validateDigital(noneactotherconam,"其他待缴")) {
		return false;
	}

	return　true;
}
/**
* 股东变更时，验证缴付信息的值是否合法(修改)
*/
function validateTermDataWithNoActpatent(actmoneyconam, 
						  noneactmoneyconam, 
						  actgoodsconam,
						  noneactgoodsconam,
						  actindustryconam, 
						  noneactindustryconam,
						  actlandconam, 
						  noneactlandconam,
						  actotherconam,
						  noneactotherconam) {
	
	if(!validateDigital(actmoneyconam, "货币实缴")) {
		return false;
	}
	if(!validateDigital(noneactmoneyconam, "货币待缴")) {
		return false;
	}
	if(!validateDigital(actgoodsconam, "实物实缴")) {
		return false;
	}
	if(!validateDigital(noneactgoodsconam, "实物待缴")) {
		return false;
	}
	if(!validateDigital(actindustryconam, "知识产权实缴")) {
		return false;
	}
	if(!validateDigital(noneactindustryconam, "知识产权待缴")) {
		return false;
	}
	if(!validateDigital(actlandconam, "土地使用权实缴")) {
		return false;
	}
	if(!validateDigital(noneactlandconam, "土地使用权待缴")) {
		return false;
	}
	if(!validateDigital(actotherconam,"其他实缴")) {
		return false;
	}
	if(!validateDigital(noneactotherconam,"其他待缴")) {
		return false;
	}

	return　true;
}
/**
* 股东变更时，验证缴付信息的值是否合法 （由于业务变化，加了此方法）
*/
function validateInverstorTermData(actmoneyconam, 
						  actgoodsconam,
						  actindustryconam,
						  actlandconam,
						  actotherconam) {
	
	if(!validateDigital(actmoneyconam, "货币实缴")) {
		return false;
	}
	if(!validateDigital(actgoodsconam, "实物实缴")) {
		return false;
	}
	if(!validateDigital(actindustryconam, "知识产权实缴")) {
		return false;
	}
	if(!validateDigital(actlandconam, "土地使用权实缴")) {
		return false;
	}
	if(!validateDigital(actotherconam,"其他实缴")) {
		return false;
	}
	return　true;
}
/**
* 股东变更时，动态验证缴付信息的值是否合法 add by larry
*/
function validateInverstorTermInfoData(value,key ) {
	
	if(!validateDigital(value, key)) {
		return false;
	}
	return　true;
}

/**
* 验证一个表单中至少选择一个复选框
*/
function validateCheckbox(formName) {
	for(var i=0;i<document.getElementById(formName).length;i++){
		if (document.getElementById(formName)[i].type == "checkbox"){
			if (document.getElementById(formName)[i].checked == true){
				return true;
			} 
		}
	}
	return false;
}

/**
* 验证货币出资不能低于注册资本总额的百分之三十
*/
function checkCash(regcap,cash) {
	var cap = parseFloat(regcap);//注册资本
 	var cash = parseFloat(cash);//货币出资
 	if (cash < cap*0.3){
 	    alert("货币出资不能低于注册资本总额的百分之三十!目前注册资本是："+ cap +"（万元）货币出资额是："+cash+"（万元）");
 	    return false;
 	}
	return true;
}

/**
*  验证法定代表人选中的时候是否选择了董事或经理。
*/ 
function checkLerep() {
	if ($('changeItems19')) { // 如果法定代表人存在
		if ($('changeItems19').checked) { 
			if ($('recordItems53') && $('recordItems54')) {
				if (!$('recordItems53').checked && !$('recordItems54').checked) {
					alert('如果选择了【法定代表人】变更事项，至少还需要选择【董事】或【经理】备案事项');
					return false;
				} 
			}
		} 
	} 
	
	return true;
}

/**
 * 验证多个输入项至少填一项(二期新增）
 * @Author WuWei
 * @date   2008-10-22
 * @param str		待验证的输入项拼接成的字符串
 * @param msg		输入项名称
 */
function isAtLeastOne(str, msg) {
	var reg=FormVerify.regRequire;
	if (reg.test(str)) {
		return true;
	} else {
		window.alert(msg+"至少填一项!");
		return false;
	}
}

/**
 * 验证非负整数
 * @author	WuWei
 * @date	2008-11-1
 * @param {} str		输入的数字
 * @param {} Msg		提示信息
 * @return {Boolean}
 */
function isNotNegativeInteger(str,Msg) {
	var reg=FormVerify.regNotNegativeInteger;
	if (reg.test(str)==false){
		window.alert("["+Msg+"]输入的格式不正确!");
		return false;
	}else{		
		return true;
	}
}

/**
 * 验证字符串是否超长
 * @author	wuwei
 * @date	2008-11-6
 * @param {} str
 * @param {} maxLength
 * @param {} msg
 */
function isExceedLength(str,maxLength,msg) {
	if (getStringLength(str)>maxLength){
		alert("["+msg+"]不得超过"+ Math.floor(maxLength/2) + "个汉字或"+maxLength+"个英文字符或数字！");
		return true;
	} else {
		return false;
	}
}
/**
 * 验证日期不得大于当前日期
 * @author	wuwei
 * @date	2008-11-8
 * @param {} birthdayStr，日期格式:"xxxx-xx-xx"
 * @return {Boolean}
 */
function checkBirthday(birthdayStr,msg) {
	    var birthdayArr  = birthdayStr.split("-");
	    var birthday = new Date(birthdayArr[0], birthdayArr[1]-1,birthdayArr[2]);
      	var now = new Date();
      	if(birthday.getTime() > now.getTime()) {
      		alert("[" + msg + "]不得大于当前日期！");
      		return false;
      	} else {
      		return true;
      	}
}

/**
 * 校验实收资本不得低于注册资本的20%
 * @author	ww
 * @date	2008-11-14
 * @param {} realCapital	实收资本
 * @param {} regCapital		注册资本
 * @return {Boolean}
 */
function checkRealCapRate(realCapital,regCapital) {
	var realCap = parseFloat(realCapital);//实收资本
 	var regCap = parseFloat(regCapital);//注册资本
 	if (realCap < regCap * 0.2) {
 	    alert("实收资本不得低于注册资本的百分之二十！");
 	    return false;
 	}
	return true;
}

/**
 * 校验注册资本不能大于投资总额
 * @author   ww
 * @date     2008-12-26
 * @param {} regcap
 * @param {} totalmoney
 * @return {Boolean}
 */
function checkTotalMoney(regcap,totalmoney){
 	var cap = parseFloat(regcap);//注册资本
 	var tMoney = parseFloat(totalmoney);//投资总额
 	if(cap>tMoney)
 	{
 		alert("注册资本不能大于投资总额!")
        return false;
 	}
	return true;
 }  
 /*****************************************************************************************************
*******密码是否含有全角，如果没有全角则返回true
*******************************************************************************************************/
function validatePassWord(txtstr){  
	for(var i=0;i<txtstr.length;i++){
		if(txtstr.charCodeAt(i)>128){
			return false;
		}
	}
	return true;
}

/**
 * 密码强度校验
 * @date     2010-3-11
 * @param {} sPW   密码
 * @param {} sName 用户名
 * @param {} isAlert 是否提示
 */
function checkPwStrong(sPW,sName,isAlert) {
    //判断是否包含了用户名
    if(sPW.indexOf(sName)!=-1){   
       if(isAlert == 1) {
           alert("密码长度应为6-10位，密码中必须包含0～9、a～z大小写字母和符号的混合使用，且不得包含用户名字符串。\n提示：密码中包含了用户名");
       }
       return -1;//密码包含用户名
    }

    var Modes = 0;
    if (sPW.length < 6) {
       if(isAlert == 1) {      
           alert("密码长度应为6-10位，密码中必须包含0～9、a～z大小写字母和符号的混合使用，且不得包含用户名字符串。\n提示：密码长度小于6位");
       }
       return 0;//密码过短
    }

	//遍历密码字符
    for(var i = 0; i < sPW.length; i++) {
       //alert(sPW +"-"+ Modes);
       Modes|=CharMode(sPW.charCodeAt(i)); 
    }

     var strong = bitTotal(Modes);
     if(strong < 2) {
        alert("密码长度应为6-10位，密码中必须包含0～9、a～z大小写字母和符号的混合使用，且不得包含用户名字符串。");
     }
       
       return strong;
}

//计算出当前密码当中一共有多少种模式 
function bitTotal(num) { 
    var modes=0; 
    for (var i=0;i<4;i++) { 
       if (num & 1) modes++; 
       num>>>=1; 
    } 
    return modes; 
} 

 /**
 * 校验:实缴的出资数额不能大于认缴的出资数额
 * @author   menglingwen
 * @date     2010-03-16
 * @param {} regcap
 * @param {} totalmoney
 * @return {Boolean}
 */
function checkRealCapMoney(regcap,totalmoney){
 	var cap = parseFloat(regcap);//实缴的出资数额
 	var tMoney = parseFloat(totalmoney);//认缴的出资数额
 	if(cap>tMoney)
 	{
 		alert("实缴的出资数额不能大于认缴的出资数额!")
        return false;
 	}
	return true;
 }  
 
 
 /**
 * 校验:外方出资额不能大于认缴的出资数额  
 * @author   menglingwen
 * @date     2010-03-16
 * @param {} regcap
 * @param {} totalmoney
 * @return {Boolean}
 */
function checkExternalMoney(regcap,totalmoney){
 	var cap = parseFloat(regcap);//外方出资
 	var tMoney = parseFloat(totalmoney);//认缴的出资数额
 	if(cap>tMoney)
 	{
 		alert("外方出资不能大于认缴的出资数额!")
        return false;
 	}
	return true;
 }  
 
 



// 测试某个字符是属于哪一类
function CharMode(iN) { 
    if (iN>=48 && iN <=57) //数字
    {
       return 1;
    }
    
    if (iN>=65 && iN <=90) //大写 
    {
       return 2;
    }

    if (iN>=97 && iN <=122) //小写
    {
       return 4;
    }

    else 
    {
       return 8;
    }
}




