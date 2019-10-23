// async call addToCart button
$(document).ready(() => {
    $("#book-exposition input[type='submit']").click(() => {
        $.ajax({
          url: "/addToCart",
          type: "POST",
          data: $('#book-exposition form').serialize(),
          success: () => {
              alert("the book was added to your shopping cart");
          },
          error: () => {
              alert("an error occurred during AJAX request");
          }
        });
    });
});
