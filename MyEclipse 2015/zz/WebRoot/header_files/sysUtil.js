
SysUtil=function SysUtil()
{
}

SysUtil.timeDiff=0;
SysUtil.lastTime=0;

/**
 * 显示日期时间。
 * @param spanID 放置时间的span的id.
 */
SysUtil.showDateTime=function(spanID)
{
  var now,year,month,day,week,hours,minutes,seconds,timeValue;
  if(SysUtil.lastTime==0)
    SysUtil.timeDiff=AppUtil.getCurSvrTime().getTime()-new Date().getTime();
  var curTime=new Date().getTime()+SysUtil.timeDiff;
  if(SysUtil.lastTime!=0 && Math.abs(curTime-SysUtil.lastTime)>10000)//客户端时间调整
  {
    SysUtil.timeDiff=AppUtil.getCurSvrTime().getTime()-new Date().getTime();
    curTime=new Date().getTime()+SysUtil.timeDiff;
  }
  SysUtil.lastTime=curTime;
  now = new Date(curTime);
  //year = now.getFullYear();
  month = now.getMonth()+1;
  day = now.getDate();
  week = now.getDay();
  hours = now.getHours();
  minutes = now.getMinutes();
  seconds = now.getSeconds();
  //timeValue = year+"年";//firefox1.0中显示105年
  timeValue = month+"月";
  timeValue += day+"日";  
  var x = new Array("星期日", "星期一", "星期二", "星期三","星期四", "星期五", "星期六");
  timeValue += " "+x[week];
  timeValue += " "+hours;
  timeValue += ((minutes < 10) ? ":0" : ":") + minutes;
  timeValue += ((seconds < 10) ? ":0" : ":") + seconds;
  var clock=PubUtil.findObj(spanID);
  if(clock)
  {
    clock.innerHTML = timeValue;//innerText在firefox及netscape中不支持
  }
  setTimeout("SysUtil.showDateTime('"+spanID+"')",1000);
}