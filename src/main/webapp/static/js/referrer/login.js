$(document).ready(function () {

    $("#login-submit").click(function () {
        var telephone = $("#login-telephone").val();
        var password = $("#login-password").val();
        if (telephone == "" || password == "") {
            weui.alert("请输入用户名和密码！");
            return;
        }
        ReferrerManager.login(telephone, password, function (success) {
            if (success) {
                location.href = "orders.html";
            } else {
                weui.alert("用户名或密码错误！");
            }
        });
    });

});