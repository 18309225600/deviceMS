$(document).ready(function(){

    listPageData("/device/list");

    bind();

});


var bind = function(){

    //查看按钮
    $("tr").find("a#viewBtn").on("click",function(){
        var id = $(this).parents("tr.userDataListTr").attr("id");
        $(location).attr("href","/lecms_webapp/MaterialCategoryController/editCategory?op=view&id="+id);
    });

    //编辑按钮
    $("tr").find("a#editBtn").on("click",function(){
        var id = $(this).parents("tr.userDataListTr").attr("id");
        $(location).attr("href","/lecms_webapp/MaterialCategoryController/editCategory?op=edit&id="+id);
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