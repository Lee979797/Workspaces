function saveAsHtml_bzjgDateReport_func(){
	var hd3= bzjgDateReportFormPanel.getForm().findField("handleDate1").getValue().format('Y-m-d');
	var hd4 = bzjgDateReportFormPanel.getForm().findField("handleDate2").getValue().format('Y-m-d');
	var fileName='办证机构业务量统计图('+hd3+'至'+hd4+')';
	saveAsHtml(fileName);
}


var menu = new Ext.menu.Menu();
	menu.add({id: 'menu1_report',text:'放大',handler:function(){},iconCls:'icon-zoom'});
	menu.add({id: 'menu2_report',text:'缩小',handler:function(){},iconCls:'icon-out'});
	menu.add({id: 'menu3_report',text:'原大',handler:function(){},iconCls:'icon-in'});
	menu.add('-');
	menu.add({id: 'menu4_report',text:'清除',handler:function(){saveAsHtml_bzjgDateReport_func();},iconCls:'icon-save2'});
	menu.add({id: 'menu5_report',text:'另存',handler:function(){saveAsHtml_bzjgDateReport_func();},iconCls:'icon-save2'});
    
function showMenus(el){
	menu.show(el);
}

var btn_riqi_bzjgDateReport_menu = new Ext.Toolbar.MenuButton({
    text: '当天',
    tooltip: {title:'提示',text:'统计办证机构业务量'},
    iconCls: 'blist',
    menu : {items: [
                 {text: '当天', handler:function(){
						quickseldate('day',Ext.getCmp("handleDate1_zxt"),Ext.getCmp("handleDate2_zxt"));
						btn_riqi_bzjgDateReport_menu.setText('当天');
					}
				},{text: '本周', handler:function(){
						quickseldate('week',Ext.getCmp("handleDate1_zxt"),Ext.getCmp("handleDate2_zxt"));
						btn_riqi_bzjgDateReport_menu.setText('本周');
					}
				},
                {text: '本月份', handler:function(){
						quickseldate('month',Ext.getCmp("handleDate1_zxt"),Ext.getCmp("handleDate2_zxt"));
						btn_riqi_bzjgDateReport_menu.setText('本月份');
					}
				},
                {text: '本年度', handler:function(){
						quickseldate('year',Ext.getCmp("handleDate1_zxt"),Ext.getCmp("handleDate2_zxt"));
						btn_riqi_bzjgDateReport_menu.setText('本年度');
					}
				}
        ]}
});


var btn_saveAsHtml_bzjgDateReport = new Ext.Button({
	text : '另存',
	iconCls : 'icon-save2',
	bodyStyle: 'padding-left:10px',
	//minWidth : 70,
	handler : function(){
		saveAsHtml_bzjgDateReport_func();
	}
});

var btn_remove_bzjgDateReport = new Ext.Button({
	text : '重置',
	iconCls : 'icon-del4',
	bodyStyle: 'padding-left:10px',
	//minWidth : 70,
	handler : function(){
		bzjgDateReportFormPanel.getForm().reset();
		var objdiv2 = document.getElementById('curve');
		if(objdiv2.hasChildNodes()){
			objdiv2.removeChild(objdiv2.childNodes[0]);
		}
		objdiv2.innerHTML ='<font size="7" color="#e5e5e5"><b>统计图显示区<b></font>';
		var objectTitle2='办证机构业务量统计图';
		Ext.getCmp('zbdr_zxt').setTitle(objectTitle2);
		btn_riqi_bzjgDateReport_menu.setText('当天');
		parent.zzBzjgDateReport.location='reportTemp.htm';  
	}
});

var btn_s_bzjgDateReport = new Ext.Button({
	text : '查询',
	iconCls : 'icon-chaxun',
	bodyStyle: 'padding-left:10px',
	//minWidth : 70,
	handler : function(){
		if (bzjgDateReportFormPanel.getForm().isValid()) {
			var hd0= bzjgDateReportFormPanel.getForm().findField("handleDate1").getValue().format('Y-m-d');
			var hd1 =bzjgDateReportFormPanel.getForm().findField("handleDate1").getValue().format('Y-m-d H:i:s');
			var hd2 = bzjgDateReportFormPanel.getForm().findField("handleDate2").getValue().format('Y-m-d');
			
			if(hd0>hd2){
				alert("开始日期不能大于结束日期！");
			}else{
				ajaxLoadMask.show();
				Ext.Ajax.request({
					url : 'findByHandleDate.action',
					params : {handleDate1:hd1,handleDate2:hd2},
					method :'post', 
					waitTitle : '提示',
				    waitMsg : '请求正在发送中，请稍后',
					success : function(result,request) {//获取返回值
						ajaxLoadMask .hide();
					    eval("var data = "+ result.responseText);
					    if(data.length!=0){
					    	var objectTitle='办证机构业务量统计图('+hd0+'至'+hd2+')';
					    	Ext.getCmp('zbdr_zxt').setTitle(objectTitle);
							
						    var arr_bzjgdm = [];//
						    var arr_bzjgmc = [];
						    var arr_bzjgjc = [];
						    var arr_num = [];//
						    var arr_x = [];//
						    var arr_y = [];
						    for(var i=0;i<data.length;i++){
						    	var a = i;
						    	arr_bzjgdm.push(data[i].bzjgdm);
						    	arr_bzjgmc.push(data[i].bzjgmc);
						    	arr_bzjgjc.push(data[i].bzjgjc);
						    	arr_num.push(data[i].num);
						    	arr_x.push(a+1);
						    }
						    //根据数量生成 Y 轴数组
						    var num_max = arr_num[0];
							for(var i = 1;i < arr_num.length;i++){
								if(num_max < arr_num[i])
									num_max = arr_num[i];
							}
							//2
							var a = num_max/10;//0.2
							var b = num_max%10;//2
							var c;
							if(b!=0){
								c = Math.round(a);//0
								if(c<a){
									c = c+1;
								}
							}else{
								c = b;
							}
							for(var i = 1;i <= 10;i++){
								arr_y.push(c*i);
							}
							//以下代码为生成折线图的代码
							var objdiv = document.getElementById('curve');
							if(objdiv.hasChildNodes()){
								objdiv.removeChild(objdiv.childNodes[0]);
							}
							var objWidth=Ext.getCmp('zbdr_zxt').getInnerWidth()-80;
							var objHeight=Ext.getCmp('zbdr_zxt').getInnerHeight()-50;
							//alert(objWidth);
							//objWidth='780';
							//var objHeight='400';
							searchBzjgDateReport(objdiv,objectTitle,arr_bzjgdm,arr_bzjgmc,arr_bzjgjc,arr_num,arr_x,arr_y,objWidth,objHeight);
					    }else{
					    	var objdiv3 = document.getElementById('curve');
							if(objdiv3.hasChildNodes()){
								objdiv3.removeChild(objdiv3.childNodes[0]);
							}
							objdiv3.innerHTML ='<font size="6" color="#e5e5e5">统计图显示区</font>';
							var objectTitle3='办证机构业务量统计图';
							Ext.getCmp('zbdr_zxt').setTitle(objectTitle3);
					    	Ext.Msg.show({
								title : '提示',
								msg : '此时间段内未办理业务！',
								buttons : Ext.Msg.OK,
								icon : Ext.Msg.INFO
							});
					    }
					},
					failure : function(){
						ajaxLoadMask .hide();
						Ext.Msg.show({
							title : '提示',
							msg : '生成统计图失败！',
							buttons : Ext.Msg.OK,
							icon : Ext.Msg.INFO
						});
					}
				});
				
			}
		}	
	}
});

var bzjgDateReportFormPanel = new Ext.FormPanel({
    bodyStyle:'padding:0px',
	labelWidth : 100,
	labelAlign : 'right',
	height : 45,
	border : false,
	baseCls : 'x-plain',
	waitMsgTarget: true,
	//autoScroll : true,
	layout: 'fit',
	items:[{
		layout:'column',
        border:false,
        //autoScroll : true,
        baseCls : 'x-plain',
        bodyStyle:'padding:10px',
        items:[{
        	columnWidth:.25,
            layout: 'form',
            bodyStyle: 'padding:0px',
            border:false,
            items: [
            	new Ext.form.DateField({  
				    id:'handleDate1_zxt',
				    name: 'handleDate1',
				    format:'Y-m-d',
				    maxValue:myDate,  
				    maxText:'所选日期应在{0}之前',  
				    minValue:'01/01/1949',
				    minText:'所选日期应在{0}之后',
				    anchor:'100%',
				    labelSeparator:'',
				    fieldLabel:'办理日期自',
				    allowBlank : false,
				    renderer:dateFormat,
				    altFormats :'m/d/Y|m-d-y|m-d-Y|m/d|m-d|d|Ymd',
				    value:myDate
				})
			]
        },{
        	columnWidth:.25,
            layout: 'form',
            bodyStyle: 'padding:0px',
            border:false,
            items: [
            	new Ext.form.DateField({  
				    id:'handleDate2_zxt',
				    name: 'handleDate2',
				    format:'Y-m-d',
				    //maxValue:myDate,  
				    //maxText:'所选日期应在{0}之前',  
				    minValue:'01/01/1949',
				    minText:'所选日期应在{0}之后',
				    anchor:'100%',
				    labelSeparator:'',
				    fieldLabel:'至&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
				    allowBlank : false,
				    renderer:dateFormat,
				    altFormats :'m/d/Y|m-d-y|m-d-Y|m/d|m-d|d|Ymd',
				    value:myDate,
				    dateRange:{begin:'handleDate1_zxt',end:'handleDate2_zxt'},//用于vtype类型dateRange   
            		vtype:'dateRange'
				})
			]
        },{
        	columnWidth:.12,
            layout: 'form',
            bodyStyle: 'padding-left:5px',
            labelAlign : 'center',
            border:false,
            items: [btn_riqi_bzjgDateReport_menu]  
        },{
        	columnWidth:.10,
            layout: 'form',
            //bodyStyle: 'padding-left:10px',
            labelAlign : 'center',
            border:false,
            items: [btn_s_bzjgDateReport]
        },{
        	columnWidth:.10,
            layout: 'form',
            //bodyStyle: 'padding:5px',
            align : 'center',
            border:false,
            items: [btn_remove_bzjgDateReport]
        },{
        	columnWidth:.10,
            layout: 'form',
            //bodyStyle: 'padding:5px',
            align : 'center',
            border:false,
            items: [btn_saveAsHtml_bzjgDateReport]
        }]
	}]
	
});
var arrmc;
var arrdm;
var mouseX; var mouseY;

function showBzjgDateReport (xLeft,xTop,thisX,thisY){
	mouseX = xLeft+10;
 	mouseY = xTop-20;
 	var infoDiv = document.getElementById('infoDiv');
	infoDiv.innerHTML = bzjgDateReportFormPanel.getForm().findField("handleDate1").getValue().format('Y-m-d')+" 至 "
				+bzjgDateReportFormPanel.getForm().findField("handleDate2").getValue().format('Y-m-d')+" :"
				+"<br/>"+arrmc[thisX-1]+'('+arrdm[thisX-1]+'), 业务数量：'+thisY+' ';
	infoDiv.style.left = mouseX;
	infoDiv.style.top = mouseY;
	infoDiv.style.display = "block";
}
function hideBzjgDateReport(){
	var infoDiv = document.getElementById('infoDiv');
	infoDiv.style.display = "none";
}

function saveAsHtml(fileName){
	parent.zzBzjgDateReport.location='reportTemp.htm';  
	//var zzBzjgDateReport=open.location('','','height=10, width=10,top=10000,left=10000,toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no');  
	zzBzjgDateReport.document.write('<html><head>'); 
	zzBzjgDateReport.document.write('<title>'+fileName+'</title>'); 
	zzBzjgDateReport.document.write(' <STYLE> v//:* { BEHAVIOR: url(#default#VML) } </STYLE>');
	zzBzjgDateReport.document.write('<script type="text/javascript" src="http://127.0.0.1:6789/manage/report/zxt.js"></script>');
	zzBzjgDateReport.document.write('<link rel="stylesheet" type="text/css" href="http://127.0.0.1:6789/manage/report/zxtCss.css">');
	zzBzjgDateReport.document.write('</head>'); 
	zzBzjgDateReport.document.write('<body><center><br><br><br>');  
	zzBzjgDateReport.document.write(document.getElementById("curve").innerHTML);
	zzBzjgDateReport.document.write('</center></body></html>');  
	zzBzjgDateReport.document.execCommand('SaveAs','',fileName+'.htm');
	//zzBzjgDateReport.document.execCommand('Print');  //打印
}  

function searchBzjgDateReport(objdiv,objectTitle,arr_bzjgdm,arr_bzjgmc,arr_bzjgjc,arr_num,arr_x,arr_y,objWidth,objHeight){
	//建立曲线对象
    //var vc = new VMLCurve(document.getElementById('curve'));   
    var vc = new VMLCurve(objdiv,objWidth,objHeight); 
    
    arrmc = arr_bzjgmc; 
    arrdm = arr_bzjgdm; 
    //设置X坐标值，从左至右
    //vc.configXValue = arr_bzjgdm;
    vc.configXValue = arr_bzjgjc;
    //设置Y坐标值，从左至右
    vc.configYValue = arr_y;
    //设置Y坐标轴
    vc.configYPerValue = arr_y[0];
    vc.configYMinValue = arr_y[0];
    vc.init("vc",objectTitle);
    //用数组设置点的横纵标值及提示信息
    var xValueArr = arr_x;      //X轴数据
    var yValueArr = arr_num;    //Y轴数据
    //设置圆点的属性
    vc.setPointsProp(5,1,'#FF6600','#FF6600');
    vc.setPointsValue(xValueArr,yValueArr);
}

var zzBzjgDateViewReport_panel = new Ext.Panel({
	id:'zbdr_zxt',
	    region : 'center',
	    layout :'border',
		title : '办证机构业务量统计图',
		iconCls : 'icon-chart', 
		//autoScroll : true,
		//collapsible: true,
	    //split: true,
	    margins : '3 0 0 0',
	    cmargins : '5 0 0 0',
	    items:[{
	    	region : 'center',
	    	layout :'fit',
	    	border: false,
	    	autoScroll : true,
	    	bodyStyle:'padding-top:5px',
	    	html:'<table align="center" border="0" cellpadding="0" cellspacing="0" width="100%" height="100%">'
	    		//+'<tr><td height=20>sss</td></tr>'
				+'<tr><td height=""><div align="center" id="curve" style="overflow:scroll;"><font size="7" color="#e5e5e5"><b>统计图显示区</b></font></div></td></tr>'
				+'</table><iframe src="reportTemp.htm" name="zzBzjgDateReport" width="0" height="0" scrolling="no" frameborder="0" ></iframe>'
				+'<div id="infoDiv" style="display: none; position: absolute; width: auto; height: auto; background-color: #F1F19B;"></div>'
	    }],
	    listeners : {   
            render : function(p) {   
                p.el.on("contextmenu", function(e) {//添加事件   
                    e.stopEvent();
					menu.showAt(e.getXY());  
                })   
            }   
        }
});


var zzBzjgDateReport_panel = new Ext.Panel({
	region : 'center',
	border : false,
	iconCls : 'icon-plugin',
	//frame : true,
	//autoScroll : true,
	layout:'border',
	items: [{
	    region :'north',
	    title : '办证机构业务量统计',
	    iconCls : 'icon-plugin',
	    bodyStyle : 'padding:0px',
	    margins : '0 0 0 0',
	    cmargins : '5 5 0 0',
		layout: 'fit',
	    //autoScroll : true,
	    //tbar : [btn_s_bzjgDateReport],
	    items : [bzjgDateReportFormPanel]
	},zzBzjgDateViewReport_panel]
});
   
var p_zzBzjgDateReport = {
	id : 'zzBzjgDateReport-panel',
	border : false,
	layout : 'border',
	items : [zzBzjgDateReport_panel]
}