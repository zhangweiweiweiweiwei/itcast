$(function () {
    $.get("/top.html",function (data) {
        $("#top").html(data);
    });
    $.get("/bottom.html",function (data) {
        $("#bottom").html(data);
    });

    $.get("/admin/icd_menu.html",function (data) {
        $("#menu").html(data);
    });

});