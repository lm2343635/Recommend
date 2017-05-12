$(document).ready(function () {

    checkWorkerSession(function (worker) {

        if (!worker.state) {
            location.href = "dimission.html";
            return;
        }

        $("#worker-info").fillText({
            number: worker.number,
            name: worker.name
        })

        OrderManager.getTaskOrders(function (orders) {
            for (var i in orders) {
                var order = orders[i];
                $("#order-list").mengular(".order-list-template", {
                    oid: order.oid,
                    number: order.number,
                    name: order.name,
                    telephone: order.telephone,
                    address: order.address,
                    type: order.type,
                    price: order.price / 100.0,
                    createAt: order.createAt.format(DATE_HOUR_MINUTE_SECOND_FORMAT),
                    deliverAt: order.deliverAt.format(DATE_HOUR_MINUTE_SECOND_FORMAT)
                });

                $("#" + order.oid + " .order-list-finish").click(function () {
                    var oid = $(this).mengularId();
                    var number = $("#" + oid + " .order-list-number").text();
                    var name = $("#" + oid + " .order-list-name").text();
                    weui.confirm("确认完成的订单：" + number + "（" + name + "）", function () {
                        OrderManager.finish(oid, function (success) {
                           if (success) {
                               $("#" + oid).fadeOut().remove();
                               setTimeout(function () {
                                   weui.alert("订单" + number + "已完成！");
                               }, 300);

                           } else {
                               location.href = "session.html";
                           }
                        });
                    }, function () {

                    });
                });
            }
        });
    });

});