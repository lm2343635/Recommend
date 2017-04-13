$(document).ready(function () {

    checkAdminSession(function () {
        searchOrder(getThisMonthStart(), getThisMonthEnd());
    });

});

function searchOrder(start, end) {

    // Set orders page's title.
    $("#orders-title").fillText({
        "start-date": start,
        "end-date": end
    });

    // Update orders data.
    OrderManager.searchIn(start, end, function (orders) {
        for (var i in orders) {
            var order = orders[i];

            $("#order-list tbody").mengular(".order-list-template", {
                oid: order.oid,
                number: order.number,
                createAt: order.createAt.format(DATE_HOUR_FORMAT),
                name: order.name,
                telephone: order.telephone,
                type: order.type,
                state: StateDescription[order.state]
            });
        }
    });
}