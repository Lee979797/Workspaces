<%@ page import="com.reimburse.common.util.ShiroUtils" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<style>
    .div-print {
        display: none;
    }

    @media print {
        .div-print {
            display: block;
        }
    }
</style>
<div class="row">
    <div class="col-xs-12">
        <div class="box">
            <div class="box-header">
                <h3 class="box-title">我的审批</h3>

                <div class="box-tools">
                    <div class="input-group input-group-sm" style="width: 350px;">
                        <input type="text" name="table_search" id="searchNameId"
                               class="form-control pull-right" placeholder="请输入报销单号/标题">
                        <div class="input-group-btn">
                            <button type="button" class="btn btn-default btn-search">
                                <i class="fa fa-search"></i>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /.box-header -->
            <div class="box-body table-responsive no-padding">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>申请人</th>
                        <th>报销单号</th>
                        <th>报销标题</th>
                        <th>报销类型</th>
                        <th>报销项目</th>
                        <th>报销金额</th>
                        <th>报销状态</th>
                        <th>创建时间</th>
                        <th>备注</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody id="tbodyId"></tbody>
                </table>
            </div>
            <div id="pageId" class="box-footer clearfix">
            </div>
            <!-- /.box-body -->
        </div>
        <!-- /.box -->
    </div>
    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header" id="modalHeader">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title" id="myModalLabel">报销单详情</h4>
                </div>
                <div class="modal-body" id="modalBody">
                    ...
                </div>
                <div class="modal-footer" id="modalFooter">
                    <button id="btn-close" type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
    <div class="modal fade" id="myBill" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title" id="myBillLabel">票据详情</h4>
                </div>
                <div class="modal-body" id="billBody">
                    ...
                </div>
                <div class="modal-footer">
                    <button id="btnClose" type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
    <!--startprint-->
    <div class="div-print">
        ...
    </div>
    <!--endprint-->
</div>
<script type="text/javascript">
    var billName;
    var id;
    $(document).ready(function () {
        $("#pageId").load("pageUI.do", function () {
            doGetObjects();
        });
        $(".input-group-btn")
            .on("click", ".btn-search", doQueryObjects)
            .on("click", ".btn-add", doAdd);
        $("#tbodyId")
            .on("click", "#btnPrint", printObj)
            .on("click", ".btn-view", doViewById);
        $("#modalBody").on("click", ".btn-bill", doLoadBill);
        $("#modalHeader").on("click", ".close", doGetObjects);
        $("#modalFooter")
            .on("click", "#btn-close", doGetObjects)
            .on("click", ".btnPass", doPass)
            .on("click", ".btnFail", doFail);
    });

    function doPrint() {
        bdhtml = window.document.body.innerHTML;
        sprnstr = "<!--startprint-->"; //开始打印标识字符串有17个字符
        eprnstr = "<!--endprint-->"; //结束打印标识字符串
        prnhtml = bdhtml.substr(bdhtml.indexOf(sprnstr) + 17); //从开始打印标识之后的内容
        prnhtml = prnhtml.substring(0, prnhtml.indexOf(eprnstr)); //截取开始标识和结束标识之间的内容
        window.document.body.innerHTML = prnhtml; //把需要打印的指定内容赋给body.innerHTML
        window.print(); //调用浏览器的打印功能打印指定区域
        window.document.body.innerHTML = bdhtml;//重新给页面内容赋值
        $(function () {
            $(".container-fluid")
                .load("accountant/listUI.do")
                .removeData("id");
        });
        $(function () {
            $("#load-all-id").click(function () {
                $(".container-fluid").load("accountant/listUI.do", function () {
                    $(".container-fluid").removeData();
                });//t=Math.random();
            });
            $("#load-ing-id").click(function () {
                $(".container-fluid").load("accountant/ingListUI.do", function () {
                    $(".container-fluid").removeData();
                });//t=Math.random();
            });
            $("#load-pass-id").click(function () {
                $(".container-fluid").load("accountant/passListUI.do", function () {
                    $(".container-fluid").removeData();
                });//t=Math.random();
            });
            $("#load-fail-id").click(function () {
                $(".container-fluid").load("accountant/failListUI.do", function () {
                    $(".container-fluid").removeData();
                });//t=Math.random();
            });
            $("#load-start1-id").click(function () {
                $(".container-fluid").load("user/accountantStartUI.do", function () {
                    $(".container-fluid").removeData();
                });//t=Math.random();
            });
            $("#load-start2-id").click(function () {
                $(".container-fluid").load("user/accountantStartUI.do", function () {
                    $(".container-fluid").removeData();
                });//t=Math.random();
            })
        });
    }

    function printObj() {
        var url = "reimburse/doFindObjectById.do";
        var id = $(this).parents("tr").data("id");
        var params = {"id": id};
        $.post(url, params, function (result) {
            if (result.state === 1) {
                setPrintBody(result.data);
                setPagination(result.data);
            } else {
                alert(result.message);
            }
        });
    }

    function doLoadBill() {
        var billBody = $("#billBody");
        billBody.empty();
        var img = $("<img src='/upload/" + billName + "' style='width: 570px'>");
        billBody.append(img);
    }

    function doPass() {
        var url = "accountant/doExamineById.do";
        var params = {"id": id};
        params.examineState = 1;
        $.post(url, params, function (result) {
            if (result.state === 1) {
                alert(result.data);
                doGetObjects();
            } else {
                alert(result.message)
            }
        })
    }

    function doFail() {
        var url = "accountant/doExamineById.do";
        var params = {"id": id};
        params.examineState = 2;
        $.post(url, params, function (result) {
            if (result.state === 1) {
                alert(result.data);
                doGetObjects();
            } else {
                alert(result.message)
            }
        })
    }

    function doViewById() {
        var url = "reimburse/doFindObjectById.do";
        id = $(this).parents("tr").data("id");
        var params = {"id": id};
        $.post(url, params, function (result) {
            if (result.state === 1) {
                setModalBody(result.data);
                setPagination(result.data);
            } else {
                alert(result.message);
            }
        });
    }

    function setPrintBody(data) {
        var printBody = $(".div-print");
        printBody.empty();
        var table = $("<table class='table table-hover'></table>");
        table.data("id", data.id);
        var state;
        var modifiedTime = data.modifiedTime;
        if (data.examineState === 0) {
            state = "审批中";
            modifiedTime = "审批中";
        }
        else if (data.examineState === 1) {
            state = "已审批";
        }
        else if (data.examineState === 2) {
            state = "未通过";
        }
        var comment = data.comment;
        if (comment == null || comment === "")
            comment = "无";
        var trs =
            "<tr><td>" + '报销单编号' + "</td><td>" + data.reimburseId + "</td></tr>" +
            "<tr><td>" + '报销标题' + "</td><td>" + data.title + "</td></tr>" +
            "<tr><td>" + '报销类型' + "</td><td>" + data.type + "</td></tr>" +
            "<tr><td>" + '报销项目' + "</td><td>" + data.project + "</td></tr>" +
            "<tr><td>" + '报销金额' + "</td><td>" + data.money + "</td></tr>" +
            "<tr><td>" + '备注' + "</td><td>" + comment + "</td></tr>" +
            "<tr><td>" + '审批状态' + "</td><td>" + state + "</td></tr>" +
            "<tr><td>" + '创建人' + "</td><td>" + data.createdUser + "</td></tr>" +
            "<tr><td>" + '创建时间' + "</td><td>" + data.createdTime + "</td></tr>" +
            "<tr><td>" + '审批人' + "</td><td>" + '<%=ShiroUtils.getPrincipal()%>' + "</td></tr>" +
            "<tr><td>" + '审批时间' + "</td><td>" + modifiedTime + "</td></tr>";
        var h = $("<h3 style='text-align: center'>" + '票据' + "</h3>");
        var img = $("<div style='margin: 0 auto;width: 400px'><img src='/upload/" + data.bill + "' style='width: 400px'><div>");
        table.append(trs);
        printBody.append(table);
        printBody.append(h);
        printBody.append(img);
        doPrint();
    }

    function setModalBody(data) {
        var modalBody = $("#modalBody");
        var modalFooter = $("#modalFooter");
        var buttonPass = $("<button class='btn btn-default btnPass' data-dismiss='modal'>同意</button>");
        var buttonFail = $("<button class='btn btn-default btnFail' data-dismiss='modal'>驳回</button>");
        var buttonClose = $("<button id='btn-close' type='button' class='btn btn-default' data-dismiss='modal'>Close</button>");
        modalBody.empty();
        modalFooter.empty();
        billName = data.bill;
        var table = $("<table class='table table-hover'></table>");
        table.data("id", data.id);
        var state;
        var modifiedTime = data.modifiedTime;
        if (data.examineState === 0) {
            state = "审批中";
            modifiedTime = "审批中";
            modalFooter.append(buttonPass);
            modalFooter.append(buttonFail);
        }
        else if (data.examineState === 1) {
            state = "已审批";
        }
        else if (data.examineState === 2) {
            state = "未通过";
        }
        modalFooter.append(buttonClose);
        var comment = data.comment;
        if (comment == null || comment === "")
            comment = "无";
        var trs =
            "<tr><td>" + '报销单编号' + "</td><td>" + data.reimburseId + "</td></tr>" +
            "<tr><td>" + '报销标题' + "</td><td>" + data.title + "</td></tr>" +
            "<tr><td>" + '报销类型' + "</td><td>" + data.type + "</td></tr>" +
            "<tr><td>" + '报销项目' + "</td><td>" + data.project + "</td></tr>" +
            "<tr><td>" + '报销金额' + "</td><td>" + data.money + "</td></tr>" +
            "<tr><td>" + '备注' + "</td><td>" + comment + "</td></tr>" +
            "<tr><td>" + '票据' + "</td><td><button type='button' class='btn btn-primary btn-lg btn-bill' data-toggle='modal' data-target='#myBill'>" + '查看' + "</button></td></tr>" +
            "<tr><td>" + '审批状态' + "</td><td>" + state + "</td></tr>" +
            "<tr><td>" + '创建人' + "</td><td>" + data.createdUser + "</td></tr>" +
            "<tr><td>" + '创建时间' + "</td><td>" + data.createdTime + "</td></tr>" +
            "<tr><td>" + '审批人' + "</td><td>" + '<%=ShiroUtils.getPrincipal()%>' + "</td></tr>" +
            "<tr><td>" + '审批时间' + "</td><td>" + modifiedTime + "</td></tr>";
        table.append(trs);
        modalBody.append(table);
    }

    function doAdd() {
        $(".container-fluid").load("reimburse/editUI.do", function () {
            $(".container-fluid").removeData();
        });//t=Math.random();
    }

    //处理查询按钮事件
    function doQueryObjects() {
        $(".pagination").data("pageCurrent", 1);
        doGetObjects();
    }

    //页面加载完成异步加载当前页数据
    function doGetObjects() {
        var url = "accountant/doFindPageObjects.do";
        var pageCurrent = $(".pagination").data("pageCurrent");
        if (!pageCurrent) pageCurrent = 1;
        var params = {"pageCurrent": pageCurrent};
        params.title = $("#searchNameId").val().trim();
        params.user = "<%=ShiroUtils.getPrincipal() %>";
        console.log(params);
        $.getJSON(url, params, function (result) {
            if (result.state === 1) {
                setTableBodyRows(result.data.records);
                setPagination(result.data);
            } else {
                alert(result.message);
            }
        });
    }

    //通过服务端返回的数据初始化页面
    function setTableBodyRows(data) {
        //1.获取tbody对象，并清空内容
        var tBody = $("#tbodyId");
        tBody.empty();
        //2.迭代data内容将数据追加到tbody中
        console.log(data);
        for (var i in data) {
            var tr = $("<tr></tr>");
            tr.data("id", data[i].id);
            var state;
            if (data[i].examineState === 0)
                state = "审批中";
            else if (data[i].examineState === 1)
                state = "已审批";
            else if (data[i].examineState === 2)
                state = "未通过";
            var comment = data[i].comment;
            if (comment == null || comment === "")
                comment = "无";
            var tds =
                "<td>" + data[i].createdUser + "</td>" +
                "<td>" + data[i].reimburseId + "</td>" +
                "<td>" + data[i].title + "</td>" +
                "<td>" + data[i].type + "</td>" +
                "<td>" + data[i].project + "</td>" +
                "<td>" + data[i].money + "</td>" +
                "<td>" + state + "</td>" +
                "<td>" + data[i].createdTime + "</td>" +
                "<td>" + comment + "</td>" +
                "<td><button type='button' class='btn btn-primary btn-lg btn-view' data-toggle='modal' data-target='#myModal'>" + '查看' + "</button></td>";
            tr.append(tds);
            if (data[i].examineState !== 0) {
                var tdPrint = "<td><button id='btnPrint' type='button' class='btn btn-default'>" + '打印' + "</button></td>";
                tr.append(tdPrint)
            }
            tBody.append(tr);
        }
    }
</script>
