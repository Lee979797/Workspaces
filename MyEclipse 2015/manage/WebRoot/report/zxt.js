/* 说明: JS和VML画曲线图
 */
function VMLCurve(objDiv,objWidth,objHeight){    
    this.objDiv = objDiv;                // obj
    this.toolTips    = "";                // 提示信息
    this.configXPerValue = 0;
    this.configYPerValue = 0;
    this.configXMinValue = 0;
    this.configYMinValue = 0;     
    this.OriginXValue = 0;                // 圆点坐标
    this.OriginYValue = 0;
    
    //定义区域参数
    this.group                = null;        // v:group
    this.n                     = 1            // 倍数
    this.gpWidth            = objWidth;        // Width
    this.gpHeight            = objHeight;        // Height    
    this.configXTextLeft    = -10;        // 定义 X轴坐标值左边离坐标距离
    this.configXTextTop     = 10;        // 定义 X轴坐标值上方离X轴的距离    
    this.configYLeft         = 60;        // 定义 Y轴距对象左边的距离
    this.configYTextRight    = 40;        // 定义 Y轴坐标值离Y轴右边的距离
    this.configYTextBottom     = 5;        // 定义 Y轴坐标值离坐标下边距离
    
    //X轴值
    this.configXValue = new Array('一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月');
    //Y轴值
    this.configYValue = new Array('100','200','300','400','500','600','700','800','900','1000');
    
    // Init BackGround
    this.Background        = null;    
    this.bgColor        = "#C4E1FF";        // BackGround Color
    
    // Init ToolTip
    this.configToolLeft             = 15;
    this.configToolTop                = 15;
    
    
    //设置点线的属性
    this.PointRadius = 5;                     //圆点的半径大小
    this.LineSize    = 2;                      //线的大小
    this.PointColor  = "#FF6600";            //点的颜色
    this.LineColor   = "#FF6600";            //线的颜色    
    this.Points = "";
    this.PreviousPointY = 0;
    this.PointsYCount   = 0;
 }

// Init
VMLCurve.prototype.init = function(strObj,strTitle){
    
    this.gpcX            = this.gpWidth/this.n;            // coordsize X
    this.gpcY            = this.gpHeight/this.n;            // coordsize Y    
    this.configXLen          = this.gpWidth - this.configYLeft*2+20;    // 定义 X轴长度
    this.configYLen          = this.gpHeight- 100;            // 定义 Y 轴长度
    this.configXNum        = this.configXValue.length;        // X轴刻度数
    this.configYNum        = this.configYValue.length;        // Y轴刻度数    
    this.configXTop        = this.configYLen+20;            //定义 X轴距对象上边的距离    
    this.configXPerLen    = str2Float((this.configXLen-20)/this.configXNum,2); //定义 X轴每刻度长度
    this.configYPerLen    = str2Float((this.configYLen-20)/this.configYNum,2); //定义 Y轴每刻度长度

    
    //初始化背景参数
    this.bgWidth        = this.gpWidth;        // Height
    this.bgHeight        = this.gpHeight;    // Width    
    if(this.configYPerValue!=0){ 
        var tempArr = new Array(this.configYNum);
        for(var i=0;i<this.configYNum;i++){
            tempArr[i] = str2Float(this.configYMinValue+this.configYPerValue*i,2);
        }
        this.configYValue = tempArr; 
    }
    else {
        this.configYPerValue = str2Float((this.configYValue(this.configYNum)-this.configYMinValue)/this.configYNum,2); 
    } 
    
   if(this.configXPerValue!=0){ 
        var tempArr = new Array(this.configXNum);
        for(var i=0;i<this.configXNum;i++){
            tempArr[i] = str2Float(this.configXMinValue+this.configXPerValue*i,2);
        }
        this.configXValue = tempArr;  
    }else{
         //this.configXPerValue = str2Float((this.configXValue(this.configXNum)-this.configXMinValue)/this.configXNum,2); 
    } 
    
    this.configYValue  = this.configYValue.reverse();    //倒序数组 
    this.createGroup();
    this.createBackgroud();
    this.createCoordinate();
    this.createXTableLine();
    this.createYTableLine();
    this.setTitle(strTitle);
    this.strObj = strObj;
}

//建立画图区域
VMLCurve.prototype.createGroup = function() {
    this.group = document.createElement("<v:group ID=\"group1\" coordsize=\""+this.gpcX+","+this.gpcY+"\" style=\"z-index:-10;width:"+this.gpWidth+"px;height:"+this.gpHeight+"px\">");
    this.objDiv.insertBefore(this.group);
}

//填充背景
VMLCurve.prototype.createBackgroud = function() {
    this.Background = document.createElement("<v:rect fillcolor=\"white\" strokecolor=\"black\" style=\"z-index:-8;width:"+this.bgWidth+"px;height:"+this.bgHeight+"px\" />");
    this.Background.insertBefore(document.createElement("<v:fill rotate=\"t\" type=\"gradient\" color2=\""+this.bgColor+"\" />"));
    this.Background.insertBefore(document.createElement("<v:shadow on=\"t\" type=\"single\" color=\"silver\" offset=\"3pt,3pt\" />"));
    this.group.insertBefore(this.Background);
}

//建立坐标轴
VMLCurve.prototype.createCoordinate = function() {
    var pointX1 = this.configYLeft + "," + this.configXTop;
    var pointX2 = this.configYLeft+this.configXLen + "," + this.configXTop;
    var pointY1 = pointX1;
    var pointY2 = this.configYLeft + "," + eval(this.configXTop-this.configYLen);
    this.createCoordinateLine(pointY1,pointX2);
    this.createCoordinateLine(pointY1,pointY2);
    this.setOriginValue(this.OriginXValue,this.OriginYValue);
}

//建立坐标线
VMLCurve.prototype.createTableLine = function(xPoint,yPoint,sTableColor){
    var tempLine = document.createElement("<v:line from=\""+xPoint+"\" to=\""+yPoint+"\" strokeColor=\""+sTableColor+"\" style=\"Z-INDEX:8;POSITION:absolute;/>");
    this.group.insertBefore(tempLine);
    tempLine.insertBefore(document.createElement("<v:stroke dashstyle=\"Solid\" />"));
}

//画坐标轴线
VMLCurve.prototype.createCoordinateLine = function(xPoint,yPoint){
    var tempLine = document.createElement("<v:line from=\""+xPoint+"\" to=\""+yPoint+"\" strokeColor=\"#FF6600\" strokeweight=\"1px\" style=\"Z-INDEX:8;POSITION:absolute;\"/>");
    this.group.insertBefore(tempLine);
    tempLine.insertBefore(document.createElement("<v:stroke  EndArrow=\"classic\" />"));
}

//创建文本提示信息
VMLCurve.prototype.createText = function(xLeft,xTop,sText,sClass) {
    var tempObj = document.createElement("<P class=\""+sClass+"\" style=\"Z-INDEX:8;LEFT:"+xLeft+"px;POSITION:absolute;TOP:"+xTop+"px;\"/>");
    tempObj.innerHTML = sText;
    this.group.insertBefore(tempObj);
}

// 创建X坐标网格线
VMLCurve.prototype.createXTableLine = function(){
    var x1,y1,x2,y2,point1,point2,sTableColor;
    sTableColor = "#CCCCCC";
    for(var i=0;i<this.configXValue.length;i++){
        x1 = eval(this.configYLeft + this.configXPerLen*(i+1));
        y1 = eval(this.configXTop-this.configYLen)+10;
        x2 = x1;
        y2 = eval(this.configXTop+5);
        point1 = x1 + "," + y1; 
        point2 = x2 + "," + y2;
        this.createTableLine(point1,point2,sTableColor);
        this.createText(x1+this.configXTextLeft,this.configXTop+this.configXTextTop,this.configXValue[i],"pBlack");
    }
}

//创建Y轴坐标网格线
VMLCurve.prototype.createYTableLine = function(){
    var x1,y1,x2,y2,point1,point2,sTableColor;
    for(var i=0;i<this.configYValue.length;i++){
        x1 = eval(this.configYLeft - 5);
        y1 = eval(this.configXTop - this.configYPerLen*(i+1));
        x2 = eval(this.configYLeft + this.configXLen - 10);
        y2 = y1;
        point1 = x1 + "," + y1; 
        point2 = x2 + "," + y2;
        if(this.configYValue[this.configYValue.length-i-1]=="C2") sTableColor="#FF9900";
        else sTableColor = "#CCCCCC";
        this.createTableLine(point1,point2,sTableColor);
        this.createText(this.configYLeft-this.configYTextRight,y1-this.configYTextBottom,this.configYValue[this.configYValue.length-i-1],"pBlack");
    }
}

//设置标题
VMLCurve.prototype.setTitle = function(strTitle){
    var tempObj = document.createElement("<div class=\"Title\" style=\"POSITION:absolute;Z-INDEX:9;LEFT:"+40+"px;TOP:"+(this.configXTop+40)+"px;width:"+(this.configXLen)+"px;height:"+(this.gpHeight-this.configXTop-20)+";/>");
    tempObj.innerHTML = strTitle;
    this.group.insertBefore(tempObj);
}

// 画圆点坐标
VMLCurve.prototype.setOriginValue = function(x,y){
    this.createText(this.configYLeft+this.configXTextLeft,this.configXTop+this.configXTextTop,x,"pBlack");
    this.createText(this.configYLeft-this.configYTextRight,this.configXTop-this.configYTextBottom,y,"pBlack");
}

// 设置圆点坐标属性
VMLCurve.prototype.setPointsProp = function(sPointRadius,sLineSize,sPointColor,sLineColor){
    PointRadius = sPointRadius;         //圆点的半径大小
    LineSize    = sLineSize;              //线的大小
    PointColor  = sPointColor;            //点的颜色
    LineColor   = sLineColor;            //线的颜色
}

// 设置纵坐标的值
VMLCurve.prototype.setPointsValue = function(xValueArr,yValueArr){
    var sValue  = "";
    var xValue  = 0;
    var yValue  = 0;
    var tempLen = 0;
    var thisX   = 0; 
    var thisY   = 0; 
    var tempX   = 0;
    var tempY   = 0; 
    for(var i=0;i<xValueArr.length;i++){
        thisX   = str2Float(xValueArr[i],2); 
        thisY   = str2Float(yValueArr[i],2); 
        //tempX   = str2Float((thisX - this.OriginXValue)/this.configXPerValue,2);
        tempY   = str2Float((thisY - this.OriginYValue)/this.configYPerValue,2);
        xValue  = str2Float(this.configYLeft + str2Float(thisX*this.configXPerLen,2),2);
        yValue  = str2Float(this.configXTop - str2Float(tempY*this.configYPerLen,2),2);
        //sValue  += "<br>坐标值[X,Y]:[" + xValue + "," + yValue + "]";
        //sValue  += "<br>实际值[X,Y]:[" + thisX + "," + thisY + "]";
        //this.PointsYCount  += str2Float(yValueArr[i],2);
        //this.PreviousPointY = yValueArr[i];        
        this.Points = this.Points + xValue + "," + yValue + " ";    
        this.createPoint(xValue,yValue,thisX,thisY);
    }
    this.createCurveLine();
    this.PreviousPointY = 0;
    this.Points         = 0;
    this.PointsYCount   = 0;
}

// create Point
VMLCurve.prototype.createPoint = function(sLeft,sTop,thisX,thisY){
    //根据圆点的坐标,得到左上方点的坐标
    var xLeft  = sLeft - this.PointRadius;
    var xTop   = sTop  - this.PointRadius;
    var tempOval = document.createElement("<v:oval style=\"POSITION:absolute;Z-INDEX:12;LEFT:"+xLeft+"px;TOP:"+xTop+"px;width:"+2*this.PointRadius+";height:"+2*this.PointRadius+";cursor:hand;\" stroked=\"f\" fillcolor=\""+this.PointColor+"\" strokeweight=\"1px\" onmouseover=\"showBzjgDateReport("+xLeft+','+xTop+','+thisX+','+thisY+");\" onmouseout=\"hideBzjgDateReport();\"/>");
    group1.insertBefore(tempOval);
}

//以两点为坐标画线
VMLCurve.prototype.createCurveLine = function(){
    var tempLine = document.createElement("<v:PolyLine Points=\""+ this.Points +"\" style=\"Z-INDEX:11;POSITION:absolute;\" strokeweight=\"2px\" filled=\"f\" />");
    var newStroke = document.createElement("<v:stroke dashstyle='solid' color='"+this.LineColor+"'/>");
    group1.insertBefore(tempLine);
    tempLine.insertBefore(newStroke);
}

/*********************************
* 字符串转换为数字(""-->0)as_type--str,num
* 参数说明:
as_str--转换的字符串
ai_digit--转换的小数位数(null--不限制小数位数,0--转换为整型,>0按小数位数转换)
as_type--转换后返回的类型(null,"num"--转换为数字类型,"str"--转换为字符串
(按小数格式化后的字符串)
* 例如:
* str2float("10.2124568795")返回float类型10.2124568795
* str2float("10.6",0)返回Int类型11(使用四舍五入的方法)
* str2float("10.2",2)返回float类型10.1
* str2float("10.2",2,"str")返回String类型"10.20"(按小数位数格式化字符串)
* str2float("10.216",2)返回float类型10.22
* str2float("10.216",2,"str")返回String类型"10.22"
*********************************
*/
function str2Float(as_str,ai_digit,as_type)
{
   var fdb_tmp = 0;
   var fi_digit = 0;
   var fs_digit = "1";
   var fs_str = "" + as_str;
   var fs_tmp1 = "";
   var fs_tmp2 = "";
   var fi_pos = 0;
   var fi_len = 0;
   fdb_tmp = parseFloat(isNaN(parseFloat(fs_str))?0:fs_str);
   
   switch (true)
   {
      case (ai_digit==null):       //不改变值,只转换为数字
         fdb_tmp = fdb_tmp;
         break;
      case (ai_digit==0):          //取得整数
         fdb_tmp = Math.round(fdb_tmp);
         break;
      case (ai_digit>0):            //按照传入的小数点位数四舍五入取值
         for (var i=0;i<ai_digit;i++) fs_digit +="0";
         fi_digit = parseInt(fs_digit);
         fdb_tmp = Math.round(fdb_tmp * fi_digit) / fi_digit;
         if (as_type=="str")
         {
            fs_tmp1 = fdb_tmp.toString();
            fs_tmp1 +=((fs_tmp1.indexOf(".")!=-1)?"":".") + fs_digit.substr(1);
            fi_pos = fs_tmp1.indexOf(".") + 1 + ai_digit;
            fdb_tmp = fs_tmp1.substr(0,fi_pos);
         }
        break;
   }
   return fdb_tmp;
} 

function fillstring(str) {
	if (str.length == 1) {                
		str = "0" + str;            
	}            
	return (str);        
}

function quickseldate(type,objBegintime,objEndtime) {
	var begintime, endtime;
	var oneminute = 60 * 1000;
	var onehour = 60 * oneminute;
	var oneday = 24 * onehour;
	var oneweek = 7 * oneday;
	var todayDate = new Date();
	var date = todayDate.getDate();
	var month = todayDate.getMonth() + 1;
	var year = todayDate.getYear();
	var day = todayDate.getDay();
	if (navigator.appName == "Netscape") {
		year = 1900 + year;
	}
	if (type == "day") {
		begintime = year.toString() + "-" + fillstring(month.toString()) + "-" + fillstring(date.toString());
		endtime = begintime;
	}else if (type == "week") {
		var daytoMon = day - 1;
		if (day == 0)  daytoMon = 6;
		todayDate.setTime(todayDate.getTime() - daytoMon * oneday);
		date = todayDate.getDate();
		month = todayDate.getMonth() + 1;
		year = todayDate.getYear();
		day = todayDate.getDay();
		begintime = year.toString() + "-" + fillstring(month.toString()) + "-" + fillstring(date.toString());
		todayDate.setTime(todayDate.getTime() + 6 * oneday);
		date = todayDate.getDate();
		month = todayDate.getMonth() + 1;
		year = todayDate.getYear();
		endtime = year.toString() + "-" + fillstring(month.toString()) + "-" + fillstring(date.toString());
	}else if (type == "month") {
		var dateto1 = date - 1;
		todayDate.setTime(todayDate.getTime() - dateto1 * oneday);
		date = todayDate.getDate();
		month = todayDate.getMonth() + 1;
		year = todayDate.getYear();
		day = todayDate.getDay();
		begintime = year.toString() + "-" + fillstring(month.toString()) + "-" + fillstring(date.toString());
		todayDate.setMonth(month);
		todayDate.setTime(todayDate.getTime() - oneday);
		date = todayDate.getDate();
		month = todayDate.getMonth() + 1; 
		year = todayDate.getYear();        
		endtime = year.toString() + "-" + fillstring(month.toString()) + "-" + fillstring(date.toString());         
	}else if (type == "year") {
		year = todayDate.getYear();
		begintime = year.toString() + '-01-01';     
		endtime = year.toString() + '-12-31';         
	}
	objBegintime.setValue(begintime);
   	objEndtime.setValue(endtime);       
} 
 