var btn_search_pzjg_yufuma = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchPzjg_yufuma();
		//btn_search_pzjg_yufuma.setDisabled(true);
	}
});


var text_search_pzjg_yufuma = new Ext.form.TextField({
	id : 'textSearchPzjg_yufuma',
	name : 'textSearchPzjg_yufuma',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchPzjg_yufuma();
			}
		},
		'change' : function(field, e) {
			btn_search_pzjg_yufuma.setDisabled(false);
		}
	}
});


var cm_pzjg_yufuma = new Ext.grid.ColumnModel([
	{header : '批准机构名称',width : 50,dataIndex : 'pzjgmc',sortable : true}, 
	{header : '批准机构代码',width : 20,dataIndex : 'pzjgdm',sortable : true},
	{header : '备注',width : 30,dataIndex : 'note',sortable : true}
]);


//查询返回结果的数据列
var ds_pzjg_yufuma = new Ext.data.Store({
	url : 'findAllByConditionPzjg.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'pzjgid',type : 'int'}, 
		{name : 'pzjgmc',type : 'string'},
		{name : 'pzjgdm',type : 'string'},
		{name : 'note',type : 'string'}
	])
});

var searchPzjg_yufuma = function() {
	ds_pzjg_yufuma.baseParams.conditions = text_search_pzjg_yufuma.getValue();
	ds_pzjg_yufuma.baseParams.username='';
	ds_pzjg_yufuma.baseParams.stateConditions='';
	ds_pzjg_yufuma.load({params : {start : 0,limit : 20} });
}

var grid_pzjg_yufuma = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_pzjg_yufuma,
	ds : ds_pzjg_yufuma,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入登记批准机构名称：',text_search_pzjg_yufuma,btn_search_pzjg_yufuma],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_pzjg_yufuma,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_pzjgQuery_yufuma.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			yufumaViewForm.getForm().findField('select_pzjgmc_yufuma').setValue(selections[0].get('pzjgmc'));
			yufumaViewForm.getForm().findField('select_pzjgdm_yufuma').setValue(selections[0].get('pzjgdm'));
		}
	}
});


var window_pzjgQuery_yufuma = new Ext.Window({
	title : '登记批准机构查询',
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
	items : [grid_pzjg_yufuma]
});

//--------------------机构基本信息-------------------------------------------
var yufumaViewForm = new Ext.FormPanel({	
	url : 'saveOrgnew.action',
	labelAlign : 'right',
    bodyStyle:'padding:0px',
	labelWidth : 80,
	border : false,
	baseCls : 'x-plain',
	waitMsgTarget: true,
	//autoScroll : true,
	//autoHeight : true,
	layout: 'fit',
	items:[{
        layout:'column',
        border:false,
        autoScroll : true,
        baseCls : 'x-plain',
        items:[{
		        columnWidth:.25,
		        layout: 'form',
		        border:false,
		        items: [
		            new Ext.form.TriggerField({
						id:"select_pzjgdm_yufuma",
						name:"pzjgdm",
						fieldLabel:"批准机构",
					 	valueField : "pzjgdm",
					    displayField : "pzjgdm",
					    maxLength : 9,
					    minLength : 9,
					    anchor:'97%',
					    labelSeparator:'',
					    allowBlank : false,
					    haveShow : false,
					    editable : false,
					    onTriggerClick : function() {
					    	window_pzjgQuery_yufuma.show();
					    },listeners : {
							'specialkey' : function(field, e) {
								if (e.getKey() == Ext.EventObject.ENTER) {
									findPzjgNameByCode(field);
								}
							},
							'blur': function(field){
								findPzjgNameByCode(field);
							}
						}
				    })
				]
		    },{
		        columnWidth:.75,
		        layout: 'form',
		        border:false,
		        items: [
		        	{xtype:'textfield',fieldLabel : '批准机构名称',name:'pzjgmc',labelSeparator:'',id:"select_pzjgmc_yufuma",hideLabel:true,allowBlank : false,anchor:'99.9%'}
		        ]
		    },{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '机构代码',name : 'jgdm',id:'jgdm_yufuma',labelSeparator:'',allowBlank : true,vtype:'verifyCode',readOnly:'true',maxLength : 9,minLength:9,anchor:'100%'}]
			},{
                columnWidth:.75,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '机构名称',name : 'jgmc',id:'jgmc_yufuma',labelSeparator:'',allowBlank : false,maxLength : 100,anchor:'99.9%'}]
			},{
                columnWidth:1,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '机构地址',name : 'jgdz',id:'jgdz_yufuma',labelSeparator:'',maxLength : 100,anchor:'99.9%',value:'湖北省武汉市'}]
			},{
				columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [new Ext.form.DateField({  
		                id:'pwrq_yufuma',
		                name: 'pwrq',
		                format:'Y-m-d',
		                maxValue:myDate,  
		                maxText:'所选日期应在{0}之前',  
		                minValue:'01/01/1900',
		                minText:'所选日期应在{0}之后',
		                anchor:'100%',
		                allowBlank : false,
		                labelSeparator:'',
		                fieldLabel:'批文日期',
		                renderer:dateFormat,
					    altFormats :'m/d/Y|m-d-y|m-d-Y|m/d|m-d|d|Ymd'
				    })]
			},{
				columnWidth:.45,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ 
                	xtype:'textfield',fieldLabel : '批准文号',name : 'pzwh',labelSeparator:'',
                	allowBlank : false,maxLength : 60,anchor:'99.9%',
                	enableKeyEvents:true,
	                		listeners: {
	                			keyup: function(f,e){
	                				yufumaViewForm.findById('pzwh_yufuma').setText("("+f.getValue().length+")");
	                			}
	                		}
                }]
			},{
				columnWidth : .05,
				layout : 'form',
				border : false,
				baseCls : 'x-plain',
				defaultType : 'label',
				items : [{id:'pzwh_yufuma',name:'pzwh_yufuma',text:'(0)'}]
		    },{
	                columnWidth:.3,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '经办人',name : 'tbrxm',labelSeparator:'',maxLength : 30,anchor:'97%'}]
			},{
	                columnWidth:.15,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [{	xtype : 'combo',
							fieldLabel : '证件类型',
							id : 'zjlx2_yufuma',
							name:'tbrzjlx',
							hiddenName : 'tbrzjlx',
							valueField : 'categoryName',
							displayField : 'categoryName',
							mode : 'remote',
							store : ds_zjlx_select,
							selectOnFocus : true,
							editable : false,
							labelSeparator:'',
							//readOnly:true,
							maxLength : 25,
							anchor:'100%',
							hideLabel:true,
							//onTriggerClick : Ext.emptyFn,
							triggerAction : 'all',
							loadingText : '加载中...',
							value:'居民身份证',
							listeners : {
							'select' : function(combo, record, index) {
								if(record.data.categoryName=='居民身份证'){
									var flag = isIdCardNo(yufumaViewForm.getForm().findField('tbrsfzh').getValue());
									if(flag != true){
										yufumaViewForm.getForm().findField('tbrsfzh').focus();
									}
								}else{
									yufumaViewForm.getForm().findField('tbrsfzh').focus();
								}
							}
						}
						}]
				},{
	                columnWidth:.27,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [{
	                	xtype:'textfield',fieldLabel : '证件号码',name : 'tbrsfzh',labelSeparator:'',hideLabel:true,confirmTo:'zjlx2_yufuma',vtype:'sfzhao',maxLength : 50,anchor:'95%',
	                	enableKeyEvents: true,
						listeners : {
							keyup: function(f, e){//计数
					    		yufumaViewForm.findById('ts_yufuma').setText("("+f.getValue().length+")");
					    	}
						}	
					}]
				},{
					columnWidth : '.03',
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'label',
					items : [{id:'ts_yufuma',name:'ts_yufuma',text:'(0)'}]
				},{
	                columnWidth:.2,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [{ 
	                	xtype:'textfield',fieldLabel : '经办人电话',name : 'tbrlxfs',
	                	labelSeparator:'',vtype:'dhhmphone',maxLength : 50,anchor:'100%',
	                	enableKeyEvents:true,
	                		listeners: {
	                			keyup: function(f,e){
	                				yufumaViewForm.findById('tbrlxfs_yufuma').setText("("+f.getValue().length+")");
	                			}
	                		}
	                }]
				},{
					columnWidth : .05,
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'label',
					items : [{id:'tbrlxfs_yufuma',name:'tbrlxfs_yufuma',text:'(0)'}]
			    },{
                	columnWidth:1,
                	layout: 'form',
                	bodyStyle: 'padding:0px',
                	border:false,
                	items: [
                		{xtype:'textarea',fieldLabel : '备注',name : 'memo',labelSeparator:'',maxLength : 50,height:'60',anchor:'99.5%'},
	                	{xtype:'hidden',fieldLabel : '业务类型',name : 'ywlx',value:'预赋码'},
						{xtype : 'hidden',	name : 'orgid',value:''},
					    {xtype : 'hidden',	name : 'orderid',id:'orderid'},
					    {xtype : 'hidden',name : 'zbsl',value:'1'},
					    {xtype : 'hidden',name : 'docid'},
						{xtype : 'hidden',name : 'imageUrl'},
						{xtype : 'hidden',name : 'centerid',value:currentZzUserCenterid},
					    {xtype : 'hidden',name : 'bzjgdm',value:currentZzUserBzjgdm},
						{xtype : 'hidden',name : 'lastdate',value :myDate.format('Y-m-d')}, 
						{xtype : 'hidden',name : 'lry'},//textfield
						{xtype : 'hidden',name : 'xgr',value:currentZzUsername},
						{xtype : 'hidden',name : 'state',value:'12'}]
				}]
		}]
});



var  yufumaViewForm2= new Ext.Panel({
	 title       : '基本信息',
    id          : 'jbInfo26',
    region      : 'center',
    margins     : '3 0 0 0',
    cmargins    : '5 5 0 0',
	autoScroll : true,
	layout: 'fit',
	bodyStyle: 'padding:10px',
    items : [yufumaViewForm]
});


var fileFtpForm_yufuma = new Ext.Panel({
	title:'原文扫描',
	split: true,
	width:550,
	collapsible:true,
	collapsed: false,//是否默认打开
    region:'east',
    margins:'3 0 0 0',
    html: '<OBJECT classid="clsid:B4E2D33E-D8B2-4956-9F91-1C6BDC87A6D1"  width=100%  height=100% align=center hspace=0 vspace=0 id="scanner24628"  name="scanner24628" >'
	       +'<param name="ShowCount" value="8">'
	       +'<param name="sModel" value="1">'
	       +'</OBJECT>'
    
});


//默认查询 档案
var searchYufuma = function() {
	Ext.getCmp("jgmc_yufuma").getEl().dom.readOnly = false;
	yufumaViewForm.getForm().reader = Orgnews;
	yufumaViewForm.getForm().load({
		waitMsg : '正在进行数据查询，请稍等',          //提示信息   
        waitTitle : '提示',                         //标题  
	    url: 'findAllYwqxOrgnew.action', //请求控制器获取数据
	    method: 'POST', //为"POST",则上面的url不会显示在浏览器的地址栏中
	    params: { conditions:  text_search_yufuma.getValue(),username:currentZzUsername,ywlx:null,stateConditions:'10,11,12,13,14,15,16',start:1,limit:1},	
	    success:function(form,action) {//获取返回值
				    	//alert(action.result.data.orgid);
				    	if(action.result.data.ywlx=='预赋码' && (action.result.data.state=='12' || action.result.data.state=='14'  || action.result.data.state=='15')){//判断业务是否办理中
				    		
				    		btn_code_yufuma.setDisabled(isFumaBtnActive(action.result.data.jgdm,action.result.data.state,'新办',sysXcWorkMode,sysStrYwxcSet)); 
		    		
				    		btn_del_yufuma.setDisabled(false);
				    		//btn_save_yufuma_menu.setDisabled(false);
				    		
				    		var tab3452=Ext.getCmp("jbInfo26");
				    		tab3452.setTitle("基本信息  ("+stateToInfo(yufumaViewForm.getForm().findField('state').value,action.result.data.jgdm)+")");
				    		yufumaViewForm.getForm().findField('lastdate').setValue(myDate.format('Y-m-d'));
							yufumaViewForm.getForm().findField('xgr').setValue(currentZzUsername);
				    		yufumaViewForm.getForm().findField('bzjgdm').setValue(currentZzUserBzjgdm);
				    		if(action.result.data.state=='15'){
								yufumaViewForm.getForm().findField('jgdm_yufuma').allowBlank=false;
							}else{
								yufumaViewForm.getForm().findField('jgdm_yufuma').allowBlank=true;
							}
				    		var resultObject = null;
				            //alert(action.result.data.orgid);
				    		Ext.Ajax.request({
								url : 'orgnewViewImg.action',
								params : {orgid : action.result.data.orgid},
								//waitTitle: '提示',
							    //waitMsg: '数据正在重新加载中，请稍后',
								success : function(result,request) {//获取返回值
									scanner24628.ImageData="";
				   					var resultObject = Ext.util.JSON.decode(result.responseText); 
				   					if(resultObject!=null){
					   					scanner24628.OpenProgress(3);  //设置上传的进度条的总进度数
					   					scanner24628.Progress('原文加载中',1);
										scanner24628.Progress('原文加载中',2);
					   					scanner24628.ImageData=resultObject.imageData;
					   					scanner24628.pageType=resultObject.pageTypeStr;
					   					if(scanner24628.ImageData!=""){
					   						scanner24628.Progress('原文加载完毕',3);
											scanner24628.CloseProgress();
										}else{
											scanner24628.Progress('原文加载失败',3);
							   				scanner24628.CloseProgress();
							   				alert("原文错误，加载失败！");
										}
				   					}
								},
								failure : function() {
									scanner24628.ImageData="";
						   			scanner24628.CloseProgress();
									alert("图像加载错误，或者无原文");
								}
							});	
				
					}else{
						Ext.Msg.show({
							title : '提示',
							msg : '机构正在进行“'+action.result.data.ywlx+'”业务办理中!',
							buttons : Ext.Msg.OK,
							icon : Ext.Msg.INFO,
							fn : function() {
								btn_del_yufuma.setDisabled(true);
					    		
								yufumaViewForm.getForm().reset();
								scanner24628.ImageData="";
							}
						});
		            }
		},
		failure : function() {
			Ext.Msg.show({
				title : '提示',
				msg : '预赋码申请单未查到!',
				width:250,
				buttons : Ext.Msg.OK,
				icon : Ext.Msg.ERROR,
				fn:  function() {
					btn_del_yufuma.setDisabled(true);
					yufumaViewForm.getForm().reset();
					scanner24628.ImageData="";
				}
			});
		}	
	});
}

var btn_search_yufuma = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchYufuma();
	}
});

var text_search_yufuma = new Ext.form.TextField({
	id : 'textSearchYufuma',
	name : 'textSearchYufuma',
	width : 200,
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchYufuma();
			}
		}
	}
});


var btn_refresh_yufuma = new Ext.Button({
	text : '重置',
	iconCls : 'icon-refresh',
	handler : function() {
		btn_del_yufuma.setDisabled(true);
		btn_code_yufuma.setDisabled(true);
    	//btn_save_yufuma_menu.setDisabled(true);
		yufumaViewForm.getForm().reset();
		var tab3452=Ext.getCmp("jbInfo26");
	    tab3452.setTitle("基本信息");
		scanner24628.ImageData="";
		yufumaViewForm.getForm().findField('orgid').setValue('');
		yufumaViewForm.getForm().findField('jgdm_yufuma').allowBlank=true;
		Ext.getCmp("jgmc_yufuma").getEl().dom.readOnly = false;
	}
});

var btn_del_yufuma = new Ext.Button({
	text : '删除',
	iconCls : 'icon-del',
	disabled:true,
	handler : function() {
		var orgid = yufumaViewForm.getForm().findField('orgid').value;
		if(orgid!=null && orgid!=""){
			Ext.Msg.confirm('确认删除', '你确定删除吗?', function(btn) {
				if (btn == 'yes') {
					ajaxLoadMask.show();
					Ext.Ajax.request({
						url : 'deleteOrgnew.action',
						params : {orgid : orgid},
						success : function() {
							ajaxLoadMask.hide();
							btn_del_yufuma.setDisabled(true);
							yufumaViewForm.getForm().reset();
							var tab3452=Ext.getCmp("jbInfo26");
	    					tab3452.setTitle("基本信息");
							scanner24628.ImageData="";
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


//----------------------赋码  开始------------------------------------

var yufumaFumaForm = new Ext.FormPanel({
	url : 'saveOrgnewCode.action',
	labelAlign : 'right',
	labelWidth : 80,
	bodyStyle : 'padding:5px',
	border : false,
	baseCls : 'x-plain',
	defaultType : 'combo',
	defaults : {anchor:'95%'},
	items : [
		{xtype : 'textfield',fieldLabel : '机构代码',name : 'jgdm',allowBlank:false,readOnly:true},
		{xtype : 'hidden',name : 'orgid'},
		{xtype : 'hidden',name : 'centerid',value:currentZzUserCenterid},
		{xtype : 'hidden',name : 'docid'},
		{xtype : 'textfield',fieldLabel : '机构名称',name : 'jgmc',allowBlank:false,readOnly:true},
		{xtype : 'hidden',fieldLabel : '机构地址',name : 'jgdz',readOnly:true},
		{xtype : 'textfield',fieldLabel : '注册号',name : 'zch',allowBlank:false,readOnly:true},
		{xtype : 'combo',
			fieldLabel : '是否个体',
			id : 'dmlx_yufuma',
			name : 'dmlx',
			displayField : 'dmlx',
			valueField : 'dmlxCode',
			hiddenName : 'dmlxCode',
			store : getDmlxStore('yfm'),
			triggerAction : 'all',
			lazyRender:true,
			mode : 'local',
			value : '1',
			selectOnFocus : true,
			allowBlank:false,
			editable : false
		}
	],
	buttonAlign : 'right',
	minButtonWidth : 60,
	buttons : [{
		text:'取码',
		id:'btn_qm_yufuma',
		handler : function(btn){
			if(yufumaFumaForm.getForm().findField('dmlx_yufuma').getValue()!=""){
				
				var record = grid_code_creat_yufuma.getStore().getAt(0);
				
				btn.setText('取码');
				ds_code_creat_yufuma.removeAll();
				if(yufumaViewForm.getForm().findField('ywlx').getValue()=="预赋码" && yufumaViewForm.getForm().findField('pzwh').getValue()!==""){
					ds_code_creat_yufuma.baseParams.zch = yufumaViewForm.getForm().findField('pzwh').getValue();
				}else{
					ds_code_creat_yufuma.baseParams.zch = yufumaViewForm.getForm().findField('zch').getValue();
				}
				ds_code_creat_yufuma.baseParams.orgid = yufumaViewForm.getForm().findField('orgid').getValue();
				ds_code_creat_yufuma.baseParams.state = yufumaViewForm.getForm().findField('state').getValue();
				ds_code_creat_yufuma.baseParams.jgmc = yufumaViewForm.getForm().findField('jgmc').getValue();
				ds_code_creat_yufuma.baseParams.jgdz = yufumaViewForm.getForm().findField('jgdz').getValue();
				ds_code_creat_yufuma.baseParams.centerid=yufumaViewForm.getForm().findField('centerid').getValue();
				ds_code_creat_yufuma.baseParams.dmlx=yufumaFumaForm.getForm().findField('dmlx_yufuma').getValue();//0 个体，3非个体
				if(record!=null && record.data.flag=='1'){
					ds_code_creat_yufuma.baseParams.flag='1';//0需判断，1不需判断
				}else{
					ds_code_creat_yufuma.baseParams.flag='0';//0需判断，1不需判断
				}					
				ds_code_creat_yufuma.load({
					callback: function(records, options, success){
						if(records!=null){
							if(records[0].data.flag=='1'|| records[0].data.flag=='3'){
								btn.setText('重新取码');
							}else if(records[0].data.flag=='0'){
								yufumaFumaForm.getForm().findField('jgdm').setValue(records[0].data.jgdm);
								var btn345296781=Ext.getCmp("btn_qm_yufuma");
								btn345296781.disable();
								var btnTrueYufuma=Ext.getCmp("btn_true_yufuma");
								btnTrueYufuma.enable();
								var btnFalseYufuma=Ext.getCmp("btn_false_yufuma");
								btnFalseYufuma.disable();
							}else{
								btn.disable();
								var btnTrueYufuma=Ext.getCmp("btn_true_yufuma");
								btnTrueYufuma.disable();
								var btnFalseYufuma=Ext.getCmp("btn_false_yufuma");
								btnFalseYufuma.enable();
							}
						}
					}
				});		
			}else{
				alert("请选择“是否个体” ！");
			}
		}
	},{
		text:'确定',
		id: 'btn_true_yufuma',
		handler : function(btn){
			if(yufumaFumaForm.getForm().isValid()){
				yufumaFumaForm.getForm().submit({
					waitTitle : '请稍候',
					waitMsg : '正在修改数据,请稍候...',
					success : function(form) {
						yufumaViewForm.getForm().findField('jgdm').setValue(yufumaFumaForm.getForm().findField('jgdm').getValue());
						ds_code_creat_yufuma.removeAll();
						window_fuma_yufuma.hide();
						var btn34529321=Ext.getCmp("btn_qm_yufuma");
						 //btn34529321.setText("取码");
						btn34529321.enable();
						var tab34529=Ext.getCmp("jbInfo26");
					    tab34529.setTitle("基本信息(赋码成功，请提交确认)");
					    btn_code_yufuma.setDisabled(true);
					    Ext.getCmp("jgmc_yufuma").getEl().dom.readOnly = true;
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
			}
		}
	},{
		text : '取消',
		id : 'btn_false_yufuma',
		handler:function(){
			yufumaFumaForm.getForm().reset();
			ds_code_creat_yufuma.removeAll();
			var btn34529321=Ext.getCmp("btn_qm_yufuma");
			 btn34529321.setText("取码");
			 btn34529321.enable();
			this.ownerCt.ownerCt.ownerCt.hide();
		}
	}]
});

//信息浏览
var  archivesDoCODE_yufuma= new Ext.Panel({
    region      : 'center',
    margins   : '3 3 0 3', 
    activeTab : 1,
    items : [yufumaFumaForm]
}); 

var ds_code_creat_yufuma=new Ext.data.Store({
	url : 'returnOrgnewCode.action',
	reader : new Ext.data.JsonReader({
		root : 'root'
	}, [
		{name : 'jgdm',type : 'string'},{name : 'jgmc',type : 'string'},
		{name : 'zch',type : 'string'},{name : 'flag',type : 'string'},
		{name : 'info',type : 'string'}
	])
})

var cm_code_creat_yufuma = new Ext.grid.ColumnModel([
   {header : '机构代码',width:15,dataIndex : 'jgdm',sortable : true}, 
   {header : '机构名称',width:25,dataIndex : 'jgmc',id:'jgmc_yufuma_code',sortable : true}, 
   {header : '注册号',width:20,dataIndex : 'zch',sortable : true},
   {header : '备注',width:20,dataIndex : 'flag',renderer : goStateFlag,sortable : true},
   {header : '信息',width:20,dataIndex : 'info',hidden:true,sortable : true}
]);

yufumaCodeListPanel = Ext.extend(Ext.grid.GridPanel,{
	constructor:function(){
		yufumaCodeListPanel.superclass.constructor.call(this,grid_code_creat_yufuma);
	}
});

var grid_code_creat_yufuma = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	cm : cm_code_creat_yufuma,
	ds : ds_code_creat_yufuma,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'jgmc_yufuma_code',
	viewConfig : {forceFit : true}/*,
	listeners : {
		'rowclick':function(grid,rowIndex){
			var btn345296781=Ext.getCmp("btn_qm_yufuma");
			if(grid.getStore().getAt(rowIndex).data.flag=='1' || grid.getStore().getAt(rowIndex).data.flag=='3'){
				yufumaFumaForm.getForm().findField('jgdm').setValue(grid.getStore().getAt(rowIndex).data.jgdm);
				btn345296781.disable();
				var btnTrueYufuma=Ext.getCmp("btn_true_yufuma");
				btnTrueYufuma.enable();
				var btnFalseYufuma=Ext.getCmp("btn_false_yufuma");
				btnFalseYufuma.disable();
    		}else{
    			if(grid.getStore().getAt(rowIndex).data.flag=='4'){
			 		btn345296781.setText("重新取码");
    			}
    		}
		}
	}*/
});

var window_fuma_yufuma = new Ext.Window({
	title : '机构赋码',
	iconCls : 'icon-plugin',
	width : 570,
	height : 400,
	x:'250',
	y:'120',
	resizable : true,
	modal : true,
	plain    : true,
	layout   : 'border',
	closable : false,
	closeAction : 'close',
	listeners : {
		/*'hide' : function(){
			yufumaFumaForm.getForm().reset();
			var btn34529678112=Ext.getCmp("btn_qm_yufuma");
			btn34529678112.setText("取码");
			btn34529678112.disable();
		},*/
		'show' : function(){
			yufumaFumaForm.getForm().reset();
			var btnyufuma=Ext.getCmp("btn_qm_yufuma");
			btnyufuma.enable();
			var btnTrueYufuma=Ext.getCmp("btn_true_yufuma");
			btnTrueYufuma.disable();
			var btnFalseYufuma=Ext.getCmp("btn_false_yufuma");
			btnFalseYufuma.enable();
		}
	},
	items:[archivesDoCODE_yufuma,{
	    region: 'south',
	    layout :'fit',
		title : '编码列表',
	    height: 170,
	    minSize: 100,
	    border : false,
	    maxSize: 250,
	    //北,东，南，西
	    margins     : '0 3 3 3',
    	cmargins    : '5 0 0 0',
	    items : [new yufumaCodeListPanel()]
	}]
});

var btn_code_yufuma = new Ext.Button({
	text : '赋码',
	iconCls : 'icon-add',
	disabled:true,
	handler : function(){
		window_fuma_yufuma.show();
		yufumaFumaForm.getForm().findField('orgid').setValue(yufumaViewForm.getForm().findField('orgid').getValue());
		yufumaFumaForm.getForm().findField('jgmc').setValue(yufumaViewForm.getForm().findField('jgmc').getValue());
		yufumaFumaForm.getForm().findField('jgdz').setValue(yufumaViewForm.getForm().findField('jgdz').getValue());
		yufumaFumaForm.getForm().findField('zch').setValue(yufumaViewForm.getForm().findField('pzwh').getValue());
		yufumaFumaForm.getForm().findField('centerid').setValue(yufumaViewForm.getForm().findField('centerid').getValue());
	}
});
//---------------------- 赋码结束 ------------------------------------

var btn_save_yufuma_menu = new Ext.Toolbar.MenuButton({
    text: '保存',
    handler: btn_yufuma_saveAll,
    tooltip: {title:'保存数据和原文',text:'保存'},
    iconCls: 'blist',
    //disabled:true,
    menu : {items: [
                {text: '全部保存', handler: btn_yufuma_saveAll}, '-',
                {text: '仅保存数据', handler: btn_yufuma_saveInfo},
                {text: '仅上传原文', handler: btn_yufuma_ftpFile}
        ]}
});

var upFuncYFM = function(docid,orgid,strJgdm,strState,strYwlx,strJgmc){
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
				strBzjgdm=yufumaViewForm.getForm().findField('bzjgdm').value; 
				packLength = 40960;	//定义每个包的大小40960
				//scanner24628.ImageData=document.getElementById("ImageData").value;
				base64file = scanner24628.ImageData;  //获取控件扫描的图片数据
				var baseSize = base64file.length;  //获取控件图片数据的64位编码的长度
				imageCount = scanner24628.ImageCount;	//获取扫描图片的页数
				pageTypeStr = scanner24628.PageType;    //获取标识字符串,需要写数据库
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
				scanner24628.OpenProgress(packCount);  //设置上传的进度条的总进度数
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
							scanner24628.Progress('上传中',i+1);
						}
						else
						{
							alert("上传失败，请重试0001。");
							//scanner24628.ShowSendMsg(false);
							
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
					msg : '['+yufumaViewForm.getForm().findField('jgmc_yufuma').getValue()+']，<br><br>申办信息保存成功！',
					buttons : Ext.Msg.OK,
					fn : function() {
						//alert(sysStrYwxcSet);
						if(sysXcWorkMode=='0'){
							btn_code_yufuma.setDisabled(false);
						}
						scanner24628.CloseProgress();
						subYFMAction(orgid,strJgdm,strState,strYwlx,strJgmc);
					},
					icon : Ext.Msg.INFO
				});
}

function btn_yufuma_saveAll(btn){
	if (yufumaViewForm.getForm().isValid()) {
		var strdocid = yufumaViewForm.getForm().findField('docid').getValue();
		var strjgmc = yufumaViewForm.getForm().findField('jgmc').getValue();
		if(!validateJgmc(strjgmc,strdocid)){
			return
		}
		yufumaViewForm.getForm().submit({
			waitTitle : '请稍候',
			waitMsg : '正在保存数据,请稍候...',
			success : function(form,action) {
				
				yufumaViewForm.getForm().findField('orgid').setValue(action.result.orgid);
				yufumaViewForm.getForm().findField('docid').setValue(action.result.docid);
				
				var orgid = yufumaViewForm.getForm().findField('orgid').getValue();
				var docid = action.result.docid;
		var strState = yufumaViewForm.getForm().findField('state').getValue();
		var strJgmc = yufumaViewForm.getForm().findField('jgmc_yufuma').getValue();
		var strJgdm = yufumaViewForm.getForm().findField('jgdm_yufuma').getValue();
		var strYwlx = yufumaViewForm.getForm().findField('ywlx').getValue();
				
				if(scanner24628.ImageCount>0){
					if(orgid!=null && orgid!=''){
			if((strState=='15' && strJgdm=='')){
				Ext.Msg.show({
					title : '提示',
					msg : '请赋码后，再提交！',
					buttons : Ext.Msg.OK,
					icon : Ext.Msg.INFO
				});
			}else{
				
				refreshImageFlag(orgid,'1');
				upFuncYFM(docid,orgid,strJgdm,strState,strYwlx,strJgmc);
				/*Ext.Ajax.request({
					url: 'checkArchive.action',
					params: {orgid: orgid,jgdm:strJgdm},
					success: function(result,request){//result,request
						var data = Ext.util.JSON.decode(result.responseText);
						//alert("预赋码|"+data.jglxdmOld+"|"+data.zchInfo+"|"+data.frInfo);
						var str = scanner24628.CheckArchives("预赋码",data.jglxdmOld,data.zchInfo,data.frInfo);
						
						if(str==''){
							//alert("更新imageFlag为1（表示档案完整）");
							refreshImageFlag(orgid,'1');
							upFuncYFM(docid,orgid,strJgdm,strState,strYwlx,strJgmc);
						}else{
							//alert(str+"::更新imageFlag为0（表示档案不完整）");
							Ext.Msg.show({
								title : '提示',
								msg : str + '继续提交则选是,取消提交则选否！',
								buttons : Ext.Msg.OKCANCEL,
								fn : function(btn){
									if(btn == 'ok'){
										refreshImageFlag(orgid,'0');
										upFuncYFM(docid,orgid,strJgdm,strState,strYwlx,strJgmc);
									}else{
										refreshImageFlag(orgid,'0');
									}
								},
								icon : Ext.Msg.INFO
							});
						}
					}
				});*/
			}
		}else{
			Ext.Msg.show({
				title : '提示',
				msg : '请保存信息后，再提交审核！',
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
										subYFMAction(orgid,strJgdm,strState,strYwlx,strJgmc);
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
					msg : '著录信息保存失败',
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

function btn_yufuma_saveInfo(btn){
	if (yufumaViewForm.getForm().isValid()) {
		var strdocid = yufumaViewForm.getForm().findField('docid').getValue();
		var strjgmc = yufumaViewForm.getForm().findField('jgmc').getValue();
		if(!validateJgmc(strjgmc,strdocid)){
			return
		}
		yufumaViewForm.getForm().submit({
			waitTitle : '请稍候',
			waitMsg : '正在保存数据,请稍候...',
			success : function(form,action) {
				
				yufumaViewForm.getForm().findField('orgid').setValue(action.result.orgid);
				yufumaViewForm.getForm().findField('docid').setValue(action.result.docid);
				
				if(sysXcWorkMode=='0'){
					btn_code_yufuma.setDisabled(false);
				}
				Ext.Msg.show({
					title : '提示',
					msg : '['+yufumaViewForm.getForm().findField('jgmc_yufuma').getValue()+']，<br><br>申办信息保存成功！',
					buttons : Ext.Msg.OK,
					fn : function() {btn.enable();},
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

function btn_yufuma_ftpFile(btn){
	
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
	strOrgid =yufumaViewForm.getForm().findField('orgid').value;  //参数orgid
	strDocid =yufumaViewForm.getForm().findField('docid').value;  //参数docid
	strBzjgdm=yufumaViewForm.getForm().findField('bzjgdm').value;  //办证机构代码
	
	//alert("strOrgid="+strOrgid);
	
	if(strOrgid!=""){
			packLength = 40960;	//定义每个包的大小40960
			//scanner24628.ImageData=document.getElementById("ImageData").value;
			base64file = scanner24628.ImageData;  //获取控件扫描的图片数据
			var baseSize = base64file.length;  //获取控件图片数据的64位编码的长度
			imageCount = scanner24628.GetPageCount;	//获取扫描图片的页数
			pageTypeStr = scanner24628.PageType;    //获取标识字符串,需要写数据库
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
			scanner24628.OpenProgress(packCount);  //设置上传的进度条的总进度数
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
						scanner24628.Progress('上传中',i+1);
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
			
			scanner24628.CloseProgress();
			
			Ext.Msg.show({
				title : '提示',
				msg : '['+yufumaViewForm.getForm().findField('jgmc_yufuma').getValue()+']，<br><br>原文上传成功！',
				buttons : Ext.Msg.OK,
				fn : function() {btn.enable();},
				icon : Ext.Msg.INFO
			});
			
			scanner24628.CloseProgress();
			return true;
	}else{
		alert("请录入数据后，再上传原文！");
	}
}

//提交确认方法
var subYFMAction =function (orgid,strJgdm,strState,strYwlx,strJgmc){
	ajaxLoadMask.show();
	Ext.Ajax.request({
		url: 'returnOrgnewDo.action',
		params: {orgid: orgid,jgdm:strJgdm,state:strState,ywlx:strYwlx},
		success: function(result,request){
			ajaxLoadMask.hide();
			
			eval("var data= "+result.responseText);
			//alert(data.state);
			if(data.state=='15'){
				btn_code_yufuma.setDisabled(false); 
		    	yufumaViewForm.getForm().findField('state').setValue(data.state);
		    	yufumaViewForm.getForm().findField('jgdm_yufuma').allowBlank=false;
			}else{
				Ext.Msg.show({
					title : '提示',
					msg : '[' + strJgmc + ']申请单办理完毕！',
					buttons : Ext.Msg.OK,
					fn:  function() {
	   					yufumaViewForm.getForm().findField('orgid').setValue('');
	     				btn_code_yufuma.setDisabled(true);
	   					
	   					yufumaViewForm.getForm().findField('jgdm_yufuma').allowBlank=true;
	   					var tab3452=Ext.getCmp("jbInfo26");
			    		tab3452.setTitle("基本信息");	
						yufumaViewForm.getForm().reset();
						scanner24628.PageType="";
						scanner24628.ImageData="";
						text_search_yufuma.setValue("");
						Ext.getCmp("jgmc_yufuma").getEl().dom.readOnly = false;
					},
					icon : Ext.Msg.INFO
				});
			}
		},
		failure: function(){
			ajaxLoadMask .hide();
			Ext.Msg.show({
				title : '提示',
				msg : '[' + strJgmc + ']申请单办理失败！',
				buttons : Ext.Msg.OK,
				icon : Ext.Msg.ERROR
			});
		}
	});
}


var btn_saveInfo_yufuma = new Ext.Button({
	text : '保存数据',
	iconCls : 'blist',
	//disabled:true,
	handler : btn_yufuma_saveInfo
});

var btn_print_yufuma = new Ext.Button({
	text : '打印预赋码单',
	iconCls : 'icon-print',
	//disabled:true,
	handler : function(){
		var orgid = yufumaViewForm.getForm().findField('orgid').getValue();
		if(orgid!=null && orgid!=""){
			ajaxLoadMask .show();
			Ext.Ajax.request({
				url: 'findOrgnewByOrgid.action',
   				params: {orgid: orgid},
   				success: function(result,request){//获取返回值
   					ajaxLoadMask .hide();
   					var resultObject = Ext.util.JSON.decode(result.responseText);
   					if(resultObject.root.length!=0){
						
						/////////////////////////////
						var tableStr = '<html><head><meta http-equiv="Content-Type" content="text/html; charset=gb2312" /><title>组织机构代码档案管理系统--预赋码通知单打印</title>';
			tableStr = tableStr + '<style type="text/css">@media print{INPUT {display:none}} ';
			tableStr = tableStr + '		body{ width:910px; background-color: #CCCCCC;margin:20px auto;}';
			tableStr = tableStr + '		#xiahua {width:800px; padding:10px; border:0px #ffffff solid; background:white}';
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
			tableStr = tableStr + '    <br>';
			tableStr = tableStr + '		<div id="xiahua">';
			tableStr = tableStr + '		<table  id="table" width="689" cellpadding= "0" cellspacing= "0"  border="0">';
			tableStr = tableStr + '     	<tr><td  height="30" width="200" align="left"><input type="button" name="btnPrint" value="打　　印"  onclick="reportPrint()"/></td><td  width="350" align="right" >编号：〖'+myDate.getYear()+' 〗 </td><td width="149" align="right">第 '+resultObject.root[0].zslsh+' 号</td></tr>';
			tableStr = tableStr + '     	<tr><td height="54" colspan=3 align="center" class="STYLE18 STYLE19">全国组织机构代码赋码通知单(存根)</td></tr>';
			tableStr = tableStr + '			<tr><td height="40" colspan=3 align="left" class="STYLE8"><b>'+resultObject.root[0].pzjgmc+':</b></td></tr>';
			tableStr = tableStr + '			<tr><td height="40" colspan=3 align="left" class="STYLE8">&nbsp;&nbsp;&nbsp;&nbsp;下述机构已领取组织机构代码</td></tr>';
			tableStr = tableStr + '</table>';
			tableStr = tableStr + '		<table id="table4" width="689" style="border-collapse:collapse; " cellpadding= "0" cellspacing= "0"  border= "1" bordercolor= "#3366FF" > ';         
			tableStr = tableStr + '    		<tr>';
			tableStr = tableStr + '    			<td height="35" width="274" align="center"  class="STYLE8">组织机构名称</td>';
			tableStr = tableStr + '   			<td align="left" >&nbsp;'+resultObject.root[0].jgmc+'</td>';
			tableStr = tableStr + '			</tr>';
			tableStr = tableStr + '    		<tr>';
			tableStr = tableStr + '    			<td height="45" align="center"  class="STYLE8">批准文号<br>（或批准证书批准号）</td>';
			tableStr = tableStr + '				<td align="left" >&nbsp;'+resultObject.root[0].pzwh+'</td>';
			tableStr = tableStr + '			</tr>';
			tableStr = tableStr + '    		<tr>';
			tableStr = tableStr + '				<td height="45" align="center"  class="STYLE8">批文日期<br>（或批准证书颁发日期）</td>';
			tableStr = tableStr + '				<td align="left" >&nbsp;'+dateFormatToYMD(resultObject.root[0].pwrq)+'</td>';
			tableStr = tableStr + '				</tr>';
			tableStr = tableStr + '    		<tr>';           
			tableStr = tableStr + '    			<td height="35" align="center"  class="STYLE8">组织机构代码</td>';            
			tableStr = tableStr + '    			<td align="left">&nbsp;'+resultObject.root[0].jgdm+'</td>';;
			tableStr = tableStr + '    		</tr>';
			tableStr = tableStr + '    		<tr>';           
			tableStr = tableStr + '    			<td height="35" align="center"  class="STYLE8">赋码日期</td>';            
			tableStr = tableStr + '    			<td align="left">&nbsp;'+myDate.format('Y-m-d')+'</td>';;
			tableStr = tableStr + '    		</tr>';
			tableStr = tableStr + '		</table>';
			
			tableStr = tableStr + '		<table  id="table" width="689" cellpadding= "0" cellspacing= "0"  border="0">';
			tableStr = tableStr + '   		<tr>';
			tableStr = tableStr + '   			<td height="35" width="450" align="center" valign="bottom">&nbsp;</td>';
			tableStr = tableStr + '    			<td  align="left"  width="100" valign="bottom" class="STYLE9" div>填表人签字：</td>';            
			tableStr = tableStr + '   			<td  align="left" width="119" valign="bottom" class="xiahua2">'+resultObject.root[0].tbrxm+'</td>';
			tableStr = tableStr + '				<td  align="center" width="30">&nbsp;</td>';
			tableStr = tableStr + '    		</tr>';  
			tableStr = tableStr + '    		<tr>';            
			tableStr = tableStr + '   			<td height="40" align="center" valign="bottom">&nbsp;</td>';
			tableStr = tableStr + '				<td align="left" valign="bottom" class="xiahua2">&nbsp;</td>';
			tableStr = tableStr + '    			<td align="left" valign="bottom" class="STYLE9">（赋码机构盖章)</td>'; 
			tableStr = tableStr + '				<td align="left" valign="bottom">&nbsp;</td>';
			tableStr = tableStr + '			</tr>';
			tableStr = tableStr + '   		<tr>';
			tableStr = tableStr + '   			<td  height="30"  align="center" valign="bottom">&nbsp;</td>';
			tableStr = tableStr + '				<td  align="center" valign="bottom" colspan=3>'+myDate.format('Y-m-d')+'</td>';
			tableStr = tableStr + '    		</tr>';          
			tableStr = tableStr + '		</table>';
			tableStr = tableStr + '   	<br><br>';
			tableStr = tableStr + '<hr style="border:1 dashed #987cb9" width="689" color=#987cb9 SIZE=1>';
			tableStr = tableStr + '		<table  id="table" width="689" cellpadding= "0" cellspacing= "0"  border="0">';
			tableStr = tableStr + '     	<tr><td height="30" width="550" align="right" >编号：〖'+myDate.getYear()+' 〗 </td><td width="149" align="right">第 '+resultObject.root[0].zslsh+' 号</td></tr>';
			tableStr = tableStr + '     	<tr><td height="54" align="center" cospan=2 class="STYLE18 STYLE19">全国组织机构代码赋码通知单</td></tr>';
			tableStr = tableStr + '			<tr><td height="40" align="left" cospan=2 class="STYLE8"><b>'+resultObject.root[0].pzjgmc+':</b></td></tr>';
			tableStr = tableStr + '			<tr><td height="35" align="left" cospan=2 class="STYLE8">&nbsp;&nbsp;&nbsp;&nbsp;下述机构已领取组织机构代码</td></tr>';
			tableStr = tableStr + '</table>';
			tableStr = tableStr + '		<table id="table4" width="689" style="border-collapse:collapse; " cellpadding= "0" cellspacing= "0"  border= "1" bordercolor= "#3366FF" > ';         
			tableStr = tableStr + '    		<tr>';
			tableStr = tableStr + '    			<td height="35" width="274" align="center"  class="STYLE8">组织机构名称</td>';
			tableStr = tableStr + '   			<td align="left" >&nbsp;'+resultObject.root[0].jgmc+'</td>';
			tableStr = tableStr + '			</tr>';
			tableStr = tableStr + '    		<tr>';
			tableStr = tableStr + '    			<td height="45" align="center"  class="STYLE8">批准文号<br>（或批准证书批准号）</td>';
			tableStr = tableStr + '				<td align="left" >&nbsp;'+resultObject.root[0].pzwh+'</td>';
			tableStr = tableStr + '			</tr>';
			tableStr = tableStr + '    		<tr>';
			tableStr = tableStr + '				<td height="45" align="center"  class="STYLE8">批文日期<br>（或批准证书颁发日期）</td>';
			tableStr = tableStr + '				<td align="left" >&nbsp;'+dateFormatToYMD(resultObject.root[0].pwrq)+'</td>';
			tableStr = tableStr + '				</tr>';
			tableStr = tableStr + '    		<tr>';           
			tableStr = tableStr + '    			<td height="35" align="center"  class="STYLE8">组织机构代码</td>';            
			tableStr = tableStr + '    			<td align="left">&nbsp;'+resultObject.root[0].jgdm+'</td>';;
			tableStr = tableStr + '    		</tr>';
			tableStr = tableStr + '    		<tr>';           
			tableStr = tableStr + '    			<td height="35" align="center"  class="STYLE8">赋码日期</td>';            
			tableStr = tableStr + '    			<td align="left">&nbsp;'+myDate.format('Y-m-d')+'</td>';;
			tableStr = tableStr + '    		</tr>';
			tableStr = tableStr + '		</table>';
			
			tableStr = tableStr + '		<table  id="table" width="689" cellpadding= "0" cellspacing= "0"  border="0">';
			tableStr = tableStr + '   		<tr>';
			tableStr = tableStr + '   			<td height="35" width="450" align="center" valign="bottom">&nbsp;</td>';
			tableStr = tableStr + '    			<td  align="left"  width="100" valign="bottom" class="STYLE9" div>填表人签字：</td>';            
			tableStr = tableStr + '   			<td  align="left" width="119" valign="bottom" class="xiahua2">'+resultObject.root[0].tbrxm+'</td>';
			tableStr = tableStr + '				<td  align="center" width="30">&nbsp;</td>';
			tableStr = tableStr + '    		</tr>';  
			tableStr = tableStr + '    		<tr>';            
			tableStr = tableStr + '   			<td height="40" align="center" valign="bottom">&nbsp;</td>';
			tableStr = tableStr + '				<td align="left" valign="bottom" class="xiahua2">&nbsp;</td>';
			tableStr = tableStr + '    			<td align="left" valign="bottom" class="STYLE9">（赋码机构盖章)</td>'; 
			tableStr = tableStr + '				<td align="left" valign="bottom">&nbsp;</td>';
			tableStr = tableStr + '			</tr>';
			tableStr = tableStr + '   		<tr>';
			tableStr = tableStr + '   			<td  height="30"  align="center" valign="bottom">&nbsp;</td>';
			tableStr = tableStr + '				<td  align="center" valign="bottom" colspan=3>'+myDate.format('Y-m-d')+'</td>';
			tableStr = tableStr + '    		</tr>';          
			tableStr = tableStr + '		</table>';
			tableStr = tableStr + '   	<br><br>';
			tableStr = tableStr + '	  </div>';
			tableStr = tableStr + '</center><script language="JavaScript">function reportPrint(){window.location.reload();window.print();}</script></body></html>';
				 
			var titleHTML = tableStr;// document.getElementById("printGridfff").innerHTML;     
			var newwin = window.open('printer.jsp', 'printWindow', 'menubar=yes,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no,titlebar=yes,z-look=yes,menubar=yes');     
			  
			newwin.document.write(titleHTML); 
			if(resultObject.root[0].dybz != 'N'){
				Ext.Ajax.request({
					url : "updateDybzByOrgid.action",
					params : {orgid : resultObject.root[0].orgid},
					success : function(result,request) {
						/*Ext.Msg.show({
							title : '提示',
							msg : '打印预赋码单',
							buttons : Ext.Msg.OK,
							//fn:  function() {},
							icon : Ext.Msg.INFO
						});*/
					}
				});
			}
						////////////////////////////////
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

var btn_ok_yufuma = new Ext.Button({
	text : '保存确认',
	iconCls : 'icon-store',
	//disabled:true,
	handler : btn_yufuma_saveAll
});


var p_zzYufuma = {
	id : 'zzYufuma-panel',
	border : false,
	layout : 'border',
	bodyStyle: 'padding:0px',
	items : [{
		id:'border-panel',
	    layout:'border',
	    bodyBorder: false,
	    title: '预赋码',
	    iconCls : 'icon-plugin',
 		plain: true,
		region: 'center',
		tbar : [btn_refresh_yufuma,btn_code_yufuma,btn_del_yufuma,btn_print_yufuma,/*btn_save_yufuma_menubtn_saveInfo_yufuma,*/btn_ok_yufuma,'->',text_search_yufuma,btn_search_yufuma],
		items: [yufumaViewForm2,fileFtpForm_yufuma]
	}]
}