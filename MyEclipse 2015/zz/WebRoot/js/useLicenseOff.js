//******************************************************************************
//*                                                                            *
//* 第一步 、基本信息录入                                                                                                                                                     *
//*                                                                            *
//******************************************************************************
//--------------------注销申请单基本信息著录-------------------------------------------
var orgnewOffForm = new Ext.FormPanel({
	loadMask : {
		msg : '数据加载中...'
	},
	url : 'updateOrgnew.action',
	labelAlign : 'right',
	labelWidth : 100,
	bodyStyle : 'padding:5px',
	border : false,
	//fileUpload : true,
	//autoHeight : true,
	autoScroll : true, 
	baseCls : 'x-plain',
	waitMsgTarget: true,
	items : [{//第0行修改
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		items : [{
			columnWidth : 1,
			layout : 'form',
			baseCls : 'x-plain',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items : [{fieldLabel : '机构代码',name : 'jgdm',allowBlank : false,readOnly:true,maxLength : 9,defaults : {anchor:'99%'}}]
		}]
	},{//第一行修改
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		items : [{
			columnWidth : 1,
			layout : 'form',
			baseCls : 'x-plain',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items : [{fieldLabel : '机构名称',name : 'jgmc',allowBlank : false,readOnly:true,maxLength : 100,defaults : {anchor:'99%'}}]
		}]
	},{	//第二行修改  ---不显示
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		xtype : 'hidden',
		items : [{
			layout : 'column',
			border : false,
			baseCls : 'x-plain',
			items : [{
				columnWidth : .33,
				layout : 'form',
				baseCls : 'x-plain',
				border : false,
				defaultType : 'textfield',
				defaults : {anchor : '98%'},
				items : [{fieldLabel : '法定代表人(负责人)名称',	name:'fddbr',allowBlank : false,maxLength : 20,defaults : {anchor:'98%'}}]
			},{
				columnWidth : .34,
				layout : 'form',
				border : false,
				baseCls : 'x-plain',
				defaultType : 'textfield',
				defaults : {anchor : '98%'},
				items :[{fieldLabel : '法定代表人(负责人)证件类型',name:'zjlx',allowBlank : false,maxLength : 25,defaults : {anchor:'95%'}}]
			},{
				columnWidth : .33,
				layout : 'form',
				border : false,
				baseCls : 'x-plain',
				defaultType : 'textfield',
				defaults : {anchor : '98%'},
				items :[{fieldLabel : '法定代表人(负责人)证件号码',name:'zjhm',allowBlank : false,maxLength : 18,defaults : {anchor:'95%'}}]
			}]
		}]
	},{//第三行修改---不显示
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		xtype : 'hidden',
		items : [{
				layout : 'column',
				border : false,
				baseCls : 'x-plain',
				items : [{
					columnWidth : 1,
					layout : 'form',
					baseCls : 'x-plain',
					border : false,
					defaultType : 'textarea',
					defaults : {anchor : '99%',height:'50'},
					items : [{fieldLabel : '经营或业务范围',name : 'jyfw',allowBlank : false,maxLength : 240,defaults : {anchor:'100%'}}]
				}]
		}]
	},{//第四行修改---不显示
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		xtype : 'hidden',
		items : [{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '98%'},
			items :[
		        new Ext.form.DateField({  
                id:'zcrq_ulo',
                name: 'zcrq',
                format:'Y-m-d',
                maxValue:myDate,  
                maxText:'所选日期应在{0}之前',  
                minValue:'01/01/1949',
                minText:'所选日期应在{0}之后',
                width:150,
                allowBlank : false,
                fieldLabel:'成立日期',
                renderer:dateFormat,
                altFormats :'m/d/Y|m-d-y|m-d-Y|m/d|m-d|d|Ymd'
		        }) 
		    ]
		},{
			columnWidth : .5,
			layout : 'form',
			baseCls : 'x-plain',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '98%'},
			items : [{fieldLabel : '职工人数',name : 'zgrs',xtype:'numberfield',maxLength:2000000000}]
		}]
	},{//第五行修改---不显示
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		xtype : 'hidden',
		items : [{
			columnWidth : .5,
			layout : 'form',
			baseCls : 'x-plain',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '98%'},
			items : [
			    new Ext.form.DateField({  
                id:'zsbfrq_ulo',
                name: 'zsbfrq',
                format:'Y-m-d',
                //maxValue:myDate,  
                //maxText:'所选日期应在{0}之前',  
                minValue:'01/01/1949',
                minText:'所选日期应在{0}之后',
                width:150, 
                allowBlank : false,
                fieldLabel:'证照有效开始日期',
                renderer:dateFormat
		        }) 
			]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '98%'},
			items : [
				new Ext.form.DateField({  
			    id:'zszfrq_ulo',
			    name: 'zszfrq',
			    format:'Y-m-d',
			    maxValue:myDate,  
			    maxText:'所选日期应在{0}之前',  
			    minValue:'01/01/1949',
			    minText:'所选日期应在{0}之后',
			    width:150,  
			    fieldLabel:'证照有效终止日期',
			    renderer:dateFormat
			    })   
			]
		}]
	},{//第五行修改---不显示
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		xtype : 'hidden',
		items : [{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '98%'},
			items : [{fieldLabel : '企业登记注册类型',	name : 'jjlx',allowBlank : false,maxLength : 50,defaults : {anchor:'98%'}}]
		},{
			columnWidth : .5,
			layout : 'form',
			baseCls : 'x-plain',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '98%'},
			items : [{fieldLabel : '外商投资国别或地区',name : 'wftzgb',maxLength : 50}]
		}]
	},{//第六行修改---不显示
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		xtype : 'hidden',
		items : [{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '98%'},
			items : [{fieldLabel : '注册(开办)资金',xtype : 'numberfield',name : 'zczj',maxValue : 2000000000}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '98%'},
			items :[{fieldLabel : '货币种类',name : 'hbzl',maxLength : 50}]
		}]
	},{//第六行修改---不显示
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		xtype : 'hidden',
		items : [{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '98%'},
			items :[{fieldLabel : '主管部门名称',name : 'zgmc',maxLength : 80}]
		},{
			columnWidth : .5,
			layout : 'form',
			baseCls : 'x-plain',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '98%'},
			items : [{fieldLabel : '主管部门代码',name : 'zgdm',maxLength : 9}]
		}]
	},{//第六行修改---不显示
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		xtype : 'hidden',
		items : [{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '98%'},
			items :[{fieldLabel : '登记批准机构名称',name : 'pzjgmc',maxLength : 80}]
		},{
			columnWidth : .5,
			layout : 'form',
			baseCls : 'x-plain',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '98%'},
			items : [{fieldLabel : '登记批准机构代码',name : 'pzjgdm',maxLength : 9}]
		}]
	},{//第六行修改---不显示
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		xtype : 'hidden',
		items : [{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '98%'},
			items :[{fieldLabel : '批准文号(注册号)',name : 'zch',maxLength : 31}]
		},{
			columnWidth : .5,
			layout : 'form',
			baseCls : 'x-plain',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '98%'},
			items : [{fieldLabel : '邮政编码',name : 'yzbm',maxLength : 6}]
		}]
	},{	//第六行修改---不显示
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		xtype : 'hidden',
		items : [{
			columnWidth : 1,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '机构地址',name : 'jgdz',allowBlank : false,maxLength : 100,defaults : {anchor:'99%'}}]
	
		}]
	},{	//第六行修改---不显示
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		xtype : 'hidden',
		items : [{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '98%'},
			items :[{	
					xtype : 'combo',
					fieldLabel : '行政区划',
					id : 'xzqh_ulo',
					name : 'xzqhName',  //接收值的名称
					displayField : 'xzqhName', //显示值的名称
					hiddenName : 'xzqhCode', //真正提交时此combo的name
					valueField : 'xzqhCode',  //真正提交时此combo的value
					allowBlank : false,
					maxLength : 50,
					mode : 'remote',
					store : new Ext.data.Store({
						//autoLoad : true,
						proxy : new Ext.data.HttpProxy({
							url : 'findAllXzqh.action'
						}),
						reader : new Ext.data.JsonReader({
							root : 'root'
						}, [{name : 'xzqhCode',type : 'string'},
							{name : 'xzqhName',type : 'string'}
						])
					}),
					selectOnFocus : true,
					editable : false,
					triggerAction : 'all',
					loadingText : '加载中...',
					listeners : {
						'select' : function(combo, record, index) {
							orgnewOffForm.getForm().findField('_xzqhName').setValue(Ext.get("xzqh_ulo").dom.value);
						}
					}
				}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '98%'},
			items :[{fieldLabel : '固定电话号码',name : 'dhhm',maxLength : 21}]
		}]
	},{ //表单修改
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		items : [{
			columnWidth : .5,
			layout : 'form',
			baseCls : 'x-plain',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '98%'},
			items : [ 
			    {xtype : 'hidden',fieldLabel : '移动电话',name : 'mobile',maxLength : 25},
			    {xtype : 'hidden',fieldLabel : '机构网址',name : 'weburl',allowBlank : false,maxLength : 50},
			    {fieldLabel : '经办人名称',name : 'tbrxm',allowBlank : false,maxLength : 25},
			    {	xtype : 'combo',
					fieldLabel : '经办人证件类型',
					id : 'memo_ulo',
					name:'memo',
					hiddenName : 'memo',
					valueField : 'categoryName',
					displayField : 'categoryName',
					mode : 'remote',
					store : ds_zjlx_select,
					selectOnFocus : true,
					editable : false,
					maxLength : 25,
					allowBlank : false,
					triggerAction : 'all',
					loadingText : '加载中...',
					listeners : {
						'select' : function(combo, record, index) {
							//this.ownerCt.ownerCt.ownerCt.form.findField('book.categoryName').setValue(record.data.categoryName);
						}
					}},
			    {fieldLabel : '批准注销机构',name : 'offPzjgmc',allowBlank : false,readOnly : false,maxLength : 100},
			    {xtype : 'hidden',	name : 'orgid',id:'orgid'},
			    {xtype : 'hidden',	name : 'orderid',id:'orderid'},
				{xtype : 'hidden',name : 'xzqhName'}, 
				{xtype : 'hidden',name : 'imageUrl'}
			]
		}, {//表单修改
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '98%'},
			items : [
			    {xtype : 'hidden',fieldLabel : '电子邮箱',name : 'email',maxLength : 40},
			    {fieldLabel : '经办人电话',name : 'tbrlxfs',allowBlank : false,maxLength : 25},
			    {fieldLabel : '经办人证件号码',name : 'tbrsfzh',allowBlank : false,maxLength : 25},
			    {fieldLabel : '注销文号',name : 'offPzwh',allowBlank : false,maxLength : 50},
			    {xtype : 'hidden',name : '_xzqhName',maxLength : 25},
				{xtype : 'hidden',name : 'lastdate',value :myDate.format('Y-m-d')}, 
				{xtype : 'hidden',name : 'xgr',value:currentUser},
				{xtype : 'hidden',name : 'state'},
				{xtype : 'hidden',name : 'newYwlx',value:'注销'},
				{xtype : 'hidden',name : 'newState',value:70}
			]
		}]
	},{	//第六行修改
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		items : [{
			columnWidth : 1,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textarea',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '注销原因',name : 'offReason',allowBlank : false,maxLength : 250,defaults : {anchor:'99%'}}]
	
		}]
	}],
	buttonAlign : 'center',
	minButtonWidth : 60,
	buttons : [{
		text : '保存',
		id:'off_bc',
		name:'off_bc',
		disabled:false,
		hidden:false,
		handler : function(btn){
			if (orgnewOffForm.getForm().isValid()) {
				btn.disable();
				orgnewOffForm.getForm().submit({
					waitTitle : '请稍候',
					waitMsg : '正在保存信息,请稍候...',
					success : function(form,action) {
						Ext.Msg.show({
							title : '提示',
							msg : '“注销申请单”信息，保存成功!',
							buttons : Ext.Msg.OK,
							fn : function(){
								btn.enable();
								var tab3=Ext.getCmp("centerPanel8");
								tab3.setActiveTab("OffScTab");
								
								var tab31=Ext.getCmp("OffTab");
								tab31.setTitle("第一步、注销信息录入(已保存)");	
								
								
								
							},
							icon : Ext.Msg.INFO
						});
					},
					failure : function(form, action) {
						Ext.Msg.show({
							title : '提示',
							msg : '数据保存失败',
							buttons : Ext.Msg.OK,
							fn : function() {btn.enable();},
							icon : Ext.Msg.ERROR
						});
					}
				});
			}
		}
	},{
		text : '重置',
		id:'off_cz',
		name:'off_cz',
		disabled:false,
		hidden:false,
		handler :function() {
			orgnewOffForm.getForm().reader = Orgnews;
			orgnewOffForm.getForm().load({
			    url: 'findUsernameOrgnew.action?username='+currentUsername+'&stateConditions=100,70,73', //请求控制器获取数据
			    //url: 'findUsernameOrgnew2.json',
			    method: 'POST', //为"POST",则上面的url不会显示在浏览器的地址栏中
			    waitTitle: '提示',
			    waitMsg: '数据正在加载中，请稍后',
			    success:function(form,action){
			    	var resultObject871 = Ext.util.JSON.decode(action.responseText);
   					//alert("pageTypeStr="+resultObject87.root[0].pageTypeStr);
			    	//var dt = new Date().add(Date.DAY,new Number(record.data.loanDays));
		    		//loanLogForm.getForm().findField('_preReturnTime').setValue(dt.format('Y-m-d'));
		    		//loanLogForm.getForm().findField('loanLog.preReturnTime').setValue(dt.);
		    		//alert(resultObject871.root[0].zcrq);
		    		//alert(action.responseText);
			    	//orgnewOffForm.getForm().findField('zcrq').setValue(resultObject871.root[0].zcrq.format('Y-m-d'));
			    }
			});
			

		}
	}]
});


var OffForm = {
		title: '请录入机构注销申请信息',
	    layout: 'fit',
	    frame: true,
	    id: 'Off21',
	    bodyStyle: 'padding:10px;',
	    border:false,
	    items: [orgnewOffForm]
};


//******************************************************************************
//                                                                             *
// 第二步 、附件扫描上传                                                                                                                                                       *
//                                                                             *
//******************************************************************************
function GetXmlHttp()
{
	var xmlhttp=false;
	try
	{
		xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
	}
	catch (e)
	{
		try
		{
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		catch(E)
		{
			xmlhttp = false;
		}
	}
	
	if (!xmlhttp && typeof XMLHttpRequest!='undefined')
	{
		try
		{
			xmlhttp = new XMLHttpRequest();
		}
		catch (e)
		{
			xmlhttp=false;
		}
	}
	
	if (!xmlhttp && window.createRequest)
	{
		try
		{
			xmlhttp = window.createRequest();
		}
		catch (e)
		{
			xmlhttp=false;
		}
	}
	return xmlhttp;
}


//--------------------隐含图片信息-------------------------------------------
var imgForm = new Ext.FormPanel({
		layout : 'form',
		border : false,
		defaultType : 'hidden',
		items : [{xtype : 'hidden',name : 'imageData',id:'sImageData'},{xtype : 'hidden',name : 'orgid',id:'orgid678'},{xtype : 'hidden',name : 'pageTypeStr',id:'sPageTypeStr'}]
});

var OffScOrgnewForm = new Ext.Panel({
	//url : 'shangchuanOrgnew.action',
	//bodyStyle : 'padding:5px',
	border : false,
	items: [imgForm],
	html: '<OBJECT classid="clsid:B5306E2E-8F98-46CA-9F31-AB326B2613F1"  width=100%  height=100% align=center hspace=0 vspace=0 id="scanner87"  name="scanner87" >'
	       +'<param name="ShowCount" value="8">'
	       +'<param name="sModel" value="1">'
	       +'</OBJECT>'
});

var OffScForm = {	    
		title: '请扫描并上传注销申请资料',
	    layout: 'fit',
	    frame: true,
	    id: 'Off3',
	    margins: '0 0 0 0',
	    border:false,
	    items: [OffScOrgnewForm],
		buttons: [{
		   id:'up_button',
		   name:'up_button',
		   text: '上传',   
		       handler: function(btn) {   
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
						
						
						btn.disable();
						strOrgid = currentOrgid;  //通过用户zuser session 带来的参数orgid
						
						//alert(strOrgid);
						packLength = 40960;	//定义每个包的大小40960
						//scanner87.ImageData=document.getElementById("ImageData").value;
						base64file = scanner87.ImageData;  //获取控件扫描的图片数据
						var baseSize = base64file.length;  //获取控件图片数据的64位编码的长度
						imageCount = scanner87.GetPageCount;	//获取扫描图片的页数
						pageTypeStr = scanner87.PageType;    //获取标识字符串,需要写数据库
						if(pageTypeStr!=""){
							pageTypeStr=pageTypeStr.replace(/\%/g, "|"); 
		       			}
						//alert(pageTypeStr);
						packCount = Math.ceil(base64file.length / packLength);	//判断需要发送数据包的个数
						if(imageCount==0 || base64file=="")   //判断如果没有扫描数据，结束处理
						{
							alert("请扫描或导入图片后，再上传！");
							btn.enable();
							return false;
						}
						
						if(scanner87.CheckOrder()!="")   //判断如果标识数据的类别是否完整
						{
							alert(scanner87.CheckOrder());
							btn.enable();
							return false;
						}
						
						scanner87.OpenProgress(packCount);  //设置上传的进度条的总进度数
						xmlhttp = GetXmlHttp(); //通过AJAX格式上传
						for(i=0; i < packCount; i++)  //分包上传
						{
								pack = base64file.substring(i * packLength, (i + 1) * packLength);  //每个数据包的文件大小
							   //pack="11111111111111111111111";
							try
							{
								//xmlhttp.open("post", "saveImageOrgnew.action?orgid="+strOrgid, false);
								xmlhttp.open("post", "saveImageOrgnew.action?orgid="+strOrgid+"&packindex="+i+"&pageTypeStr="+pageTypeStr+"&lastpack=false", false);
								xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   //这句必须要，而且一定要放在send以前
								xmlhttp.send("imageData=" + encodeURIComponent(pack)); 
								//xmlhttp.send("imgPackData=" + pack); 
								//alert("上传返回的值"+xmlhttp.responseText);
                                 
								var objs = eval("["+xmlhttp.responseText+"]");
								//alert(objs.length); // 2
			                    //alert(objs[0].success);  // 1
			                    
								if(objs[0].success)
								{
									//scanner87.SetSendProgress(Math.ceil(i / packCount * 100));
									scanner87.Progress('上传中',i+1);
								}
								else
								{
									alert("上传失败，请重试0001。");
									//scanner87.ShowSendMsg(false);
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
						
						scanner87.CloseProgress();
						
						Ext.Msg.show({
							title : '提示',
							msg : '“扫描上传”成功！<br><br>&nbsp;&nbsp;下一步，进入“提交注销申请”!',
							buttons : Ext.Msg.OK,
							icon : Ext.Msg.INFO,
							fn : function(){
								btn.enable();
								var tab3=Ext.getCmp("centerPanel8");
								tab3.setActiveTab("OffTjTab");
								return true;
							}
						});
		       }   
		   }]
};


//******************************************************************************
//                                                                             *
// 第三步 、注销信息提交                                                                                                                                                      *
//                                                                             *
//******************************************************************************

//------------注销信息中，查询返回结果的数据集----------
var ds_orgnewOff = new Ext.data.Store({
	url : 'findAllOrgnew.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'orgid',type : 'int'},
	    {name : 'orderid',type : 'string'},
	    {name : 'orderid',type : 'string'},
		{name : 'jgmc',type : 'string'},
		{name : 'jgdm',type : 'string'}, 
		{name : 'jglx',type : 'string'},
		{name : 'fddbr',type : 'string'}, 
		{name : 'zjlx',type : 'string'},
		{name : 'zjhm',type : 'string'}, 
		{name : 'jyfw',type : 'string'},
		{name : 'zcrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'zgdm',type : 'string'},
		{name : 'zgmc',type : 'string'},
		{name : 'pzjgmc',type : 'string'},
		{name : 'xzqhCode',type : 'string'},
		{name : 'xzqhName',type : 'string'},
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
		
		{name : 'zsbfrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'zszfrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'jjlx',type : 'string'},
		{name : 'memo',type : 'string'},
		{name : 'memo2',type : 'string'},
		
		{name : 'jjhymc',type : 'string'},
		{name : 'jjhydm',type : 'string'},
		{name : 'gk',type : 'string'},
		{name : 'ywlx',type : 'string'},
		
		{name : 'name',type : 'string'},
		{name : 'username',type : 'string'},
		{name : 'adudit_name',type : 'string'},
		{name : 'adudit_date',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'adudit_note',type : 'string'},
		{name : 'imageUrl',type : 'string'},
		
		{name : 'offPzjgmc',type : 'string'},
		{name : 'offPzwh',type : 'string'},
		{name : 'offReason',type : 'string'},	
		{name : 'offNote',type : 'string'},
		
		{name : 'state',type : 'string'}
	])
});

//----------------------点击列表信息，显示图书的扩展属性----------------------
var expander_lo = new Ext.grid.RowExpander({
	tpl : new Ext.Template('<table width="100%"  border="0" cellspacing="6" cellpadding="0"  bgcolor="#DDEEF9" style="margin-top:1px;" >'
			+ '<tr>'
			+ '<td width="" colspan="4">'
			+ '<table width="98%" bgcolor="#ffffff" border="1" cellpadding="0" cellspacing="0" align="center"  bordercolordark="#FFFFFF" bordercolorlight="#6EBBE1" style="margin-top:0px;>'
			+ '<tr height="22" valign="middle">'
			+ '  <td width="20%" height="22" align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">机构名称：</td><td width="30%"  valign="middle" style="padding-top:5px">{jgmc}<img src="images/temp.gif"></td>'
			+ '  <td width="20%" height="22" align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">机构代码：</td><td width="30%"  valign="middle" style="padding-top:5px">{jgdm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle" >'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">机构类型：</td><td nowrap="nowrap" style="padding-top:5px">{jglx}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">法定代表人：</td><td  nowrap="nowrap" style="padding-top:5px">{fddbr}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">证件类型：</td><td nowrap="nowrap"  style="padding-top:5px">{zjlx}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">证件号码：</td><td nowrap="nowrap"  style="padding-top:5px">{zjhm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">主要经营或业务范围：</td><td  colspan=3 style="padding-top:5px">{jyfw}<img src="images/temp.gif"></td>'
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
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">企业登记注册类型：</td><td nowrap="nowrap" style="padding-top:5px">{jjlx} {jjlxdm}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">外商投资国或地区：</td><td nowrap="nowrap" style="padding-top:5px">{wftzgb} {wftzgbdm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">注册(开办)资金：</td><td nowrap="nowrap" style="padding-top:5px">{zczj}(万)<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">货币种类：</td><td nowrap="nowrap" style="padding-top:5px">{hbzl}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">主管部门及代码：</td><td nowrap="nowrap" style="padding-top:5px">{zgmc} {zgdm}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">批准机构及代码：</td><td nowrap="nowrap" style="padding-top:5px">{pzjgmc} {pzjgdm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">注册文号或注册号：</td><td nowrap="nowrap" style="padding-top:5px">{zch}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">邮政编码：</td><td nowrap="nowrap" style="padding-top:5px">{yzbm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">机构地址：</td><td nowrap="nowrap" style="padding-top:5px">{jgdz}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">行政区划：</td><td nowrap="nowrap" style="padding-top:5px">{xzqhName} {xzqhCode}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">电话号码：</td><td nowrap="nowrap" style="padding-top:5px">{dhhm}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">网址：</td><td nowrap="nowrap" style="padding-top:5px">{weburl}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">手机：</td><td nowrap="nowrap" style="padding-top:5px">{mobile}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">电子信箱：</td><td nowrap="nowrap" style="padding-top:5px">{email}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经办人名称：</td><td nowrap="nowrap" style="padding-top:5px">{tbrxm}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经办人证件类型：</td><td nowrap="nowrap" style="padding-top:5px">{memo}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经办人证件号码：</td><td nowrap="nowrap" style="padding-top:5px">{tbrsfzh}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经办人电话：</td><td nowrap="nowrap" style="padding-top:5px">{tbrlxfs}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经济行业：</td><td nowrap="nowrap" style="padding-top:5px">{jjhymc} {jjhydm}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">是否公开：</td><td nowrap="nowrap" style="padding-top:5px">{gk}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">业务类型：</td><td nowrap="nowrap" colspan="3" style="padding-top:5px">{ywlx}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">批准注销机构：</td><td nowrap="nowrap" style="padding-top:5px">{offPzjgmc}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">注销文号：</td><td nowrap="nowrap" style="padding-top:5px">{offPzwh}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">注销原因：</td><td  colspan=3 style="padding-top:5px">{offReason}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">审核人：</td><td nowrap="nowrap" style="padding-top:5px">{adudit_name}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">审核时间：</td><td nowrap="nowrap" style="padding-top:5px">{adudit_date}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">审核意见：</td><td  colspan=3 style="padding-top:5px">{adudit_note}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '</table>'
			+ '</td></tr></table>')
});



var btn_return_orgnewOff = new Ext.Button({
	text : '提交注销',
	iconCls : 'icon-save',
	disabled:true,
	handler : function(btn){
		var record = grid_LicenseOff.getSelectionModel().getSelected();
		if(record){
			var orgid = record.data.orgid;
			Ext.Ajax.request({
				url: 'returnOrgnew.action',
   				success: function(){
   					Ext.Msg.show({
						title : '提示',
						msg : '注销提交成功,等待审核!',
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.INFO,
						fn : function(){
							record.set('state','71');
							btn.disable();
							//record.set('currentReader',''),
							//grid_LicenseOff.fireEvent('rowclick',grid_LicenseOff,grid_LicenseOff.getStore().indexOf(record));
							//grid_LicenseOff.getStore().remove(record);
						}
	   					
					});
   					var tab3=Ext.getCmp("centerPanel8");
   					tab3.remove("OffTab");   //移除标签
					tab3.remove("OffScTab");   //移除标签
					tab3.remove("OffPtTab");   //移除标签
   				},
   				failure: function(){
   					Ext.Msg.show({
						title : '提示',
						msg : '注销提交失败!',
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.ERROR
					});
   				},
   				params: { orgid: orgid}
			});
		}
	}
});



var btn_search_orgnewOff = new Ext.Button({
	text : '查询',
	hidden:true,
	iconCls : 'icon-search',
	handler : function() {
		searchOrgnewOff();
		//btn_add_orgnewOff.setDisabled(false);
		//btn_edit_orgnewOff.setDisabled(true);
		//btn_return_orgnewOff.setDisabled(true);
	}
});

var btn_refresh_orgnewOff = new Ext.Button({
	text : '刷新',
	iconCls : 'icon-refresh',
	handler : function() {
		textSearchOrgnewOff.value='';
		searchOrgnewOff();
		//btn_edit_orgnewOff.setDisabled(true);
		btn_return_orgnewOff.setDisabled(true);
	}
});
    
var text_search_orgnewOff = new Ext.form.TextField({
	id : 'textSearchOrgnewOff',
	hidden:true,
	name : 'textSearchOrgnewOff',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchOrgnewOff();
			}
		}
	}
});

//--------------------- 默认查询 limit为显示的条数 ---------------------- 
var searchOrgnewOff = function() {
	ds_orgnewOff.baseParams.conditions = text_search_orgnewOff.getValue();
	ds_orgnewOff.baseParams.username=currentUsername;
	ds_orgnewOff.baseParams.stateConditions='70,71,72,73,74';
	ds_orgnewOff.load({params : {start : 0,limit : 10} });
};


//---------------------- 列表显示主要数据信息 -------------------------
//列表显示机构的主要信息 yangqi
var sm32 = new Ext.grid.CheckboxSelectionModel();
var cm_orgnew = new Ext.grid.ColumnModel([expander_lo,
	sm32,
	{header : '原文',width : 20,dataIndex : 'imageUrl', renderer:icon,sortable : false},
	{header : '流水号',width : 55,dataIndex : 'orderid',sortable : true}, 
	{header : '机构名称',width : 115,sortable : true,dataIndex : 'jgmc'},
	{header : '申请状态',width : 195,dataIndex : 'state',renderer : goState,menuDisabled : true}
]);


//---------------------- 加载右栏主页面   （数据列表、工具栏按钮）---------------------- 
var grid_LicenseOff = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	//autoHeight : true,
	cm : cm_orgnew,
	ds : ds_orgnewOff,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'address',
	viewConfig : {forceFit : true},
	plugins : expander_lo,
	tbar : [btn_refresh_orgnewOff,'-',btn_return_orgnewOff,'->',text_search_orgnewOff,
	        btn_search_orgnewOff],
	bbar : new Ext.PagingToolbar({
		pageSize : 10,
		store : ds_orgnewOff,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			if(grid.getStore().getAt(rowIndex).data.state == 72){
				//btn_edit_orgnewOff.setDisabled(true);
				btn_return_orgnewOff.setDisabled(true);
			}else{
				if(grid.getStore().getAt(rowIndex).data.state == 71){
					//btn_edit_orgnewOff.setDisabled(true);
					btn_return_orgnewOff.setDisabled(true);
				}else{
					//btn_edit_orgnewOff.setDisabled(false);
					btn_return_orgnewOff.setDisabled(false);
				}
			}
		}
	}
});

//******************************************************************************
//*                                                                            *
//* 第四步 、申请表打印                                                                                                                                                          *
//*                                                                            *
//******************************************************************************

//--------申请表打印中，查询返回结果的数据集---------
var ds_orgnewOff2 = new Ext.data.Store({
	url : 'findAllOrgnew.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'orgid',type : 'int'}, 
	    {name : 'orderid',type : 'string'},
		{name : 'jgmc',type : 'string'},
		{name : 'jgdm',type : 'string'}, 
		{name : 'jglx',type : 'string'}, 
		{name : 'fddbr',type : 'string'}, 
		{name : 'zjlx',type : 'string'},
		{name : 'zjhm',type : 'string'}, 
		{name : 'jyfw',type : 'string'},
		{name : 'zcrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'zgdm',type : 'string'},
		{name : 'zgmc',type : 'string'},
		{name : 'pzjgmc',type : 'string'},
		{name : 'xzqhCode',type : 'string'},
		{name : 'xzqhName',type : 'string'},
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
		
		{name : 'jjhymc',type : 'string'},
		{name : 'jjhydm',type : 'string'},
		{name : 'gk',type : 'string'},
		
		{name : 'khyh',type : 'string'},
		{name : 'khzh',type : 'string'},
		
		{name : 'zsbfrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'zszfrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'jjlx',type : 'string'},
		{name : 'memo',type : 'string'},
		{name : 'memo2',type : 'string'},
		
		{name : 'ywlx',type : 'string'},
		{name : 'name',type : 'string'},
		{name : 'username',type : 'string'},
		{name : 'adudit_name',type : 'string'},
		{name : 'adudit_date',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'adudit_note',type : 'string'},
		
		{name : 'offPzjgmc',type : 'string'},
		{name : 'offPzwh',type : 'string'},
		{name : 'offReason', type : 'string'},	

		
		{name : 'imageUrl',type : 'string'},
		{name : 'state',type : 'string'}
	])
});

//--------“申请表打印”中，列表显示机构的扩展属性------------
var expander_lo2 = new Ext.grid.RowExpander({
	tpl : new Ext.Template('<table width="100%"  border="0" cellspacing="6" cellpadding="0"  bgcolor="#DDEEF9" style="margin-top:1px;" >'
			+ '<tr>'
			+ '<td width="" colspan="4">'
			+ '<table width="98%" bgcolor="#ffffff" border="1" cellpadding="0" cellspacing="0" align="center"  bordercolordark="#FFFFFF" bordercolorlight="#6EBBE1" style="margin-top:0px;>'
			+ '<tr height="22" valign="middle">'
			+ '  <td width="20%" height="22" align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">机构名称：</td><td width="30%"  valign="middle" style="padding-top:5px">{jgmc}<img src="images/temp.gif"></td>'
			+ '  <td width="20%" height="22" align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">机构代码：</td><td width="30%"  valign="middle" style="padding-top:5px">{jgdm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle" >'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">机构类型：</td><td nowrap="nowrap" style="padding-top:5px">{jglx}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">法定代表人：</td><td  nowrap="nowrap" style="padding-top:5px">{fddbr}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">证件类型：</td><td nowrap="nowrap"  style="padding-top:5px">{zjlx}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">证件号码：</td><td nowrap="nowrap"  style="padding-top:5px">{zjhm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">主要经营或业务范围：</td><td  colspan=3 style="padding-top:5px">{jyfw}<img src="images/temp.gif"></td>'
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
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">企业登记注册类型：</td><td nowrap="nowrap" style="padding-top:5px">{jjlx} {jjlxdm}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">外商投资国或地区：</td><td nowrap="nowrap" style="padding-top:5px">{wftzgb} {wftzgbdm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">注册(开办)资金：</td><td nowrap="nowrap" style="padding-top:5px">{zczj}(万)<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">货币种类：</td><td nowrap="nowrap" style="padding-top:5px">{hbzl}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">主管部门及代码：</td><td nowrap="nowrap" style="padding-top:5px">{zgmc} {zgdm}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">批准机构及代码：</td><td nowrap="nowrap" style="padding-top:5px">{pzjgmc} {pzjgdm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">注册文号或注册号：</td><td nowrap="nowrap" style="padding-top:5px">{zch}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">邮政编码：</td><td nowrap="nowrap" style="padding-top:5px">{yzbm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">机构地址：</td><td nowrap="nowrap" style="padding-top:5px">{jgdz}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">行政区划：</td><td nowrap="nowrap" style="padding-top:5px">{xzqhName} {xzqhCode}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">电话号码：</td><td nowrap="nowrap" style="padding-top:5px">{dhhm}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">网址：</td><td nowrap="nowrap" style="padding-top:5px">{weburl}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">手机：</td><td nowrap="nowrap" style="padding-top:5px">{mobile}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">电子信箱：</td><td nowrap="nowrap" style="padding-top:5px">{email}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经办人名称：</td><td nowrap="nowrap" style="padding-top:5px">{tbrxm}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经办人证件类型：</td><td nowrap="nowrap" style="padding-top:5px">{memo}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经办人证件号码：</td><td nowrap="nowrap" style="padding-top:5px">{tbrsfzh}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经办人电话：</td><td nowrap="nowrap" style="padding-top:5px">{tbrlxfs}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经济行业：</td><td nowrap="nowrap" style="padding-top:5px">{jjhymc} {jjhydm}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">是否公开：</td><td nowrap="nowrap" style="padding-top:5px">{gk}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">业务类型：</td><td nowrap="nowrap" colspan="3" style="padding-top:5px">{ywlx}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">审核人：</td><td nowrap="nowrap" style="padding-top:5px">{adudit_name}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">审核时间：</td><td nowrap="nowrap" style="padding-top:5px">{adudit_date}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">审核意见：</td><td  colspan=3 style="padding-top:5px">{adudit_note}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '</table>'
			+ '</td></tr></table>')
});

//---------------------- 打印申请登记表 ---------------------------
function msgShow_ulo()
{
	Ext.Msg.confirm('操作提示','“注销申请表”打印完毕吗?',function(btn){
		if('yes' == btn){
			var tab3=Ext.getCmp("centerPanel8");
			tab3.setActiveTab("OffScTab");
		}
		btn_print_orgnewOff2.setDisabled(false);	
	});	
}

var btn_print_orgnewOff2 = new Ext.Button({
	text : '打印申请表',
	iconCls : 'icon-print',
	disabled:false,
	handler : function(btn){
		//Ext.MessageBox.alert("提示","test"); 
		var record2 = grid_LicenseOff2.getSelectionModel().getSelected();
	    //Ext.MessageBox.alert("提示","您选择的出版号是："+record2.data.jgmc); 
		if(record2){
			var titleHTML = printStr(record2);      
			var newwin = window.open('printer.jsp', 'printWindow', 'menubar=yes,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no,titlebar=yes,z-look=yes,menubar=yes');     
			newwin.document.write(titleHTML);     
			//newwin.document.location.reload();     
			//newwin.print(); 
			
			//btn.disable();
		}else{
			alert("请选择打印的机构");
		}
	}
})


var btn_print_orgnewOff3 = new Ext.Button({
	text : '打印注销单',
	iconCls : 'icon-print',
	disabled:true,
	handler : function(){
		var record20 = grid_LicenseOff2.getSelectionModel().getSelected();
		if(record20){
			
			var tableStr = '<html><head><title>组织机构代码网上办证系统--注销证明打印</title>';
			tableStr = tableStr + '<style>';
			tableStr = tableStr + '.STYLE8 {font-family: "宋体"; font-size: 10.5pt; }.STYLE9 {font-size: 10.5pt; }body {margin-left: 0px;margin-top: 0px;margin-right: 0px;margin-bottom: 0px;background-color: #CCCCCC;}';
			tableStr = tableStr + '.STYLE18 {font-size: 14pt;line-height: 1.5em;}';
			tableStr = tableStr + '.STYLE19 {font-family: "黑体";line-height: 2.5em;	font-size: 16pt;}';
			tableStr = tableStr + '.STYLE20 {font-size: 16pt; }';
			tableStr = tableStr + '</style>';
			tableStr = tableStr + '</head><body><center>';
			tableStr = tableStr + '<table border= "0" width=770 cellpadding= "0" cellspacing= "0"  bgcolor="#FFFFFF">';
			tableStr = tableStr + '  <tr>';
			tableStr = tableStr + '    <td align="center" valign="middle"><br>';
			tableStr = tableStr + '        <center>';
			tableStr = tableStr + '        <table  id="table" style="width:689;border-collapse:collapse; " cellpadding= "0" cellspacing= "0"  border="0" >';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td height="54" colspan="5" align="center" class="STYLE18 STYLE19">组织机构代码注销证明</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '        </table>';
			tableStr = tableStr + '      <table id="table4" style="width:689;border-collapse:collapse; " cellpadding= "0" cellspacing= "0" border= "1" bordercolor= "#3366FF">';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td width="140" height="40"  align="center" class="STYLE8"> 机构代码</td>';
			tableStr = tableStr + '            <td colspan="5"  align="center">'+record20.data.jgdm+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '           <td width="140" height="40" align="center" class="STYLE8">机构名称</td>';
			tableStr = tableStr + '            <td colspan="5"  align="center">'+record20.data.jgmc+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td height="40" align="center" class="STYLE8"> 注销核准机关</td>';
			tableStr = tableStr + '            <td colspan="5" align="center">'+record20.data.offPzjgmc+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td height="40"  align="center" class="STYLE8">注销核准文号</td>';
			tableStr = tableStr + '            <td colspan="5" align="center">'+record20.data.offPzwh+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td height="40"  align="center" class="STYLE8">注销原因</td>';
			tableStr = tableStr + '            <td colspan="5" align="center">'+record20.data.offReason+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '         <tr>';
			tableStr = tableStr + '            <td height="40" align="center" class="STYLE8">证书回收情况</span></td>';
			tableStr = tableStr + '            <td colspan="5" align="center">'+record20.data.offNote+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td height="63" class="STYLE8"  align="center">经办人</td>';
			tableStr = tableStr + '            <td width="125" align="center">'+record20.data.tbrxm+'</td>';
			tableStr = tableStr + '            <td width="60" height="63" align="center" class="STYLE8">身份证件号码</td>';
			tableStr = tableStr + '            <td width="177" height="63" class="STYLE8" align="center">'+record20.data.tbrsfzh+'</td>';
			tableStr = tableStr + '            <td width="46" height="63" align="center" class="STYLE9">联系<br>';
			tableStr = tableStr + '            电话</td>';
			tableStr = tableStr + '            <td width="127" height="63" class="STYLE9" align="center">'+record20.data.tbrlxfs+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td height="40" class="STYLE9" div align="center">受理人</td>';
			tableStr = tableStr + '            <td colspan="2"  align="center">'+record20.data.adudit_username+'</td>';
			tableStr = tableStr + '            <td  class="STYLE9" align="center">办理日期</td>';
			tableStr = tableStr + '            <td colspan="2"  align="center">'+myDate.format('Y-m-d')+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td height="60" class="STYLE9" div align="center">代码管理机构</td>';
			tableStr = tableStr + '            <td colspan="5" align="right">（签章）&nbsp;&nbsp;&nbsp;&nbsp; </td>';
			tableStr = tableStr + '        </table>';
			tableStr = tableStr + '      <p>&nbsp;</p>';
			tableStr = tableStr + '      <p>&nbsp;</p>';
			tableStr = tableStr + '      <p><br>';
			tableStr = tableStr + '      </p></td>';
			tableStr = tableStr + '  </tr>';
			tableStr = tableStr + '</table>';
			tableStr = tableStr + '<br>';
			tableStr = tableStr + '<table border= "0" width=770 cellpadding= "0" cellspacing= "0"  bgcolor="#FFFFFF">';
			tableStr = tableStr + '  <tr>';
			tableStr = tableStr + '    <td align="center" valign="middle"><br>';
			tableStr = tableStr + '        <center>';
			tableStr = tableStr + '        <table  id="table" style="width:689;border-collapse:collapse; " cellpadding= "0" cellspacing= "0"  border="0" >';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td height="54" colspan="5" align="center" class="STYLE18 STYLE19">组织机构代码注销证明</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '        </table>';
			tableStr = tableStr + '      <table id="table4" style="width:689;border-collapse:collapse; " cellpadding= "0" cellspacing= "0" border= "1" bordercolor= "#3366FF">';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td width="140" height="40"  align="center" class="STYLE8"> 机构代码</td>';
			tableStr = tableStr + '            <td colspan="5"  align="center">'+record20.data.jgdm+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '           <td width="140" height="40" align="center" class="STYLE8">机构名称</td>';
			tableStr = tableStr + '            <td colspan="5"  align="center">'+record20.data.jgmc+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td height="40" align="center" class="STYLE8"> 注销核准机关</td>';
			tableStr = tableStr + '            <td colspan="5" align="center">'+record20.data.offPzjgmc+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td height="40"  align="center" class="STYLE8">注销核准文号</td>';
			tableStr = tableStr + '            <td colspan="5" align="center">'+record20.data.offPzwh+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td height="40"  align="center" class="STYLE8">注销原因</td>';
			tableStr = tableStr + '            <td colspan="5" align="center">'+record20.data.offReason+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '         <tr>';
			tableStr = tableStr + '            <td height="40" align="center" class="STYLE8">证书回收情况</span></td>';
			tableStr = tableStr + '            <td colspan="5" align="center">'+record20.data.offNote+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td height="63" class="STYLE8"  align="center">经办人</td>';
			tableStr = tableStr + '            <td width="125" align="center">'+record20.data.tbrxm+'</td>';
			tableStr = tableStr + '            <td width="60" height="63" align="center" class="STYLE8">身份证件号码</td>';
			tableStr = tableStr + '            <td width="177" height="63" class="STYLE8" align="center">'+record20.data.tbrsfzh+'</td>';
			tableStr = tableStr + '            <td width="46" height="63" align="center" class="STYLE9">联系<br>';
			tableStr = tableStr + '            电话</td>';
			tableStr = tableStr + '            <td width="127" height="63" class="STYLE9" align="center">'+record20.data.tbrlxfs+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td height="40" class="STYLE9" div align="center">受理人</td>';
			tableStr = tableStr + '            <td colspan="2"  align="center">'+record20.data.adudit_username+'</td>';
			tableStr = tableStr + '            <td  class="STYLE9" align="center">办理日期</td>';
			tableStr = tableStr + '            <td colspan="2"  align="center">'+myDate.format('Y-m-d')+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td height="60" class="STYLE9" div align="center">代码管理机构</td>';
			tableStr = tableStr + '            <td colspan="5" align="right">（签章）&nbsp;&nbsp;&nbsp;&nbsp; </td>';
			tableStr = tableStr + '        </table>';
			tableStr = tableStr + '      <p>&nbsp;</p>';
			tableStr = tableStr + '      <p>&nbsp;</p>';
			tableStr = tableStr + '      <p><br>';
			tableStr = tableStr + '      </p></td>';
			tableStr = tableStr + '  </tr>';
			tableStr = tableStr + '</table>';
			
			tableStr = tableStr + '</center></body></html>';
			 
			var titleHTML = tableStr;// document.getElementById("printGridfff").innerHTML;     
			var newwin = window.open('printer.jsp', 'printWindow', 'menubar=yes,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no,titlebar=yes,z-look=yes,menubar=yes');     
			  
			newwin.document.write(titleHTML);     
			newwin.document.location.reload();     
			newwin.print();     
			//newwin.close();     
		}
	}
});

var btn_search_orgnewOff2 = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchOrgnewOff2();
	}
});

var btn_refresh_orgnewOff2 = new Ext.Button({
	text : '刷新',
	iconCls : 'icon-refresh',
	handler : function() {
		textSearchOrgnewOff2.value='';
		searchOrgnewOff2();
	}
});

var text_search_orgnewOff2 = new Ext.form.TextField({
	id : 'textSearchOrgnewOff2',
	name : 'textSearchOrgnewOff2',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchOrgnewOff2();
			}
		}
	}
});


//默认查询 limit为显示的条数
var searchOrgnewOff2 = function() {
	ds_orgnewOff2.baseParams.conditions = text_search_orgnewOff2.getValue();
	ds_orgnewOff2.baseParams.username=currentUsername;
	ds_orgnewOff2.baseParams.stateConditions='70,71,72,73,74';
	ds_orgnewOff2.load({params : {start : 0,limit : 10} });
};


//---------------------- 列表显示主要数据信息 ----------------------------------
//列表显示机构的主要信息 yangqi
var sm71 = new Ext.grid.CheckboxSelectionModel();
var cm_orgnew71 = new Ext.grid.ColumnModel([expander_lo2,
	sm71,
	{header : '原文',width : 20,dataIndex : 'imageUrl', renderer:icon,sortable : false},
	{header : '流水号',width : 55,dataIndex : 'orderid',sortable : true}, 
	{header : '机构名称',width : 115,sortable : true,dataIndex : 'jgmc'},
	{header : '申请状态',width : 195,dataIndex : 'state',renderer : goState,menuDisabled : true}
]);


//加载右栏主页面   （数据列表、工具栏按钮）
var grid_LicenseOff2 = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	id:'grid_LicenseOff2',
	//autoHeight : true,
	cm : cm_orgnew71,
	ds : ds_orgnewOff2,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'address2',
	
	viewConfig : {forceFit : true},
	plugins : expander_lo2,
	tbar : [btn_refresh_orgnewOff2,btn_print_orgnewOff2,btn_print_orgnewOff3,'->',text_search_orgnewOff2,
	        btn_search_orgnewOff2],
	bbar : new Ext.PagingToolbar({
		pageSize : 10,
		store : ds_orgnewOff2,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){		
			if(grid.getStore().getAt(rowIndex).data.state == 72){
			    btn_print_orgnewOff2.setDisabled(false);
			    btn_print_orgnewOff3.setDisabled(false);
			}
		}
	}
});


//******************************************************************************
//*
//*   主界面                                                                                                                                                      *
//*
//******************************************************************************

var OffTjForm = {
		title: '请检查信息并提交审核',
	    layout: 'fit',
	    frame: true,
	    id: 'Off4',
	    border:false,
	    items: [grid_LicenseOff]   
};

var OffPtForm = {
		title: '请打印登记表',
	    layout: 'fit',
	    frame: true,
	    id: 'Off5',
	    border:false,
	    items: [grid_LicenseOff2]   
};



var p_useLicenseOff = {
	id: 'useLicenseOff-panel',
	iconCls : 'icon-plugin',
	layout : 'border',
	title: '注销申请',
	activeTab: 0,
	items:[{ 
		xtype: 'tabpanel',
		plain: true,
		region: 'center',
		margins: '5 5 5 5',
		activeTab: 0,
		layoutOnTabChange:true,
		autoDestroy: true,
		id: 'centerPanel8',
		name:'centerPanel8',
		items: [{
			title: '注销状态',
			layout: 'fit',
			layoutOnTabChange:true,
			bodyStyle: 'padding:10px;',
			html: '1、请录入机构基本信息、上传证书新办申请资料，并提交'
				+'<br>2、当前证书办理状态为'
				+'<table><tr align="center">'
				+'<td><img id=imgFlag1 src="images/jc_off.gif" /><br>录入中</td>'
				+'<td><img id=imgFlag2  src="images/jc_off.gif" /><br>已提交<td>'
				+'<td><img id=imgFlag3  src="images/jc_off.gif" /><br>待办理<td>'
				+'<td><img id=imgFlag4  src="images/jc_off.gif" /><br>完成<td>'
				+'</table>'
		},{
			title: '第一步、注销信息录入',
			layout: 'fit',
			id:'OffTab',
			layoutOnTabChange:true,
			bodyStyle: 'padding:5px;',
	        items : [OffForm],
	        listeners : {
				'activate' : function() { //标签激活后自动加载数据
					orgnewOffForm.getForm().reader = Orgnews;
					orgnewOffForm.getForm().load({
						waitMsg : '正在加载数据请稍后',          //提示信息   
			            waitTitle : '提示',                         //标题  
					    url: 'findUsernameOrgnew.action?username='+currentUsername+'&stateConditions=100,70,73', //请求控制器获取数据
					    //url: 'findUsernameOrgnew2.json',
					    method: 'POST', //为"POST",则上面的url不会显示在浏览器的地址栏中
					    waitTitle: '提示',
					    waitMsg: '数据正在加载中，请稍后',
					    success:function(form,action) {//获取返回值
					    	//alert(action.result.data.jgmc);
		   					if(action.result.data.state=='100'){
		   						var tab31=Ext.getCmp("OffTab");
		   						tab31.setTitle("第一步、注销信息录入(未保存)");	
		   						//this.setTitle("第一步、基本信息录入 (未保存)");
		   					}
						}
					});
					
				}
			}
		
		},
		/*{
			id:'OffPtTab',
			title: '第二步、打印注销申请表',
			layout: 'fit',
		    bodyStyle: 'padding:5px;',
			layoutOnTabChange:true,
			items : [OffPtForm],
			listeners : {
				'activate' : function() {  //标签激活后自动加载数据
					text_search_orgnewOff2.value='';
					searchOrgnewOff2();
				}
			}
		},
		*/
		{
			id:'OffScTab',
			title: '第二步、扫描上传',
			layout: 'fit',
			layoutOnTabChange:true,
			bodyStyle: 'padding:5px;',
			items : [OffScForm],
			listeners : {
				'activate' : function() {  //标签激活后自动加载数据
					
					//上传文件格式限制串
					var strPageTypeNeed="";
					var resultObject827 = null;
					Ext.Ajax.request({  
						 url: 'findByCategoryid.action?categoryId=34',  
						 method:'POST',  
						 success:function(result,request){
							  //alert(result.responseText);
							  resultObject827 = eval('('+result.responseText+')');  
				    		  //Ext.Msg.alert('提示框',resultObject827.remark); 
							  strPageTypeNeed=resultObject827.root[0].remark;
							  Ext.Ajax.request({  
									 url: 'findOrgidOrgnew.action',
									 params : {orgid : currentOrgid,stateConditions:'100,10,13'},
									 method:'POST',  
									 success:function(result,request){
										var resultObject8711 = Ext.util.JSON.decode(result.responseText);
					   					if(resultObject8711.root.length!=0){
					   						var strTbrsfzh=resultObject8711.root[0].tbrsfzh;
					   						var strZjhm=resultObject8711.root[0].zjhm;
					   						//alert(strTbrsfzh+"|"+strZjhm);
					   						if(strTbrsfzh==strZjhm){
					   							var strPageTypeNeed2=strPageTypeNeed.replace(/\经办人身份证件%/g, "%"); 
					   							scanner87.PageNeed=strPageTypeNeed2;
					   							//alert("===="+strPageTypeNeed2)
					   						}else{
					   							scanner87.PageNeed=strPageTypeNeed;
					   							//alert("<><><>"+strPageTypeNeed)
					   						}
					   					}
									 },
										failure : function() {
											alert("数据读取错误");
										}
							  });
							  //alert(strPageTypeNeed);
				    		  return;  
			    		 },  
						 failure:function(){  
							  Ext.Msg.alert('提示框','操作失败!');  
							  return;  
						 } 
					});
					
					scanner87.ImageData="";
					strOrgid=currentOrgid;  //当前ORGID同步
	        		var resultObject87 = null;
	        		Ext.Ajax.request({
						url : 'orgnewViewImg.action',
						params : {orgid : strOrgid,stateConditions:'100,70,73'},
						success : function(result,request) {//获取返回值
		   					var resultObject87 = Ext.util.JSON.decode(result.responseText);
		   					if(resultObject87.root.length!=0){
		   						if(resultObject87.root[0].state!='100'){
				   					if(resultObject87.root[0].imageData!=null && resultObject87.root[0].imageData!=""){
				   						scanner87.OpenProgress(3);  //设置上传的进度条的总进度数
				   						scanner87.Progress('原文加载中',1);
				   						scanner87.Progress('原文加载中',2);
				   						scanner87.ImageData=resultObject87.root[0].imageData;
				   						if(resultObject87.root[0].PageType!=""){
				   							scanner87.PageType=resultObject87.root[0].pageTypeStr;
				   						}
				   						scanner87.Progress('原文加载完毕',3);
				   						scanner87.CloseProgress();
				   					}
								}
		   					}
						},
						failure : function() {
							alert("图像加载错误");
						}
					});	
										
				}
			}
		
		},{
			id:'OffTjTab',
			title: '第三步、提交注销申请',
			layout: 'fit',
		    bodyStyle: 'padding:5px;',
			layoutOnTabChange:true,
			items : [OffTjForm],
			listeners : {
				'activate' : function() {  //标签激活后自动加载数据
					text_search_orgnewOff.value='';
					searchOrgnewOff();
					btn_return_orgnew.setDisabled(true);
				}
			}
		}],
		listeners : {
			'tabchange' : function() {
			   //alert('成功'+userstate+'吗！')
				switch (userstate) {  //设置注销状态 ?????此处应该采用机构的条目吧？
			 	case '7' :
			 		document.getElementById("imgFlag1").src = "images/jc_off.gif";
					document.getElementById("imgFlag2").src = "images/jc_off.gif";
					document.getElementById("imgFlag3").src = "images/jc_off.gif";
					document.getElementById("imgFlag4").src = "images/jc_off.gif";
			 	case '20' :
			 		document.getElementById("imgFlag1").src = "images/jc_on.gif";
					document.getElementById("imgFlag2").src = "images/jc_off.gif";
					document.getElementById("imgFlag3").src = "images/jc_off.gif";
					document.getElementById("imgFlag4").src = "images/jc_off.gif";
			 	case '21' :
			 		document.getElementById("imgFlag1").src = "images/jc_off.gif";
					document.getElementById("imgFlag2").src = "images/jc_on.gif";
					document.getElementById("imgFlag3").src = "images/jc_off.gif";
					document.getElementById("imgFlag4").src = "images/jc_off.gif";
			 	case '22' :
			 		document.getElementById("imgFlag1").src = "images/jc_off.gif";
					document.getElementById("imgFlag2").src = "images/jc_on.gif";
					document.getElementById("imgFlag3").src = "images/jc_off.gif";
					document.getElementById("imgFlag4").src = "images/jc_off.gif";
			 	case '23' :
			 		document.getElementById("imgFlag1").src = "images/jc_off.gif";
					document.getElementById("imgFlag2").src = "images/jc_on.gif";
					document.getElementById("imgFlag3").src = "images/jc_off.gif";
					document.getElementById("imgFlag4").src = "images/jc_off.gif";
			 	case '24' :
			 		document.getElementById("imgFlag1").src = "images/jc_off.gif";
					document.getElementById("imgFlag2").src = "images/jc_off.gif";
					document.getElementById("imgFlag3").src = "images/jc_off.gif";
					document.getElementById("imgFlag4").src = "images/jc_on.gif";
			 	default :
			 		document.getElementById("imgFlag1").src = "images/jc_off.gif";
					document.getElementById("imgFlag2").src = "images/jc_off.gif";
					document.getElementById("imgFlag3").src = "images/jc_off.gif";
					document.getElementById("imgFlag4").src = "images/jc_off.gif";
			 }
			
				
				var tab71=Ext.getCmp("centerPanel8");
				if(userstate=="72"||userstate=="75"){
					tab71.remove("OffTab");   //移除标签
					tab71.remove("OffScTab");   //移除标签
					tab71.remove("OffPtTab");   //移除标签
					//tab2.remove("auditForm");  //移除标签
					
				}
			}
		}
	}]
}