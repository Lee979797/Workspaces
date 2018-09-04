<%@ page import="com.ninemax.jpa.code.model.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html; charset=gbk" isELIgnored="false" %>
<%--@elvariable id="ttables" type="java.util.List<com.ninemax.jpa.code.model.Ttable>"--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
<link type="text/css" href="/css/jquery-ui-1.8.7.custom.css" rel="stylesheet"/>
<link href="/css/style.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" id='skin' type="text/css" href="/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css"/>
<script type='text/javascript' src="/js/calendar/WdatePicker.js"></script>
<script type="text/javascript" src="/js/jgdmSearch.js"></script>
<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>
<script type="text/javascript" src="/dwr/interface/sysBus.js"></script>
<script type="text/javascript" src="/dwr/interface/spBus.js"></script>
<script type="text/javascript" src="/dwr/interface/jgdmBus.js"></script>
<script type="text/javascript" src="/dwr/interface/fzdmBus.js"></script>
<script type="text/javascript" src="/dwr/interface/kqnjBus.js"></script>
<script type="text/javascript" src="/dwr/interface/codecheck.js"></script>
<script type="text/javascript" src="/dwr/interface/czjlBus.js"></script>
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/jquery-ui-1.8.7.custom.min.js"></script>
<script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
<script type='text/javascript' src='/js/tools.js'></script>
<script type="text/javascript" src="/js/ajaxfileupload.js" ></script>  
<script type="text/javascript">
    $(function () {
        $("#txtvalue").focus();
    })
    document.onkeydown = function () {
        if (event.keyCode == '13') {
            event.keyCode = 9;
        }
    }
</script>

<title>��Ϣ��ѯ</title>
<script type="text/javascript">
var fields = ['nnjjlx', 'nnjjhy', 'njjlx', 'njjhy', 'zycp3', 'zycp2', 'zycp1', 'zgdm', 'hbzl', 'wftzgb', 'xzqh', 'pzjgdm', 'jjlx', 'jjhy', 'jglx', 'njglx'];
function fCheckValue() {
    var sql = document.getElementById('where').innerHTML;
    if (undefined == sql || "" == sql) {
        ymPrompt.alert({message: "����Ӳ�ѯ��������ִ�м�����", width: 330, height: 220, title: '��ʾ��Ϣ'});
        return;
    }
    document.thisForm.sqlwhere.value = sql;
    var regSQL = /^.*and(\s*)$/;
    var regSQL2 = /^.*or(\s*)$/;
    if (regSQL.exec(sql)) {
        document.thisForm.sqlwhere.value = sql.substring(0, sql.lastIndexOf("and"));
    }
    if (regSQL2.exec(sql)) {
        document.thisForm.sqlwhere.value = sql.substring(0, sql.lastIndexOf("or"));
    }
    document.thisForm.sqlwhere.value = sql.replace(/=\s*(\w)/g, " = '$1'");
    document.thisForm.order.value = ' order by ' + document.thisForm.orderby.value + " " + document.thisForm.ordercode.value;
    document.thisForm.submit();
}
function callBack(tp) {
    if (tp != 'close' && tp != '') {
        var values = tp.split(';');
        var dms = values[0].split(':');
        var mcs = values[1].split(":");
        $("#propbar").show();
        document.getElementById("txtvalue").value = dms[0];
        document.getElementById("valuemc").innerHTML = mcs[0];
    }
}
function setcode() {
//    document.thisForm.relations.options.length = 0;
    var strCondi = ":!=:like:&gt;:&gt;=:=:&lt;=:";
    var conditions = strCondi.split(":");
    var index = 0;
    var columns = document.thisForm.column.value.split(":");
    var isSelect = false;
    var isDate = false;
    var isNumber = false;
    var obj;
    obj = $("#txtvalue");
    obj.val("");
    $("#propbar").hide();
    $("#valuemc").html("");
    for (var i = 0; i < fields.length; i++) {
        if (columns[0] == fields[i]) {
            if ("zgdm" == columns[0]) {
                columns[0] = 'zgjg';
            }
            if ("wftzgb" == columns[0]) {
                columns[0] = 'wfgb';
            }
            if ("pzjgdm" == columns[0]) {
                columns[0] = 'pzjg';
            }
            isSelect = true;
            break;
        }
    }
    /*  switch (columns[1]) {
     case '1':
     {
     document.thisForm.relations.options.add(new Option("����(=)", "="));
     document.thisForm.relations.options.add(new Option("������(<>)", "<>"));
     document.thisForm.relations.options.add(new Option("Ϊ��", "is null"));
     document.thisForm.relations.options.add(new Option("��Ϊ��", "is not null"));
     if (!isSelect) {
     document.thisForm.relations.options.add(new Option("����(like)", "like"));
     }
     break;
     }
     case '2':
     {
     document.thisForm.relations.options.add(new Option("����(=)", "="));
     document.thisForm.relations.options.add(new Option("����(>)", ">"));
     document.thisForm.relations.options.add(new Option("���ڵ���(>=)", ">="));
     document.thisForm.relations.options.add(new Option("С��(<)", "<"));
     document.thisForm.relations.options.add(new Option("С�ڵ���(<=)", "<="));
     document.thisForm.relations.options.add(new Option("������(<>)", "<>"));
     document.thisForm.relations.options.add(new Option("Ϊ��", "is null"));
     document.thisForm.relations.options.add(new Option("��Ϊ��", "is not null"));
     isNumber = true;

     break;
     }
     case '3' :
     {
     document.thisForm.relations.options.add(new Option("����(=)", "="));
     document.thisForm.relations.options.add(new Option("����(>)", ">"));
     document.thisForm.relations.options.add(new Option("���ڵ���(>=)", ">="));
     document.thisForm.relations.options.add(new Option("С��(<)", "<"));
     document.thisForm.relations.options.add(new Option("С�ڵ���(<=)", "<="));
     document.thisForm.relations.options.add(new Option("������(<>)", "<>"));
     document.thisForm.relations.options.add(new Option("Ϊ��", "is null"));
     document.thisForm.relations.options.add(new Option("��Ϊ��", "is not null"));
     isDate = true;
     break;
     }

     }*/
    if (isDate) {
        $("#txtvalue").unbind().bind('click', function () {
            WdatePicker({el: $dp.$('zcrq')});
        });
        $("#dateselect").show();
        return;
    } else {
        $("#txtvalue").attr("readonly", false);
        $("#dateselect").hide();
    }
    if (isNumber) {
        $("#txtvalue").unbind().bind("keyup", function () {
            if (/^\d*\.?\d*$/.test(obj.val())) {
                return true;
            }
            obj.val(obj.val().replace(/\D/g, ""));
            return false;
        }).bind("blur", function () {
            if (/^\d*\.?\d*$/.test(obj.val())) {
                return true;
            }
            obj.val(obj.val().replace(/\D/g, ""));
            obj.focus();
            return false;
        });
        $("#dateselect").hide();
        return;
    } else {
        $("#txtvalue").attr("readonly", false);
        $("#dateselect").hide();
    }

    if (isSelect) {
        var source = "/action/autoComplete?method=" + columns[0] + "&rand=" + new Date().getTime();
        var message = "/bsweb/select_search.action?source=t_" + columns[0];
        $("#txtvalue").attr("readonly", false).unbind().autocomplete({
            autofill: true,
            source: source,
            select: function (event, ui) {
                this.value = ui.item.dm;
                $("#propbar").show();
                $("#valuemc").html(ui.item.mc);
                return false;
            },
            change: function (event, ui) {
                this.value = ui.item.dm;
                $("#propbar").show();
                $("#valuemc").html(ui.item.mc);
                return false;
            }
        }).data("autocomplete")._renderItem = function (ul, item) {
            return $("<li></li>").data("item.autocomplete", item).append("<a style='width:188px;height:20px;'>" + "<span style='float:left;'>" + item.dm + "</span>" + "<span style='float:right;'>" + (item.mc.length > 8 ? item.mc.substring(0, 7) + '...' : item.mc) + "</span>" + "</a>").appendTo(ul);
        };
        /*  $("#txtselect").unbind().bind('click', function () {
         ymPrompt.win({message: message, handler: callBack, width: 630, height: 460, dragOut: false, title: '��Ϣ��ѯ', iframe: true});
         });
         $("#select").show();*/
        return;
    } else {
        /*  $("#select").hide();*/

    }
    if (!(isDate || isSelect)) {
        $("#txtvalue").unbind();
    }


}

function addToCondition() {
    var column = document.thisForm.column;
    var txtvalue = document.thisForm.txtvalue;
    var sqlwhere = document.thisForm.sqlwhere;
    var relation = document.thisForm.relations;
    sqlwhere.value = document.getElementById('where').innerHTML;
    if (column.value == undefined) {
        ymPrompt.alert({message: "��ѡ�������ֶ�", handle: function () {
            column.focus();
        }});
        return;
    }
    if (!/\s*is\s*((not)?)\s+null\s*/i.test(relation.value) && ( txtvalue.value == undefined || txtvalue.value == '')) {
        ymPrompt.alert({message: "��������ʵĲ�ѯֵ", handle: function () {
            txtvalue.focus();
        }});
        return;
    }
    if (sqlwhere.value == undefined) {
        sqlwhere.value = '';
    }
    if ((sqlwhere.value != '') && (!/[\s\S]*(and|or)[\s]*$/i.test(sqlwhere.value))) {
        sqlwhere.value += " and ";
    }
    sqlwhere.value += column.value.split(":")[0] + " " + relation.value + " ";
    if (!/\s*is\s*((not)?)\s+null\s*/i.test(relation.value)) {
        if ("like" == relation.value) {
            sqlwhere.value += ( "'%" + txtvalue.value + "%'");
        } else if ("likl" == relation.value) {
            sqlwhere.value = sqlwhere.value.replace("likl", "like");
            sqlwhere.value += ("'" + txtvalue.value + "%'");
        } else {
            sqlwhere.value += (" '" + txtvalue.value + "' ");
        }
        sqlwhere.value += document.thisForm.logic.value + " ";
    }
    document.getElementById('where').innerHTML = sqlwhere.value;
}

function clearSQL() {
    document.thisForm.sqlwhere.value = '';
    document.getElementById('where').innerHTML = "";
}

/* xiaruibo 20170515 �ϴ�excel */
	function importEmp(){  
	    //���鵼����ļ��Ƿ�ΪExcel�ļ�  
	    var excelPath = document.getElementById("xls").value;  
	    if(excelPath == null || excelPath == ''){  
	        alert("��ѡ��Ҫ�ϴ���Excel�ļ�");  
	        return;  
	    }else{  
	        var fileExtend = excelPath.substring(excelPath.lastIndexOf('.')).toLowerCase();   
	        if(fileExtend == '.xls'){  
	        }else{  
	            alert("�ļ���ʽ��Ϊ'.xls'��ʽ");  
	            return;  
	        }  
	    } 
	     ymPrompt.win({message: '/product/jsp/statistics/loading.html', width: 300, height: 100, titleBar: false, iframe: true}); 
	    //�ύ��  
	    document.getElementById("empForm").submit();  
	}  

</script>
</head>
<body style="background:#fff;">
<div class="page_top" style="background:#F8F8F8">${title}</div>
<div id="box">
    <div id="content">
        <div id="right">
            <div class="rightpart">
                <div class="list">
                    <form id="empForm" enctype="multipart/form-data" method="post" action="/bsweb/statistics_import_search.action" >

                        <h1 align="center" style="text-align: center; height:40px; line-height: 40px; font-size: 16px;">
                           �������ݵ���(.xls)
                        </h1>
                        <table align="center" border="1" bordercolor="#C4DBE5" cellspacing="0" cellpadding="10"
                               width="100%" style="border-collapse: collapse; background: #EAF6FB;">
                            
                            <tr>
                                <td align="right">��ѡ���ļ���</td>
                                <td align="left" valign="middle" colspan="3">
									<input type="file" id="xls" name= "xls" value="ѡ���ļ�">
									<input type="button" class="newBtn1" onclick="importEmp()" value="�ϴ�">
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>


</html>
