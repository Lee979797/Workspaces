<%@ page contentType="text/html;charset=UTF-8" %>
<!-- Horizontal Form -->
<div class="box box-info">
    <div class="box-header with-border">
        <h3 class="box-title">新建报销单</h3>
    </div>
    <!-- /.box-header -->
    <!-- form start -->
    <form class="form-horizontal" enctype="multipart/form-data" method="post" name="myForm" id="myForm">
        <div class="box-body">
            <div class="form-group">
                <label for="title" class="col-sm-2 control-label">报销标题</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="title" name="title">
                </div>
            </div>
            <div class="form-group">
                <label for="project" class="col-sm-2 control-label">报销项目</label>
                <div class="col-sm-10">
                    <%--<input type="text" class="form-control" id="project" name="project">--%>
                    <select id="project" class="form-control" name="project" onchange="doLoadTypes()">
                        <option value="-1">请选择项目</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="type" class="col-sm-2 control-label">报销类型</label>
                <div class="col-sm-10">
                    <%--<input type="text" class="form-control" id="type" name="type">--%>
                    <select id="type" class="form-control" name="type">
                        <option value="-1">请选择类型</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="money" class="col-sm-2 control-label">报销金额</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="money" name="money">
                </div>
            </div>
            <div class="form-group">
                <label for="comment" class="col-sm-2 control-label">备注</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="comment" name="comment"/>
                </div>
            </div>
            <div class="form-group" name="bill">
                <label for="file" class="col-sm-2 control-label">上传票据</label>
                <div class="col-sm-10" name="billFile">
                    <input type="file" class="form-control" id="file" name="file">
                </div>
            </div>
        </div>
        <!-- /.box-body -->
        <div class="box-footer">
            <button type="button" class="btn btn-default btn-cancel">返回</button>
            <button type="button" class="btn btn-info pull-right btn-save">提交</button>
        </div>
        <!-- /.box-footer -->
    </form>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        doLoadProject();
        $(".box-footer")
            .on("click", ".btn-cancel", doCancel)
            .on("click", ".btn-save", doSave);
    });

    function doCancel() {
        $(".container-fluid")
            .load("reimburse/listUI.do")
            .removeData("id");
    }

    function doSave() {
        var formData = new FormData($("#myForm")[0]);
        $.ajax(
            {
                url: 'reimburse/upload.do',
                type: 'POST',
                data: formData,
                contentType: false, //禁止设置请求类型
                processData: false, //禁止jquery对DAta数据的处理,默认会处理
                //禁止的原因是,FormData已经帮我们做了处理
                success: function (result) {
                    //测试是否成功
                    //但需要你后端有返回值
                    if (result.state === 1) {
                        alert(result.message);
                        doCancel();
                    } else {
                        alert(result.message);
                    }
                }
            }
        );
    }

    function doLoadProject() {
        var url = "project/doFindAll.do";
        $.post(url, function (result) {
            if (result.state === 1) {
                doLoadP(result.data)
            } else {
                alert(result.message);
            }
        })
    }

    function doLoadP(data) {
        var project = $("#project");
        project.empty();
        var defOption = "<option id='-1'>" + '请选择项目' + "</option>";
        project.append(defOption);
        for (var i in data) {
            var option = "<option id='" + data[i].id + "'>" + data[i].name + "</option>";
            project.append(option);
        }
    }

    function doLoadTypes() {
        var projectId = $('#project>option:selected')[0].id;
        var url = "project/doFindTypeById.do";
        if (projectId === -1) {
            alert("必须选择一个项目!")
        }
        var params = {"id": projectId};
        $.post(url, params, function (result) {
            if (result.state === 1) {
                doLoadT(result.data)
            } else {
                alert(result.message);
            }
        })
    }

    function doLoadT(data) {
        var type = $("#type");
        type.empty();
        var defOption = "<option>" + '请选择类型' + "</option>";
        type.append(defOption);
        for (var i in data) {
            var option = "<option>" + data[i] + "</option>";
            type.append(option);
        }
    }

</script>
