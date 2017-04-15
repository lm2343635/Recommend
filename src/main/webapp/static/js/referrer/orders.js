$(document).ready(function () {

    checkReferrerSession(function () {
        loadReferrerByState(StateCreate);
    });
    
    $("#order-state div").click(function () {
        loadReferrerByState($(this).index());
        $("#order-state div").removeClass("weui-bar__item_on");
        $(this).addClass("weui-bar__item_on");
    });

});

function loadReferrerByState(state) {
    OrderManager.getReferrerOrders(state, function (orders) {
        if (orders == null) {
            location.href = "session.html";
            return;
        }

        $("#order-list").mengularClear();

        for (var i in orders) {
            var order = orders[i];

            $("#order-list").mengular(".order-list-template", {
                oid: order.oid,
                number: order.number,
                createAt: order.createAt.format(DATE_HOUR_MINUTE_SECOND_FORMAT),
                name: order.name,
                type: order.type,
                price: order.price / 100.0,
                deduct: order.deduct / 100.0
            });
        }
    });
}