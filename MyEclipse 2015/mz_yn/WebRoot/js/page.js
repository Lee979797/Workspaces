(function () {
    window.Page = {
        total:1,
        _curent:function (num) {
            var current = document.getElementById("currentPage");
            if (current != null && current != undefined) {
                current.value = num;
            }
        },
        verify:function () {
            Page._curent(1);
            document.searchForm.submit();
            return true;
        },
        all:function () {
            Page._curent(1);
            document.getElementById("jgdm").value ="";
            document.searchForm.submit();
            return true;
        },
        goto:function (page) {
            var reg = new RegExp(/^((?!<=^.)[\d](?!>=^.))+$/);
            if (!reg.test(page) || Number(this.total) < Number(page) || Number(page) <= 0) {
                ymPrompt.alert({message:"请输入正确的页码",
                    width:330, height:220,
                    handle:function () {
                        document.searchForm.pageNo.focus();
                    }});
            } else {
                Page._curent(page);
                document.searchForm.submit();

            }
        },
        reload:function (pageSize) {
            Page._curent(1);
            document.getElementById("pageSize").value = pageSize;
            document.searchForm.submit();
        },
        show:function (jgdm) {
            document.getElementById("jgdm").value = jgdm;
            document.showForm.submit();
        },
        sort:function (filed, type) {
            document.getElementById("orderByField").value = filed;
            document.getElementById("orderByType").value = type;
            Page._curent(1);
            document.searchForm.submit();
        },
        config:function (t) {
            this.total = t;

        }
    };
})();

