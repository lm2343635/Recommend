$(document).ready(function () {

    ReferrerManager.getAll(function (referrers) {
        for (var i in referrers) {
            var referrer = referrers[i];
            console.log(referrer);
            $("#referrer-list tbody").mengular(".referrer-list-template", {
                rid: referrer.rid,
                telephone: referrer.telephone,
                name: referrer.name,
                wechat: referrer.wechat
            });
        }
    });
});