<%@ page contentType="text/html;charset=UTF-8" %>
<div class="row">
    <div class="col-xs-12">
        <div class="box">
            <div class="box-header">
                <h3 class="box-title">菜单管理</h3>

                <div class="box-tools">
                    <div class="input-group input-group-sm" style="width: 100px;">
                        <div class="input-group-btn">
                            <button type="button" class="btn btn-default btn-delete">删除</button>
                            <button type="button" class="btn btn-default btn-add">添加</button>
                            <button type="button" class="btn btn-default btn-update">修改</button>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /.box-header -->
            <div class="box-body table-responsive no-padding">
                <table id="menuTable" class="table table-hover">
                    <thead>
                    <tr>
                        <th data-field="selectItem" data-checkbox="true"></th>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>
        <!-- /.box -->
    </div>
</div>
<script type="text/javascript" src="bower_components/treegrid/jquery.treegrid.extension.js"></script>
<script type="text/javascript" src="bower_components/treegrid/jquery.treegrid.min.js"></script>
<script type="text/javascript" src="bower_components/treegrid/tree.table.js"></script>
<script type="text/javascript">
    /**
     * 初始化表格的列
     */
    var columns = [
        {
            field: 'selectItem',
            radio: true
        },
        {
            title: '菜单ID',
            field: 'id',
            visible: false,
            align: 'center',
            valign: 'middle',
            width: '80px'
        },
        {
            title: '菜单名称',
            field: 'name',
            align: 'center',
            valign: 'middle',
            sortable: true,
            width: '130px'
        },
        {
            title: '上级菜单',
            field: 'parentName',
            align: 'center',
            valign: 'middle',
            sortable: true,
            width: '100px'
        },
        {
            title: '类型',
            field: 'type',
            align: 'center',
            valign: 'middle',
            sortable: true,
            width: '70px',
            formatter: function (item, index) {
                if (item.type === 1) {
                    return '<span class="label label-success">菜单</span>';
                }
                if (item.type === 2) {
                    return '<span class="label label-warning">按钮</span>';
                }
            }
        },
        {
            title: '排序号',
            field: 'sort',
            align: 'center',
            valign: 'middle',
            sortable: true,
            width: '70px'
        },
        {
            title: '菜单URL',
            field: 'url',
            align: 'center',
            valign: 'middle',
            sortable: true,
            width: '160px'
        },
        {
            title: '授权标识',
            field: 'permission',
            align: 'center',
            valign: 'middle',
            sortable: true
        }];

    $(function () {
        doGetObjects();
        $(".input-group-btn")
            .on("click", ".btn-delete", doDeleteObject)
            .on("click", ".btn-add,.btn-update", doAddOrUpdate);
    });

    function doAddOrUpdate() {
        var title;
        if ($(this).hasClass("btn-add")) {
            title = "添加菜单";
            doLoadEditPage(title);
        } else if ($(this).hasClass("btn-update")) {
            title = "修改菜单";
            var id = doGetCheckedId();
            if (!id) {
                alert("请先选择");
                return;
            }
            $(".container-fluid").data("id", id);
            doLoadEditPage(title);
        }
    }

    function doLoadEditPage(title) {
        var url = "menu/editUI.do";
        $(".container-fluid").load(url, function () {
            $(".box-title").html(title);
        })
    }

    function doDeleteObject() {
        //1.url
        var url = "menu/doDeleteObject.do";
        //2.params
        var id = doGetCheckedId();
        if (!id) {
            alert("请先选择一条记录");
            return;
        }
        var params = {"id": id};
        //3.post
        $.post(url, params, function (result) {
            if (result.state === 1) {
                alert(result.message);
                doGetObjects();
            } else {
                alert(result.message);
            }
        })
    }

    function doGetCheckedId() {
        //获取选中的记录对象
        var selections = $("#menuTable")
        //这个函数固定写法，记住即可
        //假如要理解这个方法可参考jquery.treegrid.extension.js
            .bootstrapTreeTable("getSelections");
        //判定是否有选中的
        if (selections.length > 0) {
            //返回选中记录的id值
            return selections[0].id;
        }
    }


    function doGetObjects() {
        //1.构建treeTable对象
        var tableId = "menuTable";
        var url = "menu/doFindObjects.do";
        var treeTable =
            new TreeTable(tableId, url, columns);
        //2.初始化treeTable
        //treeTable.setExpandColumn(2);//设置可展开的列，默认为1
        treeTable.init();

        //treeTable 底层语法练习
        (function () {
            var f3 = function (id) {
                this.id = id;
            };
            f3.prototype = {
                get: function () {
                    return this.id;
                }
            };
            window.f3 = f3;
        })();
        var f = new f3();
        f.get();

    }
</script>
