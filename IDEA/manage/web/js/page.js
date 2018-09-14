//*************************************************************
// 功能描述： 生成日期内容
// 参数描述： 无
//-------------------------------------------------------------
function PageDate()
{
	currentDate = new Date()
	with (currentDate)
    {
		day=getDay()
		month=getMonth()+1
	//	strDate ='今天是:'+ getFullYear()+'-'+ month +'-'+ getDate() + ' ';
	    strDate =getFullYear()+'年'+ month +'月'+ getDate() + '日 ';
	}
	if (day==1){strWeek = '&nbsp;星期一';}
	if (day==2){strWeek = '&nbsp;星期二';}
	if (day==3){strWeek = '&nbsp;星期三';}
	if (day==4){strWeek = '&nbsp;星期四';}
	if (day==5){strWeek = '&nbsp;星期五';}
	if (day==6){strWeek = '&nbsp;星期六';}
	if (day==0){strWeek = '&nbsp;星期日';}
	document.write(strDate + strWeek);
//	document.write(strDate );
	
}
//*************************************************************
// 功能描述： 藏显示左边二级菜单
// 参数描述： e1 所控制显示表格的id值
//-------------------------------------------------------------
var leftwidth1=142;
var leftwidth2=300;

function top_menu(e1)
{
var el = document.getElementById(e1);


	if (el.style.display=='none')
	{
		el.style.display='';
		el.style.width=leftwidth1;
		imgmenu1.src="common/images/menu_min.jpg";
		imgmenu2.src="common/images/bottom_max.gif";
		imgmenu1.alt="隐藏菜单";
		imgmenu2.alt="放大菜单";
		}else{
    	el.style.display='none'
	    imgmenu1.src="common/images/menu_max.jpg";
	    imgmenu2.src="common/images/bottom_max.gif";
	    imgmenu1.alt="显示菜单";
	    imgmenu2.alt="最大化菜单";
	}
}
function bottom_menu(e1)
{
    var el = document.getElementById(e1);
//var e1;
	if (el.style.width==leftwidth1+'px'| el.style.display=='none')	
	{
		el.style.display='';
		el.style.width=leftwidth2;
		imgmenu1.src="common/images/menu_min.jpg";
		imgmenu2.src="common/images/bottom_min.gif";
		imgmenu1.alt="隐藏菜单";
	    imgmenu2.alt="缩小菜单";
		}else{
    	//el.style.display='none'
    	el.style.width=leftwidth1;
	    imgmenu2.src="common/images/bottom_max.gif";
	    imgmenu1.src="common/images/menu_min.jpg";
	    imgmenu1.alt="隐藏菜单";
	    imgmenu2.alt="放大菜单";
	    
	}
}
function leftmenu() {
var el  = document.getElementById("leftmenu");
alert(el.style.display);
	if (el.style.display=='none')
	{
		el.style.display='';
		el.style.width=leftwidth1;
		imgmenu1.src="common/images/menu_min.jpg";
		imgmenu2.src="common/images/bottom_max.gif";
		imgmenu1.alt="隐藏菜单";
		imgmenu2.alt="放大菜单";
		}else{
    	el.style.display='none'
	    imgmenu1.src="common/images/menu_max.jpg";
	    imgmenu2.src="common/images/bottom_max.gif";
	    imgmenu1.alt="显示菜单";
	    imgmenu2.alt="最大化菜单";
	}

}