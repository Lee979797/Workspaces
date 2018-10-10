<%@ page contentType="text/html;charset=UTF-8" %>
<!-- Horizontal Form -->
<div class="box box-info">
    <div class="box-header with-border">
        <h3 class="box-title">新建报销类型</h3>
    </div>
    <!-- /.box-header -->
    <!-- form start -->
    <form class="form-horizontal">
        <div class="box-body">
            <div class="form-group">
                <label for="expenseType" class="col-sm-2 control-label">报销类型</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="expenseType">
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
        $(".box-footer")
            .on("click", ".btn-cancel", doCancel)
            .on("click", ".btn-save", doSave);
    });

    function doCancel() {
        $(".container-fluid")
            .load("expense/listUI.do")
            .removeData("id");
    }

    function doSave() {
        var params = {type:$("#expenseType").val()};
        var url = "expense/doCreatedType.do";
        $.post(url, params, function (result) {
            if (result.state === 1) {
                alert(result.data);
                doCancel();
            } else {
                alert(result.message);
            }
        })
    }
</script>
    
    
    
    
    
    
    