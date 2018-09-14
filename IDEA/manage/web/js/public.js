//页面上需要校验的信息项 对象
var validateObjs;
//需要校验的FORM
var commonValidateForm;
//初始化，页面加载完成后执行
function initCommonValidate(formName){
	//加载目标FORM所有输入信息项的name
	
	commonValidateForm = document.forms[formName];
	
	var str = "";
	for(var i=0;i<commonValidateForm.elements.length;i++){
	    if (commonValidateForm.elements[i].validateId != null){
	    	fieldName=commonValidateForm.elements[i].validateId;
	    }else{   
			fieldName=commonValidateForm.elements[i].name;
		}
		if (str == "") {
			str = fieldName;
		}
		
		else {
			str = str + "," + fieldName;
		}   
	}
	//动态创建一个临时FROM，用来异步提交
	var commonValidateTempForm = document.createElement("FORM");
	document.body.appendChild(commonValidateTempForm);
	commonValidateTempForm.method = "POST";
	commonValidateTempForm.name = "commonValidateTempForm";
	
	
	var newElement = document.createElement("<input id='fieldNames' name='fieldNames' type='hidden'>");
	commonValidateTempForm.appendChild(newElement);
	newElement.value = str;

	DWRUtil.useLoadingMessage('正在加载校验数据，请稍等…');
	DWRActionUtil.execute({namespace:'/common', action:'getValidateJson', executeResult:'false'}, 'fieldNames', initCommonValidateCallback);	
}

function initCommonValidateCallback(commonValidateAction) {
	validateObjs = commonValidateAction.validateJsonList;
	//iframeheightchange("ifrid"); //deleted by ww, 2008-11-13
}

function commonValidate(){
	for(var i=0;i<commonValidateForm.elements.length;i++){
		var tempInputField = commonValidateForm.elements[i];
	    if (tempInputField.validateId != null){
	    	fieldFlag=commonValidateForm.elements[i].validateId;
	    }else{   
			fieldFlag=commonValidateForm.elements[i].name;
		}
		
	 	for (var k=0;k<validateObjs.length;k++){
			var tempTargetName = validateObjs[k][0];
			if(fieldFlag == tempTargetName) {
				var tempTargetValue = tempInputField.value;
				
				//校验时替换掉回车和'，不然后面eval报错 addBy Lucas 2008-1-16
				tempTargetValue = tempTargetValue.replace(/\r\n|'/g,"_");
				//if (tempInputField.name == "nameSecondPageVo.parentUnitInfo.opsco"){
				//	alert(tempTargetValue);
				//}
				var tempValidateStr = validateObjs[k][1];
				//替换所有的用 /g 参数，否则只替换第一个
				tempValidateStr = tempValidateStr.replace(/targetValue/g, tempTargetValue);
				var   a   =   tempValidateStr.split(";");   
		  		for(var j=0;   j<a.length;   j++){
		  		   	if (!eval(a[j])) return false; // Modified by ww, 2008-11-2
				}
			}
		}		
	}
	return true;
}

var AsdcUtil = {
  
};
//给SELECT输入域添加选择项
AsdcUtil.addListToSel = function(selboxID,list){
	//listItem = String[]{id,value}
	var selectObj = document.getElementById(selboxID);
	for (i=0;i<list.length;i++){
		var optionVal = list[i][0];
		var optionText = list[i][1];
		addOption(selectObj,optionVal,optionText);
	}
	
}

AsdcUtil.getRadioSelectValue = function(radioName){
	var radios = document.getElementsByName(radioName);
	for (i=0;i<radios.length;i++){
		if (radios[i].checked) return radios[i].value;
	}
	
}
//实缴，待缴显示
AsdcUtil.toSetValueForInput = function(act,noneact,size,actList,noneactList){
	
	for (i=0;i<size;i++){
	
		var actMany = actList[i];//实缴
		var noneactMany = noneactList[i];//待缴
		actMany = Math.round(actMany*10000)/10000;
		noneactMany = Math.round(noneactMany*10000)/10000;
		document.getElementById(i+act).innerHTML = actMany;
		document.getElementById(i+noneact).innerHTML = noneactMany; 
	}	
}

//待缴显示
AsdcUtil.toSetValueForInput_NeedToPay = function(noneact,size,noneactList){
	
	for (i=0;i<size;i++){
		var noneactMany = noneactList[i];//待缴
		noneactMany = Math.round(noneactMany*10000)/10000;
		document.getElementById(i+noneact).innerHTML = noneactMany; 
	}
}

// 給指定的select添加新的option選項 optionIndex插入位置
function addOption(objSelect,optionVal,optionText){
	var  _o=document.createElement("Option");  
	_o.text=optionText;
	_o.value=optionVal; 
	objSelect.add(_o);
}

function alertValidateObjs(){
	var tempstr = "";
	for (i=0;i<validateObjs.length;i++){
		tempstr = validateObjs[i][0] + " ------- " +  validateObjs[i][1];
		alert(tempstr);
	}
	
}
//帮助的JS函数
function showHelp(obj){
	helpObj = obj;
	var fieldText = obj.innerHTML;
	document.getElementById("fieldID").value = obj.id;
	//document.getElementById("showHelpText").innerHTML = "<img src='<%=basePath%>common/images/wait.gif'style='vertical-align:absmiddle' /> 正在获取帮助信息";
	document.getElementById("showHelpTitle").innerHTML = fieldText;

	document.all.showHelpText.innerText = "正在加载帮助信息...";
	showmenuie5();
	useLoadingMessage('正在加载帮助信息...');
	DWRActionUtil.execute({namespace:'/common', action:'getHelp', executeResult:'false'}, 'showHelpForm', showHelpCallback);

}

function showHelpCallback(HelpAction) {
	//alert(HelpAction.helpText);
	//alert(helpObj.innerHTML);
	//document.getElementById("showHelpText").innerHTML = HelpAction.helpText;
	//document.getElementById("showHelpText").innerText = HelpAction.helpText;
	document.all.showHelpText.innerText = HelpAction.helpText;
	
}

function   showmenuie5(){   
	var leftedge=document.body.clientWidth-event.clientX-100;   
	var bottomedge=document.body.clientHeight-event.clientY + 100;   
	if   (leftedge<ie5menu.offsetWidth)   
		ie5menu.style.left = document.body.scrollLeft+event.clientX-ie5menu.offsetWidth;   
	else   
		ie5menu.style.left = document.body.scrollLeft+event.clientX   
	if (bottomedge<ie5menu.offsetHeight)   
		ie5menu.style.top = document.body.scrollTop+event.clientY-ie5menu.offsetHeight   
	else   
		ie5menu.style.top = document.body.scrollTop+event.clientY   
	//ie5menu.style.visibility="visible"  
	ie5menu.style.display = "";
	return   false
}   
 
function   hidemenuie5(){   
	//ie5menu.style.visibility="hidden"
	ie5menu.style.display="none";
}   

/**
 * 调整iframe高度自适应
 * @author wuwei
 * @date   2008-11-6
 * @param {} divid 在body里面嵌套一个div
 */
function adjustIframeHeight(divid) {
	if($(divid) == null) {
		return;
	}
	 var parentobj=parent.document.getElementById("ifrid");
	 if(null != parentobj) {
	 	parentobj.style.height=$(divid).offsetHeight + 20;
	 	//后台管理页面修改后的预览需要修改父亲的高度
        if (parent.parent != null){
            if (parent.parent.document.getElementById("ifrid") != null){
        	    parent.parent.document.getElementById("ifrid").style.height=$(divid).offsetHeight + 20;
            }
        }
	 }
	  
}

function iframeheightchange(iframeid){
	if (parent!= null){
		var parentobj=parent.document.getElementById(iframeid);
		if (parentobj != null){
			parentobj.style.height=document.body.scrollHeight+20;
		  	//parentobj.style.width=document.body.scrollWidth+10;-->
            //后台管理页面修改后的预览需要修改父亲的高度
            if (parent.parent != null){
                if (parent.parent.document.getElementById(iframeid) != null){
            	    parent.parent.document.getElementById(iframeid).style.height=document.body.scrollHeight+20;
                }
            }
	  	}
  	}
}

function subIframeHeight(iframeid){
	if (parent!= null){
		var parentobj=parent.document.getElementById(iframeid);
		if (parentobj != null){
			parentobj.style.height=document.body.scrollHeight - 20;
		  	//parentobj.style.width=document.body.scrollWidth+10;-->
            //后台管理页面修改后的预览需要修改父亲的高度
            if (parent.parent != null){
                if (parent.parent.document.getElementById(iframeid) != null){
            	    parent.parent.document.getElementById(iframeid).style.height=document.body.scrollHeight - 20;
                }
            }
	  	}
  	}
}

function addiframeheight(iframeid,addheight){
	var parentobj=parent.document.getElementById(iframeid);
	parentobj.style.height=document.body.scrollHeight+addheight;
  	//parentobj.style.width=document.body.scrollWidth+10;
}
function iframeheightchangeHeight(iframeid){
	var parentobj=parent.document.getElementById(iframeid);
	parentobj.style.height=document.body.scrollHeight;
  	//parentobj.style.width=document.body.scrollWidth;
}

//在主业面显示企业类型 add by Li Jian
//parent.document.getElementById("corpName").innerText="";
function setCorpType(corpType){
	if (parent!= null){
		var parentobj=parent.document.getElementById("corpTypeName");
		if (parentobj != null){
			parentobj.innerText="（"+corpType+"）";
	  	}
  	}
}

function PublicUtil(){
}
//获取对象的值
function $$(id){
	return document.getElementById(id).value;
}

//获取对象ID
function $(id){
	return document.getElementById(id);
}

//获取select被选中的文本信息
function $s(id){
	var select =  document.getElementById(id);
	return select.options[select.selectedIndex].innerText;
}

//获取checkBox取值，返回Array
AsdcUtil.selectCheckBox = function selectCheckBox(checkBoxName){
    var aa = document.getElementsByName(checkBoxName);
    for (var i=0; i<aa.length; i++)
    {
     	if(aa[i].checked){
    		return aa[i].value;
  		}
	}	

}

//add by zhenghu 获取checkBox取值用@链接成字符串，返回String
AsdcUtil.selectCheckBoxStr = function selectCheckBoxStr(checkBoxName){
    var aa = document.getElementsByName(checkBoxName);
    var str="";
    for (var i=0; i<aa.length; i++)
    {
     	if(aa[i].checked){
    		str= str+aa[i].value+"@";
  		}
	}
	return str;

}

//选中SelectBox的值
AsdcUtil.selectValue = function selectValue(selectID,value){
   var selectObj = $(selectID);
   for (var i=0; i<selectObj.length; i++)
   {
    	if(selectObj[i].value == value){
	   		selectObj[i].selected = "selected";
	   		break;
 		}
	}
	$(selectID).value=value;
}	



//获取radio被选中的值
function selectRadio(radioname){
    var aa = document.getElementsByName(radioname);
    for (var i=0; i<aa.length; i++)
    {
     	if(aa[i].checked){
    		return aa[i].value;
  		}
	}
}


//清空form
function clearform(formname){
	for(var i=0;i<=$(formname).length-1;i++)
	{
		t=$(formname).elements[i].type;
		if(t!="button"){
			if(t=="select-one"){
				$(formname).elements[i].selectedIndex="0";
			}else{
				$(formname).elements[i].value="";
			}
		}
	}
};
//Disable掉页面元素
PublicUtil.disable=function(id){
	$(id).style.display="none";
	$(id).disabled=true;
};
//Enable页面元素
PublicUtil.enable=function(id){
	$(id).style.display="";
	$(id).disabled=false;
};
//显示页面元素
PublicUtil.appear=function(id){
	$(id).style.display="";
};
//不显示页面元素
PublicUtil.disappear=function(id){
	$(id).style.display="none";
};
//焦点
function focuson(id){
	$(id).focus();
};


//判断是否出现错误页面提示
function applyCondition(states,nexturl){
	if ( states=="-1" )
		this.location="login_error.jsp";
	else
		this.location=nexturl;
}

function getTotalMoney(name) {
	var totalMoney = 0;
	
	totalMoney += getValue($("termInfo." + name + "actmoneyconam").value);
	totalMoney += getValue($("termInfo." + name + "actgoodsconam").value);
	totalMoney += getValue($("termInfo." + name + "actindustryconam").value);
	//totalMoney += getValue($("termInfo." + name + "actpatentconam").value);
	totalMoney += getValue($("termInfo." + name + "actlandconam").value);
	totalMoney += getValue($("termInfo." + name + "actotherconam").value);
	
	return roundNumber(totalMoney, 6);
}


function getValue(value) {
	var ret = parseFloat(value);
	
	if (ret == NaN) {
		return 0;
	}
	
	return ret;
}

/**
*  保留小数点位数
*  powNumber -> 需要保留几位小数字
*/
function roundNumber(input, powNumber) { 
	var num = Math.pow(10, powNumber);
	
	return Math.round(parseFloat(input)*num)/num;
}

//变更备案事项联动
function changeRecordItems(name,id) {
}

/**
*  法定代表人，股东相关变更事项。
*/
function changeItemsCommon(name, id,entType) {
	var obj = $(name + id);
	
	if (!obj) {
		return;
	}
	
	//选择了变更事项中的除了“法定代表人和实收资本”以外的任何一项或多项，默认把备案事项中的公司章程前的对勾选中
	if (name == 'changeItems' && id != '19' && id != '18') {
		if (obj.checked && $('recordItems66') != null ) {
			$('recordItems66').checked = true; // 选中章程
		}
	} else if (name == 'recordItems' && id == '20') {  // 选中的是投资总额
		if (obj.checked && $('recordItems66') != null ) {
			$('recordItems66').checked = true; // 选中章程
		}
	}
	//股东姓名和名称变更 提示：
	if(name=='changeItems' && id=='16'){
		entType = entType.substring(0,4);
		if(entType == '1204'){
			//合伙企业
			alert('此项变更只限于原自然人合伙人姓名改变或原非自然人合伙人名称改变，不涉及新合伙人加入；如您申请增减资本（金）等变更事项，请勾选【合伙人及其出资情况变更】。');
		}else{
			alert('此项变更只限于原自然人股东姓名改变或原法人股东名称改变，不涉及新股东加入；如您申请股权转让、增减资本（金）等变更事项，请勾选【股东及其出资情况变更】。');
		}
	}
	
	
	if (id == '19') { // 法定代表人
		if (obj.checked) {  
			$('recordItems53').checked = true; // 选中董事
			$('recordItems54').checked = true; // 选中经理
			alert('法定代表人变化，请同时修改董事和经理信息！');
			return;
		}
	} else if (id == '53' || id == '54') { // 董事或经理
		if (obj.checked) {
			// Do nothing...
			//$('changeItems19').checked = true;
			//return;
		} else if (!$('recordItems53').checked && !$('recordItems54').checked) {
			$('changeItems19').checked = false;
 
			return;	
		}
	} else if (id == '15') { // 注册资本
		if (obj.checked) { 
			if ($('changeItems18')) {
				$('changeItems18').checked = true;  // 实收资本
			}
			$('changeItems17').checked = true;  // 选中股东及其出资情况变更
		}
	//} else if (id == '18') { // 实收资本
	//	if (obj.checked) {
	//		$('changeItems17').checked = true;  // 选中股东及其出资情况变更
	//	}
	} else if (id == '17') { // 股东及其出资情况变更
		// 如果不选择【股东及其出资情况】,注册资本和实收资本也不应该选中
		if (!obj.checked) {
			$('changeItems15').checked = false; // 注册资本
			//$('changeItems18').checked = false; // 实收资本
		}
	}
}


function setCookies(cookiesName,cookiesValue,time) {//time：秒
	var date = new Date();
	date.setTime(date.getTime() + time);
	document.cookie = cookiesName + "=" + escape(cookiesValue) + ";expires=" +  date.toGMTString();
}
function setCookiesNoTime(cookiesName,cookiesValue) {
	document.cookie = cookiesName + "=" + escape(cookiesValue);
}
function getCookieVal(offset)
{
	var endstr = document.cookie.indexOf(";", offset);
	if(endstr == -1)
	{
	endstr = document.cookie.length;
	}
	return unescape(document.cookie.substring(offset, endstr));
} 
function getCookies(cookiesNames) {
	var arg = cookiesNames + "=";
	var alen = arg.length;
	var clen = document.cookie.length;
	var i = 0;
	while(i < clen)
	{
	var j = i + alen;
	if (document.cookie.substring(i, j) == arg)
	{
	return getCookieVal(j);
	}
	i = document.cookie.indexOf(" ", i) + 1;
	if(i == 0) break;
	}
	return; 
	
}

// 从区县id取得对应的工商所id的方法
// 参数为 区县的名称
// codelib 表内共：
/*
东城 01
西城 02
崇文 03
宣武 04
朝阳 05
海淀 06
丰台 07
石景山 08
顺义 09
通州 10
怀柔 11
平谷 12
大兴 13
房山 14
门头沟 15
昌平 16
密云 17
延庆 18
经济技术开发区 19
燕山 20
*/
// 对应department表内：
/*
2	东城 
3	西城 
4	崇文 
5	宣武 
6	朝阳 
7	海淀 
8	丰台 
9	石景山
10	顺义 
11	通州 
12	怀柔 
13	平谷 
14	大兴 
15	房山 
16	燕山 
17	门头沟
18	昌平
19	密云
20	延庆 
21	开发区 
*/
function region2deptid(regioname){
	if(regioname=="01"){
		return "2";
	}else if(regioname=="02"){
		return "3";
	}else if(regioname=="03"){ // 崇文
		//return "4";
		return "2"; // 东城
	}else if(regioname=="04"){ // 宣武
		//return "5";
		return "3"; // 西城
	}else if(regioname=="05"){
		return "6";
	}else if(regioname=="06"){
		return "7";
	}else if(regioname=="07"){
		return "8";
	}else if(regioname=="08"){
		return "9";
	}else if(regioname=="09"){
		return "10";
	}else if(regioname=="10"){
		return "11";
	}else if(regioname=="11"){
		return "12";
	}else if(regioname=="12"){
		return "13";
	}else if(regioname=="13"){
		return "14";
	}else if(regioname=="14"){
		return "15";
	}else if(regioname=="15"){
		return "17";
	}else if(regioname=="16"){
		return "18";
	}else if(regioname=="17"){
		return "19";
	}else if(regioname=="18"){
		return "20";
	}else if(regioname=="19"){
		return "21";
	}else if(regioname=="20"){
		return "16";
	}
	
}


// 从工商所id取得区县id对应的的方法
function deptid2region(regioname){
	if(regioname=="2"){
		return "01";
	}else if(regioname=="3"){
		return "02";
	}else if(regioname=="4"){
		return "03";
	}else if(regioname=="5"){
		return "04";
	}else if(regioname=="6"){
		return "05";
	}else if(regioname=="7"){
		return "06";
	}else if(regioname=="8"){
		return "07";
	}else if(regioname=="9"){
		return "08";
	}else if(regioname=="10"){
		return "09";
	}else if(regioname=="11"){
		return "10";
	}else if(regioname=="12"){
		return "11";
	}else if(regioname=="13"){
		return "12";
	}else if(regioname=="14"){
		return "13";
	}else if(regioname=="15"){
		return "14";
	}else if(regioname=="17"){
		return "15";
	}else if(regioname=="18"){
		return "16";
	}else if(regioname=="19"){
		return "17";
	}else if(regioname=="20"){
		return "18";
	}else if(regioname=="21"){
		return "19";
	}else if(regioname=="16"){
		return "20";
	}
	
}

/**
**特殊区域代码ID返回相对应的depID
**/	
function specialRegion2depID(codeKey){
	if (codeKey == "01") {
		return "47";
	} 
	else if(codeKey == "03"){
		return "48";
	}
	else if(codeKey == "04"){
		return "49";
	}
	else if(codeKey == "05"){
		return "50"; 
	}
	else if(codeKey == "06"){
		return "51";
	}else if(codeKey=="02")	{
		return "23";//add by larry 如果下面有分所，zk修改
	}	
}

/**
 * 判断Select是否存在值为value的item
 * @author   wuwei
 * @date     2008-10-29
 * @param {} selectId
 * @param {} value
 * @return {Boolean}
 */
function isSelectContainsValue(selectObj,value) {
	for (var i=0; i<selectObj.length; i++) {
    	if(selectObj[i].value == value){
	   		return true;
 		}
	}
	return false;
}

/**
 * 将源下拉框选中的item移动到目标下拉框，但不删除源下拉框中的item (for 2nd)
 * @author   wuwei
 * @date     2008-10-29
 * @param {} fromSelectId 源下拉框id
 * @param {} toSelectId   目标下拉框id
 * @return {Boolean}
 */
function moveItem(fromSelectId, toSelectId) {
	var fromObj = $(fromSelectId);
	if(fromObj.selectedIndex == 0) {
		return false;
	}
	var selectedText = $s(fromSelectId);
	var toObj = $(toSelectId);
	if(isSelectContainsValue(toObj, selectedText)) {
		alert('请不要重复添加');
		fromObj.selectedIndex = 0;
		return true;
	}
	addOption(toObj, selectedText, selectedText);
	fromObj.selectedIndex = 0;
	return true;
}

/**
 * 删除下拉框中选中的item
 * @author    wuwei
 * @date      2008-10-29
 * @param {} selectId
 */
function removeSelectedItem(selectId) {
	var selectObj = $(selectId);
	if(selectObj == null) {
		return;
	}
    selectObj.options.remove(selectObj.selectedIndex);
}

/**
 * 外资设立，拼接所属股东
 * @author wuwei
 * @date   2008-10-29
 */
function saveAppointUnit(selectId, strConnected) {
      var allAppointUnit = "";
      for(var i = 0; i<$(selectId).length; i++) {
          if(i==0){
              allAppointUnit = $(selectId).options[i].text;
          }else{
              allAppointUnit = allAppointUnit + "#!" + $(selectId).options[i].text;
          }
      }
      $(strConnected).value = allAppointUnit;
}

/**
 * 外资设立，解析所属股东，初始化下拉框
 * @author wuwei
 * @date   2008-10-29
 * @param {} appointUnit ”股东1,股东2,... ..."
 */
 function initAppointUnit(appointUnit, selectId) {
 	var appointUnitArray = appointUnit.split("#!");
    if(appointUnitArray.length != 0){
        var oSelect = $(selectId);
        for(var i = 0; i < appointUnitArray.length; i++){
            if(appointUnitArray[i] != ""){
            	addOption(oSelect, appointUnitArray[i], appointUnitArray[i]);
            }
        }
	}
}

/**
 * prevent submit when press enter in input text box
 * @param {e} event
 */
function onKeyDownSetting(e){
	if (!e){
	    var e = window.event;
	}
	if ( e.keyCode==13 ){	
		return false;
	}
}

/**
 * 组装名称预核文号
 * @param {} organ		机构：京/京海/京朝/......
 * @param {} type		类型：外/个/内/......
 * @param {} year		年份：2008/2009/......		
 * @param {} serial		流水号
 * @return {}
 * @author ww
 * @date   2009-2-3
 */
function joinNameRegNo(organ, type, year, serial) {
	var reg=FormVerify.regRequire;
	if (!(reg.test(organ.Trim()) && reg.test(type.Trim()) && reg.test(year.Trim()) && reg.test(serial.Trim()))){
		window.alert("请将名称预核文号填写完整！");
		return "";
	}
	
	var nameRegNoTemplate = "(ORGAN)名称预核(TYPE)字 [YEAR] 第 SERIAL 号";
	var nameRegNo = nameRegNoTemplate.replace(/ORGAN/,organ).replace(/TYPE/,type)
									 .replace(/YEAR/,year).replace(/SERIAL/,serial);
	return nameRegNo;
}

function joinNameRegNoforName(organ, character,type, year, serial) {
	var reg=FormVerify.regRequire;
	if (!(reg.test(organ.Trim()) && reg.test(type.Trim()) && reg.test(character.Trim()) && reg.test(year.Trim()) && reg.test(serial.Trim()))){
		window.alert("请将名称预核文号填写完整！");
		return "";
	}
	
	var nameRegNoTemplate = "(ORGAN)名称CHARACTER核(TYPE)字 [YEAR] 第 SERIAL 号";
	var nameRegNo = nameRegNoTemplate.replace(/ORGAN/,organ).replace(/CHARACTER/,character).replace(/TYPE/,type)
									 .replace(/YEAR/,year).replace(/SERIAL/,serial);
	return nameRegNo;
}

/**
 * 解析名称预核文号
 * @param {} nameRegNo		(XX)名称预核(X)字 [XXXX] 第 XXXXXXX 号
 * @return {}
 * @author ww
 * @date   2009-2-3
 */
function splitNameRegNo(nameRegNo) {
	var array = nameRegNo.replace(/\((.*)\)名称预核\((.*)\)字\s+\[(.*)\]\s+第\s+(.*)\s+号/,"$1@$2@$3@$4").split('@');
	return array;
}
