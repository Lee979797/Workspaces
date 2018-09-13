var DfileQuery = Ext.data.Record.create([
	{name : 'orgid',mapping : 'orgid',type : 'int'}, 
	{name : 'centerid',mapping : 'centerid',type : 'string'},
	{name : 'orderid',mapping : 'orderid',type : 'string'}, 
	{name : 'jgdm',	mapping : 'jgdm',type : 'string'}, 
	{name : 'jgmc',mapping : 'jgmc',type : 'string'}, 
	{name : 'jglx',mapping : 'jglx',type : 'string'},
	{name : 'fddbr',mapping : 'fddbr',type : 'string'}, 
	{name : 'zjlx',mapping : 'zjlx',type : 'string'}, 
	{name : 'zjhm',mapping : 'zjhm',type : 'string'}, 
	{name : 'jyfw',mapping : 'jyfw',type : 'string'}, 
	{name : 'zcrq',mapping : 'zcrq',type : 'date',dateFormat:'Y-M-D'}, 
	{name : 'xzqhCode',mapping : 'xzqhCode',type : 'string'},
	{name : 'xzqhName',mapping : 'xzqhName',type : 'string'},
	{name : 'jgdz',mapping : 'jgdz',type : 'string'}, 
	{name : 'yzbm',mapping : 'yzbm',type : 'string'}, 
	{name : 'dhhm',mapping : 'dhhm',type : 'string'}, 
	{name : 'zycp1',mapping : 'zycp1',type : 'string'}, 
	{name : 'zycp2',mapping : 'zycp2',type : 'string'}, 
	{name : 'zycp3',mapping : 'zycp3',type : 'string'}, 
	{name : 'zczj',mapping : 'zczj',type : 'string'}, 
	{name : 'wftzgb',mapping : 'wftzgb',type : 'string'}, 
	{name : 'zgrs',mapping : 'zgrs',type : 'string'}, 
	{name : 'zch',mapping : 'zch',type : 'string'}, 
	{name : 'pzwh',mapping : 'pzwh',type : 'string'},
	{name : 'pzrq',mapping : 'pzrq',type : 'date',dateFormat:'Y-M-D'},
	{name : 'pzjgmc',mapping : 'pzjgmc',type : 'string'},
	{name : 'pzjgdm',mapping : 'pzjgdm',type : 'string'},
	{name : 'kfgk',mapping : 'kfgk',type : 'string'},
	{name : 'email',mapping : 'email',type : 'string'},
	{name : 'weburl',mapping : 'weburl',type : 'string'},
	{name : 'mobile',mapping : 'mobile',type : 'string'},
	{name : 'tbrxm',mapping : 'tbrxm',type : 'string'},
	{name : 'tbrsfzh',mapping : 'tbrsfzh',type : 'string'},
	{name : 'tbrlxfs',mapping : 'tbrlxfs',type : 'string'},
	{name : 'jydz',mapping : 'jydz',type : 'string'},
	{name : 'jyyb',mapping : 'jyyb',type : 'string'},
	{name : 'jydh',mapping : 'jydh',type : 'string'},
	{name : 'jfly',mapping : 'jfly',type : 'string'},
	{name : 'zsbfrq',mapping : 'zsbfrq',type : 'date', convert:function(v){if(v) return v.substring(0,10);}},
	{name : 'zszfrq',mapping : 'zszfrq',type : 'date', convert:function(v){if(v) return v.substring(0,10);}},
	{name : 'jjlx',mapping : 'jjlx',type : 'string'},
	{name : 'jjlxdm',mapping : 'jjlxdm',type : 'string'},
	{name : 'tbrzjlx',mapping : 'tbrzjlx',type : 'string'},
	{name : 'memo',mapping : 'memo',type : 'string'},
	{name : 'memo2',mapping : 'memo2',type : 'string'},
	
	{name : 'hbzl',mapping : 'hbzl',type : 'string'},
	{name : 'hbzldm',mapping : 'hbzldm',type : 'string'},
	
	{name : 'khyh',mapping : 'khyh',type : 'string'},
	{name : 'khzh',mapping : 'khzh',type : 'string'},
	{name : 'userid',mapping : 'userid',type : 'string'},
	{name : 'username',mapping : 'username',type : 'string'},
	{name : 'handleUsername', mapping: 'handleUsername',type : 'string'},
	{name : 'handleName', mapping: 'handleName',type : 'string'},
	{name : 'handleDate', mapping: 'handleDate',type : 'string'},
	{name : 'handleNote', mapping: 'handleNote',type : 'string'},	
	{name : 'imageUrl', mapping: 'imageUrl',type : 'string'},
	
	{name : 'offPzjgmc', mapping: 'offPzjgmc',type : 'string'},
	{name : 'offPzwh', mapping: 'offPzwh',type : 'string'},
	{name : 'offReason', mapping: 'offReason',type : 'string'},	
	{name : 'offNote', mapping: 'offNote',type : 'string'},
	
	{name : 'errorFlag', mapping: 'errorFlag',type : 'string'},
	{name : 'd_flag',mapping : 'd_flag',type : 'int'}, 
	{name : 'up_Dflag',mapping : 'up_Dflag',type : 'int'}, 
	{name : 'up_Aflag',mapping : 'up_Aflag',type : 'int'},
	{name : 'pigeTime',mapping : 'pigeTime',type : 'date', convert:function(v){if(v) return v.substring(0,10);}},
	
	{name : 'state',mapping : 'state',type : 'string'}
]);


var arctypeStr2 = [['0','全部档案'],['1','新办'],['2','年检'],['3','迁出'],['4','迁入'],['5','变更'],['6','换证'],['7','补证'],['8','注销'],['9','其他'],['10','预赋码']]; 
var arctypeStore2 = new Ext.data.SimpleStore({fields:['arctypeCode','arctypeValue'],data:arctypeStr2});


//function veiwErrorflag(ErrorflagValue)
//{
//   if(ErrorflagValue.toString()!=""){
//	   var Errorflags = ErrorflagValue.split(",");
//	   var strEsFlag='';
//	   for (var i = 0; i < Errorflags.length-1; i++) {
//		   var esFlag=Errorflags[i];
//		   if(esFlag!=""){
//			   switch (esFlag) {
//			   case '1' :
//				   strEsFlag=strEsFlag+'<font color=red>1</font>图像不清晰 ';
//				   break;
//			   case '2' :
//				   strEsFlag=strEsFlag+'<font color=red>2</font>图像黑边、倾斜 ';
//				   break;
//			   case '3' :
//				   strEsFlag=strEsFlag+'<font color=red>3</font>图像混扫 ';
//				   break;
//			   case '4' :
//				   strEsFlag=strEsFlag+'<font color=red>4</font>图像残缺 ';
//				   break;
//			   case '5' :
//				   strEsFlag=strEsFlag+'<font color=red>5</font>建档日期错误 ';
//				   break;
//			   case '6' :
//				   strEsFlag=strEsFlag+'<font color=red>6</font>档案分类错误 ';
//				   break;
//			   case '7' :
//				   strEsFlag=strEsFlag+'<font color=red>7</font>申请表标识问题 ';
//				   break;
//			   case '8' :
//				   strEsFlag=strEsFlag+'<font color=red>8</font>批准证书标识问题 ';
//				   break;
//			   case '9' :
//				   alert("t9");
//				   strEsFlag=strEsFlag+'<font color=red>9</font>身份证明文件标识问题 ';
//				   break;
//			   case '10' :
//				   strEsFlag=strEsFlag+'<font color=red>10</font>其他文件标示问题 ';
//				   break;
//			   case '11' :
//				   strEsFlag=strEsFlag+'<font color=red>11</font>其他问题 ';
//				   break;
//			   case '12' :
//				   strEsFlag=strEsFlag+'<font color=red>12</font>批准文件不合格 ';
//				   break;
//			   case '13' :
//				   strEsFlag=strEsFlag+'<font color=red>13</font>缺页问题 ';
//				   break;
//			   case '20' :
//				   strEsFlag=strEsFlag+'<font color=red>20</font>批量问题 ';
//				   break;
//			   case '21' :
//				   strEsFlag=strEsFlag+'<font color=red>21</font>多个问题 ';
//				   break;
//			   case '22' :
//				   strEsFlag=strEsFlag+'<font color=red>22</font>年检执照问 ';
//				   break;
//			   default :
//				   strEsFlag=strEsFlag+'';
//			       break;
//			   } 
//	   		}else{
//	   			strEsFlag='';
//			}
//	   }
//   }else{
//	   strEsFlag="";
//   }
//   veiwErrorflag=strEsFlag;
//}

//点击列表信息，显示图书的扩展属性//
var expander_dfileQuery = new Ext.grid.RowExpander({
	tpl : new Ext.Template('<table width="100%"  border="0" cellspacing="6" cellpadding="0"  bgcolor="#DDEEF9" style="margin-top:1px;" >'
			+ '<tr>'
			+ '<td width="" colspan="4">'
			+ '<table width="98%" bgcolor="#ffffff" border="1" cellpadding="0" cellspacing="0" align="center"  bordercolordark="#FFFFFF" bordercolorlight="#6EBBE1" style="margin-top:0px;>'
			+ '<tr height="22" valign="middle">'
			+ '  <td width="20%" height="22" align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">机构名称：</td><td width="30%"  valign="middle" style="padding-top:5px">{jgmc}<img src="images/temp.gif"></td>'
			+ '  <td width="20%" height="22" align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">机构代码：</td><td width="30%"  valign="middle" style="padding-top:5px">{jgdm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle" >'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">法定代表人：</td><td nowrap="nowrap" style="padding-top:5px">{fddbr}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">机构类型：</td><td  nowrap="nowrap" style="padding-top:5px">{jglx}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">证件类型：</td><td nowrap="nowrap"  style="padding-top:5px">{zjlx}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">证件号码：</td><td nowrap="nowrap"  style="padding-top:5px">{zjhm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">主要经营或业务范围：</td><td  colspan=3 style="padding-top:5px">{jyfw}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">成立日期：</td><td nowrap="nowrap" style="padding-top:5px">{zcrq}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">职工人数：</td><td nowrap="nowrap" style="padding-top:5px">{zgrs}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">证照有效开始日期：</td><td nowrap="nowrap" style="padding-top:5px">{zsbfrq}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">证照有效终止日期：</td><td nowrap="nowrap" style="padding-top:5px">{zszfrq}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">企业登记注册类型：</td><td nowrap="nowrap" style="padding-top:5px">{jjlx} {jjlxdm}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">外商投资国或地区：</td><td nowrap="nowrap" style="padding-top:5px">{wftzgb} {wftzgbdm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">注册资金：</td><td nowrap="nowrap" style="padding-top:5px">{zczj}(万)<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">货币种类：</td><td nowrap="nowrap" style="padding-top:5px">{hbzl}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">主管部门及代码：</td><td nowrap="nowrap" style="padding-top:5px">{zgmc} {zgdm}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">批准机构及代码：</td><td nowrap="nowrap" style="padding-top:5px">{pzjgmc} {pzjgdm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">注册文号或注册号：</td><td nowrap="nowrap" style="padding-top:5px">{zch}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">邮政编码：</td><td nowrap="nowrap" style="padding-top:5px">{yzbm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">机构地址：</td><td nowrap="nowrap" style="padding-top:5px">{jgdz}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">行政区划：</td><td nowrap="nowrap" style="padding-top:5px">{xzqhName} {xzqhCode}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">电话号码：</td><td nowrap="nowrap" style="padding-top:5px">{dhhm}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">网址：</td><td nowrap="nowrap" style="padding-top:5px">{weburl}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">手机：</td><td nowrap="nowrap" style="padding-top:5px">{mobile}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">电子信箱：</td><td nowrap="nowrap" style="padding-top:5px">{email}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经办人名称：</td><td nowrap="nowrap" style="padding-top:5px">{tbrxm}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经办人证件类型：</td><td nowrap="nowrap" style="padding-top:5px">{tbrzjlx}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经办人证件号码：</td><td nowrap="nowrap" style="padding-top:5px">{tbrsfzh}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经办人电话：</td><td nowrap="nowrap" style="padding-top:5px">{tbrlxfs}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经济行业：</td><td nowrap="nowrap" style="padding-top:5px">{jjhymc} {jjhydm}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">机构类型：</td><td nowrap="nowrap" style="padding-top:5px">{jglx}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">是否公开：</td><td nowrap="nowrap" colspan="3" style="padding-top:5px">{gk}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '</table>'
			+ '</td></tr></table>')
});

//--------------------查看临时库机构档案信息-------------------------------------------
var dfileQueryEditForm = new Ext.FormPanel({
	loadMask : {
		msg : '数据加载中...'
	},
	url : 'updateDfileQuery.action',
	labelAlign : 'right',
	labelWidth : 60,
	bodyStyle : 'padding:5px',
	border : false,
	autoHeight : true,
	autoScroll : true, 
	baseCls : 'x-plain',
	waitMsgTarget: true,
	items : [{
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		items : [{//第一行修改
			columnWidth : 1,
			layout : 'form',
			baseCls : 'x-plain',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items : [{xtype : 'hidden',name : 'DID'},{xtype : 'hidden',name : 'isbc',id : 'isbc',value:'0'},{xtype : 'hidden',name : 'ATTR',value:1},
			         {fieldLabel : '机构名称',	name : 'JGMC',allowBlank : false,readOnly:true,maxLength : 50,
		                listeners : {
		                    change : function(field,newValue,oldValue){
		                    	document.getElementById("isbc").value='1'; 
		                    }
		                }}]
		}]
	},{
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		items : [{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '机构代码',name : 'JGDM',allowBlank : false,readOnly:true,maxLength : 10}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '档案类型',name : 'ARCTYPE',allowBlank : false,readOnly:true,maxLength : 10}]
		}]
	},{	layout : 'column',
		border : false,
		baseCls : 'x-plain',
		items : [{//第三行修改
				layout : 'column',
				border : false,
				baseCls : 'x-plain',
				items : [{
					columnWidth : .5,
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'textfield',
					defaults : {anchor : '99%'},
					items :[{fieldLabel : '建档日期',name : 'NEWDATE',allowBlank : false,readOnly:true,maxLength : 10}]
				},{
					columnWidth : .5,
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'textfield',
					defaults : {anchor : '99%'},
					items :[{fieldLabel : '录档日期',name : 'MODIFYDATE',allowBlank : false,readOnly:true,maxLength : 10}]
				}]
		}]
	},{//表单修改
		xtype : 'panel',
		baseCls : 'x-plain',
		bodyBorder : false,
		layout : 'form',
		defaultType : 'textarea',
		defaults : {anchor:'99%'},
		items : [{fieldLabel : '问题类型',name : 'errorFlag',maxLength : 500,readOnly:true,disabled : true }]
	}]
});




var sm334 = new Ext.grid.CheckboxSelectionModel();
//列表显示图书主要信息//
var cm_dfileQuery = new Ext.grid.ColumnModel([expander_dfileQuery,
    sm334,
     {header : '流水号',	width : 20,dataIndex : 'orderid',sortable : true}, 
	{header : '机构代码',width : 40,dataIndex : 'jgdm',	sortable : true}, 
	{header : '机构名称',width : 120,dataIndex : 'jgmc',sortable : true}, 
	{header : '办证机构代码',width : 40,dataIndex : 'bzjgdm',sortable : true},
	{header : '建档日期',width : 30,	dataIndex : 'pigeTime',renderer: goDateFormat,sortable : true}, 
	{header : '录档日期',width : 30,dataIndex : 'lastdate',renderer: goDateFormat,sortable : true}, 
	{header : '档案类型',width : 30,dataIndex : 'ywlx',sortable : true}, 
	{header : '问题类型',width : 120,dataIndex : 'errorFlag',id : 'errorFlag',renderer : goErrorflag,menuDisabled : true}]
);


var dfileImg = new Ext.Panel({
	title   : '原文',
    region    : 'center',
    margins   : '3 3 3 0', 
    activeTab : 0,
    html: '<OBJECT classid="clsid:B4E2D33E-D8B2-4956-9F91-1C6BDC87A6D1"  width=100%  height=100% align=center hspace=0 vspace=0 id="scanner"  name="scanner" >'
	       +'<param name="ShowCount" value="8">'
	       +'<param name="sModel" value="1">'
	       +'</OBJECT>'
    
});

//Panel for the west
var  dfileView= new Ext.Panel({
    title       : '基本信息',
    region      : 'west',
    split       : true,
    width       : 360,
    collapsible : true,
    margins     : '3 0 3 3',
    cmargins    : '3 3 3 3',
	defaults  : {
		autoScroll : true
	},
    items : [dfileQueryEditForm]
}); 



var window_edit_dfileQuery = new Ext.Window({
	title : '数据查看',
	width : 800,
	height : 500,
	resizable : true,
	modal : true,
	plain    : true,
	layout   : 'border',
	closeAction : 'hide',
	maximizable:true,
	items : [dfileView,dfileImg],
	buttons : [{   
        text: '前一条',   
        handler: function() {
			//前一条
			var grid_ = grid_dfileQuery;
            var selModel = grid_.getSelectionModel();
            if(selModel.hasPrevious()){
                selModel.selectPrevious();
         		var record = grid_dfileQuery.getSelectionModel().getSelected();
         		if(record){
         			dfileQueryEditForm.getForm().loadRecord(record);
         		}
             }else{
                 alert("已经到第一条,请翻页");
             }  
        }
    },{   
        text: '下一条',   
        handler: function() {
        	 var grid_ = grid_dfileQuery;
             var selModel = grid_.getSelectionModel();
             if(selModel.hasNext()){
                selModel.selectNext();
         		var record = grid_dfileQuery.getSelectionModel().getSelected();
         		if(record){
         			dfileQueryEditForm.getForm().loadRecord(record);
         		}
             }else{
                 alert("已经到最后一条,请翻页");
             }
        }   
    },{  
        text: '退出',   
        handler: function() {   
        	window_edit_dfileQuery.hide(); 
        }   
    }]
   
});

function ShowInfoMsg(aMsg,winWidth){
	var InfoMsgWin=Ext.getCmp('InfoMsgWin');
	if(InfoMsgWin){
		InfoMsgWin.close();
	};
	var okBtn=new Ext.Button({
		id:'okButton',
		text:'确定',
		enableToggle:false,
		iconCls:'okbutton-icon-cls',
		minWidth:80,
		tooltip:'确定',
		handler:function(){
			var aWin=Ext.getCmp('InfoMsgWin');
			if(aWin){aWin.close();
		};
		delete aWin;
		}
	});
	InfoMsgWin=new Ext.Window({
		id:'InfoMsgWin',
		title:"提示信息",
		border:true,
		resizable:false,
		closable:true,
		closeAction:'close',
		modal:true,
		width:winWidth,
		iconCls:'msgwindow-icon-cls',
		html:aMsg,
		buttonAlign:'center',
		buttons:[okBtn]
	});
	InfoMsgWin.show();
	delete okBtn;
	delete InfoMsgWin;
};

var btn_refresh_registerQuery = new Ext.Button({
	text : '刷新',
	iconCls : 'icon-refresh',
	handler : function() {
		textSearchDfileQuery.value='';
		searchDfileQuery();
		//btn_edit_dfileQuery.setDisabled(true);
	}
});


var btn_view_dfileQuery = new Ext.Button({
	text : '查看',
	iconCls : 'icon-edit',
	handler : function(){
		var record = grid_dfileQuery.getSelectionModel().getSelected();
		if(record){
			window_edit_dfileQuery.show();
			dfileQueryEditForm.getForm().loadRecord(record);
		}
	}
})


var btn_query_dfileQuery = new Ext.Button({
	text : '高级查询',
	iconCls : 'icon-edit',
	handler : function(){
		window_dfileQuery.show();
	}
});

var gaojiQueryForm = new Ext.FormPanel({
	labelAlign : 'right',
	labelWidth : 70,
	bodyStyle : 'padding:5px',
	border : false,
	autoHeight : true,
	autoScroll : true, 
	baseCls : 'x-plain',
	waitMsgTarget: true,
	items : [{
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		items : [{//第一行基本
			columnWidth : 1,
			layout : 'form',
			baseCls : 'x-plain',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '100%'},
			items : [{fieldLabel : '机构代码',	name : 'JGDM',allowBlank : true,maxLength : 50}]
		}]
	},{
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		items : [{//第二行基本
			columnWidth : 1,
			layout : 'form',
			baseCls : 'x-plain',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '100%'},
			items : [{fieldLabel : '机构名称',	name : 'JGMC',allowBlank : true,maxLength : 50}]
		}]
		
	},{
		layout : 'column',//第三行基本
		border : false,
		baseCls : 'x-plain',
		items : [{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '100%'},
			items :[{xtype:'datefield',fieldLabel:'建档日期',name:'NEWDATE1',readOnly:false,format:'Y-m-d'}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '100%'},
			items :[{xtype:'datefield',fieldLabel:'至',name:'NEWDATE2',readOnly:false,format:'Y-m-d'} ]
		}]
		
	},{
		layout : 'column',//第四行基本
		border : false,
		baseCls : 'x-plain',
		items : [{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '100%'},
			items :[{xtype:'datefield',fieldLabel:'录档日期',name : 'MODIFYDATE1',readOnly : false,format:'Y-m-d'}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '100%'},
			items :[{xtype:'datefield',fieldLabel:'至',name : 'MODIFYDATE2',readOnly : false,format:'Y-m-d'} ]
		}]
		
	},{
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		items : [{//第五行基本
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '100%'},
			items :[{
				xtype : 'combo',
				fieldLabel : '档案类型',
				id : 'ARCTYPE_QUERY',
				name : 'ARCTYPE',
				displayField : 'arctypeValue',
				valueField : 'arctypeValue',
				hiddenName : 'ARCTYPE',
				store : arctypeStore2,
				triggerAction : 'all',
				lazyRender:true,
				emptyText:'',
				mode : 'local',
				selectOnFocus : true,
				allowBlank:true,
				editable : false
			}]
		}]
	}],
	buttonAlign : 'right',
	minButtonWidth : 60,
	buttons : [{
		text:'查询',
		handler : function(){
			if(this.ownerCt.getForm().isValid()){
				ds_dfileQuery.proxy = new Ext.data.HttpProxy({url:'findDfileGjQuery.action'});
				ds_dfileQuery.baseParams.jgmc=gaojiQueryForm.getForm().findField('jgmc').getValue();
				ds_dfileQuery.baseParams.jgdm=gaojiQueryForm.getForm().findField('jgdm').getValue();
				//alert(gaojiQueryForm.getForm().findField('NEWDATE1').getValue());
				if(gaojiQueryForm.getForm().findField('NEWDATE1').getValue()!=""){
					//alert("1");
					ds_dfileQuery.baseParams.snewdate=gaojiQueryForm.getForm().findField('NEWDATE1').getValue().format('Y-m-d');
					//alert("11");
				}
				if(gaojiQueryForm.getForm().findField('NEWDATE2').getValue()!="" ){
					//alert("2");
					ds_dfileQuery.baseParams.enewdate=gaojiQueryForm.getForm().findField('NEWDATE2').getValue().format('Y-m-d');
					//alert("22");
				}
				if(gaojiQueryForm.getForm().findField('MODIFYDATE1').getValue()!="" ){
					//alert("3");
					ds_dfileQuery.baseParams.smodifydate=gaojiQueryForm.getForm().findField('MODIFYDATE1').getValue().format('Y-m-d');
					//alert("33");
				}
				if(gaojiQueryForm.getForm().findField('MODIFYDATE2').getValue()!=""){
					ds_dfileQuery.baseParams.emodifydate=gaojiQueryForm.getForm().findField('MODIFYDATE2').getValue().format('Y-m-d');
					//alert("4");
				}
				ds_dfileQuery.baseParams.arctype=gaojiQueryForm.getForm().findField('ARCTYPE').getValue();
				ds_dfileQuery.baseParams.dflagConditions='2';
				ds_dfileQuery.baseParams.conditions ='';
				ds_dfileQuery.baseParams.username='';
				ds_dfileQuery.baseParams.stateConditions='';
				ds_dfileQuery.load({params : {start : 0,limit : 20}});	
			}
		}
	},{
		text : '取消',
		handler:function(){
			this.ownerCt.ownerCt.hide();
		}
	}]
});

var window_dfileQuery = new Ext.Window({
	title : '高级查询',
	width : 400,
	resizable : false,
	autoHeight : true,
	modal : true,
	closeAction : 'hide',
	items : [gaojiQueryForm]
});

var searchDfileQuery = function() {
	ds_dfileQuery.baseParams.conditions = text_search_dfileQuery.getValue();
	ds_dfileQuery.baseParams.jgmc=null;
	ds_dfileQuery.baseParams.jgdm=null;
	ds_dfileQuery.baseParams.snewdate=null;
	ds_dfileQuery.baseParams.enewdate=null;
	ds_dfileQuery.baseParams.smodifydate=null;
	ds_dfileQuery.baseParams.emodifydate=null;
	ds_dfileQuery.baseParams.arctype=null;
	ds_dfileQuery.baseParams.username='';
	ds_dfileQuery.baseParams.stateConditions='';
	ds_dfileQuery.load({params : {start : 0,limit : 20}});
}

var ds_dfileQuery = new Ext.data.Store({
	url : 'findDfile.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'orgid',type : 'int'}, 
	    {name : 'orderid',type : 'string'}, 
	    {name : 'centerid',type : 'string'},
		{name : 'jgmc',type : 'string'},
		{name : 'jgdm',type : 'string'},
		{name : 'jglx',type : 'string'}, 
		{name : 'fddbr',type : 'string'}, 
		{name : 'zjlx',type : 'string'},
		{name : 'zjhm',type : 'string'}, 
		{name : 'jyfw',type : 'string'},
		{name : 'zcrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'zgdm',type : 'string'},
		{name : 'zgmc',type : 'string'},
		{name : 'pzjgmc',type : 'string'},
		{name : 'xzqhCode',type : 'string'},
		{name : 'xzqhName',type : 'string'},
		{name : 'jgdz',type : 'string'},
		{name : 'yzbm',type : 'string'},
		{name : 'dhhm',type : 'string'},
		{name : 'bzjgdm',type : 'string'},
		{name : 'zycp1',type : 'string'},
		{name : 'zycp2',type : 'string'},
		{name : 'zycp3',type : 'string'},
		{name : 'zczj',type : 'string'},
		{name : 'hbzl',type : 'string'},
		{name : 'wftzgb',type : 'string'},
		{name : 'zgrs',type : 'string'},
		{name : 'zch',type : 'string'},
		{name : 'pzwh',type : 'string'},
		{name : 'pwrq',type : 'string'},
		{name : 'email',type : 'string'},
		{name : 'weburl',type : 'string'},
		{name : 'mobile',type : 'string'},
		{name : 'yjflag',type : 'string'},
		{name : 'tbrxm',type : 'string'},
		{name : 'tbrsfzh',type : 'string'},
		{name : 'tbrlxfs',type : 'string'},
		{name : 'jydz',type : 'string'},
		{name : 'jyyb',type : 'string'},
		{name : 'jydh',type : 'string'},
		{name : 'jfly',type : 'string'},
		{name : 'khyh',type : 'string'},
		{name : 'khzh',type : 'string'},
		
		{name : 'zsbfrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'zszfrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'jjlx',type : 'string'},
		{name : 'jjlxdm',type : 'string'},
		{name : 'tbrzjlx',type : 'string'},
		{name : 'memo',type : 'string'},
		{name : 'memo2',type : 'string'},
		{name : 'wftzgbdm',type : 'string'},
		{name : 'hbzldm',type : 'string'},
		{name : 'pzjgdm',type : 'string'},
		
		{name : 'ywlx',type : 'string'},
		{name : 'name',type : 'string'},
		{name : 'userid',type : 'string'},
		{name : 'username',type : 'string'},
		{name : 'handleName',type : 'string'},
		{name : 'handleDate',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'handleNote',type : 'string'},
		{name : 'imageUrl',type : 'string'},
		
		{name : 'offPzjgmc',type : 'string'},
		{name : 'offPzwh',type : 'string'},
		{name : 'offReason',type : 'string'},	
		{name : 'offNote',type : 'string'},
		
		{name : 'd_flag',type : 'int'}, 
		{name : 'up_Dflag',type : 'int'}, 
		{name : 'up_Aflag',type : 'int'}, 
		{name : 'errorFlag',type : 'string'},
		{name : 'pigeTime',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		
		{name : 'state',type : 'string'}]
	)
});


var btn_search_dfileQuery = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : searchDfileQuery
});

var text_search_dfileQuery = new Ext.form.TextField({
	name : 'textSearchDfileQuery',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchDfileQuery();
			}
		}
	}
});

/*
//# 每页显示行数   
// Page size combo box   
var pagingCombo = new Ext.form.ComboBox({   
    store : new Ext.data.SimpleStore({   
        fields : ['num'],   
        data : [[5], [10], [20], [50], [100]]   
    }),   
    displayField : 'num',   
    typeAhead : false,   
    mode : 'local',   
    triggerAction : 'all',   
    emptyText : '行数',   
    selectOnFocus : false,   
    allowBlank : false,   
    width : 65,   
    listWidth : 65,   
    resizable : false  
});   

pagingCombo.on('select', function(combo, record, index) {   
    setGridLimit(record.data.num);   
});   
function setGridLimit(record) {   
    dsLimit = record;   
    paging.pageSize = record;   
    refreshGrid();   
}   

function refreshGrid() {   
    var create_time = Ext.get('startdate').dom.value;   
    var end_time = Ext.get('enddate').dom.value;   
    ds.load({   
        params : {   
            start : 0,   
            limit : dsLimit
        }   
    });   
} 
  
//把一下语句计入tbar中，既可以实现翻页，，参数需要修改
  ,{id : 'btnSearch', text : '每页显示', tooltip : '每页显示' }, pagingCombo,'--'
*/

var grid_dfileQuery = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_dfileQuery,
	ds : ds_dfileQuery,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'errorFlag',
	viewConfig : {forceFit : true},
	plugins : expander_dfileQuery,
	tbar : [btn_view_dfileQuery,btn_refresh_registerQuery,btn_query_dfileQuery,'->',text_search_dfileQuery,btn_search_dfileQuery],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_dfileQuery,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有记录"
	}),
	listeners : {
		'rowdblclick':function(grid, rowIndex){
			var record = grid_dfileQuery.getSelectionModel().getSelected();
			if(record){
				window_edit_dfileQuery.show();
				dfileQueryEditForm.getForm().loadRecord(record);
			}
		}
	}
});

var dfileQuery_panel = new Ext.Panel({
	title : '问题数据查询',
	iconCls : 'icon-plugin',
	region : 'center',
	border : 'layout',
	frame : true,
	layout:'border',
	defaults: {
	    collapsible: true,
	    split: true
	},
	items: [{
	    region:'center',
	    layout : 'border',
	    items : [grid_dfileQuery]
	}]
});

var p_dfileQuery = {
	id : 'zzDfileQuery-panel',
	border : false,
	layout : 'border',
	items : [dfileQuery_panel]
}
