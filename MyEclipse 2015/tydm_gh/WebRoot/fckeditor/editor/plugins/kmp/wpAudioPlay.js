/*********************************************************************************************************/
/**
 * FCKeditor Flash MP3 Player (AudioPlayer) Plugin For Fckeditor (Support: Lajox ; Email: lajox@19www.com)
 */
/*********************************************************************************************************/

var dialog	= window.parent ;
var oEditor    = window.parent.InnerDialogLoaded(); 
var FCK        = oEditor.FCK; 
var FCKLang    = oEditor.FCKLang ;
var FCKConfig  = oEditor.FCKConfig ;

/*****选项卡 begin****/
// Set the dialog tabs.
dialog.AddTab( 'Info', oEditor.FCKLang.DlgInfoTab ) ;

//if ( !FCKConfig.MediaDlgHideAdvanced )
dialog.AddTab( 'Advanced', oEditor.FCKLang.DlgAdvancedTag ) ;

// Function called when a dialog tag is selected.
function OnDialogTabChange( tabCode )
{
	ShowE('divInfo'		, ( tabCode == 'Info' ) ) ;
	ShowE('divAdvanced'	, ( tabCode == 'Advanced' ) ) ;
}

/*****选项卡 end****/

window.onload = function()
{
	oEditor.FCKLanguageManager.TranslatePage(document) ;
	window.parent.SetOkButton( true ) ;
	loadKMPSelection();

}

function loadKMPSelection() {
	// Show/Hide according to settings
	ShowE('spanBrowse', FCKConfig.LinkBrowser);
}

/** Browse/upload a file on server */
function BrowseServer() {
 OpenFileBrowser( FCKConfig.MediaBrowserURL, FCKConfig.MediaBrowserWindowWidth, FCKConfig.MediaBrowserWindowHeight ) ;
}



function makeRandomNum(){//根据时间生成数字串 月2+日2+时2+分2+秒2
	var nowDate=new Date();
	var theNum;
	theNum=(nowDate.getMonth()+1).toString()+nowDate.getDate().toString()+nowDate.getHours().toString()+nowDate.getMinutes().toString()+nowDate.getSeconds().toString();
	return  theNum;
}
function Ok()
{	
	var sMp3Url = GetE('txtUrl').value;
	var sAutioPlay="";
	
	var sAutoStart = GetE('autoStart').checked; 
	if (sAutoStart==true){
		sAutoStart="autostart=yes&amp;"
	}
	else{
		sAutoStart="autostart=no&amp;";
	}
	
	var sLoop = GetE('loop').checked;
	if (sLoop==true){
		sLoop="loop=yes&amp;";	
	}
	else{
		sLoop="loop=no&amp;";
	}
	
	var alwayOpen= GetE('alwayOpen').checked;
	if (alwayOpen==true){
		alwayOpen="animation=no&amp;";
	}
	else{
		alwayOpen="animation=yes&amp;";
	}
	//处理title和Artist信息
	var musicTitles,musicArtists;
	musicTitles="";
	musicArtists="";

	if (GetE('musicTitle').value!=""){
		musicTitles="titles="+GetE('musicTitle').value+"&amp;";
	}
	if (GetE('musicArtist').value!=""){
		musicArtists="artists="+GetE('musicArtist').value+"&amp;";
	}
	
	//处理播放器宽度和高度信息
	var PlayerWidth,PlayerHeight;
	PlayerWidth="290";
	PlayerHeight="24";

	if (GetE('PlayerWidth').value!=""){
		PlayerWidth = GetE('PlayerWidth').value;
	}
	if (GetE('PlayerHeight').value!=""){
		PlayerHeight = GetE('PlayerHeight').value;
	}

//处理高级选项信息
 var AdvanceControl;
 var bg,leftbg,lefticon,rightbg,rightbghover,righticon,righticonhover,text,slider,track,border,loader;
	bg 		= "bg=0xCDDFF3&amp;";
	leftbg 		= "leftbg=0x357DCE&amp;";
	lefticon	= "lefticon=0xF2F2F2&amp;";
	rightbg		= "rightbg=0xF06A51&amp;";
	rightbghover 	= "rightbghover=0xAF2910&amp;";
	righticon	= "righticon=0xF2F2F2&amp;";
	righticonhover	= "righticonhover=0xFFFFFF&amp;";
	text		= "text=0x357DCE&amp;";
	slider		= "slider=0x357DCE&amp;";
	track		= "track=0xFFFFFF&amp;";
	border		= "border=0xFFFFFF&amp;";
	loader		= "loader=0xAF2910&amp;";

//AdvanceControl = "bg=0xCDDFF3&amp;leftbg=0x357DCE&amp;lefticon=0xF2F2F2&amp;rightbg=0xF06A51&amp;rightbghover=0xAF2910&amp;righticon=0xF2F2F2&amp;righticonhover=0xFFFFFF&amp;text=0x357DCE&amp;slider=0x357DCE&amp;track=0xFFFFFF&amp;border=0xFFFFFF&amp;loader=0xAF2910&amp;"

	if (GetE('bg').value!=""){
		bg = GetE('bg').value;
	}
	if (GetE('bg').value!=""){ bg = "bg="+GetE('bg').value+"&amp;"; }
	if (GetE('leftbg').value!=""){ leftbg = "leftbg="+GetE('leftbg').value+"&amp;"; }
	if (GetE('lefticon').value!=""){ lefticon = "lefticon="+GetE('lefticon').value+"&amp;"; }
	if (GetE('rightbg').value!=""){ rightbg = "rightbg="+GetE('rightbg').value+"&amp;"; }
	if (GetE('rightbghover').value!=""){ rightbghover = "rightbghover="+GetE('rightbghover').value+"&amp;"; }
	if (GetE('righticon').value!=""){ righticon = "righticon="+GetE('righticon').value+"&amp;"; }
	if (GetE('righticonhover').value!=""){ righticonhover = "righticonhover="+GetE('righticonhover').value+"&amp;"; }
	if (GetE('text').value!=""){ text = "text="+GetE('text').value+"&amp;"; }
	if (GetE('slider').value!=""){ slider = "slider="+GetE('slider').value+"&amp;"; }
	if (GetE('track').value!=""){ track = "track="+GetE('track').value+"&amp;"; }
	if (GetE('border').value!=""){ border = "border="+GetE('border').value+"&amp;"; }
	if (GetE('loader').value!=""){ loader = "loader="+GetE('loader').value+"&amp;"; }

        AdvanceControl = bg+leftbg+lefticon+rightbg+rightbghover+righticon+righticonhover+text+slider+track+border+loader;


	var numTemp;
	//var Mp3PlayerPath="./fckeditor/editor/plugins/kmp/player.swf";  //Flash Mp3播放器路径
	var Mp3PlayerPath="/fckeditor/editor/plugins/kmp/player.swf";  //Flash Mp3播放器路径
	
	if( sMp3Url.length> 0) {
		numTemp=makeRandomNum(); 
sAutioPlay ="<object id=\"audioplayer"+numTemp+"\" data=\""+Mp3PlayerPath+"\" width=\""+PlayerWidth+"\" height=\""+PlayerHeight+"\"  type=\"application/x-shockwave-flash\">"+"<param value="+Mp3PlayerPath+" name=\"movie\" />"+"<param value=\"playerID="+numTemp+"&amp;"+AdvanceControl+musicTitles+musicArtists+sAutoStart+sLoop+alwayOpen+"soundFile="+sMp3Url+"\" name=\"FlashVars\" /><param value=\"high\" name=\"quality\" /><param value=\"false\" name=\"menu\" /><param value=\"transparent\" name=\"wmode\" />"+"</object>";
		
		oEditor.FCK.InsertHtml(sAutioPlay) ;
    	window.parent.Cancel() ;
	} else {
		alert("请输入正确的MP3地址。（例：http://www.163.com/popmusic.mp3）");
	}
	return true ;
}


/** Set selected URL from Browser */
function SetUrl(url) {
	GetE('txtUrl').value = url;
}
