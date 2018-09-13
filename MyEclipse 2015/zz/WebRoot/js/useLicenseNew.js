var ds_hbzl_select = new Ext.data.Store({
	url : 'findAllBySubjectid.action?subjectId=1',
	reader : new Ext.data.JsonReader({
		root : 'root'
	}, [{name : 'categoryId',type : 'int'},
		{name : 'categoryName',type : 'string'},
		{name : 'categoryCode',type : 'string'}
	])
});

var ds_zjlx_select = new Ext.data.Store({
	url : 'findAllBySubjectid.action?subjectId=2',
	reader : new Ext.data.JsonReader({
		root : 'root'
	}, [{name : 'categoryId',type : 'int'},
		{name : 'categoryName',type : 'string'},
		{name : 'categoryCode',type : 'string'}
	])
});


var ds_wftzgb_select = new Ext.data.Store({
	url : 'findAllBySubjectid.action?subjectId=3',
	reader : new Ext.data.JsonReader({
		root : 'root'
	}, [{name : 'categoryId',type : 'int'},
		{name : 'categoryName',type : 'string'},
		{name : 'categoryCode',type : 'string'}
	])
});


var Orgnew = Ext.data.Record.create([
	{name : 'orgid',mapping : 'orgid',type : 'int'}, 
	{name : 'orderid',mapping : 'orderid',type : 'string'}, 
	{name : 'jgzcdz',mapping : 'jgzcdz',type : 'string'}, 
	{name : 'jgmc',mapping : 'jgmc',type : 'string'}, 
	{name : 'jgdm',mapping : 'jgdm',type : 'string'}, 
	{name : 'jglx',mapping : 'jglx',type : 'string'},
	{name : 'fddbr',mapping : 'fddbr',type : 'string'}, 
	{name : 'zjlx',mapping : 'zjlx',type : 'string'}, 
	{name : 'zjhm',mapping : 'zjhm',type : 'string'}, 
	{name : 'jyfw',mapping : 'jyfw',type : 'string'}, 
	{name : 'zcrq',mapping : 'zcrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}}, 
	{name : 'xzqhCode',mapping : 'xzqhCode',type : 'string'},
	{name : 'xzqhName',mapping : 'xzqhName',type : 'string'},
	{name : 'jgdz',mapping : 'jgdz',type : 'string'}, 
	{name : 'yzbm',mapping : 'yzbm',type : 'string'}, 
	{name : 'dhhm',mapping : 'dhhm',type : 'string'}, 
	{name : 'zycp1',mapping : 'zycp1',type : 'string'}, 
	{name : 'zycp2',mapping : 'zycp2',type : 'string'}, 
	{name : 'zycp3',mapping : 'zycp3',type : 'string'}, 
	{name : 'zczj',mapping : 'zczj',type : 'date', convert:function(v){if(v) return v.substring(0,10);}}, 
	{name : 'wftzgb',mapping : 'wftzgb',type : 'string'}, 
	{name : 'wftzgbdm',mapping : 'wftzgbdm',type : 'string'}, 
	{name : 'zgrs',mapping : 'zgrs',type : 'string'}, 
	{name : 'zch',mapping : 'zch',type : 'string'}, 
	{name : 'pzwh',mapping : 'pzwh',type : 'string'},
	{name : 'pzrq',mapping : 'pzrq',type : 'date', convert:function(v){if(v) return v.substring(0,10);}},
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
	{name : 'memo',mapping : 'memo',type : 'string'},
	{name : 'memo2',mapping : 'memo2',type : 'string'},
	
	
	{name : 'jjhymc',mapping : 'jjhymc',type : 'string'},
	{name : 'jjhydm',mapping : 'jjhydm',type : 'string'},
	{name : 'gk',mapping : 'gk',type : 'string'},

	
	{name : 'hbzl',mapping : 'hbzl',type : 'string'},
	{name : 'hbzldm',mapping : 'hbzldm',type : 'string'},
	
	{name : 'moveoutAddrss',mapping : 'moveoutAddrss',type : 'string'},
	{name : 'moveoutReason',mapping : 'moveoutReason',type : 'string'},
	{name : 'offPzjgmc',mapping : 'offPzjgmc',type : 'string'},
	{name : 'offPzwh',mapping : 'offPzwh',type : 'string'},
	{name : 'offReason',mapping : 'offReason',type : 'string'},
	
	{name : 'khyh',mapping : 'khyh',type : 'string'},
	{name : 'khzh',mapping : 'khzh',type : 'string'},
	{name : 'ywlx',mapping : 'ywlx',type : 'string'},
	{name : 'userid',mapping : 'userid',type : 'string'},
	{name : 'username',mapping : 'username',type : 'string'},
	{name : 'auditUsername', mapping: 'auditUsername',type : 'string'},
	{name : 'auditName', mapping: 'auditName',type : 'string'},
	{name : 'auditDate',mapping : 'zsbfrq',type : 'date', convert:function(v){if(v) return v.substring(0,10);}},
	{name : 'auditNote', mapping: 'auditNote',type : 'string'},
	{name : 'pageTypeStr', mapping: 'pageTypeStr',type : 'string'},	
	{name : 'imageUrl', mapping: 'imageUrl',type : 'string'},
	{name : 'state',mapping : 'state',type : 'string'}
	
	
	
]);

var Orgnews = new Ext.data.JsonReader({root:'root'},[
        {name : 'orgid',type : 'int'}, 
        {name : 'docid',type : 'string'}, 
        {name : 'orderid',type : 'string'}, 
		{name : 'jgmc',type : 'string'},
		{name : 'jgdm',type : 'string'},
		{name : 'jglx',type : 'string'},
		
		{name : 'jglxdm',type : 'string'},
		{name : 'jglxOld',type : 'string'},
		{name : 'jglxdmOld',type : 'string'},
		{name : 'jjlxOld',type : 'string'},
		{name : 'jjlxdmOld',type : 'string'},
		{name : 'jjhymcOld',type : 'string'},
		{name : 'jjhydmOld',type : 'string'},
		
		{name : 'fddbr',type : 'string'}, 
		{name : 'zjlx',type : 'string'},
		{name : 'zjhm',type : 'string'}, 
		{name : 'jyfw',type : 'string'},
		{name : 'zcrq',type: 'date', convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'zgdm',type : 'string'},
		{name : 'zgmc',type : 'string'},
		{name : 'pzjgmc',type : 'string'},
		{name : 'pzjgdm',type : 'string'},
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
		{name : 'hbzldm',type : 'string'},
		{name : 'wftzgb',type : 'string'},
		{name : 'wftzgbdm',type : 'string'},
		{name : 'zgrs',type : 'string'},
		{name : 'zch',type : 'string'},
		{name : 'pzwh',type : 'string'},
		{name : 'pwrq',type : 'string'},
		{name : 'email',type : 'string'},
		{name : 'weburl',type : 'string'},
		{name : 'mobile',type : 'string'},
		{name : 'yjflag',type : 'string'},
		{name : 'tbrxm',type : 'string'},
		{name : 'tbrzjlx',type : 'string'},
		{name : 'tbrsfzh',type : 'string'},
		{name : 'tbrlxfs',type : 'string'},
		{name : 'zsbfrq',type: 'date', convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'zszfrq',type: 'date', convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'jjlx',type : 'string'},
		{name : 'jjlxdm',type : 'string'},
		{name : 'memo',type : 'string'},
		{name : 'memo2',type : 'string'},
		{name : 'moveoutAddrss',type : 'string'},
		{name : 'moveoutReason',type : 'string'},
		{name : 'offPzjgmc',type : 'string'},
		{name : 'offPzwh',type : 'string'},
		{name : 'offReason',type : 'string'},
		{name : 'lrDate',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'zbsl',type : 'string'},
		{name : 'fbsl',type : 'string'},
		{name : 'jjhymc',mapping : 'jjhymc',type : 'string'},
		{name : 'jjhydm',mapping : 'jjhydm',type : 'string'},
		{name : 'gk',mapping : 'gk',type : 'string'},
		{name : 'njrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'isxw',type : 'string'},
		{name : 'fkbz',type : 'string'},
		{name : 'fksl',type : 'int'},
		{name : 'bzrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'zfrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'handleName',type : 'string'},
		{name : 'handleDate',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'handleNote',type : 'string'},
		{name : 'fbsl',type : 'int'},
		
		
		{name : 'jydz',type : 'string'},
		{name : 'jyyb',type : 'string'},
		{name : 'jydh',type : 'string'},
		{name : 'jfly',type : 'string'},
		{name : 'khyh',type : 'string'},
		{name : 'khzh',type : 'string'},
		{name : 'name',type : 'string'},
		{name : 'username',type : 'string'},
		{name : 'auditName',type : 'string'},
		{name : 'auditDate',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'auditNote',type : 'string'},
		{name : 'pageTypeStr',type : 'string'},
		{name : 'imageUrl',type : 'string'},
		{name : 'ywlx',type : 'string'},
		{name : 'state',type : 'string'},
		{name : 'imageData',type : 'string'}]
);
 


//------------------------当前日期-----------------------
var myDate = new Date();

var dateFormat = function(v){
	if(v){
		return v.substring(0,10)
	}
	return '未审批';
};

function dateFormatToYMD(strDate)
{
	if(strDate!=null && strDate!=""){
		//var date= new Date(Date.parse(strDate.replace(/-/g,"/"))); //转换成Data();
		//var strYear=date.getFullYear();    //获取完整的年份(4位,1970)
		//var strMonth=date.getMonth()+1;       //获取当前月份(0-11,0代表1月)
		//var strDate=date.getDate();        //获取当前日(1-31
		//return String.format(strYear.toString()+"年"+strMonth.toString()+"月"+strDate.toString()+"日");
		var arr = strDate.substring(0,10).split('-');
		strDate = arr[0]+"年"+arr[1]+"月"+arr[2]+"日";
		return strDate;
	}else{
		return String.format(" ");
	}
}

//------------------------录入后下拉列表显示行政区划----------------------------
var xzqhCode;
var ds_xzqh_select = new Ext.data.Store({
	url : 'findAllXzqh.action',
	reader : new Ext.data.JsonReader({
		root : 'root'
	}, [{name : 'xzqhCode',type : 'string'},
		{name : 'xzqhName',type : 'string'}
	])
});

//-----------------------点击列表信息，显示图书的扩展属性-----------------------
var expander = new Ext.grid.RowExpander({
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
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">注册号：</td><td nowrap="nowrap" style="padding-top:5px">{zch}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">邮政编码：</td><td nowrap="nowrap" style="padding-top:5px">{yzbm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">注册地址：</td><td nowrap="nowrap" style="padding-top:5px">{jgdz}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">行政区划：</td><td nowrap="nowrap" style="padding-top:5px">{xzqhName} {xzqhCode}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">联系电话：</td><td nowrap="nowrap" style="padding-top:5px">{dhhm}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">电子信箱：</td><td nowrap="nowrap" style="padding-top:5px">{email}<img src="images/temp.gif"></td>'
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
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经办人：</td><td nowrap="nowrap" style="padding-top:5px">{tbrxm}<img src="images/temp.gif"></td>'
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


//-----------------------点击列表信息，显示图书的扩展属性-----------------------
var expander201 = new Ext.grid.RowExpander({
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
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">注册号：</td><td nowrap="nowrap" style="padding-top:5px">{zch}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">邮政编码：</td><td nowrap="nowrap" style="padding-top:5px">{yzbm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">注册地址：</td><td nowrap="nowrap" style="padding-top:5px">{jgdz}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">行政区划：</td><td nowrap="nowrap" style="padding-top:5px">{xzqhName} {xzqhCode}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">联系电话：</td><td nowrap="nowrap" style="padding-top:5px">{dhhm}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">电子信箱：</td><td nowrap="nowrap" style="padding-top:5px">{email}<img src="images/temp.gif"></td>'
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
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经办人：</td><td nowrap="nowrap" style="padding-top:5px">{tbrxm}<img src="images/temp.gif"></td>'
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



//------------------------------ 浏览图片窗口 -----------------------------------
var image_window_uln2 = new Ext.Window({   
    id: 'image-window2',   
    title : '原文浏览',   
    width : 800,   
    height : 600,   
    resizable : true,
    maximizable:true,
    closeAction :'hide',   
    layout:'border',   
    items:[{   
        xtype: 'panel',   
        region: 'center',   
        layout:'fit',   
        bodyStyle : 'background-color:#E5E3DF;',   
        frame:false,   
        border:false,
        html: '<OBJECT classid="clsid:B5306E2E-8F98-46CA-9F31-AB326B2613F1"   width=100%  height=100% align=center hspace=0 vspace=0 id="scanner2204"  name="scanner2204">'
 	       +'<param name="ShowCount" value="1">'
 	       +'<param name="sModel" value="1">'
 	       +'</OBJECT>'    
    }],   
    buttons: [{   
	       text: '重载原文',   
	       handler: function() { 
	       	
	       		var resultObject = null;
    			var record = grid_LicenseNew2.getSelectionModel().getSelected();
    			var strOrgid="";
				if(record){
		    		strOrgid=record.data.orgid;
		    		//此处原文加载时候需要优化为以上注销部分form的提交模式
		    		Ext.Ajax.request({
						url : 'orgnewViewImg.action',
						params : {orgid : strOrgid},
						method:'post', 
						//waitTitle: '提示',
					    //waitMsg: '数据正在重新加载中，请稍后',
						success : function(result,request) {//获取返回值
						    //resultObject = eval('('+result.responseText+')');  
		   					var resultObject = Ext.util.JSON.decode(result.responseText);  
		   					scanner2204.ImageData=resultObject.imageData;
		   					scanner2204.pageTypeStr=resultObject.pageTypeStr;
						},
						failure : function() {
							alert("图像加载错误");
						}
					});	
				}
	       }   
   },{   
       text: '取消',   
       handler: function() {   
           image_window_uln2.hide();   
       }   
   }],   
    listeners: {   
    	'activate' : function() {
    		var resultObject = null;
    		var record = grid_LicenseNew2.getSelectionModel().getSelected();
    		var strOrgid="";
        	 //当前ORGID同步
	    	if(record){
	    		strOrgid=record.data.orgid;
	    		//alert(strOrgid);
	    		//此处原文加载时候需要优化为以上注销部分form的提交模式
	    		Ext.Ajax.request({
					url : 'orgnewViewImg.action',
					params : {orgid : strOrgid},
					method:'post', 
					//waitTitle: '提示',
				    //waitMsg: '数据正在重新加载中，请稍后',
					success : function(result,request) {//获取返回值
					    //resultObject = eval('('+result.responseText+')');  
	   					var resultObject = Ext.util.JSON.decode(result.responseText);  
	   					scanner2204.ImageData=resultObject.imageData;
	   					scanner2204.pageTypeStr=resultObject.pageTypeStr;
					},
					failure : function() {
						alert("图像加载错误");
					}
				});	
	    	}
        }   
    }   
});   



//---------------------- 显示浏览原文的窗口 ------------------------------------
function viewPic_uln2(orgName,fileUrl)
{
	image_window_uln2.show(); 
	image_window_uln2.setTitle('原文浏览-[' + orgName + ']');    
	//scanner2200.ImageData=document.getElementById("sImageData2").value;
}

//---------------------- 列表显示原文的标识 ------------------------------------
function icon_uln2(value,p,record){
	if(typeof record=='object'){
		var fileUrl;
		var orgName;
		fileUrl=record.data["imageUrl"];
		orgName=record.data["jgmc"];
		if(fileUrl!=''){
			//alert(fileUrl);
			return String.format('<a style="display:table;width:100%;" onclick=viewPic_uln2("'+orgName+'","'+fileUrl+'")><img src="images/file_ico.gif"></a>',record.data["orgid"]);
		}
	}  
}
//------------------------------ 浏览图片窗口 -----------------------------------
var image_window_uln4 = new Ext.Window({   
    id: 'image-window4',   
    title : '原文浏览',   
    width : 800,   
    height : 600,   
    resizable : true,
    maximizable:true,
    closeAction :'hide',   
    layout:'border',   
    items:[{   
        xtype: 'panel',   
        region: 'center',   
        layout:'fit',   
        bodyStyle : 'background-color:#E5E3DF;',   
        frame:false,   
        border:false,
        html: '<OBJECT classid="clsid:B5306E2E-8F98-46CA-9F31-AB326B2613F1"   width=100%  height=100% align=center hspace=0 vspace=0 id="scanner2201"  name="scanner2201">'
 	       +'<param name="ShowCount" value="1">'
 	       +'<param name="sModel" value="1">'
 	       +'</OBJECT>'    
    }],   
    buttons: [{   
	       text: '重载原文',   
	       handler: function() { 
	       	
	       		var resultObject = null;
    			var record = grid_LicenseNew.getSelectionModel().getSelected();
    			var strOrgid="";
				if(record){
		    		strOrgid=record.data.orgid
		    		//此处原文加载时候需要优化为以上注销部分form的提交模式
		    		Ext.Ajax.request({
						url : 'orgnewViewImg.action',
						params : {orgid : strOrgid},
						method:'post', 
						//waitTitle: '提示',
					    //waitMsg: '数据正在重新加载中，请稍后',
						success : function(result,request) {//获取返回值
						    //resultObject = eval('('+result.responseText+')');  
		   					var resultObject = Ext.util.JSON.decode(result.responseText);  
		   					scanner2201.ImageData=resultObject.imageData;
		   					scanner2201.pageTypeStr=resultObject.pageTypeStr;
						},
						failure : function() {
							alert("图像加载错误");
						}
					});	
				}
	       }   
   },{   
       text: '取消',   
       handler: function() {   
           image_window_uln4.hide();   
       }   
   }],   
    listeners: {   
    	'activate' : function() {
    		var resultObject = null;
    		var record = grid_LicenseNew.getSelectionModel().getSelected();
    		var strOrgid="";
        	 //当前ORGID同步
	    	if(record){
	    		strOrgid=record.data.orgid;
	    		//alert(strOrgid);
	    		//此处原文加载时候需要优化为以上注销部分form的提交模式
	    		Ext.Ajax.request({
					url : 'orgnewViewImg.action',
					params : {orgid : strOrgid},
					method:'post', 
					//waitTitle: '提示',
				    //waitMsg: '数据正在重新加载中，请稍后',
					success : function(result,request) {//获取返回值
					    //resultObject = eval('('+result.responseText+')');  
	   					var resultObject = Ext.util.JSON.decode(result.responseText);  
	   					scanner2201.ImageData=resultObject.imageData;
	   					scanner2201.pageTypeStr=resultObject.pageTypeStr;
					},
					failure : function() {
						alert("图像加载错误");
					}
				});	
	    	}
        }   
    }   
});   



//---------------------- 显示浏览原文的窗口 ------------------------------------
function viewPic_uln4(orgName,fileUrl)
{
	image_window_uln4.show(); 
	image_window_uln4.setTitle('原文浏览-[' + orgName + ']');    
	//scanner2200.ImageData=document.getElementById("sImageData2").value;
}
function icon_uln4(value,p,record){
	if(typeof record=='object'){
		var fileUrl;
		var orgName;
		fileUrl=record.data["imageUrl"];
		orgName=record.data["jgmc"];
		if(fileUrl!=''){
			//alert(fileUrl);
			return String.format('<a style="display:table;width:100%;" onclick=viewPic_uln4("'+orgName+'","'+fileUrl+'")><img src="images/file_ico.gif"></a>',record.data["orgid"]);
		}
	}  
}
var showTableFlag="";

//---------------------- 列表显示申请单状态 ------------------------------------
function goState(value,p,record)
{
   var stateValue;
   stateValue=record.data["state"];
   //btn_add_orgnew.setDisabled(true); //如果有新办数据时候，则新办按钮被屏蔽
   if(typeof stateValue!=''){
	   	switch (stateValue) {
	   	
	   	case '0' :
			return String.format('<font color="DarkBlue"><b>网上办证，申请暂存</b></font>');
		case '1' :
			return String.format('<font color="DarkBlue"><b>网上办证，申请暂存</b></font>');
		case '2' :
			return String.format('<font color="blue"><b>网上办证，等待审批</b></font>');
		case '3' :
			return String.format('<font color="blue"><b>网上办证，等待审批</b></font>');
		case '4' :
			return String.format('<font color="red"><b>网上办证，审批驳回</b></font>');
		case '5' :
			return String.format('<font color="green"><b>审批通过，请打印确认单</b></font>');
	    case '6' :
			return String.format('<font color="green">办理完毕</font>');
	   	/*
	   	case '0' :
			return String.format('<font color="DarkBlue"><b>自助办证，申请暂存</b></font>');
		case '1' :
			return String.format('<font color="DarkBlue"><b>自助办证，申请暂存</b></font>');
		case '2' :
			return String.format('<font color="blue"><b>自助办证，等待办理</b></font>');
		case '3' :
			return String.format('<font color="red"><b>自助办证，等待审批</b></font>');
		case '4' :
			return String.format('<font color="red"><b>自助办证，审批驳回</b></font>');
		case '5' :
			return String.format('<font color="red"><b>自助办证，正在赋码</b></font>');
		
		case '0' :
		   	return String.format('<font color="DarkBlue"><b>申请单暂存中，内容确认无误后，请及时提交</b></font>');
		    break;
	   	case '1' :
		   	return String.format('<font color="black"><b>“申请单已提交，正在审核中，请等待...</b></font>');
		    break;
	   	case '2' :
		   	return String.format('<font color="blue"><b>申请单审批通过，请备齐资料，去现场办理</b></font>');
		    break;
	  	case '3' :
		   	return String.format('<font color="red"><b>申请单被驳回，请查看审查意见，调整后再提交</b></font>');
		    break;
	   	case '4' :
		   	return String.format('<font color="red"><b>正在办理中</b></font>');
		    break;
	   	case '5' :
		   	return String.format('<font color="red"><b>业务办理完毕</b></font>');
		    break;*/
	   	case '100' :
		   	return String.format('<font color="red"><b>状态正常。。。</b></font>');
			break;
	   	default :
			return String.format('<font color="green"><b>审批通过，请打印确认单</b></font>');
	   } 
	}
	//return stateValue
}
				
//---------------------- 列表显示主要数据信息 ----------------------------------
// 列表显示机构的主要信息 yangqi
var sm2 = new Ext.grid.CheckboxSelectionModel();
var cm_orgnew = new Ext.grid.ColumnModel([expander,
	sm2,
	{header : '原文',width : 20,dataIndex : 'imageUrl', renderer:icon_uln4,sortable : false},
	{header : '流水号',width : 55,dataIndex : 'orderid',sortable : true}, 
	{header : '机构名称',width : 115,sortable : true,dataIndex : 'jgmc'},
	{header : '申请状态',width : 195,dataIndex : 'state',renderer : goState,menuDisabled : true}
]);

//---------------------- 列表显示主要数据信息 ----------------------------------
//列表显示机构的主要信息 yangqi
var sm4 = new Ext.grid.CheckboxSelectionModel();
var cm_orgnew4 = new Ext.grid.ColumnModel([expander201,
	sm4,
	{header : '原文',width : 20,dataIndex : 'imageUrl', renderer:icon_uln2,sortable : false},
	{header : '流水号',width : 55,dataIndex : 'orderid',sortable : true}, 
	{header : '机构名称',width : 115,sortable : true,dataIndex : 'jgmc'},
	{header : '申请状态',width : 195,dataIndex : 'state',renderer : goState,menuDisabled : true}
]);


//--------------------隐含图片信息-------------------------------------------
var imgFormNew = new Ext.FormPanel({
		layout : 'form',
		border : false,
		defaultType : 'hidden',
		items : [{xtype : 'hidden',name : 'imageData',id:'sImageData2'},{xtype : 'hidden',name : 'orgid',id:'orgid890'},{textfield : 'hidden',name : 'pageTypeStr',id:'sPageTypeStr2'}]
});

var shangchuanOrgnewForm = new Ext.Panel({
	//url : 'shangchuanOrgnew.action',
	//bodyStyle : 'padding:5px',
	border : false,
	items: [imgFormNew],
	html: '<OBJECT classid="clsid:B5306E2E-8F98-46CA-9F31-AB326B2613F1"   width=100%  height=100% align=center hspace=0 vspace=0 id="scanner2"  name="scanner2" >'
	       +'<param name="ShowCount" value="8">'
	       +'<param name="sModel" value="1">'
	       +'</OBJECT>'
});

var btn_search_pzjg = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchPzjg();
		//btn_search_pzjg.setDisabled(true);
	}
});


var text_search_pzjg = new Ext.form.TextField({
	id : 'textSearchPzjg',
	name : 'textSearchPzjg',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchPzjg();
			}
		},
		'change' : function(field, e) {
			btn_search_pzjg.setDisabled(false);
		}
	}
});


var cm_pzjg = new Ext.grid.ColumnModel([
	{header : '批准机构名称',width : 50,dataIndex : 'pzjgmc',sortable : true}, 
	{header : '批准机构代码',width : 20,dataIndex : 'pzjgdm',sortable : true},
	{header : '备注',width : 30,dataIndex : 'note',sortable : true}
]);


//查询返回结果的数据列
var ds_pzjg = new Ext.data.Store({
	url : 'findAllByConditionPzjg.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'pzjgid',type : 'int'}, 
		{name : 'pzjgmc',type : 'string'},
		{name : 'pzjgdm',type : 'string'},
		{name : 'bzjgdm',type : 'string'},
		{name : 'note',type : 'string'}
	])
});

var searchPzjg = function() {
	ds_pzjg.baseParams.conditions = text_search_pzjg.getValue();
	ds_pzjg.baseParams.username=currentUsername;
	ds_pzjg.baseParams.stateConditions='';
	ds_pzjg.load({params : {start : 0,limit : 20} });
}

var grid_pzjg = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_pzjg,
	ds : ds_pzjg,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入登记批准机构名称：',text_search_pzjg,btn_search_pzjg],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_pzjg,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_pzjgQuery.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			orgnewEditForm.getForm().findField('select_pzjgmc').setValue(selections[0].get('pzjgmc'));
			orgnewEditForm.getForm().findField('select_pzjgdm').setValue(selections[0].get('pzjgdm'));
			orgnewEditForm.getForm().findField('bzjgdm').setValue(selections[0].get('bzjgdm'));
			orgnewEditForm.getForm().findField('select_pzjg').setValue(selections[0].get('pzjgmc')+" "+selections[0].get('pzjgdm'));
		}
	}
});

var window_pzjgQuery = new Ext.Window({
	title : '登记批准机构查询',
	iconCls : 'icon-plugin',
	width :500,
	height:400,
	//plain    : true,
	layout   : 'border',
	resizable : false,
	modal : true,
	resizable : true, 
	maximizable:true,
	closeAction : 'hide',
	items : [grid_pzjg]
});
//这是主管部门名称窗口
var searchZgmc = function() {
	ds_zgmc.baseParams.conditions = text_search_zgmc.getValue();
	ds_zgmc.baseParams.username=currentUsername;
	ds_zgmc.baseParams.stateConditions='';
	ds_zgmc.load({params : {start : 0,limit : 20} });
}

var btn_search_zgmc = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchZgmc();
		//btn_search_pzjg.setDisabled(true);
	}
});

var text_search_zgmc = new Ext.form.TextField({
	id : 'textSearchZgmc',
	name : 'textSearchZgmc',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchZgmc();
			}
		},
		'change' : function(field, e) {
			btn_search_zgmc.setDisabled(false);
		}
	}
});

var cm_zgmc = new Ext.grid.ColumnModel([
	{header : '主管部门名称',width : 50,dataIndex : 'jgmc',sortable : true}, 
	{header : '主管部门代码',width : 20,dataIndex : 'jgdm',sortable : true}
]);

var ds_zgmc = new Ext.data.Store({
	//url : 'findAllByConditionZgbm.action',
	url : 'findAllTjgdm.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
		[
			{name : 'jgdm',type : 'string'},
			//{name : 'zgjgmc',type : 'string'}
			{name : 'jgmc',type : 'string'}
		])
});
var grid_zgmc = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_zgmc,
	ds : ds_zgmc,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入主管部门名称：',text_search_zgmc,btn_search_zgmc],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_zgmc,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_zgmcQuery.hide();
			var selections=grid.getSelectionModel().getSelections();
			orgnewEditForm.getForm().findField('select_zgmc').setValue(selections[0].get('jgmc'));
			orgnewEditForm.getForm().findField('select_zgdm').setValue(selections[0].get('jgdm'));
			orgnewEditForm.getForm().findField('select_zg').setValue(selections[0].get('jgmc')+" "+selections[0].get('jgdm'));
			
		}
	}
});
var window_zgmcQuery = new Ext.Window({
	title : '主管部门名称查询',
	iconCls : 'icon-plugin',
	width :500,
	height:400,
	//plain    : true,
	layout   : 'border',
	resizable : false,
	modal : true,
	resizable : true, 
	maximizable:true,
	closeAction : 'hide',
	items : [grid_zgmc]
});
//这是行政区划的
var searchXzqh = function() {
	ds_xzqh.baseParams.conditions = text_search_xzqh.getValue();
	ds_xzqh.baseParams.username=currentUsername;
	ds_xzqh.baseParams.stateConditions='';
	ds_xzqh.load({params : {start : 0,limit : 20} });
}

var btn_search_xzqh = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchXzqh();
		//btn_search_pzjg.setDisabled(true);
	}
});

var text_search_xzqh = new Ext.form.TextField({
	id : 'textSearchXzqh',
	name : 'textSearchXzqh',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchXzqh();
			}
		},
		'change' : function(field, e) {
			btn_search_xzqh.setDisabled(false);
		}
	}
});

var cm_xzqh = new Ext.grid.ColumnModel([
	{header : '行政区划名称',width : 50,dataIndex : 'xzqhName',sortable : true},
	{header : '行政区划代码',width : 20,dataIndex : 'xzqhCode',sortable : true}
]);

var ds_xzqh = new Ext.data.Store({
	
	url : 'findAllByConditionXzqh.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
		[
			{name : 'xzqhCode',type : 'string'},
			{name : 'xzqhName',type : 'string'},
			{name : 'xzqhNote',type : 'string'}
		])
});
var grid_xzqh = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_xzqh,
	ds : ds_xzqh,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入行政区划名称：',text_search_xzqh,btn_search_xzqh],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_xzqh,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_xzqhQuery.hide();
			var selections=grid.getSelectionModel().getSelections();
			orgnewEditForm.getForm().findField('xzqh_uln').setValue(selections[0].get('xzqhName')+" "+selections[0].get('xzqhCode'));
			
			orgnewEditForm.getForm().findField('xzqh_name').setValue(selections[0].get('xzqhName'));
			orgnewEditForm.getForm().findField('xzqh_code').setValue(selections[0].get('xzqhCode'));
			
			//orgnewEditForm.getForm().findField('_xzqhName').setValue(selections[0].get('xzqhName'));
			//orgnewEditForm.getForm().findField('_xzqhCode').setValue(selections[0].get('xzqhCode'));
		}
	}
});
var window_xzqhQuery = new Ext.Window({
	title : '行政区划名称查询',
	iconCls : 'icon-plugin',
	width :500,
	height:400,
	//plain    : true,
	layout   : 'border',
	resizable : false,
	modal : true,
	resizable : true, 
	maximizable:true,
	closeAction : 'hide',
	items : [grid_xzqh]
});
//这是实际地址对应的行政区划
var searchXzqh2 = function() {
	ds_xzqh2.baseParams.conditions = text_search_xzqh2.getValue();
	ds_xzqh2.baseParams.username=currentUsername;
	ds_xzqh2.baseParams.stateConditions='';
	ds_xzqh2.load({params : {start : 0,limit : 20} });
}

var btn_search_xzqh2 = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchXzqh2();
	}
});

var text_search_xzqh2 = new Ext.form.TextField({
	id : 'textSearchXzqh2',
	name : 'textSearchXzqh2',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchXzqh2();
			}
		},
		'change' : function(field, e) {
			btn_search_xzqh2.setDisabled(false);
		}
	}
});

var cm_xzqh2 = new Ext.grid.ColumnModel([
	{header : '行政区划名称',width : 50,dataIndex : 'xzqhName',sortable : true},
	{header : '行政区划代码',width : 20,dataIndex : 'xzqhCode',sortable : true}
]);

var ds_xzqh2 = new Ext.data.Store({
	
	url : 'findAllByConditionXzqh.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
		[
			{name : 'xzqhCode',type : 'string'},
			{name : 'xzqhName',type : 'string'},
			{name : 'xzqhNote',type : 'string'}
		])
});
var grid_xzqh2 = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_xzqh2,
	ds : ds_xzqh2,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入行政区划名称：',text_search_xzqh2,btn_search_xzqh2],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_xzqh2,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_xzqh2Query.hide();
			var selections=grid.getSelectionModel().getSelections();
			orgnewEditForm.getForm().findField('xzqh_uln2').setValue(selections[0].get('xzqhName')+" "+selections[0].get('xzqhCode'));
			
			orgnewEditForm.getForm().findField('xzqh_name2').setValue(selections[0].get('xzqhName'));
			orgnewEditForm.getForm().findField('xzqh_code2').setValue(selections[0].get('xzqhCode'));
			
			//orgnewEditForm.getForm().findField('_xzqhName2').setValue(selections[0].get('xzqhName'));
			//orgnewEditForm.getForm().findField('_xzqhCode2').setValue(selections[0].get('xzqhCode'));
		}
	}
});
var window_xzqh2Query = new Ext.Window({
	title : '行政区划名称查询',
	iconCls : 'icon-plugin',
	width :500,
	height:400,
	//plain    : true,
	layout   : 'border',
	resizable : false,
	modal : true,
	resizable : true, 
	maximizable:true,
	closeAction : 'hide',
	items : [grid_xzqh2]
});


//行政区划的到此结束
var btn_search_jjlx = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchJjlx();
		//btn_search_jjlx.setDisabled(true);
	}
});


var text_search_jjlx = new Ext.form.TextField({
	id : 'textSearchJjlx',
	name : 'textSearchJjlx',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchJjlx();
			}
		},
		'change' : function(field, e) {
			btn_search_jjlx.setDisabled(false);
		}
	}
});


var cm_jjlx = new Ext.grid.ColumnModel([
    {header : '大类',width : 30,dataIndex : 'pjjlxmc',sortable : true}, 
    {header : '中类',width : 30,dataIndex : 'pjjlxmc2',sortable : true}, 
    {header : '小类',width : 30,dataIndex : 'pjjlxmc3',sortable : true}, 
	{header : '经济类型名称',width : 100,dataIndex : 'jjlxmc',sortable : true}, 
	{header : '经济类型代码',width : 30,dataIndex : 'jjlxdm',sortable : true},
	{header : '备注',width : 30,dataIndex : 'note',sortable : true}
]);


//查询返回结果的数据列
var ds_jjlx = new Ext.data.Store({
	url : 'findAllByConditionJjlx.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'jjlxid',type : 'int'}, 
	    {name : 'pjjlxmc',type : 'string'},
	    {name : 'pjjlxmc2',type : 'string'},
	    {name : 'pjjlxmc3',type : 'string'},
		{name : 'jjlxmc',type : 'string'},
		{name : 'jjlxdm',type : 'string'},
		{name : 'ojjlxmc',type : 'string'},
		{name : 'ojjlxdm',type : 'string'},
		{name : 'note',type : 'string'}
	])
});

var searchJjlx = function() {
	ds_jjlx.baseParams.conditions = text_search_jjlx.getValue();
	ds_jjlx.baseParams.username=currentUsername;
	ds_jjlx.baseParams.stateConditions='';
	ds_jjlx.load({params : {start : 0,limit : 20} });
}

var grid_jjlx = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_jjlx,
	ds : ds_jjlx,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入企业登记注册类型名称：',text_search_jjlx,btn_search_jjlx],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_jjlx,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_jjlxQuery.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			orgnewEditForm.getForm().findField('select_jjlx').setValue(selections[0].get('jjlxmc'));
			orgnewEditForm.getForm().findField('select_jjlxdm').setValue(selections[0].get('jjlxdm'));
			orgnewEditForm.getForm().findField('select_jjlxOld').setValue(selections[0].get('ojjlxmc'));
			orgnewEditForm.getForm().findField('select_jjlxdmOld').setValue(selections[0].get('ojjlxdm'));
			orgnewEditForm.getForm().findField('s_jjlx').setValue(selections[0].get('jjlxmc')+" "+selections[0].get('jjlxdm'));
			if(selections[0].get('jjlxdm')>5000 && selections[0].get('jjlxdm')<8000){
				orgnewEditForm.getForm().findField('wftzgb').allowBlank=false;
				orgnewEditForm.getForm().findField('wftzgbdm').allowBlank=false;
				if(selections[0].get('jjlxdm')>6000 && selections[0].get('jjlxdm')<7000){
					orgnewEditForm.getForm().findField('wftzgb').setValue('港澳台');
					orgnewEditForm.getForm().findField('wftzgbdm').setValue('344');
				}
			}
		}
	}
});


var window_jjlxQuery = new Ext.Window({
	title : '企业登记注册类型查询',
	iconCls : 'icon-plugin',
	width :500,
	height:400,
	//plain    : true,
	layout   : 'border',
	resizable : false,
	modal : true,
	resizable : true, 
	maximizable:true,
	closeAction : 'hide',
	items : [grid_jjlx]
});

//依据代码 查询 名称 函数
var findMcByDm = function(field){
	
	var code = field.getValue();
	if(code != ""){
		Ext.Ajax.request({
			url : 'findJjlxNameByCode.action',
			params : {jjlxdm : code},
			success : function(response) {
				eval("var data = "+response.responseText);
				if(data!="" && data!=null){
					orgnewEditForm.getForm().findField('jjlx').setValue(data.jjlx);
					orgnewEditForm.getForm().findField('ojjlxmc').setValue(data.ojjlxmc);
					orgnewEditForm.getForm().findField('ojjlxdm').setValue(data.ojjlxdm);
				}else{
					orgnewEditForm.getForm().findField('jjlx').setValue("");
				}
				
			},
			failure : function() {
				Ext.Msg.show({
					title : '错误提示',
					msg : '查询时发生错误!',
					buttons : Ext.Msg.OK,
					icon : Ext.Msg.ERROR
				});
			}
		});
	}
	
}
//机构类型窗口

var cm_jglx = new Ext.grid.ColumnModel([
    {header : '一级类型',width : 60,dataIndex : 'pjglxmc',sortable : true}, 
	{header : '二级类型',width : 100,dataIndex : 'jglxmc',sortable : true}, 
	{header : '代码',width : 30,dataIndex : 'jglxdm',sortable : true},
	{header : '备注',width : 50,dataIndex : 'note',sortable : true}
]);
//查询返回结果的数据列
var ds_jglx = new Ext.data.Store({
	url : 'findAllByConditionJglx.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'jglxid',type : 'int'}, 
	    {name : 'pjglxmc',type : 'string'},
	    {name : 'pjglxdm',type : 'string'},
	    {name : 'ojglxmc',type : 'string'},
	    {name : 'ojglxdm',type : 'string'},
		{name : 'jglxmc',type : 'string'},
		{name : 'jglxdm',type : 'string'},
		{name : 'note',type : 'string'}
	])
});
var text_search_jglx = new Ext.form.TextField({
	id : 'textsearchJglx',
	name : 'textsearchJglx',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchJglx();
			}
		},
		'change' : function(field, e) {
			btn_search_jglx.setDisabled(false);
		}
	}
});
var btn_search_jglx = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchJglx();
	}
});
var searchJglx = function() {
	ds_jglx.baseParams.conditions = text_search_jglx.getValue();
	ds_jglx.baseParams.username=currentUsername;
	ds_jglx.baseParams.stateConditions='';
	ds_jglx.load({params : {start : 0,limit : 20} });
}

var grid_jglx = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_jglx,
	ds : ds_jglx,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入企业登记注册类型名称：',text_search_jglx,btn_search_jglx],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_jglx,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_jglx.hide();
			var selections=grid.getSelectionModel().getSelections();
			//alert();
			orgnewEditForm.getForm().findField('select_jg').setValue(selections[0].get('jglxmc')+" "+selections[0].get('jglxdm'));
			orgnewEditForm.getForm().findField('select_jglx').setValue(selections[0].get('jglxmc'));
			orgnewEditForm.getForm().findField('select_jglxdm').setValue(selections[0].get('jglxdm'));
			
			orgnewEditForm.getForm().findField('select_jglxOld').setValue(selections[0].get('ojglxmc'));
			orgnewEditForm.getForm().findField('select_jglxdmOld').setValue(selections[0].get('ojglxdm'));
			
			orgnewEditForm.getForm().findField('select_pjglxmc').setValue(selections[0].get('pjglxmc'));
			orgnewEditForm.getForm().findField('select_pjglxdm').setValue(selections[0].get('pjglxdm'));
			
			if(selections[0].get('pjglxdm')==1){
				orgnewEditForm.getForm().findField('s_jjlx').allowBlank=false;
			}else{
				orgnewEditForm.getForm().findField('s_jjlx').allowBlank=true;
			}
		}
	}
});
var window_jglx = new Ext.Window({
	title : '机构类型查询',
	iconCls : 'icon-plugin',
	width :500,
	height:400,
	//plain    : true,
	layout   : 'border',
	resizable : false, 
	modal : true,
	//resizable : true, 
	maximizable:true,
	closeAction : 'hide',
	items : [grid_jglx]
});
//jglx 结束
//经济行业开始 
var btn_search_hylx = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchHylx();
		//btn_search_jjlx.setDisabled(true);
	}
});


var text_search_hylx = new Ext.form.TextField({
	id : 'textSearchHylx',
	name : 'textSearchHylx',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchHylx();
			}
		},
		'change' : function(field, e) {
			btn_search_hylx.setDisabled(false);
		}
	}
});
var cm_hylx = new Ext.grid.ColumnModel([
	{header : '大类',width : 60,dataIndex : 'hylxmc1',sortable : true}, 
	{header : '中类',width : 60,dataIndex : 'hylxmc2',sortable : true}, 
	{header : '小类',width : 60,dataIndex : 'hylxmc3',sortable : true}, 
    {header : '经济行业名称',width : 60,dataIndex : 'hylxmc',sortable : true},
	{header : '经济行业代码',width : 30,dataIndex : 'hylxdm',sortable : true},
	{header : '备注',width : 60,dataIndex : 'note',menuDisabled : true}
]);


//查询返回结果的数据列
var ds_hylx = new Ext.data.Store({
	url : 'findAllByConditionHylx.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'hylxid',type : 'int'}, 
	    {name : 'hylxmc',type : 'string'},
	    {name : 'hylxdm',type : 'string'},
	    {name : 'hylxmcOld',type : 'string'},
	    {name : 'hylxdmOld',type : 'string'},
		 {name : 'hylxmc1',type : 'string'},
		 {name : 'hylxmc2',type : 'string'},
		 {name : 'hylxmc3',type : 'string'},
		{ name : 'note',type : 'string'}
	])
});

var searchHylx = function() {
	ds_hylx.baseParams.conditions = text_search_hylx.getValue();
	ds_hylx.baseParams.username=currentUsername;
	ds_hylx.baseParams.stateConditions='';
	ds_hylx.load({params : {start : 0,limit : 20} });
}

var grid_hylx = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_hylx,
	ds : ds_hylx,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入经济行业代码名称：',text_search_hylx,btn_search_hylx],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_hylx,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_hylx.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			orgnewEditForm.getForm().findField('select_jjhy').setValue(selections[0].get('hylxmc')+" "+selections[0].get('hylxdm'));
			orgnewEditForm.getForm().findField('select_jjhymc').setValue(selections[0].get('hylxmc'));
			orgnewEditForm.getForm().findField('select_jjhydm').setValue(selections[0].get('hylxdm'));
			orgnewEditForm.getForm().findField('select_jjhymcOld').setValue(selections[0].get('hylxmcOld'));
			orgnewEditForm.getForm().findField('select_jjhydmOld').setValue(selections[0].get('hylxdmOld'));
		}
	}
});
var window_hylx = new Ext.Window({
	title : '经济行业查询',
	iconCls : 'icon-plugin',
	width :500,
	height:400,
	//plain    : true,
	layout   : 'border',
	resizable : false,
	modal : true,
	resizable : true, 
	maximizable:true,
	closeAction : 'hide',
	items : [grid_hylx]
});
//经济行业结束
//--------------------修改新办申请机构信息-------------------------------------------
var orgnewEditForm = new Ext.FormPanel({
	loadMask : {
		msg : '数据加载中...'
	},
	url : 'saveOrgnew.action',
	labelAlign : 'right',
    bodyStyle:'padding:0px',
	labelWidth : 120,
	border : false,
	baseCls : 'x-plain',
	waitMsgTarget: true,
	autoScroll : true,
	items : [{
		layout:'column',
        border:false,
        //autoScroll : true,
        baseCls : 'x-plain',
        bodyStyle:'padding:10px',
		items : [{
			columnWidth : 1,
			layout : 'form',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '99.7%'},
			items : [{fieldLabel : '机构名称',name : 'jgmc',allowBlank : false,maxLength : 100},
				{xtype:'hidden',name: 'docid'},
				{xtype:'hidden',name: 'jgdm'}
			]
		},{
			columnWidth : .5,//.33
			layout : 'form',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '98%'},//98
			items : [{fieldLabel : '法定代表人',name : 'fddbr',allowBlank : false}
			]
		},{
			
			columnWidth : .3,//.34
			layout : 'form',
			border : false,
			allowBlank : false,
			defaultType : 'textfield',
			defaults : {anchor : '100%'},//97
			items :[{
				xtype : 'combo',
				fieldLabel : '身份证件',
				id : 'zjlx_uln',
				name:'zjlx',
				hiddenName : 'zjlx',
				valueField : 'categoryName',
				displayField : 'categoryName',
				mode : 'remote',
				store : ds_zjlx_select,
				selectOnFocus : true,
				editable : false,
				allowBlank : false,
				readOnly:true,
				//onTriggerClick : Ext.emptyFn,
				triggerAction : 'all',
				loadingText : '加载中...',
				listeners : {
					'select' : function(combo, record, index) {
						//this.ownerCt.ownerCt.ownerCt.form.findField('book.categoryName').setValue(record.data.categoryName);
						
					}
				}
			}]
		
		},{
			
			columnWidth : .2,
			layout : 'form',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '100%'},//97
			items :[
				{fieldLabel : '证件号码',name : 'zjhm',allowBlank:false,maxLength : 18,
					confirmTo:'zjlx_uln',vtype:'sfzhao',labelSeparator:'',hideLabel:true
				
			}]
		
		},{
			columnWidth : .95,
			layout : 'form',
			border : false,
			defaultType : 'textarea',
			defaults : {anchor : '99%',height:'50'},//98.5%
			items : [
				{fieldLabel : '经营范围',name : 'jyfw',allowBlank : false,maxLength : 1000,
					
			    	enableKeyEvents: true,
			    	listeners:{
			    		keyup: function(f, e){//计数
				    		var length = 1000-f.getValue().length
				    		if(length>=0){
				    			orgnewEditForm.findById('fw').setText("("+length+")");
				    		}else{
				    			orgnewEditForm.findById('fw').setText("(输入超出范围)");
				    		}
				    	}
			    	}
					
				}
			]
		},{
			columnWidth : .05,
			layout : 'form',
			border : false,
			defaultType : 'label',
			items : [{id:'fw',name:'fw',text:'(1000)'}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '98%'},
			items :[
		        new Ext.form.DateField({  
                id:'zcrq_uln',
                name: 'zcrq',
                format:'Y-m-d',
                maxValue:myDate,  
                maxText:'所选日期应在{0}之前',  
                minValue:'01/01/1949',
                minText:'所选日期应在{0}之后',
                width:150,
                allowBlank : false,
                fieldLabel:'成立日期',
                renderer:dateFormat,
			    altFormats :'m/d/Y|m-d-y|m-d-Y|m/d|m-d|d|Ymd'
		        }) 
		    ]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items : [{fieldLabel : '职工人数(人)',allowBlank : false,name : 'zgrs',value:'0',xtype : 'numberfield',maxLength : 2000000000}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '98%'},
			items : [
			    new Ext.form.DateField({  
                id:'zsbfrq_uln',
                name: 'zsbfrq',
                format:'Y-m-d',
                maxValue:myDate,  
                maxText:'所选日期应在{0}之前',  
                minValue:'01/01/1900',
                minText:'所选日期应在{0}之后',
                width:150, 
                fieldLabel:'证照有效期',
                renderer:dateFormat,
			    altFormats :'m/d/Y|m-d-y|m-d-Y|m/d|m-d|d|Ymd'
		        }) 
			]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items : [
				new Ext.form.DateField({  
			    id:'zszfrq_uln',
			    name: 'zszfrq',
			    format:'Y-m-d',
			    minValue:'01/01/1900',labelSeparator:'',
			    minText:'所选日期应在{0}之后',
			    width:150,  
			    fieldLabel:'至&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
			    renderer:dateFormat,
			    altFormats :'m/d/Y|m-d-y|m-d-Y|m/d|m-d|d|Ymd' 
			    })   
			]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '98%'},
			items : [new Ext.form.TriggerField({
				id:"s_jjlx",
				name:"s_jjlx",
				fieldLabel:"企业登记注册类型",
			 	//valueField : "jjlxdm",
			    //displayField : "jjlxdm",
			    haveShow : false,
		    
				selectOnFocus : true,
			    //readOnly:'true',
			    
			    editable : false,
			    onTriggerClick : function() {
			    	window_jjlxQuery.show();
			    }/*,
			    listeners : {
					'specialkey' : function(field, e) {
						if (e.getKey() == Ext.EventObject.ENTER) {
							findMcByDm(field);
							//findJjlxByDm(field);
						}
					},
					'blur': function(field){
						findMcByDm(field);
						//findJjlxByDm(field);
					}
				}*/
		    }),
				{xtype:'hidden',id:"select_jjlx",name : 'jjlx'},
				{xtype:'hidden',id:"select_jjlxdm",name : 'jjlxdm'},
				{xtype:'hidden',id:"select_jjlxOld",name:'jjlxOld'}, 
				{xtype:'hidden',id:"select_jjlxdmOld",name:'jjlxdmOld'}]
		},{
			columnWidth : .5,//有限责任公司
			layout : 'form',
			border : false,defaults : {anchor : '99%'},
			items:[{
					xtype : 'combo',
					fieldLabel : '外商投资国别',
					id : 'wftzgb_uln',
					//name:'wftz', //接收值的名称
					
					displayField : 'categoryName',//显示值的名称
					//hiddenName : 'wftzgb',//真正提交时此combo的name
					//valueField : 'categoryCode',//真正提交时此combo的value
					mode : 'remote',
					store : ds_wftzgb_select,
					selectOnFocus : true,
					editable : false,
					triggerAction : 'all',
					loadingText : '加载中...',
					listeners : {
						'select' : function(combo, record, index) {
							//alert("名称："+Ext.get("wftzgb_uln").dom.value);  wftzgbdm 
							//alert("代码："+this.getValue());
							orgnewEditForm.getForm().findField('wftzgb').setValue(record.data.categoryName);
							orgnewEditForm.getForm().findField('wftzgbdm').setValue(record.data.categoryCode);
							orgnewEditForm.getForm().findField('wftzgb_uln').setValue(record.data.categoryName+" "+record.data.categoryCode);
						}
					}
				},
				{xtype : 'hidden',name:'wftzgb'}, 
				{xtype : 'hidden',name:'wftzgbdm'}
				
			]
		},{
			columnWidth : 1,//////////////////////////////////
			layout : 'form',
			border : false,
			defaultType : 'hidden',
			defaults : {anchor : '98.5%'},
			items : [
				{fieldLabel : '',name : 'h1'}
			]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			defaults : {anchor : '98%'},
			items : [{fieldLabel : '注册(开办)资金(万)',allowBlank : false,xtype : 'numberfield',decimalPrecision :6,name : 'zczj',value:'0'}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			defaults : {anchor : '99%'},
			items :[{xtype : 'combo',
				fieldLabel : '货币种类',
				id : 'hbzl_uln',
				//name:'hb', //接收值的名称
				allowBlank : false,
				displayField : 'categoryName',//显示值的名称
				//hiddenName : 'hbzl',//真正提交时此combo的name
				//valueField : 'categoryCode',//真正提交时此combo的value
				mode : 'remote',
				store : ds_hbzl_select,
				selectOnFocus : true,
				maxLength : 50,
				editable : false,
				triggerAction : 'all',
				loadingText : '加载中...',
				listeners : {
					'select' : function(combo, record, index) {
						//alert("名称："+Ext.get("hbzl_uln").dom.value);   
						//alert("代码："+this.getValue());
						
						orgnewEditForm.getForm().findField('hbzl').setValue(record.data.categoryName);
						orgnewEditForm.getForm().findField('hbzldm').setValue(record.data.categoryCode);
						orgnewEditForm.getForm().findField('hbzl_uln').setValue(record.data.categoryName+" "+record.data.categoryCode);
					}
				}
			},
			{xtype : 'hidden',name:'hbzldm'}, 
			{xtype : 'hidden',name:'hbzl'}
		]
		},{
			columnWidth : 1,
			layout : 'form',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '99.4%'},
			items :[
				new Ext.form.TriggerField({
					id:"select_zg",
					//name:"zg",
					fieldLabel:"主管部门",
				 	//valueField : "zgdm",
				    //displayField : "zgdm",
				    
				    //readOnly:'true',
				    selectOnFocus : true,
					editable : true,
				    haveShow : false,
				    onTriggerClick : function() {
				    	window_zgmcQuery.show();
				    },
				    enableKeyEvents: true,
			    	listeners:{
			    		keyup: function(f, e){//计数
				    		//console.log(f);
			    			var str = Ext.get("select_zg").dom.value;
			    			if(str==null||str==""){
			    				orgnewEditForm.findById('select_zgmc').setValue(null);
			    				orgnewEditForm.findById('select_zgdm').setValue(null);
			    			}else{
			    				var num = str.indexOf(" ");
				    			if(num == -1){
				    				orgnewEditForm.findById('select_zgmc').setValue(str);
				    				orgnewEditForm.findById('select_zgdm').setValue(null);
				    			}else{
				    				var mc = str.substring(0,num);
				    				orgnewEditForm.findById('select_zgmc').setValue(mc);
				    				
				    				var dm = str.substring(num+1);
				    				orgnewEditForm.findById('select_zgdm').setValue(dm);
				    			}
			    			}
			    		}
			    	}
			    }),
			    {xtype:'hidden',fieldLabel : '主管部门名称',id:"select_zgmc",name : 'zgmc'},
			    {xtype:'hidden',fieldLabel : '主管部门代码',id:"select_zgdm",name : 'zgdm'}
			]
		},{
			columnWidth : 1,//////////////////////////////////
			layout : 'form',
			border : false,
			defaultType : 'hidden',
			items : [
				{fieldLabel : '',name : 'h2'}
			]
		},{
			columnWidth : 1,
			bodyStyle: 'padding:0px',
			layout : 'form',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '99.4%'},
			items :[new Ext.form.TriggerField({
				id:"select_pzjg",
				//name:"pzjg",
				fieldLabel:"登记批准机构",
			 	//valueField : "pzjgdm",
			    //displayField : "pzjgdm",
			    allowBlank : false,
		
				selectOnFocus : true,
			    //readOnly:'true',
			    
			    haveShow : false,
			    editable : true,
			    onTriggerClick : function() {
			    	window_pzjgQuery.show();
			    },
			    enableKeyEvents: true,
		    	listeners:{
		    		keyup: function(f, e){//计数
			    		//console.log(f);
		    			var str = Ext.get("select_pzjg").dom.value;
		    			if(str==null||str==""){
		    				orgnewEditForm.findById('select_pzjgmc').setValue(null);
		    				orgnewEditForm.findById('select_pzjgdm').setValue(null);
		    			}else{
		    				var num = str.indexOf(" ");
			    			if(num == -1){
			    				orgnewEditForm.findById('select_pzjgmc').setValue(str);
			    				orgnewEditForm.findById('select_pzjgdm').setValue(null);
			    			}else{
			    				var mc = str.substring(0,num);
			    				orgnewEditForm.findById('select_pzjgmc').setValue(mc);
			    				
			    				var dm = str.substring(num+1);
			    				orgnewEditForm.findById('select_pzjgdm').setValue(dm);
			    			}
		    			}
		    		}
		    	}
		    }),
		    {xtype:'hidden',fieldLabel : '登记批准机构名称',id:"select_pzjgmc",name : 'pzjgmc'},
		    {xtype:'hidden',fieldLabel : '登记批准机构代码',id:"select_pzjgdm",name : 'pzjgdm'}
		    ]
		},{
			columnWidth : .45,
			layout : 'form',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '98%'},
			items :[{fieldLabel : '批准文号或注册号',name : 'zch',allowBlank : false,maxLength : 30,//vtype:'pzzch',
					enableKeyEvents: true,
			    	listeners:{
			    		keyup: function(f, e){//计数
			    			var l = 18-f.getValue().length;
			    			if(l>=0){
			    				orgnewEditForm.findById('ch').setText("("+l+")");
			    			}else{
			    				orgnewEditForm.findById('ch').setText("(输入超出范围)");
			    			}
				    		
				    	}
			    	}
			}]
		},{
			columnWidth : .05,
			layout : 'form',
			border : false,
			defaultType : 'label',
			items : [{id:'ch',name:'ch',text:"(18)"}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '联系电话',name : 'dhhm',vtype:'dhhmphone',maxLength : 21
			}]
		},{
			columnWidth : 1,
			layout : 'form',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '99.3%'},//jgdz
			items :[{fieldLabel : '机构注册地址',allowBlank : false,name : 'jgdz',maxLength : 100,defaults : {anchor:'100%'}}]
	
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '98%'},
			items :[
				new Ext.form.TriggerField({
					fieldLabel : '注册行政区划',
					id : 'xzqh_uln',
					//name : 'xzqhCode',  //接收值的名称
					//displayField : 'xzqhCode', //显示值的名称
					//valueField : 'xzqhCode',  //真正提交时此combo的value
					//maxLength : 50,
					allowBlank : false,
				
					selectOnFocus : true,
				    readOnly:'true',
				    
				    haveShow : false,
				    editable : false,
				    onTriggerClick : function() {
				    	window_xzqhQuery.show();
				    }
			    }),
			    {xtype:'hidden',fieldLabel : '注册地址行政区划名称',id:"xzqh_name",name : 'xzqhName'},
			    {xtype:'hidden',fieldLabel : '注册地址行政区划代码',id:"xzqh_code",name : 'xzqhCode'}
			]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items : [{fieldLabel : '邮政编码',allowBlank : false,minLength : 6,maxLength : 6,name : 'yzbm'}]
		},{
			columnWidth : 1,
			layout : 'form',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '99.3%'},
			items : [{fieldLabel : '机构实际地址',name : 'jydz',maxLength : 100,defaults : {anchor:'100%'}}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '98%'},
			items :[
				new Ext.form.TriggerField({
					fieldLabel : '实际行政区划',
					id : 'xzqh_uln2',
					//name : 'xzqhCode2',  //接收值的名称
					//displayField : 'xzqhCode2', //显示值的名称
					//valueField : 'xzqhCode2',  //真正提交时此combo的value
					selectOnFocus : true,
				    readOnly:'true',
				    
				    haveShow : false,
				    editable : false,
				    onTriggerClick : function() {
				    	window_xzqh2Query.show();
				    	
				    }
			    }),
			    {xtype:'hidden',fieldLabel : '行政区划名称',id:"xzqh_name2",name : 'xzqhName2'},
				{xtype:'hidden',fieldLabel : '行政区划代码',id:"xzqh_code2",name : 'xzqhCode2'}
			]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items : [{fieldLabel : '邮政编码',minLength : 6,maxLength : 6,name : 'jyyb'}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			defaultType : 'textfield',
			
			items :[{anchor : '98%',fieldLabel : '网址',vtype:'url',vtypeText:'不是有效的网址',name : 'weburl',maxLength : 50
			}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			defaultType : 'textfield',
			items :[{anchor : '99%',fieldLabel : '电子邮箱',name : 'email',vtype:'email',vtypeText:'不是有效的邮箱地址',maxLength : 40
			}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '98%'},
			items :[{fieldLabel : '经办人',name : 'tbrxm',allowBlank : false,maxLength : 25
			
			}]
		},{
			columnWidth : .3,//30
			layout : 'form',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '100%'},
			items :[{	xtype : 'combo',
				fieldLabel : '身份证件',
				id : 'zjlx2_uln',
				//labelSeparator:'',hideLabel:true,
				name:'tbrzjlx',
				hiddenName : 'tbrzjlx',
				valueField : 'categoryName',
				displayField : 'categoryName',
				mode : 'remote',
				store : ds_zjlx_select,
				selectOnFocus : true,
				maxLength : 25,
				editable : false,
				allowBlank : false,
				triggerAction : 'all',
				loadingText : '加载中...'/*,
				listeners : {
					'select' : function(combo, record, index) {
						//this.ownerCt.ownerCt.ownerCt.form.findField('book.categoryName').setValue(record.data.categoryName);
					}
				}*/
			},
		    {xtype : 'hidden',name:'orgid'},
		    {xtype : 'hidden',name:'orderid',id:'orderid'},
			{xtype : 'hidden',name:'imageUrl'}]
		},{
			columnWidth : .2,
			layout : 'form',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '证件号码',name : 'tbrsfzh',allowBlank : false,maxLength : 18,confirmTo:'zjlx2_uln',vtype:'sfzhao',
		    	labelSeparator:'',hideLabel:true,
		    	listeners : {
					/*'blur' : function(f) {
						var o = orgnewEditForm.getForm().findField('memo').getValue();
						if(o == '居民身份证'){
							var flag = isIdCardNo(f.getValue());
							if(flag != true){
								f.setValue('');
								orgnewEditForm.findById('zh').setText("(0)");
							}
						}
					},
					keyup: function(f, e){//计数
		    			orgnewEditForm.findById('zh').setText("("+f.getValue().length+")");
			    	}*/
				}
			},
	    
		{xtype : 'hidden',name : 'lastdate',value :myDate.format('Y-m-d')}, 
		{xtype : 'hidden',name : 'xgr',value:currentJgdm},
		{xtype : 'hidden',name : 'lry',value:currentJgdm},
		{xtype : 'hidden',name : 'username'},
		{xtype : 'hidden',name : 'userid'},
		{xtype : 'hidden',name : 'bzjgdm'},
		{xtype : 'hidden',name : 'zbsl'},
		{xtype : 'hidden',name : 'fbsl'},
		{xtype : 'hidden',name : 'scbzrq'},
		{xtype : 'hidden',name : 'strNjqx',value:sysNjqxDate},
		{xtype : 'hidden',name : 'newYwlx'},
		{xtype : 'hidden',name : 'newState',value:0}]
		},{
			columnWidth : .5,//20
			layout : 'form',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '98%'},
			items :[{fieldLabel : '经办人电话',vtype:'dhhmphone',allowBlank : false,name : 'tbrlxfs',maxLength : 25
			}]
		},{
			columnWidth : .5,//20
			layout : 'form',
			border : false,
			//defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[new Ext.form.DateField({  
                id:'rq',
                name: 'rq',
                format:'Y-m-d',
                maxValue:myDate,
                value: myDate,
                maxText:'所选日期应在{0}之前',  
                minValue:'01/01/1900',
                minText:'所选日期应在{0}之后',
                width:150, 
                fieldLabel:'填表日期',
                renderer:dateFormat,
			    altFormats :'m/d/Y|m-d-y|m-d-Y|m/d|m-d|d|Ymd'
		        }) 
		    ]
		},{
			columnWidth : .5,//20
			layout : 'form',
			border : false,
			//defaultType : 'textfield',
			defaults : {anchor : '98%'},bodyStyle:'padding-top:3px',
			items :[new Ext.form.TriggerField({
						id:"select_jjhy",
						name:"jjhy",
						fieldLabel:"经济行业",
					 	//valueField : "jjhydm",
					    //displayField : "jjhydm",
					    maxLength : 50,
					    allowBlank : false,
					    haveShow : false,
					    //labelSeparator:'',
					    editable : false,
					    readOnly:true,
					    onTriggerClick : function() {
					    	window_hylx.show();
					    }
					}),
				{xtype : 'hidden',id:"select_jjhymc",name : 'jjhymc'},
				{xtype : 'hidden',id:"select_jjhydm",name : 'jjhydm'},
				{xtype : 'hidden',id:"select_jjhymcOld",name : 'jjhymcOld'},
				{xtype : 'hidden',id:"select_jjhydmOld",name : 'jjhydmOld'},
				{xtype : 'hidden',id:"select_pjglxmc",name : 'pjglxmc'},
				{xtype : 'hidden',id:"select_pjglxdm",name : 'pjglxdm'}
			]
		},{
			columnWidth : .5,//20
			layout : 'form',
			border : false,
			//defaultType : 'textfield',
			defaults : {anchor : '99%'},bodyStyle:'padding-top:3px',
			items :[new Ext.form.TriggerField({
						id:"select_jg",
						name:"jg",
						fieldLabel:"机构类型",
						anchor:'97%',
					 	//valueField : "jglxdm",
					    //displayField : "jglxdm",
					    //labelSeparator:'',
					    allowBlank : false,
					    haveShow : false,
					    editable : false,
					    readOnly : true,
					    onTriggerClick : function() {
					    	window_jglx.show();
					    }
					}),
				{xtype : 'hidden',id:"select_jglx",name : 'jglx'},
				{xtype : 'hidden',id:"select_jglxdm",name : 'jglxdm'},
				{xtype : 'hidden',id:"select_jglxOld",name : 'jglxOld'},
				{xtype : 'hidden',id:"select_jglxdmOld",name : 'jglxdmOld'}
			]
		},{
			
			columnWidth : 1,
			layout : 'form',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '99.3%'},
			items :[{fieldLabel : '备注',name : 'memo'}]
		
		}]
	}],
	buttonAlign : 'center',
	minButtonWidth : 60,
	buttons : [{
		text : '保存',
		id:'modify_bc',
		name:'modify_bc',
		handler : function(btn){
			if (orgnewEditForm.getForm().isValid()) {
				btn.disable();
				orgnewEditForm.getForm().submit({
					waitTitle : '请稍候',
					waitMsg : '正在保存数据,请稍候...',
					params : {strNjqx:sysNjqxDate},
					success : function(form,action) {
						orgnewEditForm.getForm().findField('orgid').setValue(action.result.orgid);
						Ext.Msg.show({
							title : '提示',
							//action.result.success
							msg : '[' + form.findField('jgmc').getValue() + ']保存成功!<br><br> 下一步“打印申请单”!',
							buttons : Ext.Msg.OK,
							fn : function(){
								btn.enable();
								var tab1=Ext.getCmp("centerPanel");
								tab1.setActiveTab("printTab");		
							},
							icon : Ext.Msg.INFO
						});
					},
					failure : function(form, action) {
						Ext.Msg.show({
							title : '提示',
							msg : '数据保存失败',
							buttons : Ext.Msg.OK,
							fn : function() {btn.enable();},
							icon : Ext.Msg.ERROR
						});
					}
				});
			}
		}
	},{
		text : '重置',
		id:'modify_cz',
		name:'modify_cz',
		handler :function() {
		
			orgnewEditForm.getForm().reader = Orgnews;
			orgnewEditForm.getForm().load({
			    //url: 'findUsernameOrgnew.action?username='+currentUsername, //请求控制器获取数据
			    url: 'findConditionsOrgnew.action',
			    method: 'POST', //为"POST",则上面的url不会显示在浏览器的地址栏中
			    params:{
			    	//userid: currentUserid,
			    	jgdm: currentJgdm
			    },
			    waitTitle: '提示',
			    waitMsg: '数据正在加载中，请稍后',
			    success:function(form,action) {//获取返回值
			    	
			    	if(action.result.data.state=='2'||action.result.data.state=='3'||action.result.data.state=='5'||action.result.data.state=='6'){
			    		Ext.Msg.show({
							title : '提示',
							msg : '业务正在受理中！',
							buttons : Ext.Msg.OK,
							fn: function(){
								orgnewEditForm.getForm().reset();
							},
							icon : Ext.Msg.INFO
						});
			    	}else{
			    		//text_search_editForm.setValue('');
	   					
	   					var name = orgnewEditForm.getForm().findField("jjlx").getValue();
	   					var code = orgnewEditForm.getForm().findField("jjlxdm").getValue();
	   					if(name != ""){
	   						orgnewEditForm.getForm().findField("s_jjlx").setValue(name+" "+code);
	   					}else{
	   						orgnewEditForm.getForm().findField("s_jjlx").setValue(code);
	   					}
	   					
	   					name = orgnewEditForm.getForm().findField("wftzgb").getValue();
	   					code = orgnewEditForm.getForm().findField("wftzgbdm").getValue();
	   					if(name != ""){
	   						orgnewEditForm.getForm().findField("wftzgb_uln").setValue(name+" "+code);
	   					}else{
	   						orgnewEditForm.getForm().findField("wftzgb_uln").setValue(code);
	   					}
	   					
	   					name = orgnewEditForm.getForm().findField("hbzl").getValue();
	   					code = orgnewEditForm.getForm().findField("hbzldm").getValue();
	   					if(name != ""){
	   						orgnewEditForm.getForm().findField("hbzl_uln").setValue(name+" "+code);
	   					}else{
	   						orgnewEditForm.getForm().findField("hbzl_uln").setValue(code);
	   					}
	   					
	   					name = orgnewEditForm.getForm().findField("zgmc").getValue();
	   					code = orgnewEditForm.getForm().findField("zgdm").getValue();
	   					if(name != ""){
	   						orgnewEditForm.getForm().findField("select_zg").setValue(name+" "+code);
	   					}else{
	   						orgnewEditForm.getForm().findField("select_zg").setValue(code);
	   					}
	   					
	   					name = orgnewEditForm.getForm().findField("pzjgmc").getValue();
	   					code = orgnewEditForm.getForm().findField("pzjgdm").getValue();
	   					if(name != ""){
	   						orgnewEditForm.getForm().findField("select_pzjg").setValue(name+" "+code);
	   					}else{
	   						orgnewEditForm.getForm().findField("select_pzjg").setValue(code);
	   					}
	   					
	   					name = orgnewEditForm.getForm().findField("xzqhName").getValue();
	   					code = orgnewEditForm.getForm().findField("xzqhCode").getValue();
	   					if(name != ""){
	   						orgnewEditForm.getForm().findField("xzqh_uln").setValue(name+" "+code);
	   					}else{
	   						orgnewEditForm.getForm().findField("xzqh_uln").setValue(code);
	   					}
	   					
	   					name = orgnewEditForm.getForm().findField("xzqhName2").getValue();
	   					code = orgnewEditForm.getForm().findField("xzqhCode2").getValue();
	   					if(name != ""){
	   						orgnewEditForm.getForm().findField("xzqh_uln2").setValue(name+" "+code);
						}else{
							orgnewEditForm.getForm().findField("xzqh_uln2").setValue(code);
						}
						
						name = orgnewEditForm.getForm().findField("select_jglx").getValue();
	   					code = orgnewEditForm.getForm().findField("select_jglxdm").getValue();
	   					if(name != ""){
	   						orgnewEditForm.getForm().findField("select_jg").setValue(name+" "+code);
						}else{
							orgnewEditForm.getForm().findField("select_jg").setValue(code);
						}
						
						name = orgnewEditForm.getForm().findField("select_jjhymc").getValue();
	   					code = orgnewEditForm.getForm().findField("select_jjhydm").getValue();
	   					if(name != ""){
	   						orgnewEditForm.getForm().findField("select_jjhy").setValue(name+" "+code);
						}else{
							orgnewEditForm.getForm().findField("select_jjhy").setValue(code);
						}
						
						orgnewEditForm.getForm().findField("bzjgdm").setValue(currentBzjgdm);
						
			    	}
				},
				failure : function(form,action) {
					alert("未查询到机构信息！");
					window.open("index.jsp","_self","",false);
				}
			});
			//Ext.getCmp("zrcq_edit").setValue(Ext.get("zcrqid").dom.value); 
		}
	}/*,{
		text : '识别',
		id:'modify_cz',
		name:'modify_cz',
		handler : function(){
	 		var ocrStr="[{id:'orgid',value:''},{id:'jgmc',value:'北京东方神启文化有限公司'},{id:'jgdm',value:'234533323'},	{id:'fddbr',value:'郭东方'},	{id:'zjlx',value:'居民身份证'},{id:'zjhm',value:'101108195409091212'},{id:'jyfw',value:'在法律范围内，许可经营项目'},{id:'zcrq',value:'20110727'},{id:'zczj',value:'10'},	{id:'zch',value:'110106014104570'},{id:'jglx',value:'有限责任公司'},{id:'jgdz',value:'北京市朝阳区神舟大厦109室'},{id:'pzjgmc',value:'北京市工商局朝阳分局'},{id:'pzjgdm',value:'110000021'},{id:'jjlx',value:'有限责任公司'},{id:'zsbfrq',value:'2012-11-07'},{id:'zszfrq',value:'2032-11-06'},{id:'wftzgb',value:'中国'},{id:'hbzl',value:'人民币'},{id:'jydz',value:'北京市朝阳区神舟大厦109室'},{id:'zgmc',value:''},{id:'zgdm',value:''},{id:'dhhm',value:'010-62528899'},{id:'mobile',value:'13810101225'},{id:'jjhymc',value:'文化策划'},{id:'jjhydm',value:'0102'},{id:'zgrs',value:'100'},{id:'xzqhCode',value:'100000220'},{id:'xzqhName',value:'北京市海淀区'},{id:'yzbm',value:'100098'},{id:'weburl',value:'www.sina.com'},{id:'email',value:'nenuo@sina.com'},{id:'tbrxm',value:'郭齐平'},{id:'tbrsfzh',value:'410325198204126593'},{id:'memo',value:'居民身份证'},{id:'tbrlxfs',value:'13651031561'},{id:'gk',value:'是'}]";
			if(ocrStr!="" || ocrStr!=null){
				var respText = Ext.util.JSON.decode(ocrStr); 
				orgnewEditForm.getForm().setValues(respText); 
			}else{
				alert("请扫描或导入需识别的图片！");
			}
		}
	}*/]
});



var ds_user_select = new Ext.data.Store({
	url : 'findUserByExample.action',
	reader : new Ext.data.JsonReader({
		root : 'root'
	}, [{name : 'userId',type : 'int'}, 
		{name : 'emplName',type : 'string'}
	])
})





//---------------------- 定义工具栏按钮事件 ------------------------------------------------------
var window_edit_orgnew = new Ext.Window({
	title : '新办申请--信息修改',
	width : 800,
	resizable : true,
	autoHeight : true,
	autoScroll : true, 
	modal : true,
	closeAction : 'hide',
	items : [orgnewEditForm]
	
});



var btn_return_orgnew = new Ext.Button({
	text : '提交申请',
	iconCls : 'icon-save',
	disabled:true,
	handler : function(){
		var record = grid_LicenseNew.getSelectionModel().getSelected();
		if(record){
			var orgid = record.data.orgid;
			
			Ext.Ajax.request({
				url: 'returnOrgnew.action',
				params: { orgid: orgid},
   				success: function(result,response){
   					eval("var data= "+result.responseText);
   					if(!data.success){
   						alert("请上传原文后提交");
   					}else{
   						Ext.Msg.show({
							title : '提示',
							msg : '申请单提交成功<br><br>&nbsp;&nbsp;本次业务办理完毕，请到信息查询功能中查询业务处理状态!',
							buttons : Ext.Msg.OK,
							icon : Ext.Msg.INFO,
							fn : function(){
								record.set('state','1');
								Ext.Ajax.request({
									url : 'logout.action',
									success: function(){
										//window.open("index.jsp","_self","",false);
										ds_orgnew4.removeAll();
										ds_orgnew.removeAll();
										Ext.getCmp('content-panel').layout.setActiveItem('useLicenseAudit-panel');
										searchOrgnewAudit();
									},
									failure : function() {
										Ext.Msg.show({
											title : '错误提示',
											msg : '退出系统失败!',
											icon : Ext.Msg.ERROR,
											buttons : Ext.Msg.OK
										});
									}
								});
		   					}
						});
   					}
   					
   				},
   				failure: function(){
   					Ext.Msg.show({
						title : '提示',
						msg : '申请单提交失败！!',
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.ERROR
					});
   				}
   				
			});
			
		}
	}
});



var btn_scanImage = new Ext.Button({
	text : '扫描',
	iconCls : 'icon-scan',
	handler : function() {
		window.open("NKOScanProj.jsp")
	}
});


var btn_edit_orgnew = new Ext.Button({
	text : '编辑',
	iconCls : 'icon-edit',
	disabled:true,
	handler : function(){
		var record = grid_LicenseNew.getSelectionModel().getSelected();
		if(record){
			window_edit_orgnew.show();
			orgnewEditForm.getForm().loadRecord(record);
		}
	}
})

var btn_del_orgnew = new Ext.Button({
	text : '删除',
	iconCls : 'icon-del',
	disabled:true,
	handler : function() {
		var record = grid_LicenseNew.getSelectionModel().getSelected();
		if (record) {
			Ext.Msg.confirm('确认删除', '你确定删除该件工单?', function(btn) {
				if (btn == 'yes') {
					Ext.Ajax.request({
						url : 'deleteOrgnew.action',
						params : {orgid : record.data.orgid},
						success : function() {grid_LicenseNew.getStore().remove(record);},
						failure : function() {
							Ext.Msg.show({
								title : '错误提示',
								msg : '删除时发生错误!',
								buttons : Ext.Msg.OK,
								icon : Ext.Msg.ERROR
							});
						}
					});
				}
			});
		}
	}
});

var btn_print_orgnew = new Ext.Button({
	text : '打印',
	iconCls : 'icon-print',
	disabled:true,
	handler : function(){
		var record = grid_LicenseNew.getSelectionModel().getSelected();
		if(record){
			print_window.show();
			orgnewPrintForm.getForm().loadRecord(record);
		}
	}
})

//---------------------- 打印申请登记表 ---------------------------
function msgShow_uln()
{
	Ext.Msg.confirm('操作提示','“申请表”打印完毕吗?',function(btn){
		if('yes' == btn){
			var tab=Ext.getCmp("centerPanel");
			tab.setActiveTab("shangchuanTab");
		}
		btn_print_orgnew2.setDisabled(false);	
	});	
}
function printSqdStr(resultObject){//申请单模版
	
	if(resultObject!=null){
		var tableStr = '<html><head><title>组织机构代码网上办证系统--申请单打印</title></head>';
		tableStr = tableStr + '<body onunload="window.opener.msgShow();"><center>';
		tableStr = tableStr + '	<table border= "0" width=770 cellpadding= "0" cellspacing= "0"  bgcolor="#FFFFFF">';
		tableStr = tableStr + '		<style type="text/css">@media print{INPUT {display:none}} .head1{font-size: 18pt;font-family: "黑体";} .txt1 {font-size: 11.5pt} .txt2 {font-size: 14pt}  .title1 {font-size: 11.5pt;font-family: "黑体"; } .title2 {font-size: 11.5pt;font-family: "宋体"; }	.fangge {font-size: 16pt;color: #FF0000;line-height:1em;} body {margin-left: 0px;margin-top: 0px;margin-right: 0px;margin-bottom: 0px;background-color: #CCCCCC;}</style>';
		tableStr = tableStr + '		<tr><td align="center" valign="middle"><br>';
		tableStr = tableStr + '	<center>';				
		tableStr = tableStr + '	<table  id="table5" style="width:720;border-collapse:collapse; " cellpadding= "0" cellspacing= "0"  border="0" >';
		tableStr = tableStr + '		<tr><td width="200"><table width="200" style="width:200;border-collapse:collapse; " cellpadding= "0" cellspacing= "0" border= "0"><tr><td width="200"><input type="button" name="btnPrint" value="打　　印"  onclick="reportPrint()"/></td></tr></table></td>';			
		tableStr = tableStr + '			<td width="">&nbsp;</td><td width="194" align="right">';
		tableStr = tableStr + '				<table id="table3" style="width:184;border-collapse:collapse;" align="right" cellpadding= "0" cellspacing= "0" border= "1" bordercolor= "#3366FF">';
		tableStr = tableStr + '							<tr>';
			
		if(resultObject.data.jgdm!=""){
			var codeStr=resultObject.data.jgdm;
			codeArray = new Array;
			codeArray = codeStr.split("");
		    for(k=0;k<codeArray.length;k++){
		    	if(k!=8){
		    		tableStr = tableStr + '<td width="23"  align="center" class="txt2">'+codeArray[k]+'</td>';	
		    	}else{
		    		tableStr = tableStr + '</tr></table></td>';
					tableStr = tableStr + '<td width="15" align="center">-</td><td width="23"><table width="23"  id="table4" style="width:23;border-collapse:collapse; " cellpadding= "0" cellspacing= "0" border= "1" bordercolor= "#3366FF"><tr><td width="21"  class="txt2" align="center">'+codeArray[k]+'</td></tr></table></td></tr>';
		    	}
		    }
		 }else{
			 	tableStr = tableStr + '			<td width="23">&nbsp;</td><td width="23">&nbsp;</td><td width="23">&nbsp;</td><td width="23">&nbsp;</td><td width="23">&nbsp;</td><td width="23">&nbsp;</td><td width="23">&nbsp;</td><td width="23">&nbsp;</td>';
			 	tableStr = tableStr + '		</tr></table></td>';
			 	tableStr = tableStr + 		'<td width="15" align="center">-</td><td width="23"><table width="23"  id="table4" style="width:23;border-collapse:collapse; " cellpadding= "0" cellspacing= "0" border= "1" bordercolor= "#3366FF"><tr><td width="21">&nbsp;</td></tr></table></td></tr>';
		 }
				 						
		tableStr = tableStr + '	<tr><td height="54" colspan="5"><div align="center" class="head1">组织机构代码证基本信息登记表</div></td></tr></table>';
		
		tableStr = tableStr + '		<table id="table1" style="width:720;border-collapse:collapse; " cellpadding= "3" cellspacing= "0" border= "1" bordercolor= "#3366FF">';
		tableStr = tableStr + '			<tr><td width="140" height="45" class="title1"><div align="center" class="title1"><div align="center">机构名称<br>(盖  章)</div></div></td>';
		tableStr = tableStr + '				<td colspan="7" align="left"  class="txt1">&nbsp;'+resultObject.data.jgmc+'</td></tr>';
		tableStr = tableStr + '			<tr><td width="140" height="30" class="title1" align="center" >法定代表人(负责人)</td><td width="250"  align="left" colspan=3 class="txt1">&nbsp;'+resultObject.data.fddbr+'</td>';
		tableStr = tableStr + '				<td height="30" width=80 class="title1" align="center">法人证件</td><td width=250 colspan=3  class="txt1">'+resultObject.data.zjlx+'&nbsp;&nbsp;'+resultObject.data.zjhm+'</td></tr>';
		tableStr = tableStr + '			<tr><td height="100" class="title1"  align="center">经营范围<br />(职能、宗旨)</td><td colspan="7" align="left"  class="txt1">&nbsp;'+resultObject.data.jyfw +'</td></tr>';
		tableStr = tableStr + '			<tr><td height="30" class="title1"  align="center">成立日期</td><td colspan="3" align="left"  class="txt1">&nbsp;'+dateFormatToYMD(resultObject.data.zcrq)+'</td>';
		tableStr = tableStr + '				<td width=80 class="title1" align="center">职工人数</td><td colspan="3" align="left"  class="txt1">&nbsp;'+resultObject.data.zgrs+'&nbsp;(人)</td></tr>';
		tableStr = tableStr + '			<tr><td height="30" class="title1" align="center">证照有效期</td><td colspan="7" align="center" class="txt1">&nbsp;'+dateFormatToYMD(resultObject.data.zsbfrq)+'&nbsp;&nbsp;至&nbsp;&nbsp;'+dateFormatToYMD(resultObject.data.zszfrq)+'</tr>';
		tableStr = tableStr + '			<tr><td height="30" width="140"  class="title1" align="center">企业登记注册类型</td><td width="230" colspan="2" align="left" class="txt1">&nbsp;'+resultObject.data.jjlx+'&nbsp;&nbsp;'+resultObject.data.jjlxdm+'</td>';
		tableStr = tableStr + '				<td colspan="2"  class="title1" align="center">外商投资国别</td><td colspan="3" align="left" width="250" class="txt1">&nbsp;'+resultObject.data.wftzgb+'&nbsp;&nbsp;'+resultObject.data.wftzgbdm+'</td></tr>';
		tableStr = tableStr + '			<tr><td height="30" class="title1"  align="center">注册(开办)资金</td><td colspan="3" align="left"  class="txt1">&nbsp;'+resultObject.data.zczj +'&nbsp;(万元)</td>';
		tableStr = tableStr + '				<td  class="title1" align="center">货币种类</td><td colspan="3"  align="left" class="txt1">&nbsp;'+resultObject.data.hbzl+'&nbsp;&nbsp;'+resultObject.data.hbzldm +'</td></tr>';
		tableStr = tableStr + '			<tr><td height="30" class="title1" align="center">主管部门</td><td colspan="7" align="left"  class="txt1">&nbsp;'+resultObject.data.zgmc +'&nbsp;&nbsp;'+resultObject.data.zgdm+'</td></tr>';
		tableStr = tableStr + '			<tr><td height="30" class="title1" align="center">登记批准机构</td><td colspan="7" align="left" class="txt1">&nbsp;'+resultObject.data.pzjgmc+'&nbsp;&nbsp;'+resultObject.data.pzjgdm+'</td></tr>';
		/*
		tableStr = tableStr + '			<tr><td height="30" class="title1" align="center">批准文号或注册号</td><td colspan="3" align="left" class="txt1">&nbsp;'+resultObject.data.zch+'</td>';
		tableStr = tableStr + '				<td class="title1" align="center">邮政编码</td><td  colspan="3" align="left" class="txt1">&nbsp;'+resultObject.data.yzbm+'</td></tr>';
		tableStr = tableStr + '			<tr><td height="30" class="title1" align="center">机构注册地址</td><td colspan="7" class="txt1" align="left">&nbsp;'+resultObject.data.jgdz+'</td></tr>';
		tableStr = tableStr + '			<tr><td height="30" class="title1" align="center">机构经营地址</td><td colspan="7" class="txt1" align="left">&nbsp;'+resultObject.data.jydz+'</td></tr>';
		tableStr = tableStr + '			<tr><td height="30" class="title1" align="center">行政区划</td><td colspan="7" class="txt1" align="left">&nbsp;'+resultObject.data.xzqhName+'&nbsp;&nbsp;'+resultObject.data.xzqhCode+'</td></tr>';
		tableStr = tableStr + '			<tr><td height="30" class="title1" align="center">固定电话</td><td colspan="3" class="txt1" align="left">&nbsp;'+resultObject.data.dhhm+'</td>';
		tableStr = tableStr + '				<td class="title1" align="center">移动电话</td><td colspan="3 align="left" class="txt1" >&nbsp;'+resultObject.data.mobile+'</td></tr>';
		tableStr = tableStr + '			<tr><td height="30" class="title1" align="center">电子邮箱</td><td colspan="3" class="txt1" align="left">&nbsp;'+resultObject.data.email+'</td>';
		tableStr = tableStr + '				<td class="title1" align="center">网&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址</td><td colspan="3" align="left" class="txt1">&nbsp;'+resultObject.data.weburl+'</td></tr>';
		*/
		tableStr = tableStr + '			<tr><td height="30" class="title1" align="center">批准文号或注册号</td><td colspan="7" align="left" class="txt1">&nbsp;'+resultObject.data.zch+'</td></tr>';
		tableStr = tableStr + '			<tr><td height="30" class="title1" align="center">机构注册地址</td><td colspan="7" class="txt1" align="left">&nbsp;'+resultObject.data.jgdz+'</td></tr>';
		tableStr = tableStr + '			<tr><td height="30" class="title1" align="center">行政区划</td><td colspan="3" class="txt1" align="left">&nbsp;'+resultObject.data.xzqhName+'&nbsp;&nbsp;'+resultObject.data.xzqhCode+'</td>';
		tableStr = tableStr + '				<td class="title1" align="center">邮政编码</td><td  colspan="3" align="left" class="txt1">&nbsp;'+resultObject.data.yzbm+'</td></tr>';
		tableStr = tableStr + '			<tr><td height="30" class="title1" align="center">机构实际地址</td><td colspan="7" class="txt1" align="left">&nbsp;'+resultObject.data.jydz+'</td></tr>';
		tableStr = tableStr + '			<tr><td height="30" class="title1" align="center">行政区划</td><td colspan="3" class="txt1" align="left">&nbsp;'+resultObject.data.xzqhName2+'&nbsp;&nbsp;'+resultObject.data.xzqhCode2+'</td>';
		tableStr = tableStr + '				<td class="title1" align="center">邮政编码</td><td  colspan="3" align="left" class="txt1">&nbsp;'+resultObject.data.jyyb+'</td></tr>';
		tableStr = tableStr + '			<tr><td height="30" class="title1" align="center">电子信箱</td><td colspan="3" class="txt1" align="left">&nbsp;'+resultObject.data.email+'</td>';
		tableStr = tableStr + '				<td class="title1" align="center">网&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址</td><td colspan="3" align="left" class="txt1">&nbsp;'+resultObject.data.weburl+'</td></tr>';
		tableStr = tableStr + '			<tr><td height="30" class="title1" align="center">联系电话</td><td colspan="3" class="txt1" align="left">&nbsp;'+resultObject.data.dhhm+'</td>';
		tableStr = tableStr + '				<td class="title1" align="center">申请IC卡</td><td colspan="3 align="left" class="txt1" >&nbsp;'+resultObject.data.fkbz+'</td></tr>';
		tableStr = tableStr + '			<tr><td height="30" class="title1" align="center">经  办   人</td><td width="240" colspan=3 align="left" class="txt1">&nbsp;'+resultObject.data.tbrxm+'</td>';
		tableStr = tableStr + '				<td height="30" class="title1" align="center">经办人证件</td><td colspan=3 align="left"  class="txt1">&nbsp;'+resultObject.data.tbrzjlx+'&nbsp;&nbsp;'+resultObject.data.tbrsfzh+'</td></tr>';
		tableStr = tableStr + '			<tr><td height="30" class="title1" align="center">经办人电话</td><td colspan="3" align="left"  class="txt1">&nbsp;'+resultObject.data.tbrlxfs+'</td>';
		tableStr = tableStr + '				<td colspan="1" class="title1" align="center">填表日期</td><td colspan="3" align="left"  class="txt1">&nbsp;'+dateFormatToYMD(myDate.format('Y-m-d'))+'</div></td></tr>';
		tableStr = tableStr + '		</table>';
		tableStr = tableStr + '		<table style="width:720;border-collapse:collapse; " cellpadding= "0" cellspacing= "0" border= "0"><tr><td height="10" ></td></tr></table>';
		tableStr = tableStr + '		<table   id="table2" style="width:718;border-collapse:collapse; " cellpadding= "0" cellspacing= "0" border= "1" bordercolor= "#3366FF">';
		tableStr = tableStr + '			<tr><td height="150" width="80" class="STYLE7">';
		tableStr = tableStr + '				<table width="718" border="0">';
		tableStr = tableStr + '					<tr><td height="25" align="left" class="title1">备注栏：</td></tr><tr><td height="70" align="left" class="title1">&nbsp;</td></tr>';
		tableStr = tableStr + '					<tr><td align="right" height="30" class="title1">校对人签字：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>';
		tableStr = tableStr + '					<tr><td align="right" height="25" class="title1">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日&nbsp;</td></tr>';
		tableStr = tableStr + '				</table></td>';
		tableStr = tableStr + '			</tr>';
		tableStr = tableStr + '		</table>';
		tableStr = tableStr + '		<table style="width:720;border-collapse:collapse; " cellpadding= "0" cellspacing= "0" border= "0"><tr><td height="5" ></td></tr></table>';
		tableStr = tableStr + '		<table id="table3" style="width:720;border-collapse:collapse; " cellpadding= "0" cellspacing= "0" border= "1" bordercolor= "#FF0000">';
		tableStr = tableStr + '			<tr>';
		tableStr = tableStr + '				<td width="115" height="30" class="title1"><div align="center">业务类型</div></td>';
		tableStr = tableStr + '				<td width="605" colspan="3" align="center">';
		tableStr = tableStr + '					<table width="" style="width:560;border-collapse:collapse; " border="0" cellpadding="0" cellspacing="0">';
		tableStr = tableStr + '						<tr><td width="60"><span class="fangge">';	
			var ywlxState='no'; 
			var ywlxStr=resultObject.data.ywlx
				if(ywlxStr=="新办")
				 {
					 tableStr = tableStr + '■';
					 ywlxState='yes'; 
			     } else {
			    	  tableStr = tableStr + '□';
			     }
			 tableStr = tableStr + '</span><span class="STYLE9">新办</span></td><td><span class="fangge"> ';
				 if(ywlxStr=="换证")
				 {
					 tableStr = tableStr + '■';
					 ywlxState='yes'; 
			     } else {
			    	  tableStr = tableStr + '□';
			     }
			 tableStr = tableStr + '</span><span class="STYLE9">换证</span></td> <td><span class="fangge">'; 
				 if(ywlxStr=="变更")
				 {
					 tableStr = tableStr + '■';
					 ywlxState='yes'; 
			     } else {
			    	  tableStr = tableStr + '□';
			     }
			 tableStr = tableStr + '</span><span class="STYLE9">变更</span></td><td><span class="fangge"> ';
				 if(ywlxStr=="迁出")
				 {
					 tableStr = tableStr + '■';
					 var ywlxState='yes'; 
			     } else {
			    	 tableStr = tableStr + '□';
			     }
			 tableStr = tableStr + '</span><span class="STYLE9">迁出</span></td><td><span class="fangge">';
				 if(ywlxStr=="迁入")
				 {
					tableStr = tableStr + '■';
					 var ywlxState='yes'; 
			     } else {
			    	 tableStr = tableStr + '□';
			     }
			 tableStr = tableStr + '</span><span class="STYLE9">迁入</span></td><td><span class="fangge">'; 
				 if(ywlxStr=="年检")
				 {
					 tableStr = tableStr + '■';
					 ywlxState='yes'; 
			     } else {
			    	  tableStr = tableStr + '□';
			     }
			 tableStr = tableStr + '</span><span class="STYLE9">年检</span></td><td><span class="fangge">'; 
				 if(ywlxStr=="补证")
				 {
					tableStr = tableStr + '■';
					ywlxState='yes';
			     } else {
			    	  tableStr = tableStr + '□';
			     }
			 tableStr = tableStr + '</span><span class="STYLE9">补证</span></td><td><span class="fangge">';
				 if(ywlxStr=="其它")
				 {
					  tableStr = tableStr + '■';
			     } else {
			    	  tableStr = tableStr + '□';
			     }
		tableStr = tableStr + '</span><span class="title2">其它</span></td></tr></table> ';
		tableStr = tableStr + '				</td> ';
		tableStr = tableStr + '			</tr> ';
		tableStr = tableStr + '			<tr><td width="115" height="30" class="title1"><div align="center">代码有效期</div></td><td colspan="3" class="txt1"><div align="center">  至 &nbsp;&nbsp;</div></td></tr> ';
		tableStr = tableStr + '			<tr><td width="115" height="30" class="title1"><div align="center">经济行业(11版)</div></td><td width="245" class="txt1">&nbsp;'+resultObject.data.jjhymc+' '+resultObject.data.jjhydm+'</td> ';
		tableStr = tableStr + '				<td width="115" class="title1" align="center">机构类型(06版)</td><td width="245" class="txt1">&nbsp;'+resultObject.data.jglx+' '+resultObject.data.jglxdm+'</td></tr> ';
		tableStr = tableStr + '			<tr><td height="30" class="title1"><div align="center">受&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;理</div></td><td align="right">年&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;日</td> ';
		tableStr = tableStr + '				<td class="title1"><div align="center">审&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;核</div></td><td align="right">年&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;日</td></tr> ';
		tableStr = tableStr + '			<tr><td height="30" class="title1"><div align="center">录&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;入</div></td><td align="right">年&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;日</td> ';
		tableStr = tableStr + '				<td class="title1"><div align="center">扫&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;描</div></td><td align="right">年&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;日</td></tr> ';
		tableStr = tableStr + '			<tr><td height="30" class="title1"><div align="center">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注</div></td><td align="left" colspan=3>&nbsp;</td></tr>';
		tableStr = tableStr + '		</table><br> ';
		tableStr = tableStr + '		</td> ';
		tableStr = tableStr + '		</tr></table></center><script language="JavaScript">function reportPrint(){window.location.reload();window.print();}</script></body></html>';
	}  
	return String.format(tableStr);
}
function goZjlx(zjlxValue)
{
   if(typeof zjlxValue!=''){
	   switch (zjlxValue) {
	   case '0' :
		   zjlx="居民身份证";
	   case '1' :
		   zjlx="军官证";;
	   default :
		  zjlx="居民身份证";;
	   } 
	}
	return zjlx
}
var btn_print_orgnew2 = new Ext.Button({
	text : '打印申请表',
	iconCls : 'icon-print',
	//disabled:true,
	handler : function(btn){
		pagesetup_null();
		var record2 = grid_LicenseNew2.getSelectionModel().getSelected();
	    //Ext.MessageBox.alert("提示","Jglx是："+record2.data.jglx); 
		if(record2){
			var titleHTML = printSqdStr(record2); 
			var newwin = window.open('printer.jsp', 'printWindow', 'menubar=yes,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no,titlebar=yes,z-look=yes,menubar=yes');     
			newwin.document.write(titleHTML);
		}else{
			alert("请选择打印条目");
		}
	}
})



//默认查询 limit为显示的条数
var searchOrgnew = function() {
	if(currentJgdm==''){
		ds_orgnew.baseParams.conditions = orgnewEditForm.getForm().findField("jgmc").getValue();
	}else{
		ds_orgnew.baseParams.conditions = orgnewEditForm.getForm().findField("jgdm").getValue();
	}
	//ds_orgnew.baseParams.userId=12;
	//ds_orgnew.baseParams.conditions.currentReaderId
	//alert(currentUsername);
	//ds_orgnew.baseParams.username=currentUsername;
	//ds_orgnew.baseParams.state='3';
	ds_orgnew.baseParams.stateConditions='0,1,2,4,5';
	ds_orgnew.load({params : {start : 0,limit : 10} });
	//if(ds_orgnew.getTotalCount()=='0'){btn_add_orgnew.setDisabled(false);}
	//alert(ds_orgnew.getTotalCount());
}


					
//默认查询 limit为显示的条数
var searchOrgnew2 = function() {
	if(currentJgdm==''){
		ds_orgnew4.baseParams.conditions = orgnewEditForm.getForm().findField("jgmc").getValue();
	}else{
		ds_orgnew4.baseParams.conditions = orgnewEditForm.getForm().findField("jgdm").getValue();
	}
	//ds_orgnew4.baseParams.username=currentUsername;
	ds_orgnew4.baseParams.stateConditions='0,1,2,4,5';
	ds_orgnew4.load({params : {start : 0,limit : 2} });
}


//查询返回结果的数据列
var ds_orgnew = new Ext.data.Store({
	url : 'findAllOrgnew.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'orgid',type : 'int'}, {name : 'docid',type : 'string'},
	    {name : 'orderid',type : 'string'},
		{name : 'jgmc',type : 'string'},
		{name : 'jgdm',type : 'string'},
		{name : 'jglx',type : 'string'},
		{name : 'jglxdm',type : 'string'},
		{name : 'fddbr',type : 'string'}, 
		{name : 'zjlx',type : 'string'},
		{name : 'zjhm',type : 'string'}, 
		{name : 'jyfw',type : 'string'},
		{name : 'zcrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'zgdm',type : 'string'},
		{name : 'zgmc',type : 'string'},
		{name : 'pzjgmc',type : 'string'},
		{name : 'pzjgdm',type : 'string'},
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
		{name : 'hbzldm',type : 'string'},
		{name : 'wftzgb',type : 'string'},
		{name : 'wftzgbdm',type : 'string'},
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

		
		{name : 'jjhymc',type : 'string'},
		{name : 'jjhydm',type : 'string'},
		{name : 'gk',type : 'string'},
		{name : 'ywlx',type : 'string'},
		{name : 'njrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'isxw',type : 'string'},
		{name : 'fkbz',type : 'string'},
		{name : 'fksl',type : 'int'},
		{name : 'bzrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'zfrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'handleName',type : 'string'},
		{name : 'handleDate',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'handleNote',type : 'string'},
		{name : 'fbsl',type : 'int'},
		{name : 'lrDate',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		
		{name : 'zsbfrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'zszfrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'jjlx',type : 'string'},
		{name : 'jjlxdm',type : 'string'},
		{name : 'memo',type : 'string'},
		{name : 'memo2',type : 'string'},
		{name : 'moveoutAddrss',type : 'string'},
		{name : 'moveoutReason',type : 'string'},
		
		
		{name : 'name',type : 'string'},
		{name : 'username',type : 'string'},
		{name : 'pageTypeStr',type : 'string'},
		{name : 'auditName',type : 'string'},
		{name : 'auditDate',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'auditNote',type : 'string'},
		{name : 'imageUrl',type : 'string'},
		{name : 'state',type : 'string'}
	]),
	listeners: {
		 load: function(store) {
			 store.on('load',function(){
				 if(store.getCount()>0){
					 grid_LicenseNew.getSelectionModel().selectFirstRow();
					 btn_return_orgnew.setDisabled(false);
				 }
			 })
			
		 }
	}
	
});


//查询返回结果的数据列
var ds_orgnew4 = new Ext.data.Store({
	url : 'findAllOrgnew.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'orgid',type : 'int'}, {name : 'docid',type : 'string'},
	    {name : 'orderid',type : 'string'},
		{name : 'jgmc',type : 'string'},
		{name : 'jgdm',type : 'string'},
		{name : 'jglx',type : 'string'},
		{name : 'jglxdm',type : 'string'},
		{name : 'fddbr',type : 'string'}, 
		{name : 'zjlx',type : 'string'},
		{name : 'zjhm',type : 'string'}, 
		{name : 'jyfw',type : 'string'},
		{name : 'zcrq',type : 'date', convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'zgdm',type : 'string'},
		{name : 'zgmc',type : 'string'},
		{name : 'pzjgmc',type : 'string'},
		{name : 'pzjgdm',type : 'string'},
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
		{name : 'hbzldm',type : 'string'},
		{name : 'wftzgb',type : 'string'},
		{name : 'wftzgbdm',type : 'string'},
		{name : 'zgrs',type : 'string'},
		
		{name : 'jjhymc',mapping : 'jjhymc',type : 'string'},
		{name : 'jjhydm',mapping : 'jjhydm',type : 'string'},
		{name : 'gk',mapping : 'gk',type : 'string'},
		{name : 'njrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'isxw',type : 'string'},
		{name : 'fkbz',type : 'string'},
		{name : 'fksl',type : 'int'},
		{name : 'bzrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'zfrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'handleName',type : 'string'},
		{name : 'handleDate',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'handleNote',type : 'string'},
		{name : 'fbsl',type : 'int'},
		{name : 'lrDate',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'zsbfrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'zszfrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'jjlx',type : 'string'},
		{name : 'jjlxdm',type : 'string'},
		{name : 'memo',type : 'string'},
		{name : 'memo2',type : 'string'},

		
		
		{name : 'zch',type : 'string'},
		{name : 'pzwh',type : 'string'},
		{name : 'pwrq',type : 'string'},
		{name : 'email',type : 'string'},
		{name : 'weburl',type : 'string'},
		{name : 'mobile',type : 'string'},
		{name : 'yjflag',type : 'string'},
		{name : 'tbrxm',type : 'string'},
		{name : 'tbrzjlx',type : 'string'},
		{name : 'tbrsfzh',type : 'string'},
		{name : 'tbrlxfs',type : 'string'},
		{name : 'jydz',type : 'string'},
		{name : 'jyyb',type : 'string'},
		{name : 'jydh',type : 'string'},
		{name : 'jfly',type : 'string'},
		{name : 'khyh',type : 'string'},
		{name : 'khzh',type : 'string'},
		{name : 'ywlx',type : 'string'},
		{name : 'name',type : 'string'},
		{name : 'username',type : 'string'},
		{name : 'pageTypeStr',type : 'string'},
		{name : 'auditName',type : 'string'},
		{name : 'auditDate',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'auditNote',type : 'string'},
		{name : 'imageUrl',type : 'string'},
		{name : 'state',type : 'string'}
	]),
	listeners: {
		 load: function(store) {
			 store.on('load',function(){
				 if(store.getCount()>0){
					 grid_LicenseNew2.getSelectionModel().selectFirstRow();
					 btn_return_orgnew.setDisabled(false);
				 }
			})
		 }
	}
});

var btn_search_orgnew = new Ext.Button({
	text : '查询',
	hidden:true,
	iconCls : 'icon-search',
	handler : function() {
		searchOrgnew();
		//btn_add_orgnew.setDisabled(false);
		btn_edit_orgnew.setDisabled(true);
		btn_return_orgnew.setDisabled(true);
		btn_del_orgnew.setDisabled(true);
		btn_print_orgnew.setDisabled(true);
	}
});

var btn_search_orgnew2 = new Ext.Button({
	text : '查询',
	hidden:true,
	iconCls : 'icon-search',
	handler : function() {
		searchOrgnew2();
		btn_print_orgnew2.setDisabled(true);
	}
});

var btn_refresh_orgnew = new Ext.Button({
	text : '刷新',
	iconCls : 'icon-refresh',
	handler : function() {
		textSearchOrgnew.value='';
		searchOrgnew();
		//btn_add_orgnew.setDisabled(true);
		btn_edit_orgnew.setDisabled(true);
		btn_return_orgnew.setDisabled(true);
		btn_del_orgnew.setDisabled(true);
	}
});

var btn_refresh_orgnew2 = new Ext.Button({
	text : '刷新',
	iconCls : 'icon-refresh',
	handler : function() {
		textSearchOrgnew2.value='';
		searchOrgnew2();
	}
});
/*
var ds_xzqh_list = new Ext.data.Store({
	autoLoad : true,
	proxy : new Ext.data.HttpProxy({
		url : 'findAllXzqhName.action'
	}),
	reader : new Ext.data.JsonReader({
		root : 'root'
	}, [{name : 'xzqhId',type : 'int'},
		{name : 'xzqhName',type : 'string'}
	])
});

var btn_zz_combo = new Ext.form.ComboBox({
	name : 'textSearchOrgnew',
	store: ds_xzqh_list,
	displayField:'xzqhName',
	typeAhead: true,
	mode: 'remote',
	triggerAction: 'all',
	emptyText:'工作单分类',
	editable : true,
	width:135,
	loadingText : '加载中...'
});
*/
    
var text_search_orgnew = new Ext.form.TextField({
	id : 'textSearchOrgnew',
	hidden:true,
	name : 'textSearchOrgnew',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchOrgnew();
			}
		}
	}
});

var text_search_orgnew2 = new Ext.form.TextField({
	id : 'textSearchOrgnew2',
	hidden:true,
	name : 'textSearchOrgnew2',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchOrgnew2();
			}
		}
	}
});

//加载右栏主页面   （数据列表、工具栏按钮）
var grid_LicenseNew2 = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	//autoHeight : true,
	cm : cm_orgnew4,
	ds : ds_orgnew4,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'state',
	viewConfig : {forceFit : true},
	plugins : expander201,
	tbar : [btn_print_orgnew2,/*btn_refresh_orgnew2,*/'->', 
		  	text_search_orgnew2,btn_search_orgnew2],
	bbar : new Ext.PagingToolbar({
		pageSize : 10,
		store : ds_orgnew4,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			//if(grid_LicenseNew2.getStore().getAt(rowIndex).data.state == 2){
				//btn_edit_orgnewLicenseAgain.setDisabled(true);
				btn_print_orgnew2.setDisabled(false);
			//}
		}
	    
	
	}
});

//加载右栏主页面   （数据列表、工具栏按钮）
var grid_LicenseNew = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	//autoHeight : true,
	cm : cm_orgnew,
	ds : ds_orgnew,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'state',
	viewConfig : {forceFit : true},
	plugins : expander,
	tbar : [/*btn_refresh_orgnew,'-',*/btn_return_orgnew,'->', 
		  	text_search_orgnew,btn_search_orgnew],
	bbar : new Ext.PagingToolbar({
		pageSize : 10,
		store : ds_orgnew,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		
		'rowclick':function(grid,rowIndex){
			btn_return_orgnew.setDisabled(false);
		}
	}
});

var ds_filelog =  new Ext.data.Store({
	url : 'findAllLoanLog.action',
	sortInfo : {field: 'loanTime', direction: 'DESC'},
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'logId',type : 'int'}, 
		{name : 'orgid',type : 'int'}, 
		{name : 'orgnewName',type : 'string'}, 
		{name : 'loanTime'},
		{name : 'loanDays',type : 'int'}, 
		{name : 'preReturnTime'},
		{name : 'returnTime'},
		{name : 'readerId',type : 'int'},
		{name : 'reader',type : 'string'},
		{name : 'loannerId',type : 'int'},
		{name : 'filetypename',type : 'string'},
		{name : 'loanner',type : 'string'}]
	)
});



LoanLogPanel = Ext.extend(Ext.grid.GridPanel,{
	constructor:function(){
		LoanLogPanel.superclass.constructor.call(this,{
		loadMask : {msg : '数据加载中...'},
			cm : new Ext.grid.ColumnModel([ 
			   {header : '文件分类',width : 100,	dataIndex : 'filetypename',sortable : true}, 
				{header : '文件名称',	width : 120,dataIndex : 'orgnewName',id : 'orgnewName',renderer:linker,sortable : true}, 
				{header : '文件大小(K)',	width : 90,	dataIndex : 'reader',sortable : true},
				{header : '上传时间',width : 100,	dataIndex : 'loanTime',renderer: dateFormat,sortable : true}, 
				{header : '浏览次数',width : 100,	dataIndex : 'loanDays',sortable : true}, 
				{header : '审核时间',	width : 100,dataIndex : 'preReturnTime',renderer: dateFormat,sortable : true}, 
				{header : '通过时间',	width : 100,dataIndex : 'returnTime',renderer:dateFormat,sortable : true}, 
				{header : '受理人',	width : 100,dataIndex : 'loanner',menuDisabled : true}]
			),
			autoExpandColumn : 'jgmc',
			ds : ds_filelog,
			sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
			bbar : new Ext.PagingToolbar({
					pageSize : 10,
					store : ds_filelog,
					displayInfo : true,
					displayMsg : '第 {0} - {1} 条 共 {2} 条',
					emptyMsg : "没有新办申请记录"}
			)
		});
	}
});


var useLicenseNew_panel = new Ext.Panel({
	title : '新办申请',
	iconCls : 'icon-plugin',
	region : 'center',
	//border : 'layout',
	plain: true,
	frame : true,
	layout:'border',
	defaults: {
	    collapsible: true,
	    split: true
	},
	items: [{
	    region:'center',
	    layout : 'border',
	    items : [grid_LicenseNew]
	}]
});

var p_useLicenseNew = {
	id : 'useLicenseNew-panel',
	border : false,
	layout : 'border',
	items : [useLicenseNew_panel]
}

//当前日期
//alert(myDate.format('Y-m-d'));
//当前用户ID
//alert(currentUsername);
//当前用户姓名
//alert(currentUser);
//searchOrgnew();
