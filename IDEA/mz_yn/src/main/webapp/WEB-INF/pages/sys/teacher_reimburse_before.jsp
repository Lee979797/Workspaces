<%@ page import="com.reimburse.common.util.ShiroUtils" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="row">
    <div class="col-xs-12">
        <div class="box">
            <div class="box-header">
                <h3 class="box-title">待审批</h3>

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
                <div id="modalHeader" class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title" id="myModalLabel">报销单详情</h4>
                </div>
                <div class="modal-body" id="modalBody">
                    ...
                </div>
                <div id="modalFooter" class="modal-footer">
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
</div>
<script type="text/javascript">
    var billName;
    $(document).ready(function () {
        $("#pageId").load("pageUI.do", function () {
            doGetObjects();
        });
        $(".input-group-btn")
            .on("click", ".btn-search", doQueryObjects)
            .on("click", ".btn-add", doAdd);
        $("tbody").on("click", ".btn-view", doViewById);
        $("#modalBody").on("click", ".btn-bill", doLoadBill);
        $("#modalHeader").on("click", ".close", doGetObjects);
        $("#modalFooter").on("click", "#btn-close", doGetObjects);
    });

    function doLoadBill() {
        var billBody = $("#billBody");
        billBody.empty();
        var img = $("<img src='/upload/" + billName + "' style='width: 570px'>");
        billBody.append(img);
    }

    function doViewById() {
        var url = "reimburse/doFindObjectById.do";
        var id = $(this).parents("tr").data("id");
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

    function setModalBody(data) {
        var modalBody = $("#modalBody");
        modalBody.empty();
        console.log(data);
        var table = $("<table class='table table-hover'></table>");
        table.data("id", data.id);
        billName = data.bill;
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
            "<tr><td>" + '审批状态' + "</td><td>" + '审批中' + "</td></tr>" +
            "<tr><td>" + '创建人' + "</td><td>" + data.createdUser + "</td></tr>" +
            "<tr><td>" + '创建时间' + "</td><td>" + data.createdTime + "</td></tr>" +
            "<tr><td>" + '审批人' + "</td><td>" + data.modifiedUser + "</td></tr>" +
            "<tr><td>" + '审批时间' + "</td><td>" + '审批中' + "</td></tr>";
        table.append(trs);
        modalBody.append(table);
    }

    function doAdd() {
        doLoadEditPage("新建报销单")
    }

    function doLoadEditPage(title) {
        var url = "reimburse/editUI.do";
        $(".container-fluid").load(url, function () {
            $(".box-title").html(title);
        })
    }

    //处理查询按钮事件
    function doQueryObjects() {
        $(".pagination").data("pageCurrent", 1);
        doGetObjects();
    }

    //页面加载完成异步加载当前页数据
    function doGetObjects() {
        var url = "reimburse/doFindPageObjects.do";
        var pageCurrent = $(".pagination").data("pageCurrent");
        if (!pageCurrent) pageCurrent = 1;
        var params = {"pageCurrent": pageCurrent};
        params.title = $("#searchNameId").val().trim();
        params.user = "<%=ShiroUtils.getPrincipal() %>";
        params.examineState = "0";
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
            var comment = data[i].comment;
            if (comment == null || comment === "")
                comment = "无";
            var tds =
                "<td>" + data[i].reimburseId + "</td>" +
                "<td>" + data[i].title + "</td>" +
                "<td>" + data[i].type + "</td>" +
                "<td>" + data[i].project + "</td>" +
                "<td>" + data[i].money + "</td>" +
                "<td>" + '审批中' + "</td>" +
                "<td>" + data[i].createdTime + "</td>" +
                "<td>" + comment + "</td>" +
                "<td><button type='button' class='btn btn-primary btn-lg btn-view' data-toggle='modal' data-target='#myModal'>" + '查看' + "</button></td>";
            tr.append(tds);
            tBody.append(tr);
        }
    }
</script>
