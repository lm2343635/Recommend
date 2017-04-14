$(document).ready(function () {

    $("#login-submit").click(function () {
        var number = $("#login-number").val();
        var password = $("#login-password").val();
        WorkerManager.login(number, password, function (success) {
            if (success) {
                location.href = "tasks.html";
            } else {
                weui.alert("用户名或密码错误！");
            }
        });
    });

});