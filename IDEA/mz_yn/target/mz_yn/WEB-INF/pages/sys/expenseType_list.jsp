<%@ page contentType="text/html;charset=UTF-8" %>
<div class="row">
    <div class="col-xs-12">
        <div class="box">
            <div class="box-header">
                <h3 class="box-title">报销类型</h3>
                <div class="box-tools">
                    <button id="btnAdd" class="btn btn-default" type="button">添加</button>
                </div>
            </div>
            <!-- /.box-header -->
            <div class="box-body table-responsive no-padding">
                <table class="table table-hover" style="width: 50%;margin: 0 auto">
                    <thead>
                    <tr>
                        <th>报销类型</th>
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
        $(".box-tools").on("click","#btnAdd",doAdd);
        $("#tbodyId").on("click","#btnDel",doDel);
    });

    function doAdd() {
        var url = "expense/addUI.do";
        $(".container-fluid").load(url, function () {
            $(".box-title").html("新建报销类型");
        })
    }

    function doDel() {
        var url = "expense/doDeleteType.do";
        id = $(this).parents("tr").data("id");
        var params = {"id": id};
        $.post(url, params, function (result) {
            if (result.state === 1) {
                alert(result.data);
                doGetObjects()
            } else {
                alert(result.message);
            }
        });
    }

    //页面加载完成异步加载当前页数据
    function doGetObjects() {
        var url = "expense/doFindAllType.do";
        var pageCurrent = $(".pagination").data("pageCurrent");
        if (!pageCurrent) pageCurrent = 1;
        var params = {"pageCurrent": pageCurrent};
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
            var tds =
                "<td>" + data[i].expenseType + "</td>" +
                "<td><button id='btnDel' class='btn btn-default'>" + '删除' + "</button></td>";
            tr.append(tds);
            tBody.append(tr);
        }
    }
</script>
