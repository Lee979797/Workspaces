//------------------------------ 浏览图片窗口 -----------------------------------
var image_window_uln = new Ext.Window({   
    id: 'image-windowyw',   
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
        html: '<OBJECT classid="clsid:B5306E2E-8F98-46CA-9F31-AB326B2613F1"   width=100%  height=100% align=center hspace=0 vspace=0 id="scanner2202"  name="scanner2202">'
 	       +'<param name="ShowCount" value="1">'
 	       +'<param name="sModel" value="1">'
 	       +'</OBJECT>'    
    }],   
    buttons: [{   
	       text: '重载原文',   
	       handler: function() { 
	       	
	       		var resultObject = null;
    			var record = jgBerthYwGridForm.getSelectionModel().getSelected();
    			var strOrgid="";
				if(record){
		    		strOrgid=record.data.orgid
		        	if(strOrgid=="" || strOrgid==null){
		        		strOrgid=currentOrgid; 
		        	}
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
		   					scanner2202.ImageData=resultObject.imageData;
		   					scanner2202.pageTypeStr=resultObject.pageTypeStr;
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
           image_window_uln.hide();   
       }   
   }],   
    listeners: {   
    	'activate' : function() {
    		var resultObject = null;
    		var record = jgBerthYwGridForm.getSelectionModel().getSelected();
    		var strOrgid="";
        	 //当前ORGID同步
	    	if(record){
	    		strOrgid=record.data.orgid
	        	if(strOrgid=="" || strOrgid==null){
	        		strOrgid=currentOrgid; 
	        	}
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
	   					scanner2202.ImageData=resultObject.imageData;
	   					scanner2202.pageTypeStr=resultObject.pageTypeStr;
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
function viewPic_uln(orgName,fileUrl)
{
	image_window_uln.show(); 
	image_window_uln.setTitle('原文浏览-[' + orgName + ']');    
	//scanner2200.ImageData=document.getElementById("sImageData2").value;
}

//---------------------- 列表显示原文的标识 ------------------------------------
function icon_uln(value,p,record){
	if(typeof record=='object'){
		var fileUrl;
		var orgName;
		fileUrl=record.data["imageUrl"];
		orgName=record.data["jgmc"];
		if(fileUrl!=''){
			//alert(fileUrl);
			return String.format('<a style="display:table;width:100%;" onclick=viewPic_uln("'+orgName+'","'+fileUrl+'")><img src="images/file_ico.gif"></a>',record.data["orgid"]);
		}
	}  
}
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

//查询返回结果的数据列
var ds_jgBerthYw = new Ext.data.Store({
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
	])
	
});
var text_search_jgBerthYw = new Ext.form.TextField({
	id:'textsearchjgBerthYw',
	name : 'textsearchjgBerthYw',
	width : 200,
	emptyText : '查询条件机构名称、代码、注册号',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchJgBerthYw();
			}
		}
	}
});
var btn_search_jgBerthYw = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchJgBerthYw();
	}
});
//默认查询 limit为显示的条数
var searchJgBerthYw = function() {
	ds_jgBerthYw.baseParams.conditions = text_search_jgBerthYw.getValue();
	//ds_jgBerthYw.baseParams.userid=currentUserid;
	ds_jgBerthYw.baseParams.username=currentUsername;
	ds_jgBerthYw.baseParams.stateConditions='0,1,2,3,4,5,6';
	ds_jgBerthYw.load({params : {start : 0,limit : 30} });
}

var sm2 = new Ext.grid.CheckboxSelectionModel();
var cm_jgBerthYw = new Ext.grid.ColumnModel([expander,
	sm2,
	{header : '原文',width : 20,dataIndex : 'imageUrl', renderer:icon_uln,sortable : false},
	{header : '流水号',width : 55,dataIndex : 'orderid',sortable : true},
	{header : '机构代码',width : 95,sortable : true,dataIndex : 'jgdm'},
	{header : '机构名称',width : 115,sortable : true,dataIndex : 'jgmc'},
	{header : '注 册 号',width : 115,sortable : true,dataIndex : 'zch'},
	{header : '申请状态',width : 100,dataIndex : 'state',renderer : goState,menuDisabled : true}
]);

//加载右栏主页面   （数据列表、工具栏按钮）
var jgBerthYwGridForm = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_jgBerthYw,
	ds : ds_jgBerthYw,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	viewConfig : {forceFit : true},
	plugins : expander,
	tbar : ['->',text_search_jgBerthYw,btn_search_jgBerthYw],
	bbar : new Ext.PagingToolbar({
		pageSize : 50,
		store : ds_jgBerthYw,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	})
});

var p_JgBerthYw = {
	id : 'useJgBerthYw-panel',
	border : false,
	layout : 'border',
	bodyStyle: 'padding:0px',
	items : [{
		id:'border-panel',
	    layout:'border',
	    title: '用户挂靠机构信息',
	    iconCls : 'icon-plugin',
		region: 'center',
		plain: true,
		baseCls : 'x-plain',
		items: [jgBerthYwGridForm]
	}]
}