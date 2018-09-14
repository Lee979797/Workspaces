var btn_search_jglxSelcet_qc = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchJglxSelcet_qc();
		//btn_search_jjlx.setDisabled(true);
	}
});


var text_search_jglxSelcet_qc = new Ext.form.TextField({
	id : 'textsearchJglxSelcet_qc',
	name : 'textsearchJglxSelcet_qc',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchJglxSelcet_qc();
			}
		},
		'change' : function(field, e) {
			btn_search_jglxSelcet_qc.setDisabled(false);
		}
	}
});


var cm_jglxSelcet_qc = new Ext.grid.ColumnModel([
    {header : '一级类型',width : 60,dataIndex : 'pjglxmc',sortable : true}, 
	{header : '二级类型',width : 100,dataIndex : 'jglxmc',sortable : true}, 
	{header : '代码',width : 30,dataIndex : 'jglxdm',sortable : true},
	{header : '备注',width : 50,dataIndex : 'note',sortable : true}
]);


//查询返回结果的数据列
var ds_jglxSelcet_qc = new Ext.data.Store({
	url : 'findAllByConditionJglx.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'jglxid',type : 'int'}, 
	    {name : 'pjglxmc',type : 'string'},
	    {name : 'pjglxdm',type : 'string'},
		{name : 'jglxmc',type : 'string'},
		{name : 'jglxdm',type : 'string'},
		{name : 'note',type : 'string'}
	])
});

var searchJglxSelcet_qc = function() {
	ds_jglxSelcet_qc.baseParams.conditions = text_search_jglxSelcet_qc.getValue();
	ds_jglxSelcet_qc.baseParams.username="";
	ds_jglxSelcet_qc.baseParams.stateConditions='';
	ds_jglxSelcet_qc.load({params : {start : 0,limit : 20} });
}

var grid_jglx_qianchu = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_jglxSelcet_qc,
	ds : ds_jglxSelcet_qc,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入机构类型名称：',text_search_jglxSelcet_qc,btn_search_jglxSelcet_qc],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_jglxSelcet_qc,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_jglxQuery_qianchu.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			qianchuViewForm.getForm().findField('select_jglxmc_qianchu').setValue(selections[0].get('jglxmc'));
			qianchuViewForm.getForm().findField('select_jglxdm_qianchu').setValue(selections[0].get('jglxdm'));
		}
	}
});


var window_jglxQuery_qianchu = new Ext.Window({
	title : '机构类型查询',
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
	items : [grid_jglx_qianchu]
});


var btn_search_bzjg_qianchu = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchBzjg_qianchu();
		btn_search_bzjg_qianchu.setDisabled(true);
	}
});


var text_search_bzjg_qianchu = new Ext.form.TextField({
	id : 'textSearchBzjg_qianchu',
	name : 'textSearchbzjg_qianchu',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchBzjg_qianchu();
			}
		},
		'change' : function(field, e) {
			btn_search_bzjg_qianchu.setDisabled(false);
		}
	}
});


var cm_bzjg_qianchu = new Ext.grid.ColumnModel([
	{header : '办证机构名称',width : 50,dataIndex : 'bzjgmc',sortable : true}, 
	{header : '办证机构代码',width : 20,dataIndex : 'bzjgdm',sortable : true},
	{header : '省中心机构代码',width : 20,dataIndex : 'superdm',sortable : true},
	{header : '备注',width : 30,dataIndex : 'note',sortable : true}
]);


//查询返回结果的数据列
var ds_bzjg_qianchu = new Ext.data.Store({
	url : 'findAllByConditionBzjgall.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'bzjgid',type : 'int'}, 
		{name : 'bzjgmc',type : 'string'},
		{name : 'bzjgdm',type : 'string'},
		{name : 'superdm',type : 'string'},
		{name : 'note',type : 'string'}
	])
});

var searchBzjg_qianchu = function() {
	ds_bzjg_qianchu.baseParams.conditions = text_search_bzjg_qianchu.getValue();
	ds_bzjg_qianchu.load({params : {start : 0,limit : 20} });
}

var grid_bzjg_qianchu = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_bzjg_qianchu,
	ds : ds_bzjg_qianchu,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入迁入办证机构名称：',text_search_bzjg_qianchu,btn_search_bzjg_qianchu],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_bzjg_qianchu,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_bzjgQuery_qianchu.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			qianchuViewForm.getForm().findField('select_moveoutAddrss_qianchu').setValue(selections[0].get('bzjgmc')+selections[0].get('bzjgdm'));
			qianchuViewForm.getForm().findField('select_moveoutCenter_qianchu').setValue(selections[0].get('superdm'));
			qianchuViewForm.getForm().findField('select_moveoutBzjgdm_qianchu').setValue(selections[0].get('bzjgdm'));
		}
	}
});


var window_bzjgQuery_qianchu = new Ext.Window({
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
	items : [grid_bzjg_qianchu]
});



//--------------------机构基本信息-------------------------------------------
var qianchuViewForm = new Ext.FormPanel({	
	url : 'saveOrgnew.action',
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
            items:[{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [new Ext.form.TriggerField({
						id:"select_jglxdm_qianchu",
						name:"jglxdm",
						fieldLabel:"机构类型",
						anchor:'97%',
					 	valueField : "jglxdm",
					    displayField : "jglxdm",
					    labelSeparator:'',
					    allowBlank : false,
					    haveShow : false,
					    editable : false,
					    onTriggerClick : function() {
					    	window_jglxQuery_qianchu.show();
					    },listeners : {
							'specialkey' : function(field, e) {
								if (e.getKey() == Ext.EventObject.ENTER) {
									findJglxNameByCode(field);
								}
							},
							'blur': function(field){
								findJglxNameByCode(field);
							}
						}
					})
				]
			},{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '机构类型名称',id:"select_jglxmc_qianchu",name : 'jglx',labelSeparator:'',hideLabel:true,readOnly:'true',maxLength : 50,anchor:'100%'}]
			},{
                columnWidth:1,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '机构名称',name : 'jgmc',readOnly:true,labelSeparator:'',allowBlank : false,maxLength : 100,anchor:'100%'}]
			},{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '法定代表人',name : 'fddbr',readOnly:true,labelSeparator:'',allowBlank : false,maxLength : 30,anchor:'100%'}]
			},{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '机构代码',name : 'jgdm',readOnly:true,labelSeparator:'',allowBlank : false,maxLength : 50,anchor:'100%'}]
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
                items: [{ fieldLabel : '经营范围',name : 'jyfw',labelSeparator:'',readOnly:true,anchor:'99.5%',height:'50'}]
			},{
                columnWidth:1,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                defaultType : 'textarea',
                items: [{ fieldLabel : '企业简介',name : 'qyjj',labelSeparator:'',readOnly:true,anchor:'99.5%',height:'50'}]
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
			},{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '经办人',name :'tbrxm',labelSeparator:'',allowBlank : false,maxLength : 10,anchor:'100%'}]
			},{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ 	
            			xtype : 'combo',
						fieldLabel : '证件类型',
						id : 'zjlx2_qianchu',
						name:'tbrzjlx',
						hiddenName : 'tbrzjlx',
						valueField : 'categoryName',
						displayField : 'categoryName',
						mode : 'remote',
						store : ds_zjlx_select,
						selectOnFocus : true,
						editable : false,
						allowBlank : false,
						//readOnly:true,
						maxLength : 25,
						anchor:'100%',
						labelSeparator:'',
						value:'居民身份证',
						//onTriggerClick : Ext.emptyFn,
						triggerAction : 'all',
						loadingText : '加载中...',
						listeners : {
						'select' : function(combo, record, index) {
							if(record.data.categoryName=='居民身份证'){
								var flag = isIdCardNo(qianchuViewForm.getForm().findField('tbrsfzh').getValue());
								if(flag != true){
									qianchuViewForm.getForm().findField('tbrsfzh').focus();
								}
							}else{
								qianchuViewForm.getForm().findField('tbrsfzh').focus();
							}
						}
					}
				}]
			},{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '经办人证件号码',name : 'tbrsfzh',labelSeparator:'',allowBlank : false,maxLength : 30,anchor:'100%'}]
            },{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '经办人电话',name : 'tbrlxfs',labelSeparator:'',vtype:'dhhmphone',maxLength : 20,anchor:'100%'},
					{ xtype:'hidden',fieldLabel : '业务类型',name : 'ywlx',value:'迁出'},
					{xtype : 'hidden',	name : 'orgid',value:''},
				    {xtype : 'hidden',	name : 'orderid',id:'orderid'},
				    {xtype : 'hidden',name : 'docid'},
				    
				    {xtype : 'hidden',name : 'zbsl'},
				    {xtype : 'hidden',name : 'fbsl'},
				    {xtype : 'hidden',name : 'fksl'},
				    
					{xtype : 'hidden',name : 'imageUrl'},
					{xtype : 'hidden',name : 'lastdate',value :myDate.format('Y-m-d')}, 
					{xtype : 'hidden',name : 'lry'},
					{xtype : 'hidden',name : 'bzjgdm',value:currentZzUserBzjgdm},
					{xtype : 'hidden',name : 'xgr',value:currentZzUsername},
					{xtype : 'hidden',name : 'state',value:'12'},
					{xtype : 'hidden',id:'select_moveoutCenter_qianchu',name : 'moveoutCenter'},
					{xtype : 'hidden',id:'select_moveoutBzjgdm_qianchu',name : 'moveoutBzjgdm'},
					{xtype : 'hidden',name : 'qzrq',value :myDate.format('Y-m-d')},
					{xtype : 'hidden',name : 'centerid'}	
                ]	
            },{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [ new Ext.form.TriggerField({
						id:"select_moveoutAddrss_qianchu",
						name:"moveoutAddrss",
						fieldLabel:"迁入办证机构",
					 	valueField : "moveoutAddrss",
					    displayField : "moveoutAddrss",
					    maxLength : 100,
					    allowBlank : false,
					    haveShow : false,
					    labelSeparator:'',
					    readOnly:true,
					    anchor:'100%',
					    editable : false,
					    onTriggerClick : function() {
					    	window_bzjgQuery_qianchu.show();
					    }
					})]
             },{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{xtype : 'combo',
						fieldLabel : '是否公开',
						id : 'gk_qianchu',
						name : 'gk',
						displayField : 'gk',
						valueField : 'gk',
						hiddenName : 'gk',
						store : gkStore,
						triggerAction : 'all',
						lazyRender:true,
						value:'是',
						anchor:'100%',
						mode : 'local',
						selectOnFocus : true,
						allowBlank:false,
						labelSeparator:'',
						editable : false
					}]
			},{
                columnWidth:1,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                defaultType : 'textarea',
                items: [{ fieldLabel : '迁入原因',name : 'moveoutReason',labelSeparator:'',anchor:'99.5%',maxLength : 250,height:'50'}]
			}]
         }]
});

var  qianchuViewForm2= new Ext.Panel({
    title       : '基本信息',
    region      : 'center',
    id          : 'jbInfo28',
    collapsible:false,
    border : 'layout',
    bodyStyle: 'padding:0px',
    margins: '3 0 0 0',
    cmargins: '3 5 0 0',
	layout: 'fit',
    items : [qianchuViewForm]
});


var fileFtpForm_qianchu = new Ext.Panel({
	title:'原文扫描',
	split:true,
	width:550,
	collapsible:true,
	collapsed: false,
    region:'east',
    margins:'3 0 0 5',
    cmargins:'3 0 0 5',
    //activeTab: 0,
    html: '<OBJECT classid="clsid:B4E2D33E-D8B2-4956-9F91-1C6BDC87A6D1"  width=100%  height=100% align=center hspace=0 vspace=0 id="scanner24629"  name="scanner24629" >'
	       +'<param name="ShowCount" value="8">'
	       +'<param name="sModel" value="1">'
	       +'</OBJECT>'
    
});


//默认查询 档案
var searchqianchu = function() {

	qianchuViewForm.getForm().reader = Orgnews;
	qianchuViewForm.getForm().load({
		waitMsg : '正在进行数据查询，请稍等',          //提示信息   
        waitTitle : '提示',                      //标题  
	    url: 'findAllYwqxOrgnew.action', //请求控制器获取数据
	    method: 'POST', //为"POST",则上面的url不会显示在浏览器的地址栏中
	    params: { conditions:  text_search_qianchu.getValue(),username:currentZzUsername,ywlxConditions:null,stateConditions:'10,11,12,13,14,15,16',start:1,limit:1},	
	    success:function(form,action) {//获取返回值
	    	if(action.result.data.ywlx=='迁出' && (action.result.data.state=='12' || action.result.data.state=='14')){//判断业务是否办理中
	    		/*
	    		if(currentZzUserYwqx=='2'&&currentZzUserBzjgdm!=currentZzUserCenterid&&action.result.data.bzjgdm==currentZzUserCenterid){
	    			alert('本业务属于中心业务，不属于跨区办理范畴');
	    			btn_del_qianchu.setDisabled(true);
					qianchuViewForm.getForm().reset();
					var tab3452=Ext.getCmp("jbInfo28");
				    tab3452.setTitle("基本信息");
					scanner24629.ImageData="";
	    			return;
	    		}
	    		*/
	    		btn_del_qianchu.setDisabled(false);
	    		var tab3452=Ext.getCmp("jbInfo28");
	    		tab3452.setTitle("基本信息  ("+stateToInfo(qianchuViewForm.getForm().findField('state').value)+")");	
	    		qianchuViewForm.getForm().findField('lastdate').setValue(myDate.format('Y-m-d'));
				qianchuViewForm.getForm().findField('xgr').setValue(currentZzUsername);
	    		qianchuViewForm.getForm().findField('bzjgdm').setValue(currentZzUserBzjgdm);
	    		var resultObject = null;
	    		Ext.Ajax.request({
					url : 'orgnewViewImg.action',
					params : {orgid : action.result.data.orgid},
					success : function(result,request) {//获取返回值
						scanner24629.ImageData="";
	   					var resultObject = Ext.util.JSON.decode(result.responseText); 
	   					if(resultObject!=null){
		   					scanner24629.OpenProgress(3);  //设置上传的进度条的总进度数
		   					scanner24629.Progress('原文加载中',1);
							scanner24629.Progress('原文加载中',2);
		   					scanner24629.ImageData=resultObject.imageData;
		   					scanner24629.pageType=resultObject.pageTypeStr;
		   					if(scanner24629.ImageData!=""){
		   						scanner24629.Progress('原文加载完毕',3);
								scanner24629.CloseProgress();
							}else{
								scanner24629.Progress('原文加载失败',3);
				   				scanner24629.CloseProgress();
				   				alert("原文错误，加载失败！");
							}
	   					}
					},
					failure : function() {
						scanner24629.ImageData="";
			   			scanner24629.CloseProgress();
						alert("图像加载错误，或者无原文");
					}
				});	
	
			}else{
				btn_del_qianchu.setDisabled(true);
				Ext.Msg.show({
					title : '提示',
					msg : '机构正在进行“'+action.result.data.ywlx+'”业务办理中!',
					buttons : Ext.Msg.OK,
					icon : Ext.Msg.INFO,
					fn : function() {qianchuViewForm.getForm().reset();scanner24629.ImageData="";}
				});
            }
		},
		failure : function() {//正式库检索
				qianchuViewForm.getForm().reader = Orgnews;
				qianchuViewForm.getForm().load({
					waitMsg : '正在进行数据查询，请稍等',          //提示信息   
			        waitTitle : '提示',                      //标题  
				    url: 'findAllTjgdmByJgdm.action', //请求控制器获取数据
				    method: 'POST', //为"POST",则上面的url不会显示在浏览器的地址栏中
				    params: { jgdm:  text_search_qianchu.getValue(),userBzjgdm:null},	
				    success:function(form,action) {//获取返回值
				    		if(currentZzUsername!='admin' && sysBzjgLimitMode=='1' && action.result.data.bzjgdm!=currentZzUserBzjgdm && currentZzUserYwqx!='2' && currentZzUserBzjgdm!=currentZzUserCenterid){
				    				Ext.Msg.show({
										title : '提示',
										msg : '【'+action.result.data.jgmc+'】，<br><br>办证机构代码为“'+action.result.data.bzjgdm+'”,不属于本办证机构办理！',
										buttons : Ext.Msg.OK,
										fn:  function() {
											btn_del_qianchu.setDisabled(true);
							    			btn_save_qianchu_menu.setDisabled(false);
							    			
											qianchuViewForm.getForm().reset();
											scanner24629.ImageData="";
											var tab3452558=Ext.getCmp("jbInfo28");
							    			tab3452558.setTitle("基本信息");
										},
										icon : Ext.Msg.ERROR
									});
				    		}else{
						    	if(action.result.data.state=='100' || action.result.data.state==''){//判断此机构状态是否正常
						    		btn_del_qianchu.setDisabled(true);
						    		scanner24629.ImageData="";
						    		var tab3452=Ext.getCmp("jbInfo28");
						    		tab3452.setTitle("基本信息  (新录入)");
						    		qianchuViewForm.getForm().findField('ywlx').setValue('迁出');
						    		qianchuViewForm.getForm().findField('state').setValue('12');
						    		qianchuViewForm.getForm().findField('orgid').setValue('');
						    		qianchuViewForm.getForm().findField('lastdate').setValue(myDate.format('Y-m-d'));
						    		qianchuViewForm.getForm().findField('qzrq').setValue(myDate.format('Y-m-d'));
						    		qianchuViewForm.getForm().findField('centerid').setValue(currentZzUserCenterid);
						    		qianchuViewForm.getForm().findField('bzjgdm').setValue(currentZzUserBzjgdm);
						    		var zbslStr = qianchuViewForm.getForm().findField('zbsl').getValue();
						    		var fbslStr = qianchuViewForm.getForm().findField('fbsl').getValue();
						    		var fkslStr = qianchuViewForm.getForm().findField('fksl').getValue();
						    		if(zbslStr==null||zbslStr==''){
						    			qianchuViewForm.getForm().findField('zbsl').setValue('1');
						    		}
						    		if(fbslStr == null||fbslStr==''){
						    			qianchuViewForm.getForm().findField('fbsl').setValue('1');
						    		}
						    		if(fkslStr==null||fkslStr==''){
						    			qianchuViewForm.getForm().findField('fksl').setValue('0');
						    		}
						    		
								}else{
									Ext.Msg.show({
										title : '提示',
										msg : '机构“'+action.result.data.jgmc+'”状态为“'+tjgdmStateToInfo(action.result.data.state)+'”,<br><br>不能再次办理业务！',
										fn:  function() {
											btn_del_qianchu.setDisabled(true);
							    			btn_save_qianchu_menu.setDisabled(false);
							    			
											qianchuViewForm.getForm().reset();
											scanner24629.ImageData="";
											var tab3452558=Ext.getCmp("jbInfo28");
							    			tab3452558.setTitle("基本信息");
										},
										buttons : Ext.Msg.OK,
										icon : Ext.Msg.ERROR
									});
					            }
				    		}
					},
					failure : function() {
						Ext.Msg.show({
							title : '提示',
							msg : '机构信息未查到！',
							width:250,
							buttons : Ext.Msg.OK,
							icon : Ext.Msg.ERROR,
							fn:  function() {
								btn_del_qianchu.setDisabled(true);
							    //btn_shibie_qianchu.setDisabled(false);
								qianchuViewForm.getForm().reset();
								scanner24629.ImageData="";
							}
						});
					}	
			});
		}
	});
}

var btn_search_qianchu = new Ext.Button({
	text : '代码查询',
	iconCls : 'icon-search',
	handler : function() {
		searchqianchu();
	}
});

var text_search_qianchu = new Ext.form.TextField({
	id : 'textSearchqianchu',
	name : 'textSearchqianchu',
	width : 200,
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchqianchu();
			}
		}
	}
});




var btn_refresh_qianchu = new Ext.Button({
	text : '重置',
	iconCls : 'icon-refresh',
	handler : function() {
    	//btn_save_qianchu_menu.setDisabled(true);
    	//btn_shibie_qianchu.setDisabled(false);
		btn_del_qianchu.setDisabled(true);
		qianchuViewForm.getForm().reset();
		var tab3452=Ext.getCmp("jbInfo28");
	    tab3452.setTitle("基本信息");
		scanner24629.ImageData="";
		//this.ownerCt.form.reset();;
	}
});

var btn_del_qianchu = new Ext.Button({
	text : '删除',
	iconCls : 'icon-del',
	disabled:true,
	handler : function() {
		var orgid = qianchuViewForm.getForm().findField('orgid').value;
		if(orgid!=null && orgid!=""){
			Ext.Msg.confirm('确认删除', '你确定删除吗?', function(btn) {
				if (btn == 'yes') {
					ajaxLoadMask.show();
					Ext.Ajax.request({
						url : 'deleteOrgnew.action',
						params : {orgid : orgid},
						success : function() {
							ajaxLoadMask.hide();
							btn_del_qianchu.setDisabled(true);
					    	//btn_shibie_qianchu.setDisabled(false);
							qianchuViewForm.getForm().reset();
							var tab3452=Ext.getCmp("jbInfo28");
	    					tab3452.setTitle("基本信息");
							scanner24629.ImageData="";
						},
						failure : function() {
							ajaxLoadMask.hide();
							Ext.Msg.show({
								title : '提示',
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



var btn_save_qianchu_menu = new Ext.Toolbar.MenuButton({
    text: '保存',
    handler: btn_qianchu_saveAll,
    tooltip: {title:'保存数据和原文',text:'保存'},
    iconCls: 'blist',
    //disabled:true,
    menu : {items: [
                {text: '全部保存', handler: btn_qianchu_saveAll}, '-',
                {text: '仅保存数据', handler: btn_qianchu_saveInfo},
                {text: '仅上传原文', handler: btn_qianchu_ftpFile}
        ]}
});

var upFuncQC = function(docid,orgid,strJgdm,strState,strYwlx,jgmc){
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
				
				
				strOrgid = orgid;  //参数orgid
				strDocid = docid;
				strBzjgdm=qianchuViewForm.getForm().findField('bzjgdm').value; 
				
				packLength = 40960;	//定义每个包的大小40960
				//scanner24629.ImageData=document.getElementById("ImageData").value;
				base64file = scanner24629.ImageData;  //获取控件扫描的图片数据
				var baseSize = base64file.length;  //获取控件图片数据的64位编码的长度
				imageCount = scanner24629.ImageCount;	//获取扫描图片的页数
				pageTypeStr = scanner24629.PageType;    //获取标识字符串,需要写数据库
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
				scanner24629.OpenProgress(packCount);  //设置上传的进度条的总进度数
				xmlhttp = GetXmlHttp(); //通过AJAX格式上传
				for(var i=0; i < packCount; i++)  //分包上传
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
						//xmlhttp.open("post", "saveImageOrgnew.action?orgid="+strOrgid, false);
						xmlhttp.open("post", "saveImageOrgnew.action?orgid="+strOrgid+"&docid="+strDocid+"&packindex="+i+"&pageTypeStr="+pageTypeStr+"&bzjgdm="+strBzjgdm+"&lastpack="+lastpack, false);
						xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   //这句必须要，而且一定要放在send以前
						xmlhttp.send("imageData=" + encodeURIComponent(pack)); 
						//xmlhttp.send("imgPackData=" + pack); 
						//alert("上传返回的值"+xmlhttp.responseText);
		             
						var objs = eval("["+xmlhttp.responseText+"]");
						//alert(objs.length); // 2
		                //alert(objs[0].success);  // 1
		                //alert(objs[0].success);
		                //if(i==2) break;
						if(objs[0].success)
						{
							scanner24629.Progress('上传中',i+1);
						}
						else
						{
							alert("上传失败，请重试0001。");
							//scanner24629.ShowSendMsg(false);
							
							return false;
						}
					}
					catch(e)
					{
						//alert(e.description+'|'+e.name+'|'+e.number);
						alert("上传失败，请重试0002。");
						
						return false;
					}
				}
				
				Ext.Msg.show({
					title : '提示',
					msg : '['+qianchuViewForm.getForm().findField('jgmc').value+']，<br><br>信息保存成功！',
					buttons : Ext.Msg.OK,
					fn : function() {
						scanner24629.CloseProgress();
						subQCAction(orgid,strJgdm,strState,strYwlx,jgmc);
					},
					icon : Ext.Msg.INFO
				});

				
}

function btn_qianchu_saveAll(btn){
	if (qianchuViewForm.getForm().isValid()) {
		qianchuViewForm.getForm().submit({
			waitTitle : '请稍候',
			waitMsg : '正在保存数据,请稍候...',
			success : function(form,action) {
				
				qianchuViewForm.getForm().findField('orgid').setValue(action.result.orgid);
				qianchuViewForm.getForm().findField('docid').setValue(action.result.docid);
				
				var orgid = qianchuViewForm.getForm().findField('orgid').getValue();
				var docid = action.result.docid;
		var strJgdm = qianchuViewForm.getForm().findField('jgdm').getValue();
		var strState = qianchuViewForm.getForm().findField('state').getValue();
		var jgmc = qianchuViewForm.getForm().findField('jgmc').getValue();
		var strYwlx = qianchuViewForm.getForm().findField('ywlx').getValue();
				
				if(scanner24629.ImageCount>0){
					if(orgid!=null && orgid!=""){
			Ext.Ajax.request({
				url: 'checkArchive.action',
				params: {orgid: orgid,jgdm:strJgdm},
				success: function(result,request){//result,request
					var data = Ext.util.JSON.decode(result.responseText);
					var str = scanner24629.CheckArchives("迁出",data.jglxdmOld,data.zchInfo,data.frInfo);
					if(str==''){
						//alert("更新imageFlag为1（表示档案完整）");
						refreshImageFlag(orgid,'1');
						upFuncQC(docid,orgid,strJgdm,strState,strYwlx,jgmc);
					}else{
						//alert(str+"::更新imageFlag为0（表示档案不完整）");
						Ext.Msg.show({
							title : '提示',
							msg : str + '继续提交则选是,取消提交则选否！',
							buttons : Ext.Msg.OKCANCEL,
							fn : function(btn){
								if(btn == 'ok'){
									refreshImageFlag(orgid,'0');
									upFuncQC(docid,orgid,strJgdm,strState,strYwlx,jgmc);
								}else{
									refreshImageFlag(orgid,'0');
								}
							},
							icon : Ext.Msg.INFO
						});
					}
				}
			});
		}else{
			Ext.Msg.show({
				title : '提示',
				msg : '请保存信息后，再进行“迁出确认”处理！',
				buttons : Ext.Msg.OK,
				icon : Ext.Msg.INFO
			});
		}
				}else{
					Ext.Msg.show({
							title : '提示',
							msg : '档案尚未扫描请确认是否继续提交！',
							buttons : Ext.Msg.OKCANCEL,
							fn : function(btn){
								if(btn == 'ok'){
									refreshImageFlag(orgid,'0');
									subQCAction(orgid,strJgdm,strState,strYwlx,jgmc);
								}else{
									refreshImageFlag(orgid,'0');
								}
							},
							icon : Ext.Msg.INFO
						});
				}
			},
			failure : function(form) {
				Ext.Msg.show({
					title : '提示',
					msg : '申请信息保存失败',
					buttons : Ext.Msg.OK,
					fn : function() {btn.enable();},
					icon :Ext.Msg.ERROR
				});
			}
		});
	}else{
		Ext.Msg.show({
			title : '提示',
			msg : '申请表信息，填写不完整！<br><br>显示为红色的输入框为错误输入项',
			buttons : Ext.Msg.OK,
			fn : function() {btn.enable();},
			icon : Ext.Msg.ERROR
		});
	}
}

function btn_qianchu_saveInfo(btn){
	if (qianchuViewForm.getForm().isValid()) {
		qianchuViewForm.getForm().submit({
			waitTitle : '请稍候',
			waitMsg : '正在保存数据,请稍候...',
			success : function(form,action) {
				//alert(action.result.orgid);
				qianchuViewForm.getForm().findField('orgid').setValue(action.result.orgid);
				qianchuViewForm.getForm().findField('docid').setValue(action.result.docid);
				Ext.Msg.show({
					title : '提示',
					msg : '['+qianchuViewForm.getForm().findField('jgmc').value+']，申办信息保存成功',
					buttons : Ext.Msg.OK,
					//fn : function() {btn.enable();btn_ok_qianchu.setDisabled(false);},
					icon : Ext.Msg.INFO
				});
			},
			failure : function(form) {
				Ext.Msg.show({
					title : '提示',
					msg : '信息保存失败',
					buttons : Ext.Msg.OK,
					fn : function() {btn.enable();},
					icon :Ext.Msg.ERROR
				});
			}
		});
	}else{
		Ext.Msg.show({
			title : '提示',
			msg : '申请表信息，填写不完整！<br><br>显示为红色的输入框为错误输入项',
			buttons : Ext.Msg.OK,
			fn : function() {btn.enable();},
			icon : Ext.Msg.ERROR
		});
	}
}

function btn_qianchu_ftpFile(btn){
	
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
	
	btn.disable();
	strOrgid =qianchuViewForm.getForm().findField('orgid').value;  //参数orgid
	strDocid =qianchuViewForm.getForm().findField('docid').value;  //参数docid
	strBzjgdm=qianchuViewForm.getForm().findField('bzjgdm').value;  //办证机构代码
	//alert("strOrgid="+strOrgid);
	
	if(strOrgid!=""){
			packLength = 40960;	//定义每个包的大小40960
			//scanner24629.ImageData=document.getElementById("ImageData").value;
			base64file = scanner24629.ImageData;  //获取控件扫描的图片数据
			var baseSize = base64file.length;  //获取控件图片数据的64位编码的长度
			imageCount = scanner24629.GetPageCount;	//获取扫描图片的页数
			pageTypeStr = scanner24629.PageType;    //获取标识字符串,需要写数据库
			if(pageTypeStr!=""){
				pageTypeStr=pageTypeStr.replace(/\%/g, "|"); 
			}
			
			//alert(baseSize);
			packCount = Math.ceil(baseSize / packLength);	//判断需要发送数据包的个数
			//alert("packCount="+packCount);
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
			scanner24629.OpenProgress(packCount);  //设置上传的进度条的总进度数
			xmlhttp = GetXmlHttp(); //通过AJAX格式上传
			for(var i=0; i < packCount; i++)  //分包上传
			{
				if(i==packCount-1){
					lastpack="true";
				}else{
					lastpack="false";
				}
							
				pack = base64file.substring(i * packLength, (i + 1) * packLength);  //每个数据包的文件大小
				try{
					xmlhttp.open("post", "saveImageOrgnew.action?orgid="+strOrgid+"&docid="+strDocid+"&packindex="+i+"&pageTypeStr="+pageTypeStr+"&bzjgdm="+strBzjgdm+"&lastpack="+lastpack, false);
					xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   //这句必须要，而且一定要放在send以前
					xmlhttp.send("imageData=" + encodeURIComponent(pack)); 
					//alert("上传返回的值"+xmlhttp.responseText);
		         
					var objs = eval("["+xmlhttp.responseText+"]");
					if(objs[0].success){
						scanner24629.Progress('上传中',i+1);
					}else{
						alert("上传失败，请重试0001。");
						btn.enable();
						return false;
					}
				}catch(e){   
					//alert(e.description+'|'+e.name+'|'+e.number);
					alert("上传失败，请重试0002。");
					btn.enable();
					return false;
				}
			}
			scanner24629.CloseProgress();
			
			Ext.Msg.show({
				title : '提示',
				msg : '['+qianchuViewForm.getForm().findField('jgmc').value+']，<br><br>原文上传成功！',
				buttons : Ext.Msg.OK,
				fn : function() {btn.enable();},
				icon : Ext.Msg.INFO
			});
			
			scanner24629.CloseProgress();
			return true;
	}else{
		alert("请录入数据后，再上传原文！");
	}
}

//提交确认方法
var subQCAction =function (orgid,strJgdm,strState,strYwlx,jgmc){
	ajaxLoadMask.show();
	Ext.Ajax.request({
		url: 'returnOrgnewDo.action',
		params: {orgid: orgid,jgdm:strJgdm,state:strState,ywlx:strYwlx},
		success: function(){
			ajaxLoadMask .hide();
			Ext.Msg.show({
				title : '提示',
				msg : '[' + jgmc + ']申请单办理完毕！',
				buttons : Ext.Msg.OK,
				fn:  function() {
   					qianchuViewForm.getForm().findField('orgid').setValue('');
   					
   					//btn_print_qianchu.setDisabled(true);
   					var tab345=Ext.getCmp("jbInfo28");
		    		tab345.setTitle("基本信息");	
					qianchuViewForm.getForm().reset();
					scanner24629.PageType="";
					scanner24629.ImageData="";
					text_search_qianchu.setValue("");
				},
				icon : Ext.Msg.INFO
			});
		},
		failure: function(){
			ajaxLoadMask .hide();
			Ext.Msg.show({
				title : '提示',
				msg : '[' + jgmc + ']申请单办理失败！',
				buttons : Ext.Msg.OK,
				icon : Ext.Msg.ERROR
			});
		}
	});
}


var btn_print_qzd = new Ext.Button({
	text : '打印迁址单',
	iconCls : 'icon-print',
	handler : function(){
		var orgid = qianchuViewForm.getForm().findField('orgid').getValue();
		if(orgid!=null && orgid!=""){
			ajaxLoadMask .show();
			Ext.Ajax.request({
				url: 'findOrgnewByOrgid.action',
   				params: {orgid: orgid},
   				success: function(result,request){//获取返回值
   					ajaxLoadMask .hide();
   					var resultObject = Ext.util.JSON.decode(result.responseText);
   					if(resultObject.root.length!=0){
						
						/////////////////////
						
			
			var tableStr = '<html><head><meta http-equiv="Content-Type" content="text/html; charset=gb2312" /><title>组织机构代码网上办证系统--迁址证明打印</title>';
			tableStr = tableStr + '<style type="text/css">';
			tableStr = tableStr + '		body{ width:910px; background-color: #CCCCCC;margin:20px auto;}';
			tableStr = tableStr + '		#xiahua {width:800px; padding:10px; border:1px #000000 solid; background:white}';
			tableStr = tableStr + '		.xiahua2 { border-bottom:1px #000000 solid; padding:2px; font-size:10.5pt; }';
			tableStr = tableStr + '		.STYLE8 {font-family: "宋体"; font-size: 10.5pt; }';
			tableStr = tableStr + '		.STYLE9 {font-size: 10.5pt; }';
			tableStr = tableStr + '		.STYLE18 {font-size: 14pt;line-height: 1.5em;}';
			tableStr = tableStr + '		.STYLE19 {font-family: "黑体";line-height: 2.5em;	font-size: 16pt;}';
			tableStr = tableStr + '		.STYLE20 {font-size: 16pt; }';
			tableStr = tableStr + '</style>';
			tableStr = tableStr + '</head>';
			tableStr = tableStr + '<body>';
			tableStr = tableStr + '	<center>';
			tableStr = tableStr + '    <br><br>';
			tableStr = tableStr + '		<div id="xiahua">';
			tableStr = tableStr + '		<table  id="table" width=689; cellpadding= "0" cellspacing= "0"  border="0"><tr><td height="54" align="center" class="STYLE18 STYLE19">迁址证明</td></tr></table>';
			tableStr = tableStr + '		<table id="table4" style="border-collapse:collapse; " cellpadding= "0" cellspacing= "0" border= "0" > ';         
			tableStr = tableStr + '			<tr>';
			tableStr = tableStr + '    		<td height="40" colspan="4" align="left" valign="bottom" class="STYLE8">组织机构代码：</td>';
			tableStr = tableStr + '		  		<td width="231" align="left" valign="bottom" class="xiahua2">'+resultObject.root[0].jgdm+'</td>';
			tableStr = tableStr + '    		<td width="105" align="left">&nbsp;</td><td width="179" align="center">&nbsp;</td><td width="105" align="center">&nbsp;</td>';
			tableStr = tableStr + '		  </tr>';
			tableStr = tableStr + '    	<tr>';
			tableStr = tableStr + '    		<td height="40" colspan="4" align="left" valign="bottom" class="STYLE8">组织机构名称：</td>';
			tableStr = tableStr + '   			<td colspan="4"  align="left" valign="bottom" class="xiahua2">'+resultObject.root[0].jgmc+'</td>';
			tableStr = tableStr + '			</tr>';
			tableStr = tableStr + '    	<tr>';
			tableStr = tableStr + '    		<td width="71" height="40" align="center" valign="bottom">自</td>';
			tableStr = tableStr + '				<td height="40" colspan="4" align="left" valign="bottom" class="xiahua2">'+resultObject.root[0].xzqhName+'</td>';
			tableStr = tableStr + '		      <td width="105" height="40" align="center" valign="bottom" class="STYLE8">（迁出地）迁入</td>';
			tableStr = tableStr + '		      <td width="179" align="left" valign="bottom" class="xiahua2">'+resultObject.root[0].moveoutAddrss+'</td>';
			tableStr = tableStr + '		      <td width="105" align="center" valign="bottom" class="STYLE8">（迁入地）</td>';
			tableStr = tableStr + '			</tr>';
			tableStr = tableStr + '    	<tr>';
			tableStr = tableStr + '				<td height="40" colspan="3"  align="left" valign="bottom" class="STYLE8">迁址原因：</td>';
			tableStr = tableStr + '				<td colspan="5" align="left" valign="bottom" class="xiahua2">'+resultObject.root[0].moveoutReason+'</td>';
			tableStr = tableStr + '			</tr>';
			tableStr = tableStr + '    	<tr>';           
			tableStr = tableStr + '    		<td height="40" colspan="4" align="left" valign="bottom" class="STYLE8">证书回收情况：</td>';            
			tableStr = tableStr + '    		<td align="left" valign="bottom">□ 正本&nbsp;&nbsp;'+resultObject.root[0].zbsl+'个</td>';
			tableStr = tableStr + '			<td align="left" valign="bottom">□ 纸质副本&nbsp;&nbsp;'+resultObject.root[0].fbsl+'个</td>';
			tableStr = tableStr + '    		<td align="center" colspan="2" valign="bottom">□ 电子副本&nbsp;&nbsp;'+resultObject.root[0].fksl+'个</td>';
			tableStr = tableStr + '    	</tr>';  
			tableStr = tableStr + '    	<tr>';            
			tableStr = tableStr + '   			<td height="46" colspan="2"  align="left" valign="bottom" class="STYLE8">经 办 人：</td>';            
			tableStr = tableStr + '				<td height="46" colspan="3"  align="left" valign="bottom" class="xiahua2"">'+resultObject.root[0].tbrxm+'</td>';
			tableStr = tableStr + '		      <td height="46" align="center" valign="bottom" class="STYLE9">联系电话：</td>';        
			tableStr = tableStr + '				<td align="left" valign="bottom" class="xiahua2">'+resultObject.root[0].tbrlxfs+'</td>';
			tableStr = tableStr + '				<td class="STYLE9" align="center">&nbsp;</td>';
			tableStr = tableStr + '   		</tr>';          
			tableStr = tableStr + '   		<tr>';           
			tableStr = tableStr + '    		<td height="50" colspan="2" align="left" valign="bottom" class="STYLE9" div>受 理 人：</td>';            
			tableStr = tableStr + '   			<td height="50" colspan="3" align="left" valign="bottom" class="xiahua2">'+currentZzUser+'</td>';
			tableStr = tableStr + '   			<td  align="center" valign="bottom"><span class="STYLE9">办理日期：</span></td>';
			tableStr = tableStr + '				<td  align="left" valign="bottom" class="xiahua2">'+myDate.format('Y-m-d')+'</td>';
			tableStr = tableStr + '				<td  align="center">&nbsp;</td>';
			tableStr = tableStr + '    	</tr>';          
			tableStr = tableStr + '    	<tr>';            
			tableStr = tableStr + '    		<td height="47" colspan="4" align="left" valign="bottom" class="STYLE9" div>代码管理机构:</td>';            
			tableStr = tableStr + '				<td colspan="3" align="left" valign="bottom" class="xiahua2">'+currentZzUserBzjgmc+'</td>';
			tableStr = tableStr + '				<td align="left" valign="bottom"><span class="STYLE9">（签章） </span></td>';
			tableStr = tableStr + '			</tr>';
			tableStr = tableStr + '		</table>';
			tableStr = tableStr + '   	<p>&nbsp;</p>';
			tableStr = tableStr + '	  </div>';
			tableStr = tableStr + '	<br><br><br><br>';
			
			
			tableStr = tableStr + '		<div id="xiahua">';
			tableStr = tableStr + '		<table  id="table" width=689; cellpadding= "0" cellspacing= "0"  border="0"><tr><td height="54" align="center" class="STYLE18 STYLE19">迁址证明</td></tr></table>';
			tableStr = tableStr + '		<table id="table4" style="border-collapse:collapse; " cellpadding= "0" cellspacing= "0" border= "0" > ';         
			tableStr = tableStr + '			<tr>';
			tableStr = tableStr + '    		<td height="40" colspan="4" align="left" valign="bottom" class="STYLE8">组织机构代码：</td>';
			tableStr = tableStr + '		  		<td width="231" align="left" valign="bottom" class="xiahua2">'+resultObject.root[0].jgdm+'</td>';
			tableStr = tableStr + '    		<td width="105" align="left">&nbsp;</td><td width="179" align="center">&nbsp;</td><td width="105" align="center">&nbsp;</td>';
			tableStr = tableStr + '		  </tr>';
			tableStr = tableStr + '    	<tr>';
			tableStr = tableStr + '    		<td height="40" colspan="4" align="left" valign="bottom" class="STYLE8">组织机构名称：</td>';
			tableStr = tableStr + '   			<td colspan="4"  align="left" valign="bottom" class="xiahua2">'+resultObject.root[0].jgmc+'</td>';
			tableStr = tableStr + '			</tr>';
			tableStr = tableStr + '    	<tr>';
			tableStr = tableStr + '    		<td width="71" height="40" align="center" valign="bottom">自</td>';
			tableStr = tableStr + '				<td height="40" colspan="4" align="left" valign="bottom" class="xiahua2">'+resultObject.root[0].xzqhName+'</td>';
			tableStr = tableStr + '		      <td width="105" height="40" align="center" valign="bottom" class="STYLE8">（迁出地）迁入</td>';
			tableStr = tableStr + '		      <td width="179" align="left" valign="bottom" class="xiahua2">'+resultObject.root[0].moveoutAddrss+'</td>';
			tableStr = tableStr + '		      <td width="105" align="center" valign="bottom" class="STYLE8">（迁入地）</td>';
			tableStr = tableStr + '			</tr>';
			tableStr = tableStr + '    	<tr>';
			tableStr = tableStr + '				<td height="40" colspan="3"  align="left" valign="bottom" class="STYLE8">迁址原因：</td>';
			tableStr = tableStr + '				<td colspan="5" align="left" valign="bottom" class="xiahua2">'+resultObject.root[0].moveoutReason+'</td>';
			tableStr = tableStr + '			</tr>';
			tableStr = tableStr + '    	<tr>';           
			tableStr = tableStr + '    		<td height="40" colspan="4" align="left" valign="bottom" class="STYLE8">证书回收情况：</td>';            
			tableStr = tableStr + '    		<td align="left" valign="bottom">□ 正本&nbsp;&nbsp;'+resultObject.root[0].zbsl+'个</td>';
			tableStr = tableStr + '			<td align="left" valign="bottom">□ 纸质副本&nbsp;&nbsp;'+resultObject.root[0].fbsl+'个</td>';
			tableStr = tableStr + '    		<td align="center" colspan="2" valign="bottom">□ 电子副本&nbsp;&nbsp;'+resultObject.root[0].fksl+'个</td>';
			tableStr = tableStr + '    	</tr>';  
			tableStr = tableStr + '    	<tr>';            
			tableStr = tableStr + '   			<td height="46" colspan="2"  align="left" valign="bottom" class="STYLE8">经 办 人：</td>';            
			tableStr = tableStr + '				<td height="46" colspan="3"  align="left" valign="bottom" class="xiahua2"">'+resultObject.root[0].tbrxm+'</td>';
			tableStr = tableStr + '		      <td height="46" align="center" valign="bottom" class="STYLE9">联系电话：</td>';        
			tableStr = tableStr + '				<td align="left" valign="bottom" class="xiahua2">'+resultObject.root[0].tbrlxfs+'</td>';
			tableStr = tableStr + '				<td class="STYLE9" align="center">&nbsp;</td>';
			tableStr = tableStr + '   		</tr>';          
			tableStr = tableStr + '   		<tr>';           
			tableStr = tableStr + '    		<td height="50" colspan="2" align="left" valign="bottom" class="STYLE9" div>受 理 人：</td>';            
			tableStr = tableStr + '   			<td height="50" colspan="3" align="left" valign="bottom" class="xiahua2">'+currentZzUser+'</td>';
			tableStr = tableStr + '   			<td  align="center" valign="bottom"><span class="STYLE9">办理日期：</span></td>';
			tableStr = tableStr + '				<td  align="left" valign="bottom" class="xiahua2">'+myDate.format('Y-m-d')+'</td>';
			tableStr = tableStr + '				<td  align="center">&nbsp;</td>';
			tableStr = tableStr + '    	</tr>';          
			tableStr = tableStr + '    	<tr>';            
			tableStr = tableStr + '    		<td height="47" colspan="4" align="left" valign="bottom" class="STYLE9" div>代码管理机构:</td>';            
			tableStr = tableStr + '				<td colspan="3" align="left" valign="bottom" class="xiahua2">'+currentZzUserBzjgmc+'</td>';
			tableStr = tableStr + '				<td align="left" valign="bottom"><span class="STYLE9">（签章） </span></td>';
			tableStr = tableStr + '			</tr>';
			tableStr = tableStr + '		</table>';
			tableStr = tableStr + '   	<p>&nbsp;</p>';
			tableStr = tableStr + '	  </div>';
			tableStr = tableStr + '</center></body></html>';
				 
			var titleHTML = tableStr;// document.getElementById("printGridfff").innerHTML;     
			var newwin = window.open('printer.jsp', 'printWindow', 'menubar=yes,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no,titlebar=yes,z-look=yes,menubar=yes');     
			  
			newwin.document.write(titleHTML);     
			//newwin.document.location.reload();     
			//newwin.print();     
			//newwin.close();     
		
						/////////////////////////
   					}
   				},
   				failure: function(){
   					ajaxLoadMask .hide();
   					Ext.Msg.show({
						title : '提示',
						msg : '打印失败！',
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.ERROR
					});
   				}
			});
		}else{
			Ext.Msg.show({
				title : '提示',
				msg : '请保存信息后，再进行打印！',
				buttons : Ext.Msg.OK,
				icon : Ext.Msg.ERROR
			});
		}
	}
});

var btn_saveInfo_qianchu = new Ext.Button({
	text : '保存数据',
	iconCls : 'blist',
	handler : btn_qianchu_saveInfo
});

var btn_ok_qianchu = new Ext.Button({
	text : '确认提交',
	iconCls : 'icon-store',
	handler : btn_qianchu_saveAll
});


var p_zzQianchu = {
	id : 'zzQianchu-panel',
	border : false,
	layout : 'border',
	bodyStyle: 'padding:0px',
	items : [{
		id:'border-panel',
	    layout:'border',
	    bodyBorder: false,
	    title: '迁出',
	    iconCls : 'icon-plugin',
 		plain: true,
		region: 'center',
		tbar : [btn_refresh_qianchu,btn_del_qianchu,/*btn_save_qianchu_menu*/btn_saveInfo_qianchu,btn_print_qzd,btn_ok_qianchu,'->',text_search_qianchu,btn_search_qianchu],
		items: [qianchuViewForm2,fileFtpForm_qianchu]
	}]
}