$(document).ready(function () {

    $("#register-submit").click(function () {
        var telephone = $("#register-telephone").val();
        var name = $("#register-name").val();
        var password = $("#register-password").val();
        var wechat = $("#register-wechat").val();
        var validate = true;
        if (telephone == "" || telephone == null) {
            $("#register-telephone").parent().parent().addClass("weui-cell_warn");
            validate = false;
        } else {
            $("#register-telephone").parent().parent().removeClass("weui-cell_warn");
        }
        if (name == "" || name == null) {
            $("#register-name").parent().parent().addClass("weui-cell_warn");
            validate = false;
        } else {
            $("#register-name").parent().parent().removeClass("weui-cell_warn");
        }
        if (password == "" || password == null) {
            $("#register-password").parent().parent().addClass("weui-cell_warn");
            validate = false;
        } else {
            $("#register-password").parent().parent().removeClass("weui-cell_warn");
        }
        if (wechat == "" || wechat == null) {
            $("#register-wechat").parent().parent().addClass("weui-cell_warn");
            validate = false;
        } else {
            $("#register-wechat").parent().parent().removeClass("weui-cell_warn");
        }
        ReferrerManager.isTelephoneExist(telephone, function (exist) {
            if (exist) {
                weui.alert("警告", {
                    title: "好",
                    buttons: [{
                        label: "改手机号已被注册！",
                        type: 'primary',
                        onClick: function(){  }
                    }]
                });
                return;
            }

            ReferrerManager.register(telephone, password, name, wechat, function(success) {
                if (success) {
                    location.href = "index.html";
                }
            });
        });
    });

});