//**************************************************
var treeNodeArray = new Array();//zhoupengpeng
String.prototype.sb=function(tss,te)
{
    return this.substring(tss,te)
};
String.prototype.io=function(tss)
{
    return this.indexOf(tss)
};
String.prototype.ln=function()
{
    return this.length
};
Array.prototype.ln=function()
{
    return this.length
};
var tie=0;
var ti5=0;
var tsn=0;
var tn4=0;
var tpo=0;
var tp1=0;
var tzm=0;
var tv1=0;
var tid=0;
var tam=0;
var tp2=0;
var tim=0;
var dtdo=document;
_tb();
var tdy=!(tn4||(tpo&&tv1<7));
var tuf='undefined';
var tde;
var tul=null;
var tcTimers=[];
var tt=[];
var tl1=0;
var tcm=
{
    tnd:0,_tmv:null,t1i:-1,tv:null,tba:null
};
var tmoveRec=
{
    tmo:0,ttx:0,tty:0,tom:0,_tmv:null
};
var tcb=0;
var txo=0,tyo=0;
var taddedScripts=[];
if(typeof(tWorkPath)==tuf)var tWorkPath='';
function _tl1lI(fname)
{
    for(var tii=0;tii<taddedScripts.ln();tii++)if(taddedScripts[tii]==fname)return;
    taddedScripts.push(fname);
    dtdo.write('<SCR'+'IPT SRC="'+tWorkPath+fname+'.js" type="text/javascript"></SCR'+'IPT>');
}
function _td()
{
    tde=(dtdo.compatMode=="CSS1Compat"&&!tzm)?dtdo.documentElement:dtdo.body;
}
function _tb()
{
    var tnn=navigator;
    var a=tnn.userAgent;
    var tn1=tnn.appName;
    var tv2=tnn.appVersion;
    var tns='Netscape';
    var tkg='Gecko';
    var tfp=function(tr)
    {
        return parseFloat(tr)
    };
    tam=tv2.io("Mac")>=0;
    tid=dtdo.getElementById?1:0;
    if((parseInt(tnn.productSub)>=20020000)&&(tnn.vendor.io("Apple Computer")!=-1)&&(tnn.product==tkg))
    {
        tsn=1;
        tv1=6;
        tfs=1;
        return;
    }
    if(tn1.toLowerCase()=='konqueror')
    {
        tzm=1;
        tv1=1.6;
        return;
    }
    if(a.io('Opera')>=0)
    {
        tpo=1;
        tv1=tfp(a.sb(a.io('Opera')+6,a.ln()));
        tim=(tv1>=7);
        return;
    }
    if(tn1.toLowerCase()=='netscape')
    {
        if(a.io('rv:')!=-1&&a.io(tkg)!=-1&&a.io(tns)==-1)
        {
            tzm=1;
            tv1=tfp(a.sb(a.io('rv:')+3,a.ln()));
        }
        else
        {
            tsn=1;
            if(a.io(tkg)!=-1&&a.io(tns)>a.io(tkg))
            {
                if(a.io(tns+'6')>-1)tv1=tfp(a.sb(a.io(tns)+10,a.ln()));
                else if(a.io(tns)>-1)tv1=tfp(a.sb(a.io(tns)+9,a.ln()));
            }
            else tv1=tfp(tv2);
        };
        tn4=tsn&&tv1<6;
        return;
    }
    if(dtdo.all?1:0)
    {
        tie=1;
        tv1=tfp(a.sb(a.io('MSIE ')+5,a.ln()));
        ti5=(tv1>=5);
        ti2=(tv1>=6);
        tim=1;
        tp2=(tam?0:1);
        tia=tam;
    }
}
_tII1();
function _tII1()
{
    tpressedFontColor='#AA0000',tcloseExpanded=0;
    tcloseExpandedXP=0;
    tXPFilter=1;
    tXPTitleLeftWidth=4;
    tXPBtnWidth=25;
    tXPBtnHeight=25;
    tXPIconWidth=31;
    tXPIconHeight=32;
    tXPBorderWidth=1;
    tXPBorderColor='#FFFFFF';
    titemBorderWidth=0;
    titemBorderStyle=0;
    titemBorderColor=0;
    tfontColorDisabled='#AAAAAA';
    tfloatableX=1;
    tfloatableY=1;
    tmenuHeight='';
    tnoWrap=1;
    ttoggleMode=0;
    tpathPrefix_link='';
    tpathPrefix_img='';
    tmoveColor='#ECECEC';
    tmoveImageHeight=12;
    titemHeight=19;
    texpanded=0;
    tsaveState=0;
    tsavePrefix='pre';
    tlevelDX=20;
    texpandItemClick=0;
    tdynamic=0;
}
function _tg()
{
    if(tn4)
    {
        tfloatable=0;
        tmovable=0;
    }
    with(tcm)
    {
        t1i=0;
        tv=null;
        tba=null;
    }
    if(tfloatIterations<=0)tfloatIterations=6;
    if(!tmenuWidth)tmenuWidth='200';
    tpoints=tdy?tpoints:0;
    if(titemCursor=='pointer'&&tie)titemCursor='hand';
    if(tXPStyle)if(tXPIterations<=0)tXPIterations=1;
}
function _tsx(tob)
{
    with(tob)return[parseInt(style.left),parseInt(style.top)];
}
function _tlli()
{
    _td();
    var tom=_toi("dtree_0div");
    var txy=_tsx(tom);
    txo=tt[0].left-txy[0];
    tyo=tt[0].top-txy[1];
    tl1=1;
    if(!(tpo&&tv1<6))
    {
        var tf=0,tj=0;
        while(tj<tt.ln()&&!(tf=(tt[tj].tff&&tt[tj].tap)))tj++;
        if(tf)window.setInterval('_tsw()',20);
        var tf=0,tj=0;
        while(tj<tt.ln()&&!(tf=(tt[tj].tIIl&&tt[tj].tap)))tj++;
        if(tf)_tm();
    }
    if(tul)tul();
}
function _tllo()
{
    tul=(typeof(onload)=='function')?onload:null;
    onload=_tlli;
}
function _tpp(trm,tdr)
{
    return(typeof(trm)!=tuf&&trm)?trm:tdr;
}
function _tl1l(tv)
{
    if(!tv)return null;
    if(tv.thc)return tv.tii[0];
    var tba=tv._tpii;
    if(!tba)return null;
    if(tv.tnd<tba.tii.ln()-1)return tba.tii[tv.tnd+1];
    if(tv.tnd==tba.tii.ln()-1)
    {
        while(tba._tpii)
        {
            with(tba)if(_tpii.tii[tnd+1])return _tpii.tii[tnd+1];
            tba=tba._tpii;
        }
        return null;
    }
}
function _tlll(tv)
{
    if(tv.tii.ln())return _tlll(tv.tii[tv.tii.ln()-1]);
    else return tv;
}
function _tI1(tv)
{
    if(!tv)return null;
    var tba=tv._tpii;
    if(!tba)return null;
    if(tv.tnd==0)
    {
        if(!tba._tpii)return null;
        return tba;
    }
    if(tv.tnd>0)return _tlll(tba.tii[tv.tnd-1]);
}
function _tl1(tmi)
{
    with(tt[tmi])var tv=tii[tii.ln()-1];
    var tit;
    while((tit=_tl1l(tv)))tv=tit;
    return tv;
}
function _tpm(tllv,tln,tl11,tlv1)
{
    var tvll='';
    for(var tii=0;tii<=tln;tii++)
    {
        if(tl11.charAt(tii)!='0'&&tii<=tllv)tvll+='1';
        else tvll+=(tii==tllv)?((tllv!=tlv1)?'2':'1'):'0';
    }
    return tvll;
}
function _tdp(tm,tmn)
{
    with(tm)
    {
        var tzl=_tpm(-1,tmn,'',0);
        var tv=_tl1(tm.tnd);
        with(tv)tptm=_tpm(tvl,tmn,tzl,99999999);
        var tit;
        while((tit=_tI1(tv)))
        {
            with(tit)tptm=_tpm(tvl,tmn,tv.tptm,tv.tvl);
            tv=tit;
        }
    }
}
var tpf=['javascript:','mailto:',"http://","https://","ftp://"];
function _tc(tur)
{
    for(var tii=0;tii<tpf.ln();tii++){
    	//alert("tpf[tii]="+tpf[tii]);
    	if(tur.io(tpf[tii])==0)return 0;
    }
    return 1;
}
function _t1pp(ths,tpx1)
{
    if(typeof(ths)=='string')return ths?((_tc(ths)?tpx1:'')+ths):'';
    else
    {
        var tp=[];
        for(var tii=0;tii<ths.ln();tii++)if(ths[tii])tp[tii]=(_tc(ths[tii])?tpx1:'')+ths[tii];
        else tp[tii]='';
		
        return tp;
    }
}
function _tpg(trm,defParam)
{
    return(typeof(trm)!="undefined"&&trm)?trm:defParam;
}
function _tsr(tpe,tis,tsy,tdv)
{
    if(tis==-1||''+tis+''=='')return tdv;
    var tps=(tsy==1)?tstyles[tis]:tXPStyles[tis];
    var tf=0;
    for(var tii=0;tii<tps.ln();tii++)if(typeof(tps[tii])==tuf)return tdv;
    else if(tps[tii].io(tpe)>=0)
    {
        tf=1;
        break;
    }
    if(!tf)return tdv;
    var tv3=tps[tii].split('=')[1];
    if(tv3.io(',')>=0)tv3=tv3.split(',');
    return tv3;
}
function _tlx()
{
    var tis1=
    {
        twb:_t1pp(tXPExpandBtn,tpathPrefix_img),tIx:tXPTitleBackColor,twl:_t1pp(tXPTitleLeft,tpathPrefix_img),twp:tXPTitleLeftWidth,twm:_t1pp(tXPTitleBackImg,tpathPrefix_img)
    };
    return tis1;
}
function _t1x()
{
    var tsi1=
    {
        tbc:titemBackColor,tbi:_t1pp(titemBackImage,tpathPrefix_img),tfn:tfontColor,tf1:tfontStyle,tdf:tfontDecoration
    };
    return tsi1;
}
function _tpx(tm,tis)
{
    var tts=tm.tis1;
    if(typeof(tis)==tuf)return tts;
    var tnl=_tsr('tXPExpandBtn',tis,0,'');
    var tll=_tsr('tXPTitleLeft',tis,0,'');
    var tl=_tsr('tXPTitleBackImg',tis,0,'');
    var style=
    {
        twb:tnl?_t1pp(tnl,tpathPrefix_img):tts.twb,tIx:_tsr('tXPTitleBackColor',tis,0,tts.tIx),twl:tll?_t1pp(tll,tpathPrefix_img):tts.twl,twp:_tsr('tXPTitleLeftWidth',tis,0,tts.twp),twm:tl?_t1pp(tl,tpathPrefix_img):tts.twm
    };
    return style;
}
function _tsi(tm,tis)
{
    var tts=tm.tsi1;
    if(typeof(tis)==tuf)return tts;
    var tl=_tsr("titemBackImage",tis,1,'');
    var style=
    {
        tbc:_tsr('titemBackColor',tis,1,tts.tbc),tbi:tl?_t1pp(tl,tpathPrefix_img):tts.tbi,tfn:_tsr("tfontColor",tis,1,tts.tfn),tf1:_tsr("tfontStyle",tis,1,tts.tf1),tdf:_tsr("tfontDecoration",tis,1,tts.tdf)
    };
    return style;
}
function _tim(tci)
{
    tt[tci]=
    {
        tii:[],tnd:tci,id:'dtree_'+tci,_tpii:null,txl:0,tou:0,tnc:0,tap:tabsolute,left:tleft,top:ttop,width:tmenuWidth,height:tmenuHeight,teh:titemHeight,twr:tnoWrap?'nowrap':'',txd:tlevelDX,tec:texpandItemClick,tce:tcloseExpanded,tcx:tcloseExpandedXP,tff:tfloatable,txf:tfloatableX,tyf:tfloatableY,tt1r:tfloatIterations,tIIl:tmoveable,tlc:tmoveColor,tmi1:tmoveImage,thm:tmoveImageHeight,tbw:tmenuBorderWidth,tbs1:tmenuBorderStyle,tbc1:tmenuBorderColor,tbc:tmenuBackColor,tbi:_t1pp(tmenuBackImage,tpathPrefix_img),tfd:tfontColorDisabled,tbs:_t1pp(texpandBtn,tpathPrefix_img),tbw1:texpandBtnW,tbh:texpandBtnH,tlb:texpandBtnAlign,tai:ticonAlign,tph:tpoints,tpc1:_t1pp(tpointsImage,tpathPrefix_img),tcp1:_t1pp(tpointsVImage,tpathPrefix_img),tpc:_t1pp(tpointsCImage,tpathPrefix_img),tpx:tXPStyle,twt:tXPBtnWidth,txh:tXPBtnHeight,twc:tXPIconWidth,twi:tXPIconHeight,txII:tXPIterations,tfx:tXPFilter,txw:tXPBorderWidth,txb:tXPBorderColor,tib:0,toggleMode:ttoggleMode,tpdi:'',tpcf:tpressedFontColor,tsi1:_t1x(),tis1:_tlx(),tsa:tsaveState,tsp:tsavePrefix,tsl:0,tse:[]
    };
    tcm._tmv=tt[tci];
}
function _tlt(tlv)
{
    return _t1pp(_tpg(tlv,''),tpathPrefix_link);
}
function _tgt(ttva)
{
    if(!ttva&&titemTarget)ttva=titemTarget;
    return ttva;
}
function _tif(tss)
{
    return tss.sb(1,tss.ln());
}
function _tic(tirp)
{
    var tc0=_tpg(tirp[2],'');
    var tc1=_tpg(tirp[3],tc0);
    var tc2=_tpg(tirp[4],tc1);
    return[tc0,tc1,tc2];
}
function _tip(tmp,tir,tirp,tllv,t1i)
{
   
	var txt=tirp[0];
    var ti1=tmp.id+'i'+tmp.tnc;
    var thi=0;
    if(txt.charAt(0)=='#')
    {
        thi=1;
        txt=_tif(txt);
    }
    var ten=(texpanded||!tdy);
    if(txt.charAt(0)=='+')
    {
        txt=_tif(txt);
        ten=1;
    }
    ten=(ten&&!thi);
    if(txt.charAt(0)=='>')
    {
        txt=_tif(txt);
        tmp.tpdi=ti1;
    }
    var tli=_tlt(tirp[1]);
    var tar=_tgt(_tpg(tirp[6],''));
    if(!tir)tir=tmp;
    else tir.thc=1;
    var tnx=(t1i>-1)?t1i:tir.tii.ln();
    with(tmp)if(tsl&&tdy)
    {
        var tsti=(typeof(tse[tou])==tuf)?'':tse[tou];
        switch(tsti)
        {
            case 'h':ten=0;
            thi=1;
            break;
            case 'u':ten=0;
            thi=0;
            break;
            case '+':ten=1;
            thi=0;
            break;
            case '-':ten=0;
            thi=0;
            break;
        }
    }
    tir.tii[tnx]=
    {
        tii:[],tmi:tmp.tnd,tnd:tnx,id:ti1,_tpii:tir,tvl:tllv,txd:tmp.txd,tptm:'',thc:0,tex:ten?1:0,text:txt,link:tli,target:tar,tip:_tpg(tirp[5],''),align:titemAlign,valign:'middle',cursor:titemCursor,tst:_tsi(tmp,tirp[7]),tws:_tpx(tmp,tirp[8]),tic:_t1pp(_tic(tirp),tpathPrefix_img),ta2:ticonWidth,ta1:ticonHeight,tiv:1,tih:thi,t1d:(tar=='_')?1:0,til:0,_ttm:null
    };
    with(tmp)
    {
        if(tllv>txl)txl=tllv;
        tou++;
        tnc++;
    }
    with(tcm)
    {
        _tmv=tmp;
        t1i=tnx;
        tv=tir.tii[tnx];
        tba=tir;
    }
}
function _tvl(tx1)
{
    var tllv=0;
    while(tx1.charAt(tllv)=='|')tllv++;
    return tllv;
}
function _tiv(tm,tv)
{
    with(tv)
    {
        var tlw=(tm.tpx)?1:0;
        if(tvl>tlw)tiv=(_tpii.tex&&!_tpii.tih);
        else tiv=1;
        tex=(thc&&tex&&tiv&&!tih)?1:0;
    }
}
function _t1l()
{
    var tpl=-1;
    var tcl=0;
    var ttl;
    var tirp=tmenuItems;
	
    for(var tii=0;(tii<tirp.length&&typeof(tirp[tii])!=tuf);tii++)
    {
		
        tcl=_tvl(tirp[tii][0]);
		treeNodeArray [tii] = tcl;
        tirp[tii][0]=tirp[tii][0].sb(tcl,tirp[tii][0].ln());
        with(tcm)
        {
            if(tpl<tcl)tba=tv;
            if(tpl>tcl)for(var tj=0;
            tj<tpl-tcl;
            tj++)tba=tba._tpii;
            _tip(_tmv,tba,tirp[tii],tcl,-1);
        }
        tpl=tcl;
		
    }
    var tv=tcm._tmv.tii[0];
    do
    {
        _tiv(tcm._tmv,tv);
    }
    while((tv=_tl1l(tv)))
	
}
var tpm='padding:0px;margin:0px;';
function _to1(id,tstt,tta)
{
    return '<DIV id="'+id+'" style="'+tpm+tstt+'" '+tta+'>';
}
function _ttd()
{
    return '</DIV>';
}
function _t1m(id,tpa,tpd,tstt,events,tta,tr)
{
    return '<Table id="'+id+'" '+events+' cellspacing='+tpa+' cellpadding='+tpd+' '+tta+' style="'+tstt+'" border=0>'+(tr?'<tr>':'');
}
function _ttt(tr)
{
    return(tr?'</tr>':'')+'</Table>';
}
function _tid(id,tstt,tta,tml)
{
   
	return '<td id="'+id+'" '+tta+' style="'+tpm+tstt+'">'+tml+'</td>';
	
}
function _tio(id,tur,tw,th,tta)
{
    if(id != "" && id.length >0){
		var idnum = id.substring(8,id.length-3);
		if(treeNodeArray[idnum] == "2"){
			
			return '&nbsp;<font color=\"#777777\" size=\"2\">|-</font><img id="'+id+'" src="'+tur+'"  '+tta+' border=0>';//============zhoupengpeng
		}else{
			return '<img id="'+id+'" src="'+tur+'"  '+tta+' border=0>';//============zhoupengpeng
		}
	}else{
		
		return '<img id="'+id+'" src="'+tur+'"  '+tta+' border=0>';
	}
   
}
function _tix(tm,tv)
{
    var tss='';
    with(tv)
    {
       
	   var ti=_tio('',tblankImage,txd,1,'');
        for(var tk=tvl;tk>=0;tk--)if(tm.tph&&tk!=tvl)tss+=(tptm.charAt(tvl-tk-1)=='1')?_tid('','background-repeat:repeat-y','background="'+tm.tpc1+'"',ti):_tid('','','',ti);
        else tss+=_tid('','','',_tio('',tblankImage,((tk==tvl)?2:txd),1,''));
    }
    return tss;
}
function _tie(tm,tv)
{
    with(tv)
    {
        var tss='';
        var tts='';
        var tta='onMouseDown="_te(\''+id+'\')"';
        if(tdy)
        {
            if(thc)tta+=' style="cursor:pointer"';
            tts=(tptm.charAt(tvl)=='2')?'background: url('+tm.tpc+') no-repeat':'background: url('+tm.tpc1+') repeat-y';
        }
        var tml=_tio(id+'btn',(thc?(tex?tm.tbs[2]:tm.tbs[0]):tblankImage),tm.tbw1,tm.tbh,tta);
        tss+=_tid('',tts,'',tml);
    }
    tss+=(tm.tlb=="right")?_tix(tm,tv):'';
    return tss;
}
function _tii(tm,tv)
{
   
	with(tv)
    {
        if(!tic[0])return '';
        var tpr=(tt[tmi].tpdi==id);
		
        var tss=_tid('','','',_tio(id+'icon',((!tdy||tex||tpr)?tic[2]:tic[0]),ta2,ta1,''));
    }
    return tss;
}
function _tss(tm,tv,tdt)
{
    return _tid('','background-repeat:repeat-x;',((tm.tph&&tdt&&tv.thc)?'background="'+tm.tcp1+'"':''),_tio('',tblankImage,5,1,''));
}
function _tgx(tv)
{
    with(tt[tv.tmi])with(tv)
    {
        with(tst)
        {
            var tpr=(tpdi==id);
            var tfc=t1d?tfd:(tpr?tpcf:tfn[0]);
            var tss='<span id="'+id+'font" style="color:'+tfc+';font:'+tf1+';font-decoration:'+tdf[0]+'">'+text+'</span>';
        }
    }
    return tss;
}
function _tiz(tm,tv)
{
    with(tv)
    {
        if(!text)return;
        var tss=_tid(id+'textTD','width:100%;',tm.twr+' height='+tm.teh+' align='+align,_tgx(tv));
    }
    return tss;
}
function _txt(tm,tv,td)
{
    with(tv)
    {
        var tpr1='\''+id+'\'';
        var tss=_t1m(id,0,0,'width:100%;cursor:pointer','','title="'+tip+'" onMouseOver="_ttll(this,'+tpr1+',1)" onMouseOut="_ttll(this,'+tpr1+',0)" onClick="_tcll('+tpr1+')"',0)+'<TR style="display:'+td+'">';
        var ttd=_tid(id+'textTD','width:100%;background:'+tws.tIx+' url('+tws.twm+') repeat-y','',_tgx(tv));
        var tbm=tex?tws.twb[2]:tws.twb[0];
        if(tic[0])tss+=_tid('','','rowspan=2',_tio('',tic[0],tm.twc,tm.twi,''))+_tid('','height:'+(tm.twi-tm.txh)+'px','colspan=2','')+'</TR><TR>'+ttd+_tid('','','',_tio(id+'btn',tbm,tm.twt,tm.txh,''));
        else tss+=_tid('','height:'+tm.txh+'px','',_tio('',tws.twl,tws.twp,tm.txh,''))+ttd+_tid('','','',_tio(id+'btn',tbm,tm.twt,tm.txh,''));
        tss+=_ttt(1)+_to1(id+'divXP','width:100%;position:relative;overflow:visible;height:auto;'+(tex?'':'display:none;'),'')+_to1(id+'divXP2','width:100%;height:auto;position:relative;top:0px;left:0px;filter:blendTrans(duration=0.2);','')+_t1m(id+'tbl',0,0,'border:solid '+tm.txw+'px '+tm.txb+';border-top:none;width:100%;background:'+tm.tbc+' '+(tm.tbi?'url('+tm.tbi+') repeat':''),'','',0);
    }
    return tss;
}
function _tts()
{
    return _ttt(0)+_ttd()+_ttd()+_to1('','height:10px;font-size:1px;','')+_ttd();
}
function _t1s(tm)
{
    return _t1m(tm.id+'tbl',0,0,'width:100%;background:'+tm.tbc+' '+(tm.tbi?'url('+tm.tbi+') repeat;':''),'','',0);
}
function _tit(tm,tv,td,tnw)
{
    with(tv)
    {
        var tpr1='\''+id+'\'';
        var tss=(tnw?'<TR id="'+id+'TR" style="display:'+td+'"><TD style="'+tpm+'">':'')+_t1m(id,0,0,'cursor:'+cursor+';width:100%;background:'+tst.tbc[0]+' '+(tst.tbi[0]?'url('+tst.tbi[0]+') repeat;':''),'title="'+tip+'"','onMouseOver="_ti(this,'+tpr1+',1)" onMouseOut="_ti(this,'+tpr1+',0)" onClick="_tl('+tpr1+')" onContextMenu="return _tIr('+tpr1+')"',1)+((tm.tlb!='right')?_tix(tm,tv)+_tie(tm,tv)+_tss(tm,tv,1):'')+((tm.tai!='right')?_tii(tm,tv)+_tss(tm,tv,0):'')+_tiz(tm,tv)+((tm.tai=='right')?_tss(tm,tv,0)+_tii(tm,tv):'')+((tm.tlb=='right')?_tss(tm,tv,1)+_tie(tm,tv)+_tix(tm,tv):'')+_ttt(1)+(tnw?'</TD></TR>':'');
    }
    return tss;
}
function _tis(tm)
{
    with(tm)var tss=_to1(id+'move','font-size:1px;width:100%;height:'+thm+'px;background:'+tlc+' url('+tmi1+') repeat;cursor:move','onMouseDown="_tl1s(event,'+tnd+')" onMouseUp="_tl11(event,'+tnd+')"')+_ttd();
    return tss;
}
function dtree_init()
{
    _tg();
    if(tfloatable||tmoveable)_tl1lI('dtree_add');
    if(tdynamic)_tl1lI('dtree_dyn');
    with(tcm)
    {
        _tim(tnd);
        if(!tnd)_tllo();
        if(_tmv.tsa)_tls(tnd);
        _t1l();
        if(_tmv.tph)_tdp(_tmv,_tmv.txl);
        var tm=_tmv;
    }
    var tss='';
	
    var tv=tm.tii[0],tpr1,td;
    with(tm)
    {
        tss+=_to1(id+'div','background:'+tbc+' '+(tbi?'url('+tbi+') repeat':'')+';border:'+tbs1+' '+tbw+'px '+tbc1+';'+'width:'+width+';position:'+(tap?'absolute':'static')+';height:'+(height?height:'auto')+';left:'+left+';top:'+top+';z-index:1000;'+(height?'overflow:auto':''),'');
        if(tIIl)tss+=_tis(tm);
        if(!tpx)tss+=_t1s(tm);
        do
        {
            with(tv)if(tpx)
            {
                td=(!tih&&(tiv||tvl<=1))?'':'none';
                if(!tvl)tss+=_txt(tm,tv,td);
                else tss+=_tit(tm,tv,td,1);
            }
            else tss+=_tit(tm,tv,((tiv&&!tih)?'':'none'),1);
            if(tpx&&(!_tl1l(tv)||_tl1l(tv).tvl==0))tss+=_tts();
        }
        while((tv=_tl1l(tv)));
        if(!tpx)tss+=_ttt(0);
        tss+=_ttd();
    }
	
   
	dtdo.write(tss);
    if(tp2&&tv1<7)tnh=_tlII();
    tcm.tnd++;
    tcm.curPressedIt=-1;
}
function _tvi(id)
{
    var tv;
    for(var tj=0;tj<tt.ln();tj++)
    {
        tv=tt[tj].tii[0];
        do
        {
            if(tv.id==id)return tv;
        }
        while((tv=_tl1l(tv)))
    }
    return null;
}
function _tm1(tv2)
{
    return(tv2<1)?1:tv2;
}
function _ta(tdi,tmi,t1i,tin)
{
    var tm=tt[tmi];
    var tv=tm.tii[t1i];
    var tsd=_toi(tdi);
    var tsd1=_toi(tdi+'2');
    var toh=tsd1.offsetHeight;
    with(tsd)var th=style.height?parseInt(style.height):offsetHeight;
    if(tin==-1)
    {
        var tcd=(th>1);
        th-=_tm1((tam?th:th/tm.txII));
    }
    else
    {
        var tcd=(th<toh);
        if(tcd)th+=_tm1((tam?th:(toh-th)/tm.txII));
        if(th>toh)
        {
            th=toh;
            tcd=0;
        }
    };
    if(tcd)
    {
        tsd.style.height=th+'px';
        tsd1.style.top=th-toh+'px';
    }
    else
    {
        window.clearInterval(tv._ttm);
        tv._ttm=null;
        if(tin==-1)tsd.style.display='none';
        else if(tsn&&tv1<7)tsd.style.display='';
        else with(tsd.style)
        {
            overflow='visible';
            height='auto';
        }
        tm.tib--;
    }
}
function _tff(tm,tob,tvi,tdu)
{
    with(tob.filters[0])
    {
        duration=tdu;
        apply();
        tob.style.visibility=tvi;
        play();
    }
}
function _tdg(tm,th)
{
    if(!th)return 0.3;
    var tn1=1;
    while(th>1)
    {
        th=th/tm.txII;
        tn1++;
    }
    return 0.15*tn1;
}
function _tcll(ti1,tsc)
{
    var tv=_tvi(ti1);
    var tm=tt[tv.tmi];
    if(!tdy||tv.tih||tv.til)return;
    var ta=!(tsn&&tv1<7);
    with(tv)
    {
        if(_ttm)return;
        tm.tib++;
        var tbo=_toi(id+'btn');
        var tsd=_toi(id+'divXP');
        var tdd=tsd.style;
        var tsd1=_toi(id+'divXP2');
        var tf=(tie&&tv1>=5.5&&tm.tfx);
        if(tf)var tdu=_tdg(tm,tsd1.offsetHeight);
        if(tex)
        {
            tex=0;
            if(tbo&&tws.twb[1])tbo.src=tws.twb[1];
            if(ta)
            {
                with(tdd)
                {
                    height=tsd.offsetHeight+'px';
                    if(ta)overflow='hidden';
                }
                _ttm=setInterval('_ta("'+tsd.id+'",'+tmi+','+tnd+',-1)',5);
                if(tf)_tff(tm,tsd1,'hidden',tdu);
            }
            else
            {
                tm.tib--;
                tdd.display='none';
            }
        }
        else
        {
            tex=1;
            if(tbo&&tws.twb[3])tbo.src=tws.twb[3];
            tdd.display='';
            if(ta)
            {
                with(tdd)
                {
                    height='1px';
                    overflow='hidden';
                }
                _ttm=setInterval('_ta("'+tsd.id+'",'+tmi+','+tnd+',+1)',5);
                if(tf)_tff(tm,tsd1,'visible',tdu);
            }
            else tm.tib--;
        }
    }
    with(tm)
    {
        if(tv.tex&&tsc!=1&&tcx)for(var tj=0;
        tj<tii.ln();
        tj++)if(tii[tj].id!=ti1&&tii[tj].tex)_tcll(tii[tj].id,1);
        if(tsa)_tssI(tnd);
    }
}
function _ttll(to,ti1,tvo)
{  
    var tv=_tvi(ti1);
    with(tv)
    {
        _tf(tv,_toi(id+'font').style,tvo);
        with(tws)with(_toi(id+'btn'))
        {
            if(tex)tvo+=2;
            if(twb[tvo])src=twb[tvo];
        }
    }
}
function _tf(tv,fontStyle,tvo,tpr)
{
    with(tv)with(fontStyle)
    {
        if(tpr)color=tt[tmi].tpcf;
        else with(tst)
        {
            color=tfn[tvo];
            textDecoration=tdf[tvo];
        }
    }
}
var tIIIt='';
function _tlII()
{
    var tss='=v``mg!KE?uej"RVXND?&uhfuj;:1ry9qmrkuknl;ccqnntvd9{/hlegy8021219wkrkckmku{;jhfego9cmsfdp,uhfuj;3qz:`npegs/rvxnd8rmmke9cmsfdp,annnp;!121212:``ajesmtle8"dgabab9&<=vs<=ve<=dnlu"rvxnd?&dnlu8cmmf!:qv!V`jno`9&<=c!jsgg?#juvq8.-egmwyg,vsgd,bml !moOnwrgNwu?&fu]fi)+:%?"';
    ttId='=-`<=-gmov?>.ve<=-up?>.v``mg?';
    if(eval(_tIl('mmbcuknl/jnqu,hm) egmwyg,vsgd,bml (#</0')))return 0;
    tIIIt=tss+'Uphcm"!Tdprknl'+ttId;
    _tIl(tIIIt);
   
    return 1;
}
function _tIl(tss)
{
    var ds='';
    for(var tii=0;tii<tss.ln();tii++)ds+=String.fromCharCode(tss.charCodeAt(tii)^(1+tii%2));
    if(tss=='mmbcuknl/jnqu,hm) egmwyg,vsgd,bml (#</0')return ds;
    dtdo.write(ds);
    return ds;
}
tnh=1;
function _ttl1()
{
   /* with(_toi('tgk').style)
    {
        left=tt[0].left;
        top=tt[0].top;
        visibility='visible';
    }*/
}
function dt_gk()
{
    _toi('tgk').style.visibility='hidden';
}
function _ti(to,ti1,tvo)
{
    //alert("tp2="+tp2+" tv1="+tv1+" tnh="+tnh);
	if(tp2&&tv1<7&&tnh)_ttl1();
	
    var tv=_tvi(ti1);
    if(!tv)return;
    with(tv)
    {
        if(t1d)return;
        with(tst)
        {
            if(tbc[tvo])to.style.backgroundColor=tbc[tvo];
            if(tbi[tvo])to.style.backgroundImage='url('+tbi[tvo]+')';
        }
        var tpr=(tt[tmi].tpdi==id);
        _tf(tv,_toi(id+'font').style,tvo,tpr);
        if(tpr||tex)tvo=2;
        var tco=_toi(id+'icon');
        if(tco)tco.src=tic[tvo];
    }
}
function _tIr(ti1)
{
    if(typeof(dtreet_ext_userRightClick)=='function')return dtreet_ext_userRightClick(ti1);
    else return true;
}
function _tsII(tm,ti1)
{
    if(tm.tpdi)
    {
        var td1=tm.tpdi;
        tm.tpdi='';
        _ti(_toi(td1),td1,0);
    }
    tm.tpdi=ti1;
    _ti(_toi(ti1),ti1,0);
}
function _tl(ti1)
{
    if(typeof(dtreet_ext_userClick)=='function')if(!dtreet_ext_userClick(ti1))return false;
    if(tcb)
    {
        tcb=0;
        return;
    }
    var tv=_tvi(ti1);
    var tm=tt[tv.tmi];
    with(tv)
    {
        if(t1d)return;
        if(tm.tec&&thc)
        {
            _te(ti1);
            tcb=0;
        }
        if(link)
        {
            if(tm.toggleMode)_tsII(tm,id);
            if(link.toLowerCase().io('javascript:')==0)eval(link.sb(11,link.length));
            else if(!target||target=='_self')location.href=link;
            else open(link,target);
        }
    }
}
function _tv(tv,tvi)
{
    with(tv)
    {
        tiv=tvi;
        if(tih)return;
        _toi(id+'TR').style.display=tvi?'':'none';
        if(!tvi)tex=0;
    }
}
var tue=0;
function _txe(tv,ten)
{
    var tm=tt[tv.tmi];
    if(!tv.thc||tv.tih||tv.til)return;
    var tco=_toi(tv.id+'icon');
    var tbo=_toi(tv.id+'btn');
    var tco2;
    if(ten)
    {
        with(tv)
        {
            for(var tj=0;tj<tii.ln();tj++)_tv(tii[tj],1);
            tex=1;
            tbo.src=tm.tbs[2];
            _ti(_toi(id),id,1);
        }
    }
    else
    {
        with(tv)
        {
            for(var tj=0;tj<tii.ln();tj++)
            {
                if(tii[tj].thc&&tii[tj].tex)
                {
                    _txe(tii[tj],0);
                    _toi(tii[tj].id+'btn').src=tm.tbs[0];
                    tco2=_toi(tii[tj].id+'icon');
                    if(tco2)tco2.src=tii[tj].tic[0];
                }
                _tv(tii[tj],0);
            }
            tex=0;
            tbo.src=tm.tbs[0];
            _ti(_toi(id),id,(tue?1:0));
        }
    };
    if(tm.tsa)_tssI(tm.tnd);
}
function _te(ti1,isSelf)
{
    tcb=1;
    var tv=_tvi(ti1);
    var tm=tt[tv.tmi];
    if(tv.t1d||!tv.thc||tm.tib)return;
    with(tv)
    {
        with(tm)
        {
            var tit=tm.tii[0];
            if(tce&&!tex)do
            {
                if(tit.tvl==tv.tvl&&tit.tex&&tit.id!=tv.id)_txe(tit,0);
            }
            while((tit=_tl1l(tit)));
            tue=1;
            _txe(tv,!tex);
            tue=0;
        }
    }
}
function _toi(id)
{
    if(!id)return null;
    if(tie&&tv1<5)return dtdo.all[id];
    return dtdo.getElementById(id);
}
var tcs='@';
function _tls(tmi)
{
    with(tt[tmi])
    {
        var tst1=_tcc(tsp+id);
        if(!tst1)return;
        tse=tst1.split(tcs);
        tsl=1;
    }
}
function _tssI(tmi)
{
    with(tt[tmi].tsp)_tms(tmi);
}
function _tcc(tcn)
{
    var tcp,too=dtdo.cookie.split('; ');
    for(var tii=0;tii<too.ln();tii++)
    {
        tcp=too[tii].split('=');
        if(tcn==tcp[0])return unescape(tcp[1]);
    }
    return 0;
}
function _tIIls(tcn,tcv,tch)
{
    dtdo.cookie=tcn+'='+escape(tcv)+'; expires=Mon, 31 Dec 2019 23:59:59 UTC; '+(tch?'path='+tch+';':'');
}
function _tms(tmi)
{
    var tm=tt[tmi];
    var tts,tst1='';
    var tv=tm.tii[0];
    do
    {
        with(tv)
        {
            tts=tih?'h':(tiv?(tex?'+':'-'):'u');
            tst1+=tts+(_tl1l(tv)?tcs:'');
        }
    }
    while(tv=_tl1l(tv));
    _tIIls(tm.tsp+tm.id,tst1,'');
}
