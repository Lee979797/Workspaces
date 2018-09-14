

//办证机构窗口
var btn_search_bzjg_XzqhYw = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchBzjg_XzqhYw();
		//btn_search_pzjg_xb.setDisabled(true);
	}
});

var text_search_bzjg_XzqhYw = new Ext.form.TextField({
	id : 'textSearchBzjg_XzqhYw',
	name : 'textSearchBzjg_XzqhYw',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchBzjg_XzqhYw();
			}
		},
		'change' : function(field, e) {
			btn_search_bzjg_XzqhYw.setDisabled(false);
		}
	}
});

var cm_bzjg_XzqhYw = new Ext.grid.ColumnModel([
	{header : '办证机构名称',width : 50,dataIndex : 'bzjgName',sortable : true}, 
	{header : '办证机构代码',width : 20,dataIndex : 'bzjgCode',sortable : true},
	{header : '备注',width : 30,dataIndex : 'remark',sortable : true}
]);

//查询返回结果的数据列
var ds_bzjg_XzqhYw = new Ext.data.Store({
	url : 'findAllBzjg.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'bzjgId',type : 'int'}, 
		{name : 'bzjgName',type : 'string'},
		{name : 'bzjgCode',type : 'string'},
		{name : 'remark',type : 'string'}
	])
});

var searchBzjg_XzqhYw = function() {
	ds_bzjg_XzqhYw.baseParams.conditions = text_search_bzjg_XzqhYw.getValue();
	ds_bzjg_XzqhYw.baseParams.username='';
	ds_bzjg_XzqhYw.baseParams.stateConditions='';
	ds_bzjg_XzqhYw.load({params : {start : 0,limit : 20} });
}

var grid_bzjg_XzqhYw = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_bzjg_XzqhYw,
	ds : ds_bzjg_XzqhYw,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入登记批准机构名称：',text_search_bzjg_XzqhYw,btn_search_bzjg_XzqhYw],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_bzjg_XzqhYw,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_bzjg_XzqhYw.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			xzqhYwFormPanel.getForm().findField('select_bzjgdm_XzqhYw').setValue(selections[0].get('bzjgCode'));
			xzqhYwFormPanel.getForm().findField('select_bzjgmc_XzqhYw').setValue(selections[0].get('bzjgName'));
		}
	}
});

var window_bzjg_XzqhYw = new Ext.Window({
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
	items : [grid_bzjg_XzqhYw]
});

var btn_xzqhYwReport_menu = new Ext.Toolbar.MenuButton({
    text: '当天',
    tooltip: {title:'提示',text:'统计办证机构业务量'},
    iconCls: 'blist',
    menu : {items: [
                 {text: '当天', handler:function(){
						quickseldate('day',Ext.getCmp("date1_xzqhYw"),Ext.getCmp("date2_xzqhYw"));
						btn_xzqhYwReport_menu.setText('当天');
					}
				},{text: '本周', handler:function(){
						quickseldate('week',Ext.getCmp("date1_xzqhYw"),Ext.getCmp("date2_xzqhYw"));
						btn_xzqhYwReport_menu.setText('本周');
					}
				},
                {text: '本月份', handler:function(){
						quickseldate('month',Ext.getCmp("date1_xzqhYw"),Ext.getCmp("date2_xzqhYw"));
						btn_xzqhYwReport_menu.setText('本月份');
					}
				},
                {text: '本年度', handler:function(){
						quickseldate('year',Ext.getCmp("date1_xzqhYw"),Ext.getCmp("date2_xzqhYw"));
						btn_xzqhYwReport_menu.setText('本年度');
					}
				}
        ]}
});


var xzqhYwFormPanel = new Ext.FormPanel({
	labelAlign : 'right',
    bodyStyle:'padding:0px',
	labelWidth : 85,
	height: 50,
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
        items:[{
        	columnWidth:.25,
        	layout: 'form',
        	bodyStyle: 'padding:0px',
        	border:false,
            items: [
            	new Ext.form.TriggerField({
					id:"select_bzjgdm_XzqhYw",
					name:"bzjgdm",
					fieldLabel:"办证机构代码",
					anchor:'97%',
				 	valueField : "bzjgCode",
				    displayField : "bzjgCode",
				    labelSeparator:'',
				    allowBlank : false,
				    haveShow : false,
				    editable : false,
				    onTriggerClick : function() {
				    	window_bzjg_XzqhYw.show();
				    }
				})
            ]
        },{
            columnWidth:.17,
            layout: 'form',
            border:false,
            items: [{xtype:'textfield',fieldLabel : '办证机构名称',name:'bzjgName',labelSeparator:'',id:"select_bzjgmc_XzqhYw",allowBlank : false,hideLabel:true,anchor:'99.9%'}]
        },{
        	columnWidth:.25,
            layout: 'form',
            bodyStyle: 'padding:0px',
            border:false,
            items: [
            	new Ext.form.DateField({  
				    id:'date1_xzqhYw',
				    name: 'date1',
				    format:'Y-m-d',
				    maxValue:myDate,  
				    maxText:'所选日期应在{0}之前',  
				    minValue:'01/01/1949',
				    minText:'所选日期应在{0}之后',
				    anchor:'100%',
				    labelSeparator:'',
				    fieldLabel:'办理日期自',
				    allowBlank : false,
				    renderer:dateFormat,
				    altFormats :'m/d/Y|m-d-y|m-d-Y|m/d|m-d|d|Ymd',
				    value:myDate
				})
			]
        },{
        	columnWidth:.25,
            layout: 'form',
            bodyStyle: 'padding:0px',
            border:false,
            items: [
            	new Ext.form.DateField({  
				    id:'date2_xzqhYw',
				    name: 'date2',
				    format:'Y-m-d', 
				    minValue:'01/01/1949',
				    minText:'所选日期应在{0}之后',
				    anchor:'100%',
				    labelSeparator:'',
				    fieldLabel:'至&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
				    allowBlank : false,
				    renderer:dateFormat,
				    altFormats :'m/d/Y|m-d-y|m-d-Y|m/d|m-d|d|Ymd',
				    value:myDate,
				    dateRange:{begin:'date1_xzqhYw',end:'date2_xzqhYw'},//用于vtype类型dateRange   
            		vtype:'dateRange'
				})
			]
        },{
        	columnWidth:.08,
            layout: 'form',
            bodyStyle: 'padding-left:5px',
            labelAlign : 'center',
            border:false,
            items: [btn_xzqhYwReport_menu]  
        }]
	}]
	
});

function searchXzqhYwReport(){
	
	var bzjgdm = xzqhYwFormPanel.getForm().findField('bzjgdm').getValue();
	var hd1 = xzqhYwFormPanel.getForm().findField('date1').getValue().format('Y-m-d');
	var hd2 = xzqhYwFormPanel.getForm().findField('date2').getValue().format('Y-m-d');
	Ext.Ajax.request({
		url : 'findXzqhYwReport.action',
		params : {hd1:hd1,hd2:hd2,bzjgdm:bzjgdm},
		method :'post', 
		waitTitle : '提示',
	    waitMsg : '请求正在发送中，请稍后',
		success : function(result,request) {//获取返回值
		    eval("var data = "+ result.responseText);
		    if(data.length!=0){
		    	var arrData = [];
		    	for(var i=0;i<data.length;i++){
		    		arrData[i] = new Array();
		    		arrData[i].push(data[i].xzqhName);
		    		arrData[i].push(data[i].xzqhCode);
		    		arrData[i].push(data[i].xbNum);
		    		arrData[i].push(data[i].njNum);
		    		arrData[i].push(data[i].bgNum);
		    		arrData[i].push(data[i].hzNum);
		    		arrData[i].push(data[i].bzNum);
		    		arrData[i].push(data[i].qrNum);
		    		arrData[i].push(data[i].qcNum);
		    		arrData[i].push(data[i].yfmNum);
		    		arrData[i].push(data[i].zxNum);
		    		arrData[i].push(data[i].plzxNum);
		    	}
		    	ds_xzqhYwPrint.loadData(arrData);
		    	btn_create_XzqhYwReport.setDisabled(false);
		    }else{
		    	Ext.Msg.show({
					title : '提示',
					msg : '此时间段内未办理业务！',
					buttons : Ext.Msg.OK,
					icon : Ext.Msg.INFO
				});
		    }
		},
		failure : function(){
			Ext.Msg.show({
				title : '提示',
				msg : '未获取到数据，请确认信息正确性！',
				buttons : Ext.Msg.OK,
				icon : Ext.Msg.INFO
			});
		}
	});
	
	
	
}
var btn_search_XzqhYwReport = new Ext.Button({
	text : '查询报表数据',
	iconCls : 'icon-search',
	handler : function() {
		if(xzqhYwFormPanel.getForm().isValid()){
			searchXzqhYwReport();
		}else{
			alert("请确认填入信息准确性！");
		}
	}
});
var btn_create_XzqhYwReport = new Ext.Button({
	text : '生成折线图',
	disabled : true,
	//iconCls : 'icon-search',
	handler : function(btn) {
		/*
		 * 方法一*/
		var nameArray = ["新办","年检","变更","换证","补证","迁入","迁出","预赋码","注销","批量注销"];
		var colArray = ["#FF0080","#0000E3","#8600FF","#00FFFF","#00BB00","#F9F900","#F75000","#AD5A5A","#949449","#000000"];
		//数据源（各个业务对应的数量）
		var dataArr = [];
		dataArr.push(nameArray);
		var record=xzqhYwGridPanel.getSelectionModel().getSelections();
		if (typeof(record)!="undefined"){
			var len = record.length;
			if(len>0){
				for(var i = 0; i < len; i++){
					var arr = new Array();
					//"#FF0000,1,1,3,100000"
					//参数1线条的颜色，参数2线条的宽度，参数3线条的类型，参数4转折点的类型,参数5线条名称
					arr.push(colArray[i%10]+",1,1,3,"+record[i].data.xzqhCode);
					arr.push(record[i].data.xbNum);
					arr.push(record[i].data.njNum);
					arr.push(record[i].data.bgNum);
					arr.push(record[i].data.hzNum);
					arr.push(record[i].data.bzNum);
					arr.push(record[i].data.qrNum);
					arr.push(record[i].data.qcNum);
					arr.push(record[i].data.yfmNum);
					arr.push(record[i].data.zxNum);
					arr.push(record[i].data.plzxNum);
					
					dataArr.push(arr);
				}
				//获取panel的高度；宽度；
				var objWidth=Ext.getCmp('xzqhZXT').getInnerWidth()-80;
				var objHeight=Ext.getCmp('xzqhZXT').getInnerHeight()-154;
				//生成折线图
				draw_vml(tDraw,dataArr,20,55,objWidth,objHeight,len);
			}else{
				alert('请选择记录！');
			}
		}
	}
});

//下栏开始。。。。。。。。。。。。。。

var ds_xzqhYwPrint =  
new Ext.data.SimpleStore({
	
	fields:[{name: 'xzqhName',type: 'string'},{name: 'xzqhCode',type: 'string'},
		{name: 'xbNum',type: 'int'},{name: 'njNum',type: 'int'},{name: 'bgNum',type: 'int'},
		{name: 'hzNum',type: 'int'},{name: 'bzNum',type: 'int'},{name: 'qrNum',type: 'int'},
		{name: 'qcNum',type: 'int'},{name: 'yfmNum',type: 'int'},{name: 'zxNum',type: 'int'},
		{name: 'plzxNum',type: 'int'}]
});

var sm2 = new Ext.grid.CheckboxSelectionModel();
var cm_xzqhYwPrint = new Ext.grid.ColumnModel([
	sm2,
	{header : '行政区划',width : 15,dataIndex : 'xzqhName',sortable : false},
	{header : '行政区划代码',dataIndex : 'xzqhCode',hidden : true},
	{header : '新办',width : 15,dataIndex : 'xbNum',sortable : true}, 
	{header : '年检',width : 15,dataIndex : 'njNum',sortable : true},
	{header : '变更',width : 15,dataIndex : 'bgNum',sortable : true},
	{header : '换证',width : 15,dataIndex : 'hzNum',sortable : true},
	{header : '补证',width : 15,dataIndex : 'bzNum',sortable : true},
	{header : '迁入',width : 15,dataIndex : 'qrNum',sortable : true},
	{header : '迁出',width : 15,dataIndex : 'qcNum',sortable : true}, 
	{header : '预赋码',width : 15,dataIndex : 'yfmNum',sortable : true},
	{header : '注销',width : 15,dataIndex : 'zxNum',sortable : true},
	{header : '批量注销',width : 15,dataIndex : 'plzxNum',sortable : true}
]);

var xzqhYwGridPanel = new Ext.grid.GridPanel({
	region : 'center',
	border: false,
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	autoScroll : true,
	cm : cm_xzqhYwPrint,
	ds : ds_xzqhYwPrint,
	sm : new Ext.grid.CheckboxSelectionModel(),
	viewConfig : {forceFit : true},
	
	listeners : {
		'rowdblclick':function(grid, rowIndex){
			
		},
		'rowclick':function(grid,rowIndex){
			
		}
	}
});



var p_zzXzqhYwReport = {
	id : 'zzXzqhYwReport-panel',
	border : false,
	layout : 'border',
	items : [{
		id: 'xnorth-panel',
		region :'north',
	    title : '查询条件',
	    bodyStyle : 'padding:0px',
	    margins : '0 0 0 0',
	    cmargins : '5 5 0 0',
		layout: 'fit',
	    autoScroll : true,
	    tbar : [btn_search_XzqhYwReport,btn_create_XzqhYwReport],
	    items : [xzqhYwFormPanel]
	},{
		id:'xborder-panel',
	    layout:'border',
	    border: false,
	    iconCls : 'icon-plugin',
 		plain: true,
 		margins : '3 0 0 0',
	    cmargins : '5 0 0 0',
		region: 'center',
		items: [{
			region: 'center',
			title: '业务统计报表',
			layout: 'fit',
			items: [xzqhYwGridPanel]
		},{
			region :'east',
			title: '业务统计图',
			id: 'xzqhZXT',
			layout: 'fit',
			width: 630,
			collapsible: true,
		    split: true,
		    collapsed: false,
		    autoScroll : true,
		    html:'<div id="tDraw" style="width:auto;height:auto;padding-top:30px;padding-left:10px;"></div>'
		}]
	}]
}