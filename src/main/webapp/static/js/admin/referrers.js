$(document).ready(function () {

    checkAdminSession(function () {
        ReferrerManager.getAll(function (referrers) {
            for (var i in referrers) {
                var referrer = referrers[i];
                $("#referrer-list tbody").mengular(".referrer-list-template", {
                    rid: referrer.rid,
                    telephone: referrer.telephone,
                    name: referrer.name,
                    wechat: referrer.wechat,
                    password: referrer.password
                });
            }
        });
    });

});