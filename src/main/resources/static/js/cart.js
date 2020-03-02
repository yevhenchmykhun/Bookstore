$(document).ready(function () {
    $("#addToCartForm button[type='submit']").click(function () {
        $.ajax({
            url: "/cart/add",
            type: "post",
            data: $('#addToCartForm').serialize(),
            success: function (data) {
                $("#cartItemsNumber").text(data);
                alert("the book was added to your shopping cart");
            },
            error: function () {
                alert("an error occurred during AJAX request");
            }
        });

        return false;
    });
});
