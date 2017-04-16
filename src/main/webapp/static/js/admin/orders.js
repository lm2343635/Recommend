$(document).ready(function () {

    checkAdminSession(function () {
        var start = getThisMonthStart();
        var end = getThisMonthEnd();
        searchOrder(start, end, StateAll);

        $("#search-start, #search-end").datetimepicker({
            format: "yyyy-mm-dd",
            autoclose: true,
            todayBtn: true,
            startView: 2,
            minView: 2,
            language: "zh-CN"
        });

        $("#search-start").val(start);
        $("#search-end").val(end);
    });

    $("#search-submit").click(function () {
        var start = $("#search-start").val();
        var end = $("#search-end").val();
        var state = $("#search-state").val();
        searchOrder(start, end, state);
    });
});

function searchOrder(start, end, state) {
    // Set orders page's title.
    $("#orders-title").fillText({
        start: start,
        end: end,
        state: StateDescription[state]
    });

    // Update orders data.
    OrderManager.searchIn(start, end, state, function (orders) {
        $("#order-list tbody").mengularClear();
        for (var i in orders) {
            var order = orders[i];

            $("#order-list tbody").mengular(".order-list-template", {
                oid: order.oid,
                number: order.number,
                createAt: order.createAt.format(DATE_HOUR_MINUTE_SECOND_FORMAT),
                name: order.name,
                telephone: order.telephone,
                type: order.type,
                state: StateDescription[order.state],
                color: StateColors[order.state]
            });
        }
    });
}