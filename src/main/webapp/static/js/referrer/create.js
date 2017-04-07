$(document).ready(function () {

    $("#create-submit").click(function () {
        var name = $("#create-name").val();
        var telephone = $("#create-telephone").val();
        var address = $("#create-address").val();
        var type = ""
        $("input[name='create-type']:checkbox:checked").each(function(){
            type += $(this).val() + " ";
        });
        var remark = $("#create-remark").val();
        if (name == "" || telephone == "" || address == "" || type == "") {
            weui.alert("请完整填写顾客姓名、顾客电话、顾客地址和项目！");
            return;
        }
        OrderManager.create(name, telephone, address, type, remark, function (number) {
            if (number == null) {
                weui.alert("订单创建失败，请重新登录后重试！", function () {
                    location.href = "index.html";
                });
            } else {
                weui.alert("订单" + number + "创建成功！", function(){
                    location.href = "orders.html";
                });
            }
        });
    });

});