//--------------------机构基本信息-------------------------------------------
var cardnjViewForm = new Ext.FormPanel({	
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
                	{xtype:'textfield',fieldLabel : '机构代码',readOnly:true,name : 'jgdm',anchor:'100%'},
                	{xtype:'textfield',fieldLabel : '机构类型',readOnly:true,name : 'jg',anchor:'100%'}
                	,{xtype:'hidden',name:'jglx'}
                	,{xtype:'hidden',name:'jglxdm'}
                	,{xtype:'hidden',name:'jglxOld'}
                	,{xtype:'hidden',name:'jglxdmOld'}
                ]
			},{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{xtype:'textfield',fieldLabel : '机构名称',readOnly:true,name : 'jgmc',anchor:'100%'},
                	{xtype:'textfield',fieldLabel : '机构地址',readOnly:true,name : 'jgdz',anchor:'100%'}]
			},{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{xtype:'textfield',fieldLabel : '办证日期',readOnly:true,name : 'bzrq',anchor:'100%'}]
			},{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{xtype:'textfield',fieldLabel : '作废日期',readOnly:true,name : 'zfrq',anchor:'100%'}]
			},{
                columnWidth:1,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '经营范围',readOnly:true,name : 'jyfw',anchor:'100%'}]
			},{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '成立日期',name : 'zcrq',readOnly:true,anchor:'100%'},
                	{ xtype:'textfield',fieldLabel : '职工人数',readOnly:true,name : 'zgrs',anchor:'100%'}]
			},{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '颁发单位',value:currentZzUserBzjgmc,readOnly:true,name : 'bfdw',anchor:'100%'},
                	{ xtype:'textfield',fieldLabel : '行政区划名称',readOnly:true,name : 'xzqhName',anchor:'100%'}]
			},{
                columnWidth:1,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '批准机构',readOnly:true,name : 'pzjg',anchor:'100%'}
                	,{xtype:'hidden',name:'pzjgdm'}
                	,{xtype:'hidden',name:'pzjgmc'}
                ]
			},{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '经济行业',readOnly:true,name : 'jjhy1',anchor:'100%'}
                	
                ]
			},{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '经济类型',readOnly:true,name : 'jj1',anchor:'100%'}
                	
                ]
			},{
				xtype: 'fieldset',
				title: '以下内容为卡年检时写入卡内信息',
				//region: 'center',
        		defaults: {anchor: '100%'},
                columnWidth:1,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [////////////////
                	{//第一行修改
						layout : 'column',
						border : false,
						baseCls : 'x-plain',
						items : [{
			                columnWidth:.5,
			                layout: 'form',
			                bodyStyle: 'padding:0px',
			                border:false,
			                items: [
			                	{ xtype:'textfield',fieldLabel : '法人代表',readOnly:true,name : 'fddbr',anchor:'100%'},
			                	{ xtype:'textfield',fieldLabel : '身份证',readOnly:true,name : 'zjhm',anchor:'100%'}]
						},{
			                columnWidth:.5,
			                layout: 'form',
			                bodyStyle: 'padding:0px',
			                border:false,
			                items: [
			                	{ xtype:'textfield',fieldLabel : '经济行业',readOnly:true,name : 'jjhy',anchor:'100%'},
			                	{ xtype:'textfield',fieldLabel : '经济类型',readOnly:true,name : 'jj',anchor:'100%'}
			                	,{xtype:'hidden',name:'jjhydm'}
			                	,{xtype:'hidden',name:'jjhymc'}
			                	,{xtype:'hidden',name:'jjlxdm'}
			                	,{xtype:'hidden',name:'jjlx'}
			                ]
						}]
					},{
						//第2行修改
						layout : 'column',
						border : false,
						baseCls : 'x-plain',
						items : [{
			                columnWidth:.5,
			                layout: 'form',
			                bodyStyle: 'padding:0px',
			                border:false,
			                items: [
			                	{ xtype:'textfield',fieldLabel : '注册资金(万)',readOnly:true,name : 'zczj',anchor:'100%'},
			                	{ xtype:'textfield',fieldLabel : '货币种类',readOnly:true,name : 'hb',anchor:'100%'}
			                	,{xtype:'hidden',name:'hbzl'}
			                	,{xtype:'hidden',name:'hbzldm'}
			                ]
						},{
			                columnWidth:.5,
			                layout: 'form',
			                bodyStyle: 'padding:0px',
			                border:false,
			                items: [
			                	{ xtype:'textfield',fieldLabel : '邮政编码',readOnly:true,name : 'yzbm',anchor:'100%'},
			                	{ xtype:'textfield',fieldLabel : '外方国别',readOnly:true,name : 'wf',anchor:'100%'}
			                	,{xtype:'hidden',name:'wftzgb'}
                				,{xtype:'hidden',name:'wftzgbdm'}
			                ]
						}]
					},{//第3行修改
						layout : 'column',
						border : false,
						baseCls : 'x-plain',
						items : [{
			                columnWidth:.5,
			                layout: 'form',
			                bodyStyle: 'padding:0px',
			                border:false,
			                items: [
			                	{ xtype:'textfield',fieldLabel : '注册号(文件号)',readOnly:true,name : 'zch',anchor:'100%'},
			                	{ xtype:'textfield',fieldLabel : '联系电话',readOnly:true,name : 'dhhm',anchor:'100%'}]
						},{
			                columnWidth:.5,
			                layout: 'form',
			                bodyStyle: 'padding:0px',
			                border:false,
			                items: [
			                	{ xtype:'textfield',fieldLabel : '年检日期',readOnly:true,name : 'njrq',anchor:'100%'},
			                	{ xtype:'textfield',fieldLabel : '年检期限',readOnly:true,name : 'njqx',anchor:'100%'}]
						}]
					},{//第4行修改
						layout : 'column',
						border : false,
						baseCls : 'x-plain',
						items : [{
			                columnWidth:.5,
			                layout: 'form',
			                bodyStyle: 'padding:0px',
			                border:false,
			                items: [
			                	{ xtype:'textfield',fieldLabel : '行政区划代码',readOnly:true,name : 'xzqhCode',anchor:'100%'}
			                ]
						},{
			                columnWidth:.5,
			                layout: 'form',
			                bodyStyle: 'padding:0px',
			                border:false,
			                items: [{ xtype:'combo',fieldLabel : '读卡器串口号',name : 'listCom',
									id : 'dkqckh_cardnj',
									store: new Ext.data.SimpleStore({
										fields:['value','text'],
			                			data:[
			                				['1','com1'],
			                				['2','com2'],
			                				['3','com3'],
			                				['4','com4']
			                			]
									}),
									displayField:'text',
			                		valueField:'value',
			                		value: '1',
			                		forceSelection : true,
			                		typeAhead: true,
			                		triggerAction : 'all',
									lazyRender:true,
									readOnly: true,
									editable: false,
			                		mode:'local',
									loadingText : '加载中...'
			                	}]
						}]
					}/*,{//第5行修改
						layout : 'column',
						border : false,
						baseCls : 'x-plain',
						items : [{
			                columnWidth:1,
			                layout: 'form',
			                bodyStyle: 'padding:0px',
			                border:false,
			                items: [{ 
			                	xtype: 'radiogroup',
			                	name: 'lsh',
			                	fieldLabel: '选择打卡流水号',
			                	cls: 'x-check-group-alt',
			                	items: [
					                {boxLabel: '12334', name: 'txtlsh', inputValue: 1, checked: true},
					                {boxLabel: '22344', name: 'txtlsh', inputValue: 2},
					                {boxLabel: '23232', name: 'txtlsh', inputValue: 3}
					            ]
			                }]
						}]
					}*/
                ]////////////////
			}]
         }]
});


//ic卡信息显示
var  cardnjViewForm2= new Ext.Panel({
    title       : '年检信息',
    region      : 'center',
    id          : 'jbInfo25987',
    collapsible:false,
    border : 'layout',
    bodyStyle: 'padding:0px',
    margins: '3 0 0 0',
    cmargins: '5 5 0 0',
	layout: 'fit',
    items : [cardnjViewForm]
});

//ic卡控件
var cardForm_cab = new Ext.Panel({
	title:'年检写卡控件',
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
	       +'align=center name="prt1" codebase="icocx/IcCardPrint.CAB#version=1,3,0,3">'
	       +'</object> '
	
});


//默认查询 档案
var searchcardnj = function() {
	cardnjViewForm.getForm().reader = Orgnews;
	cardnjViewForm.getForm().load({
		waitMsg : '正在进行数据查询，请稍等',          //提示信息   
        waitTitle : '提示',                      //标题  
	    url: 'findAllOrgnew.action', //请求控制器获取数据
	    method: 'POST', //为"POST",则上面的url不会显示在浏览器的地址栏中
	    params: { conditions: text_search_cardnj.getValue(),username:currentZzUsername,ywlxConditions:'',stateConditions:'22,24,4,12,16',centerid:currentZzUserBzjgdm,start:1,limit:1},	
	    success:function(form,action) {//获取返回值
	    	if(action.result.data.orgid!=''){//自动加载原文
	    		btn_del_buzheng.setDisabled(false);
	    		var tab3452=Ext.getCmp("jbInfo25987");
	    		tab3452.setTitle("年检信息  (读取成功)");
	    		
	    		var code = "";
	    		var name = "";
	    		
	    		code = cardnjViewForm.getForm().findField('jglxdmOld').getValue();
	    		name = cardnjViewForm.getForm().findField('jglxOld').getValue();
	    		cardnjViewForm.getForm().findField('jg').setValue(code+"("+name+")");
	    		
	    		code = cardnjViewForm.getForm().findField('pzjgdm').getValue();
	    		name = cardnjViewForm.getForm().findField('pzjgmc').getValue();
	    		cardnjViewForm.getForm().findField('pzjg').setValue(code+"("+name+")");
	    		
	    		code = cardnjViewForm.getForm().findField('jjhydm').getValue();
	    		name = cardnjViewForm.getForm().findField('jjhymc').getValue();
	    		cardnjViewForm.getForm().findField('jjhy').setValue(code+"("+name+")");
	    		cardnjViewForm.getForm().findField('jjhy1').setValue(code+"("+name+")");
	    		
	    		code = cardnjViewForm.getForm().findField('jjlxdm').getValue();
	    		name = cardnjViewForm.getForm().findField('jjlx').getValue();
	    		cardnjViewForm.getForm().findField('jj').setValue(code+"("+name+")");
	    		cardnjViewForm.getForm().findField('jj1').setValue(code+"("+name+")");
	    		
	    		code = cardnjViewForm.getForm().findField('hbzldm').getValue();
	    		name = cardnjViewForm.getForm().findField('hbzl').getValue();
	    		cardnjViewForm.getForm().findField('hb').setValue(code+"("+name+")");
	    		
	    		code = cardreadViewForm.getForm().findField('wftzgbdm').getValue();
	    		name = cardreadViewForm.getForm().findField('wftzgb').getValue();
	    		if(code != null||name!=null){
	    			cardreadViewForm.getForm().findField('wf').setValue(code+"  ("+name+")");
	    		}
	    		
			}else{
				Ext.Msg.show({
					title : '提示',
					msg : '信息不完整，将信息完整后进行！',
					buttons : Ext.Msg.OK,
					icon : Ext.Msg.INFO
				});
            }
		},
		failure : function() {//正式库检索
			Ext.Msg.show({
				title : '提示',
				msg : '业务已办理完毕，无法年检写卡！',
				buttons : Ext.Msg.OK,
				icon : Ext.Msg.INFO
			});
		}
	});
}

var btn_search_cardnj = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchcardnj();
	}
});


var text_search_cardnj = new Ext.form.TextField({
	id : 'textSearchcardnj',
	name : 'textSearchcardnj',
	width : 200,
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchcardnj();
			}
		}
	}
});

var btn_xieru_cardnj = new Ext.Button({
	text : '卡年检',
	handler : function(){
		if(cardnjViewForm.getForm().findField('jgdm').getValue()!=""){
			if(cardnjViewForm.getForm().findField('listCom').getValue()!=""){
				if(fWriteCardNJ()){
					Ext.Msg.show({
						title : '提示',
						msg : '年检成功！',
						buttons : Ext.Msg.OK,
						fn : function(){
							cardnjViewForm.getForm().reset();
							text_search_cardnj.setValue("");
						},
						icon : Ext.Msg.INFO
					});
				}else{
					Ext.Msg.show({
						title : '提示',
						msg : '年检失败，请选择正确的端口号重试！',
						buttons : Ext.Msg.OK,
						/*fn : function(){
							cardnjViewForm.getForm().reset();
						},*/
						icon : Ext.Msg.INFO
					});
				}
			}else{
				Ext.Msg.show({
					title : '提示',
					msg : '还未选择读卡器的串口号！',
					buttons : Ext.Msg.OK,
					icon : Ext.Msg.INFO
				});
			}
		}else{
			Ext.Msg.show({
				title : '出错',
				msg : '没有将要写卡的信息！',
				buttons : Ext.Msg.OK,
				icon : Ext.Msg.INFO
			});
		}
	}
});
var btn_reset_cardnj = new Ext.Button({
	text : '重置',
	handler : function(){
		cardnjViewForm.getForm().reset();
	}
});

var p_zzCardAudit = {
	id : 'zzCardAudit-panel',
	border : false,
	layout : 'border',
	bodyStyle: 'padding:0px',
	items : [{
		id:'border-panel',
	    layout:'border',
	    bodyBorder: false,
	    title: 'IC卡年检操作',
	    iconCls : 'icon-plugin',
 		plain: true,
		region: 'center',
		tbar : [btn_xieru_cardnj,btn_reset_cardnj,'->',text_search_cardnj,btn_search_cardnj],
		items: [cardnjViewForm2,cardForm_cab]
	}]
}