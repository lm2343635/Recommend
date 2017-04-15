var oid = request("oid");

$(document).ready(function () {

    checkAdminSession(function () {
        OrderManager.getOrder(oid, function (order) {
            if (order == null) {
                location.href = "link.html";
                return;
            }

            switch(order.state) {
                case StateCreate:
                    $("#deliver-order-button").removeAttr("disabled");
                    break;
                case StateFinish:
                    $("#deduct-order-button").removeAttr("disabled");
                    break;
                case StateBandon:

                    break;
                default:
                    break;
            }

            document.title = order.number;

            $("#order-title, #deliver-order-title, #deduct-order-title").fillText({
                number: order.number
            });

            $("#order-info").fillText({
                createAt: order.createAt.format(DATE_HOUR_FORMAT),
                name: order.name,
                telephone: order.telephone,
                type: order.type,
                address: order.address,
                remark: order.remark,
                state: StateDescription[order.state],
                referrer: order.referrer.name,
                worker: order.worker == null ? "未分配维修师傅" : order.worker.name,
                price: order.price / 100.0,
                deduct: order.deduct / 100.0
            });

            $("#deliver-order-type").val(order.type);
            $("#deduct-order-price").val(order.price / 100.0);
        });

        WorkerManager.getWorkers(false, function (workers) {
            for (var i in workers) {
                $("<option>").text(workers[i].name + "（" + workers[i].number + "）")
                    .val(workers[i].wid).appendTo("#deliver-order-worker");
            }
        });
    });

    $("#deliver-order-submit").click(function () {
        var wid = $("#deliver-order-worker").val();
        var price = $("#deliver-order-price").val();
        var type = $("#deliver-order-type").val();
        var validate = true;
        if (wid == null || wid == "") {
            $("#deliver-order-worker").parent().addClass("has-error");
            validate = false;
        } else {
            $("#deliver-order-worker").parent().removeClass("has-error");
        }
        if (price == null || price == "" || !isNum(price)) {
            $("#deliver-order-price").parent().addClass("has-error");
            validate = false;
        } else {
            $("#deliver-order-price").parent().removeClass("has-error");
        }
        if (type == null || type == "") {
            $("#deliver-order-type").parent().addClass("has-error");
            validate = false;
        } else {
            $("#deliver-order-type").parent().removeClass("has-error");
        }
        price = parseInt(100 * price);
        if (validate) {
            OrderManager.deliver(oid, wid, price, type, function (success) {
                if (success) {
                    location.reload();
                } else {
                    location.href = "session.html";
                }
            });
        }
    });

    $("#deduct-order-submit").click(function () {
        var price = $("#deduct-order-price").val();
        var deduct = $("#deduct-order-deduct").val();
        var validate = true;
        if (price == null || price == "" || !isNum(price)) {
            $("#deduct-order-price").parent().addClass("has-error");
            validate = false;
        } else {
            $("#deduct-order-price").parent().removeClass("has-error");
        }
        if (deduct == null || deduct == "" || !isNum(deduct)) {
            $("#deduct-order-deduct").parent().addClass("has-error");
            validate = false;
        } else {
            $("#deduct-order-deduct").parent().removeClass("has-error");
        }
        price = parseInt(100 * price);
        deduct = parseInt(100 * deduct);
        if (validate) {
            OrderManager.deduct(oid, price, deduct, function (success) {
                if (success) {
                    location.reload();
                } else {
                    location.href = "session.html";
                }
            });
        }
    });
});