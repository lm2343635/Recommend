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
        })
    });
});