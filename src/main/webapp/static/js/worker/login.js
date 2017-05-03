$(document).ready(function () {

    $("#login-submit").click(function () {
        var number = $("#login-number").val();
        var password = $("#login-password").val();
        if (number == "" || password == "") {
            weui.alert("请输入用户名和密码！");
            return;
        }
        WorkerManager.login(number, password, function (success) {
            if (success) {
                location.href = "tasks.html";
            } else {
                weui.alert("用户名或密码错误！");
            }
        });
    });

});