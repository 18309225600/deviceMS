$(document).ready(function(){

    var status = $(".statusCode").val();

    listPageData("/device/list?status="+status);

    bind();

});


var bind = function(){

    //查看详情按钮
    $("tr").find("button.detailOp").on("click",function(){
        var id = $(this).parents("tr.dataTr").attr("id");
        $(location).attr("href","/device/detail/"+id);
    });

    //报废按钮
    $("tr").find("button.dumpOp").on("click",function(){
        var confirm = prompt("请输入报废原因：")
        if(confirm){
            var id = $(this).parents("tr.dataTr").attr("id");
            $.ajax("/device/dump/"+id,{
                async: true,
                data: {"remark":confirm},
                success: function (data) {
                    alert(data);
                    window.location.reload();
                },
                error: function (data) {
                    alert("err"+data);
                    window.location.reload();
                }
            });
        }else {
            alert("未输入原因，已放弃本次操作！")
        }
    });

    //删除按钮
    $("tr").find("a#deleteBtn").on("click",function(){
        var con = confirm("确认删除吗?");
        if(con){
            var id = $(this).parents("tr.userDataListTr").attr("id");
            $(location).attr("href","/lecms_webapp/MaterialCategoryController/editCategory?op=delete&id="+id);
        }
    });
}

//获取列表分页数据  刷新页面
this.listPageData = function(url){
    var index = url.indexOf("?");
    if(index!=-1){
        url+="&";
    }else{
        url+="?";
    }

    $("#firstPage").on("click",function(){
        /*直接ajax跳转到首页*/
        $(location).attr("href",url+"pagNo=1");
    });

    $("#proidPage").on("click",function(){
        var pageNo = $("#pageNo").val();
        if(pageNo>1){
            $(location).attr("href",url+"pageNo="+(pageNo*1-1));
        }else{
            alert("没有前一页了！")
        }
    });

    $("#nextPage").on("click",function(){
        var pageNo = $("#pageNo").val();
        var totalPage = $("#totalPage").val();
        if(pageNo<totalPage){
            $(location).attr("href",url+"pageNo="+(pageNo*1+1));
        }else{
            alert("没有下一页了！")
        }
    });

    $("#endPage").on("click",function(){
        var totalPage = $("#totalPage").val();
        $(location).attr("href",url+"pageNo="+totalPage);
    });


    $("#goto").on("click",function(){
        var gotoPage = $("#gotoPage").val();
        var totalPage = $("#totalPage").val();
        if(gotoPage>0&&gotoPage<totalPage*1+1){
            $(location).attr("href",url+"pageNo="+gotoPage);
        }
    });
}