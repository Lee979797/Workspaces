
var btn_save_LeafHelp = new Ext.Button({
	text : '保存数据',
	iconCls : 'icon-save',
	handler : function() {
		if(leafHelpFormPanel.getForm().isValid()){
			//alert(leafHelpFormPanel.getForm().findField('content').getValue());
			leafHelpFormPanel.getForm().submit({
				waitMsg : '正在保存......',
				method : 'POST',
				success: function(result,request){
					alert("帮助信息设置成功");
				},
				failure: function(){
					alert("设置失败");
				}
			});
		}else{
			alert("请确认填入信息准确性！");
		}
	}
});

var exampleData = [['1','一号节点'],['2','二号节点'],['3','三号节点']];
var estore = new Ext.data.SimpleStore({
	fields: ['id', 'mc'],
    data : exampleData
});

var leafHelpFormPanel = new Ext.FormPanel({
	//title : "文件上传",
	url:'saveLeafHelp.action',
	labelWidth : 70,
	labelAlign : 'right',
	border : false,
	bodyStyle: 'padding:30px 10px 0 10px',
	frame : false,
	items : [{
		xtype : "textfield",
		name : "title",
		allowBlank:false,
		fieldLabel : "标题",
		anchor : "98%"
	}, {
		xtype : "combo",
		name : "leafId",
		allowBlank:false,
		valueField: 'id',
		displayField:'mc',
		store: estore,
		mode: 'local',
		triggerAction: 'all',
		fieldLabel : "栏目",
		id : 'leaf1',
		hiddenName : 'leafId',
		lazyRender:true,
		selectOnFocus : true,
		editable : false,
		anchor : "98%"
	}, {
		xtype : "textfield",
		name : "keyWs",
		allowBlank:false,
		fieldLabel : "关键字",
		anchor : "98%"
	}, {
		xtype : "StarHtmleditor",
		name : "content",
		allowBlank:false,
		fieldLabel : "内容",
		anchor : "97.8%"
	}]
});

var p_zzLeafHelp = {
	id : 'zzLeafHelp-panel',
	border : false,
	layout : 'border',
	items : [{
		id: 'help-panel',
		region :'center',
	    title : '帮助设置',
	    bodyStyle : 'padding:0px',
	    margins : '0 0 0 0',
	    cmargins : '5 5 0 0',
		layout: 'fit',
	    autoScroll : true,
	    tbar : [btn_save_LeafHelp],
	    items : [leafHelpFormPanel]
	}]
}