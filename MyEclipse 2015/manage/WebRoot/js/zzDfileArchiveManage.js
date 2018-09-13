
var arctypeStr3 = [['1','新办'],['2','年检'],['3','迁出'],['4','迁入'],['5','变更'],['6','换证'],['7','补证'],['8','注销'],['9','其他'],['10','预赋码']]; 
var arctypeStore3 = new Ext.data.SimpleStore({fields:['arctypeCode','arctypeValue'],data:arctypeStr3});

//点击列表信息，显示图书的扩展属性//
var expander_dfileArchiveManage = new Ext.grid.RowExpander({
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

//var hobbys = new Array();  //定义一个数组

//--------------------修改临时库机构档案信息-------------------------------------------
var dfileArchiveManageEditForm = new Ext.FormPanel({
	loadMask : {
		msg : '数据加载中...'
	},
	url : 'updateDfile.action',
	labelAlign : 'right',
	labelWidth : 95,
	bodyStyle : 'padding:5px',
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
	                items: [{ xtype:'textfield',fieldLabel : '机构名称',readOnly:true,name : 'jgmc',allowBlank : false,anchor:'100%'}]
				},{
	                columnWidth:.5,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [
	                	{xtype:'textfield',fieldLabel : '机构代码',name : 'jgdm',readOnly:true,anchor:'100%'},
	                	{xtype:'textfield',fieldLabel : '证件类型',name : 'zjlx',readOnly:true,anchor:'100%'}
	                ]
				},{
	                columnWidth:.5,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [
                		{xtype:'textfield',fieldLabel : '法定代表',name : 'fddbr',readOnly:true,anchor:'100%'},
                		{xtype:'textfield',fieldLabel : '证件号码',name : 'zjhm',readOnly:true,anchor:'100%'}
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
						{xtype:'textfield',fieldLabel : '迁入地址',id:'moveoutAddrss_dfileManage',name : 'moveoutAddrss',maxLength : 100,readOnly:true,anchor:'100%'},
						{xtype:'textfield',fieldLabel : '迁址原因',id:'moveoutReason_dfileManage',name : 'moveoutReason',maxLength : 250,readOnly:true,anchor:'100%'},
						{xtype:'textfield',fieldLabel : '批注注销机构',id:'offPzjgmc_dfileManage',name : 'offPzjgmc',maxLength : 100,readOnly:true,anchor:'100%'},
						{xtype:'textfield',fieldLabel : '批准注销文号',id:'offPzwh_dfileManage',name : 'offPzwh',maxLength : 50,readOnly:true,anchor:'100%'},
						{xtype:'textfield',fieldLabel : '注销原因',id:'offReason_dfileManage',name : 'offReason',maxLength:250,readOnly:true,anchor:'100%'},
						{xtype:'textfield',fieldLabel : '证书回收情况',id:'offNote_dfileManage',name : 'offNote',height:80,maxLength:250,anchor:'100%'}*/
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
						{id:"select_jglxdm_dfileManage",xtype : 'hidden',name : 'jglxdm'},
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
						{id:"select_jjhydm_dfileManage",xtype : 'hidden',name : 'jjhydm'},
						{xtype : 'hidden',name : 'd_flag'},
						{xtype : 'hidden',name : 'docid'},
						{xtype:'textfield',fieldLabel : '机构类型',name : 'jglx',readOnly:true,anchor:'100%'},
						{xtype:'textfield',fieldLabel : '备注',name : 'memo',anchor:'100%'}
						/*{xtype:'textfield',fieldLabel : '迁入地址',id:'moveoutAddrss_dfileManage',name : 'moveoutAddrss',maxLength : 100,readOnly:true,anchor:'100%'},
						{xtype:'textfield',fieldLabel : '迁址原因',id:'moveoutReason_dfileManage',name : 'moveoutReason',maxLength : 250,readOnly:true,anchor:'100%'},
						{xtype:'textfield',fieldLabel : '批注注销机构',id:'offPzjgmc_dfileManage',name : 'offPzjgmc',maxLength : 100,readOnly:true,anchor:'100%'},
						{xtype:'textfield',fieldLabel : '批准注销文号',id:'offPzwh_dfileManage',name : 'offPzwh',maxLength : 50,readOnly:true,anchor:'100%'},
						{xtype:'textfield',fieldLabel : '注销原因',id:'offReason_dfileManage',name : 'offReason',maxLength:250,readOnly:true,anchor:'100%'},
						{xtype:'textfield',fieldLabel : '证书回收情况',id:'offNote_dfileManage',name : 'offNote',height:80,maxLength:250,anchor:'100%'}*/
                	]
				},{	columnWidth:1,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [{
				        xtype: 'checkboxgroup',
				        fieldLabel: '问题类型',
				        columns: 2,
				        items: [
				            {boxLabel: '图像不清晰', name: 'errorFlag',inputValue:'1'},
				            {boxLabel: '图像黑边、倾斜', name: 'errorFlag',inputValue:'2'},
				            {boxLabel: '图像混扫', name: 'errorFlag',inputValue:'3'},
				            {boxLabel: '图像残缺', name: 'errorFlag',inputValue:'4'},
				            {boxLabel: '建档日期错误', name: 'errorFlag',inputValue:'5'},
				            
				            {boxLabel: '档案分类错误', name: 'errorFlag',inputValue:'6'},
				            {boxLabel: '申请表标识问题', name: 'errorFlag',inputValue:'7'},
				            {boxLabel: '批准证书标识问题', name: 'errorFlag',inputValue:'8'},
				            {boxLabel: '身份证明文件标识问题', name: 'errorFlag',inputValue:'9'},
				            {boxLabel: '其他文件标示问题', name: 'errorFlag',inputValue:'10'},
				
				            {boxLabel: '其他问题', name: 'errorFlag',inputValue:'11'},
				            {boxLabel: '批准文件不合格', name: 'errorFlag',inputValue:'12'},
				            {boxLabel: '缺页问题', name: 'errorFlag',inputValue:'13'},
				            {boxLabel: '批量问题', name: 'errorFlag',inputValue:'20'},
				            {boxLabel: '多个问题', name: 'errorFlag',inputValue:'21'},
				            {boxLabel: '年检执照问题', name: 'errorFlag',inputValue:'22'}
				        ]
				    }]
				}]
		}]
});

var sm2345 = new Ext.grid.CheckboxSelectionModel();
//列表显示图书主要信息//
var cm_dfileArchiveManage = new Ext.grid.ColumnModel([expander_dfileArchiveManage,
    sm2345,
    {header : '原文',width : 15,dataIndex : 'imageUrl', renderer:icon_dam,sortable : false},
    {header : '档案ID',	width : 80,dataIndex : 'docid',sortable : true}, 
	{header : '机构代码',width : 40,dataIndex : 'jgdm',	sortable : true}, 
	{header : '机构名称',width : 120,dataIndex : 'jgmc',sortable : true}, 
	{header : '办证机构代码',width : 40,dataIndex : 'bzjgdm',sortable : true},
	{header : '建档日期',width : 30,	dataIndex : 'handleDate',renderer: goDateFormat,sortable : true}, 
	{header : '录档日期',width : 30,dataIndex : 'pigeTime',renderer: goDateFormat,sortable : true}, 
	{header : '档案类型',width : 30,dataIndex : 'ywlx',sortable : true},
	{header : '备注',width : 30,dataIndex : 'memo',sortable : true}
	]
);





var dfileArchiveImg = new Ext.Panel({
	title   : '原文浏览',
    region    : 'center',
    margins   : '3 3 3 0', 
    activeTab : 0,
    html: '<OBJECT classid="clsid:B4E2D33E-D8B2-4956-9F91-1C6BDC87A6D1"  width=100%  height=100% align=center hspace=0 vspace=0 id="scanner992"  name="scanner992" >'
	       +'<param name="ShowCount" value="8">'
	       +'<param name="sModel" value="1">'
	       +'</OBJECT>'
    
});

//Panel for the west
var  dfileArchiveView= new Ext.Panel({
    title       : '基本信息2',
    region      : 'west',
    split       : true,
    width       : 530,
    collapsible : true,
    margins     : '3 0 3 3',
    cmargins    : '3 3 3 3',
	autoScroll : true,
	layout: 'fit',
    items : [dfileArchiveManageEditForm]
}); 

var window_edit_dfileArchiveManage = new Ext.Window({
	title : '数据审核',
	width : 1200,
	height : 600,
	resizable : true,
	//autoHeight : true,
	modal : true,
	plain    : true,
	layout   : 'border',
	closeAction : 'hide',
	maximizable:true,
	items : [dfileArchiveView,dfileArchiveImg],
	buttons : [{
		text : '审核确认',
		handler : function(btn){
                                
			if (dfileArchiveManageEditForm.getForm().isValid()) {
					btn.disable();
					dfileArchiveManageEditForm.getForm().submit({
					waitTitle : '请稍候',
					waitMsg : '正在修改数据,请稍候...',
					success : function(form) {
							btn.enable();
							dfileArchiveManageEditForm.getForm().reset();
			         		scanner992.ImageData="";
		   					scanner992.PageType="";
							var record = grid_dfileArchiveManage.getSelectionModel().getSelected();
			         		if(record){
								grid_dfileArchiveManage.getStore().remove(record);
			         		}
			         		
			         		//自动加载下一条开始：
			         		var grid_ = grid_dfileArchiveManage;
							var selModel = grid_.getSelectionModel();
							//alert(selModel.hasSelection());
							if(selModel.hasSelection()){
							    //selModel.selectNext();
							    //grid_dfileArchiveManage.getSelectionModel().selectNext();
								var record = grid_dfileArchiveManage.getSelectionModel().getSelected();
								if(record){
										//加载数据
					         			dfileArchiveManageEditForm.getForm().loadRecord(record);
						        		scanner992.ImageData="";
						    			scanner992.pageType="";
						    			var resultObject90 = null;
						    			Ext.Ajax.request({
											url : 'dfileViewImg.action',
											params : {orgid : record.data.orgid,d_flag:record.data.d_flag},
											success : function(result,request) {//获取返回值
												var resultObject90 = Ext.util.JSON.decode(result.responseText);
												if(resultObject90.imageData!=null && resultObject90.imageData!=""){
													scanner992.OpenProgress(3);  //设置上传的进度条的总进度数
													scanner992.Progress('原文加载中',1);
													scanner992.Progress('原文加载中',2);
								   					scanner992.ImageData=resultObject90.imageData;
							   						if(scanner992.ImageData!="" && resultObject90.pageTypeStr!=null){
							   							scanner992.PageType=resultObject90.pageTypeStr;
							   							scanner992.Progress('原文加载完毕',3);
							   						}else{
							   							scanner992.Progress('原文加载失败',3);
								   						alert("原文错误，加载失败，请重新扫描或导入！");
							   						}
							   						scanner992.CloseProgress();
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
			         		
			         		
			         		//自动加载下一条结束。
							return true;
					},
					failure : function(form) {
						Ext.Msg.show({
							title : '提示',
							msg : '保存失败',
							buttons : Ext.Msg.OK,
							fn : function() {btn.enable();},
							icon : Ext.Msg.ERROR
						});
					}
				});
			}
		}
	},{   
        text: '前一条',   
        handler: function(btn) {
    			//前一条
				var grid_ = grid_dfileArchiveManage;
	            var selModel = grid_.getSelectionModel();
	            if(selModel.hasPrevious()){
	                selModel.selectPrevious();
	         		var record = grid_dfileArchiveManage.getSelectionModel().getSelected();
	         		if(record){
	         			//加载数据
	         			dfileArchiveManageEditForm.getForm().loadRecord(record);
		        		scanner992.ImageData="";
		    			scanner992.pageType="";
		    			var resultObject90 = null;
		    			Ext.Ajax.request({
							url : 'dfileViewImg.action',
							params : {orgid : record.data.orgid,d_flag:record.data.d_flag},
							success : function(result,request) {//获取返回值
								var resultObject90 = Ext.util.JSON.decode(result.responseText);
								if(resultObject90.imageData!=null && resultObject90.imageData!=""){
									scanner992.OpenProgress(3);  //设置上传的进度条的总进度数
									scanner992.Progress('原文加载中',1);
									scanner992.Progress('原文加载中',2);
				   					scanner992.ImageData=resultObject90.imageData;
			   						if(scanner992.ImageData!="" && resultObject90.pageTypeStr!=null){
			   							scanner992.PageType=resultObject90.pageTypeStr;
			   							scanner992.Progress('原文加载完毕',3);
			   						}else{
			   							scanner992.Progress('原文加载失败',3);
				   						alert("原文错误，加载失败，请重新扫描或导入！");
			   						}
			   						scanner992.CloseProgress();
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
        handler: function(btn) {
        	
				var grid_ = grid_dfileArchiveManage;
				var selModel = grid_.getSelectionModel();
				if(selModel.hasNext()){
				    selModel.selectNext();
				    //grid_dfileArchiveManage.getSelectionModel().selectNext();
					var record = grid_dfileArchiveManage.getSelectionModel().getSelected();
					if(record){
							//加载数据
		         			dfileArchiveManageEditForm.getForm().loadRecord(record);
			        		scanner992.ImageData="";
			    			scanner992.pageType="";
			    			var resultObject90 = null;
			    			Ext.Ajax.request({
								url : 'dfileViewImg.action',
								params : {orgid : record.data.orgid,d_flag:record.data.d_flag},
								success : function(result,request) {//获取返回值
									var resultObject90 = Ext.util.JSON.decode(result.responseText);
									if(resultObject90.imageData!=null && resultObject90.imageData!=""){
										scanner992.OpenProgress(3);  //设置上传的进度条的总进度数
										scanner992.Progress('原文加载中',1);
										scanner992.Progress('原文加载中',2);
					   					scanner992.ImageData=resultObject90.imageData;
				   						if(scanner992.ImageData!="" && resultObject90.pageTypeStr!=null){
				   							scanner992.PageType=resultObject90.pageTypeStr;
				   							scanner992.Progress('原文加载完毕',3);
				   						}else{
				   							scanner992.Progress('原文加载失败',3);
					   						alert("原文错误，加载失败，请重新扫描或导入！");
				   						}
				   						scanner992.CloseProgress();
									}
								},
								failure : function() {
									alert("图像加载错误");
								}
							});
							btn.enable();
						}
					 }else{
					     alert("已经到最后一条,请翻页");
					 }
			}  
    },{   
        text: '退出',   
        handler: function() {
        	window_edit_dfileArchiveManage.hide();
        }   
    },{
    	text: '原文重载',   
        handler: function() {  
        	var record = grid_dfileArchiveManage.getSelectionModel().getSelected();
        	if(record){
        		scanner992.ImageData="";
    			scanner992.pageType="";
    			Ext.Ajax.request({
					url : 'dfileViewImg.action',
					params : {orgid : record.data.orgid,d_flag:record.data.d_flag},
					success : function(result,request) {//获取返回值
						var resultObject91 = Ext.util.JSON.decode(result.responseText);
						if(resultObject91.imageData!=null && resultObject91.imageData!=""){
							scanner992.OpenProgress(3);  //设置上传的进度条的总进度数
							scanner992.Progress('原文加载中',1);
							scanner992.Progress('原文加载中',2);
		   					scanner992.ImageData=resultObject91.imageData;
	   						if(scanner992.ImageData!="" && resultObject91.pageTypeStr!=null){
	   							scanner992.PageType=resultObject91.pageTypeStr;
	   							scanner992.Progress('原文加载完毕',3);
	   						}else{
	   							scanner992.Progress('原文加载失败',3);
		   						alert("原文错误，加载失败，请重新扫描或导入！");
	   						}
	   						scanner992.CloseProgress();
						}
					},
					failure : function() {
						alert("图像加载错误");
					}
				});
        	}
        }   	
    },{   
        text: '保存档案',   
        handler: function() {   
        	
			//数据保存成功后，再自动保存原文
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
			
			var record = grid_dfileArchiveManage.getSelectionModel().getSelected();
			strOrgid = record.data.orgid;  //参数orgid
			strDocid =record.data.docid;  //参数docid
			strBzjgdm = record.data.bzjgdm;
		
			packLength = 40960;	//定义每个包的大小40960
			base64file = scanner992.ImageData;  //获取控件扫描的图片数据
			var baseSize = base64file.length;  //获取控件图片数据的64位编码的长度
			imageCount = scanner992.GetPageCount;	//获取扫描图片的页数
			pageTypeStr = scanner992.PageType;    //获取标识字符串,需要写数据库
			if(pageTypeStr!=""){
				pageTypeStr=pageTypeStr.replace(/\%/g, "|"); 
			}
			packCount = Math.ceil(baseSize / packLength);	//判断需要发送数据包的个数
			if(imageCount==0 || base64file=="")   //判断如果没有扫描数据，结束处理
			{
				alert("请扫描或导入图片后，再上传！");
				return false;
			}
			if (pageTypeStr.indexOf('未标识')!=-1){ //判断如果没有标识，则不允许上传
				alert("请进行电子原文标识后，再保存！");
				return false;
			}
			scanner992.OpenProgress(packCount);  //设置上传的进度条的总进度数
			xmlhttp = GetXmlHttp(); //通过AJAX格式上传
			for(var i=0; i < packCount; i++)  //分包上传
			{
				if(i==packCount-1){
					lastpack="true";
				}else{
					lastpack="false";
				}				
				pack = base64file.substring(i * packLength, (i + 1) * packLength);  //每个数据包的文件大小
				try
				{
					xmlhttp.open("post", "saveImageDfile.action?orgid="+strOrgid+"&docid="+strDocid+"&packindex="+i+"&pageTypeStr="+pageTypeStr+"&bzjgdm="+strBzjgdm+"&lastpack="+lastpack, false);
					xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   //这句必须要，而且一定要放在send以前
					xmlhttp.send("imageData=" + encodeURIComponent(pack)); 
					var objs = eval("["+xmlhttp.responseText+"]");
					if(objs[0].success)
					{
						scanner992.Progress('上传中',i+1);
					}
					else
					{
						alert("上传失败，请重试0001。");
						return false;
					}
				}
				catch(e)
				{
					alert("上传失败，请重试0002。");
					return false;
				}
			}
			Ext.Msg.show({
				title : '提示',
				msg : '保存成功！',
				buttons : Ext.Msg.OK,
				icon : Ext.Msg.INFO
			});	
			scanner992.CloseProgress();
        }   
    }],
	listeners : {
		'activate' : function() {  //激活后自动加载数据	
			var record = grid_dfileArchiveManage.getSelectionModel().getSelected();
			if(record){
				scanner992.ImageData="";
    			scanner992.pageType="";
    			dfileArchiveManageEditForm.getForm().reset();
				dfileArchiveManageEditForm.getForm().loadRecord(record);
	    		Ext.Ajax.request({
					url : 'dfileViewImg.action',
					params : {orgid : record.data.orgid,d_flag:record.data.d_flag},
					success : function(result,request) {//获取返回值
						var resultObject = Ext.util.JSON.decode(result.responseText);
						if(resultObject.imageData!=null && resultObject.imageData!=""){
							scanner992.OpenProgress(3);  //设置上传的进度条的总进度数
							scanner992.Progress('原文加载中',1);
							scanner992.Progress('原文加载中',2);
		   					scanner992.ImageData=resultObject.imageData;
	   						if(scanner992.ImageData!="" && resultObject.pageTypeStr!=null){
	   							scanner992.PageType=resultObject.pageTypeStr;
	   							scanner992.Progress('原文加载完毕',3);
	   						}else{
	   							scanner992.Progress('原文加载失败',3);
		   						alert("原文错误，加载失败，请重新扫描和标识！");
	   						}
	   						scanner992.CloseProgress();
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

var btn_refresh_registerManage = new Ext.Button({
	text : '刷新',
	iconCls : 'icon-refresh',
	handler : function() {
		textSearchDfileArchiveManage.value='';
		searchDfileArchiveManage();
		//btn_edit_dfileArchiveManage.setDisabled(true);
	}
});
/*var btn_del_registerManage = new Ext.Button({
	text : '删除',
	iconCls : 'icon-del',
	handler : function() {
		
	}
});*/


var btn_edit_dfileArchiveManage = new Ext.Button({
	text : '数据审核',
	iconCls : 'icon-edit',
	handler : function(){
		var record = grid_dfileArchiveManage.getSelectionModel().getSelections();
		if (typeof(record)!="undefined"){
			var len = record.length;
			if(len==1){
				window_edit_dfileArchiveManage.show();
			}else{
				alert("请选择一条数据！");
			}
		}
	}
})

////???????????????????????????????????/			
var btn_return_dfileArchiveManage_create = new Ext.Button({
	text : '批量审核通过',
	iconCls : 'icon-store',
	handler : function(btn){
		var record=grid_dfileArchiveManage.getSelectionModel().getSelections();
		var Ids = "";
		if (typeof(record)!="undefined"){
			var len = record.length;
			if(len>0){
					for(var i = 0; i < len; i++){
						Ids=Ids+record[i].data.orgid+",";
					}
					ajaxLoadMask.show();
					Ext.Ajax.request({
						url: 'updateDfileOk.action',
		   				params: { orgids: Ids},
		   				success: function(response){
		   					ajaxLoadMask.hide();
		   					Ext.Msg.show({
								title : '提示',
								msg : '“批量审核”操作成功!',
								buttons : Ext.Msg.OK,
								icon : Ext.Msg.INFO,
								fn : function(){
									//更新修改行的值
									for(var j = 0; j < len; j++){
										record[j].set('state','100'); 
										grid_dfileArchiveManage.fireEvent('rowclick',grid_dfileArchiveManage,grid_dfileArchiveManage.getStore().indexOf(record[j]));
										grid_dfileArchiveManage.getStore().remove(record[j]);
									}
									btn.enable();
									searchDfileArchiveManage();
									grid_dfileArchiveManage.unSelectAll();
								}
							});
		   				},
		   				failure: function(){
		   					ajaxLoadMask.hide();
		   					Ext.Msg.show({
								title : '提示',
								msg : '“批量审核”操作失败!',
								buttons : Ext.Msg.OK,
								icon : Ext.Msg.ERROR
							});
		   				}
					});
			}else{
				Ext.Msg.show({
					title : '提示',
					msg : '请选择机构!',
					buttons : Ext.Msg.OK,
					icon : Ext.Msg.ERROR
				});
			}
		}
	}
});


var searchDfileArchiveManage = function() {
	ds_dfileArchiveManage.baseParams.conditions = text_search_dfileArchiveManage.getValue();
	ds_dfileArchiveManage.baseParams.username='';
	ds_dfileArchiveManage.baseParams.stateConditions='';
	ds_dfileArchiveManage.baseParams.dflagConditions='1';//查询临时数据
	ds_dfileArchiveManage.load({params : {start : 0,limit : useFullPageSize}
	});
}

var ds_dfileArchiveManage = new Ext.data.Store({
	url : 'findQxDfile.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'orgid',type : 'int'}, 
	   {name : 'docid',type : 'string'},
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
		{name : 'auditDate',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
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


var btn_search_dfileArchiveManage = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : searchDfileArchiveManage
});

var text_search_dfileArchiveManage = new Ext.form.TextField({
	id : 'textSearchDfileArchiveManageid',
	name : 'textSearchDfileArchiveManage',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchDfileArchiveManage();
			}
		}
	}
});


var grid_dfileArchiveManage = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_dfileArchiveManage,
	ds : ds_dfileArchiveManage,
	//sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	sm : new Ext.grid.CheckboxSelectionModel(),
	autoExpandColumn : 'jgmc',
	viewConfig : {forceFit : true},
	plugins : expander_dfileArchiveManage,
	tbar : [btn_edit_dfileArchiveManage,btn_refresh_registerManage,'-',btn_return_dfileArchiveManage_create,'->',text_search_dfileArchiveManage,btn_search_dfileArchiveManage],
	bbar : new Ext.PagingToolbar({
		pageSize : useFullPageSize,
		store : ds_dfileArchiveManage,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有记录"
	}),
	listeners : {
		'rowdblclick':function(grid, rowIndex){
			//var record = grid_dfileArchiveManage.getSelectionModel().getSelected();
			var record = grid.getStore().getAt(rowIndex);
			if(record){
				window_edit_dfileArchiveManage.show();
				dfileArchiveManageEditForm.getForm().loadRecord(record);
			}
		},
		'rowclick':function(grid,rowIndex){
			btn_edit_dfileArchiveManage.setDisabled(false);
			btn_return_dfileArchiveManage_create.setDisabled(false);
		}
	}
});

var zzDfileArchiveManage_panel = new Ext.Panel({
	title : '临时库管理',
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
	    items : [grid_dfileArchiveManage]
	}]
});

var p_zzDfileArchiveManage = {
	id : 'zzDfileArchiveManage-panel',
	border : false,
	layout : 'border',
	items : [zzDfileArchiveManage_panel]
}
