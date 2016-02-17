// async call addtocart button
$(document).ready(function () {
    $("#book-exposition input[type='submit']").click(function () {
        var formData = $('#book-exposition form').serialize();
        $.post("/addtocart", formData);
    });
});
