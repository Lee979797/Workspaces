var smic = new Ext.grid.CheckboxSelectionModel();
var ds_icprintlog =  new Ext.data.Store({
	url : 'findAllIcPrintLog.action',
	sortInfo : {field: 'printTime', direction: 'DESC'},
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'klsh',type : 'int'},  
		{name : 'orgName',type : 'string'}, 
		{name : 'orgCode',type : 'string'}, 
		{name : 'centerid',type : 'string'}, 
		{name : 'orderId',type : 'string'},
		{name : 'printTime'},
		{name : 'ickxlh',type : 'string'},
		{name : 'printerName',type : 'string'},
		{name : 'note',type : 'string'}]
	)
});
var searchIcPrintLog = function(){
	ds_icprintlog.baseParams.conditions = text_search_IcPrintLog.getValue();
	ds_icprintlog.load({params : {start : 0,limit : useFullPageSize} });
}
var btn_search_IcPrintLog = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchIcPrintLog();
	}
});
var btn_loss_IcPrintLog = new Ext.Button({
	text : '挂失',
	iconCls : 'icon-store',
	handler : function() {
		var record = icPrintLogPanel.getSelectionModel().getSelected();
		if(record){
			var kxlh = record.data.ickxlh;
			Ext.Ajax.request({
				url: 'lossOrRecoverIC.action',
				params: {ickxlh: kxlh,flag: 0},
				success: function(result,response){
					eval("var data="+result.responseText);
					if(data.success){
						alert("成功挂失，序列号为 [ "+kxlh+" ] 的IC卡将不可用！");
					}
				},
				failure: function(){
					alert("挂失IC卡失败，请重新进行操作！");
				}
				
			});
		}else{
			alert("没有要挂失的信息，请先选择！");
		}
	}
});
var btn_recover_IcPrintLog = new Ext.Button({
	text : '取消挂失',
	iconCls : 'icon-store',
	handler : function() {
		var record = icPrintLogPanel.getSelectionModel().getSelected();
		if(record){
			var kxlh = record.data.ickxlh;
			Ext.Ajax.request({
				url: 'lossOrRecoverIC.action',
				params: {ickxlh: kxlh,flag: 1},
				success: function(result,response){
					eval("var data="+result.responseText);
					if(data.success){
						alert("取消挂失，序列号为 [ "+kxlh+" ] 的IC卡变为可用！");
					}
				},
				failure: function(){
					alert("取消挂失IC卡失败，请重新进行操作！");
				}
				
			});
		}else{
			alert("没有要取消挂失的信息，请先选择！");
		}
	}
});
var text_search_IcPrintLog = new Ext.form.TextField({
	id:'textSearchIcPrintLog',
	name : 'textSearchIcPrintLog',
	width : 200,
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchIcPrintLog();
			}
		}
	}
});

var zzCardPrintLog_Panel = new Ext.grid.GridPanel({
	loadMask : {msg : '数据加载中...'},
	region:'center',
	cm : new Ext.grid.ColumnModel([smic,
	   	{header : 'IC序列号',width : 130,	dataIndex : 'ickxlh',sortable : true}, 
		{header : '机构名称',	width : 120,dataIndex : 'orgName',id : 'orgNamePrintLog',sortable : true}, 
		{header : '机构代码',	width : 90,	dataIndex : 'orgCode',sortable : true},
		{header : '打印时间',width : 100,	dataIndex : 'printTime',renderer: dateFormatShzt,sortable : true}, 
		{header : '打印人',	width : 100,dataIndex : 'printerName',menuDisabled : true},
		{header : '备注',	width : 100,dataIndex : 'note',sortable : true}]
	),
	viewConfig : {forceFit : true},
	autoExpandColumn : 'orgNamePrintLog',
	ds : ds_icprintlog,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	tbar : [btn_loss_IcPrintLog,btn_recover_IcPrintLog,'->',text_search_IcPrintLog,btn_search_IcPrintLog],
	bbar : new Ext.PagingToolbar({
		pageSize : useFullPageSize,
		store : ds_icprintlog,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有新办申请记录"}
	)
});

//--------------------机构基本信息-------------------------------------------

var p_zzCardPrintLog = {
	id : 'zzCardPrintLog-panel',
	border : false,
	layout : 'border',
	items : [{
		title : 'IC卡查询',
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
		    items : [zzCardPrintLog_Panel]
		}]
	}]
}