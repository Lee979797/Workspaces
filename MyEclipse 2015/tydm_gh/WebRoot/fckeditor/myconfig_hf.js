FCKConfig.FontNames		= '宋体;黑体;楷体_GB2312;Arial;Comic Sans MS;Courier New;Tahoma;Times New Roman;Verdana' ;
//FCKConfig.FontSizes		= 'smaller/较小;larger/较大;xx-small/极细�?x-small/细字;small/小字�?medium/中字�?large/大字�?x-large/加大�?xx-large/特大�? ;

FCKConfig.EnterMode = 'br' ;			// p | div | br
FCKConfig.ShiftEnterMode = 'p' ;	// p | div | br

FCKConfig.AutoDetectLanguage = false ;
FCKConfig.DefaultLanguage = "zh-cn" ;
FCKConfig.StartupFocus = false ;
FCKConfig.FormatSource = true ;
FCKConfig.FormatOutput = true ;

FCKConfig.LinkUpload = true ;
FCKConfig.LinkBrowser = true ;

FCKConfig.ImageBrowser = true ;

FCKConfig.Plugins.Add('simplecommands');
FCKConfig.Plugins.Add('Media','en,zh-cn');
//FCKConfig.ProtectedSource.Add( /<\#[\s\S]*?>/g);
//FCKConfig.ProtectedSource.Add( /<\/\#[\s\S]*?>/g);
//FCKConfig.ProtectedSource.Add( /<\@[\s\S]*?>/g);
//FCKConfig.ProtectedSource.Add( /<\/\@[\s\S]*?>/g);
//FCKConfig.ProtectedSource.Add( /\${[\s\S]*?}/g ) ;
FCKConfig.ProtectedSource.Add( /<\/font[\s\S]*?>/g);
//FCKConfig.Plugins.Add('attachment','zh-cn');
FCKConfig.ToolbarSets["mydefault"] = [
	['Source','FitWindow','Preview','Save'],
	['Templates','Print'],
	['Cut','Copy','Paste','PasteText','PasteWord'],
	['Undo','Redo','-','Find','Replace','-','SelectAll','RemoveFormat'],
	['Form','Checkbox','Radio','TextField','Textarea','Select','Button','ImageButton','HiddenField'],
	['Bold','Italic','Underline','StrikeThrough','-','Subscript','Superscript'],
	['OrderedList','UnorderedList','-','Outdent','Indent','Blockquote','CreateDiv'],
	['JustifyLeft','JustifyCenter','JustifyRight','JustifyFull'],
	['Link','Unlink','Anchor'],
	['Image','Flash','Media','Table','Rule','SpecialChar'],
	['StyleSimple','FontFormatSimple','FontNameSimple','FontSizeSimple'],
	['PageBreak']
];

FCKConfig.ToolbarSets["template"] = [
	['Source','FitWindow','Preview'],
	['Templates','Print'],
	['Cut','Copy','Paste','PasteText','PasteWord'],
	['Undo','Redo','-','Find','Replace','-','SelectAll','RemoveFormat','PageBreak'],
	['Form','Checkbox','Radio','TextField','Textarea','Select','Button','ImageButton','HiddenField'],
	['Bold','Italic','Underline','StrikeThrough','-','Subscript','Superscript'],
	['OrderedList','UnorderedList','-','Outdent','Indent','Blockquote','CreateDiv'],
	['JustifyLeft','JustifyCenter','JustifyRight','JustifyFull'],
	['Link','Unlink','Anchor'],
	['Image','Flash','Media','Table','Rule','SpecialChar'],
	['StyleSimple','FontFormatSimple','FontNameSimple','FontSizeSimple'],
	['TextColor','BGColor']
];
FCKConfig.ToolbarSets["showQueryResult"] = [];
FCKConfig.ToolbarSets["jeecms1"] = [
	['Source','Preview','FitWindow','-','Save','Paste','PasteText','PasteWord','-'],
	['Undo','Redo','-','Find','Replace','-','SelectAll','RemoveFormat'],
	['Bold','Italic','Underline','StrikeThrough'],
	['OrderedList','UnorderedList'],
	'/',
	['StyleSimple','FontFormatSimple','FontNameSimple','FontSizeSimple'],
	['TextColor','BGColor'],
	['Outdent','Indent','-','JustifyLeft','JustifyCenter','JustifyRight','JustifyFull'],
	['Link','Unlink','Image','Flash','SpecialChar','PageBreak']
];