
//-----------------------点击列表信息，显示图书的扩展属性-----------------------
var expander_orgPrtQzd = new Ext.grid.RowExpander({
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
var imageView_window_prtQzd = new Ext.Window({   
    id: 'image-window_7004',   
    title : '原文预览',   
    width : 900,   
    height : 600,   
    resizable : true, 
    maximizable:true,
    closeAction :'hide',
    html: '<OBJECT classid="clsid:B4E2D33E-D8B2-4956-9F91-1C6BDC87A6D1"   width=100%  height=100% align=center hspace=0 vspace=0 id="scanner7004"  name="scanner7004" >'
	       +'<param name="ShowCount" value="8">'
	       +'<param name="sModel" value="1">'
	       +'</OBJECT>',
    buttons: [{   
	       text: '重载',   
		       handler: function() { 
		    	   var record = grid_OrgPrtQzd.getSelectionModel().getSelected();
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
								scanner7004.OpenProgress(3);  //设置上传的进度条的总进度数
								scanner7004.Progress('原文加载中',1);
								scanner7004.Progress('原文加载中',2);
							    //resultObject = eval('('+result.responseText+')');  
			   					scanner7004.ImageData=resultObject.imageData;
		   						if(scanner7004.ImageData!=""){
		   							scanner7004.PageType=resultObject.pageTypeStr;
		   							scanner7004.Progress('原文加载完毕',3);
		   						}else{
		   							scanner7004.Progress('原文加载失败',3);
			   						alert("原文错误，加载失败，请重新扫描或导入！");
		   						}
		   						scanner7004.CloseProgress();
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
	            imageView_window_prtQzd.hide();   
	        }
	   }],
	   listeners : {
			'activate' : function() {  //标签激活后自动加载数据
				var record = grid_OrgPrtQzd.getSelectionModel().getSelected();
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
							scanner7004.OpenProgress(3);  //设置上传的进度条的总进度数
							scanner7004.Progress('原文加载中',1);
							scanner7004.Progress('原文加载中',2);
						    //resultObject = eval('('+result.responseText+')');  
		   					scanner7004.ImageData=resultObject.imageData;
	   						if(scanner7004.ImageData!=""){
	   							scanner7004.PageType=resultObject.pageTypeStr;
	   							scanner7004.Progress('原文加载完毕',3);
		   						scanner7004.CloseProgress();
	   						}else{
	   							scanner7004.Progress('原文加载失败',3);
		   						scanner7004.CloseProgress();
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
function viewPic_prtQzd()
{
	imageView_window_prtQzd.show(); 
	imageView_window_prtQzd.setTitle('原文预览');
}
//---------------------- 列表显示原文的标识 ------------------------------------
function icon_prtQzd(value,p,record){
	if(typeof record=='object'){
		var fileUrl;
		fileUrl=record.data["imageData"];
		//alert(fileUrl);
		if(fileUrl!=''){
			return String.format('<a style="display:table;width:100%;" onclick="viewPic_prtQzd()"><img src="images/file_ico.gif"></a>',record.data["orgid"]);
		}
	}  
}

var btn_print_orgPrtQzd = new Ext.Button({
	text : '打印迁址单',
	iconCls : 'icon-print',
	disabled:true,
	handler : function(){
		var record20 = grid_OrgPrtQzd.getSelectionModel().getSelected();
		if(record20){
			
			var tableStr = '<html><head><meta http-equiv="Content-Type" content="text/html; charset=gb2312" /><title>组织机构代码网上办证系统--迁址证明打印</title>';
			tableStr = tableStr + '<style type="text/css">';
			tableStr = tableStr + '		body{ width:910px; background-color: #CCCCCC;margin:20px auto;}';
			tableStr = tableStr + '		#xiahua {width:800px; padding:10px; border:1px #000000 solid; background:white}';
			tableStr = tableStr + '		.xiahua2 { border-bottom:1px #000000 solid; padding:2px; font-size:10.5pt; }';
			tableStr = tableStr + '		.STYLE8 {font-family: "宋体"; font-size: 10.5pt; }';
			tableStr = tableStr + '		.STYLE9 {font-size: 10.5pt; }';
			tableStr = tableStr + '		.STYLE18 {font-size: 14pt;line-height: 1.5em;}';
			tableStr = tableStr + '		.STYLE19 {font-family: "黑体";line-height: 2.5em;	font-size: 16pt;}';
			tableStr = tableStr + '		.STYLE20 {font-size: 16pt; }';
			tableStr = tableStr + '</style>';
			tableStr = tableStr + '</head>';
			tableStr = tableStr + '<body>';
			tableStr = tableStr + '	<center>';
			tableStr = tableStr + '    <br><br>';
			tableStr = tableStr + '		<div id="xiahua">';
			tableStr = tableStr + '		<table  id="table" width=689; cellpadding= "0" cellspacing= "0"  border="0"><tr><td height="54" align="center" class="STYLE18 STYLE19">迁址证明</td></tr></table>';
			tableStr = tableStr + '		<table id="table4" style="border-collapse:collapse; " cellpadding= "0" cellspacing= "0" border= "0" > ';         
			tableStr = tableStr + '			<tr>';
			tableStr = tableStr + '    		<td height="40" colspan="4" align="left" valign="bottom" class="STYLE8">组织机构代码：</td>';
			tableStr = tableStr + '		  		<td width="231" align="left" valign="bottom" class="xiahua2">'+record20.data.jgdm+'</td>';
			tableStr = tableStr + '    		<td width="105" align="left">&nbsp;</td><td width="179" align="center">&nbsp;</td><td width="105" align="center">&nbsp;</td>';
			tableStr = tableStr + '		  </tr>';
			tableStr = tableStr + '    	<tr>';
			tableStr = tableStr + '    		<td height="40" colspan="4" align="left" valign="bottom" class="STYLE8">组织机构名称：</td>';
			tableStr = tableStr + '   			<td colspan="4"  align="left" valign="bottom" class="xiahua2">'+record20.data.jgmc+'</td>';
			tableStr = tableStr + '			</tr>';
			tableStr = tableStr + '    	<tr>';
			tableStr = tableStr + '    		<td width="71" height="40" align="center" valign="bottom">自</td>';
			tableStr = tableStr + '				<td height="40" colspan="4" align="left" valign="bottom" class="xiahua2">'+record20.data.xzqhName+'</td>';
			tableStr = tableStr + '		      <td width="105" height="40" align="center" valign="bottom" class="STYLE8">（迁出地）迁入</td>';
			tableStr = tableStr + '		      <td width="179" align="left" valign="bottom" class="xiahua2">'+record20.data.moveoutAddrss+'</td>';
			tableStr = tableStr + '		      <td width="105" align="center" valign="bottom" class="STYLE8">（迁入地）</td>';
			tableStr = tableStr + '			</tr>';
			tableStr = tableStr + '    	<tr>';
			tableStr = tableStr + '				<td height="40" colspan="3"  align="left" valign="bottom" class="STYLE8">迁址原因：</td>';
			tableStr = tableStr + '				<td colspan="5" align="left" valign="bottom" class="xiahua2">'+record20.data.moveoutReason+'</td>';
			tableStr = tableStr + '			</tr>';
			tableStr = tableStr + '    	<tr>';           
			tableStr = tableStr + '    		<td height="40" colspan="4" align="left" valign="bottom" class="STYLE8">证书回收情况：</td>';            
			tableStr = tableStr + '    		<td align="left" valign="bottom">□ 正本&nbsp;&nbsp;'+record20.data.zbsl+'个</td>';
			tableStr = tableStr + '			<td align="left" valign="bottom">□ 纸质副本&nbsp;&nbsp;'+record20.data.fbsl+'个</td>';
			tableStr = tableStr + '    		<td align="center" colspan="2" valign="bottom">□ 电子副本&nbsp;&nbsp;'+record20.data.fksl+'个</td>';
			tableStr = tableStr + '    	</tr>';  
			tableStr = tableStr + '    	<tr>';            
			tableStr = tableStr + '   			<td height="46" colspan="2"  align="left" valign="bottom" class="STYLE8">经 办 人：</td>';            
			tableStr = tableStr + '				<td height="46" colspan="3"  align="left" valign="bottom" class="xiahua2"">'+record20.data.tbrxm+'</td>';
			tableStr = tableStr + '		      <td height="46" align="center" valign="bottom" class="STYLE9">联系电话：</td>';        
			tableStr = tableStr + '				<td align="left" valign="bottom" class="xiahua2">'+record20.data.tbrlxfs+'</td>';
			tableStr = tableStr + '				<td class="STYLE9" align="center">&nbsp;</td>';
			tableStr = tableStr + '   		</tr>';          
			tableStr = tableStr + '   		<tr>';           
			tableStr = tableStr + '    		<td height="50" colspan="2" align="left" valign="bottom" class="STYLE9" div>受 理 人：</td>';            
			tableStr = tableStr + '   			<td height="50" colspan="3" align="left" valign="bottom" class="xiahua2">'+currentZzUser+'</td>';
			tableStr = tableStr + '   			<td  align="center" valign="bottom"><span class="STYLE9">办理日期：</span></td>';
			tableStr = tableStr + '				<td  align="left" valign="bottom" class="xiahua2">'+myDate.format('Y-m-d')+'</td>';
			tableStr = tableStr + '				<td  align="center">&nbsp;</td>';
			tableStr = tableStr + '    	</tr>';          
			tableStr = tableStr + '    	<tr>';            
			tableStr = tableStr + '    		<td height="47" colspan="4" align="left" valign="bottom" class="STYLE9" div>代码管理机构:</td>';            
			tableStr = tableStr + '				<td colspan="3" align="left" valign="bottom" class="xiahua2">'+currentZzUserBzjgmc+'</td>';
			tableStr = tableStr + '				<td align="left" valign="bottom"><span class="STYLE9">（签章） </span></td>';
			tableStr = tableStr + '			</tr>';
			tableStr = tableStr + '		</table>';
			tableStr = tableStr + '   	<p>&nbsp;</p>';
			tableStr = tableStr + '	  </div>';
			tableStr = tableStr + '	<br><br><br><br>';
			
			
			tableStr = tableStr + '		<div id="xiahua">';
			tableStr = tableStr + '		<table  id="table" width=689; cellpadding= "0" cellspacing= "0"  border="0"><tr><td height="54" align="center" class="STYLE18 STYLE19">迁址证明</td></tr></table>';
			tableStr = tableStr + '		<table id="table4" style="border-collapse:collapse; " cellpadding= "0" cellspacing= "0" border= "0" > ';         
			tableStr = tableStr + '			<tr>';
			tableStr = tableStr + '    		<td height="40" colspan="4" align="left" valign="bottom" class="STYLE8">组织机构代码：</td>';
			tableStr = tableStr + '		  		<td width="231" align="left" valign="bottom" class="xiahua2">'+record20.data.jgdm+'</td>';
			tableStr = tableStr + '    		<td width="105" align="left">&nbsp;</td><td width="179" align="center">&nbsp;</td><td width="105" align="center">&nbsp;</td>';
			tableStr = tableStr + '		  </tr>';
			tableStr = tableStr + '    	<tr>';
			tableStr = tableStr + '    		<td height="40" colspan="4" align="left" valign="bottom" class="STYLE8">组织机构名称：</td>';
			tableStr = tableStr + '   			<td colspan="4"  align="left" valign="bottom" class="xiahua2">'+record20.data.jgmc+'</td>';
			tableStr = tableStr + '			</tr>';
			tableStr = tableStr + '    	<tr>';
			tableStr = tableStr + '    		<td width="71" height="40" align="center" valign="bottom">自</td>';
			tableStr = tableStr + '				<td height="40" colspan="4" align="left" valign="bottom" class="xiahua2">'+record20.data.xzqhName+'</td>';
			tableStr = tableStr + '		      <td width="105" height="40" align="center" valign="bottom" class="STYLE8">（迁出地）迁入</td>';
			tableStr = tableStr + '		      <td width="179" align="left" valign="bottom" class="xiahua2">'+record20.data.moveoutAddrss+'</td>';
			tableStr = tableStr + '		      <td width="105" align="center" valign="bottom" class="STYLE8">（迁入地）</td>';
			tableStr = tableStr + '			</tr>';
			tableStr = tableStr + '    	<tr>';
			tableStr = tableStr + '				<td height="40" colspan="3"  align="left" valign="bottom" class="STYLE8">迁址原因：</td>';
			tableStr = tableStr + '				<td colspan="5" align="left" valign="bottom" class="xiahua2">'+record20.data.moveoutReason+'</td>';
			tableStr = tableStr + '			</tr>';
			tableStr = tableStr + '    	<tr>';           
			tableStr = tableStr + '    		<td height="40" colspan="4" align="left" valign="bottom" class="STYLE8">证书回收情况：</td>';            
			tableStr = tableStr + '    		<td align="left" valign="bottom">□ 正本&nbsp;&nbsp;'+record20.data.zbsl+'个</td>';
			tableStr = tableStr + '			<td align="left" valign="bottom">□ 纸质副本&nbsp;&nbsp;'+record20.data.fbsl+'个</td>';
			tableStr = tableStr + '    		<td align="center" colspan="2" valign="bottom">□ 电子副本&nbsp;&nbsp;'+record20.data.fksl+'个</td>';
			tableStr = tableStr + '    	</tr>';  
			tableStr = tableStr + '    	<tr>';            
			tableStr = tableStr + '   			<td height="46" colspan="2"  align="left" valign="bottom" class="STYLE8">经 办 人：</td>';            
			tableStr = tableStr + '				<td height="46" colspan="3"  align="left" valign="bottom" class="xiahua2"">'+record20.data.tbrxm+'</td>';
			tableStr = tableStr + '		      <td height="46" align="center" valign="bottom" class="STYLE9">联系电话：</td>';        
			tableStr = tableStr + '				<td align="left" valign="bottom" class="xiahua2">'+record20.data.tbrlxfs+'</td>';
			tableStr = tableStr + '				<td class="STYLE9" align="center">&nbsp;</td>';
			tableStr = tableStr + '   		</tr>';          
			tableStr = tableStr + '   		<tr>';           
			tableStr = tableStr + '    		<td height="50" colspan="2" align="left" valign="bottom" class="STYLE9" div>受 理 人：</td>';            
			tableStr = tableStr + '   			<td height="50" colspan="3" align="left" valign="bottom" class="xiahua2">'+currentZzUser+'</td>';
			tableStr = tableStr + '   			<td  align="center" valign="bottom"><span class="STYLE9">办理日期：</span></td>';
			tableStr = tableStr + '				<td  align="left" valign="bottom" class="xiahua2">'+myDate.format('Y-m-d')+'</td>';
			tableStr = tableStr + '				<td  align="center">&nbsp;</td>';
			tableStr = tableStr + '    	</tr>';          
			tableStr = tableStr + '    	<tr>';            
			tableStr = tableStr + '    		<td height="47" colspan="4" align="left" valign="bottom" class="STYLE9" div>代码管理机构:</td>';            
			tableStr = tableStr + '				<td colspan="3" align="left" valign="bottom" class="xiahua2">'+currentZzUserBzjgmc+'</td>';
			tableStr = tableStr + '				<td align="left" valign="bottom"><span class="STYLE9">（签章） </span></td>';
			tableStr = tableStr + '			</tr>';
			tableStr = tableStr + '		</table>';
			tableStr = tableStr + '   	<p>&nbsp;</p>';
			tableStr = tableStr + '	  </div>';
			tableStr = tableStr + '</center></body></html>';
				 
			var titleHTML = tableStr;// document.getElementById("printGridfff").innerHTML;     
			var newwin = window.open('printer.jsp', 'printWindow', 'menubar=yes,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no,titlebar=yes,z-look=yes,menubar=yes');     
			  
			newwin.document.write(titleHTML);     
			//newwin.document.location.reload();     
			//newwin.print();     
			//newwin.close();     
		}
	}
})

//---------------------- 列表显示主要数据信息 ----------------------------------
// 列表显示机构的主要信息 yangqi
var sm267858 = new Ext.grid.CheckboxSelectionModel();
var cm_orgPrtQzd = new Ext.grid.ColumnModel([expander_orgPrtQzd,
	sm267858,
	{header : '原文',width : 20,dataIndex : 'imageUrl', renderer:icon_prtQzd,sortable : false},
	{header : '流水号',width : 60,dataIndex : 'orderid',sortable : true}, 
	{header : '机构名称',width : 180,sortable : true,dataIndex : 'jgmc'},
	{header : '机构代码',width : 60,sortable : true,dataIndex : 'jgdm'},
	{header : '机构类型',width : 60,sortable : true,dataIndex : 'jglx'},
	{header : '法定代表人/负责人',width : 80,dataIndex : 'fddbr',sortable : true}
]);


//---------------------- 定义工具栏按钮事件 ------------------------------------------------------
//默认查询 limit为显示的条数
var searchOrgPrtQzd = function() {
	ds_orgPrtQzd.baseParams.conditions = text_search_orgPrtQzd.getValue();
	ds_orgPrtQzd.baseParams.username=currentZzUsername;
	ds_orgPrtQzd.baseParams.stateConditions='6,16';
	ds_orgPrtQzd.baseParams.ywlxConditions='迁出';
	ds_orgPrtQzd.load({params : {start : 0,limit : useFullPageSize} });
}

//查询返回结果的数据列
var ds_orgPrtQzd = new Ext.data.Store({
	url : 'findAllOrgnew.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'orgid',type : 'int'}, 
	    {name : 'orderid',type : 'string'}, 
	    {name : 'centerid',type : 'string'},
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
		
		{name : 'jjhymc',type : 'string'},
		{name : 'jjhydm',type : 'string'},
		{name : 'gk',type : 'string'},
		{name : 'njrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'bzrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'zfrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'isxw',type : 'string'},
		{name : 'fkbz',type : 'string'},
		{name : 'fksl',type : 'int'},
		{name : 'zbsl',type : 'int'},
		{name : 'fbsl',type : 'int'},
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
		{name : 'auditName',type : 'string'},
		{name : 'auditDate',type : 'date',convert:function(v){if(v) return v.substring(0,16);}},
		{name : 'auditNote',type : 'string'},
		{name : 'imageUrl',type : 'string'},
		{name : 'moveoutAddrss',type : 'string'},
		{name : 'moveoutReason',type : 'string'},	
		{name : 'moveoutNote',type : 'string'},
		{name : 'dybz',type : 'string'},
		{name : 'state',type : 'string'}
	])
});

var btn_search_orgPrtQzd = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchOrgPrtQzd();
		btn_print_orgPrtQzd.setDisabled(true);
		//btn_print_orgPrtQzd_code.setDisabled(true);
	}
});

var btn_refresh_orgPrtQzd = new Ext.Button({
	text : '刷新',
	iconCls : 'icon-refresh',
	handler : function() {
		textSearchOrgPrtQzdid.value='';
		searchOrgPrtQzd();
		btn_print_orgPrtQzd.setDisabled(true);
		//btn_print_orgPrtQzd_code.setDisabled(true);
	}
});


var text_search_orgPrtQzd = new Ext.form.TextField({
	id:'textSearchOrgPrtQzdid',
	name : 'textSearchOrgPrtQzd',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchOrgPrtQzd();
			}
		}
	}
});

//加载右栏主页面   （数据列表、工具栏按钮）
var grid_OrgPrtQzd = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	//autoHeight : true,
	cm : cm_orgPrtQzd,
	ds : ds_orgPrtQzd,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'address',
	viewConfig : {forceFit : true},
	plugins : expander_orgPrtQzd,
	tbar : [btn_refresh_orgPrtQzd,btn_print_orgPrtQzd,'->', text_search_orgPrtQzd,btn_search_orgPrtQzd],
	bbar : new Ext.PagingToolbar({
		pageSize : useFullPageSize,
		store : ds_orgPrtQzd,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			//btn_do_orgnew.setDisabled(false);
			//btn_print_orgPrtQzd_code.setDisabled(grid.getStore().getAt(rowIndex).data.state == 2 ? false:true);
			if(grid.getStore().getAt(rowIndex).data.state == 6 || grid.getStore().getAt(rowIndex).data.state == 16 || grid.getStore().getAt(rowIndex).data.state == 24)
			{
				btn_print_orgPrtQzd.setDisabled(false);
				//btn_do_orgnew.setDisabled(true);
			}
			btn_print_orgPrtQzd.setDisabled(false);
		}
	}
});


var zzOrgPrtQzd_panel = new Ext.Panel({
	title : '迁址单打印',
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
	    items : [grid_OrgPrtQzd]
	}]
});

var p_zzOrgPrtQzd = {
	id : 'zzOrgPrtQzd-panel',
	border : false,
	layout : 'border',
	items : [zzOrgPrtQzd_panel]
}
