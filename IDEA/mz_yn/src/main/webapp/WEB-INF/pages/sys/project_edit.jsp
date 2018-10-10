<%@ page contentType="text/html;charset=UTF-8" %>
<!-- Horizontal Form -->
<div class="box box-info">
    <div class="box-header with-border">
        <h3 class="box-title">添加报销项目</h3>
    </div>
    <!-- /.box-header -->
    <!-- form start -->
    <form class="form-horizontal">
        <div class="box-body">
            <div class="form-group">
                <label for="projectNameId" class="col-sm-2 control-label">项目名称</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="projectNameId">
                </div>
            </div>
            <div class="form-group">
                <label for="noteId" class="col-sm-2 control-label">备注</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="noteId">
                </div>
            </div>
            <div class="form-group">
                <label for="rolesId" class="col-sm-2 control-label">项目报销类型</label>
                <div class="col-sm-10" id="rolesId">
                </div>
            </div>
        </div>
        <!-- /.box-body -->
        <div class="box-footer">
            <button type="button" class="btn btn-default btn-cancel">Cancel</button>
            <button type="button" class="btn btn-info pull-right btn-save">Save</button>
        </div>
        <!-- /.box-footer -->
    </form>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        doLoadRoles();
        $(".box-footer")
            .on("click", ".btn-cancel", doCancel)
            .on("click", ".btn-save", doSaveOrUpdate);
    });

    function doCancel() {
        $(".container-fluid")
            .load("project/listUI.do")
            .removeData("id");
    }

    function doSaveOrUpdate() {
        var id = $(".container-fluid").data("id");
        //1.获取表单数据
        var params = getEditFormData();
        if (id) params.id = id;
        //2.发起异步请求
        var insertUrl = "project/doSaveObject.do";
        var updateUrl = "project/doUpdateObject.do";
        var url = id ? updateUrl : insertUrl;
        $.post(url, params, function (result) {
            if (result.state === 1) {
                alert(result.message);
                doCancel();
            } else {
                alert(result.message);
            }
        })
    }

    function getEditFormData() {
        //获取用户输入的数据
        var params = {
            name: $("#projectNameId").val(),
            note: $("#noteId").val()
        };
        //获取选择的角色
        var roleIds = [];
        $("#rolesId input[name='roleId']")
            .each(function () {
                if ($(this).prop("checked")) {
                    roleIds.push($(this).val());
                }
            });
        params.roleIds = roleIds.toString();
        return params;
    }

    function doLoadRoles() {
        var url = "project/doFindTypes.do";
        $.post(url, function (result) {
            if (result.state === 1) {
                console.log(result);
                doInitPageRoles(result.data);
                var id = $(".container-fluid").data("id");
                if (id) doFindObjectById(id);
            } else {
                alert(result.message);
            }
        })
    }

    function doFindObjectById(id) {
        var url = "project/doFindObjectById.do";
        var params = {"id": id};
        $.getJSON(url, params, function (result) {
            if (result.state === 1) {
                doInitFormData(result.data);
            } else {
                alert(result.message);
            }
        })
    }

    function doInitFormData(data) {
        //初始化用户信息
        $("#projectNameId").val(data.user.name);
        $("#noteId").val(data.user.note);
        //初始化用户角色信息
        var ids = data.roleIds;
        for (var i in ids) {
            $("#rolesId input[value='" + ids[i] + "']").prop("checked", true);
        }
    }

    function doInitPageRoles(data) {
        //1.获取角色要显示的位置对象
        var div = $("#rolesId");
        div.empty();
        //2.迭代数据，将数据追加到div
        var input = "<input type='checkbox' name='roleId' value='[id]'>[name]";
        for (var i in data) {
            var newInput = input.replace("[id]", data[i].id)
                .replace("[name]", data[i].expenseType);
            div.append(newInput)
        }
    }
</script>
    
    
    
    
    
    
    