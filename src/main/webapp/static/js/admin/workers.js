$(document).ready(function () {

    checkAdminSession(function () {
        loadWorkers();
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
                loadWorkers();
            } else {
                $.messager.popup("工号已存在，请使用其他工号！");
            }
        });
    });

    $("#add-worker-modal").on("hidden.bs.modal", function (e) {
        $("#add-worker-form .form-group input").val("");
    });

});

function loadWorkers() {
    WorkerManager.getAll(function (workers) {
        if (workers == null) {
            location.href = "session.html";
            return;
        }

        $("#worker-list tbody").mengularClear();
        for (var i in workers) {
            var worker = workers[i];
            $("#worker-list tbody").mengular(".worker-list-template", {
                wid: worker.wid,
                number: worker.number,
                name: worker.name,
                password: worker.password
            });

            // Change worker state.
            $("#" + worker.wid + " .worker-list-state input").bootstrapSwitch({
                state: worker.state
            }).on("switchChange.bootstrapSwitch", function (event, state) {
                var wid = $(this).mengularId();
                WorkerManager.changeState(wid, state);
            });
        }
    });
}