$(function){
    $('a.dropdown-toggle').click(function(){
        alert(this);
        $(this).parent().css('class','active');
    });
}