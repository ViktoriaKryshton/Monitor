
window.alert = function() {
};
var defaultCSS = document.getElementById('bootstrap-css');
function changeCSS(css) {
    if (css)
        $('head > link').filter(':first').replaceWith('<link rel="stylesheet" href="' + css + '" type="text/css" />');
    else
        $('head > link').filter(':first').replaceWith(defaultCSS);
}
$(document).ready(function() {
    var iframe_height = parseInt($('html').height());
    window.parent.postMessage(iframe_height, 'http://bootsnipp.com');
});

function setValuesAndSubmitBook(book_id) {
    document.getElementById('book_id').value = book_id;
    document.forms[1].submit();
}

function setValuesAndSubmit(id_book) {
    document.getElementById('id_book').value = id_book;
    document.forms[2].submit();
}

$(function() {
    $('#rating_1').rating({
        fx: 'full',
        image: 'images/stars.png',
        loader: 'images/ajax-loader.gif',
        url: 'controller?command=ADD_VOTER',
        click: function(mark) {
            document.getElementById('mark').value = mark;
            document.forms[1].submit();
        }
    });
});

window.jQuery || document.write('<script type="text/javascript" src="js/jquery-1.6.2.min.js"><\/script>');
