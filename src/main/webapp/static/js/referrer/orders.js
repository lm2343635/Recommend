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

            $("#" + order.oid + " .order-list-moore").click(function () {
                var oid = $(this).mengularId();
                OrderManager.getOrder(oid, function (order) {
                    $("#order-info .weui-form-preview__bd").fillText({
                        number: order.number,
                        createAt: order.createAt.format(DATE_HOUR_FORMAT),
                        deliverAt: order.deliverAt == null ? "未派发" : order.deliverAt.format(DATE_HOUR_FORMAT),
                        finishAt: order.finishAt == null ? "未完成" : order.finishAt .format(DATE_HOUR_FORMAT),
                        deductAt: order.deductAt == null ? "未结算" : order.deductAt.format(DATE_HOUR_FORMAT),
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
                    $("#order-info").show();
                });

            });
        }
    });
}