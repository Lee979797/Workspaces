
//--------------------机构基本信息-------------------------------------------
var cardPrintViewForm = new Ext.FormPanel({
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
            defaults : {anchor : '93%'},
            items: [
            	{ xtype:'textfield',fieldLabel : '机构名称',readOnly:true,name : 'jgmc'},
            	{ xtype:'textfield',fieldLabel : '机构地址',readOnly:true,name : 'jgdz'},
            	{ xtype:'textfield',fieldLabel : '机构代码',readOnly:true,name : 'jgdm'},
            	{ xtype:'textfield',fieldLabel : '法人代表',readOnly:true,name : 'fddbr'},
            	{ xtype:'textfield',fieldLabel : '颁发日期',readOnly:true,name : 'bfrq',value:dateFormatToYMD(myDate.format('Y-m-d'))}
            ]
		}]
     }]
});

//ic卡信息显示
var  cardPrintViewForm2= new Ext.Panel({
    title       : '打卡信息',
    region      : 'center',
    id          : 'cpInfo',
    collapsible:false,
    border : 'layout',
    bodyStyle: 'padding:0px',
    margins: '3 0 0 0',
    cmargins: '5 5 0 0',
	layout: 'fit',
    items : [cardPrintViewForm]
});

//ic卡控件
var cardPrintForm_cab = new Ext.Panel({
	//title: "设置打印机打卡机名称",
	split: true,
	autoWidth :true,
	//collapsible:true,
	//collapsed: true,//是否默认打开
	autoScroll: true,
    region:'north',
    height:40,
    margins:'3 0 0 0',
    cmargins:'3 0 0 5',
    html: '<object width="100%" height="100%" align="center" classid="clsid:917FD85D-CA3D-4C05-BDC7-D9E49B7607C7"'
	       +'codebase="NacaoPrintProj.ocx#version=1.0.0.0" hspace="0" vspace="0" id="NPrint" name="NPrint">'
	       +'</object> '
	
});

function searchCardPrint(){
	
	cardPrintViewForm.getForm().reader = Orgnews;
	cardPrintViewForm.getForm().load({
		waitMsg : '正在进行数据查询，请稍等',          //提示信息   
        waitTitle : '提示',                      //标题  
	    url: 'findAllOrgnew.action', //请求控制器获取数据
	    method: 'POST', //为"POST",则上面的url不会显示在浏览器的地址栏中
	    params: { conditions: text_search_CardPrint.getValue(),username:currentZzUsername,ywlxConditions:'',stateConditions:'22,24,6,12,16',centerid:currentZzUserBzjgdm,start:1,limit:1},	
	    success:function(form,action) {//获取返回值
	    	if(action.result.data.orgid!=''){
	    		var tabwc=Ext.getCmp("cpInfo");
	    		tabwc.setTitle("打卡信息  (读取成功)");	
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

var btn_search_CardPrint = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchCardPrint();
	}
});

var text_search_CardPrint = new Ext.form.TextField({
	id : 'textsearchCardPrint',
	name : 'textsearchCardPrint',
	width : 200,
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchCardPrint();
			}
		}
	}
});

var btn_print_CardPrint = new Ext.Button({
	text : '打卡',
	iconCls : 'icon-print',
	handler : function(){
		var jgmc = cardPrintViewForm.getForm().findField('jgmc').getValue();
		if(jgmc==null||jgmc==""){
			alert("没有要打卡的信息！请先查询相关信息！");
		}else{
			NPrint.IC_JGDM = "1|黑体|9|"+cardPrintViewForm.getForm().findField('jgdm').getValue()+"|";
			NPrint.IC_JGMC = "1|黑体|9|"+cardPrintViewForm.getForm().findField('jgmc').getValue()+"|";
			NPrint.IC_JGDZ = "1|黑体|9|"+cardPrintViewForm.getForm().findField('jgdz').getValue()+"|";
			NPrint.IC_FDDBR = "1|黑体|9|"+cardPrintViewForm.getForm().findField('fddbr').getValue()+"|";
			NPrint.IC_BFRQ = "1|黑体|9|"+cardPrintViewForm.getForm().findField('bfrq').getValue()+"|";
			NPrint.PrintType = 1;
			NPrint.NacaoPrint();
			
			cardPrintViewForm.getForm().reset();
			text_search_CardPrint.setValue("");
			var tabwc=Ext.getCmp("cpInfo");
		    tabwc.setTitle("打卡信息");	
		}
	}
});

var btn_design_CardPrint = new Ext.Button({
	text : '打卡设置',
	iconCls : 'icon-store',
	handler : function(){
		NPrint.NacaoDesign();
	}
});

var btn_designPrinter_CardPrint = new Ext.Button({
	text : '设置打印机名称',
	iconCls : 'blist',
	handler : function(){
		//cardPrintForm_cab.expand(true);
		NPrint.SetPrintName();
	}
});

var btn_reset_CardPrint = new Ext.Button({
	text : '重置',
	iconCls : 'icon-refresh',
	handler : function(){
		cardPrintViewForm.getForm().reset();
		text_search_CardPrint.setValue("");
		var tabwc=Ext.getCmp("cpInfo");
	    tabwc.setTitle("打卡信息");	
	}
});

var p_zzCardPrint = {
	id : 'zzCardPrint-panel',
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
		tbar : [btn_print_CardPrint,btn_design_CardPrint,btn_designPrinter_CardPrint,btn_reset_CardPrint,'->',text_search_CardPrint,btn_search_CardPrint],
		items: [cardPrintViewForm2,cardPrintForm_cab]
	}]
}
