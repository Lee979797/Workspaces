<%@ page contentType="text/html;charset=UTF-8" %>
<div class="row">
    <div class="col-xs-12">
        <div class="box">
            <div class="box-header">
                <h3 class="box-title">角色管理</h3>

                <div class="box-tools">
                    <div class="input-group input-group-sm" style="width: 350px;">
                        <input type="text" name="table_search" id="searchNameId"
                               class="form-control pull-right" placeholder="角色名">

                        <div class="input-group-btn">
                            <button type="button" class="btn btn-default btn-search">
                                <i class="fa fa-search"></i>
                            </button>
                            <button type="button"
                                    class="btn btn-default btn-delete">删除
                            </button>
                            <button type="button" class="btn btn-default btn-add">添加</button>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /.box-header -->
            <div class="box-body table-responsive no-padding">
                <form>
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th><input type="checkbox" id="checkAll">全选</th>
                            <th>name</th>
                            <th>create date</th>
                            <th>modified date</th>
                            <th>operator</th>
                        </tr>
                        </thead>
                        <tbody id="tbodyId">
                        </tbody>
                    </table>
                </form>
            </div>
            <!-- /.box-body -->
            <div id="pageId" class="box-footer clearfix">
                <script type="text/javascript">
                    $("#pageId").load("pageUI.do");
                </script>
            </div>
        </div>
        <!-- /.box -->
    </div>
</div>
<script type="text/javascript">
    $(function () {
        //异步加载
        doGetObjects();
        $(".input-group-btn")
            .on("click", ".btn-delete", doDeleteObject)
            .on("click", ".btn-add", doAddOrUpdate)
            .on("click", ".btn-search", doQueryObjects)
        //执行全选
        $("#checkAll").change(function () {
            doCheckAll($(this).prop("checked"));
        });

        //在每个修改按钮上注册点击事件
        $("tbody")
            .on("click", ".btn-update", doAddOrUpdate)
    });

    function doQueryObjects() {
        $(".pagination").data("pageCurrent", 1);
        doGetObjects();
    }

    /*   function doQueryObjects(){
           //url 定义
           var url="role/doFindPageObjects.do";
           //参数获取
           var params={name:$("#searchNameId").val()};
           var pageCurrent=
           $(".pagination").data("pageCurrent");
           if(!pageCurrent)pageCurrent=1;
           params.pageCurrent=pageCurrent;
           //发起异步请求(中文时注意乱码)
           $.getJSON(url,params,function(result){
              if(result.state==1){
                  setTableBodyRows(result.data.records);
                  setPagination(result.data);
              }else{
                  alert(result.message);
              }
           });
       } */
    //加载编辑页面
    function doAddOrUpdate() {
        //定义页面标题(内容可能是添加角色也可能是修改角色)
        var title;
        //判定要执行的操作(是添加还是修改)
        if ($(this).hasClass("btn-add")) {
            title = "添加角色";
            doLoadEditPage(title);
        } else {
            title = "修改角色";
            //获取当前行的id值
            var id = $(this).parents("tr").data("id");
            console.log("id=" + id);
            //根据id查找记录，判定记录是否存在
            var url = "role/doFindObjectById.do";
            var data = {"id": id};
            $.getJSON(url, data, function (result) {
                if (result.state == 1) {
                    //此位置除了要分析正确还要考虑对象不存在的情况
                    $(".container-fluid").data("data", result.data)
                    doLoadEditPage(title);
                } else {
                    alert(result.message);
                }
            });
        }
    }

    function doLoadEditPage(title) {
        $(".container-fluid")
            .load("role/editUI.do", function () {
                console.log("load success")
                $(".box-title").html(title);
            });
    }

    //当点击列表中某一个checkbox时，修改全选状态
    function doChangeCheckAllState() {
        var flag = true;
        $("tbody input[name='checkItem']")
            .each(function () {
                flag = flag & $(this).prop("checked");
            });
        $("#checkAll").prop("checked", flag);
    }

    //执行全选操作(让列表中的checkbox的状态与表头中checkbox状态一致)
    function doCheckAll(state) {//dom
        /*$("tbody input[name='checkItem']")
         .each(function(){
             $(this).prop("checked",state)
         }); */
        $("tbody input[name='checkItem']")
            .prop("checked", state);
    }

    //执行删除操作
    function doDeleteObject() {
        //1.获取选中的值
        var ids = doGetCheckedIds();
        //2.对值进行验证
        if (ids.length == 0) {
            alert("please check");
            return;
        }
        //3.异步请求执行删除
        var url = "role/doDeleteObject.do";
        var params = {idStr: ids};
        $.post(url, params, function (result) {
            if (result.state == 1) {
                alert(result.message);
                doGetObjects();
            } else {
                alert(result.message);
            }
        })
    }

    //获取选中的id值
    function doGetCheckedIds() {
        var array = [];
        $("tbody input[name='checkItem']")
            .each(function () {
                if ($(this).prop("checked")) {
                    array.push($(this).val());
                }
            });
        return array.toString();
    }

    function doGetObjects() {
        //获取参数信息
        var pageCurrent =
            $(".pagination").data("pageCurrent");
        if (!pageCurrent) pageCurrent = 1;
        var params = {"pageCurrent": pageCurrent}
        var name = $("#searchNameId").val();
        if (name) params.name = name;
        //发送异步请求
        $.ajax({
            url: "role/doFindPageObjects.do",
            dataType: "json",
            data: params,
            success: function (result) {
                if (result.state == 1) {
                    setTableBodyRows(result.data.records);
                    setPagination(result.data)
                } else {
                    alert(result.message);
                }
            }
        });
    }

    function setTableBodyRows(data) {
        //1.获取body对象
        var tBody = $("#tbodyId");
        tBody.empty();
        //2.迭代data，将data添加到Body中
        for (var i in data) {
            var tr = $("<tr></tr>");
            //tr对象上绑定一个id值(唯一标识这行记录)
            tr.data("id", data[i].id);
            var tds = "<td><input type='checkbox' name='checkItem' value='" + data[i].id + "'></td>" +
                "<td>" + data[i].name + "</td>" +
                "<td>" + data[i].createdTime + "</td>" +
                "<td>" + data[i].modifiedTime + "</td>" +
                "<td><button type='button' class='btn btn-default btn-update'>update</button></td>";
            tr.append(tds);
            tBody.append(tr);
        }
        //每个checkbox上注册一个click事件
        $("tbody input[name='checkItem']")
            .click(doChangeCheckAllState);

    }

</script>











