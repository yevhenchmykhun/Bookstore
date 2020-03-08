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

// disable form submissions if there are invalid fields
(function () {
    'use strict';

    window.addEventListener('load', function () {
        // fetch all the forms we want to apply custom Bootstrap validation styles to
        var forms = document.getElementsByClassName('needs-validation');

        // loop over them and prevent submission
        var validation = Array.prototype.filter.call(forms, function (form) {
            form.addEventListener('submit', function (event) {
                if (form.checkValidity() === false) {
                    event.preventDefault();
                    event.stopPropagation();
                }
                form.classList.add('was-validated');
            }, false);
        });
    }, false);
})();