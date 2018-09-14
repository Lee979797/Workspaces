

//-----------------------点击列表信息，显示图书的扩展属性-----------------------
var expander_gd = new Ext.grid.RowExpander({
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

//---------------------- 列表显示原文的标识 ------------------------------------
function icon_goDfile(value,p,record){
	if(typeof record=='object'){
		var fileUrl;
		fileUrl=record.data["imageUrl"];
		if(fileUrl!=''){
			return String.format('<a style="display:table;width:100%;" onclick=""><img src="images/file_ico.gif"></a>',record.data["orgid"]);
		}else{
			return String.format('<a style="display:table;width:100%;" onclick=""><img src="images/report_no.gif"></a>',record.data["orgid"]);
		}
	}  
}

//---------------------- 列表显示主要数据信息 ----------------------------------
// 列表显示机构的主要信息 yangqi
var sm2678 = new Ext.grid.CheckboxSelectionModel();
 
var cm_goDfile = new Ext.grid.ColumnModel([expander_gd,
	sm2678,
	{header : '原文',width : 20,dataIndex : 'imageUrl', renderer:icon_goDfile,sortable : false},
	//{header : '流水号',width : 60,dataIndex : 'orderid',sortable : true}, 
	{header : '机构代码',width : 60,sortable : true,dataIndex : 'jgdm'},
	{header : '机构名称',width : 90,sortable : true,dataIndex : 'jgmc'},
	{header : '机构类型',width : 60,sortable : true,dataIndex : 'jglx'},
	{header : '法定代表人/负责人',width : 70,dataIndex : 'fddbr',sortable : true}, 
	{header : '办理人',width : 40,dataIndex : 'handleName',id : 'handleName',sortable : true},
	{header : '业务类型',	width : 50,dataIndex : 'ywlx',id : 'ywlx',sortable : true},
	{header : '状态',width : 50,dataIndex : 'state',renderer : goState,menuDisabled : true}
]);

var btn_return_goDfile_create = new Ext.Button({
	text : '批量归档',
	iconCls : 'icon-store',
	//disabled:true,
	handler : function(btn){
		var record=grid_GoDfile.getSelectionModel().getSelections();
		var Ids = "";
		var ReDms = "";
		if (typeof(record)!="undefined"){
			var len = record.length;
			if(len>0){
				for(var i = 0; i < len; i++){
					if(record[i].data.gk=='否'||record[i].data.imageFlag=="1"){
						Ids=Ids+record[i].data.orgid+",";
					}else{
						ReDms=ReDms+record[i].data.jgdm+"|";
					}
				}
				if(Ids!=""){
					ajaxLoadMask.show();
					Ext.Ajax.request({
						url: 'returnOrgnewCreate.action',
		   				params: { orgids: Ids},
		   				success: function(response){
		   					ajaxLoadMask.hide();
		   					Ext.Msg.show({
								title : '提示',
								msg : '“归档”操作成功!',
								buttons : Ext.Msg.OK,
								icon : Ext.Msg.INFO,
								fn : function(){
									//更新修改行的值
									for(var j = 0; j < len; j++){
										record[j].set('state','100'); 
										grid_GoDfile.fireEvent('rowclick',grid_GoDfile,grid_GoDfile.getStore().indexOf(record[j]));
										grid_GoDfile.getStore().remove(record[j]);
									}
									btn.enable();
									searchGoDfile();
									grid_GoDfile.unSelectAll();
									if(ReDms!=""){
										//alert("以下机构档案不完整请补扫后归档:"+ReDms);
										Ext.Msg.show({
											title : '提示',
											msg : "以下机构档案不完整请补扫后归档:"+ReDms,
											buttons : Ext.Msg.OK,
											icon : Ext.Msg.INFO
										});
									}
								}
							});
		   				},
		   				failure: function(){
		   					ajaxLoadMask.hide();
		   					Ext.Msg.show({
								title : '提示',
								msg : '“归档”操作失败!',
								buttons : Ext.Msg.OK,
								icon : Ext.Msg.ERROR
							});
		   				}
					});
				}else{
					if(ReDms!=""){
						//alert("以下机构档案不完整请补扫后归档:"+ReDms);
						Ext.Msg.show({
							title : '提示',
							msg : "以下机构档案不完整请补扫后归档:"+ReDms,
							buttons : Ext.Msg.OK,
							icon : Ext.Msg.INFO
						});
					}
				}
				
			}else{
				Ext.Msg.show({
					title : '提示',
					msg : '请选择需归档机构信息！',
					buttons : Ext.Msg.OK,
					icon : Ext.Msg.ERROR
				});
			}
		}
	}
});



//默认查询 limit为显示的条数
var searchGoDfile = function() {
	ds_goDfile.baseParams.conditions = text_search_goDfile.getValue();
	ds_goDfile.baseParams.dybz = 'N';
	if(currentZzUsername=='admin'){
		ds_goDfile.baseParams.handleUsername = null;
	}else{
		ds_goDfile.baseParams.handleUsername = currentZzUsername;
	}
	//ds_goDfile.baseParams.ywlx=(currentZzUserBzjgdm==currentZzUserCenterid?"":null);
	ds_goDfile.baseParams.username=currentZzUsername;
	ds_goDfile.baseParams.stateConditions='6,16';
	ds_goDfile.load({params : {start : 0,limit : useFullPageSize} });

}

//查询返回结果的数据列
var ds_goDfile = new Ext.data.Store({
	url : 'findAllOrgnew.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'orgid',type : 'int'}, 
	    {name : 'orderid',type : 'string'}, 
	    {name : 'centerid',type : 'string'},
	    {name : 'docid',type : 'string'},
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
		
		{name : 'njrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'bzrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'zfrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'isxw',type : 'string'},
		{name : 'fkbz',type : 'string'},
		{name : 'fksl',type : 'int'},
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
		{name : 'imageFlag',type : 'string'},
		
		{name : 'offPzjgmc',type : 'string'},
		{name : 'offPzwh',type : 'string'},
		{name : 'offReason',type : 'string'},	
		{name : 'offNote',type : 'string'},
		{name : 'state',type : 'string'}
	])
});

var btn_search_goDfile = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchGoDfile();
		//btn_return_goDfile_create.setDisabled(true);
		//btn_return_goDfile_code.setDisabled(true);
	}
});

var btn_refresh_goDfile = new Ext.Button({
	text : '刷新',
	iconCls : 'icon-refresh',
	handler : function() {
		textSearchGoDfileid.value='';
		searchGoDfile();
		//btn_return_goDfile_create.setDisabled(true);
		//btn_return_goDfile_code.setDisabled(true);
	}
});

var btn_do_orgnew = new Ext.Button({
	text : '归档办理',
	handler : function(){
		var record = grid_GoDfile.getSelectionModel().getSelected();
		if(record){
			var record = grid_GoDfile.getSelectionModel().getSelected();
			if(record){
				window_do_goDfile.show();
				goDfileViewForm.getForm().loadRecord(record);
				window_do_goDfile.setTitle('归档办理--【'+record.data.jgmc+'】--'+record.data.ywlx);
			}	
		}
	}
});


var text_search_goDfile = new Ext.form.TextField({
	id:'textSearchGoDfileid',
	name : 'textSearchGoDfile',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchGoDfile();
			}
		}
	}
});
/*
//--------------------机构基本信息-------------------------------------------
var goDfileViewForm = new Ext.FormPanel({
	labelAlign : 'right',
	labelWidth : 95,
	bodyStyle : 'padding:0px',
	border : false,
	autoHeight : true,
	autoScroll : true, 
	baseCls : 'x-plain',
	waitMsgTarget: true,
	items : [{
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		bodyStyle : 'padding:5px',
		items : [{//第一行基本
			columnWidth : 1,
			layout : 'form',
			baseCls : 'x-plain',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '99.5%'},
			items : [
				{xtype : 'hidden',name : 'orgid'},
				{xtype : 'hidden',name : 'state'},
				{xtype : 'hidden',name : 'imageFlag'},
				{fieldLabel : '机构名称',	name : 'jgmc',readOnly:true}
			]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '机构代码',name : 'jgdm',readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '机构类型',name : 'jglx',readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '是否公开',name : 'gk',readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '小微企业',name : 'isxw',readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '法定代表人',name : 'fddbr',readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '是否发卡',name : 'fkbz',readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '证件类型',name : 'zjlx',readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '证件号码',name : 'zjhm',readOnly:true}]
		},{////第五行基本
			columnWidth : 1,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99.5%'},
			items : [{fieldLabel : '经营范围',name : 'jyfw',readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '成立日期',name : 'zcrq',readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '职工人数',name : 'zgrs',readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '证照有效期',name : 'zsbfrq',readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '至',name : 'zszfrq',readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '企业注册类型',name : 'jjlxdm',readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '经济行业代码',name : 'jjhydm',readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '注册资金',name : 'zczj',readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '外方国别',name : 'wftzgb',readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '主管部门',name : 'zgmc',readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '批准机构',name : 'pzjgmc',readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '注册号',name : 'zch',readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '联系电话',name : 'dhhm',readOnly:true}]
		},{
			columnWidth : 1,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99.5%'},
			items :[{fieldLabel : '机构注册地址',name : 'jgdz',readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '行政区划',name : 'xzqhCode',readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '邮政编码',name : 'yzbm',readOnly:true}]
		},{
			columnWidth : 1,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99.5%'},
			items :[{fieldLabel : '机构实际地址',name : 'jydz',readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '行政区划',name : 'xzqhCode2',readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '邮政编码',name : 'jyyb',readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '经办人',name : 'tbrxm',readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '经办人电话',name : 'tbrlxfs',readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '经办人证件类型',name : 'tbrzjlx',readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '经办人证件号码',name : 'tbrsfzh',readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '办证日期',name : 'bzrq',readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '作废日期',name : 'zfrq',readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '年检期限',name : 'njqx',readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '业务类型',name : 'ywlx',readOnly:true}]
		}]
	}]
});


//信息浏览
var  goDfileView= new Ext.Panel({
    title       : '基本信息',
    region      : 'west',
    split       : true,
    width       : 530,
    collapsible : true,
    margins     : '3 0 3 3',
    cmargins    : '3 3 3 3',
	autoScroll : true,
	items : [goDfileViewForm]
}); 

//图像浏览
var goDfileViewImg = new Ext.Panel({
	title   : '原文信息',
    region    : 'center',
    width       : 530,
    margins   : '3 3 3 0', 
    //margins   : '0 0 0 2', 
    activeTab : 0,
    html: '<OBJECT classid="clsid:B4E2D33E-D8B2-4956-9F91-1C6BDC87A6D1"   width=100%  height=100% align=center hspace=0 vspace=0 id="scanner2"  name="scanner2" >'
	       +'<param name="ShowCount" value="1">'
	       +'<param name="sModel" value="1">'
	       +'</OBJECT>'
});


var window_do_goDfile = new Ext.Window({
	title : '归档办理',
	iconCls : 'icon-plugin',
	width : 930,
	height : 580,
	resizable : true,
	modal : true,
	plain    : true,
	layout   : 'border',
	closeAction : 'hide',
	maximizable:true,
	items : [goDfileView,goDfileViewImg],
	buttons : [{   
        text: '重载原文',   
        handler: function() {
        	var record = grid_GoDfile.getSelectionModel().getSelected();
        	if(record){
        		Ext.Ajax.request({
				url : 'orgnewViewImg.action',
				params : {orgid : record.data.orgid},
				success : function(result,request) {//获取返回值 
					scanner2.ImageData="";
   					var resultObject = Ext.util.JSON.decode(result.responseText); 
   					scanner2.OpenProgress(3);  //设置上传的进度条的总进度数
   					scanner2.Progress('原文加载中',1);
					scanner2.Progress('原文加载中',2);
   					scanner2.ImageData=resultObject.imageData;
   					scanner2.pageType=resultObject.pageTypeStr;
   					if(scanner2.ImageData!="" && scanner2.pageType!=null){
   						scanner2.Progress('原文加载完毕',3);
						scanner2.CloseProgress();
					}else{
						scanner2.Progress('原文加载失败',3);
		   				scanner2.CloseProgress();
		   				alert("原文错误，加载失败或者标识错误！");
					}
				},
				failure : function() {
					scanner2.ImageData="";
		   			scanner2.CloseProgress();
					alert("图像加载错误,或者无原文！");
				}
			});
	        	
			}else{
                alert("请选择条目！");
            }
        }   
    },{   
        text: '前一条',   
        handler: function() {
        	 var grid_ = grid_GoDfile;
             var selModel = grid_.getSelectionModel();
             if(selModel.hasPrevious()){
                selModel.selectPrevious();
         		var record = grid_GoDfile.getSelectionModel().getSelected();
         		if(record){
         			goDfileViewForm.getForm().loadRecord(record);
         			window_do_goDfile.setTitle('审核办理--【'+record.data.jgmc+'】');
         			
         			Ext.Ajax.request({
	    				url : 'orgnewViewImg.action',
	    				params : {orgid : record.data.orgid},
	    				success : function(result,request) {//获取返回值 
	    					scanner2.ImageData="";
		   					var resultObject = Ext.util.JSON.decode(result.responseText); 
		   					scanner2.OpenProgress(3);  //设置上传的进度条的总进度数
		   					scanner2.Progress('原文加载中',1);
							scanner2.Progress('原文加载中',2);
		   					scanner2.ImageData=resultObject.imageData;
		   					scanner2.pageType=resultObject.pageTypeStr;
		   					if(scanner2.ImageData!="" && scanner2.pageType!=null){
		   						scanner2.Progress('原文加载完毕',3);
								scanner2.CloseProgress();
							}else{
								scanner2.Progress('原文加载失败',3);
				   				scanner2.CloseProgress();
				   				alert("原文错误，加载失败或者标识错误！");
							}
	    				},
	    				failure : function() {
	    					scanner2.ImageData="";
				   			scanner2.CloseProgress();
	    					alert("图像加载错误,或者无原文！");
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
        	 var grid_ = grid_GoDfile;
             var selModel = grid_.getSelectionModel();
             if(selModel.hasNext()){
                selModel.selectNext();
                //grid_GoDfile.getSelectionModel().selectNext();
         		var record = grid_GoDfile.getSelectionModel().getSelected();
         		if(record){
         			goDfileViewForm.getForm().loadRecord(record);
         			window_do_goDfile.setTitle('审核办理--【'+record.data.jgmc+'】');	
	        		Ext.Ajax.request({
	    				url : 'orgnewViewImg.action',
	    				params : {orgid : record.data.orgid},
	    				success : function(result,request) {//获取返回值 
	    					scanner2.ImageData="";
		   					var resultObject = Ext.util.JSON.decode(result.responseText); 
		   					if(resultObject!=null){
			   					scanner2.OpenProgress(3);  //设置上传的进度条的总进度数
			   					scanner2.Progress('原文加载中',1);
								scanner2.Progress('原文加载中',2);
			   					scanner2.ImageData=resultObject.imageData;
			   					scanner2.pageType=resultObject.pageTypeStr;
			   					if(scanner2.ImageData!="" && scanner2.pageType!=null){
			   						scanner2.Progress('原文加载完毕',3);
										scanner2.CloseProgress();
									}else{
										scanner2.Progress('原文加载失败',3);
					   				scanner2.CloseProgress();
					   				alert("原文错误，加载失败或者标识错误！");
									}
								}
	    				},
	    				failure : function() {
	    					scanner2.ImageData="";
				   			scanner2.CloseProgress();
	    					alert("图像加载错误,或者无原文！");
	    				}
	    			});
			            	
			    	
         		}
             }else{
                 alert("已经到最后一条,请翻页");
             }
        }   
    },{
    	text : '归档',
		handler : function(btn){
			if(goDfileViewForm.getForm().findField('gk').getValue()=='否'||goDfileViewForm.getForm().findField('imageFlag').getValue()=='1'){
				if(goDfileViewForm.getForm().isValid()){
					var orgid = goDfileViewForm.getForm().findField('orgid').getValue();
					ajaxLoadMask.show();
					Ext.Ajax.request({
						url: 'returnOrgnewCreateOne.action',
		   				success: function(){
		   					ajaxLoadMask.hide();
		   					btn.enable();
							//window_do_goDfile.hide();
		   					goDfileViewForm.getForm().reset();
		   					scanner2.ImageData="";
		   					scanner2.PageType="";
							var record = grid_GoDfile.getSelectionModel().getSelected();
			         		if(record){
								grid_GoDfile.getStore().remove(record);
								
			         		}
		   				},
		   				failure: function(){
		   					ajaxLoadMask.hide();
		   					Ext.Msg.show({
								title : '提示',
								msg : '[' + goDfileViewForm.getForm().findField('jgmc').getValue() + '] “归档操作”失败!',
								icon : Ext.Msg.ERROR,
								buttons : Ext.Msg.OK
							});
		   				},
		   				params: {orgid: orgid}
					});
				}
			}else{
				alert("档案不完整，请检查标识及是否缺页！");
			}
			
		}
	},{   
        text: '退出',   
        handler: function() {   
        	window_do_goDfile.hide(); 
        }   
    }],
    listeners : {
    	'activate' : function() {
        	var record = grid_GoDfile.getSelectionModel().getSelected();
        	if(record){
        		Ext.Ajax.request({
    				url : 'orgnewViewImg.action',
    				params : {orgid : record.data.orgid},
    				success : function(result,request) {//获取返回值 
    					scanner2.ImageData="";
	   					var resultObject = Ext.util.JSON.decode(result.responseText); 
	   					if(resultObject!=null){
		   					scanner2.OpenProgress(3);  //设置上传的进度条的总进度数
		   					scanner2.Progress('原文加载中',1);
							scanner2.Progress('原文加载中',2);
		   					scanner2.ImageData=resultObject.imageData;
		   					scanner2.pageType=resultObject.pageTypeStr;
		   					if(scanner2.ImageData!="" && scanner2.pageType!=null){
		   						scanner2.Progress('原文加载完毕',3);
									scanner2.CloseProgress();
								}else{
									scanner2.Progress('原文加载失败',3);
					   				scanner2.CloseProgress();
					   				alert("原文错误，加载失败或者标识错误！");
								}
							}
    				},
    				failure : function() {
    					scanner2.ImageData="";
			   			scanner2.CloseProgress();
    					alert("图像加载错误,或者无原文！");
    				}
    			});
            	
    		}else{
                alert("请选择条目！");
            }
        } 
    }
});*/

var viewImage = function(orgid){
	 
    //var record = grid_GoDfile.getSelectionModel().getSelected();
    var resultObject = null;
    var	imgUrl='';
	imgUrl='orgnewViewImg.action';
	scanner7008.ImageData="";
	Ext.Ajax.request({
		url : imgUrl,
		params : {orgid : orgid},
		success : function(result,request) {//获取返回值
			var resultObject = Ext.util.JSON.decode(result.responseText);
			if(resultObject!=null){
				scanner7008.OpenProgress(3);  //设置上传的进度条的总进度数
				scanner7008.Progress('原文加载中',1);
				scanner7008.Progress('原文加载中',2);
			    //resultObject = eval('('+result.responseText+')');  
				scanner7008.ImageData=resultObject.imageData;
				if(scanner7008.ImageData!=""){
					scanner7008.PageType=resultObject.pageTypeStr;
					scanner7008.Progress('原文加载完毕',3);
				}else{
					scanner7008.Progress('原文加载失败',3);
					alert("原文错误，加载失败，请重新扫描或导入！");
				}
				scanner7008.CloseProgress();
			}
		},
		failure : function() {
			alert("图像加载错误");
		}
	});
   
}
//--------------------图片浏览窗口-------------------------------------------
var viewImagePanel = new Ext.Panel({
	region : 'east',
    title : '原文预览',   
    width : 530,  
    collapsible: true,
    collapsed: true,
    margins   : '0 0 0 2', 
    closeAction :'hide',
    html: '<OBJECT classid="clsid:B4E2D33E-D8B2-4956-9F91-1C6BDC87A6D1"   width=100%  height=100% align=center hspace=0 vspace=0 id="scanner7008"  name="scanner7008" >'
	       +'<param name="ShowCount" value="8">'
	       +'<param name="sModel" value="1">'
	       +'</OBJECT>',
    buttons: [{ 
		   id:'up_button2',
		   name:'up_button2',
		   text: '上传',   
	       handler: function(btn) {   
				
	       		var record = grid_GoDfile.getSelectionModel().getSelected();
				Ext.Ajax.request({
					url: 'checkArchive.action',
					params: {orgid: record.data.orgid,jgdm:record.data.jgdm},
					success: function(result,request){//result,request
						var data = Ext.util.JSON.decode(result.responseText);
						var dalx = "";
						if(record.data.ywlx=='新办'){
							dalx = '申请';
						}else if(record.data.ywlx=='年检'){
							dalx = '年度验证';
						}else if(record.data.ywlx=='批量注销'){
							dalx = '注销';
						}else{
							dalx = record.data.ywlx;
						}
						var str = scanner7008.CheckArchives(dalx,data.jglxdmOld,data.zchInfo,data.frInfo);
						if(str==''||record.data.ywlx=='预赋码'){
							//alert("更新imageFlag为1（表示档案完整）");
							refreshImageFlag(record.data.orgid,'1');
							var base64file;
							var packLength;
							var packCount;
							var imageCount;
							var pageTypeStr;
							var lastPack;
							var xmlhttp;
							var i;
							var pack;
							var strOrgid;
							var strBzjgdm;
							
							//var record = grid_GoDfile.getSelectionModel().getSelected();
						    //Ext.MessageBox.alert("提示","您选择的出版号是："+record2.data.fddbr); 
							btn.disable();
							strOrgid = record.data.orgid;  //参数orgid
							strDocid =record.data.docid;  //参数docid
							strBzjgdm = record.data.bzjgdm;
							//alert(record.data.imageData);
							packLength = 40960;	//定义每个包的大小40960
							//scanner7008.ImageData=record.data.imageData;
							base64file = scanner7008.ImageData;  //获取控件扫描的图片数据
							var baseSize = base64file.length;  //获取控件图片数据的64位编码的长度
							imageCount = scanner7008.GetPageCount;	//获取扫描图片的页数
							pageTypeStr = scanner7008.PageType;    //获取标识字符串,需要写数据库
							if(pageTypeStr!=""){
								pageTypeStr=pageTypeStr.replace(/\%/g, "|"); 
			       			}
							
							packCount = Math.ceil(base64file.length / packLength);	//判断需要发送数据包的个数
							//alert(packCount);
							if(imageCount==0 || base64file=="")   //判断如果没有扫描数据，结束处理
							{
								alert("请扫描或导入图片后，再上传！");
								btn.enable();
								return false;
							}
							if (pageTypeStr.indexOf('未标识')!=-1){ //判断如果没有标识，则不允许上传
								alert("请进行电子原文标识后，再保存！");
								btn.enable();
								return false;
							}
							scanner7008.OpenProgress(packCount);  //设置上传的进度条的总进度数
							xmlhttp = GetXmlHttp(); //通过AJAX格式上传
							for(i=0; i < packCount; i++)  //分包上传
							{
									
								if(i==packCount-1){
									lastpack="true";
								}else{
									lastpack="false";
								}
								pack = base64file.substring(i * packLength, (i + 1) * packLength);  //每个数据包的文件大小
									//alert(pack);
								try
								{
									xmlhttp.open("post", "saveImageOrgnew.action?orgid="+strOrgid+"&docid="+strDocid+"&packindex="+i+"&pageTypeStr="+pageTypeStr+"&bzjgdm="+strBzjgdm+"&lastpack="+lastpack, false);
									xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   //这句必须要，而且一定要放在send以前
									xmlhttp.send("imageData=" + encodeURIComponent(pack)); 
		                            //alert(xmlhttp.responseText);
									var objs = eval("["+xmlhttp.responseText+"]");
									if(objs[0].success)
									{
										scanner7008.Progress('上传中',i+1);
									}
									else
									{
										alert("上传失败，请重试0001。");
										btn.enable();
										return false;
									}
								}
								catch(e)
								{
									alert("上传失败，请重试0002。");
									btn.enable();
									return false;
								}
							}
							alert("上传成功！");
							searchGoDfile();
							btn.enable();
							return true;
							
						}else{
							alert(str);
							/*Ext.Msg.show({
								title : '提示',
								msg : str,
								buttons : Ext.Msg.OK,
								fn: function(){},
								icon : Ext.Msg.INFO
							});*/
							return false;
						}
					}
				});
					
	       }   
	   }/*,{   
	       text: '重载',   
		       handler: viewImage
	   }*/,{   
	        text: '清空',   
	        handler: function() {   
	            scanner7008.ImageData="";
	        }
	   }]

});
 

//加载右栏主页面   （数据列表、工具栏按钮）
var grid_GoDfile = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_goDfile,
	ds : ds_goDfile,
	sm : new Ext.grid.CheckboxSelectionModel(),
	autoExpandColumn : 'jgmc',
	viewConfig : {forceFit : true},
	plugins : expander_gd,
	tbar : [btn_refresh_goDfile,btn_return_goDfile_create,'->', 
		  	text_search_goDfile,btn_search_goDfile],
	bbar : new Ext.PagingToolbar({
		pageSize : useFullPageSize,
		store : ds_goDfile,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowdblclick':function(grid, rowIndex){
			viewImage(grid.getStore().getAt(rowIndex).data.orgid);
		},
		'rowclick':function(grid,rowIndex){
			scanner7008.ImageData="";
		}
	}
});


var zzGoDfile_panel = new Ext.Panel({
	title : '扫描归档',
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
	    items : [grid_GoDfile,viewImagePanel]
	}]
});

var p_zzGoDfile = {
	id : 'zzGoDfile-panel',
	border : false,
	layout : 'border',
	items : [zzGoDfile_panel]
}