$(document).ready(function () {

    $("select").on("change",function () {
       var role = $(this).val();

        $.ajax("/roleMenu/list",{
            async: true,
            data: {"role":role},
            success: function (data) {
                //remove all checked
                var $input = $("input.form-check-input");
                for(i=0,len=$input.length;i<len;i++){
                    $($input[i]).removeAttr("checked");
                }

                //checked select
                for(i=0,len=data.length;i<len;i++){
                    $("input#checkbox"+data[i].id).prop("checked","true");
                }
            },
            error: function (data) {
                alert("err"+data);
            }
        });
    });

    $("button.saveRole").on("click",function () {
        var role = $("select").val();
        var $input = $('input[type=checkbox]:checked');

        var menus = [];

        for (i=0,len=$input.length;i<len;i++){
            menus.push($($input[i]).val());
        }

        var param = {"role":role,"menus":menus};
        $.ajax("/roleMenu/updateRoleMenus",{
            async: true,
            type: "POST",
            contentType: "application/json;charset=UTF-8",
            data: JSON.stringify(param),
            success: function (data) {
                alert(data);
            }
        });
    })

});