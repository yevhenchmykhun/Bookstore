(function ($) {
    $(document).ready(function () {
        $('#admin-menu > ul > li > a').click(function () {
            $('#admin-menu li').removeClass('active');
            $(this).closest('li').addClass('active');
            var checkElement = $(this).next();
            if ((checkElement.is('ul')) && (checkElement.is(':visible'))) {
                $(this).closest('li').removeClass('active');
                checkElement.slideUp('normal');
            }
            if ((checkElement.is('ul')) && (!checkElement.is(':visible'))) {
                $('#admin-menu ul ul:visible').slideUp('normal');
                checkElement.slideDown('normal');
            }
            if ($(this).closest('li').find('ul').children().length == 0) {
                return true;
            } else {
                return false;
            }
        });
    });
})(jQuery);


(function ($) {
    $(document).ready(function () {
        $('.admin-tables table').tablesorter();
    });
})(jQuery);
