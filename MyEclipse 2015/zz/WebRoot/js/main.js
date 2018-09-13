// 右侧主显示区  欢迎页面


Ext.BLANK_IMAGE_URL = '/zz/resources/images/default/s.gif';
Ext.useShims = true;
Ext.QuickTips.init();
Ext.form.Field.prototype.msgTarget='title';//再设置提示样式qtip、side、title、under


var start = {
	id : 'start-panel',
	title : '欢迎使用',
	layout : 'fit',
	bodyStyle : 'padding:10px',
	html : '<table width=100% height=100% border=0><tr><td align=right valign=bottom><img src="/zz/images/bg.jpg"/></td></tr></table>'
};

 
Ext.form.TextField.override({
    initComponent: Ext.form.TextField.prototype.initComponent.createInterceptor(function(){  
        if (this.allowBlank === false && this.fieldLabel) {  
            this.fieldLabel ='<font color=red>*</font>' + this.fieldLabel;  
        }  
    })  
}); 
//vtype方式验证的方法
Ext.apply(Ext.form.VTypes, {
	dhhmphone:function(val,field)  
	{  
		try{  
			//var a=/^(0[0-9]{2,4}-)?([1-9][0-9]{3,10})+(-[0-9]{1,6})?$|(^(13[0-9]|15[0|3|6|7|8|9]|18[8|9])d{8}$)/;
			//var a=/^(0[0-9]{2,4}-)?([1-9][0-9]{3,10})+(-[0-9]{1,6})?$|(^(13[0-9]|15[0-9]|18[0-9])d{8}$)/;
			var a=/^(0[0-9]{2,4}(-)?)?([1-9][0-9]{3,10})+(-[0-9]{1,6})?$|(^(13[0-9]|15[0-9]|18[0-9])d{8}$)/;//15[0|3|6|7|8|9]|18[8|9]
			var b = /(^0?[1][35][0-9]{9}$)/;
			if(a.test(val)||b.test(val))
				return true;  
			return false;  
	    }catch(e){  
			return false;  
		}  
	},dhhmphoneText:'请输入正确的电话/手机号码,如:0920-29392929或13122212123',
	phone:function(val,field)  
	{  
		try{  
			var a=/^(0[0-9]{2,3}-)?([2-9][0-9]{3,10})+(-[0-9]{1,6})?$/;
			if(a.test(val))
				return true;  
			return false;  
	    }catch(e){  
			return false;  
		}  
	},phoneText:'请输入正确的电话号码,如:0920-29392929',
	mobilephone:function(val,field)  
	{  
		try{
			if(typeof(val)=="undefined"){
				return false;
			}
			if(val==""||val==null){
				return false;
			}
			if(val.length!=11){
				return false;
			}
			var myreg =/^(1[3-9]{1}[0-9]{1})\d{8}$/;
			if(!myreg.test(val)){
				return false;
			}
			return true;
		}catch(e){  
			return false;  
		}  
	},mobilephoneText:'请输入正确的手机号码',
	sfzhao : function(val, field) {// val指这里的文本框值，field指这个文本框组件，大家要明白这个意思
		if (field.confirmTo) {// confirmTo是我们自定义的配置参数，一般用来保存另外的组件的id值
			var zjlx = Ext.get(field.confirmTo);// 取得confirmTo的那个id的值
			if(zjlx.getValue()=='居民身份证'){
				var flag = isIdCardNo(val);
				return (flag);
			}
		}
		return true;
	},sfzhaoText:'请输入正确的证件号码',
	pzzch : function(val, field) {// val指这里的文本框值，field指这个文本框组件，大家要明白这个意思
		try{  
			var len = val.length;
			if(len<=15&&len>0){
				return true;
			}
			return false;
	    }catch(e){  
			return false;  
		}
	},pzzchText:'有效长度为15个字',
	pwd : function(val, field) {// val指这里的文本框值，field指这个文本框组件，大家要明白这个意思
		if (field.confirmTo) {// confirmTo是我们自定义的配置参数，一般用来保存另外的组件的id值
			var pnew1 = Ext.get(field.confirmTo);// 取得confirmTo的那个id的值
			
			if(pnew1.getValue()==val){
				return true;
			}
		}
		return false;
	},pwdText:'请输入相同的密码'
});

Ext.onReady(function() {
	setTimeout(function() {
		Ext.get('loading').remove();
		Ext.getDom('header').style.visibility = 'visible';
		var vp = new Ext.Viewport({
			layout : 'border',
			defaults : {
				collapsible : true,
				split : true
			},
			items : [{
				xtype : 'box',
				region : 'north',
				applyTo : 'header',
				height : 61,
				split : false
			}, {
				title : currentUserMsg,
				id : 'accordion-panel',
				layout : 'border',
				region : 'west',
				margins : '2 0 5 5',
				width : 150,
				minSize : 100,
				maxSize : 300,
				bodyStyle : 'background-color:#DFE8F6',
				autoScroll : true,
				defaults : {
					border : false
				},
				bbar : [{
							text : '退出系统',
							iconCls : 'icon-delete',
							handler : function() {
								Ext.Msg.confirm('操作提示', '您确定要退出本系统?', function(btn) {
									if ('yes' == btn) {
										Ext.Ajax.request({
											url : 'logout.action',
											success : function() {
												location = '/zz/index.jsp';
											},
											failure : function() {
												Ext.Msg.show({
													title : '错误提示',
													msg : '退出系统失败!',
													icon : Ext.Msg.ERROR,
													buttons : Ext.Msg.OK
												});
											}
										});
									}
								});
							}
					/*
					text : '开始',
					iconCls : 'icon-plugin',
					menu : new Ext.menu.Menu({
						items : [{
							text : '关于系统',
							iconCls : 'icon-info',
							handler : function() {
								new Ext.Window({
									closeAction : 'close',
									resizable : false,
									bodyStyle : 'padding: 7',
									modal : true,
									title : '关于本系统',
									html : '本系统采用目前较为流行的技术实现,<br>前台使用了ExtJs技术,所以实现了跨浏览器<br>' +
											'本程序在IE6,IE7,FireFox3均测试通过!<br><br>主要技术: Struts2 + Spring2.5 + iBatis2.3 + ExtJs2.2<br><br>'
											+ '数&nbsp;&nbsp;据&nbsp;&nbsp;库: Microsoft SQL Server 2000',
									width : 300,
									height : 200
								}).show();
							}
						}, {
							text : '退出系统',
							iconCls : 'icon-delete',
							handler : function() {
								Ext.Msg.confirm('操作提示', '您确定要退出本系统?', function(btn) {
									if ('yes' == btn) {
										Ext.Ajax.request({
											url : 'logout.action',
											success : function() {
												location = '/zz/index.jsp';
											},
											failure : function() {
												Ext.Msg.show({
													title : '错误提示',
													msg : '退出系统失败!',
													icon : Ext.Msg.ERROR,
													buttons : Ext.Msg.OK
												});
											}
										});
									}
								});
							}
						}]
					})
				*/}],
				items : [{
					layout : 'accordion',
					region : 'center',
					items : [{
						title : '导航菜单',
						iconCls : 'icon-nav',
						border : false,
						items : [{
							xtype : 'treepanel',
							border : false,
							rootVisible : false,
							autoScroll : true,
							loader : new Ext.tree.TreeLoader({
								dataUrl : goUrl(nav)
							}),
							root : new Ext.tree.AsyncTreeNode(),
							listeners : {
								'click' : function(n) {
									try {
										var sn = this.selModel.selNode || {};
										//单击展开闭合操作方法开始
										if(!n.leaf){
											if(n.expanded==false){
												n.expand() ;
											}else{
												n.collapse() ;
											}
										}//单击展开闭合操作方法结束
										if (n.leaf && n.id != sn.id) {
											
											/*alert(n.id.substring(0, n.id
													.indexOf('-'))
													+ '-panel');
													*/
											Ext.getCmp('content-panel').layout.setActiveItem(n.id.substring(0, n.id
													.indexOf('-'))
													+ '-panel');
											//根据树形菜单执行不同的相应
											var treeNodValue=n.id.substring(0, n.id.indexOf('-'));
											
										    switch (treeNodValue) {
											   case 'useLicenseAudit' :
												   //alert(treeNodValue);
												   searchOrgnewAudit();
												   break;
											   case 'useJgBerthSet' :   
												   searchJgBerth();
												   break;
											   case 'useJgBerthYw' :
											   	   searchJgBerthYw();
											       break;
											   case 'useLicenseInfoModify' :
												   //alert(treeNodValue);
												   //searchOrgnewInfoModify();
												   break;
											   case 'useLicenseReplace' :
												   //alert(treeNodValue);
												   //searchOrgnewReplace();
												   break;
											   case 'useLicenseAgain' :
												   //alert(treeNodValue);
												   //searchOrgnewAgain();
												   break;
											   case 'useLicenseMoveto' :
												   //alert(treeNodValue);
												   //searchOrgnewMoveto();
												   break;
											   case 'useLicenseMoveout' :
												   //alert(treeNodValue);
												   //searchOrgnewMoveout();
												   break;
											   case 'useLicenseOff' :
												  // alert(treeNodValue);
												   //searchOrgnewOff();
												   break;
											   case 'useInfoSet' :
											       //alert(treeNodValue);
												   searchUserInfo();
												   break;
										   }
										    
										}
									} catch (e) {
									}
								}
							}
						}]
					}]  
				}]
			}, {
				id : 'content-panel',
				region : 'center',
				layout : 'card',
				margins : '2 5 5 0',
				activeItem : 0,
				border : false,
				items : [start,p_useLicenseNew,p_useCardWizard,p_useLicenseAudit/*,p_usePwdSet,p_useInfoSet,p_jgBerthSet,p_JgBerthYw*/]  //参数配置
			}]
		});
	}, 250);
});

function goUrl(tipValue)
{
   var tipValue;
   if(typeof tipValue!=''){
	   switch (tipValue) {
	   case 'simple' :
		   return String.format('/zz/js/tree-data-simple.json');
		    break;
	   case 'new' :
		   return String.format('/zz/js/tree-data-new.json');
		    break;
	   default :
		   return String.format('/zz/js/tree-data-simple.json');
	   } 
	}
}

//打印申请单 页边距设置
var HKEY_Root,HKEY_Path,HKEY_Key;
HKEY_Root="HKEY_CURRENT_USER";
HKEY_Path="\\Software\\Microsoft\\Internet Explorer\\PageSetup\\";

function pagesetup_null(){
	try{
		var RegWsh = new ActiveXObject("WScript.Shell")
		HKEY_Key="header" 
		RegWsh.RegWrite(HKEY_Root+HKEY_Path+HKEY_Key,"")
		HKEY_Key="footer"
		RegWsh.RegWrite(HKEY_Root+HKEY_Path+HKEY_Key,"")
		HKEY_Key="margin_bottom";   
		RegWsh.RegWrite(HKEY_Root+HKEY_Path+HKEY_Key,"0.16929");  //设置下页边距（10为  0.39370，，4.3为0.16929） 
   		HKEY_Key="margin_left";   
  	 	RegWsh.RegWrite(HKEY_Root+HKEY_Path+HKEY_Key,"0.16929");  //设置左页边距（10）   
  	 	HKEY_Key="margin_right";   
   		RegWsh.RegWrite(HKEY_Root+HKEY_Path+HKEY_Key,"0.16929");  //设置右页边距（10）   
   		HKEY_Key="margin_top";   
   		RegWsh.RegWrite(HKEY_Root+HKEY_Path+HKEY_Key,"0.16929");  //设置上页边距（108）   
		//window.print()
	}catch(e){}
}