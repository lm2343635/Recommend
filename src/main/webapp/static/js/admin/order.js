var oid = request("oid");

$(document).ready(function () {

    checkAdminSession(function () {
        OrderManager.getOrder(oid, function (order) {
            if (order == null) {
                location.href = "link.html";
                return;
            }

            document.title = order.number;

            $("#order-title").fillText({
                "number": order.number
            });

            $("#order-info").fillText({
                createAt: order.createAt.format(DATE_HOUR_FORMAT),
                name: order.name,
                telephone: order.telephone,
                type: order.type,
                address: order.address,
                remark: order.remark,
                state: order.state
            });
        })
    });
});