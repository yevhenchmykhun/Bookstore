$(document).ready(function () {
    $('#sign-in-form form').validate({
        rules: {
            email: {
                required: true,
                email: true
            },
            password: {
                required: true,
            }
        },
        messages: {
            email: {
                required: "Field email is required",
                email: "Your email address must be in the format of name@domain.com"
            },
            password: {
                required: "Field password is required"
            }
        }
    });
});

// async call addtocart button
$(document).ready(function () {
    $("#book-exposition input[type='submit']").click(function () {
        var formData = $('#book-exposition form').serialize();
        $.post("/addtocart", formData, function (val) {
            //val has the updated value that you will send from the servlet
            //do something
        });
    });
});
