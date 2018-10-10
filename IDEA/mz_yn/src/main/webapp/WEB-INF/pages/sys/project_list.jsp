<%@ page import="com.reimburse.common.util.ShiroUtils" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="row">
    <div class="col-xs-12">
        <div class="box">
            <div class="box-header">
                <h3 class="box-title">报销项目</h3>

                <div class="box-tools">
                    <div class="input-group input-group-sm" style="width: 350px;">
                        <input type="text" name="table_search" id="searchNameId"
                               class="form-control pull-right" placeholder="用户名">

                        <div class="input-group-btn">
                            <button type="button" class="btn btn-default btn-search">
                                <i class="fa fa-search"></i>
                            </button>
                            <button type="button" class="btn btn-default btn-add">添加</button>
                            <button type="button" class="btn btn-default btn-update">修改</button>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /.box-header -->
            <div class="box-body table-responsive no-padding">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th></th>
                        <th>报销项目</th>
                        <th>备注</th>
                        <th>创建时间</th>
                        <th>修改时间</th>
                        <th>操作</th>
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
</div>
<script type="text/javascript">
    $(document).ready(function () {
        $("#pageId").load("pageUI.do", function () {
            doGetObjects();
        });
        $(".input-group-btn")
            .on("click", ".btn-search", doQueryObjects)
            .on("click", ".btn-add,.btn-update", doAddOrUpdate);
        $("#tbodyId").on("click", ".btn-del", doDeleteById);
    });

    function doAddOrUpdate() {
        //1.判定点击的对象
        var title;
        if ($(this).hasClass("btn-add")) {
            title = "添加报销项目";
            doLoadEditPage(title);
        } else if ($(this).hasClass("btn-update")) {
            title = "修改报销项目";
            var id = getCheckedId();
            console.log("id=" + id);
            $(".container-fluid").data("id", id);
            doLoadEditPage(title);
        }
    }

    function getCheckedId() {
        return $("tbody input[name='radioId']:checked").val();
    }

    function doLoadEditPage(title) {
        var url = "project/editUI.do";
        $(".container-fluid").load(url, function () {
            $(".box-title").html(title);
        })
    }

    function doDeleteById() {
        var url = "project/doDeleteById.do";
        var id = $(this).parents("tr").data("id");
        var params = {"id": id};
        $.post(url, params, function (result) {
            if (result.state === 1) {
                alert(result.data);
                doGetObjects();
            } else {
                alert(result.message);
            }
        })
    }

    //处理查询按钮事件
    function doQueryObjects() {
        $(".pagination").data("pageCurrent", 1);
        doGetObjects();
    }

    //页面加载完成异步加载当前页数据
    function doGetObjects() {
        var url = "project/doFindAllProject.do";
        var pageCurrent = $(".pagination").data("pageCurrent");
        if (!pageCurrent) pageCurrent = 1;
        var params = {"pageCurrent": pageCurrent};
        params.username = $("#searchNameId").val().trim();
        $.post(url, params, function (result) {
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
        for (var i in data) {
            var tr = $("<tr></tr>");
            tr.data("id", data[i].id);
            tr.data("valid", data[i].valid);
            var modifiedTime = data[i].modifiedTime;
            if (modifiedTime == null || modifiedTime === "")
                modifiedTime = "";
            var tds = "<td><input type='radio' name='radioId' value='" + data[i].id + "' ></td>" +
                "<td>" + data[i].name + "</td>" +
                "<td>" + data[i].note + "</td>" +
                "<td>" + data[i].createdTime + "</td>" +
                "<td>" + modifiedTime + "</td>" +
                "<td><button type='button' class='btn btn-default btn-del'>" + '删除' + "</button></td>";
            tr.append(tds);
            tBody.append(tr);
        }
    }
</script>




