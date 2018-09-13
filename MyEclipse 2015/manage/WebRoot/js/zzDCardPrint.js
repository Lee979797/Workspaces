
//--------------------机构基本信息-------------------------------------------
var cardDPrintViewForm = new Ext.FormPanel({	
	//url : 'saveOrgnew.action',
	labelAlign : 'right',
    bodyStyle:'padding:0px',
	labelWidth : 120,
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
                items: [
                	{ xtype:'textfield',fieldLabel : '机构代码',readOnly:true,name : 'jgdm',anchor:'100%'}
                ]
			},{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '机构类型',readOnly:true,name : 'jg',anchor:'100%'}
                	,{ xtype:'hidden',name : 'jglxdm'}
                	,{ xtype:'hidden',name : 'jglx'}
                	,{ xtype:'hidden',name : 'jglxdmOld'}
                	,{ xtype:'hidden',name : 'jglxOld'}
                ]
			},{
                columnWidth:1,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '机构名称',readOnly:true,name : 'jgmc',anchor:'100%'},
                	{ xtype:'textfield',fieldLabel : '经营范围' ,readOnly:true,name : 'jyfw',anchor:'100%'}
                
                ]
			},{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '法人代表',readOnly:true,name : 'fddbr',anchor:'100%'}
                ]
			},{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '身份证号',readOnly:true,name : 'zjhm',anchor:'100%'}
                ]
			},{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '经济行业',readOnly:true,name : 'jjhy',anchor:'100%'},
                	{ xtype:'textfield',fieldLabel : '经济类型',readOnly:true,name : 'jj',anchor:'100%'}
                	,{ xtype:'hidden',name : 'jjhydm'}
                	,{ xtype:'hidden',name : 'jjhymc'}
                	,{ xtype:'hidden',name : 'jjlxdm'}
                	,{ xtype:'hidden',name : 'jjlx'}
                ]
			},{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '成立日期',readOnly:true,name : 'zcrq',anchor:'100%'},
                	{ xtype:'textfield',fieldLabel : '职工人数',readOnly:true,name : 'zgrs',anchor:'100%'}]
			},{
                columnWidth:1,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '批准机构',readOnly:true,name : 'pzjgmc',anchor:'100%'}
                ]
			},{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '注册资金(万)',readOnly:true,name : 'zczj',anchor:'100%'},
                	{ xtype:'textfield',fieldLabel : '货币种类',readOnly:true,name : 'hb',anchor:'100%'}
                	,{ xtype:'hidden',name : 'hbzldm'}
                	,{ xtype:'hidden',name : 'hbzl'}
                ]
			},{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '邮政编码',readOnly:true,name : 'yzbm',anchor:'100%'},
                	{ xtype:'textfield',fieldLabel : '外方国别',readOnly:true,name : 'wf',anchor:'100%'}
                	,{ xtype:'hidden',name : 'wftzgbdm'}
                	,{ xtype:'hidden',name : 'wftzgb'}
                ]
			},{
                columnWidth:1,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '行政区划',readOnly:true,name : 'xzqh',anchor:'100%'},
                	{ xtype:'textfield',fieldLabel : '机构地址',readOnly:true,name : 'jgdz',anchor:'100%'}
                	,{ xtype:'hidden',name : 'xzqhName'}
                	,{ xtype:'hidden',name : 'xzqhCode'}
                ]
			},{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '联系电话',readOnly:true,name : 'dhhm',anchor:'100%'},
                	{ xtype:'textfield',fieldLabel : '法人手机',readOnly:true,name : 'mobile',anchor:'100%'}
                ]
			},{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '注册号(文件号)',readOnly:true,name : 'zch',anchor:'100%'},
                	{ xtype:'textfield',fieldLabel : '是否公开',readOnly:true,name : 'gk',anchor:'100%'}
                ]
			},{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '年检日期',readOnly:true,name : 'njrq',anchor:'100%'},
                	{ xtype:'textfield',fieldLabel : '年检期限',readOnly:true,name : 'njqx',anchor:'100%'}
                ]
			},{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '办证日期',readOnly:true,name : 'bzrq',anchor:'100%'},
                	{ xtype:'textfield',fieldLabel : '作废日期',readOnly:true,name : 'zfrq',anchor:'100%'}
                ]
			},{
                columnWidth:1,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '颁发单位',value:currentZzUserBzjgmc,readOnly:true,name : 'bfdw',anchor:'100%'}
                ]
			}/*,{
                columnWidth:1,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ 
                	xtype: 'radiogroup',
                	fieldLabel: '选择打卡流水号',
                	cls: 'x-check-group-alt',
                	items: [
		                {boxLabel: '12334', name: 'txtlsh', inputValue: 1, checked: true},
		                {boxLabel: '22344', name: 'txtlsh', inputValue: 2},
		                {boxLabel: '23232', name: 'txtlsh', inputValue: 3}
		            ]
                }]
            
			}*/]
         }]
});


//ic卡信息显示
var  cardDPrintViewForm2= new Ext.Panel({
    title       : '打卡信息',
    region      : 'center',
    id          : 'dcInfo',
    collapsible:false,
    border : 'layout',
    bodyStyle: 'padding:0px',
    margins: '3 0 0 0',
    cmargins: '5 5 0 0',
	layout: 'fit',
    items : [cardDPrintViewForm]
});

//ic卡控件
var cardDPrintForm_cab = new Ext.Panel({
	title:'打印控件',
	split:false,
	width:100,
	collapsible:true,
	collapsed: true,
	//hidden: true,
    region:'east',
    margins:'3 0 0 5',
    cmargins:'3 0 0 5',
    //activeTab: 0,
    html: '<object scope="application" width="0" height="0" classid="CLSID:5604A3B0-13F5-4AED-9A9D-B097D1FAC65C"'
	       +'align=center name="prt" codebase="IcCardPrint.CAB#version=1,3,0,3">'
	       +'</object> '
	
      
});


//默认查询 档案
var searchprintcard = function() {
	
	cardDPrintViewForm.getForm().reader = Orgnews;
	cardDPrintViewForm.getForm().load({
		waitMsg : '正在进行数据查询，请稍等',          //提示信息   
        waitTitle : '提示',                      //标题  
	    url: 'findAllOrgnew.action', //请求控制器获取数据
	    method: 'POST', //为"POST",则上面的url不会显示在浏览器的地址栏中
	    params: { conditions: text_search_cardprint.getValue(),username:currentZzUsername,ywlxConditions:'',stateConditions:'22,24,6,16',centerid:currentZzUserBzjgdm,start:1,limit:1},	
	    success:function(form,action) {//获取返回值
	    	if(action.result.data.orgid!=''){//自动加载原文
	    		//btn_del_buzheng.setDisabled(false);
	    		var tabwc=Ext.getCmp("dcInfo");
	    		tabwc.setTitle("打卡信息  (读取成功)");	
	    		var code = "";
	    		var name ="";
	    		
	    		code = cardDPrintViewForm.getForm().findField('jglxdmOld').getValue();
	    		name = cardDPrintViewForm.getForm().findField('jglxOld').getValue();
	    		cardDPrintViewForm.getForm().findField('jg').setValue(code+"  ("+name+")");
	    		
	    		code = cardDPrintViewForm.getForm().findField('jjhydm').getValue();
	    		name = cardDPrintViewForm.getForm().findField('jjhymc').getValue();
	    		cardDPrintViewForm.getForm().findField('jjhy').setValue(code+"  ("+name+")");
	    		
	    		code = cardDPrintViewForm.getForm().findField('jjlxdm').getValue();
	    		name = cardDPrintViewForm.getForm().findField('jjlx').getValue();
	    		cardDPrintViewForm.getForm().findField('jj').setValue(code+"  ("+name+")");
	    		
	    		code = cardDPrintViewForm.getForm().findField('hbzldm').getValue();
	    		name = cardDPrintViewForm.getForm().findField('hbzl').getValue();
	    		cardDPrintViewForm.getForm().findField('hb').setValue(code+"  ("+name+")");
	    		
	    		code = cardDPrintViewForm.getForm().findField('xzqhCode').getValue();
	    		name = cardDPrintViewForm.getForm().findField('xzqhName').getValue();
	    		cardDPrintViewForm.getForm().findField('xzqh').setValue(code+"  ("+name+")");
	    		
	    		code = cardDPrintViewForm.getForm().findField('wftzgbdm').getValue();
	    		name = cardDPrintViewForm.getForm().findField('wftzgb').getValue();
	    		cardDPrintViewForm.getForm().findField('wf').setValue(code+"  ("+name+")");
			}else{
				Ext.Msg.show({
					title : '提示',
					msg : '信息读取失败!',
					buttons : Ext.Msg.OK,
					icon : Ext.Msg.ERROR
				});
            }
		},
		failure : function() {//正式库检索
			Ext.Msg.show({
				title : '提示',
				msg : '没有查询到需打印的信息!',
				buttons : Ext.Msg.OK,
				icon : Ext.Msg.ERROR
			});
		}
	});
}

var btn_search_cardprint = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchprintcard();
	}
});


var text_search_cardprint = new Ext.form.TextField({
	id : 'textSearchcardprint',
	name : 'textSearchcardprint',
	width : 200,
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchprintcard();
			}
		}
	}
});

var btn_print_card = new Ext.Button({
	text : '打印',
	iconCls : 'icon-store',
	handler : function(){
		if(cardDPrintViewForm.getForm().findField('jgdm').getValue()!=""){
			
			Ext.Ajax.request({
				url : 'findCardPrintSet.action',
				params : {username:currentZzUsername},
				method:'post', 
				waitTitle: '提示',
			    waitMsg: '数据正在重新加载中，请稍后',
				success : function(result,request) {//获取返回值
				    eval("var data = "+ result.responseText);
				    
				    if(data!=null){
				    	//打印端口
						prt.gPrintPort=data.printPort;
						//通讯波特率
						prt.gBaudRate=data.baudRate;
						//打卡机类型
						prt.gPrinterType=data.printerType;
						//通讯端口
						prt.gCommunicationPort=data.communicationPort;
						
				    }else{
				    	//打印端口
						prt.gPrintPort="LPT1:";
						//通讯波特率
						prt.gBaudRate=9600;
						//打印机类型
						prt.gPrinterType=2;
						//通讯端口
						prt.gCommunicationPort=1;
				    }
				    
				    if(fPrintCard()){
				    	Ext.Msg.show({
							title : '提示',
							msg : '正常打卡完毕！',
							buttons : Ext.Msg.OK,
							icon : Ext.Msg.INFO,
							fn : function(){
								/////////在数据库中记录下ic卡的序列号
								//CardSerialNo=4;
								Ext.Ajax.request({
									url : 'saveICKxlh.action',
									params : {ickxlh:CardSerialNo,printerName:currentZzUsername,centerid:currentZzUserCenterid,orgCode:cardDPrintViewForm.getForm().findField('jgdm').getValue()},
									method:'post', 
									waitTitle: '提示',
								    waitMsg: '数据正在重新加载中，请稍后',
									success : function(result,request) {
										
									},
									failure: function(){
										alert("保存信息不成功！");
									}
								});
								cardDPrintViewForm.getForm().reset();
								text_search_cardprint.setValue("");
							}
						});
				    }
				},
				failure : function() {
					Ext.Msg.show({
						title : '提示',
						msg : '获取设置参数错误！',
						buttons : Ext.Msg.OK,
						fn:function(){return},
						icon : Ext.Msg.ERROR
					});
				}
			});
			
		}else{
			Ext.Msg.show({
				title : '提示',
				msg : '没有要打卡的信息，请填写后打卡！',
				buttons : Ext.Msg.OK
			});
		}
	}
});

var btn_printreset_card = new Ext.Button({
	text : '重置',
	iconCls : 'icon-refresh',
	handler : function(){
		cardDPrintViewForm.getForm().reset();
	}
});

var p_zzDCardPrint = {
	id : 'zzDCardPrint-panel',
	border : false,
	layout : 'border',
	bodyStyle: 'padding:0px',
	items : [{
		id:'border-panel',
	    layout:'border',
	    bodyBorder: false,
	    title: '打卡操作',
	    iconCls : 'icon-plugin',
 		plain: true,
		region: 'center',
		tbar : [btn_print_card,btn_printreset_card,'->',text_search_cardprint,btn_search_cardprint],
		items: [cardDPrintViewForm2,cardDPrintForm_cab]
	}]
}