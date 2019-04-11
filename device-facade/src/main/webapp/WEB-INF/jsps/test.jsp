<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <title>jQuery File Upload Example</title>
</head>
<input>
<input id="fileupload" type="file" name="file" data-url="/toolbox/fileupload" formmethod="post" multiple>
<script src="/static/jquery/jquery.js"></script>
<script src="/static/jquery/jquery.ui.widget.js"></script>
<script src="/static/jquery/jquery.iframe-transport.js"></script>
<script src="/static/jquery/jquery.fileupload.js"></script>
<script src="/static/ajax-upload/ajaxfileupload.js"></script>

<script>
    $(function () {
        $('#fileupload').fileupload({
            dataType: 'json',
            done: function (e, data) {
                console.info(e);
                console.info(data);
                $.each(data.result.files, function (index, file) {
                    $("p").text(file.name).appendTo(document.body);
                });
            }
        });
    });


    function imageUpload(){
        $.ajaxFileUpload({
            url : '/toolbox/fileupload', //用于文件上传的服务器端请求地址
            fileElementId : 'file', //文件上传空间的id属性  <input type="file" id="file" name="file" />
            type : 'post',
            dataType : 'json', //返回值类型 一般设置为json
            success : function(data, status) //服务器成功响应处理函数
            {
                console.info(data.responseText);
                alert("头像上传成功");
            },
            error : function(data, status, e)//服务器响应失败处理函数
            {
                console.info(data.responseText);
                alert("图片上传失败");
            }
        });
    }
</script>

<input type="file" id="file" name="file">
<input type="button" onclick="imageUpload()">上传</input>

</body>
</html>