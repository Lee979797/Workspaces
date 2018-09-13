
//-----------------------点击列表信息，显示图书的扩展属性-----------------------
var expander_zlpfb = new Ext.grid.RowExpander({
	tpl : new Ext.Template('<table width="100%"  border="0" cellspacing="6" cellpadding="0"  bgcolor="#DDEEF9" style="margin-top:1px;" >'
			+ '<tr>'
			+ '<td width="" colspan="4">'
			+ '<table width="98%" bgcolor="#ffffff" border="1" cellpadding="0" cellspacing="0" align="center"  bordercolordark="#FFFFFF" bordercolorlight="#6EBBE1" style="margin-top:0px;>'
			+ '<tr height="" valign="middle">'
			+ '  <td width="20%" align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">机构名称：</td><td width="30%"  valign="middle" style="padding-top:5px">{jgmc}<img src="images/temp.gif"></td>'
			+ '  <td width="20%" align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">机构代码：</td><td width="30%"  valign="middle" style="padding-top:5px">{jgdm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">小微企业：</td><td nowrap="nowrap" style="padding-top:5px">{isxw}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">年检日期：</td><td nowrap="nowrap" style="padding-top:5px">{njrq}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">法定代表人：</td><td nowrap="nowrap" style="padding-top:5px">{fddbr}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">是否公开：</td><td nowrap="nowrap" style="padding-top:5px">{gk}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">证件类型：</td><td nowrap="nowrap"  style="padding-top:5px">{zjlx}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">证件号码：</td><td nowrap="nowrap"  style="padding-top:5px">{zjhm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle" >'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">机构类型：</td><td  nowrap="nowrap" style="padding-top:5px">{jglx}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经济行业：</td><td nowrap="nowrap" style="padding-top:5px">{jjhymc} {jjhydm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经营范围：</td><td  colspan=3 style="padding-top:5px">{jyfw}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">企业简介：</td><td  colspan=3 style="padding-top:5px">{qyjj}<img src="images/temp.gif"></td>'
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
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">企业注册类型：</td><td nowrap="nowrap" style="padding-top:5px">{jjlx} {jjlxdm}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">外方国别：</td><td nowrap="nowrap" style="padding-top:5px">{wftzgb} {wftzgbdm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">注册资金：</td><td nowrap="nowrap" style="padding-top:5px">{zczj}(万)<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">货币种类：</td><td nowrap="nowrap" style="padding-top:5px">{hbzl}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">主管部门：</td><td nowrap="nowrap" style="padding-top:5px">{zgmc} {zgdm}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">批准机构：</td><td nowrap="nowrap" style="padding-top:5px">{pzjgmc} {pzjgdm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">注 册 号：</td><td nowrap="nowrap" style="padding-top:5px">{zch}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">联系电话：</td><td nowrap="nowrap" style="padding-top:5px">{dhhm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">机构注册地址：</td><td  colspan=3 style="padding-top:5px">{jgdz}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">行政区划：</td><td nowrap="nowrap" style="padding-top:5px">{xzqhName} {xzqhCode}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">邮政编码：</td><td nowrap="nowrap" style="padding-top:5px">{yzbm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">机构实际地址：</td><td  colspan=3 style="padding-top:5px">{jydz}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">行政区划：</td><td nowrap="nowrap" style="padding-top:5px">{xzqhName2} {xzqhCode2}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">邮政编码：</td><td nowrap="nowrap" style="padding-top:5px">{jyyb}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">电子信箱：</td><td nowrap="nowrap" style="padding-top:5px">{email}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">网&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址：</td><td nowrap="nowrap" style="padding-top:5px">{weburl}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">是否发卡：</td><td nowrap="nowrap" style="padding-top:5px">{fkbz}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">发卡数量：</td><td nowrap="nowrap" style="padding-top:5px">{fksl}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">办证日期：</td><td nowrap="nowrap" style="padding-top:5px">{bzrq}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">作废日期：</td><td nowrap="nowrap" style="padding-top:5px">{zfrq}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经 办 人：</td><td nowrap="nowrap" style="padding-top:5px">{tbrxm}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经办人证件类型：</td><td nowrap="nowrap" style="padding-top:5px">{tbrzjlx}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经办人证件号码：</td><td nowrap="nowrap" style="padding-top:5px">{tbrsfzh}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经办人电话：</td><td nowrap="nowrap" style="padding-top:5px">{tbrlxfs}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">办 理 人：</td><td nowrap="nowrap" style="padding-top:5px">{handleName}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">办理时间：</td><td nowrap="nowrap" style="padding-top:5px">{handleDate}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">审 核 人：</td><td nowrap="nowrap" style="padding-top:5px">{auditName}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">审核时间：</td><td nowrap="nowrap" style="padding-top:5px">{auditDate}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">审核意见：</td><td  colspan=3 style="padding-top:5px">{auditNote}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '</table>'
			+ '</td></tr></table>')
});


//--------------------图片浏览窗口-------------------------------------------
var imageView_window_licensePrintFuben = new Ext.Window({   
    id: 'image-window_zlpfb',   
    title : '原文预览',   
    width : 900,   
    height : 600,   
    resizable : true, 
    maximizable:true,
    closeAction :'hide',
    html: '<OBJECT classid="clsid:B4E2D33E-D8B2-4956-9F91-1C6BDC87A6D1"   width=100%  height=100% align=center hspace=0 vspace=0 id="scanner7375"  name="scanner7375" >'
	       +'<param name="ShowCount" value="8">'
	       +'<param name="sModel" value="0">'
	       +'</OBJECT>',
    buttons: [{   
	       text: '重载',   
		       handler: function() { 
		    	   var record = grid_LicensePrintFuben.getSelectionModel().getSelected();
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
								scanner7375.OpenProgress(3);  //设置上传的进度条的总进度数
								scanner7375.Progress('原文加载中',1);
								scanner7375.Progress('原文加载中',2);
							    //resultObject = eval('('+result.responseText+')');  
			   					scanner7375.ImageData=resultObject.imageData;
		   						if(scanner7375.ImageData!=""){
		   							scanner7375.PageType=resultObject.pageTypeStr;
		   							scanner7375.Progress('原文加载完毕',3);
		   						}else{
		   							scanner7375.Progress('原文加载失败',3);
			   						alert("原文错误，加载失败，请重新扫描或导入！");
		   						}
		   						scanner7375.CloseProgress();
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
	            imageView_window_licensePrintFuben.hide(); 
	            scanner7375.ImageData="";
	        }
	   }],
	   listeners : {
			'activate' : function() {  //标签激活后自动加载数据
				var record = grid_LicensePrintFuben.getSelectionModel().getSelected();
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
							scanner7375.OpenProgress(3);  //设置上传的进度条的总进度数
							scanner7375.Progress('原文加载中',1);
							scanner7375.Progress('原文加载中',2);
						    //resultObject = eval('('+result.responseText+')');  
		   					scanner7375.ImageData=resultObject.imageData;
	   						if(scanner7375.ImageData!=""){
	   							scanner7375.PageType=resultObject.pageTypeStr;
	   							scanner7375.Progress('原文加载完毕',3);
		   						scanner7375.CloseProgress();
	   						}else{
	   							scanner7375.Progress('原文加载失败',3);
		   						scanner7375.CloseProgress();
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
function viewPic_licensePrintFuben()
{
	imageView_window_licensePrintFuben.show(); 
	imageView_window_licensePrintFuben.setTitle('原文预览');
}
//---------------------- 列表显示原文的标识 ------------------------------------
function icon_licensePrintFuben(value,p,record){
	if(typeof record=='object'){
		var fileUrl;
		fileUrl=record.data["imageData"];
		//alert(fileUrl);
		if(fileUrl!=''){
			return String.format('<a style="display:table;width:100%;" onclick="viewPic_licensePrintFuben()"><img src="images/file_ico.gif"></a>',record.data["orgid"]);
		}
	}  
}
 
var btn_print_licensePrintFuben = new Ext.Button({
	text : '加打副本',
	//id: 'licensePrintFuben',
	iconCls : 'icon-print',
	//disabled:false,
	handler : function(){
		var record = grid_LicensePrintFuben.getSelectionModel().getSelected();
		if(record){
			window_do_licensePrintFuben.show();
		}else{
			alert("请选择需打印证书的机构");
		}
	}
});



var window_do_licensePrintFuben = new Ext.Window({   
    id: 'licensePrintFuben-window',   
    title : '加打副本--打印预览',   
    width : 900,   
    height : 700,   
    resizable : true, 
    maximizable:true,
    closeAction :'hide',
    autoScroll : true,
    html:'<object classid="clsid:917FD85D-CA3D-4C05-BDC7-D9E49B7607C7" height="100%" width="100%" id="lprt_fb" name="lprt_fb" codebase="prtocx/NacaoPrintProj.ocx#version=1.0.0.0">'
    	+'</object>',
    buttons: [{ 
		text: '打印',   
		handler: function(btn) {
			var record = grid_LicensePrintFuben.getSelectionModel().getSelected();
			if(record){
				var orgid = record.data.orgid;
				Ext.Ajax.request({
					url: 'returnOrgnewPrint.action',
	   				success: function(){
	   					btn.disable();
	   					if(record){
	   						
							//为打印控件赋值，正副本相同
							lprt_fb.JGDM="1|Times New Roman|13|"+formatJgdm(record.data.jgdm)+"|";
		    					lprt_fb.JGMC="1|宋体|12|"+record.data.jgmc+"|";
				    			lprt_fb.JGLX="1|宋体|12|"+record.data.jglxOld+"|";
							if(sysZsFddbrBz=='0'){//1不打印，0打印
								var  strJglxdmOld=record.data.jglxdmOld;
								if(strJglxdmOld=='2' || strJglxdmOld=='4' || strJglxdmOld=='6' || strJglxdmOld=='8' || strJglxdmOld=='9'){
									lprt_fb.FDDBR="0|宋体|12|"+record.data.fddbr+"|";
								}else{
									lprt_fb.FDDBR="1|宋体|12|"+record.data.fddbr+"|";
								}
							}else{
								lprt_fb.FDDBR="2|宋体|12|"+record.data.fddbr+"|";
							}
							lprt_fb.JGDZ="1|宋体|12|"+record.data.jgdz+"|";
				    			lprt_fb.ZSYXQ="1|宋体|12|自"+dateFormatToYMD(record.data.bzrq)+"\n至"+dateFormatToYMD(record.data.zfrq)+"|";
				    			lprt_fb.BFDW="1|宋体|12|"+sysZsbfdw+"|";
				    			lprt_fb.DJH1="1|宋体|12|组代管"+record.data.centerid+"-|";
				    			lprt_fb.DJH2="1|宋体|12|"+returnZslsh(record.data.zslsh)+"|";
								
							var iSn=parseInt(record.data.fbsl)+1;  //副本数量+1
							
						 	lprt_fb.DJH3="1|宋体|12|-"+iSn+"|";
						 	lprt_fb.OrgBarCode="1|宋体|12|"+record.data.jgdm+"|";
				    			//lprt_fb.NJInfo="1|宋体|12|"+sysPrintNote+"|";
							lprt_fb.PrintType=0;
						 	/////打印方法、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、
							lprt_fb.NacaoPrint();
							var txtDjh=record.data.centerid+"-"+record.data.zslsh+"-"+iSn;
							//防止点击窗口右上角的小按钮关闭输编号的窗口
					 		var a='0';
							do{
						  	 	a=showModalDialog("zsbhInputPage.jsp?succes=null&zfbFlag=1&addFuben=1&txtOrgid="+record.data.orgid+"&txtFbsl="+iSn+"&txtDjh="+txtDjh+"&txtJgdm="+record.data.jgdm+"&txtJgmc="+record.data.jgmc,["组代管"+txtDjh,"1","+formatJgdm(record.data.jgdm)+"],"dialogHeight:330px; dialogWidth: 400px; edge: raised; center: Yes; help: No; resizable: No; status: No; unadorned:1; "); 
							}while (a!='1');

							Ext.Msg.show({
								title : '提示',
								msg : '副本证书加打完毕!!',
								buttons : Ext.Msg.OK,
								fn : function(){record.set('fbsl',iSn);window_do_licensePrintFuben.hide();btn.enable();},
								icon : Ext.Msg.INFO
							});
	   					}
	   				},
	   				failure: function(){
	   					Ext.Msg.show({
							title : '提示',
							msg : '打印操作失败!!',
							buttons : Ext.Msg.OK,
							icon : Ext.Msg.ERROR
						});
	   				},
	   				params: { orgid: orgid}
				});
			
			}else{
				alert("请选择需打印证书的机构");
			}
		}
	},{   
        text: '取消',   
        handler: function() {   
            window_do_licensePrintFuben.hide();   
        }
   }],
   listeners : {
    	'activate' : function(e) {
    		var record = grid_LicensePrintFuben.getSelectionModel().getSelected();
	    	if(record){
	    		
	    		lprt_fb.JGDM="1|Times New Roman|13|"+formatJgdm(record.data.jgdm)+"|";
	    		lprt_fb.JGMC="1|宋体|12|"+record.data.jgmc+"|";
	    		lprt_fb.JGLX="1|宋体|12|"+record.data.jglxOld+"|";
	    		if(sysZsFddbrBz=='0'){//1不打印，0打印
		    		var  strJglxdmOld=record.data.jglxdmOld;
					if(strJglxdmOld=='2' || strJglxdmOld=='4' || strJglxdmOld=='6' || strJglxdmOld=='8' || strJglxdmOld=='9'){
						lprt_fb.FDDBR="0|宋体|12|"+record.data.fddbr+"|";
					}else{
						lprt_fb.FDDBR="1|宋体|12|"+record.data.fddbr+"|";
					}
	    		}else{
	    			lprt_fb.FDDBR="2|宋体|12|"+record.data.fddbr+"|";
	    		}
	    		lprt_fb.JGDZ="1|宋体|12|"+record.data.jgdz+"|";
	    		lprt_fb.ZSYXQ="1|宋体|12|自"+dateFormatToYMD(record.data.bzrq)+"\n至"+dateFormatToYMD(record.data.zfrq)+"|";
	    		lprt_fb.BFDW="1|宋体|12|"+sysZsbfdw+"|";
	    		lprt_fb.DJH1="1|宋体|12|组代管"+record.data.centerid+"-|";
	    		lprt_fb.DJH2="1|宋体|12|"+returnZslsh(record.data.zslsh)+"|";
	    		lprt_fb.DJH3="1|宋体|12|-1|";
	    		lprt_fb.OrgBarCode="1|宋体|12|"+record.data.jgdm+"|";
	    		//lprt_fb.NJInfo="1|宋体|12|"+sysPrintNote+"|";
			lprt_fb.PrintType=0;
	    	}
    	}
   }
});   
      
//默认查询 limit为显示的条数,测试时候不用打印标志为限制
var searchLicensePrintFuben = function() {
	ds_licensePrintFuben.baseParams.conditions = text_search_licensePrintFuben.getValue();
	//ds_licensePrintFuben.baseParams.dybz = 'Y';
	ds_licensePrintFuben.baseParams.username=currentZzUsername;
	ds_licensePrintFuben.baseParams.ywlxConditions='新办,变更,换证,补证,迁入,清整';
	ds_licensePrintFuben.baseParams.stateConditions='6,16,22';
	//ds_licensePrintFuben.baseParams.handleDate='handleDate';
	//ds_licensePrintFuben.baseParams.czshbz='1';
	ds_licensePrintFuben.load({params : {start : 0,limit : useFullPageSize} });
}

//查询返回结果的数据列
var ds_licensePrintFuben = new Ext.data.Store({
	url : 'findAllOrgnew.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'orgid',type : 'int'}, 
	    {name : 'orderid',type : 'string'}, 
	    {name : 'centerid',type : 'string'},
		{name : 'jgmc',type : 'string'},
		{name : 'jgdm',type : 'string'},
		{name : 'jglx',type : 'string'}, 
		{name : 'jglxdm',type : 'string'}, 
		{name : 'jglxOld',type : 'string'}, 
		{name : 'jglxdmOld',type : 'string'}, 
		{name : 'fddbr',type : 'string'}, 
		{name : 'zjlx',type : 'string'},
		{name : 'zjlxdm',type : 'string'},
		{name : 'zjhm',type : 'string'}, 
		{name : 'jyfw',type : 'string'},
		{name : 'qyjj',type : 'string'},
		{name : 'zcrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'zgdm',type : 'string'},
		{name : 'zgmc',type : 'string'},
		{name : 'jjhymc',type : 'string'},
		{name : 'jjhydm',type : 'string'},
		{name : 'jjlx',type : 'string'},
		{name : 'jjlxdm',type : 'string'},
		{name : 'gk',type : 'string'},
		{name : 'pzjgmc',type : 'string'},
		{name : 'pzjgdm',type : 'string'},
		{name : 'xzqhCode',type : 'string'},
		{name : 'xzqhName',type : 'string'},
		{name : 'xzqhCode2',type : 'string'},
		{name : 'xzqhName2',type : 'string'},
		{name : 'jgdz',type : 'string'},
		{name : 'yzbm',type : 'string'},
		{name : 'dhhm',type : 'string'},
		{name : 'bzjgdm',type : 'string'},
		{name : 'zycp1',type : 'string'},
		{name : 'zycp2',type : 'string'},
		{name : 'zycp3',type : 'string'},
		{name : 'zczj',type : 'string'},
		{name : 'hbzl',type : 'string'},
		{name : 'hbzldm',type : 'string'},
		{name : 'wftzgb',type : 'string'},
		{name : 'wftzgbdm',type : 'string'},
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
		{name : 'zslsh',type : 'string'},
		{name : 'bzrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'zfrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'tbrzjlx',type : 'string'},
		{name : 'memo2',type : 'string'},
		{name : 'memo',type : 'string'},
		{name : 'name',type : 'string'},
		{name : 'dybz',type : 'string'},
		
		{name : 'njrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'isxw',type : 'string'},
		{name : 'fkbz',type : 'string'},
		{name : 'fksl',type : 'int'},
		
		{name : 'username',type : 'string'},
		{name : 'handleName',type : 'string'},
		{name : 'handleDate',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'handleNote',type : 'string'},
		{name : 'auditName',type : 'string'},
		{name : 'auditDate',type : 'date',convert:function(v){if(v) return v.substring(0,16);}},
		{name : 'auditNote',type : 'string'},
		{name : 'fbsl',type : 'int'},
		{name : 'moveoutAddrss',type : 'string'},
		{name : 'moveoutReason',type : 'string'},
		{name : 'offPzjgmc',type : 'string'},
		{name : 'offPzwh',type : 'string'},
		{name : 'offReason',type : 'string'},
		{name : 'offNote',type : 'string'},
		{name : 'imageUrl',type : 'string'},
		{name : 'ywlx',type : 'string'},
		{name : 'state',type : 'string'}
	])
});

var btn_search_licensePrintFuben = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchLicensePrintFuben();
		//btn_print_licensePrintFuben.setDisabled(false);
	}
});

var btn_refresh_licensePrintFuben = new Ext.Button({
	text : '刷新',
	iconCls : 'icon-refresh',
	handler : function() {
		textSearchLicensePrintFubenid.value='';
		searchLicensePrintFuben();
		//btn_print_licensePrintFuben.setDisabled(false);
	}
});

    
var text_search_licensePrintFuben = new Ext.form.TextField({
	id:'textSearchLicensePrintFubenid',
	name : 'textSearchLicensePrintFuben',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchLicensePrintFuben();
			}
		}
	}
});

//---------------------- 列表显示主要数据信息 ----------------------------------
// 列表显示机构的主要信息 yangqi
var sm287211 = new Ext.grid.CheckboxSelectionModel();
var cm_licensePrintFuben = new Ext.grid.ColumnModel([expander_zlpfb,
	sm287211,
	{header : '原文',width : 20,dataIndex : 'imageUrl', renderer:icon_licensePrintFuben,sortable : false},
	{header : '流水号',width : 60,dataIndex : 'orderid',sortable : true}, 
	{header : '机构名称',width : 180,dataIndex : 'jgmc',sortable : true},
	{header : '机构代码',width : 50,dataIndex : 'jgdm',sortable : true},
	{header : '机构类型',width : 50,dataIndex : 'jglx',sortable : true},
	{header : '证书流水号',width : 50,dataIndex : 'zslsh',sortable : true},
	{header : '法定代表人/负责人',width : 60,dataIndex : 'fddbr',sortable : true}, 
	{header : '办理人',width : 40,dataIndex : 'handleName',id : 'handleName',sortable : true},
	{header : '状态',width : 50,dataIndex : 'state',renderer : goState,menuDisabled : true}
]);


//加载右栏主页面   （数据列表、工具栏按钮）
var grid_LicensePrintFuben = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_licensePrintFuben,
	ds : ds_licensePrintFuben,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	//pageSize : useFullPageSize,
	autoExpandColumn : 'state',
	viewConfig : {forceFit : true},
	plugins : expander_zlpfb,
	tbar : [btn_refresh_licensePrintFuben,btn_print_licensePrintFuben,'->', 
		  	text_search_licensePrintFuben,btn_search_licensePrintFuben],
	bbar : new Ext.PagingToolbar({
		pageSize : useFullPageSize,
		store : ds_licensePrintFuben,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	})
});


var zzLicensePrintFuben_panel = new Ext.Panel({
	title : '加打副本',
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
	    items : [grid_LicensePrintFuben]
	}]
});

var p_zzLicensePrintFuben = {
	id : 'zzLicensePrintFuben-panel',
	border : false,
	layout : 'border',
	items : [zzLicensePrintFuben_panel]
}


