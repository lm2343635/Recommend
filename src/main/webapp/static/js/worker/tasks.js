$(document).ready(function () {

    checkWorkerSession(function (worker) {

        console.log(worker);

        $("#worker-info").fillText({
            number: worker.number,
            name: worker.name
        })

        OrderManager.getTaskOrder(function (orders) {
            for (var i in orders) {
                var order = orders[i];
                $("#order-list").mengular(".order-list-template",  {
                    oid: order.oid,
                    number: order.number,
                    name: order.name,
                    telephone: order.telephone,
                    address: order.address,
                    type: order.type,
                    createAt: order.createAt.format(DATE_HOUR_MINUTE_SECOND_FORMAT),
                    deliverAt: order.deliverAt.format(DATE_HOUR_MINUTE_SECOND_FORMAT)
                });
            }
        });
    });
    
});