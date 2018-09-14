//--------------------机构基本信息-------------------------------------------
var cardreadViewForm = new Ext.FormPanel({	
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
                columnWidth:1,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '机构名称',readOnly:true,name : 'jgmc',anchor:'100%'},
                	{ xtype:'textfield',fieldLabel : '机构地址',readOnly:true,name : 'jgdz',anchor:'100%'}
                ]
			},{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '机构代码',readOnly:true,name : 'jgdm',anchor:'100%'},
                	{ xtype:'textfield',fieldLabel : '机构类型',readOnly:true,name : 'jg',anchor:'100%'}
                	,{xtype:'hidden',name:'jglxOld'}
                	,{xtype:'hidden',name:'jglxdmOld'}
                ]
			},{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '颁发单位',value:sysZsbfdw,readOnly:true,name : 'bfdw',anchor:'100%'},
                	{ xtype:'textfield',fieldLabel : '颁发日期',readOnly:true,name : 'bzrq',anchor:'100%'}
                ]
			},{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '法人代表',readOnly:true,name : 'fddbr',anchor:'100%'},
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
                	{ xtype:'textfield',fieldLabel : '经济类型',readOnly:true,name : 'jj',anchor:'100%'},
                	{ xtype:'textfield',fieldLabel : '行政区划',readOnly:true,name : 'xzqh',anchor:'100%'}
                	,{xtype:'hidden',name:'jjlx'}
                	,{xtype:'hidden',name:'jjlxdm'}
                	,{xtype:'hidden',name:'xzqhName'}
                	,{xtype:'hidden',name:'xzqhCode'}
                ]
			},{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '注册号',readOnly:true,name : 'zch',anchor:'100%'},
                	{ xtype:'textfield',fieldLabel : '邮政编码',readOnly:true,name : 'yzbm',anchor:'100%'}]
			},{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '注册资金(万)',readOnly:true,name : 'zczj',anchor:'100%'},
                	{ xtype:'textfield',fieldLabel : '年检期限',readOnly:true,name : 'njqx',anchor:'100%'}
                ]
			},{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '投资国别',readOnly:true,name : 'wf',anchor:'100%'}
                	,{xtype:'hidden',name:'wftzgb'}
                	,{xtype:'hidden',name:'wftzgbdm'},
                	{ xtype:'textfield',fieldLabel : '年检日期',readOnly:true,name : 'njrq',anchor:'100%'}
                ]
			},{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '电话号码',readOnly:true,name : 'dhhm',anchor:'100%'},
                	{ xtype:'textfield',fieldLabel : '卡序列号',readOnly:true,name : 'kxlh',anchor:'100%'}]
			}]
         }]
});


//ic卡信息显示
var  cardreadViewForm2= new Ext.Panel({
    title       : '读卡信息',
    region      : 'center',
    id          : 'rcInfo',
    collapsible:false,
    border : 'layout',
    bodyStyle: 'padding:0px',
    margins: '3 0 0 0',
    cmargins: '5 5 0 0',
	layout: 'fit',
    items : [cardreadViewForm]
});

//ic卡控件
var cardReadForm_cab = new Ext.Panel({
	title:'读卡控件',
	split:false,
	width:100,
	collapsible:true,
	collapsed: true,
	//hidden: true,
    region:'east',
    margins:'3 0 0 5',
    cmargins:'3 0 0 5',
    //activeTab: 0,
    html: '<OBJECT ID="HD_GetIndexInfo" CLASSID="CLSID:E0F75AD4-006C-4B32-B45C-E8FD6E9E335F"  CODEBASE="HD_GetIndexInfo.ocx#version=1,5,0,0"  height="0"  width="0" VIEWASTEXT>'
	      +'</object> '
	     
});

/*
var btn_search_nianjian = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchnianjian();
	}
});


var text_search_nianjian = new Ext.form.TextField({
	id : 'textSearchnianjian',
	name : 'textSearchnianjian',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchnianjian();
			}
		}
	}
});
*/

var btn_duru_cardread = new Ext.Button({
	text : '读卡',
	iconCls : 'icon-store',
	handler : function(){
		
			
			if(fReadCard()){
				Ext.Msg.show({
					title : '提示',
					msg : '正常读卡完毕！',
					buttons : Ext.Msg.OK,
					fn : function(){
						var code = "";
			    		var name ="";
			    		//
			    		code = cardreadViewForm.getForm().findField('jglxdmOld').getValue();
			    		name = cardreadViewForm.getForm().findField('jglxOld').getValue();
			    		cardreadViewForm.getForm().findField('jg').setValue(code+"  ("+name+")");
			    		
			    		//
			    		code = cardreadViewForm.getForm().findField('jjlxdm').getValue();
			    		name = cardreadViewForm.getForm().findField('jjlx').getValue();
			    		cardreadViewForm.getForm().findField('jj').setValue(code+"  ("+name+")");
			    		//
			    		code = cardreadViewForm.getForm().findField('hbzldm').getValue();
			    		name = cardreadViewForm.getForm().findField('hbzl').getValue();
			    		cardreadViewForm.getForm().findField('hb').setValue(code+"  ("+name+")");
			    		//
			    		code = cardreadViewForm.getForm().findField('xzqhCode').getValue();
			    		name = cardreadViewForm.getForm().findField('xzqhName').getValue();
			    		cardreadViewForm.getForm().findField('xzqh').setValue(code+"  ("+name+")");
			    		//
			    		code = cardreadViewForm.getForm().findField('wftzgbdm').getValue();
			    		name = cardreadViewForm.getForm().findField('wftzgb').getValue();
			    		if(code != null||name!=null){
			    			cardreadViewForm.getForm().findField('wf').setValue(code+"  ("+name+")");
			    		}
					},
					icon : Ext.Msg.INFO
				});
			}
		
	}
});
var btn_reset_cardread = new Ext.Button({
	text : '重置',
	iconCls : 'icon-refresh',
	handler : function(){
		cardreadViewForm.getForm().reset();
	}
});

var p_zzCardRead = {
	id : 'zzCardRead-panel',
	border : false,
	layout : 'border',
	bodyStyle: 'padding:0px',
	items : [{
		id:'border-panel',
	    layout:'border',
	    bodyBorder: false,
	    title: '读卡操作',
	    iconCls : 'icon-plugin',
 		plain: true,
		region: 'center',
		tbar : [btn_duru_cardread,btn_reset_cardread/*,'->',text_search_nianjian,btn_search_nianjian*/],
		items: [cardreadViewForm2,cardReadForm_cab]
	}]
}