var DfileQueryAll = Ext.data.Record.create([
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


var arctypeStr5= [['0','全部档案'],['1','新办'],['2','年检'],['3','迁出'],['4','迁入'],['5','变更'],['6','换证'],['7','补证'],['8','注销'],['9','其他'],['10','预赋码']]; 
var arctypeStore5 = new Ext.data.SimpleStore({fields:['arctypeCode','arctypeValue'],data:arctypeStr5});




//点击列表信息，显示图书的扩展属性//
var expander_dfileQueryAll = new Ext.grid.RowExpander({
	tpl : new Ext.Template('<table width="100%"  border="0" cellspacing="6" cellpadding="0"  bgcolor="#DDEEF9" style="margin-top:1px;" >'
			+ '<tr>'
			+ '<td width="" colspan="4">'
			+ '<table width="98%" bgcolor="#ffffff" border="1" cellpadding="0" cellspacing="0" align="center"  bordercolordark="#FFFFFF" bordercolorlight="#6EBBE1" style="margin-top:0px;>'
			+ '<tr height="" valign="middle">'
			+ '  <td width="20%" align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">机构名称：</td><td width="30%"  valign="middle" style="padding-top:5px">{jgmc}<img src="images/temp.gif"></td>'
			+ '  <td width="20%" align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">机构代码：</td><td width="30%"  valign="middle" style="padding-top:5px">{jgdm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">小微企业：</td><td nowrap="nowrap" style="padding-top:5px">{isxw}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">年检日期：</td><td nowrap="nowrap" style="padding-top:5px">{njrq}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">法定代表人：</td><td nowrap="nowrap" style="padding-top:5px">{fddbr}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">是否公开：</td><td nowrap="nowrap" style="padding-top:5px">{gk}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">证件类型：</td><td nowrap="nowrap"  style="padding-top:5px">{zjlx}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">证件号码：</td><td nowrap="nowrap"  style="padding-top:5px">{zjhm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle" >'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">机构类型：</td><td  nowrap="nowrap" style="padding-top:5px">{jglx}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经济行业：</td><td nowrap="nowrap" style="padding-top:5px">{jjhymc} {jjhydm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经营范围：</td><td  colspan=3 style="padding-top:5px">{jyfw}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">企业简介：</td><td  colspan=3 style="padding-top:5px">{qyjj}<img src="images/temp.gif"></td>'
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
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">企业注册类型：</td><td nowrap="nowrap" style="padding-top:5px">{jjlx} {jjlxdm}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">外方国别：</td><td nowrap="nowrap" style="padding-top:5px">{wftzgb} {wftzgbdm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">注册资金：</td><td nowrap="nowrap" style="padding-top:5px">{zczj}(万)<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">货币种类：</td><td nowrap="nowrap" style="padding-top:5px">{hbzl}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">主管部门：</td><td nowrap="nowrap" style="padding-top:5px">{zgmc} {zgdm}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">批准机构：</td><td nowrap="nowrap" style="padding-top:5px">{pzjgmc} {pzjgdm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">注 册 号：</td><td nowrap="nowrap" style="padding-top:5px">{zch}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">联系电话：</td><td nowrap="nowrap" style="padding-top:5px">{dhhm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">机构注册地址：</td><td  colspan=3 style="padding-top:5px">{jgdz}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">行政区划：</td><td nowrap="nowrap" style="padding-top:5px">{xzqhName} {xzqhCode}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">邮政编码：</td><td nowrap="nowrap" style="padding-top:5px">{yzbm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">机构实际地址：</td><td  colspan=3 style="padding-top:5px">{jydz}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">行政区划：</td><td nowrap="nowrap" style="padding-top:5px">{xzqhName2} {xzqhCode2}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">邮政编码：</td><td nowrap="nowrap" style="padding-top:5px">{jyyb}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">电子信箱：</td><td nowrap="nowrap" style="padding-top:5px">{email}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">网&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址：</td><td nowrap="nowrap" style="padding-top:5px">{weburl}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">是否发卡：</td><td nowrap="nowrap" style="padding-top:5px">{fkbz}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">发卡数量：</td><td nowrap="nowrap" style="padding-top:5px">{fksl}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">办证日期：</td><td nowrap="nowrap" style="padding-top:5px">{bzrq}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">作废日期：</td><td nowrap="nowrap" style="padding-top:5px">{zfrq}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经 办 人：</td><td nowrap="nowrap" style="padding-top:5px">{tbrxm}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经办人证件类型：</td><td nowrap="nowrap" style="padding-top:5px">{tbrzjlx}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经办人证件号码：</td><td nowrap="nowrap" style="padding-top:5px">{tbrsfzh}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经办人电话：</td><td nowrap="nowrap" style="padding-top:5px">{tbrlxfs}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">办 理 人：</td><td nowrap="nowrap" style="padding-top:5px">{handleName}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">办理时间：</td><td nowrap="nowrap" style="padding-top:5px">{handleDate}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">审 核 人：</td><td nowrap="nowrap" style="padding-top:5px">{auditName}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">审核时间：</td><td nowrap="nowrap" style="padding-top:5px">{auditDate}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">审核意见：</td><td  colspan=3 style="padding-top:5px">{auditNote}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '</table>'
			+ '</td></tr></table>')
});


function goErrorflag2(ErrorflagValue)
{
   if(ErrorflagValue.toString()!=""){
	   var Errorflags = ErrorflagValue.split(",");
	   var strEsFlag='';
	   for (var i = 0; i < Errorflags.length-1; i++) {
		   var esFlag=Errorflags[i];
		   
		   if(esFlag!=""){
			   switch (esFlag) {
			   case '1' :
				   strEsFlag=strEsFlag+'1 图像不清晰；';
				   break;
			   case '2' :
				   strEsFlag=strEsFlag+'2 图像黑边、倾斜；';
				   break;
			   case '3' :
				   strEsFlag=strEsFlag+'3 图像混扫；';
				   break;
			   case '4' :
				   strEsFlag=strEsFlag+'4 图像残缺；';
				   break;
			   case '5' :
				   strEsFlag=strEsFlag+'5 建档日期错误；';
				   break;
			   case '6' :
				   strEsFlag=strEsFlag+'6 档案分类错误；';
				   break;
			   case '7' :
				   strEsFlag=strEsFlag+'7 申请表标识问题；';
				   break;
			   case '8' :
				   strEsFlag=strEsFlag+'8 批准证书标识问题；';
				   break;
			   case '9' :
				   strEsFlag=strEsFlag+'9 身份证明文件标识问题；';
				   break;
			   case '10' :
				   strEsFlag=strEsFlag+'10 其他文件标示问题；';
				   break;
			   case '11' :
				   strEsFlag=strEsFlag+'11 其他问题；';
				   break;
			   case '12' :
				   strEsFlag=strEsFlag+'12 批准文件不合格；';
				   break;
			   case '13' :
				   strEsFlag=strEsFlag+'13 缺页问题；';
				   break;
			   case '20' :
				   strEsFlag=strEsFlag+'20 批量问题；';
				   break;
			   case '21' :
				   strEsFlag=strEsFlag+'21 多个问题；';
				   break;
			   case '22' :
				   strEsFlag=strEsFlag+'22 年检执照问；';
				   break;
			   default :
				   strEsFlag=strEsFlag+'';
			       break;
			   } 
	   		}else{
	   			strEsFlag='';
			}
	   }
   }else{
	   strEsFlag="";
   }
    return String.format(strEsFlag);
}


//--------------------机构基本信息-------------------------------------------
var dfileQueryAllViewForm = new Ext.FormPanel({
	url : 'updateOrgnew.action',
	labelAlign : 'right',
	labelWidth : 95,
	bodyStyle : 'padding:5px',
	border : false,
	baseCls : 'x-plain',
	waitMsgTarget: true,
	autoHeight : true,
	autoScroll : true,
	items : [{
            layout:'column',
            border:false,
            autoScroll : true,
            baseCls : 'x-plain',
            items:[{
	                columnWidth:.5,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [
	                	{xtype:'textfield',fieldLabel : '流水号',	name : 'orderid',readOnly:true,anchor:'100%'}]
				},{
	                columnWidth:.5,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [
	                	{xtype:'textfield',fieldLabel : '业务类型',name : 'ywlx',allowBlank : false,readOnly:true,anchor:'100%'},
	                		{xtype : 'hidden',name : 'orgid'},
							{xtype : 'hidden',name : 'centerid'},
							{xtype : 'hidden',name : 'state'}
					]
				},{
	                columnWidth:1,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '机构名称',name : 'jgmc',allowBlank : false,readOnly:true,anchor:'100%'}]
				},{
	                columnWidth:.5,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [
	                	{xtype:'textfield',fieldLabel : '机构代码',name : 'jgdm',allowBlank : false,readOnly:true,anchor:'100%'},
	                	{xtype:'textfield',fieldLabel : '证件类型',name : 'zjlx',readOnly:true,anchor:'100%'}
	                ]
				},{
	                columnWidth:.5,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [
                		{xtype:'textfield',fieldLabel : '法定代表',name : 'fddbr',readOnly:true,anchor:'100%'},
                		{xtype:'textfield',fieldLabel : '证件号码',name : 'zjhm',allowBlank : false,readOnly:true,anchor:'100%'}
                	]
				},{
					columnWidth:1,
                	layout: 'form',
                	bodyStyle: 'padding:0px',
                	border:false,
                	defaultType : 'textarea',
                	items: [
                		{xtype:'textfield',fieldLabel : '经营范围',name : 'jyfw',allowBlank : false,readOnly:true,anchor:'100%',height:'50'}
                	]
				},{
					columnWidth:1,
                	layout: 'form',
                	bodyStyle: 'padding:0px',
                	border:false,
                	defaultType : 'textarea',
                	items: [
                		{xtype:'textfield',fieldLabel : '企业简介',name : 'qyjj',readOnly:true,anchor:'100%',height:'50'}
                	]
				},{
	                columnWidth:.5,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [
	                	{xtype:'textfield',fieldLabel : '成立日期',name : 'zcrq',readOnly:true,anchor:'100%'},
	                	{xtype:'textfield',fieldLabel : '企业注册类型',name : 'jjlx',readOnly:true,anchor:'100%'},
	                	{xtype : 'hidden',name : 'jjlxdm'},
	                	{xtype:'textfield',fieldLabel : '证照终止日期',name : 'zszfrq',readOnly:true,anchor:'100%'},
	                	{xtype:'textfield',fieldLabel : '注册资金',name : 'zczj',readOnly:true,anchor:'100%'},
	                	{xtype:'textfield',fieldLabel : '主管部门',name : 'zgmc',readOnly:true,anchor:'100%'},
	                	{xtype : 'hidden',name : 'zgdm'}
	                ]
				},{
	                columnWidth:.5,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [
                		{xtype:'textfield',fieldLabel : '职工人数',name : 'zgrs',readOnly:true,anchor:'100%'},
						{xtype:'textfield',fieldLabel : '证照开始日期',name : 'zsbfrq',readOnly:true,anchor:'100%'},
						{xtype:'textfield',fieldLabel : '投资国别',name : 'wftzgb',readOnly:true,anchor:'100%'},
						{xtype : 'hidden',name : 'wftzgbdm'},
						{xtype:'textfield',fieldLabel : '货币种类',name : 'hbzl',readOnly:true,anchor:'100%'},
						{xtype : 'hidden',name : 'hbzldm'},
						{xtype:'textfield',fieldLabel : '批准机构',name : 'pzjgmc',readOnly:true,anchor:'100%'},
						{xtype : 'hidden',name : 'pzjgdm'}
						/*
						,
						{xtype:'textfield',fieldLabel : '迁入地址',id:'moveoutAddrss_all',name : 'moveoutAddrss',maxLength : 100,readOnly:true,anchor:'100%'},
						{xtype:'textfield',fieldLabel : '迁址原因',id:'moveoutReason_all',name : 'moveoutReason',maxLength : 250,readOnly:true,anchor:'100%'},
						{xtype:'textfield',fieldLabel : '批注注销机构',id:'offPzjgmc_all',name : 'offPzjgmc',maxLength : 100,readOnly:true,anchor:'100%'},
						{xtype:'textfield',fieldLabel : '批准注销文号',id:'offPzwh_all',name : 'offPzwh',maxLength : 50,readOnly:true,anchor:'100%'},
						{xtype:'textfield',fieldLabel : '注销原因',id:'offReason_all',name : 'offReason',maxLength:250,readOnly:true,anchor:'100%'},
						{xtype:'textfield',fieldLabel : '证书回收情况',id:'offNote_all',name : 'offNote',height:80,maxLength:250,anchor:'100%'}*/
                	]
				},{
	                columnWidth:1,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [
	                	{xtype:'textfield',fieldLabel : '注册文号',name : 'zch',readOnly:true,anchor:'100%'},
	                	{xtype:'textfield',fieldLabel : '机构注册地址',name : 'jgdz',readOnly:true,anchor:'100%'}
	                ]
				},{
	                columnWidth:.5,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [
	                	{xtype:'textfield',fieldLabel : '行政区划',name : 'xzqhName',readOnly:true,anchor:'100%'}
					]
				},{
	                columnWidth:.5,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [
	                	{xtype:'textfield',fieldLabel : '邮政编码',name : 'yzbm',readOnly:true,anchor:'100%'}
					]
				},{
	                columnWidth:1,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [
	                	{xtype:'textfield',fieldLabel : '机构实际地址',name : 'jydz',readOnly:true,anchor:'100%'}
	                ]
				},{
	                columnWidth:.5,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [
	                	{xtype:'textfield',fieldLabel : '行政区划',name : 'xzqhName2',readOnly:true,anchor:'100%'}
					]
				},{
	                columnWidth:.5,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [
	                	{xtype:'textfield',fieldLabel : '邮政编码',name : 'jyyb',readOnly:true,anchor:'100%'}
					]
				},{
	                columnWidth:.5,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [
	                	{xtype:'textfield',fieldLabel : '联系电话',name : 'dhhm',readOnly:true,anchor:'100%'},
	                	{xtype:'textfield',fieldLabel : '移动电话',name : 'mobile',readOnly:true,anchor:'100%'},
	                	{xtype:'textfield',fieldLabel : '经办人名称',name : 'tbrxm',readOnly:true,anchor:'100%'},
	                	{xtype:'textfield',fieldLabel : '经办人证件号码',name : 'tbrsfzh',readOnly:true,anchor:'100%'},
	                	{xtype:'textfield',fieldLabel : '经济行业',name : 'jjhymc',readOnly:true,anchor:'100%'},
						{xtype : 'hidden',id:"select_jglxdm_all",name : 'jglxdm'},
						{xtype:'textfield',fieldLabel : '是否公开',name : 'gk',readOnly:true,anchor:'100%'}
	                ]
				},{
	                columnWidth:.5,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [
						{xtype : 'hidden',name : 'xzqhCode'},{xtype : 'hidden',name : 'xzqhCode2'},
						{xtype:'textfield',fieldLabel : '网址',name : 'weburl',readOnly:true,anchor:'100%'},
						{xtype:'textfield',fieldLabel : '电子信箱',name : 'email',readOnly:true,anchor:'100%'},
						{xtype:'textfield',fieldLabel : '经办人证件类型',name : 'tbrzjlx',readOnly:true,anchor:'100%'},
						{xtype:'textfield',fieldLabel : '经办人电话',name : 'tbrlxfs',readOnly:true,anchor:'100%'},
						{id:"select_jjhydm_all",xtype : 'hidden',name : 'jjhydm'},
						{xtype : 'hidden',name : 'd_flag'},
						{xtype:'textfield',fieldLabel : '机构类型',name : 'jglx',readOnly:true,anchor:'100%'}
						/*
						,
						{xtype:'textfield',fieldLabel : '迁入地址',id:'moveoutAddrss_all',name : 'moveoutAddrss',maxLength : 100,readOnly:true,anchor:'100%'},
						{xtype:'textfield',fieldLabel : '迁址原因',id:'moveoutReason_all',name : 'moveoutReason',maxLength : 250,readOnly:true,anchor:'100%'},
						{xtype:'textfield',fieldLabel : '批注注销机构',id:'offPzjgmc_all',name : 'offPzjgmc',maxLength : 100,readOnly:true,anchor:'100%'},
						{xtype:'textfield',fieldLabel : '批准注销文号',id:'offPzwh_all',name : 'offPzwh',maxLength : 50,readOnly:true,anchor:'100%'},
						{xtype:'textfield',fieldLabel : '注销原因',id:'offReason_all',name : 'offReason',maxLength:250,readOnly:true,anchor:'100%'},
						{xtype:'textfield',fieldLabel : '证书回收情况',id:'offNote_all',name : 'offNote',height:80,maxLength:250,anchor:'100%'}*/
                	]
				},{
	                columnWidth:1,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '问题类型',name : 'errorFlag',readOnly:true,disabled : true,anchor:'100%',height:'40'}]
				}]
		}]
});

var sm3347 = new Ext.grid.CheckboxSelectionModel();
//列表显示图书主要信息//
var cm_dfileQueryAll = new Ext.grid.ColumnModel([expander_dfileQueryAll,
    sm3347,
    {header : '原文',width : 20,dataIndex : 'imageUrl', renderer:icon_dam,sortable : false},
    {header : '流水号',width : 60,dataIndex : 'orderid',sortable : true}, 
	{header : '机构代码',width : 40,dataIndex : 'jgdm',	sortable : true}, 
	{header : '机构名称',width : 120,dataIndex : 'jgmc',sortable : true}, 
	{header : '办证机构代码',width : 40,dataIndex : 'bzjgdm',sortable : true}, 
	{header : '建档日期',width : 40,	dataIndex : 'handleDate',renderer: goDateFormat,sortable : true}, 
	{header : '录档日期',width : 40,dataIndex : 'pigeTime',renderer: goDateFormat,sortable : true}, 
	{header : '档案状态',width : 40,dataIndex : 'd_flag',renderer :goDflag,sortable : true},
	{header : '档案类型',width : 30,dataIndex : 'ywlx',sortable : true}, 
	{header : '问题类型',width : 120,dataIndex : 'errorFlag',id : 'errorFlag',renderer : goErrorflag,menuDisabled : true},
	{header : '备注',width : 30,dataIndex : 'memo',sortable : true}
	]
);



var dfileImgAll = new Ext.Panel({
	title   : '原文信息',
    region    : 'center',
    margins   : '3 3 3 0', 
    activeTab : 0,
    html: '<OBJECT classid="clsid:B4E2D33E-D8B2-4956-9F91-1C6BDC87A6D1"  width=100%  height=100% align=center hspace=0 vspace=0 id="scanner991"  name="scanner991" >'
	       +'<param name="ShowCount" value="8">'
	       +'<param name="sModel" value="1">'
	       +'</OBJECT>'
    
});

var  dfileViewAll= new Ext.Panel({
    title       : '基本信息',
    region      : 'west',
    split       : true,
    width       : 530,
    collapsible : true,
    margins     : '3 0 3 3',
    cmargins    : '3 3 3 3',
	autoScroll : true,
	layout: 'fit',
    items : [dfileQueryAllViewForm]
}); 


var window_edit_dfileQueryAll = new Ext.Window({
	title : '数据查看',
	iconCls : 'icon-veiw',
	width : 1000,
	height : 620,
	resizable : true,
	modal : true,
	plain    : true,
	layout   : 'border',
	closeAction : 'hide',
	maximizable:true,
	items : [dfileViewAll,dfileImgAll],
	buttons : [{   
        text: '前一条',   
        handler: function() {
			//前一条
			var grid_ = grid_dfileQueryAll;
            var selModel = grid_.getSelectionModel();
            if(selModel.hasPrevious()){
                selModel.selectPrevious();
         		var record = grid_dfileQueryAll.getSelectionModel().getSelected();
         		if(record){
         			dfileQueryAllViewForm.getForm().loadRecord(record);
         			dfileQueryAllViewForm.getForm().findField('errorFlag').setValue(goErrorflag2(record.data.errorFlag));
         			scanner991.ImageData="";
	    			scanner991.pageType="";
	
		    		Ext.Ajax.request({
						url : 'dfileViewImg.action',
						params : {orgid : record.data.orgid,d_flag:record.data.d_flag},
						success : function(result,request) {//获取返回值
							var resultObject90 = Ext.util.JSON.decode(result.responseText);
							if(resultObject90.imageData!=null && resultObject90.imageData!=""){
								scanner991.OpenProgress(3);  //设置上传的进度条的总进度数
								scanner991.Progress('原文加载中',1);
								scanner991.Progress('原文加载中',2);
			   					scanner991.ImageData=resultObject90.imageData;
								if(scanner991.ImageData!="" && resultObject90.pageTypeStr!=null){
									scanner991.PageType=resultObject90.pageTypeStr;
									scanner991.Progress('原文加载完毕',3);
								}else{
									scanner991.Progress('原文加载失败',3);
			   						alert("原文错误，加载失败，请重新扫描或标识！");
								}
								scanner991.CloseProgress();
							}
						},
						failure : function() {
							alert("图像加载错误");
						}
					});
         		}
             }else{
                 alert("已经到第一条,请翻页");
             }  
        }
    },{   
        text: '下一条',   
        handler: function() {
        	 var grid_ = grid_dfileQueryAll;
             var selModel = grid_.getSelectionModel();
             if(selModel.hasNext()){
                selModel.selectNext();
         		var record = grid_dfileQueryAll.getSelectionModel().getSelected();
         		if(record){
         			dfileQueryAllViewForm.getForm().loadRecord(record);
         			dfileQueryAllViewForm.getForm().findField('errorFlag').setValue(goErrorflag2(record.data.errorFlag));
         			scanner991.ImageData="";
	    			scanner991.pageType="";
	
		    		Ext.Ajax.request({
						url : 'dfileViewImg.action',
						params : {orgid : record.data.orgid,d_flag:record.data.d_flag},
						success : function(result,request) {//获取返回值
							var resultObject90 = Ext.util.JSON.decode(result.responseText);
							if(resultObject90.imageData!=null && resultObject90.imageData!=""){
								scanner991.OpenProgress(3);  //设置上传的进度条的总进度数
								scanner991.Progress('原文加载中',1);
								scanner991.Progress('原文加载中',2);
			   					scanner991.ImageData=resultObject90.imageData;
								if(scanner991.ImageData!="" && resultObject90.pageTypeStr!=null){
									scanner991.PageType=resultObject90.pageTypeStr;
									scanner991.Progress('原文加载完毕',3);
								}else{
									scanner991.Progress('原文加载失败',3);
			   						alert("原文错误，加载失败，请重新扫描或标识！");
								}
								scanner991.CloseProgress();
							}
						},
						failure : function() {
							alert("图像加载错误");
						}
					});
         		}
             }else{
                 alert("已经到最后一条,请翻页");
             }
        }   
    },{  
        text: '退出',   
        handler: function() {   
        	window_edit_dfileQueryAll.hide(); 
        }   
    }],
	listeners : {
		'activate' : function() {  //激活后自动加载数据
			var record = grid_dfileQueryAll.getSelectionModel().getSelected();
        	if(record){
        		scanner991.ImageData="";
    			scanner991.pageType="";
	    		Ext.Ajax.request({
					url : 'dfileViewImg.action',
					params : {orgid : record.data.orgid,d_flag:record.data.d_flag},
					success : function(result,request) {//获取返回值
						var resultObject90 = Ext.util.JSON.decode(result.responseText);
						if(resultObject90.imageData!=null && resultObject90.imageData!=""){
							scanner991.OpenProgress(3);  //设置上传的进度条的总进度数
							scanner991.Progress('原文加载中',1);
							scanner991.Progress('原文加载中',2);
		   					scanner991.ImageData=resultObject90.imageData;
							if(scanner991.ImageData!="" && resultObject90.pageTypeStr!=null){
								scanner991.PageType=resultObject90.pageTypeStr;
								scanner991.Progress('原文加载完毕',3);
							}else{
								scanner991.Progress('原文加载失败',3);
		   						alert("原文错误，加载失败，请重新扫描或标识！");
							}
							scanner991.CloseProgress();
						}
					},
					failure : function() {
						alert("图像加载错误");
					}
				});
        	}					
		}
	}
   
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

var btn_refresh_registerQueryAll = new Ext.Button({
	text : '刷新',
	iconCls : 'icon-refresh',
	handler : function() {
		textSearchDfileQueryAll.value='';
		searchDfileQueryAll();
		//btn_edit_dfileQueryAll.setDisabled(true);
	}
});


var btn_view_dfileQueryAll = new Ext.Button({
	text : '查看',
	iconCls : 'icon-veiw',
	handler : function(){
		var record = grid_dfileQueryAll.getSelectionModel().getSelected();
		if(record){
			window_edit_dfileQueryAll.show();
			dfileQueryAllViewForm.getForm().loadRecord(record);
			dfileQueryAllViewForm.getForm().findField('errorFlag').setValue(goErrorflag2(record.data.errorFlag));
		}
	}
})


var btn_query_dfileQueryAll = new Ext.Button({
	text : '简单查询',
	iconCls : 'icon-chaxun',
	handler : function(){
		window_dfileQueryAll.show();
	}
});

var gaojiQueryAllForm = new Ext.FormPanel({
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
			items : [{fieldLabel : '机构代码',	name : 'jgdm',allowBlank : true,maxLength : 50}]
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
			items : [{fieldLabel : '机构名称',	name : 'jgmc',allowBlank : true,maxLength : 50}]
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
		items : [{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '100%'},
			items :[{
				xtype : 'combo',
				fieldLabel : '办证机构',
				name:'bzjgdm',
				hiddenName : 'bzjgdm',
				valueField : 'bzjgCode',
				displayField : 'bzjgName',
				mode : 'remote',
				store : ds_bzjgdm_all,
				selectOnFocus : true,
				editable : false,
				allowBlank : true,
				readOnly:true,
				maxLength : 25,
				anchor:'100%',
				triggerAction : 'all',
				loadingText : '加载中...'
			}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '100%'},
			items :[{xtype : 'combo',
				fieldLabel : '档案类型',
				id : 'ARCTYPE_QUERY1',
				name : 'ARCTYPE',
				displayField : 'arctypeValue',
				valueField : 'arctypeValue',
				hiddenName : 'ARCTYPE',
				store : arctypeStore5,
				triggerAction : 'all',
				lazyRender:true,
				emptyText:'',
				mode : 'local',
				selectOnFocus : true,
				allowBlank:true,
				editable : false}]
		}]
	}],
	buttonAlign : 'center',
	minButtonWidth : 60,
	buttons : [{
		text:'查询',
		handler : function(){
			if(this.ownerCt.getForm().isValid()){
				ds_dfileQueryAll.proxy = new Ext.data.HttpProxy({url:'findAllDfileGjQuery.action'});
				ds_dfileQueryAll.baseParams.jgmc=gaojiQueryAllForm.getForm().findField('jgmc').getValue();
				ds_dfileQueryAll.baseParams.jgdm=gaojiQueryAllForm.getForm().findField('jgdm').getValue();
				if(gaojiQueryAllForm.getForm().findField('NEWDATE1').getValue()!=""){
					ds_dfileQueryAll.baseParams.snewdate=gaojiQueryAllForm.getForm().findField('NEWDATE1').getValue().format('Y-m-d');
				}
				if(gaojiQueryAllForm.getForm().findField('NEWDATE2').getValue()!="" ){
					ds_dfileQueryAll.baseParams.enewdate=gaojiQueryAllForm.getForm().findField('NEWDATE2').getValue().format('Y-m-d');
				}
				if(gaojiQueryAllForm.getForm().findField('MODIFYDATE1').getValue()!="" ){
					ds_dfileQueryAll.baseParams.smodifydate=gaojiQueryAllForm.getForm().findField('MODIFYDATE1').getValue().format('Y-m-d');
				}
				if(gaojiQueryAllForm.getForm().findField('MODIFYDATE2').getValue()!=""){
					ds_dfileQueryAll.baseParams.emodifydate=gaojiQueryAllForm.getForm().findField('MODIFYDATE2').getValue().format('Y-m-d');
				}
				ds_dfileQueryAll.baseParams.bzjgdm=gaojiQueryAllForm.getForm().findField('bzjgdm').getValue();
				ds_dfileQueryAll.baseParams.arctype=gaojiQueryAllForm.getForm().findField('ARCTYPE').getValue();
				ds_dfileQueryAll.baseParams.dflagConditions='0,1,2';
				ds_dfileQueryAll.baseParams.conditions ='';
				ds_dfileQueryAll.baseParams.username='';
				ds_dfileQueryAll.load({params : {start : 0,limit : useFullPageSize}});	
			}
		}
	},{
		text : '重置',
		handler:function(){
			gaojiQueryAllForm.getForm().reset();
		}
	},{
		text : '关闭',
		handler:function(){
			gaojiQueryAllForm.getForm().reset();
			this.ownerCt.ownerCt.hide();
		}
	}]
});

var window_dfileQueryAll = new Ext.Window({
	title : '简单查询',
	iconCls : 'icon-chaxun',
	width : 400,
	resizable : false,
	autoHeight : true,
	modal : true,
	closeAction : 'hide',
	items : [gaojiQueryAllForm]
});

//------------------------------------------------------------------------------------------------
//组合查询开始
//var tjStoreStr= [['jgdm','机构代码'],['jgmc','机构名称'],['jglx','机构类型'],['jjhymc','经济行业'],['jjlx','经济类型'],['zjhm','证件号码'],['pzjgdm','批准机构代码'],['fddbr','法定代表人'],['bzjgdm','办证机构代码'],['xzqhName','行政区划'],['yzbm','邮政编码'],['bgrq','变更日期'],['wftzgb','外方国别']]; 
var tjStoreStr = [['jgdm','机构代码'],['jgmc','机构名称'],['jglx','机构类型'],['jglxdm','机构类型代码'],['jglxOld','机构类型（老）'],
['jglxdmOld','机构类型代码（老）'],['fddbr','法定代表人'],['zjlx','证件类型'],['zjhm','证件号码'],
['jjhymc','经济行业'],['jjhydm','经济行业代码'],['jjhydmOld','经济行业代码（老）'],['jjhymcOld','经济行业名称（老）'],
['jjlxdm','经济类型代码'],['jjlx','经济类型'],['jjlxOld','经济类型（老）'],['jjlxdmOld','经济类型代码（老）'],
['zcrq','注册日期'],['zgdm','主管机构代码'],['pzjgdm','批准机构代码'],['pzjgmc','批准机构名称'],
['xzqhCode','行政区划代码'],['xzqhName','行政区划名称'],['jgdz','机构地址'],['bzrq','办证日期'],
['zfrq','作废日期'],['bzjgdm','办证机构代码'],['zslsh','证书流水号'],['bgrq','变更日期'],['lry','录入员'],['zgrs','职工人数'],
['lrName','录入员名字'],['lrDate','录入日期'],['njrq','年检日期'],['njqx','年检期限'],['zch','注册号'],['zczj','注册资金'],
['zgmc','主管机构名称'],['pzwh','批准文号'],['mobile','联系电话'],['tbrxm','经办人姓名'],
['tbrzjlx','经办人证件类型'],['tbrsfzh','经办人身份证号'],['tbrlxfs','经办人联系方式'],['zsbfrq','证书颁发日期'],
['zszfrq','证书作废日期'],['ywlx','业务类型'],['auditName','审核人'],['auditDate','审核日期'],
['handleName','办理人'],['handleDate','办理日期']];
var tjStore = new Ext.data.SimpleStore({fields:['tjCode','tjValue'],data:tjStoreStr});

//其他用gxStore1
var gxStoreStr1= [['=','等于(=)'],['<>','不等于(<>)'],['like','包含(like)'],['%-','左包含(%-)'],['-%','右包含(-%)'],['null','为空(null)']]; 
//日期及整数用gxStore2
var gxStoreStr2= [['=','等于(=)'],['>','大于(>)'],['>=','大于等于(>=)'],['<','小于(<)'],['<=','小于等于(<=)'],['<>','不等于(<>)'],['null','为空(null)']]; 
var gxStore = new Ext.data.SimpleStore({fields:['gxCode','gxValue']});

var ljStoreStr= [['null','无'],['and','并且'],['or','或者']]; 
var ljStore = new Ext.data.SimpleStore({fields:['ljCode','ljValue'],data:ljStoreStr});

var pxStoreStr= [['ASC','升序'],['DESC','降序']]; 
var pxStore = new Ext.data.SimpleStore({fields:['pxCode','pxValue'],data:pxStoreStr});

var btn_zuheQuery_all = new Ext.Button({
	text : '查询',
	minWidth : 60,
	disabled:true,
	handler : function(btn){
		if(zuHeQueryForm.getForm().isValid()){
			//var queryPxzd = zuHeQueryForm.getForm().findField('queryPxzd').getValue();
			//var queryPxfs = zuHeQueryForm.getForm().findField('queryPxfs').getValue();
			var queryPxzd = 'orgid';
			var queryPxfs = 'asc';
			var strPx='';
			//需要传递的串
			if(queryPxzd!=''){
				strPx = ""+queryPxzd+" "+queryPxfs;
			}else{
				strPx =" orgid ";
			}
			var strWhere = zuHeQueryForm.getForm().findField('strWhere').getValue();

			ds_dfileQueryAll.proxy = new Ext.data.HttpProxy({url:'findAllDfileZuheQuery.action'});
			ds_dfileQueryAll.baseParams.arctype=zuHeQueryForm.getForm().findField('ARCTYPE').getValue();
			ds_dfileQueryAll.baseParams.strWhere=strWhere;
			ds_dfileQueryAll.baseParams.strPx=strPx;
			ds_dfileQueryAll.baseParams.dflagConditions='0,1,2';
			ds_dfileQueryAll.baseParams.conditions ='';
			ds_dfileQueryAll.baseParams.username='';
			ds_dfileQueryAll.load({params : {start : 0,limit : useFullPageSize}});	
		}
	}
});

var zuHeQueryForm = new Ext.FormPanel({
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
		items : [{//第1行基本
			columnWidth : 1,
			layout : 'form',
			baseCls : 'x-plain',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '100%'},
			items : [{xtype : 'combo',
				fieldLabel : '查询字段',
				id : 'ZUHE_QUERY1',
				name : 'queryTjzd',
				displayField : 'tjValue',
				valueField : 'tjCode',
				hiddenName : 'queryTjzd',
				store : tjStore,
				triggerAction : 'all',
				lazyRender:true,
				emptyText:'',
				mode : 'local',
				selectOnFocus : true,
				allowBlank:true,
				editable : false,
				listeners : {
					'select' : function(combo, record, index) {
						zuHeQueryForm.getForm().findField('queryGxysf').setDisabled(false);
						var arr = ['zcrq','bzrq','zfrq','bgrq','lrDate','njrq','njqx','zczj','zgrs','zsbfrq','zszfrq','handleDate','auditDate'];
						if(arr.toString().indexOf(record.data.tjCode) > -1){
							gxStore.loadData(gxStoreStr2);
						}else{
							gxStore.loadData(gxStoreStr1);
						}
					}
				}
			}]
		}]
	},{
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		items : [{//第2行基本
			columnWidth : 1,
			layout : 'form',
			baseCls : 'x-plain',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '100%'},
			items : [{xtype : 'combo',
				fieldLabel : '关系运算符',
				id : 'ZUHE_QUERY2',
				name : 'queryGxysf',
				displayField : 'gxValue',
				valueField : 'gxCode',
				hiddenName : 'queryGxysf',
				store : gxStore,
				disabled : true,
				triggerAction : 'all',
				lazyRender:true,
				emptyText:'',
				mode : 'local',
				selectOnFocus : true,
				allowBlank:true,
				editable : false,
				listeners : {
					'select' : function(val, field) {
						if(val.getValue()=='null'){
							zuHeQueryForm.getForm().findField('data').setDisabled(true);
						}else{
							zuHeQueryForm.getForm().findField('data').setDisabled(false);
						}
					}
				}
			}]
		}]
		
	},{
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		items : [{//第2行基本
			columnWidth : 1,
			layout : 'form',
			baseCls : 'x-plain',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '100%'},
			items : [{fieldLabel : '查询值',name : 'data',allowBlank : true,maxLength : 50}]
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
			defaults : {anchor : '100%'},
			items :[{xtype : 'combo',
				fieldLabel : '逻辑运算符',
				id : 'ZUHE_QUERY3',
				name : 'queryLjysf',
				displayField : 'ljValue',
				valueField : 'ljCode',
				hiddenName : 'queryLjysf',
				store : ljStore,
				triggerAction : 'all',
				lazyRender:true,
				disabled :true,
				emptyText:'',
				mode : 'local',
				selectOnFocus : true,
				allowBlank:true,
				editable : false}]
		},{//第3行基本
			columnWidth : .5,
			layout : 'form',
			baseCls : 'x-plain',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '100%'},
			items : [{xtype : 'combo',
				fieldLabel : '目标档案',
				id : 'ARCTYPE_QUERY3',
				name : 'ARCTYPE',
				displayField : 'arctypeValue',
				valueField : 'arctypeValue',
				hiddenName : 'ARCTYPE',
				store : arctypeStore5,
				triggerAction : 'all',
				lazyRender:true,
				emptyText:'',
				mode : 'local',
				selectOnFocus : true,
				allowBlank:true,
				editable : false}]
		}]
		
	},{
		layout : 'column',//第4行基本
		border : false,
		baseCls : 'x-plain',
		items : [{
			columnWidth : 1,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textarea',
			defaults : {anchor : '99.2%'},
			items :[{fieldLabel : '查询条件',name : 'strWhere',height:90,allowBlank:false,readOnly:true,editable : false}]
		}]
		
	}
	/*因为排序的ORGID翻页问题，暂时不开放此功能
	 ,{
		layout : 'column',//第5行基本
		border : false,
		baseCls : 'x-plain',
		items : [{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '100%'},
			items :[{xtype : 'combo',
				fieldLabel : '排序字段',
				id : 'ZUHE_QUERY4',
				name : 'queryPxzd',
				displayField : 'tjValue',
				valueField : 'tjCode',
				hiddenName : 'queryPxzd',
				store : tjStore,
				triggerAction : 'all',
				lazyRender:true,
				emptyText:'',
				mode : 'local',
				selectOnFocus : true,
				allowBlank:true,
				editable : false}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '100%'},
			items :[{xtype : 'combo',
				fieldLabel : '排序方式',
				id : 'ZUHE_QUERY5',
				name : 'queryPxfs',
				displayField : 'pxValue',
				valueField : 'pxCode',
				hiddenName : 'queryPxfs',
				store : pxStore,
				triggerAction : 'all',
				lazyRender:true,
				emptyText:'',
				mode : 'local',
				selectOnFocus : true,
				allowBlank:true,
				editable : false}]
		}]	
	}
	*/
	],
	buttonAlign : 'center',
	minButtonWidth : 60,
	buttons : [{
		text : '添加',
		handler:function(){
			var queryTjzd = zuHeQueryForm.getForm().findField('queryTjzd').getValue();
			var queryGxysf = zuHeQueryForm.getForm().findField('queryGxysf').getValue();
			var data = zuHeQueryForm.getForm().findField('data').getValue();
			var queryLjysf = zuHeQueryForm.getForm().findField('queryLjysf').getValue();
			var strWhere = zuHeQueryForm.getForm().findField('strWhere').getValue();
			if(queryTjzd!=""){
				btn_zuheQuery_all.setDisabled(false);
				if(queryLjysf!="" && queryLjysf!=""){
					//zuHeQueryForm.getForm().findField('strWhere').setValue(strWhere+queryLjysf+" "+queryTjzd+" "+queryGxysf+" '"+data+"' ");
					if(queryGxysf=="=" || queryGxysf=="<>"){
						zuHeQueryForm.getForm().findField('strWhere').setValue(strWhere+queryLjysf+" "+queryTjzd+" "+queryGxysf+" '"+data+"' ");
					}else{
						if(queryGxysf=="%-"){
							zuHeQueryForm.getForm().findField('strWhere').setValue(strWhere+queryLjysf+" "+queryTjzd+" like '%"+data+"' ");
						}else if(queryGxysf=="-%"){
							zuHeQueryForm.getForm().findField('strWhere').setValue(strWhere+queryLjysf+" "+queryTjzd+" like '"+data+"%' ");
						}else if(queryGxysf=="like"){
							zuHeQueryForm.getForm().findField('strWhere').setValue(strWhere+queryLjysf+" "+queryTjzd+" like '%"+data+"%' ");
						}else if(queryGxysf=="null"){
							zuHeQueryForm.getForm().findField('strWhere').setValue(strWhere+queryLjysf+" "+queryTjzd+" is null ");
						}else{
							zuHeQueryForm.getForm().findField('strWhere').setValue(strWhere+queryLjysf+" "+queryTjzd+" "+queryGxysf+" '"+data+"' ");
						}
					}
				}else {
					if(queryGxysf=="=" || queryGxysf=="<>"){
						zuHeQueryForm.getForm().findField('strWhere').setValue(queryTjzd+" "+queryGxysf+" '"+data+"' ");
					}else{
						if(queryGxysf=="%-"){
							zuHeQueryForm.getForm().findField('strWhere').setValue(queryTjzd+" like '%"+data+"' ");
						}else if(queryGxysf=="-%"){
							zuHeQueryForm.getForm().findField('strWhere').setValue(queryTjzd+" like '"+data+"%' ");
						}else if(queryGxysf=="like"){
							zuHeQueryForm.getForm().findField('strWhere').setValue(queryTjzd+" like '%"+data+"%' ");
						}else if(queryGxysf=="null"){
							zuHeQueryForm.getForm().findField('strWhere').setValue(queryLjysf+" "+queryTjzd+" is null ");
						}else{
							zuHeQueryForm.getForm().findField('strWhere').setValue(queryLjysf+" "+queryTjzd+" "+queryGxysf+" '"+data+"' ");
						}
					}
					zuHeQueryForm.getForm().findField('queryLjysf').setDisabled(false);
				}
			}else{
				alert("请先选择要添加的条件字段的值！");
			}
			
		}
	},btn_zuheQuery_all,{
		text : '重置',
		handler:function(){
			zuHeQueryForm.getForm().reset();
			zuHeQueryForm.getForm().findField('queryLjysf').setDisabled(true);
			btn_zuheQuery_all.setDisabled(true);
		}
	},{
		text : '关闭',
		handler:function(){
			zuHeQueryForm.getForm().reset();
			this.ownerCt.ownerCt.hide();
		}
	}]
});



var window_dfileQueryZH = new Ext.Window({
	title : '组合查询',
	iconCls : 'icon-search2',
	width : 500,
	resizable : false,
	autoHeight : true,
	modal : true,
	closeAction : 'hide',
	items : [zuHeQueryForm]
});

var btn_query_dfileQueryZH = new Ext.Button({
	text : '组合查询',
	iconCls : 'icon-search2',
	handler : function(){
		window_dfileQueryZH.show();
	}
});
//组合查询结束
//------------------------------------------------------------------------------------------------

var searchDfileQueryAll = function() {
	ds_dfileQueryAll.baseParams.conditions = text_search_dfileQueryAll.getValue();
	ds_dfileQueryAll.baseParams.dflagConditions='0,1,2';
	ds_dfileQueryAll.baseParams.jgmc=null;
	ds_dfileQueryAll.baseParams.jgdm=null;
	ds_dfileQueryAll.baseParams.snewdate=null;
	ds_dfileQueryAll.baseParams.enewdate=null;
	ds_dfileQueryAll.baseParams.smodifydate=null;
	ds_dfileQueryAll.baseParams.emodifydate=null;
	ds_dfileQueryAll.baseParams.arctype=null;
	ds_dfileQueryAll.baseParams.username='';
	ds_dfileQueryAll.load({params : {start : 0,limit : useFullPageSize}});
}

var ds_dfileQueryAll = new Ext.data.Store({
	url : 'findAllDfile.action',
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
		{name : 'qyjj',type : 'string'},
		{name : 'zcrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'zgdm',type : 'string'},
		{name : 'zgmc',type : 'string'},
		{name : 'pzjgmc',type : 'string'},
		{name : 'xzqhCode',type : 'string'},
		{name : 'xzqhName',type : 'string'},
		{name : 'xzqhCode2',type : 'string'},
		{name : 'xzqhName2',type : 'string'},
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
		
		{name : 'isxw',type : 'string'},
		{name : 'fkbz',type : 'string'},
		{name : 'fksl',type : 'int'},
		{name : 'njrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'bzrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'zfrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'jjhymc',type : 'string'},
		{name : 'jjhydm',type : 'string'},
		{name : 'gk',type : 'string'},
		
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
		{name : 'auditName',type : 'string'},
		{name : 'auditDate',type : 'date',convert:function(v){if(v) return v.substring(0,16);}},
		{name : 'auditNote',type : 'string'},
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


var btn_search_dfileQueryAll = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : searchDfileQueryAll
});

var text_search_dfileQueryAll = new Ext.form.TextField({
	id : 'textSearchDfileQueryAllid',
	name : 'textSearchDfileQueryAll',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchDfileQueryAll();
			}
		}
	}
});


var grid_dfileQueryAll = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_dfileQueryAll,
	ds : ds_dfileQueryAll,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'errorFlag',
	viewConfig : {forceFit : true},
	plugins : expander_dfileQueryAll,
	tbar : [btn_view_dfileQueryAll,btn_refresh_registerQueryAll,btn_query_dfileQueryAll,btn_query_dfileQueryZH,'->',text_search_dfileQueryAll,btn_search_dfileQueryAll],
	bbar : new Ext.PagingToolbar({
		pageSize : useFullPageSize,
		store : ds_dfileQueryAll,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有记录"
	}),
	listeners : {
		'rowdblclick':function(grid, rowIndex){
			var record = grid_dfileQueryAll.getSelectionModel().getSelected();
			if(record){
				window_edit_dfileQueryAll.show();
				dfileQueryAllViewForm.getForm().loadRecord(record);
				dfileQueryAllViewForm.getForm().findField('errorFlag').setValue(goErrorflag2(record.data.errorFlag));
			}
		}
	}
});

var zzDfileQueryAll_panel = new Ext.Panel({
	title : '全库查询',
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
	    items : [grid_dfileQueryAll]
	}]
});

var p_zzDfileQueryAll = {
	id : 'zzDfileQueryAll-panel',
	border : false,
	layout : 'border',
	items : [zzDfileQueryAll_panel]
}
