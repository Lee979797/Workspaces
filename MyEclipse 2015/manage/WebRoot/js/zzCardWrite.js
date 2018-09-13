//--------------------机构基本信息-------------------------------------------
var cardwriteViewForm = new Ext.FormPanel({	
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
                	,{ xtype:'hidden',name : 'jglxOld'}
                	,{ xtype:'hidden',name : 'jglxdmOld'}
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
                	,{ xtype:'hidden',name : 'hbzl'}
                	,{ xtype:'hidden',name : 'hbzldm'}
                ]
			},{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '经济类型',readOnly:true,name : 'jj',anchor:'100%'},
                	{ xtype:'textfield',fieldLabel : '行政区划',readOnly:true,name : 'xzqh',anchor:'100%'}
                	,{ xtype:'hidden',name : 'jjlx'}
                	,{ xtype:'hidden',name : 'jjlxdm'}
                	,{ xtype:'hidden',name : 'xzqhName'}
                	,{ xtype:'hidden',name : 'xzqhCode'}
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
                	{ xtype:'textfield',fieldLabel : '投资国别',readOnly:true,name : 'wf',anchor:'100%'},
                	{ xtype:'hidden',name : 'wftzgb'}
                	,{ xtype:'hidden',name : 'wftzgbdm'},
                	{ xtype:'textfield',fieldLabel : '年检日期',readOnly:true,name : 'njrq',anchor:'100%'}
				]
			},{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '电话号码',readOnly:true,name : 'dhhm',anchor:'100%'}
                	,{ xtype:'textfield',fieldLabel : '卡序列号',readOnly:true,name : 'kxlh',anchor:'100%'}]
			}]
         }]
});


//ic卡信息显示
var  cardwriteViewForm2= new Ext.Panel({
    title       : '写卡信息',
    region      : 'center',
    id          : 'wcInfo',
    collapsible:false,
    border : 'layout',
    bodyStyle: 'padding:0px',
    margins: '3 0 0 0',
    cmargins: '5 5 0 0',
	layout: 'fit',
    items : [cardwriteViewForm]
});

//ic卡控件
var cardWriteForm_cab = new Ext.Panel({
	title:'写卡控件',
	split:false,
	width:100,
	collapsible:true,
	collapsed: true,
	//hidden: true,
    region:'east',
    margins:'3 0 0 5',
    cmargins:'3 0 0 5',
    //activeTab: 0,
    html: '<object scope="application" width="32" height="32" classid="CLSID:43FF18D6-10EC-4DB4-9923-31ECDC6DFA19"'
	       +'codebase=icocx/SmartCard.cab name="SmartCard" style="display:None">'
	       +'</object> '
	
});

function searchcardwrite(){
	
	cardwriteViewForm.getForm().reader = Orgnews;
	cardwriteViewForm.getForm().load({
		waitMsg : '正在进行数据查询，请稍等',          //提示信息   
        waitTitle : '提示',                      //标题  
	    url: 'findAllOrgnew.action', //请求控制器获取数据
	    method: 'POST', //为"POST",则上面的url不会显示在浏览器的地址栏中
	    params: { conditions: text_search_cardwrite.getValue(),username:currentZzUsername,ywlxConditions:'',stateConditions:'22,24,6,16',centerid:currentZzUserBzjgdm,start:1,limit:1},	
	    success:function(form,action) {//获取返回值
	    	if(action.result.data.orgid!=''){//自动加载原文
	    		//btn_del_buzheng.setDisabled(false);
	    		var tabwc=Ext.getCmp("wcInfo");
	    		tabwc.setTitle("写卡信息  (读取成功)");	
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
				msg : '信息错误!',
				buttons : Ext.Msg.OK,
				icon : Ext.Msg.ERROR
			});
		}
	});

}

var btn_search_cardwrite = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchcardwrite();
	}
});


var text_search_cardwrite = new Ext.form.TextField({
	id : 'textSearchcardwrite',
	name : 'textSearchcardwrite',
	width : 200,
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchcardwrite();
			}
		}
	}
});


var btn_xieru_cardwrite = new Ext.Button({
	text : '写卡',
	iconCls : 'icon-store',
	handler : function(){
		//alert('写卡操作');
			
			if(cardwriteViewForm.getForm().findField('jgdm').getValue()!=""){
				fWriteCard();
			}else{
				Ext.Msg.show({
					title : '提示',
					msg : '没有将要写卡的信息！',
					buttons : Ext.Msg.OK,
					icon : Ext.Msg.INFO
				});
			}
		
		
	}
});
var btn_reset_cardwrite = new Ext.Button({
	text : '重置',
	iconCls : 'icon-refresh',
	handler : function(){
		cardwriteViewForm.getForm().reset();
	}
});


var p_zzCardWrite = {
	id : 'zzCardWrite-panel',
	border : false,
	layout : 'border',
	bodyStyle: 'padding:0px',
	items : [{
		id:'border-panel',
	    layout:'border',
	    bodyBorder: false,
	    title: '写卡操作',
	    iconCls : 'icon-plugin',
 		plain: true,
		region: 'center',
		tbar : [btn_xieru_cardwrite,btn_reset_cardwrite,'->',text_search_cardwrite,btn_search_cardwrite],
		items: [cardwriteViewForm2,cardWriteForm_cab]
	}]
}