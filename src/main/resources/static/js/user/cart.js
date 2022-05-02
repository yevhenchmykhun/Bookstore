$(document).ready(function () {

    $("#addToCartForm button[type='submit']").click(submitForm("/rest/cart/add", function (data) {
        $("#cartItemsNumber").text(data);
    }));

    $("#deleteFromCartForm button[type='submit']").click(submitForm("/rest/cart/delete", function () {
        const tr = $(this).closest("tr");
        if ($(tr).siblings().length === 1) {
            $(tr).remove();
            $("#checkout-items").addClass("d-none");
            $("#checkout-empty").removeClass("d-none");
        } else {
            $(tr).remove();
        }

        const $cartItemsNumber = $("#cartItemsNumber");
        const number = $cartItemsNumber.text();
        $cartItemsNumber.text(number - 1);
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
