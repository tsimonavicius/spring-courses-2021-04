$(document).ready(function() {
    $("#languageSelector").change(function () {
        var selectedOption = $('#languageSelector').val();
        if (selectedOption !== ''){
            window.location.replace('?lang=' + selectedOption);
        }
    });
})
