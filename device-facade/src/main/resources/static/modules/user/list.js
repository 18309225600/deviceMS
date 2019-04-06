$(document).ready(function(){

    listPageData("/user/list");

    bind();

});

var bind = function(){

    //编辑按钮
    $("tr").find("button#editRole").on("click",function(){
        $(this).parents("tr").find(select).removeAttr("disabled");
    });

    //保存按钮
    $("tr").find("button#saveRole").on("click",function(){
        $(this).parents("tr").find(select).attr("disabled","disabled");
        var role = $(this).parents("tr").find(select).val();
        var id = $(this).parents("tr").find("input").val();
        $.ajax("/user/changeRole/"+id,{
            async: true,
            data: {"role":role},
            success: function (data) {
                alert(data);
            },
            error: function (data) {
                alert("err"+data);
            }
        });

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
        var pageNo = parseInt($("#pageNo").val());
        var totalPage = parseInt($("#totalPage").val());
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