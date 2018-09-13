
//-----------------------点击列表信息，显示图书的扩展属性-----------------------
var expander_zam = new Ext.grid.RowExpander({
	tpl : new Ext.Template('<table width="100%"  border="0" cellspacing="6" cellpadding="0"  bgcolor="#DDEEF9" style="margin-top:1px;" >'
			+ '<tr>'
			+ '<td width="" colspan="4">'
			+ '<table width="98%" bgcolor="#ffffff" border="1" cellpadding="0" cellspacing="0" align="center"  bordercolordark="#FFFFFF" bordercolorlight="#6EBBE1" style="margin-top:0px;>'
			+ '<tr height="22" valign="middle">'
			+ '  <td width="20%" height="22" align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">机构名称：</td><td width="30%"  valign="middle" style="padding-top:5px">{jgmc}<img src="images/temp.gif"></td>'
			+ '  <td width="20%" height="22" align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">机构代码：</td><td width="30%"  valign="middle" style="padding-top:5px">{jgdm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle" >'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">法定代表人：</td><td nowrap="nowrap" style="padding-top:5px">{fddbr}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">机构类型：</td><td  nowrap="nowrap" style="padding-top:5px">{jglx}<img src="images/temp.gif"></td>'
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
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">注册资金：</td><td nowrap="nowrap" style="padding-top:5px">{zczj}(万)<img src="images/temp.gif"></td>'
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
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经办人证件类型：</td><td nowrap="nowrap" style="padding-top:5px">{tbrzjlx}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经办人证件号码：</td><td nowrap="nowrap" style="padding-top:5px">{tbrsfzh}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经办人电话：</td><td nowrap="nowrap" style="padding-top:5px">{tbrlxfs}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经济行业：</td><td nowrap="nowrap" style="padding-top:5px">{jjhymc} {jjhydm}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">机构类型：</td><td nowrap="nowrap" style="padding-top:5px">{jglx}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">是否公开：</td><td nowrap="nowrap" colspan="3" style="padding-top:5px">{gk}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">审核人：</td><td nowrap="nowrap" style="padding-top:5px">{handleName}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">审核时间：</td><td nowrap="nowrap" style="padding-top:5px">{handleDate}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">审核意见：</td><td  colspan=3 style="padding-top:5px">{handleNote}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '</table>'
			+ '</td></tr></table>')
});



//--------------------图片浏览窗口-------------------------------------------
var imageView_window_archivesManage = new Ext.Window({   
    id: 'image-window_7010',   
    title : '原文预览',   
    width : 900,   
    height : 600,   
    resizable : true, 
    maximizable:true,
    closeAction :'hide',
    html: '<OBJECT classid="clsid:B4E2D33E-D8B2-4956-9F91-1C6BDC87A6D1"   width=100%  height=100% align=center hspace=0 vspace=0 id="scanner7010"  name="scanner7010" >'
	       +'<param name="ShowCount" value="8">'
	       +'<param name="sModel" value="1">'
	       +'</OBJECT>',
    buttons: [{ 
		   id:'up_button2',
		   name:'up_button2',
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
					var strBzjgdm;
					
					var record = grid_archivesManage.getSelectionModel().getSelected();
				    //Ext.MessageBox.alert("提示","您选择的出版号是："+record2.data.fddbr); 
					btn.disable();
					strOrgid = record.data.orgid;  //参数orgid
					strDocid =record.data.docid;  //参数docid
					strBzjgdm = record.data.bzjgdm;
					
					//alert(record.data.imageData);
					packLength = 40960;	//定义每个包的大小40960
					//scanner7010.ImageData=record.data.imageData;
					base64file = scanner7010.ImageData;  //获取控件扫描的图片数据
					var baseSize = base64file.length;  //获取控件图片数据的64位编码的长度
					imageCount = scanner7010.GetPageCount;	//获取扫描图片的页数
					pageTypeStr = scanner7010.PageType;    //获取标识字符串,需要写数据库
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
					if (pageTypeStr.indexOf('未标识')!=-1){ //判断如果没有标识，则不允许上传
						alert("请进行电子原文标识后，再保存！");
						btn.enable();
						return false;
					}
					scanner7010.OpenProgress(packCount);  //设置上传的进度条的总进度数
					xmlhttp = GetXmlHttp(); //通过AJAX格式上传
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
							xmlhttp.open("post", "saveImageOrgnew.action?orgid="+strOrgid+"&docid="+strDocid+"&packindex="+i+"&pageTypeStr="+pageTypeStr+"&bzjgdm="+strBzjgdm+"&lastpack="+lastpack, false);
							xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   //这句必须要，而且一定要放在send以前
							xmlhttp.send("imageData=" + encodeURIComponent(pack)); 
                            //alert(xmlhttp.responseText);
							var objs = eval("["+xmlhttp.responseText+"]");
							if(objs[0].success)
							{
								scanner7010.Progress('上传中',i+1);
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
					alert("上传成功！");
					btn.enable();
					return true;
	       }   
	   },{   
	       text: '重载',   
		       handler: function() { 
		    	   var record = grid_archivesManage.getSelectionModel().getSelected();
				   var resultObject = null;
				   var useState=record.data.state;
				   var	imgUrl='';
					imgUrl='orgnewViewImg.action';

		    		Ext.Ajax.request({
						url : imgUrl,
						params : {orgid : record.data.orgid},
						success : function(result,request) {//获取返回值
							var resultObject = Ext.util.JSON.decode(result.responseText);
							if(resultObject!=null){
								scanner7010.OpenProgress(3);  //设置上传的进度条的总进度数
								scanner7010.Progress('原文加载中',1);
								scanner7010.Progress('原文加载中',2);
							    //resultObject = eval('('+result.responseText+')');  
			   					scanner7010.ImageData=resultObject.imageData;
		   						if(scanner7010.ImageData!=""){
		   							scanner7010.PageType=resultObject.pageTypeStr;
		   							scanner7010.Progress('原文加载完毕',3);
		   						}else{
		   							scanner7010.Progress('原文加载失败',3);
			   						alert("原文错误，加载失败，请重新扫描或导入！");
		   						}
		   						scanner7010.CloseProgress();
							}
						},
						failure : function() {
							alert("图像加载错误");
						}
					});
		       }
	   },{   
	        text: '取消',   
	        handler: function() {   
	            imageView_window_archivesManage.hide();   
	        }
	   }],
	   listeners : {
			'activate' : function() {  //标签激活后自动加载数据
				var record = grid_archivesManage.getSelectionModel().getSelected();
				var resultObject = null;
				var useState=record.data.state;
				var	imgUrl='';

				imgUrl='orgnewViewImg.action';
	    		Ext.Ajax.request({
					url : imgUrl,
					params : {orgid : record.data.orgid},
					success : function(result,request) {//获取返回值
						var resultObject = Ext.util.JSON.decode(result.responseText);
						if(resultObject!=null){
							scanner7010.OpenProgress(3);  //设置上传的进度条的总进度数
							scanner7010.Progress('原文加载中',1);
							scanner7010.Progress('原文加载中',2);
						    //resultObject = eval('('+result.responseText+')');  
		   					scanner7010.ImageData=resultObject.imageData;
	   						if(scanner7010.ImageData!=""){
	   							scanner7010.PageType=resultObject.pageTypeStr;
	   							scanner7010.Progress('原文加载完毕',3);
		   						scanner7010.CloseProgress();
	   						}else{
	   							scanner7010.Progress('原文加载失败',3);
		   						scanner7010.CloseProgress();
		   						alert("原文错误，加载失败，请重新扫描或导入！");
	   						}
						}
					},
					failure : function() {
						alert("图像加载错误");
					}
				});
			}
		}
    
});   

//---------------------- 弹出浏览原文的窗口 ------------------------------------
function viewPic_archivesManage()
{
	imageView_window_archivesManage.show(); 
	imageView_window_archivesManage.setTitle('原文预览');
}
//---------------------- 列表显示原文的标识 ------------------------------------
function icon_archivesManage(value,p,record){
	if(typeof record=='object'){
		var fileUrl;
		fileUrl=record.data["imageData"];
		//alert(fileUrl);
		if(fileUrl!=''){
			return String.format('<a style="display:table;width:100%;" onclick="viewPic_archivesManage()"><img src="images/file_ico.gif"></a>',record.data["orgid"]);
		}
	}  
}


//---------------------- 列表显示主要数据信息 ----------------------------------
// 列表显示机构的主要信息 yangqi
var sm24568 = new Ext.grid.CheckboxSelectionModel();
var cm_archives = new Ext.grid.ColumnModel([expander_zam,
	sm24568,
	{header : '原文',width : 20,dataIndex : 'imageUrl', renderer:icon_archivesManage,sortable : false},
	{header : '流水号',width : 60,dataIndex : 'orderid',sortable : true}, 
	{header : '机构名称',width : 180,sortable : true,dataIndex : 'jgmc'},
	{header : '机构代码',width : 180,sortable : true,dataIndex : 'jgdm'},
	{header : '机构类型',width : 180,sortable : true,dataIndex : 'jglx'},
	{header : '法定代表人/负责人',width : 80,dataIndex : 'fddbr',sortable : true}, 
	{header : '经办人姓名',width : 40,dataIndex : 'name',id : 'name',sortable : true},
	{header : '审核人',	width : 50,dataIndex : 'handleName',sortable : true},
	{header : '状态',width : 150,dataIndex : 'state',renderer : goState,menuDisabled : true}
]);


//---------------------- 增加 新办申请信息 ----------------------------------------------
var orgnewForm = new Ext.FormPanel({
	url : 'saveOrgnew.action',
	labelAlign : 'right',
	labelWidth : 70,
	bodyStyle : 'padding:5px',
	border : false,
	fileUpload : true,
	baseCls : 'x-plain',
	items : [{
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		items : [{//第一行 增加
			columnWidth : .67,
			layout : 'form',
			baseCls : 'x-plain',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '96.5%'},
			items : [{fieldLabel : '机构名称',name : 'orgnew.jgmc',id : 'orgnew.jgmc',allowBlank : false,maxLength : 50,defaults : {anchor:'95%'}}]
		},{
			columnWidth : .33,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '93%'},
			items :[
		        new Ext.form.DateField({  
                id:'zcrq',
                name: 'orgnew.zcrq',
                format:'Y-m-d',  
                maxValue:'05/23/2012',  
                maxText:'所选日期应在{0}之前',  
                minValue:'01/01/2008',
                minText:'所选日期应在{0}之后',
                disabledDates:["2008年03月12日"],             //禁止选择2008年03月12日   
                width:150,  
                fieldLabel:'注册日期'  
		        }) 
		    ]
		}]
	},{	layout : 'column',
		border : false,
		baseCls : 'x-plain',
		items : [{//第二行 增加
				layout : 'column',
				border : false,
				baseCls : 'x-plain',
				items : [{
					columnWidth : .33,
					layout : 'form',
					baseCls : 'x-plain',
					border : false,
					defaultType : 'textfield',
					defaults : {anchor : '96.5%'},
					items : [{fieldLabel : '法定代表人',	name : 'orgnew.fddbr',allowBlank : false,maxLength : 30,defaults : {anchor:'95%'}}]
				},{
					columnWidth : .34,
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'textfield',
					defaults : {anchor : '93%'},
					items :[{fieldLabel : '证件类型',name : 'orgnew.zjlx',allowBlank : false,maxLength : 10,defaults : {anchor:'95%'}}]
				},{
					columnWidth : .33,
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'textfield',
					defaults : {anchor : '93%'},
					items :[{fieldLabel : '证件号码',name : 'orgnew.zjhm',xtype : 'numberfield',allowBlank : false,maxLength : 25,defaults : {anchor:'95%'}}]
				}]
		}]
	},{
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		items : [{//第三行增加
				layout : 'column',
				border : false,
				baseCls : 'x-plain',
				items : [{
					columnWidth : 1,
					layout : 'form',
					baseCls : 'x-plain',
					border : false,
					defaultType : 'textfield',
					defaults : {anchor : '97.5%'},
					items : [{fieldLabel : '经营范围',name : 'orgnew.jyfw',allowBlank : false,maxLength : 50,defaults : {anchor:'96.5%'}}]
			}]
		}]
	},{	
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		items : [{//第四行增加
				layout : 'column',
				border : false,
				baseCls : 'x-plain',
				items : [{
					columnWidth : .67,
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'textfield',
					defaults : {anchor : '96.5%'},
					items :[{fieldLabel : '机构地址',name : 'orgnew.jgdz',allowBlank : false,maxLength : 50,defaults : {anchor:'95%'}}]
				},{
					columnWidth : .33,
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'textfield',
					defaults : {anchor : '93%'},
					items :[{xtype : 'hidden',name : 'orgnew.xzqhName'},{
						xtype : 'combo',
						fieldLabel : '行政区划',
						id : 'xzqh',
						name:'xzqhName',
						hiddenName : 'orgnew.xzqhCode',
						valueField : 'xzqhCode',
						displayField : 'xzqhName',
						mode : 'remote',
						store : ds_xzqh_select,
						selectOnFocus : true,
						editable : false,
						triggerAction : 'all',
						loadingText : '加载中...',
						listeners : {
							'select' : function(combo, record, index) {
								this.ownerCt.ownerCt.ownerCt.ownerCt.form.findField('orgnew.xzqhName').setValue(record.data.xzqhName);
							}
						}
					}]
			}]
		}]
	},{
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		items : [{
			columnWidth : .33,
			layout : 'form',
			baseCls : 'x-plain',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '93%'},
			items : [
			    {fieldLabel : '邮政编码',name : 'orgnew.yzbm',xtype : 'numberfield',allowBlank : false,maxLength : 50},
				{fieldLabel : '机构网址',name : 'orgnew.weburl',allowBlank : false,maxLength : 50}, 
				{fieldLabel : '主要产品一',name : 'orgnew.zycp1',allowBlank : false,maxLength : 50}, 
				{fieldLabel : '职工人数',name : 'orgnew.zgrs',maxLength : 50}, 
				{fieldLabel : '批准机构',name : 'orgnew.pzjgmc',maxLength : 50}, 
				{fieldLabel : '经营地址',name : 'orgnew.jydz',maxLength : 25}, 
				{fieldLabel : '经费来源',name : 'orgnew.jfly',maxLength : 25}, 
				{fieldLabel : '经办人名称',name : 'orgnew.tbrxm',maxLength : 25}, 
				{fieldLabel : '可否公开',name : 'orgnew.gk',maxLength : 25}
			]
		}, {
			columnWidth : .34,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '93%'},
			items : [
				{fieldLabel : '电话号码',name : 'orgnew.dhhm',maxLength : 50}, 
				{fieldLabel : '注册资金',xtype : 'numberfield',xtype : 'numberfield',name : 'orgnew.zczj',maxValue : 1000}, 
				{fieldLabel : '主要产品二',name : 'orgnew.zycp2',maxLength : 25}, 
				{fieldLabel : '主管机构名',name : 'orgnew.zgmc',maxLength : 25}, 
				{fieldLabel : '批准文号',name : 'orgnew.pzwh',maxLength : 25},
				{fieldLabel : '经营邮编',name : 'orgnew.jyyb',xtype : 'numberfield',maxLength : 25}, 
				{fieldLabel : '开户银行',name : 'orgnew.khyh',maxLength : 25}, 
				{fieldLabel : '身份证号码',name : 'orgnew.tbrsfzh',maxLength : 25}, 
				{fieldLabel : '是否邮寄',name : 'orgnew.yjflag',maxLength : 25}, 
				{xtype : 'hidden',name : 'orgnew.scbzrq',value :myDate.format('Y-m-d'),maxLength : 50 }, 
				{xtype : 'hidden',name : 'orgnew.lry',value:currentZzUsername,maxLength : 50},
				{xtype : 'hidden',name : 'orgnew.username',value:currentZzUsername,maxLength : 50},
				{xtype : 'hidden',name : 'orgnew.name',value:currentZzUser,maxLength : 50}
				]
		}, {
			columnWidth : .33,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '93%'},
			items : [
				{fieldLabel : '电子邮箱',name : 'orgnew.email',maxLength : 50}, 
				{fieldLabel : '投资国别',xtype : 'numberfield',name : 'orgnew.wftzgb',maxValue : 1000}, 
				{fieldLabel : '主要产品三',name : 'orgnew.zycp3',maxLength : 25}, 
				{fieldLabel : '注册号',name : 'orgnew.zch',maxLength : 25}, 
				{fieldLabel : '批准日期',name : 'orgnew.pwrq',maxLength : 25}, 
				{fieldLabel : '经营电话',name : 'orgnew.jydh',maxLength : 25}, 
				{fieldLabel : '开户帐号',name : 'orgnew.khzh',maxLength : 25}, 
				{fieldLabel : '经办人电话',name : 'orgnew.tbrlxfs',maxLength : 25},
				{fieldLabel : '电子附件',name : 'upload',inputType : 'file'}
			]
		}]
	}],
	buttonAlign : 'center',
	minButtonWidth : 60,
	buttons : [{
		text : '添加',
		handler : function(btn) {
			if (orgnewForm.getForm().isValid()) {
				btn.disable();
				var bnfield = orgnewForm.getForm().findField('orgnew.jgmc');
				orgnewForm.getForm().submit({
					waitTitle : '请稍候',
					waitMsg : '正在提交表单数据,请稍候...',
					success : function(form, action) {
						var store = grid_archivesManage.getStore();
						if (store.data.length <= 20) {
							var orgnew = new Orgnew({
								orgid : action.result.orgid,
								jgmc : bnfield.getValue(),
								
								zcrq : form.findField('orgnew.zcrq').getValue(),
								fddbr : form.findField('orgnew.fddbr').getValue(),
								zjlx : form.findField('orgnew.zjlx').getValue(),
								zjhm : form.findField('orgnew.zjhm').getValue(),
								jyfw : form.findField('orgnew.jyfw').getValue(),
								jgdz : form.findField('orgnew.jgdz').getValue(),
								yzbm : form.findField('orgnew.yzbm').getValue(),
								
								dhhm : form.findField('orgnew.dhhm').getValue(),
								email : form.findField('orgnew.email').getValue(),
								weburl : form.findField('orgnew.weburl').getValue(),
								zczj : form.findField('orgnew.zczj').getValue(),
								wftzgb : form.findField('orgnew.wftzgb').getValue(),
								zgrs : form.findField('orgnew.zgrs').getValue(),
								zgmc : form.findField('orgnew.zgmc').getValue(),
								zycp1 : form.findField('orgnew.zycp1').getValue(),
								zycp2 : form.findField('orgnew.zycp2').getValue(),
								zycp3 : form.findField('orgnew.zycp3').getValue(),
								zch : form.findField('orgnew.zch').getValue(),
								pzjgmc : form.findField('orgnew.pzjgmc').getValue(),
								pzwh : form.findField('orgnew.pzwh').getValue(),
								pwrq : form.findField('orgnew.pwrq').getValue(),
								jydz : form.findField('orgnew.jydz').getValue(),
								jyyb : form.findField('orgnew.jyyb').getValue(),
								jydh : form.findField('orgnew.jydh').getValue(),
								jfly : form.findField('orgnew.jfly').getValue(),
								khyh : form.findField('orgnew.khyh').getValue(),
								khzh : form.findField('orgnew.khzh').getValue(),
								tbrxm : form.findField('orgnew.tbrxm').getValue(),
								tbrsfzh : form.findField('orgnew.tbrsfzh').getValue(),
								tbrlxfs : form.findField('orgnew.tbrlxfs').getValue(),
								gk : form.findField('orgnew.gk').getValue(),
								yjflag : form.findField('orgnew.yjflag').getValue(),
								xzqhCode : form.findField('orgnew.xzqhCode').getValue(),
								//xzqhName : Ext.get('xzqh').dom.value,   //特殊处理id唯一

								imageUrl : action.result.imageUrl
								
							});
							store.insert(0, [orgnew]);
							if (store.data.length > 20) {
								store.remove(store.getAt(store.data.length- 1));
							}
						}
						Ext.Msg.show({
							title : '提示',
							msg : '[ ' + bnfield.getValue() + ' ]   添加成功!!',
							buttons : Ext.MessageBox.OK,
							icon : Ext.Msg.INFO
						});
						bnfield.reset();
						btn.enable();
					},
					failure : function(form, action) {
						Ext.Msg.show({
							title : '错误提示',
							msg : action.result.contentTypeIsValid ? '操作失败' : '操作失败,文件类型不正确!',
							buttons : Ext.Msg.OK,
							fn : function() {bnfield.focus(true);btn.enable();},
							icon : Ext.Msg.ERROR
						});
					}
				});
			}
		}
	},{
		text : '扫描',
		handler : function() {window.open("NKOScanProj.jsp");}
	} ,{
		text : '重置',
		handler : function() {this.ownerCt.form.reset();}
	}, {
		text : '取消',
		handler : function() {this.ownerCt.ownerCt.hide();}
	}]
});

//--------------------修改新办申请机构信息-------------------------------------------
var orgnewEditForm = new Ext.FormPanel({
	url : 'updateOrgnew.action',
	labelAlign : 'right',
	labelWidth : 70,
	bodyStyle : 'padding:5px',
	border : false,
	fileUpload : true,
	autoHeight : true,
	autoScroll : true, 
	baseCls : 'x-plain',
	items : [{
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		items : [{//第一行修改
			columnWidth : .67,
			layout : 'form',
			baseCls : 'x-plain',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '96.5%'},
			items : [{fieldLabel : '机构名称',	name : 'jgmc',allowBlank : false,maxLength : 50,defaults : {anchor:'95%'}}]
		},{
			columnWidth : .33,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '93%'},
			items :[{
				xtype : 'combo',
				fieldLabel : '机构类型',
				id : 'jglx_add',
				name: 'jglx',
				hiddenName : 'dutyName',
				valueField : 'dutyName',
				displayField : 'dutyName',
				mode : 'remote',
				store : new Ext.data.Store({
					autoLoad : true,
					proxy : new Ext.data.HttpProxy({
						url : 'findAllDuty.action'
					}),
					reader : new Ext.data.JsonReader({
						root : 'root'
					}, [{name : 'dutyId',type : 'string'},
						{name : 'dutyName',type : 'string'}
					])
				}),
				selectOnFocus : true,
				editable : false,
				triggerAction : 'all',
				loadingText : '加载中...',
				listeners : {
					'select' : function(combo, record, index) {
						this.ownerCt.ownerCt.ownerCt.form.findField('jglx').setValue(record.data.dutyName);
					}
				}
			}]
		}]
	},{	layout : 'column',
		border : false,
		baseCls : 'x-plain',
		items : [{//第二行修改
				layout : 'column',
				border : false,
				baseCls : 'x-plain',
				items : [{
					columnWidth : .33,
					layout : 'form',
					baseCls : 'x-plain',
					border : false,
					defaultType : 'textfield',
					defaults : {anchor : '96.5%'},
					items : [{fieldLabel : '法定代表人',	name : 'fddbr',allowBlank : false,maxLength : 30,defaults : {anchor:'95%'}}]
				},{
					columnWidth : .34,
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'textfield',
					defaults : {anchor : '93%'},
					items :[{fieldLabel : '证件类型',	name : 'zjlx',allowBlank : false,maxLength : 10,defaults : {anchor:'95%'}}]
				},{
					columnWidth : .33,
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'textfield',
					defaults : {anchor : '93%'},
					items :[{fieldLabel : '证件号码',name : 'zjhm',allowBlank : false,maxLength : 25,defaults : {anchor:'95%'}}]
				}]
		}]
	},{
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		items : [{//第三行修改
				layout : 'column',
				border : false,
				baseCls : 'x-plain',
				items : [{
					columnWidth : 1,
					layout : 'form',
					baseCls : 'x-plain',
					border : false,
					defaultType : 'textfield',
					defaults : {anchor : '97.5%'},
					items : [{fieldLabel : '经营范围',name : 'jyfw',allowBlank : false,maxLength : 50,defaults : {anchor:'96.5%'}}]
				}]
		}]
	},{	
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		items : [{//第四行修改
				layout : 'column',
				border : false,
				baseCls : 'x-plain',
				items : [{
					columnWidth : .67,
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'textfield',
					defaults : {anchor : '96.5%'},
					items :[{fieldLabel : '机构地址',	name : 'jgdz',allowBlank : false,maxLength : 50,defaults : {anchor:'95%'}}]
				},{
					columnWidth : .33,
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'textfield',
					defaults : {anchor : '93%'},
					items :[{
						xtype : 'combo',
						fieldLabel : '行政区划',
						id : 'xzqh_edit',
						name: 'xzqhName',
						hiddenName : 'xzqhCode',
						valueField : 'xzqhCode',
						displayField : 'xzqhName',
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
								this.ownerCt.ownerCt.ownerCt.ownerCt.form.findField('xzqhName').setValue(record.data.xzqhName);
							}
						}
					}]
			}]
		}]
	},{ //表单修改
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		items : [{
			columnWidth : .33,
			layout : 'form',
			baseCls : 'x-plain',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '93%'},
			items : [
			    {xtype : 'hidden',	name : 'orgid'},
			    {fieldLabel : '邮政编码',	name : 'yzbm',allowBlank : false,maxLength : 50},
				{fieldLabel : '机构网址',	name : 'weburl',allowBlank : false,maxLength : 50}, 
				{fieldLabel : '主要产品一',	name : 'zycp1',allowBlank : false,maxLength : 50}, 
				{xtype : 'hidden',name : 'xzqhName'},
				{xtype : 'hidden',name : 'jglx'}, 
				{xtype : 'hidden',name : 'imageUrl'},
				{fieldLabel : '职工人数',name : 'zgrs',maxLength : 50}, 
				{fieldLabel : '批准机构',name : 'pzjgmc',maxLength : 50}, 
				{fieldLabel : '经营地址',name : 'jydz',maxLength : 25}, 
				{fieldLabel : '经费来源',name : 'jfly',maxLength : 25}, 
				{fieldLabel : '经办人名称',name : 'tbrxm',maxLength : 25}
			]
		}, {//表单修改
			columnWidth : .34,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '93%'},
			items : [
				{fieldLabel : '电话号码',name : 'dhhm',maxLength : 50}, 
				{fieldLabel : '注册资金',xtype : 'numberfield',name : 'zczj',maxValue : 1000}, 
				{fieldLabel : '主要产品二',name : 'zycp2',maxLength : 25}, 
				{fieldLabel : '主管机构名',name : 'zgmc',maxLength : 25}, 
				{fieldLabel : '批准文号',name : 'pzwh',maxLength : 25},
				{fieldLabel : '经营邮编',name : 'jyyb',maxLength : 25}, 
				{fieldLabel : '开户银行',name : 'khyh',maxLength : 25}, 
				{fieldLabel : '身份证号码',name : 'tbrsfzh',maxLength : 25}, 
				{xtype : 'hidden',name : 'lastdate',value :myDate.format('Y-m-d'),maxLength : 8 }, 
				{xtype : 'hidden',name : 'xgr',valuemaxLength : 50}
				]
		}, {//表单修改
			columnWidth : .33,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '93%'},
			items : [
				{fieldLabel : '电子邮箱',name : 'email',maxLength : 50}, 
				{fieldLabel : '投资国别',xtype : 'numberfield',name : 'wftzgb',maxValue : 1000}, 
				{fieldLabel : '主要产品三',name : 'zycp3',maxLength : 25}, 
				{fieldLabel : '注册号',name : 'zch',maxLength : 25}, 
				{fieldLabel : '批准日期',name : 'pwrq',maxLength : 25}, 
				{fieldLabel : '经营电话',name : 'jydh',maxLength : 25}, 
				{fieldLabel : '开户帐号',name : 'khzh',maxLength : 25}, 
				{fieldLabel : '经办人电话',name : 'tbrlxfs',maxLength : 25}
			]
		}]
	},{//表单修改
		xtype : 'panel',
		baseCls : 'x-plain',
		bodyBorder : false,
		layout : 'form',
		defaultType : 'textarea',
		defaults : {anchor:'97.6%'},
		items : [{fieldLabel : '审核意见',name : 'authorDesc',maxLength : 500,disabled : true }]
	}],
	buttonAlign : 'center',
	minButtonWidth : 60,
	buttons : [{
		text : '修改',
		handler : function(btn){
			if (orgnewEditForm.getForm().isValid()) {
				btn.disable();
				orgnewEditForm.getForm().submit({
					waitTitle : '请稍候',
					waitMsg : '正在修改数据,请稍候...',
					success : function(form,action) {
						Ext.Msg.show({
							title : '成功提示',
							msg : '数据修改成功!',
							buttons : Ext.Msg.OK,
							fn : function(){btn.enable();},
							icon : Ext.Msg.INFO
						});
						var store = grid_archivesManage.getStore();
						var orgnew = new Orgnew({
							orgid : form.findField('orgid').getValue(),
							// 数据修改自动更新表格列表本地信息
							
							fddbr : form.findField('fddbr').getValue(),
							zjlx : form.findField('zjlx').getValue(),
							zjhm : form.findField('zjhm').getValue(),
							jyfw : form.findField('jyfw').getValue(),
							jgdz : form.findField('jgdz').getValue(),
							yzbm : form.findField('yzbm').getValue(),
							dhhm : form.findField('dhhm').getValue(),
							email : form.findField('email').getValue(),
							weburl : form.findField('weburl').getValue(),
							zczj : form.findField('zczj').getValue(),
							wftzgb : form.findField('wftzgb').getValue(),
							zgrs : form.findField('zgrs').getValue(),
							zgmc : form.findField('zgmc').getValue(),
							zycp1 : form.findField('zycp1').getValue(),
							zycp2 : form.findField('zycp2').getValue(),
							zycp3 : form.findField('zycp3').getValue(),
							zch : form.findField('zch').getValue(),
							pzjgmc : form.findField('pzjgmc').getValue(),
							pzwh : form.findField('pzwh').getValue(),
							pwrq : form.findField('pwrq').getValue(),
							jydz : form.findField('jydz').getValue(),
							jyyb : form.findField('jyyb').getValue(),
							jydh : form.findField('jydh').getValue(),
							jfly : form.findField('jfly').getValue(),
							khyh : form.findField('khyh').getValue(),
							khzh : form.findField('khzh').getValue(),
							tbrxm : form.findField('tbrxm').getValue(),
							tbrsfzh : form.findField('tbrsfzh').getValue(),
							tbrlxfs : form.findField('tbrlxfs').getValue(),
							//gk : form.findField('gk').getValue(),
							//yjflag : form.findField('yjflag').getValue(),
							zcrq : Ext.get('zrcq_edit').dom.value,
							
							
							/*下拉选择问题，报JS错误？？？？yangqi
							xzqhName : Ext.get('xzqh_edit').dom.value,
							xzqhCode : form.findField('xzqhCode').getValue(),
							xzqhName : Ext.get('xzqh_edit').dom.value,
							zcrq : form.findField('zcrq').getValue(),
							imageUrl : action.result.imageUrl,
							*/
							jgmc : form.findField('jgmc').getValue()
						});
						var index = store.indexOf(grid_archivesManage.getSelectionModel().getSelected());
						store.remove(grid_archivesManage.getSelectionModel().getSelected());
						store.insert(index,orgnew);
						grid_archivesManage.getSelectionModel().selectRow(index);
					},
					failure : function(form, action) {
						Ext.Msg.show({
							title : '错误提示',
							msg : action.result.contentTypeIsValid ? '操作失败' : '操作失败,文件类型不正确!',
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
		handler : function() {
			var record = grid_archivesManage.getSelectionModel().getSelected();
			if(record){
				orgnewEditForm.getForm().loadRecord(record);
				orgnewEditForm.getForm().findField('_companyName').setValue('');
				orgnewEditForm.getForm().findField('_deptNo').setValue('');
				orgnewEditForm.getForm().findField('upload').setValue('');
			}
		}
	}, {
		text : '取消',
		handler : function() {this.ownerCt.ownerCt.hide();}
	}]
});

var ds_user_select = new Ext.data.Store({
	url : 'findUserByExample.action',
	reader : new Ext.data.JsonReader({
		root : 'root'
	}, [{name : 'userId',type : 'int'}, 
		{name : 'emplName',type : 'string'}
	])
});

//---------------------- 定义工具栏按钮事件 ------------------------------------------------------
var window_edit_archives = new Ext.Window({
	title : '证书办理--信息修改',
	width : 800,
	resizable : true,
	autoHeight : true,
	autoScroll : true, 
	modal : true,
	closeAction : 'hide',
	items : [orgnewEditForm]
});


var window_add_archives = new Ext.Window({
	title : '新办申请--信息登记',
	width : 800,
	resizable : false,
	autoHeight : true,
	modal : true,
	closeAction : 'hide',
	listeners : {
		'hide' : function() {
			//this.findById('orgnew.jgmc').ownerCt.ownerCt.ownerCt.form.reset();
		}
	},
	items : [orgnewForm]
});


/*
var btn_loandData_archives = new Ext.Button({
	text : '预约日期',
	iconCls : 'icon-datetime',
	disabled:true,
	handler : function(){
		var record = grid_archivesManage.getSelectionModel().getSelected();
		if(record){
			window_do_orgnew.show();
			loanDataForm.getForm().findField('orgid').setValue(record.data.orgid);
			loanDataForm.getForm().findField('userid').setValue(record.data.userid);
			loanDataForm.getForm().findField('jgmc').setValue(record.data.orgnewName);
			loanDataForm.getForm().findField('_jgmc').setValue(record.data.bookName);
		}
	}
});
*/


var btn_return_archives_create = new Ext.Button({
	text : '归档',
	iconCls : 'icon-store',
	disabled:true,
	handler : function(){
		var record = grid_archivesManage.getSelectionModel().getSelected();
		if(record){
			var orgid = record.data.orgid;
			Ext.Ajax.request({
				url: 'returnOrgnewCreate.action',
   				success: function(){
   					Ext.Msg.show({
						title : '提示',
						msg : '审核归档操作成功!',
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.INFO,
						fn : function(){
							//更新修改行的值
							record.set('state','5');
							grid_archivesManage.fireEvent('rowclick',grid_archivesManage,grid_archivesManage.getStore().indexOf(record));
							grid_archivesManage.getStore().remove(record);
							
						}
					});
   				},
   				failure: function(){
   					Ext.Msg.show({
						title : '提示',
						msg : '归档操作失败!',
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.ERROR
					});
   				},
   				params: { orgid: orgid}
			});
		}
	}
});


var btn_scanImage = new Ext.Button({
	text : '扫描',
	iconCls : 'icon-scan',
	handler : function() {
		window.open("NKOScanProj.jsp")
	}
});

var btn_add_archives = new Ext.Button({
	text : '新办',
	iconCls : 'icon-add',
	disabled:false,
	handler : function() {
		window_add_archives.show();
	}
});

var btn_edit_archives = new Ext.Button({
	text : '编辑',
	iconCls : 'icon-edit',
	disabled:true,
	handler : function(){
		var record = grid_archivesManage.getSelectionModel().getSelected();
		if(record){
			window_edit_archives.show();
			orgnewEditForm.getForm().loadRecord(record);
		}
	}
})

var btn_del_archives = new Ext.Button({
	text : '删除',
	iconCls : 'icon-del',
	disabled:true,
	handler : function() {
		var record = grid_archivesManage.getSelectionModel().getSelected();
		if (record) {
			Ext.Msg.confirm('确认删除', '你确定删除该件工单?', function(btn) {
				if (btn == 'yes') {
					Ext.Ajax.request({
						url : 'deleteOrgnew.action',
						params : {orgid : record.data.orgid},
						success : function() {grid_archivesManage.getStore().remove(record);},
						failure : function() {
							Ext.Msg.show({
								title : '错误提示',
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



//默认查询 limit为显示的条数
var searchArchives = function() {
	ds_archives.baseParams.conditions = text_search_archives.getValue();
	ds_archives.baseParams.username=currentZzUsername;
	ds_archives.baseParams.stateConditions='2,4,12,14,22,24,32,34,42,44,52,54,62,64,72,74';
	ds_archives.load({params : {start : 0,limit : 10} });

}

//查询返回结果的数据列
var ds_archives = new Ext.data.Store({
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
		{name : 'khyh',type : 'string'},
		{name : 'khzh',type : 'string'},
		
		{name : 'zsbfrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'zszfrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'jjlx',type : 'string'},
		{name : 'jjlxdm',type : 'string'},
		{name : 'tbrzjlx',type : 'string'},
		{name : 'memo',type : 'string'},
		{name : 'memo2',type : 'string'},
		{name : 'wftzgbdm',type : 'string'},
		{name : 'hbzldm',type : 'string'},
		{name : 'pzjgdm',type : 'string'},
		
		{name : 'ywlx',type : 'string'},
		{name : 'name',type : 'string'},
		{name : 'userid',type : 'string'},
		{name : 'username',type : 'string'},
		{name : 'handleName',type : 'string'},
		{name : 'handleDate',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'handleNote',type : 'string'},
		{name : 'imageUrl',type : 'string'},
		//{name : 'imageData',type : 'string'},
		{name : 'state',type : 'string'}
	])
});

var btn_search_archives = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchArchives();
		btn_edit_archives.setDisabled(true);
		btn_return_archives_create.setDisabled(true);
		//btn_return_archives_code.setDisabled(true);
	}
});

var btn_refresh_archives = new Ext.Button({
	text : '刷新',
	iconCls : 'icon-refresh',
	handler : function() {
		textSearchArchivesid.value='';
		searchArchives();
		btn_edit_archives.setDisabled(true);
		btn_return_archives_create.setDisabled(true);
		//btn_return_archives_code.setDisabled(true);
	}
});

var btn_do_orgnew = new Ext.Button({
	text : '审核办理',
	handler : function(){
		var record = grid_archivesManage.getSelectionModel().getSelected();
		if(record){
			//需要删除下列
			//window_do_orgnew.show();
			//loanArchiveForm.getForm().loadRecord(record);
			
			
			var record = grid_archivesManage.getSelectionModel().getSelected();
			if(record){
				window_do_archive.show();
				archiveViewForm.getForm().loadRecord(record);
				window_do_archive.setTitle('审核办理--【'+record.data.jgmc+'】--'+record.data.ywlx);
			}
			
			//loanArchiveForm.getForm().findField('orgnew.orgid').setValue(record.data.orgid);
			//loanArchiveForm.getForm().findField('_orgid').setValue(record.data.orgid);
			///loanArchiveForm.getForm().findField('orgnew.state').setValue(record.data.state);
			//loanArchiveForm.getForm().findField('orgnew.jgmc').setValue(record.data.jgmc);
			//loanArchiveForm.getForm().findField('_jgmc').setValue(record.data.jgmc);
			//loanArchiveForm.getForm().findField('orgnewCode_do').setValue(record.data.jgdm);
			//var orgid2 = loanArchiveForm.getForm().findField("_orgid").getValue();
			//var orgid3=1111;
			//alert(record.data.jgmc);
			//baseParams:{'orgid':1234},	
		}
	}
});

var ds_code_select=new Ext.data.Store({
	//grid.store.data.items[rowIndex].id});
	//caseStore.proxy = new Ext.data.HttpProxy({url:"payCaseManage.do?oper=listCase&city="+city+"&county="+county"});
	//baseParams:{'orgid':123},
	proxy : new Ext.data.HttpProxy({
		url : "returnOrgnewCode.action",
		method: 'POST'
	}),
	reader : new Ext.data.JsonReader({
		root : 'root'
	}, [{name : 'jgdm',type : 'string'},{name : 'jgmc',type : 'string'}])
})


/*
//?????????????yangqi   此处完善机构类型表的增加和字段录入
var loanArchiveForm = new Ext.FormPanel({
	url : 'returnOrgnewDo.action',
	labelAlign : 'right',
	labelWidth : 80,
	bodyStyle : 'padding:5px',
	border : false,
	baseCls : 'x-plain',
	defaultType : 'combo',
	defaults : {anchor:'95%'},
	items : [
		{xtype : 'hidden',name : 'orgid'},
		{xtype : 'hidden',name : 'state'},
	    {xtype : 'textfield',fieldLabel : '机构名称',name : 'jgmc',disabled:true},
	    {xtype : 'textfield',fieldLabel : '机构类型',name : 'jglx',disabled:true},
	    {
	    	xtype : 'combo',
			fieldLabel : '机构代码',
			id : 'orgnewCode_do',
			name : 'jgdm',
			valueField : 'jgdm',
			displayField : 'jgdm',
			hiddenName : 'jgdm', 
			mode : 'remote',
			store : ds_code_select,
			selectOnFocus : true,
			editable : false,
			triggerAction : 'all',
			loadingText : '加载中...',
			listeners : {
				'beforequery' : function(queryEvent) {
					var record = grid_archivesManage.getSelectionModel().getSelected();
					if(record){
						//给store为ds_code_select传params参数值，类似与returnOrgnewCode.action?orgid=111&jgmc=sss&zch=123&centerid=100000
						ds_code_select.baseParams.orgid = record.data.orgid;
						ds_code_select.baseParams.state = record.data.state;
						ds_code_select.baseParams.jgmc = record.data.jgmc;
						ds_code_select.baseParams.zch = record.data.zch;
						ds_code_select.baseParams.centerid="100000";
						ds_code_select.baseParams.dmlx="0";//0 个体，1非个体
					}
					
					if (!this.ownerCt.form.findField('jgmc').getValue()) {
						queryEvent.cancel = true;
					}
				 }
			}
	    }
	  ],
	buttonAlign : 'right',
	minButtonWidth : 60,
	buttons : [{
		text:'测试取码',
		handler : function(){
			var record = grid_archivesManage.getSelectionModel().getSelected();
			if(record){
				var orgid = record.data.orgid;
				var jgmc = record.data.jgmc;
				var zch = record.data.zch;
				var centerid = "100000";
				var dmlx = "0";
				Ext.Ajax.request({
					url: 'returnOrgnewCode.action',
	   				success: function(){
	   					Ext.Msg.show({
							title : '提示',
							msg : '取码访问成功!',
							buttons : Ext.Msg.OK,
							icon : Ext.Msg.INFO,
							fn : function(){
								//var record = grid_archivesManage.getSelectionModel().getSelected();
								//if(record){
								//	loanArchiveForm.getForm().findField('orgnewCode_do').setValue(record.data.orgid);
								//}
							}
						});
	   				},
	   				failure: function(){
	   					Ext.Msg.show({
							title : '提示',
							msg : '取码访问失败!!',
							buttons : Ext.Msg.OK,
							icon : Ext.Msg.ERROR
						});
	   				},
	   				params: { orgid: orgid,jgmc:jgmc,zch:zch,centerid:centerid,dmlx:dmlx}
				});
			}
		}
	},{
		text : '确定',
		handler : function(){
			if(this.ownerCt.getForm().isValid()){
						loanArchiveForm.getForm().submit({
							success: function(form){
								Ext.Msg.show({
									title : '提示',
									msg : '[' + form.findField('jgmc').getValue() + '] 办理成功!',
									icon :Ext.Msg.INFO,
									buttons :Ext.Msg.OK,
									fn:function(){
										window_do_orgnew.hide();
										var record = grid_archivesManage.getSelectionModel().getSelected();
										var strState=parseInt(form.findField('state').getValue())+2;
										record.set('state',strState.toString()); 
										grid_archivesManage.fireEvent('rowclick',grid_archivesManage,grid_archivesManage.getStore().indexOf(record));
									}
								});
							},
							failure : function(form,action){
								Ext.Msg.show({
									title : '提示',
									msg : '[' + form.findField('jgmc').getValue() + '] 办理失败!',
									icon : Ext.Msg.ERROR,
									buttons : Ext.Msg.OK
								});
							}
						});
			}
		}
	},{
		text : '取消',
		handler:function(){
			this.ownerCt.ownerCt.hide();
		}
	}]
});


var window_do_orgnew = new Ext.Window({
	title : '审核办理',
	width : 400,
	resizable : true,
	//autoHeight : true,
	modal : true,
	maximizable:true,
	closeAction : 'hide',
	items : [loanArchiveForm]
});
 */   
var text_search_archives = new Ext.form.TextField({
	id:'textSearchArchivesid',
	name : 'textSearchArchives',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchArchives();
			}
		}
	}
});

//--------------------机构基本信息-------------------------------------------
var archiveViewForm = new Ext.FormPanel({
	url : 'returnOrgnewDo.action',
	labelAlign : 'right',
	labelWidth : 70,
	bodyStyle : 'padding:5px',
	border : false,
	autoHeight : true,
	autoScroll : true, 
	baseCls : 'x-plain',
	waitMsgTarget: true,
	items : [{
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		items : [{//第一行基本
			columnWidth : 1,
			layout : 'form',
			baseCls : 'x-plain',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items : [{xtype : 'hidden',name : 'orgid'},{xtype : 'hidden',name : 'state'},{fieldLabel : '机构名称',	name : 'jgmc',allowBlank : false,readOnly:true,maxLength : 50}]
		}]
	},{
		layout : 'column',//第二行基本
		border : false,
		baseCls : 'x-plain',
		items : [{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{
		    	xtype : 'combo',
				fieldLabel : '机构代码',
				id : 'orgnewCode_do',
				name : 'jgdm',
				valueField : 'jgdm',
				displayField : 'jgdm',
				hiddenName : 'jgdm', 
				mode : 'remote',
				store : ds_code_select,
				selectOnFocus : true,
				editable : false,
				triggerAction : 'all',
				loadingText : '加载中...',
				listeners : {
					'beforequery' : function(queryEvent) {
						var record = grid_archivesManage.getSelectionModel().getSelected();
						if(record){
							//给store为ds_code_select传params参数值，类似与returnOrgnewCode.action?orgid=111&jgmc=sss&zch=123&centerid=100000
							ds_code_select.baseParams.orgid = record.data.orgid;
							ds_code_select.baseParams.state = record.data.state;
							ds_code_select.baseParams.jgmc = record.data.jgmc;
							ds_code_select.baseParams.zch = record.data.zch;
							ds_code_select.baseParams.centerid=currentZzUserBzjgdm;
							ds_code_select.baseParams.dmlx="0";//0 个体，1非个体
						}
					 }
				}
			}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '行政区划',	name : 'xzqhCode',allowBlank : false,readOnly:true,maxLength : 10}]
		}]
	},{	layout : 'column',//第三行基本
		border : false,
		baseCls : 'x-plain',
		items : [{
				layout : 'column',
				border : false,
				baseCls : 'x-plain',
				items : [{
					columnWidth : .5,
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'textfield',
					defaults : {anchor : '99%'},
					items :[{fieldLabel : '机构类型',name : 'jglx',maxLength : 50,readOnly:true}]
				},{
					columnWidth : .5,
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'textfield',
					defaults : {anchor : '99%'},
					items :[{fieldLabel : '法定代表',name : 'fddbr',maxLength : 30,readOnly:true}]
				}]
		}]
	},{	layout : 'column',//第四行基本
		border : false,
		baseCls : 'x-plain',
		items : [{
				layout : 'column',
				border : false,
				baseCls : 'x-plain',
				items : [{
					columnWidth : .5,
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'textfield',
					defaults : {anchor : '99%'},
					items :[{fieldLabel : '证件类型',name : 'zjlx',maxLength : 50,readOnly:true}]
				},{
					columnWidth : .5,
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'textfield',
					defaults : {anchor : '99%'},
					items :[{fieldLabel : '证件号码',name : 'zjhm',maxLength : 50,readOnly:true}]
				}]
		}]
	},{////第五行基本
		xtype : 'panel',
		baseCls : 'x-plain',
		bodyBorder : false,
		layout : 'form',
		defaultType : 'textarea',
		defaults : {anchor:'99%'},
		items : [{fieldLabel : '经营范围',name : 'jyfw',maxLength : 100,readOnly:true}]
	},{	layout : 'column',//第六行基本
		border : false,
		baseCls : 'x-plain',
		items : [{
				layout : 'column',
				border : false,
				baseCls : 'x-plain',
				items : [{
					columnWidth : .5,
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'textfield',
					defaults : {anchor : '99%'},
					items :[{fieldLabel : '成立日期',name : 'zcrq',maxLength : 50,readOnly:true}]
				},{
					columnWidth : .5,
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'textfield',
					defaults : {anchor : '99%'},
					items :[{fieldLabel : '职工人数',name : 'zgrs',maxLength : 50,readOnly:true}]
				}]
		}]
	},{	layout : 'column',//第七行基本
		border : false,
		baseCls : 'x-plain',
		items : [{
				layout : 'column',
				border : false,
				baseCls : 'x-plain',
				items : [{
					columnWidth : .5,
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'textfield',
					defaults : {anchor : '99%'},
					items :[{fieldLabel : '注册日期',name : 'zcrq',maxLength : 50,readOnly:true}]
				},{
					columnWidth : .5,
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'textfield',
					defaults : {anchor : '99%'},
					items :[{fieldLabel : '经济行业代码',name : 'jjhydm',maxLength : 50,readOnly:true}]
				}]
		}]
	},{	layout : 'column',//第八行基本
		border : false,
		baseCls : 'x-plain',
		items : [{
				layout : 'column',
				border : false,
				baseCls : 'x-plain',
				items : [{
					columnWidth : .5,
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'textfield',
					defaults : {anchor : '99%'},
					items :[{fieldLabel : '投资国别',name : 'wftzgb',maxLength : 50,readOnly:true}]
				},{
					columnWidth : .5,
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'textfield',
					defaults : {anchor : '99%'},
					items :[{fieldLabel : '注册资金',name : 'zczj',maxLength : 50,readOnly:true}]
				}]
		}]
	},{	layout : 'column',//第九行基本
		border : false,
		baseCls : 'x-plain',
		items : [{
				layout : 'column',
				border : false,
				baseCls : 'x-plain',
				items : [{
					columnWidth : .5,
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'textfield',
					defaults : {anchor : '99%'},
					items :[{fieldLabel : '货币种类',name : 'hbzl',maxLength : 50,readOnly:true}]
				},{
					columnWidth : .5,
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'textfield',
					defaults : {anchor : '99%'},
					items :[{fieldLabel : '主管部门',name : 'zgmc',maxLength : 50,readOnly:true}]
				}]
		}]
	},{	layout : 'column',//第十行基本
		border : false,
		baseCls : 'x-plain',
		items : [{
				layout : 'column',
				border : false,
				baseCls : 'x-plain',
				items : [{
					columnWidth : .5,
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'textfield',
					defaults : {anchor : '99%'},
					items :[{fieldLabel : '批准机构',name : 'pzjgmc',maxLength : 50,readOnly:true}]
				},{
					columnWidth : .5,
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'textfield',
					defaults : {anchor : '99%'},
					items :[{fieldLabel : '注册文号',name : 'zch',maxLength : 50,readOnly:true}]
				}]
		}]
	},{	layout : 'column',//第11行基本
		border : false,
		baseCls : 'x-plain',
		items : [{
				layout : 'column',
				border : false,
				baseCls : 'x-plain',
				items : [{
					columnWidth : .5,
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'textfield',
					defaults : {anchor : '99%'},
					items :[{fieldLabel : '邮政编码',name : 'yzbm',maxLength : 50,readOnly:true}]
				},{
					columnWidth : .5,
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'textfield',
					defaults : {anchor : '99%'},
					items :[{fieldLabel : '机构地址',name : 'jgdz',maxLength : 50,readOnly:true}]
				}]
		}]
	},{	layout : 'column',//第12行基本
		border : false,
		baseCls : 'x-plain',
		items : [{
				layout : 'column',
				border : false,
				baseCls : 'x-plain',
				items : [{
					columnWidth : .5,
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'textfield',
					defaults : {anchor : '99%'},
					items :[{fieldLabel : '固定电话',name : 'tel',maxLength : 50,readOnly:true}]
				},{
					columnWidth : .5,
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'textfield',
					defaults : {anchor : '99%'},
					items :[{fieldLabel : '网址',name : 'webUrl',maxLength : 50,readOnly:true}]
				}]
		}]
	},{	layout : 'column',//第13行基本
		border : false,
		baseCls : 'x-plain',
		items : [{
				layout : 'column',
				border : false,
				baseCls : 'x-plain',
				items : [{
					columnWidth : .5,
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'textfield',
					defaults : {anchor : '99%'},
					items :[{fieldLabel : '移动电话',name : 'mobile',maxLength : 50,readOnly:true}]
				},{
					columnWidth : .5,
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'textfield',
					defaults : {anchor : '99%'},
					items :[{fieldLabel : '电子信箱',name : 'email',maxLength : 50,readOnly:true}]
				}]
		}]
	},{	layout : 'column',//第14行基本
		border : false,
		baseCls : 'x-plain',
		items : [{
				layout : 'column',
				border : false,
				baseCls : 'x-plain',
				items : [{
					columnWidth : .5,
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'textfield',
					defaults : {anchor : '99%'},
					items :[{fieldLabel : '经办人',name : 'tbrxm',maxLength : 50,readOnly:true}]
				},{
					columnWidth : .5,
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'textfield',
					defaults : {anchor : '99%'},
					items :[{fieldLabel : '经办人证件号码',name : 'tbrsfzh',maxLength : 50,readOnly:true}]
				}]
		}]
	},{	layout : 'column',//第15行基本
		border : false,
		baseCls : 'x-plain',
		items : [{
				layout : 'column',
				border : false,
				baseCls : 'x-plain',
				items : [{
					columnWidth : .5,
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'textfield',
					defaults : {anchor : '99%'},
					items :[{fieldLabel : '经办人电话',name : 'tbrlxfs',maxLength : 50,readOnly:true}]
				},{
					columnWidth : .5,
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'textfield',
					defaults : {anchor : '99%'},
					items :[{fieldLabel : '业务类型',name : 'ywlx',maxLength : 50,readOnly:true}]
				}]
		}]
	}
	
	]
});


//信息浏览
var  archiveView= new Ext.Panel({
    title       : '基本信息',
    region      : 'west',
    split       : true,
    width       : 370,
    collapsible : true,
    margins     : '3 0 3 3',
    cmargins    : '3 3 3 3',
	defaults  : {
		autoScroll : true
	},
    items : [archiveViewForm]
}); 

//图像浏览
var archiveViewImg = new Ext.Panel({
	title   : '原文信息',
    region    : 'center',
    margins   : '3 3 3 0', 
    activeTab : 0,
    html: '<OBJECT classid="clsid:B4E2D33E-D8B2-4956-9F91-1C6BDC87A6D1"   width=100%  height=100% align=center hspace=0 vspace=0 id="scanner2"  name="scanner" >'
	       +'<param name="ShowCount" value="1">'
	       +'<param name="sModel" value="1">'
	       +'</OBJECT>'
    
});




var window_do_archive = {
		id:'border-panel',
		title: '四 Border Layout',
	    layout:'border',
	    bodyBorder: false,
		defaults: {
			collapsible: true,
	        split: true,
			animFloat: false,
			autoHide: false,
			useSplitTips: true,
			bodyStyle: 'padding:15px'
		},
	    items: [{
	        title: 'Footer',
			region: 'south',
	        height: 150,
	        minSize: 75,
	        maxSize: 250,
			cmargins: '5 0 0 0',
			html: '<p>Footer content</p>'
	    },{
			title: 'Navigation',
	        region:'west',
			floatable: false,
			margins: '5 0 0 0',
			cmargins: '5 5 0 0',
	        width: 175,
	        minSize: 100,
	        maxSize: 250,
			html: '<p>Secondary content like navigation links could go here</p>'
		},{
			title: 'Main Content',
			collapsible: false,
	        region:'center',
			margins: '5 0 0 0',
			html: '<h1>Main Page</h1><p>This is where the main content would go</p>'
		}]
	};

//加载右栏主页面   （数据列表、工具栏按钮）
var grid_archivesManage = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	//autoHeight : true,
	cm : cm_archives,
	ds : ds_archives,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'address',
	viewConfig : {forceFit : true},
	plugins : expander_zam,
	tbar : [btn_edit_archives,btn_del_archives,btn_refresh_archives,'-',btn_do_orgnew,btn_return_archives_create,'->', 
		  	text_search_archives,btn_search_archives],
	bbar : new Ext.PagingToolbar({
		pageSize : 10,
		store : ds_archives,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowdblclick':function(grid, rowIndex){
			var record33 = grid_archivesManage.getSelectionModel().getSelected();
			if(record33){
				window_do_archive.show();
				archiveViewForm.getForm().loadRecord(record33);
				window_do_archive.setTitle('审核办理--【'+record33.data.jgmc+'】--'+record33.data.ywlx);
			}
		},
		'rowclick':function(grid,rowIndex){
			btn_edit_archives.setDisabled(false);
			btn_do_orgnew.setDisabled(false);
			//btn_return_archives_code.setDisabled(grid.getStore().getAt(rowIndex).data.state == 2 ? false:true);
			if(grid.getStore().getAt(rowIndex).data.state == 4||grid.getStore().getAt(rowIndex).data.state == 14||grid.getStore().getAt(rowIndex).data.state == 24 ||grid.getStore().getAt(rowIndex).data.state == 34 ||grid.getStore().getAt(rowIndex).data.state == 44 ||grid.getStore().getAt(rowIndex).data.state == 54||grid.getStore().getAt(rowIndex).data.state == 64 ||grid.getStore().getAt(rowIndex).data.state == 74||grid.getStore().getAt(rowIndex).data.state == 84)
			{
				btn_return_archives_create.setDisabled(false);
				btn_do_orgnew.setDisabled(true);
				btn_edit_archives.setDisabled(true);
			}
			btn_del_archives.setDisabled(grid.getStore().getAt(rowIndex).data.state == 2 ? false:true);
		}
	}
});

var ds_filelog =  new Ext.data.Store({
	url : 'findAllLoanLog.action',
	sortInfo : {field: 'loanTime', direction: 'DESC'},
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'logId',type : 'int'}, 
		{name : 'orgid',type : 'int'}, 
		{name : 'orgnewName',type : 'string'}, 
		{name : 'loanTime'},
		{name : 'loanDays',type : 'int'}, 
		{name : 'preReturnTime'},
		{name : 'returnTime'},
		{name : 'readerId',type : 'int'},
		{name : 'reader',type : 'string'},
		{name : 'loannerId',type : 'int'},
		{name : 'filetypename',type : 'string'},
		{name : 'loanner',type : 'string'}]
	)
});

var dateFormatShzt = function(v){
	if(v){
		return v.substring(0,10)
	}
	return '未审批';
}

function linker(value,p,record)
{
   var fileUrl;
   fileUrl=record.data["bookId"] +'/'+ record.data["logId"]+'.jpg';
   if(typeof val!=''){
	   return String.format('<a style="display:table;width:100%;" onclick=viewPic("'+record.data["bookName"]+'","file/2012/'+fileUrl+'")>'+ record.data["bookName"]+'</a>',record.data.ID) 
   		//return String.format('<a style="display:table;width:100%;" target="_blank" href="file/2012/' + record.data["bookId"] +'/'+ record.data["logId"]+'.jpg" >'+ record.data["bookName"]+'</a>',record.data.ID)
	}
	return val;
}

LoanLogPanel = Ext.extend(Ext.grid.GridPanel,{
	constructor:function(){
		LoanLogPanel.superclass.constructor.call(this,{
		loadMask : {msg : '数据加载中...'},
			cm : new Ext.grid.ColumnModel([ 
			   {header : '文件分类',width : 100,	dataIndex : 'filetypename',sortable : true}, 
				{header : '文件名称',	width : 120,dataIndex : 'orgnewName',id : 'orgnewName',renderer:linker,sortable : true}, 
				{header : '文件大小(K)',	width : 90,	dataIndex : 'reader',sortable : true},
				{header : '上传时间',width : 100,	dataIndex : 'loanTime',renderer: dateFormatShzt,sortable : true}, 
				{header : '浏览次数',width : 100,	dataIndex : 'loanDays',sortable : true}, 
				{header : '审核时间',	width : 100,dataIndex : 'preReturnTime',renderer: dateFormatShzt,sortable : true}, 
				{header : '通过时间',	width : 100,dataIndex : 'returnTime',renderer:dateFormatShzt,sortable : true}, 
				{header : '受理人',	width : 100,dataIndex : 'loanner',menuDisabled : true}]
			),
			autoExpandColumn : 'jgmc',
			ds : ds_filelog,
			sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
			bbar : new Ext.PagingToolbar({
					pageSize : 10,
					store : ds_filelog,
					displayInfo : true,
					displayMsg : '第 {0} - {1} 条 共 {2} 条',
					emptyMsg : "没有新办申请记录"}
			)
		});
	}
});


var zzArchivesManage_panel = new Ext.Panel({
	title : '证书管理',
	iconCls : 'icon-plugin',
	region : 'center',
	border : 'layout',
	frame : true,
	layout:'border',
	defaults: {
	    collapsible: true,
	    split: true
	},
	items: [{
	    region:'center',
	    layout : 'border',
	    items : [window_do_archive]
	}]
});

var p_zzArchivesManage = {
	id : 'zzArchivesManage-panel',
	border : false,
	layout : 'border',
	items : [zzArchivesManage_panel]
}