var shenBanSearch = function(){
	orgnewEditForm.getForm().reader = Orgnews;
	Ext.Ajax.request({  
		url: 'findAllJgBerth.action',
		method: 'POST',  
		params : {
			conditions:text_search_editForm.getValue(),
			userid:currentUserid,
			limit:50,
			start:0
		},
		success:function(result,request){
			eval("var data= "+result.responseText);
			if(data.root!=null&&data.root!=''){
				Ext.Ajax.request({  
					url: 'findConditionsOrgnew.action',
					method: 'POST',  
					params : {
						conditions: text_search_editForm.getValue(),
						userid: currentUserid
					},
					success:function(result,request){
						eval("var d= "+result.responseText);
						if(d.root!=null&&d.root!=''){
							orgnewEditForm.getForm().load({
							    url: 'findConditionsOrgnew.action', //请求控制器获取数据
							    method: 'POST', //为"POST",则上面的url不会显示在浏览器的地址栏中
							    params : {
									conditions: text_search_editForm.getValue(),
									userid: currentUserid
								},
							    waitTitle: '提示',
							    waitMsg: '数据正在加载中，请稍后',
							    success:function(form,action) {//获取返回值
							    	
				   					if(action.result.data.state=='2'||action.result.data.state=='3'||action.result.data.state=='5'||action.result.data.state=='6'){
				   						Ext.Msg.show({
											title : '提示',
											msg : '业务正在受理中！',
											buttons : Ext.Msg.OK,
											fn: function(){
												orgnewEditForm.getForm().reset();
											},
											icon : Ext.Msg.INFO
										});
				   					}else{
				   						var name = orgnewEditForm.getForm().findField("jjlx").getValue();
					   					var code = orgnewEditForm.getForm().findField("jjlxdm").getValue();
					   					if(name != ""){
					   						orgnewEditForm.getForm().findField("s_jjlx").setValue(name+" "+code);
					   					}else{
					   						orgnewEditForm.getForm().findField("s_jjlx").setValue(code);
					   					}
					   					
					   					name = orgnewEditForm.getForm().findField("wftzgb").getValue();
					   					code = orgnewEditForm.getForm().findField("wftzgbdm").getValue();
					   					if(name != ""){
					   						orgnewEditForm.getForm().findField("wftzgb_uln").setValue(name+" "+code);
					   					}else{
					   						orgnewEditForm.getForm().findField("wftzgb_uln").setValue(code);
					   					}
					   					
					   					name = orgnewEditForm.getForm().findField("hbzl").getValue();
					   					code = orgnewEditForm.getForm().findField("hbzldm").getValue();
					   					if(name != ""){
					   						orgnewEditForm.getForm().findField("hbzl_uln").setValue(name+" "+code);
					   					}else{
					   						orgnewEditForm.getForm().findField("hbzl_uln").setValue(code);
					   					}
					   					
					   					name = orgnewEditForm.getForm().findField("zgmc").getValue();
					   					code = orgnewEditForm.getForm().findField("zgdm").getValue();
					   					if(name != ""){
					   						orgnewEditForm.getForm().findField("select_zg").setValue(name+" "+code);
					   					}else{
					   						orgnewEditForm.getForm().findField("select_zg").setValue(code);
					   					}
					   					
					   					name = orgnewEditForm.getForm().findField("pzjgmc").getValue();
					   					code = orgnewEditForm.getForm().findField("pzjgdm").getValue();
					   					if(name != ""){
					   						orgnewEditForm.getForm().findField("select_pzjg").setValue(name+" "+code);
					   					}else{
					   						orgnewEditForm.getForm().findField("select_pzjg").setValue(code);
					   					}
					   					
					   					name = orgnewEditForm.getForm().findField("xzqhName").getValue();
					   					code = orgnewEditForm.getForm().findField("xzqhCode").getValue();
					   					if(name != ""){
					   						orgnewEditForm.getForm().findField("xzqh_uln").setValue(name+" "+code);
					   					}else{
					   						orgnewEditForm.getForm().findField("xzqh_uln").setValue(code);
					   					}
					   					
					   					name = orgnewEditForm.getForm().findField("xzqhName2").getValue();
					   					code = orgnewEditForm.getForm().findField("xzqhCode2").getValue();
					   					if(name != ""){
					   						orgnewEditForm.getForm().findField("xzqh_uln2").setValue(name+" "+code);
										}else{
											orgnewEditForm.getForm().findField("xzqh_uln2").setValue(code);
										}
										
										name = orgnewEditForm.getForm().findField("select_jglx").getValue();
					   					code = orgnewEditForm.getForm().findField("select_jglxdm").getValue();
					   					if(name != ""){
					   						orgnewEditForm.getForm().findField("select_jg").setValue(name+" "+code);
										}else{
											orgnewEditForm.getForm().findField("select_jg").setValue(code);
										}
										
										name = orgnewEditForm.getForm().findField("select_jjhymc").getValue();
					   					code = orgnewEditForm.getForm().findField("select_jjhydm").getValue();
					   					if(name != ""){
					   						orgnewEditForm.getForm().findField("select_jjhy").setValue(name+" "+code);
										}else{
											orgnewEditForm.getForm().findField("select_jjhy").setValue(code);
										}
										
										name = orgnewEditForm.getForm().findField("username").getValue();
										if(name == ""||name == null){
											orgnewEditForm.getForm().findField("username").setValue(currentUsername);
										}
										orgnewEditForm.getForm().findField("bzjgdm").setValue(currentBzjgdm);
				   					}
								}
											
							});
						}else{
							orgnewEditForm.getForm().reset();
							if(data.root[0].jgdm){
			    				orgnewEditForm.getForm().findField("jgdm").setValue(data.root[0].jgdm);
			    			}
			    			orgnewEditForm.getForm().findField("jgmc").setValue(data.root[0].jgmc);
			    			orgnewEditForm.getForm().findField("jgdz").setValue(data.root[0].jgdz);
			    			orgnewEditForm.getForm().findField("pzjgdm").setValue(data.root[0].pzjgdm);
			    			orgnewEditForm.getForm().findField("pzjgmc").setValue(data.root[0].pzjgmc);
			    			orgnewEditForm.getForm().findField("bzjgdm").setValue(currentBzjgdm);
			    			orgnewEditForm.getForm().findField("select_pzjg").setValue(data.root[0].pzjgmc+" "+data.root[0].pzjgdm);
		   					
			    			orgnewEditForm.getForm().findField("zch").setValue(data.root[0].zch);
			    			orgnewEditForm.getForm().findField("email").setValue(data.root[0].email);
			    			orgnewEditForm.getForm().findField("dhhm").setValue(data.root[0].dhhm);
						}
					}
				});
			}else{
				Ext.Msg.show({
					title : '提示',
					msg : '查询机构不再挂靠机构序列中，请完成挂靠后再试！',
					buttons : Ext.Msg.OK,
					icon : Ext.Msg.ERROR
				});
			}
		}
	});
}

var text_search_editForm = new Ext.form.TextField({
	id:'textsearcheditForm',
	name : 'textsearcheditForm',
	width : 200,
	emptyText : '查询挂靠机构名称、代码、注册号',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				shenBanSearch();
			}
		}
	}
});
var btn_search_editForm = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		shenBanSearch();
	}
});
var editForm = {
		title: '请录入企业登记注册信息',
	    layout: 'fit',
	    id: 'CardWizard2',
	    bodyStyle: 'padding:0px;',
 		plain: true,
	    border:true,
		autoScroll : true,
		//tbar:['->',text_search_editForm,btn_search_editForm],
	    items: [orgnewEditForm]
};

function GetXmlHttp2()
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




var shangchuanForm = {
		title: '请扫描注册审批资料，并上传',
	    layout: 'fit',
	    frame: true,
	    id: 'CardWizard33',
	    margins: '0 0 0 0',
	    border:false,
	    items: [shangchuanOrgnewForm],
		buttons: [{ 
		   id:'up_button2',
		   name:'up_button2',
		   text: '上传',   
	       handler: function(btn) {
	       	
	       	if(orgnewEditForm.getForm().findField('orgid')!=null){
	       		
	       	
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
					var record = grid_LicenseNew2.getSelectionModel().getSelected();
				    //Ext.MessageBox.alert("提示","您选择的出版号是："+record2.data.fddbr); 
					btn.disable();
					
					strOrgid = record.data.orgid;  //参数orgid
					strDocid = record.data.docid;  //参数docid
					//alert(record.data.imageData);
					var strBzjgdm = orgnewEditForm.getForm().findField('bzjgdm').getValue();
					
					packLength = 40960;	//定义每个包的大小40960
					//scanner7005.ImageData=record.data.imageData;
					base64file = scanner2.ImageData;  //获取控件扫描的图片数据
					var baseSize = base64file.length;  //获取控件图片数据的64位编码的长度
					imageCount = scanner2.GetPageCount;	//获取扫描图片的页数
					pageTypeStr = scanner2.PageType;    //获取标识字符串,需要写数据库
					
					if(pageTypeStr!=""){
						pageTypeStr=pageTypeStr.replace(/\%/g, "|"); 
	       			}
					
					packCount = Math.ceil(base64file.length / packLength);	//判断需要发送数据包的个数
					//alert(packCount);
					if(imageCount==0 || base64file=="")   //判断如果没有扫描数据，结束处理
					{
						alert("请扫描或导入图片后，再上传！");
						btn.enable();
						return false;
					}
					var size = scanner2.GetFileSize;
					var ic = scanner2.ImageCount;
					if(size>(ic*250*1024)){
						alert("图像过大无法上传，请保存本地压缩后重试！");
						return;
					}
					
					if (pageTypeStr.indexOf('未标识')!=-1){ //判断如果没有标识，则不允许上传
						alert("请进行电子原文标识后，再保存！");
						btn.enable();
						return false;
					}
					scanner2.OpenProgress(packCount);  //设置上传的进度条的总进度数
					xmlhttp = GetXmlHttp2(); //通过AJAX格式上传
					for(i=0; i < packCount; i++)  //分包上传
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
							xmlhttp.open("post", "saveImageOrgnew.action?orgid="+strOrgid+"&bzjgdm="+strBzjgdm+"&docid="+strDocid+"&packindex="+i+"&pageTypeStr="+pageTypeStr+"&lastpack="+lastpack, false);
							xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   //这句必须要，而且一定要放在send以前
							xmlhttp.send("imageData=" + encodeURIComponent(pack)); 
	                        //alert(xmlhttp.responseText);
							var objs = eval("["+xmlhttp.responseText+"]");
							if(objs[0].success)
							{
								scanner2.Progress('上传中',i+1);
							}
							else
							{
								alert("上传失败，请重试0001。");
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
					//alert("上传成功！");
					Ext.Msg.show({
						title : '提示',
						msg : '证明文件扫描上传成功!',
						icon : Ext.Msg.INFO,
						buttons : Ext.Msg.OK,
						fn:function(){
							var tab1=Ext.getCmp("centerPanel");
							tab1.setActiveTab("tijiaoTab");
						}
					});
					btn.enable();
					return true;
		       }else{
		       		alert("请先进行信息录入");
		       }
	       		
	       	}   
	   }]
};


var submitForm = {
	title: '信息提交',
    layout: 'fit',
    frame: true,
    id: 'CardWizard41',
    border:false,
    items: [grid_LicenseNew]   
};	


	
var printForm = {
	title: '打印申请单',
    layout: 'fit',
    frame: true,
    id: 'CardWizard4',
    border:false,
    items: [grid_LicenseNew2]   
};	


function reLsayout() {
    //useCardWizard-panel.doLayout(false, true);
    alert('ssss');
}
 
function changeState(stateValue) {
	 switch (stateValue) {
	   case '1' :
		   var strHtml='<table border="0" cellpadding="5" cellspacing="5"><tr><td><table><tr align="center">'
			+'<td>当前状态为</td>'
			+'<td id=imgFlag1><img src="images/jc_on.gif" /><br>录入</td>'
			+'<td id=imgFlag2><img src="images/jc_off.gif" /><br>打印<td>'
			+'<td id=imgFlag3><img src="images/jc_off.gif" /><br>上传<td>'
			+'<td id=imgFlag4><img src="images/jc_off.gif" /><br>提交<td>'
			+'<td id=imgFlag5><img src="images/jc_off.gif" /><br>完成<td>'
			+'</table></td></tr></table>'
		    break;
	   case '2' :
		  var strHtml='<table border="0" cellpadding="5" cellspacing="5"><tr><td><table><tr align="center">'
			+'<td>当前状态为</td>'
			+'<td id=imgFlag1><img src="images/jc_on.gif" /><br>录入</td>'
			+'<td id=imgFlag2><img src="images/jc_on.gif" /><br>打印<td>'
			+'<td id=imgFlag3><img src="images/jc_off.gif" /><br>上传<td>'
			+'<td id=imgFlag4><img src="images/jc_off.gif" /><br>提交<td>'
			+'<td id=imgFlag5><img src="images/jc_off.gif" /><br>完成<td>'
			+'</table></td></tr></table>'
		    break;
	   case '3' :
	   		var strHtml='<table border="0" cellpadding="5" cellspacing="5"><tr><td><table><tr align="center">'
			+'<td>当前状态为</td>'
			+'<td id=imgFlag1><img src="images/jc_on.gif" /><br>录入</td>'
			+'<td id=imgFlag2><img src="images/jc_on.gif" /><br>打印<td>'
			+'<td id=imgFlag3><img src="images/jc_on.gif" /><br>上传<td>'
			+'<td id=imgFlag4><img src="images/jc_off.gif" /><br>提交<td>'
			+'<td id=imgFlag5><img src="images/jc_off.gif" /><br>完成<td>'
			+'</table></td></tr></table>'
			break;
		case '4' :
	   		var strHtml='<table border="0" cellpadding="5" cellspacing="5"><tr><td><table><tr align="center">'
			+'<td>当前状态为</td>'
			+'<td id=imgFlag1><img src="images/jc_on.gif" /><br>录入</td>'
			+'<td id=imgFlag2><img src="images/jc_on.gif" /><br>打印<td>'
			+'<td id=imgFlag3><img src="images/jc_on.gif" /><br>上传<td>'
			+'<td id=imgFlag4><img src="images/jc_on.gif" /><br>提交<td>'
			+'<td id=imgFlag5><img src="images/jc_off.gif" /><br>完成<td>'
			+'</table></td></tr></table>'
			break;
		case '5' :
	   		var strHtml='<table border="0" cellpadding="5" cellspacing="5"><tr><td><table><tr align="center">'
			+'<td>当前状态为</td>'
			+'<td id=imgFlag1><img src="images/jc_on.gif" /><br>录入</td>'
			+'<td id=imgFlag2><img src="images/jc_on.gif" /><br>打印<td>'
			+'<td id=imgFlag3><img src="images/jc_on.gif" /><br>上传<td>'
			+'<td id=imgFlag4><img src="images/jc_on.gif" /><br>提交<td>'
			+'<td id=imgFlag5><img src="images/jc_on.gif" /><br>完成<td>'
			+'</table></td></tr></table>'
			break;
	    default :
		   return String.format('<font color="red"><b>状态错误。。。</b></font>');
	   } 
		Ext.getCmp("listState").getEl().dom.innerHTML=strHtml;
}


var p_useCardWizard = {
	id: 'useCardWizard-panel',
	iconCls : 'icon-plugin',
	layout : 'anchor',
	title: '网上申请',
	bodyStyle: 'padding:5px;',
	activeTab: 0,
	items:[{
		id:'listState',
        height: 35,
		anchor: '100%',
		border:false,
		html: '<table border="0" cellpadding="5" cellspacing="5"><tr><td><table><tr align="center">'
			+'<td>当前状态为</td>'
			+'<td id=imgFlag1><img src="images/jc_off.gif" /><br>录入</td>'
			+'<td id=imgFlag2><img src="images/jc_off.gif" /><br>打印<td>'
			+'<td id=imgFlag3><img src="images/jc_off.gif" /><br>上传<td>'
			+'<td id=imgFlag4><img src="images/jc_off.gif" /><br>提交<td>'
			+'<td id=imgFlag5><img src="images/jc_off.gif" /><br>完成<td>'
			+'</table></td></tr></table>'
    },{
		anchor: '-0, -35',
		border:false,
		layout: 'fit',
		items: [{ 
		xtype: 'tabpanel',
		plain: true,
		region: 'center',
		margins: '5 5 5 5',
		activeTab: 0,
		layoutOnTabChange:true,
		autoDestroy: true,
		
		id: 'centerPanel',
		name:'centerPanel',
		items: [{
			title: '申办提示',
			layout: 'fit',
			layoutOnTabChange:true,
			bodyStyle: 'padding:10px;',
			html: '1、请录入机构基本信息、上传证书新办申请资料，并提交'
				+'<br>2、当前证书办理状态为'
		},{
			title: '第一步、信息录入',
			layout: 'fit',
			id:'editTab',
			layoutOnTabChange:true,
			bodyStyle: 'padding:5px;',iconCls : 'icon-plugin',
 			plain: true,
	        items : [editForm],
	        listeners : {
				'activate' : function() { //标签激活后自动加载数据
					changeState("1");
					orgnewEditForm.getForm().reader = Orgnews;
					if(currentJgdm!=''){
						orgnewEditForm.getForm().load({
						    //url: 'findUsernameOrgnew.action?username='+currentUsername, //请求控制器获取数据
						    url: 'findConditionsOrgnew.action',
						    method: 'POST', //为"POST",则上面的url不会显示在浏览器的地址栏中
						    params:{
						    	//userid: currentUserid,
						    	jgdm: currentJgdm
						    },
						    waitTitle: '提示',
						    waitMsg: '数据正在加载中，请稍后',
						    success:function(form,action) {//获取返回值
						    	
						    	if(action.result.data.state=='2'||action.result.data.state=='3'||action.result.data.state=='5'||action.result.data.state=='6'){
						    		Ext.Msg.show({
										title : '提示',
										msg : '业务正在受理中！',
										buttons : Ext.Msg.OK,
										fn: function(){
											orgnewEditForm.getForm().reset();
										},
										icon : Ext.Msg.INFO
									});
						    	}else{
						    		//text_search_editForm.setValue('');
				   					
				   					var name = orgnewEditForm.getForm().findField("jjlx").getValue();
				   					var code = orgnewEditForm.getForm().findField("jjlxdm").getValue();
				   					if(name != ""){
				   						orgnewEditForm.getForm().findField("s_jjlx").setValue(name+" "+code);
				   					}else{
				   						orgnewEditForm.getForm().findField("s_jjlx").setValue(code);
				   					}
				   					
				   					name = orgnewEditForm.getForm().findField("wftzgb").getValue();
				   					code = orgnewEditForm.getForm().findField("wftzgbdm").getValue();
				   					if(name != ""){
				   						orgnewEditForm.getForm().findField("wftzgb_uln").setValue(name+" "+code);
				   					}else{
				   						orgnewEditForm.getForm().findField("wftzgb_uln").setValue(code);
				   					}
				   					
				   					name = orgnewEditForm.getForm().findField("hbzl").getValue();
				   					code = orgnewEditForm.getForm().findField("hbzldm").getValue();
				   					if(name != ""){
				   						orgnewEditForm.getForm().findField("hbzl_uln").setValue(name+" "+code);
				   					}else{
				   						orgnewEditForm.getForm().findField("hbzl_uln").setValue(code);
				   					}
				   					
				   					name = orgnewEditForm.getForm().findField("zgmc").getValue();
				   					code = orgnewEditForm.getForm().findField("zgdm").getValue();
				   					if(name != ""){
				   						orgnewEditForm.getForm().findField("select_zg").setValue(name+" "+code);
				   					}else{
				   						orgnewEditForm.getForm().findField("select_zg").setValue(code);
				   					}
				   					
				   					name = orgnewEditForm.getForm().findField("pzjgmc").getValue();
				   					code = orgnewEditForm.getForm().findField("pzjgdm").getValue();
				   					if(name != ""){
				   						orgnewEditForm.getForm().findField("select_pzjg").setValue(name+" "+code);
				   					}else{
				   						orgnewEditForm.getForm().findField("select_pzjg").setValue(code);
				   					}
				   					
				   					name = orgnewEditForm.getForm().findField("xzqhName").getValue();
				   					code = orgnewEditForm.getForm().findField("xzqhCode").getValue();
				   					if(name != ""){
				   						orgnewEditForm.getForm().findField("xzqh_uln").setValue(name+" "+code);
				   					}else{
				   						orgnewEditForm.getForm().findField("xzqh_uln").setValue(code);
				   					}
				   					
				   					name = orgnewEditForm.getForm().findField("xzqhName2").getValue();
				   					code = orgnewEditForm.getForm().findField("xzqhCode2").getValue();
				   					if(name != ""){
				   						orgnewEditForm.getForm().findField("xzqh_uln2").setValue(name+" "+code);
									}else{
										orgnewEditForm.getForm().findField("xzqh_uln2").setValue(code);
									}
									
									name = orgnewEditForm.getForm().findField("select_jglx").getValue();
				   					code = orgnewEditForm.getForm().findField("select_jglxdm").getValue();
				   					if(name != ""){
				   						orgnewEditForm.getForm().findField("select_jg").setValue(name+" "+code);
									}else{
										orgnewEditForm.getForm().findField("select_jg").setValue(code);
									}
									
									name = orgnewEditForm.getForm().findField("select_jjhymc").getValue();
				   					code = orgnewEditForm.getForm().findField("select_jjhydm").getValue();
				   					if(name != ""){
				   						orgnewEditForm.getForm().findField("select_jjhy").setValue(name+" "+code);
									}else{
										orgnewEditForm.getForm().findField("select_jjhy").setValue(code);
									}
									
									orgnewEditForm.getForm().findField("bzjgdm").setValue(currentBzjgdm);
									
									name = orgnewEditForm.getForm().findField("username").getValue();
									if(name == ""||name == null){
										orgnewEditForm.getForm().findField("username").setValue(currentJgdm);
									}
						    	}
							},
							failure : function(form,action) {
									
								orgnewEditForm.getForm().reader = Orgnews;
								orgnewEditForm.getForm().load({
								    url: 'findConditionsTjgdm.action',
								    method: 'POST', //为"POST",则上面的url不会显示在浏览器的地址栏中
								    params:{
								    	//userid: currentUserid,
								    	jgdm: currentJgdm
								    },
								    waitTitle: '提示',
								    waitMsg: '数据正在加载中，请稍后',
								    success:function(form,action) {//获取返回值
								    		orgnewEditForm.getForm().findField("orgid").setValue('');
						   					var name = orgnewEditForm.getForm().findField("jjlx").getValue();
						   					var code = orgnewEditForm.getForm().findField("jjlxdm").getValue();
						   					if(name != ""){
						   						orgnewEditForm.getForm().findField("s_jjlx").setValue(name+" "+code);
						   					}else{
						   						orgnewEditForm.getForm().findField("s_jjlx").setValue(code);
						   					}
						   					
						   					name = orgnewEditForm.getForm().findField("wftzgb").getValue();
						   					code = orgnewEditForm.getForm().findField("wftzgbdm").getValue();
						   					if(name != ""){
						   						orgnewEditForm.getForm().findField("wftzgb_uln").setValue(name+" "+code);
						   					}else{
						   						orgnewEditForm.getForm().findField("wftzgb_uln").setValue(code);
						   					}
						   					
						   					name = orgnewEditForm.getForm().findField("hbzl").getValue();
						   					code = orgnewEditForm.getForm().findField("hbzldm").getValue();
						   					if(name != ""){
						   						orgnewEditForm.getForm().findField("hbzl_uln").setValue(name+" "+code);
						   					}else{
						   						orgnewEditForm.getForm().findField("hbzl_uln").setValue(code);
						   					}
						   					
						   					name = orgnewEditForm.getForm().findField("zgmc").getValue();
						   					code = orgnewEditForm.getForm().findField("zgdm").getValue();
						   					if(name != ""){
						   						orgnewEditForm.getForm().findField("select_zg").setValue(name+" "+code);
						   					}else{
						   						orgnewEditForm.getForm().findField("select_zg").setValue(code);
						   					}
						   					
						   					name = orgnewEditForm.getForm().findField("pzjgmc").getValue();
						   					code = orgnewEditForm.getForm().findField("pzjgdm").getValue();
						   					if(name != ""){
						   						orgnewEditForm.getForm().findField("select_pzjg").setValue(name+" "+code);
						   					}else{
						   						orgnewEditForm.getForm().findField("select_pzjg").setValue(code);
						   					}
						   					
						   					name = orgnewEditForm.getForm().findField("xzqhName").getValue();
						   					code = orgnewEditForm.getForm().findField("xzqhCode").getValue();
						   					if(name != ""){
						   						orgnewEditForm.getForm().findField("xzqh_uln").setValue(name+" "+code);
						   					}else{
						   						orgnewEditForm.getForm().findField("xzqh_uln").setValue(code);
						   					}
						   					
						   					name = orgnewEditForm.getForm().findField("xzqhName2").getValue();
						   					code = orgnewEditForm.getForm().findField("xzqhCode2").getValue();
						   					if(name != ""){
						   						orgnewEditForm.getForm().findField("xzqh_uln2").setValue(name+" "+code);
											}else{
												orgnewEditForm.getForm().findField("xzqh_uln2").setValue(code);
											}
											
											name = orgnewEditForm.getForm().findField("select_jglx").getValue();
						   					code = orgnewEditForm.getForm().findField("select_jglxdm").getValue();
						   					if(name != ""){
						   						orgnewEditForm.getForm().findField("select_jg").setValue(name+" "+code);
											}else{
												orgnewEditForm.getForm().findField("select_jg").setValue(code);
											}
											
											name = orgnewEditForm.getForm().findField("select_jjhymc").getValue();
						   					code = orgnewEditForm.getForm().findField("select_jjhydm").getValue();
						   					if(name != ""){
						   						orgnewEditForm.getForm().findField("select_jjhy").setValue(name+" "+code);
											}else{
												orgnewEditForm.getForm().findField("select_jjhy").setValue(code);
											}
											
											orgnewEditForm.getForm().findField("bzjgdm").setValue(currentBzjgdm);
											
											name = orgnewEditForm.getForm().findField("username").getValue();
											if(name == ""||name == null){
												orgnewEditForm.getForm().findField("username").setValue(currentJgdm);
											}
								    	
									},
									failure : function(form,action) {
										alert("未查询到机构信息！");
										window.open("index.jsp","_self","",false);
									}
								});
							}
						});
					}else{
						//var orgid = orgnewEditForm.getForm().findField('orgid').getValue();
					
							orgnewEditForm.getForm().load({
								url:'findUsernameOrgnew.action',
								method: 'post',
								params:{
									username:currentUser
								},
								waitTitle:'提示',
								waitMsg:'数据正在加载中，请稍后',
								success:function(form,action){//获取返回值
							    	
							    	if(action.result.data.state=='2'||action.result.data.state=='3'||action.result.data.state=='5'||action.result.data.state=='6'){
							    		Ext.Msg.show({
											title : '提示',
											msg : '业务正在受理中！',
											buttons : Ext.Msg.OK,
											fn: function(){
												orgnewEditForm.getForm().reset();
											},
											icon : Ext.Msg.INFO
										});
							    	}else{
							    		//text_search_editForm.setValue('');
					   					
					   					var name = orgnewEditForm.getForm().findField("jjlx").getValue();
					   					var code = orgnewEditForm.getForm().findField("jjlxdm").getValue();
					   					if(name != ""){
					   						orgnewEditForm.getForm().findField("s_jjlx").setValue(name+" "+code);
					   					}else{
					   						orgnewEditForm.getForm().findField("s_jjlx").setValue(code);
					   					}
					   					
					   					name = orgnewEditForm.getForm().findField("wftzgb").getValue();
					   					code = orgnewEditForm.getForm().findField("wftzgbdm").getValue();
					   					if(name != ""){
					   						orgnewEditForm.getForm().findField("wftzgb_uln").setValue(name+" "+code);
					   					}else{
					   						orgnewEditForm.getForm().findField("wftzgb_uln").setValue(code);
					   					}
					   					
					   					name = orgnewEditForm.getForm().findField("hbzl").getValue();
					   					code = orgnewEditForm.getForm().findField("hbzldm").getValue();
					   					if(name != ""){
					   						orgnewEditForm.getForm().findField("hbzl_uln").setValue(name+" "+code);
					   					}else{
					   						orgnewEditForm.getForm().findField("hbzl_uln").setValue(code);
					   					}
					   					
					   					name = orgnewEditForm.getForm().findField("zgmc").getValue();
					   					code = orgnewEditForm.getForm().findField("zgdm").getValue();
					   					if(name != ""){
					   						orgnewEditForm.getForm().findField("select_zg").setValue(name+" "+code);
					   					}else{
					   						orgnewEditForm.getForm().findField("select_zg").setValue(code);
					   					}
					   					
					   					name = orgnewEditForm.getForm().findField("pzjgmc").getValue();
					   					code = orgnewEditForm.getForm().findField("pzjgdm").getValue();
					   					if(name != ""){
					   						orgnewEditForm.getForm().findField("select_pzjg").setValue(name+" "+code);
					   					}else{
					   						orgnewEditForm.getForm().findField("select_pzjg").setValue(code);
					   					}
					   					
					   					name = orgnewEditForm.getForm().findField("xzqhName").getValue();
					   					code = orgnewEditForm.getForm().findField("xzqhCode").getValue();
					   					if(name != ""){
					   						orgnewEditForm.getForm().findField("xzqh_uln").setValue(name+" "+code);
					   					}else{
					   						orgnewEditForm.getForm().findField("xzqh_uln").setValue(code);
					   					}
					   					
					   					name = orgnewEditForm.getForm().findField("xzqhName2").getValue();
					   					code = orgnewEditForm.getForm().findField("xzqhCode2").getValue();
					   					if(name != ""){
					   						orgnewEditForm.getForm().findField("xzqh_uln2").setValue(name+" "+code);
										}else{
											orgnewEditForm.getForm().findField("xzqh_uln2").setValue(code);
										}
										
										name = orgnewEditForm.getForm().findField("select_jglx").getValue();
					   					code = orgnewEditForm.getForm().findField("select_jglxdm").getValue();
					   					if(name != ""){
					   						orgnewEditForm.getForm().findField("select_jg").setValue(name+" "+code);
										}else{
											orgnewEditForm.getForm().findField("select_jg").setValue(code);
										}
										
										name = orgnewEditForm.getForm().findField("select_jjhymc").getValue();
					   					code = orgnewEditForm.getForm().findField("select_jjhydm").getValue();
					   					if(name != ""){
					   						orgnewEditForm.getForm().findField("select_jjhy").setValue(name+" "+code);
										}else{
											orgnewEditForm.getForm().findField("select_jjhy").setValue(code);
										}
										
										orgnewEditForm.getForm().findField("bzjgdm").setValue(currentBzjgdm);
										orgnewEditForm.getForm().findField("xgr").setValue(currentUser);
										orgnewEditForm.getForm().findField("lry").setValue(currentUser);
										
							    	}
								},
								failure : function(form,action) {
									Ext.Ajax.request({
										url: 'findUserInfo.action',
										params : {username:currentUser},
										method:'POST', 
										waitTitle: '提示',
							    		waitMsg: '数据正在加载中，请稍后',
							    		success: function(result,request){
							    			eval("var data="+result.responseText);
							    			orgnewEditForm.getForm().reset();
							    			text_search_editForm.setValue('');
							    			if(data.root[0].orgCode){
							    				orgnewEditForm.getForm().findField("jgdm").setValue(data.root[0].orgCode);
							    			}
							    			orgnewEditForm.getForm().findField("jgmc").setValue(data.root[0].orgName);
							    			orgnewEditForm.getForm().findField("jgdz").setValue(data.root[0].address);
							    			orgnewEditForm.getForm().findField("pzjgdm").setValue(data.root[0].pzjgdm);
							    			orgnewEditForm.getForm().findField("pzjgmc").setValue(data.root[0].pzjgmc);
							    			orgnewEditForm.getForm().findField("bzjgdm").setValue(currentBzjgdm);
							    			orgnewEditForm.getForm().findField("select_pzjg").setValue(data.root[0].pzjgmc+" "+data.root[0].pzjgdm);
						   					orgnewEditForm.getForm().findField("username").setValue(data.root[0].userName);
							    			orgnewEditForm.getForm().findField("zch").setValue(data.root[0].orgZch);
							    			orgnewEditForm.getForm().findField("email").setValue(data.root[0].email);
							    			orgnewEditForm.getForm().findField("dhhm").setValue(data.root[0].tel);
							    			orgnewEditForm.getForm().findField("xgr").setValue(currentUser);
											orgnewEditForm.getForm().findField("lry").setValue(currentUser);
							    		}
									});
								}
							});
						
					}
					////////////////////////////
				}
			}
		    
		},{
			id:'printTab',
			title: '第二步、打印申请表',
			layout: 'fit',
		    bodyStyle: 'padding:5px;',
			layoutOnTabChange:true,
			items : [printForm],
			listeners : {
				'activate' : function() {  //标签激活后自动加载数据
					var jglx = orgnewEditForm.getForm().findField("jglx").getValue();
					if(jglx==null||jglx==''){
						alert("请先进行第一步保存数据操作！");
					}else{
						changeState("2");
						textSearchOrgnew2.value='';
						searchOrgnew2();
					}
				}
			}
		},{
			id:'shangchanTab',
			title: '第三步、扫描上传',
			layout: 'fit',
			layoutOnTabChange:true,
			bodyStyle: 'padding:5px;',
			items : [shangchuanForm],
			listeners : {
				'activate' : function() {  //标签激活后自动加载数据
					var record = grid_LicenseNew2.getSelectionModel().getSelected();;
					if(record==null){
						alert("请先执行第二步操作！");
					}else{
						changeState("3");
						var strOrgid= record.data.orgid;
						
		        		var resultObject = null;
	                    if(strOrgid==null && strOrgid==""){
	                    	alert("系统出现意外问题，请重新登录！");
	                    }else{
	                    	var strPageTypeNeed="";
	    					var resultObject821 = null;
	    					Ext.Ajax.request({  
	    						 url: 'findByCategoryid.action?categoryId=603',  
	    						 method:'POST',  
	    						 success:function(result,request){
	    							  resultObject821 = eval('('+result.responseText+')');
	    							  strPageTypeNeed=resultObject821.root[0].remark;
	    							  
	    							  //////////////////////////////////////////////////////////
						    							  
	    							  Ext.Ajax.request({  
			    						 url: 'findByJglxdm.action',
			    						 params : {jglxdm:orgnewEditForm.getForm().findField('select_jglxdm').getValue()},
			    						 method:'POST',  
			    						 success:function(result,request){
			    						 	
			    						 	eval("var pjglxmc="+result.responseText);
			    						 	//alert(pjglxmc);
			    						 	if(pjglxmc=="其他组织机构"){
			    							  	pjglxmc=pjglxmc.replace(/其他组织机构/,"其他机构");
			    							}
			    							strPageTypeNeed=strPageTypeNeed.replace(/批准成立文件/g, pjglxmc+"批准文件");
			    							//alert("标识：    "+strPageTypeNeed);
			    						 }
	    							  });
	    							  
	    							  ////////////////////////////////////////////////////
	    							  
	    							  Ext.Ajax.request({  
	 									 url: 'findOrgidOrgnew.action',
	 									 params : {orgid : strOrgid,stateConditions:'0,1'},
	 									 method:'POST',  
	 									 success:function(result,request){
	 										var resultObject8211 = Ext.util.JSON.decode(result.responseText);
	 					   					if(resultObject8211.root.length!=0){
	 					   						var strTbrsfzh=resultObject8211.root[0].tbrsfzh;
	 					   						var strZjhm=resultObject8211.root[0].zjhm;
	 					   						//alert(strTbrsfzh+"|"+strZjhm);
	 					   						if(strTbrsfzh==strZjhm){
	 					   							var strPageTypeNeed2=strPageTypeNeed.replace(/\经办人身份证件%/g, "%"); 
	 					   							scanner2.PageNeed=strPageTypeNeed2;
	 					   							//alert("===="+strPageTypeNeed2)
	 					   						}else{
	 					   							scanner2.PageNeed=strPageTypeNeed;
	 					   							//alert("<><><>"+strPageTypeNeed)
	 					   						}
	 					   					}
	 									 }
	 							  });
	    				    		  return;  
	    			    		 },  
	    						 failure:function(){  
	    							  Ext.Msg.alert('提示框','操作失败!');  
	    							  return;  
	    						 } 
	    					});
	    					/*Ext.Ajax.request({
								url : 'orgnewViewImg.action',
								params : {orgid : strOrgid},
								//waitTitle: '提示',
							    //waitMsg: '数据正在重新加载中，请稍后',
								success : function(result,request) {//获取返回值
									scanner2.ImageData="";
				   					var resultObject = Ext.util.JSON.decode(result.responseText); 
				   					if(resultObject!=null){
					   					scanner2.OpenProgress(3);  //设置上传的进度条的总进度数
					   					scanner2.Progress('原文加载中',1);
										scanner2.Progress('原文加载中',2);
					   					scanner2.ImageData=resultObject.imageData;
					   					scanner2.pageType=resultObject.pageTypeStr;
					   					if(scanner2.ImageData!=""){
					   						scanner2.Progress('原文加载完毕',3);
											scanner2.CloseProgress();
										}else{
											scanner2.Progress('原文加载失败',3);
							   				scanner2.CloseProgress();
							   				alert("原文错误，加载失败！");
										}
				   					}
								},
								failure : function() {
									scanner2.ImageData="";
						   			scanner2.CloseProgress();
									//alert("图像加载错误，或者无原文");
									//、shangchuanForm.up_button2.setDisa、
								}
							});*/
	                    }
					}
				}
			}
		},{
			id:'tijiaoTab',
			title: '第四步、提交申办信息',
			layout: 'fit',
		    bodyStyle: 'padding:5px;',
			layoutOnTabChange:true,
			items : [submitForm],
			listeners : {
				'activate' : function() {  //标签激活后自动加载数据
					var jglx = orgnewEditForm.getForm().findField("jglx").getValue();
					if(jglx==null||jglx==''){
						alert("请先进行第一步操作！");
					}else{
						changeState("4");
						textSearchOrgnew.value='';
						searchOrgnew();
						btn_return_orgnew.setDisabled(true);
					}
				}
			}
		
		}]
		}]
	}]
}


