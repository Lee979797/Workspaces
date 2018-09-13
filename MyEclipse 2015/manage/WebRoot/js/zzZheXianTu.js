   
var zxtFormPanel = new Ext.FormPanel({
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
        	columnWidth:.5,
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
        	columnWidth:.5,
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
				    fieldLabel:'至&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
				    allowBlank : false,
				    renderer:dateFormat,
				    altFormats :'m/d/Y|m-d-y|m-d-Y|m/d|m-d|d|Ymd',
				    value:myDate,
				    dateRange:{begin:'handleDate1_zxt',end:'handleDate2_zxt'},//用于vtype类型dateRange   
            		vtype:'dateRange'
				})
			]
        }]
	}]
	
});
var arr;
var mouseX; var mouseY;

function showZxt (xLeft,xTop,thisX,thisY){
	//mouseOver();
	mouseX = xLeft+10;
 	mouseY = xTop-20;
 	var infoDiv = document.getElementById('infoDiv');
	infoDiv.innerHTML = zxtFormPanel.getForm().findField("handleDate1").getValue().format('Y-m-d')+" 至 "
				+zxtFormPanel.getForm().findField("handleDate2").getValue().format('Y-m-d')+" 时间段内"
				+"<br/>"+arr[thisX-1]+' 所办业务数量：'+thisY;
	infoDiv.style.left = mouseX;
	infoDiv.style.top = mouseY;
	infoDiv.style.display = "block";
	/*Ext.Msg.show({
		title : '提示',
		closable : false, 
		modal : false,
		msg : zxtFormPanel.getForm().findField("handleDate1").getValue().format('Y-m-d')+" 至 "
				+zxtFormPanel.getForm().findField("handleDate2").getValue().format('Y-m-d')+" 时间段内"
				+"<br/>"+arr[thisX-1]+' 所办业务数量：'+thisY
	});*/
}
function hideZxt(){
	//Ext.Msg.hide();
	var infoDiv = document.getElementById('infoDiv');
	infoDiv.style.display = "none";
}

function searchZxt(objdiv,arr_bzjgdm,arr_bzjgmc,arr_num,arr_x,arr_y){
	//建立曲线对象
    //var vc = new VMLCurve(document.getElementById('curve'));   
    var vc = new VMLCurve(objdiv); 
    
    arr = arr_bzjgmc; 
    //设置X坐标值，从左至右
    vc.configXValue = arr_bzjgdm;
    //设置Y坐标值，从左至右
    vc.configYValue = arr_y;
    //设置Y坐标轴
    vc.configYPerValue = arr_y[0];
    vc.configYMinValue = arr_y[0];
    vc.init("vc","业务数量曲线图");
    //用数组设置点的横纵标值及提示信息
    var xValueArr = arr_x;      //X轴数据
    var yValueArr = arr_num;    //Y轴数据
    //设置圆点的属性
    vc.setPointsProp(5,1,'#FF6600','#FF6600');
    vc.setPointsValue(xValueArr,yValueArr);
}
var btn_s_zxt = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function(){
		
		var hd1 = zxtFormPanel.getForm().findField("handleDate1").getValue().format('Y-m-d H:i:s');
		var hd2 = zxtFormPanel.getForm().findField("handleDate2").getValue().format('Y-m-d');
		
		if(zxtFormPanel.getForm().findField("handleDate1").getValue().format('Y-m-d')>hd2){
			alert("开始日期不能大于结束日期！");
		}else{
			Ext.Ajax.request({
				url : 'findByHandleDate.action',
				params : {handleDate1:hd1,handleDate2:hd2},
				method :'post', 
				waitTitle : '提示',
			    waitMsg : '请求正在发送中，请稍后',
				success : function(result,request) {//获取返回值
				    eval("var data = "+ result.responseText);
				    if(data.length!=0){
					    var arr_bzjgdm = [];//
					    var arr_bzjgmc = [];
					    var arr_num = [];//
					    var arr_x = [];//
					    var arr_y = [];
					    for(var i=0;i<data.length;i++){
					    	var a = i;
					    	arr_bzjgdm.push(data[i].bzjgdm);
					    	arr_bzjgmc.push(data[i].bzjgmc);
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
						searchZxt(objdiv,arr_bzjgdm,arr_bzjgmc,arr_num,arr_x,arr_y);
				    }else{
				    	Ext.Msg.show({
							title : '提示',
							msg : '此时间段内未办理业务！',
							buttons : Ext.Msg.OK,
							icon : Ext.Msg.INFO
						});
				    }
				},
				failure : function(){
					Ext.Msg.show({
						title : '提示',
						msg : '生成折线图失败！',
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.INFO
					});
				}
			});
			
		}
		
	}
});

var zzZheXianTu_panel = new Ext.Panel({
	region : 'center',
	border : false,
	//frame : true,
	//autoScroll : true,
	defaults: {
	    collapsible: true,
	    split: true
	},
	layout:'border',
	items: [{
	    region :'center',
	    title : '查询条件',
	    layout : 'border',
	    bodyStyle : 'padding:0px',
	    margins : '0 0 0 0',
	    cmargins : '5 5 0 0',
		layout: 'fit',
	    autoScroll : true,
	    tbar : [btn_s_zxt],
	    items : [zxtFormPanel]
	},{
	    region : 'south',
	    layout :'fit',
		title : '折线图',
		height : 400,
		//minSize : 150,
		//maxSize:400,
		autoScroll : true,
	    items:[{
	    	region : 'center',
	    	layout :'fit',
	    	//border: false,
	    	height : 400,
	    	//autoHeight: true,
		    margins : '0 0 0 0',
	    	cmargins : '5 0 0 0',
	    	autoScroll : true,
	    	bodyStyle:'padding-top:5px',
	    	html:'<table align="center" border="0" cellpadding="0" cellspacing="0" width="100%" height="100%">'
				+'<tr><td height="20"><div align="center" id="curve" style="overflow:scroll;"></div></td></tr>'
				+'</table>'
				+'<div id="infoDiv" style="display: none; position: absolute; width: auto; height: auto; background-color: #F1F19B;"></div>'
	    }]
    }]
});
   
var p_zzZheXianTuPanel = {
	id : 'zzZheXianTu-panel',
	border : false,
	layout : 'border',
	items : [zzZheXianTu_panel]
}