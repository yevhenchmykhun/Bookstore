$(document).ready(function () {

    $("#addToCartForm button[type='submit']").click(submitForm("/cart/add", function (data) {
        $("#cartItemsNumber").text(data);
    }));

    $("#deleteFromCartForm button[type='submit']").click(submitForm("/cart/delete", function () {
        let tr = $(this).closest("tr");
        if ($(tr).siblings().length === 1) {
            $(tr).remove();
            $("#checkout-items").addClass("d-none");
            $("#checkout-empty").removeClass("d-none");
        } else {
            $(tr).remove();
        }

        let cartItemsNumberSelector = "#cartItemsNumber";
        let cartItemsNumber = $(cartItemsNumberSelector).text();
        $(cartItemsNumberSelector).text(cartItemsNumber - 1);
    }));

    function submitForm(url, successCallback) {
        return function () {
            $.ajax({
                url: url,
                type: "post",
                data: $(this).parent().serialize(),
                success: successCallback.bind(this),
                error: function () {
                    alert("an error occurred during AJAX request");
                }
            });

            return false;
        };
    }

});
