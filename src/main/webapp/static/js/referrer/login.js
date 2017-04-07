$(document).ready(function () {

    $("#login-submit").click(function () {
        var telephone = $("#login-telephone").val();
        var password = $("#login-password").val();
        ReferrerManager.login(telephone, password, function (success) {
            if (success) {
                location.href = "orders.html";
            } else {
                weui.alert("用户名或密码错误！");
            }
        });
    });

});