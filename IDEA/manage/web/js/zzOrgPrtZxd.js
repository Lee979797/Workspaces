
//-----------------------点击列表信息，显示图书的扩展属性-----------------------
var expander_orgPrtZxd = new Ext.grid.RowExpander({
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
var imageView_window_prtZxd = new Ext.Window({   
    id: 'image-window_7001',   
    title : '原文预览',   
    width : 900,   
    height : 600,   
    resizable : true, 
    maximizable:true,
    closeAction :'hide',
    html: '<OBJECT classid="clsid:B4E2D33E-D8B2-4956-9F91-1C6BDC87A6D1"   width=100%  height=100% align=center hspace=0 vspace=0 id="scanner7001"  name="scanner7001" >'
	       +'<param name="ShowCount" value="8">'
	       +'<param name="sModel" value="1">'
	       +'</OBJECT>',
    buttons: [{   
	       text: '重载',   
		       handler: function() { 
		    	   var record = grid_OrgPrtZxd.getSelectionModel().getSelected();
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
								scanner7001.OpenProgress(3);  //设置上传的进度条的总进度数
								scanner7001.Progress('原文加载中',1);
								scanner7001.Progress('原文加载中',2);
							    //resultObject = eval('('+result.responseText+')');  
			   					scanner7001.ImageData=resultObject.imageData;
		   						if(scanner7001.ImageData!=""){
		   							scanner7001.PageType=resultObject.pageTypeStr;
		   							scanner7001.Progress('原文加载完毕',3);
		   						}else{
		   							scanner7001.Progress('原文加载失败',3);
			   						alert("原文错误，加载失败，请重新扫描或导入！");
		   						}
		   						scanner7001.CloseProgress();
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
	            imageView_window_prtZxd.hide();   
	        }
	   }],
	   listeners : {
			'activate' : function() {  //标签激活后自动加载数据
				var record = grid_OrgPrtZxd.getSelectionModel().getSelected();
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
							scanner7001.OpenProgress(3);  //设置上传的进度条的总进度数
							scanner7001.Progress('原文加载中',1);
							scanner7001.Progress('原文加载中',2);
						    //resultObject = eval('('+result.responseText+')');  
		   					scanner7001.ImageData=resultObject.imageData;
	   						if(scanner7001.ImageData!=""){
	   							scanner7001.PageType=resultObject.pageTypeStr;
	   							scanner7001.Progress('原文加载完毕',3);
		   						scanner7001.CloseProgress();
	   						}else{
	   							scanner7001.Progress('原文加载失败',3);
		   						scanner7001.CloseProgress();
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
function viewPic_prtZxd()
{
	imageView_window_prtZxd.show(); 
	imageView_window_prtZxd.setTitle('原文预览');
}
//---------------------- 列表显示原文的标识 ------------------------------------
function icon_prtZxd(value,p,record){
	if(typeof record=='object'){
		var fileUrl;
		fileUrl=record.data["imageData"];
		//alert(fileUrl);
		if(fileUrl!=''){
			return String.format('<a style="display:table;width:100%;" onclick="viewPic_prtZxd()"><img src="images/file_ico.gif"></a>',record.data["orgid"]);
		}
	}  
}

var btn_print_orgPrtZxd = new Ext.Button({
	text : '打印注销单',
	iconCls : 'icon-print',
	disabled:true,
	handler : function(){
		pagesetup_null();
		var record20 = grid_OrgPrtZxd.getSelectionModel().getSelected();
		if(record20){
			
			var tableStr = '<html><head><title>组织机构代码网上办证系统--注销证明打印</title>';
			tableStr = tableStr + '<style>';
			tableStr = tableStr + '.STYLE8 {font-family: "宋体"; font-size: 10.5pt; }.STYLE9 {font-size: 10.5pt; }body {margin-left: 0px;margin-top: 0px;margin-right: 0px;margin-bottom: 0px;background-color: #CCCCCC;}';
			tableStr = tableStr + '.STYLE18 {font-size: 14pt;line-height: 1.5em;}';
			tableStr = tableStr + '.STYLE19 {font-family: "黑体";line-height: 2.5em;	font-size: 16pt;}';
			tableStr = tableStr + '.STYLE20 {font-size: 16pt; }';
			tableStr = tableStr + '</style>';
			tableStr = tableStr + '</head><body><center>';
			tableStr = tableStr + '<table border= "0" width=770 cellpadding= "0" cellspacing= "0"  bgcolor="#FFFFFF">';
			tableStr = tableStr + '  <tr>';
			tableStr = tableStr + '    <td align="center" valign="middle"><br>';
			tableStr = tableStr + '        <center>';
			tableStr = tableStr + '        <table  id="table" style="width:689;border-collapse:collapse; " cellpadding= "0" cellspacing= "0"  border="0" >';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td height="54" colspan="5" align="center" class="STYLE18 STYLE19">组织机构代码注销证明</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '        </table>';
			tableStr = tableStr + '      <table id="table4" style="width:689;border-collapse:collapse; " cellpadding= "0" cellspacing= "0" border= "1" bordercolor= "#3366FF">';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td width="140" height="40"  align="center" class="STYLE8"> 机构代码</td>';
			tableStr = tableStr + '            <td colspan="5"  align="center">'+record20.data.jgdm+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '           <td width="140" height="40" align="center" class="STYLE8">机构名称</td>';
			tableStr = tableStr + '            <td colspan="5"  align="center">'+record20.data.jgmc+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td height="40" align="center" class="STYLE8"> 注销核准机关</td>';
			tableStr = tableStr + '            <td colspan="5" align="center">'+record20.data.offPzjgmc+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td height="40"  align="center" class="STYLE8">注销核准文号</td>';
			tableStr = tableStr + '            <td colspan="5" align="center">'+record20.data.offPzwh+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td height="40"  align="center" class="STYLE8">注销原因</td>';
			tableStr = tableStr + '            <td colspan="5" align="center">'+record20.data.offReason+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '         <tr>';
			tableStr = tableStr + '            <td height="40" align="center" class="STYLE8">证书回收情况</span></td>';
			tableStr = tableStr + '            <td colspan="5" align="center">'+record20.data.offNote+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td height="63" class="STYLE8"  align="center">经办人</td>';
			tableStr = tableStr + '            <td width="125" align="center">'+record20.data.tbrxm+'</td>';
			tableStr = tableStr + '            <td width="60" height="63" align="center" class="STYLE8">身份证件号码</td>';
			tableStr = tableStr + '            <td width="177" height="63" class="STYLE8" align="center">'+record20.data.tbrsfzh+'</td>';
			tableStr = tableStr + '            <td width="46" height="63" align="center" class="STYLE9">联系<br>';
			tableStr = tableStr + '            电话</td>';
			tableStr = tableStr + '            <td width="127" height="63" class="STYLE9" align="center">'+record20.data.tbrlxfs+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td height="40" class="STYLE9" div align="center">受理人</td>';
			tableStr = tableStr + '            <td colspan="2"  align="center">'+currentZzUser+'</td>';
			tableStr = tableStr + '            <td  class="STYLE9" align="center">办理日期</td>';
			tableStr = tableStr + '            <td colspan="2"  align="center">'+myDate.format('Y-m-d')+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td height="60" class="STYLE9" div align="center">代码管理机构</td>';
			tableStr = tableStr + '            <td colspan="5" align="right">（签章）&nbsp;&nbsp;&nbsp;&nbsp; </td>';
			tableStr = tableStr + '        </table>';
			tableStr = tableStr + '      <p>&nbsp;</p>';
			tableStr = tableStr + '      <p>&nbsp;</p>';
			tableStr = tableStr + '      <p><br>';
			tableStr = tableStr + '      </p></td>';
			tableStr = tableStr + '  </tr>';
			tableStr = tableStr + '</table>';
			tableStr = tableStr + '<br>';
			tableStr = tableStr + '<table border= "0" width=770 cellpadding= "0" cellspacing= "0"  bgcolor="#FFFFFF">';
			tableStr = tableStr + '  <tr>';
			tableStr = tableStr + '    <td align="center" valign="middle"><br>';
			tableStr = tableStr + '        <center>';
			tableStr = tableStr + '        <table  id="table" style="width:689;border-collapse:collapse; " cellpadding= "0" cellspacing= "0"  border="0" >';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td height="54" colspan="5" align="center" class="STYLE18 STYLE19">组织机构代码注销证明</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '        </table>';
			tableStr = tableStr + '      <table id="table4" style="width:689;border-collapse:collapse; " cellpadding= "0" cellspacing= "0" border= "1" bordercolor= "#3366FF">';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td width="140" height="40"  align="center" class="STYLE8"> 机构代码</td>';
			tableStr = tableStr + '            <td colspan="5"  align="center">'+record20.data.jgdm+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '           <td width="140" height="40" align="center" class="STYLE8">机构名称</td>';
			tableStr = tableStr + '            <td colspan="5"  align="center">'+record20.data.jgmc+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td height="40" align="center" class="STYLE8"> 注销核准机关</td>';
			tableStr = tableStr + '            <td colspan="5" align="center">'+record20.data.offPzjgmc+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td height="40"  align="center" class="STYLE8">注销核准文号</td>';
			tableStr = tableStr + '            <td colspan="5" align="center">'+record20.data.offPzwh+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td height="40"  align="center" class="STYLE8">注销原因</td>';
			tableStr = tableStr + '            <td colspan="5" align="center">'+record20.data.offReason+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '         <tr>';
			tableStr = tableStr + '            <td height="40" align="center" class="STYLE8">证书回收情况</span></td>';
			tableStr = tableStr + '            <td colspan="5" align="center">'+record20.data.offNote+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td height="63" class="STYLE8"  align="center">经办人</td>';
			tableStr = tableStr + '            <td width="125" align="center">'+record20.data.tbrxm+'</td>';
			tableStr = tableStr + '            <td width="60" height="63" align="center" class="STYLE8">身份证件号码</td>';
			tableStr = tableStr + '            <td width="177" height="63" class="STYLE8" align="center">'+record20.data.tbrsfzh+'</td>';
			tableStr = tableStr + '            <td width="46" height="63" align="center" class="STYLE9">联系<br>';
			tableStr = tableStr + '            电话</td>';
			tableStr = tableStr + '            <td width="127" height="63" class="STYLE9" align="center">'+record20.data.tbrlxfs+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td height="40" class="STYLE9" div align="center">受理人</td>';
			tableStr = tableStr + '            <td colspan="2"  align="center">'+currentZzUser+'</td>';
			tableStr = tableStr + '            <td  class="STYLE9" align="center">办理日期</td>';
			tableStr = tableStr + '            <td colspan="2"  align="center">'+myDate.format('Y-m-d')+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td height="60" class="STYLE9" div align="center">代码管理机构</td>';
			tableStr = tableStr + '            <td colspan="5" align="right">（签章）&nbsp;&nbsp;&nbsp;&nbsp; </td>';
			tableStr = tableStr + '        </table>';
			tableStr = tableStr + '      <p>&nbsp;</p>';
			tableStr = tableStr + '      <p>&nbsp;</p>';
			tableStr = tableStr + '      <p><br>';
			tableStr = tableStr + '      </p></td>';
			tableStr = tableStr + '  </tr>';
			tableStr = tableStr + '</table>';
			
			tableStr = tableStr + '</center></body></html>';
			 
			var titleHTML = tableStr;// document.getElementById("printGridfff").innerHTML;     
			var newwin = window.open('printer.jsp', 'printWindow', 'menubar=yes,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no,titlebar=yes,z-look=yes,menubar=yes');     
			  
			newwin.document.write(titleHTML);     
			//newwin.document.location.reload();     
			//newwin.print();     
			//newwin.close();   
			if(record20.data.dybz != 'N'){
				Ext.Ajax.request({
					url : "updateDybzByOrgid.action",
					params : {orgid : record20.data.orgid},
					success : function(result,request) {
						
					}
				});
			}
		}
	}
});


//---------------------- 列表显示主要数据信息 ----------------------------------
// 列表显示机构的主要信息 yangqi
var sm265856 = new Ext.grid.CheckboxSelectionModel();
var cm_orgPrtZxd = new Ext.grid.ColumnModel([expander_orgPrtZxd,
	sm265856,
	{header : '原文',width : 20,dataIndex : 'imageUrl', renderer:icon_prtZxd,sortable : false},
	{header : '流水号',width : 60,dataIndex : 'orderid',sortable : true}, 
	{header : '机构名称',width : 180,sortable : true,dataIndex : 'jgmc'},
	{header : '机构代码',width : 60,sortable : true,dataIndex : 'jgdm'},
	{header : '机构类型',width : 60,sortable : true,dataIndex : 'jglx'},
	{header : '法定代表人/负责人',width : 80,dataIndex : 'fddbr',sortable : true}
]);


//---------------------- 定义工具栏按钮事件 ------------------------------------------------------
//默认查询 limit为显示的条数
var searchOrgPrtZxd = function() {
	ds_orgPrtZxd.baseParams.conditions = text_search_orgPrtZxd.getValue();
	ds_orgPrtZxd.baseParams.username=currentZzUsername;
	ds_orgPrtZxd.baseParams.stateConditions='6,16';
	ds_orgPrtZxd.baseParams.ywlxConditions='注销,批量注销';
	ds_orgPrtZxd.load({params : {start : 0,limit : useFullPageSize} });
}

//查询返回结果的数据列
var ds_orgPrtZxd = new Ext.data.Store({
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
		{name : 'offPzjgmc',type : 'string'},
		{name : 'offPzwh',type : 'string'},
		{name : 'offReason',type : 'string'},	
		{name : 'offNote',type : 'string'},
		{name : 'dybz',type : 'string'},
		{name : 'state',type : 'string'}
	])
});

var btn_search_orgPrtZxd = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchOrgPrtZxd();
		btn_print_orgPrtZxd.setDisabled(true);
		//btn_print_orgPrtZxd_code.setDisabled(true);
	}
});

var btn_refresh_orgPrtZxd = new Ext.Button({
	text : '刷新',
	iconCls : 'icon-refresh',
	handler : function() {
		textSearchOrgPrtZxdid.value='';
		searchOrgPrtZxd();
		btn_print_orgPrtZxd.setDisabled(true);
		//btn_print_orgPrtZxd_code.setDisabled(true);
	}
});


var text_search_orgPrtZxd = new Ext.form.TextField({
	id:'textSearchOrgPrtZxdid',
	name : 'textSearchOrgPrtZxd',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchOrgPrtZxd();
			}
		}
	}
});

//加载右栏主页面   （数据列表、工具栏按钮）
var grid_OrgPrtZxd = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	//autoHeight : true,
	cm : cm_orgPrtZxd,
	ds : ds_orgPrtZxd,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'address',
	viewConfig : {forceFit : true},
	plugins : expander_orgPrtZxd,
	tbar : [btn_refresh_orgPrtZxd,btn_print_orgPrtZxd,'->', text_search_orgPrtZxd,btn_search_orgPrtZxd],
	bbar : new Ext.PagingToolbar({
		pageSize : useFullPageSize,
		store : ds_orgPrtZxd,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			//btn_do_orgnew.setDisabled(false);
			//btn_print_orgPrtZxd_code.setDisabled(grid.getStore().getAt(rowIndex).data.state == 2 ? false:true);
			if(grid.getStore().getAt(rowIndex).data.state == 6 ||grid.getStore().getAt(rowIndex).data.state == 16 ||grid.getStore().getAt(rowIndex).data.state == 24)
			{
				btn_print_orgPrtZxd.setDisabled(false);
				//btn_do_orgnew.setDisabled(true);
			}
			btn_print_orgPrtZxd.setDisabled(false);
		}
	}
});


var zzOrgPrtZxd_panel = new Ext.Panel({
	title : '注销单打印',
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
	    items : [grid_OrgPrtZxd]
	}]
});

var p_zzOrgPrtZxd = {
	id : 'zzOrgPrtZxd-panel',
	border : false,
	layout : 'border',
	items : [zzOrgPrtZxd_panel]
}