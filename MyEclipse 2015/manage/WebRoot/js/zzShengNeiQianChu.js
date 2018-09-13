var btn_search_bzjg_ShengNeiqianchu = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchBzjg_ShengNeiqianchu();
	}
});


var text_search_bzjg_ShengNeiqianchu = new Ext.form.TextField({
	id : 'textSearchBzjg_ShengNeiqianchu',
	name : 'textSearchbzjg_ShengNeiqianchu',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchBzjg_ShengNeiqianchu();
			}
		}
	}
});


var cm_bzjg_ShengNeiqianchu = new Ext.grid.ColumnModel([
	{header : '办证机构名称',width : 50,dataIndex : 'bzjgName',sortable : true}, 
	{header : '办证机构代码',width : 20,dataIndex : 'bzjgCode',sortable : true}
]);


//查询返回结果的数据列
var ds_bzjg_ShengNeiqianchu = new Ext.data.Store({
	url : 'findAllBzjg.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'bzjgId',type : 'int'}, 
		{name : 'bzjgName',type : 'string'},
		{name : 'bzjgCode',type : 'string'}
	])
});

var searchBzjg_ShengNeiqianchu = function() {
	ds_bzjg_ShengNeiqianchu.baseParams.conditions = text_search_bzjg_ShengNeiqianchu.getValue();
	ds_bzjg_ShengNeiqianchu.load({params : {start : 0,limit : 20} });
};

var grid_bzjg_ShengNeiqianchu = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_bzjg_ShengNeiqianchu,
	ds : ds_bzjg_ShengNeiqianchu,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入迁入办证机构名称：',text_search_bzjg_ShengNeiqianchu,btn_search_bzjg_ShengNeiqianchu],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_bzjg_qianchu,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_bzjgQuery_ShengNeiqianchu.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			ShengNeiqianchuViewForm.getForm().findField('bzjg').setValue(selections[0].get('bzjgName')+selections[0].get('bzjgCode'));
			ShengNeiqianchuViewForm.getForm().findField('bzjgmc').setValue(selections[0].get('bzjgName'));
			ShengNeiqianchuViewForm.getForm().findField('bzjgdm').setValue(selections[0].get('bzjgCode'));
		}
	}
});


var window_bzjgQuery_ShengNeiqianchu = new Ext.Window({
	title : '办证机构查询',
	iconCls : 'icon-plugin',
	width :500,
	height:400,
	x:'250',
	y:'170',
	//plain    : true,
	layout   : 'border',
	resizable : false,
	modal : true,
	resizable : true, 
	maximizable:true,
	closeAction : 'hide',
	items : [grid_bzjg_ShengNeiqianchu]
});



//--------------------机构基本信息-------------------------------------------
var ShengNeiqianchuViewForm = new Ext.FormPanel({	
	
	labelAlign : 'right',
    bodyStyle:'padding:0px',
	labelWidth : 100,
	border : false,
	baseCls : 'x-plain',
	waitMsgTarget: true,
	autoScroll : true,
	layout: 'fit',
	items:[{
            layout:'column',
            border:false,
            autoScroll : true,
            baseCls : 'x-plain',
            bodyStyle:'padding:10px',
            items:[
                   {                
                	   columnWidth:1,                
                	   layout: 'form',                
                	   bodyStyle: 'padding:0px',                
                	   border:false,                
                	   items: [{ xtype:'textfield',fieldLabel : '机构名称',name : 'jgmc',readOnly:true,labelSeparator:'',allowBlank : true,maxLength : 100,anchor:'100%'}]
			      },
			{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '法定代表人',name : 'fddbr',readOnly:true,labelSeparator:'',allowBlank : true,maxLength : 30,anchor:'100%'}]
			},{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '机构代码',name : 'jgdm',readOnly:true,labelSeparator:'',allowBlank : true,maxLength : 50,anchor:'100%'}]
			},{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '证件类型',name : 'zjlx',readOnly:true,labelSeparator:'',maxLength : 50,anchor:'100%'}]
			},{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '证件号码',name : 'zjhm',readOnly:true,labelSeparator:'',maxLength : 50,anchor:'100%'}]
			},{
                columnWidth:1,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                defaultType : 'textarea',
                items: [{ xtype:'textfield',fieldLabel : '经营范围',name : 'jyfw',labelSeparator:'',readOnly:true,anchor:'100%',height:'50'}]
			},{
                columnWidth:.5,
                layout: 'form',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '机构注册地址',name : 'jgdz',labelSeparator:'',readOnly:true,maxLength : 100,anchor:'100%'}]
			},{
				columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '邮政编码',name : 'yzbm',labelSeparator:'',readOnly:true,maxLength : 6,anchor:'100%'}]
			},{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '行政区划名称',name :'xzqhName',labelSeparator:'',readOnly:true,maxLength : 50,anchor:'100%'}]
			},{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '行政区划代码',name : 'xzqhCode',labelSeparator:'',readOnly:true,maxLength : 50,anchor:'100%'}]
			},{
                columnWidth:.5,
                layout: 'form',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '机构实际地址',name : 'jydz',labelSeparator:'',readOnly:true,maxLength : 100,anchor:'100%'}]
			},{
				columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '邮政编码',name : 'jyyb',labelSeparator:'',readOnly:true,maxLength : 6,anchor:'100%'}]
			},{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '行政区划名称',name :'xzqhName2',labelSeparator:'',readOnly:true,maxLength : 50,anchor:'100%'}]
			},{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '行政区划代码',name : 'xzqhCode2',labelSeparator:'',readOnly:true,maxLength : 50,anchor:'100%'}]
			},{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '办证日期',name :'bzrq',labelSeparator:'',readOnly:true,maxLength : 50,anchor:'100%'}]
			},{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '作废日期',name : 'zfrq',labelSeparator:'',readOnly:true,maxLength : 50,anchor:'100%'}]
			},         
            {
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [ new Ext.form.TriggerField({
						id:"bzjg_ShengNeiqianchu",
						name:"bzjg",
						fieldLabel:"迁入办证机构",
					    maxLength : 100,
					    allowBlank : false,
					    haveShow : false,
					    labelSeparator:'',
					    readOnly:true,
					    anchor:'100%',
					    editable : false,
					    onTriggerClick : function() {
					    	window_bzjgQuery_ShengNeiqianchu.show();
					    }
					}),
					{xtype : 'hidden',	name : 'bzjgdm'},
					{xtype : 'hidden',	name : 'bzjgmc'}
				]
             },
             {
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{xtype : 'textfield',
						fieldLabel : '是否公开',
						name : 'gk',
						labelSeparator:'',
						readOnly:true,
						anchor:'100%',
						allowBlank:true
					},
					{xtype : 'hidden',	name : 'orgid'}]
			}]
         }]
});

var  ShengNeiqianchuViewForm2= new Ext.Panel({
    title       : '基本信息',
    region      : 'center',
    id          : 'jbInfo28',
    collapsible:false,
    border : 'layout',
    bodyStyle: 'padding:0px',
    margins: '3 0 0 0',
    cmargins: '3 5 0 0',
	layout: 'fit',
    items : [ShengNeiqianchuViewForm]
});

//默认查询 档案
var searchSnqc = function() {
	ShengNeiqianchuViewForm.getForm().reader = Orgnews;
	ShengNeiqianchuViewForm.getForm().load({
		waitMsg : '正在进行数据查询，请稍等',          //提示信息   
		waitTitle : '提示',                      //标题  
		url: 'findAllTjgdmByJgdm.action', //请求控制器获取数据
		method: 'POST', //为"POST",则上面的url不会显示在浏览器的地址栏中
		params: { jgdm: text_search_ShengNeiQianChu.getValue(),userBzjgdm:currentZzUserBzjgdm},	
		success: function(form,action) {//获取返回值	
			//action.result.data.jgmc
		},
		failure: function() {
			Ext.Msg.show({
				title : '提示',
				msg : '查询失败,请确认数据存在',
				buttons : Ext.Msg.OK,
				fn : function(){},
				icon : Ext.Msg.INFO
			});		
		}
	});
};

var btn_search_qianchu = new Ext.Button({
	text : '代码查询',
	iconCls : 'icon-search',
	handler : function() {
		searchSnqc();
	}
});

var text_search_ShengNeiQianChu = new Ext.form.TextField({
	id : 'textSearShengNeichqianchu',
	name : 'textSearShengNeichqianchu',
	width : 200,
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchSnqc();
			}
		}
	}
});

var btn_refresh_qianchu = new Ext.Button({
	text : '重置',
	iconCls : 'icon-refresh',
	handler : function() {
		ShengNeiqianchuViewForm.getForm().reset();
		var tab3452=Ext.getCmp("jbInfo28");
	    tab3452.setTitle("基本信息");
	}
});

function btn_qianchu_saveInfo(btn){
	var jgdm = ShengNeiqianchuViewForm.getForm().findField('jgdm').getValue();
	var bzjgdm = ShengNeiqianchuViewForm.getForm().findField('bzjgdm').getValue();
	if (jgdm!=null) {
		if(bzjgdm!=null){
			Ext.Ajax.request({
				url: 'returnTjgdmSnqc.action',
				params: {jgdm: jgdm,bzjgdm:bzjgdm},
   				success: function(){
   					Ext.Msg.show({
						title : '提示',
						msg : '迁出设置成功！',
						buttons : Ext.Msg.OK,
						fn : function(){
							ShengNeiqianchuViewForm.getForm().reset();
							text_search_ShengNeiQianChu.setValue("");
						},
						icon : Ext.Msg.INFO
					});
   				},
   				failure: function(){
   					Ext.Msg.show({
						title : '提示',
						msg : '迁出设置失败,请检查数据库链接',
						buttons : Ext.Msg.OK,
						fn : function(){},
						icon : Ext.Msg.INFO
					});
   				}
			});
			
		}else{
			Ext.Msg.show({
				title : '提示',
				msg : '请选择迁入的办证机构！',
				buttons : Ext.Msg.OK,
				fn : function() {},
				icon : Ext.Msg.INFO
			});
		}
		
	}else{
		Ext.Msg.show({
			title : '提示',
			msg : '请先查询需要迁出的机构信息！',
			buttons : Ext.Msg.OK,
			fn : function() {},
			icon : Ext.Msg.INFO
		});
	}
}

var btn_ok_qianchu = new Ext.Button({
	text : '迁出确认',
	iconCls : 'icon-store',
	handler : btn_qianchu_saveInfo
});


var p_zzShengNeiQianChu = {
	id : 'zzShengNeiQianChu-panel',
	border : false,
	layout : 'border',
	bodyStyle: 'padding:0px',
	items : [{
		id:'border-panel',
	    layout:'border',
	    bodyBorder: false,
	    title: '省内迁出',
	    iconCls : 'icon-plugin',
 		plain: true,
		region: 'center',
		tbar : [btn_refresh_qianchu,btn_ok_qianchu,'->',text_search_ShengNeiQianChu,btn_search_qianchu],
		items: [ShengNeiqianchuViewForm2]
	}]
}