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

                    break;
                case StateDeliver:
                    $("#deliver-order-button").remove();
                    break;
                default:
                    break;
            }

            document.title = order.number;

            $("#order-title").fillText({
                number: order.number
            });

            $("#order-info").fillText({
                createAt: order.createAt.format(DATE_HOUR_FORMAT),
                name: order.name,
                telephone: order.telephone,
                type: order.type,
                address: order.address,
                remark: order.remark,
                state: StateDescription[order.state]
            });

            $("#deliver-order-title").fillText({
                number: order.number
            });

            $("#deliver-order-type").val(order.type);
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
});