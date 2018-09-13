var arctypeStr2 = [['0','全部档案'],['1','新办'],['2','年检'],['3','迁出'],['4','迁入'],['5','变更'],['6','换证'],['7','补证'],['8','注销'],['9','其他'],['10','预赋码']]; 
var arctypeStore2 = new Ext.data.SimpleStore({fields:['arctypeCode','arctypeValue'],data:arctypeStr2});



//点击列表信息，显示图书的扩展属性//
var expander_dfileQueryArchive = new Ext.grid.RowExpander({
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





function goArcErrorflag(value,p,record)
{
   var dflagValue;
   dflagValue=record.data["d_flag"];
   if(dflagValue.toString()=="2"){
	  strEsFlag="<font color=red><b>档案已驳回</b></font>";
   }else{
	   strEsFlag="";
   }
    return String.format(strEsFlag);
}

	
//--------------------查看临时库机构档案信息-------------------------------------------
var dfileQueryArchiveEditForm = new Ext.FormPanel({
	loadMask : {
		msg : '数据加载中...'
	},
	labelAlign : 'right',
	labelWidth : 95,
	bodyStyle : 'padding:0px',
	border : false,
	autoHeight : true,
	autoScroll : true, 
	baseCls : 'x-plain',
	waitMsgTarget: true,
	items : [{
            layout:'column',
            border:false,
            autoScroll : true,
            baseCls : 'x-plain',
            bodyStyle : 'padding:10px',
            items:[{
	                columnWidth:.5,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [
	                	{xtype:'textfield',fieldLabel : '流水号',	name : 'orderid',readOnly:true, anchor:'100%'}]
				},{
	                columnWidth:.5,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [
	                	{xtype:'textfield',fieldLabel : '业务类型',name : 'ywlx', readOnly:true,anchor:'100%'},
	                		{xtype : 'hidden',name : 'orgid'},
							{xtype : 'hidden',name : 'centerid'},
							{xtype : 'hidden',name : 'state'}
					]
				},{
	                columnWidth:1,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '机构名称',name : 'jgmc',readOnly:true, anchor:'100%'}]
				},{
	                columnWidth:.5,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [
	                	{xtype:'textfield',fieldLabel : '机构代码',name : 'jgdm',readOnly:true, anchor:'100%'},
	                	{xtype:'textfield',fieldLabel : '证件类型',name : 'zjlx',readOnly:true, anchor:'100%'}
	                ]
				},{
	                columnWidth:.5,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [
                		{xtype:'textfield',fieldLabel : '法定代表',name : 'fddbr',readOnly:true,anchor:'100%'},
                		{xtype:'textfield',fieldLabel : '证件号码',name : 'zjhm', readOnly:true,anchor:'100%'}
                	]
				},{
					columnWidth:1,
                	layout: 'form',
                	bodyStyle: 'padding:0px',
                	border:false,
                	defaultType : 'textarea',
                	items: [
                		{xtype:'textfield',fieldLabel : '经营范围',name : 'jyfw',readOnly:true,anchor:'100%',height:'50'}
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
	                	{xtype:'textfield',fieldLabel : '成立日期',name : 'zcrq',readOnly:true, anchor:'100%'},
	                	{xtype:'textfield',fieldLabel : '企业注册类型',name : 'jjlx',readOnly:true, anchor:'100%'},
	                	{xtype : 'hidden',name : 'jjlxdm'},
	                	{xtype:'textfield',fieldLabel : '证照终止日期',name : 'zszfrq',readOnly:true, anchor:'100%'},
	                	{xtype:'textfield',fieldLabel : '注册资金',name : 'zczj',readOnly:true, anchor:'100%'},
	                	{xtype:'textfield',fieldLabel : '主管部门',name : 'zgmc',readOnly:true, anchor:'100%'},
	                	{xtype : 'hidden',name : 'zgdm'}
	                ]
				},{
	                columnWidth:.5,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [
                		{xtype:'textfield',fieldLabel : '职工人数',name : 'zgrs',readOnly:true, anchor:'100%'},
						{xtype:'textfield',fieldLabel : '证照开始日期',name : 'zsbfrq',readOnly:true, anchor:'100%'},
						{xtype:'textfield',fieldLabel : '投资国别',name : 'wftzgb',readOnly:true, anchor:'100%'},
						{xtype : 'hidden',name : 'wftzgbdm'},
						{xtype:'textfield',fieldLabel : '货币种类',name : 'hbzl',readOnly:true, anchor:'100%'},
						{xtype : 'hidden',name : 'hbzldm'},
						{xtype:'textfield',fieldLabel : '批准机构',name : 'pzjgmc',readOnly:true, anchor:'100%'},
						{xtype : 'hidden',name : 'pzjgdm'}
						/*,
						{xtype:'textfield',fieldLabel : '迁入地址',id:'moveoutAddrss_archiveQuery',name : 'moveoutAddrss',maxLength : 100,readOnly:true,anchor:'100%'},
						{xtype:'textfield',fieldLabel : '迁址原因',id:'moveoutReason_archiveQuery',name : 'moveoutReason',maxLength : 250,readOnly:true,anchor:'100%'},
						{xtype:'textfield',fieldLabel : '批注注销机构',id:'offPzjgmc_archiveQuery',name : 'offPzjgmc',maxLength : 100,readOnly:true,anchor:'100%'},
						{xtype:'textfield',fieldLabel : '批准注销文号',id:'offPzwh_archiveQuery',name : 'offPzwh', readOnly:true,anchor:'100%'},
						{xtype:'textfield',fieldLabel : '注销原因',id:'offReason_archiveQuery',name : 'offReason',readOnly:true,anchor:'100%'},
						{xtype:'textfield',fieldLabel : '证书回收情况',id:'offNote_archiveQuery',name : 'offNote',height:80,anchor:'100%'}
                		*/
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
	                	{xtype:'textfield',fieldLabel : '联系电话',name : 'dhhm', readOnly:true,anchor:'100%'},
	                	{xtype:'textfield',fieldLabel : '移动电话',name : 'mobile',readOnly:true, anchor:'100%'},
	                	{xtype:'textfield',fieldLabel : '经办人名称',name : 'tbrxm',readOnly:true, anchor:'100%'},
	                	{xtype:'textfield',fieldLabel : '经办人证件号码',name : 'tbrsfzh',readOnly:true, anchor:'100%'},
	                	{xtype:'textfield',fieldLabel : '经济行业',name : 'jjhymc',readOnly:true, anchor:'100%'},
	                	{xtype:'textfield',fieldLabel : '是否公开',name : 'gk',readOnly:true, anchor:'100%'}
	                ]
				},{
	                columnWidth:.5,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [
						{xtype : 'hidden',name : 'xzqhCode'},{xtype : 'hidden',name : 'xzqhCode2'},
						{xtype:'textfield',fieldLabel : '网址',name : 'weburl',readOnly:true, anchor:'100%'},
						{xtype:'textfield',fieldLabel : '电子信箱',name : 'email',readOnly:true, anchor:'100%'},
						{xtype:'textfield',fieldLabel : '经办人证件类型',name : 'tbrzjlx',readOnly:true, anchor:'100%'},
						{xtype:'textfield',fieldLabel : '经办人电话',name : 'tbrlxfs',readOnly:true, anchor:'100%'},
						{id:"select_jjhydm_archiveQuery",xtype : 'hidden',readOnly:true,name : 'jjhydm'},
						{xtype:'textfield',fieldLabel : '机构类型',name : 'jglx',readOnly:true, anchor:'100%'}
						/*,
						{xtype:'textfield',fieldLabel : '迁入地址',id:'moveoutAddrss_archiveQuery',name : 'moveoutAddrss',maxLength : 100,readOnly:true,anchor:'100%'},
						{xtype:'textfield',fieldLabel : '迁址原因',id:'moveoutReason_archiveQuery',name : 'moveoutReason',maxLength : 250,readOnly:true,anchor:'100%'},
						{xtype:'textfield',fieldLabel : '批注注销机构',id:'offPzjgmc_archiveQuery',name : 'offPzjgmc',maxLength : 100,readOnly:true,anchor:'100%'},
						{xtype:'textfield',fieldLabel : '批准注销文号',id:'offPzwh_archiveQuery',name : 'offPzwh', readOnly:true,anchor:'100%'},
						{xtype:'textfield',fieldLabel : '注销原因',id:'offReason_archiveQuery',name : 'offReason',readOnly:true,anchor:'100%'},
						{xtype:'textfield',fieldLabel : '证书回收情况',id:'offNote_archiveQuery',name : 'offNote',height:80,anchor:'100%'}
                		*/
                	]
				}
				/*
				,{
	                columnWidth:1,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '问题类型',name : 'errorFlag',readOnly:true,disabled : true,anchor:'100%',height:'40'}]
				}*/]
		}]
});


var sm3345 = new Ext.grid.CheckboxSelectionModel();
//列表显示图书主要信息//
var cm_dfileQueryArchive = new Ext.grid.ColumnModel([expander_dfileQueryArchive,
    sm3345,
    {header : '原文',width : 20,dataIndex : 'imageUrl', renderer:icon_dam,sortable : false},
    {header : '档案ID',width : 100,dataIndex : 'docid',sortable : true}, 
	{header : '机构代码',width : 40,dataIndex : 'jgdm',	sortable : true}, 
	{header : '机构名称',width : 160,dataIndex : 'jgmc',sortable : true},
	{header : '办证机构代码',width : 40,dataIndex : 'bzjgdm',sortable : true},
	{header : '建档日期',width : 30,	dataIndex : 'handleDate',renderer: goDateFormat,sortable : true}, 
	{header : '录档日期',width : 30,dataIndex : 'pigeTime',renderer: goDateFormat,sortable : true}, 
	{header : '档案类型',width : 30,dataIndex : 'ywlx',sortable : true},
	{header : '档案状态',width : 40,dataIndex : 'errorFlag',id : 'errorFlag',renderer : goArcErrorflag,menuDisabled : true},
	{header : '备注',width : 30,dataIndex : 'memo',sortable : true}
	]
);


var dfileArchiveImg = new Ext.Panel({
	title   : '原文',
    region    : 'center',
    margins   : '3 3 3 0', 
    activeTab : 0,
    html: '<OBJECT classid="clsid:B4E2D33E-D8B2-4956-9F91-1C6BDC87A6D1"  width=100%  height=100% align=center hspace=0 vspace=0 id="scanner993"  name="scanner993" >'
	       +'<param name="ShowCount" value="8">'
	       +'<param name="sModel" value="1">'
	       +'</OBJECT>'
    
});


	
    
//Panel for the west
var  dfileArchiveView= new Ext.Panel({
    title       : '基本信息',
    region      : 'west',
    split       : true,
    width       : 530,
    collapsible : true,
    margins     : '3 0 3 3',
    cmargins    : '3 3 3 3',
    autoScroll : true,
    items : [dfileQueryArchiveEditForm]
}); 


var window_edit_dfileQueryArchive = new Ext.Window({
	title : '档案查看',
	iconCls : 'icon-veiw',
	width : 1000,
	height : 600,
	resizable : true,
	modal : true,
	plain    : true,
	layout   : 'border',
	closeAction : 'hide',
	maximizable:true,
	items : [dfileArchiveView,dfileArchiveImg],
	buttons : [{
		text : '驳回问题库',
		iconCls : 'icon-put',
		handler : function(btn){
			var record=grid_dfileQueryArchive.getSelectionModel().getSelected();
			if (record) {
				Ext.Msg.confirm('操作提示','确认此机构档案“驳回问题库”?',function(btn){
					if('yes' == btn){
						ajaxLoadMask.show();
						var strOrgid=record.data.orgid;
						Ext.Ajax.request({
							url: 'updateArchiveNO.action',
			   				params: { orgid: strOrgid},
			   				success: function(response){
			   					ajaxLoadMask.hide();
			   					Ext.Msg.show({
									title : '提示',
									msg : '机构档案“驳回问题库”操作成功!',
									buttons : Ext.Msg.OK,
									icon : Ext.Msg.INFO,
									fn : function(){
										grid_dfileQueryArchive.getStore().remove(record);
									}
								});
			   				},
			   				failure: function(){
			   					ajaxLoadMask.hide();
			   					Ext.Msg.show({
									title : '提示',
									msg : '机构档案“驳回问题库”操作失败!',
									buttons : Ext.Msg.OK,
									icon : Ext.Msg.ERROR
								});
			   				}
						});
					}
				});
			}else{
				alert('请选择需驳回问题库的机构档案！');
			}
		}
	},{   
        text: '前一条',   
        handler: function() {
			//前一条
			var grid_ = grid_dfileQueryArchive;
            var selModel = grid_.getSelectionModel();
            if(selModel.hasPrevious()){
                selModel.selectPrevious();
         		var record = grid_dfileQueryArchive.getSelectionModel().getSelected();
         		if(record){
         			dfileQueryArchiveEditForm.getForm().loadRecord(record);
         			scanner993.ImageData="";
         			scanner993.pageType="";
	
		    		Ext.Ajax.request({
						url : 'dfileViewImg.action',
						params : {orgid : record.data.orgid,d_flag:record.data.d_flag},
						success : function(result,request) {//获取返回值
							var resultObject90 = Ext.util.JSON.decode(result.responseText);
							if(resultObject90.imageData!=null && resultObject90.imageData!=""){
								scanner993.OpenProgress(3);  //设置上传的进度条的总进度数
								scanner993.Progress('原文加载中',1);
								scanner993.Progress('原文加载中',2);
			   					scanner993.ImageData=resultObject90.imageData;
								if(scanner993.ImageData!="" && resultObject90.pageTypeStr!=null){
									scanner993.PageType=resultObject90.pageTypeStr;
									scanner993.Progress('原文加载完毕',3);
								}else{
									scanner993.Progress('原文加载失败',3);
			   						alert("原文错误，加载失败，请重新扫描或导入！");
								}
								scanner993.CloseProgress();
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
        	 var grid_ = grid_dfileQueryArchive;
             var selModel = grid_.getSelectionModel();
             if(selModel.hasNext()){
                selModel.selectNext();
         		var record = grid_dfileQueryArchive.getSelectionModel().getSelected();
         		if(record){
         			dfileQueryArchiveEditForm.getForm().loadRecord(record);
         			scanner993.ImageData="";
	    			scanner993.pageType="";
	
		    		Ext.Ajax.request({
						url : 'dfileViewImg.action',
						params : {orgid : record.data.orgid,d_flag:record.data.d_flag},
						success : function(result,request) {//获取返回值
							var resultObject90 = Ext.util.JSON.decode(result.responseText);
							if(resultObject90.imageData!=null && resultObject90.imageData!=""){
								scanner993.OpenProgress(3);  //设置上传的进度条的总进度数
								scanner993.Progress('原文加载中',1);
								scanner993.Progress('原文加载中',2);
			   					scanner993.ImageData=resultObject90.imageData;
								if(scanner993.ImageData!="" && resultObject90.pageTypeStr!=null){
									scanner993.PageType=resultObject90.pageTypeStr;
									scanner993.Progress('原文加载完毕',3);
								}else{
									scanner993.Progress('原文加载失败',3);
			   						alert("原文错误，加载失败，请重新扫描或导入！");
								}
								scanner993.CloseProgress();
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
        	window_edit_dfileQueryArchive.hide(); 
        }   
    }],
	listeners : {
		'activate' : function() {  //激活后自动加载数据
			var record = grid_dfileQueryArchive.getSelectionModel().getSelected();
        	if(record){
        		scanner993.ImageData="";
    			scanner993.pageTypeStr="";

	    		Ext.Ajax.request({
					url : 'dfileViewImg.action',
					params : {orgid : record.data.orgid,d_flag:record.data.d_flag},
					success : function(result,request) {//获取返回值
						var resultObject90 = Ext.util.JSON.decode(result.responseText);
						if(resultObject90.imageData!=null && resultObject90.imageData!=""){
							scanner993.OpenProgress(3);  //设置上传的进度条的总进度数
							scanner993.Progress('原文加载中',1);
							scanner993.Progress('原文加载中',2);
		   					scanner993.ImageData=resultObject90.imageData;
							if(scanner993.ImageData!="" && resultObject90.pageTypeStr!=null){
								scanner993.PageType=resultObject90.pageTypeStr;
								scanner993.Progress('原文加载完毕',3);
							}else{
								scanner993.Progress('原文加载失败',3);
		   						alert("原文错误，加载失败，请重新扫描或标识！");
							}
							scanner993.CloseProgress();
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

var btn_refresh_registerQuery = new Ext.Button({
	text : '刷新',
	iconCls : 'icon-refresh',
	handler : function() {
		textSearchDfileArchiveQuery.value='';
		searchDfileArchiveQuery();
		//btn_edit_dfileQueryArchive.setDisabled(true);
	}
});


var btn_view_dfileQueryArchive = new Ext.Button({
	text : '查看',
	iconCls : 'icon-veiw',
	handler : function(){
		var record = grid_dfileQueryArchive.getSelectionModel().getSelected();
		if(record){
			window_edit_dfileQueryArchive.show();
			dfileQueryArchiveEditForm.getForm().loadRecord(record);
		}
	}
})


var btn_query_dfileQueryArchive = new Ext.Button({
	text : '高级查询',
	iconCls : 'icon-search2',
	handler : function(){
		window_dfileQueryArchive.show();
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
				id : 'ARCTYPE_QUERY2',
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
				editable : false}]
		}]
	}],
	buttonAlign : 'center',
	minButtonWidth : 60,
	buttons : [{
		text:'查询',
		handler : function(){
			if(this.ownerCt.getForm().isValid()){
				ds_dfileQueryArchive.proxy = new Ext.data.HttpProxy({url:'findArchiveGjQuery.action'});
				ds_dfileQueryArchive.baseParams.jgmc=gaojiQueryForm.getForm().findField('jgmc').getValue();
				ds_dfileQueryArchive.baseParams.jgdm=gaojiQueryForm.getForm().findField('jgdm').getValue();
				if(gaojiQueryForm.getForm().findField('NEWDATE1').getValue()!=""){
					//alert("1");
					ds_dfileQueryArchive.baseParams.snewdate=gaojiQueryForm.getForm().findField('NEWDATE1').getValue().format('Y-m-d');
					//alert("11");
				}
				if(gaojiQueryForm.getForm().findField('NEWDATE2').getValue()!="" ){
					//alert("2");
					ds_dfileQueryArchive.baseParams.enewdate=gaojiQueryForm.getForm().findField('NEWDATE2').getValue().format('Y-m-d');
					//alert("22");
				}
				if(gaojiQueryForm.getForm().findField('MODIFYDATE1').getValue()!="" ){
					//alert("3");
					ds_dfileQueryArchive.baseParams.smodifydate=gaojiQueryForm.getForm().findField('MODIFYDATE1').getValue().format('Y-m-d');
					//alert("33");
				}
				if(gaojiQueryForm.getForm().findField('MODIFYDATE2').getValue()!=""){
					ds_dfileQueryArchive.baseParams.emodifydate=gaojiQueryForm.getForm().findField('MODIFYDATE2').getValue().format('Y-m-d');
					//alert("4");
				}
			
				ds_dfileQueryArchive.baseParams.arctype=gaojiQueryForm.getForm().findField('ARCTYPE').getValue();
				ds_dfileQueryArchive.baseParams.bzjgdm=gaojiQueryForm.getForm().findField('bzjgdm').getValue();
				ds_dfileQueryArchive.baseParams.dflagConditions='0';
				ds_dfileQueryArchive.baseParams.conditions ='';
				ds_dfileQueryArchive.baseParams.username='';
				ds_dfileQueryArchive.baseParams.stateConditions='';
				ds_dfileQueryArchive.load({params : {start : 0,limit : useFullPageSize}});	
			}
		}
	},{
		text : '重置',
		handler:function(){
			gaojiQueryForm.getForm().reset();
		}
	},{
		text : '关闭',
		handler:function(){
			gaojiQueryForm.getForm().reset();
			this.ownerCt.ownerCt.hide();
		}
	}]
});

var window_dfileQueryArchive = new Ext.Window({
	title : '高级查询',
	iconCls : 'icon-search2',
	width : 400,
	resizable : false,
	autoHeight : true,
	modal : true,
	closeAction : 'hide',
	items : [gaojiQueryForm]
});

var btn_no_dfileQueryArchive = new Ext.Button({
	text : '驳回问题库',
	iconCls : 'icon-put',
	//disabled:true,
	handler : function(btn){
		var record=grid_dfileQueryArchive.getSelectionModel().getSelected();
		if (record) {
			Ext.Msg.confirm('操作提示','确认此机构档案“驳回问题库”?',function(btn){
				if('yes' == btn){
					ajaxLoadMask.show();
					var strOrgid=record.data.orgid;
					Ext.Ajax.request({
						url: 'updateArchiveNO.action',
		   				params: { orgid: strOrgid},
		   				success: function(response){
		   					ajaxLoadMask.hide();
		   					Ext.Msg.show({
								title : '提示',
								msg : '机构档案“驳回问题库”操作成功!',
								buttons : Ext.Msg.OK,
								icon : Ext.Msg.INFO,
								fn : function(){
									grid_dfileQueryArchive.getStore().remove(record);
								}
							});
		   				},
		   				failure: function(){
		   					ajaxLoadMask.hide();
		   					Ext.Msg.show({
								title : '提示',
								msg : '机构档案“驳回问题库”操作失败!',
								buttons : Ext.Msg.OK,
								icon : Ext.Msg.ERROR
							});
		   				}
					});
				}
			});
		}else{
			alert('请选择需驳回问题库的机构档案！');
		}
	}
});

var searchDfileArchiveQuery = function() {
	ds_dfileQueryArchive.baseParams.conditions = text_search_dfileQueryArchive.getValue();
	ds_dfileQueryArchive.baseParams.jgmc=null;
	ds_dfileQueryArchive.baseParams.jgdm=null;
	ds_dfileQueryArchive.baseParams.snewdate=null;
	ds_dfileQueryArchive.baseParams.enewdate=null;
	ds_dfileQueryArchive.baseParams.smodifydate=null;
	ds_dfileQueryArchive.baseParams.emodifydate=null;
	ds_dfileQueryArchive.baseParams.arctype=null;
	ds_dfileQueryArchive.baseParams.username='';
	ds_dfileQueryArchive.baseParams.dflagConditions='0';  //查询合格库数据
	ds_dfileQueryArchive.load({params : {start : 0,limit : useFullPageSize}});
}

var ds_dfileQueryArchive = new Ext.data.Store({
	url : 'findArchive.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	  [{name : 'orgid',type : 'int'}, 
	    {name : 'orderid',type : 'string'}, 
	    {name : 'docid',type : 'string'}, 
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


var btn_search_dfileQueryArchive = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : searchDfileArchiveQuery
});

var text_search_dfileQueryArchive = new Ext.form.TextField({
	id : 'textSearchDfileArchiveQueryid',
	name : 'textSearchDfileArchiveQuery',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchDfileArchiveQuery();
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

var grid_dfileQueryArchive = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_dfileQueryArchive,
	ds : ds_dfileQueryArchive,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'jgmc',
	viewConfig : {forceFit : true},
	plugins : expander_dfileQueryArchive,
	tbar : [btn_refresh_registerQuery,btn_view_dfileQueryArchive,btn_query_dfileQueryArchive,'-',btn_no_dfileQueryArchive,'->',text_search_dfileQueryArchive,btn_search_dfileQueryArchive],
	bbar : new Ext.PagingToolbar({
		pageSize : useFullPageSize,
		store : ds_dfileQueryArchive,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有记录"
	}),
	listeners : {
		'rowdblclick':function(grid, rowIndex){			
			var record = grid_dfileQueryArchive.getSelectionModel().getSelected();
			if(record){
				window_edit_dfileQueryArchive.show();
				dfileQueryArchiveEditForm.getForm().loadRecord(record);
			}
			
		}
	}
});



var zzDfileQueryArchive_panel = new Ext.Panel({
	title : '合格库管理',
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
	    items : [grid_dfileQueryArchive]
	}]
});

var p_zzDfileQueryArchive = {
	id : 'zzDfileQueryArchive-panel',
	border : false,
	layout : 'border',
	items : [zzDfileQueryArchive_panel]
}
