$(document).ready(function () {

    checkReferrerSession(function (referrer) {
        $("#referrer-info").fillText({
            name: referrer.name,
            telephone: referrer.telephone,
            wechat: referrer.wechat,
            balance: referrer.balance / 100.0
        });

        if (referrer.balance == 0) {
            $("#apply-submit").remove();
            $("#apply-disabled").show();
        } else {
            if (referrer.applying) {
                $("#apply-submit").remove();
                $("#apply-applying").show();
            } else {
                $("#apply-submit").show();
                $("#apply-enable").show();
            }
        }

    });

    $("#apply-submit").click(function () {
        ReferrerManager.apply(function (success) {
            if (success) {
                location.reload();
            } else {
                location.href = "session.html";
            }
        });
    });

});