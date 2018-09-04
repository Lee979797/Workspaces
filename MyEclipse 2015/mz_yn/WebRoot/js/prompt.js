var scrollerwidth=220
var scrollerheight=40
var scrollerbgcolor=''
var scrollerfontcolor="#007FAE"
var pausebetweenimages=4000//间隔的时间
var speed=90;//滚动速度

var slideimages=new Array()

//extend this list

iiii=0
function getGreetingsContent(i,strContent)
{
	//var a = new VBArray(strContent);
	//var b = a.toArray();
	//alert(strContent)
	slideimages[i]=strContent//b;
	
	if (slideimages.length>1)
	{	first2.innerHTML=slideimages[0];
		second2.innerHTML=slideimages[1];
	}
	
}
function move3(whichdiv){
	tdiv=eval(whichdiv)
	if (tdiv.style.pixelTop>0&&tdiv.style.pixelTop<=5){
	tdiv.style.pixelTop=0;
	setTimeout("move3(tdiv)",pausebetweenimages)
	setTimeout("move4(second2)",pausebetweenimages)
	return
	}
	if (tdiv.style.pixelTop>=tdiv.offsetHeight*-1){
	tdiv.style.pixelTop-=5;
	setTimeout("move3(tdiv)",speed)
	}
	else{	
	tdiv.style.pixelTop=scrollerheight
	tdiv.innerHTML=slideimages[iiii]
	if (iiii>=slideimages.length-1)	
	iiii=0;
	else	
	iiii++	
	}
}

function move4(whichdiv)
{
	tdiv2=eval(whichdiv)
	if (tdiv2.style.pixelTop>0&&tdiv2.style.pixelTop<=5){	
	tdiv2.style.pixelTop=0
	setTimeout("move4(tdiv2)",pausebetweenimages)
	setTimeout("move3(first2)",pausebetweenimages)
	return
	}
	if (tdiv2.style.pixelTop>=tdiv2.offsetHeight*-1){	
	tdiv2.style.pixelTop-=5
	setTimeout("move4(second2)",speed)
	}
	else{	
	tdiv2.style.pixelTop=scrollerheight
	tdiv2.innerHTML=slideimages[iiii]
	if (iiii>=slideimages.length-1)	
	iiii=0;
	else
	iiii++;	
	}
}
//主体函数，运行调用该函数
function startscroll(){
	slideimages[0]="";
	//getGreetingsContent();	
	move3(first2);
	second2.style.top=scrollerheight;	
}