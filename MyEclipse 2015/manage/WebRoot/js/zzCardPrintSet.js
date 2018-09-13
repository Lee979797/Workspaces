
//--------------------机构基本信息-------------------------------------------
var cardprintSetViewForm = new Ext.FormPanel({	
	url : 'saveCardPrintSet.action',
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
            items:[{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{xtype: 'toolbar',items: [{xtype: 'tbtext',text: '&nbsp;&nbsp;1&nbsp;&nbsp;&nbsp;&nbsp;'},
                		{xtype: 'tbtext',text: '当前设置：'}
                	]},
                	{ xtype:'textfield',fieldLabel : '打卡机类型',name : 'prtType',readOnly: true,anchor:'100%'},
                	{ xtype:'textfield',fieldLabel : '打印端口',name : 'prtPort',readOnly: true,anchor:'100%'},
                	{ xtype:'textfield',fieldLabel : '通讯端口',name : 'comPort',readOnly: true,anchor:'100%'},
                	{ xtype:'textfield',fieldLabel : '通讯波特率',name : 'comBaud',readOnly: true,anchor:'100%'}
                ]
			},{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{xtype: 'toolbar',items: [{xtype: 'tbtext',text: '&nbsp;&nbsp;2&nbsp;&nbsp;&nbsp;&nbsp;'},
                		{xtype: 'tbtext',text: '重新设置：'}
                	]},
                	
                	{ xtype:'combo',fieldLabel : '打卡机类型',id : 'pType',name : 'printerType',allowBlank : false,anchor:'100%',
                		
						store: new Ext.data.SimpleStore({
							fields:['value','text'],
                			data:[
                				[1,'P300系列'],
                				[2,'P400系列'],
                				[3,'NBS一体机']
                			]
						}),
						readOnly: true,
						forceSelection : true,
                		typeAhead: true,
                		triggerAction : 'all',
						lazyRender:true,
						displayField:'text',
                		valueField:'value',
                		hiddenName :'printerType',
                		mode:'local'
                	},
                	{ xtype:'combo',fieldLabel : '打印端口',name : 'printPort',allowBlank : false,anchor:'100%',
                		
						store: new Ext.data.SimpleStore({
							fields:['value','text'],
                			data:[
                				['LPT1:','LPT1:'],
                				['LPT2:','LPT2:'],
                				['COM1:','COM1:'],
                				['COM2:','COM2:'],
                				['COM3:','COM3:'],
                				['COM4:','COM4:']
                			]
						}),
						readOnly: true,
						forceSelection : true,
                		typeAhead: true,
                		triggerAction : 'all',
						lazyRender:true,
						displayField:'text',
                		valueField:'value',
                		mode:'local'
                	},
                	{ xtype:'combo',fieldLabel : '通讯端口',id : 'cPort',name : 'communicationPort',allowBlank : false,anchor:'100%',
                		
						store: new Ext.data.SimpleStore({
							fields:['value','text'],
                			data:[
                				[1,'COM1'],
                				[2,'COM2'],
                				[3,'COM3'],
                				[4,'COM4']
                			]
						}),
						readOnly: true,
						forceSelection : true,
                		typeAhead: true,
                		triggerAction : 'all',
						lazyRender:true,
						displayField:'text',
                		valueField:'value',
                		hiddenName :'communicationPort',
                		mode:'local'
                	},
                	{ xtype:'combo',fieldLabel : '通讯波特率',name : 'baudRate',allowBlank : false,anchor:'100%',
                		
						store: new Ext.data.SimpleStore({
							fields:['value','text'],
                			data:[
                				[9600,'9600'],
                				[115200,'115200'],
                				[4800,'4800']
                			]
						}),
						readOnly: true,
						forceSelection : true,
                		typeAhead: true,
                		triggerAction : 'all',
						lazyRender:true,
						displayField:'text',
                		valueField:'value',
                		hiddenName :'baudRate',
                		mode:'local'
                	}
                ]
			}]
    }],
    buttonAlign : 'center',
    minButtonWidth : 60,
    buttons : [{
		text : '保存',
		id:'printset_bc',
		name:'printset_bc',
		handler : function(btn){
			if (cardprintSetViewForm.getForm().isValid()) {
				cardprintSetViewForm.getForm().submit({
					waitTitle : '请稍候',
					waitMsg : '正在保存数据,请稍候...',
					params : {username:currentZzUsername,bzjgdm:currentZzUserBzjgdm},
					success : function(form,action) {
						
					    Ext.Msg.show({
							title : '提示',
							msg : '保存参数设置成功',
							buttons : Ext.Msg.OK,
							fn : function(){
								cardprintSetViewForm.getForm().findField("prtType").setValue(Ext.get("pType").dom.value);
							    cardprintSetViewForm.getForm().findField("prtPort").setValue(cardprintSetViewForm.getForm().findField("printPort").getValue());
							    cardprintSetViewForm.getForm().findField("comPort").setValue(Ext.get("cPort").dom.value);
							    cardprintSetViewForm.getForm().findField("comBaud").setValue(cardprintSetViewForm.getForm().findField("baudRate").getValue());
							    
							},
							icon : Ext.Msg.INFO
						});
					},
					failure : function(form, action) {
						Ext.Msg.show({
							title : '提示',
							msg : '保存参数设置错误',
							buttons : Ext.Msg.OK,
							icon : Ext.Msg.ERROR
						});
					}
				});
			}
		
		}
    }]
});
var SearchPrintSet = function(){
	
	Ext.Ajax.request({
		url : 'findCardPrintSet.action',
		params : {username:currentZzUsername},
		method:'post', 
		waitTitle: '提示',
	    waitMsg: '数据正在重新加载中，请稍后',
		success : function(result,request) {//获取返回值
		    eval("var data = "+ result.responseText);
		    if(data != null){
		    	var str="";
		    
			    switch(data.printerType){
			    	case 1 :
			    		str = "P300系列";break;
			    	case 2 :
			    		str = "P400系列";break;
			    	case 3 :
			    		str = "NBS一体机";
			    }
			    cardprintSetViewForm.getForm().findField("prtType").setValue(str);//
			    cardprintSetViewForm.getForm().findField("prtPort").setValue(data.printPort);
			    
			    switch(data.communicationPort){
			    	case 1 :
			    		str = "COM1";break;
			    	case 2 :
			    		str = "COM2";break;
			    	case 3 :
			    		str = "COM3";break;
			    	case 4 :
			    		str = "COM4";
			    }
			    
			    cardprintSetViewForm.getForm().findField("comPort").setValue(str);//
			    cardprintSetViewForm.getForm().findField("comBaud").setValue(data.baudRate);
			    
		    }else{
		    	Ext.Msg.show({
					title : '提示',
					msg : '未进行过打印机参数设置，当前为默认设置',
					buttons : Ext.Msg.OK,
					fn : function() {
						cardprintSetViewForm.getForm().findField("prtType").setValue("P400系列");//
					    cardprintSetViewForm.getForm().findField("prtPort").setValue("LPT1:");
					    cardprintSetViewForm.getForm().findField("comPort").setValue("COM1");//
					    cardprintSetViewForm.getForm().findField("comBaud").setValue("9600");
					}
				});
		    }
		},
		failure : function() {
			Ext.Msg.show({
				title : '提示',
				msg : '加载打印机参数设置错误',
				buttons : Ext.Msg.OK,
				icon : Ext.Msg.ERROR
			});
		}
	});
	
}

//ic卡信息显示
var  cardprintSetViewForm2= new Ext.Panel({
   
    region      : 'center',
    id          : 'printsetInfo',
    collapsible:false,
    border : 'layout',
    bodyStyle: 'padding:10px',
    margins: '3 0 0 0',
    cmargins: '5 5 0 0',
	layout: 'fit',
    items : [cardprintSetViewForm]
});

var p_zzCardPrintSet = {
	id : 'zzCardPrintSet-panel',
	border : false,
	layout : 'border',
	bodyStyle: 'padding:0px',
	items : [{
		id:'border-panel',
	    layout:'border',
	    bodyBorder: false,
	    title: '打卡机设置',
	    iconCls : 'icon-plugin',
 		plain: true,
		region: 'center',
		items: [cardprintSetViewForm2]
	}]
}