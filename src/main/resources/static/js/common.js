$(document).ready(function () {
    $(".clickable-card").hover(
        function () {
            $(this).addClass('shadow bg-white rounded');
        },
        function () {
            $(this).removeClass('shadow bg-white rounded');
        }
    )
});