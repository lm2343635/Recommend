$(document).ready(function () {

    checkAdminSession(function () {

    });

    $("#add-worker-submit").click(function () {
        var number = $("#add-worker-number").val();
        var name = $("#add-worker-name").val();
        var password = $("#add-worker-password").val();
        if (number == "" || name == "" || password == "") {
            $.messager.popup("请填写工号、姓名和密码！");
            return;
        }

        WorkerManager.addWorker(number, name, password, function (success) {
            if (success) {
                $.messager.popup("添加师傅成功！");
                $("#add-worker-modal").modal("hide");
            } else {
                $.messager.popup("工号已存在，请使用其他工号！");
            }
        });
    });

    $("#add-worker-modal").on("hidden.bs.modal", function (e) {
        $("#add-worker-form .form-control input").val("");
    });

});