// 右侧主显示区  欢迎页面
Ext.BLANK_IMAGE_URL = 'resources/images/default/s.gif';
Ext.useShims = true;
Ext.QuickTips.init();
var start = {
    id: 'start-panel',
    title: '欢迎使用',
    layout: 'fit',
    bodyStyle: 'padding:10px',
    html: '<table width=100% height=100% border=0><tr><td align=right valign=bottom><img src="images/bg.jpg"/></td></tr></table>'
};

var strPfunc = strPfunc.substr(0, strPfunc.length);
//alert(strPfunc);
strPfuncList = strPfunc.split(",");
var arrPfuncList = [];
/**
 * 2018.09.14
 * 项目启动不了
 * 原因：strPfuncList中p_zzNianBao未定义
 * 将z_duty表中系统超级管理员的funcCode字段中的zzNianBao删除后可以启动
 *
 */
for (var i = 0, len = strPfuncList.length; i < len; i++) {
    var item = eval(strPfuncList[i]);
    arrPfuncList = arrPfuncList.concat(item);
}

var rootTree = new Ext.tree.TreeLoader({dataUrl: 'toSimpleTree.jsp'});

var TreePan = new Ext.tree.TreePanel({
    xtype: 'treepanel',
    id: 'navTreeId',
    border: false,
    rootVisible: false,
    autoScroll: true,
    loader: rootTree,
    root: new Ext.tree.AsyncTreeNode(),
    listeners: {
        'click': function (n) {
            try {
                var sn = this.selModel.selNode || {};
                //单击展开闭合操作方法开始
                if (!n.leaf) {
                    if (n.expanded == false) {
                        n.expand();
                    } else {
                        n.collapse();
                    }
                }//单击展开闭合操作方法结束

                if (n.leaf && n.id != sn.id) {
                    Ext.getCmp('content-panel').layout.setActiveItem(n.id.substring(0, n.id
                            .indexOf('-'))
                        + '-panel');
                    //根据树形菜单执行不同的相应
                    var treeNodValue = n.id.substring(0, n.id.indexOf('-'));
                    switch (treeNodValue) {
                        case 'zzArchiveScan' :
                            Ext.getCmp('textSearchArchiveScan').focus(false, 50);
                            if (sysOcrSwitch == '0') {//0代表关闭ORC功能1代表打开OCR功能
                                btn_shibie_archiveScan.setDisabled(true);
                                scanner74622.OCRFlag = '0';
                            } else {
                                scanner74622.OCRFlag = '1';
                            }
                            break;
                        case 'zzXinban' :
                            Ext.getCmp('textSearchXinban').focus(false, 50);
                            if (sysOcrSwitch == '0') {//0代表关闭ORC功能(0:不开OCR150dpi)
                                btn_shibie_xinban.setDisabled(true);
                                scanner24622.OCRFlag = '0';
                            } else {//1代表打开OCR功能(1:打开OCR300dpi)
                                scanner24622.OCRFlag = '1';
                            }
                            break;
                        case 'zzNianjian' :
                            Ext.getCmp('textSearchnianjian').focus(false, 50);
                            scanner24623.OCRFlag = '0';
                            break;
                        case 'zzBiangen' :
                            Ext.getCmp('textSearchbiangen').focus(false, 50);
                            scanner24624.OCRFlag = '0';
                            break;
                        case 'zzBuzheng' :
                            Ext.getCmp('textSearchbuzheng').focus(false, 50);
                            scanner24626.OCRFlag = '0';
                            break;
                        case 'zzHuanzheng' :
                            Ext.getCmp('textSearchhuanzheng').focus(false, 50);
                            scanner24625.OCRFlag = '0';
                            break;
                        case 'zzQianru' :
                            Ext.getCmp('textSearchQianru').focus(false, 50);
                            if (sysOcrSwitch == '0') {
                                btn_shibie_qianru.setDisabled(true);
                                scanner24627.OCRFlag = '0';
                            } else {
                                scanner24627.OCRFlag = '1';
                            }
                            break;
                        case 'zzQianchu' :
                            Ext.getCmp('textSearchqianchu').focus(false, 50);
                            scanner24629.OCRFlag = '0';
                            break;
                        case 'zzYufuma' :
                            Ext.getCmp('textSearchYufuma').focus(false, 50);
                            scanner24628.OCRFlag = '0';
                            break;
                        case 'zzFeizhi' :
                            Ext.getCmp('textSearchfeizhi').focus(false, 50);
                            scanner24630.OCRFlag = '0';
                            break;
                        case 'zzPiliangfeizhi' :
                            Ext.getCmp('textSearchpiliangfeizhi').focus(false, 50);
                            scanner24631.OCRFlag = '0';
                            break;
                        case 'zzWorkQuery' :
                            Ext.getCmp('textSearchWorkQueryid').focus(false, 50);
                            searchWorkQuery();
                            break;
                        case 'zzWorkOrder' :
                            Ext.getCmp('textSearchWorkOrderid').focus(false, 50);
                            searchWorkOrder();
                            break;
                        case 'zzWorkShenhe' :
                            Ext.getCmp('textSearchWorkShenheid').focus(false, 50);
                            //scanner74179.OCRFlag='0';
                            break;
                        case 'zzFeizhiHuifuManage' :
                            Ext.getCmp('textSearchFeizhiHuifuManageid').focus(false, 50);
                            //scanner74832.OCRFlag='0';
                            break;
                        case 'zzArchivesDo' :
                            Ext.getCmp('textSearchArchivesDo').focus(false, 50);
                            scanner246.OCRFlag = '0';
                            break;
                        case 'zzArchives' :
                            Ext.getCmp('textSearchArchivesid').focus(false, 50);
                            searchArchives();
                            break;
                        case 'zzDataModify' :
                            Ext.getCmp('textSearchdataModify').focus(false, 50);
                            break;
                        case 'zzGoDfile' :
                            Ext.getCmp('textSearchGoDfileid').focus(false, 50);
                            scanner2.OCRFlag = '0';
                            break;
                        case 'zzLicensePrint' :
                            Ext.getCmp('textSearchLicensePrintid').focus(false, 50);
                            //searchLicensePrint();
                            break;
                        case 'zzDfileManage' :
                            Ext.getCmp('textSearchDfileManageid').focus(false, 50);
                            scanner994.OCRFlag = '0';
                            break;
                        case 'zzLicensePrintFuben' :
                            Ext.getCmp('textSearchLicensePrintFubenid').focus(false, 50);
                            break;
                        case 'zzLicensePrintTeshu' :
                            Ext.getCmp('textSearchLicensePrintTeshuid').focus(false, 50);
                            break;
                        case 'zzOrgPrtSqd' :
                            Ext.getCmp('textSearchOrgPrtSqdid').focus(false, 50);
                            searchOrgPrtSqd();
                            break;
                        case 'zzOrgPrtQzd' :
                            Ext.getCmp('textSearchOrgPrtQzdid').focus(false, 50);
                            searchOrgPrtQzd();
                            break;
                        case 'zzOrgPrtZxd' :
                            Ext.getCmp('textSearchOrgPrtZxdid').focus(false, 50);
                            searchOrgPrtZxd();
                            break;
                        case 'zzOrgPrtYfm' :
                            Ext.getCmp('textSearchOrgPrtYfmid').focus(false, 50);
                            searchOrgPrtYfm();
                            break;
                        case 'zzDfileQueryAll' :
                            Ext.getCmp('textSearchDfileQueryAllid').focus(false, 50);
                            break;
                        case 'zzDfileArchiveManage' :
                            Ext.getCmp('textSearchDfileArchiveManageid').focus(false, 50);
                            break;
                        case 'zzDfileQueryArchive' :
                            Ext.getCmp('textSearchDfileArchiveQueryid').focus(false, 50);
                            break;
                        case 'zzDfileManage' :
                            Ext.getCmp('textSearchDfileManageid').focus(false, 50);
                            break;
                        case 'zzLicenseLog' :
                            Ext.getCmp('textSearchLicenseLogid').focus(false, 50);
                            break;
                        case 'zzLicenseArchive' :
                            Ext.getCmp('textSearchOrgnewArchiveid').focus(false, 50);
                            break;
                        case 'zzRegisterManage' :
                            SearchRegistUser();
                            break;
                        case 'zzCardPrintSet' :
                            SearchPrintSet();
                            break;
                        case 'zzQXSet' :
                            searchAllBzjg();
                            break;
                        case 'zzCardPrint':
                            NPrint.SetPrintName();
                            break;
                    }
                }
            } catch (e) {
            }
        }
    }
});

function showTreeMsg() {
    Ext.Ajax.request({
        url: 'findCountAllOrgnew.action',
        params: {username: currentZzUsername, stateConditions: '10,11,12,13,14,15,16,22,24'},
        success: function (result, request) {
            var resultObject = Ext.util.JSON.decode(result.responseText);
            if (resultObject != null) {
                var zwqCount = 0;
                var zwsCount = 0;
                var zzaCount = 0;
                var zgfCount = 0;
                var zlpCount = 0;
                var yfmdpCount = 0;
                var fzdpCount = 0;
                var qzdpCount = 0;
                for (var j = 0; j < resultObject.length; j++) {
                    var state = resultObject[j].state;
                    var msgCount = parseInt(resultObject[j].msgCount);
                    var dybz = resultObject[j].dybz;
                    var handleUsername = resultObject[j].handleUsername;
                    var ywlx = resultObject[j].ywlx;
                    if (state == 12 || state == 13 || state == 14 || state == 15 || state == 22) {
                        zwqCount = zwqCount + msgCount
                    }
                    if (state == 13) {
                        zwsCount = zwsCount + msgCount
                    }
                    if (state == 2 || state == 3) {
                        zzaCount = zzaCount + msgCount
                    }
                    if (currentZzUsername == 'admin') {
                        if (state == 16 && dybz != 'Y') {
                            zgfCount = zgfCount + msgCount
                        }
                    } else {
                        if (state == 16 && dybz != 'Y' && currentZzUsername == handleUsername) {
                            zgfCount = zgfCount + msgCount;
                        }
                    }
                    if ((state == 16 || state == 6) && dybz == 'Y') {
                        if (ywlx == '新办' || ywlx == '变更' || ywlx == '换证' || ywlx == '补证' || ywlx == '迁入') {
                            zlpCount = zlpCount + msgCount
                        } else if (ywlx == '预赋码') {
                            yfmdpCount = yfmdpCount + msgCount
                        } else if (ywlx == '注销') {
                            fzdpCount = fzdpCount + msgCount
                        } else if (ywlx == '迁出') {
                            qzdpCount = qzdpCount + msgCount
                        }
                    }

                }

                try {
                    var noteYwblParent = TreePan.getNodeById('ywblParent-manage');
                    if (zwqCount > 0) {
                        //noteYwblParent.setText('<font color=red>业务办理</font>');
                        noteYwblParent.getUI().getIconEl().src = "images/memo.gif";
                    } else {
                        //noteYwblParent.setText('业务办理');
                        noteYwblParent.getUI().getIconEl().src = "images/folder-open.gif";//
                    }
                } catch (e) {
                }

                try {
                    var noteWorkQuery = TreePan.getNodeById('zzWorkQuery-manage');
                    if (zwqCount > 0) {
                        noteWorkQuery.setText('待办查询(<font color=red>' + zwqCount + '</font>)');
                    } else {
                        noteWorkQuery.setText('待办查询');
                    }
                } catch (e) {
                }

                try {
                    var noteZxspParent = TreePan.getNodeById('zxspParent-manage');
                    if (zwsCount > 0) {
                        noteZxspParent.expand(true);
                        //noteZxspParent.setText('<font color=red>中心审批</font>');
                        noteZxspParent.getUI().getIconEl().src = "images/memo.gif";
                    } else {
                        noteZxspParent.collapse(true);
                        //noteZxspParent.setText('中心审批');
                        noteZxspParent.getUI().getIconEl().src = "images/folder-open.gif";
                    }
                } catch (e) {
                }

                try {
                    var noteWorkShenhe = TreePan.getNodeById('zzWorkShenhe-manage');
                    if (zwsCount > 0) {
                        noteWorkShenhe.setText('现场业务审批(<font color=red>' + zwsCount + '</font>)');
                    } else {
                        noteWorkShenhe.setText('现场业务审批');
                    }
                } catch (e) {
                }

                try {
                    var noteWsblParent = TreePan.getNodeById('wsblParent-manage');
                    if (zzaCount > 0) {
                        noteWsblParent.expand(true);
                        //noteWsblParent.setText('<font color=red>网上办理</font>');
                        noteWsblParent.getUI().getIconEl().src = "images/memo.gif";
                    } else {
                        noteWsblParent.collapse(true);
                        //noteWsblParent.setText('网上办理');
                        noteWsblParent.getUI().getIconEl().src = "images/folder-open.gif";
                    }
                } catch (e) {
                }

                try {
                    var noteArchives = TreePan.getNodeById('zzArchives-manage');
                    if (zzaCount > 0) {
                        noteArchives.setText('自助待办查询(<font color=red>' + zzaCount + '</font>)');
                    } else {
                        noteArchives.setText('自助待办查询');
                    }
                } catch (e) {
                }
                try {
                    var noteYwglParent = TreePan.getNodeById('ywglParent-manage');
                    if (zgfCount > 0) {
                        noteYwglParent.expand(true);
                        //noteYwglParent.setText('<font color=red>业务管理</font>');
                        noteYwglParent.getUI().getIconEl().src = "images/memo.gif";
                    } else {
                        noteYwglParent.collapse(true);
                        //noteYwglParent.setText('业务管理');
                        noteYwglParent.getUI().getIconEl().src = "images/folder-open.gif";
                    }
                } catch (e) {
                }

                try {
                    var noteGoDfile = TreePan.getNodeById('zzGoDfile-manage');
                    if (zgfCount > 0) {
                        noteGoDfile.setText('扫描归档(<font color=red>' + zgfCount + '</font>)');
                    } else {
                        noteGoDfile.setText('扫描归档');
                    }
                } catch (e) {
                }

                try {
                    var noteDjdyParent = TreePan.getNodeById('djdyParent-manage');
                    if (zlpCount > 0 || yfmdpCount > 0 || fzdpCount > 0 || qzdpCount > 0) {
                        noteDjdyParent.expand(true);
                        //noteDjdyParent.setText('<font color=red>单据打印</font>');
                        noteDjdyParent.getUI().getIconEl().src = "images/memo.gif";
                    } else {
                        noteDjdyParent.collapse(true);
                        //noteDjdyParent.setText('单据打印');
                        noteDjdyParent.getUI().getIconEl().src = "images/folder-open.gif";
                    }
                } catch (e) {
                }

                try {
                    var noteLicensePrint = TreePan.getNodeById('zzLicensePrint-manage');
                    if (zlpCount > 0) {
                        noteLicensePrint.setText('证书打印(<font color=red>' + zlpCount + '</font>)');
                    } else {
                        noteLicensePrint.setText('证书打印');
                    }
                } catch (e) {
                }
                try {
                    var noteOrgPrtYfm = TreePan.getNodeById('zzOrgPrtYfm-manage');
                    if (yfmdpCount > 0) {
                        noteOrgPrtYfm.setText('预赋码单打印(<font color=red>' + yfmdpCount + '</font>)');
                    } else {
                        noteOrgPrtYfm.setText('预赋码单打印');
                    }
                } catch (e) {
                }
                try {
                    var noteOrgPrtZxd = TreePan.getNodeById('zzOrgPrtZxd-manage');
                    if (fzdpCount > 0) {
                        noteOrgPrtZxd.setText('注销单打印(<font color=red>' + fzdpCount + '</font>)');
                    } else {
                        noteOrgPrtZxd.setText('注销单打印');
                    }
                } catch (e) {
                }
                try {
                    var noteOrgPrtQzd = TreePan.getNodeById('zzOrgPrtQzd-manage');
                    if (qzdpCount > 0) {
                        noteOrgPrtQzd.setText('迁址单打印(<font color=red>' + qzdpCount + '</font>)');
                    } else {
                        noteOrgPrtQzd.setText('迁址单打印');
                    }
                } catch (e) {
                }
            }
        }
    });
}

function showPrintCount() {//证书打印数量showPrintCount showDfileWT
    Ext.Ajax.request({
        url: 'findPrintCount.action',
        params: {
            dybz: 'Y',
            stateConditions: '100',
            handleDate: 'handleDate',
            czshbz: '1',
            start: 0,
            limit: useUpPageSize
        },
        success: function (result, request) {
            eval("var data= " + result.responseText);

            try {
                var noteDjdyParent = TreePan.getNodeById('djdyParent-manage');
                if (data.prtCount > 0) {
                    noteDjdyParent.expand(true);
                    //noteDjdyParent.setText('<font color=red>单据打印</font>');
                    noteDjdyParent.getUI().getIconEl().src = "images/memo.gif";
                } else {
                    noteDjdyParent.collapse(true);
                    //noteDjdyParent.setText('单据打印');
                    noteDjdyParent.getUI().getIconEl().src = "images/folder-open.gif";
                }
            } catch (e) {
            }

            try {
                var noteLicensePrint = TreePan.getNodeById('zzLicensePrint-manage');
                if (data.prtCount > 0) {
                    noteLicensePrint.setText('证书打印(<font color=red>' + data.prtCount + '</font>)');
                } else {
                    noteLicensePrint.setText('证书打印');
                }
            } catch (e) {
            }

        }
    });
}

function showDfileWT() {//zzDfileManage问题库计数
    Ext.Ajax.request({
        url: 'findDfileCount.action',
        params: {username: '', stateConditions: '', dflagConditions: '2', start: 0, limit: useFullPageSize},
        success: function (result, request) {
            eval("var data= " + result.responseText);

            try {
                var noteDjdyParent = TreePan.getNodeById('daglParent-manage');
                if (data.dfileCount > 0) {
                    noteDjdyParent.expand(true);
                    //noteDjdyParent.setText('<font color=red>单据打印</font>');
                    noteDjdyParent.getUI().getIconEl().src = "images/memo.gif";
                } else {
                    noteDjdyParent.collapse(true);
                    //noteDjdyParent.setText('单据打印');
                    noteDjdyParent.getUI().getIconEl().src = "images/folder-open.gif";
                }
            } catch (e) {
            }

            try {
                var noteLicensePrint = TreePan.getNodeById('zzDfileManage-manage');
                if (data.dfileCount > 0) {
                    noteLicensePrint.setText('问题库管理(<font color=red>' + data.dfileCount + '</font>)');
                } else {
                    noteLicensePrint.setText('问题库管理');
                }
            } catch (e) {
            }

        }
    });
}


Ext.onReady(function () {
    Ext.getDoc().on("contextmenu", function (e) {
        e.stopEvent();
    });

    setTimeout(function () {
        var CardSerialNo = "";
        Ext.get('loading').remove();
        Ext.getDom('header').style.visibility = 'visible';


        //点击叶子节点弹出窗口
//		TreePan.addListener('click', BiaoZhunClick);
//	    function BiaoZhunClick(node, e) {
//	        if (node.leaf) {
//	            var newWin = new Ext.Window({
//	                width: 745,
//	                height: 529,
//	                title: "现用技术标准",
//	                html: "<iframe src=\"Manage/VolunteerShipInfo.aspx\" marginheight=\"0\" marginwidth=\"0\" width=\"727\" height=\"500\"></iframe>"
//	            });
//	            newWin.show();
//	        }
//	    }

        var vp = new Ext.Viewport({
            layout: 'border',
            id: 'mainViewportId',
            defaults: {
                collapsible: true,
                split: true
            },
            items: [{
                id: 'top-panel',
                xtype: 'box',
                region: 'north',
                applyTo: 'header',
                height: 62,
                split: false
            }, {
                title: currentZzUserMsg,
                id: 'accordion-panel',
                layout: 'border',
                region: 'west',
                margins: '2 0 5 5',
                cmargins: '2 5 5 5',
                width: 185,
                minSize: 130,
                maxSize: 300,
                bodyStyle: 'background-color:#DFE8F6',
                autoScroll: true,
                defaults: {
                    border: false
                },
                bbar: [{
                    text: '开始',
                    iconCls: 'icon-plugin',
                    menu: new Ext.menu.Menu({
                        items: [{
                            text: '修改密码',
                            iconCls: 'icon-pwd',
                            handler: function () {
                                Ext.getCmp('content-panel').layout.setActiveItem('zzUserPwdSet-panel');
                            }
                        }, {
                            text: '个人设置',
                            iconCls: 'icon-user',
                            handler: function () {
                                Ext.getCmp('content-panel').layout.setActiveItem('zzUserConfigSet-panel');
                                searchUserConfigSet();
                            }
                        }, {
                            text: '重载菜单',
                            iconCls: 'icon-default',
                            handler: function () {
                                var navTree = Ext.getCmp('navTreeId');
                                var loader = rootTree;
                                loader.load(navTree.root);
                            }
                        }, {
                            text: '显示需办信息',
                            iconCls: 'icon-memo',
                            handler: function () {
                                showTreeMsg();
                                //showPrintCount();
                                showDfileWT();
                            }
                        }, {
                            text: '关于系统',
                            iconCls: 'icon-info',
                            handler: function () {
                                new Ext.Window({
                                    closeAction: 'close',
                                    resizable: false,
                                    bodyStyle: 'padding: 15',
                                    modal: true,
                                    title: '关于本系统',
                                    html: '本系统采用目前较为流行的技术实现,<br>前台使用了ExtJs技术,所以实现了跨浏览器<br>' +
                                        '本程序在IE6,IE7,IE9均测试通过!<br><br>主要技术: Struts2 + Spring2.5 + ExtJs2.2<br><br>'
                                        + '数&nbsp;&nbsp;据&nbsp;&nbsp;库: Microsoft SQL Server 2000<br><br>'
                                        + '当前档案扫描控件最新版本为<a href="downloadFlie/nacaoOcx.exe" target="_blank">' + scanWorkVersion + ' 下载</a>',
                                    width: 350,
                                    height: 230
                                }).show();
                            }
                        }, {
                            text: '退出系统',
                            iconCls: 'icon-delete',
                            handler: function () {
                                Ext.Msg.confirm('操作提示', '您确定要退出本系统?', function (btn) {
                                    if ('yes' == btn) {
                                        Ext.Ajax.request({
                                            url: 'logout.action',
                                            success: function () {
                                                location = 'index.jsp';
                                            },
                                            failure: function () {
                                                Ext.Msg.show({
                                                    title: '错误提示',
                                                    msg: '退出系统失败!',
                                                    icon: Ext.Msg.ERROR,
                                                    buttons: Ext.Msg.OK
                                                });
                                            }
                                        });
                                    }
                                });
                            }
                        }]
                    })
                }],
                items: [{
                    layout: 'accordion',
                    region: 'center',
                    layoutConfig: {
                        activeOnTop: true,             //设置打开的子面板置顶
                        fill: true,                     //子面板充满父面板的剩余空间
                        hideCollapseTool: true,         //隐藏“展开收缩”按钮
                        titleCollapse: false,     //允许通过点击子面板的标题来展开或收缩面板
                        animate: true          //使用动画效果
                    },
                    items: [{
                        title: '导航菜单',
                        iconCls: 'icon-nav',
                        id: 'treeNav',
                        border: false,
                        autoScroll: true,
                        items: [TreePan],
                        listeners: {
                            'click': function () {
                                alert("工具栏按钮")
                            }
                        }
                    }]
                }]
            }, {
                id: 'content-panel',
                region: 'center',
                layout: 'card',
                margins: '2 5 5 0',
                activeItem: 0,
                border: false,
                //items : [start,p_zzSysuser,p_zzDuty,p_zzWorkOrder,p_zzArchives,p_zzWorkShenhe,p_zzWorkQuery,p_zzArchivesDo,p_zzLicensePrint,p_zzLicensePrintFuben,p_zzLicensePrintTeshu,p_zzRegisterManage,p_zzLicenseLog,p_zzLicenseArchive,p_zzDfileQueryAll,p_zzDfileManage,p_zzDfileArchiveManage,p_zzDfileQueryArchive,p_zzDictIndex,p_zzDictDetail,p_zzXzqhManage,p_zzBzjgallManage,p_zzPzjgManage,p_zzSysConfigManage,p_zzCenter,p_zzBzjg,p_zzJglxManage,p_zzJjlxManage,p_zzHylxManage,p_zzYwnetSet,p_zzArchiveScan,p_zzXinban,p_zzNianjian,p_zzBiangen,p_zzHuanzheng,p_zzBuzheng,p_zzQianru,p_zzYufuma,p_zzQianchu,p_zzFeizhi,p_zzPiliangfeizhi,p_zzGoDfile,p_zzFeizhiHuifu,p_zzFeizhiHuifuManage,p_zzJggzSq,p_zzJggzManage,p_zzOrgPrtSqd,p_zzOrgPrtQzd,p_zzOrgPrtZxd,p_zzOrgPrtYfm,p_zzCardAudit,p_zzCardPrintSet,p_zzCardRead,p_zzCardWrite,p_zzDCardPrint,p_zzCardPrintLog,p_zzCardPrint,p_zzQXSet,p_zzZsscManage,p_zzTsfmManage,p_zzDataModify,p_zzUserPwdSet]//
                items: arrPfuncList
            }]
        });

    }, 250);
});

function luckPage() {
    Ext.MessageBox.prompt('解除锁定', '请输入锁定密码:', jiaoyanFunc);
}

function jiaoyanFunc(btn, text) {
    if (btn == 'ok') {
        if (text != '1234') {
            Ext.MessageBox.prompt('解除锁定', '请输入锁定密码:', jiaoyanFunc);
        }
    }
}

function showViewport() {
    //Ext.getDom('header').style.visibility = 'hidden';
    //var ss=Ext.getId('mainViewportId').getSize();
    var conHeight = Ext.getCmp('content-panel').getInnerHeight();
    var conWidth = Ext.getCmp('content-panel').getInnerWidth();
    alert(conHeight);
}


var taskMsg = {
    run: function () {
        showTreeMsg();
        //showPrintCount();
        showDfileWT();
    },
    interval: sysMsgInterval, //10分钟600000刷新一次
    repeat: sysMsgRepeat //循环次数0，为无限制
}

setTimeout(function () {
    Ext.TaskMgr.start(taskMsg);
}, 120000);
