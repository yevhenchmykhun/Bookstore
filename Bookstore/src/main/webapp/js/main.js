(function ($) {
    $(document).ready(function () {
        $("#sign-in-form form").validate({
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
})(jQuery);


/*$(document).ready(function(){
 $("#checkoutForm").validate({
 rules: {
 name: "required",
 email: {
 required: true,
 email: true
 },
 phone: {
 required: true,
 number: true,
 minlength: 9
 },
 address: {
 required: true
 },
 creditcard: {
 required: true,
 creditcard: true
 }
 }
 });
 });*/
